package consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import clases.cargo;
import conexion.conexion;

public class consultas_cargo extends conexion {

	/* Consultas para Cargos */

	/* Registrar */
	public boolean insertar(cargo cargo) {
		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "INSERT INTO cargos (area_cargo, nombre_cargo, sueldo_cargo, valor_hora_extra_cargo, funciones_cargo) VALUES(?,?,?,?,?)";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, cargo.getArea_cargo());
			ps.setString(2, cargo.getNombre_cargo());
			ps.setDouble(3, cargo.getSueldo_cargo());
			ps.setDouble(4, cargo.getValor_hora_extra_cargo());
			ps.setString(5, cargo.getFunciones_cargo());
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
	public boolean actualizar(cargo cargo) {
		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "UPDATE cargos SET id_cargo=?, area_cargo=?, nombre_cargo=?, sueldo_cargo=?, valor_hora_extra_cargo=?, funciones_cargo=? WHERE id_cargo=? ";

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, cargo.getId_cargo());
			ps.setString(2, cargo.getArea_cargo());
			ps.setString(3, cargo.getNombre_cargo());
			ps.setDouble(4, cargo.getSueldo_cargo());
			ps.setDouble(5, cargo.getValor_hora_extra_cargo());
			ps.setString(6, cargo.getFunciones_cargo());
			ps.setInt(7, cargo.getId_cargo());
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
