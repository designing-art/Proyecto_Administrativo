package principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import formularios.*;

public class television extends JFrame {

	public static void main(String[] args) {
		ventana_principal principal = new ventana_principal();
		login_usuario login = new login_usuario();
		login.setLocationRelativeTo(null);
		login.setVisible(true);
		login.consultarEmpresa();
		login.btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.iniciarSesion();
			}
		});

	}
}