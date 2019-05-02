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

import clases.horario;
import conexion.conexion;
import consultas.consultas_horario;
import formularios.registro_horarios;

public class control_horario implements ActionListener {

	public horario claseHorario;
	public consultas_horario consultasHorario;
	public registro_horarios formularioHorario;

	public control_horario(horario claseHorario, consultas_horario consultasHorario,
			registro_horarios formularioHorario) {
		super();
		this.claseHorario = claseHorario;
		this.consultasHorario = consultasHorario;
		this.formularioHorario = formularioHorario;
		this.formularioHorario.btnGuardarHorario.addActionListener(this);
		this.formularioHorario.btnActualizarHorario.addActionListener(this);
		this.formularioHorario.btnNuevoHorario.addActionListener(this);
		this.formularioHorario.btnAceptarHorario.addActionListener(this);
		this.formularioHorario.btnActualizarDatosHorario.addActionListener(this);
		this.formularioHorario.btnBorrarHorario.addActionListener(this);
		this.formularioHorario.btnAtras.addActionListener(this);
		this.formularioHorario.btnMostrarHorario.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/* Insertar */
		if (e.getSource() == formularioHorario.btnGuardarHorario) {

			if (formularioHorario.txtDescripcionHorario.getText().isEmpty()
					|| formularioHorario.txtObservacionHorario.getText().isEmpty()
					|| formularioHorario.txtDescripcionHorario.getText().toString()
							.equalsIgnoreCase("Escriba una descripcion.")
					|| formularioHorario.txtObservacionHorario.getText().toString()
							.equalsIgnoreCase("Escriba una observacion."))

			{
				JOptionPane.showMessageDialog(null, "Porfavor llene los campos para guardar el cargo!");

			} else {
				claseHorario.setTipo_horario(formularioHorario.cbxTipoHorario.getSelectedItem().toString());
				claseHorario.setDias_horario(formularioHorario.cbxDiasHorario.getSelectedItem().toString());
				claseHorario.setHoras_horario(formularioHorario.cbxHorasDia.getSelectedItem().toString());
				claseHorario.setDescripcion_horario(formularioHorario.txtDescripcionHorario.getText());
				claseHorario.setObservacion_horario(formularioHorario.txtObservacionHorario.getText());

				if (consultasHorario.insertar(claseHorario)) {
					JOptionPane.showMessageDialog(null, "Horario registrado!");
					limpiar();
					formularioHorario.construirTabla();
					formularioHorario.obtenerUltimoId();
				} else {
					JOptionPane.showMessageDialog(null, "Error! Horario no registrado");
					limpiar();
				}
			}
		}

		/* Pasar datos de la tabla al formulario para actualizar */
		if (e.getSource() == formularioHorario.btnActualizarDatosHorario) {
			int filaseleccionada;
			try {
				filaseleccionada = formularioHorario.tablaHorario.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					String codigo = formularioHorario.tablaHorario.getValueAt(filaseleccionada, 0).toString();
					String tipo = formularioHorario.tablaHorario.getValueAt(filaseleccionada, 1).toString();
					String dias = formularioHorario.tablaHorario.getValueAt(filaseleccionada, 2).toString();
					String horas = formularioHorario.tablaHorario.getValueAt(filaseleccionada, 3).toString();
					String descripcion = formularioHorario.tablaHorario.getValueAt(filaseleccionada, 4).toString();
					String observacion = formularioHorario.tablaHorario.getValueAt(filaseleccionada, 5).toString();

					formularioHorario.txtCodigoHorario.setText(codigo);
					formularioHorario.cbxTipoHorario.setSelectedItem(tipo);
					formularioHorario.cbxHorasDia.setSelectedItem(horas);
					formularioHorario.cbxDiasHorario.setSelectedItem(dias);
					formularioHorario.txtDescripcionHorario.setText(descripcion);
					formularioHorario.txtObservacionHorario.setText(observacion);

					formularioHorario.txtCodigoHorario.setForeground(Color.BLACK);
					formularioHorario.cbxTipoHorario.setForeground(Color.BLACK);
					formularioHorario.cbxDiasHorario.setForeground(Color.BLACK);
					formularioHorario.cbxHorasDia.setForeground(Color.BLACK);
					formularioHorario.txtObservacionHorario.setForeground(Color.BLACK);
					formularioHorario.txtDescripcionHorario.setForeground(Color.BLACK);

					formularioHorario.txtCodigoHorario.setEditable(false);
					formularioHorario.txtDescripcionHorario.setEditable(true);
					formularioHorario.txtObservacionHorario.setEditable(true);
					formularioHorario.btnActualizarHorario.setVisible(false);
					formularioHorario.txtDescripcionHorario.setBackground(Color.WHITE);
					formularioHorario.txtObservacionHorario.setBackground(Color.WHITE);

					formularioHorario.btnBorrarHorario.setVisible(true);
					formularioHorario.btnGuardarHorario.setVisible(false);
					formularioHorario.btnNuevoHorario.setVisible(false);
					formularioHorario.btnActualizarHorario.setVisible(true);
					formularioHorario.btnActualizarDatosHorario.setVisible(true);
					formularioHorario.btnMostrarHorario.setVisible(false);
					formularioHorario.btnAceptarHorario.setText("Cancelar");
					formularioHorario.btnAceptarHorario.setVisible(true);

				}

			} catch (HeadlessException ex) {
				JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente",
						" .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);
			}
		}

		/* Pasar datos de la tabla al formulario para ver los datos */
		if (e.getSource() == formularioHorario.btnMostrarHorario) {
			int fila;
			try {
				fila = formularioHorario.tablaHorario.getSelectedRow();
				if (fila == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					String codigo = formularioHorario.tablaHorario.getValueAt(fila, 0).toString();
					String tipo = formularioHorario.tablaHorario.getValueAt(fila, 1).toString();
					String dias = formularioHorario.tablaHorario.getValueAt(fila, 2).toString();
					String horas = formularioHorario.tablaHorario.getValueAt(fila, 3).toString();
					String descripcion = formularioHorario.tablaHorario.getValueAt(fila, 4).toString();
					String observacion = formularioHorario.tablaHorario.getValueAt(fila, 5).toString();

					formularioHorario.txtCodigoHorario.setText(codigo);
					formularioHorario.cbxTipoHorario.setSelectedItem(tipo);
					formularioHorario.cbxHorasDia.setSelectedItem(horas);
					formularioHorario.cbxDiasHorario.setSelectedItem(dias);
					formularioHorario.txtDescripcionHorario.setText(descripcion);
					formularioHorario.txtObservacionHorario.setText(observacion);

					formularioHorario.txtCodigoHorario.setForeground(Color.BLACK);
					formularioHorario.cbxTipoHorario.setForeground(Color.BLACK);
					formularioHorario.cbxHorasDia.setForeground(Color.BLACK);
					formularioHorario.cbxDiasHorario.setForeground(Color.BLACK);
					formularioHorario.txtDescripcionHorario.setForeground(Color.BLACK);
					formularioHorario.txtObservacionHorario.setForeground(Color.BLACK);

					formularioHorario.btnBorrarHorario.setVisible(false);
					formularioHorario.btnGuardarHorario.setVisible(false);
					formularioHorario.btnNuevoHorario.setVisible(false);
					formularioHorario.btnActualizarHorario.setVisible(false);
					formularioHorario.btnActualizarDatosHorario.setVisible(false);
					formularioHorario.btnMostrarHorario.setVisible(true);
					formularioHorario.btnAceptarHorario.setText("Aceptar");
					formularioHorario.btnAceptarHorario.setVisible(true);

					formularioHorario.cbxTipoHorario.setEditable(false);
					formularioHorario.cbxDiasHorario.setEditable(false);
					formularioHorario.cbxHorasDia.setEditable(false);
					formularioHorario.txtObservacionHorario.setEditable(false);
					formularioHorario.txtDescripcionHorario.setEditable(false);
					formularioHorario.txtDescripcionHorario.setBackground(Color.LIGHT_GRAY);
					formularioHorario.txtObservacionHorario.setBackground(Color.LIGHT_GRAY);
					formularioHorario.btnActualizarHorario.setVisible(false);

				}

			} catch (HeadlessException ex) {
				JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente",
						" .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);
			}
		}

		/* Actualizar */
		if (e.getSource() == formularioHorario.btnActualizarHorario) {

			if (formularioHorario.txtDescripcionHorario.getText().isEmpty()
					|| formularioHorario.txtObservacionHorario.getText().isEmpty()
					|| formularioHorario.txtDescripcionHorario.getText().toString()
							.equalsIgnoreCase("Escriba una descripcion.")
					|| formularioHorario.txtObservacionHorario.getText().toString()
							.equalsIgnoreCase("Escriba una observacion.")) {
				JOptionPane.showMessageDialog(null, "Porfavor llene los campos para actualizar el horario!");
			} else {

				claseHorario.setId_horario(Integer.parseInt(formularioHorario.txtCodigoHorario.getText()));
				claseHorario.setTipo_horario(formularioHorario.cbxTipoHorario.getSelectedItem().toString());
				claseHorario.setDias_horario(formularioHorario.cbxDiasHorario.getSelectedItem().toString());
				claseHorario.setHoras_horario(formularioHorario.cbxHorasDia.getSelectedItem().toString());
				claseHorario.setDescripcion_horario(formularioHorario.txtDescripcionHorario.getText());
				claseHorario.setObservacion_horario(formularioHorario.txtObservacionHorario.getText());

				if (consultasHorario.actualizar(claseHorario)) {
					JOptionPane.showMessageDialog(null, "Horario Actualizado!");
					limpiar();
					formularioHorario.construirTabla();
					formularioHorario.obtenerUltimoId();
					formularioHorario.btnActualizarHorario.setVisible(false);
					formularioHorario.cbxTipoHorario.setEditable(false);
					formularioHorario.cbxDiasHorario.setEditable(false);
					formularioHorario.cbxHorasDia.setEditable(false);
					formularioHorario.txtDescripcionHorario.setEditable(false);
					formularioHorario.txtObservacionHorario.setEditable(false);
					formularioHorario.txtCodigoHorario.setText(null);
					formularioHorario.txtDescripcionHorario.setBackground(Color.LIGHT_GRAY);
					formularioHorario.txtObservacionHorario.setBackground(Color.LIGHT_GRAY);

				} else {
					JOptionPane.showMessageDialog(null, "Error! Horario no Actualizado");
					limpiar();
				}

			}
		}

		/* Borrar */
		if (e.getSource() == formularioHorario.btnBorrarHorario) {
			PreparedStatement ps = null;
			int filaseleccionada;
			try {
				filaseleccionada = formularioHorario.tablaHorario.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					conexion objCon = new conexion();
					Connection conn = objCon.getConexion();
					int Fila = formularioHorario.tablaHorario.getSelectedRow();
					String codigo = formularioHorario.tablaHorario.getValueAt(Fila, 0).toString();
					ps = conn.prepareStatement("DELETE FROM horarios WHERE id_horario=?");
					ps.setString(1, codigo);
					ps.execute();
					JOptionPane.showMessageDialog(null, "Horario Eliminado");
					limpiar();
					formularioHorario.construirTabla();
					formularioHorario.txtCodigoHorario.setEditable(false);
					formularioHorario.txtDescripcionHorario.setEditable(false);
					formularioHorario.txtObservacionHorario.setEditable(false);
					formularioHorario.btnActualizarHorario.setVisible(false);
					formularioHorario.txtDescripcionHorario.setBackground(Color.LIGHT_GRAY);
					formularioHorario.txtObservacionHorario.setBackground(Color.LIGHT_GRAY);
				}
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "Error al Eliminar Horario");
				System.out.println(ex.toString());
			}
		}

		/* Nuevo */
		if (e.getSource() == formularioHorario.btnNuevoHorario) {
			limpiar();
			formularioHorario.obtenerUltimoId();
			formularioHorario.pistas();
			formularioHorario.construirTabla();
			formularioHorario.btnBorrarHorario.setVisible(false);
			formularioHorario.btnGuardarHorario.setVisible(true);
			formularioHorario.btnNuevoHorario.setVisible(true);
			formularioHorario.btnActualizarHorario.setVisible(false);
			formularioHorario.btnActualizarDatosHorario.setVisible(true);
			formularioHorario.txtObservacionHorario.setEditable(true);
			formularioHorario.txtDescripcionHorario.setEditable(true);
			formularioHorario.txtObservacionHorario.setBackground(Color.WHITE);
			formularioHorario.txtDescripcionHorario.setBackground(Color.WHITE);
			formularioHorario.txtCodigoHorario.setEditable(false);
			formularioHorario.btnActualizarHorario.setVisible(false);
			formularioHorario.btnMostrarHorario.setVisible(true);
			formularioHorario.btnAceptarHorario.setVisible(false);
		}

		/* Aceptar */
		if (e.getSource() == formularioHorario.btnAceptarHorario) {
			limpiar();
			formularioHorario.obtenerUltimoId();
			formularioHorario.pistas();
			formularioHorario.construirTabla();
			formularioHorario.btnBorrarHorario.setVisible(false);
			formularioHorario.btnGuardarHorario.setVisible(true);
			formularioHorario.btnNuevoHorario.setVisible(true);
			formularioHorario.btnActualizarHorario.setVisible(false);
			formularioHorario.btnActualizarDatosHorario.setVisible(true);
			formularioHorario.txtObservacionHorario.setEditable(true);
			formularioHorario.txtDescripcionHorario.setEditable(true);
			formularioHorario.txtObservacionHorario.setBackground(Color.WHITE);
			formularioHorario.txtDescripcionHorario.setBackground(Color.WHITE);
			formularioHorario.txtCodigoHorario.setEditable(false);
			formularioHorario.btnActualizarHorario.setVisible(false);
			formularioHorario.btnMostrarHorario.setVisible(true);
			formularioHorario.btnAceptarHorario.setVisible(false);
		}

	}

	/* Metodo para el boton nuevo que limpia los datos de los txtFields */
	public void limpiar() {
		formularioHorario.txtCodigoHorario.setText(null);
		formularioHorario.txtDescripcionHorario.setText(null);
		formularioHorario.txtObservacionHorario.setText(null);

	}

	/* Metodos para mostrar datos en tabla Cargos */
	public static ArrayList<horario> buscarUsuariosConMatriz() {
		conexion conex = new conexion();
		ArrayList<horario> miLista = new ArrayList<horario>();
		horario horario;
		try {
			Statement estatuto = conex.getConexion().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT * FROM horarios ");

			while (rs.next()) {
				horario = new horario();
				horario.setId_horario(Integer.parseInt(rs.getString("id_horario")));
				horario.setTipo_horario(rs.getString("tipo_horario"));
				horario.setDias_horario(rs.getString("dias_horario"));
				horario.setHoras_horario(rs.getString("horas_horario"));
				horario.setDescripcion_horario(rs.getString("descripcion_horario"));
				horario.setObservacion_horario(rs.getString("observacion_horario"));
				miLista.add(horario);
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
		ArrayList<horario> miLista = buscarUsuariosConMatriz();
		String matrizInfo[][] = new String[miLista.size()][6];
		for (int i = 0; i < miLista.size(); i++) {
			matrizInfo[i][0] = miLista.get(i).getId_horario() + "";
			matrizInfo[i][1] = miLista.get(i).getTipo_horario() + "";
			matrizInfo[i][2] = miLista.get(i).getDias_horario() + "";
			matrizInfo[i][3] = miLista.get(i).getHoras_horario() + "";
			matrizInfo[i][4] = miLista.get(i).getDescripcion_horario() + "";
			matrizInfo[i][5] = miLista.get(i).getObservacion_horario() + "";
		}

		return matrizInfo;
	}

}
