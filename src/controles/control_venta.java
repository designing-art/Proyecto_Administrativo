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

import clases.factura_cliente;
import clases.ingreso;
import clases.inventario;
import clases.sar;
import clases.venta;
import conexion.conexion;
import consultas.consultas_factura_cliente;
import consultas.consultas_ingreso;
import consultas.consultas_inventario;
import consultas.consultas_venta;
import formularios.login_usuario;
import formularios.registro_facturas_clientes;
import formularios.registro_ingresos;
import formularios.registro_ventas;

public class control_venta implements ActionListener {

	public venta clase;
	public consultas_venta consulta;
	public registro_ventas formulario;

	public inventario clase2;
	public consultas_inventario consulta2;
	public registro_ingresos formulario2;

	public ingreso clase3;
	public consultas_ingreso consulta3;
	public registro_ingresos formulario3;

	public static String identidad = null;

	public static int cantidad = 0;
	public static int existencia = 0;

	public control_venta(venta clase, inventario clase2, ingreso clase3, consultas_venta consulta,
			registro_ventas formulario, registro_ingresos formulario2) {
		this.clase = clase;
		this.clase2 = clase2;
		this.clase3 = clase3;
		this.consulta = consulta;
		this.formulario = formulario;
		this.formulario2 = formulario2;
		this.formulario.btnGuardar.addActionListener(this);
		this.formulario.btnNuevo.addActionListener(this);
		this.formulario.btnActualizar.addActionListener(this);
		this.formulario.btnActualizarDatos.addActionListener(this);
		this.formulario.btnBorrar.addActionListener(this);
		this.formulario.btnVer.addActionListener(this);
		this.formulario.btnAceptar.addActionListener(this);
		this.formulario.btnVerder.addActionListener(this);
		this.formulario2.btnMostrar.addActionListener(this);
		this.formulario2.btnAceptar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == formulario.btnGuardar) {
			if (formulario.txtNombre.getText().isEmpty() || formulario.txtDescripcion.getText().isEmpty()
					|| formulario.txtColor.getText().isEmpty() || formulario.txtCantidadVenta.getText().isEmpty()
					|| formulario.txtMarca.getText().isEmpty() || formulario.txtPrecioCompra.getText().isEmpty()
					|| formulario.txtPeso.getText().isEmpty() || formulario.txtModelo.getText().isEmpty()
					|| formulario.txtPrecioVenta.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Porfavor llene los campos para guardar la venta!");
			} else {
				existencia = Integer.parseInt(formulario.txtExistencia.getText().toString());
				cantidad = Integer.parseInt(formulario.txtCantidadVenta.getText().toString());
				if (cantidad > existencia) {
					JOptionPane.showMessageDialog(null, "Cantidad de venta incorrecta!\n" + "imposible hacer la venta\n"
							+ "No hay suficiente existencia.\n");
				} else {
					if (existencia == 0) {
						JOptionPane.showMessageDialog(null, "No hay productos disponibles para la venta.");
					} else {
						formulario.restarVenta();
						clase.setNombre_objeto_venta(formulario.txtNombre.getText().toString());
						clase.setDescripcion_objeto_venta(formulario.txtDescripcion.getText().toString());
						clase.setPeso_objeto_venta(formulario.txtPeso.getText().toString());
						clase.setColor_objeto_venta(formulario.txtColor.getText().toString());
						clase.setMarca_objeto_venta(formulario.txtMarca.getText().toString());
						clase.setModelo_objeto_venta(formulario.txtModelo.getText().toString());
						clase.setExistencia_objeto_venta(
								Integer.parseInt(formulario.txtExistencia.getText().toString()));
						clase.setCantidad_objeto_venta(
								Integer.parseInt(formulario.txtCantidadVenta.getText().toString()));
						clase.setPrecio_compra_venta(
								Double.parseDouble(formulario.txtPrecioCompra.getText().toString()));
						clase.setPrecio_venta(Double.parseDouble(formulario.txtPrecioVenta.getText().toString()));
						clase.setFecha_registro_venta(formulario.editor.getText().toString());

						clase2.setId_inventario(Integer.parseInt(formulario.txtCodigoInventario.getText().toString()));
						clase2.setExistencias_objeto_inventario(
								Integer.parseInt(formulario.txtExistencia.getText().toString()));

						clase3.setTipo_ingreso("Venta de : " + formulario.txtNombre.getText().toString());
						clase3.setCantidad_ingreso(Double.parseDouble(formulario.txtPrecioVenta.getText().toString()));
						clase3.setDescripcion_ingreso(
								"Caracteristicas de la venta : " + formulario.txtDescripcion.getText().toString());
						clase3.setFecha_ingreso(formulario.editor.getText().toString());

						if (consulta.insertar(clase) && consulta.actualizarInventario(clase2)
								&& consulta.insertarIngreso(clase3)) {
							JOptionPane.showMessageDialog(null, "Venta registrada!");
							limpiar();
							formulario.obtenerUltimoId();
							formulario.construirTablaVenta();
							formulario.construirTablaInventario();

							factura_cliente clase = new factura_cliente();
							consultas_factura_cliente consulta = new consultas_factura_cliente();
							registro_facturas_clientes formulario2 = new registro_facturas_clientes();
							sar clase2 = new sar();
							control_factura_cliente control = new control_factura_cliente(clase, consulta, formulario2,
									clase2);
							formulario2.setVisible(true);
							formulario2.setLocationRelativeTo(null);
							formulario2.txtCliente.requestFocusInWindow();
							formulario2.obtenerUltimoId();
							formulario2.pistas();
							formulario2.consultarEmpresa();
							formulario2.construirTabla();
							formulario2.establecerDatosEmpresa();
							formulario2.ObtenerUltimosDatosSar();
							formulario2.btnGuardar.setVisible(true);
							formulario2.btnNuevo.setVisible(true);
							formulario2.btnActualizar.setVisible(false);
							formulario2.btnAceptar.setVisible(false);
							formulario2.btnBorrar.setVisible(false);
							formulario2.setTitle("Sesión iniciada por: " + login_usuario.nombreCompletoUsuario);
							formulario2.txtEmpleado.setText(login_usuario.nombreCompletoUsuario);
							formulario.dispose();

						} else {
							JOptionPane.showMessageDialog(null, "Error! objeto no registrado");
							limpiar();
						}
					}
				}
			}
		}

		if (e.getSource() == formulario.btnActualizar) {
			if (formulario.txtNombre.getText().isEmpty() || formulario.txtDescripcion.getText().isEmpty()
					|| formulario.txtColor.getText().isEmpty() || formulario.txtCantidadVenta.getText().isEmpty()
					|| formulario.txtMarca.getText().isEmpty() || formulario.txtPrecioCompra.getText().isEmpty()
					|| formulario.txtPeso.getText().isEmpty() || formulario.txtModelo.getText().isEmpty()
					|| formulario.txtPrecioVenta.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Porfavor llene los campos para actualizar la venta!");
			} else {
				clase.setId_venta(Integer.parseInt(formulario.txtCodigo.getText().toString()));
				clase.setNombre_objeto_venta(formulario.txtNombre.getText().toString());
				clase.setDescripcion_objeto_venta(formulario.txtDescripcion.getText().toString());
				clase.setPeso_objeto_venta(formulario.txtPeso.getText().toString());
				clase.setColor_objeto_venta(formulario.txtColor.getText().toString());
				clase.setMarca_objeto_venta(formulario.txtMarca.getText().toString());
				clase.setModelo_objeto_venta(formulario.txtModelo.getText().toString());
				clase.setExistencia_objeto_venta(Integer.parseInt(formulario.txtExistencia.getText().toString()));
				clase.setCantidad_objeto_venta(Integer.parseInt(formulario.txtCantidadVenta.getText().toString()));
				clase.setPrecio_compra_venta(Double.parseDouble(formulario.txtPrecioCompra.getText().toString()));
				clase.setPrecio_venta(Double.parseDouble(formulario.txtPrecioVenta.getText().toString()));
				clase.setFecha_registro_venta(formulario.editor.getText().toString());
				if (consulta.actualizar(clase)) {
					JOptionPane.showMessageDialog(null, "Venta Actualizada!");
					limpiar();
					formulario.obtenerUltimoId();
					formulario.construirTablaVenta();
					formulario.construirTablaInventario();
				} else {
					JOptionPane.showMessageDialog(null, "Error! objeto no registrado");
					limpiar();
				}
			}
		}

		if (e.getSource() == formulario.btnActualizarDatos) {
			int filaseleccionada;
			try {
				filaseleccionada = formulario.tablaVentas.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					String codigo = formulario.tablaVentas.getValueAt(filaseleccionada, 0).toString();
					String nombre = formulario.tablaVentas.getValueAt(filaseleccionada, 1).toString();
					String descripcion = formulario.tablaVentas.getValueAt(filaseleccionada, 2).toString();
					String peso = formulario.tablaVentas.getValueAt(filaseleccionada, 3).toString();
					String color = formulario.tablaVentas.getValueAt(filaseleccionada, 4).toString();
					String marca = formulario.tablaVentas.getValueAt(filaseleccionada, 5).toString();
					String modelo = formulario.tablaVentas.getValueAt(filaseleccionada, 6).toString();
					String existencia = formulario.tablaVentas.getValueAt(filaseleccionada, 8).toString();
					String cantidad = formulario.tablaVentas.getValueAt(filaseleccionada, 7).toString();
					String compra = formulario.tablaVentas.getValueAt(filaseleccionada, 9).toString();
					String venta = formulario.tablaVentas.getValueAt(filaseleccionada, 10).toString();
					String registro = formulario.tablaVentas.getValueAt(filaseleccionada, 11).toString();

					formulario.txtCodigo.setText(codigo);
					formulario.txtNombre.setText(nombre);
					formulario.txtDescripcion.setText(descripcion);
					formulario.txtPeso.setText(peso);
					formulario.txtColor.setText(color);
					formulario.txtMarca.setText(marca);
					formulario.txtModelo.setText(modelo);
					formulario.txtExistencia.setText(existencia);
					formulario.txtCantidadVenta.setText(cantidad);
					formulario.txtPrecioCompra.setText(compra);
					formulario.txtPrecioVenta.setText(venta);
					formulario.editor.setText(registro);

					formulario.txtCodigo.setForeground(Color.BLACK);
					formulario.txtNombre.setForeground(Color.BLACK);
					formulario.txtPrecioCompra.setForeground(Color.BLACK);
					formulario.txtPrecioVenta.setForeground(Color.BLACK);
					formulario.txtDescripcion.setForeground(Color.BLACK);
					formulario.txtPeso.setForeground(Color.BLACK);
					formulario.txtColor.setForeground(Color.BLACK);
					formulario.txtMarca.setForeground(Color.BLACK);
					formulario.txtModelo.setForeground(Color.BLACK);
					formulario.txtCantidadVenta.setForeground(Color.BLACK);
					formulario.txtExistencia.setForeground(Color.BLACK);

					formulario.btnBorrar.setVisible(true);
					formulario.btnGuardar.setVisible(false);
					formulario.btnNuevo.setVisible(false);
					formulario.btnActualizar.setVisible(true);
					formulario.btnActualizarDatos.setVisible(true);
					formulario.btnVer.setVisible(false);
					formulario.btnAceptar.setText("Cancelar");
					formulario.btnAceptar.setVisible(true);

					formulario.txtCantidadVenta.requestFocusInWindow();

				}

			} catch (HeadlessException ex) {
				JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente",
						" .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);
			}
		}

		// METODO PARA PASAR LOS DATOS A LA VENTA DEL PRODUCTO
		if (e.getSource() == formulario.btnVerder) {
			int filaseleccionada;
			try {
				filaseleccionada = formulario.tablaInventario.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					String codigo = formulario.tablaInventario.getValueAt(filaseleccionada, 0).toString();
					String nombre = formulario.tablaInventario.getValueAt(filaseleccionada, 1).toString();
					String descripcion = formulario.tablaInventario.getValueAt(filaseleccionada, 3).toString();
					String peso = formulario.tablaInventario.getValueAt(filaseleccionada, 4).toString();
					String color = formulario.tablaInventario.getValueAt(filaseleccionada, 5).toString();
					String marca = formulario.tablaInventario.getValueAt(filaseleccionada, 6).toString();
					String modelo = formulario.tablaInventario.getValueAt(filaseleccionada, 7).toString();
					String existencia = formulario.tablaInventario.getValueAt(filaseleccionada, 9).toString();
					String compra = formulario.tablaInventario.getValueAt(filaseleccionada, 2).toString();

					formulario.txtCodigoInventario.setText(codigo);
					formulario.txtNombre.setText(nombre);
					formulario.txtDescripcion.setText(descripcion);
					formulario.txtPeso.setText(peso);
					formulario.txtColor.setText(color);
					formulario.txtMarca.setText(marca);
					formulario.txtModelo.setText(modelo);
					formulario.txtExistencia.setText(existencia);
					formulario.txtPrecioCompra.setText(compra);

					formulario.txtCodigo.setForeground(Color.BLACK);
					formulario.txtNombre.setForeground(Color.BLACK);
					formulario.txtPrecioCompra.setForeground(Color.BLACK);
					formulario.txtPrecioVenta.setForeground(Color.BLACK);
					formulario.txtDescripcion.setForeground(Color.BLACK);
					formulario.txtPeso.setForeground(Color.BLACK);
					formulario.txtColor.setForeground(Color.BLACK);
					formulario.txtMarca.setForeground(Color.BLACK);
					formulario.txtModelo.setForeground(Color.BLACK);
					formulario.txtCantidadVenta.setForeground(Color.BLACK);
					formulario.txtExistencia.setForeground(Color.BLACK);

					formulario.txtPrecioVenta.setEditable(true);
					formulario.txtCantidadVenta.setEditable(true);

					formulario.txtCantidadVenta.requestFocusInWindow();

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
				filaseleccionada = formulario.tablaVentas.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					String codigo = formulario.tablaVentas.getValueAt(filaseleccionada, 0).toString();
					String nombre = formulario.tablaVentas.getValueAt(filaseleccionada, 1).toString();
					String descripcion = formulario.tablaVentas.getValueAt(filaseleccionada, 2).toString();
					String peso = formulario.tablaVentas.getValueAt(filaseleccionada, 3).toString();
					String color = formulario.tablaVentas.getValueAt(filaseleccionada, 4).toString();
					String marca = formulario.tablaVentas.getValueAt(filaseleccionada, 5).toString();
					String modelo = formulario.tablaVentas.getValueAt(filaseleccionada, 6).toString();
					String existencia = formulario.tablaVentas.getValueAt(filaseleccionada, 8).toString();
					String cantidad = formulario.tablaVentas.getValueAt(filaseleccionada, 7).toString();
					String compra = formulario.tablaVentas.getValueAt(filaseleccionada, 9).toString();
					String venta = formulario.tablaVentas.getValueAt(filaseleccionada, 10).toString();
					String registro = formulario.tablaVentas.getValueAt(filaseleccionada, 11).toString();

					formulario.txtCodigo.setText(codigo);
					formulario.txtNombre.setText(nombre);
					formulario.txtDescripcion.setText(descripcion);
					formulario.txtPeso.setText(peso);
					formulario.txtColor.setText(color);
					formulario.txtMarca.setText(marca);
					formulario.txtModelo.setText(modelo);
					formulario.txtExistencia.setText(existencia);
					formulario.txtCantidadVenta.setText(cantidad);
					formulario.txtPrecioCompra.setText(compra);
					formulario.txtPrecioVenta.setText(venta);
					formulario.editor.setText(registro);

					formulario.txtCodigo.setForeground(Color.BLACK);
					formulario.txtNombre.setForeground(Color.BLACK);
					formulario.txtPrecioCompra.setForeground(Color.BLACK);
					formulario.txtPrecioVenta.setForeground(Color.BLACK);
					formulario.txtDescripcion.setForeground(Color.BLACK);
					formulario.txtPeso.setForeground(Color.BLACK);
					formulario.txtColor.setForeground(Color.BLACK);
					formulario.txtMarca.setForeground(Color.BLACK);
					formulario.txtModelo.setForeground(Color.BLACK);
					formulario.txtCantidadVenta.setForeground(Color.BLACK);
					formulario.txtExistencia.setForeground(Color.BLACK);

					formulario.txtPrecioVenta.setEditable(false);
					formulario.txtCantidadVenta.setEditable(false);

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

		if (e.getSource() == formulario2.btnMostrar) {
			int filaseleccionada;
			try {
				filaseleccionada = formulario2.tabla.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					String codigo = formulario2.tabla.getValueAt(filaseleccionada, 0).toString();
					String ingreso = formulario2.tabla.getValueAt(filaseleccionada, 1).toString();
					String cantidad = formulario2.tabla.getValueAt(filaseleccionada, 2).toString();
					String descripcion = formulario2.tabla.getValueAt(filaseleccionada, 3).toString();
					String fecha = formulario2.tabla.getValueAt(filaseleccionada, 4).toString();

					formulario2.txtCodigo.setText(codigo);
					formulario2.txtIngreso.setText(ingreso);
					formulario2.txtCantidad.setText(cantidad);
					formulario2.txtDescripcion.setText(descripcion);
					formulario2.editor.setText(fecha);

					formulario2.txtCodigo.setForeground(Color.BLACK);
					formulario2.txtIngreso.setForeground(Color.BLACK);
					formulario2.txtCantidad.setForeground(Color.BLACK);
					formulario2.txtDescripcion.setForeground(Color.BLACK);
					formulario2.editor.setForeground(Color.BLACK);

					formulario2.txtBusquedaCargos.requestFocusInWindow();

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
				filaseleccionada = formulario.tablaVentas.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					if (login_usuario.cargoUsuario.toString() == "Usuario Avanzado") {

						conexion objCon = new conexion();
						Connection conn = objCon.getConexion();
						int Fila = formulario.tablaVentas.getSelectedRow();
						String codigo = formulario.tablaVentas.getValueAt(Fila, 0).toString();
						ps = conn.prepareStatement("DELETE FROM ventas WHERE id_venta=?");
						ps.setString(1, codigo);
						ps.execute();
						JOptionPane.showMessageDialog(null, "Objeto Eliminado!");
						limpiar();
						formulario.construirTablaInventario();
						formulario.construirTablaVenta();
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
			formulario.construirTablaInventario();
			formulario.construirTablaVenta();
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
			formulario.construirTablaInventario();
			formulario.construirTablaVenta();
			formulario.establecerFechaRegistro();
			formulario.txtPrecioVenta.setEditable(true);
			formulario.txtCantidadVenta.setEditable(true);
			formulario.txtExistencia.setText("0");
			formulario.txtNombre.requestFocusInWindow();
		}

		/* Aceptar */
		if (e.getSource() == formulario2.btnAceptar) {
			limpiar2();
			formulario2.construirTabla();
			formulario2.txtBusquedaCargos.requestFocusInWindow();
		}

	}

	/* Metodos para implementar */

	/* Metodo para el boton nuevo que limpia los datos de los txtFields */
	public void limpiar() {
		formulario.txtBusquedaInventario.setText(null);
		formulario.txtBusquedaVentas.setText(null);
		formulario.txtCodigo.setText(null);
		formulario.txtNombre.setText(null);
		formulario.txtPrecioCompra.setText(null);
		formulario.txtPrecioVenta.setText(null);
		formulario.txtDescripcion.setText(null);
		formulario.txtPeso.setText(null);
		formulario.txtColor.setText(null);
		formulario.txtMarca.setText(null);
		formulario.txtModelo.setText(null);
		formulario.txtExistencia.setText(null);
		formulario.txtCantidadVenta.setText(null);
	}

	public void limpiar2() {
		formulario2.txtBusquedaCargos.setText(null);
		formulario2.txtCodigo.setText(null);
		formulario2.txtIngreso.setText(null);
		formulario2.txtCantidad.setText(null);
		formulario2.txtDescripcion.setText(null);
		formulario2.editor.setText(null);

	}

	/* Metodos para mostrar datos en tabla Contratos de los empleados */
	public static ArrayList<venta> buscarUsuariosConMatriz() {
		conexion conex = new conexion();
		ArrayList<venta> miLista = new ArrayList<venta>();
		venta venta;
		try {
			Statement estatuto = conex.getConexion().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT * FROM ventas");

			while (rs.next()) {
				venta = new venta();
				venta.setId_venta(Integer.parseInt(rs.getString("id_venta")));
				venta.setNombre_objeto_venta(rs.getString("nombre_objeto_venta"));
				venta.setDescripcion_objeto_venta(rs.getString("descripcion_objeto_venta"));
				venta.setPeso_objeto_venta(rs.getString("peso_objeto_venta"));
				venta.setColor_objeto_venta(rs.getString("color_objeto_venta"));
				venta.setMarca_objeto_venta(rs.getString("marca_objeto_venta"));
				venta.setModelo_objeto_venta(rs.getString("modelo_objeto_venta"));
				venta.setCantidad_objeto_venta(Integer.parseInt(rs.getString("cantidad_objeto_venta")));
				venta.setExistencia_objeto_venta(Integer.parseInt(rs.getString("existencia_objeto_venta")));
				venta.setPrecio_compra_venta(rs.getDouble("precio_compra_venta"));
				venta.setPrecio_venta(rs.getDouble("precio_venta"));
				venta.setFecha_registro_venta(rs.getString("fecha_registro_venta"));
				miLista.add(venta);
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
		ArrayList<venta> miLista = buscarUsuariosConMatriz();
		String matrizInfo[][] = new String[miLista.size()][12];
		for (int i = 0; i < miLista.size(); i++) {
			matrizInfo[i][0] = miLista.get(i).getId_venta() + "";
			matrizInfo[i][1] = miLista.get(i).getNombre_objeto_venta() + "";
			matrizInfo[i][2] = miLista.get(i).getDescripcion_objeto_venta() + "";
			matrizInfo[i][3] = miLista.get(i).getPeso_objeto_venta() + "";
			matrizInfo[i][4] = miLista.get(i).getColor_objeto_venta() + "";
			matrizInfo[i][5] = miLista.get(i).getMarca_objeto_venta() + "";
			matrizInfo[i][6] = miLista.get(i).getModelo_objeto_venta() + "";
			matrizInfo[i][7] = miLista.get(i).getCantidad_objeto_venta() + "";
			matrizInfo[i][8] = miLista.get(i).getExistencia_objeto_venta() + "";
			matrizInfo[i][9] = miLista.get(i).getPrecio_compra_venta() + "";
			matrizInfo[i][10] = miLista.get(i).getPrecio_venta() + "";
			matrizInfo[i][11] = miLista.get(i).getFecha_registro_venta() + "";

		}

		return matrizInfo;
	}

	/* Metodos para mostrar datos en tabla Contratos de los empleados */
	public static ArrayList<ingreso> buscarUsuariosConMatriz2() {
		conexion conex = new conexion();
		ArrayList<ingreso> miLista = new ArrayList<ingreso>();
		ingreso ingreso;
		try {
			Statement estatuto = conex.getConexion().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT * FROM ingresos");

			while (rs.next()) {
				ingreso = new ingreso();
				ingreso.setId_ingreso(Integer.parseInt(rs.getString("id_ingreso")));
				ingreso.setTipo_ingreso(rs.getString("tipo_ingreso"));
				ingreso.setCantidad_ingreso(rs.getDouble("cantidad_ingreso"));
				ingreso.setDescripcion_ingreso(rs.getString("descripcion_ingreso"));
				ingreso.setFecha_ingreso(rs.getString("fecha_ingreso"));
				miLista.add(ingreso);
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
		ArrayList<ingreso> miLista = buscarUsuariosConMatriz2();
		String matrizInfo[][] = new String[miLista.size()][5];
		for (int i = 0; i < miLista.size(); i++) {
			matrizInfo[i][0] = miLista.get(i).getId_ingreso() + "";
			matrizInfo[i][1] = miLista.get(i).getTipo_ingreso() + "";
			matrizInfo[i][2] = miLista.get(i).getCantidad_ingreso() + "";
			matrizInfo[i][3] = miLista.get(i).getDescripcion_ingreso() + "";
			matrizInfo[i][4] = miLista.get(i).getFecha_ingreso() + "";

		}

		return matrizInfo;
	}

}
