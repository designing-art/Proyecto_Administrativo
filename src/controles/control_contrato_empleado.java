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
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

import com.placeholder.PlaceHolder;

import clases.cargo;
import clases.contrato_empleado;
import conexion.conexion;
import consultas.consultas_cargo;
import consultas.consultas_contrato_empleado;
import formularios.registro_cargos;
import formularios.registro_contratos_empleados;

public class control_contrato_empleado implements ActionListener {

	public control_contrato_empleado clase;
	public consultas_contrato_empleado consulta;
	public registro_contratos_empleados formulario;
	
	

	public control_contrato_empleado(control_contrato_empleado clase, consultas_contrato_empleado consulta,
			registro_contratos_empleados formulario) {
		this.clase = clase;
		this.consulta = consulta;
		this.formulario = formulario;
		this.formulario.btnGuardarCargo.addActionListener(this);
		this.formulario.btnNuevoCargo.addActionListener(this);
		this.formulario.btnActualizarCargo.addActionListener(this);
		this.formulario.btnActualizarDatosCargo.addActionListener(this);
		this.formulario.btnBorrarCargo.addActionListener(this);
		this.formulario.btnMostrar.addActionListener(this);
		this.formulario.btnAceptar.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		/* Insertar */
		if (e.getSource() == formulario.btnGuardarCargo) {
			
			if(formulario.txtNombreCargo.getText().isEmpty() 
				|| formulario.txtSueldoCargo.getText().isEmpty() 
				|| formulario.txtHoraExtraCargo.getText().isEmpty()
				|| formulario.txtFuncionesCargo.getText().isEmpty()
				|| formulario.txtNombreCargo.getText().toString().equalsIgnoreCase("Ingrese el nombre del cargo.")
				|| formulario.txtSueldoCargo.getText().toString().equalsIgnoreCase("Digite el sueldo.")
				|| formulario.txtHoraExtraCargo.getText().toString().equalsIgnoreCase("Digite precio hora extra.")
				|| formulario.txtFuncionesCargo.getText().toString().equalsIgnoreCase("Ingrese las Funciones.")) 
			{
				JOptionPane.showMessageDialog(null, "Porfavor llene los campos para guardar el cargo!");
				
			}else {	
			clase.setArea_cargo(formulario.cbxTipoCargo.getSelectedItem().toString());
			clase.setNombre_cargo(formulario.txtNombreCargo.getText());
			clase.setSueldo_cargo(Double.parseDouble(formulario.txtSueldoCargo.getText()));
			clase.setValor_hora_extra_cargo(Double.parseDouble(formulario.txtHoraExtraCargo.getText()));
			clase.setFunciones_cargo(formulario.txtFuncionesCargo.getText());
			
			if (consulta.insertar(clase)) {
				JOptionPane.showMessageDialog(null, "Cargo registrado!");
				limpiar();
				formulario.construirTabla();
				formulario.obtenerUltimoId();
			} else {
				JOptionPane.showMessageDialog(null, "Error! Cargo no Registrado");
				limpiar();
			}
		}
		}
		
		/* Pasar datos de la tabla al formulario para actualizar */
		if (e.getSource() == formulario.btnActualizarDatosCargo) {
			int filaseleccionada;
			try {
				filaseleccionada = formulario.tablaCargos.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					String codigo = formulario.tablaCargos.getValueAt(filaseleccionada, 0).toString();
					String area = formulario.tablaCargos.getValueAt(filaseleccionada, 1).toString();
					String nombre = formulario.tablaCargos.getValueAt(filaseleccionada, 2).toString();
					String sueldo = formulario.tablaCargos.getValueAt(filaseleccionada, 3).toString();
					String horaextra = formulario.tablaCargos.getValueAt(filaseleccionada, 4).toString();
					String funciones = formulario.tablaCargos.getValueAt(filaseleccionada, 5).toString();

					formulario.txtCodigoCargo.setText(codigo);
					formulario.cbxTipoCargo.setSelectedItem(area);
					formulario.txtNombreCargo.setText(nombre);
					formulario.txtSueldoCargo.setText(sueldo);
					formulario.txtHoraExtraCargo.setText(horaextra);
					formulario.txtFuncionesCargo.setText(funciones);
					
					formulario.txtCodigoCargo.setForeground(Color.BLACK);
					formulario.cbxTipoCargo.setForeground(Color.BLACK);
					formulario.txtNombreCargo.setForeground(Color.BLACK);
					formulario.txtSueldoCargo.setForeground(Color.BLACK);
					formulario.txtHoraExtraCargo.setForeground(Color.BLACK);
					formulario.txtFuncionesCargo.setForeground(Color.BLACK);
					
					formulario.btnBorrarCargo.setVisible(true);
					formulario.btnGuardarCargo.setVisible(false);
					formulario.btnNuevoCargo.setVisible(false);
					formulario.btnActualizarCargo.setVisible(true);
					formulario.btnActualizarDatosCargo.setVisible(true);
					formulario.btnMostrar.setVisible(false);
					formulario.btnAceptar.setText("Cancelar");
					formulario.btnAceptar.setVisible(true);
					
					formulario.txtNombreCargo.requestFocusInWindow();
					
				}

			} catch (HeadlessException ex) {
				JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente",
						" .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		/* Pasar datos de la tabla al formulario para ver los datos */
		if (e.getSource() == formulario.btnMostrar) {
			int fila;
			try {
				fila = formulario.tablaCargos.getSelectedRow();
				if (fila == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					String codigo = formulario.tablaCargos.getValueAt(fila, 0).toString();
					String area = formulario.tablaCargos.getValueAt(fila, 1).toString();
					String nombre = formulario.tablaCargos.getValueAt(fila, 2).toString();
					String sueldo = formulario.tablaCargos.getValueAt(fila, 3).toString();
					String horaextra = formulario.tablaCargos.getValueAt(fila, 4).toString();
					String funciones = formulario.tablaCargos.getValueAt(fila, 5).toString();
					
					formulario.txtCodigoCargo.setText(codigo);
					formulario.cbxTipoCargo.setSelectedItem(area);
					formulario.txtNombreCargo.setText(nombre);
					formulario.txtSueldoCargo.setText(sueldo);
					formulario.txtHoraExtraCargo.setText(horaextra);
					formulario.txtFuncionesCargo.setText(funciones);
					
					formulario.txtCodigoCargo.setForeground(Color.BLACK);
					formulario.cbxTipoCargo.setForeground(Color.BLACK);
					formulario.txtNombreCargo.setForeground(Color.BLACK);
					formulario.txtSueldoCargo.setForeground(Color.BLACK);
					formulario.txtHoraExtraCargo.setForeground(Color.BLACK);
					formulario.txtFuncionesCargo.setForeground(Color.BLACK);
					
					formulario.btnBorrarCargo.setVisible(false);
					formulario.btnGuardarCargo.setVisible(false);
					formulario.btnNuevoCargo.setVisible(false);
					formulario.btnActualizarCargo.setVisible(false);
					formulario.btnActualizarDatosCargo.setVisible(false);
					formulario.btnAceptar.setText("Aceptar");
					formulario.btnAceptar.setVisible(true);
					
					formulario.cbxTipoCargo.setEditable(false);
					formulario.txtNombreCargo.setEditable(false);
					formulario.txtSueldoCargo.setEditable(false);
					formulario.txtHoraExtraCargo.setEditable(false);
					formulario.txtFuncionesCargo.setEditable(false);
					formulario.txtFuncionesCargo.setBackground(Color.LIGHT_GRAY);
					formulario.btnActualizarCargo.setVisible(false);
					
	
				}

			} catch (HeadlessException ex) {
				JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente",
						" .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		/* Actualizar */
		if (e.getSource() == formulario.btnActualizarCargo) {
			
			if(formulario.txtNombreCargo.getText().isEmpty() 
					|| formulario.txtSueldoCargo.getText().isEmpty() 
					|| formulario.txtHoraExtraCargo.getText().isEmpty()
					|| formulario.txtFuncionesCargo.getText().isEmpty()
					|| formulario.txtNombreCargo.getText().toString().equalsIgnoreCase("Ingrese el nombre del cargo.")
					|| formulario.txtSueldoCargo.getText().toString().equalsIgnoreCase("Digite el sueldo.")
					|| formulario.txtHoraExtraCargo.getText().toString().equalsIgnoreCase("Digite precio hora extra.")
					|| formulario.txtFuncionesCargo.getText().toString().equalsIgnoreCase("Ingrese las Funciones.")) 
			{
				JOptionPane.showMessageDialog(null, "Porfavor llene los campos para actualizar el cargo!");
			}else {	
				
			
			clase.setId_cargo(Integer.parseInt(formulario.txtCodigoCargo.getText()));
			clase.setArea_cargo(formulario.cbxTipoCargo.getSelectedItem().toString());
			clase.setNombre_cargo(formulario.txtNombreCargo.getText());
			clase.setSueldo_cargo(Double.parseDouble(formulario.txtSueldoCargo.getText()));
			clase.setValor_hora_extra_cargo(Double.parseDouble(formulario.txtHoraExtraCargo.getText()));
			clase.setFunciones_cargo(formulario.txtFuncionesCargo.getText());

			if (consulta.actualizar(clase)) {
				JOptionPane.showMessageDialog(null, "Cargo Actualizado!");
				limpiar();
				formulario.construirTabla();
				formulario.obtenerUltimoId();
				formulario.btnActualizarCargo.setVisible(false);
				formulario.txtNombreCargo.setEditable(false);
				formulario.txtSueldoCargo.setEditable(false);
				formulario.txtHoraExtraCargo.setEditable(false);
				formulario.txtFuncionesCargo.setEditable(false);
				formulario.cbxTipoCargo.setEditable(false);
				formulario.txtCodigoCargo.setText(null);
				formulario.txtFuncionesCargo.setBackground(Color.LIGHT_GRAY);
			} else {
				JOptionPane.showMessageDialog(null, "Error! Cargo no Actualizado");
				limpiar();
			}
			               
			}
		}

		/* Borrar */
		if (e.getSource() == formulario.btnBorrarCargo) {
			PreparedStatement ps = null;
			int filaseleccionada;
			try {
					filaseleccionada = formulario.tablaCargos.getSelectedRow();
					if (filaseleccionada == -1) {
						JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
					} else {
				conexion objCon = new conexion();
				Connection conn = objCon.getConexion();
				int Fila = formulario.tablaCargos.getSelectedRow();
				String codigo = formulario.tablaCargos.getValueAt(Fila, 0).toString();
				ps = conn.prepareStatement("DELETE FROM cargos WHERE id_cargo=?");
				ps.setString(1, codigo);
				ps.execute();
				JOptionPane.showMessageDialog(null, "Cargo Eliminado");
				limpiar();
				formulario.construirTabla();
				
				formulario.cbxTipoCargo.setEditable(false);
				formulario.txtNombreCargo.setEditable(false);
				formulario.txtSueldoCargo.setEditable(false);
				formulario.txtHoraExtraCargo.setEditable(false);
				formulario.txtFuncionesCargo.setEditable(false);
				formulario.btnActualizarCargo.setVisible(false);
				
					}
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "Error al Eliminar Cargo");
				System.out.println(ex.toString());
			}
		}
		

		/* Nuevo */
		if (e.getSource() == formulario.btnNuevoCargo) {
			limpiar();
			formulario.obtenerUltimoId();
			formulario.btnBorrarCargo.setVisible(false);
			formulario.btnGuardarCargo.setVisible(true);
			formulario.btnMostrar.setVisible(true);
			formulario.btnNuevoCargo.setVisible(true);
			formulario.btnActualizarCargo.setVisible(false);
			formulario.btnActualizarDatosCargo.setVisible(true);		
			formulario.txtNombreCargo.setEditable(true);
			formulario.txtSueldoCargo.setEditable(true);
			formulario.txtHoraExtraCargo.setEditable(true);
			formulario.txtFuncionesCargo.setEditable(true);
			formulario.btnActualizarCargo.setVisible(false);
			formulario.pistas();
			formulario.construirTabla();
			formulario.txtFuncionesCargo.setBackground(Color.WHITE);
		}
		
		/* Aceptar */
		if (e.getSource() == formulario.btnAceptar) {
			limpiar();
			formulario.obtenerUltimoId();
			formulario.btnBorrarCargo.setVisible(false);
			formulario.btnGuardarCargo.setVisible(true);
			formulario.btnNuevoCargo.setVisible(true);
			formulario.btnActualizarCargo.setVisible(false);
			formulario.btnActualizarDatosCargo.setVisible(true);		
			formulario.txtNombreCargo.setEditable(true);
			formulario.txtSueldoCargo.setEditable(true);
			formulario.txtHoraExtraCargo.setEditable(true);
			formulario.txtFuncionesCargo.setEditable(true);
			formulario.btnActualizarCargo.setVisible(false);
			formulario.btnMostrar.setVisible(true);
			formulario.btnAceptar.setVisible(false);
			formulario.txtFuncionesCargo.setBackground(Color.WHITE);
			formulario.pistas();
			formulario.construirTabla();
		}

	}

	/* Metodos para implementar */

	/* Metodo para el boton nuevo que limpia los datos de los txtFields */
	public void limpiar() {
		formulario.cbxTipoCargo.getSelectedItem().equals(null);
		formulario.txtCodigoCargo.setText(null);
		formulario.txtNombreCargo.setText(null);
		formulario.txtSueldoCargo.setText(null);
		formulario.txtHoraExtraCargo.setText(null);
		formulario.txtFuncionesCargo.setText(null);
		formulario.txtBusquedaCargos.setText(null);
	}

	/* Metodos para mostrar datos en tabla Contratos de los empleados */
	public static ArrayList<contrato_empleado> buscarUsuariosConMatriz() {
		conexion conex = new conexion();
		ArrayList<contrato_empleado> miLista = new ArrayList<contrato_empleado>();
		contrato_empleado contrato;
		try {
			Statement estatuto = conex.getConexion().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT * FROM contrato_empleado ");

			while (rs.next()) {
				contrato = new contrato_empleado();
				contrato.setId_contrato_empleado(Integer.parseInt(rs.getString("id_contrato_empleado")));
				contrato.setTipo_contrato_empleado(rs.getString("tipo_contrato_empleado"));
				contrato.setTiempo_contrato_empleado(rs.getString("tiempo_contrato_empleado"));
				contrato.setDireccion_foto_contrato_empleado(rs.getString("direccion_foto_contrato_empleado"));
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
		ArrayList<contrato_empleado> miLista = buscarUsuariosConMatriz();
		String matrizInfo[][] = new String[miLista.size()][6];
		for (int i = 0; i < miLista.size(); i++) {
			matrizInfo[i][0] = miLista.get(i).getId_contrato_empleado() + "";
			matrizInfo[i][1] = miLista.get(i).getTipo_contrato_empleado() + "";
			matrizInfo[i][2] = miLista.get(i).getTiempo_contrato_empleado() + "";
			matrizInfo[i][3] = miLista.get(i).getDireccion_foto_contrato_empleado() + "";
		}

		return matrizInfo;
	}

}
