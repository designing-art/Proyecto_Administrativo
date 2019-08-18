package consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import clases.sar;
import conexion.conexion;

public class consultas_sar extends conexion {
	public boolean insertar(sar sar) {
		PreparedStatement ps = null;
		Connection con = getConexion();
		String sql = "INSERT INTO sar (cai_sar, formato_sar, rango_inicial_sar, rango_final_sar, factura_actual_sar, fecha_limite_sar) VALUES(?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, sar.getCai_sar());
			ps.setString(2, sar.getFormato_sar());
			ps.setInt(3, sar.getRango_inicial_sar());
			ps.setInt(4, sar.getRango_final_sar());
			ps.setInt(5, sar.getFactura_actual_sar());
			ps.setString(6, sar.getFecha_limite_sar());
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
	
		public boolean insertarEliminacion(sar sar) {
			PreparedStatement ps = null;
			Connection con = getConexion();
			String sql = "INSERT INTO sar (id_sar, cai_sar, formato_sar, rango_inicial_sar, rango_final_sar, factura_actual_sar, fecha_limite_sar) VALUES(?,?,?,?,?,?,?)";
			try {
				ps = con.prepareStatement(sql);
				ps.setInt(1, sar.getId_sar());
				ps.setString(2, sar.getCai_sar());
				ps.setString(3, sar.getFormato_sar());
				ps.setInt(4, sar.getRango_inicial_sar());
				ps.setInt(5, sar.getRango_final_sar());
				ps.setInt(6, sar.getFactura_actual_sar());
				ps.setString(7, sar.getFecha_limite_sar());
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
	public boolean actualizar(sar sar) {
		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "UPDATE sar SET id_sar=?, cai_sar=?, formato_sar=?, rango_inicial_sar=?, rango_final_sar=?, factura_actual_sar=?, fecha_limite_sar=? WHERE id_sar=? ";

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, sar.getId_sar());
			ps.setString(2, sar.getCai_sar());
			ps.setString(3, sar.getFormato_sar());
			ps.setInt(4, sar.getRango_inicial_sar());
			ps.setInt(5, sar.getRango_final_sar());
			ps.setInt(6, sar.getFactura_actual_sar());
			ps.setString(7, sar.getFecha_limite_sar());
			ps.setInt(8, sar.getId_sar());
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
