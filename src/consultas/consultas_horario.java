package consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import clases.cargo;
import clases.horario;
import conexion.conexion;

public class consultas_horario extends conexion {

    public boolean registrar(horario horario) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO cargos (id_horario, horainicio_horario, horafinal_horario, dias_horario, descripcion_horario, observacion_horario) VALUES(?,?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, horario.getId_horario());
            ps.setString(2, horario.getHora_inicio_horario());
            ps.setString(3, horario.getHora_final_horario());
            ps.setString(4, horario.getDias_horario());
            ps.setString(5, horario.getDescripcion_horario());
            ps.setString(6, horario.getObservacion_horario());
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
    
    public boolean modificar(horario horario) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE horarios SET id_horario=?, horainicio_horario=?, horafinal_horario=?, dias_horario=?, descripcion_horario=?, observacion_horario=? WHERE id_horario=? ";

        try {
        	 ps = con.prepareStatement(sql);
             ps.setInt(1, horario.getId_horario());
             ps.setString(2, horario.getHora_inicio_horario());
             ps.setString(3, horario.getHora_final_horario());
             ps.setString(4, horario.getDias_horario());
             ps.setString(5, horario.getDescripcion_horario());
             ps.setString(6, horario.getObservacion_horario());
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

    public boolean eliminar(horario horario) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM horarios WHERE id_horario=? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, horario.getId_horario());
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
    
    public boolean buscar(horario horario) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM horarios WHERE id_horario = ? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, horario.getId_horario());
            rs = ps.executeQuery();
            
            if(rs.next())
            {
            	
            	horario.setId_horario(Integer.parseInt(rs.getString("id_cargo")));
            	horario.setHora_inicio_horario(rs.getString("horainicio_horario"));
            	horario.setHora_final_horario(rs.getString("horafinal_horario"));
            	horario.setDias_horario(rs.getString("dias_horario"));
            	horario.setDescripcion_horario(rs.getString("descripcion_horario"));
            	horario.setObservacion_horario(rs.getString("observacion_horario"));
            	
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
