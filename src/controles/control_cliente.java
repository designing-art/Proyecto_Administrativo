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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import clases.cliente;
import conexion.conexion;
import consultas.consultas_cliente;
import formularios.login_usuario;
import formularios.registro_clientes;

public class control_cliente implements ActionListener {

	public cliente clase;
	public consultas_cliente consulta;
	public registro_clientes formulario;
	public static String identidad = null;

	public control_cliente(cliente clase, consultas_cliente consulta, registro_clientes formulario) {
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
			if (formulario.txtNombresCliente.getText().isEmpty() || formulario.txtNombreEmpresa.getText().isEmpty()
					|| formulario.txtApellidosCliente.getText().isEmpty()
					|| formulario.txtDireccionCliente.getText().isEmpty()
					|| formulario.txtTelefonoCliente.getText().isEmpty()
					|| formulario.txtCorreoCliente.getText().isEmpty()
					|| formulario.txtIdentidadCliente.getText().isEmpty()
					|| formulario.txtFotoCliente.getText().isEmpty() || formulario.txtNombreEmpresa.getText().isEmpty()
					|| formulario.txtDireccionEmpresa.getText().isEmpty()
					|| formulario.txtRTNEmpresa.getText().isEmpty() || formulario.txtTelefonoEmpresa.getText().isEmpty()
					|| formulario.txtCorreoEmpresa.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Porfavor llene los campos para guardar el cliente!");
			} else {
				clase.setNombres_cliente(formulario.txtNombresCliente.getText().toString());
				clase.setApellidos_cliente(formulario.txtApellidosCliente.getText().toString());
				clase.setDireccion_cliente(formulario.txtDireccionCliente.getText().toString());
				clase.setTelefono_cliente(formulario.txtTelefonoCliente.getText().toString());
				clase.setCorreo_cliente(formulario.txtCorreoCliente.getText().toString());
				clase.setGenero_cliente(formulario.cbxGeneroCliente.getSelectedItem().toString());
				clase.setIdentidad_cliente(formulario.txtIdentidadCliente.getText().toString());
				clase.setFoto_cliente(formulario.txtFotoCliente.getText().toString());
				clase.setNombre_empresa_cliente(formulario.txtNombreEmpresa.getText().toString());
				clase.setDescripcion_empresa_cliente(formulario.txtDescripcionEmpresa.getText().toString());
				clase.setDireccion_empresa_cliente(formulario.txtDireccionEmpresa.getText().toString());
				clase.setRtn_empresa_cliente(formulario.txtRTNEmpresa.getText().toString());
				clase.setTelefono_empresa_cliente(formulario.txtTelefonoEmpresa.getText().toString());
				clase.setCorreo_empresa_cliente(formulario.txtCorreoEmpresa.getText().toString());

				if (consulta.registrar(clase)) {
					JOptionPane.showMessageDialog(null, "Cliente registrado!");
					limpiar();
					formulario.construirTabla();
					formulario.obtenerUltimoId();
					formulario.txtFotoCliente.setText("Sin Fotografia.");
					final ImageIcon iconoContrato = new ImageIcon(getClass().getResource("/iconos/usuario.png"));
					final ImageIcon iconofoto = new ImageIcon(iconoContrato.getImage().getScaledInstance(
							formulario.lblFotoC.getWidth(), formulario.lblFotoC.getHeight(), Image.SCALE_DEFAULT));
					formulario.lblFotoC.setIcon(iconofoto);
				} else {
					JOptionPane.showMessageDialog(null, "Error! Cliente no registrado");
					limpiar();
				}

			}

		}

		if (e.getSource() == formulario.btnActualizar) {
			if (formulario.txtNombresCliente.getText().isEmpty() || formulario.txtNombreEmpresa.getText().isEmpty()
					|| formulario.txtApellidosCliente.getText().isEmpty()
					|| formulario.txtDireccionCliente.getText().isEmpty()
					|| formulario.txtTelefonoCliente.getText().isEmpty()
					|| formulario.txtCorreoCliente.getText().isEmpty()
					|| formulario.txtIdentidadCliente.getText().isEmpty()
					|| formulario.txtFotoCliente.getText().isEmpty() || formulario.txtNombreEmpresa.getText().isEmpty()
					|| formulario.txtDireccionEmpresa.getText().isEmpty()
					|| formulario.txtRTNEmpresa.getText().isEmpty() || formulario.txtTelefonoEmpresa.getText().isEmpty()
					|| formulario.txtCorreoEmpresa.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Porfavor llene los campos para guardar el cliente!");
			} else {
				clase.setId_cliente(Integer.parseInt(formulario.txtCodigo.getText().toString()));
				clase.setNombres_cliente(formulario.txtNombresCliente.getText().toString());
				clase.setApellidos_cliente(formulario.txtApellidosCliente.getText().toString());
				clase.setDireccion_cliente(formulario.txtDireccionCliente.getText().toString());
				clase.setTelefono_cliente(formulario.txtTelefonoCliente.getText().toString());
				clase.setCorreo_cliente(formulario.txtCorreoCliente.getText().toString());
				clase.setGenero_cliente(formulario.cbxGeneroCliente.getSelectedItem().toString());
				clase.setIdentidad_cliente(formulario.txtIdentidadCliente.getText().toString());
				clase.setFoto_cliente(formulario.txtFotoCliente.getText().toString());
				clase.setNombre_empresa_cliente(formulario.txtNombreEmpresa.getText().toString());
				clase.setDescripcion_empresa_cliente(formulario.txtDescripcionEmpresa.getText().toString());
				clase.setDireccion_empresa_cliente(formulario.txtDireccionEmpresa.getText().toString());
				clase.setRtn_empresa_cliente(formulario.txtRTNEmpresa.getText().toString());
				clase.setTelefono_empresa_cliente(formulario.txtTelefonoEmpresa.getText().toString());
				clase.setCorreo_empresa_cliente(formulario.txtCorreoEmpresa.getText().toString());

				if (consulta.modificar(clase)) {
					JOptionPane.showMessageDialog(null, "Cliente actualizado!");
					limpiar();
					formulario.construirTabla();
					formulario.obtenerUltimoId();
					formulario.txtFotoCliente.setText("Sin Fotografia.");

					final ImageIcon iconoContrato = new ImageIcon(getClass().getResource("/iconos/usuario.png"));
					final ImageIcon iconofoto = new ImageIcon(iconoContrato.getImage().getScaledInstance(
							formulario.lblFotoC.getWidth(), formulario.lblFotoC.getHeight(), Image.SCALE_DEFAULT));
					formulario.lblFotoC.setIcon(iconofoto);
				} else {
					JOptionPane.showMessageDialog(null, "Error! Cliente no actualizado");
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
					String nombres = formulario.tabla.getValueAt(filaseleccionada, 1).toString();
					String apellidos = formulario.tabla.getValueAt(filaseleccionada, 2).toString();
					String direccion1 = formulario.tabla.getValueAt(filaseleccionada, 3).toString();
					String telefono1 = formulario.tabla.getValueAt(filaseleccionada, 4).toString();
					String correo1 = formulario.tabla.getValueAt(filaseleccionada, 5).toString();
					String genero = formulario.tabla.getValueAt(filaseleccionada, 6).toString();
					String identidad = formulario.tabla.getValueAt(filaseleccionada, 7).toString();
					String foto = formulario.tabla.getValueAt(filaseleccionada, 8).toString();
					String nombre = formulario.tabla.getValueAt(filaseleccionada, 9).toString();
					String descripcion = formulario.tabla.getValueAt(filaseleccionada, 10).toString();
					String direccion2 = formulario.tabla.getValueAt(filaseleccionada, 11).toString();
					String rtn = formulario.tabla.getValueAt(filaseleccionada, 12).toString();
					String telefono2 = formulario.tabla.getValueAt(filaseleccionada, 13).toString();
					String correo2 = formulario.tabla.getValueAt(filaseleccionada, 14).toString();

					formulario.txtCodigo.setText(codigo);
					formulario.txtNombresCliente.setText(nombres);
					formulario.txtApellidosCliente.setText(apellidos);
					formulario.txtDireccionCliente.setText(direccion1);
					formulario.txtTelefonoCliente.setText(telefono1);
					formulario.txtCorreoCliente.setText(correo1);
					formulario.cbxGeneroCliente.setSelectedItem(genero);
					formulario.txtIdentidadCliente.setText(identidad);
					formulario.txtFotoCliente.setText(foto);
					formulario.txtNombreEmpresa.setText(nombre);
					formulario.txtDescripcionEmpresa.setText(descripcion);
					formulario.txtDireccionEmpresa.setText(direccion2);
					formulario.txtRTNEmpresa.setText(rtn);
					formulario.txtTelefonoEmpresa.setText(telefono2);
					formulario.txtCorreoEmpresa.setText(correo2);

					formulario.txtCodigo.setForeground(Color.BLACK);
					formulario.txtNombresCliente.setForeground(Color.BLACK);
					formulario.txtApellidosCliente.setForeground(Color.BLACK);
					formulario.txtDireccionCliente.setForeground(Color.BLACK);
					formulario.txtTelefonoCliente.setForeground(Color.BLACK);
					formulario.txtCorreoCliente.setForeground(Color.BLACK);
					formulario.cbxGeneroCliente.setForeground(Color.BLACK);
					formulario.txtIdentidadCliente.setForeground(Color.BLACK);
					formulario.txtFotoCliente.setForeground(Color.BLACK);
					formulario.txtNombreEmpresa.setForeground(Color.BLACK);
					formulario.txtDescripcionEmpresa.setForeground(Color.BLACK);
					formulario.txtDireccionEmpresa.setForeground(Color.BLACK);
					formulario.txtRTNEmpresa.setForeground(Color.BLACK);
					formulario.txtTelefonoEmpresa.setForeground(Color.BLACK);
					formulario.txtCorreoEmpresa.setForeground(Color.BLACK);

					final ImageIcon iconoContrato = new ImageIcon(foto);
					final ImageIcon iconofoto = new ImageIcon(iconoContrato.getImage().getScaledInstance(
							formulario.lblFotoC.getWidth(), formulario.lblFotoC.getHeight(), Image.SCALE_DEFAULT));
					formulario.lblFotoC.setIcon(iconofoto);

					formulario.btnBorrar.setVisible(true);
					formulario.btnGuardar.setVisible(false);
					formulario.btnNuevo.setVisible(false);
					formulario.btnActualizar.setVisible(true);
					formulario.btnActualizarDatos.setVisible(true);
					formulario.btnVer.setVisible(false);
					formulario.btnAceptar.setText("Cancelar");
					formulario.btnAceptar.setVisible(true);

					formulario.txtNombresCliente.requestFocusInWindow();

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
					String nombres = formulario.tabla.getValueAt(filaseleccionada, 1).toString();
					String apellidos = formulario.tabla.getValueAt(filaseleccionada, 2).toString();
					String direccion1 = formulario.tabla.getValueAt(filaseleccionada, 3).toString();
					String telefono1 = formulario.tabla.getValueAt(filaseleccionada, 4).toString();
					String correo1 = formulario.tabla.getValueAt(filaseleccionada, 5).toString();
					String genero = formulario.tabla.getValueAt(filaseleccionada, 6).toString();
					String identidad = formulario.tabla.getValueAt(filaseleccionada, 7).toString();
					String foto = formulario.tabla.getValueAt(filaseleccionada, 8).toString();
					String nombre = formulario.tabla.getValueAt(filaseleccionada, 9).toString();
					String descripcion = formulario.tabla.getValueAt(filaseleccionada, 10).toString();
					String direccion2 = formulario.tabla.getValueAt(filaseleccionada, 11).toString();
					String rtn = formulario.tabla.getValueAt(filaseleccionada, 12).toString();
					String telefono2 = formulario.tabla.getValueAt(filaseleccionada, 13).toString();
					String correo2 = formulario.tabla.getValueAt(filaseleccionada, 14).toString();

					formulario.txtCodigo.setText(codigo);
					formulario.txtNombresCliente.setText(nombres);
					formulario.txtApellidosCliente.setText(apellidos);
					formulario.txtDireccionCliente.setText(direccion1);
					formulario.txtTelefonoCliente.setText(telefono1);
					formulario.txtCorreoCliente.setText(correo1);
					formulario.cbxGeneroCliente.setSelectedItem(genero);
					formulario.txtIdentidadCliente.setText(identidad);
					formulario.txtFotoCliente.setText(foto);
					formulario.txtNombreEmpresa.setText(nombre);
					formulario.txtDescripcionEmpresa.setText(descripcion);
					formulario.txtDireccionEmpresa.setText(direccion2);
					formulario.txtRTNEmpresa.setText(rtn);
					formulario.txtTelefonoEmpresa.setText(telefono2);
					formulario.txtCorreoEmpresa.setText(correo2);

					formulario.txtCodigo.setForeground(Color.BLACK);
					formulario.txtNombresCliente.setForeground(Color.BLACK);
					formulario.txtApellidosCliente.setForeground(Color.BLACK);
					formulario.txtDireccionCliente.setForeground(Color.BLACK);
					formulario.txtTelefonoCliente.setForeground(Color.BLACK);
					formulario.txtCorreoCliente.setForeground(Color.BLACK);
					formulario.cbxGeneroCliente.setForeground(Color.BLACK);
					formulario.txtIdentidadCliente.setForeground(Color.BLACK);
					formulario.txtFotoCliente.setForeground(Color.BLACK);
					formulario.txtNombreEmpresa.setForeground(Color.BLACK);
					formulario.txtDescripcionEmpresa.setForeground(Color.BLACK);
					formulario.txtDireccionEmpresa.setForeground(Color.BLACK);
					formulario.txtRTNEmpresa.setForeground(Color.BLACK);
					formulario.txtTelefonoEmpresa.setForeground(Color.BLACK);
					formulario.txtCorreoEmpresa.setForeground(Color.BLACK);

					formulario.txtCodigo.setEditable(false);
					formulario.txtNombresCliente.setEditable(false);
					formulario.txtApellidosCliente.setEditable(false);
					formulario.txtDireccionCliente.setEditable(false);
					formulario.txtTelefonoCliente.setEditable(false);
					formulario.txtCorreoCliente.setEditable(false);
					formulario.cbxGeneroCliente.setEditable(false);
					formulario.txtIdentidadCliente.setEditable(false);
					formulario.txtFotoCliente.setEditable(false);
					formulario.txtNombreEmpresa.setEditable(false);
					formulario.txtDescripcionEmpresa.setEditable(false);
					formulario.txtDireccionEmpresa.setEditable(false);
					formulario.txtRTNEmpresa.setEditable(false);
					formulario.txtTelefonoEmpresa.setEditable(false);
					formulario.txtCorreoEmpresa.setEditable(false);

					final ImageIcon iconoContrato = new ImageIcon(foto);
					final ImageIcon iconofoto = new ImageIcon(iconoContrato.getImage().getScaledInstance(
							formulario.lblFotoC.getWidth(), formulario.lblFotoC.getHeight(), Image.SCALE_DEFAULT));
					formulario.lblFotoC.setIcon(iconofoto);

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
						ps = conn.prepareStatement("DELETE FROM clientes WHERE id_cliente=?");
						ps.setString(1, codigo);
						ps.execute();
						JOptionPane.showMessageDialog(null, "Cliente Eliminado!");
						limpiar();
						formulario.construirTabla();
						formulario.txtCodigo.setText(null);
						formulario.btnAceptar.setEnabled(true);
						formulario.btnActualizar.setVisible(false);
						formulario.btnGuardar.setVisible(false);
						formulario.btnNuevo.setVisible(false);

						final ImageIcon iconoContrato = new ImageIcon(getClass().getResource("/iconos/usuario.png"));
						final ImageIcon iconofoto = new ImageIcon(iconoContrato.getImage().getScaledInstance(
								formulario.lblFotoC.getWidth(), formulario.lblFotoC.getHeight(), Image.SCALE_DEFAULT));
						formulario.lblFotoC.setIcon(iconofoto);
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

			final ImageIcon iconoContrato = new ImageIcon(getClass().getResource("/iconos/usuario.png"));
			final ImageIcon iconofoto = new ImageIcon(iconoContrato.getImage().getScaledInstance(
					formulario.lblFotoC.getWidth(), formulario.lblFotoC.getHeight(), Image.SCALE_DEFAULT));
			formulario.lblFotoC.setIcon(iconofoto);
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
			formulario.txtCodigo.setEditable(false);
			formulario.txtNombresCliente.setEditable(true);
			formulario.txtApellidosCliente.setEditable(true);
			formulario.txtDireccionCliente.setEditable(true);
			formulario.txtTelefonoCliente.setEditable(true);
			formulario.txtCorreoCliente.setEditable(true);
			formulario.cbxGeneroCliente.setEditable(true);
			formulario.txtIdentidadCliente.setEditable(true);
			formulario.txtFotoCliente.setEditable(false);
			formulario.txtFotoCliente.setText("Sin Fotografia.");
			formulario.txtNombreEmpresa.setEditable(true);
			formulario.txtDescripcionEmpresa.setEditable(true);
			formulario.txtDireccionEmpresa.setEditable(true);
			formulario.txtRTNEmpresa.setEditable(true);
			formulario.txtTelefonoEmpresa.setEditable(true);
			formulario.txtCorreoEmpresa.setEditable(true);
			formulario.txtNombresCliente.requestFocusInWindow();

			final ImageIcon iconoContrato = new ImageIcon(getClass().getResource("/iconos/usuario.png"));
			final ImageIcon iconofoto = new ImageIcon(iconoContrato.getImage().getScaledInstance(
					formulario.lblFotoC.getWidth(), formulario.lblFotoC.getHeight(), Image.SCALE_DEFAULT));
			formulario.lblFotoC.setIcon(iconofoto);
		}

	}

	/* Metodos para implementar */

	/* Metodo para el boton nuevo que limpia los datos de los txtFields */
	public void limpiar() {
		formulario.txtBusqueda.setText(null);
		formulario.txtCodigo.setText(null);
		formulario.txtNombresCliente.setText(null);
		formulario.txtApellidosCliente.setText(null);
		formulario.txtDireccionCliente.setText(null);
		formulario.txtTelefonoCliente.setText(null);
		formulario.txtCorreoCliente.setText(null);
		formulario.txtIdentidadCliente.setText(null);
		formulario.txtFotoCliente.setText("Sin Fotografia.");
		formulario.txtNombreEmpresa.setText(null);
		formulario.txtDescripcionEmpresa.setText(null);
		formulario.txtDireccionEmpresa.setText(null);
		formulario.txtRTNEmpresa.setText(null);
		formulario.txtTelefonoEmpresa.setText(null);
		formulario.txtCorreoEmpresa.setText(null);
		formulario.txtNombresCliente.requestFocusInWindow();
	}

	public static ArrayList<cliente> buscarUsuariosConMatriz() {
		conexion conex = new conexion();
		ArrayList<cliente> miLista = new ArrayList<cliente>();
		cliente cliente;
		try {
			Statement estatuto = conex.getConexion().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT * FROM clientes");

			while (rs.next()) {
				cliente = new cliente();
				cliente.setId_cliente(Integer.parseInt(rs.getString("id_cliente")));
				cliente.setNombres_cliente(rs.getString("nombres_cliente"));
				cliente.setApellidos_cliente(rs.getString("apellidos_cliente"));
				cliente.setDireccion_cliente(rs.getString("direccion_cliente"));
				cliente.setTelefono_cliente(rs.getString("telefono_cliente"));
				cliente.setCorreo_cliente(rs.getString("correo_cliente"));
				cliente.setGenero_cliente(rs.getString("genero_cliente"));
				cliente.setIdentidad_cliente(rs.getString("identidad_cliente"));
				cliente.setFoto_cliente(rs.getString("foto_cliente"));
				cliente.setNombre_empresa_cliente(rs.getString("nombre_empresa_cliente"));
				cliente.setDescripcion_empresa_cliente(rs.getString("descripcion_empresa_cliente"));
				cliente.setDireccion_empresa_cliente(rs.getString("direccion_empresa_cliente"));
				cliente.setRtn_empresa_cliente(rs.getString("rtn_empresa_cliente"));
				cliente.setTelefono_empresa_cliente(rs.getString("telefono_empresa_cliente"));
				cliente.setCorreo_empresa_cliente(rs.getString("correo_empresa_cliente"));
				miLista.add(cliente);
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
		ArrayList<cliente> miLista = buscarUsuariosConMatriz();
		String matrizInfo[][] = new String[miLista.size()][15];
		for (int i = 0; i < miLista.size(); i++) {
			matrizInfo[i][0] = miLista.get(i).getId_cliente() + "";
			matrizInfo[i][1] = miLista.get(i).getNombres_cliente() + "";
			matrizInfo[i][2] = miLista.get(i).getApellidos_cliente() + "";
			matrizInfo[i][3] = miLista.get(i).getDireccion_cliente() + "";
			matrizInfo[i][4] = miLista.get(i).getTelefono_cliente() + "";
			matrizInfo[i][5] = miLista.get(i).getCorreo_cliente() + "";
			matrizInfo[i][6] = miLista.get(i).getGenero_cliente() + "";
			matrizInfo[i][7] = miLista.get(i).getIdentidad_cliente() + "";
			matrizInfo[i][8] = miLista.get(i).getFoto_cliente() + "";
			matrizInfo[i][9] = miLista.get(i).getNombre_empresa_cliente() + "";
			matrizInfo[i][10] = miLista.get(i).getDescripcion_empresa_cliente() + "";
			matrizInfo[i][11] = miLista.get(i).getDireccion_empresa_cliente() + "";
			matrizInfo[i][12] = miLista.get(i).getRtn_empresa_cliente() + "";
			matrizInfo[i][13] = miLista.get(i).getTelefono_empresa_cliente() + "";
			matrizInfo[i][14] = miLista.get(i).getCorreo_empresa_cliente() + "";

		}

		return matrizInfo;
	}

}
