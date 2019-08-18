package controles;

import java.awt.Color;
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
import clases.cargo;
import conexion.conexion;
import consultas.consultas_cargo;
import formularios.login_usuario;
import formularios.registro_cargos;
import formularios.registro_empleados;

public class control_cargo implements ActionListener {

	public cargo claseCargo;
	public consultas_cargo consultasCargo;
	public registro_cargos formularioCargo;
	public static int numeroRegistro = 0;

	public control_cargo(cargo claseCargo, consultas_cargo consultasCargo, registro_cargos formularioCargo) {
		this.claseCargo = claseCargo;
		this.consultasCargo = consultasCargo;
		this.formularioCargo = formularioCargo;
		this.formularioCargo.btnGuardarCargo.addActionListener(this);
		this.formularioCargo.btnNuevoCargo.addActionListener(this);
		this.formularioCargo.btnActualizarCargo.addActionListener(this);
		this.formularioCargo.btnActualizarDatosCargo.addActionListener(this);
		this.formularioCargo.btnBorrarCargo.addActionListener(this);
		this.formularioCargo.btnMostrar.addActionListener(this);
		this.formularioCargo.btnAceptar.addActionListener(this);
		this.formularioCargo.btnAsignar.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/* Insertar */
		if (e.getSource() == formularioCargo.btnGuardarCargo) {

			if (formularioCargo.txtNombreCargo.getText().isEmpty() || formularioCargo.txtSueldoCargo.getText().isEmpty()
					|| formularioCargo.txtHoraExtraCargo.getText().isEmpty()
					|| formularioCargo.txtFuncionesCargo.getText().isEmpty()
					|| formularioCargo.txtNombreCargo.getText().toString()
							.equalsIgnoreCase("Ingrese el nombre del cargo.")
					|| formularioCargo.txtSueldoCargo.getText().toString().equalsIgnoreCase("Digite el sueldo.")
					|| formularioCargo.txtHoraExtraCargo.getText().toString()
							.equalsIgnoreCase("Digite precio hora extra.")
					|| formularioCargo.txtFuncionesCargo.getText().toString()
							.equalsIgnoreCase("Ingrese las Funciones.")) {
				JOptionPane.showMessageDialog(null, "Porfavor llene los campos para guardar el cargo!");

			} else {
				claseCargo.setArea_cargo(formularioCargo.cbxTipoCargo.getSelectedItem().toString());
				claseCargo.setNombre_cargo(formularioCargo.txtNombreCargo.getText());
				claseCargo.setSueldo_cargo(Double.parseDouble(formularioCargo.txtSueldoCargo.getText()));
				claseCargo.setValor_hora_extra_cargo(Double.parseDouble(formularioCargo.txtHoraExtraCargo.getText()));
				claseCargo.setFunciones_cargo(formularioCargo.txtFuncionesCargo.getText());
				if (consultasCargo.insertar(claseCargo)) {
					JOptionPane.showMessageDialog(null, "Cargo registrado!");
					limpiar();
					formularioCargo.construirTabla();
					formularioCargo.obtenerUltimoId();
				} else {
					JOptionPane.showMessageDialog(null, "Error! Cargo no Registrado");
					limpiar();
				}
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

					formularioCargo.txtCodigoCargo.setForeground(Color.BLACK);
					formularioCargo.cbxTipoCargo.setForeground(Color.BLACK);
					formularioCargo.txtNombreCargo.setForeground(Color.BLACK);
					formularioCargo.txtSueldoCargo.setForeground(Color.BLACK);
					formularioCargo.txtHoraExtraCargo.setForeground(Color.BLACK);
					formularioCargo.txtFuncionesCargo.setForeground(Color.BLACK);

					formularioCargo.btnBorrarCargo.setVisible(true);
					formularioCargo.btnGuardarCargo.setVisible(false);
					formularioCargo.btnNuevoCargo.setVisible(false);
					formularioCargo.btnActualizarCargo.setVisible(true);
					formularioCargo.btnActualizarDatosCargo.setVisible(true);
					formularioCargo.btnMostrar.setVisible(false);
					formularioCargo.btnAceptar.setText("Cancelar");
					formularioCargo.btnAceptar.setVisible(true);

					formularioCargo.txtNombreCargo.requestFocusInWindow();

				}

			} catch (HeadlessException ex) {
				JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente",
						" .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);
			}
		}

		if (e.getSource() == formularioCargo.btnAsignar) {

			int filaseleccionada;
			try {
				filaseleccionada = formularioCargo.tablaCargos.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					String nombre = formularioCargo.tablaCargos.getValueAt(filaseleccionada, 2).toString();
					String sueldo = formularioCargo.tablaCargos.getValueAt(filaseleccionada, 3).toString();
					String horaex = formularioCargo.tablaCargos.getValueAt(filaseleccionada, 4).toString();
					String funcion = formularioCargo.tablaCargos.getValueAt(filaseleccionada, 5).toString();

					registro_empleados.lbl_nombre_cargo_asignacion.setText(nombre);
					registro_empleados.lbl_sueldo_cargo_asignacion.setText(sueldo);
					registro_empleados.lbl_horaextra_cargo_asignacion.setText(horaex);
					registro_empleados.lbl_funciones_cargo_asignacion.setText(funcion);

					registro_empleados.lbl_nombre_cargo_asignacion.setForeground(Color.BLACK);
					registro_empleados.lbl_sueldo_cargo_asignacion.setForeground(Color.BLACK);
					registro_empleados.lbl_horaextra_cargo_asignacion.setForeground(Color.BLACK);
					registro_empleados.lbl_funciones_cargo_asignacion.setForeground(Color.BLACK);

					formularioCargo.dispose();

				}

			} catch (HeadlessException ex) {
				JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente",
						" .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);
			}
		}

		/* Pasar datos de la tabla al formulario para ver los datos */
		if (e.getSource() == formularioCargo.btnMostrar) {
			int fila;
			try {
				fila = formularioCargo.tablaCargos.getSelectedRow();
				if (fila == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					String codigo = formularioCargo.tablaCargos.getValueAt(fila, 0).toString();
					String area = formularioCargo.tablaCargos.getValueAt(fila, 1).toString();
					String nombre = formularioCargo.tablaCargos.getValueAt(fila, 2).toString();
					String sueldo = formularioCargo.tablaCargos.getValueAt(fila, 3).toString();
					String horaextra = formularioCargo.tablaCargos.getValueAt(fila, 4).toString();
					String funciones = formularioCargo.tablaCargos.getValueAt(fila, 5).toString();

					formularioCargo.txtCodigoCargo.setText(codigo);
					formularioCargo.cbxTipoCargo.setSelectedItem(area);
					formularioCargo.txtNombreCargo.setText(nombre);
					formularioCargo.txtSueldoCargo.setText(sueldo);
					formularioCargo.txtHoraExtraCargo.setText(horaextra);
					formularioCargo.txtFuncionesCargo.setText(funciones);

					formularioCargo.txtCodigoCargo.setForeground(Color.BLACK);
					formularioCargo.cbxTipoCargo.setForeground(Color.BLACK);
					formularioCargo.txtNombreCargo.setForeground(Color.BLACK);
					formularioCargo.txtSueldoCargo.setForeground(Color.BLACK);
					formularioCargo.txtHoraExtraCargo.setForeground(Color.BLACK);
					formularioCargo.txtFuncionesCargo.setForeground(Color.BLACK);

					formularioCargo.btnBorrarCargo.setVisible(false);
					formularioCargo.btnGuardarCargo.setVisible(false);
					formularioCargo.btnNuevoCargo.setVisible(false);
					formularioCargo.btnActualizarCargo.setVisible(false);
					formularioCargo.btnActualizarDatosCargo.setVisible(false);
					formularioCargo.btnAceptar.setText("Aceptar");
					formularioCargo.btnAceptar.setVisible(true);

					formularioCargo.cbxTipoCargo.setEditable(false);
					formularioCargo.txtNombreCargo.setEditable(false);
					formularioCargo.txtSueldoCargo.setEditable(false);
					formularioCargo.txtHoraExtraCargo.setEditable(false);
					formularioCargo.txtFuncionesCargo.setEditable(false);
					formularioCargo.txtFuncionesCargo.setBackground(Color.LIGHT_GRAY);
					formularioCargo.btnActualizarCargo.setVisible(false);

				}

			} catch (HeadlessException ex) {
				JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente",
						" .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);
			}
		}

		/* Actualizar */
		if (e.getSource() == formularioCargo.btnActualizarCargo) {

			if (formularioCargo.txtNombreCargo.getText().isEmpty() || formularioCargo.txtSueldoCargo.getText().isEmpty()
					|| formularioCargo.txtHoraExtraCargo.getText().isEmpty()
					|| formularioCargo.txtFuncionesCargo.getText().isEmpty()
					|| formularioCargo.txtNombreCargo.getText().toString()
							.equalsIgnoreCase("Ingrese el nombre del cargo.")
					|| formularioCargo.txtSueldoCargo.getText().toString().equalsIgnoreCase("Digite el sueldo.")
					|| formularioCargo.txtHoraExtraCargo.getText().toString()
							.equalsIgnoreCase("Digite precio hora extra.")
					|| formularioCargo.txtFuncionesCargo.getText().toString()
							.equalsIgnoreCase("Ingrese las Funciones.")) {
				JOptionPane.showMessageDialog(null, "Porfavor llene los campos para actualizar el cargo!");
			} else {

				claseCargo.setId_cargo(Integer.parseInt(formularioCargo.txtCodigoCargo.getText()));
				claseCargo.setArea_cargo(formularioCargo.cbxTipoCargo.getSelectedItem().toString());
				claseCargo.setNombre_cargo(formularioCargo.txtNombreCargo.getText());
				claseCargo.setSueldo_cargo(Double.parseDouble(formularioCargo.txtSueldoCargo.getText()));
				claseCargo.setValor_hora_extra_cargo(Double.parseDouble(formularioCargo.txtHoraExtraCargo.getText()));
				claseCargo.setFunciones_cargo(formularioCargo.txtFuncionesCargo.getText());

				if (consultasCargo.actualizar(claseCargo)) {
					JOptionPane.showMessageDialog(null, "Cargo Actualizado!");
					limpiar();
					formularioCargo.construirTabla();
					formularioCargo.obtenerUltimoId();
					formularioCargo.btnActualizarCargo.setVisible(false);
					formularioCargo.txtNombreCargo.setEditable(false);
					formularioCargo.txtSueldoCargo.setEditable(false);
					formularioCargo.txtHoraExtraCargo.setEditable(false);
					formularioCargo.txtFuncionesCargo.setEditable(false);
					formularioCargo.cbxTipoCargo.setEditable(false);
					formularioCargo.txtCodigoCargo.setText(null);
					formularioCargo.txtFuncionesCargo.setBackground(Color.LIGHT_GRAY);
				} else {
					JOptionPane.showMessageDialog(null, "Error! Cargo no Actualizado");
					limpiar();
				}

			}
		}

		/* Borrar */
		if (e.getSource() == formularioCargo.btnBorrarCargo) {
			PreparedStatement ps = null;
			int filaseleccionada;
			try {
				filaseleccionada = formularioCargo.tablaCargos.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					String permiso = login_usuario.tipoUsuario.toString();
					if (permiso.equals("Usuario Avanzado")) {

						conexion objCon = new conexion();
						Connection conn = objCon.getConexion();
						int Fila = formularioCargo.tablaCargos.getSelectedRow();
						String codigo = formularioCargo.tablaCargos.getValueAt(Fila, 0).toString();
						ps = conn.prepareStatement("DELETE FROM cargos WHERE id_cargo=?");
						ps.setString(1, codigo);
						ps.execute();
						JOptionPane.showMessageDialog(null, "Cargo Eliminado");

						claseCargo.setId_cargo(Integer.parseInt(codigo));
						claseCargo.setArea_cargo("Eliminado");
						claseCargo.setNombre_cargo("Eliminado");
						claseCargo.setSueldo_cargo(Double.parseDouble("0"));
						claseCargo.setValor_hora_extra_cargo(Double.parseDouble("0"));
						claseCargo.setFunciones_cargo("Eliminado");
						if (consultasCargo.insertarEliminacion(claseCargo)) {
							limpiar();
							formularioCargo.construirTabla();
							formularioCargo.obtenerUltimoId();
						}

						formularioCargo.cbxTipoCargo.setEditable(false);
						formularioCargo.txtNombreCargo.setEditable(false);
						formularioCargo.txtSueldoCargo.setEditable(false);
						formularioCargo.txtHoraExtraCargo.setEditable(false);
						formularioCargo.txtFuncionesCargo.setEditable(false);
						formularioCargo.btnActualizarCargo.setVisible(false);

					} else {
						JOptionPane.showMessageDialog(null,
								"Usted no tiene permisos para eliminar (Solo el jefe de la empresa)");
					}

				}
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "Error al Eliminar Cargo");
				System.out.println(ex.toString());
			}
		}

		/* Nuevo */
		if (e.getSource() == formularioCargo.btnNuevoCargo) {
			limpiar();
			formularioCargo.obtenerUltimoId();
			formularioCargo.btnBorrarCargo.setVisible(false);
			formularioCargo.btnGuardarCargo.setVisible(true);
			formularioCargo.btnMostrar.setVisible(true);
			formularioCargo.btnNuevoCargo.setVisible(true);
			formularioCargo.btnActualizarCargo.setVisible(false);
			formularioCargo.btnActualizarDatosCargo.setVisible(true);
			formularioCargo.txtNombreCargo.setEditable(true);
			formularioCargo.txtSueldoCargo.setEditable(true);
			formularioCargo.txtHoraExtraCargo.setEditable(true);
			formularioCargo.txtFuncionesCargo.setEditable(true);
			formularioCargo.btnActualizarCargo.setVisible(false);
			formularioCargo.construirTabla();
			formularioCargo.txtFuncionesCargo.setBackground(Color.WHITE);
		}

		/* Aceptar */
		if (e.getSource() == formularioCargo.btnAceptar) {
			limpiar();
			formularioCargo.obtenerUltimoId();
			formularioCargo.btnBorrarCargo.setVisible(false);
			formularioCargo.btnGuardarCargo.setVisible(true);
			formularioCargo.btnNuevoCargo.setVisible(true);
			formularioCargo.btnActualizarCargo.setVisible(false);
			formularioCargo.btnActualizarDatosCargo.setVisible(true);
			formularioCargo.txtNombreCargo.setEditable(true);
			formularioCargo.txtSueldoCargo.setEditable(true);
			formularioCargo.txtHoraExtraCargo.setEditable(true);
			formularioCargo.txtFuncionesCargo.setEditable(true);
			formularioCargo.btnActualizarCargo.setVisible(false);
			formularioCargo.btnMostrar.setVisible(true);
			formularioCargo.btnAceptar.setVisible(false);
			formularioCargo.txtFuncionesCargo.setBackground(Color.WHITE);
			formularioCargo.construirTabla();
		}

	}

	/* Metodos para implementar */

	/* Metodo para el boton nuevo que limpia los datos de los txtFields */
	public void limpiar() {
		formularioCargo.cbxTipoCargo.getSelectedItem().equals(null);
		formularioCargo.txtCodigoCargo.setText(null);
		formularioCargo.txtNombreCargo.setText(null);
		formularioCargo.txtSueldoCargo.setText(null);
		formularioCargo.txtHoraExtraCargo.setText(null);
		formularioCargo.txtFuncionesCargo.setText(null);
		formularioCargo.txtBusquedaCargos.setText(null);
	}

	/* Metodos para mostrar datos en tabla Cargos */
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
