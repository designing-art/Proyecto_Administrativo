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

import clases.contrato_cliente;
import conexion.conexion;
import consultas.consultas_contrato_cliente;
import formularios.registro_contratos_clientes;

public class control_contrato_cliente implements ActionListener {

	public contrato_cliente clase;
	public consultas_contrato_cliente consulta;
	public registro_contratos_clientes formulario;
	public static String identidad = null;

	public control_contrato_cliente(contrato_cliente clase, consultas_contrato_cliente consulta,
			registro_contratos_clientes formulario) {
		this.clase = clase;
		this.consulta = consulta;
		this.formulario = formulario;
		this.formulario.btnGuardarContrato.addActionListener(this);
		this.formulario.btnNuevoContrato.addActionListener(this);
		this.formulario.btnActualizarContrato.addActionListener(this);
		this.formulario.btnActualizarDatosContrato.addActionListener(this);
		this.formulario.btnBorrarContrato.addActionListener(this);
		this.formulario.btnMostrarContrato.addActionListener(this);
		this.formulario.btnAceptar.addActionListener(this);
		this.formulario.btnVerFotoContrato.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		validarIdentidad();
		/* Insertar */
		if (e.getSource() == formulario.btnGuardarContrato) {

			if (formulario.txtFotoContrato.getText().isEmpty() || formulario.txtIdentidadContrato.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Porfavor llene los campos para guardar el contrato!");
			} else {
				if (formulario.txtIdentidadContrato.getText().toString().equals(identidad)) {
					JOptionPane.showMessageDialog(null, "Se encontrado un registro con esta identidad : " + identidad,
							"Atencion datos duplicados", JOptionPane.INFORMATION_MESSAGE);
				} else {
					clase.setTipo_contrato_cliente(formulario.cbxTipo.getSelectedItem().toString());
					clase.setTiempo_contrato_cliente(formulario.cbxTiempo.getSelectedItem().toString());
					clase.setFoto_contrato_cliente(formulario.txtFotoContrato.getText().toString());
					clase.setIdentidad_rtn_cliente(formulario.txtIdentidadContrato.getText().toString());

					if (consulta.insertar(clase)) {
						JOptionPane.showMessageDialog(null, "Contrato registrado!");
						limpiar();
						formulario.txtFotoContrato.setText("Sin Fotografia.");
						formulario.construirTabla();
						formulario.obtenerUltimoId();
						final ImageIcon iconoContrato = new ImageIcon(getClass().getResource("/iconos/contrato.png"));
						final ImageIcon iconofoto = new ImageIcon(
								iconoContrato.getImage().getScaledInstance(formulario.lbl_foto_contrato.getWidth(),
										formulario.lbl_foto_contrato.getHeight(), Image.SCALE_DEFAULT));
						formulario.lbl_foto_contrato.setIcon(iconofoto);
					} else {
						JOptionPane.showMessageDialog(null, "Error! contrato no registrado");
						limpiar();
					}
				}
			}

		}

		/* Pasar datos de la tabla al formulario para actualizar */
		if (e.getSource() == formulario.btnActualizarDatosContrato) {

			int filaseleccionada;
			try {
				filaseleccionada = formulario.tablaContratos.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					String codigo = formulario.tablaContratos.getValueAt(filaseleccionada, 0).toString();
					String tipo = formulario.tablaContratos.getValueAt(filaseleccionada, 1).toString();
					String tiempo = formulario.tablaContratos.getValueAt(filaseleccionada, 2).toString();
					String foto = formulario.tablaContratos.getValueAt(filaseleccionada, 3).toString();
					String identidad = formulario.tablaContratos.getValueAt(filaseleccionada, 4).toString();

					formulario.txtCodigo.setText(codigo);
					formulario.cbxTipo.setSelectedItem(tipo);
					formulario.cbxTiempo.setSelectedItem(tiempo);
					formulario.txtFotoContrato.setText(foto);
					formulario.txtIdentidadContrato.setText(identidad);

					final ImageIcon foto_contrato = new ImageIcon(foto);
					final ImageIcon logo = new ImageIcon(
							foto_contrato.getImage().getScaledInstance(formulario.lbl_foto_contrato.getWidth(),
									formulario.lbl_foto_contrato.getHeight(), Image.SCALE_DEFAULT));
					formulario.lbl_foto_contrato.setIcon(logo);

					formulario.txtCodigo.setForeground(Color.BLACK);
					formulario.cbxTipo.setForeground(Color.BLACK);
					formulario.cbxTiempo.setForeground(Color.BLACK);
					formulario.txtFotoContrato.setForeground(Color.BLACK);
					formulario.txtIdentidadContrato.setForeground(Color.BLACK);

					formulario.txtIdentidadContrato.setEditable(true);
					formulario.btnBorrarContrato.setVisible(true);
					formulario.btnGuardarContrato.setVisible(false);
					formulario.btnNuevoContrato.setVisible(false);
					formulario.btnActualizarContrato.setVisible(true);
					formulario.btnActualizarDatosContrato.setVisible(true);
					formulario.btnMostrarContrato.setVisible(false);
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
		if (e.getSource() == formulario.btnMostrarContrato) {
			int fila;
			try {
				fila = formulario.tablaContratos.getSelectedRow();
				if (fila == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					String codigo = formulario.tablaContratos.getValueAt(fila, 0).toString();
					String tipo = formulario.tablaContratos.getValueAt(fila, 1).toString();
					String tiempo = formulario.tablaContratos.getValueAt(fila, 2).toString();
					String foto = formulario.tablaContratos.getValueAt(fila, 3).toString();
					String identidad = formulario.tablaContratos.getValueAt(fila, 4).toString();

					formulario.txtCodigo.setText(codigo);
					formulario.cbxTipo.setSelectedItem(tipo);
					formulario.cbxTiempo.setSelectedItem(tiempo);
					formulario.txtFotoContrato.setText(foto);
					formulario.txtIdentidadContrato.setText(identidad);

					final ImageIcon foto_contrato = new ImageIcon(foto);
					final ImageIcon logo = new ImageIcon(
							foto_contrato.getImage().getScaledInstance(formulario.lbl_foto_contrato.getWidth(),
									formulario.lbl_foto_contrato.getHeight(), Image.SCALE_DEFAULT));
					formulario.lbl_foto_contrato.setIcon(logo);

					formulario.txtCodigo.setForeground(Color.BLACK);
					formulario.cbxTipo.setForeground(Color.BLACK);
					formulario.cbxTiempo.setForeground(Color.BLACK);
					formulario.txtFotoContrato.setForeground(Color.BLACK);
					formulario.txtIdentidadContrato.setForeground(Color.BLACK);

					formulario.txtIdentidadContrato.setEditable(false);
					formulario.btnBorrarContrato.setVisible(false);
					formulario.btnGuardarContrato.setVisible(false);
					formulario.btnNuevoContrato.setVisible(false);
					formulario.btnActualizarContrato.setVisible(false);
					formulario.btnActualizarDatosContrato.setVisible(false);
					formulario.btnAceptar.setText("Aceptar");
					formulario.btnAceptar.setVisible(true);

				}

			} catch (HeadlessException ex) {
				JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente",
						" .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);
			}
		}

		/* Actualizar */
		if (e.getSource() == formulario.btnActualizarContrato) {
			validarIdentidad();
			if (formulario.txtFotoContrato.getText().isEmpty() || formulario.txtIdentidadContrato.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Porfavor llene los campos para actualizar el contrato!");
			} else {
				if (formulario.txtIdentidadContrato.getText().toString().equals(identidad)) {
					JOptionPane.showMessageDialog(null, "Se encontrado un registro con esta identidad : " + identidad,
							"Atencion datos duplicados", JOptionPane.INFORMATION_MESSAGE);
				} else {
					clase.setId_contrato_cliente(Integer.parseInt(formulario.txtCodigo.getText().toString()));
					clase.setTipo_contrato_cliente(formulario.cbxTipo.getSelectedItem().toString());
					clase.setTiempo_contrato_cliente(formulario.cbxTiempo.getSelectedItem().toString());
					clase.setFoto_contrato_cliente(formulario.txtFotoContrato.getText().toString());
					clase.setIdentidad_rtn_cliente(formulario.txtIdentidadContrato.getText().toString());

					if (consulta.actualizar(clase)) {
						JOptionPane.showMessageDialog(null, "Contrato Actualizado!");
						limpiar();
						formulario.txtFotoContrato.setText("Sin Fotografia.");
						formulario.construirTabla();
						formulario.obtenerUltimoId();
						formulario.btnActualizarContrato.setVisible(false);
						formulario.btnSubirFotoContrato.setVisible(false);
						formulario.txtCodigo.setEnabled(false);
						formulario.txtCodigo.setText(null);
						final ImageIcon iconoContrato = new ImageIcon(getClass().getResource("/iconos/contrato.png"));
						final ImageIcon iconofoto = new ImageIcon(
								iconoContrato.getImage().getScaledInstance(formulario.lbl_foto_contrato.getWidth(),
										formulario.lbl_foto_contrato.getHeight(), Image.SCALE_DEFAULT));
						formulario.lbl_foto_contrato.setIcon(iconofoto);

					} else {
						JOptionPane.showMessageDialog(null, "Error! contrato no Actualizado");
						limpiar();
					}

				}
			}
		}

		/* Borrar */
		if (e.getSource() == formulario.btnBorrarContrato) {
			PreparedStatement ps = null;
			int filaseleccionada;
			try {
				filaseleccionada = formulario.tablaContratos.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					conexion objCon = new conexion();
					Connection conn = objCon.getConexion();
					int Fila = formulario.tablaContratos.getSelectedRow();
					String codigo = formulario.tablaContratos.getValueAt(Fila, 0).toString();
					ps = conn.prepareStatement("DELETE FROM contrato_cliente WHERE id_contrato_cliente=?");
					ps.setString(1, codigo);
					ps.execute();
					JOptionPane.showMessageDialog(null, "Contrato Eliminado!");
					limpiar();
					formulario.construirTabla();
					formulario.txtCodigo.setText(null);
					formulario.btnSubirFotoContrato.setEnabled(false);
					formulario.lbl_foto_contrato.setEnabled(false);
					formulario.btnAceptar.setEnabled(true);
					formulario.btnActualizarContrato.setVisible(false);
					formulario.btnGuardarContrato.setVisible(false);
					formulario.btnNuevoContrato.setVisible(false);

				}
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "Error al Eliminar Cargo");
				System.out.println(ex.toString());
			}
		}

		/* Nuevo */
		if (e.getSource() == formulario.btnNuevoContrato) {
			limpiar();
			formulario.txtFotoContrato.setText("Sin Fotografia.");
			formulario.obtenerUltimoId();
			formulario.btnBorrarContrato.setVisible(false);
			formulario.btnGuardarContrato.setVisible(true);
			formulario.btnNuevoContrato.setVisible(true);
			formulario.btnActualizarContrato.setVisible(false);
			formulario.btnActualizarDatosContrato.setVisible(true);
			formulario.txtFotoContrato.setEditable(false);
			formulario.btnMostrarContrato.setVisible(true);
			formulario.btnAceptar.setVisible(false);
			formulario.txtIdentidadContrato.setEditable(true);
			formulario.pistas();
			formulario.construirTabla();
			final ImageIcon iconoContrato = new ImageIcon(getClass().getResource("/iconos/contrato.png"));
			final ImageIcon iconofoto = new ImageIcon(
					iconoContrato.getImage().getScaledInstance(formulario.lbl_foto_contrato.getWidth(),
							formulario.lbl_foto_contrato.getHeight(), Image.SCALE_DEFAULT));
			formulario.lbl_foto_contrato.setIcon(iconofoto);
		}

		/* Aceptar */
		if (e.getSource() == formulario.btnAceptar) {
			limpiar();
			formulario.txtFotoContrato.setText("Sin Fotografia.");
			formulario.btnBorrarContrato.setVisible(false);
			formulario.btnGuardarContrato.setVisible(true);
			formulario.btnNuevoContrato.setVisible(true);
			formulario.btnActualizarContrato.setVisible(false);
			formulario.btnActualizarDatosContrato.setVisible(true);
			formulario.txtFotoContrato.setEditable(false);
			formulario.btnMostrarContrato.setVisible(true);
			formulario.btnAceptar.setVisible(false);
			formulario.txtCodigo.setEnabled(true);
			formulario.txtCodigo.setEditable(false);
			formulario.txtIdentidadContrato.setEditable(true);
			formulario.obtenerUltimoId();
			formulario.pistas();
			formulario.construirTabla();
			final ImageIcon iconoContrato = new ImageIcon(getClass().getResource("/iconos/contrato.png"));
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
		formulario.txtFotoContrato.setText(null);
		formulario.txtIdentidadContrato.setText(null);
	}

	/* Metodos para mostrar datos en tabla Contratos de los empleados */
	public static ArrayList<contrato_cliente> buscarUsuariosConMatriz() {
		conexion conex = new conexion();
		ArrayList<contrato_cliente> miLista = new ArrayList<contrato_cliente>();
		contrato_cliente contrato;
		try {
			Statement estatuto = conex.getConexion().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT * FROM contrato_cliente ");

			while (rs.next()) {
				contrato = new contrato_cliente();
				contrato.setId_contrato_cliente(Integer.parseInt(rs.getString("id_contrato_cliente")));
				contrato.setTipo_contrato_cliente(rs.getString("tipo_contrato_cliente"));
				contrato.setTiempo_contrato_cliente(rs.getString("tiempo_contrato_cliente"));
				contrato.setFoto_contrato_cliente(rs.getString("foto_contrato_cliente"));
				contrato.setIdentidad_rtn_cliente(rs.getString("identidad_rtn_cliente"));
				miLista.add(contrato);
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
		ArrayList<contrato_cliente> miLista = buscarUsuariosConMatriz();
		String matrizInfo[][] = new String[miLista.size()][5];
		for (int i = 0; i < miLista.size(); i++) {
			matrizInfo[i][0] = miLista.get(i).getId_contrato_cliente() + "";
			matrizInfo[i][1] = miLista.get(i).getTipo_contrato_cliente() + "";
			matrizInfo[i][2] = miLista.get(i).getTiempo_contrato_cliente() + "";
			matrizInfo[i][3] = miLista.get(i).getFoto_contrato_cliente() + "";
			matrizInfo[i][4] = miLista.get(i).getIdentidad_rtn_cliente() + "";

		}

		return matrizInfo;
	}

	public void validarIdentidad() {
		conexion conex = new conexion();
		try {
			Statement estatuto = conex.getConexion().createStatement();
			ResultSet rs = estatuto
					.executeQuery("SELECT identidad_rtn_cliente FROM contrato_cliente where identidad_rtn_cliente = '"
							+ formulario.txtIdentidadContrato.getText().toString() + "'");

			if (rs.next()) {
				identidad = (rs.getString("identidad_rtn_cliente"));
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
