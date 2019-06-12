package principal;
import java.util.Timer;
import javax.swing.JFrame;
import formularios.*;

public class television extends JFrame {
	
	public static void main(String[] args) {
		ventana_principal principal = new ventana_principal();
		principal.setLocationRelativeTo(null);
		principal.setVisible(true);
		principal.consultarEmpresa();
		Timer time = new Timer();
		time.schedule(principal.tarea, 0, 1000);
		registro_configuracion configuracion = new registro_configuracion();
		configuracion.consultarConfiguracion();
		configuracion.mostrarConfiguracion();
		configuracion.configuracionSonido();
	}
	
}