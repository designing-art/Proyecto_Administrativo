package mantenimiento.television;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import clases.television.cargo;
import conexion.television.conexion;

public class consultas_cargo extends conexion {

    public boolean registrar(cargo cargo) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO cargos (id_cargo, area_cargo, nombre_cargo, valor_hora_extra_cargo, sueldo_cargo, funciones_cargo) VALUES(?,?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cargo.getId_cargo());
            ps.setString(2, cargo.getArea_cargo());
            ps.setString(3, cargo.getNombre_cargo());
            ps.setDouble(4, cargo.getValor_hora_extra_cargo());
            ps.setDouble(5, cargo.getSueldo_cargo());
            ps.setString(6, cargo.getFunciones_cargo());
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
    
    public boolean modificar(cargo cargo) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE cargos SET id_cargo=?, area_cargo=?, nombre_cargo=?,  valor_hora_extra_cargo=?, sueldo_cargo=?, funciones_cargo=? WHERE id_cargo=? ";

        try {
        	 ps = con.prepareStatement(sql);
             ps.setInt(1, cargo.getId_cargo());
             ps.setString(2, cargo.getArea_cargo());
             ps.setString(3, cargo.getNombre_cargo());
             ps.setDouble(4, cargo.getValor_hora_extra_cargo());
             ps.setDouble(5, cargo.getSueldo_cargo());
             ps.setString(6, cargo.getFunciones_cargo());
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

    public boolean eliminar(cargo cargo) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM cargos WHERE id_cargo=? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cargo.getId_cargo());
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
    
    public boolean buscar(cargo cargo) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM cargos WHERE id_cargo = ? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cargo.getId_cargo());
            rs = ps.executeQuery();
            
            if(rs.next())
            {
            	
            	cargo.setId_cargo(Integer.parseInt(rs.getString("id_cargo")));
            	cargo.setArea_cargo(rs.getString("area_cargo"));
            	cargo.setNombre_cargo(rs.getString("nombre_cargo"));
            	cargo.setValor_hora_extra_cargo(Double.parseDouble(rs.getString("valor_hora_extra_cargo")));
            	cargo.setSueldo_cargo(Double.parseDouble(rs.getString("sueldo_cargo")));
            	cargo.setFunciones_cargo(rs.getString("funciones_cargo"));
            	
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