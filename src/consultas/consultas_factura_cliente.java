package consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import clases.factura_cliente;
import clases.sar;
import conexion.conexion;

public class consultas_factura_cliente extends conexion {

	public boolean insertar(factura_cliente factura_cliente) {
		PreparedStatement ps = null;
		Connection con = getConexion();
		
		String sql = "INSERT INTO facturas_clientes (numero_factura_cliente, fecha_hora_factura_cliente, firma_cliente, rtn_factura_cliente, direccion_cliente, por_concepto_cliente, cantidad_letras_cliente, cantidad_pagada_cliente, empleado_atencion_cliente) VALUES(?,?,?,?,?,?,?,?,?)";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, factura_cliente.getNumero_factura_cliente());
			ps.setString(2, factura_cliente.getFecha_hora_factura_cliente());
			ps.setString(3, factura_cliente.getFirma_cliente());
			ps.setString(4, factura_cliente.getRtn_factura_cliente());
			ps.setString(5, factura_cliente.getDireccion_cliente());
			ps.setString(6, factura_cliente.getPor_concepto_cliente());
			ps.setString(7, factura_cliente.getCantidad_letras_cliente());
			ps.setDouble(8, factura_cliente.getCantidad_pagada_cliente());
			ps.setString(9, factura_cliente.getEmpleado_atencion_cliente());
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
	public boolean actualizar(factura_cliente factura_cliente) {
		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "UPDATE facturas_clientes SET id_facturas_cliente=?, numero_factura_cliente=?, fecha_hora_factura_cliente=?, firma_cliente=?, rtn_factura_cliente=?, direccion_cliente=?, por_concepto_cliente=?, cantidad_letras_cliente=?, cantidad_pagada_cliente=?, empleado_atencion_cliente=? WHERE id_facturas_cliente=? ";

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, factura_cliente.getId_facturas_cliente());
			ps.setString(2, factura_cliente.getNumero_factura_cliente());
			ps.setString(3, factura_cliente.getFecha_hora_factura_cliente());
			ps.setString(4, factura_cliente.getFirma_cliente());
			ps.setString(5, factura_cliente.getRtn_factura_cliente());
			ps.setString(6, factura_cliente.getDireccion_cliente());
			ps.setString(7, factura_cliente.getPor_concepto_cliente());
			ps.setString(8, factura_cliente.getCantidad_letras_cliente());
			ps.setDouble(9, factura_cliente.getCantidad_pagada_cliente());
			ps.setString(10, factura_cliente.getEmpleado_atencion_cliente());
			ps.setInt(11, factura_cliente.getId_facturas_cliente());
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
		public boolean actualizarDatosSAR(sar sar) {
			PreparedStatement ps = null;
			Connection con = getConexion();
			String sql = "UPDATE sar SET factura_actual_sar=? WHERE id_sar=? ";
			try {
				ps = con.prepareStatement(sql);
				ps.setInt(1, sar.getFactura_actual_sar());
				ps.setInt(2, sar.getId_sar());
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
