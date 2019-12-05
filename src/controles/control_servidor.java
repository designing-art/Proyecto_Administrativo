package controles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.JOptionPane;
import clases.configuracion;
import clases.servidor;
import consultas.consultas_configuracion;
import consultas.consultas_servidor;
import formularios.configuracion_servidor;
import formularios.configuraciones;
import formularios.login_usuario;
import formularios.ventana_principal;

public class control_servidor implements ActionListener {

	public static String frase = null;
	public servidor clase;
	public consultas_servidor consulta;
	public configuracion_servidor formulario;

	public control_servidor(servidor clase, consultas_servidor consulta, configuracion_servidor formulario) {
		this.clase = clase;
		this.consulta = consulta;
		this.formulario = formulario;
		this.formulario.btnGuardar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == formulario.btnGuardar) {

			if (formulario.txtDireccionServidor.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Porfavor selecione una forma de trabajo en red.!");
			} else {
				clase.setId_servidor(Integer.parseInt(formulario.txtCodigoServidor.getText().toString()));
				clase.setIp_servidor(formulario.txtDireccionServidor.getText().toString());
				if (consulta.actualizar(clase)) {
					JOptionPane.showMessageDialog(null, "Conexion de servidor actualizada!");
					JOptionPane.showMessageDialog(null, "Es necesario reiniciar el sistema administrativo!");
					System.exit(0);
				} else {
					JOptionPane.showMessageDialog(null, "Error! no actualizado");
				}
			}
		}
	}
}
