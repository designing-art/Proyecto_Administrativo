package controles;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.placeholder.PlaceHolder;

import clases.cargo;
import conexion.conexion;
import consultas.consultas_cargo;
import formularios.registro_cargos;

public class control_cargo implements ActionListener {

	public cargo claseCargo;
	public consultas_cargo consultasCargo;
	public registro_cargos formularioCargo;

	public control_cargo(cargo claseCargo, consultas_cargo consultasCargo, registro_cargos formularioCargo) {
		this.claseCargo = claseCargo;
		this.consultasCargo = consultasCargo;
		this.formularioCargo = formularioCargo;
		this.formularioCargo.btnGuardarCargo.addActionListener(this);
		this.formularioCargo.btnNuevoCargo.addActionListener(this);
		this.formularioCargo.btnActualizarCargo.addActionListener(this);
		this.formularioCargo.btnBorrarCargo.addActionListener(this);

	}

	// ---------------------------------------------------------------------------------------------------------------------------//
	// ---------------------------EVENTOS PARA INSERTAR Y ACTUALIZAR
	// CARGOS-------------------------------------------------------//

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//----Insertar
		if (e.getSource() == formularioCargo.btnGuardarCargo) {
			claseCargo.setArea_cargo(formularioCargo.cbxTipoCargo.getSelectedItem().toString());
			claseCargo.setNombre_cargo(formularioCargo.txtNombreCargo.getText());
			claseCargo.setSueldo_cargo(Double.parseDouble(formularioCargo.txtSueldoCargo.getText()));
			claseCargo.setValor_hora_extra_cargo(Double.parseDouble(formularioCargo.txtHoraExtraCargo.getText()));
			claseCargo.setFunciones_cargo(formularioCargo.txtFuncionesCargo.getText());

			if (consultasCargo.registrar(claseCargo)) {
				JOptionPane.showMessageDialog(null, "Exito! Cargo Registrado");
				limpiar();
				formularioCargo.construirTabla();
			} else {
				JOptionPane.showMessageDialog(null, "Error! Cargo no Registrado");
				limpiar();
			}
		}

		//----Actualizar
			if (e.getSource() == formularioCargo.btnActualizarCargo) {
				claseCargo.setArea_cargo(formularioCargo.cbxTipoCargo.getSelectedItem().toString());
				claseCargo.setNombre_cargo(formularioCargo.txtNombreCargo.getText());
				claseCargo.setSueldo_cargo(Double.parseDouble(formularioCargo.txtSueldoCargo.getText()));
				claseCargo.setValor_hora_extra_cargo(Double.parseDouble(formularioCargo.txtHoraExtraCargo.getText()));
				claseCargo.setFunciones_cargo(formularioCargo.txtFuncionesCargo.getText());

				if (consultasCargo.modificar(claseCargo)) {
					JOptionPane.showMessageDialog(null, "Exito! Registro Modificado");
					limpiar();
				} else {
					JOptionPane.showMessageDialog(null, "Error al Modificar");
					limpiar();
				}
			}
	
			//----Borrar
			if (e.getSource() == formularioCargo.btnBorrarCargo) {
				PreparedStatement ps = null;
		        try {

		            conexion objCon = new conexion();
		            Connection conn = objCon.getConexion();

		            int Fila = formularioCargo.tablaCargos.getSelectedRow();
		            String codigo = formularioCargo.tablaCargos.getValueAt(Fila, 0).toString();

		            ps = conn.prepareStatement("DELETE FROM cargos WHERE id_cargo=?");
		            ps.setString(1, codigo);
		            ps.execute();

		            JOptionPane.showMessageDialog(null, "Cargo Eliminado");
		            limpiar();
		            formularioCargo.construirTabla();

		        } catch (SQLException ex) {
		            JOptionPane.showMessageDialog(null, "Error al Eliminar Cargo");
		            System.out.println(ex.toString());
		        }
			}
			
			//----Limpiar
			if (e.getSource() == formularioCargo.btnNuevoCargo) {
				limpiar();
			}
		}
	
	

	public void limpiar() {
		formularioCargo.txtNombreCargo.setText("");
		formularioCargo.txtSueldoCargo.setText("");
		formularioCargo.txtHoraExtraCargo.setText("");
		formularioCargo.txtFuncionesCargo.setText("");
	}

	// ------------------------------------FIN DE LOS METODOS DE REGISTRO Y
	// ACTUALIZAR CARGO-----------------------------------//

	public void pistas() {
		PlaceHolder pistas;
		pistas = new PlaceHolder(formularioCargo.txtNombreCargo, "Escriba nombre de cargo.");
		pistas = new PlaceHolder(formularioCargo.txtSueldoCargo, "Ingrese el sueldo");
		pistas = new PlaceHolder(formularioCargo.txtHoraExtraCargo, "Ingrese el costo.");
		pistas = new PlaceHolder(formularioCargo.txtFuncionesCargo, "Escriba funciones asignadas.");
	}

	public static String[][] obtenerMatriz() {

		consultas_cargo consulta = new consultas_cargo();
		ArrayList<cargo> miLista = consulta.buscarUsuariosConMatriz();

		String matrizInfo[][] = new String[miLista.size()][6];

		for (int i = 0; i < miLista.size(); i++) {
			matrizInfo[i][0] = miLista.get(i).getId_cargo() + "";
			matrizInfo[i][1] = miLista.get(i).getArea_cargo() + "";
			matrizInfo[i][2] = miLista.get(i).getNombre_cargo() + "";
			matrizInfo[i][3] = miLista.get(i).getSueldo_cargo() + "";
			matrizInfo[i][4] = miLista.get(i).getValor_hora_extra_cargo() + "";
			matrizInfo[i][5] = miLista.get(i).getFunciones_cargo() + "";
		}

		return matrizInfo;
	}

}
