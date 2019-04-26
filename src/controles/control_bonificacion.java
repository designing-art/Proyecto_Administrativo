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

import clases.bonificacion;
import conexion.conexion;
import consultas.consultas_bonificacion;
import formularios.registro_bonificaciones;

public class control_bonificacion implements ActionListener {

	public bonificacion clase;
	public consultas_bonificacion consulta;
	public registro_bonificaciones formulario;
	public ImageIcon usuario = new ImageIcon(getClass().getResource("/material/usuario.png"));

	public control_bonificacion(bonificacion clase, consultas_bonificacion consulta, registro_bonificaciones formulario) {
		this.clase = clase;
		this.consulta = consulta;
		this.formulario = formulario;
		this.formulario.btnGuardar.addActionListener(this);
		this.formulario.btnNuevo.addActionListener(this);
		this.formulario.btnActualizar.addActionListener(this);
		this.formulario.btnActualizarDatosBonificacion.addActionListener(this);
		this.formulario.btnBorrarBonificacion.addActionListener(this);
		this.formulario.btnVerBonificacion.addActionListener(this);
		this.formulario.btnAceptar.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == formulario.btnGuardar) {

			if (formulario.txtObservacionBonificacion.getText().isEmpty()
					|| formulario.txtIdentidadBonificacion.getText().isEmpty()
					|| formulario.txtCantidadBonificacion.getText().isEmpty()
					|| formulario.txtObservacionBonificacion.getText().toString()
							.equalsIgnoreCase("Ingrese el nombre del cargo.")
					|| formulario.txtIdentidadEmpleadoBonificacion.getText().toString()
							.equalsIgnoreCase("Escriba una observacion.")
					|| formulario.txtCantidadBonificacion.getText().toString().equalsIgnoreCase("Digite la cantidad.")) {
				JOptionPane.showMessageDialog(null, "Porfavor llene los campos para guardar la bonificacion!");

			} else {
				clase.setTipo_bonificacion(formulario.cbxTipoBonificacion.getSelectedItem().toString());
				clase.setObservacion_bonificacion(formulario.txtObservacionBonificacion.getText());
				clase.setCantidad_bonificacion(Double.parseDouble(formulario.txtCantidadBonificacion.getText()));
				clase.setIdentidad_empleado_bonificacion(formulario.txtIdentidadEmpleadoBonificacion.getText());
				clase.setFecha_bonificacion(formulario.editor.getText());

				if (consulta.registrar(clase)) {
					JOptionPane.showMessageDialog(null, "Bonificacion registrada!");
					limpiar();
					formulario.construirTabla();
					formulario.obtenerUltimoId();
					formulario.establecerFechaRegistro();
					
					final ImageIcon logo = new ImageIcon(
							usuario.getImage().getScaledInstance(formulario.lblFotoBonificacion.getWidth(),
									formulario.lblFotoBonificacion.getHeight(), Image.SCALE_DEFAULT));
					formulario.lblFotoBonificacion.setIcon(logo);
					formulario.txtDireccionFoto.setText(null);
					formulario.txtIdentidadEmpleadoBonificacion.setText(null);
					formulario.txtIdentidadEmpleadoBonificacion.requestFocusInWindow();

				} else {
					JOptionPane.showMessageDialog(null, "Error! Bonificacion no Registrado");
					limpiar();
				}
			}
		}

		if (e.getSource() == formulario.btnActualizarDatosBonificacion) {
			int filaseleccionada;
			try {
				filaseleccionada = formulario.tablaBonificaciones.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
					formulario.txtIdentidadEmpleadoBonificacion.setText(null);
				} else {
					String codigo = formulario.tablaBonificaciones.getValueAt(filaseleccionada, 0).toString();
					String tipo = formulario.tablaBonificaciones.getValueAt(filaseleccionada, 1).toString();
					String observacion = formulario.tablaBonificaciones.getValueAt(filaseleccionada, 2).toString();
					String identidad = formulario.tablaBonificaciones.getValueAt(filaseleccionada, 3).toString();
					String cantidad = formulario.tablaBonificaciones.getValueAt(filaseleccionada, 4).toString();
					String fecha = formulario.tablaBonificaciones.getValueAt(filaseleccionada, 5).toString();

					formulario.txtCodigo.setText(codigo);
					formulario.cbxTipoBonificacion.setSelectedItem(tipo);
					formulario.txtObservacionBonificacion.setText(observacion);
					formulario.txtIdentidadEmpleadoBonificacion.setText(identidad);
					formulario.txtCantidadBonificacion.setText(cantidad);
					formulario.editor.setText(fecha);

					formulario.txtCodigoBonificacion.setForeground(Color.BLACK);
					formulario.cbxTipoBonificacion.setForeground(Color.BLACK);
					formulario.txtObservacionBonificacion.setForeground(Color.BLACK);
					formulario.txtIdentidadEmpleadoBonificacion.setForeground(Color.BLACK);
					formulario.txtCantidadBonificacion.setForeground(Color.BLACK);
					formulario.editor.setForeground(Color.BLACK);

					formulario.btnBorrarBonificacion.setVisible(true);
					formulario.btnGuardar.setVisible(false);
					formulario.btnNuevo.setVisible(false);
					formulario.btnActualizar.setVisible(true);
					formulario.btnActualizarDatosBonificacion.setVisible(true);
					formulario.btnVerBonificacion.setVisible(false);
					formulario.btnAceptar.setText("Cancelar");
					formulario.btnAceptar.setVisible(true);

					formulario.txtIdentidadBonificacion.requestFocusInWindow();

				}

			} catch (HeadlessException ex) {
				JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente",
						" .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);
			}
		}

		if (e.getSource() == formulario.btnVerBonificacion) {
			int filaseleccionada;
			try {
				filaseleccionada = formulario.tablaBonificaciones.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
					formulario.txtIdentidadEmpleadoBonificacion.setText(null);
				} else {
					String codigo = formulario.tablaBonificaciones.getValueAt(filaseleccionada, 0).toString();
					String tipo = formulario.tablaBonificaciones.getValueAt(filaseleccionada, 1).toString();
					String observacion = formulario.tablaBonificaciones.getValueAt(filaseleccionada, 2).toString();
					String identidad = formulario.tablaBonificaciones.getValueAt(filaseleccionada, 3).toString();
					String cantidad = formulario.tablaBonificaciones.getValueAt(filaseleccionada, 4).toString();
					String fecha = formulario.tablaBonificaciones.getValueAt(filaseleccionada, 5).toString();

					formulario.txtCodigo.setText(codigo);
					formulario.cbxTipoBonificacion.setSelectedItem(tipo);
					formulario.txtObservacionBonificacion.setText(observacion);
					formulario.txtIdentidadEmpleadoBonificacion.setText(identidad);
					formulario.txtCantidadBonificacion.setText(cantidad);
					formulario.editor.setText(fecha);

					formulario.txtCodigo.setForeground(Color.BLACK);
					formulario.cbxTipoBonificacion.setForeground(Color.BLACK);
					formulario.txtObservacionBonificacion.setForeground(Color.BLACK);
					formulario.txtIdentidadEmpleadoBonificacion.setForeground(Color.BLACK);
					formulario.txtCantidadBonificacion.setForeground(Color.BLACK);
					formulario.editor.setForeground(Color.BLACK);

					formulario.btnBorrarBonificacion.setVisible(false);
					formulario.btnGuardar.setVisible(false);
					formulario.btnNuevo.setVisible(false);
					formulario.btnActualizar.setVisible(false);
					formulario.btnActualizarDatosBonificacion.setVisible(false);
					formulario.btnAceptar.setText("Aceptar");
					formulario.btnAceptar.setVisible(true);

					formulario.cbxTipoBonificacion.setEditable(false);
					formulario.txtObservacionBonificacion.setEditable(false);
					formulario.txtIdentidadEmpleadoBonificacion.setEditable(false);
					formulario.txtCantidadBonificacion.setEditable(false);
					formulario.txtObservacionBonificacion.setBackground(Color.LIGHT_GRAY);
					formulario.btnActualizar.setVisible(false);

				}

			} catch (HeadlessException ex) {
				JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente",
						" .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);
			}
		}

		if (e.getSource() == formulario.btnActualizar) {

			if (formulario.txtObservacionBonificacion.getText().isEmpty()
					|| formulario.txtIdentidadBonificacion.getText().isEmpty()
					|| formulario.txtCantidadBonificacion.getText().isEmpty()
					|| formulario.txtObservacionBonificacion.getText().toString()
							.equalsIgnoreCase("Ingrese el nombre del cargo.")
					|| formulario.txtIdentidadEmpleadoBonificacion.getText().toString()
							.equalsIgnoreCase("Escriba una observacion.")
					|| formulario.txtCantidadBonificacion.getText().toString().equalsIgnoreCase("Digite la cantidad.")) {
				JOptionPane.showMessageDialog(null, "Porfavor llene los campos para guardar la bonificacion!");

			} else {
				clase.setId_bonificacion(Integer.parseInt(formulario.txtCodigo.getText()));
				clase.setTipo_bonificacion(formulario.cbxTipoBonificacion.getSelectedItem().toString());
				clase.setObservacion_bonificacion(formulario.txtObservacionBonificacion.getText());
				clase.setCantidad_bonificacion(Double.parseDouble(formulario.txtCantidadBonificacion.getText()));
				clase.setIdentidad_empleado_bonificacion(formulario.txtIdentidadEmpleadoBonificacion.getText());
				clase.setFecha_bonificacion(formulario.editor.getText());
				clase.setId_bonificacion(Integer.parseInt(formulario.txtCodigo.getText()));

				if (consulta.modificar(clase)) {
					JOptionPane.showMessageDialog(null, "Bonificacion Actualizada!");
					limpiar();
					formulario.construirTabla();
					formulario.obtenerUltimoId();
					formulario.cbxTipoBonificacion.setEditable(false);
					formulario.txtObservacionBonificacion.setEditable(false);
					formulario.txtIdentidadEmpleadoBonificacion.setEditable(false);
					formulario.txtCantidadBonificacion.setEditable(false);
					formulario.txtObservacionBonificacion.setBackground(Color.LIGHT_GRAY);
					formulario.btnActualizar.setVisible(false);
					final ImageIcon logo = new ImageIcon(
							usuario.getImage().getScaledInstance(formulario.lblFotoBonificacion.getWidth(),
									formulario.lblFotoBonificacion.getHeight(), Image.SCALE_DEFAULT));
					formulario.lblFotoBonificacion.setIcon(logo);
					formulario.txtBusquedaBonificacion.requestFocusInWindow();


				} else {
					JOptionPane.showMessageDialog(null, "Error! Bonificacion no Actualizado");
					limpiar();
				}

			}
		}

		if (e.getSource() == formulario.btnBorrarBonificacion) {
			PreparedStatement ps = null;
			int filaseleccionada;
			try {
				filaseleccionada = formulario.tablaBonificaciones.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					conexion objCon = new conexion();
					Connection conn = objCon.getConexion();
					int Fila = formulario.tablaBonificaciones.getSelectedRow();
					String codigo = formulario.tablaBonificaciones.getValueAt(Fila, 0).toString();
					ps = conn.prepareStatement("DELETE FROM bonificaciones WHERE id_bonificacion=?");
					ps.setString(1, codigo);
					ps.execute();
					JOptionPane.showMessageDialog(null, "Bonificacion Eliminada!");
					limpiar();
					formulario.construirTabla();

					formulario.cbxTipoBonificacion.setEditable(false);
					formulario.txtObservacionBonificacion.setEditable(false);
					formulario.txtIdentidadEmpleadoBonificacion.setEditable(false);
					formulario.txtCantidadBonificacion.setEditable(false);
					formulario.txtObservacionBonificacion.setBackground(Color.LIGHT_GRAY);
					formulario.btnActualizar.setVisible(false);
					
					final ImageIcon logo = new ImageIcon(
							usuario.getImage().getScaledInstance(formulario.lblFotoBonificacion.getWidth(),
									formulario.lblFotoBonificacion.getHeight(), Image.SCALE_DEFAULT));
					formulario.lblFotoBonificacion.setIcon(logo);
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
			formulario.btnBorrarBonificacion.setVisible(false);
			formulario.btnGuardar.setVisible(true);
			formulario.btnVerBonificacion.setVisible(true);
			formulario.btnNuevo.setVisible(true);
			formulario.btnActualizar.setVisible(false);
			formulario.btnActualizarDatosBonificacion.setVisible(true);
			formulario.txtObservacionBonificacion.setEditable(true);
			formulario.txtCantidadBonificacion.setEditable(true);
			formulario.pistas();
			formulario.construirTabla();
			formulario.establecerFechaRegistro();
			formulario.txtObservacionBonificacion.setBackground(Color.WHITE);
			formulario.txtIdentidadEmpleadoBonificacion.requestFocusInWindow();
			
			final ImageIcon logo = new ImageIcon(
					usuario.getImage().getScaledInstance(formulario.lblFotoBonificacion.getWidth(),
							formulario.lblFotoBonificacion.getHeight(), Image.SCALE_DEFAULT));
			formulario.lblFotoBonificacion.setIcon(logo);
			formulario.txtDireccionFoto.setText(null);
			
		}

		if (e.getSource() == formulario.btnAceptar) {
			limpiar();
			limpiar();
			formulario.obtenerUltimoId();
			formulario.btnBorrarBonificacion.setVisible(false);
			formulario.btnGuardar.setVisible(true);
			formulario.btnVerBonificacion.setVisible(true);
			formulario.btnNuevo.setVisible(true);
			formulario.btnAceptar.setVisible(false);
			formulario.btnActualizar.setVisible(false);
			formulario.btnActualizarDatosBonificacion.setVisible(true);
			formulario.txtObservacionBonificacion.setEditable(true);
			formulario.txtCantidadBonificacion.setEditable(true);
			formulario.pistas();
			formulario.construirTabla();
			formulario.establecerFechaRegistro();
			formulario.txtObservacionBonificacion.setBackground(Color.WHITE);
			formulario.txtIdentidadEmpleadoBonificacion.requestFocusInWindow();
			formulario.txtIdentidadEmpleadoBonificacion.setEditable(true);
			
			final ImageIcon logo = new ImageIcon(
					usuario.getImage().getScaledInstance(formulario.lblFotoBonificacion.getWidth(),
							formulario.lblFotoBonificacion.getHeight(), Image.SCALE_DEFAULT));
			formulario.lblFotoBonificacion.setIcon(logo);
			formulario.txtDireccionFoto.setText(null);
			
		}

	}

	public void limpiar() {
		formulario.txtCodigo.setText(null);
		formulario.txtCodigoBonificacion.setText(null);
		formulario.txtBusquedaBonificacion.setText(null);
		formulario.txtObservacionBonificacion.setText(null);
		formulario.txtCantidadBonificacion.setText(null);
		formulario.txtIdentidadEmpleadoBonificacion.setText(null);
		registro_bonificaciones.txtTotalBonificacion.setText(null);
		formulario.txtNombresBonificacion.setText(null);
		formulario.txtApellidosBonificacion.setText(null);
		formulario.txtIdentidadBonificacion.setText(null);
	}

	public static ArrayList<bonificacion> buscarUsuariosConMatriz() {
		conexion conex = new conexion();
		ArrayList<bonificacion> miLista = new ArrayList<bonificacion>();
		bonificacion bonificacion;
		try {
			Statement estatuto = conex.getConexion().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT * FROM bonificaciones");

			while (rs.next()) {
				bonificacion = new bonificacion();
				bonificacion.setId_bonificacion(Integer.parseInt(rs.getString("id_bonificacion")));
				bonificacion.setTipo_bonificacion(rs.getString("tipo_bonificacion"));
				bonificacion.setObservacion_bonificacion(rs.getString("observacion_bonificacion"));
				bonificacion.setIdentidad_empleado_bonificacion(rs.getString("identidad_empleado_bonificacion"));
				bonificacion.setCantidad_bonificacion(Double.parseDouble(rs.getString("cantidad_bonificacion")));
				bonificacion.setFecha_bonificacion(rs.getString("fecha_bonificacion"));
				miLista.add(bonificacion);
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
		ArrayList<bonificacion> miLista = buscarUsuariosConMatriz();
		String matrizInfo[][] = new String[miLista.size()][6];
		for (int i = 0; i < miLista.size(); i++) {
			matrizInfo[i][0] = miLista.get(i).getId_bonificacion() + "";
			matrizInfo[i][1] = miLista.get(i).getTipo_bonificacion() + "";
			matrizInfo[i][2] = miLista.get(i).getObservacion_bonificacion() + "";
			matrizInfo[i][3] = miLista.get(i).getIdentidad_empleado_bonificacion() + "";
			matrizInfo[i][4] = miLista.get(i).getCantidad_bonificacion() + "";
			matrizInfo[i][5] = miLista.get(i).getFecha_bonificacion() + "";
		}

		return matrizInfo;
	}

}
