package consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import clases.ingreso;
import clases.inventario;
import clases.venta;
import conexion.conexion;

public class consultas_venta extends conexion {

	public boolean insertar(venta venta) {
		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "INSERT INTO ventas (nombre_objeto_venta, descripcion_objeto_venta, peso_objeto_venta, color_objeto_venta, marca_objeto_venta, modelo_objeto_venta, existencia_objeto_venta, cantidad_objeto_venta, precio_compra_venta, precio_venta, fecha_registro_venta ) VALUES(?,?,?,?,?,?,?,?,?,?,?)";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, venta.getNombre_objeto_venta());
			ps.setString(2, venta.getDescripcion_objeto_venta());
			ps.setString(3, venta.getPeso_objeto_venta());
			ps.setString(4, venta.getColor_objeto_venta());
			ps.setString(5, venta.getMarca_objeto_venta());
			ps.setString(6, venta.getModelo_objeto_venta());
			ps.setInt(7, venta.getExistencia_objeto_venta());
			ps.setInt(8, venta.getCantidad_objeto_venta());
			ps.setDouble(9, venta.getPrecio_compra_venta());
			ps.setDouble(10, venta.getPrecio_venta());
			ps.setString(11, venta.getFecha_registro_venta());
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
	public boolean actualizar(venta venta) {
		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "UPDATE ventas SET id_venta=?, nombre_objeto_venta=?, descripcion_objeto_venta=?, peso_objeto_venta=?, color_objeto_venta=?, marca_objeto_venta=?, modelo_objeto_venta=?, existencia_objeto_venta=?, cantidad_objeto_venta=?, precio_compra_venta=?, precio_venta=?, fecha_registro_venta=? WHERE id_venta=? ";

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, venta.getId_venta());
			ps.setString(2, venta.getNombre_objeto_venta());
			ps.setString(3, venta.getDescripcion_objeto_venta());
			ps.setString(4, venta.getPeso_objeto_venta());
			ps.setString(5, venta.getColor_objeto_venta());
			ps.setString(6, venta.getMarca_objeto_venta());
			ps.setString(7, venta.getModelo_objeto_venta());
			ps.setInt(8, venta.getExistencia_objeto_venta());
			ps.setInt(9, venta.getCantidad_objeto_venta());
			ps.setDouble(10, venta.getPrecio_compra_venta());
			ps.setDouble(11, venta.getPrecio_venta());
			ps.setString(12, venta.getFecha_registro_venta());
			ps.setInt(13, venta.getId_venta());
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
	public boolean actualizarInventario(inventario inventario) {
		PreparedStatement ps = null;
		Connection con = getConexion();
		String sql = "UPDATE inventario SET existencias_objeto_inventario=? WHERE id_inventario=? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, inventario.getExistencias_objeto_inventario());
			ps.setInt(2, inventario.getId_inventario());
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
