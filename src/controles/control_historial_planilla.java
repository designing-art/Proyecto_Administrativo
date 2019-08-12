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
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;

import javax.swing.JOptionPane;

import clases.historial_planilla;
import clases.planilla;
import conexion.conexion;
import consultas.consultas_historial_planilla;
import consultas.consultas_planilla;
import formularios.login_usuario;
import formularios.registro_nuevas_planillas;
import formularios.registro_planillas;

public class control_historial_planilla implements ActionListener {

	public historial_planilla clase_historial_planilla;
	public consultas_historial_planilla consulta_historial_planilla;
	public registro_nuevas_planillas formulario_historial_planilla;

	public static String id = null;
	public static String nombrePla = null;

	public static String fecha_creacion = null;
	public static String fecha_pago = null;
	public static int valor = 0;

	public control_historial_planilla(historial_planilla clase, consultas_historial_planilla consulta,
			registro_nuevas_planillas formulario) {
		this.clase_historial_planilla = clase;
		this.consulta_historial_planilla = consulta;
		this.formulario_historial_planilla = formulario;
		this.formulario_historial_planilla.btnGuardar.addActionListener(this);
		this.formulario_historial_planilla.btnNuevo.addActionListener(this);
		this.formulario_historial_planilla.btnActualizar.addActionListener(this);
		this.formulario_historial_planilla.btnActualizarDatosPlanilla.addActionListener(this);
		this.formulario_historial_planilla.btnBorrarPlanilla.addActionListener(this);
		this.formulario_historial_planilla.btnVerPlanilla.addActionListener(this);
		this.formulario_historial_planilla.btnAceptar.addActionListener(this);
		this.formulario_historial_planilla.btnContinuar.addActionListener(this);
		this.formulario_historial_planilla.btnupanddown.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == formulario_historial_planilla.btnGuardar) {
			if (formulario_historial_planilla.txtNombrePlanilla.getText().isEmpty()
					|| formulario_historial_planilla.editor.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Porfavor llene los campos para crear la planilla!");
			} else {
				clase_historial_planilla
						.setEstado_planila(formulario_historial_planilla.txtEstadoPlanilla.getText().toString());
				clase_historial_planilla.setTipo_planilla_final(
						formulario_historial_planilla.cbxTipoPlanillaFinal.getSelectedItem().toString());
				clase_historial_planilla
						.setNombre_planilla_final(formulario_historial_planilla.txtNombrePlanilla.getText().toString());
				clase_historial_planilla
						.setFecha_crecion_planilla_final(formulario_historial_planilla.editor2.getText());
				clase_historial_planilla.setFecha_pago_planilla_final(formulario_historial_planilla.editor.getText());

				clase_historial_planilla.setTotal_deducciones_planilla_final(
						Double.parseDouble(formulario_historial_planilla.txtTotalDeducciones.getText().toString()));
				clase_historial_planilla.setTotal_bonificaciones_planilla_final(
						Double.parseDouble(formulario_historial_planilla.txtTotalBonos.getText().toString()));
				clase_historial_planilla.setTotal_sueldos_planilla_final(
						Double.parseDouble(formulario_historial_planilla.txtTotalSueldos.getText().toString()));

				clase_historial_planilla.setTotal_pago_planilla_final(
						Double.parseDouble(formulario_historial_planilla.txtTotalPlanilla.getText().toString()));

				if (consulta_historial_planilla.registrar(clase_historial_planilla)) {
					JOptionPane.showMessageDialog(null, "Exito! Datos de la panilla! Guardados.");
					limpiar();
					formulario_historial_planilla.construirTabla();
					formulario_historial_planilla.obtenerUltimoId();
					formulario_historial_planilla.establecerFechaRegistro();
					formulario_historial_planilla.iniciarEncero();

				} else {
					JOptionPane.showMessageDialog(null, "Error!  no Registrado");
					limpiar();
					formulario_historial_planilla.iniciarEncero();
				}
			}
		}

		if (e.getSource() == formulario_historial_planilla.btnActualizarDatosPlanilla) {
			int filaseleccionada;
			try {
				filaseleccionada = formulario_historial_planilla.tablaPlanilla.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					String codigo = formulario_historial_planilla.tablaPlanilla.getValueAt(filaseleccionada, 0)
							.toString();
					String tipo = formulario_historial_planilla.tablaPlanilla.getValueAt(filaseleccionada, 2)
							.toString();
					String estado = formulario_historial_planilla.tablaPlanilla.getValueAt(filaseleccionada, 1)
							.toString();
					String nombre = formulario_historial_planilla.tablaPlanilla.getValueAt(filaseleccionada, 3)
							.toString();
					String creacion = formulario_historial_planilla.tablaPlanilla.getValueAt(filaseleccionada, 4)
							.toString();
					String vencimiento = formulario_historial_planilla.tablaPlanilla.getValueAt(filaseleccionada, 5)
							.toString();
					String bonos = formulario_historial_planilla.tablaPlanilla.getValueAt(filaseleccionada, 6)
							.toString();
					String deduc = formulario_historial_planilla.tablaPlanilla.getValueAt(filaseleccionada, 7)
							.toString();
					String sueldos = formulario_historial_planilla.tablaPlanilla.getValueAt(filaseleccionada, 8)
							.toString();
					String total = formulario_historial_planilla.tablaPlanilla.getValueAt(filaseleccionada, 9)
							.toString();

					formulario_historial_planilla.txtCodigoPlanilla.setText(codigo);
					formulario_historial_planilla.cbxTipoPlanillaFinal.setSelectedItem(tipo);
					formulario_historial_planilla.txtEstadoPlanilla.setText(estado);
					formulario_historial_planilla.txtNombrePlanilla.setText(nombre);
					formulario_historial_planilla.editor2.setText(creacion);
					formulario_historial_planilla.editor.setText(vencimiento);
					formulario_historial_planilla.txtTotalDeducciones.setText(deduc);
					formulario_historial_planilla.txtTotalDeducciones.setText(bonos);
					formulario_historial_planilla.txtTotalSueldos.setText(sueldos);
					formulario_historial_planilla.txtTotalPlanilla.setText(total);

					formulario_historial_planilla.txtCodigoPlanilla.setForeground(Color.BLACK);
					formulario_historial_planilla.editor2.setForeground(Color.BLACK);
					formulario_historial_planilla.editor.setForeground(Color.BLACK);
					formulario_historial_planilla.txtNombrePlanilla.setForeground(Color.BLACK);
					formulario_historial_planilla.txtTotalDeducciones.setForeground(Color.BLACK);
					formulario_historial_planilla.txtTotalBonos.setForeground(Color.BLACK);
					formulario_historial_planilla.txtTotalSueldos.setForeground(Color.BLACK);
					formulario_historial_planilla.txtTotalPlanilla.setForeground(Color.BLACK);

					formulario_historial_planilla.btnBorrarPlanilla.setVisible(true);
					formulario_historial_planilla.btnGuardar.setVisible(false);
					formulario_historial_planilla.btnNuevo.setVisible(false);
					formulario_historial_planilla.btnActualizar.setVisible(true);
					formulario_historial_planilla.btnActualizarDatosPlanilla.setVisible(true);
					formulario_historial_planilla.btnVerPlanilla.setVisible(false);
					formulario_historial_planilla.btnAceptar.setText("Cancelar");
					formulario_historial_planilla.btnAceptar.setVisible(true);
					formulario_historial_planilla.txtNombrePlanilla.setEditable(true);

					formulario_historial_planilla.txtNombrePlanilla.requestFocusInWindow();

				}

			} catch (HeadlessException ex) {
				JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInt�ntelo nuevamente",
						" .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);
			}
		}

		if (e.getSource() == formulario_historial_planilla.btnVerPlanilla) {
			int filaseleccionada;
			try {
				filaseleccionada = formulario_historial_planilla.tablaPlanilla.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
					formulario_historial_planilla.txtNombrePlanilla.setText(null);
				} else {
					String codigo = formulario_historial_planilla.tablaPlanilla.getValueAt(filaseleccionada, 0)
							.toString();
					String tipo = formulario_historial_planilla.tablaPlanilla.getValueAt(filaseleccionada, 2)
							.toString();
					String estado = formulario_historial_planilla.tablaPlanilla.getValueAt(filaseleccionada, 1)
							.toString();
					String nombre = formulario_historial_planilla.tablaPlanilla.getValueAt(filaseleccionada, 3)
							.toString();
					String creacion = formulario_historial_planilla.tablaPlanilla.getValueAt(filaseleccionada, 4)
							.toString();
					String vencimiento = formulario_historial_planilla.tablaPlanilla.getValueAt(filaseleccionada, 5)
							.toString();
					String bonos = formulario_historial_planilla.tablaPlanilla.getValueAt(filaseleccionada, 6)
							.toString();
					String deduc = formulario_historial_planilla.tablaPlanilla.getValueAt(filaseleccionada, 7)
							.toString();
					String sueldos = formulario_historial_planilla.tablaPlanilla.getValueAt(filaseleccionada, 8)
							.toString();
					String total = formulario_historial_planilla.tablaPlanilla.getValueAt(filaseleccionada, 8)
							.toString();

					formulario_historial_planilla.txtCodigoPlanilla.setText(codigo);
					formulario_historial_planilla.cbxTipoPlanillaFinal.setSelectedItem(tipo);
					formulario_historial_planilla.txtEstadoPlanilla.setText(estado);
					formulario_historial_planilla.txtNombrePlanilla.setText(nombre);
					formulario_historial_planilla.editor2.setText(creacion);
					formulario_historial_planilla.editor.setText(vencimiento);
					formulario_historial_planilla.txtTotalDeducciones.setText(deduc);
					formulario_historial_planilla.txtTotalDeducciones.setText(bonos);
					formulario_historial_planilla.txtTotalSueldos.setText(sueldos);
					formulario_historial_planilla.txtTotalPlanilla.setText(total);

					formulario_historial_planilla.txtCodigoPlanilla.setForeground(Color.BLACK);
					formulario_historial_planilla.editor2.setForeground(Color.BLACK);
					formulario_historial_planilla.editor.setForeground(Color.BLACK);
					formulario_historial_planilla.txtNombrePlanilla.setForeground(Color.BLACK);
					formulario_historial_planilla.txtTotalDeducciones.setForeground(Color.BLACK);
					formulario_historial_planilla.txtTotalBonos.setForeground(Color.BLACK);
					formulario_historial_planilla.txtTotalPlanilla.setForeground(Color.BLACK);
					formulario_historial_planilla.txtTotalSueldos.setForeground(Color.BLACK);

					formulario_historial_planilla.btnBorrarPlanilla.setVisible(false);
					formulario_historial_planilla.btnGuardar.setVisible(false);
					formulario_historial_planilla.btnNuevo.setVisible(false);
					formulario_historial_planilla.btnActualizar.setVisible(false);
					formulario_historial_planilla.btnActualizarDatosPlanilla.setVisible(false);
					formulario_historial_planilla.btnAceptar.setText("Aceptar");
					formulario_historial_planilla.btnAceptar.setVisible(true);
					formulario_historial_planilla.btnActualizar.setVisible(false);
					formulario_historial_planilla.txtNombrePlanilla.setEditable(false);

				}

			} catch (HeadlessException ex) {
				JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInt�ntelo nuevamente",
						" .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);
			}
		}

		if (e.getSource() == formulario_historial_planilla.btnActualizar) {
			if (formulario_historial_planilla.txtNombrePlanilla.getText().isEmpty()
					|| formulario_historial_planilla.editor.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Porfavor llene los campos para actualizar la planilla!");
			} else {
				LocalDate date1 = LocalDate.now();
				Date fechaActual = Date.from(date1.atStartOfDay(ZoneId.systemDefault()).toInstant());
				Date fechaDePago = formulario_historial_planilla.datePago.getDate();
				switch (fechaDePago.compareTo(fechaActual)) {
				case 1:
					valor = 1;
					break;
				case 0:
					valor = 0;
					break;
				case -1:
					valor = -1;
					break;
				}

				if (valor == 1 || valor == 0) {
					clase_historial_planilla.setId_planilla_final(
							Integer.parseInt(formulario_historial_planilla.txtCodigoPlanilla.getText()));
					clase_historial_planilla
							.setEstado_planila(formulario_historial_planilla.txtEstadoPlanilla.getText().toString());
					clase_historial_planilla.setTipo_planilla_final(
							formulario_historial_planilla.cbxTipoPlanillaFinal.getSelectedItem().toString());
					clase_historial_planilla.setNombre_planilla_final(
							formulario_historial_planilla.txtNombrePlanilla.getText().toString());
					clase_historial_planilla
							.setFecha_crecion_planilla_final(formulario_historial_planilla.editor2.getText());
					clase_historial_planilla
							.setFecha_pago_planilla_final(formulario_historial_planilla.editor.getText());

					clase_historial_planilla.setTotal_deducciones_planilla_final(
							Double.parseDouble(formulario_historial_planilla.txtTotalDeducciones.getText()));
					clase_historial_planilla.setTotal_bonificaciones_planilla_final(
							Double.parseDouble(formulario_historial_planilla.txtTotalBonos.getText()));
					clase_historial_planilla.setTotal_sueldos_planilla_final(
							Double.parseDouble(formulario_historial_planilla.txtTotalSueldos.getText().toString()));

					clase_historial_planilla.setTotal_pago_planilla_final(
							Double.parseDouble(formulario_historial_planilla.txtTotalPlanilla.getText()));

					if (consulta_historial_planilla.modificar(clase_historial_planilla)) {
						JOptionPane.showMessageDialog(null, "Exito! Datos de la panilla! Actualizados.");
						limpiar();
						formulario_historial_planilla.construirTabla();
						formulario_historial_planilla.obtenerUltimoId();
						formulario_historial_planilla.establecerFechaRegistro();
						formulario_historial_planilla.iniciarEncero();

					} else {
						JOptionPane.showMessageDialog(null, "Error!  no Actualizado");
						limpiar();
					}

				} else {
					JOptionPane.showMessageDialog(null, "No puede actualizar esta planilla, Esta Cerrada!");
				}

			}
		}

		if (e.getSource() == formulario_historial_planilla.btnBorrarPlanilla) {
			PreparedStatement ps = null;
			int filaseleccionada;
			try {
				filaseleccionada = formulario_historial_planilla.tablaPlanilla.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					if (login_usuario.cargoUsuario.toString() == "Usuario Avanzado") {

						conexion objCon = new conexion();
						Connection conn = objCon.getConexion();
						int Fila = formulario_historial_planilla.tablaPlanilla.getSelectedRow();
						String codigo = formulario_historial_planilla.tablaPlanilla.getValueAt(Fila, 0).toString();
						ps = conn.prepareStatement("DELETE FROM historial_planillas WHERE id_planilla_final=?");
						ps.setString(1, codigo);
						ps.execute();
						JOptionPane.showMessageDialog(null, "Planilla Eliminada!");
						limpiar();
						formulario_historial_planilla.construirTabla();
						formulario_historial_planilla.btnActualizar.setVisible(false);
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

		if (e.getSource() == formulario_historial_planilla.btnContinuar) {
			int filaseleccionada;
			filaseleccionada = formulario_historial_planilla.tablaPlanilla.getSelectedRow();
			if (filaseleccionada == -1) {
				JOptionPane.showMessageDialog(null, "Para continuar trabajando, seleccione una planilla.");
			} else {
				String codigo = formulario_historial_planilla.tablaPlanilla.getValueAt(filaseleccionada, 0).toString();
				String tipo = formulario_historial_planilla.tablaPlanilla.getValueAt(filaseleccionada, 2).toString();
				String estado = formulario_historial_planilla.tablaPlanilla.getValueAt(filaseleccionada, 1).toString();
				String nombre = formulario_historial_planilla.tablaPlanilla.getValueAt(filaseleccionada, 3).toString();
				String creacion = formulario_historial_planilla.tablaPlanilla.getValueAt(filaseleccionada, 4)
						.toString();
				String vencimiento = formulario_historial_planilla.tablaPlanilla.getValueAt(filaseleccionada, 5)
						.toString();
				String bonos = formulario_historial_planilla.tablaPlanilla.getValueAt(filaseleccionada, 6).toString();
				String deduc = formulario_historial_planilla.tablaPlanilla.getValueAt(filaseleccionada, 7).toString();
				String sueldos = formulario_historial_planilla.tablaPlanilla.getValueAt(filaseleccionada, 8).toString();
				String total = formulario_historial_planilla.tablaPlanilla.getValueAt(filaseleccionada, 8).toString();

				formulario_historial_planilla.txtCodigoPlanilla.setText(codigo);
				formulario_historial_planilla.cbxTipoPlanillaFinal.setSelectedItem(tipo);
				formulario_historial_planilla.txtEstadoPlanilla.setText(estado);
				formulario_historial_planilla.txtNombrePlanilla.setText(nombre);
				formulario_historial_planilla.editor2.setText(creacion);
				formulario_historial_planilla.editor.setText(vencimiento);
				formulario_historial_planilla.txtTotalDeducciones.setText(deduc);
				formulario_historial_planilla.txtTotalDeducciones.setText(bonos);
				formulario_historial_planilla.txtTotalSueldos.setText(sueldos);
				formulario_historial_planilla.txtTotalPlanilla.setText(total);

				formulario_historial_planilla.txtCodigoPlanilla.setForeground(Color.BLACK);
				formulario_historial_planilla.editor2.setForeground(Color.BLACK);
				formulario_historial_planilla.editor.setForeground(Color.BLACK);
				formulario_historial_planilla.txtNombrePlanilla.setForeground(Color.BLACK);
				formulario_historial_planilla.txtTotalDeducciones.setForeground(Color.BLACK);
				formulario_historial_planilla.txtTotalBonos.setForeground(Color.BLACK);
				formulario_historial_planilla.txtTotalPlanilla.setForeground(Color.BLACK);
				formulario_historial_planilla.txtTotalSueldos.setForeground(Color.BLACK);

				formulario_historial_planilla.btnBorrarPlanilla.setVisible(false);
				formulario_historial_planilla.btnGuardar.setVisible(false);
				formulario_historial_planilla.btnNuevo.setVisible(false);
				formulario_historial_planilla.btnActualizar.setVisible(false);
				formulario_historial_planilla.btnActualizarDatosPlanilla.setVisible(false);
				formulario_historial_planilla.btnAceptar.setText("Aceptar");
				formulario_historial_planilla.btnAceptar.setVisible(true);
				formulario_historial_planilla.btnActualizar.setVisible(false);
				formulario_historial_planilla.txtNombrePlanilla.setEditable(false);

				LocalDate date1 = LocalDate.now();
				Date fechaActual = Date.from(date1.atStartOfDay(ZoneId.systemDefault()).toInstant());
				Date fechaDePago = formulario_historial_planilla.datePago.getDate();
				switch (fechaDePago.compareTo(fechaActual)) {
				case 1:
					valor = 1;
					break;
				case 0:
					valor = 0;
					break;
				case -1:
					valor = -1;
					break;
				}

				if (valor == 1 || valor == 0) {
					planilla clase = new planilla();
					historial_planilla clase2 = new historial_planilla();
					consultas_planilla consulta = new consultas_planilla();
					registro_planillas formulario = new registro_planillas();
					control_planilla control = new control_planilla(clase, clase2, consulta, formulario);
					formulario.setVisible(true);
					formulario.setLocationRelativeTo(null);
					registro_planillas.txtIdentidadEmpleadoPlanilla.requestFocusInWindow();
					formulario.btnBorrarPlanilla.setVisible(false);
					formulario.btnGuardar.setVisible(true);
					formulario.btnNuevo.setVisible(true);
					formulario.btnActualizar.setVisible(false);
					formulario.btnActualizarDatosPlanilla.setVisible(true);
					formulario.btnVerPlanilla.setVisible(true);
					formulario.btnAceptar.setVisible(false);
					formulario.consultarPlanillaActual();
					formulario.obtenerUltimoId();
					formulario.establecerFechaRegistro();
					formulario.pistas();
					Timer time = new Timer();
					time.schedule(formulario.tarea, 0, 1000);
					formulario.setTitle("Sesi�n iniciada por: " + login_usuario.nombreCompletoUsuario);
					registro_planillas.txtCodigoPlanillaNueva.setText(codigo);
					registro_planillas.lblNombrePlanillaNueva.setText(nombre);
					formulario.construirTabla();
					formulario.construirTablaEmpleados();
					formulario_historial_planilla.dispose();

				} else {
					formulario_historial_planilla.txtEstadoPlanilla.setText("Cerrada");
					formulario_historial_planilla.txtEstadoPlanilla.setBackground(Color.RED);
					int resp = JOptionPane.showConfirmDialog(null, "Planilla Cerrada!, Pero deseas sus detalles?");
					if (JOptionPane.OK_OPTION == resp) {
						planilla clase = new planilla();
						historial_planilla clase2 = new historial_planilla();
						consultas_planilla consulta = new consultas_planilla();
						registro_planillas formulario = new registro_planillas();
						control_planilla control = new control_planilla(clase, clase2, consulta, formulario);
						formulario.setVisible(true);
						formulario.setLocationRelativeTo(null);
						registro_planillas.txtIdentidadEmpleadoPlanilla.requestFocusInWindow();
						formulario.btnBorrarPlanilla.setVisible(false);
						formulario.btnGuardar.setVisible(true);
						formulario.btnNuevo.setVisible(true);
						formulario.btnActualizar.setVisible(false);
						formulario.btnActualizarDatosPlanilla.setVisible(true);
						formulario.btnVerPlanilla.setVisible(true);
						formulario.btnAceptar.setVisible(false);
						formulario.consultarPlanillaActual();
						formulario.obtenerUltimoId();
						formulario.establecerFechaRegistro();
						formulario.pistas();
						Timer time = new Timer();
						time.schedule(formulario.tarea, 0, 1000);
						formulario.setTitle("Sesi�n iniciada por: " + login_usuario.nombreCompletoUsuario);
						registro_planillas.txtCodigoPlanillaNueva.setText(codigo);
						registro_planillas.lblNombrePlanillaNueva.setText(nombre);
						formulario.construirTabla();
						formulario.construirTablaEmpleados();
						formulario.btnNuevo.setVisible(false);
						formulario.btnGuardar.setVisible(false);
						formulario.btnActualizarDatosPlanilla.setVisible(false);
						formulario.btnGuardarPlanilla.setVisible(false);
						formulario_historial_planilla.dispose();
					}

				}

			}
		}

		if (e.getSource() == formulario_historial_planilla.btnNuevo) {
			limpiar();
			formulario_historial_planilla.iniciarEncero();
			formulario_historial_planilla.obtenerUltimoId();
			formulario_historial_planilla.btnBorrarPlanilla.setVisible(false);
			formulario_historial_planilla.btnGuardar.setVisible(true);
			formulario_historial_planilla.btnVerPlanilla.setVisible(true);
			formulario_historial_planilla.btnNuevo.setVisible(true);
			formulario_historial_planilla.btnActualizar.setVisible(false);
			formulario_historial_planilla.btnActualizarDatosPlanilla.setVisible(true);
			formulario_historial_planilla.pistas();
			formulario_historial_planilla.construirTabla();
			formulario_historial_planilla.establecerFechaRegistro();
			formulario_historial_planilla.txtNombrePlanilla.requestFocusInWindow();
			formulario_historial_planilla.txtNombrePlanilla.setEditable(true);
			formulario_historial_planilla.txtEstadoPlanilla.setText("Abierta");
			formulario_historial_planilla.txtEstadoPlanilla.setBackground(Color.GREEN);
			formulario_historial_planilla.iniciarEncero();

		}

		if (e.getSource() == formulario_historial_planilla.btnAceptar) {
			limpiar();
			limpiar();
			formulario_historial_planilla.iniciarEncero();
			formulario_historial_planilla.obtenerUltimoId();
			formulario_historial_planilla.btnBorrarPlanilla.setVisible(false);
			formulario_historial_planilla.btnGuardar.setVisible(true);
			formulario_historial_planilla.btnVerPlanilla.setVisible(true);
			formulario_historial_planilla.btnNuevo.setVisible(true);
			formulario_historial_planilla.btnAceptar.setVisible(false);
			formulario_historial_planilla.btnActualizar.setVisible(false);
			formulario_historial_planilla.btnActualizarDatosPlanilla.setVisible(true);
			formulario_historial_planilla.pistas();
			formulario_historial_planilla.iniciarEncero();
			formulario_historial_planilla.construirTabla();
			formulario_historial_planilla.establecerFechaRegistro();
			formulario_historial_planilla.txtNombrePlanilla.requestFocusInWindow();
			formulario_historial_planilla.txtNombrePlanilla.setEditable(true);
			formulario_historial_planilla.txtEstadoPlanilla.setText("Abierta");
			formulario_historial_planilla.txtEstadoPlanilla.setBackground(Color.GREEN);

		}

		if (e.getSource() == formulario_historial_planilla.btnupanddown) {
			if (formulario_historial_planilla.btnupanddown.isSelected()) {
				formulario_historial_planilla.construirTabla();
			} else {
				formulario_historial_planilla.construirTabla2();
			}
		}

	}

	public void limpiar() {
		formulario_historial_planilla.txtCodigoPlanilla.setText(null);
		formulario_historial_planilla.txtNombrePlanilla.setText(null);
		formulario_historial_planilla.editor.setText(null);
		formulario_historial_planilla.txtTotalDeducciones.setText(null);
		formulario_historial_planilla.txtTotalBonos.setText(null);
		formulario_historial_planilla.txtTotalPlanilla.setText(null);
		formulario_historial_planilla.iniciarEncero();
		formulario_historial_planilla.txtEstadoPlanilla.setText("Abierta");
		formulario_historial_planilla.txtEstadoPlanilla.setBackground(Color.GREEN);

	}

	public static ArrayList<historial_planilla> buscarUsuariosConMatriz() {
		conexion conex = new conexion();
		ArrayList<historial_planilla> miLista = new ArrayList<historial_planilla>();
		historial_planilla planilla;
		try {
			Statement estatuto = conex.getConexion().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT * FROM historial_planillas ORDER BY id_planilla_final DESC");

			while (rs.next()) {
				planilla = new historial_planilla();
				planilla.setId_planilla_final(Integer.parseInt(rs.getString("id_planilla_final")));
				planilla.setEstado_planila(rs.getString("estado_planilla"));
				planilla.setTipo_planilla_final(rs.getString("tipo_planilla_final"));
				planilla.setNombre_planilla_final(rs.getString("nombre_planilla_final"));
				planilla.setFecha_crecion_planilla_final(rs.getString("fecha_crecion_planilla_final"));
				planilla.setFecha_pago_planilla_final(rs.getString("fecha_pago_planilla_final"));
				planilla.setTotal_deducciones_planilla_final(
						Double.parseDouble(rs.getString("total_deducciones_planilla_final")));
				planilla.setTotal_bonificaciones_planilla_final(
						Double.parseDouble(rs.getString("total_bonificaciones_planilla_final")));
				planilla.setTotal_sueldos_planilla_final(
						Double.parseDouble(rs.getString("total_sueldos_planilla_final")));
				planilla.setTotal_pago_planilla_final(Double.parseDouble(rs.getString("total_pago_planilla_final")));
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

	public static ArrayList<historial_planilla> buscarUsuariosConMatriz2() {
		conexion conex = new conexion();
		ArrayList<historial_planilla> miLista = new ArrayList<historial_planilla>();
		historial_planilla planilla;
		try {
			Statement estatuto = conex.getConexion().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT * FROM historial_planillas");

			while (rs.next()) {
				planilla = new historial_planilla();
				planilla.setId_planilla_final(Integer.parseInt(rs.getString("id_planilla_final")));
				planilla.setEstado_planila(rs.getString("estado_planilla"));
				planilla.setTipo_planilla_final(rs.getString("tipo_planilla_final"));
				planilla.setNombre_planilla_final(rs.getString("nombre_planilla_final"));
				planilla.setFecha_crecion_planilla_final(rs.getString("fecha_crecion_planilla_final"));
				planilla.setFecha_pago_planilla_final(rs.getString("fecha_pago_planilla_final"));
				planilla.setTotal_deducciones_planilla_final(
						Double.parseDouble(rs.getString("total_deducciones_planilla_final")));
				planilla.setTotal_bonificaciones_planilla_final(
						Double.parseDouble(rs.getString("total_bonificaciones_planilla_final")));
				planilla.setTotal_sueldos_planilla_final(
						Double.parseDouble(rs.getString("total_sueldos_planilla_final")));
				planilla.setTotal_pago_planilla_final(Double.parseDouble(rs.getString("total_pago_planilla_final")));
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
		ArrayList<historial_planilla> miLista = buscarUsuariosConMatriz();
		String matrizInfo[][] = new String[miLista.size()][10];
		for (int i = 0; i < miLista.size(); i++) {
			matrizInfo[i][0] = miLista.get(i).getId_planilla_final() + "";
			matrizInfo[i][1] = miLista.get(i).getEstado_planila() + "";
			matrizInfo[i][2] = miLista.get(i).getTipo_planilla_final() + "";
			matrizInfo[i][3] = miLista.get(i).getNombre_planilla_final() + "";
			matrizInfo[i][4] = miLista.get(i).getFecha_crecion_planilla_final() + "";
			matrizInfo[i][5] = miLista.get(i).getFecha_pago_planilla_final() + "";
			matrizInfo[i][6] = miLista.get(i).getTotal_deducciones_planilla_final() + "";
			matrizInfo[i][7] = miLista.get(i).getTotal_bonificaciones_planilla_final() + "";
			matrizInfo[i][8] = miLista.get(i).getTotal_sueldos_planilla_final() + "";
			matrizInfo[i][9] = miLista.get(i).getTotal_pago_planilla_final() + "";

		}

		return matrizInfo;
	}

	public static String[][] obtenerMatriz2() {
		ArrayList<historial_planilla> miLista = buscarUsuariosConMatriz2();
		String matrizInfo[][] = new String[miLista.size()][10];
		for (int i = 0; i < miLista.size(); i++) {
			matrizInfo[i][0] = miLista.get(i).getId_planilla_final() + "";
			matrizInfo[i][1] = miLista.get(i).getEstado_planila() + "";
			matrizInfo[i][2] = miLista.get(i).getTipo_planilla_final() + "";
			matrizInfo[i][3] = miLista.get(i).getNombre_planilla_final() + "";
			matrizInfo[i][4] = miLista.get(i).getFecha_crecion_planilla_final() + "";
			matrizInfo[i][5] = miLista.get(i).getFecha_pago_planilla_final() + "";
			matrizInfo[i][6] = miLista.get(i).getTotal_deducciones_planilla_final() + "";
			matrizInfo[i][7] = miLista.get(i).getTotal_bonificaciones_planilla_final() + "";
			matrizInfo[i][8] = miLista.get(i).getTotal_sueldos_planilla_final() + "";
			matrizInfo[i][9] = miLista.get(i).getTotal_pago_planilla_final() + "";

		}

		return matrizInfo;
	}

}
