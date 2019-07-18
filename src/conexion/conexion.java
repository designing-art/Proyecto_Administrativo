package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class conexion {

	private final String base = "television";
	private final String user = "root";
	private final String password = "1234";
	private final String url = "jdbc:mysql://localhost:3306/"+base;
	private Connection con = null;

	public Connection getConexion() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(this.url, this.user, this.password);

		} catch (SQLException e) {
			System.err.println(e);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
		}
		return con;
	}

	public void desconectar() {
		con = null;

	}

}
