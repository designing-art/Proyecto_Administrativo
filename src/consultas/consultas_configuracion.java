package consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import clases.configuracion;
import conexion.conexion;

public class consultas_configuracion extends conexion {

	/* Consultas para empresa */

	/* Registrar */
	public boolean insertar(configuracion configuracion) {
		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "INSERT INTO configuraciones (sonido_configuracion, frase_configuracion) VALUES(?,?)";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, configuracion.getSonido_configuracion());
			ps.setString(2, configuracion.getFrase_configuracion());
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
	public boolean actualizar(configuracion configuracion) {
		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "UPDATE configuraciones SET id_configuracion=?, sonido_configuracion=?, frase_configuracion=? WHERE id_configuracion=? ";

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, configuracion.getId_configuracion());
			ps.setString(2, configuracion.getSonido_configuracion());
			ps.setString(3, configuracion.getFrase_configuracion());
			ps.setInt(4, configuracion.getId_configuracion());
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

	public boolean buscar(configuracion configuracion) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConexion();

		String sql = "SELECT * FROM configuraciones WHERE id_configuracion = 1 ";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				configuracion.setId_configuracion(Integer.parseInt(rs.getString("id_configuracion")));
				configuracion.setSonido_configuracion(rs.getString("sonido_configuracion"));
				configuracion.setFrase_configuracion(rs.getString("frase_configuracion"));
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
