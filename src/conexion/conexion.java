package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import formularios.login_usuario;

public class conexion {

	private final String base = "television?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private final String user = "root";
	private final String password = "1234";
	public static String urlGlobal = login_usuario.txtIPservidor.getText().toString();
	private final String url = "jdbc:mysql://" + urlGlobal + "/" + base;
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

	public void conectarConIPglobal() {
		try {
			Statement estatuto = getConexion().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT ip_servidor FROM servidor WHERE id_servidor = 1");

			if (rs.next()) {
				String ipServidor = (rs.getString("ip_servidor"));
				login_usuario.txtIPservidor.setText(ipServidor);
			}
			rs.close();
			estatuto.close();
		} catch (

		SQLException exx) {
			System.out.println(exx.getMessage());
			JOptionPane.showMessageDialog(null, "Error al consultar", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
