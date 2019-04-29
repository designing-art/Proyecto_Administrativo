package consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import clases.horario;
import conexion.conexion;

public class consultas_horario extends conexion {

	/* Consultas para Horario */

	/* Registrar */
	public boolean insertar(horario horario) {
		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "INSERT INTO horarios ( tipo_horario, dias_horario, horas_horario, descripcion_horario, observacion_horario) VALUES(?,?,?,?,?)";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, horario.getTipo_horario());
			ps.setString(2, horario.getDias_horario());
			ps.setString(3, horario.getHoras_horario());
			ps.setString(4, horario.getDescripcion_horario());
			ps.setString(5, horario.getObservacion_horario());
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

	/* Actualizar */
	public boolean actualizar(horario horario) {
		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "UPDATE horarios SET id_horario=?, tipo_horario=?, dias_horario=?, horas_horario=?, descripcion_horario=?,observacion_horario=? WHERE id_horario=? ";

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, horario.getId_horario());
			ps.setString(2, horario.getTipo_horario());
			ps.setString(3, horario.getDias_horario());
			ps.setString(4, horario.getHoras_horario());
			ps.setString(5, horario.getDescripcion_horario());
			ps.setString(6, horario.getObservacion_horario());
			ps.setInt(7, horario.getId_horario());
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
