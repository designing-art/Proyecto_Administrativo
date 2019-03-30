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

	/* Eventos */
	public void actionPerformed(ActionEvent e) {
		/* Insertar */
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

		/* Actualizar */
		if (e.getSource() == formularioCargo.btnActualizarCargo) {
			PreparedStatement ps = null;
			try {
				conexion objCon = new conexion();
				Connection conn = objCon.getConexion();
				int Fila = formularioCargo.tablaCargos.getSelectedRow();
				String codigo = formularioCargo.tablaCargos.getValueAt(Fila, 0).toString();
				
				claseCargo.setId_cargo(Integer.parseInt(formularioCargo.txtSueldoCargo.getText()));
				claseCargo.setArea_cargo(formularioCargo.cbxTipoCargo.getSelectedItem().toString());
				claseCargo.setNombre_cargo(formularioCargo.txtNombreCargo.getText());
				claseCargo.setSueldo_cargo(Double.parseDouble(formularioCargo.txtSueldoCargo.getText()));
				claseCargo.setValor_hora_extra_cargo(Double.parseDouble(formularioCargo.txtHoraExtraCargo.getText()));
				claseCargo.setFunciones_cargo(formularioCargo.txtFuncionesCargo.getText());
				
				ps = conn.prepareStatement("UPDATE cargos SET id_cargo=?, area_cargo=?, nombre_cargo=?, sueldo_cargo=?, valor_hora_extra_cargo=?, funciones_cargo=? WHERE id_cargo=?");
				ps.setString(1, codigo);
				ps.execute();
				
				JOptionPane.showMessageDialog(null, "Cargo actualizado!");
				limpiar();
				formularioCargo.construirTabla();
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "Error al actualizar Cargo");
				System.out.println(ex.toString());
			}
		}

		/* Borrar */
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

		/* Limpiar */
		if (e.getSource() == formularioCargo.btnNuevoCargo) {
			limpiar();
		}
	}

	/* Metodos para implementar */
	public void limpiar() {
		formularioCargo.txtNombreCargo.setText(null);
		formularioCargo.txtSueldoCargo.setText(null);
		formularioCargo.txtHoraExtraCargo.setText(null);
		formularioCargo.txtFuncionesCargo.setText(null);
		formularioCargo.txtBusquedaCargos.setText(null);
	}

	public void pistasCargo() {
		PlaceHolder pistasCargo;
		pistasCargo = new PlaceHolder(formularioCargo.txtNombreCargo, "Escriba nombre de cargo.");
		pistasCargo = new PlaceHolder(formularioCargo.txtSueldoCargo, "Ingrese el sueldo bruto");
		pistasCargo = new PlaceHolder(formularioCargo.txtHoraExtraCargo, "Ingrese precio hora extra.");
		pistasCargo = new PlaceHolder(formularioCargo.txtFuncionesCargo, "Escriba funciones asignadas.");
		pistasCargo = new PlaceHolder(formularioCargo.txtBusquedaCargos, "buscar: codigo -- Nombre -- area");
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
