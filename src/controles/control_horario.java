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
    }


    public void actionPerformed(ActionEvent e) {
		/* Insertar */
		if (e.getSource() == formularioHorario.btnGuardarHorario) {
			
			if(formularioHorario.txtNombreCargo.getText().isEmpty() 
				|| formularioHorario.txtSueldoCargo.getText().isEmpty() 
				|| formularioHorario.txtHoraExtraCargo.getText().isEmpty()
				|| formularioHorario.txtFuncionesCargo.getText().isEmpty()
				|| formularioHorario.txtNombreCargo.getText().toString().equalsIgnoreCase("Ingrese el nombre del cargo.")
				|| formularioHorario.txtSueldoCargo.getText().toString().equalsIgnoreCase("Digite el sueldo.")
				|| formularioHorario.txtHoraExtraCargo.getText().toString().equalsIgnoreCase("Digite precio hora extra.")
				|| formularioHorario.txtFuncionesCargo.getText().toString().equalsIgnoreCase("Ingrese las Funciones.")) 
			{
				JOptionPane.showMessageDialog(null, "Porfavor llene los campos para guardar el cargo!");
				
			}else {	
			claseHorario.setArea_cargo(formularioHorario.cbxTipoCargo.getSelectedItem().toString());
			claseHorario.setNombre_cargo(formularioHorario.txtNombreCargo.getText());
			claseHorario.setSueldo_cargo(Double.parseDouble(formularioHorario.txtSueldoCargo.getText()));
			claseHorario.setValor_hora_extra_cargo(Double.parseDouble(formularioHorario.txtHoraExtraCargo.getText()));
			claseHorario.setFunciones_cargo(formularioHorario.txtFuncionesCargo.getText());
			
			

			if (consultasCargo.insertar(claseHorario)) {
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
		if (e.getSource() == formularioHorario.btnActualizarDatosCargo) {
			int filaseleccionada;
			try {
				filaseleccionada = formularioHorario.tablaCargos.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					String codigo = formularioHorario.tablaCargos.getValueAt(filaseleccionada, 0).toString();
					String area = formularioHorario.tablaCargos.getValueAt(filaseleccionada, 1).toString();
					String nombre = formularioHorario.tablaCargos.getValueAt(filaseleccionada, 2).toString();
					String sueldo = formularioHorario.tablaCargos.getValueAt(filaseleccionada, 3).toString();
					String horaextra = formularioHorario.tablaCargos.getValueAt(filaseleccionada, 4).toString();
					String funciones = formularioHorario.tablaCargos.getValueAt(filaseleccionada, 5).toString();

					formularioHorario.txtCodigoCargo.setText(codigo);
					formularioHorario.cbxTipoCargo.setSelectedItem(area);
					formularioHorario.txtNombreCargo.setText(nombre);
					formularioHorario.txtSueldoCargo.setText(sueldo);
					formularioHorario.txtHoraExtraCargo.setText(horaextra);
					formularioHorario.txtFuncionesCargo.setText(funciones);
					
					formularioHorario.txtCodigoCargo.setForeground(Color.BLACK);
					formularioHorario.cbxTipoCargo.setForeground(Color.BLACK);
					formularioHorario.txtNombreCargo.setForeground(Color.BLACK);
					formularioHorario.txtSueldoCargo.setForeground(Color.BLACK);
					formularioHorario.txtHoraExtraCargo.setForeground(Color.BLACK);
					formularioHorario.txtFuncionesCargo.setForeground(Color.BLACK);
					
					formularioHorario.btnBorrarCargo.setVisible(true);
					formularioHorario.btnGuardarCargo.setVisible(false);
					formularioHorario.btnNuevoCargo.setVisible(false);
					formularioHorario.btnActualizarCargo.setVisible(true);
					formularioHorario.btnActualizarDatosCargo.setVisible(true);
					formularioHorario.btnMostrar.setVisible(false);
					formularioHorario.btnAceptar.setText("Cancelar");
					formularioHorario.btnAceptar.setVisible(true);
					
					formularioHorario.txtNombreCargo.requestFocusInWindow();
					
				}

			} catch (HeadlessException ex) {
				JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente",
						" .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		/* Pasar datos de la tabla al formulario para ver los datos */
		if (e.getSource() == formularioHorario.btnMostrar) {
			int fila;
			try {
				fila = formularioHorario.tablaCargos.getSelectedRow();
				if (fila == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					String codigo = formularioHorario.tablaCargos.getValueAt(fila, 0).toString();
					String area = formularioHorario.tablaCargos.getValueAt(fila, 1).toString();
					String nombre = formularioHorario.tablaCargos.getValueAt(fila, 2).toString();
					String sueldo = formularioHorario.tablaCargos.getValueAt(fila, 3).toString();
					String horaextra = formularioHorario.tablaCargos.getValueAt(fila, 4).toString();
					String funciones = formularioHorario.tablaCargos.getValueAt(fila, 5).toString();
					
					formularioHorario.txtCodigoCargo.setText(codigo);
					formularioHorario.cbxTipoCargo.setSelectedItem(area);
					formularioHorario.txtNombreCargo.setText(nombre);
					formularioHorario.txtSueldoCargo.setText(sueldo);
					formularioHorario.txtHoraExtraCargo.setText(horaextra);
					formularioHorario.txtFuncionesCargo.setText(funciones);
					
					formularioHorario.txtCodigoCargo.setForeground(Color.BLACK);
					formularioHorario.cbxTipoCargo.setForeground(Color.BLACK);
					formularioHorario.txtNombreCargo.setForeground(Color.BLACK);
					formularioHorario.txtSueldoCargo.setForeground(Color.BLACK);
					formularioHorario.txtHoraExtraCargo.setForeground(Color.BLACK);
					formularioHorario.txtFuncionesCargo.setForeground(Color.BLACK);
					
					formularioHorario.btnBorrarCargo.setVisible(false);
					formularioHorario.btnGuardarCargo.setVisible(false);
					formularioHorario.btnNuevoCargo.setVisible(false);
					formularioHorario.btnActualizarCargo.setVisible(false);
					formularioHorario.btnActualizarDatosCargo.setVisible(false);
					formularioHorario.btnAceptar.setText("Aceptar");
					formularioHorario.btnAceptar.setVisible(true);
					
					formularioHorario.cbxTipoCargo.setEditable(false);
					formularioHorario.txtNombreCargo.setEditable(false);
					formularioHorario.txtSueldoCargo.setEditable(false);
					formularioHorario.txtHoraExtraCargo.setEditable(false);
					formularioHorario.txtFuncionesCargo.setEditable(false);
					formularioHorario.txtFuncionesCargo.setBackground(Color.LIGHT_GRAY);
					formularioHorario.btnActualizarCargo.setVisible(false);
					
	
				}

			} catch (HeadlessException ex) {
				JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente",
						" .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		/* Actualizar */
		if (e.getSource() == formularioHorario.btnActualizarHorario) {
			
			if(formularioHorario.txtNombreCargo.getText().isEmpty() 
					|| formularioHorario.txtSueldoCargo.getText().isEmpty() 
					|| formularioHorario.txtHoraExtraCargo.getText().isEmpty()
					|| formularioHorario.txtFuncionesCargo.getText().isEmpty()
					|| formularioHorario.txtNombreCargo.getText().toString().equalsIgnoreCase("Ingrese el nombre del cargo.")
					|| formularioHorario.txtSueldoCargo.getText().toString().equalsIgnoreCase("Digite el sueldo.")
					|| formularioHorario.txtHoraExtraCargo.getText().toString().equalsIgnoreCase("Digite precio hora extra.")
					|| formularioHorario.txtFuncionesCargo.getText().toString().equalsIgnoreCase("Ingrese las Funciones.")) 
			{
				JOptionPane.showMessageDialog(null, "Porfavor llene los campos para actualizar el cargo!");
			}else {	
				
			
			claseHorario.setId_cargo(Integer.parseInt(formularioHorario.txtCodigoCargo.getText()));
			claseHorario.setArea_cargo(formularioHorario.cbxTipoCargo.getSelectedItem().toString());
			claseHorario.setNombre_cargo(formularioHorario.txtNombre.getText());
			claseHorario.setSueldo_cargo(Double.parseDouble(formularioHorario.txtSueldoCargo.getText()));
			claseHorario.setValor_hora_extra_cargo(Double.parseDouble(formularioHorario.txtHoraExtraCargo.getText()));
			claseHorario.setFunciones_cargo(formularioHorario.txtFuncionesCargo.getText());

			if (consultasHorario.actualizar(claseHorario)) {
				JOptionPane.showMessageDialog(null, "Horario Actualizado!");
				limpiar();
				formularioHorario.construirTabla();
				formularioHorario.obtenerUltimoId();
				formularioHorario.btnActualizarHorario.setVisible(false);
				formularioHorario.txtNombreCargo.setEditable(false);
				formularioHorario.txtSueldoCargo.setEditable(false);
				formularioHorario.txtHoraExtraCargo.setEditable(false);
				formularioHorario.txtFuncionesCargo.setEditable(false);
				formularioHorario.txtFuncionesCargo.setBackground(Color.LIGHT_GRAY);
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
				String codigo = formularioHorario.tablahorario.getValueAt(Fila, 0).toString();
				ps = conn.prepareStatement("DELETE FROM cargos WHERE id_cargo=?");
				ps.setString(1, codigo);
				ps.execute();
				JOptionPane.showMessageDialog(null, "Horario Eliminado");
				limpiar();
				formularioHorario.construirTabla();
				
				formularioHorario.cbxTipoCargo.setEditable(false);
				formularioHorario.txtNombreCargo.setEditable(false);
				formularioHorario.txtSueldoCargo.setEditable(false);
				formularioHorario.txtHoraExtraCargo.setEditable(false);
				formularioHorario.txtFuncionesCargo.setEditable(false);
				formularioHorario.btnActualizarCargo.setVisible(false);
				
					}
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "Error al Eliminar Horario");
				System.out.println(ex.toString());
			}
		}
		

		/* Limpiar */
		if (e.getSource() == formularioHorario.btnNuevoCargo) {
			limpiar();
			formularioHorario.obtenerUltimoId();
			formularioHorario.btnBorrarHorario.setVisible(false);
			formularioHorario.btnGuardarHorario.setVisible(true);
			formularioHorario.btnMostrar.setVisible(true);
			formularioHorario.btnNuevoHorario.setVisible(true);
			formularioHorario .btnActualizarHorario.setVisible(false);
			formularioHorario.btnActualizarDatosHorario.setVisible(true);		
			formularioHorario.txtNombreCargo.setEditable(true);
			formularioHorario.txtSueldoCargo.setEditable(true);
			formularioHorario.txtHoraExtraCargo.setEditable(true);
			formularioHorario.txtFuncionesCargo.setEditable(true);
			formularioHorario.btnActualizarHorario.setVisible(false);
			formularioHorario.pistas();
			formularioHorario.construirTabla();
			formularioHorario.txtFuncionesHorario.setBackground(Color.WHITE);
		}
		
		/* Aceptar */
		if (e.getSource() == formularioHorario.btnAceptar) {
			limpiar();
			formularioHorario.obtenerUltimoId();
			formularioHorario.btnBorrarHorario.setVisible(false);
			formularioHorario.btnGuardarHorario.setVisible(true);
			formularioHorario.btnNuevoHorario.setVisible(true);
			formularioHorario.btnActualizarHorario.setVisible(false);
			formularioHorario.btnActualizarDatosHorario.setVisible(true);		
			formularioHorario.txtNombreCargo.setEditable(true);
			formularioHorario.txtSueldoCargo.setEditable(true);
			formularioHorario.txtHoraExtraCargo.setEditable(true);
			formularioHorario.txtFuncionesCargo.setEditable(true);
			formularioHorario.btnActualizarCargo.setVisible(false);
			formularioHorario.btnMostrar.setVisible(true);
			formularioHorario.btnAceptar.setVisible(false);
			formularioHorario.txtFuncionesCargo.setBackground(Color.WHITE);
			formularioHorario.pistas();
			formularioHorario.construirTabla();
		}

	}

	/* Metodos para implementar */

	/* Metodo para el boton nuevo que limpia los datos de los txtFields */
	public void limpiar() {
		formularioHorario.cbxTipoCargo.getSelectedItem().equals(null);
		formularioHorario.txtCodigoCargo.setText(null);
		formularioHorario.txtNombreCargo.setText(null)
		formularioHorario.txtSueldoCargo.setText(null);
		formularioHorario.txtHoraExtraCargo.setText(null);
		formularioHorario.txtFuncionesCargo.setText(null);
		formularioHorario.txtBusquedaCargos.setText(null);
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

