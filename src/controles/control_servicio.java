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
import clases.producto;
import clases.sar;
import clases.servicio;
import conexion.conexion;
import consultas.consultas_factura_cliente;
import consultas.consultas_ingreso;
import consultas.consultas_producto;
import consultas.consultas_servicio;
import formularios.login_usuario;
import formularios.registro_facturas_clientes;
import formularios.registro_ingresos;
import formularios.registro_productos;
import formularios.registro_servicios;

public class control_servicio implements ActionListener {

	public servicio clase;
	public consultas_servicio consulta;
	public registro_servicios formulario;

	public producto clase2;
	public consultas_producto consulta2;
	public registro_productos formulario2;

	public ingreso clase3;
	public consultas_ingreso consulta3;
	public registro_ingresos formulario3;

	public static String identidad = null;
	public static int contador = 0;
	public static String cantidad = null;
	public static int cantidadp = 1;
	public static int total = 0;
	public static int existencia = 0;
	public static String resultado = null;

	public control_servicio(servicio clase, producto clase2, ingreso clase3, consultas_servicio consulta,
			registro_servicios formulario) {
		this.clase = clase;
		this.clase2 = clase2;
		this.clase3 = clase3;
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
			if (formulario.txtServicio.getText().isEmpty() || formulario.txtTiempo.getText().isEmpty()
					|| formulario.txtDescripcion.getText().isEmpty() || formulario.txtPrecio.getText().isEmpty()
					|| formulario.txtPrecio.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Porfavor llene los campos para guardar el servicio!");
			} else {

				if (registro_servicios.cbxProductos.getSelectedItem().toString().equals("Ninguno")) {

					clase.setTipo_servicio(formulario.txtServicio.getText().toString());
					clase.setTiempo_servicio(formulario.txtTiempo.getText().toString());
					clase.setPrecio_servicio(Double.parseDouble(formulario.txtPrecio.getText().toString()));
					clase.setDescripcion_servicio(formulario.txtDescripcion.getText().toString());
					clase.setProducto_servicio(registro_servicios.cbxProductos.getSelectedItem().toString());

					clase3.setTipo_ingreso("Ingreso por servicio de: " + formulario.txtServicio.getText().toString());
					clase3.setCantidad_ingreso(Double.parseDouble(formulario.txtPrecio.getText().toString()));
					clase3.setDescripcion_ingreso(
							"Caracteristicas del servicio : " + formulario.txtDescripcion.getText().toString() + " y "
									+ "venta de :" + registro_servicios.txtDispositivo.getText().toString());
					clase3.setFecha_ingreso(formulario.editor.getText().toString());
					if (consulta.insertar(clase) && consulta.insertarIngreso(clase3)) {
						JOptionPane.showMessageDialog(null, "Venta registrada!");
						limpiar();
						formulario.obtenerUltimoId();
						formulario.construirTabla();
					} else {
						JOptionPane.showMessageDialog(null, "Error! objeto no registrado");
						limpiar();
					}

				} else {

					existencia = Integer.parseInt(registro_servicios.txtExistenciaProducto.getText().toString());
					if (cantidadp > existencia) {
						JOptionPane.showMessageDialog(null, "Cantidad de venta incorrecta!\n"
								+ "imposible hacer la venta\n" + "No hay suficiente existencia.\n");
					} else {
						if (existencia == 0) {
							JOptionPane.showMessageDialog(null, "No hay productos disponibles para la venta.");
						} else {
							formulario.restarVenta();
							clase.setTipo_servicio(formulario.txtServicio.getText().toString());
							clase.setTiempo_servicio(formulario.txtTiempo.getText().toString());
							clase.setPrecio_servicio(Double.parseDouble(formulario.txtPrecio.getText().toString()));
							clase.setDescripcion_servicio(formulario.txtDescripcion.getText().toString());
							clase.setProducto_servicio(registro_servicios.cbxProductos.getSelectedItem().toString());

							clase2.setExistencia_producto(
									Integer.parseInt(registro_servicios.txtExistenciaProducto.getText().toString()));
							clase2.setId_producto(Integer.parseInt(registro_servicios.txtCodigoProducto.getText().toString()));

							clase3.setTipo_ingreso(
									"Ingreso por servicio de: " + formulario.txtServicio.getText().toString());
							clase3.setCantidad_ingreso(Double.parseDouble(formulario.txtPrecio.getText().toString()));
							clase3.setDescripcion_ingreso(
									"Caracteristicas del servicio : " + formulario.txtDescripcion.getText().toString()
											+ " y " + "venta de :" + registro_servicios.txtDispositivo.getText().toString());
							clase3.setFecha_ingreso(formulario.editor.getText().toString());

							if (consulta.insertar(clase) && consulta.actualizarInventarioProductos(clase2)
									&& consulta.insertarIngreso(clase3)) {
								JOptionPane.showMessageDialog(null, "Venta registrada!");
								limpiar();
								formulario.obtenerUltimoId();
								formulario.construirTabla();

								factura_cliente clase = new factura_cliente();
								consultas_factura_cliente consulta = new consultas_factura_cliente();
								registro_facturas_clientes formulario2 = new registro_facturas_clientes();
								sar clase2 = new sar();
								control_factura_cliente control = new control_factura_cliente(clase, consulta,
										formulario2, clase2);
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
		}

		/* Actualizar */
		if (e.getSource() == formulario.btnActualizar)

		{
			if (formulario.txtServicio.getText().isEmpty() || formulario.txtTiempo.getText().isEmpty()
					|| formulario.txtDescripcion.getText().isEmpty() || formulario.txtPrecio.getText().isEmpty()
					|| formulario.txtPrecio.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Porfavor llene los campos para actualizar el servicio!");
			} else {
				clase.setId_servicio(Integer.parseInt(formulario.txtCodigo.getText().toString()));
				clase.setTipo_servicio(formulario.txtServicio.getText().toString());
				clase.setTiempo_servicio(formulario.txtTiempo.getText().toString());
				clase.setPrecio_servicio(Double.parseDouble(formulario.txtPrecio.getText().toString()));
				clase.setDescripcion_servicio(formulario.txtDescripcion.getText().toString());
				clase.setProducto_servicio(registro_servicios.cbxProductos.getSelectedItem().toString());
				if (consulta.actualizar(clase)) {
					JOptionPane.showMessageDialog(null, "Servicio actualizado!");
					limpiar();
					formulario.construirTabla();
					formulario.obtenerUltimoId();
				} else {
					JOptionPane.showMessageDialog(null, "Error! servicio no actualizado");
					limpiar();
				}
			}
		}
		if (e.getSource() == formulario.btnActualizarDatos) {
			int filaseleccionada;
			try {
				filaseleccionada = formulario.tablaServicios.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					String codigo = formulario.tablaServicios.getValueAt(filaseleccionada, 0).toString();
					String tipo = formulario.tablaServicios.getValueAt(filaseleccionada, 1).toString();
					String tiempo = formulario.tablaServicios.getValueAt(filaseleccionada, 2).toString();
					String precio = formulario.tablaServicios.getValueAt(filaseleccionada, 3).toString();
					String descripcion = formulario.tablaServicios.getValueAt(filaseleccionada, 4).toString();
					String producto = formulario.tablaServicios.getValueAt(filaseleccionada, 5).toString();

					formulario.txtCodigo.setText(codigo);
					formulario.txtServicio.setText(tipo);
					formulario.txtTiempo.setText(tiempo);
					formulario.txtPrecio.setText(precio);
					formulario.txtDescripcion.setText(descripcion);
					registro_servicios.cbxProductos.setSelectedItem(producto);

					formulario.txtCodigo.setForeground(Color.BLACK);
					formulario.txtServicio.setForeground(Color.BLACK);
					formulario.txtTiempo.setForeground(Color.BLACK);
					formulario.txtPrecio.setForeground(Color.BLACK);
					formulario.txtDescripcion.setForeground(Color.BLACK);
					registro_servicios.cbxProductos.setForeground(Color.BLACK);

					formulario.btnBorrar.setVisible(true);
					formulario.btnGuardar.setVisible(false);
					formulario.btnNuevo.setVisible(false);
					formulario.btnActualizar.setVisible(true);
					formulario.btnActualizarDatos.setVisible(true);
					formulario.btnVer.setVisible(false);
					formulario.btnAceptar.setText("Cancelar");
					formulario.btnAceptar.setVisible(true);

					formulario.txtBusqueda.requestFocusInWindow();

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
				filaseleccionada = formulario.tablaServicios.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					String codigo = formulario.tablaServicios.getValueAt(filaseleccionada, 0).toString();
					String tipo = formulario.tablaServicios.getValueAt(filaseleccionada, 1).toString();
					String tiempo = formulario.tablaServicios.getValueAt(filaseleccionada, 2).toString();
					String precio = formulario.tablaServicios.getValueAt(filaseleccionada, 3).toString();
					String descripcion = formulario.tablaServicios.getValueAt(filaseleccionada, 4).toString();
					String producto = formulario.tablaServicios.getValueAt(filaseleccionada, 5).toString();

					formulario.txtCodigo.setText(codigo);
					formulario.txtServicio.setText(tipo);
					formulario.txtTiempo.setText(tiempo);
					formulario.txtPrecio.setText(precio);
					formulario.txtDescripcion.setText(descripcion);
					registro_servicios.cbxProductos.setSelectedItem(producto);

					formulario.txtCodigo.setForeground(Color.BLACK);
					formulario.txtServicio.setForeground(Color.BLACK);
					formulario.txtTiempo.setForeground(Color.BLACK);
					formulario.txtPrecio.setForeground(Color.BLACK);
					formulario.txtDescripcion.setForeground(Color.BLACK);
					registro_servicios.cbxProductos.setForeground(Color.BLACK);

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
				filaseleccionada = formulario.tablaServicios.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					if (login_usuario.cargoUsuario.toString() == "Usuario Avanzado") {

						conexion objCon = new conexion();
						Connection conn = objCon.getConexion();
						int Fila = formulario.tablaServicios.getSelectedRow();
						String codigo = formulario.tablaServicios.getValueAt(Fila, 0).toString();
						ps = conn.prepareStatement("DELETE FROM servicios WHERE id_servicio=?");
						ps.setString(1, codigo);
						ps.execute();
						JOptionPane.showMessageDialog(null, "Servicio Eliminado!");
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
				JOptionPane.showMessageDialog(null, "Error al Eliminar Servicio");
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
			formulario.obtenerUltimoId();
			formulario.pistas();
			formulario.construirTabla();

		}

	}

	/* Metodos para implementar */

	/* Metodo para el boton nuevo que limpia los datos de los txtFields */
	public void limpiar() {
		formulario.txtBusqueda.setText(null);
		formulario.txtCodigo.setText(null);
		formulario.txtDescripcion.setText(null);
		formulario.txtPrecio.setText(null);
		formulario.txtServicio.setText(null);
		formulario.txtTiempo.setText(null);
		registro_servicios.txtCapasidad.setText(null);
		registro_servicios.txtPrecioProducto.setText(null);
		registro_servicios.txtDispositivo.setText(null);
		registro_servicios.txtMarca.setText(null);
	}

	/* Metodos para mostrar datos en tabla Contratos de los empleados */
	public static ArrayList<servicio> buscarUsuariosConMatriz() {
		conexion conex = new conexion();
		ArrayList<servicio> miLista = new ArrayList<servicio>();
		servicio servicio;
		try {
			Statement estatuto = conex.getConexion().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT * FROM servicios ");

			while (rs.next()) {
				servicio = new servicio();
				servicio.setId_servicio(Integer.parseInt(rs.getString("id_servicio")));
				servicio.setTipo_servicio(rs.getString("tipo_servicio"));
				servicio.setTiempo_servicio(rs.getString("tiempo_servicio"));
				servicio.setPrecio_servicio(Double.parseDouble(rs.getString("precio_servicio")));
				servicio.setDescripcion_servicio(rs.getString("descripcion_servicio"));
				servicio.setProducto_servicio(rs.getString("producto_servicio"));
				miLista.add(servicio);
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
		ArrayList<servicio> miLista = buscarUsuariosConMatriz();
		String matrizInfo[][] = new String[miLista.size()][6];
		for (int i = 0; i < miLista.size(); i++) {
			matrizInfo[i][0] = miLista.get(i).getId_servicio() + "";
			matrizInfo[i][1] = miLista.get(i).getTipo_servicio() + "";
			matrizInfo[i][2] = miLista.get(i).getTiempo_servicio() + "";
			matrizInfo[i][3] = miLista.get(i).getPrecio_servicio() + "";
			matrizInfo[i][4] = miLista.get(i).getDescripcion_servicio() + "";
			matrizInfo[i][5] = miLista.get(i).getProducto_servicio() + "";

		}

		return matrizInfo;
	}

	public void consultarProductos() {
		conexion conex = new conexion();
		try {
			Statement estatuto = conex.getConexion().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT dispositivo_de_entrega_producto FROM productos");

			while (rs.next()) {
				registro_servicios.cbxProductos.addItem(rs.getString("dispositivo_de_entrega_producto"));
			}
			formulario.contador++;
			rs.close();
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error al consultar", "Error", JOptionPane.ERROR_MESSAGE);

		}

	}

	public void consultarExistencia() {
		conexion objCon = new conexion();
		Connection conn = objCon.getConexion();
		try {
			PreparedStatement stmtr = conn.prepareStatement(
					"SELECT existencia_producto FROM productos WHERE dispositivo_de_entrega_producto ='"
							+ registro_servicios.txtDispositivo.getText().toString() + "'");
			ResultSet rsr = stmtr.executeQuery();
			rsr.next();
			cantidad = (rsr.getString("existencia_producto"));
			;
			stmtr.close();
			rsr.close();
			conn.close();

		} catch (Exception e21) {
			e21.printStackTrace();
		}
	}
}
