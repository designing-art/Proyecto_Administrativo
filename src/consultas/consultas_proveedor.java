package consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import clases.proveedor;
import conexion.conexion;

public class consultas_proveedor extends conexion {

	/* Consultas para Cargos */

	/* Registrar */
	public boolean insertar(proveedor proveedor) {
		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "INSERT INTO proveedores (nombres_proveedor, cuenta_bancaria_proveedor, direccion_proveedor, rtn_proveedor, telefono_proveedor, correo_electronico_proveedor, foto_proveedor) VALUES(?,?,?,?,?,?,?)";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, proveedor.getNombres_proveedor());
			ps.setString(2, proveedor.getCuenta_bancaria_proveedor());
			ps.setString(3, proveedor.getDireccion_proveedor());
			ps.setString(4, proveedor.getRtn_proveedor());
			ps.setString(5, proveedor.getTelefono_proveedor());
			ps.setString(6, proveedor.getCorreo_electronico_proveedor());
			ps.setString(7, proveedor.getFoto_proveedor());
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
	public boolean actualizar(proveedor proveedor) {
		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "UPDATE proveedores SET id_proveedor=?, nombres_proveedor=?, cuenta_bancaria_proveedor=?, direccion_proveedor=?, rtn_proveedor=?, telefono_proveedor=?, correo_electronico_proveedor=?, foto_proveedor=? WHERE id_proveedor=? ";

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, proveedor.getId_proveedor());
			ps.setString(2, proveedor.getNombres_proveedor());
			ps.setString(3, proveedor.getCuenta_bancaria_proveedor());
			ps.setString(4, proveedor.getDireccion_proveedor());
			ps.setString(5, proveedor.getRtn_proveedor());
			ps.setString(6, proveedor.getTelefono_proveedor());
			ps.setString(7, proveedor.getCorreo_electronico_proveedor());
			ps.setString(8, proveedor.getFoto_proveedor());
			ps.setInt(9, proveedor.getId_proveedor());
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
