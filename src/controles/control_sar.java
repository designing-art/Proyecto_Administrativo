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
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import clases.sar;
import conexion.conexion;
import consultas.consultas_sar;
import formularios.registro_sar;

public class control_sar implements ActionListener {

	public sar clase;
	public consultas_sar consulta;
	public registro_sar formulario;
	public static String identidad = null;
	public static int RANGO2;
	public static int valor = 0;

	public control_sar(sar clase, consultas_sar consulta, registro_sar formulario) {
		this.clase = clase;
		this.consulta = consulta;
		this.formulario = formulario;
		this.formulario.btnGuardar.addActionListener(this);
		this.formulario.btnNuevo.addActionListener(this);
		this.formulario.btnActualizar.addActionListener(this);
		this.formulario.btnActualizarDatos.addActionListener(this);
		this.formulario.btnBorrar.addActionListener(this);
		this.formulario.btnMostrar.addActionListener(this);
		this.formulario.btnAceptar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == formulario.btnGuardar) {
			if (formulario.txtFormatoSar.getText().isEmpty()
					|| formulario.txtCaiSar.getText().isEmpty()
					|| formulario.txtRangoFinal.getText().isEmpty() 
					|| formulario.txtRangoFinal.getText().isEmpty()
					|| formulario.txtD.getText().isEmpty()
					|| formulario.editor.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Porfavor llene los campos para guardar el SAR!");
			} else {

				int b = Integer.valueOf(formulario.txtRangoFinal.getText().toString());
				int a = Integer.valueOf(formulario.txtRangoInicial.getText().toString());
				if (a >= b) {
					JOptionPane.showMessageDialog(null, "El rango ingresado es incorrecto!");
				} else {
					validarRango();

					if (RANGO2 >= b) {
						JOptionPane.showMessageDialog(null, "No es posible guardar este rango ya existe!");
					} else {
						validarFechaLimite();
						if (valor <= 0) {
							JOptionPane.showMessageDialog(null, "La fecha ingresada es incorrecta!");
						} else {
							clase.setCai_sar(formulario.txtCaiSar.getText().toString());
							clase.setFormato_sar(formulario.txtFormatoSar.getText().toString());
							clase.setRango_inicial_sar(
									Integer.parseInt(formulario.txtRangoInicial.getText().toString()));
							clase.setRango_final_sar(Integer.parseInt(formulario.txtRangoFinal.getText().toString()));
							clase.setFactura_actual_sar(
									Integer.parseInt(formulario.txtRangoInicial.getText().toString()));
							clase.setFecha_limite_sar(formulario.editor.getText().toString());
							if (consulta.insertar(clase)) {
								JOptionPane.showMessageDialog(null, "SAR registrado!");
								limpiar();
								formulario.construirTabla();
								formulario.obtenerUltimoId();
								formulario.ObtenerUltimosDatosSar();
								formulario.calcularDatosFacturas();
							} else {
								JOptionPane.showMessageDialog(null, "Error! SAR no registrado");
								limpiar();
							}
						}
					}
				}
			}
		}

		if (e.getSource() == formulario.btnActualizar) {
			if (formulario.txtFormatoSar.getText().isEmpty() || formulario.txtCaiSar.getText().isEmpty()
					|| formulario.txtRangoFinal.getText().isEmpty() || formulario.txtRangoFinal.getText().isEmpty()
					|| formulario.txtD.getText().isEmpty()
					|| formulario.editor.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Porfavor llene los campos para actualizar el SAR!");
			} else {
				clase.setId_sar(Integer.parseInt(formulario.txtCodigoSar.getText().toString()));
				clase.setCai_sar(formulario.txtCaiSar.getText().toString());
				clase.setFormato_sar(formulario.txtFormatoSar.getText().toString());
				clase.setRango_inicial_sar(Integer.parseInt(formulario.txtRangoInicial.getText().toString()));
				clase.setRango_final_sar(Integer.parseInt(formulario.txtRangoFinal.getText().toString()));
				clase.setFactura_actual_sar(Integer.parseInt(formulario.txtD.getText().toString()));
				clase.setFecha_limite_sar(formulario.editor.getText().toString());
				if (consulta.actualizar(clase)) {
					JOptionPane.showMessageDialog(null, "SAR actualizado!");
					limpiar();
					formulario.construirTabla();
					formulario.obtenerUltimoId();
					formulario.ObtenerUltimosDatosSar();
					formulario.calcularDatosFacturas();
				} else {
					JOptionPane.showMessageDialog(null, "Error! SAR no actualizado");
					limpiar();
				}
			}
		}

		if (e.getSource() == formulario.btnActualizarDatos) {
			int filaseleccionada;
			try {
				filaseleccionada = formulario.tablaSAR.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					String codigo = formulario.tablaSAR.getValueAt(filaseleccionada, 0).toString();
					String cai = formulario.tablaSAR.getValueAt(filaseleccionada, 1).toString();
					String formato = formulario.tablaSAR.getValueAt(filaseleccionada, 2).toString();
					String ri = formulario.tablaSAR.getValueAt(filaseleccionada, 3).toString();
					String rf = formulario.tablaSAR.getValueAt(filaseleccionada, 4).toString();
					String limite = formulario.tablaSAR.getValueAt(filaseleccionada, 6).toString();

					formulario.txtCodigoSar.setText(codigo);
					formulario.txtCaiSar.setText(cai);
					formulario.txtFormatoSar.setText(formato);
					formulario.txtRangoInicial.setText(ri);
					formulario.txtRangoFinal.setText(rf);
					formulario.editor.setText(limite);

					formulario.txtCodigoSar.setForeground(Color.BLACK);
					formulario.txtCaiSar.setForeground(Color.BLACK);
					formulario.txtFormatoSar.setForeground(Color.BLACK);
					formulario.txtRangoInicial.setForeground(Color.BLACK);
					formulario.txtRangoFinal.setForeground(Color.BLACK);
					formulario.editor.setForeground(Color.BLACK);

					formulario.btnBorrar.setVisible(true);
					formulario.btnGuardar.setVisible(false);
					formulario.btnNuevo.setVisible(false);
					formulario.btnActualizar.setVisible(true);
					formulario.btnActualizarDatos.setVisible(true);
					formulario.btnMostrar.setVisible(false);
					formulario.btnAceptar.setText("Cancelar");
					formulario.btnAceptar.setVisible(true);

					formulario.txtCaiSar.requestFocusInWindow();

				}

			} catch (HeadlessException ex) {
				JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente",
						" .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);
			}
		}

		/* Pasar datos de la tabla al formulario para ver los datos */
		if (e.getSource() == formulario.btnMostrar) {
			int filaseleccionada;
			try {
				filaseleccionada = formulario.tablaSAR.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					String codigo = formulario.tablaSAR.getValueAt(filaseleccionada, 0).toString();
					String cai = formulario.tablaSAR.getValueAt(filaseleccionada, 1).toString();
					String formato = formulario.tablaSAR.getValueAt(filaseleccionada, 2).toString();
					String ri = formulario.tablaSAR.getValueAt(filaseleccionada, 3).toString();
					String rf = formulario.tablaSAR.getValueAt(filaseleccionada, 4).toString();
					String limite = formulario.tablaSAR.getValueAt(filaseleccionada, 6).toString();

					formulario.txtCodigoSar.setText(codigo);
					formulario.txtCaiSar.setText(cai);
					formulario.txtFormatoSar.setText(formato);
					formulario.txtRangoInicial.setText(ri);
					formulario.txtRangoFinal.setText(rf);
					formulario.editor.setText(limite);

					formulario.txtCodigoSar.setForeground(Color.BLACK);
					formulario.txtCaiSar.setForeground(Color.BLACK);
					formulario.txtFormatoSar.setForeground(Color.BLACK);
					formulario.txtRangoInicial.setForeground(Color.BLACK);
					formulario.txtRangoFinal.setForeground(Color.BLACK);
					formulario.editor.setForeground(Color.BLACK);

					formulario.txtCodigoSar.setEditable(false);
					formulario.txtCaiSar.setEditable(false);
					formulario.txtRangoInicial.setEditable(false);
					formulario.txtRangoFinal.setEditable(false);
					formulario.editor.setEditable(false);

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
				filaseleccionada = formulario.tablaSAR.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					conexion objCon = new conexion();
					Connection conn = objCon.getConexion();
					int Fila = formulario.tablaSAR.getSelectedRow();
					String codigo = formulario.tablaSAR.getValueAt(Fila, 0).toString();
					ps = conn.prepareStatement("DELETE FROM sar WHERE id_sar=?");
					ps.setString(1, codigo);
					ps.execute();
					JOptionPane.showMessageDialog(null, "SAR Eliminado!");
					limpiar();
					formulario.ObtenerUltimosDatosSar();
					formulario.calcularDatosFacturas();
					formulario.construirTabla();
					formulario.txtCodigoSar.setText(null);
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
			formulario.btnMostrar.setVisible(true);
			formulario.btnAceptar.setVisible(false);
			formulario.construirTabla();
			formulario.ObtenerUltimosDatosSar();
			formulario.calcularDatosFacturas();
		}

		/* Aceptar */
		if (e.getSource() == formulario.btnAceptar) {
			limpiar();
			formulario.ObtenerUltimosDatosSar();
			formulario.btnBorrar.setVisible(false);
			formulario.btnGuardar.setVisible(true);
			formulario.btnNuevo.setVisible(true);
			formulario.btnActualizar.setVisible(false);
			formulario.btnActualizarDatos.setVisible(true);
			formulario.btnMostrar.setVisible(true);
			formulario.btnAceptar.setVisible(false);
			formulario.txtCodigoSar.setEnabled(true);
			formulario.txtCodigoSar.setEditable(false);
			formulario.obtenerUltimoId();
			formulario.construirTabla();
			formulario.calcularDatosFacturas();
			formulario.txtCodigoSar.setEditable(true);
			formulario.txtCaiSar.setEditable(true);
			formulario.txtRangoInicial.setEditable(true);
			formulario.txtRangoFinal.setEditable(true);

			formulario.txtCaiSar.requestFocusInWindow();
		}

	}

	/* Metodos para implementar */

	/* Metodo para el boton nuevo que limpia los datos de los txtFields */
	public void limpiar() {
		formulario.txtBusquedaCargos.setText(null);
		formulario.txtCodigoSar.setText(null);
		formulario.txtCaiSar.setText(null);
		formulario.txtRangoInicial.setText(null);
		formulario.txtRangoFinal.setText(null);
		formulario.editor.setText(null);
		formulario.txtFormatoSar.setText(null);
	}

	/* Metodos para mostrar datos en tabla Contratos de los empleados */
	public static ArrayList<sar> buscarUsuariosConMatriz() {
		conexion conex = new conexion();
		ArrayList<sar> miLista = new ArrayList<sar>();
		sar sar;
		try {
			Statement estatuto = conex.getConexion().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT * FROM sar");

			while (rs.next()) {
				sar = new sar();
				sar.setId_sar(Integer.parseInt(rs.getString("id_sar")));
				sar.setCai_sar(rs.getString("cai_sar"));
				sar.setFormato_sar(rs.getString("formato_sar"));
				sar.setRango_inicial_sar(Integer.parseInt(rs.getString("rango_inicial_sar")));
				sar.setRango_final_sar(Integer.parseInt(rs.getString("rango_final_sar")));
				sar.setFactura_actual_sar(Integer.parseInt(rs.getString("factura_actual_sar")));
				sar.setFecha_limite_sar(rs.getString("fecha_limite_sar"));
				miLista.add(sar);
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
		ArrayList<sar> miLista = buscarUsuariosConMatriz();
		String matrizInfo[][] = new String[miLista.size()][7];
		for (int i = 0; i < miLista.size(); i++) {
			matrizInfo[i][0] = miLista.get(i).getId_sar() + "";
			matrizInfo[i][1] = miLista.get(i).getCai_sar() + "";
			matrizInfo[i][2] = miLista.get(i).getFormato_sar() + "";
			matrizInfo[i][3] = miLista.get(i).getRango_inicial_sar() + "";
			matrizInfo[i][4] = miLista.get(i).getRango_final_sar() + "";
			matrizInfo[i][5] = miLista.get(i).getFactura_actual_sar() + "";
			matrizInfo[i][6] = miLista.get(i).getFecha_limite_sar() + "";

		}

		return matrizInfo;
	}

	public void validarRango() {
		conexion objCon = new conexion();
		Connection conn = objCon.getConexion();
		try {
			PreparedStatement stmtr = conn
					.prepareStatement("SELECT rango_inicial_sar, rango_final_sar FROM sar order by id_sar desc;");
			ResultSet rsr = stmtr.executeQuery();
			while (rsr.next()) {
				RANGO2 = Integer.valueOf(rsr.getInt("rango_final_sar"));
			}
			;
			stmtr.close();
			rsr.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void validarFechaLimite() {
		LocalDate date = LocalDate.now();
		Date fechaActual = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
		Date fechaSeleccionada = formulario.dateFechaLimite.getDate();

		switch (fechaSeleccionada.compareTo(fechaActual)) {
		case 1:
			valor = 1;
			break;
		case 0:
			valor = 0;
			break;
		case -1:
			valor = -1;
			break;

		}
	}

}
