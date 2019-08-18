package consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import clases.factura_empresa;
import conexion.conexion;

public class consultas_factura_empresa extends conexion {

	public boolean insertar(factura_empresa factura_empresa) {
		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "INSERT INTO facturas_compras (fecha_factura, compra_factura, precio_factura, cantidad_factura, descripcion_factura, foto_factura) VALUES(?,?,?,?,?,?)";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, factura_empresa.getFecha_factura());
			ps.setString(2, factura_empresa.getCompra_factura());
			ps.setDouble(3, factura_empresa.getPrecio_factura());
			ps.setString(4, factura_empresa.getCantidad_factura());
			ps.setString(5, factura_empresa.getDescripcion_factura());
			ps.setString(6, factura_empresa.getFoto_factura());
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

	public boolean insertarEliminacion(factura_empresa factura_empresa) {
		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "INSERT INTO facturas_compras (id_factura, fecha_factura, compra_factura, precio_factura, cantidad_factura, descripcion_factura, foto_factura) VALUES(?,?,?,?,?,?,?)";

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, factura_empresa.getId_factura());
			ps.setString(1, factura_empresa.getFecha_factura());
			ps.setString(2, factura_empresa.getCompra_factura());
			ps.setDouble(3, factura_empresa.getPrecio_factura());
			ps.setString(4, factura_empresa.getCantidad_factura());
			ps.setString(5, factura_empresa.getDescripcion_factura());
			ps.setString(6, factura_empresa.getFoto_factura());
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
	public boolean actualizar(factura_empresa factura_empresa) {
		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "UPDATE facturas_compras SET id_factura=?, fecha_factura=?, compra_factura=?, precio_factura=?, cantidad_factura=?, descripcion_factura=?, foto_factura=? WHERE id_factura=? ";

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, factura_empresa.getId_factura());
			ps.setString(2, factura_empresa.getFecha_factura());
			ps.setString(3, factura_empresa.getCompra_factura());
			ps.setDouble(4, factura_empresa.getPrecio_factura());
			ps.setString(5, factura_empresa.getCantidad_factura());
			ps.setString(6, factura_empresa.getDescripcion_factura());
			ps.setString(7, factura_empresa.getFoto_factura());
			ps.setInt(8, factura_empresa.getId_factura());
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
