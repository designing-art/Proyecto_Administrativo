package consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import clases.deduccion;
import conexion.conexion;

public class cosultas_deduccion extends conexion {
	
	public boolean registrar(deduccion deduccion) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO deducciones (id_deduccion, prestamo_deduccion, adelanto_deduccion, embargo_deduccion, plan_telefonico_deduccion, deduccion_bancaria,cooperativa_deduccion,ihss_deduccion,rap_deduccion,otras_deduccion) VALUES(?,?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, deduccion.getId_Deduccion());
            ps.setDouble(2, deduccion.getPrestamo_localDeduccion());
            ps.setDouble(3, deduccion.getAdelanto_deduccion());
            ps.setDouble(4, deduccion.getEmbargo_deduccion());
            ps.setDouble(5, deduccion.getPlan_telefonicoDeduccion());
            ps.setDouble(6, deduccion.getDeduccion_bancaria());
            ps.setDouble(7, deduccion.getCooperativa_deduccion());
            ps.setDouble(8, deduccion.getRap_deduccion());
            ps.setDouble(9, deduccion.getOtras_deduccion());
            ps.setDouble(9, deduccion.getIhss_deduccion());
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
    
    public boolean modificar(deduccion deduccion) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE deduccion SET id_deduccion=?,prestamo _deduccion=?,adelanto_deduccion=?,  embargo_deduccion=?, plan_telefonico_deduccion=?, deduccion_bancaria=?, cooperativa_deduccion=? ,ihss_deduccion=?, rap_deduccion=?, otras_deduccion=?WHERE id_cargo=? ";

        try {
        	 ps = con.prepareStatement(sql);
        	 ps.setDouble(2, deduccion.getPrestamo_localDeduccion());
             ps.setDouble(3, deduccion.getAdelanto_deduccion());
             ps.setDouble(4, deduccion.getEmbargo_deduccion());
             ps.setDouble(5, deduccion.getPlan_telefonicoDeduccion());
             ps.setDouble(6, deduccion.getDeduccion_bancaria());
             ps.setDouble(7, deduccion.getCooperativa_deduccion());
             ps.setDouble(8, deduccion.getRap_deduccion());
             ps.setDouble(9, deduccion.getOtras_deduccion());
             ps.setDouble(9, deduccion.getIhss_deduccion());
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

    public boolean eliminar(deduccion  deduccion) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM cargos WHERE id_cargo=? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, deduccion.getId_Deduccion());
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
    
    public boolean buscar(deduccion deduccion) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM deduccion WHERE id_deduccion= ? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, deduccion.getId_Deduccion());
            rs = ps.executeQuery();
            
            if(rs.next())
            {
            	
            	deduccion.setId_Deduccion(Integer.parseInt(rs.getString("id_deduccion")));
            	deduccion.setPrestamo_localDeduccion(Double.parseDouble(rs.getString("Prestamo_deduccion")));
            	deduccion.setAdelanto_deduccion(Double.parseDouble(rs.getString("Adelanto_deduccion")));
            	deduccion.setEmbargo_deduccion(Double.parseDouble(rs.getString("Embargo_deduccion")));
            	deduccion.setIhss_deduccion(Double.parseDouble(rs.getString("Ihss_deduccion")));
                deduccion.setRap_deduccion(Double.parseDouble(rs.getString("Rap_deduccion")));
                deduccion.setPlan_telefonicoDeduccion(Double.parseDouble(rs.getString("Plan_telefonico_deduccion")));
                deduccion.setCooperativa_deduccion(Double.parseDouble(rs.getString("Cooperativa_deduccion")));
                deduccion.setDeduccion_bancaria(Double.parseDouble(rs.getString("Deduccion_bancaria")));
            	
            
            	
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
