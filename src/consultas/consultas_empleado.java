package consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import clases.empleado;
import conexion.conexion;

public class consultas_empleado extends conexion {

	public boolean registrar(empleado empleado) {
		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "INSERT INTO empleados (nombres_empleado, apellidos_empleado , identidad_empleado, genero_empleado, edad_empleado, telefono_empleado, correo_empleado, direccion_empleado, direccion_foto_empleado, referencia_empleado, telefono_referencia, fecha_nacimiento_empleado, fecha_registro_empleado, fecha_inicio_labores_empleado, estado_empleado, nombre_cargo_empleado, sueldo_cargo_empleado, hora_extra_cargo_empleado, obligaciones_cargo_empleado, tipo_horario_empleado, dias_horario_empleado, horas_horario_empleado, identidad_contrato_empleado_asignado, tipo_contrato_empleado_asignado, tiempo_contrato_empleado_asignado, foto_contrato_empleado_asignado) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, empleado.getNombres_empleado());
			ps.setString(2, empleado.getApellidos_empleado());
			ps.setString(3, empleado.getIdentidad_empleado());
			ps.setString(4, empleado.getGenero_empleado());
			ps.setString(5, empleado.getEdad_empleado());
			ps.setString(6, empleado.getTelefono_empleado());
			ps.setString(7, empleado.getCorreo_empleado());
			ps.setString(8, empleado.getDireccion_empleado());
			ps.setString(9, empleado.getDireccion_foto_empleado());
			ps.setString(10, empleado.getReferencia_empleado());
			ps.setString(11, empleado.getTelefono_referencia());
			ps.setString(12, empleado.getFecha_nacimiento_empleado());
			ps.setString(13, empleado.getFecha_registro_empleado());
			ps.setString(14, empleado.getFecha_inicio_labores_empleado());
			ps.setString(15, empleado.getEstado_empleado());
			ps.setString(16, empleado.getNombre_cargo_empleado());
			ps.setString(17, empleado.getSueldo_cargo_empleado());
			ps.setString(18, empleado.getHora_extra_cargo_empleado());
			ps.setString(19, empleado.getObligaciones_cargo_empleado());
			ps.setString(20, empleado.getTipo_horario_empleado());
			ps.setString(21, empleado.getDias_horario_empleado());
			ps.setString(22, empleado.getHoras_horario_empleado());
			ps.setString(23, empleado.getIdentidad_contrato_empleado_asignado());
			ps.setString(24, empleado.getTipo_contrato_empleado_asignado());
			ps.setString(25, empleado.getTiempo_contrato_empleado_asignado());
			ps.setString(26, empleado.getFoto_contrato_empleado_asignado());
			ps.execute();

			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.err.println(e);
			}
		}
	}

	public boolean modificar(empleado empleado) {
		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "UPDATE empleados SET id_empleado=?, nombres_empleado=?, apellidos_empleado=?, identidad_empleado=?, genero_empleado=?, edad_empleado=?, telefono_empleado=?, correo_empleado=?, direccion_empleado=?, direccion_foto_empleado=?, referencia_empleado=?, telefono_referencia=?, fecha_nacimiento_empleado=?, fecha_registro_empleado=?, fecha_inicio_labores_empleado=?, estado_empleado=?, nombre_cargo_empleado=?, sueldo_cargo_empleado=?, hora_extra_cargo_empleado=?, obligaciones_cargo_empleado=?, tipo_horario_empleado=?, dias_horario_empleado=?, horas_horario_empleado=?, identidad_contrato_empleado_asignado=?, tipo_contrato_empleado_asignado=?, tiempo_contrato_empleado_asignado=?, foto_contrato_empleado_asignado=? WHERE id_empleado=? ";

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, empleado.getId_empleado());
			ps.setString(2, empleado.getNombres_empleado());
			ps.setString(3, empleado.getApellidos_empleado());
			ps.setString(4, empleado.getIdentidad_empleado());
			ps.setString(5, empleado.getGenero_empleado());
			ps.setString(6, empleado.getEdad_empleado());
			ps.setString(7, empleado.getTelefono_empleado());
			ps.setString(8, empleado.getCorreo_empleado());
			ps.setString(9, empleado.getDireccion_empleado());
			ps.setString(10, empleado.getDireccion_foto_empleado());
			ps.setString(11, empleado.getReferencia_empleado());
			ps.setString(12, empleado.getTelefono_referencia());
			ps.setString(13, empleado.getFecha_nacimiento_empleado());
			ps.setString(14, empleado.getFecha_registro_empleado());
			ps.setString(15, empleado.getFecha_inicio_labores_empleado());
			ps.setString(16, empleado.getEstado_empleado());
			ps.setString(17, empleado.getNombre_cargo_empleado());
			ps.setString(18, empleado.getSueldo_cargo_empleado());
			ps.setString(19, empleado.getHora_extra_cargo_empleado());
			ps.setString(20, empleado.getObligaciones_cargo_empleado());
			ps.setString(21, empleado.getTipo_horario_empleado());
			ps.setString(22, empleado.getDias_horario_empleado());
			ps.setString(23, empleado.getHoras_horario_empleado());
			ps.setString(24, empleado.getIdentidad_contrato_empleado_asignado());
			ps.setString(25, empleado.getTipo_contrato_empleado_asignado());
			ps.setString(26, empleado.getTiempo_contrato_empleado_asignado());
			ps.setString(27, empleado.getFoto_contrato_empleado_asignado());
			ps.setInt(28, empleado.getId_empleado());
			ps.execute();
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.err.println(e);
			}
		}

	}
}