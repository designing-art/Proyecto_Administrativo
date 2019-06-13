package consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import clases.compra;
import clases.inventario;
import conexion.conexion;

public class consultas_compra extends conexion {

	public boolean insertar(compra compra) {
		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "INSERT INTO compras (nombre_objeto_compra, precio_objeto_compra, descripcion_objeto_compra, peso_objeto_compra, color_objeto_compra, marca_objeto_compra, modelo_objeto_compra, cantidad_objeto_compra, fecha_registro_compra ) VALUES(?,?,?,?,?,?,?,?,?)";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, compra.getNombre_objeto_compra());
			ps.setDouble(2, compra.getPrecio_objeto_compra());
			ps.setString(3, compra.getDescripcion_objeto_compra());
			ps.setString(4, compra.getPeso_objeto_compra());
			ps.setString(5, compra.getColor_objeto_compra());
			ps.setString(6, compra.getMarca_objeto_compra());
			ps.setString(7, compra.getModelo_objeto_compra());
			ps.setInt(8, compra.getCantidad_objeto_compra());
			ps.setString(9, compra.getFecha_registro_compra());
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
	public boolean actualizar(compra compra) {
		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "UPDATE inventario SET id_compra=?, nombre_objeto_compra=?, precio_objeto_compra=?, descripcion_objeto_compra=?, peso_objeto_compra=?, color_objeto_compra=?, marca_objeto_compra=?, modelo_objeto_compra=?, cantidad_objeto_compra=?, existencias_objeto_compra=?, fecha_registro_compra=? WHERE id_compra=? ";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1,compra.getId_compra());
			ps.setString(2, compra.getNombre_objeto_compra());
			ps.setDouble(3, compra.getPrecio_objeto_compra());
			ps.setString(4, compra.getDescripcion_objeto_compra());
			ps.setString(5, compra.getPeso_objeto_compra());
			ps.setString(6, compra.getColor_objeto_compra());
			ps.setString(7, compra.getMarca_objeto_compra());
			ps.setString(8, compra.getModelo_objeto_compra());
			ps.setInt(9, compra.getCantidad_objeto_compra());
			ps.setString(10, compra.getFecha_registro_compra());
			ps.setInt(11, compra.getId_compra());
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
