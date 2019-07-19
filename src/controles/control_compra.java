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

import clases.compra;
import clases.inventario;
import conexion.conexion;
import consultas.consultas_compra;
import consultas.consultas_inventario;
import formularios.registro_compras;
import formularios.registro_inventario;

public class control_compra implements ActionListener {

	public compra clase;
	public consultas_compra consulta;
	public registro_compras formulario;

	public inventario clase2;
	public consultas_inventario consulta2;
	public registro_inventario formulario2;

	public control_compra(compra clase, inventario clase2, consultas_compra consulta, consultas_inventario consulta2,
			registro_compras formulario, registro_inventario formulario2) {
		this.clase = clase;
		this.consulta = consulta;
		this.formulario = formulario;
		this.clase2 = clase2;
		this.consulta2 = consulta2;
		this.formulario2 = formulario2;
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
				JOptionPane.showMessageDialog(null, "Porfavor llene los campos para guardar la compra!");
			} else {
				clase.setNombre_objeto_compra(formulario.txtNombre.getText().toString());
				clase.setPrecio_objeto_compra(Double.parseDouble(formulario.txtPrecio.getText().toString()));
				clase.setDescripcion_objeto_compra(formulario.txtDescripcion.getText().toString());
				clase.setPeso_objeto_compra(formulario.txtPeso.getText().toString());
				clase.setColor_objeto_compra(formulario.txtColor.getText().toString());
				clase.setMarca_objeto_compra(formulario.txtMarca.getText().toString());
				clase.setModelo_objeto_compra(formulario.txtModelo.getText().toString());
				clase.setCantidad_objeto_compra(Integer.parseInt(formulario.txtCantidad.getText().toString()));
				clase.setFecha_registro_compra(formulario.editor.getText().toString());

				clase2.setNombre_objeto_inventario(formulario.txtNombre.getText().toString());
				clase2.setPrecio_objeto_inventario(Double.parseDouble(formulario.txtPrecio.getText().toString()));
				clase2.setDescripcion_objeto_inventario(formulario.txtDescripcion.getText().toString());
				clase2.setPeso_objeto_inventario(formulario.txtPeso.getText().toString());
				clase2.setColor_objeto_inventario(formulario.txtColor.getText().toString());
				clase2.setMarca_objeto_inventario(formulario.txtMarca.getText().toString());
				clase2.setModelo_objeto_inventario(formulario.txtModelo.getText().toString());
				clase2.setCantidad_objeto_inventario(Integer.parseInt(formulario.txtCantidad.getText().toString()));
				clase2.setExistencias_objeto_inventario(Integer.parseInt(formulario.txtCantidad.getText().toString()));
				clase2.setFecha_registro_inventario(formulario.editor.getText().toString());

				if (consulta.insertar(clase) && consulta2.insertar(clase2)) {
					JOptionPane.showMessageDialog(null, "Compra registrada!");
					limpiar();
					formulario.construirTabla();
					formulario.obtenerUltimoId();
				} else {
					JOptionPane.showMessageDialog(null, "Error! compra no registrada");
					limpiar();
				}
			}
		}

		if (e.getSource() == formulario.btnActualizar) {
			if (formulario.txtNombre.getText().isEmpty() || formulario.txtDescripcion.getText().isEmpty()
					|| formulario.txtColor.getText().isEmpty() || formulario.txtCantidad.getText().isEmpty()
					|| formulario.txtMarca.getText().isEmpty() || formulario.txtPrecio.getText().isEmpty()
					|| formulario.txtPeso.getText().isEmpty() || formulario.txtModelo.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Porfavor llene los campos para actualizar la compra!");
			} else {
				clase.setId_compra(Integer.parseInt(formulario.txtCodigo.getText().toString()));
				clase.setNombre_objeto_compra(formulario.txtNombre.getText().toString());
				clase.setPrecio_objeto_compra(Double.parseDouble(formulario.txtPrecio.getText().toString()));
				clase.setDescripcion_objeto_compra(formulario.txtDescripcion.getText().toString());
				clase.setPeso_objeto_compra(formulario.txtPeso.getText().toString());
				clase.setColor_objeto_compra(formulario.txtColor.getText().toString());
				clase.setMarca_objeto_compra(formulario.txtMarca.getText().toString());
				clase.setModelo_objeto_compra(formulario.txtModelo.getText().toString());
				clase.setCantidad_objeto_compra(Integer.parseInt(formulario.txtCantidad.getText().toString()));
				clase.setFecha_registro_compra(formulario.editor.getText().toString());

				clase2.setId_inventario(Integer.parseInt(formulario.txtCodigo.getText().toString()));
				clase2.setNombre_objeto_inventario(formulario.txtNombre.getText().toString());
				clase2.setPrecio_objeto_inventario(Double.parseDouble(formulario.txtPrecio.getText().toString()));
				clase2.setDescripcion_objeto_inventario(formulario.txtDescripcion.getText().toString());
				clase2.setPeso_objeto_inventario(formulario.txtPeso.getText().toString());
				clase2.setColor_objeto_inventario(formulario.txtColor.getText().toString());
				clase2.setMarca_objeto_inventario(formulario.txtMarca.getText().toString());
				clase2.setModelo_objeto_inventario(formulario.txtModelo.getText().toString());
				clase2.setCantidad_objeto_inventario(Integer.parseInt(formulario.txtCantidad.getText().toString()));
				clase2.setExistencias_objeto_inventario(Integer.parseInt(formulario.txtCantidad.getText().toString()));
				clase2.setFecha_registro_inventario(formulario.editor.getText().toString());

				if (consulta.actualizar(clase) && consulta2.actualizar(clase2)) {
					JOptionPane.showMessageDialog(null, "compra actualizada!");
					limpiar();
					formulario.construirTabla();
					formulario.txtCodigo.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "Error! compra no actualizada");
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
					String fecha = formulario.tabla.getValueAt(filaseleccionada, 9).toString();

					formulario.txtCodigo.setText(codigo);
					formulario.txtNombre.setText(nombre);
					formulario.txtPrecio.setText(precio);
					formulario.txtDescripcion.setText(descripcion);
					formulario.txtPeso.setText(peso);
					formulario.txtColor.setText(color);
					formulario.txtMarca.setText(marca);
					formulario.txtModelo.setText(modelo);
					formulario.txtCantidad.setText(cantidad);
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

					formulario.btnBorrar.setVisible(true);
					formulario.btnGuardar.setVisible(false);
					formulario.btnNuevo.setVisible(false);
					formulario.btnActualizar.setVisible(true);
					formulario.btnActualizarDatos.setVisible(true);
					formulario.btnVer.setVisible(false);
					formulario.btnAceptar.setText("Cancelar");
					formulario.btnAceptar.setVisible(true);

					formulario.txtCantidad.setEditable(false);

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
					String fecha = formulario.tabla.getValueAt(filaseleccionada, 9).toString();

					formulario.txtCodigo.setText(codigo);
					formulario.txtNombre.setText(nombre);
					formulario.txtPrecio.setText(precio);
					formulario.txtDescripcion.setText(descripcion);
					formulario.txtPeso.setText(peso);
					formulario.txtColor.setText(color);
					formulario.txtMarca.setText(marca);
					formulario.txtModelo.setText(modelo);
					formulario.txtCantidad.setText(cantidad);
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

					formulario.txtCodigo.setEditable(false);
					formulario.txtNombre.setEditable(false);
					formulario.txtPrecio.setEditable(false);
					formulario.txtDescripcion.setEditable(false);
					formulario.txtPeso.setEditable(false);
					formulario.txtColor.setEditable(false);
					formulario.txtMarca.setEditable(false);
					formulario.txtModelo.setEditable(false);
					formulario.txtCantidad.setEditable(false);

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
					conexion objCon = new conexion();
					Connection conn = objCon.getConexion();
					int Fila = formulario.tabla.getSelectedRow();
					String codigo = formulario.tabla.getValueAt(Fila, 0).toString();
					ps = conn.prepareStatement("DELETE FROM compras WHERE id_compra=?");
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

				}
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "Error al Eliminar");
				System.out.println(ex.toString());
			}
		}

		/* Nuevo */
		if (e.getSource() == formulario.btnNuevo) {
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
		formulario.txtCantidad.setText(null);
	}

	/* Metodos para mostrar datos en tabla Contratos de los empleados */
	public static ArrayList<compra> buscarUsuariosConMatriz() {
		conexion conex = new conexion();
		ArrayList<compra> miLista = new ArrayList<compra>();
		compra compra;
		try {
			Statement estatuto = conex.getConexion().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT * FROM compras");

			while (rs.next()) {
				compra = new compra();
				compra.setId_compra(Integer.parseInt(rs.getString("id_compra")));
				compra.setNombre_objeto_compra(rs.getString("nombre_objeto_compra"));
				compra.setPrecio_objeto_compra(rs.getDouble("precio_objeto_compra"));
				compra.setDescripcion_objeto_compra(rs.getString("descripcion_objeto_compra"));
				compra.setPeso_objeto_compra(rs.getString("peso_objeto_compra"));
				compra.setColor_objeto_compra(rs.getString("color_objeto_compra"));
				compra.setMarca_objeto_compra(rs.getString("marca_objeto_compra"));
				compra.setModelo_objeto_compra(rs.getString("modelo_objeto_compra"));
				compra.setCantidad_objeto_compra(Integer.parseInt(rs.getString("cantidad_objeto_compra")));
				compra.setFecha_registro_compra(rs.getString("fecha_registro_compra"));
				miLista.add(compra);
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
		ArrayList<compra> miLista = buscarUsuariosConMatriz();
		String matrizInfo[][] = new String[miLista.size()][10];
		for (int i = 0; i < miLista.size(); i++) {
			matrizInfo[i][0] = miLista.get(i).getId_compra() + "";
			matrizInfo[i][1] = miLista.get(i).getNombre_objeto_compra() + "";
			matrizInfo[i][2] = miLista.get(i).getPrecio_objeto_compra() + "";
			matrizInfo[i][3] = miLista.get(i).getDescripcion_objeto_compra() + "";
			matrizInfo[i][4] = miLista.get(i).getPeso_objeto_compra() + "";
			matrizInfo[i][5] = miLista.get(i).getColor_objeto_compra() + "";
			matrizInfo[i][6] = miLista.get(i).getMarca_objeto_compra() + "";
			matrizInfo[i][7] = miLista.get(i).getModelo_objeto_compra() + "";
			matrizInfo[i][8] = miLista.get(i).getCantidad_objeto_compra() + "";
			matrizInfo[i][9] = miLista.get(i).getFecha_registro_compra() + "";

		}

		return matrizInfo;
	}

}
