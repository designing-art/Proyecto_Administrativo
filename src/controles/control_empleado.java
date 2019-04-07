package controles;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

import clases.cargo;
import clases.empleado;
import conexion.conexion;
import consultas.consultas_empleado;
import formularios.lista_empleados;
import formularios.registro_empleados;
import formularios.ventana_principal;

public class control_empleado implements ActionListener {

	public empleado claseEmpleado;
	public consultas_empleado consultaEmpleado;
	public registro_empleados formularioEmpleado;
	public lista_empleados listaEmpleado;
	public String fechaNacimiento;
	public String fechaRegistro;
	public String fechaLabores;

	public control_empleado(empleado claseEmpleado, consultas_empleado consultaEmpleado,
			registro_empleados formularioEmpleado, lista_empleados listaEmpleado) {
		this.claseEmpleado = claseEmpleado;
		this.consultaEmpleado = consultaEmpleado;
		this.formularioEmpleado = formularioEmpleado;
		this.listaEmpleado = listaEmpleado;
		this.formularioEmpleado.btnGuardarEmpleado.addActionListener(this);
		this.formularioEmpleado.btnActualizarEmpleado.addActionListener(this);
		this.formularioEmpleado.btnNuevoEmpleado.addActionListener(this);
		this.formularioEmpleado.btnCancelarEmpleado.addActionListener(this);
		this.formularioEmpleado.btnEmpleados.addActionListener(this);
		this.listaEmpleado.btnNuevoEmpleado.addActionListener(this);
		this.listaEmpleado.btnActualizarDatosEmpleado.addActionListener(this);
		this.listaEmpleado.btnBorrarEmpleado.addActionListener(this);
		this.listaEmpleado.btnMostrarEmpleado.addActionListener(this);
	}

	@Override
	/* Insertar Empleado */
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == formularioEmpleado.btnGuardarEmpleado) {

			if (formularioEmpleado.txtNombresEmpleado.getText().isEmpty()
					|| formularioEmpleado.txtApellidosEmpleado.getText().isEmpty()
					|| formularioEmpleado.txtIdentidadEmpleado.getText().isEmpty()
					|| formularioEmpleado.txtEdadEmpleado.getText().isEmpty()
					|| formularioEmpleado.txtTelefonoEmpleado.getText().isEmpty()
					|| formularioEmpleado.txtCorreoEmpleado.getText().isEmpty()
					|| formularioEmpleado.txtDireccionEmpleado.getText().isEmpty()
					|| formularioEmpleado.txtDireccionFoto.getText().isEmpty()
					|| formularioEmpleado.txtNombreReferencia.getText().isEmpty()
					|| formularioEmpleado.txtTelefonoReferencia.getText().isEmpty()
					|| formularioEmpleado.txtNombresEmpleado.getText().toString()
							.equalsIgnoreCase("Ingrese nombres del empleado.")
					|| formularioEmpleado.txtApellidosEmpleado.getText().toString()
							.equalsIgnoreCase("Ingrese apellidos del empleado.")
					|| formularioEmpleado.txtIdentidadEmpleado.getText().equals("   -   -     ")
					|| formularioEmpleado.txtTelefonoEmpleado.getText().equals("+(504)   -    ")
					|| formularioEmpleado.txtCorreoEmpleado.getText().toString()
							.equalsIgnoreCase("Ingrese el correo del empleado.")
					|| formularioEmpleado.txtDireccionEmpleado.getText().toString()
							.equalsIgnoreCase("Ingrese la direccion del empleado.")
					|| formularioEmpleado.txtDireccionFoto.getText().equals("")
					|| formularioEmpleado.txtEdadEmpleado.getText().equals("")
					|| formularioEmpleado.txtEdadEmpleado.getText().equals("Click -->")
					|| formularioEmpleado.dateFechaNacimiento.getDate().toString().isEmpty()
					|| formularioEmpleado.dateFechaRegistro.getDate().toString().isEmpty()
					|| formularioEmpleado.dateFechaLabores.getDate().toString().isEmpty()
					|| formularioEmpleado.txtNombreReferencia.getText().toString()
							.equalsIgnoreCase("Ingrese nombre completo de la referencia.")
					|| formularioEmpleado.txtTelefonoReferencia.getText().equals("+(504)   -    "))

			{
				JOptionPane.showMessageDialog(null, "Porfavor llene los campos para guardar los datos del empleado!");

			} else {
				claseEmpleado.setNombres_empleado(formularioEmpleado.txtNombresEmpleado.getText());
				claseEmpleado.setApellidos_empleado(formularioEmpleado.txtApellidosEmpleado.getText());
				claseEmpleado.setIdentidad_empleado(formularioEmpleado.txtIdentidadEmpleado.getText().toString());
				claseEmpleado.setGenero_empleado(formularioEmpleado.cbxGeneroEmpleado.getSelectedItem().toString());
				int año1 = formularioEmpleado.dateFechaNacimiento.getCalendar().get(Calendar.YEAR);
				int dia1 = formularioEmpleado.dateFechaNacimiento.getCalendar().get(Calendar.DAY_OF_MONTH);
				int mes1 = formularioEmpleado.dateFechaNacimiento.getCalendar().get(Calendar.MONTH);
				fechaNacimiento = dia1 + "-" + mes1 + "-" + año1;
				claseEmpleado.setFecha_nacimiento_empleado(fechaNacimiento);
				int año2 = formularioEmpleado.dateFechaRegistro.getCalendar().get(Calendar.YEAR);
				int dia2 = formularioEmpleado.dateFechaRegistro.getCalendar().get(Calendar.DAY_OF_MONTH);
				int mes2 = formularioEmpleado.dateFechaRegistro.getCalendar().get(Calendar.MONTH);
				fechaRegistro = dia2 + "-" + mes2 + "-" + año2;
				claseEmpleado.setFecha_registro_empleado(fechaRegistro);
				int año3 = formularioEmpleado.dateFechaLabores.getCalendar().get(Calendar.YEAR);
				int dia3 = formularioEmpleado.dateFechaLabores.getCalendar().get(Calendar.DAY_OF_MONTH);
				int mes3 = formularioEmpleado.dateFechaLabores.getCalendar().get(Calendar.MONTH);
				fechaLabores = dia3 + "-" + mes3 + "-" + año3;
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
					JOptionPane.showMessageDialog(null, "Registro Guardado");
					limpiar();
					empleado claseEmpleado = new empleado();
					consultas_empleado consultaEmpleado = new consultas_empleado();
					registro_empleados formularioEmpleado = new registro_empleados();
					lista_empleados listaEmpleados = new lista_empleados();
					control_empleado controlEmpleado = new control_empleado(claseEmpleado, consultaEmpleado,
							formularioEmpleado, listaEmpleados);
					listaEmpleados.setVisible(true);
					listaEmpleados.setLocationRelativeTo(null);
					listaEmpleados.txtBusquedaEmpleado.requestFocusInWindow();
				} else {
					JOptionPane.showMessageDialog(null, "Error al Guardar");
					limpiar();
				}
			}
		}

		/* Actualizar Empleado */
		if (e.getSource() == formularioEmpleado.btnActualizarEmpleado) {

			if (formularioEmpleado.txtNombresEmpleado.getText().isEmpty()
					|| formularioEmpleado.txtApellidosEmpleado.getText().isEmpty()
					|| formularioEmpleado.txtIdentidadEmpleado.getText().isEmpty()
					|| formularioEmpleado.txtEdadEmpleado.getText().isEmpty()
					|| formularioEmpleado.txtTelefonoEmpleado.getText().isEmpty()
					|| formularioEmpleado.txtCorreoEmpleado.getText().isEmpty()
					|| formularioEmpleado.txtDireccionEmpleado.getText().isEmpty()
					|| formularioEmpleado.txtDireccionFoto.getText().isEmpty()
					|| formularioEmpleado.txtNombreReferencia.getText().isEmpty()
					|| formularioEmpleado.txtTelefonoReferencia.getText().isEmpty()
					|| formularioEmpleado.txtNombresEmpleado.getText().toString()
							.equalsIgnoreCase("Ingrese nombres del empleado.")
					|| formularioEmpleado.txtApellidosEmpleado.getText().toString()
							.equalsIgnoreCase("Ingrese apellidos del empleado.")
					|| formularioEmpleado.txtIdentidadEmpleado.getText().equals("   -   -     ")
					|| formularioEmpleado.txtTelefonoEmpleado.getText().equals("+(504)   -    ")
					|| formularioEmpleado.txtCorreoEmpleado.getText().toString()
							.equalsIgnoreCase("Ingrese el correo del empleado.")
					|| formularioEmpleado.txtDireccionEmpleado.getText().toString()
							.equalsIgnoreCase("Ingrese la direccion del empleado.")
					|| formularioEmpleado.txtDireccionFoto.getText().equals("")
					|| formularioEmpleado.txtEdadEmpleado.getText().equals("")
					|| formularioEmpleado.txtEdadEmpleado.getText().equals("Click -->")
					|| formularioEmpleado.dateFechaNacimiento.getDate().toString().isEmpty()
					|| formularioEmpleado.dateFechaRegistro.getDate().toString().isEmpty()
					|| formularioEmpleado.dateFechaLabores.getDate().toString().isEmpty()
					|| formularioEmpleado.txtNombreReferencia.getText().toString()
							.equalsIgnoreCase("Ingrese nombre completo de la referencia.")
					|| formularioEmpleado.txtTelefonoReferencia.getText().equals("+(504)   -    "))

			{
				JOptionPane.showMessageDialog(null,
						"Porfavor llene los campos para actualizar los datos del empleado!");

			} else {

				claseEmpleado.setId_empleado(Integer.parseInt(formularioEmpleado.txtCodigoEmpleado.getText()));
				claseEmpleado.setNombres_empleado(formularioEmpleado.txtNombresEmpleado.getText());
				claseEmpleado.setApellidos_empleado(formularioEmpleado.txtApellidosEmpleado.getText());
				claseEmpleado.setIdentidad_empleado(formularioEmpleado.txtIdentidadEmpleado.getText());
				claseEmpleado.setGenero_empleado(formularioEmpleado.cbxGeneroEmpleado.getSelectedItem().toString());
				int año1 = formularioEmpleado.dateFechaNacimiento.getCalendar().get(Calendar.YEAR);
				int dia1 = formularioEmpleado.dateFechaNacimiento.getCalendar().get(Calendar.DAY_OF_MONTH);
				int mes1 = formularioEmpleado.dateFechaNacimiento.getCalendar().get(Calendar.MONTH);
				fechaNacimiento = dia1 + "-" + mes1 + "-" + año1;
				claseEmpleado.setFecha_nacimiento_empleado(fechaNacimiento);
				int año2 = formularioEmpleado.dateFechaRegistro.getCalendar().get(Calendar.YEAR);
				int dia2 = formularioEmpleado.dateFechaRegistro.getCalendar().get(Calendar.DAY_OF_MONTH);
				int mes2 = formularioEmpleado.dateFechaRegistro.getCalendar().get(Calendar.MONTH);
				fechaRegistro = dia2 + "-" + mes2 + "-" + año2;
				claseEmpleado.setFecha_registro_empleado(fechaRegistro);
				int año3 = formularioEmpleado.dateFechaLabores.getCalendar().get(Calendar.YEAR);
				int dia3 = formularioEmpleado.dateFechaLabores.getCalendar().get(Calendar.DAY_OF_MONTH);
				int mes3 = formularioEmpleado.dateFechaLabores.getCalendar().get(Calendar.MONTH);
				fechaLabores = dia3 + "-" + mes3 + "-" + año3;
				claseEmpleado.setFecha_inicio_labores_empleado(fechaLabores);
				claseEmpleado.setDireccion_foto_empleado(formularioEmpleado.txtDireccionFoto.getText().toString());
				claseEmpleado.setEdad_empleado(formularioEmpleado.txtEdadEmpleado.getText().toString());
				claseEmpleado.setTelefono_empleado(formularioEmpleado.txtTelefonoEmpleado.getText().toString());
				claseEmpleado.setCorreo_empleado(formularioEmpleado.txtCorreoEmpleado.getText().toString());
				claseEmpleado.setDireccion_empleado(formularioEmpleado.txtDireccionEmpleado.getText().toString());
				claseEmpleado.setReferencia_empleado(formularioEmpleado.txtNombreReferencia.getText().toString());
				claseEmpleado.setTelefono_referencia(formularioEmpleado.txtTelefonoReferencia.getText().toString());
				claseEmpleado.setEstado_empleado(formularioEmpleado.cbxEstadoEmpleado.getSelectedItem().toString());

				if (consultaEmpleado.modificar(claseEmpleado)) {
					JOptionPane.showMessageDialog(null, "Registro Modificado");
					limpiar();
				} else {
					JOptionPane.showMessageDialog(null, "Error al Modificar");
					limpiar();
				}

			}
		}

		/* Borrar */
		if (e.getSource() == listaEmpleado.btnBorrarEmpleado) {
			PreparedStatement ps = null;
			int filaseleccionada;
			try {
				filaseleccionada = listaEmpleado.tablaEmpleados.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					conexion objCon = new conexion();
					Connection conn = objCon.getConexion();
					int Fila = listaEmpleado.tablaEmpleados.getSelectedRow();
					String codigo = listaEmpleado.tablaEmpleados.getValueAt(Fila, 0).toString();
					ps = conn.prepareStatement("DELETE FROM empleados WHERE id_empleado=?");
					ps.setString(1, codigo);
					ps.execute();
					JOptionPane.showMessageDialog(null, "Datos del Empleado Eliminados");
					limpiar();
					listaEmpleado.construirTablaEmpleados();
				}
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "Error al Eliminar Datos del Empleado");
				System.out.println(ex.toString());
			}
		}

		/* Limpiar */
		if (e.getSource() == listaEmpleado.btnNuevoEmpleado) {
			crearNuevoEmpleado();
		}

		/* Pasar datos de la tabla al formulario para actualizar */
		if (e.getSource() == listaEmpleado.btnActualizarDatosEmpleado) {
			int filaseleccionada;
			try {
				filaseleccionada = listaEmpleado.tablaEmpleados.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					String codigo = listaEmpleado.tablaEmpleados.getValueAt(filaseleccionada, 0).toString();
					String nombres = listaEmpleado.tablaEmpleados.getValueAt(filaseleccionada, 1).toString();
					String apellidos = listaEmpleado.tablaEmpleados.getValueAt(filaseleccionada, 2).toString();
					String identidad = listaEmpleado.tablaEmpleados.getValueAt(filaseleccionada, 3).toString();
					String genero = listaEmpleado.tablaEmpleados.getValueAt(filaseleccionada, 4).toString();
					String edad = listaEmpleado.tablaEmpleados.getValueAt(filaseleccionada, 5).toString();
					String telefono = listaEmpleado.tablaEmpleados.getValueAt(filaseleccionada, 6).toString();
					String correo = listaEmpleado.tablaEmpleados.getValueAt(filaseleccionada, 7).toString();
					String direccion = listaEmpleado.tablaEmpleados.getValueAt(filaseleccionada, 8).toString();
					String direccion_foto = listaEmpleado.tablaEmpleados.getValueAt(filaseleccionada, 9).toString();
					String referencia = listaEmpleado.tablaEmpleados.getValueAt(filaseleccionada, 10).toString();
					String t_referencia = listaEmpleado.tablaEmpleados.getValueAt(filaseleccionada, 11).toString();
					String fecha_nac = listaEmpleado.tablaEmpleados.getValueAt(filaseleccionada, 12).toString();
					String fecha_reg = listaEmpleado.tablaEmpleados.getValueAt(filaseleccionada, 13).toString();
					String fecha_lab = listaEmpleado.tablaEmpleados.getValueAt(filaseleccionada, 14).toString();
					String estado = listaEmpleado.tablaEmpleados.getValueAt(filaseleccionada, 15).toString();

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
					formularioEmpleado.txtNombreReferencia.setText(referencia);
					formularioEmpleado.txtTelefonoReferencia.setText(t_referencia);
					formularioEmpleado.dateFechaNacimiento.setDateFormatString(fecha_nac);
					formularioEmpleado.dateFechaRegistro.setDateFormatString(fecha_reg);
					formularioEmpleado.dateFechaLabores.setDateFormatString(fecha_lab);
					formularioEmpleado.txtSueldoCargo.setText(estado);

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
					formularioEmpleado.dateFechaNacimiento.setForeground(Color.BLACK);
					formularioEmpleado.dateFechaRegistro.setForeground(Color.BLACK);
					formularioEmpleado.dateFechaLabores.setForeground(Color.BLACK);
					formularioEmpleado.txtSueldoCargo.setForeground(Color.BLACK);

					formularioEmpleado.btnGuardarEmpleado.setVisible(false);
					formularioEmpleado.btnNuevoEmpleado.setVisible(false);
					formularioEmpleado.btnActualizarEmpleado.setVisible(true);
					formularioEmpleado.btnCancelarEmpleado.setVisible(true);

					formularioEmpleado.txtNombresEmpleado.requestFocusInWindow();

				}

			} catch (HeadlessException ex) {
				JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente",
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
		formularioEmpleado.dateFechaLabores.setToolTipText(null);
		formularioEmpleado.dateFechaNacimiento.setToolTipText(null);
		formularioEmpleado.dateFechaRegistro.setToolTipText(null);
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

	public void crearNuevoEmpleado() {
		formularioEmpleado.txtNombresEmpleado.requestFocusInWindow();
		formularioEmpleado.obtenerUltimoId();
		formularioEmpleado.pistas();
		formularioEmpleado.establecerFechaRegistro();
		formularioEmpleado.btnGuardarEmpleado.setVisible(true);
		formularioEmpleado.btnNuevoEmpleado.setVisible(true);
		formularioEmpleado.btnActualizarEmpleado.setVisible(false);
		formularioEmpleado.btnCancelarEmpleado.setVisible(false);
		registro_empleados formularioEmpleado = new registro_empleados();
		lista_empleados listaEmpleados = new lista_empleados();
		formularioEmpleado.setVisible(true);
		formularioEmpleado.setLocationRelativeTo(null);
		
	}

}
