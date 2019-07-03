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

import clases.cliente;
import clases.inventario;
import clases.usuario;
import conexion.conexion;
import consultas.consultas_cliente;
import consultas.consultas_inventario;
import consultas.consultas_usuario;
import formularios.registro_clientes;
import formularios.registro_inventario;
import formularios.registro_usuarios;

public class control_usuario implements ActionListener {

	public usuario clase;
	public consultas_usuario consulta;
	public registro_usuarios formulario;
	public static String identidad = null;

	public control_usuario(usuario clase, consultas_usuario consulta, registro_usuarios formulario) {
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
			if (formulario.txtNombres.getText().isEmpty()
					|| formulario.txtApellidos.getText().isEmpty()
					|| formulario.txtCargo.getText().isEmpty()
					|| formulario.txtIdentidad.getText().isEmpty()
					|| formulario.txtUsuario.getText().isEmpty()
					|| formulario.txtContraseña.getText().isEmpty()) 
			{
				JOptionPane.showMessageDialog(null, "Porfavor llene los campos para guardar el usuario!");
			} else {
				clase.setUsuario(formulario.txtUsuario.getText().toString());
				clase.setContraseña(formulario.txtContraseña.getText().toString());
				clase.setIdentidad(formulario.txtIdentidad.getText().toString());
				clase.setNombre(formulario.txtNombres.getText().toString()+" "+formulario.txtApellidos.getText().toString());
				clase.setCargo(formulario.txtCargo.getText().toString());
				clase.setTipo_usuario(formulario.cbxTipoUsuario.getSelectedItem().toString());
				clase.setPermisos(formulario.txtPermisos.getText().toString());

				if (consulta.insertar(clase)) {
					JOptionPane.showMessageDialog(null, "Usuario registrado!");
					limpiar();
					formulario.construirTabla();
					formulario.obtenerUltimoId();
				} else {
					JOptionPane.showMessageDialog(null, "Error! Usuario no registrado");
					limpiar();
				}
			}

		}

		if (e.getSource() == formulario.btnActualizar)
		{
			if (formulario.txtNombres.getText().isEmpty()
					|| formulario.txtApellidos.getText().isEmpty()
					|| formulario.txtCargo.getText().isEmpty()
					|| formulario.txtIdentidad.getText().isEmpty()
					|| formulario.txtUsuario.getText().isEmpty()
					|| formulario.txtContraseña.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Porfavor llene los campos para guardar el usuario!");
			} else {
				clase.setId_usuario(Integer.parseInt(formulario.txtCodigo.getText().toString()));
				clase.setUsuario(formulario.txtUsuario.getText().toString());
				clase.setContraseña(formulario.txtContraseña.getText().toString());
				clase.setIdentidad(formulario.txtIdentidad.getText().toString());
				clase.setNombre(formulario.txtNombres.getText().toString()+" "+formulario.txtApellidos.getText().toString());
				clase.setCargo(formulario.txtCargo.getText().toString());
				clase.setTipo_usuario(formulario.cbxTipoUsuario.getSelectedItem().toString());
				clase.setPermisos(formulario.txtPermisos.getText().toString());

				if (consulta.actualizar(clase)) {
					JOptionPane.showMessageDialog(null, "Usuario actualizado!");
					limpiar();
					formulario.construirTabla();
					formulario.obtenerUltimoId();
				} else {
					JOptionPane.showMessageDialog(null, "Error! Usuario no actualizado");
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
					String usuario = formulario.tabla.getValueAt(filaseleccionada, 1).toString();
					String contraseña = formulario.tabla.getValueAt(filaseleccionada, 2).toString();
					String identidad = formulario.tabla.getValueAt(filaseleccionada, 3).toString();
					String nombre = formulario.tabla.getValueAt(filaseleccionada, 4).toString();
					String cargo = formulario.tabla.getValueAt(filaseleccionada, 5).toString();
					String tipo = formulario.tabla.getValueAt(filaseleccionada, 6).toString();
					String permisos = formulario.tabla.getValueAt(filaseleccionada, 7).toString();

					formulario.txtCodigo.setText(codigo);
					formulario.txtUsuario.setText(usuario);
					formulario.txtContraseña.setText(contraseña);
					formulario.txtIdentidad.setText(identidad);
					formulario.txtNombres.setText(nombre);
					formulario.txtCargo.setText(cargo);
					formulario.cbxTipoUsuario.setSelectedItem(tipo);
					formulario.txtPermisos.setText(permisos);

					formulario.txtCodigo.setForeground(Color.BLACK);
					formulario.txtUsuario.setForeground(Color.BLACK);
					formulario.txtContraseña.setForeground(Color.BLACK);
					formulario.txtIdentidad.setForeground(Color.BLACK);
					formulario.txtNombres.setForeground(Color.BLACK);
					formulario.txtCargo.setForeground(Color.BLACK);
					formulario.cbxTipoUsuario.setForeground(Color.BLACK);
					formulario.txtPermisos.setForeground(Color.BLACK);

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
				filaseleccionada = formulario.tabla.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					String codigo = formulario.tabla.getValueAt(filaseleccionada, 0).toString();
					String usuario = formulario.tabla.getValueAt(filaseleccionada, 1).toString();
					String contraseña = formulario.tabla.getValueAt(filaseleccionada, 2).toString();
					String identidad = formulario.tabla.getValueAt(filaseleccionada, 3).toString();
					String nombre = formulario.tabla.getValueAt(filaseleccionada, 4).toString();
					String cargo = formulario.tabla.getValueAt(filaseleccionada, 5).toString();
					String tipo = formulario.tabla.getValueAt(filaseleccionada, 6).toString();
					String permisos = formulario.tabla.getValueAt(filaseleccionada, 7).toString();

					formulario.txtCodigo.setText(codigo);
					formulario.txtUsuario.setText(usuario);
					formulario.txtContraseña.setText(contraseña);
					formulario.txtIdentidad.setText(identidad);
					formulario.txtNombres.setText(nombre);
					formulario.txtCargo.setText(cargo);
					formulario.cbxTipoUsuario.setSelectedItem(tipo);
					formulario.txtPermisos.setText(permisos);

					formulario.txtCodigo.setForeground(Color.BLACK);
					formulario.txtUsuario.setForeground(Color.BLACK);
					formulario.txtContraseña.setForeground(Color.BLACK);
					formulario.txtIdentidad.setForeground(Color.BLACK);
					formulario.txtNombres.setForeground(Color.BLACK);
					formulario.txtCargo.setForeground(Color.BLACK);
					formulario.cbxTipoUsuario.setForeground(Color.BLACK);
					formulario.txtPermisos.setForeground(Color.BLACK);

					formulario.txtCodigo.setEditable(false);
					formulario.txtUsuario.setEditable(false);
					formulario.txtContraseña.setEditable(false);
					formulario.txtIdentidad.setEditable(false);
					formulario.txtNombres.setEditable(false);
					formulario.txtCargo.setEditable(false);
					formulario.cbxTipoUsuario.setEditable(false);
					formulario.txtPermisos.setEditable(false);

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
					ps = conn.prepareStatement("DELETE FROM usuario WHERE id_usuario=?");
					ps.setString(1, codigo);
					ps.execute();
					JOptionPane.showMessageDialog(null, "Usuario Eliminado!");
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
			formulario.txtCodigo.setEditable(false);
			formulario.txtCodigo.setEditable(true);
			formulario.txtUsuario.setEditable(true);
			formulario.txtContraseña.setEditable(true);
			formulario.txtIdentidad.setEditable(true);
			formulario.txtNombres.setEditable(true);
			formulario.txtCargo.setEditable(true);
			formulario.cbxTipoUsuario.setEditable(true);
			formulario.txtPermisos.setEditable(true);
			formulario.txtBusqueda.requestFocusInWindow();
		}

	}

	/* Metodos para implementar */

	/* Metodo para el boton nuevo que limpia los datos de los txtFields */
	public void limpiar() {
		formulario.txtBusqueda.setText(null);
		formulario.txtCodigo.setText(null);
		formulario.txtUsuario.setText(null);
		formulario.txtContraseña.setText(null);
		formulario.txtIdentidad.setText(null);
		formulario.txtNombres.setText(null);
		formulario.txtCargo.setText(null);
		formulario.txtPermisos.setText(null);
		formulario.txtBusqueda.requestFocusInWindow();
	}

	public static ArrayList<usuario> buscarUsuariosConMatriz() {
		conexion conex = new conexion();
		ArrayList<usuario> miLista = new ArrayList<usuario>();
		usuario usuario;
		try {
			Statement estatuto = conex.getConexion().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT * FROM usuario");

			while (rs.next()) {
				usuario = new usuario();
				usuario.setId_usuario(Integer.parseInt(rs.getString("id_usuario")));
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setContraseña(rs.getString("contraseña"));
				usuario.setIdentidad(rs.getString("identidad"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setCargo(rs.getString("cargo"));
				usuario.setTipo_usuario(rs.getString("tipo_usuario"));
				usuario.setPermisos(rs.getString("permisos"));
				miLista.add(usuario);
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
		ArrayList<usuario> miLista = buscarUsuariosConMatriz();
		String matrizInfo[][] = new String[miLista.size()][8];
		for (int i = 0; i < miLista.size(); i++) {
			matrizInfo[i][0] = miLista.get(i).getId_usuario() + "";
			matrizInfo[i][1] = miLista.get(i).getUsuario() + "";
			matrizInfo[i][2] = miLista.get(i).getContraseña() + "";
			matrizInfo[i][3] = miLista.get(i).getIdentidad() + "";
			matrizInfo[i][4] = miLista.get(i).getNombre() + "";
			matrizInfo[i][5] = miLista.get(i).getCargo() + "";
			matrizInfo[i][6] = miLista.get(i).getTipo_usuario() + "";
			matrizInfo[i][7] = miLista.get(i).getPermisos() + "";

		}

		return matrizInfo;
	}

}
