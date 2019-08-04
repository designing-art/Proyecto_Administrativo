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

import clases.factura_empresa;
import conexion.conexion;
import consultas.consultas_factura_empresa;
import formularios.login_usuario;
import formularios.registro_facturas_empresa;

public class control_factura_empresa implements ActionListener {

	public factura_empresa clase;
	public consultas_factura_empresa consulta;
	public registro_facturas_empresa formulario;

	public control_factura_empresa(factura_empresa clase, consultas_factura_empresa consulta,
			registro_facturas_empresa formulario) {
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
			if (registro_facturas_empresa.txtFechaHoraFactura.getText().isEmpty()
					|| formulario.txtFoto.getText().isEmpty() || formulario.txtCompra.getText().isEmpty()
					|| formulario.txtPrecio.getText().isEmpty() || formulario.txtCantidad.getText().isEmpty()
					|| formulario.txtDescripcion.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Porfavor llene los campos para guardar la factura!");
			} else {
				clase.setFecha_factura(registro_facturas_empresa.txtFechaHoraFactura.getText().toString());
				clase.setCompra_factura(formulario.txtCompra.getText().toString());
				clase.setPrecio_factura(Double.parseDouble(formulario.txtPrecio.getText().toString()));
				clase.setCantidad_factura(formulario.txtCantidad.getText().toString());
				clase.setDescripcion_factura(formulario.txtDescripcion.getText().toString());
				clase.setFoto_factura(formulario.txtFoto.getText().toString());

				if (consulta.insertar(clase)) {
					JOptionPane.showMessageDialog(null, "Factura registrada!");
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
			if (registro_facturas_empresa.txtFechaHoraFactura.getText().isEmpty()
					|| formulario.txtFoto.getText().isEmpty() || formulario.txtCompra.getText().isEmpty()
					|| formulario.txtPrecio.getText().isEmpty() || formulario.txtCantidad.getText().isEmpty()
					|| formulario.txtDescripcion.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Porfavor llene los campos para actualizar la compra!");
			} else {
				clase.setId_factura(Integer.parseInt(formulario.txtCodigo.getText().toString()));
				clase.setFecha_factura(registro_facturas_empresa.txtFechaHoraFactura.getText().toString());
				clase.setCompra_factura(formulario.txtCompra.getText().toString());
				clase.setPrecio_factura(Double.parseDouble(formulario.txtDescripcion.getText().toString()));
				clase.setCantidad_factura(formulario.txtCantidad.getText().toString());
				clase.setDescripcion_factura(formulario.txtDescripcion.getText().toString());
				clase.setFoto_factura(formulario.txtFoto.getText().toString());

				if (consulta.actualizar(clase)) {
					JOptionPane.showMessageDialog(null, "Factura actualizada!");
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
					String fecha = formulario.tabla.getValueAt(filaseleccionada, 1).toString();
					String compra = formulario.tabla.getValueAt(filaseleccionada, 2).toString();
					String precio = formulario.tabla.getValueAt(filaseleccionada, 3).toString();
					String cantidad = formulario.tabla.getValueAt(filaseleccionada, 4).toString();
					String descrip = formulario.tabla.getValueAt(filaseleccionada, 5).toString();
					String foto = formulario.tabla.getValueAt(filaseleccionada, 6).toString();

					formulario.txtCodigo.setText(codigo);
					registro_facturas_empresa.txtFechaHoraFactura.setText(fecha);
					formulario.txtCompra.setText(compra);
					formulario.txtPrecio.setText(precio);
					formulario.txtCantidad.setText(cantidad);
					formulario.txtDescripcion.setText(descrip);
					formulario.txtFoto.setText(foto);

					formulario.txtCodigo.setForeground(Color.BLACK);
					registro_facturas_empresa.txtFechaHoraFactura.setForeground(Color.BLACK);
					formulario.txtCompra.setForeground(Color.BLACK);
					formulario.txtPrecio.setForeground(Color.BLACK);
					formulario.txtCantidad.setForeground(Color.BLACK);
					formulario.txtDescripcion.setForeground(Color.BLACK);
					formulario.txtFoto.setForeground(Color.BLACK);

					formulario.btnBorrar.setVisible(true);
					formulario.btnGuardar.setVisible(false);
					formulario.btnNuevo.setVisible(false);
					formulario.btnActualizar.setVisible(true);
					formulario.btnActualizarDatos.setVisible(true);
					formulario.btnVer.setVisible(false);
					formulario.btnAceptar.setText("Cancelar");
					formulario.btnAceptar.setVisible(true);

					formulario.txtCantidad.setEditable(false);

					formulario.txtCompra.requestFocusInWindow();

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
					String fecha = formulario.tabla.getValueAt(filaseleccionada, 1).toString();
					String compra = formulario.tabla.getValueAt(filaseleccionada, 2).toString();
					String precio = formulario.tabla.getValueAt(filaseleccionada, 3).toString();
					String cantidad = formulario.tabla.getValueAt(filaseleccionada, 4).toString();
					String descrip = formulario.tabla.getValueAt(filaseleccionada, 5).toString();
					String foto = formulario.tabla.getValueAt(filaseleccionada, 6).toString();

					formulario.txtCodigo.setText(codigo);
					registro_facturas_empresa.txtFechaHoraFactura.setText(fecha);
					formulario.txtCompra.setText(compra);
					formulario.txtPrecio.setText(precio);
					formulario.txtCantidad.setText(cantidad);
					formulario.txtDescripcion.setText(descrip);
					formulario.txtFoto.setText(foto);

					formulario.txtCodigo.setForeground(Color.BLACK);
					registro_facturas_empresa.txtFechaHoraFactura.setForeground(Color.BLACK);
					formulario.txtCompra.setForeground(Color.BLACK);
					formulario.txtPrecio.setForeground(Color.BLACK);
					formulario.txtCantidad.setForeground(Color.BLACK);
					formulario.txtDescripcion.setForeground(Color.BLACK);
					formulario.txtFoto.setForeground(Color.BLACK);

					registro_facturas_empresa.txtFechaHoraFactura.setEditable(false);
					formulario.txtPrecio.setEditable(false);
					formulario.txtDescripcion.setEditable(false);
					formulario.txtFoto.setEditable(false);
					formulario.txtDescripcion.setEditable(false);
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
					if (login_usuario.cargoUsuario.toString() == "Usuario Avanzado") {

						conexion objCon = new conexion();
						Connection conn = objCon.getConexion();
						int Fila = formulario.tabla.getSelectedRow();
						String codigo = formulario.tabla.getValueAt(Fila, 0).toString();
						ps = conn.prepareStatement("DELETE FROM facturas_compras WHERE id_factura=?");
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
			registro_facturas_empresa.txtFechaHoraFactura.setEditable(false);
			formulario.txtPrecio.setEditable(false);
			formulario.txtDescripcion.setEditable(false);
			formulario.txtFoto.setEditable(false);
			formulario.txtDescripcion.setEditable(false);
			formulario.txtCantidad.setEditable(false);
			formulario.txtCompra.requestFocusInWindow();
		}

	}

	/* Metodos para implementar */

	/* Metodo para el boton nuevo que limpia los datos de los txtFields */
	public void limpiar() {
		formulario.txtBusqueda.setText(null);
		formulario.txtCodigo.setText(null);
		formulario.txtCompra.setText(null);
		formulario.txtPrecio.setText(null);
		formulario.txtDescripcion.setText(null);
		formulario.txtCantidad.setText(null);
		formulario.txtDescripcion.setText(null);
		formulario.txtFoto.setText(null);
	}

	public static ArrayList<factura_empresa> buscarUsuariosConMatriz() {
		conexion conex = new conexion();
		ArrayList<factura_empresa> miLista = new ArrayList<factura_empresa>();
		factura_empresa factura_empresa;
		try {
			Statement estatuto = conex.getConexion().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT * FROM facturas_compras");

			while (rs.next()) {
				factura_empresa = new factura_empresa();
				factura_empresa.setId_factura(Integer.parseInt(rs.getString("id_factura")));
				factura_empresa.setFecha_factura(rs.getString("fecha_factura"));
				factura_empresa.setCompra_factura(rs.getString("compra_factura"));
				factura_empresa.setPrecio_factura(rs.getDouble("precio_factura"));
				factura_empresa.setCantidad_factura(rs.getString("cantidad_factura"));
				factura_empresa.setDescripcion_factura(rs.getString("descripcion_factura"));
				factura_empresa.setFoto_factura(rs.getString("foto_factura"));
				miLista.add(factura_empresa);
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
		ArrayList<factura_empresa> miLista = buscarUsuariosConMatriz();
		String matrizInfo[][] = new String[miLista.size()][7];
		for (int i = 0; i < miLista.size(); i++) {
			matrizInfo[i][0] = miLista.get(i).getId_factura() + "";
			matrizInfo[i][1] = miLista.get(i).getFecha_factura() + "";
			matrizInfo[i][2] = miLista.get(i).getCompra_factura() + "";
			matrizInfo[i][3] = miLista.get(i).getPrecio_factura() + "";
			matrizInfo[i][4] = miLista.get(i).getCantidad_factura() + "";
			matrizInfo[i][5] = miLista.get(i).getDescripcion_factura() + "";
			matrizInfo[i][6] = miLista.get(i).getFoto_factura() + "";
		}

		return matrizInfo;
	}

}
