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
import clases.inventario;
import conexion.conexion;
import consultas.consultas_inventario;
import formularios.login_usuario;
import formularios.registro_inventario;

public class control_inventario implements ActionListener {

	public inventario clase;
	public consultas_inventario consulta;
	public registro_inventario formulario;
	public static String identidad = null;

	public control_inventario(inventario clase, consultas_inventario consulta, registro_inventario formulario) {
		this.clase = clase;
		this.consulta = consulta;
		this.formulario = formulario;
		this.formulario.btnGuardar.addActionListener(this);
		this.formulario.btnNuevo.addActionListener(this);
		this.formulario.btnActualizar.addActionListener(this);
		this.formulario.btnActualizarDatos.addActionListener(this);
		this.formulario.btnBorrar.addActionListener(this);
		this.formulario.btnVer.addActionListener(this);
		this.formulario.btnAceptar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == formulario.btnGuardar) {
			if (formulario.txtNombre.getText().isEmpty() || formulario.txtDescripcion.getText().isEmpty()
					|| formulario.txtColor.getText().isEmpty() || formulario.txtCantidad.getText().isEmpty()
					|| formulario.txtMarca.getText().isEmpty() || formulario.txtPrecio.getText().isEmpty()
					|| formulario.txtPeso.getText().isEmpty() || formulario.txtModelo.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Porfavor llene los campos para guardar el Objeto!");
			} else {
				clase.setNombre_objeto_inventario(formulario.txtNombre.getText().toString());
				clase.setPrecio_objeto_inventario(Double.parseDouble(formulario.txtPrecio.getText().toString()));
				clase.setDescripcion_objeto_inventario(formulario.txtDescripcion.getText().toString());
				clase.setPeso_objeto_inventario(formulario.txtPeso.getText().toString());
				clase.setColor_objeto_inventario(formulario.txtColor.getText().toString());
				clase.setMarca_objeto_inventario(formulario.txtMarca.getText().toString());
				clase.setModelo_objeto_inventario(formulario.txtModelo.getText().toString());
				clase.setCantidad_objeto_inventario(Integer.parseInt(formulario.txtCantidad.getText().toString()));
				clase.setExistencias_objeto_inventario(Integer.parseInt(formulario.txtCantidad.getText().toString()));
				clase.setFecha_registro_inventario(formulario.editor.getText().toString());

				if (consulta.insertar(clase)) {
					JOptionPane.showMessageDialog(null, "Objeto registrado!");
					limpiar();
					formulario.construirTabla();
					formulario.obtenerUltimoId();
				} else {
					JOptionPane.showMessageDialog(null, "Error! objeto no registrado");
					limpiar();
				}
			}
		}

		if (e.getSource() == formulario.btnActualizar) {
			if (formulario.txtNombre.getText().isEmpty() || formulario.txtDescripcion.getText().isEmpty()
					|| formulario.txtColor.getText().isEmpty() || formulario.txtCantidad.getText().isEmpty()
					|| formulario.txtMarca.getText().isEmpty() || formulario.txtPrecio.getText().isEmpty()
					|| formulario.txtPeso.getText().isEmpty() || formulario.txtModelo.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Porfavor llene los campos para actualizar el Objeto!");
			} else {
				clase.setId_inventario(Integer.parseInt(formulario.txtCodigo.getText().toString()));
				clase.setNombre_objeto_inventario(formulario.txtNombre.getText().toString());
				clase.setPrecio_objeto_inventario(Double.parseDouble(formulario.txtPrecio.getText().toString()));
				clase.setDescripcion_objeto_inventario(formulario.txtDescripcion.getText().toString());
				clase.setPeso_objeto_inventario(formulario.txtPeso.getText().toString());
				clase.setColor_objeto_inventario(formulario.txtColor.getText().toString());
				clase.setMarca_objeto_inventario(formulario.txtMarca.getText().toString());
				clase.setModelo_objeto_inventario(formulario.txtModelo.getText().toString());
				clase.setCantidad_objeto_inventario(Integer.parseInt(formulario.txtCantidad.getText().toString()));
				clase.setExistencias_objeto_inventario(Integer.parseInt(formulario.txtCantidad.getText().toString()));
				clase.setFecha_registro_inventario(formulario.editor.getText().toString());

				if (consulta.actualizar(clase)) {
					JOptionPane.showMessageDialog(null, "Objeto actualizado!");
					limpiar();
					formulario.construirTabla();
					formulario.txtCodigo.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "Error! objeto no actualizado");
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
					String nombre = formulario.tabla.getValueAt(filaseleccionada, 1).toString();
					String precio = formulario.tabla.getValueAt(filaseleccionada, 2).toString();
					String descripcion = formulario.tabla.getValueAt(filaseleccionada, 3).toString();
					String peso = formulario.tabla.getValueAt(filaseleccionada, 4).toString();
					String color = formulario.tabla.getValueAt(filaseleccionada, 5).toString();
					String marca = formulario.tabla.getValueAt(filaseleccionada, 6).toString();
					String modelo = formulario.tabla.getValueAt(filaseleccionada, 7).toString();
					String cantidad = formulario.tabla.getValueAt(filaseleccionada, 8).toString();
					String existencia = formulario.tabla.getValueAt(filaseleccionada, 9).toString();
					String fecha = formulario.tabla.getValueAt(filaseleccionada, 10).toString();

					formulario.txtCodigo.setText(codigo);
					formulario.txtNombre.setText(nombre);
					formulario.txtPrecio.setText(precio);
					formulario.txtDescripcion.setText(descripcion);
					formulario.txtPeso.setText(peso);
					formulario.txtColor.setText(color);
					formulario.txtMarca.setText(marca);
					formulario.txtModelo.setText(modelo);
					formulario.txtCantidad.setText(cantidad);
					formulario.txtExistencia.setText(existencia);
					formulario.editor.setText(fecha);

					formulario.txtCodigo.setForeground(Color.BLACK);
					formulario.txtNombre.setForeground(Color.BLACK);
					formulario.txtPrecio.setForeground(Color.BLACK);
					formulario.txtDescripcion.setForeground(Color.BLACK);
					formulario.txtPeso.setForeground(Color.BLACK);
					formulario.txtColor.setForeground(Color.BLACK);
					formulario.txtMarca.setForeground(Color.BLACK);
					formulario.txtModelo.setForeground(Color.BLACK);
					formulario.txtCantidad.setForeground(Color.BLACK);
					formulario.txtExistencia.setForeground(Color.BLACK);

					formulario.btnBorrar.setVisible(true);
					formulario.btnGuardar.setVisible(false);
					formulario.btnNuevo.setVisible(false);
					formulario.btnActualizar.setVisible(true);
					formulario.btnActualizarDatos.setVisible(true);
					formulario.btnVer.setVisible(false);
					formulario.btnAceptar.setText("Cancelar");
					formulario.btnAceptar.setVisible(true);

					formulario.txtCantidad.setEditable(false);
					formulario.txtExistencia.setEditable(false);

					formulario.txtBusquedaContratosEmpleados.requestFocusInWindow();

				}

			} catch (HeadlessException ex) {
				JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente",
						" .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);
			}
		}

		/* Pasar datos de la tabla al formulario para ver los datos */
		if (e.getSource() == formulario.btnVer) {
			int filaseleccionada;
			try {
				filaseleccionada = formulario.tabla.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					String codigo = formulario.tabla.getValueAt(filaseleccionada, 0).toString();
					String nombre = formulario.tabla.getValueAt(filaseleccionada, 1).toString();
					String precio = formulario.tabla.getValueAt(filaseleccionada, 2).toString();
					String descripcion = formulario.tabla.getValueAt(filaseleccionada, 3).toString();
					String peso = formulario.tabla.getValueAt(filaseleccionada, 4).toString();
					String color = formulario.tabla.getValueAt(filaseleccionada, 5).toString();
					String marca = formulario.tabla.getValueAt(filaseleccionada, 6).toString();
					String modelo = formulario.tabla.getValueAt(filaseleccionada, 7).toString();
					String cantidad = formulario.tabla.getValueAt(filaseleccionada, 8).toString();
					String existencia = formulario.tabla.getValueAt(filaseleccionada, 9).toString();
					String fecha = formulario.tabla.getValueAt(filaseleccionada, 10).toString();

					formulario.txtCodigo.setText(codigo);
					formulario.txtNombre.setText(nombre);
					formulario.txtPrecio.setText(precio);
					formulario.txtDescripcion.setText(descripcion);
					formulario.txtPeso.setText(peso);
					formulario.txtColor.setText(color);
					formulario.txtMarca.setText(marca);
					formulario.txtModelo.setText(modelo);
					formulario.txtCantidad.setText(cantidad);
					formulario.txtExistencia.setText(existencia);
					formulario.editor.setText(fecha);

					formulario.txtCodigo.setForeground(Color.BLACK);
					formulario.txtNombre.setForeground(Color.BLACK);
					formulario.txtPrecio.setForeground(Color.BLACK);
					formulario.txtDescripcion.setForeground(Color.BLACK);
					formulario.txtPeso.setForeground(Color.BLACK);
					formulario.txtColor.setForeground(Color.BLACK);
					formulario.txtMarca.setForeground(Color.BLACK);
					formulario.txtModelo.setForeground(Color.BLACK);
					formulario.txtCantidad.setForeground(Color.BLACK);
					formulario.txtExistencia.setForeground(Color.BLACK);

					formulario.txtCodigo.setEditable(false);
					formulario.txtNombre.setEditable(false);
					formulario.txtPrecio.setEditable(false);
					formulario.txtDescripcion.setEditable(false);
					formulario.txtPeso.setEditable(false);
					formulario.txtColor.setEditable(false);
					formulario.txtMarca.setEditable(false);
					formulario.txtModelo.setEditable(false);
					formulario.txtCantidad.setEditable(false);
					formulario.txtExistencia.setEditable(false);

					formulario.btnBorrar.setVisible(false);
					formulario.btnGuardar.setVisible(false);
					formulario.btnNuevo.setVisible(false);
					formulario.btnActualizar.setVisible(false);
					formulario.btnActualizarDatos.setVisible(false);
					formulario.btnAceptar.setText("Aceptar");
					formulario.btnAceptar.setVisible(true);

				}

			} catch (HeadlessException ex) {
				JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente",
						" .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);
			}
		}

		/* Borrar */
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
						ps = conn.prepareStatement("DELETE FROM inventario WHERE id_inventario=?");
						ps.setString(1, codigo);
						ps.execute();
						JOptionPane.showMessageDialog(null, "Objeto Eliminado!");
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

		/* Nuevo */
		if (e.getSource() == formulario.btnNuevo) {
			limpiar();
			limpiar();
			formulario.obtenerUltimoId();
			formulario.btnBorrar.setVisible(false);
			formulario.btnGuardar.setVisible(true);
			formulario.btnNuevo.setVisible(true);
			formulario.btnActualizar.setVisible(false);
			formulario.btnActualizarDatos.setVisible(true);
			formulario.btnVer.setVisible(true);
			formulario.btnAceptar.setVisible(false);
			formulario.pistas();
			formulario.construirTabla();
		}

		/* Aceptar */
		if (e.getSource() == formulario.btnAceptar) {
			limpiar();
			formulario.btnBorrar.setVisible(false);
			formulario.btnGuardar.setVisible(true);
			formulario.btnNuevo.setVisible(true);
			formulario.btnActualizar.setVisible(false);
			formulario.btnActualizarDatos.setVisible(true);
			formulario.btnVer.setVisible(true);
			formulario.btnAceptar.setVisible(false);
			formulario.txtCodigo.setEnabled(true);
			formulario.txtCodigo.setEditable(false);
			formulario.obtenerUltimoId();
			formulario.pistas();
			formulario.construirTabla();
			formulario.establecerFechaRegistro();
			formulario.txtNombre.setEditable(true);
			formulario.txtPrecio.setEditable(true);
			formulario.txtDescripcion.setEditable(true);
			formulario.txtPeso.setEditable(true);
			formulario.txtColor.setEditable(true);
			formulario.txtMarca.setEditable(true);
			formulario.txtModelo.setEditable(true);
			formulario.txtCantidad.setEditable(true);
			formulario.txtExistencia.setText("0");
			formulario.txtNombre.requestFocusInWindow();
		}

	}

	/* Metodos para implementar */

	/* Metodo para el boton nuevo que limpia los datos de los txtFields */
	public void limpiar() {
		formulario.txtBusquedaContratosEmpleados.setText(null);
		formulario.txtCodigo.setText(null);
		formulario.txtNombre.setText(null);
		formulario.txtPrecio.setText(null);
		formulario.txtDescripcion.setText(null);
		formulario.txtPeso.setText(null);
		formulario.txtColor.setText(null);
		formulario.txtMarca.setText(null);
		formulario.txtModelo.setText(null);
		formulario.txtExistencia.setText(null);
		formulario.txtCantidad.setText(null);
	}

	/* Metodos para mostrar datos en tabla Contratos de los empleados */
	public static ArrayList<inventario> buscarUsuariosConMatriz() {
		conexion conex = new conexion();
		ArrayList<inventario> miLista = new ArrayList<inventario>();
		inventario inventario;
		try {
			Statement estatuto = conex.getConexion().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT * FROM inventario");

			while (rs.next()) {
				inventario = new inventario();
				inventario.setId_inventario(Integer.parseInt(rs.getString("id_inventario")));
				inventario.setNombre_objeto_inventario(rs.getString("nombre_objeto_inventario"));
				inventario.setPrecio_objeto_inventario(rs.getDouble("precio_objeto_inventario"));
				inventario.setDescripcion_objeto_inventario(rs.getString("descripcion_objeto_inventario"));
				inventario.setPeso_objeto_inventario(rs.getString("peso_objeto_inventario"));
				inventario.setColor_objeto_inventario(rs.getString("color_objeto_inventario"));
				inventario.setMarca_objeto_inventario(rs.getString("marca_objeto_inventario"));
				inventario.setModelo_objeto_inventario(rs.getString("modelo_objeto_inventario"));
				inventario.setCantidad_objeto_inventario(Integer.parseInt(rs.getString("cantidad_objeto_inventario")));
				inventario.setExistencias_objeto_inventario(
						Integer.parseInt(rs.getString("existencias_objeto_inventario")));
				inventario.setFecha_registro_inventario(rs.getString("fecha_registro_inventario"));
				miLista.add(inventario);
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
		ArrayList<inventario> miLista = buscarUsuariosConMatriz();
		String matrizInfo[][] = new String[miLista.size()][11];
		for (int i = 0; i < miLista.size(); i++) {
			matrizInfo[i][0] = miLista.get(i).getId_inventario() + "";
			matrizInfo[i][1] = miLista.get(i).getNombre_objeto_inventario() + "";
			matrizInfo[i][2] = miLista.get(i).getPrecio_objeto_inventario() + "";
			matrizInfo[i][3] = miLista.get(i).getDescripcion_objeto_inventario() + "";
			matrizInfo[i][4] = miLista.get(i).getPeso_objeto_inventario() + "";
			matrizInfo[i][5] = miLista.get(i).getColor_objeto_inventario() + "";
			matrizInfo[i][6] = miLista.get(i).getMarca_objeto_inventario() + "";
			matrizInfo[i][7] = miLista.get(i).getModelo_objeto_inventario() + "";
			matrizInfo[i][8] = miLista.get(i).getCantidad_objeto_inventario() + "";
			matrizInfo[i][9] = miLista.get(i).getExistencias_objeto_inventario() + "";
			matrizInfo[i][10] = miLista.get(i).getFecha_registro_inventario() + "";

		}

		return matrizInfo;
	}

}
