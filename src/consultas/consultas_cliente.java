package consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import clases.cliente;
import conexion.conexion;

public class consultas_cliente extends conexion {

	public boolean registrar(cliente cliente) {
		PreparedStatement ps = null;
		Connection con = getConexion();
		String sql = "INSERT INTO clientes (nombres_cliente, apellidos_cliente , direccion_cliente, telefono_cliente, correo_cliente, genero_cliente, identidad_cliente, foto_cliente, nombre_empresa_cliente, descripcion_empresa_cliente, direccion_empresa_cliente, rtn_empresa_cliente, telefono_empresa_cliente, correo_empresa_cliente) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, cliente.getNombres_cliente());
			ps.setString(2, cliente.getApellidos_cliente());
			ps.setString(3, cliente.getDireccion_cliente());
			ps.setString(4, cliente.getTelefono_cliente());
			ps.setString(5, cliente.getCorreo_cliente());
			ps.setString(6, cliente.getGenero_cliente());
			ps.setString(7, cliente.getIdentidad_cliente());
			ps.setString(8, cliente.getFoto_cliente());
			ps.setString(9, cliente.getNombre_empresa_cliente());
			ps.setString(10, cliente.getDescripcion_empresa_cliente());
			ps.setString(11, cliente.getDireccion_empresa_cliente());
			ps.setString(12, cliente.getRtn_empresa_cliente());
			ps.setString(13, cliente.getTelefono_empresa_cliente());
			ps.setString(14, cliente.getCorreo_empresa_cliente());
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

	public boolean modificar(cliente cliente) {
		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "UPDATE clientes SET id_cliente=?, nombres_cliente=?, apellidos_cliente=?, direccion_cliente=?, telefono_cliente=?, correo_cliente=?, genero_cliente=?, identidad_cliente=?, foto_cliente=?, nombre_empresa_cliente=?, descripcion_empresa_cliente=?, direccion_empresa_cliente=?, rtn_empresa_cliente=?, telefono_empresa_cliente=?, correo_empresa_cliente=? WHERE id_cliente=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, cliente.getId_cliente());
			ps.setString(2, cliente.getNombres_cliente());
			ps.setString(3, cliente.getApellidos_cliente());
			ps.setString(4, cliente.getDireccion_cliente());
			ps.setString(5, cliente.getTelefono_cliente());
			ps.setString(6, cliente.getCorreo_cliente());
			ps.setString(7, cliente.getGenero_cliente());
			ps.setString(8, cliente.getIdentidad_cliente());
			ps.setString(9, cliente.getFoto_cliente());
			ps.setString(10, cliente.getNombre_empresa_cliente());
			ps.setString(11, cliente.getDescripcion_empresa_cliente());
			ps.setString(12, cliente.getDireccion_empresa_cliente());
			ps.setString(13, cliente.getRtn_empresa_cliente());
			ps.setString(14, cliente.getTelefono_empresa_cliente());
			ps.setString(15, cliente.getCorreo_empresa_cliente());
			ps.setInt(16, cliente.getId_cliente());
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