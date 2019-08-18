package consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import clases.ingreso;
import clases.producto;
import clases.servicio;
import conexion.conexion;

public class consultas_servicio extends conexion {

	public boolean insertar(servicio servicio) {
		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "INSERT INTO servicios (tipo_servicio, tiempo_servicio, precio_servicio, descripcion_servicio, producto_servicio) VALUES(?,?,?,?,?)";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, servicio.getTipo_servicio());
			ps.setString(2, servicio.getTiempo_servicio());
			ps.setDouble(3, servicio.getPrecio_servicio());
			ps.setString(4, servicio.getDescripcion_servicio());
			ps.setString(5, servicio.getProducto_servicio());
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

	public boolean insertarEliminacion(servicio servicio) {
		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "INSERT INTO servicios (id_servicio, tipo_servicio, tiempo_servicio, precio_servicio, descripcion_servicio, producto_servicio) VALUES(?,?,?,?,?,?)";

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, servicio.getId_servicio());
			ps.setString(2, servicio.getTipo_servicio());
			ps.setString(3, servicio.getTiempo_servicio());
			ps.setDouble(4, servicio.getPrecio_servicio());
			ps.setString(5, servicio.getDescripcion_servicio());
			ps.setString(6, servicio.getProducto_servicio());
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
	public boolean actualizar(servicio servicio) {
		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "UPDATE servicios SET id_servicio=?, tipo_servicio=?, tiempo_servicio=?, precio_servicio=?, descripcion_servicio=?, producto_servicio=? WHERE id_servicio=? ";

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, servicio.getId_servicio());
			ps.setString(2, servicio.getTipo_servicio());
			ps.setString(3, servicio.getTiempo_servicio());
			ps.setDouble(4, servicio.getPrecio_servicio());
			ps.setString(5, servicio.getDescripcion_servicio());
			ps.setString(6, servicio.getProducto_servicio());
			ps.setInt(7, servicio.getId_servicio());
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

	public boolean actualizarInventarioProductos(producto producto) {
		PreparedStatement ps = null;
		Connection con = getConexion();
		String sql = "UPDATE productos SET existencia_producto=? WHERE id_producto=? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, producto.getExistencia_producto());
			ps.setInt(2, producto.getId_producto());
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

	public boolean insertarIngreso(ingreso ingreso) {
		PreparedStatement ps = null;
		Connection con = getConexion();
		String sql = "INSERT INTO ingresos (tipo_ingreso, cantidad_ingreso, descripcion_ingreso, fecha_ingreso) VALUES(?,?,?,?)";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, ingreso.getTipo_ingreso());
			ps.setDouble(2, ingreso.getCantidad_ingreso());
			ps.setString(3, ingreso.getDescripcion_ingreso());
			ps.setString(4, ingreso.getFecha_ingreso());
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
