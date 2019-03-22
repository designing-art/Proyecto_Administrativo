package consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import clases.empleado;
import conexion.conexion;

public class consultas_empleado extends conexion {

    public boolean registrar(empleado empleado) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO empleados (id_empleado, nombres_empleado, apellidos_empleado , identidad_empleado, genero_empleado, edad_empleado, telefono1_empleado, telefono2_empleado, correo_empleado, direccion_empleado, foto_empleado, referencia_empleado, telefono_referencia, fecha_nacimiento_empleado, fecha_registro_empleado, fecha_inicio_labores_empleado, estado_empleado) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, empleado.getId_empleado());
            ps.setString(2, empleado.getNombres_empleado());
            ps.setString(3, empleado.getApellidos_empleado());
            ps.setString(4, empleado.getIdentidad_empleado());
            ps.setString(5, empleado.getGenero_empleado());
            ps.setInt(6, empleado.getEdad_empleado());
            ps.setString(7, empleado.getTelefono1_empleado());
            ps.setString(8, empleado.getTelefono2_empleado());
            ps.setString(9, empleado.getCorreo_empleado());
            ps.setString(10, empleado.getDireccion_empleado());
            ps.setString(11, empleado.getReferencia_empleado());
            ps.setString(12, empleado.getTelefono_referencia());
            ps.setString(13, empleado.getFecha_nacimiento_empleado());
            ps.setString(14, empleado.getFecha_registro_empleado());
            ps.setString(15, empleado.getFecha_inicio_labores_empleado());
            ps.setString(16, empleado.getEstado_empleado());
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
    
    public boolean modificar(empleado empleado) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE empleados SET id_empleado=?, nombres_empleado=?, apellidos_empleado=?, identidad_empleado=?, genero_empleado=?, edad_empleado=?, telefono1_empleado=?, telefono2_empleado=?, correo_empleado=?, direccion_empleado=?, foto_empleado=?, referencia_empleado=?, telefono_referencia=?, fecha_nacimiento_empleado=?, fecha_registro_empleado=?, fecha_inicio_labores_empleado=?, estado_empleado=? WHERE id_empleados=? ";

        try {
        	ps = con.prepareStatement(sql);
            ps.setInt(1, empleado.getId_empleado());
            ps.setString(2, empleado.getNombres_empleado());
            ps.setString(3, empleado.getApellidos_empleado());
            ps.setString(4, empleado.getIdentidad_empleado());
            ps.setString(5, empleado.getGenero_empleado());
            ps.setInt(6, empleado.getEdad_empleado());
            ps.setString(7, empleado.getTelefono1_empleado());
            ps.setString(8, empleado.getTelefono2_empleado());
            ps.setString(9, empleado.getCorreo_empleado());
            ps.setString(10, empleado.getDireccion_empleado());
            ps.setInt(11, empleado.getFoto_empleado());
            ps.setString(12, empleado.getReferencia_empleado());
            ps.setString(13, empleado.getTelefono_referencia());
            ps.setString(14, empleado.getFecha_nacimiento_empleado());
            ps.setString(15, empleado.getFecha_registro_empleado());
            ps.setString(16, empleado.getFecha_inicio_labores_empleado());
            ps.setString(17, empleado.getEstado_empleado());
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

    public boolean eliminar(empleado empleado) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM empleados WHERE id_empleado=? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, empleado.getId_empleado());
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

        String sql = "SELECT * FROM empleados WHERE id_empleado=? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, empleado.getId_empleado());
            rs = ps.executeQuery();
            
            if(rs.next())
            {
            	
            	empleado.setId_empleado(Integer.parseInt(rs.getString("id_empleado")));
            	empleado.setNombres_empleado(rs.getString("nombres_empleado"));
            	empleado.setApellidos_empleado(rs.getString("apellidos_empleado"));
            	empleado.setIdentidad_empleado(rs.getString("identidad_empleado"));
            	empleado.setGenero_empleado(rs.getString("genero_empleado"));
            	empleado.setEdad_empleado(Integer.parseInt(rs.getString("edad_empleado")));
            	empleado.setTelefono1_empleado(rs.getString("telefono1_empleado"));
            	empleado.setTelefono2_empleado(rs.getString("telefono2_empleado"));
            	empleado.setCorreo_empleado(rs.getString("correo_empleado"));
            	empleado.setDireccion_empleado(rs.getString("direccion_empleado"));
            	empleado.setReferencia_empleado(rs.getString("referencia_empleado"));
            	empleado.setTelefono_referencia(rs.getString("telefono_referencia"));
            	empleado.setFecha_nacimiento_empleado(rs.getString("fecha_nacimiento_empleado"));
            	empleado.setFecha_registro_empleado(rs.getString("fecha_registro_empleado"));
            	empleado.setFecha_inicio_labores_empleado(rs.getString("fecha_inicio_labores_empleado"));
            	empleado.setEstado_empleado(rs.getString("estado_empleado"));
            	
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