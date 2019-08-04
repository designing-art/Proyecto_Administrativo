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

import clases.egreso;
import conexion.conexion;
import consultas.consultas_egreso;
import formularios.login_usuario;
import formularios.registro_egresos;

public class control_egresos implements ActionListener {

	public egreso clase;
	public consultas_egreso consulta;
	public registro_egresos formulario;

	public control_egresos(egreso clase, consultas_egreso consulta, registro_egresos formulario) {
		this.clase = clase;
		this.consulta = consulta;
		this.formulario = formulario;
		this.formulario.btnGuardar.addActionListener(this);
		this.formulario.btnNuevo.addActionListener(this);
		this.formulario.btnActualizar.addActionListener(this);
		this.formulario.btnActualizarDatos.addActionListener(this);
		this.formulario.btnBorrar.addActionListener(this);
		this.formulario.btnMostrar.addActionListener(this);
		this.formulario.btnAceptar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == formulario.btnGuardar) {
			if (formulario.txtEgreso.getText().isEmpty() || formulario.txtCantidad.getText().isEmpty()
					|| formulario.txtDescripcion.getText().isEmpty() || formulario.editor.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Porfavor llene los campos para guardar el egreso!");
			} else {
				clase.setTipo_egreso(formulario.txtEgreso.getText().toString());
				clase.setCantidad_egreso(Double.parseDouble(formulario.txtCantidad.getText().toString()));
				clase.setDescripcion_egreso(formulario.txtDescripcion.getText().toString());
				clase.setFecha_egreso(formulario.editor.getText().toString());

				if (consulta.insertarEgreso(clase)) {
					JOptionPane.showMessageDialog(null, "Egreso registrado!");
					limpiar();
					formulario.obtenerUltimoId();
					formulario.construirTabla();

				} else {
					JOptionPane.showMessageDialog(null, "Error! Egreso no registrado");
					limpiar();
				}
			}
		}

		if (e.getSource() == formulario.btnActualizar) {
			if (formulario.txtEgreso.getText().isEmpty() || formulario.txtCantidad.getText().isEmpty()
					|| formulario.txtDescripcion.getText().isEmpty() || formulario.editor.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Porfavor llene los campos para actualizar el egreso!");
			} else {
				clase.setId_egreso(Integer.parseInt(formulario.txtCodigo.getText().toString()));
				clase.setTipo_egreso(formulario.txtEgreso.getText().toString());
				clase.setCantidad_egreso(Double.parseDouble(formulario.txtCantidad.getText().toString()));
				clase.setDescripcion_egreso(formulario.txtDescripcion.getText().toString());
				clase.setFecha_egreso(formulario.editor.getText().toString());

				if (consulta.actualizarEgreso(clase)) {
					JOptionPane.showMessageDialog(null, "Egreso Actualizado!");
					limpiar();
					formulario.obtenerUltimoId();
					formulario.construirTabla();

				} else {
					JOptionPane.showMessageDialog(null, "Error! Egreso no Actualizado");
					limpiar();
				}
			}
		}

		if (e.getSource() == formulario.btnActualizarDatos) {
			int filaseleccionada;
			try {
				filaseleccionada = formulario.tabla.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					String codigo = formulario.tabla.getValueAt(filaseleccionada, 0).toString();
					String ingreso = formulario.tabla.getValueAt(filaseleccionada, 1).toString();
					String cantidad = formulario.tabla.getValueAt(filaseleccionada, 2).toString();
					String descripcion = formulario.tabla.getValueAt(filaseleccionada, 3).toString();
					String fecha = formulario.tabla.getValueAt(filaseleccionada, 4).toString();

					formulario.txtCodigo.setText(codigo);
					formulario.txtEgreso.setText(ingreso);
					formulario.txtCantidad.setText(cantidad);
					formulario.txtDescripcion.setText(descripcion);
					formulario.editor.setText(fecha);

					formulario.txtCodigo.setForeground(Color.BLACK);
					formulario.txtEgreso.setForeground(Color.BLACK);
					formulario.txtCantidad.setForeground(Color.BLACK);
					formulario.txtDescripcion.setForeground(Color.BLACK);
					formulario.editor.setForeground(Color.BLACK);

					formulario.btnBorrar.setVisible(true);
					formulario.btnGuardar.setVisible(false);
					formulario.btnNuevo.setVisible(false);
					formulario.btnActualizar.setVisible(true);
					formulario.btnActualizarDatos.setVisible(true);
					formulario.btnMostrar.setVisible(false);
					formulario.btnAceptar.setText("Cancelar");
					formulario.btnAceptar.setVisible(true);

					formulario.txtEgreso.requestFocusInWindow();

				}

			} catch (HeadlessException ex) {
				JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente",
						" .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);
			}
		}

		if (e.getSource() == formulario.btnMostrar) {
			int filaseleccionada;
			try {
				filaseleccionada = formulario.tabla.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					String codigo = formulario.tabla.getValueAt(filaseleccionada, 0).toString();
					String ingreso = formulario.tabla.getValueAt(filaseleccionada, 1).toString();
					String cantidad = formulario.tabla.getValueAt(filaseleccionada, 2).toString();
					String descripcion = formulario.tabla.getValueAt(filaseleccionada, 3).toString();
					String fecha = formulario.tabla.getValueAt(filaseleccionada, 4).toString();

					formulario.txtCodigo.setText(codigo);
					formulario.txtEgreso.setText(ingreso);
					formulario.txtCantidad.setText(cantidad);
					formulario.txtDescripcion.setText(descripcion);
					formulario.editor.setText(fecha);

					formulario.txtCodigo.setForeground(Color.BLACK);
					formulario.txtEgreso.setForeground(Color.BLACK);
					formulario.txtCantidad.setForeground(Color.BLACK);
					formulario.txtDescripcion.setForeground(Color.BLACK);
					formulario.editor.setForeground(Color.BLACK);

					formulario.txtBusquedaCargos.requestFocusInWindow();

				}

			} catch (HeadlessException ex) {
				JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente",
						" .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);
			}
		}

		if (e.getSource() == formulario.btnBorrar) {
			PreparedStatement ps = null;
			int filaseleccionada;
			try {
				filaseleccionada = formulario.tabla.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					if (login_usuario.cargoUsuario.toString() == "Usuario Avanzado") {

						conexion objCon = new conexion();
						Connection conn = objCon.getConexion();
						int Fila = formulario.tabla.getSelectedRow();
						String codigo = formulario.tabla.getValueAt(Fila, 0).toString();
						ps = conn.prepareStatement("DELETE FROM egresos WHERE id_egreso=?");
						ps.setString(1, codigo);
						ps.execute();
						JOptionPane.showMessageDialog(null, "Egreso Eliminado!");
						limpiar();
						formulario.construirTabla();
						formulario.txtCodigo.setText(null);
						formulario.btnAceptar.setEnabled(true);
						formulario.btnActualizar.setVisible(false);
						formulario.btnGuardar.setVisible(false);
						formulario.btnNuevo.setVisible(false);
					} else {
						JOptionPane.showMessageDialog(null,
								"Usted no tiene permisos para eliminar (Solo el jefe de la empresa)");
					}

				}
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "Error al Eliminar");
				System.out.println(ex.toString());
			}
		}

		if (e.getSource() == formulario.btnNuevo) {
			limpiar();
			formulario.obtenerUltimoId();
			formulario.btnBorrar.setVisible(false);
			formulario.btnGuardar.setVisible(true);
			formulario.btnNuevo.setVisible(true);
			formulario.btnActualizar.setVisible(false);
			formulario.btnActualizarDatos.setVisible(true);
			formulario.btnMostrar.setVisible(true);
			formulario.btnAceptar.setVisible(false);
			formulario.construirTabla();
			formulario.obtenerUltimoId();
		}

		if (e.getSource() == formulario.btnAceptar) {
			limpiar();
			formulario.construirTabla();
			formulario.obtenerUltimoId();
			formulario.txtBusquedaCargos.requestFocusInWindow();
		}

	}

	public void limpiar() {
		formulario.txtBusquedaCargos.setText(null);
		formulario.txtCodigo.setText(null);
		formulario.txtEgreso.setText(null);
		formulario.txtCantidad.setText(null);
		formulario.txtDescripcion.setText(null);
		formulario.editor.setText(null);

	}

	public static ArrayList<egreso> buscarUsuariosConMatriz2() {
		conexion conex = new conexion();
		ArrayList<egreso> miLista = new ArrayList<egreso>();
		egreso egreso;
		try {
			Statement estatuto = conex.getConexion().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT * FROM egresos");

			while (rs.next()) {
				egreso = new egreso();
				egreso.setId_egreso(Integer.parseInt(rs.getString("id_egreso")));
				egreso.setTipo_egreso(rs.getString("tipo_egreso"));
				egreso.setCantidad_egreso(rs.getDouble("cantidad_egreso"));
				egreso.setDescripcion_egreso(rs.getString("descripcion_egreso"));
				egreso.setFecha_egreso(rs.getString("fecha_egreso"));
				miLista.add(egreso);
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

	public static String[][] obtenerMatriz2() {
		ArrayList<egreso> miLista = buscarUsuariosConMatriz2();
		String matrizInfo[][] = new String[miLista.size()][5];
		for (int i = 0; i < miLista.size(); i++) {
			matrizInfo[i][0] = miLista.get(i).getId_egreso() + "";
			matrizInfo[i][1] = miLista.get(i).getTipo_egreso() + "";
			matrizInfo[i][2] = miLista.get(i).getCantidad_egreso() + "";
			matrizInfo[i][3] = miLista.get(i).getDescripcion_egreso() + "";
			matrizInfo[i][4] = miLista.get(i).getFecha_egreso() + "";

		}

		return matrizInfo;
	}

}
