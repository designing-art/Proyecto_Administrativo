package consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import clases.contrato_empleado;
import clases.empleado;
import conexion.conexion;

public class consultas_contrato_empleado extends conexion {
	/*Consultas para Contratos de los empleados*/
	
	/*Registrar*/
	public boolean insertar(contrato_empleado contrato) {
        PreparedStatement ps = null;
        Connection con = getConexion(); 

        String sql = "INSERT INTO contrato_empleado (tipo_contrato_empleado, tiempo_contrato_empleado, direccion_foto_contrato_empleado) VALUES(?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, contrato.getTipo_contrato_empleado());
            ps.setString(2, contrato.getTiempo_contrato_empleado());
            ps.setString(3, contrato.getDireccion_foto_contrato_empleado());
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
    public boolean actualizar(contrato_empleado contrato) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE contrato_empleado SET id_contrato_empleado=?, tipo_contrato_empleado=?, tiempo_contrato_empleado=?, direccion_foto_contrato_empleado=? WHERE id_contrato_empleado=? ";

        try {
        	 ps = con.prepareStatement(sql);
             ps.setInt(1, contrato.getId_contrato_empleado());
             ps.setString(2, contrato.getTipo_contrato_empleado());
             ps.setString(3, contrato.getTiempo_contrato_empleado());
             ps.setString(4, contrato.getDireccion_foto_contrato_empleado());
             ps.setInt(5, contrato.getId_contrato_empleado());
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
