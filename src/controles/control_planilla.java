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

import clases.planilla;
import conexion.conexion;
import consultas.consultas_planilla;
import formularios.registro_nuevas_planillas;
import formularios.registro_planillas;

public class control_planilla implements ActionListener {

	public planilla clase_planilla;
	public consultas_planilla consulta_planilla;
	public registro_planillas formulario_planilla;
	public ImageIcon usuario = new ImageIcon(getClass().getResource("/iconos/usuario.png"));
	public static String identidad = null;

	public control_planilla(planilla clase, consultas_planilla consulta, registro_planillas formulario) {
		this.clase_planilla = clase;
		this.consulta_planilla = consulta;
		this.formulario_planilla = formulario;
		this.formulario_planilla.btnGuardar.addActionListener(this);
		this.formulario_planilla.btnNuevo.addActionListener(this);
		this.formulario_planilla.btnActualizar.addActionListener(this);
		this.formulario_planilla.btnActualizarDatosPlanilla.addActionListener(this);
		this.formulario_planilla.btnBorrarPlanilla.addActionListener(this);
		this.formulario_planilla.btnVerPlanilla.addActionListener(this);
		this.formulario_planilla.btnAceptar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == formulario_planilla.btnGuardar) {
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
				if (formulario_planilla.txtIdentidadPlanilla.getText().toString().equals(identidad)) {
					JOptionPane.showMessageDialog(null, "Se encontrado un registro con esta identidad : " + identidad,
							"Atencion datos duplicados", JOptionPane.INFORMATION_MESSAGE);
				} else {
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

					if (consulta_planilla.registrar(clase_planilla)) {
						JOptionPane.showMessageDialog(null, "Exito! Empleado agregado a la panilla!");
						limpiar();
						formulario_planilla.construirTabla();
						formulario_planilla.obtenerUltimoId();
						formulario_planilla.establecerFechaRegistro();

						final ImageIcon logo = new ImageIcon(
								usuario.getImage().getScaledInstance(formulario_planilla.lblFotoPlanilla.getWidth(),
										formulario_planilla.lblFotoPlanilla.getHeight(), Image.SCALE_DEFAULT));
						formulario_planilla.lblFotoPlanilla.setIcon(logo);
						formulario_planilla.txtDireccionFoto.setText(null);
						formulario_planilla.lblFotoPlanilla.setText(null);
						formulario_planilla.lblFotoPlanilla.requestFocusInWindow();

					} else {
						JOptionPane.showMessageDialog(null, "Error!  no Registrado");
						limpiar();
					}
				}
			}
		}

		if (e.getSource() == formulario_planilla.btnActualizarDatosPlanilla) {
			int filaseleccionada;
			try {
				filaseleccionada = formulario_planilla.tablaPlanilla.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
					formulario_planilla.txtIdentidadEmpleadoPlanilla.setText(null);
				} else {
					String codigo = formulario_planilla.tablaPlanilla.getValueAt(filaseleccionada, 0).toString();
					String tipo = formulario_planilla.tablaPlanilla.getValueAt(filaseleccionada, 1).toString();
					String fecha = formulario_planilla.tablaPlanilla.getValueAt(filaseleccionada, 2).toString();
					String nombres = formulario_planilla.tablaPlanilla.getValueAt(filaseleccionada, 3).toString();
					String apellidos = formulario_planilla.tablaPlanilla.getValueAt(filaseleccionada, 4).toString();
					String identidad = formulario_planilla.tablaPlanilla.getValueAt(filaseleccionada, 5).toString();
					String cargo = formulario_planilla.tablaPlanilla.getValueAt(filaseleccionada, 6).toString();
					String sueldob = formulario_planilla.tablaPlanilla.getValueAt(filaseleccionada, 7).toString();
					String deduc = formulario_planilla.tablaPlanilla.getValueAt(filaseleccionada, 8).toString();
					String bonif = formulario_planilla.tablaPlanilla.getValueAt(filaseleccionada, 9).toString();
					String sueldon = formulario_planilla.tablaPlanilla.getValueAt(filaseleccionada, 10).toString();
					String total = formulario_planilla.tablaPlanilla.getValueAt(filaseleccionada, 11).toString();

					formulario_planilla.txtCodigo.setText(codigo);
					formulario_planilla.editor.setText(fecha);
					formulario_planilla.txtNombresPlanilla.setText(nombres);
					formulario_planilla.txtApellidosPlanilla.setText(apellidos);
					formulario_planilla.txtIdentidadPlanilla.setText(identidad);
					formulario_planilla.txtCargoPlanilla.setText(cargo);
					registro_planillas.txtCantidadPlanilla.setText(sueldob);
					registro_planillas.txtTotalDeduccionesPlanilla.setText(deduc);
					registro_planillas.txtTotalBonificacionesPlanilla.setText(bonif);
					registro_planillas.txtSueldoNetoPlanilla.setText(sueldon);
					registro_planillas.txtTotalPagoEmpleado.setText(total);

					formulario_planilla.txtCodigoPlanilla.setForeground(Color.BLACK);
					formulario_planilla.txtNombresPlanilla.setForeground(Color.BLACK);
					formulario_planilla.txtApellidosPlanilla.setForeground(Color.BLACK);
					formulario_planilla.txtIdentidadPlanilla.setForeground(Color.BLACK);
					formulario_planilla.editor.setForeground(Color.BLACK);

					formulario_planilla.btnBorrarPlanilla.setVisible(true);
					formulario_planilla.btnGuardar.setVisible(false);
					formulario_planilla.btnNuevo.setVisible(false);
					formulario_planilla.btnActualizar.setVisible(true);
					formulario_planilla.btnActualizarDatosPlanilla.setVisible(true);
					formulario_planilla.btnVerPlanilla.setVisible(false);
					formulario_planilla.btnAceptar.setText("Cancelar");
					formulario_planilla.btnAceptar.setVisible(true);

					formulario_planilla.txtIdentidadEmpleadoPlanilla.requestFocusInWindow();

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
					formulario_planilla.txtIdentidadEmpleadoPlanilla.setText(null);
				} else {
					String codigo = formulario_planilla.tablaPlanilla.getValueAt(filaseleccionada, 0).toString();
					String tipo = formulario_planilla.tablaPlanilla.getValueAt(filaseleccionada, 1).toString();
					String fecha = formulario_planilla.tablaPlanilla.getValueAt(filaseleccionada, 2).toString();
					String nombres = formulario_planilla.tablaPlanilla.getValueAt(filaseleccionada, 3).toString();
					String apellidos = formulario_planilla.tablaPlanilla.getValueAt(filaseleccionada, 4).toString();
					String identidad = formulario_planilla.tablaPlanilla.getValueAt(filaseleccionada, 5).toString();
					String cargo = formulario_planilla.tablaPlanilla.getValueAt(filaseleccionada, 6).toString();
					String sueldob = formulario_planilla.tablaPlanilla.getValueAt(filaseleccionada, 7).toString();
					String deduc = formulario_planilla.tablaPlanilla.getValueAt(filaseleccionada, 8).toString();
					String bonif = formulario_planilla.tablaPlanilla.getValueAt(filaseleccionada, 9).toString();
					String sueldon = formulario_planilla.tablaPlanilla.getValueAt(filaseleccionada, 10).toString();
					String total = formulario_planilla.tablaPlanilla.getValueAt(filaseleccionada, 11).toString();

					formulario_planilla.txtCodigo.setText(codigo);
					formulario_planilla.editor.setText(fecha);
					formulario_planilla.txtNombresPlanilla.setText(nombres);
					formulario_planilla.txtApellidosPlanilla.setText(apellidos);
					formulario_planilla.txtIdentidadPlanilla.setText(identidad);
					formulario_planilla.txtCargoPlanilla.setText(cargo);
					registro_planillas.txtCantidadPlanilla.setText(sueldob);
					registro_planillas.txtTotalDeduccionesPlanilla.setText(deduc);
					registro_planillas.txtTotalBonificacionesPlanilla.setText(bonif);
					registro_planillas.txtSueldoNetoPlanilla.setText(sueldon);
					registro_planillas.txtTotalPagoEmpleado.setText(total);

					formulario_planilla.txtCodigoPlanilla.setForeground(Color.BLACK);
					formulario_planilla.txtNombresPlanilla.setForeground(Color.BLACK);
					formulario_planilla.txtApellidosPlanilla.setForeground(Color.BLACK);
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

	}

	public void limpiar() {
		formulario_planilla.txtCodigo.setText(null);
		formulario_planilla.txtCodigoPlanilla.setText(null);
		formulario_planilla.txtNombresPlanilla.setText(null);
		formulario_planilla.txtApellidosPlanilla.setText(null);
		formulario_planilla.txtIdentidadPlanilla.setText(null);
		formulario_planilla.txtCargoPlanilla.setText(null);
		formulario_planilla.txtBusquedaPlanilla.setText(null);
		formulario_planilla.txtTotalPlanilla.setText(null);
		formulario_planilla.txtDireccionFoto.setText(null);
		registro_planillas.txtTotalPagoEmpleado.setText(null);
		registro_planillas.txtTotalBonificacionesPlanilla.setText(null);
		registro_planillas.txtTotalDeduccionesPlanilla.setText(null);
		registro_planillas.txtCantidadPlanilla.setText(null);
		registro_planillas.txtSueldoNetoPlanilla.setText(null);
		formulario_planilla.txtIdentidadEmpleadoPlanilla.setText(null);
	}

	public static ArrayList<planilla> buscarUsuariosConMatriz() {
		conexion conex = new conexion();
		ArrayList<planilla> miLista = new ArrayList<planilla>();
		planilla planilla;
		try {
			Statement estatuto = conex.getConexion().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT * FROM planillas");

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
		String matrizInfo[][] = new String[miLista.size()][11];
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
		}

		return matrizInfo;
	}

	public void validarIdentidad() {
		conexion conex = new conexion();
		try {
			Statement estatuto = conex.getConexion().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT identidad_planilla FROM planillas where identidad_planilla = '"
					+ formulario_planilla.txtIdentidadPlanilla.getText().toString() + "'");

			if (rs.next()) {
				identidad = (rs.getString("identidad_planilla"));
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
