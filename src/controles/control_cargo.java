package controles;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
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
		this.formularioCargo.btnActualizarDatosCargo.addActionListener(this);
		this.formularioCargo.btnBorrarCargo.addActionListener(this);

	}
	public void actionPerformed(ActionEvent e) {
		/* Insertar */
		if (e.getSource() == formularioCargo.btnGuardarCargo) {
			claseCargo.setArea_cargo(formularioCargo.cbxTipoCargo.getSelectedItem().toString());
			claseCargo.setNombre_cargo(formularioCargo.txtNombreCargo.getText());
			claseCargo.setSueldo_cargo(Double.parseDouble(formularioCargo.txtSueldoCargo.getText()));
			claseCargo.setValor_hora_extra_cargo(Double.parseDouble(formularioCargo.txtHoraExtraCargo.getText()));
			claseCargo.setFunciones_cargo(formularioCargo.txtFuncionesCargo.getText());

			if (consultasCargo.insertar(claseCargo)) {
				JOptionPane.showMessageDialog(null, "Cargo registrado!");
				limpiar();
				formularioCargo.construirTabla();
			} else {
				JOptionPane.showMessageDialog(null, "Error! Cargo no Registrado");
				limpiar();
			}
		}
		
		/* Pasar datos de la tabla al formulario para actualizar */
		if (e.getSource() == formularioCargo.btnActualizarDatosCargo) {
			int filaseleccionada;
			try {
				filaseleccionada = formularioCargo.tablaCargos.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					String codigo = formularioCargo.tablaCargos.getValueAt(filaseleccionada, 0).toString();
					String area = formularioCargo.tablaCargos.getValueAt(filaseleccionada, 1).toString();
					String nombre = formularioCargo.tablaCargos.getValueAt(filaseleccionada, 2).toString();
					String sueldo = formularioCargo.tablaCargos.getValueAt(filaseleccionada, 3).toString();
					String horaextra = formularioCargo.tablaCargos.getValueAt(filaseleccionada, 4).toString();
					String funciones = formularioCargo.tablaCargos.getValueAt(filaseleccionada, 5).toString();

					formularioCargo.txtCodigoCargo.setText(codigo);
					formularioCargo.cbxTipoCargo.setSelectedItem(area);
					formularioCargo.txtNombreCargo.setText(nombre);
					formularioCargo.txtSueldoCargo.setText(sueldo);
					formularioCargo.txtHoraExtraCargo.setText(horaextra);
					formularioCargo.txtFuncionesCargo.setText(funciones);
				}

			} catch (HeadlessException ex) {
				JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente",
						" .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		/* Actualizar */
		if (e.getSource() == formularioCargo.btnActualizarCargo) {
			
			claseCargo.setId_cargo(Integer.parseInt(formularioCargo.txtCodigoCargo.getText()));
			claseCargo.setArea_cargo(formularioCargo.cbxTipoCargo.getSelectedItem().toString());
			claseCargo.setNombre_cargo(formularioCargo.txtNombreCargo.getText());
			claseCargo.setSueldo_cargo(Double.parseDouble(formularioCargo.txtSueldoCargo.getText()));
			claseCargo.setValor_hora_extra_cargo(Double.parseDouble(formularioCargo.txtHoraExtraCargo.getText()));
			claseCargo.setFunciones_cargo(formularioCargo.txtFuncionesCargo.getText());
            
            if(consultasCargo.actualizar(claseCargo))
            {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
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
	
	/* Metodo para el boton nuevo que limpia los datos de los txtFields*/
	public void limpiar() {
		formularioCargo.txtCodigoCargo.setText(null);
		formularioCargo.txtNombreCargo.setText(null);
		formularioCargo.txtSueldoCargo.setText(null);
		formularioCargo.txtHoraExtraCargo.setText(null);
		formularioCargo.txtFuncionesCargo.setText(null);
		formularioCargo.txtBusquedaCargos.setText(null);
	}

	/* Metodo para darle pistas de insercion de datos al usuario*/
	public void pistasCargo() {
		PlaceHolder pistasCargo;
		pistasCargo = new PlaceHolder(formularioCargo.txtNombreCargo, "Escriba nombre de cargo.");
		pistasCargo = new PlaceHolder(formularioCargo.txtSueldoCargo, "Ingrese el sueldo bruto");
		pistasCargo = new PlaceHolder(formularioCargo.txtHoraExtraCargo, "Ingrese precio hora extra.");
		pistasCargo = new PlaceHolder(formularioCargo.txtFuncionesCargo, "Escriba funciones asignadas.");
		pistasCargo = new PlaceHolder(formularioCargo.txtBusquedaCargos, "buscar: codigo -- Nombre -- area");
	}
	
	/* Metodos para mostrar datos en tabla Cargos*/
	public static ArrayList<cargo> buscarUsuariosConMatriz() {
		conexion conex = new conexion();
		ArrayList<cargo> miLista = new ArrayList<cargo>();
		cargo cargo;
		try {
			Statement estatuto = conex.getConexion().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT * FROM cargos ");

			while (rs.next()) {
				cargo = new cargo();
				cargo.setId_cargo(Integer.parseInt(rs.getString("id_cargo")));
				cargo.setArea_cargo(rs.getString("area_cargo"));
				cargo.setNombre_cargo(rs.getString("nombre_cargo"));
				cargo.setSueldo_cargo(Double.parseDouble(rs.getString("sueldo_cargo")));
				cargo.setValor_hora_extra_cargo(Double.parseDouble(rs.getString("valor_hora_extra_cargo")));
				cargo.setFunciones_cargo(rs.getString("funciones_cargo"));
				miLista.add(cargo);
			}
			rs.close();
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error al consultar", "Error", JOptionPane.ERROR_MESSAGE);

		}
		return miLista;
	}

	public static String[][] obtenerMatriz() {
		ArrayList<cargo> miLista = buscarUsuariosConMatriz();
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
