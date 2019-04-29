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
import formularios.registro_planillas;

public class control_planilla implements ActionListener {

	public planilla clase;
	public consultas_planilla consulta;
	public registro_planillas formulario;
	public ImageIcon usuario = new ImageIcon(getClass().getResource("/material/usuario.png"));

	public control_planilla(planilla clase, consultas_planilla consulta, registro_planillas formulario) {
		this.clase = clase;
		this.consulta = consulta;
		this.formulario = formulario;
		this.formulario.btnGuardar.addActionListener(this);
		this.formulario.btnNuevo.addActionListener(this);
		this.formulario.btnActualizar.addActionListener(this);
		this.formulario.btnActualizarDatosPlanilla.addActionListener(this);
		this.formulario.btnBorrarPlanilla.addActionListener(this);
		this.formulario.btnVerPlanilla.addActionListener(this);
		this.formulario.btnAceptar.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == formulario.btnGuardar) {

			if (formulario.txtIdentidadEmpleadoPlanilla.getText().isEmpty()
					|| formulario.txtIdentidadPlanilla.getText().isEmpty()
					|| registro_planillas.txtCantidadPlanilla.getText().isEmpty()
					|| registro_planillas.txtTotalBonificacionesPlanilla.getText().isEmpty()
					|| registro_planillas.txtTotalDeduccionesPlanilla.getText().isEmpty()
					|| registro_planillas.txtTotalPagoEmpleado.getText().isEmpty()
					|| registro_planillas.txtCantidadPlanilla.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Porfavor llene los campos para guardar en la planilla!");

			} else {
				clase.setTipo_planilla(formulario.cbxTipoPlanilla.getSelectedItem().toString());
				clase.setFecha_planilla(formulario.editor.getText());
				clase.setNombres_planilla(formulario.txtNombresPlanilla.getText());
				clase.setApellidos_planilla(formulario.txtApellidosPlanilla.getText());
				clase.setIdentidad_planilla(formulario.txtIdentidadPlanilla.getText());
				clase.setCargo_planilla(formulario.txtCargoPlanilla.getText());
				clase.setSueldo_bruto_planilla(Double.parseDouble(registro_planillas.txtCantidadPlanilla.getText()));
				clase.setTotal_deducciones_planilla(
						Double.parseDouble(registro_planillas.txtTotalDeduccionesPlanilla.getText()));
				clase.setTotal_bonificaciones_planilla(
						Double.parseDouble(registro_planillas.txtTotalBonificacionesPlanilla.getText()));
				clase.setSueldo_neto_planilla(Double.parseDouble(registro_planillas.txtSueldoNetoPlanilla.getText()));
				clase.setTotal_apagar_planilla(Double.parseDouble(registro_planillas.txtTotalPagoEmpleado.getText()));

				if (consulta.registrar(clase)) {
					JOptionPane.showMessageDialog(null, "Exito! Empleado agregado a la panilla!");
					limpiar();
					formulario.construirTabla();
					formulario.obtenerUltimoId();
					formulario.establecerFechaRegistro();

					final ImageIcon logo = new ImageIcon(
							usuario.getImage().getScaledInstance(formulario.lblFotoPlanilla.getWidth(),
									formulario.lblFotoPlanilla.getHeight(), Image.SCALE_DEFAULT));
					formulario.lblFotoPlanilla.setIcon(logo);
					formulario.txtDireccionFoto.setText(null);
					formulario.lblFotoPlanilla.setText(null);
					formulario.lblFotoPlanilla.requestFocusInWindow();

				} else {
					JOptionPane.showMessageDialog(null, "Error!  no Registrado");
					limpiar();
				}
			}
		}

		if (e.getSource() == formulario.btnActualizarDatosPlanilla) {
			int filaseleccionada;
			try {
				filaseleccionada = formulario.tablaPlanilla.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
					formulario.txtIdentidadEmpleadoPlanilla.setText(null);
				} else {
					String codigo = formulario.tablaPlanilla.getValueAt(filaseleccionada, 0).toString();
					String tipo = formulario.tablaPlanilla.getValueAt(filaseleccionada, 1).toString();
					String fecha = formulario.tablaPlanilla.getValueAt(filaseleccionada, 2).toString();
					String nombres = formulario.tablaPlanilla.getValueAt(filaseleccionada, 3).toString();
					String apellidos = formulario.tablaPlanilla.getValueAt(filaseleccionada, 4).toString();
					String identidad = formulario.tablaPlanilla.getValueAt(filaseleccionada, 5).toString();
					String cargo = formulario.tablaPlanilla.getValueAt(filaseleccionada, 6).toString();
					String sueldob = formulario.tablaPlanilla.getValueAt(filaseleccionada, 7).toString();
					String deduc = formulario.tablaPlanilla.getValueAt(filaseleccionada, 8).toString();
					String bonif = formulario.tablaPlanilla.getValueAt(filaseleccionada, 9).toString();
					String sueldon = formulario.tablaPlanilla.getValueAt(filaseleccionada, 10).toString();
					String total = formulario.tablaPlanilla.getValueAt(filaseleccionada, 11).toString();

					formulario.txtCodigo.setText(codigo);
					formulario.cbxTipoPlanilla.setSelectedItem(tipo);
					formulario.editor.setText(fecha);
					formulario.txtNombresPlanilla.setText(nombres);
					formulario.txtApellidosPlanilla.setText(apellidos);
					formulario.txtIdentidadPlanilla.setText(identidad);
					formulario.txtCargoPlanilla.setText(cargo);
					registro_planillas.txtCantidadPlanilla.setText(sueldob);
					registro_planillas.txtTotalDeduccionesPlanilla.setText(deduc);
					registro_planillas.txtTotalBonificacionesPlanilla.setText(bonif);
					registro_planillas.txtSueldoNetoPlanilla.setText(sueldon);
					registro_planillas.txtTotalPagoEmpleado.setText(total);

					formulario.txtCodigoPlanilla.setForeground(Color.BLACK);
					formulario.cbxTipoPlanilla.setForeground(Color.BLACK);
					formulario.txtNombresPlanilla.setForeground(Color.BLACK);
					formulario.txtApellidosPlanilla.setForeground(Color.BLACK);
					formulario.txtIdentidadPlanilla.setForeground(Color.BLACK);
					formulario.editor.setForeground(Color.BLACK);

					formulario.btnBorrarPlanilla.setVisible(true);
					formulario.btnGuardar.setVisible(false);
					formulario.btnNuevo.setVisible(false);
					formulario.btnActualizar.setVisible(true);
					formulario.btnActualizarDatosPlanilla.setVisible(true);
					formulario.btnVerPlanilla.setVisible(false);
					formulario.btnAceptar.setText("Cancelar");
					formulario.btnAceptar.setVisible(true);

					formulario.txtIdentidadEmpleadoPlanilla.requestFocusInWindow();

				}

			} catch (HeadlessException ex) {
				JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente",
						" .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);
			}
		}

		if (e.getSource() == formulario.btnVerPlanilla) {
			int filaseleccionada;
			try {
				filaseleccionada = formulario.tablaPlanilla.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
					formulario.txtIdentidadEmpleadoPlanilla.setText(null);
				} else {
					String codigo = formulario.tablaPlanilla.getValueAt(filaseleccionada, 0).toString();
					String tipo = formulario.tablaPlanilla.getValueAt(filaseleccionada, 1).toString();
					String fecha = formulario.tablaPlanilla.getValueAt(filaseleccionada, 2).toString();
					String nombres = formulario.tablaPlanilla.getValueAt(filaseleccionada, 3).toString();
					String apellidos = formulario.tablaPlanilla.getValueAt(filaseleccionada, 4).toString();
					String identidad = formulario.tablaPlanilla.getValueAt(filaseleccionada, 5).toString();
					String cargo = formulario.tablaPlanilla.getValueAt(filaseleccionada, 6).toString();
					String sueldob = formulario.tablaPlanilla.getValueAt(filaseleccionada, 7).toString();
					String deduc = formulario.tablaPlanilla.getValueAt(filaseleccionada, 8).toString();
					String bonif = formulario.tablaPlanilla.getValueAt(filaseleccionada, 9).toString();
					String sueldon = formulario.tablaPlanilla.getValueAt(filaseleccionada, 10).toString();
					String total = formulario.tablaPlanilla.getValueAt(filaseleccionada, 11).toString();

					formulario.txtCodigo.setText(codigo);
					formulario.cbxTipoPlanilla.setSelectedItem(tipo);
					formulario.editor.setText(fecha);
					formulario.txtNombresPlanilla.setText(nombres);
					formulario.txtApellidosPlanilla.setText(apellidos);
					formulario.txtIdentidadPlanilla.setText(identidad);
					formulario.txtCargoPlanilla.setText(cargo);
					registro_planillas.txtCantidadPlanilla.setText(sueldob);
					registro_planillas.txtTotalDeduccionesPlanilla.setText(deduc);
					registro_planillas.txtTotalBonificacionesPlanilla.setText(bonif);
					registro_planillas.txtSueldoNetoPlanilla.setText(sueldon);
					registro_planillas.txtTotalPagoEmpleado.setText(total);

					formulario.txtCodigoPlanilla.setForeground(Color.BLACK);
					formulario.cbxTipoPlanilla.setForeground(Color.BLACK);
					formulario.txtNombresPlanilla.setForeground(Color.BLACK);
					formulario.txtApellidosPlanilla.setForeground(Color.BLACK);
					formulario.txtIdentidadPlanilla.setForeground(Color.BLACK);
					formulario.editor.setForeground(Color.BLACK);

					formulario.btnBorrarPlanilla.setVisible(false);
					formulario.btnGuardar.setVisible(false);
					formulario.btnNuevo.setVisible(false);
					formulario.btnActualizar.setVisible(false);
					formulario.btnActualizarDatosPlanilla.setVisible(false);
					formulario.btnAceptar.setText("Aceptar");
					formulario.btnAceptar.setVisible(true);
					formulario.btnActualizar.setVisible(false);

				}

			} catch (HeadlessException ex) {
				JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente",
						" .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);
			}
		}

		if (e.getSource() == formulario.btnActualizar) {

			if (formulario.txtIdentidadEmpleadoPlanilla.getText().isEmpty()
					|| formulario.txtIdentidadPlanilla.getText().isEmpty()
					|| registro_planillas.txtCantidadPlanilla.getText().isEmpty()
					|| registro_planillas.txtTotalBonificacionesPlanilla.getText().isEmpty()
					|| registro_planillas.txtTotalDeduccionesPlanilla.getText().isEmpty()
					|| registro_planillas.txtTotalPagoEmpleado.getText().isEmpty()
					|| registro_planillas.txtCantidadPlanilla.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Porfavor llene los campos para guardar el pago!");

			} else {
				clase.setId_planilla(Integer.parseInt(formulario.txtCodigo.getText()));
				clase.setTipo_planilla(formulario.cbxTipoPlanilla.getSelectedItem().toString());
				clase.setFecha_planilla(formulario.editor.getText());
				clase.setNombres_planilla(formulario.txtNombresPlanilla.getText());
				clase.setApellidos_planilla(formulario.txtApellidosPlanilla.getText());
				clase.setIdentidad_planilla(formulario.txtIdentidadPlanilla.getText());
				clase.setCargo_planilla(formulario.txtCargoPlanilla.getText());
				clase.setSueldo_bruto_planilla(Double.parseDouble(registro_planillas.txtCantidadPlanilla.getText()));
				clase.setTotal_deducciones_planilla(
						Double.parseDouble(registro_planillas.txtTotalDeduccionesPlanilla.getText()));
				clase.setTotal_bonificaciones_planilla(
						Double.parseDouble(registro_planillas.txtTotalBonificacionesPlanilla.getText()));
				clase.setSueldo_neto_planilla(Double.parseDouble(registro_planillas.txtSueldoNetoPlanilla.getText()));
				clase.setTotal_apagar_planilla(Double.parseDouble(registro_planillas.txtTotalPagoEmpleado.getText()));
				clase.setId_planilla(Integer.parseInt(formulario.txtCodigo.getText()));

				if (consulta.modificar(clase)) {
					JOptionPane.showMessageDialog(null, "Datos del pago actualizados!");
					limpiar();
					formulario.construirTabla();
					formulario.obtenerUltimoId();
					formulario.btnActualizar.setVisible(false);
					final ImageIcon logo = new ImageIcon(
							usuario.getImage().getScaledInstance(formulario.lblFotoPlanilla.getWidth(),
									formulario.lblFotoPlanilla.getHeight(), Image.SCALE_DEFAULT));
					formulario.lblFotoPlanilla.setIcon(logo);
					formulario.txtBusquedaPlanilla.requestFocusInWindow();

				} else {
					JOptionPane.showMessageDialog(null, "Error!  no Actualizado");
					limpiar();
				}

			}
		}

		if (e.getSource() == formulario.btnBorrarPlanilla) {
			PreparedStatement ps = null;
			int filaseleccionada;
			try {
				filaseleccionada = formulario.tablaPlanilla.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					conexion objCon = new conexion();
					Connection conn = objCon.getConexion();
					int Fila = formulario.tablaPlanilla.getSelectedRow();
					String codigo = formulario.tablaPlanilla.getValueAt(Fila, 0).toString();
					ps = conn.prepareStatement("DELETE FROM planillas WHERE id_planilla=?");
					ps.setString(1, codigo);
					ps.execute();
					JOptionPane.showMessageDialog(null, "Pago de empleado Eliminado!");
					limpiar();
					formulario.construirTabla();
					formulario.btnActualizar.setVisible(false);

					final ImageIcon logo = new ImageIcon(
							usuario.getImage().getScaledInstance(formulario.lblFotoPlanilla.getWidth(),
									formulario.lblFotoPlanilla.getHeight(), Image.SCALE_DEFAULT));
					formulario.lblFotoPlanilla.setIcon(logo);
					formulario.txtDireccionFoto.setText(null);

				}
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "Error al eliminar deduccion");
				System.out.println(ex.toString());
			}
		}

		if (e.getSource() == formulario.btnNuevo) {
			limpiar();
			formulario.obtenerUltimoId();
			formulario.btnBorrarPlanilla.setVisible(false);
			formulario.btnGuardar.setVisible(true);
			formulario.btnVerPlanilla.setVisible(true);
			formulario.btnNuevo.setVisible(true);
			formulario.btnActualizar.setVisible(false);
			formulario.btnActualizarDatosPlanilla.setVisible(true);
			formulario.pistas();
			formulario.construirTabla();
			formulario.establecerFechaRegistro();
			formulario.txtIdentidadEmpleadoPlanilla.requestFocusInWindow();

			final ImageIcon logo = new ImageIcon(
					usuario.getImage().getScaledInstance(formulario.lblFotoPlanilla.getWidth(),
							formulario.lblFotoPlanilla.getHeight(), Image.SCALE_DEFAULT));
			formulario.lblFotoPlanilla.setIcon(logo);
			formulario.txtDireccionFoto.setText(null);

		}

		if (e.getSource() == formulario.btnAceptar) {
			limpiar();
			limpiar();
			formulario.obtenerUltimoId();
			formulario.btnBorrarPlanilla.setVisible(false);
			formulario.btnGuardar.setVisible(true);
			formulario.btnVerPlanilla.setVisible(true);
			formulario.btnNuevo.setVisible(true);
			formulario.btnAceptar.setVisible(false);
			formulario.btnActualizar.setVisible(false);
			formulario.btnActualizarDatosPlanilla.setVisible(true);
			formulario.pistas();
			formulario.construirTabla();
			formulario.establecerFechaRegistro();
			formulario.txtIdentidadEmpleadoPlanilla.requestFocusInWindow();
			formulario.txtIdentidadEmpleadoPlanilla.setEditable(true);

			final ImageIcon logo = new ImageIcon(
					usuario.getImage().getScaledInstance(formulario.lblFotoPlanilla.getWidth(),
							formulario.lblFotoPlanilla.getHeight(), Image.SCALE_DEFAULT));
			formulario.lblFotoPlanilla.setIcon(logo);
			formulario.txtDireccionFoto.setText(null);

		}

	}

	public void limpiar() {
		formulario.txtCodigo.setText(null);
		formulario.txtCodigoPlanilla.setText(null);
		formulario.txtNombresPlanilla.setText(null);
		formulario.txtApellidosPlanilla.setText(null);
		formulario.txtIdentidadPlanilla.setText(null);
		formulario.txtCargoPlanilla.setText(null);
		formulario.txtBusquedaPlanilla.setText(null);
		formulario.txtTotalPlanilla.setText(null);
		formulario.txtDireccionFoto.setText(null);
		registro_planillas.txtTotalPagoEmpleado.setText(null);
		registro_planillas.txtTotalBonificacionesPlanilla.setText(null);
		registro_planillas.txtTotalDeduccionesPlanilla.setText(null);
		registro_planillas.txtCantidadPlanilla.setText(null);
		registro_planillas.txtSueldoNetoPlanilla.setText(null);
		formulario.txtIdentidadEmpleadoPlanilla.setText(null);
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
				planilla.setTipo_planilla(rs.getString("tipo_planilla"));
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
		String matrizInfo[][] = new String[miLista.size()][12];
		for (int i = 0; i < miLista.size(); i++) {
			matrizInfo[i][0] = miLista.get(i).getId_planilla() + "";
			matrizInfo[i][1] = miLista.get(i).getTipo_planilla() + "";
			matrizInfo[i][2] = miLista.get(i).getFecha_planilla() + "";
			matrizInfo[i][3] = miLista.get(i).getNombres_planilla() + "";
			matrizInfo[i][4] = miLista.get(i).getApellidos_planilla() + "";
			matrizInfo[i][5] = miLista.get(i).getIdentidad_planilla() + "";
			matrizInfo[i][6] = miLista.get(i).getCargo_planilla() + "";
			matrizInfo[i][7] = miLista.get(i).getSueldo_bruto_planilla() + "";
			matrizInfo[i][8] = miLista.get(i).getTotal_deducciones_planilla() + "";
			matrizInfo[i][9] = miLista.get(i).getTotal_bonificaciones_planilla() + "";
			matrizInfo[i][10] = miLista.get(i).getSueldo_neto_planilla() + "";
			matrizInfo[i][11] = miLista.get(i).getTotal_apagar_planilla() + "";
		}

		return matrizInfo;
	}

}
