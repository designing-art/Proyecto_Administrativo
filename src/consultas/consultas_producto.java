package consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import clases.producto;
import conexion.conexion;

public class consultas_producto extends conexion {

	public boolean insertar(producto producto) {
		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "INSERT INTO productos (dispositivo_de_entrega_producto, marca_producto, capacidad_produto, color_producto, precio_producto, direccion_foto_producto, cantidad_producto, existencia_producto, fecha_registro_producto ) VALUES(?,?,?,?,?,?,?,?,?)";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, producto.getDispositivo_de_entrega_producto());
			ps.setString(2, producto.getMarca_producto());
			ps.setString(3, producto.getCapacidad_produto());
			ps.setString(4, producto.getColor_producto());
			ps.setDouble(5, producto.getPrecio_producto());
			ps.setString(6, producto.getDireccion_foto_producto());
			ps.setInt(7, producto.getCantidad_producto());
			ps.setInt(8, producto.getExistencia_producto());
			ps.setString(9, producto.getFecha_registro_producto());
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

	public boolean insertarEliminacion(producto producto) {
		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "INSERT INTO productos (id_producto, dispositivo_de_entrega_producto, marca_producto, capacidad_produto, color_producto, precio_producto, direccion_foto_producto, cantidad_producto, existencia_producto, fecha_registro_producto ) VALUES(?,?,?,?,?,?,?,?,?,?)";

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, producto.getId_producto());
			ps.setString(1, producto.getDispositivo_de_entrega_producto());
			ps.setString(2, producto.getMarca_producto());
			ps.setString(3, producto.getCapacidad_produto());
			ps.setString(4, producto.getColor_producto());
			ps.setDouble(5, producto.getPrecio_producto());
			ps.setString(6, producto.getDireccion_foto_producto());
			ps.setInt(7, producto.getCantidad_producto());
			ps.setInt(8, producto.getExistencia_producto());
			ps.setString(9, producto.getFecha_registro_producto());
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
	public boolean actualizar(producto producto) {
		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "UPDATE productos SET id_producto=?, dispositivo_de_entrega_producto=?, marca_producto=?, capacidad_produto=?, color_producto=?, precio_producto=?, direccion_foto_producto=?, cantidad_producto=?, existencia_producto=?, fecha_registro_producto=? WHERE id_producto=? ";

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, producto.getId_producto());
			ps.setString(2, producto.getDispositivo_de_entrega_producto());
			ps.setString(3, producto.getMarca_producto());
			ps.setString(4, producto.getCapacidad_produto());
			ps.setString(5, producto.getColor_producto());
			ps.setDouble(6, producto.getPrecio_producto());
			ps.setString(7, producto.getDireccion_foto_producto());
			ps.setInt(8, producto.getCantidad_producto());
			ps.setInt(9, producto.getExistencia_producto());
			ps.setString(10, producto.getFecha_registro_producto());
			ps.setInt(11, producto.getId_producto());
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
