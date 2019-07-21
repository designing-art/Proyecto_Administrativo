package controles;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.JOptionPane;
import clases.configuracion;
import consultas.consultas_configuracion;
import formularios.configuraciones;
import formularios.login_usuario;
import formularios.ventana_principal;

public class control_configuracion implements ActionListener {

	public static String frase = null;
	public configuracion clase;
	public consultas_configuracion consulta;
	public configuraciones formulario;
	public ventana_principal formulario2 = new ventana_principal();

	public control_configuracion(configuracion clase, consultas_configuracion consulta, configuraciones formulario) {
		this.clase = clase;
		this.consulta = consulta;
		this.formulario = formulario;
		this.formulario = formulario;
		this.formulario.btnGuardar.addActionListener(this);
		this.formulario.btnActualizar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == formulario.btnGuardar) {

			if (configuraciones.rdbtnActivar.isSelected()) {
				clase.setSonido_configuracion(configuraciones.rdbtnActivar.getText().toString());
			} else {
				clase.setSonido_configuracion(configuraciones.rdbtnDesactivar.getText().toString());
			}

			clase.setFrase_configuracion(configuraciones.txtFrase.getText().toString());

			if (consulta.insertar(clase)) {
				JOptionPane.showMessageDialog(null, "Exito! Configuracion guardada!");
				formulario.dispose();
				ventana_principal principal = new ventana_principal();
				principal.setLocationRelativeTo(null);
				principal.setVisible(true);
				principal.consultarEmpresa();
				login_usuario usuario = new login_usuario();
				usuario.consultarDatosInicioSesionUsuario();
				usuario.establecerDatosInicioSesionUsuario();
				usuario.consultarPermisos();
				usuario.definirPermisos();
				Timer time = new Timer();
				time.schedule(principal.tarea, 0, 1000);
				configuraciones configuracion = new configuraciones();
				configuracion.consultarConfiguracion();
				configuracion.establecerConfiguraciones();
				ventana_principal.txtFrase.setText(configuraciones.txtFrase.getText().toString());
				principal.setTitle("Sesi�n iniciada por: "+login_usuario.nombreCompletoUsuario);
				
			} else {
				JOptionPane.showMessageDialog(null, "Error! datos no registrados");
			}
		}

		if (e.getSource() == formulario.btnActualizar) {

			clase.setId_configuracion(Integer.parseInt(formulario.txtCodigo.getText().toString()));

			if (configuraciones.rdbtnActivar.isSelected()) {
				clase.setSonido_configuracion(configuraciones.rdbtnActivar.getText().toString());
			} else {
				clase.setSonido_configuracion(configuraciones.rdbtnDesactivar.getText().toString());
			}

			clase.setFrase_configuracion(configuraciones.txtFrase.getText().toString());

			if (consulta.actualizar(clase)) {
				JOptionPane.showMessageDialog(null, "Exito Configuracion guardada!");
				formulario.dispose();
				ventana_principal principal = new ventana_principal();
				principal.setLocationRelativeTo(null);
				principal.setVisible(true);
				principal.consultarEmpresa();
				login_usuario usuario = new login_usuario();
				usuario.consultarDatosInicioSesionUsuario();
				usuario.establecerDatosInicioSesionUsuario();
				usuario.consultarPermisos();
				usuario.definirPermisos();
				Timer time = new Timer();
				time.schedule(principal.tarea, 0, 1000);
				configuraciones configuracion = new configuraciones();
				configuracion.consultarConfiguracion();
				configuracion.establecerConfiguraciones();
				ventana_principal.txtFrase.setText(configuraciones.txtFrase.getText().toString());
				principal.setTitle("Sesi�n iniciada por: "+login_usuario.nombreCompletoUsuario);
				
			} else {
				JOptionPane.showMessageDialog(null, "Error! datos no actualizados");
			}
		}
	}

}
