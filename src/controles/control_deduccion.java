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

import clases.deduccion;
import conexion.conexion;
import consultas.consultas_deduccion;
import formularios.registro_deducciones;

public class control_deduccion implements ActionListener {

	public deduccion clase;
	public consultas_deduccion consulta;
	public registro_deducciones formulario;
	public ImageIcon usuario = new ImageIcon(getClass().getResource("/material/usuario.png"));

	public control_deduccion(deduccion clase, consultas_deduccion consulta, registro_deducciones formulario) {
		this.clase = clase;
		this.consulta = consulta;
		this.formulario = formulario;
		this.formulario.btnGuardar.addActionListener(this);
		this.formulario.btnNuevo.addActionListener(this);
		this.formulario.btnActualizar.addActionListener(this);
		this.formulario.btnActualizarDatosDeduccion.addActionListener(this);
		this.formulario.btnBorrarDeduccion.addActionListener(this);
		this.formulario.btnVerDeduccion.addActionListener(this);
		this.formulario.btnAceptar.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == formulario.btnGuardar) {

			if (formulario.txtObservacionDeduccion.getText().isEmpty()
					|| formulario.txtIdentidadDeduccion.getText().isEmpty()
					|| formulario.txtCantidadDeduccion.getText().isEmpty()
					|| formulario.txtObservacionDeduccion.getText().toString()
							.equalsIgnoreCase("Ingrese el nombre del cargo.")
					|| formulario.txtIdentidadEmpleadoDeduccion.getText().toString()
							.equalsIgnoreCase("Escriba una observacion.")
					|| formulario.txtCantidadDeduccion.getText().toString().equalsIgnoreCase("Digite la cantidad.")) {
				JOptionPane.showMessageDialog(null, "Porfavor llene los campos para guardar la deduccion!");

			} else {
				clase.setTipo_deduccion(formulario.cbxTipoDeduccion.getSelectedItem().toString());
				clase.setObservacion_deduccion(formulario.txtObservacionDeduccion.getText());
				clase.setCantidad_deduccion(Double.parseDouble(formulario.txtCantidadDeduccion.getText()));
				clase.setIdentidad_empleado_deduccion(formulario.txtIdentidadEmpleadoDeduccion.getText());
				clase.setFecha_deduccion(formulario.editor.getText());

				if (consulta.registrar(clase)) {
					JOptionPane.showMessageDialog(null, "Deduccion registrada!");
					limpiar();
					formulario.construirTabla();
					formulario.obtenerUltimoId();
					formulario.establecerFechaRegistro();
					
					final ImageIcon logo = new ImageIcon(
							usuario.getImage().getScaledInstance(formulario.lblFotoDeduccion.getWidth(),
									formulario.lblFotoDeduccion.getHeight(), Image.SCALE_DEFAULT));
					formulario.lblFotoDeduccion.setIcon(logo);
					formulario.txtDireccionFoto.setText(null);
					formulario.txtIdentidadEmpleadoDeduccion.setText(null);
					formulario.txtIdentidadEmpleadoDeduccion.requestFocusInWindow();

				} else {
					JOptionPane.showMessageDialog(null, "Error! Deduccion no Registrado");
					limpiar();
				}
			}
		}

		if (e.getSource() == formulario.btnActualizarDatosDeduccion) {
			int filaseleccionada;
			try {
				filaseleccionada = formulario.tablaDeducciones.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
					formulario.txtIdentidadEmpleadoDeduccion.setText(null);
				} else {
					String codigo = formulario.tablaDeducciones.getValueAt(filaseleccionada, 0).toString();
					String tipo = formulario.tablaDeducciones.getValueAt(filaseleccionada, 1).toString();
					String observacion = formulario.tablaDeducciones.getValueAt(filaseleccionada, 2).toString();
					String identidad = formulario.tablaDeducciones.getValueAt(filaseleccionada, 3).toString();
					String cantidad = formulario.tablaDeducciones.getValueAt(filaseleccionada, 4).toString();
					String fecha = formulario.tablaDeducciones.getValueAt(filaseleccionada, 5).toString();

					formulario.txtCodigo.setText(codigo);
					formulario.cbxTipoDeduccion.setSelectedItem(tipo);
					formulario.txtObservacionDeduccion.setText(observacion);
					formulario.txtIdentidadEmpleadoDeduccion.setText(identidad);
					formulario.txtCantidadDeduccion.setText(cantidad);
					formulario.editor.setText(fecha);

					formulario.txtCodigoDeduccion.setForeground(Color.BLACK);
					formulario.cbxTipoDeduccion.setForeground(Color.BLACK);
					formulario.txtObservacionDeduccion.setForeground(Color.BLACK);
					formulario.txtIdentidadEmpleadoDeduccion.setForeground(Color.BLACK);
					formulario.txtCantidadDeduccion.setForeground(Color.BLACK);
					formulario.editor.setForeground(Color.BLACK);

					formulario.btnBorrarDeduccion.setVisible(true);
					formulario.btnGuardar.setVisible(false);
					formulario.btnNuevo.setVisible(false);
					formulario.btnActualizar.setVisible(true);
					formulario.btnActualizarDatosDeduccion.setVisible(true);
					formulario.btnVerDeduccion.setVisible(false);
					formulario.btnAceptar.setText("Cancelar");
					formulario.btnAceptar.setVisible(true);

					formulario.txtIdentidadDeduccion.requestFocusInWindow();

				}

			} catch (HeadlessException ex) {
				JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente",
						" .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);
			}
		}

		if (e.getSource() == formulario.btnVerDeduccion) {
			int filaseleccionada;
			try {
				filaseleccionada = formulario.tablaDeducciones.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
					formulario.txtIdentidadEmpleadoDeduccion.setText(null);
				} else {
					String codigo = formulario.tablaDeducciones.getValueAt(filaseleccionada, 0).toString();
					String tipo = formulario.tablaDeducciones.getValueAt(filaseleccionada, 1).toString();
					String observacion = formulario.tablaDeducciones.getValueAt(filaseleccionada, 2).toString();
					String identidad = formulario.tablaDeducciones.getValueAt(filaseleccionada, 3).toString();
					String cantidad = formulario.tablaDeducciones.getValueAt(filaseleccionada, 4).toString();
					String fecha = formulario.tablaDeducciones.getValueAt(filaseleccionada, 5).toString();

					formulario.txtCodigo.setText(codigo);
					formulario.cbxTipoDeduccion.setSelectedItem(tipo);
					formulario.txtObservacionDeduccion.setText(observacion);
					formulario.txtIdentidadEmpleadoDeduccion.setText(identidad);
					formulario.txtCantidadDeduccion.setText(cantidad);
					formulario.editor.setText(fecha);

					formulario.txtCodigo.setForeground(Color.BLACK);
					formulario.cbxTipoDeduccion.setForeground(Color.BLACK);
					formulario.txtObservacionDeduccion.setForeground(Color.BLACK);
					formulario.txtIdentidadEmpleadoDeduccion.setForeground(Color.BLACK);
					formulario.txtCantidadDeduccion.setForeground(Color.BLACK);
					formulario.editor.setForeground(Color.BLACK);

					formulario.btnBorrarDeduccion.setVisible(false);
					formulario.btnGuardar.setVisible(false);
					formulario.btnNuevo.setVisible(false);
					formulario.btnActualizar.setVisible(false);
					formulario.btnActualizarDatosDeduccion.setVisible(false);
					formulario.btnAceptar.setText("Aceptar");
					formulario.btnAceptar.setVisible(true);

					formulario.cbxTipoDeduccion.setEditable(false);
					formulario.txtObservacionDeduccion.setEditable(false);
					formulario.txtIdentidadEmpleadoDeduccion.setEditable(false);
					formulario.txtCantidadDeduccion.setEditable(false);
					formulario.txtObservacionDeduccion.setBackground(Color.LIGHT_GRAY);
					formulario.btnActualizar.setVisible(false);

				}

			} catch (HeadlessException ex) {
				JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente",
						" .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);
			}
		}

		if (e.getSource() == formulario.btnActualizar) {

			if (formulario.txtObservacionDeduccion.getText().isEmpty()
					|| formulario.txtIdentidadDeduccion.getText().isEmpty()
					|| formulario.txtCantidadDeduccion.getText().isEmpty()
					|| formulario.txtObservacionDeduccion.getText().toString()
							.equalsIgnoreCase("Ingrese el nombre del cargo.")
					|| formulario.txtIdentidadEmpleadoDeduccion.getText().toString()
							.equalsIgnoreCase("Escriba una observacion.")
					|| formulario.txtCantidadDeduccion.getText().toString().equalsIgnoreCase("Digite la cantidad.")) {
				JOptionPane.showMessageDialog(null, "Porfavor llene los campos para guardar la deduccion!");

			} else {
				clase.setId_deduccion(Integer.parseInt(formulario.txtCodigo.getText()));
				clase.setTipo_deduccion(formulario.cbxTipoDeduccion.getSelectedItem().toString());
				clase.setObservacion_deduccion(formulario.txtObservacionDeduccion.getText());
				clase.setCantidad_deduccion(Double.parseDouble(formulario.txtCantidadDeduccion.getText()));
				clase.setIdentidad_empleado_deduccion(formulario.txtIdentidadEmpleadoDeduccion.getText());
				clase.setFecha_deduccion(formulario.editor.getText());
				clase.setId_deduccion(Integer.parseInt(formulario.txtCodigo.getText()));

				if (consulta.modificar(clase)) {
					JOptionPane.showMessageDialog(null, "Deduccion Actualizada!");
					limpiar();
					formulario.construirTabla();
					formulario.obtenerUltimoId();
					formulario.cbxTipoDeduccion.setEditable(false);
					formulario.txtObservacionDeduccion.setEditable(false);
					formulario.txtIdentidadEmpleadoDeduccion.setEditable(false);
					formulario.txtCantidadDeduccion.setEditable(false);
					formulario.txtObservacionDeduccion.setBackground(Color.LIGHT_GRAY);
					formulario.btnActualizar.setVisible(false);
					final ImageIcon logo = new ImageIcon(
							usuario.getImage().getScaledInstance(formulario.lblFotoDeduccion.getWidth(),
									formulario.lblFotoDeduccion.getHeight(), Image.SCALE_DEFAULT));
					formulario.lblFotoDeduccion.setIcon(logo);
					formulario.txtBusquedaDeduccion.requestFocusInWindow();


				} else {
					JOptionPane.showMessageDialog(null, "Error! Deduccion no Actualizado");
					limpiar();
				}

			}
		}

		if (e.getSource() == formulario.btnBorrarDeduccion) {
			PreparedStatement ps = null;
			int filaseleccionada;
			try {
				filaseleccionada = formulario.tablaDeducciones.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					conexion objCon = new conexion();
					Connection conn = objCon.getConexion();
					int Fila = formulario.tablaDeducciones.getSelectedRow();
					String codigo = formulario.tablaDeducciones.getValueAt(Fila, 0).toString();
					ps = conn.prepareStatement("DELETE FROM deducciones WHERE id_deduccion=?");
					ps.setString(1, codigo);
					ps.execute();
					JOptionPane.showMessageDialog(null, "Deduccion Eliminada!");
					limpiar();
					formulario.construirTabla();

					formulario.cbxTipoDeduccion.setEditable(false);
					formulario.txtObservacionDeduccion.setEditable(false);
					formulario.txtIdentidadEmpleadoDeduccion.setEditable(false);
					formulario.txtCantidadDeduccion.setEditable(false);
					formulario.txtObservacionDeduccion.setBackground(Color.LIGHT_GRAY);
					formulario.btnActualizar.setVisible(false);
					
					final ImageIcon logo = new ImageIcon(
							usuario.getImage().getScaledInstance(formulario.lblFotoDeduccion.getWidth(),
									formulario.lblFotoDeduccion.getHeight(), Image.SCALE_DEFAULT));
					formulario.lblFotoDeduccion.setIcon(logo);
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
			formulario.btnBorrarDeduccion.setVisible(false);
			formulario.btnGuardar.setVisible(true);
			formulario.btnVerDeduccion.setVisible(true);
			formulario.btnNuevo.setVisible(true);
			formulario.btnActualizar.setVisible(false);
			formulario.btnActualizarDatosDeduccion.setVisible(true);
			formulario.txtObservacionDeduccion.setEditable(true);
			formulario.txtCantidadDeduccion.setEditable(true);
			formulario.pistas();
			formulario.construirTabla();
			formulario.establecerFechaRegistro();
			formulario.txtObservacionDeduccion.setBackground(Color.WHITE);
			formulario.txtIdentidadEmpleadoDeduccion.requestFocusInWindow();
			
			final ImageIcon logo = new ImageIcon(
					usuario.getImage().getScaledInstance(formulario.lblFotoDeduccion.getWidth(),
							formulario.lblFotoDeduccion.getHeight(), Image.SCALE_DEFAULT));
			formulario.lblFotoDeduccion.setIcon(logo);
			formulario.txtDireccionFoto.setText(null);
			
		}

		if (e.getSource() == formulario.btnAceptar) {
			limpiar();
			limpiar();
			formulario.obtenerUltimoId();
			formulario.btnBorrarDeduccion.setVisible(false);
			formulario.btnGuardar.setVisible(true);
			formulario.btnVerDeduccion.setVisible(true);
			formulario.btnNuevo.setVisible(true);
			formulario.btnAceptar.setVisible(false);
			formulario.btnActualizar.setVisible(false);
			formulario.btnActualizarDatosDeduccion.setVisible(true);
			formulario.txtObservacionDeduccion.setEditable(true);
			formulario.txtCantidadDeduccion.setEditable(true);
			formulario.pistas();
			formulario.construirTabla();
			formulario.establecerFechaRegistro();
			formulario.txtObservacionDeduccion.setBackground(Color.WHITE);
			formulario.txtIdentidadEmpleadoDeduccion.requestFocusInWindow();
			formulario.txtIdentidadEmpleadoDeduccion.setEditable(true);
			
			final ImageIcon logo = new ImageIcon(
					usuario.getImage().getScaledInstance(formulario.lblFotoDeduccion.getWidth(),
							formulario.lblFotoDeduccion.getHeight(), Image.SCALE_DEFAULT));
			formulario.lblFotoDeduccion.setIcon(logo);
			formulario.txtDireccionFoto.setText(null);
			
		}

	}

	public void limpiar() {
		formulario.txtCodigo.setText(null);
		formulario.txtCodigoDeduccion.setText(null);
		formulario.txtBusquedaDeduccion.setText(null);
		formulario.txtObservacionDeduccion.setText(null);
		formulario.txtCantidadDeduccion.setText(null);
		formulario.txtIdentidadEmpleadoDeduccion.setText(null);
		formulario.txtTotalDeducciones.setText(null);
		formulario.txtNombresDeduccion.setText(null);
		formulario.txtApellidosDeduccion.setText(null);
		formulario.txtIdentidadDeduccion.setText(null);
	}

	public static ArrayList<deduccion> buscarUsuariosConMatriz() {
		conexion conex = new conexion();
		ArrayList<deduccion> miLista = new ArrayList<deduccion>();
		deduccion dedu;
		try {
			Statement estatuto = conex.getConexion().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT * FROM deducciones");

			while (rs.next()) {
				dedu = new deduccion();
				dedu.setId_deduccion(Integer.parseInt(rs.getString("id_deduccion")));
				dedu.setTipo_deduccion(rs.getString("tipo_deduccion"));
				dedu.setObservacion_deduccion(rs.getString("observacion_deduccion"));
				dedu.setIdentidad_empleado_deduccion(rs.getString("identidad_empleado_deduccion"));
				dedu.setCantidad_deduccion(Double.parseDouble(rs.getString("cantidad_deduccion")));
				dedu.setFecha_deduccion(rs.getString("fecha_deduccion"));
				miLista.add(dedu);
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
		ArrayList<deduccion> miLista = buscarUsuariosConMatriz();
		String matrizInfo[][] = new String[miLista.size()][6];
		for (int i = 0; i < miLista.size(); i++) {
			matrizInfo[i][0] = miLista.get(i).getId_deduccion() + "";
			matrizInfo[i][1] = miLista.get(i).getTipo_deduccion() + "";
			matrizInfo[i][2] = miLista.get(i).getObservacion_deduccion() + "";
			matrizInfo[i][3] = miLista.get(i).getIdentidad_empleado_deduccion() + "";
			matrizInfo[i][4] = miLista.get(i).getCantidad_deduccion() + "";
			matrizInfo[i][5] = miLista.get(i).getFecha_deduccion() + "";
		}

		return matrizInfo;
	}

}
