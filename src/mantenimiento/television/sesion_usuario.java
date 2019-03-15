package mantenimiento.television;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import clases.television.usuarios;
import conexion.television.MySQLConexion;

public class sesion_usuario {
	

public usuarios obtenerUsuario(usuarios usu){
	
	usuarios usuario = null;
	Connection conexion = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	try {
	
		conexion = MySQLConexion.getConexion();
		String sql = "select * from usuario where usuario = ? and contraseña =  ? ";
		
		pst = conexion.prepareStatement(sql);
		pst.setString(1, usu.getUsuario());
		pst.setString(2, usu.getContraseña());
		rs = pst.executeQuery();
		
		while (rs.next()) {
			usuario = new usuarios(rs.getString(1), rs.getString(2));
		}
		
	} catch (Exception e) {
	System.out.println("Error en obtener usuario");
	}
	
	
	return usuario;
	
}
	

}