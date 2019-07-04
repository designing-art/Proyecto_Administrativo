package principal;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import clases.empleado;
import clases.usuario;
import consultas.consultas_usuario;
import formularios.*;

public class television extends JFrame {

	public static void main(String[] args) {
		login_usuario login = new login_usuario();
		login.setLocationRelativeTo(null);
		login.setVisible(true);
		login.btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultas_usuario consulta = new consultas_usuario();
				usuario clase = new usuario();
				clase.setUsuario(login.txtUsuario.getText().toString());
				clase.setContraseña(login.txtContraseña.getText().toString());
				if (consulta.buscarUsuario(clase)) {
					ventana_principal principal = new ventana_principal();
					principal.setLocationRelativeTo(null);
					principal.setVisible(true);
					String permiso = null;
					permiso = String.valueOf(clase.getPermisos().toString());
					if (permiso.equals("Nivel 1 (Dueño)")) {
						ventana_principal.panelClientes.setVisible(true);
						ventana_principal.panelEmpleados.setVisible(true);
						ventana_principal.panelFacturas.setVisible(true);
						ventana_principal.panelFinanzas.setVisible(true);
						ventana_principal.panelInventario.setVisible(true);
						ventana_principal.panelOpciones.setVisible(true);
					} else {
						if (permiso.equals("Nivel 2 (Administrador)")) {
							ventana_principal.panelClientes.setVisible(true);
							ventana_principal.panelEmpleados.setVisible(true);
							ventana_principal.panelFacturas.setVisible(true);
							ventana_principal.panelFinanzas.setVisible(true);
							ventana_principal.panelInventario.setVisible(true);
							ventana_principal.panelOpciones.setVisible(true);
						} else {
							if (permiso.equals("Nivel 3 (Empleado)")) {
								ventana_principal.panelClientes.setVisible(true);
								ventana_principal.panelEmpleados.setVisible(false);
								ventana_principal.panelFacturas.setVisible(true);
								ventana_principal.panelFinanzas.setVisible(false);
								ventana_principal.panelInventario.setVisible(true);
								ventana_principal.panelOpciones.setVisible(false);
								ventana_principal.btnInformacionEmpresa.setVisible(false);
								
							}
						}

					}
					ventana_principal.lblNombreUsuario.setText(String.valueOf(clase.getNombre().toString()));
					ventana_principal.lblCargoUsuario.setText(String.valueOf(clase.getCargo().toString()));
					ventana_principal.lblTipoUsuario.setText(String.valueOf(clase.getTipo_usuario().toString()));
					ventana_principal.lblPermisoUsuario.setText(String.valueOf(clase.getPermisos().toString()));
					principal.consultarEmpresa();
					Timer time = new Timer();
					time.schedule(principal.tarea, 0, 1000);
					registro_configuracion configuracion = new registro_configuracion();
					configuracion.consultarConfiguracion();
					configuracion.configuracionSonido();
					login.dispose();
				} else {
					login.lblAlerta.setText("El usuario y contraseña son incorrectas");
				}
				if (login.txtUsuario.getText().toString().equals("admin")
						&& login.txtContraseña.getText().toString().equals("admin")) {
					ventana_principal principal = new ventana_principal();
					principal.setLocationRelativeTo(null);
					principal.setVisible(true);
					principal.consultarEmpresa();
					Timer time = new Timer();
					time.schedule(principal.tarea, 0, 1000);
					registro_configuracion configuracion = new registro_configuracion();
					configuracion.consultarConfiguracion();
					configuracion.configuracionSonido();
					login.dispose();
				} else {
					login.lblAlerta.setText("El usuario y contraseña son incorrectas");
					login.lblAlerta.setForeground(Color.RED);
				}
			}

		});

	}

}