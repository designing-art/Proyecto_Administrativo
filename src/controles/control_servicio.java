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
import clases.servicio;
import conexion.conexion;
import consultas.consultas_contrato_empleado;
import consultas.consultas_producto;
import consultas.consultas_servicio;
import formularios.registro_contratos_empleados;
import formularios.registro_productos;
import formularios.registro_servicios;

public class control_servicio implements ActionListener {

	public servicio clase;
	public consultas_servicio consulta;
	public registro_servicios formulario;
	public static String identidad = null;

	public control_servicio(servicio clase, consultas_servicio consulta, registro_servicios formulario) {
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
			if (formulario.txtServicio.getText().isEmpty()
					|| formulario.txtTiempo.getText().isEmpty()
					|| formulario.txtDescripcion.getText().isEmpty()
					|| formulario.txtPrecio.getText().isEmpty() 
					|| formulario.txtPrecio.getText().isEmpty())
			{
			JOptionPane.showMessageDialog(null, "Porfavor llene los campos para guardar el servicio!");
		} else {
			clase.setTipo_servicio(formulario.txtServicio.getText().toString());
			clase.setTiempo_servicio(formulario.txtTiempo.getText().toString());
			clase.setPrecio_servicio(Double.parseDouble(formulario.txtPrecio.getText().toString()));
			clase.setDescripcion_servicio(formulario.txtDescripcion.getText().toString());
			clase.setProducto_servicio(formulario.cbxProductos.getSelectedItem().toString());
			if (consulta.insertar(clase)) {
				JOptionPane.showMessageDialog(null, "Servicio registrado!");
				limpiar();
				formulario.construirTabla();
				formulario.obtenerUltimoId();
			} else {
				JOptionPane.showMessageDialog(null, "Error! servicio no registrado");
				limpiar();
			}
		}
	}
		
		/* Actualizar */
		if (e.getSource() == formulario.btnActualizar) {
			if (formulario.txtServicio.getText().isEmpty()
					|| formulario.txtTiempo.getText().isEmpty()
					|| formulario.txtDescripcion.getText().isEmpty()
					|| formulario.txtPrecio.getText().isEmpty() 
					|| formulario.txtPrecio.getText().isEmpty())
			{
			JOptionPane.showMessageDialog(null, "Porfavor llene los campos para actualizar el servicio!");
		} else {
			clase.setId_servicio(Integer.parseInt(formulario.txtCodigo.getText().toString()));
			clase.setTipo_servicio(formulario.txtServicio.getText().toString());
			clase.setTiempo_servicio(formulario.txtTiempo.getText().toString());
			clase.setPrecio_servicio(Double.parseDouble(formulario.txtPrecio.getText().toString()));
			clase.setDescripcion_servicio(formulario.txtDescripcion.getText().toString());
			clase.setProducto_servicio(formulario.cbxProductos.getSelectedItem().toString());
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
					formulario.cbxProductos.setSelectedItem(producto);
				
					formulario.txtCodigo.setForeground(Color.BLACK);
					formulario.txtServicio.setForeground(Color.BLACK);
					formulario.txtTiempo.setForeground(Color.BLACK);
					formulario.txtPrecio.setForeground(Color.BLACK);
					formulario.txtDescripcion.setForeground(Color.BLACK);
					formulario.cbxProductos.setForeground(Color.BLACK);

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
				JOptionPane.showMessageDialog(null, "Error: " + ex + "\nIntÚntelo nuevamente",
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
					formulario.cbxProductos.setSelectedItem(producto);
				
					formulario.txtCodigo.setForeground(Color.BLACK);
					formulario.txtServicio.setForeground(Color.BLACK);
					formulario.txtTiempo.setForeground(Color.BLACK);
					formulario.txtPrecio.setForeground(Color.BLACK);
					formulario.txtDescripcion.setForeground(Color.BLACK);
					formulario.cbxProductos.setForeground(Color.BLACK);

					formulario.btnBorrar.setVisible(false);
					formulario.btnGuardar.setVisible(false);
					formulario.btnNuevo.setVisible(false);
					formulario.btnActualizar.setVisible(false);
					formulario.btnActualizarDatos.setVisible(false);
					formulario.btnAceptar.setText("Aceptar");
					formulario.btnAceptar.setVisible(true);

				}

			} catch (HeadlessException ex) {
				JOptionPane.showMessageDialog(null, "Error: " + ex + "\nIntÚntelo nuevamente",
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
					conexion objCon = new conexion();
					Connection conn = objCon.getConexion();
					int Fila = formulario.tablaServicios.getSelectedRow();
					String codigo = formulario.tablaServicios.getValueAt(Fila, 0).toString();
					ps = conn.prepareStatement("DELETE FROM servicios WHERE id_servicios=?");
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
		formulario.txtCapasidad.setText(null);
		formulario.txtColor.setText(null);
		formulario.txtDispositivo.setText(null);
		formulario.txtMarca.setText(null);
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

}
