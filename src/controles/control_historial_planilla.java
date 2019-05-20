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
import consultas.consultas_historial_planilla;
import consultas.consultas_planilla;
import formularios.registro_nuevas_planillas;
import formularios.registro_planillas;

public class control_historial_planilla implements ActionListener {

	public historial_planilla clase_historial_planilla;
	public consultas_historial_planilla consulta_historial_planilla;
	public registro_nuevas_planillas formulario_historial_planilla;
	public control_historial_planilla(historial_planilla clase, consultas_historial_planilla consulta, registro_nuevas_planillas formulario) {
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
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == formulario_historial_planilla.btnGuardar) {
			if (formulario_historial_planilla.txtNombrePlanilla.getText().isEmpty()
					|| formulario_historial_planilla.editor.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Porfavor llene los campos para crear la planilla!");
			} else {
					clase_historial_planilla.setEstado_planila(formulario_historial_planilla.cbxEstadoPlanilla.getSelectedItem().toString());
					clase_historial_planilla.setTipo_planilla_final(formulario_historial_planilla.cbxTipoPlanillaFinal.getSelectedItem().toString());
					clase_historial_planilla.setNombre_planilla_final(formulario_historial_planilla.txtNombrePlanilla.getText().toString());
					clase_historial_planilla.setFecha_crecion_planilla_final(formulario_historial_planilla.editor2.getText());
					clase_historial_planilla.setFecha_pago_planilla_final(formulario_historial_planilla.editor.getText());

					clase_historial_planilla.setTotal_deducciones_planilla_final(
							Double.parseDouble(formulario_historial_planilla.txtTotalDeducciones.getText().toString()));
					clase_historial_planilla.setTotal_bonificaciones_planilla_final(
							Double.parseDouble(formulario_historial_planilla.txtTotalBonos.getText().toString()));
					clase_historial_planilla.setTotal_pago_planilla_final(
							Double.parseDouble(formulario_historial_planilla.txtTotalPlanilla.getText().toString()));

					if (consulta_historial_planilla.registrar(clase_historial_planilla)) {
						JOptionPane.showMessageDialog(null, "Exito! Empleado agregado a la panilla!");
						limpiar();
						formulario_historial_planilla.construirTabla();
						formulario_historial_planilla.obtenerUltimoId();
						formulario_historial_planilla.establecerFechaRegistro();

					} else {
						JOptionPane.showMessageDialog(null, "Error!  no Registrado");
						limpiar();
					}
			}
		}

		/*
		if (e.getSource() == formulario_historial_planilla.btnActualizarDatosPlanilla) {
			int filaseleccionada;
			try {
				filaseleccionada = formulario_historial_planilla.tablaPlanilla.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					String codigo = formulario_historial_planilla.tablaPlanilla.getValueAt(filaseleccionada, 0).toString();
					String tipo = formulario_historial_planilla.tablaPlanilla.getValueAt(filaseleccionada, 1).toString();
					String fecha = formulario_historial_planilla.tablaPlanilla.getValueAt(filaseleccionada, 2).toString();
					String nombres = formulario_historial_planilla.tablaPlanilla.getValueAt(filaseleccionada, 3).toString();
					String apellidos = formulario_historial_planilla.tablaPlanilla.getValueAt(filaseleccionada, 4).toString();
					String identidad = formulario_historial_planilla.tablaPlanilla.getValueAt(filaseleccionada, 5).toString();
					String cargo = formulario_historial_planilla.tablaPlanilla.getValueAt(filaseleccionada, 6).toString();
					String sueldob = formulario_historial_planilla.tablaPlanilla.getValueAt(filaseleccionada, 7).toString();
					String deduc = formulario_historial_planilla.tablaPlanilla.getValueAt(filaseleccionada, 8).toString();
					String bonif = formulario_historial_planilla.tablaPlanilla.getValueAt(filaseleccionada, 9).toString();
					String sueldon = formulario_historial_planilla.tablaPlanilla.getValueAt(filaseleccionada, 10).toString();
					String total = formulario_historial_planilla.tablaPlanilla.getValueAt(filaseleccionada, 11).toString();

					formulario_historial_planilla.txtCodigo.setText(codigo);
					formulario_historial_planilla.cbxTipoPlanilla.setSelectedItem(tipo);
					formulario_historial_planilla.editor.setText(fecha);
					formulario_historial_planilla.txtNombresPlanilla.setText(nombres);
					formulario_historial_planilla.txtApellidosPlanilla.setText(apellidos);
					formulario_historial_planilla.txtIdentidadPlanilla.setText(identidad);
					formulario_historial_planilla.txtCargoPlanilla.setText(cargo);
					registro_planillas.txtCantidadPlanilla.setText(sueldob);
					registro_planillas.txtTotalDeduccionesPlanilla.setText(deduc);
					registro_planillas.txtTotalBonificacionesPlanilla.setText(bonif);
					registro_planillas.txtSueldoNetoPlanilla.setText(sueldon);
					registro_planillas.txtTotalPagoEmpleado.setText(total);

					formulario_historial_planilla.txtCodigoPlanilla.setForeground(Color.BLACK);
					formulario_historial_planilla.cbxTipoPlanilla.setForeground(Color.BLACK);
					formulario_historial_planilla.txtNombresPlanilla.setForeground(Color.BLACK);
					formulario_historial_planilla.txtApellidosPlanilla.setForeground(Color.BLACK);
					formulario_historial_planilla.txtIdentidadPlanilla.setForeground(Color.BLACK);
					formulario_historial_planilla.editor.setForeground(Color.BLACK);

					formulario_historial_planilla.btnBorrarPlanilla.setVisible(true);
					formulario_historial_planilla.btnGuardar.setVisible(false);
					formulario_historial_planilla.btnNuevo.setVisible(false);
					formulario_historial_planilla.btnActualizar.setVisible(true);
					formulario_historial_planilla.btnActualizarDatosPlanilla.setVisible(true);
					formulario_historial_planilla.btnVerPlanilla.setVisible(false);
					formulario_historial_planilla.btnAceptar.setText("Cancelar");
					formulario_historial_planilla.btnAceptar.setVisible(true);

					formulario_historial_planilla.txtIdentidadEmpleadoPlanilla.requestFocusInWindow();

				}

			} catch (HeadlessException ex) {
				JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente",
						" .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);
			}
		}

		if (e.getSource() == formulario_historial_planilla.btnVerPlanilla) {
			int filaseleccionada;
			try {
				filaseleccionada = formulario_historial_planilla.tablaPlanilla.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
					formulario_historial_planilla.txtIdentidadEmpleadoPlanilla.setText(null);
				} else {
					String codigo = formulario_historial_planilla.tablaPlanilla.getValueAt(filaseleccionada, 0).toString();
					String tipo = formulario_historial_planilla.tablaPlanilla.getValueAt(filaseleccionada, 1).toString();
					String fecha = formulario_historial_planilla.tablaPlanilla.getValueAt(filaseleccionada, 2).toString();
					String nombres = formulario_historial_planilla.tablaPlanilla.getValueAt(filaseleccionada, 3).toString();
					String apellidos = formulario_historial_planilla.tablaPlanilla.getValueAt(filaseleccionada, 4).toString();
					String identidad = formulario_historial_planilla.tablaPlanilla.getValueAt(filaseleccionada, 5).toString();
					String cargo = formulario_historial_planilla.tablaPlanilla.getValueAt(filaseleccionada, 6).toString();
					String sueldob = formulario_historial_planilla.tablaPlanilla.getValueAt(filaseleccionada, 7).toString();
					String deduc = formulario_historial_planilla.tablaPlanilla.getValueAt(filaseleccionada, 8).toString();
					String bonif = formulario_historial_planilla.tablaPlanilla.getValueAt(filaseleccionada, 9).toString();
					String sueldon = formulario_historial_planilla.tablaPlanilla.getValueAt(filaseleccionada, 10).toString();
					String total = formulario_historial_planilla.tablaPlanilla.getValueAt(filaseleccionada, 11).toString();

					formulario_historial_planilla.txtCodigo.setText(codigo);
					formulario_historial_planilla.cbxTipoPlanilla.setSelectedItem(tipo);
					formulario_historial_planilla.editor.setText(fecha);
					formulario_historial_planilla.txtNombresPlanilla.setText(nombres);
					formulario_historial_planilla.txtApellidosPlanilla.setText(apellidos);
					formulario_historial_planilla.txtIdentidadPlanilla.setText(identidad);
					formulario_historial_planilla.txtCargoPlanilla.setText(cargo);
					registro_planillas.txtCantidadPlanilla.setText(sueldob);
					registro_planillas.txtTotalDeduccionesPlanilla.setText(deduc);
					registro_planillas.txtTotalBonificacionesPlanilla.setText(bonif);
					registro_planillas.txtSueldoNetoPlanilla.setText(sueldon);
					registro_planillas.txtTotalPagoEmpleado.setText(total);

					formulario_historial_planilla.txtCodigoPlanilla.setForeground(Color.BLACK);
					formulario_historial_planilla.cbxTipoPlanilla.setForeground(Color.BLACK);
					formulario_historial_planilla.txtNombresPlanilla.setForeground(Color.BLACK);
					formulario_historial_planilla.txtApellidosPlanilla.setForeground(Color.BLACK);
					formulario_planilla.txtIdentidadPlanilla.setForeground(Color.BLACK);
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

		if (e.getSource() == formulario_planilla.btnActualizar) {
			validarIdentidad();

			if (formulario_planilla.txtIdentidadEmpleadoPlanilla.getText().isEmpty()
					|| formulario_planilla.txtIdentidadPlanilla.getText().isEmpty()
					|| registro_planillas.txtCantidadPlanilla.getText().isEmpty()
					|| registro_planillas.txtTotalBonificacionesPlanilla.getText().isEmpty()
					|| registro_planillas.txtTotalDeduccionesPlanilla.getText().isEmpty()
					|| registro_planillas.txtTotalPagoEmpleado.getText().isEmpty()
					|| registro_planillas.txtCantidadPlanilla.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Porfavor llene los campos para guardar el pago!");

			} else {
					clase_planilla.setId_planilla(Integer.parseInt(formulario_planilla.txtCodigo.getText()));
					clase_planilla.setTipo_planilla(formulario_planilla.cbxTipoPlanilla.getSelectedItem().toString());
					clase_planilla.setFecha_planilla(formulario_planilla.editor.getText());
					clase_planilla.setNombres_planilla(formulario_planilla.txtNombresPlanilla.getText());
					clase_planilla.setApellidos_planilla(formulario_planilla.txtApellidosPlanilla.getText());
					clase_planilla.setIdentidad_planilla(formulario_planilla.txtIdentidadPlanilla.getText());
					clase_planilla.setCargo_planilla(formulario_planilla.txtCargoPlanilla.getText());
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
					clase_planilla.setId_planilla(Integer.parseInt(formulario_planilla.txtCodigo.getText()));

					if (consulta_planilla.modificar(clase_planilla)) {
						JOptionPane.showMessageDialog(null, "Datos del pago actualizados!");
						limpiar();
						formulario_planilla.construirTabla();
						formulario_planilla.obtenerUltimoId();
						formulario_planilla.btnActualizar.setVisible(false);
						final ImageIcon logo = new ImageIcon(
								usuario.getImage().getScaledInstance(formulario_planilla.lblFotoPlanilla.getWidth(),
										formulario_planilla.lblFotoPlanilla.getHeight(), Image.SCALE_DEFAULT));
						formulario_planilla.lblFotoPlanilla.setIcon(logo);
						formulario_planilla.txtBusquedaPlanilla.requestFocusInWindow();

					} else {
						JOptionPane.showMessageDialog(null, "Error!  no Actualizado");
						limpiar();
					}

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
							usuario.getImage().getScaledInstance(formulario_planilla.lblFotoPlanilla.getWidth(),
									formulario_planilla.lblFotoPlanilla.getHeight(), Image.SCALE_DEFAULT));
					formulario_planilla.lblFotoPlanilla.setIcon(logo);
					formulario_planilla.txtDireccionFoto.setText(null);

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
			formulario_planilla.txtIdentidadEmpleadoPlanilla.requestFocusInWindow();

			final ImageIcon logo = new ImageIcon(
					usuario.getImage().getScaledInstance(formulario_planilla.lblFotoPlanilla.getWidth(),
							formulario_planilla.lblFotoPlanilla.getHeight(), Image.SCALE_DEFAULT));
			formulario_planilla.lblFotoPlanilla.setIcon(logo);
			formulario_planilla.txtDireccionFoto.setText(null);

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
			formulario_planilla.txtIdentidadEmpleadoPlanilla.requestFocusInWindow();
			formulario_planilla.txtIdentidadEmpleadoPlanilla.setEditable(true);

			final ImageIcon logo = new ImageIcon(
					usuario.getImage().getScaledInstance(formulario_planilla.lblFotoPlanilla.getWidth(),
							formulario_planilla.lblFotoPlanilla.getHeight(), Image.SCALE_DEFAULT));
			formulario_planilla.lblFotoPlanilla.setIcon(logo);
			formulario_planilla.txtDireccionFoto.setText(null);

		}
		
		//------------------------------------------------------------------------------------------------//

*/
	}

	public void limpiar() {
		formulario_historial_planilla.txtCodigoPlanilla.setText(null);
		formulario_historial_planilla.txtNombrePlanilla.setText(null);
		formulario_historial_planilla.editor.setText(null);
		formulario_historial_planilla.txtTotalDeducciones.setText(null);
		formulario_historial_planilla.txtTotalBonos.setText(null);
		formulario_historial_planilla.txtTotalPlanilla.setText(null);
		
	}

	public static ArrayList<historial_planilla> buscarUsuariosConMatriz() {
		conexion conex = new conexion();
		ArrayList<historial_planilla> miLista = new ArrayList<historial_planilla>();
		historial_planilla planilla;
		try {
			Statement estatuto = conex.getConexion().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT * FROM historial_planillas");

			while (rs.next()) {
				planilla = new historial_planilla();
				planilla.setId_planilla_final(Integer.parseInt(rs.getString("id_planilla_final")));
				planilla.setEstado_planila(rs.getString("estado_planila"));
				planilla.setTipo_planilla_final(rs.getString("tipo_planilla_final"));
				planilla.setNombre_planilla_final(rs.getString("nombre_planilla_final"));
				planilla.setFecha_crecion_planilla_final(rs.getString("fecha_crecion_planilla_final"));
				planilla.setFecha_pago_planilla_final(rs.getString("fecha_pago_planilla_final"));
				planilla.setTotal_deducciones_planilla_final(Double.parseDouble(rs.getString("total_deducciones_planilla_final")));
				planilla.setTotal_bonificaciones_planilla_final(Double.parseDouble(rs.getString("total_bonificaciones_planilla_final")));
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
		String matrizInfo[][] = new String[miLista.size()][9];
		for (int i = 0; i < miLista.size(); i++) {
			matrizInfo[i][0] = miLista.get(i).getId_planilla_final() + "";
			matrizInfo[i][1] = miLista.get(i).getEstado_planila() + "";
			matrizInfo[i][2] = miLista.get(i).getTipo_planilla_final() + "";
			matrizInfo[i][3] = miLista.get(i).getNombre_planilla_final() + "";
			matrizInfo[i][4] = miLista.get(i).getFecha_crecion_planilla_final() + "";
			matrizInfo[i][5] = miLista.get(i).getFecha_pago_planilla_final() + "";
			matrizInfo[i][6] = miLista.get(i).getTotal_deducciones_planilla_final() + "";
			matrizInfo[i][7] = miLista.get(i).getTotal_bonificaciones_planilla_final() + "";
			matrizInfo[i][8] = miLista.get(i).getTotal_pago_planilla_final() + "";
		
		}

		return matrizInfo;
	}
		

}
