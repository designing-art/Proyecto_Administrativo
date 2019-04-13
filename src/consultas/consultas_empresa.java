package consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import clases.empresa;
import conexion.conexion;

public class consultas_empresa extends conexion {
	
/*Consultas para empresa*/
	
	/*Registrar*/
	public boolean insertar(empresa empresa) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO empresa (nombre_empresa, direccion_empresa, telefono_empresa, rtn_empresa, direccion_logo_empresa, direccion_foto_empresa, correo_empresa, cuenta_bancaria_empresa) VALUES(?,?,?,?,?,?,?,?)";
    	
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, empresa.getNombre_empresa());
            ps.setString(2, empresa.getDireccion_empresa());
            ps.setString(3, empresa.getTelefono_empresa());
            ps.setString(4, empresa.getRtn_empresa());
            ps.setString(5, empresa.getDireccion_logo_empresa());
            ps.setString(6, empresa.getDireccion_foto_empresa());
            ps.setString(7, empresa.getCorreo_empresa());
            ps.setString(8, empresa.getCuenta_bancaria_empresa());
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
	
	/*Actualizar*/  
    public boolean actualizar(empresa empresa) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE empresa SET id_empresa=?, nombre_empresa=?, direccion_empresa=?, telefono_empresa=?, rtn_empresa=?, direccion_logo_empresa=?, direccion_foto_empresa=?, correo_empresa=?, cuenta_bancaria_empresa=? WHERE id_empresa=? ";

        try {
        	 ps = con.prepareStatement(sql);
        	 ps.setInt(1, empresa.getId_empresa());
        	 ps.setString(2, empresa.getNombre_empresa());
             ps.setString(3, empresa.getDireccion_empresa());
             ps.setString(4, empresa.getTelefono_empresa());
             ps.setString(5, empresa.getRtn_empresa());
             ps.setString(6, empresa.getDireccion_logo_empresa());
             ps.setString(7, empresa.getDireccion_foto_empresa());
             ps.setString(8, empresa.getCorreo_empresa());
             ps.setString(9, empresa.getCuenta_bancaria_empresa());
             ps.setInt(10, empresa.getId_empresa());
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
    
    public boolean buscar(empresa empresa) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM empresa WHERE id_empresa = 1 ";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next())
            {
               empresa.setId_empresa( Integer.parseInt(rs.getString("id_empresa")));
               empresa.setNombre_empresa(rs.getString("nombre_empresa"));
               empresa.setDireccion_empresa(rs.getString("direccion_empresa"));
               empresa.setTelefono_empresa(rs.getString("telefono_empresa"));
               empresa.setRtn_empresa(rs.getString("rtn_empresa"));
               empresa.setDireccion_logo_empresa(rs.getString("direccion_logo_empresa"));
               empresa.setDireccion_foto_empresa(rs.getString("direccion_foto_empresa"));
               empresa.setCorreo_empresa(rs.getString("correo_empresa"));
               empresa.setCuenta_bancaria_empresa(rs.getString("cuenta_bancaria_empresa"));
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

