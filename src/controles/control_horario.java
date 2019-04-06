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

import clases.cargo;
import clases.horario;
import conexion.conexion;
import consultas.consultas_horario;
import formularios.registro_horarios;

public class control_horario implements ActionListener {

    public horario claseHorario;
    public consultas_horario consultasHorario;
    public registro_horarios formularioHorario;

    public control_horario(horario claseHorario, consultas_horario cosultasCHorario, registro_horarios formularioHorario) {
        this.consultasHorario = consultasHorario;
        this.consultasHorario = consultasHorario;
        this.formularioHorario = formularioHorario;
        this.formularioHorario.btnGuardarHorario.addActionListener(this);
        this.formularioHorario.btnActualizarHorario.addActionListener(this);
        this.formularioHorario.btnSalirHorario.addActionListener(this);
        this.formularioHorario.btnNuevoHorario.addActionListener(this);
        this.formularioHorario.btnAceptarHorario.addActionListener(this);
        this.formularioHorario.btnActualizardDatosHorario.addActionListener(this);
        this.formularioHorario.btnBorrarHorario.addActionListener(this);
        this.formularioHorario.btnRegresarHorario.addActionListener(this);
        this.formularioHorario.btnMostrarHorario.addActionListener(this);
    
    }


    public void actionPerformed(ActionEvent e) {
		/* Insertar */
		if (e.getSource() == formularioHorario.btnGuardarHorario) {
			
			if(formularioHorario.txtidhorario.getText().isEmpty() 
				|| formularioHorario.textBuscarHorario.getText().isEmpty() 
				|| formularioHorario.textCodigoHorario.getText().isEmpty()
				|| formularioHorario.textDescripcioHorario.getText().isEmpty())
				
			{
				JOptionPane.showMessageDialog(null, "Porfavor llene los campos para guardar el cargo!");
				
			}else {	
			claseHorario.setTipo_horario(formularioHorario.cbxtipoHorario.getSelectedItem().toString());
			claseHorario.setDescripcion_horario(formularioHorario.textDescripcioHorario.getText());
			claseHorario.setDias_horario(formularioHorario.textCodigoHorario.getText());
			claseHorario.setObservacion_horario(formularioHorario.textObservacionHorario.getText());
			claseHorario.setDias_horario(formularioHorario.textCodigoHorario.getText());
			
			

			if (consultasHorario.insertar(claseHorario)) {
				JOptionPane.showMessageDialog(null, "Cargo registrado!");
				limpiar();
				formularioHorario.construirTabla();
				formularioHorario.obtenerUltimoId();
			} else {
				JOptionPane.showMessageDialog(null, "Error! Cargo no Registrado");
				limpiar();
			}
		}
		}
		
		/* Pasar datos de la tabla al formulario para actualizar */
		if (e.getSource() == formularioHorario.btnActualizardDatosHorario) {
			int filaseleccionada;
			try {
				filaseleccionada = formularioHorario.tablaHorario.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					String codigoHorario = formularioHorario.tablaHorario.getValueAt(filaseleccionada, 0).toString();
					String descripcion_Horario= formularioHorario.tablaHorario.getValueAt(filaseleccionada, 1).toString();
					String odservacion_Horario= formularioHorario.tablaHorario.getValueAt(filaseleccionada, 2).toString();
					String  horaInicial_Horario= formularioHorario.tablaHorario.getValueAt(filaseleccionada, 3).toString();
					String horafinal_Horario = formularioHorario.tablaHorario.getValueAt(filaseleccionada, 4).toString();
					String dias_Horario = formularioHorario.tablaHorario.getValueAt(filaseleccionada, 5).toString();
					String buscar_Horario= formularioHorario.tablaHorario.getValueAt(filaseleccionada, 6).toString();;
					
					formularioHorario.textCodigoHorario.setText(codigoHorario);
					formularioHorario.textDescripcioHorario.setText(dias_Horario);
					formularioHorario.textObservacionHorario.setText(odservacion_Horario);
					formularioHorario.textBuscarHorario.setText(buscar_Horario);
				
					
					formularioHorario.textCodigoHorario.setForeground(Color.BLACK);
					formularioHorario.cbxtipoHorario.setForeground(Color.BLACK);
					formularioHorario.textBuscarHorario.setForeground(Color.BLACK);
					formularioHorario.textDescripcioHorario.setForeground(Color.BLACK);
					formularioHorario.textObservacionHorario.setForeground(Color.BLACK);
					
					formularioHorario.btnBorrarHorario.setVisible(true);
					formularioHorario.btnGuardarHorario.setVisible(false);
					formularioHorario.btnNuevoHorario.setVisible(false);
					formularioHorario.btnActualizarHorario.setVisible(true);
					formularioHorario.btnActualizardDatosHorario.setVisible(true);
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
					
					String tipo_horario = formularioHorario.tablaHorario.getValueAt(fila, 0).toString();
				    String hora_inicio_horario= formularioHorario.tablaHorario.getValueAt(fila, 1).toString();
				    String hora_final_de_horario= formularioHorario.tablaHorario.getValueAt(fila, 2).toString();
				    String dias_horario= formularioHorario.tablaHorario.getValueAt(fila, 3).toString();
				    String descripcion_horario= formularioHorario.tablaHorario.getValueAt(fila, 4).toString();
				    String observacion_horario = formularioHorario.tablaHorario.getValueAt(fila, 5).toString();
				    String codigo_Horario = formularioHorario.tablaHorario.getValueAt(fila, 5).toString();
					
					formularioHorario.textCodigoHorario.setText(codigo_Horario);
					formularioHorario.cbxtipoHorario.setSelectedItem(tipo_horario);
					formularioHorario.textDescripcioHorario.setText(dias_horario);
					formularioHorario.textObservacionHorario.setText(observacion_horario);
					formularioHorario.textBuscarHorario.setText(hora_inicio_horario);
					
					
				    formularioHorario.textCodigoHorario.setForeground(Color.BLACK);
					formularioHorario.cbxtipoHorario.setForeground(Color.BLACK);
					formularioHorario.textDescripcioHorario.setForeground(Color.BLACK);
					formularioHorario.textObservacionHorario.setForeground(Color.BLACK);
					formularioHorario.textBuscarHorario.setForeground(Color.BLACK);
					
					
					formularioHorario.btnBorrarHorario.setVisible(false);
					formularioHorario.btnGuardarHorario.setVisible(false);
					formularioHorario.btnNuevoHorario.setVisible(false);
					formularioHorario.btnActualizarHorario.setVisible(false);
					formularioHorario.btnActualizardDatosHorario.setVisible(false);
					formularioHorario.btnAceptarHorario.setText("Aceptar");
					formularioHorario.btnAceptarHorario.setVisible(true);
					
					formularioHorario.cbxtipoHorario.setEditable(false);
					formularioHorario.textBuscarHorario.setEditable(false);
					formularioHorario.textCodigoHorario.setEditable(false);
					formularioHorario.textDescripcioHorario.setEditable(false);
					formularioHorario.textObservacionHorario.setEditable(false);
					
					formularioHorario.btnActualizarHorario.setVisible(false);
					
	
				}

			} catch (HeadlessException ex) {
				JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente",
						" .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		/* Actualizar */
		if (e.getSource() == formularioHorario.btnActualizarHorario) {
			
			if(formularioHorario.txtidhorario.getText().isEmpty() 
					|| formularioHorario.textBuscarHorario.getText().isEmpty() 
					|| formularioHorario.textCodigoHorario.getText().isEmpty()
					|| formularioHorario.textDescripcioHorario.getText().isEmpty())
					
			{
				JOptionPane.showMessageDialog(null, "Porfavor llene los campos para actualizar el cargo!");
			}else {	
				
			
			claseHorario.setId(Integer.parseInt(formularioHorario.textCodigoHorario.getText()));
			claseHorario.setTipo_horario(formularioHorario.cbxtipoHorario.getSelectedItem().toString());
			claseHorario.setDias_horario(formularioHorario.textBuscarHorario.getText());
			claseHorario.setHora_final_de_horario(formularioHorario.textDescripcioHorario.getText());
			claseHorario.setHora_inicio_horario(formularioHorario.textObservacionHorario.getText());
			

			if (consultasHorario.actualizar(claseHorario)) {
				JOptionPane.showMessageDialog(null, "Horario Actualizado!");
				limpiar();
				formularioHorario.construirTabla();
				formularioHorario.obtenerUltimoId();
				formularioHorario.btnActualizarHorario.setVisible(false);
				formularioHorario.textBuscarHorario.setEditable(false);
				formularioHorario.textCodigoHorario.setEditable(false);
				formularioHorario.textObservacionHorario.setEditable(false);
				formularioHorario.textDescripcioHorario.setEditable(false);
				
			} else {
				JOptionPane.showMessageDialog(null, "Error! Cargo no Actualizado");
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
				ps = conn.prepareStatement("DELETE FROM cargos WHERE id_cargo=?");
				ps.setString(1, codigo);
				ps.execute();
				JOptionPane.showMessageDialog(null, "Horario Eliminado");
				limpiar();
				formularioHorario.construirTabla();
				
				formularioHorario.cbxtipoHorario.setEditable(false);
				formularioHorario.textBuscarHorario.setEditable(false);
				formularioHorario.textCodigoHorario.setEditable(false);
				formularioHorario.textDescripcioHorario.setEditable(false);
				formularioHorario.textObservacionHorario.setEditable(false);
		       formularioHorario.btnActualizarHorario.setVisible(false);
				
					}
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "Error al Eliminar Horario");
				System.out.println(ex.toString());
			}
		}
		

		/* Limpiar */
		if (e.getSource() == formularioHorario.btnNuevoHorario) {
			limpiar();
			formularioHorario.obtenerUltimoId();
			formularioHorario.btnBorrarHorario.setVisible(false);
			formularioHorario.btnGuardarHorario.setVisible(true);
			formularioHorario.btnMostrarHorario.setVisible(true);
			formularioHorario.btnNuevoHorario.setVisible(true);
			formularioHorario .btnActualizarHorario.setVisible(false);
			formularioHorario.btnActualizardDatosHorario.setVisible(true);		
			formularioHorario.textBuscarHorario.setEditable(true);
			formularioHorario.textCodigoHorario.setEditable(true);
			formularioHorario.textDescripcioHorario.setEditable(true);
			formularioHorario.textObservacionHorario.setEditable(true);
			formularioHorario.btnActualizarHorario.setVisible(false);
			formularioHorario.pistas();
			formularioHorario.construirTabla();
			
		}
		
		/* Aceptar */
		if (e.getSource() == formularioHorario.btnAceptarHorario) {
			limpiar();
			formularioHorario.obtenerUltimoId();
			formularioHorario.btnBorrarHorario.setVisible(false);
			formularioHorario.btnGuardarHorario.setVisible(true);
			formularioHorario.btnNuevoHorario.setVisible(true);
			formularioHorario.btnActualizarHorario.setVisible(false);
			formularioHorario.btnActualizardDatosHorario.setVisible(true);		
			formularioHorario.textBuscarHorario.setEditable(true);
			formularioHorario.textObservacionHorario.setEditable(true);
			formularioHorario.textDescripcioHorario.setEditable(true);
			formularioHorario.textCodigoHorario.setEditable(true);
			formularioHorario.btnActualizarHorario.setVisible(false);
			formularioHorario.btnMostrarHorario.setVisible(true);
			formularioHorario.btnAceptarHorario.setVisible(false);
			
			formularioHorario.pistas();
			formularioHorario.construirTabla();
		}

	}

	/* Metodos para implementar */

	/* Metodo para el boton nuevo que limpia los datos de los txtFields */
	public void limpiar() {
		formularioHorario.cbxtipoHorario.getSelectedItem().equals(null);
		formularioHorario.textCodigoHorario.setText(null);
		formularioHorario.textBuscarHorario.setText(null);
		formularioHorario.textObservacionHorario.setText(null);
		formularioHorario.textDescripcioHorario.setText(null);
		
	}

	/* Metodos para mostrar datos en tabla Cargos */
	public static ArrayList<horario> buscarUsuariosConMatriz() {
		conexion conex = new conexion();
		ArrayList<horario> miLista = new ArrayList<horario>();
		horario horario;
		try {
			Statement estatuto = conex.getConexion().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT * FROM horario ");

			while (rs.next()) {
				horario = new horario();
				horario.setId(Integer.parseInt(rs.getString("id_horario")));
			    horario.setHora_inicio_horario(rs.getString("Hora_inicio_horario"));
			    horario.setHora_final_de_horario(rs.getString("hora_final_de_horario"));
			    horario.setDias_horario(rs.getString("dias_horario"));
				horario.setDescripcion_horario(rs.getString("descripcion_horario2"));
				horario.setObservacion_horario(rs.getString("observacion_horario"));
				horario.setTipo_horario(rs.getString("Tipo_horario"));
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
			matrizInfo[i][0] = miLista.get(i).getTipo_horario() + "";
			matrizInfo[i][1] = miLista.get(i).getId() + "";
			matrizInfo[i][2] = miLista.get(i).getHora_inicio_horario() + "";
			matrizInfo[i][3] = miLista.get(i).getHora_final_de_horario()+ "";
			matrizInfo[i][4] = miLista.get(i).getDias_horario() + "";
			matrizInfo[i][5] = miLista.get(i).getObservacion_horario()+ "";
			matrizInfo[i][6] = miLista.get(i).getDescripcion_horario()+ "";
		}

		return matrizInfo;
	}
	

}

