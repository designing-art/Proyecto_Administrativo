package consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import clases.ingreso;
import conexion.conexion;

public class consultas_ingreso extends conexion {

	/* Actualizar */
	public boolean actualizar(ingreso ingreso) {
		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "UPDATE sar SET id_ingreso=?, tipo_ingreso=?, cantidad_ingreso=?, descripcion_ingreso=?, fecha_ingreso=? WHERE id_ingreso=? ";

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, ingreso.getId_ingreso());
			ps.setString(1, ingreso.getTipo_ingreso());
			ps.setDouble(2, ingreso.getCantidad_ingreso());
			ps.setString(3, ingreso.getDescripcion_ingreso());
			ps.setString(4, ingreso.getFecha_ingreso());
			ps.setInt(8, ingreso.getId_ingreso());
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
