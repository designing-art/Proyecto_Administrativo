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
import clases.contrato_empleado;
import clases.producto;
import conexion.conexion;
import consultas.consultas_contrato_empleado;
import consultas.consultas_producto;
import formularios.registro_contratos_empleados;
import formularios.registro_productos;

public class control_producto implements ActionListener {

	public producto clase;
	public consultas_producto consulta;
	public registro_productos formulario;
	public static String identidad = null;

	public control_producto(producto clase, consultas_producto consulta, registro_productos formulario) {
		this.clase = clase;
		this.consulta = consulta;
		this.formulario = formulario;
		this.formulario.btnGuardarProducto.addActionListener(this);
		this.formulario.btnNuevoProducto.addActionListener(this);
		this.formulario.btnActualizarProducto.addActionListener(this);
		this.formulario.btnActualizarDatosProducto.addActionListener(this);
		this.formulario.btnBorrarProducto.addActionListener(this);
		this.formulario.btnVerProducto.addActionListener(this);
		this.formulario.btnAceptar.addActionListener(this);
		this.formulario.btnVerFotoProducto.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == formulario.btnGuardarProducto) {
			if (formulario.txtDireccionFotoProducto.getText().isEmpty() || formulario.txtDispositivo.getText().isEmpty()
					|| formulario.txtCapasidad.getText().isEmpty() || formulario.txtColor.getText().isEmpty()
					|| formulario.txtMarca.getText().isEmpty() || formulario.txtPrecio.getText().isEmpty())
			{
			JOptionPane.showMessageDialog(null, "Porfavor llene los campos para guardar el producto!");
		} else {
			clase.setDispositivo_de_entrega_producto(formulario.txtDispositivo.getText().toString());
			clase.setCapacidad_produto(formulario.txtCapasidad.getText().toString());
			clase.setColor_producto(formulario.txtColor.getText().toString());
			clase.setMarca_producto(formulario.txtMarca.getText().toString());
			clase.setDireccion_foto_producto(formulario.txtDireccionFotoProducto.getText().toString());
			clase.setPrecio_producto(Double.parseDouble(formulario.txtPrecio.getText().toString()));
			if (consulta.insertar(clase)) {
				JOptionPane.showMessageDialog(null, "Producto registrado!");
				limpiar();
				formulario.construirTabla();
				formulario.obtenerUltimoId();
				final ImageIcon iconoContrato = new ImageIcon(getClass().getResource("/iconos/usb.png"));
				final ImageIcon iconofoto = new ImageIcon(
						iconoContrato.getImage().getScaledInstance(formulario.lbl_foto_contrato.getWidth(),
								formulario.lbl_foto_contrato.getHeight(), Image.SCALE_DEFAULT));
				formulario.lbl_foto_contrato.setIcon(iconofoto);
			} else {
				JOptionPane.showMessageDialog(null, "Error! producto no registrado");
				limpiar();
			}
		}
	}
		
		/* Actualizar */
		if (e.getSource() == formulario.btnActualizarProducto) {
			if (formulario.txtDireccionFotoProducto.getText().isEmpty() || formulario.txtDispositivo.getText().isEmpty()
					|| formulario.txtCapasidad.getText().isEmpty() || formulario.txtColor.getText().isEmpty()
					|| formulario.txtMarca.getText().isEmpty() || formulario.txtPrecio.getText().isEmpty())
			{
			JOptionPane.showMessageDialog(null, "Porfavor llene los campos para actualizar el producto!");
		} else {
			clase.setId_producto(Integer.parseInt(formulario.txtCodigoProducto.getText().toString()));
			clase.setDispositivo_de_entrega_producto(formulario.txtDispositivo.getText().toString());
			clase.setCapacidad_produto(formulario.txtCapasidad.getText().toString());
			clase.setColor_producto(formulario.txtColor.getText().toString());
			clase.setMarca_producto(formulario.txtMarca.getText().toString());
			clase.setDireccion_foto_producto(formulario.txtDireccionFotoProducto.getText().toString());
			clase.setPrecio_producto(Double.parseDouble(formulario.txtPrecio.getText().toString()));
			if (consulta.actualizar(clase)) {
				JOptionPane.showMessageDialog(null, "Producto actualizado!");
				limpiar();
				formulario.construirTabla();
				formulario.obtenerUltimoId();
				final ImageIcon iconoContrato = new ImageIcon(getClass().getResource("/iconos/usb.png"));
				final ImageIcon iconofoto = new ImageIcon(
						iconoContrato.getImage().getScaledInstance(formulario.lbl_foto_contrato.getWidth(),
								formulario.lbl_foto_contrato.getHeight(), Image.SCALE_DEFAULT));
				formulario.lbl_foto_contrato.setIcon(iconofoto);
			} else {
				JOptionPane.showMessageDialog(null, "Error! producto no registrado");
				limpiar();
			}
		}
	}
	
		if (e.getSource() == formulario.btnActualizarDatosProducto) {
			int filaseleccionada;
			try {
				filaseleccionada = formulario.tablaProductos.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					String codigo = formulario.tablaProductos.getValueAt(filaseleccionada, 0).toString();
					String dispo = formulario.tablaProductos.getValueAt(filaseleccionada, 1).toString();
					String marca = formulario.tablaProductos.getValueAt(filaseleccionada, 2).toString();
					String capasidad = formulario.tablaProductos.getValueAt(filaseleccionada, 3).toString();
					String color = formulario.tablaProductos.getValueAt(filaseleccionada, 4).toString();
					String precio = formulario.tablaProductos.getValueAt(filaseleccionada, 5).toString();
					String foto = formulario.tablaProductos.getValueAt(filaseleccionada, 6).toString();

					formulario.txtCodigoProducto.setText(codigo);
					formulario.txtDispositivo.setText(dispo);
					formulario.txtMarca.setText(marca);
					formulario.txtCapasidad.setText(capasidad);
					formulario.txtColor.setText(color);
					formulario.txtPrecio.setText(precio);
					formulario.txtDireccionFotoProducto.setText(foto);

					final ImageIcon foto_contrato = new ImageIcon(foto);
					final ImageIcon logo = new ImageIcon(
							foto_contrato.getImage().getScaledInstance(formulario.lbl_foto_contrato.getWidth(),
									formulario.lbl_foto_contrato.getHeight(), Image.SCALE_DEFAULT));
					formulario.lbl_foto_contrato.setIcon(logo);

					formulario.txtCodigoProducto.setForeground(Color.BLACK);
					formulario.txtDispositivo.setForeground(Color.BLACK);
					formulario.txtCapasidad.setForeground(Color.BLACK);
					formulario.txtColor.setForeground(Color.BLACK);
					formulario.txtMarca.setForeground(Color.BLACK);
					formulario.txtPrecio.setForeground(Color.BLACK);
					formulario.txtDireccionFotoProducto.setForeground(Color.BLACK);

					formulario.btnBorrarProducto.setVisible(true);
					formulario.btnGuardarProducto.setVisible(false);
					formulario.btnNuevoProducto.setVisible(false);
					formulario.btnActualizarProducto.setVisible(true);
					formulario.btnActualizarDatosProducto.setVisible(true);
					formulario.btnVerProducto.setVisible(false);
					formulario.btnAceptar.setText("Cancelar");
					formulario.btnAceptar.setVisible(true);

					formulario.txtBusquedaContratosEmpleados.requestFocusInWindow();

				}

			} catch (HeadlessException ex) {
				JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente",
						" .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);
			}
		}

		/* Pasar datos de la tabla al formulario para ver los datos */
		if (e.getSource() == formulario.btnVerProducto) {
			int filaseleccionada;
			try {
				filaseleccionada = formulario.tablaProductos.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					String codigo = formulario.tablaProductos.getValueAt(filaseleccionada, 0).toString();
					String dispo = formulario.tablaProductos.getValueAt(filaseleccionada, 1).toString();
					String marca = formulario.tablaProductos.getValueAt(filaseleccionada, 2).toString();
					String capasidad = formulario.tablaProductos.getValueAt(filaseleccionada, 3).toString();
					String color = formulario.tablaProductos.getValueAt(filaseleccionada, 4).toString();
					String precio = formulario.tablaProductos.getValueAt(filaseleccionada, 5).toString();
					String foto = formulario.tablaProductos.getValueAt(filaseleccionada, 6).toString();

					formulario.txtCodigoProducto.setText(codigo);
					formulario.txtDispositivo.setText(dispo);
					formulario.txtMarca.setText(marca);
					formulario.txtCapasidad.setText(capasidad);
					formulario.txtColor.setText(color);
					formulario.txtPrecio.setText(precio);
					formulario.txtDireccionFotoProducto.setText(foto);

					final ImageIcon foto_contrato = new ImageIcon(foto);
					final ImageIcon logo = new ImageIcon(
							foto_contrato.getImage().getScaledInstance(formulario.lbl_foto_contrato.getWidth(),
									formulario.lbl_foto_contrato.getHeight(), Image.SCALE_DEFAULT));
					formulario.lbl_foto_contrato.setIcon(logo);

					formulario.txtCodigoProducto.setForeground(Color.BLACK);
					formulario.txtDispositivo.setForeground(Color.BLACK);
					formulario.txtCapasidad.setForeground(Color.BLACK);
					formulario.txtColor.setForeground(Color.BLACK);
					formulario.txtMarca.setForeground(Color.BLACK);
					formulario.txtPrecio.setForeground(Color.BLACK);
					formulario.txtDireccionFotoProducto.setForeground(Color.BLACK);

					formulario.btnBorrarProducto.setVisible(false);
					formulario.btnGuardarProducto.setVisible(false);
					formulario.btnNuevoProducto.setVisible(false);
					formulario.btnActualizarProducto.setVisible(false);
					formulario.btnActualizarDatosProducto.setVisible(false);
					formulario.btnAceptar.setText("Aceptar");
					formulario.btnAceptar.setVisible(true);

				}

			} catch (HeadlessException ex) {
				JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente",
						" .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);
			}
		}

		

		/* Borrar */
		if (e.getSource() == formulario.btnBorrarProducto) {
			PreparedStatement ps = null;
			int filaseleccionada;
			try {
				filaseleccionada = formulario.tablaProductos.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					conexion objCon = new conexion();
					Connection conn = objCon.getConexion();
					int Fila = formulario.tablaProductos.getSelectedRow();
					String codigo = formulario.tablaProductos.getValueAt(Fila, 0).toString();
					ps = conn.prepareStatement("DELETE FROM productos WHERE id_producto=?");
					ps.setString(1, codigo);
					ps.execute();
					JOptionPane.showMessageDialog(null, "Producto Eliminado!");
					limpiar();
					formulario.construirTabla();
					formulario.txtCodigoProducto.setText(null);
					formulario.btnSubirFotoContrato.setEnabled(false);
					formulario.lbl_foto_contrato.setEnabled(false);
					formulario.btnAceptar.setEnabled(true);
					formulario.btnActualizarProducto.setVisible(false);
					formulario.btnGuardarProducto.setVisible(false);
					formulario.btnNuevoProducto.setVisible(false);

				}
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "Error al Eliminar Cargo");
				System.out.println(ex.toString());
			}
		}

		/* Nuevo */
		if (e.getSource() == formulario.btnNuevoProducto) {
			limpiar();
			limpiar();
			formulario.obtenerUltimoId();
			formulario.btnBorrarProducto.setVisible(false);
			formulario.btnGuardarProducto.setVisible(true);
			formulario.btnNuevoProducto.setVisible(true);
			formulario.btnActualizarProducto.setVisible(false);
			formulario.btnActualizarDatosProducto.setVisible(true);
			formulario.txtDireccionFotoProducto.setEditable(false);
			formulario.btnVerProducto.setVisible(true);
			formulario.btnAceptar.setVisible(false);
			formulario.pistas();
			formulario.construirTabla();
			final ImageIcon iconoContrato = new ImageIcon(getClass().getResource("/iconos/usb.png"));
			final ImageIcon iconofoto = new ImageIcon(
					iconoContrato.getImage().getScaledInstance(formulario.lbl_foto_contrato.getWidth(),
							formulario.lbl_foto_contrato.getHeight(), Image.SCALE_DEFAULT));
			formulario.lbl_foto_contrato.setIcon(iconofoto);
		}

		/* Aceptar */
		if (e.getSource() == formulario.btnAceptar) {
			limpiar();
			formulario.btnBorrarProducto.setVisible(false);
			formulario.btnGuardarProducto.setVisible(true);
			formulario.btnNuevoProducto.setVisible(true);
			formulario.btnActualizarProducto.setVisible(false);
			formulario.btnActualizarDatosProducto.setVisible(true);
			formulario.txtDireccionFotoProducto.setEditable(false);
			formulario.btnVerProducto.setVisible(true);
			formulario.btnAceptar.setVisible(false);
			formulario.txtCodigoProducto.setEnabled(true);
			formulario.txtCodigoProducto.setEditable(false);
			formulario.obtenerUltimoId();
			formulario.pistas();
			formulario.construirTabla();
			final ImageIcon iconoContrato = new ImageIcon(getClass().getResource("/iconos/usb.png"));
			final ImageIcon iconofoto = new ImageIcon(
					iconoContrato.getImage().getScaledInstance(formulario.lbl_foto_contrato.getWidth(),
							formulario.lbl_foto_contrato.getHeight(), Image.SCALE_DEFAULT));
			formulario.lbl_foto_contrato.setIcon(iconofoto);

		}

	}

	/* Metodos para implementar */

	/* Metodo para el boton nuevo que limpia los datos de los txtFields */
	public void limpiar() {
		formulario.txtBusquedaContratosEmpleados.setText(null);
		formulario.txtDispositivo.setText(null);
		formulario.txtCapasidad.setText(null);
		formulario.txtColor.setText(null);
		formulario.txtMarca.setText(null);
		formulario.txtPrecio.setText(null);
		formulario.txtDireccionFotoProducto.setText(null);
		formulario.txtCodigoProducto.setText(null);
	}

	/* Metodos para mostrar datos en tabla Contratos de los empleados */
	public static ArrayList<producto> buscarUsuariosConMatriz() {
		conexion conex = new conexion();
		ArrayList<producto> miLista = new ArrayList<producto>();
		producto producto;
		try {
			Statement estatuto = conex.getConexion().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT * FROM productos ");

			while (rs.next()) {
				producto = new producto();
				producto.setId_producto(Integer.parseInt(rs.getString("id_producto")));
				producto.setDispositivo_de_entrega_producto(rs.getString("dispositivo_de_entrega_producto"));
				producto.setMarca_producto(rs.getString("marca_producto"));
				producto.setCapacidad_produto(rs.getString("capacidad_produto"));
				producto.setColor_producto(rs.getString("color_producto"));
				producto.setPrecio_producto(Double.parseDouble(rs.getString("precio_producto")));
				producto.setDireccion_foto_producto(rs.getString("direccion_foto_producto"));
				miLista.add(producto);
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
		ArrayList<producto> miLista = buscarUsuariosConMatriz();
		String matrizInfo[][] = new String[miLista.size()][7];
		for (int i = 0; i < miLista.size(); i++) {
			matrizInfo[i][0] = miLista.get(i).getId_producto() + "";
			matrizInfo[i][1] = miLista.get(i).getDispositivo_de_entrega_producto() + "";
			matrizInfo[i][2] = miLista.get(i).getMarca_producto() + "";
			matrizInfo[i][3] = miLista.get(i).getCapacidad_produto() + "";
			matrizInfo[i][4] = miLista.get(i).getColor_producto() + "";
			matrizInfo[i][5] = miLista.get(i).getPrecio_producto() + "";
			matrizInfo[i][6] = miLista.get(i).getDireccion_foto_producto() + "";

		}

		return matrizInfo;
	}

	public void validarIdentidad() {
		conexion conex = new conexion();
		try {
			Statement estatuto = conex.getConexion().createStatement();
			ResultSet rs = estatuto.executeQuery(
					"SELECT identidad_contrato_empleado FROM contrato_empleado where identidad_contrato_empleado = '"
							+ formulario.txtBusquedaContratosEmpleados.getText().toString() + "'");

			if (rs.next()) {
				identidad = (rs.getString("identidad_contrato_empleado"));
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
