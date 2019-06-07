
package principal;

import java.io.FileNotFoundException;
import java.util.Timer;
import javax.swing.JFrame;
import formularios.*;
import javazoom.jl.decoder.JavaLayerException;

public class television extends JFrame {

	public static void main(String[] args) throws FileNotFoundException, JavaLayerException {
		ventana_principal principal = new ventana_principal();
		registro_empresa empresa = new registro_empresa();
		principal.setLocationRelativeTo(null);
		principal.setVisible(true);
		Timer time = new Timer();
		time.schedule(principal.tarea, 0, 1000);
		principal.consultarEmpresa();
		principal.vozBienvenido();
	}
}