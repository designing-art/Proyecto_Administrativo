package consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import clases.egreso;
import conexion.conexion;

public class consultas_egreso extends conexion {
	

	public boolean insertarEgreso(egreso egreso) {
		PreparedStatement ps = null;
		Connection con = getConexion();
		String sql = "INSERT INTO egresos (tipo_egreso, cantidad_egreso, descripcion_egreso, fecha_egreso) VALUES(?,?,?,?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, egreso.getTipo_egreso());
			ps.setDouble(2, egreso.getCantidad_egreso());
			ps.setString(3, egreso.getDescripcion_egreso());
			ps.setString(4, egreso.getFecha_egreso());
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
	public boolean actualizarEgreso(egreso egreso) {
		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "UPDATE egresos SET id_egreso=?, tipo_egreso=?, cantidad_egreso=?, descripcion_egreso=?, fecha_egreso=? WHERE id_egreso=? ";

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, egreso.getId_egreso());
			ps.setString(2, egreso.getTipo_egreso());
			ps.setDouble(3, egreso.getCantidad_egreso());
			ps.setString(4, egreso.getDescripcion_egreso());
			ps.setString(5, egreso.getFecha_egreso());
			ps.setInt(6, egreso.getId_egreso());
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
