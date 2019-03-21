package mantenimiento.television;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import clases.television.bonificacion;
import conexion.television.conexion;

public class consultas_bonificacion extends conexion {
	
	public boolean registrar(bonificacion bonificacion) {
		
	        PreparedStatement ps = null;
	        Connection con = getConexion();

	        String sql = "INSERT INTO bonificaciones (id_bonificacion, nombres_bonificacion, apellidos_bonificacion, identidad_bonificacion, tipo_bonificacion, cantidad_bonificacion, observacion_bonificacion, total_bonificacion;) VALUES(?,?,?,?,?,?)";

	        try {
	            ps = con.prepareStatement(sql);
	            ps.setInt(1, bonificacion.getId_bonificacion());
	            ps.setString(2, bonificacion.getNombres_bonificacion());
	            ps.setString(3, bonificacion.getApellidos_bonificacion());
	            ps.setString(4, bonificacion.getIdentidad_bonificacion());
	            ps.setString(5, bonificacion.getCantidad_bonificacion());
	            ps.setString(6, bonificacion.getObservacion_bonificacion());
	            ps.setString(7, bonificacion.getTotal_bonificacion());
	            ps.setString(8, bonificacion.getTipo_bonificacion());
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
	    
	    public boolean modificar(bonificacion bonificacion) {
	        PreparedStatement ps = null;
	        Connection con = getConexion();

	        String sql = "UPDATE bonificaciones SET id_bonificacion=?, nombres_bonificacion=?, apellidos_bonificaion=?, identidad_bonificacion=?, cantidad_bonificacion=?, observacion_bonificacion=? total_bonificacion=? tipo_bonificacion=? WHERE id_bonificacion=? ";

	        try {
	        	 ps = con.prepareStatement(sql);
	        	 ps.setInt(1, bonificacion.getId_bonificacion());
		            ps.setString(2, bonificacion.getNombres_bonificacion());
		            ps.setString(3, bonificacion.getApellidos_bonificacion());
		            ps.setString(4, bonificacion.getIdentidad_bonificacion());
		            ps.setString(5, bonificacion.getCantidad_bonificacion());
		            ps.setString(6, bonificacion.getObservacion_bonificacion());
		            ps.setString(7, bonificacion.getTotal_bonificacion());
		            ps.setString(8, bonificacion.getTipo_bonificacion());
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

	    public boolean eliminar(bonificacion horario) {
	        PreparedStatement ps = null;
	        Connection con = getConexion();

	        String sql = "DELETE FROM bonificaciones WHERE id_bonificacion=? ";

	        try {
	            ps = con.prepareStatement(sql);
	            ps.setInt(1, horario.getId_bonificacion());
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
	    
	    public boolean buscar(bonificacion bonificacion) {
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        Connection con = getConexion();

	        String sql = "SELECT * FROM bonificaciones WHERE id_bonificacion = ? ";

	        try {
	            ps = con.prepareStatement(sql);
	            ps.setInt(1, bonificacion.getId_bonificacion());
	            rs = ps.executeQuery();
	            
	            if(rs.next())
	            {
	            	
	            	bonificacion.setId_bonificacion(Integer.parseInt(rs.getString("id_bonificacion")));
	            	bonificacion.setNombres_bonificacion(rs.getString("nombres_bonificacion"));
	            	bonificacion.setApellidos_bonificacion(rs.getString("apellidos_bonificacion"));
	            	bonificacion.setIdentidad_bonificacion(rs.getString("identidad_bonificacion"));
	            	bonificacion.setCantidad_bonificacion(rs.getString("cantidad_bonificacion"));
	            	bonificacion.setObservacion_bonificacion(rs.getString("observacion_bonificacion"));
	            	bonificacion.setTipo_bonificacion(rs.getString("tipo_bonificacion"));
	            	bonificacion.setTotal_bonificacion(rs.getString("total_bonificacion"));
	            	
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


