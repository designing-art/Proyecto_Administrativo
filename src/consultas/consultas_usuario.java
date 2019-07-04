package consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import clases.cargo;
import clases.empleado;
import clases.sar;
import clases.usuario;
import conexion.conexion;

public class consultas_usuario extends conexion {
	public boolean insertar(usuario usuario) {
		PreparedStatement ps = null;
		Connection con = getConexion();
		String sql = "INSERT INTO usuario (usuario, contraseña, identidad, nombre, cargo, tipo_usuario, permisos) VALUES(?,?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, usuario.getUsuario());
			ps.setString(2, usuario.getContraseña());
			ps.setString(3, usuario.getIdentidad());
			ps.setString(4, usuario.getNombre());
			ps.setString(5, usuario.getCargo());
			ps.setString(6, usuario.getTipo_usuario());
			ps.setString(7, usuario.getPermisos());
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
	public boolean actualizar(usuario usuario) {
		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "UPDATE usuario SET id_usuario=?, usuario=?, contraseña=?, identidad=?, nombre=?, cargo=?, tipo_usuario=?, permisos=? WHERE id_usuario=? ";
			
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, usuario.getId_usuario());
			ps.setString(2, usuario.getUsuario());
			ps.setString(3, usuario.getContraseña());
			ps.setString(4, usuario.getIdentidad());
			ps.setString(5, usuario.getNombre());
			ps.setString(6, usuario.getCargo());
			ps.setString(7, usuario.getTipo_usuario());
			ps.setString(8, usuario.getPermisos());
			ps.setInt(9, usuario.getId_usuario());
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

		String sql = "SELECT nombres_empleado, apellidos_empleado, identidad_empleado, nombre_cargo_empleado FROM empleados WHERE identidad_empleado = ? ";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, empleado.getIdentidad_empleado());
			rs = ps.executeQuery();

			if (rs.next()) {
				empleado.setNombres_empleado(rs.getString("nombres_empleado"));
				empleado.setApellidos_empleado(rs.getString("apellidos_empleado"));
				empleado.setIdentidad_empleado(rs.getString("identidad_empleado"));
				empleado.setNombre_cargo_empleado(rs.getString("nombre_cargo_empleado"));
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
	
	public boolean buscarUsuario(usuario usuario) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConexion();

		String sql = "SELECT * FROM usuario WHERE usuario=? and contraseña =?";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, usuario.getUsuario());
			ps.setString(2, usuario.getContraseña());
			rs = ps.executeQuery();

			if (rs.next()) {
				usuario.setNombre(rs.getString("nombre"));
				usuario.setCargo(rs.getString("cargo"));
				usuario.setTipo_usuario(rs.getString("tipo_usuario"));
				usuario.setPermisos(rs.getString("permisos"));
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
