package consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import clases.servidor;
import conexion.conexion;

public class consultas_servidor extends conexion {

	public boolean actualizar(servidor servidor) {
		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "UPDATE servidor SET id_servidor=?, ip_servidor=? WHERE id_servidor=? ";

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, servidor.getId_servidor());
			ps.setString(2, servidor.getIp_servidor());
			ps.setInt(3, servidor.getId_servidor());
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

