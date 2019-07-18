package consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import clases.empleado;
import clases.usuario;
import conexion.conexion;

public class consultas_usuario extends conexion {
	public boolean insertar(usuario usuario) {
		PreparedStatement ps = null;
		Connection con = getConexion();
		String sql = "INSERT INTO usuario (usuario, contraseña, identidad, nombre, cargo, tipo_usuario, permiso_todo, permiso_empleado, permiso_cargo, permiso_horario, permiso_contrato_e, permiso_cliente, permiso_contrato_c, permiso_compra, permiso_proveedor, permiso_inventario, permiso_factura_c, permiso_factura_e, permiso_sar, permiso_ingreso, permiso_producto, permiso_servicio, permiso_venta, permiso_egreso, permiso_bonificacion, permiso_deduccion, permiso_planilla, permiso_empresa, permiso_opciones, permiso_usuarios, permiso_acercade) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, usuario.getUsuario());
			ps.setString(2, usuario.getContraseña());
			ps.setString(3, usuario.getIdentidad());
			ps.setString(4, usuario.getNombre());
			ps.setString(5, usuario.getCargo());
			ps.setString(6, usuario.getTipo_usuario());
			ps.setString(7, usuario.getPermiso_todo());
			ps.setString(8, usuario.getPermiso_empleado());
			ps.setString(9, usuario.getPermiso_cargo());
			ps.setString(10, usuario.getPermiso_cargo());
			ps.setString(11, usuario.getPermiso_contrato_e());
			ps.setString(12, usuario.getPermiso_cliente());
			ps.setString(13, usuario.getPermiso_contrato_c());
			ps.setString(14, usuario.getPermiso_compra());
			ps.setString(15, usuario.getPermiso_proveedor());
			ps.setString(16, usuario.getPermiso_inventario());
			ps.setString(17, usuario.getPermiso_factura_c());
			ps.setString(18, usuario.getPermiso_factura_e());
			ps.setString(19, usuario.getPermiso_sar());
			ps.setString(20, usuario.getPermiso_ingreso());
			ps.setString(21, usuario.getPermiso_producto());
			ps.setString(22, usuario.getPermiso_servicio());
			ps.setString(23, usuario.getPermiso_venta());
			ps.setString(24, usuario.getPermiso_egreso());
			ps.setString(25, usuario.getPermiso_bonificacion());
			ps.setString(26, usuario.getPermiso_deduccion());
			ps.setString(27, usuario.getPermiso_planilla());
			ps.setString(28, usuario.getPermiso_empresa());
			ps.setString(29, usuario.getPermiso_opciones());
			ps.setString(30, usuario.getPermiso_usuarios());
			ps.setString(31, usuario.getPermiso_acercade());
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
	public boolean actualizar(usuario usuario) {
		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "UPDATE usuario SET id_usuario=?, usuario=?, contraseña=?, identidad=?, nombre=?, cargo=?, tipo_usuario=?, permiso_todo=?, permiso_empleado=?, permiso_cargo=?, permiso_horario=?, permiso_contrato_e=?, permiso_cliente=?, permiso_contrato_c=?, permiso_compra=?, permiso_proveedor=?, permiso_inventario=?, permiso_factura_c=?, permiso_factura_e=?, permiso_sar=?, permiso_ingreso=?, permiso_producto=?, permiso_servicio=?, permiso_venta=?, permiso_egreso=?, permiso_bonificacion=?, permiso_deduccion=?, permiso_planilla=?, permiso_empresa=?, permiso_opciones=?, permiso_usuarios=?, permiso_acercade=? WHERE id_usuario=? ";
			
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, usuario.getId_usuario());
			ps.setString(2, usuario.getUsuario());
			ps.setString(3, usuario.getContraseña());
			ps.setString(4, usuario.getIdentidad());
			ps.setString(5, usuario.getNombre());
			ps.setString(6, usuario.getCargo());
			ps.setString(7, usuario.getTipo_usuario());
			ps.setString(8, usuario.getPermiso_todo());
			ps.setString(9, usuario.getPermiso_empleado());
			ps.setString(10, usuario.getPermiso_cargo());
			ps.setString(11, usuario.getPermiso_horario());
			ps.setString(12, usuario.getPermiso_contrato_e());
			ps.setString(13, usuario.getPermiso_cliente());
			ps.setString(14, usuario.getPermiso_contrato_c());
			ps.setString(15, usuario.getPermiso_compra());
			ps.setString(16, usuario.getPermiso_proveedor());
			ps.setString(17, usuario.getPermiso_inventario());
			ps.setString(18, usuario.getPermiso_factura_c());
			ps.setString(19, usuario.getPermiso_factura_e());
			ps.setString(20, usuario.getPermiso_sar());
			ps.setString(21, usuario.getPermiso_ingreso());
			ps.setString(22, usuario.getPermiso_producto());
			ps.setString(23, usuario.getPermiso_servicio());
			ps.setString(24, usuario.getPermiso_venta());
			ps.setString(25, usuario.getPermiso_egreso());
			ps.setString(26, usuario.getPermiso_bonificacion());
			ps.setString(27, usuario.getPermiso_deduccion());
			ps.setString(28, usuario.getPermiso_planilla());
			ps.setString(29, usuario.getPermiso_empresa());
			ps.setString(30, usuario.getPermiso_opciones());
			ps.setString(31, usuario.getPermiso_usuarios());
			ps.setString(32, usuario.getPermiso_acercade());
			ps.setInt(33, usuario.getId_usuario());
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
	
	public boolean buscar(empleado empleado) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConexion();

		String sql = "SELECT nombres_empleado, apellidos_empleado, identidad_empleado, nombre_cargo_empleado FROM empleados WHERE identidad_empleado = ? ";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, empleado.getIdentidad_empleado());
			rs = ps.executeQuery();

			if (rs.next()) {
				empleado.setNombres_empleado(rs.getString("nombres_empleado"));
				empleado.setApellidos_empleado(rs.getString("apellidos_empleado"));
				empleado.setIdentidad_empleado(rs.getString("identidad_empleado"));
				empleado.setNombre_cargo_empleado(rs.getString("nombre_cargo_empleado"));
				return true;
			}
			return false;
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
	
	public boolean buscarUsuario(usuario usuario) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConexion();

		String sql = "SELECT * FROM usuario WHERE usuario=? and contraseña =?";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, usuario.getUsuario());
			ps.setString(2, usuario.getContraseña());
			rs = ps.executeQuery();

			if (rs.next()) {
				usuario.setNombre(rs.getString("nombre"));
				usuario.setCargo(rs.getString("cargo"));
				usuario.setTipo_usuario(rs.getString("tipo_usuario"));
				usuario.setPermiso_todo(rs.getString("permiso_todo"));
				usuario.setPermiso_empleado(rs.getString("permiso_empleado"));
				usuario.setPermiso_cargo(rs.getString("permiso_cargo"));
				usuario.setPermiso_horario(rs.getString("permiso_horario"));
				usuario.setPermiso_contrato_e(rs.getString("permiso_contrato_e"));
				usuario.setPermiso_cliente(rs.getString("permiso_cliente"));
				usuario.setPermiso_contrato_c(rs.getString("permiso_contrato_c"));
				usuario.setPermiso_compra(rs.getString("permiso_compra"));
				usuario.setPermiso_proveedor(rs.getString("permiso_proveedor"));
				usuario.setPermiso_inventario(rs.getString("permiso_inventario"));
				usuario.setPermiso_factura_c(rs.getString("permiso_factura_c"));
				usuario.setPermiso_factura_e(rs.getString("permiso_factura_e"));
				usuario.setPermiso_sar(rs.getString("permiso_sar"));
				usuario.setPermiso_ingreso(rs.getString("permiso_ingreso"));
				usuario.setPermiso_producto(rs.getString("permiso_producto"));
				usuario.setPermiso_servicio(rs.getString("permiso_servicio"));
				usuario.setPermiso_venta(rs.getString("permiso_venta"));
				usuario.setPermiso_egreso(rs.getString("permiso_egreso"));
				usuario.setPermiso_bonificacion(rs.getString("permiso_bonificacion"));
				usuario.setPermiso_deduccion(rs.getString("permiso_deduccion"));
				usuario.setPermiso_planilla(rs.getString("permiso_planilla"));
				usuario.setPermiso_empresa(rs.getString("permiso_empresa"));
				usuario.setPermiso_opciones(rs.getString("permiso_opciones"));
				usuario.setPermiso_usuarios(rs.getString("permiso_usuarios"));
				usuario.setPermiso_acercade(rs.getString("permiso_acercade"));
				return true;
			}
			return false;
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
