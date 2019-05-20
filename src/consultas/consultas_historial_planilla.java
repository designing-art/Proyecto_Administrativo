package consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import clases.historial_planilla;

import conexion.conexion;

public class consultas_historial_planilla extends conexion {
	
	public boolean registrar(historial_planilla historial_planilla) {
		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "INSERT INTO historial_planillas (tipo_planilla_final, fecha_crecion_planilla_final, fecha_pago_planilla_final, nombre_planilla_final, total_deducciones_planilla_final, total_bonificaciones_planilla_final, total_pago_planilla_final) VALUES(?,?,?,?,?,?,?,?)";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, historial_planilla.getTipo_planilla_final());
			ps.setString(2, historial_planilla.getFecha_crecion_planilla_final());
			ps.setString(3, historial_planilla.getFecha_pago_planilla_final());
			ps.setString(4, historial_planilla.getNombre_planilla_final());
			ps.setDouble(5, historial_planilla.getTotal_deducciones_planilla_final());
			ps.setDouble(6, historial_planilla.getTotal_bonificaciones_planilla_final());
			ps.setDouble(7, historial_planilla.getTotal_pago_planilla_final());
			ps.setString(8, historial_planilla.getEstado_planila());
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
	
	public boolean modificar(historial_planilla historial_planilla) {
		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "UPDATE historial_planillas SET id_planilla_final=?, tipo_planilla_final=?, fecha_crecion_planilla_final=?, fecha_pago_planilla_final=?, nombre_planilla_final=?, total_deducciones_planilla_final=?, total_bonificaciones_planilla_final=?, total_pago_planilla_final=?, estado_planilla=?, codigo_planilla=?, WHERE id_planilla_final=? ";

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, historial_planilla.getId_planilla_final());
			ps.setString(2, historial_planilla.getTipo_planilla_final());
			ps.setString(3, historial_planilla.getFecha_crecion_planilla_final());
			ps.setString(4, historial_planilla.getFecha_pago_planilla_final());
			ps.setString(5, historial_planilla.getNombre_planilla_final());
			ps.setDouble(6, historial_planilla.getTotal_deducciones_planilla_final());
			ps.setDouble(7, historial_planilla.getTotal_bonificaciones_planilla_final());
			ps.setDouble(8, historial_planilla.getTotal_pago_planilla_final());
			ps.setString(9, historial_planilla.getEstado_planila());
			ps.setInt(10, historial_planilla.getId_planilla_final());
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
