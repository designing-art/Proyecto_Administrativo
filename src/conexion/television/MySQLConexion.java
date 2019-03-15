package conexion.television;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class MySQLConexion {
	public static Connection getConexion() {
	Connection con = null;
	try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		String URL = "jdbc:mysql://localhost:3306/television?useSSL=true";
		String USUARIO = "root";
		String PASS = "1234";
		
		con = DriverManager.getConnection(URL, USUARIO, PASS);
		
	} catch (ClassNotFoundException e) {
		System.out.println("Error >> Driver no Instalado!!");
	} catch (SQLException e) {
		System.out.println("Error >> de conexión con la BD");
	}
	return con;
	}

} 

		
	