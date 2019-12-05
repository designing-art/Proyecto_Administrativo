package principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

import conexion.conexion;
import formularios.*;

public class television extends JFrame {

	public static void main(String[] args) {
		login_usuario login = new login_usuario();
		login.setLocationRelativeTo(null);
		login.setVisible(true);
		login.consultarEmpresa();
		login.establecerConfiguraciones();
		conexion con = new conexion();
		con.conectarConIPglobal();
		login.btnIngresar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				login.iniciarSesion();
			}
		});
	}
	
	
}