package consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import clases.bonificacion;
import clases.empleado;
import conexion.conexion;

public class consultas_bonificacion extends conexion {

	public boolean registrar(bonificacion bonificacion) {
		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "INSERT INTO bonificaciones (tipo_bonificacion, observacion_bonificacion, identidad_empleado_bonificacion, cantidad_bonificacion, fecha_bonificacion) VALUES(?,?,?,?,?)";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, bonificacion.getTipo_bonificacion());
			ps.setString(2, bonificacion.getObservacion_bonificacion());
			ps.setString(3, bonificacion.getIdentidad_empleado_bonificacion());
			ps.setDouble(4, bonificacion.getCantidad_bonificacion());
			ps.setString(5, bonificacion.getFecha_bonificacion());
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

	public boolean modificar(bonificacion bonificacion) {
		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "UPDATE bonificaciones SET id_bonificacion=?, tipo_bonificacion=?, observacion_bonificacion=?, identidad_empleado_bonificacion=?, cantidad_bonificacion=?, fecha_bonificacion=? WHERE id_bonificacion=? ";

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, bonificacion.getId_bonificacion());
			ps.setString(1, bonificacion.getTipo_bonificacion());
			ps.setString(2, bonificacion.getObservacion_bonificacion());
			ps.setString(3, bonificacion.getIdentidad_empleado_bonificacion());
			ps.setDouble(4, bonificacion.getCantidad_bonificacion());
			ps.setString(5, bonificacion.getFecha_bonificacion());
			ps.setInt(7, bonificacion.getId_bonificacion());
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

	public boolean buscar(empleado empleado) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConexion();

		String sql = "SELECT id_empleado, nombres_empleado, apellidos_empleado, identidad_empleado, direccion_foto_empleado FROM empleados WHERE identidad_empleado = ? ";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, empleado.getIdentidad_empleado());
			rs = ps.executeQuery();

			if (rs.next()) {
				empleado.setId_empleado(rs.getInt("id_empleado"));
				empleado.setNombres_empleado(rs.getString("nombres_empleado"));
				empleado.setApellidos_empleado(rs.getString("apellidos_empleado"));
				empleado.setIdentidad_empleado(rs.getString("identidad_empleado"));
				empleado.setDireccion_foto_empleado(rs.getString("direccion_foto_empleado"));
				return true;
			}
			return false;
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
