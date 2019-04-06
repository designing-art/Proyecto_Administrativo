package controles;

import java.awt.Color;
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

public class control_empleado implements ActionListener {

	public empleado claseEmpleado;
	public consultas_empleado consultaEmpleado;
	public registro_empleados formularioEmpleado;
	public lista_empleados listaEmpleado;

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
			
			claseEmpleado.setNombres_empleado(formularioEmpleado.txtNombresEmpleado.getText());
			claseEmpleado.setApellidos_empleado(formularioEmpleado.txtApellidosEmpleado.getText());
			claseEmpleado.setIdentidad_empleado(formularioEmpleado.txtIdentidadEmpleado.getText());
			claseEmpleado.setGenero_empleado(formularioEmpleado.cbxGeneroEmpleado.getSelectedItem().toString());

			int año1 = formularioEmpleado.dateFechaNacimiento.getCalendar().get(Calendar.YEAR);
			int dia1 = formularioEmpleado.dateFechaNacimiento.getCalendar().get(Calendar.DAY_OF_MONTH);
			int mes1 = formularioEmpleado.dateFechaNacimiento.getCalendar().get(Calendar.MONTH);
			String dateFechaNacimiento = dia1 + "-" + mes1 + "-" + año1;
			claseEmpleado.setFecha_nacimiento_empleado(dateFechaNacimiento);

			int año2 = formularioEmpleado.dateFechaRegistro.getCalendar().get(Calendar.YEAR);
			int dia2 = formularioEmpleado.dateFechaRegistro.getCalendar().get(Calendar.DAY_OF_MONTH);
			int mes2 = formularioEmpleado.dateFechaRegistro.getCalendar().get(Calendar.MONTH);
			String dateFechaRegistro = dia2 + "-" + mes2 + "-" + año2;
			claseEmpleado.setFecha_registro_empleado(dateFechaRegistro);

			int año3 = formularioEmpleado.dateFechaLabores.getCalendar().get(Calendar.YEAR);
			int dia3 = formularioEmpleado.dateFechaLabores.getCalendar().get(Calendar.DAY_OF_MONTH);
			int mes3 = formularioEmpleado.dateFechaLabores.getCalendar().get(Calendar.MONTH);
			String dateFechaLabores = dia3 + "-" + mes3 + "-" + año3;
			claseEmpleado.setFecha_inicio_labores_empleado(dateFechaLabores);
			
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
			} else {
				JOptionPane.showMessageDialog(null, "Error al Guardar");
				limpiar();
			}
		}

		/* Actualizar Empleado */
		if (e.getSource() == formularioEmpleado.btnActualizarEmpleado) {

			claseEmpleado.setId_empleado(Integer.parseInt(formularioEmpleado.txtCodigoEmpleado.getText()));
			claseEmpleado.setNombres_empleado(formularioEmpleado.txtNombresEmpleado.getText());
			claseEmpleado.setApellidos_empleado(formularioEmpleado.txtApellidosEmpleado.getText());
			claseEmpleado.setIdentidad_empleado(formularioEmpleado.txtIdentidadEmpleado.getText());
			claseEmpleado.setGenero_empleado(formularioEmpleado.cbxGeneroEmpleado.getSelectedItem().toString());

			int año1 = formularioEmpleado.dateFechaNacimiento.getCalendar().get(Calendar.YEAR);
			int dia1 = formularioEmpleado.dateFechaNacimiento.getCalendar().get(Calendar.DAY_OF_MONTH);
			int mes1 = formularioEmpleado.dateFechaNacimiento.getCalendar().get(Calendar.MONTH);
			String dateFechaNacimiento = dia1 + "-" + mes1 + "-" + año1;
			claseEmpleado.setFecha_nacimiento_empleado(dateFechaNacimiento);

			int año2 = formularioEmpleado.dateFechaRegistro.getCalendar().get(Calendar.YEAR);
			int dia2 = formularioEmpleado.dateFechaRegistro.getCalendar().get(Calendar.DAY_OF_MONTH);
			int mes2 = formularioEmpleado.dateFechaRegistro.getCalendar().get(Calendar.MONTH);
			String dateFechaRegistro = dia2 + "-" + mes2 + "-" + año2;
			claseEmpleado.setFecha_registro_empleado(dateFechaRegistro);

			int año3 = formularioEmpleado.dateFechaLabores.getCalendar().get(Calendar.YEAR);
			int dia3 = formularioEmpleado.dateFechaLabores.getCalendar().get(Calendar.DAY_OF_MONTH);
			int mes3 = formularioEmpleado.dateFechaLabores.getCalendar().get(Calendar.MONTH);
			String dateFechaLabores = dia3 + "-" + mes3 + "-" + año3;
			claseEmpleado.setFecha_inicio_labores_empleado(dateFechaLabores);
			
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
					ps = conn.prepareStatement("DELETE FROM cargos WHERE id_cargo=?");
					ps.setString(1, codigo);
					ps.execute();
					JOptionPane.showMessageDialog(null, "Cargo Eliminado");
					limpiar();
					listaEmpleado.construirTablaEmpleados();

				}
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "Error al Eliminar Cargo");
				System.out.println(ex.toString());
			}
		}

		/* Limpiar */
		if (e.getSource() == listaEmpleado.btnNuevoEmpleado) {
			limpiar();
			formularioEmpleado.obtenerUltimoId();
			formularioEmpleado.pistas();
			formularioEmpleado.txtDireccionEmpleado.setBackground(Color.WHITE);
		}
	}

	public void limpiar() {
		formularioEmpleado.txtCodigoEmpleado.setText(null);
		formularioEmpleado.txtNombresEmpleado.setText(null);
		formularioEmpleado.txtApellidosEmpleado.setText(null);
		formularioEmpleado.txtIdentidadEmpleado.setText(null);
		formularioEmpleado.cbxGeneroEmpleado.getSelectedItem().equals(null);
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

	/* Metodos para mostrar datos en tabla Cargos */
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
				empleado.setReferencia_empleado(rs.getString("referencia_empleado"));
				empleado.setTelefono_empleado(rs.getString("telefono_referencia"));
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
