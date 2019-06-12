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
import clases.proveedor;
import conexion.conexion;
import consultas.consultas_proveedor;
import formularios.registro_proveedores;

public class control_proveedor implements ActionListener {

	public proveedor clase;
	public consultas_proveedor consulta;
	public registro_proveedores formulario;
	public static String rtn = null;

	public control_proveedor(proveedor clase, consultas_proveedor consulta, registro_proveedores formulario) {
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
		this.formulario.btnVerFotoProducto.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == formulario.btnGuardar) {
			validarIdentidad();
			if (formulario.txtNombresProveedor.getText().isEmpty() || formulario.txtDireccionFotoProveedor.getText().isEmpty()
					|| formulario.txtCorreoProveedor.getText().isEmpty() || formulario.txtDireccionProveedor.getText().isEmpty()
					|| formulario.txtCuentaProveedor.getText().isEmpty() || formulario.txtTelefonoProveedor.getText().isEmpty() || formulario.txtRtnProveedor.getText().isEmpty())
			{
			JOptionPane.showMessageDialog(null, "Porfavor llene los campos para guardar el proveedor!");
			} else {
				if (formulario.txtRtnProveedor.getText().toString().equals(rtn)) 
				{
					JOptionPane.showMessageDialog(null, "Se encontrado un registro con esta identidad o rtn : " + rtn,
							"Atencion datos duplicados", JOptionPane.INFORMATION_MESSAGE);
				} else {
			clase.setNombres_proveedor(formulario.txtNombresProveedor.getText().toString());
			clase.setCuenta_bancaria_proveedor(formulario.txtCuentaProveedor.getText().toString());
			clase.setDireccion_proveedor(formulario.txtDireccionProveedor.getText().toString());
			clase.setRtn_proveedor(formulario.txtRtnProveedor.getText().toString());
			clase.setTelefono_proveedor(formulario.txtTelefonoProveedor.getText().toString());
			clase.setCorreo_electronico_proveedor(formulario.txtCorreoProveedor.getText().toString());
			clase.setFoto_proveedor(formulario.txtDireccionFotoProveedor.getText().toString());
			
			if (consulta.insertar(clase)) {
				JOptionPane.showMessageDialog(null, "Proveedor registrado!");
				limpiar();
				formulario.txtDireccionFotoProveedor.setText("Sin Fotografia.");
				formulario.construirTabla();
				formulario.obtenerUltimoId();
				final ImageIcon iconoContrato = new ImageIcon(getClass().getResource("/iconos/usuario.png"));
				final ImageIcon iconofoto = new ImageIcon(
						iconoContrato.getImage().getScaledInstance(formulario.lbl_foto_contrato.getWidth(),
								formulario.lbl_foto_contrato.getHeight(), Image.SCALE_DEFAULT));
				formulario.lbl_foto_contrato.setIcon(iconofoto);
			} else {
				JOptionPane.showMessageDialog(null, "Error! proveedor no registrado");
				limpiar();
			}
				}
		}
	}
		
		/* Actualizar */
			if (e.getSource() == formulario.btnActualizar) {
				if (formulario.txtNombresProveedor.getText().isEmpty() || formulario.txtDireccionFotoProveedor.getText().isEmpty()
						|| formulario.txtCorreoProveedor.getText().isEmpty() || formulario.txtDireccionProveedor.getText().isEmpty()
						|| formulario.txtCuentaProveedor.getText().isEmpty() || formulario.txtTelefonoProveedor.getText().isEmpty() || formulario.txtRtnProveedor.getText().isEmpty())
				{
				JOptionPane.showMessageDialog(null, "Porfavor llene los campos para actualizar el proveedor!");
				} else {
					if (formulario.txtRtnProveedor.getText().toString().equals(rtn)) 
					{
						JOptionPane.showMessageDialog(null, "Se encontrado un registro con esta identidad o rtn : " + rtn,
								"Atencion datos duplicados", JOptionPane.INFORMATION_MESSAGE);
					} else {
				
				clase.setId_proveedor(Integer.parseInt(formulario.txtCodigoProveedor.getText().toString()));
				clase.setNombres_proveedor(formulario.txtNombresProveedor.getText().toString());
				clase.setCuenta_bancaria_proveedor(formulario.txtCuentaProveedor.getText().toString());
				clase.setDireccion_proveedor(formulario.txtDireccionProveedor.getText().toString());
				clase.setRtn_proveedor(formulario.txtRtnProveedor.getText().toString());
				clase.setTelefono_proveedor(formulario.txtTelefonoProveedor.getText().toString());
				clase.setCorreo_electronico_proveedor(formulario.txtCorreoProveedor.getText().toString());
				clase.setFoto_proveedor(formulario.txtDireccionFotoProveedor.getText().toString());
				
				if (consulta.actualizar(clase)) {
					JOptionPane.showMessageDialog(null, "Proveedor actualizado!");
					limpiar();
					formulario.txtDireccionFotoProveedor.setText("Sin Fotografia.");
					formulario.construirTabla();
					formulario.obtenerUltimoId();
					final ImageIcon iconoContrato = new ImageIcon(getClass().getResource("/iconos/usuario.png"));
					final ImageIcon iconofoto = new ImageIcon(
							iconoContrato.getImage().getScaledInstance(formulario.lbl_foto_contrato.getWidth(),
									formulario.lbl_foto_contrato.getHeight(), Image.SCALE_DEFAULT));
					formulario.lbl_foto_contrato.setIcon(iconofoto);
				} else {
					JOptionPane.showMessageDialog(null, "Error! proveedor no actualizado");
					limpiar();
				}
			}
				}
		}
	
		if (e.getSource() == formulario.btnActualizarDatos) {
			int filaseleccionada;
			try {
				filaseleccionada = formulario.tablaProveedores.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					String codigo = formulario.tablaProveedores.getValueAt(filaseleccionada, 0).toString();
					String nombre = formulario.tablaProveedores.getValueAt(filaseleccionada, 1).toString();
					String cuenta = formulario.tablaProveedores.getValueAt(filaseleccionada, 2).toString();
					String direccion = formulario.tablaProveedores.getValueAt(filaseleccionada, 3).toString();
					String rtn = formulario.tablaProveedores.getValueAt(filaseleccionada, 4).toString();
					String telefono = formulario.tablaProveedores.getValueAt(filaseleccionada, 5).toString();
					String correo = formulario.tablaProveedores.getValueAt(filaseleccionada, 6).toString();
					String foto = formulario.tablaProveedores.getValueAt(filaseleccionada, 7).toString();


					formulario.txtCodigoProveedor.setText(codigo);
					formulario.txtNombresProveedor.setText(nombre);
					formulario.txtCuentaProveedor.setText(cuenta);
					formulario.txtCorreoProveedor.setText(correo);
					formulario.txtRtnProveedor.setText(rtn);
					formulario.txtDireccionProveedor.setText(direccion);
					formulario.txtTelefonoProveedor.setText(telefono);
					formulario.txtDireccionFotoProveedor.setText(foto);

					final ImageIcon foto_contrato = new ImageIcon(foto);
					final ImageIcon logo = new ImageIcon(
							foto_contrato.getImage().getScaledInstance(formulario.lbl_foto_contrato.getWidth(),
									formulario.lbl_foto_contrato.getHeight(), Image.SCALE_DEFAULT));
					formulario.lbl_foto_contrato.setIcon(logo);

					formulario.txtCodigoProveedor.setForeground(Color.BLACK);
					formulario.txtCorreoProveedor.setForeground(Color.BLACK);
					formulario.txtCuentaProveedor.setForeground(Color.BLACK);
					formulario.txtNombresProveedor.setForeground(Color.BLACK);
					formulario.txtDireccionFotoProveedor.setForeground(Color.BLACK);
					formulario.txtDireccionProveedor.setForeground(Color.BLACK);
					formulario.txtTelefonoProveedor.setForeground(Color.BLACK);
					formulario.txtRtnProveedor.setForeground(Color.BLACK);


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
				filaseleccionada = formulario.tablaProveedores.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					String codigo = formulario.tablaProveedores.getValueAt(filaseleccionada, 0).toString();
					String nombre = formulario.tablaProveedores.getValueAt(filaseleccionada, 1).toString();
					String cuenta = formulario.tablaProveedores.getValueAt(filaseleccionada, 2).toString();
					String direccion = formulario.tablaProveedores.getValueAt(filaseleccionada, 3).toString();
					String rtn = formulario.tablaProveedores.getValueAt(filaseleccionada, 4).toString();
					String telefono = formulario.tablaProveedores.getValueAt(filaseleccionada, 5).toString();
					String correo = formulario.tablaProveedores.getValueAt(filaseleccionada, 6).toString();
					String foto = formulario.tablaProveedores.getValueAt(filaseleccionada, 7).toString();


					formulario.txtCodigoProveedor.setText(codigo);
					formulario.txtNombresProveedor.setText(nombre);
					formulario.txtCuentaProveedor.setText(cuenta);
					formulario.txtCorreoProveedor.setText(correo);
					formulario.txtRtnProveedor.setText(rtn);
					formulario.txtDireccionProveedor.setText(direccion);
					formulario.txtTelefonoProveedor.setText(telefono);
					formulario.txtDireccionFotoProveedor.setText(foto);

					final ImageIcon foto_contrato = new ImageIcon(foto);
					final ImageIcon logo = new ImageIcon(
							foto_contrato.getImage().getScaledInstance(formulario.lbl_foto_contrato.getWidth(),
									formulario.lbl_foto_contrato.getHeight(), Image.SCALE_DEFAULT));
					formulario.lbl_foto_contrato.setIcon(logo);

					formulario.txtCodigoProveedor.setForeground(Color.BLACK);
					formulario.txtCorreoProveedor.setForeground(Color.BLACK);
					formulario.txtCuentaProveedor.setForeground(Color.BLACK);
					formulario.txtNombresProveedor.setForeground(Color.BLACK);
					formulario.txtDireccionFotoProveedor.setForeground(Color.BLACK);
					formulario.txtDireccionProveedor.setForeground(Color.BLACK);
					formulario.txtTelefonoProveedor.setForeground(Color.BLACK);
					formulario.txtRtnProveedor.setForeground(Color.BLACK);

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
				filaseleccionada = formulario.tablaProveedores.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					conexion objCon = new conexion();
					Connection conn = objCon.getConexion();
					int Fila = formulario.tablaProveedores.getSelectedRow();
					String codigo = formulario.tablaProveedores.getValueAt(Fila, 0).toString();
					ps = conn.prepareStatement("DELETE FROM proveedores WHERE id_proveedor=?");
					ps.setString(1, codigo);
					ps.execute();
					JOptionPane.showMessageDialog(null, "Proveedor Eliminado!");
					limpiar();
					formulario.construirTabla();
					formulario.txtCodigoProveedor.setText(null);
					formulario.btnSubirFotoContrato.setEnabled(false);
					formulario.lbl_foto_contrato.setEnabled(false);
					formulario.btnAceptar.setEnabled(true);
					formulario.btnActualizar.setVisible(false);
					formulario.btnGuardar.setVisible(false);
					formulario.btnNuevo.setVisible(false);

				}
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "Error al Eliminar Proveedor");
				System.out.println(ex.toString());
			}
		}

		/* Nuevo */
		if (e.getSource() == formulario.btnNuevo) {
			limpiar();
			formulario.txtDireccionFotoProveedor.setText("Sin Fotografia.");
			formulario.obtenerUltimoId();
			formulario.btnBorrar.setVisible(false);
			formulario.btnGuardar.setVisible(true);
			formulario.btnNuevo.setVisible(true);
			formulario.btnActualizar.setVisible(false);
			formulario.btnActualizarDatos.setVisible(true);
			formulario.txtDireccionFotoProveedor.setEditable(false);
			formulario.btnVer.setVisible(true);
			formulario.btnAceptar.setVisible(false);
			formulario.pistas();
			formulario.construirTabla();
			final ImageIcon iconoContrato = new ImageIcon(getClass().getResource("/iconos/usuario.png"));
			final ImageIcon iconofoto = new ImageIcon(
					iconoContrato.getImage().getScaledInstance(formulario.lbl_foto_contrato.getWidth(),
							formulario.lbl_foto_contrato.getHeight(), Image.SCALE_DEFAULT));
			formulario.lbl_foto_contrato.setIcon(iconofoto);
		}

		/* Aceptar */
		if (e.getSource() == formulario.btnAceptar) {
			limpiar();
			formulario.txtDireccionFotoProveedor.setText("Sin Fotografia.");
			formulario.btnBorrar.setVisible(false);
			formulario.btnGuardar.setVisible(true);
			formulario.btnNuevo.setVisible(true);
			formulario.btnActualizar.setVisible(false);
			formulario.btnActualizarDatos.setVisible(true);
			formulario.txtDireccionFotoProveedor.setEditable(false);
			formulario.btnVer.setVisible(true);
			formulario.btnAceptar.setVisible(false);
			formulario.txtCodigoProveedor.setEnabled(true);
			formulario.txtCodigoProveedor.setEditable(false);
			formulario.obtenerUltimoId();
			formulario.pistas();
			formulario.construirTabla();
			final ImageIcon iconoContrato = new ImageIcon(getClass().getResource("/iconos/usuario.png"));
			final ImageIcon iconofoto = new ImageIcon(
					iconoContrato.getImage().getScaledInstance(formulario.lbl_foto_contrato.getWidth(),
							formulario.lbl_foto_contrato.getHeight(), Image.SCALE_DEFAULT));
			formulario.lbl_foto_contrato.setIcon(iconofoto);
	}
			
}

	public void limpiar() {
		formulario.txtBusqueda.setText(null);
		formulario.txtNombresProveedor.setText(null);
		formulario.txtCuentaProveedor.setText(null);
		formulario.txtCorreoProveedor.setText(null);
		formulario.txtDireccionFotoProveedor.setText(null);
		formulario.txtDireccionProveedor.setText(null);
		formulario.txtRtnProveedor.setText(null);
		formulario.txtTelefonoProveedor.setText(null);
	}

	public static ArrayList<proveedor> buscarUsuariosConMatriz() {
		conexion conex = new conexion();
		ArrayList<proveedor> miLista = new ArrayList<proveedor>();
		proveedor proveedor;
		try {
			Statement estatuto = conex.getConexion().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT * FROM proveedores ");

			while (rs.next()) {
				proveedor = new proveedor();
				proveedor.setId_proveedor(Integer.parseInt(rs.getString("id_proveedor")));
				proveedor.setNombres_proveedor(rs.getString("nombres_proveedor"));
				proveedor.setCuenta_bancaria_proveedor(rs.getString("cuenta_bancaria_proveedor"));
				proveedor.setDireccion_proveedor(rs.getString("direccion_proveedor"));
				proveedor.setRtn_proveedor(rs.getString("rtn_proveedor"));
				proveedor.setTelefono_proveedor(rs.getString("telefono_proveedor"));
				proveedor.setCorreo_electronico_proveedor(rs.getString("correo_electronico_proveedor"));
				proveedor.setFoto_proveedor(rs.getString("foto_proveedor"));
				miLista.add(proveedor);
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
		ArrayList<proveedor> miLista = buscarUsuariosConMatriz();
		String matrizInfo[][] = new String[miLista.size()][8];
		for (int i = 0; i < miLista.size(); i++) {
			matrizInfo[i][0] = miLista.get(i).getId_proveedor() + "";
			matrizInfo[i][1] = miLista.get(i).getNombres_proveedor() + "";
			matrizInfo[i][2] = miLista.get(i).getCuenta_bancaria_proveedor() + "";
			matrizInfo[i][3] = miLista.get(i).getDireccion_proveedor() + "";
			matrizInfo[i][4] = miLista.get(i).getRtn_proveedor() + "";
			matrizInfo[i][5] = miLista.get(i).getTelefono_proveedor() + "";
			matrizInfo[i][6] = miLista.get(i).getCorreo_electronico_proveedor() + "";
			matrizInfo[i][7] = miLista.get(i).getFoto_proveedor() + "";

		}

		return matrizInfo;
	}
	
	public void validarIdentidad() {
		conexion conex = new conexion();
		try {
			Statement estatuto = conex.getConexion().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT rtn_proveedor FROM proveedores where rtn_proveedor = '"
					+ formulario.txtRtnProveedor.getText().toString() + "'");

			if (rs.next()) {
				rtn = (rs.getString("rtn_proveedor"));
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
