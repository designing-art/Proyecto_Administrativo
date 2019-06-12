package consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import clases.inventario;
import conexion.conexion;

public class consultas_inventario extends conexion {

	public boolean insertar(inventario inventario) {
		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "INSERT INTO inventario (nombre_objeto_inventario, precio_objeto_inventario, descripcion_objeto_inventario, peso_objeto_inventario, color_objeto_inventario, marca_objeto_inventario, modelo_objeto_inventario, cantidad_objeto_inventario, existencias_objeto_inventario, fecha_registro_inventario ) VALUES(?,?,?,?,?,?,?,?,?,?)";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, inventario.getNombre_objeto_inventario());
			ps.setDouble(2, inventario.getPrecio_objeto_inventario());
			ps.setString(3, inventario.getDescripcion_objeto_inventario());
			ps.setString(4, inventario.getPeso_objeto_inventario());
			ps.setString(5, inventario.getColor_objeto_inventario());
			ps.setString(6, inventario.getMarca_objeto_inventario());
			ps.setString(7, inventario.getModelo_objeto_inventario());
			ps.setInt(8, inventario.getCantidad_objeto_inventario());
			ps.setInt(9, inventario.getExistencias_objeto_inventario());
			ps.setString(10, inventario.getFecha_registro_inventario());
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
	public boolean actualizar(inventario inventario) {
		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "UPDATE inventario SET id_inventario=?, nombre_objeto_inventario=?, precio_objeto_inventario=?, descripcion_objeto_inventario=?, peso_objeto_inventario=?, color_objeto_inventario=?, marca_objeto_inventario=?, modelo_objeto_inventario=?, cantidad_objeto_inventario=?, existencias_objeto_inventario=?, fecha_registro_inventario=? WHERE id_inventario=? ";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, inventario.getId_inventario());
			ps.setString(2, inventario.getNombre_objeto_inventario());
			ps.setDouble(3, inventario.getPrecio_objeto_inventario());
			ps.setString(4, inventario.getDescripcion_objeto_inventario());
			ps.setString(5, inventario.getPeso_objeto_inventario());
			ps.setString(6, inventario.getColor_objeto_inventario());
			ps.setString(7, inventario.getMarca_objeto_inventario());
			ps.setString(8, inventario.getModelo_objeto_inventario());
			ps.setInt(9, inventario.getCantidad_objeto_inventario());
			ps.setInt(10, inventario.getExistencias_objeto_inventario());
			ps.setString(11, inventario.getFecha_registro_inventario());
			ps.setInt(12, inventario.getId_inventario());
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
