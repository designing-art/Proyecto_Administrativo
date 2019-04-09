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

	public contrato_empleado clase;
	public consultas_contrato_empleado consulta;
	public registro_contratos_empleados formulario;
	
	

	public control_contrato_empleado(contrato_empleado clase, consultas_contrato_empleado consulta,
			registro_contratos_empleados formulario) {
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
	}

	public void actionPerformed(ActionEvent e) {
		/* Insertar */
		if (e.getSource() == formulario.btnGuardarContrato) {
			
			if(formulario.txtDireccionFotoContrato.getText().isEmpty()) 
			{
				JOptionPane.showMessageDialog(null, "Porfavor llene los campos para guardar el contrato!");
				
			}else {	
				
			clase.setTipo_contrato_empleado(formulario.cbxTipoContratoEmpleado.getSelectedItem().toString());
			clase.setTiempo_contrato_empleado(formulario.cbxTiempoContratoEmpleado.getSelectedItem().toString());
			clase.setDireccion_foto_contrato_empleado(formulario.txtDireccionFotoContrato.getText().toString());
			
			if (consulta.insertar(clase)) {
				JOptionPane.showMessageDialog(null, "Contrato registrado!");
				limpiar();
				formulario.construirTabla();
				formulario.obtenerUltimoId();
			} else {
				JOptionPane.showMessageDialog(null, "Error! contrato no registrado");
				limpiar();
			}
		}
		}
		
		/* Pasar datos de la tabla al formulario para actualizar */
		if (e.getSource() == formulario.btnActualizarDatosContrato) {
			int filaseleccionada;
			try {
				filaseleccionada = formulario.tablaContratosEmpleados.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					String codigo = formulario.tablaContratosEmpleados.getValueAt(filaseleccionada, 0).toString();
					String tipo = formulario.tablaContratosEmpleados.getValueAt(filaseleccionada, 1).toString();
					String tiempo = formulario.tablaContratosEmpleados.getValueAt(filaseleccionada, 2).toString();
					String foto = formulario.tablaContratosEmpleados.getValueAt(filaseleccionada, 3).toString();

					formulario.txtCodigoContratoEmpleado.setText(codigo);
					formulario.cbxTipoContratoEmpleado.setSelectedItem(tipo);
					formulario.cbxTiempoContratoEmpleado.setSelectedItem(tiempo);
					formulario.txtDireccionFotoContrato.setText(foto);
					
					formulario.txtCodigoContratoEmpleado.setForeground(Color.BLACK);
					formulario.cbxTipoContratoEmpleado.setForeground(Color.BLACK);
					formulario.cbxTiempoContratoEmpleado.setForeground(Color.BLACK);
					formulario.txtDireccionFotoContrato.setForeground(Color.BLACK);
						
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
				fila = formulario.tablaContratosEmpleados.getSelectedRow();
				if (fila == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					String codigo = formulario.tablaContratosEmpleados.getValueAt(fila, 0).toString();
					String tipo = formulario.tablaContratosEmpleados.getValueAt(fila, 1).toString();
					String tiempo = formulario.tablaContratosEmpleados.getValueAt(fila, 2).toString();
					String foto = formulario.tablaContratosEmpleados.getValueAt(fila, 3).toString();

					formulario.txtCodigoContratoEmpleado.setText(codigo);
					formulario.cbxTipoContratoEmpleado.setSelectedItem(tipo);
					formulario.cbxTiempoContratoEmpleado.setSelectedItem(tiempo);
					formulario.txtDireccionFotoContrato.setText(foto);
					
					formulario.txtCodigoContratoEmpleado.setForeground(Color.BLACK);
					formulario.cbxTipoContratoEmpleado.setForeground(Color.BLACK);
					formulario.cbxTiempoContratoEmpleado.setForeground(Color.BLACK);
					formulario.txtDireccionFotoContrato.setForeground(Color.BLACK);
					
					formulario.btnBorrarContrato.setVisible(false);
					formulario.btnGuardarContrato.setVisible(false);
					formulario.btnNuevoContrato.setVisible(false);
					formulario.btnActualizarContrato.setVisible(false);
					formulario.btnActualizarDatosContrato.setVisible(false);
					formulario.btnAceptar.setText("Aceptar");
					formulario.btnAceptar.setVisible(true);
					
					formulario.cbxTipoContratoEmpleado.setEnabled(false);
					formulario.cbxTiempoContratoEmpleado.setEnabled(false);
					
				}

			} catch (HeadlessException ex) {
				JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente",
						" .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		/* Actualizar */
		if (e.getSource() == formulario.btnActualizarContrato) {
			
			if(formulario.txtDireccionFotoContrato.getText().isEmpty()) 
			{
				JOptionPane.showMessageDialog(null, "Porfavor llene los campos para actualizar el contrato!");
				
			}else {	
				
			clase.setId_contrato_empleado(Integer.parseInt(formulario.txtCodigoContratoEmpleado.getText().toString()));
			clase.setTipo_contrato_empleado(formulario.cbxTipoContratoEmpleado.getSelectedItem().toString());
			clase.setTiempo_contrato_empleado(formulario.cbxTiempoContratoEmpleado.getSelectedItem().toString());
			clase.setDireccion_foto_contrato_empleado(formulario.txtDireccionFotoContrato.getText().toString());
			clase.setId_contrato_empleado(Integer.parseInt(formulario.txtCodigoContratoEmpleado.getText().toString()));
			
			if (consulta.actualizar(clase)) {
				JOptionPane.showMessageDialog(null, "Contrato Actualizado!");
				limpiar();
				formulario.construirTabla();
				formulario.obtenerUltimoId();
				formulario.btnActualizarContrato.setVisible(false);
				formulario.txtCodigoContratoEmpleado.setEnabled(false);
				formulario.cbxTiempoContratoEmpleado.setEnabled(false);
				formulario.cbxTipoContratoEmpleado.setEnabled(false);
				
			} else {
				JOptionPane.showMessageDialog(null, "Error! contrato no Actualizado");
				limpiar();
			}
			               
			}
		}

		/* Borrar */
		if (e.getSource() == formulario.btnBorrarContrato) {
			PreparedStatement ps = null;
			int filaseleccionada;
			try {
					filaseleccionada = formulario.tablaContratosEmpleados.getSelectedRow();
					if (filaseleccionada == -1) {
						JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
					} else {
				conexion objCon = new conexion();
				Connection conn = objCon.getConexion();
				int Fila = formulario.tablaContratosEmpleados.getSelectedRow();
				String codigo = formulario.tablaContratosEmpleados.getValueAt(Fila, 0).toString();
				ps = conn.prepareStatement("DELETE FROM contrato_empleado WHERE id_contrato_empleado=?");
				ps.setString(1, codigo);
				ps.execute();
				JOptionPane.showMessageDialog(null, "Contrato Eliminado!");
				limpiar();
				formulario.construirTabla();
				formulario.txtCodigoContratoEmpleado.setText(null);
				formulario.cbxTipoContratoEmpleado.setEnabled(false);
				formulario.cbxTiempoContratoEmpleado.setEnabled(false);
				formulario.btnSubirFotoContrato.setEnabled(false);
				formulario.lbl_foto_contrato.setEnabled(false);
				formulario.btnAceptar.setEnabled(true);
				formulario.btnVerFotoContrato.setVisible(false);
				formulario.btnImprimirContrato.setVisible(false);
				
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
			limpiar();
			formulario.obtenerUltimoId();
			formulario.btnBorrarContrato.setVisible(false);
			formulario.btnGuardarContrato.setVisible(true);
			formulario.btnNuevoContrato.setVisible(true);
			formulario.btnActualizarContrato.setVisible(false);
			formulario.btnActualizarDatosContrato.setVisible(true);		
			formulario.cbxTiempoContratoEmpleado.setEditable(true);
			formulario.cbxTipoContratoEmpleado.setEditable(true);
			formulario.txtDireccionFotoContrato.setEditable(false);
			formulario.btnVerFotoContrato.setVisible(false);
			formulario.btnImprimirContrato.setVisible(false);
			formulario.btnMostrarContrato.setVisible(true);
			formulario.btnAceptar.setVisible(false);
			formulario.pistas();
			formulario.construirTabla();
		}
		
		/* Aceptar */
		if (e.getSource() == formulario.btnAceptar) {
			limpiar();
			formulario.obtenerUltimoId();
			formulario.btnBorrarContrato.setVisible(false);
			formulario.btnGuardarContrato.setVisible(true);
			formulario.btnNuevoContrato.setVisible(true);
			formulario.btnActualizarContrato.setVisible(false);
			formulario.btnActualizarDatosContrato.setVisible(true);		
			formulario.cbxTiempoContratoEmpleado.setEditable(true);
			formulario.cbxTipoContratoEmpleado.setEditable(true);
			formulario.txtDireccionFotoContrato.setEditable(false);
			formulario.btnVerFotoContrato.setVisible(false);
			formulario.btnImprimirContrato.setVisible(false);
			formulario.btnMostrarContrato.setVisible(true);
			formulario.btnAceptar.setVisible(false);
			formulario.pistas();
			formulario.construirTabla();
		}

	}

	/* Metodos para implementar */

	/* Metodo para el boton nuevo que limpia los datos de los txtFields */
	public void limpiar() {
		formulario.cbxTiempoContratoEmpleado.getSelectedItem().equals(null);
		formulario.cbxTipoContratoEmpleado.getSelectedItem().equals(null);
		formulario.txtBusquedaContratosEmpleados.setText(null);
		formulario.txtDireccionFotoContrato.setText(null);
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
		String matrizInfo[][] = new String[miLista.size()][4];
		for (int i = 0; i < miLista.size(); i++) {
			matrizInfo[i][0] = miLista.get(i).getId_contrato_empleado() + "";
			matrizInfo[i][1] = miLista.get(i).getTipo_contrato_empleado() + "";
			matrizInfo[i][2] = miLista.get(i).getTiempo_contrato_empleado() + "";
			matrizInfo[i][3] = miLista.get(i).getDireccion_foto_contrato_empleado() + "";
		}

		return matrizInfo;
	}

}
