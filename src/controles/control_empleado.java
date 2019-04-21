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
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import clases.empleado;
import conexion.conexion;
import consultas.consultas_empleado;
import formularios.registro_empleados;

public class control_empleado implements ActionListener {

	public empleado claseEmpleado;
	public consultas_empleado consultaEmpleado;
	public registro_empleados formularioEmpleado;
	public String fechaNacimiento;
	public String fechaRegistro;
	public String fechaLabores;

	public control_empleado(empleado claseEmpleado, consultas_empleado consultaEmpleado,
			registro_empleados formularioEmpleado) {
		this.claseEmpleado = claseEmpleado;
		this.consultaEmpleado = consultaEmpleado;
		this.formularioEmpleado = formularioEmpleado;
		this.formularioEmpleado.btnGuardarEmpleado.addActionListener(this);
		this.formularioEmpleado.btnActualizarEmpleado.addActionListener(this);
		this.formularioEmpleado.btnNuevoEmpleado.addActionListener(this);
		this.formularioEmpleado.btnCancelarEmpleado.addActionListener(this);
		this.formularioEmpleado.btnActualizarDatosEmpleado.addActionListener(this);
		this.formularioEmpleado.btnBorrarEmpleado.addActionListener(this);
		this.formularioEmpleado.btnMostrarEmpleado.addActionListener(this);
	}

	@Override
	/* Insertar Empleado */
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == formularioEmpleado.btnGuardarEmpleado) {

			if (formularioEmpleado.txtNombresEmpleado.getText().isEmpty()
					
					//validaciones para datos vacios
					|| formularioEmpleado.txtApellidosEmpleado.getText().isEmpty()
					|| formularioEmpleado.txtIdentidadEmpleado.getText().isEmpty()
					|| formularioEmpleado.txtEdadEmpleado.getText().isEmpty()
					|| formularioEmpleado.txtTelefonoEmpleado.getText().isEmpty()
					|| formularioEmpleado.txtCorreoEmpleado.getText().isEmpty()
					|| formularioEmpleado.txtDireccionEmpleado.getText().isEmpty()
					|| formularioEmpleado.txtDireccionFoto.getText().isEmpty()
					|| formularioEmpleado.txtNombreReferencia.getText().isEmpty()
					|| formularioEmpleado.txtTelefonoReferencia.getText().isEmpty()
					
					//validaciones para datos con mascara y pista.
					|| formularioEmpleado.txtNombresEmpleado.getText().toString()
							.equalsIgnoreCase("Ingrese nombres del empleado.")
					|| formularioEmpleado.txtApellidosEmpleado.getText().toString()
							.equalsIgnoreCase("Ingrese apellidos del empleado.")
					|| formularioEmpleado.txtCorreoEmpleado.getText().toString()
							.equalsIgnoreCase("Ingrese el correo del empleado.")
					|| formularioEmpleado.txtDireccionEmpleado.getText().toString()
							.equalsIgnoreCase("Ingrese la direccion del empleado.")
					|| formularioEmpleado.txtEdadEmpleado.getText().equals("Calcular edad ->")
					|| formularioEmpleado.editor.getText().toString().equalsIgnoreCase("")
					|| formularioEmpleado.editor2.getText().toString().equalsIgnoreCase("")
					|| formularioEmpleado.editor3.getText().toString().equalsIgnoreCase("")
					
					|| formularioEmpleado.txtNombreReferencia.getText().toString()
							.equalsIgnoreCase("Ingrese nombre completo de la referencia."))

			{
				JOptionPane.showMessageDialog(null, "Porfavor llene los campos para guardar los datos del empleado!");

			} else {
				claseEmpleado.setNombres_empleado(formularioEmpleado.txtNombresEmpleado.getText());
				claseEmpleado.setApellidos_empleado(formularioEmpleado.txtApellidosEmpleado.getText());
				claseEmpleado.setIdentidad_empleado(formularioEmpleado.txtIdentidadEmpleado.getText().toString());
				claseEmpleado.setGenero_empleado(formularioEmpleado.cbxGeneroEmpleado.getSelectedItem().toString());
				int a�o1 = formularioEmpleado.dateFechaNacimiento.getCalendar().get(Calendar.YEAR);
				int dia1 = formularioEmpleado.dateFechaNacimiento.getCalendar().get(Calendar.DAY_OF_MONTH);
				int mes1 = formularioEmpleado.dateFechaNacimiento.getCalendar().get(Calendar.MONTH);
				fechaNacimiento = dia1 + "-" + mes1 + "-" + a�o1;
				claseEmpleado.setFecha_nacimiento_empleado(fechaNacimiento);
				int a�o2 = formularioEmpleado.dateFechaRegistro.getCalendar().get(Calendar.YEAR);
				int dia2 = formularioEmpleado.dateFechaRegistro.getCalendar().get(Calendar.DAY_OF_MONTH);
				int mes2 = formularioEmpleado.dateFechaRegistro.getCalendar().get(Calendar.MONTH);
				fechaRegistro = dia2 + "-" + mes2 + "-" + a�o2;
				claseEmpleado.setFecha_registro_empleado(fechaRegistro);
				int a�o3 = formularioEmpleado.dateFechaLabores.getCalendar().get(Calendar.YEAR);
				int dia3 = formularioEmpleado.dateFechaLabores.getCalendar().get(Calendar.DAY_OF_MONTH);
				int mes3 = formularioEmpleado.dateFechaLabores.getCalendar().get(Calendar.MONTH);
				fechaLabores = dia3 + "-" + mes3 + "-" + a�o3;
				claseEmpleado.setFecha_inicio_labores_empleado(fechaLabores);
				claseEmpleado.setDireccion_foto_empleado(formularioEmpleado.txtDireccionFoto.getText().toString());
				claseEmpleado.setEdad_empleado(formularioEmpleado.txtEdadEmpleado.getText().toString());
				claseEmpleado.setTelefono_empleado(formularioEmpleado.txtTelefonoEmpleado.getText().toString());
				claseEmpleado.setCorreo_empleado(formularioEmpleado.txtCorreoEmpleado.getText().toString());
				claseEmpleado.setDireccion_empleado(formularioEmpleado.txtDireccionEmpleado.getText().toString());
				claseEmpleado.setReferencia_empleado(formularioEmpleado.txtNombreReferencia.getText().toString());
				claseEmpleado.setTelefono_referencia(formularioEmpleado.txtTelefonoReferencia.getText().toString());
				claseEmpleado.setEstado_empleado(formularioEmpleado.cbxEstadoEmpleado.getSelectedItem().toString());
				if (consultaEmpleado.registrar(claseEmpleado)) {
					JOptionPane.showMessageDialog(null, "Exito! Datos de nuevo empleado guardados!");
					limpiar();
					formularioEmpleado.txtNombresEmpleado.requestFocusInWindow();
					formularioEmpleado.obtenerUltimoId();
					formularioEmpleado.pistas();
					formularioEmpleado.establecerFechaRegistro();
					formularioEmpleado.construirTablaEmpleados();
					formularioEmpleado.btnGuardarEmpleado.setVisible(true);
					formularioEmpleado.btnNuevoEmpleado.setVisible(true);
					formularioEmpleado.btnMostrarEmpleado.setVisible(true);
					formularioEmpleado.btnActualizarDatosEmpleado.setVisible(true);
					formularioEmpleado.btnActualizarEmpleado.setVisible(false);
					formularioEmpleado.btnCancelarEmpleado.setVisible(false);
					formularioEmpleado.btnBorrarEmpleado.setVisible(false);
					formularioEmpleado.btnCalcularEdad.setBackground(Color.RED);
					formularioEmpleado.txtDireccionFoto.setText("");
					final ImageIcon iconoContrato = new ImageIcon(getClass().getResource("/material/contrato.png"));
					final ImageIcon iconofoto = new ImageIcon(iconoContrato.getImage()
							.getScaledInstance(formularioEmpleado.lblFotoEmpleado.getWidth(), formularioEmpleado.lblFotoEmpleado.getHeight(), Image.SCALE_DEFAULT));
					formularioEmpleado.lblFotoEmpleado.setIcon(iconofoto);
					
				} else {
					JOptionPane.showMessageDialog(null, "Error al Guardar");
					limpiar();
				}
			}
		}

		/* Actualizar Empleado */
		if (e.getSource() == formularioEmpleado.btnActualizarEmpleado) {

			if (formularioEmpleado.txtNombresEmpleado.getText().isEmpty()
					
					//validaciones para datos vacios
					|| formularioEmpleado.txtApellidosEmpleado.getText().isEmpty()
					|| formularioEmpleado.txtIdentidadEmpleado.getText().isEmpty()
					|| formularioEmpleado.txtEdadEmpleado.getText().isEmpty()
					|| formularioEmpleado.txtTelefonoEmpleado.getText().isEmpty()
					|| formularioEmpleado.txtCorreoEmpleado.getText().isEmpty()
					|| formularioEmpleado.txtDireccionEmpleado.getText().isEmpty()
					|| formularioEmpleado.txtDireccionFoto.getText().isEmpty()
					|| formularioEmpleado.txtNombreReferencia.getText().isEmpty()
					|| formularioEmpleado.txtTelefonoReferencia.getText().isEmpty()
					
					//validaciones para datos con mascara y pista.
					|| formularioEmpleado.txtNombresEmpleado.getText().toString()
							.equalsIgnoreCase("Ingrese nombres del empleado.")
					|| formularioEmpleado.txtApellidosEmpleado.getText().toString()
							.equalsIgnoreCase("Ingrese apellidos del empleado.")
					|| formularioEmpleado.txtCorreoEmpleado.getText().toString()
							.equalsIgnoreCase("Ingrese el correo del empleado.")
					|| formularioEmpleado.txtDireccionEmpleado.getText().toString()
							.equalsIgnoreCase("Ingrese la direccion del empleado.")
					|| formularioEmpleado.txtEdadEmpleado.getText().equals("Calcular edad ->")
					|| formularioEmpleado.editor.getText().toString().equalsIgnoreCase("")
					|| formularioEmpleado.editor2.getText().toString().equalsIgnoreCase("")
					|| formularioEmpleado.editor3.getText().toString().equalsIgnoreCase("")
					
					|| formularioEmpleado.txtNombreReferencia.getText().toString()
							.equalsIgnoreCase("Ingrese nombre completo de la referencia."))

			{
				JOptionPane.showMessageDialog(null, "Porfavor llene los campos para actualizar los datos del empleado!");

			} else {
				claseEmpleado.setId_empleado(Integer.parseInt(formularioEmpleado.txtCodigoEmpleado.getText().toString()));
				claseEmpleado.setNombres_empleado(formularioEmpleado.txtNombresEmpleado.getText().toString());
				claseEmpleado.setApellidos_empleado(formularioEmpleado.txtApellidosEmpleado.getText().toString());
				claseEmpleado.setIdentidad_empleado(formularioEmpleado.txtIdentidadEmpleado.getText().toString());
				claseEmpleado.setGenero_empleado(formularioEmpleado.cbxGeneroEmpleado.getSelectedItem().toString());
				int a�o1 = formularioEmpleado.dateFechaNacimiento.getCalendar().get(Calendar.YEAR);
				int dia1 = formularioEmpleado.dateFechaNacimiento.getCalendar().get(Calendar.DAY_OF_MONTH);
				int mes1 = formularioEmpleado.dateFechaNacimiento.getCalendar().get(Calendar.MONTH);
				fechaNacimiento = dia1 + "-" + mes1 + "-" + a�o1;
				claseEmpleado.setFecha_nacimiento_empleado(fechaNacimiento);
				int a�o2 = formularioEmpleado.dateFechaRegistro.getCalendar().get(Calendar.YEAR);
				int dia2 = formularioEmpleado.dateFechaRegistro.getCalendar().get(Calendar.DAY_OF_MONTH);
				int mes2 = formularioEmpleado.dateFechaRegistro.getCalendar().get(Calendar.MONTH);
				fechaRegistro = dia2 + "-" + mes2 + "-" + a�o2;
				claseEmpleado.setFecha_registro_empleado(fechaRegistro);
				int a�o3 = formularioEmpleado.dateFechaLabores.getCalendar().get(Calendar.YEAR);
				int dia3 = formularioEmpleado.dateFechaLabores.getCalendar().get(Calendar.DAY_OF_MONTH);
				int mes3 = formularioEmpleado.dateFechaLabores.getCalendar().get(Calendar.MONTH);
				fechaLabores = dia3 + "-" + mes3 + "-" + a�o3;
				claseEmpleado.setFecha_inicio_labores_empleado(fechaLabores);
				claseEmpleado.setDireccion_foto_empleado(formularioEmpleado.txtDireccionFoto.getText().toString());
				claseEmpleado.setEdad_empleado(formularioEmpleado.txtEdadEmpleado.getText().toString());
				claseEmpleado.setTelefono_empleado(formularioEmpleado.txtTelefonoEmpleado.getText().toString());
				claseEmpleado.setCorreo_empleado(formularioEmpleado.txtCorreoEmpleado.getText().toString());
				claseEmpleado.setDireccion_empleado(formularioEmpleado.txtDireccionEmpleado.getText().toString());
				claseEmpleado.setReferencia_empleado(formularioEmpleado.txtNombreReferencia.getText().toString());
				claseEmpleado.setTelefono_referencia(formularioEmpleado.txtTelefonoReferencia.getText().toString());
				claseEmpleado.setEstado_empleado(formularioEmpleado.cbxEstadoEmpleado.getSelectedItem().toString());
				if (consultaEmpleado.modificar(claseEmpleado)) 
				{
					JOptionPane.showMessageDialog(null, "Exito! Datos del Empleado actualizados.");
					limpiar();
					formularioEmpleado.txtNombresEmpleado.requestFocusInWindow();
					formularioEmpleado.obtenerUltimoId();
					formularioEmpleado.pistas();
					formularioEmpleado.establecerFechaRegistro();
					formularioEmpleado.construirTablaEmpleados();
					formularioEmpleado.btnGuardarEmpleado.setVisible(true);
					formularioEmpleado.btnNuevoEmpleado.setVisible(true);
					formularioEmpleado.btnMostrarEmpleado.setVisible(true);
					formularioEmpleado.btnActualizarDatosEmpleado.setVisible(true);
					formularioEmpleado.btnActualizarEmpleado.setVisible(false);
					formularioEmpleado.btnCancelarEmpleado.setVisible(false);
					formularioEmpleado.btnBorrarEmpleado.setVisible(false);
					final ImageIcon icono = new ImageIcon(getClass().getResource("/material/usuario.png"));
					final ImageIcon iconofoto = new ImageIcon(icono.getImage()
							.getScaledInstance(formularioEmpleado.lblFotoEmpleado.getWidth(), formularioEmpleado.lblFotoEmpleado.getHeight(), Image.SCALE_DEFAULT));
					formularioEmpleado.lblFotoEmpleado.setIcon(iconofoto);
					
				} else {
					JOptionPane.showMessageDialog(null, "Error al Modificar");
					limpiar();
				}

			}
		}

		/* Borrar */
		if (e.getSource() == formularioEmpleado.btnBorrarEmpleado) {
			PreparedStatement ps = null;
			int filaseleccionada;
			try {
				filaseleccionada = formularioEmpleado.tablaEmpleados.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					conexion objCon = new conexion();
					Connection conn = objCon.getConexion();
					int Fila = formularioEmpleado.tablaEmpleados.getSelectedRow();
					String codigo = formularioEmpleado.tablaEmpleados.getValueAt(Fila, 0).toString();
					ps = conn.prepareStatement("DELETE FROM empleados WHERE id_empleado=?");
					ps.setString(1, codigo);
					ps.execute();
					JOptionPane.showMessageDialog(null, "Datos del Empleado Eliminados");
					limpiar();
					formularioEmpleado.construirTablaEmpleados();
					formularioEmpleado.btnActualizarEmpleado.setVisible(false);
					formularioEmpleado.btnCalcularEdad.setEnabled(false);
					formularioEmpleado.txtCodigoEmpleado.setEditable(false);
					formularioEmpleado.txtCodigoEmpleado.setText("");
					formularioEmpleado.txtNombresEmpleado.setEditable(false);
					formularioEmpleado.txtApellidosEmpleado.setEditable(false);
					formularioEmpleado.txtIdentidadEmpleado.setEnabled(false);
					formularioEmpleado.cbxGeneroEmpleado.setEditable(false);
					formularioEmpleado.txtEdadEmpleado.setEditable(false);
					formularioEmpleado.txtTelefonoEmpleado.setEditable(false);
					formularioEmpleado.txtCorreoEmpleado.setEditable(false);
					formularioEmpleado.txtDireccionEmpleado.setEditable(false);
					formularioEmpleado.txtDireccionEmpleado.setBackground(Color.LIGHT_GRAY);
					formularioEmpleado.txtDireccionFoto.setEditable(false);
					formularioEmpleado.txtDireccionFoto.setText("");
					formularioEmpleado.txtNombreReferencia.setEditable(false);
					formularioEmpleado.txtTelefonoReferencia.setEditable(false);
					formularioEmpleado.dateFechaNacimiento.setEnabled(false);
					formularioEmpleado.dateFechaRegistro.setEnabled(false);
					formularioEmpleado.dateFechaLabores.setEnabled(false);
					formularioEmpleado.cbxEstadoEmpleado.setEditable(false);
					formularioEmpleado.btnTomarFoto.setEnabled(false);
					formularioEmpleado.btnSubirFoto.setEnabled(false);
					formularioEmpleado.btnVerFotoEmpleado.setEnabled(false);
					
					final ImageIcon iconoContrato = new ImageIcon(getClass().getResource("/material/usuario.png"));
					final ImageIcon iconofoto = new ImageIcon(iconoContrato.getImage()
							.getScaledInstance(formularioEmpleado.lblFotoEmpleado.getWidth(), formularioEmpleado.lblFotoEmpleado.getHeight(), Image.SCALE_DEFAULT));
					formularioEmpleado.lblFotoEmpleado.setIcon(iconofoto);
					
						
					
				}
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "Error al Eliminar Datos del Empleado");
				System.out.println(ex.toString());
			}
		}
		

		/* Cancelar */
		if (e.getSource() == formularioEmpleado.btnCancelarEmpleado) {
			limpiar();
			formularioEmpleado.txtNombresEmpleado.requestFocusInWindow();
			formularioEmpleado.obtenerUltimoId();
			formularioEmpleado.pistas();
			formularioEmpleado.establecerFechaRegistro();
			formularioEmpleado.construirTablaEmpleados();
			formularioEmpleado.btnGuardarEmpleado.setVisible(true);
			formularioEmpleado.btnNuevoEmpleado.setVisible(true);
			formularioEmpleado.btnMostrarEmpleado.setVisible(true);
			formularioEmpleado.btnActualizarDatosEmpleado.setVisible(true);
			formularioEmpleado.btnActualizarEmpleado.setVisible(false);
			formularioEmpleado.btnCancelarEmpleado.setVisible(false);
			formularioEmpleado.btnBorrarEmpleado.setVisible(false);	
			
			
			formularioEmpleado.txtNombresEmpleado.setEditable(true);
			formularioEmpleado.txtApellidosEmpleado.setEditable(true);
			formularioEmpleado.txtIdentidadEmpleado.setEnabled(true);
			formularioEmpleado.cbxGeneroEmpleado.setEditable(true);
			formularioEmpleado.txtEdadEmpleado.setEditable(true);
			formularioEmpleado.txtTelefonoEmpleado.setEditable(true);
			formularioEmpleado.txtTelefonoEmpleado.setText(null);
			formularioEmpleado.txtCorreoEmpleado.setEditable(true);
			formularioEmpleado.txtDireccionEmpleado.setEditable(true);
			formularioEmpleado.txtDireccionFoto.setEditable(false);
			formularioEmpleado.txtDireccionFoto.setText(null);
			formularioEmpleado.txtNombreReferencia.setEditable(true);
			formularioEmpleado.txtTelefonoReferencia.setEditable(true);
			formularioEmpleado.txtTelefonoReferencia.setText(null);
			formularioEmpleado.dateFechaRegistro.setVisible(false);
			formularioEmpleado.cbxEstadoEmpleado.setEditable(true);
			formularioEmpleado.btnTomarFoto.setEnabled(true);
			formularioEmpleado.btnSubirFoto.setEnabled(true);
			formularioEmpleado.lblFechaDeRegistro.setVisible(false);
			formularioEmpleado.txtDireccionEmpleado.setBackground(Color.WHITE);
			formularioEmpleado.txtIdentidadEmpleado.setEditable(true);
			
			final ImageIcon iconoContrato = new ImageIcon(getClass().getResource("/material/usuario.png"));
			final ImageIcon iconofoto = new ImageIcon(iconoContrato.getImage()
					.getScaledInstance(formularioEmpleado.lblFotoEmpleado.getWidth(), formularioEmpleado.lblFotoEmpleado.getHeight(), Image.SCALE_DEFAULT));
			formularioEmpleado.lblFotoEmpleado.setIcon(iconofoto);
			
			
		}
		
		
		/* Nuevo */
		if (e.getSource() == formularioEmpleado.btnNuevoEmpleado) {
			limpiar();
			formularioEmpleado.txtNombresEmpleado.requestFocusInWindow();
			formularioEmpleado.obtenerUltimoId();
			formularioEmpleado.pistas();
			formularioEmpleado.establecerFechaRegistro();
			formularioEmpleado.construirTablaEmpleados();
			formularioEmpleado.btnGuardarEmpleado.setVisible(true);
			formularioEmpleado.btnNuevoEmpleado.setVisible(true);
			formularioEmpleado.btnMostrarEmpleado.setVisible(true);
			formularioEmpleado.btnActualizarDatosEmpleado.setVisible(true);
			formularioEmpleado.btnActualizarEmpleado.setVisible(false);
			formularioEmpleado.btnCancelarEmpleado.setVisible(false);
			formularioEmpleado.btnBorrarEmpleado.setVisible(false);	
			
			
			formularioEmpleado.txtNombresEmpleado.setEditable(true);
			formularioEmpleado.txtApellidosEmpleado.setEditable(true);
			formularioEmpleado.txtIdentidadEmpleado.setEnabled(true);
			formularioEmpleado.cbxGeneroEmpleado.setEditable(true);
			formularioEmpleado.txtEdadEmpleado.setEditable(true);
			formularioEmpleado.txtTelefonoEmpleado.setEditable(true);
			formularioEmpleado.txtTelefonoEmpleado.setText(null);
			formularioEmpleado.txtCorreoEmpleado.setEditable(true);
			formularioEmpleado.txtDireccionEmpleado.setEditable(true);
			formularioEmpleado.txtDireccionFoto.setEditable(false);
			formularioEmpleado.txtDireccionFoto.setText(null);
			formularioEmpleado.txtNombreReferencia.setEditable(true);
			formularioEmpleado.txtTelefonoReferencia.setEditable(true);
			formularioEmpleado.txtTelefonoReferencia.setText(null);
			formularioEmpleado.dateFechaRegistro.setVisible(false);
			formularioEmpleado.cbxEstadoEmpleado.setEditable(true);
			formularioEmpleado.btnTomarFoto.setEnabled(true);
			formularioEmpleado.btnSubirFoto.setEnabled(true);
			formularioEmpleado.lblFechaDeRegistro.setVisible(false);
			formularioEmpleado.txtDireccionEmpleado.setBackground(Color.WHITE);
			formularioEmpleado.txtIdentidadEmpleado.setEditable(true);
			
			final ImageIcon iconoContrato = new ImageIcon(getClass().getResource("/material/usuario.png"));
			final ImageIcon iconofoto = new ImageIcon(iconoContrato.getImage()
					.getScaledInstance(formularioEmpleado.lblFotoEmpleado.getWidth(), formularioEmpleado.lblFotoEmpleado.getHeight(), Image.SCALE_DEFAULT));
			formularioEmpleado.lblFotoEmpleado.setIcon(iconofoto);
			
			

			
			
		}

		/* Pasar datos de la tabla al formulario para actualizar */
		if (e.getSource() == formularioEmpleado.btnActualizarDatosEmpleado) {
			int filaseleccionada;
			try {
				filaseleccionada = formularioEmpleado.tablaEmpleados.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					String codigo = formularioEmpleado.tablaEmpleados.getValueAt(filaseleccionada, 0).toString();
					String nombres = formularioEmpleado.tablaEmpleados.getValueAt(filaseleccionada, 1).toString();
					String apellidos = formularioEmpleado.tablaEmpleados.getValueAt(filaseleccionada, 2).toString();
					String identidad = formularioEmpleado.tablaEmpleados.getValueAt(filaseleccionada, 3).toString();
					String genero = formularioEmpleado.tablaEmpleados.getValueAt(filaseleccionada, 4).toString();
					String edad = formularioEmpleado.tablaEmpleados.getValueAt(filaseleccionada, 5).toString();
					String telefono = formularioEmpleado.tablaEmpleados.getValueAt(filaseleccionada, 6).toString();
					String correo = formularioEmpleado.tablaEmpleados.getValueAt(filaseleccionada, 7).toString();
					String direccion = formularioEmpleado.tablaEmpleados.getValueAt(filaseleccionada, 8).toString();
					String direccion_foto = formularioEmpleado.tablaEmpleados.getValueAt(filaseleccionada, 9).toString();
					String referencia = formularioEmpleado.tablaEmpleados.getValueAt(filaseleccionada, 10).toString();
					String t_referencia = formularioEmpleado.tablaEmpleados.getValueAt(filaseleccionada, 11).toString();
					String fecha_nac = formularioEmpleado.tablaEmpleados.getValueAt(filaseleccionada, 12).toString();
					String fecha_reg = formularioEmpleado.tablaEmpleados.getValueAt(filaseleccionada, 13).toString();
					String fecha_lab = formularioEmpleado.tablaEmpleados.getValueAt(filaseleccionada, 14).toString();
					String estado = formularioEmpleado.tablaEmpleados.getValueAt(filaseleccionada, 15).toString();

					formularioEmpleado.txtCodigoEmpleado.setText(codigo);
					formularioEmpleado.txtNombresEmpleado.setText(nombres);
					formularioEmpleado.txtApellidosEmpleado.setText(apellidos);
					formularioEmpleado.txtIdentidadEmpleado.setText(identidad);
					formularioEmpleado.cbxGeneroEmpleado.setSelectedItem(genero);
					formularioEmpleado.txtEdadEmpleado.setText(edad);
					formularioEmpleado.txtTelefonoEmpleado.setText(telefono);
					formularioEmpleado.txtCorreoEmpleado.setText(correo);
					formularioEmpleado.txtDireccionEmpleado.setText(direccion);
					formularioEmpleado.txtDireccionFoto.setText(direccion_foto);
					final ImageIcon foto_contrato = new ImageIcon(direccion_foto);
					final ImageIcon logo = new ImageIcon(
							foto_contrato.getImage().getScaledInstance(formularioEmpleado.lblFotoEmpleado.getWidth(),
									formularioEmpleado.lblFotoEmpleado.getHeight(), Image.SCALE_DEFAULT));
					formularioEmpleado.lblFotoEmpleado.setIcon(logo);
					formularioEmpleado.txtNombreReferencia.setText(referencia);
					formularioEmpleado.txtTelefonoReferencia.setText(t_referencia);
					formularioEmpleado.editor3.setText(fecha_nac);
					formularioEmpleado.editor2.setText(fecha_reg);
					formularioEmpleado.editor.setText(fecha_lab);
					formularioEmpleado.cbxEstadoEmpleado.setSelectedItem(estado);
					formularioEmpleado.txtCodigoEmpleado.setForeground(Color.BLACK);
					formularioEmpleado.txtNombresEmpleado.setForeground(Color.BLACK);
					formularioEmpleado.txtApellidosEmpleado.setForeground(Color.BLACK);
					formularioEmpleado.txtIdentidadEmpleado.setForeground(Color.BLACK);
					formularioEmpleado.cbxGeneroEmpleado.setForeground(Color.BLACK);
					formularioEmpleado.txtEdadEmpleado.setForeground(Color.BLACK);
					formularioEmpleado.txtTelefonoEmpleado.setForeground(Color.BLACK);
					formularioEmpleado.txtCorreoEmpleado.setForeground(Color.BLACK);
					formularioEmpleado.txtDireccionEmpleado.setForeground(Color.BLACK);
					formularioEmpleado.txtDireccionFoto.setForeground(Color.BLACK);
					formularioEmpleado.txtNombreReferencia.setForeground(Color.BLACK);
					formularioEmpleado.txtTelefonoReferencia.setForeground(Color.BLACK);
					formularioEmpleado.editor3.setForeground(Color.BLACK);
					formularioEmpleado.editor2.setForeground(Color.BLACK);
					formularioEmpleado.editor.setForeground(Color.BLACK);
					formularioEmpleado.cbxEstadoEmpleado.setForeground(Color.BLACK);

					formularioEmpleado.btnGuardarEmpleado.setVisible(false);
					formularioEmpleado.btnNuevoEmpleado.setVisible(false);
					formularioEmpleado.btnActualizarEmpleado.setVisible(true);
					formularioEmpleado.btnCancelarEmpleado.setVisible(true);
					formularioEmpleado.btnBorrarEmpleado.setVisible(true);
					formularioEmpleado.btnMostrarEmpleado.setVisible(false);
					formularioEmpleado.lblFechaDeRegistro.setVisible(true);
					formularioEmpleado.dateFechaRegistro.setVisible(true);	
				}

			} catch (HeadlessException ex) {
				JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInt�ntelo nuevamente",
						" .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		/* Pasar datos de la tabla al formulario para visualizar */
		if (e.getSource() == formularioEmpleado.btnMostrarEmpleado) {
			int filaseleccionada;
			try {
				filaseleccionada = formularioEmpleado.tablaEmpleados.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					String codigo = formularioEmpleado.tablaEmpleados.getValueAt(filaseleccionada, 0).toString();
					String nombres = formularioEmpleado.tablaEmpleados.getValueAt(filaseleccionada, 1).toString();
					String apellidos = formularioEmpleado.tablaEmpleados.getValueAt(filaseleccionada, 2).toString();
					String identidad = formularioEmpleado.tablaEmpleados.getValueAt(filaseleccionada, 3).toString();
					String genero = formularioEmpleado.tablaEmpleados.getValueAt(filaseleccionada, 4).toString();
					String edad = formularioEmpleado.tablaEmpleados.getValueAt(filaseleccionada, 5).toString();
					String telefono = formularioEmpleado.tablaEmpleados.getValueAt(filaseleccionada, 6).toString();
					String correo = formularioEmpleado.tablaEmpleados.getValueAt(filaseleccionada, 7).toString();
					String direccion = formularioEmpleado.tablaEmpleados.getValueAt(filaseleccionada, 8).toString();
					String direccion_foto = formularioEmpleado.tablaEmpleados.getValueAt(filaseleccionada, 9).toString();
					String referencia = formularioEmpleado.tablaEmpleados.getValueAt(filaseleccionada, 10).toString();
					String t_referencia = formularioEmpleado.tablaEmpleados.getValueAt(filaseleccionada, 11).toString();
					String fecha_nac = formularioEmpleado.tablaEmpleados.getValueAt(filaseleccionada, 12).toString();
					String fecha_reg = formularioEmpleado.tablaEmpleados.getValueAt(filaseleccionada, 13).toString();
					String fecha_lab = formularioEmpleado.tablaEmpleados.getValueAt(filaseleccionada, 14).toString();
					String estado = formularioEmpleado.tablaEmpleados.getValueAt(filaseleccionada, 15).toString();

					formularioEmpleado.txtCodigoEmpleado.setText(codigo);
					formularioEmpleado.txtNombresEmpleado.setText(nombres);
					formularioEmpleado.txtApellidosEmpleado.setText(apellidos);
					formularioEmpleado.txtIdentidadEmpleado.setText(identidad);
					formularioEmpleado.cbxGeneroEmpleado.setSelectedItem(genero);
					formularioEmpleado.txtEdadEmpleado.setText(edad);
					formularioEmpleado.txtTelefonoEmpleado.setText(telefono);
					formularioEmpleado.txtCorreoEmpleado.setText(correo);
					formularioEmpleado.txtDireccionEmpleado.setText(direccion);
					formularioEmpleado.txtDireccionFoto.setText(direccion_foto);
					final ImageIcon foto_contrato = new ImageIcon(direccion_foto);
					final ImageIcon logo = new ImageIcon(
							foto_contrato.getImage().getScaledInstance(formularioEmpleado.lblFotoEmpleado.getWidth(),
									formularioEmpleado.lblFotoEmpleado.getHeight(), Image.SCALE_DEFAULT));
					formularioEmpleado.lblFotoEmpleado.setIcon(logo);
					formularioEmpleado.txtNombreReferencia.setText(referencia);
					formularioEmpleado.txtTelefonoReferencia.setText(t_referencia);
					formularioEmpleado.editor3.setText(fecha_nac);
					formularioEmpleado.editor2.setText(fecha_reg);
					formularioEmpleado.editor.setText(fecha_lab);
					formularioEmpleado.cbxEstadoEmpleado.setSelectedItem(estado);
					formularioEmpleado.txtCodigoEmpleado.setForeground(Color.BLACK);
					formularioEmpleado.txtNombresEmpleado.setForeground(Color.BLACK);
					formularioEmpleado.txtApellidosEmpleado.setForeground(Color.BLACK);
					formularioEmpleado.txtIdentidadEmpleado.setForeground(Color.BLACK);
					formularioEmpleado.cbxGeneroEmpleado.setForeground(Color.BLACK);
					formularioEmpleado.txtEdadEmpleado.setForeground(Color.BLACK);
					formularioEmpleado.txtTelefonoEmpleado.setForeground(Color.BLACK);
					formularioEmpleado.txtCorreoEmpleado.setForeground(Color.BLACK);
					formularioEmpleado.txtDireccionEmpleado.setForeground(Color.BLACK);
					formularioEmpleado.txtDireccionEmpleado.setBackground(Color.LIGHT_GRAY);
					formularioEmpleado.txtDireccionFoto.setForeground(Color.BLACK);
					formularioEmpleado.txtNombreReferencia.setForeground(Color.BLACK);
					formularioEmpleado.txtTelefonoReferencia.setForeground(Color.BLACK);
					formularioEmpleado.editor3.setForeground(Color.BLACK);
					formularioEmpleado.editor2.setForeground(Color.BLACK);
					formularioEmpleado.editor.setForeground(Color.BLACK);
					formularioEmpleado.cbxEstadoEmpleado.setForeground(Color.BLACK);

					formularioEmpleado.btnGuardarEmpleado.setVisible(false);
					formularioEmpleado.btnNuevoEmpleado.setVisible(false);
					formularioEmpleado.btnActualizarEmpleado.setVisible(false);
					formularioEmpleado.btnActualizarDatosEmpleado.setVisible(false);
					formularioEmpleado.btnCancelarEmpleado.setVisible(true);
					formularioEmpleado.btnBorrarEmpleado.setVisible(false);
					formularioEmpleado.btnMostrarEmpleado.setVisible(true);
					formularioEmpleado.lblFechaDeRegistro.setVisible(true);
					formularioEmpleado.dateFechaRegistro.setVisible(true);
					
					formularioEmpleado.txtNombresEmpleado.setEditable(false);
					formularioEmpleado.txtApellidosEmpleado.setEditable(false);
					formularioEmpleado.txtIdentidadEmpleado.setEditable(false);
					formularioEmpleado.cbxGeneroEmpleado.setEditable(false);
					formularioEmpleado.txtEdadEmpleado.setEditable(false);
					formularioEmpleado.txtTelefonoEmpleado.setEditable(false);
					formularioEmpleado.txtCorreoEmpleado.setEditable(false);
					formularioEmpleado.txtDireccionEmpleado.setEditable(false);
					formularioEmpleado.txtDireccionFoto.setEditable(false);
					formularioEmpleado.txtNombreReferencia.setEditable(false);
					formularioEmpleado.txtTelefonoReferencia.setEditable(false);
					formularioEmpleado.editor3.setEditable(false);
					formularioEmpleado.editor2.setEditable(false);
					formularioEmpleado.editor.setEditable(false);
					formularioEmpleado.cbxEstadoEmpleado.setEditable(false);
				}

			} catch (HeadlessException ex) {
				JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInt�ntelo nuevamente",
						" .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);
			}
		}


	}

	public void limpiar() {
		formularioEmpleado.txtNombresEmpleado.setText(null);
		formularioEmpleado.txtApellidosEmpleado.setText(null);
		formularioEmpleado.txtIdentidadEmpleado.setText(null);
		formularioEmpleado.txtEdadEmpleado.setText(null);
		formularioEmpleado.txtTelefonoEmpleado.setText(null);
		formularioEmpleado.txtCorreoEmpleado.setText(null);
		formularioEmpleado.txtDireccionEmpleado.setText(null);
		formularioEmpleado.txtNombreReferencia.setText(null);
		formularioEmpleado.txtTelefonoReferencia.setText(null);
		formularioEmpleado.editor.setText("");
		formularioEmpleado.editor2.setText("");
		formularioEmpleado.editor3.setText("");
		formularioEmpleado.cbxEstadoEmpleado.setToolTipText(null);
	}

	/* Metodos para mostrar datos en tabla empleados */
	public static ArrayList<empleado> buscarUsuariosConMatriz() {
		conexion conex = new conexion();
		ArrayList<empleado> miLista = new ArrayList<empleado>();
		empleado empleado;
		try {
			Statement estatuto = conex.getConexion().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT * FROM empleados ");

			while (rs.next()) {
				empleado = new empleado();
				empleado.setId_empleado(Integer.parseInt(rs.getString("id_empleado")));
				empleado.setNombres_empleado(rs.getString("nombres_empleado"));
				empleado.setApellidos_empleado(rs.getString("apellidos_empleado"));
				empleado.setIdentidad_empleado(rs.getString("identidad_empleado"));
				empleado.setGenero_empleado(rs.getString("genero_empleado"));
				empleado.setEdad_empleado(rs.getString("edad_empleado"));
				empleado.setTelefono_empleado(rs.getString("telefono_empleado"));
				empleado.setCorreo_empleado(rs.getString("correo_empleado"));
				empleado.setDireccion_empleado(rs.getString("direccion_empleado"));
				empleado.setDireccion_foto_empleado(rs.getString("direccion_foto_empleado"));
				empleado.setReferencia_empleado(rs.getString("referencia_empleado"));
				empleado.setTelefono_referencia(rs.getString("telefono_referencia"));
				empleado.setFecha_nacimiento_empleado(rs.getString("fecha_nacimiento_empleado"));
				empleado.setFecha_registro_empleado(rs.getString("fecha_registro_empleado"));
				empleado.setFecha_inicio_labores_empleado(rs.getString("fecha_inicio_labores_empleado"));
				empleado.setEstado_empleado(rs.getString("estado_empleado"));

				miLista.add(empleado);
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
		ArrayList<empleado> miLista = buscarUsuariosConMatriz();
		String matrizInfo[][] = new String[miLista.size()][16];
		for (int i = 0; i < miLista.size(); i++) {
			matrizInfo[i][0] = miLista.get(i).getId_empleado() + "";
			matrizInfo[i][1] = miLista.get(i).getNombres_empleado() + "";
			matrizInfo[i][2] = miLista.get(i).getApellidos_empleado() + "";
			matrizInfo[i][3] = miLista.get(i).getIdentidad_empleado() + "";
			matrizInfo[i][4] = miLista.get(i).getGenero_empleado() + "";
			matrizInfo[i][5] = miLista.get(i).getEdad_empleado() + "";
			matrizInfo[i][6] = miLista.get(i).getTelefono_empleado() + "";
			matrizInfo[i][7] = miLista.get(i).getCorreo_empleado() + "";
			matrizInfo[i][8] = miLista.get(i).getDireccion_empleado() + "";
			matrizInfo[i][9] = miLista.get(i).getDireccion_foto_empleado() + "";
			matrizInfo[i][10] = miLista.get(i).getReferencia_empleado() + "";
			matrizInfo[i][11] = miLista.get(i).getTelefono_referencia() + "";
			matrizInfo[i][12] = miLista.get(i).getFecha_nacimiento_empleado() + "";
			matrizInfo[i][13] = miLista.get(i).getFecha_registro_empleado() + "";
			matrizInfo[i][14] = miLista.get(i).getFecha_inicio_labores_empleado() + "";
			matrizInfo[i][15] = miLista.get(i).getEstado_empleado() + "";
		}

		return matrizInfo;
	}

}
