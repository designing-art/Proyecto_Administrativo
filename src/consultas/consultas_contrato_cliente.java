package consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import clases.contrato_cliente;
import clases.contrato_empleado;
import conexion.conexion;

public class consultas_contrato_cliente extends conexion {
	public boolean insertar(contrato_cliente contrato) {
		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "INSERT INTO contrato_cliente (tipo_contrato_cliente, tiempo_contrato_cliente, foto_contrato_cliente, identidad_rtn_cliente) VALUES(?,?,?,?)";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, contrato.getTipo_contrato_cliente());
			ps.setString(2, contrato.getTiempo_contrato_cliente());
			ps.setString(3, contrato.getFoto_contrato_cliente());
			ps.setString(4, contrato.getIdentidad_rtn_cliente());
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
	public boolean actualizar(contrato_cliente contrato) {
		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "UPDATE contrato_cliente SET id_contrato_cliente=?, tipo_contrato_cliente=?, tiempo_contrato_cliente=?, foto_contrato_cliente=?, identidad_rtn_cliente=? WHERE id_contrato_cliente=? ";

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, contrato.getId_contrato_cliente());
			ps.setString(1, contrato.getTipo_contrato_cliente());
			ps.setString(2, contrato.getTiempo_contrato_cliente());
			ps.setString(3, contrato.getFoto_contrato_cliente());
			ps.setString(4, contrato.getIdentidad_rtn_cliente());
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
