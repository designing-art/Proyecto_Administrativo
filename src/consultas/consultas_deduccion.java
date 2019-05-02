package consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import clases.deduccion;
import clases.empleado;
import conexion.conexion;

public class consultas_deduccion extends conexion {

	public boolean registrar(deduccion deduccion) {
		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "INSERT INTO deducciones (tipo_deduccion, observacion_deduccion, identidad_empleado_deduccion, cantidad_deduccion, fecha_deduccion) VALUES(?,?,?,?,?)";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, deduccion.getTipo_deduccion());
			ps.setString(2, deduccion.getObservacion_deduccion());
			ps.setString(3, deduccion.getIdentidad_empleado_deduccion());
			ps.setDouble(4, deduccion.getCantidad_deduccion());
			ps.setString(5, deduccion.getFecha_deduccion());
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

	public boolean modificar(deduccion deduccion) {
		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "UPDATE deducciones SET id_deduccion=?, tipo_deduccion=?, observacion_deduccion=?, identidad_empleado_deduccion=?, cantidad_deduccion=?, fecha_deduccion=? WHERE id_deduccion=? ";

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, deduccion.getId_deduccion());
			ps.setString(2, deduccion.getTipo_deduccion());
			ps.setString(3, deduccion.getObservacion_deduccion());
			ps.setString(4, deduccion.getIdentidad_empleado_deduccion());
			ps.setDouble(5, deduccion.getCantidad_deduccion());
			ps.setString(6, deduccion.getFecha_deduccion());
			ps.setInt(7, deduccion.getId_deduccion());
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
