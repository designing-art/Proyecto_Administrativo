package consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import clases.empleado;
import clases.historial_planilla;
import clases.planilla;
import conexion.conexion;

public class consultas_planilla extends conexion {

	public boolean registrar(planilla planilla) {
		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "INSERT INTO planillas (fecha_planilla, nombres_planilla, apellidos_planilla, identidad_planilla, cargo_planilla, sueldo_bruto_planilla, total_deducciones_planilla, total_bonificaciones_planilla, sueldo_neto_planilla, total_apagar_planilla, nombre_planilla) VALUES(?,?,?,?,?,?,?,?,?,?,?)";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, planilla.getFecha_planilla());
			ps.setString(2, planilla.getNombres_planilla());
			ps.setString(3, planilla.getApellidos_planilla());
			ps.setString(4, planilla.getIdentidad_planilla());
			ps.setString(5, planilla.getCargo_planilla());
			ps.setDouble(6, planilla.getSueldo_bruto_planilla());
			ps.setDouble(7, planilla.getTotal_deducciones_planilla());
			ps.setDouble(8, planilla.getTotal_bonificaciones_planilla());
			ps.setDouble(9, planilla.getSueldo_neto_planilla());
			ps.setDouble(10, planilla.getTotal_apagar_planilla());
			ps.setString(11, planilla.getNombre_planilla());
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

	public boolean registrarEliminacion(planilla planilla) {
		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "INSERT INTO planillas (id_planilla, fecha_planilla, nombres_planilla, apellidos_planilla, identidad_planilla, cargo_planilla, sueldo_bruto_planilla, total_deducciones_planilla, total_bonificaciones_planilla, sueldo_neto_planilla, total_apagar_planilla, nombre_planilla) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, planilla.getId_planilla());
			ps.setString(2, planilla.getFecha_planilla());
			ps.setString(3, planilla.getNombres_planilla());
			ps.setString(4, planilla.getApellidos_planilla());
			ps.setString(5, planilla.getIdentidad_planilla());
			ps.setString(6, planilla.getCargo_planilla());
			ps.setDouble(7, planilla.getSueldo_bruto_planilla());
			ps.setDouble(8, planilla.getTotal_deducciones_planilla());
			ps.setDouble(9, planilla.getTotal_bonificaciones_planilla());
			ps.setDouble(10, planilla.getSueldo_neto_planilla());
			ps.setDouble(11, planilla.getTotal_apagar_planilla());
			ps.setString(12, planilla.getNombre_planilla());
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

	public boolean modificar(planilla planilla) {
		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "UPDATE planillas SET id_planilla=?, fecha_planilla=?, nombres_planilla=?, apellidos_planilla=?, identidad_planilla=?, cargo_planilla=?, sueldo_bruto_planilla=?, total_deducciones_planilla=?, total_bonificaciones_planilla=?, sueldo_neto_planilla=?, total_apagar_planilla=?, nombre_planilla=? WHERE id_planilla=? ";

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, planilla.getId_planilla());
			ps.setString(2, planilla.getFecha_planilla());
			ps.setString(3, planilla.getNombres_planilla());
			ps.setString(4, planilla.getApellidos_planilla());
			ps.setString(5, planilla.getIdentidad_planilla());
			ps.setString(6, planilla.getCargo_planilla());
			ps.setDouble(7, planilla.getSueldo_bruto_planilla());
			ps.setDouble(8, planilla.getTotal_deducciones_planilla());
			ps.setDouble(9, planilla.getTotal_bonificaciones_planilla());
			ps.setDouble(10, planilla.getSueldo_neto_planilla());
			ps.setDouble(11, planilla.getTotal_apagar_planilla());
			ps.setString(12, planilla.getNombre_planilla());
			ps.setInt(13, planilla.getId_planilla());
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

		String sql = "SELECT id_empleado, nombres_empleado, apellidos_empleado, identidad_empleado, nombre_cargo_empleado, direccion_foto_empleado, sueldo_cargo_empleado FROM empleados WHERE identidad_empleado = ? ";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, empleado.getIdentidad_empleado());
			rs = ps.executeQuery();

			if (rs.next()) {
				empleado.setId_empleado(rs.getInt("id_empleado"));
				empleado.setNombres_empleado(rs.getString("nombres_empleado"));
				empleado.setApellidos_empleado(rs.getString("apellidos_empleado"));
				empleado.setIdentidad_empleado(rs.getString("identidad_empleado"));
				empleado.setNombre_cargo_empleado(rs.getString("nombre_cargo_empleado"));
				empleado.setDireccion_foto_empleado(rs.getString("direccion_foto_empleado"));
				empleado.setSueldo_cargo_empleado(rs.getString("sueldo_cargo_empleado"));
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

	public boolean actualizarDatosPlanilla(historial_planilla historial_planilla) {
		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "UPDATE historial_planillas SET total_deducciones_planilla_final=?, total_bonificaciones_planilla_final=?, total_sueldos_planilla_final=?, total_pago_planilla_final=? WHERE id_planilla_final=? ";

		try {
			ps = con.prepareStatement(sql);
			ps.setDouble(1, historial_planilla.getTotal_deducciones_planilla_final());
			ps.setDouble(2, historial_planilla.getTotal_bonificaciones_planilla_final());
			ps.setDouble(3, historial_planilla.getTotal_sueldos_planilla_final());
			ps.setDouble(4, historial_planilla.getTotal_pago_planilla_final());
			ps.setInt(5, historial_planilla.getId_planilla_final());
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
