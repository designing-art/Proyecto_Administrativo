package controles;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import clases.historial_planilla;
import clases.planilla;
import conexion.conexion;
import consultas.consultas_planilla;
import formularios.login_usuario;
import formularios.registro_empleados;
import formularios.registro_planillas;

public class control_planilla implements ActionListener {

	public planilla clase_planilla;
	public historial_planilla clase_historial_planilla;
	public consultas_planilla consulta_planilla;
	public registro_planillas formulario_planilla;
	public registro_empleados formulario_empleados = new registro_empleados();
	public ImageIcon usuario = new ImageIcon(getClass().getResource("/iconos/usuario.png"));
	public static String identidadPLA = null;
	public static String planillaPLA = null;

	public control_planilla(planilla clase, historial_planilla clase2, consultas_planilla consulta,
			registro_planillas formulario) {
		this.clase_planilla = clase;
		this.clase_historial_planilla = clase2;
		this.consulta_planilla = consulta;
		this.formulario_planilla = formulario;
		this.formulario_planilla.btnGuardar.addActionListener(this);
		this.formulario_planilla.btnGuardarPlanilla.addActionListener(this);
		this.formulario_planilla.btnNuevo.addActionListener(this);
		this.formulario_planilla.btnActualizar.addActionListener(this);
		this.formulario_planilla.btnActualizarDatosPlanilla.addActionListener(this);
		this.formulario_planilla.btnBorrarPlanilla.addActionListener(this);
		this.formulario_planilla.btnVerPlanilla.addActionListener(this);
		this.formulario_planilla.btnAceptar.addActionListener(this);
		this.formulario_planilla.up_down.addActionListener(this);
		this.formulario_planilla.btnAgregar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == formulario_planilla.btnGuardar) {
			validarIdentidad();

			if (registro_planillas.txtIdentidadEmpleadoPlanilla.getText().isEmpty()
					|| registro_planillas.txtIdentidadPlanilla.getText().isEmpty()
					|| registro_planillas.txtCantidadPlanilla.getText().isEmpty()
					|| registro_planillas.txtTotalBonificacionesPlanilla.getText().isEmpty()
					|| registro_planillas.txtTotalDeduccionesPlanilla.getText().isEmpty()
					|| registro_planillas.txtTotalPagoEmpleado.getText().isEmpty()
					|| registro_planillas.txtCantidadPlanilla.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Porfavor llene los campos para guardar el pago!");
			} else {
				if (registro_planillas.txtIdentidadPlanilla.getText().toString().equals(identidadPLA)
						&& registro_planillas.lblNombrePlanillaNueva.getText().toString().equals(planillaPLA)) {
					JOptionPane.showMessageDialog(null,
							"Se encontrado un registro con esta identidad : " + identidadPLA,
							"Atencion datos duplicados", JOptionPane.INFORMATION_MESSAGE);
				} else {
					clase_planilla.setFecha_planilla(formulario_planilla.editor.getText());
					clase_planilla.setNombres_planilla(registro_planillas.txtNombresPlanilla.getText());
					clase_planilla.setApellidos_planilla(registro_planillas.txtApellidosPlanilla.getText());
					clase_planilla.setIdentidad_planilla(registro_planillas.txtIdentidadPlanilla.getText());
					clase_planilla.setCargo_planilla(registro_planillas.txtCargoPlanilla.getText());
					clase_planilla.setSueldo_bruto_planilla(
							Double.parseDouble(registro_planillas.txtCantidadPlanilla.getText()));
					clase_planilla.setTotal_deducciones_planilla(
							Double.parseDouble(registro_planillas.txtTotalDeduccionesPlanilla.getText()));
					clase_planilla.setTotal_bonificaciones_planilla(
							Double.parseDouble(registro_planillas.txtTotalBonificacionesPlanilla.getText()));
					clase_planilla.setSueldo_neto_planilla(
							Double.parseDouble(registro_planillas.txtSueldoNetoPlanilla.getText()));
					clase_planilla.setTotal_apagar_planilla(
							Double.parseDouble(registro_planillas.txtTotalPagoEmpleado.getText()));
					clase_planilla.setNombre_planilla(registro_planillas.lblNombrePlanillaNueva.getText().toString());

					if (consulta_planilla.registrar(clase_planilla)) {
						JOptionPane.showMessageDialog(null, "Exito! Empleado agregado a la panilla!");
						limpiar();
						formulario_planilla.construirTabla();
						formulario_planilla.obtenerUltimoId();
						formulario_planilla.establecerFechaRegistro();

						final ImageIcon logo = new ImageIcon(
								usuario.getImage().getScaledInstance(registro_planillas.lblFotoPlanilla.getWidth(),
										registro_planillas.lblFotoPlanilla.getHeight(), Image.SCALE_DEFAULT));
						registro_planillas.lblFotoPlanilla.setIcon(logo);
						registro_planillas.txtDireccionFoto.setText(null);
						registro_planillas.lblFotoPlanilla.setText(null);
						registro_planillas.lblFotoPlanilla.requestFocusInWindow();

					} else {
						JOptionPane.showMessageDialog(null, "Error!  no Registrado");
						limpiar();
					}
				}
			}
		}

		if (e.getSource() == formulario_planilla.btnActualizar) {
			validarIdentidad();

			if (registro_planillas.txtIdentidadEmpleadoPlanilla.getText().isEmpty()
					|| registro_planillas.txtIdentidadPlanilla.getText().isEmpty()
					|| registro_planillas.txtCantidadPlanilla.getText().isEmpty()
					|| registro_planillas.txtTotalBonificacionesPlanilla.getText().isEmpty()
					|| registro_planillas.txtTotalDeduccionesPlanilla.getText().isEmpty()
					|| registro_planillas.txtTotalPagoEmpleado.getText().isEmpty()
					|| registro_planillas.txtCantidadPlanilla.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Porfavor llene los campos para guardar el pago!");

			} else {
				clase_planilla.setId_planilla(Integer.parseInt(formulario_planilla.txtCodigo.getText()));
				clase_planilla.setFecha_planilla(formulario_planilla.editor.getText());
				clase_planilla.setNombres_planilla(registro_planillas.txtNombresPlanilla.getText());
				clase_planilla.setApellidos_planilla(registro_planillas.txtApellidosPlanilla.getText());
				clase_planilla.setIdentidad_planilla(registro_planillas.txtIdentidadPlanilla.getText());
				clase_planilla.setCargo_planilla(registro_planillas.txtCargoPlanilla.getText());
				clase_planilla
						.setSueldo_bruto_planilla(Double.parseDouble(registro_planillas.txtCantidadPlanilla.getText()));
				clase_planilla.setTotal_deducciones_planilla(
						Double.parseDouble(registro_planillas.txtTotalDeduccionesPlanilla.getText()));
				clase_planilla.setTotal_bonificaciones_planilla(
						Double.parseDouble(registro_planillas.txtTotalBonificacionesPlanilla.getText()));
				clase_planilla.setSueldo_neto_planilla(
						Double.parseDouble(registro_planillas.txtSueldoNetoPlanilla.getText()));
				clase_planilla.setTotal_apagar_planilla(
						Double.parseDouble(registro_planillas.txtTotalPagoEmpleado.getText()));
				clase_planilla.setNombre_planilla(registro_planillas.lblNombrePlanillaNueva.getText().toString());

				if (consulta_planilla.modificar(clase_planilla)) {
					JOptionPane.showMessageDialog(null, "Datos del pago actualizados!");
					limpiar();
					formulario_planilla.construirTabla();
					formulario_planilla.obtenerUltimoId();
					formulario_planilla.btnActualizar.setVisible(false);
					final ImageIcon logo = new ImageIcon(
							usuario.getImage().getScaledInstance(registro_planillas.lblFotoPlanilla.getWidth(),
									registro_planillas.lblFotoPlanilla.getHeight(), Image.SCALE_DEFAULT));
					registro_planillas.lblFotoPlanilla.setIcon(logo);
					formulario_planilla.txtBusquedaPlanilla.requestFocusInWindow();

				} else {
					JOptionPane.showMessageDialog(null, "Error!  no Actualizado");
					limpiar();
				}

			}
		}

		if (e.getSource() == formulario_planilla.btnGuardarPlanilla) {
			if (registro_planillas.txtSueldosPlanilla.getText().isEmpty()
					|| registro_planillas.txtBonificacionesPlanilla.getText().isEmpty()
					|| registro_planillas.txtDeduccionesPlanilla.getText().isEmpty()
					|| registro_planillas.txtTotaPlanilla.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null,
						"Antes de guardar el progreso.\n" + "calcule los totales de la planilla actual!");

			} else {
				clase_historial_planilla.setTotal_deducciones_planilla_final(
						Double.parseDouble(registro_planillas.txtDeduccionesPlanilla.getText().toString()));
				clase_historial_planilla.setTotal_bonificaciones_planilla_final(
						Double.parseDouble(registro_planillas.txtBonificacionesPlanilla.getText().toString()));
				clase_historial_planilla.setTotal_sueldos_planilla_final(
						Double.parseDouble(registro_planillas.txtSueldosPlanilla.getText().toString()));
				clase_historial_planilla.setTotal_pago_planilla_final(
						Double.parseDouble(registro_planillas.txtTotaPlanilla.getText().toString()));
				clase_historial_planilla.setId_planilla_final(
						Integer.parseInt(registro_planillas.txtCodigoPlanillaNueva.getText().toString()));

				if (consulta_planilla.actualizarDatosPlanilla(clase_historial_planilla)) {
					JOptionPane.showMessageDialog(null, "Correcto! Datos guardados!\n" + "Planilla : '"
							+ registro_planillas.lblNombrePlanillaNueva.getText().toString() + "' actualizada!");
					limpiar();
					formulario_planilla.construirTabla();
					formulario_planilla.obtenerUltimoId();
					formulario_planilla.btnActualizar.setVisible(false);
					final ImageIcon logo = new ImageIcon(
							usuario.getImage().getScaledInstance(registro_planillas.lblFotoPlanilla.getWidth(),
									registro_planillas.lblFotoPlanilla.getHeight(), Image.SCALE_DEFAULT));
					registro_planillas.lblFotoPlanilla.setIcon(logo);
					formulario_planilla.txtBusquedaPlanilla.requestFocusInWindow();

				} else {
					JOptionPane.showMessageDialog(null, "Error!  no Actualizado");
					limpiar();
				}

			}
		}

		if (e.getSource() == formulario_planilla.btnActualizarDatosPlanilla) {
			int filaseleccionada;
			try {
				filaseleccionada = formulario_planilla.tablaPlanilla.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
					registro_planillas.txtIdentidadEmpleadoPlanilla.setText(null);
				} else {
					String codigo = formulario_planilla.tablaPlanilla.getValueAt(filaseleccionada, 0).toString();
					String fecha = formulario_planilla.tablaPlanilla.getValueAt(filaseleccionada, 1).toString();
					String nombres = formulario_planilla.tablaPlanilla.getValueAt(filaseleccionada, 2).toString();
					String apellidos = formulario_planilla.tablaPlanilla.getValueAt(filaseleccionada, 3).toString();
					String identidad = formulario_planilla.tablaPlanilla.getValueAt(filaseleccionada, 4).toString();
					String cargo = formulario_planilla.tablaPlanilla.getValueAt(filaseleccionada, 5).toString();
					String sueldob = formulario_planilla.tablaPlanilla.getValueAt(filaseleccionada, 6).toString();
					String deduc = formulario_planilla.tablaPlanilla.getValueAt(filaseleccionada, 7).toString();
					String bonif = formulario_planilla.tablaPlanilla.getValueAt(filaseleccionada, 8).toString();
					String sueldon = formulario_planilla.tablaPlanilla.getValueAt(filaseleccionada, 9).toString();
					String total = formulario_planilla.tablaPlanilla.getValueAt(filaseleccionada, 10).toString();
					String nombre = formulario_planilla.tablaPlanilla.getValueAt(filaseleccionada, 11).toString();

					formulario_planilla.txtCodigo.setText(codigo);
					formulario_planilla.editor.setText(fecha);
					registro_planillas.txtNombresPlanilla.setText(nombres);
					registro_planillas.txtApellidosPlanilla.setText(apellidos);
					registro_planillas.txtIdentidadPlanilla.setText(identidad);
					registro_planillas.txtCargoPlanilla.setText(cargo);
					registro_planillas.txtCantidadPlanilla.setText(sueldob);
					registro_planillas.txtTotalDeduccionesPlanilla.setText(deduc);
					registro_planillas.txtTotalBonificacionesPlanilla.setText(bonif);
					registro_planillas.txtSueldoNetoPlanilla.setText(sueldon);
					registro_planillas.txtTotalPagoEmpleado.setText(total);
					registro_planillas.lblNombrePlanillaNueva.setText(nombre);

					registro_planillas.txtCodigoPlanilla.setForeground(Color.BLACK);
					registro_planillas.txtNombresPlanilla.setForeground(Color.BLACK);
					registro_planillas.txtApellidosPlanilla.setForeground(Color.BLACK);
					registro_planillas.txtIdentidadPlanilla.setForeground(Color.BLACK);
					formulario_planilla.editor.setForeground(Color.BLACK);

					formulario_planilla.btnBorrarPlanilla.setVisible(true);
					formulario_planilla.btnGuardar.setVisible(false);
					formulario_planilla.btnNuevo.setVisible(false);
					formulario_planilla.btnActualizar.setVisible(true);
					formulario_planilla.btnActualizarDatosPlanilla.setVisible(true);
					formulario_planilla.btnVerPlanilla.setVisible(false);
					formulario_planilla.btnAceptar.setText("Cancelar");
					formulario_planilla.btnAceptar.setVisible(true);

					registro_planillas.txtIdentidadEmpleadoPlanilla.requestFocusInWindow();

				}

			} catch (HeadlessException ex) {
				JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente",
						" .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);
			}
		}

		if (e.getSource() == formulario_planilla.btnAgregar) {
			int filaseleccionada;
			try {
				filaseleccionada = formulario_planilla.tablaEmpleados.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					String codigo = formulario_planilla.tablaEmpleados.getValueAt(filaseleccionada, 0).toString();
					String nombres = formulario_planilla.tablaEmpleados.getValueAt(filaseleccionada, 1).toString();
					String apellidos = formulario_planilla.tablaEmpleados.getValueAt(filaseleccionada, 2).toString();
					String identidad = formulario_planilla.tablaEmpleados.getValueAt(filaseleccionada, 3).toString();
					String direccion_foto = formulario_planilla.tablaEmpleados.getValueAt(filaseleccionada, 9)
							.toString();
					String cargo = formulario_planilla.tablaEmpleados.getValueAt(filaseleccionada, 16).toString();
					String sueldo = formulario_planilla.tablaEmpleados.getValueAt(filaseleccionada, 17).toString();

					registro_planillas.txtNombresPlanilla.setText(nombres);
					registro_planillas.txtApellidosPlanilla.setText(apellidos);
					registro_planillas.txtIdentidadPlanilla.setText(identidad);
					registro_planillas.txtCodigoPlanilla.setText(codigo);
					registro_planillas.txtCargoPlanilla.setText(cargo);
					registro_planillas.txtDireccionFoto.setText(direccion_foto);
					registro_planillas.txtCantidadPlanilla.setText(sueldo);

					registro_planillas.txtNombresPlanilla.setForeground(Color.BLACK);
					registro_planillas.txtApellidosPlanilla.setForeground(Color.BLACK);
					registro_planillas.txtIdentidadPlanilla.setForeground(Color.BLACK);
					registro_planillas.txtCodigoPlanilla.setForeground(Color.BLACK);
					registro_planillas.txtCargoPlanilla.setForeground(Color.BLACK);
					registro_planillas.txtDireccionFoto.setForeground(Color.BLACK);
					registro_planillas.txtCantidadPlanilla.setForeground(Color.BLACK);

					final ImageIcon foto2 = new ImageIcon(direccion_foto);
					final ImageIcon logo = new ImageIcon(
							foto2.getImage().getScaledInstance(registro_planillas.lblFotoPlanilla.getWidth(),
									registro_planillas.lblFotoPlanilla.getHeight(), Image.SCALE_DEFAULT));
					registro_planillas.lblFotoPlanilla.setIcon(logo);

				}

			} catch (HeadlessException ex) {
				JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente",
						" .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);
			}
		}

		if (e.getSource() == formulario_planilla.btnVerPlanilla) {
			int filaseleccionada;
			try {
				filaseleccionada = formulario_planilla.tablaPlanilla.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
					registro_planillas.txtIdentidadEmpleadoPlanilla.setText(null);
				} else {
					String codigo = formulario_planilla.tablaPlanilla.getValueAt(filaseleccionada, 0).toString();
					String fecha = formulario_planilla.tablaPlanilla.getValueAt(filaseleccionada, 1).toString();
					String nombres = formulario_planilla.tablaPlanilla.getValueAt(filaseleccionada, 2).toString();
					String apellidos = formulario_planilla.tablaPlanilla.getValueAt(filaseleccionada, 3).toString();
					String identidad = formulario_planilla.tablaPlanilla.getValueAt(filaseleccionada, 4).toString();
					String cargo = formulario_planilla.tablaPlanilla.getValueAt(filaseleccionada, 5).toString();
					String sueldob = formulario_planilla.tablaPlanilla.getValueAt(filaseleccionada, 6).toString();
					String deduc = formulario_planilla.tablaPlanilla.getValueAt(filaseleccionada, 7).toString();
					String bonif = formulario_planilla.tablaPlanilla.getValueAt(filaseleccionada, 8).toString();
					String sueldon = formulario_planilla.tablaPlanilla.getValueAt(filaseleccionada, 9).toString();
					String total = formulario_planilla.tablaPlanilla.getValueAt(filaseleccionada, 10).toString();
					String nombre = formulario_planilla.tablaPlanilla.getValueAt(filaseleccionada, 11).toString();

					formulario_planilla.txtCodigo.setText(codigo);
					formulario_planilla.editor.setText(fecha);
					registro_planillas.txtNombresPlanilla.setText(nombres);
					registro_planillas.txtApellidosPlanilla.setText(apellidos);
					registro_planillas.txtIdentidadPlanilla.setText(identidad);
					registro_planillas.txtCargoPlanilla.setText(cargo);
					registro_planillas.txtCantidadPlanilla.setText(sueldob);
					registro_planillas.txtTotalDeduccionesPlanilla.setText(deduc);
					registro_planillas.txtTotalBonificacionesPlanilla.setText(bonif);
					registro_planillas.txtSueldoNetoPlanilla.setText(sueldon);
					registro_planillas.txtTotalPagoEmpleado.setText(total);
					registro_planillas.lblNombrePlanillaNueva.setText(nombre);

					registro_planillas.txtCodigoPlanilla.setForeground(Color.BLACK);
					registro_planillas.txtNombresPlanilla.setForeground(Color.BLACK);
					registro_planillas.txtApellidosPlanilla.setForeground(Color.BLACK);
					registro_planillas.txtIdentidadPlanilla.setForeground(Color.BLACK);
					formulario_planilla.editor.setForeground(Color.BLACK);

					formulario_planilla.btnBorrarPlanilla.setVisible(false);
					formulario_planilla.btnGuardar.setVisible(false);
					formulario_planilla.btnNuevo.setVisible(false);
					formulario_planilla.btnActualizar.setVisible(false);
					formulario_planilla.btnActualizarDatosPlanilla.setVisible(false);
					formulario_planilla.btnAceptar.setText("Aceptar");
					formulario_planilla.btnAceptar.setVisible(true);
					formulario_planilla.btnActualizar.setVisible(false);

				}

			} catch (HeadlessException ex) {
				JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente",
						" .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);
			}
		}

		if (e.getSource() == formulario_planilla.btnBorrarPlanilla) {
			PreparedStatement ps = null;
			int filaseleccionada;
			try {
				filaseleccionada = formulario_planilla.tablaPlanilla.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					if (login_usuario.cargoUsuario.toString() == "Usuario Avanzado") {
						conexion objCon = new conexion();
						Connection conn = objCon.getConexion();
						int Fila = formulario_planilla.tablaPlanilla.getSelectedRow();
						String codigo = formulario_planilla.tablaPlanilla.getValueAt(Fila, 0).toString();
						ps = conn.prepareStatement("DELETE FROM planillas WHERE id_planilla=?");
						ps.setString(1, codigo);
						ps.execute();
						JOptionPane.showMessageDialog(null, "Pago de empleado Eliminado!");
						limpiar();
						formulario_planilla.construirTabla();
						formulario_planilla.btnActualizar.setVisible(false);

						final ImageIcon logo = new ImageIcon(
								usuario.getImage().getScaledInstance(registro_planillas.lblFotoPlanilla.getWidth(),
										registro_planillas.lblFotoPlanilla.getHeight(), Image.SCALE_DEFAULT));
						registro_planillas.lblFotoPlanilla.setIcon(logo);
						registro_planillas.txtDireccionFoto.setText(null);
					} else {
						JOptionPane.showMessageDialog(null,
								"Usted no tiene permisos para eliminar (Solo el jefe de la empresa)");
					}

				}
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "Error al eliminar deduccion");
				System.out.println(ex.toString());
			}
		}

		if (e.getSource() == formulario_planilla.btnNuevo) {
			limpiar();
			formulario_planilla.obtenerUltimoId();
			formulario_planilla.btnBorrarPlanilla.setVisible(false);
			formulario_planilla.btnGuardar.setVisible(true);
			formulario_planilla.btnVerPlanilla.setVisible(true);
			formulario_planilla.btnNuevo.setVisible(true);
			formulario_planilla.btnActualizar.setVisible(false);
			formulario_planilla.btnActualizarDatosPlanilla.setVisible(true);
			formulario_planilla.pistas();
			formulario_planilla.construirTabla();
			formulario_planilla.establecerFechaRegistro();
			registro_planillas.txtIdentidadEmpleadoPlanilla.requestFocusInWindow();

			final ImageIcon logo = new ImageIcon(
					usuario.getImage().getScaledInstance(registro_planillas.lblFotoPlanilla.getWidth(),
							registro_planillas.lblFotoPlanilla.getHeight(), Image.SCALE_DEFAULT));
			registro_planillas.lblFotoPlanilla.setIcon(logo);
			registro_planillas.txtDireccionFoto.setText(null);

		}

		if (e.getSource() == formulario_planilla.btnAceptar) {
			limpiar();
			limpiar();
			formulario_planilla.obtenerUltimoId();
			formulario_planilla.btnBorrarPlanilla.setVisible(false);
			formulario_planilla.btnGuardar.setVisible(true);
			formulario_planilla.btnVerPlanilla.setVisible(true);
			formulario_planilla.btnNuevo.setVisible(true);
			formulario_planilla.btnAceptar.setVisible(false);
			formulario_planilla.btnActualizar.setVisible(false);
			formulario_planilla.btnActualizarDatosPlanilla.setVisible(true);
			formulario_planilla.pistas();
			formulario_planilla.construirTabla();
			formulario_planilla.establecerFechaRegistro();
			registro_planillas.txtIdentidadEmpleadoPlanilla.requestFocusInWindow();
			registro_planillas.txtIdentidadEmpleadoPlanilla.setEditable(true);

			final ImageIcon logo = new ImageIcon(
					usuario.getImage().getScaledInstance(registro_planillas.lblFotoPlanilla.getWidth(),
							registro_planillas.lblFotoPlanilla.getHeight(), Image.SCALE_DEFAULT));
			registro_planillas.lblFotoPlanilla.setIcon(logo);
			registro_planillas.txtDireccionFoto.setText(null);

		}

		if (e.getSource() == formulario_planilla.up_down) {
			if (formulario_planilla.up_down.isSelected()) {
				formulario_planilla.construirTabla2();
			} else {
				formulario_planilla.construirTabla();
			}
		}

		// ------------------------------------------------------------------------------------------------//

	}

	public void limpiar() {
		formulario_planilla.txtCodigo.setText(null);
		registro_planillas.txtCodigoPlanilla.setText(null);
		registro_planillas.txtNombresPlanilla.setText(null);
		registro_planillas.txtApellidosPlanilla.setText(null);
		registro_planillas.txtIdentidadPlanilla.setText(null);
		registro_planillas.txtCargoPlanilla.setText(null);
		formulario_planilla.txtBusquedaPlanilla.setText(null);
		registro_planillas.txtTotaPlanilla.setText(null);
		registro_planillas.txtDireccionFoto.setText(null);
		registro_planillas.txtTotalPagoEmpleado.setText(null);
		registro_planillas.txtTotalBonificacionesPlanilla.setText(null);
		registro_planillas.txtTotalDeduccionesPlanilla.setText(null);
		registro_planillas.txtCantidadPlanilla.setText(null);
		registro_planillas.txtSueldoNetoPlanilla.setText(null);
		registro_planillas.txtIdentidadEmpleadoPlanilla.setText(null);
	}

	public static ArrayList<planilla> buscarUsuariosConMatriz() {
		conexion conex = new conexion();
		ArrayList<planilla> miLista = new ArrayList<planilla>();
		planilla planilla;
		try {
			Statement estatuto = conex.getConexion().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT * FROM planillas where nombre_planilla='"
					+ registro_planillas.lblNombrePlanillaNueva.getText().toString() + "' ORDER BY id_planilla DESC");

			while (rs.next()) {
				planilla = new planilla();
				planilla.setId_planilla(Integer.parseInt(rs.getString("id_planilla")));
				planilla.setFecha_planilla(rs.getString("fecha_planilla"));
				planilla.setNombres_planilla(rs.getString("nombres_planilla"));
				planilla.setApellidos_planilla(rs.getString("apellidos_planilla"));
				planilla.setIdentidad_planilla(rs.getString("identidad_planilla"));
				planilla.setCargo_planilla(rs.getString("cargo_planilla"));
				planilla.setSueldo_bruto_planilla(Double.parseDouble(rs.getString("sueldo_bruto_planilla")));
				planilla.setTotal_deducciones_planilla(Double.parseDouble(rs.getString("total_deducciones_planilla")));
				planilla.setTotal_bonificaciones_planilla(
						Double.parseDouble(rs.getString("total_bonificaciones_planilla")));
				planilla.setSueldo_neto_planilla(Double.parseDouble(rs.getString("sueldo_neto_planilla")));
				planilla.setTotal_apagar_planilla(Double.parseDouble(rs.getString("total_apagar_planilla")));
				planilla.setNombre_planilla(rs.getString("nombre_planilla"));
				miLista.add(planilla);
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

	public static ArrayList<planilla> buscarUsuariosConMatriz2() {
		conexion conex = new conexion();
		ArrayList<planilla> miLista = new ArrayList<planilla>();
		planilla planilla;
		try {
			Statement estatuto = conex.getConexion().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT * FROM planillas where nombre_planilla='"
					+ registro_planillas.lblNombrePlanillaNueva.getText().toString() + "'");

			while (rs.next()) {
				planilla = new planilla();
				planilla.setId_planilla(Integer.parseInt(rs.getString("id_planilla")));
				planilla.setFecha_planilla(rs.getString("fecha_planilla"));
				planilla.setNombres_planilla(rs.getString("nombres_planilla"));
				planilla.setApellidos_planilla(rs.getString("apellidos_planilla"));
				planilla.setIdentidad_planilla(rs.getString("identidad_planilla"));
				planilla.setCargo_planilla(rs.getString("cargo_planilla"));
				planilla.setSueldo_bruto_planilla(Double.parseDouble(rs.getString("sueldo_bruto_planilla")));
				planilla.setTotal_deducciones_planilla(Double.parseDouble(rs.getString("total_deducciones_planilla")));
				planilla.setTotal_bonificaciones_planilla(
						Double.parseDouble(rs.getString("total_bonificaciones_planilla")));
				planilla.setSueldo_neto_planilla(Double.parseDouble(rs.getString("sueldo_neto_planilla")));
				planilla.setTotal_apagar_planilla(Double.parseDouble(rs.getString("total_apagar_planilla")));
				planilla.setNombre_planilla(rs.getString("nombre_planilla"));
				miLista.add(planilla);
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
		ArrayList<planilla> miLista = buscarUsuariosConMatriz();
		String matrizInfo[][] = new String[miLista.size()][12];
		for (int i = 0; i < miLista.size(); i++) {
			matrizInfo[i][0] = miLista.get(i).getId_planilla() + "";
			matrizInfo[i][1] = miLista.get(i).getFecha_planilla() + "";
			matrizInfo[i][2] = miLista.get(i).getNombres_planilla() + "";
			matrizInfo[i][3] = miLista.get(i).getApellidos_planilla() + "";
			matrizInfo[i][4] = miLista.get(i).getIdentidad_planilla() + "";
			matrizInfo[i][5] = miLista.get(i).getCargo_planilla() + "";
			matrizInfo[i][6] = miLista.get(i).getSueldo_bruto_planilla() + "";
			matrizInfo[i][7] = miLista.get(i).getTotal_deducciones_planilla() + "";
			matrizInfo[i][8] = miLista.get(i).getTotal_bonificaciones_planilla() + "";
			matrizInfo[i][9] = miLista.get(i).getSueldo_neto_planilla() + "";
			matrizInfo[i][10] = miLista.get(i).getTotal_apagar_planilla() + "";
			matrizInfo[i][11] = miLista.get(i).getNombre_planilla() + "";
		}

		return matrizInfo;
	}

	public static String[][] obtenerMatriz2() {
		ArrayList<planilla> miLista = buscarUsuariosConMatriz2();
		String matrizInfo[][] = new String[miLista.size()][12];
		for (int i = 0; i < miLista.size(); i++) {
			matrizInfo[i][0] = miLista.get(i).getId_planilla() + "";
			matrizInfo[i][1] = miLista.get(i).getFecha_planilla() + "";
			matrizInfo[i][2] = miLista.get(i).getNombres_planilla() + "";
			matrizInfo[i][3] = miLista.get(i).getApellidos_planilla() + "";
			matrizInfo[i][4] = miLista.get(i).getIdentidad_planilla() + "";
			matrizInfo[i][5] = miLista.get(i).getCargo_planilla() + "";
			matrizInfo[i][6] = miLista.get(i).getSueldo_bruto_planilla() + "";
			matrizInfo[i][7] = miLista.get(i).getTotal_deducciones_planilla() + "";
			matrizInfo[i][8] = miLista.get(i).getTotal_bonificaciones_planilla() + "";
			matrizInfo[i][9] = miLista.get(i).getSueldo_neto_planilla() + "";
			matrizInfo[i][10] = miLista.get(i).getTotal_apagar_planilla() + "";
			matrizInfo[i][11] = miLista.get(i).getNombre_planilla() + "";
		}

		return matrizInfo;
	}

	public void validarIdentidad() {
		conexion conex = new conexion();
		try {
			Statement estatuto = conex.getConexion().createStatement();
			ResultSet rs = estatuto
					.executeQuery("SELECT identidad_planilla, nombre_planilla FROM planillas where nombre_planilla = '"
							+ registro_planillas.lblNombrePlanillaNueva.getText().toString() + "'");

			if (rs.next()) {
				identidadPLA = (rs.getString("identidad_planilla"));
				planillaPLA = (rs.getString("nombre_planilla"));
			}

			rs.close();
			estatuto.close();
			conex.desconectar();

		} catch (SQLException exx) {
			System.out.println(exx.getMessage());
			JOptionPane.showMessageDialog(null, "Error al consultar", "Error", JOptionPane.ERROR_MESSAGE);

		}

	}

}
