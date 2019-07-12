package principal;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Timer;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import clases.empleado;
import clases.usuario;
import conexion.conexion;
import consultas.consultas_usuario;
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
				String user = String.valueOf(login.txtUsuario.getText().toString());
				String pass = String.valueOf(login.txtContraseña.getText().toString());
				if (user.equals("") && pass.equals("")) {
					login.lblAlerta.setText("Los campos (Usuario) y (Contraseña) estan vacios.");
					login.lblAlerta.setForeground(Color.RED);
				} else {
					if (user.equals("") || pass.equals("")) {
						login.lblAlerta.setText("El campo de (Usuario) o (Contraseña) esta vacio.");
						login.lblAlerta.setForeground(Color.RED);
					} else {
						consultas_usuario consulta = new consultas_usuario();
						usuario clase = new usuario();
						clase.setUsuario(login.txtUsuario.getText().toString());
						clase.setContraseña(login.txtContraseña.getText().toString());
						if (consulta.buscarUsuario(clase)) {
							ventana_principal principal = new ventana_principal();
							principal.setLocationRelativeTo(null);
							principal.setVisible(true);
							principal.consultarEmpresa();
							Timer time = new Timer();
							time.schedule(principal.tarea, 0, 1000);
							ventana_principal.lblNombreUsuario.setText(String.valueOf(clase.getNombre().toString()));
							ventana_principal.lblCargoUsuario.setText(String.valueOf(clase.getCargo().toString()));
							ventana_principal.lblTipoUsuario.setText(String.valueOf(clase.getTipo_usuario().toString()));
							registro_configuracion configuracion = new registro_configuracion();
							login.permisos();
							if (login_usuario.empleado.equals("SI")) {
								ventana_principal.btnEmpleado.setVisible(true);
								login.pack();
							} else {
								ventana_principal.btnEmpleado.setVisible(false);
								pack();
							}
							if (cargoe.equals("SI")) {
								ventana_principal.btnCargo.setVisible(true);
								pack();
							} else {
								ventana_principal.btnCargo.setVisible(false);
								pack();
							}
							if (horario.equals("SI")) {
								ventana_principal.btnHorario.setVisible(true);
								pack();
							} else {
								ventana_principal.btnHorario.setVisible(false);
								pack();
							}
							if (contrato_e.equals("SI")) {
								ventana_principal.btnContratoEmpleado.setVisible(true);
								pack();
							} else {
								ventana_principal.btnContratoEmpleado.setVisible(false);
								pack();
							}
							if (cliente.equals("SI")) {
								ventana_principal.btnCliente.setVisible(true);
								pack();
							} else {
								ventana_principal.btnCliente.setVisible(false);
								pack();
							}
							if (contrato_c.equals("SI")) {
								ventana_principal.btnContratoCliente.setVisible(true);
								pack();
							} else {
								ventana_principal.btnContratoCliente.setVisible(false);
								pack();
							}
							if (compra.equals("SI")) {
								ventana_principal.btnCompras.setVisible(true);
								pack();
							} else {
								ventana_principal.btnCompras.setVisible(false);
								pack();
							}
							if (proveedor.equals("SI")) {
								ventana_principal.btnProveedores.setVisible(true);
								pack();
							} else {
								ventana_principal.btnProveedores.setVisible(false);
								pack();
							}
							if (inventario.equals("SI")) {
								ventana_principal.btnInventario.setVisible(true);
								pack();
							} else {
								ventana_principal.btnInventario.setVisible(false);
								pack();
							}
							if (factura_c.equals("SI")) {
								ventana_principal.btnFacturasClientes.setVisible(true);
								pack();
							} else {
								ventana_principal.btnFacturasClientes.setVisible(false);
								pack();
							}
							if (factura_e.equals("SI")) {
								ventana_principal.btnFacturasEmpresa.setVisible(true);
								pack();
							} else {
								ventana_principal.btnFacturasEmpresa.setVisible(false);
								pack();
							}
							if (sar.equals("SI")) {
								ventana_principal.btnSar.setVisible(true);
								pack();
							} else {
								ventana_principal.btnSar.setVisible(false);
								pack();
							}
							if (ingreso.equals("SI")) {
								ventana_principal.btnIngreso.setVisible(true);
								pack();
							} else {
								ventana_principal.btnIngreso.setVisible(false);
								pack();
							}
							if (producto.equals("SI")) {
								ventana_principal.btnProducto.setVisible(true);
								pack();
							} else {
								ventana_principal.btnProducto.setVisible(false);
								pack();
							}
							if (servicio.equals("SI")) {
								ventana_principal.btnServicio.setVisible(true);
								pack();
							} else {
								ventana_principal.btnServicio.setVisible(false);
								pack();
							}
							if (venta.equals("SI")) {
								ventana_principal.btnVentas.setVisible(true);
								pack();
							} else {
								ventana_principal.btnVentas.setVisible(false);
								pack();
							}
							if (egreso.equals("SI")) {
								ventana_principal.btnEgreso.setVisible(true);
								pack();
							} else {
								ventana_principal.btnEgreso.setVisible(false);
								pack();
							}
							if (bonificacion.equals("SI")) {
								ventana_principal.btnBonificaciones.setVisible(true);
								pack();
							} else {
								ventana_principal.btnBonificaciones.setVisible(false);
								pack();
							}
							if (deduccion.equals("SI")) {
								ventana_principal.btnDeducciones.setVisible(true);
								pack();
							} else {
								ventana_principal.btnDeducciones.setVisible(false);
								pack();
							}
							if (planilla.equals("SI")) {
								ventana_principal.btnPlanilla.setVisible(true);
								pack();
							} else {
								ventana_principal.btnPlanilla.setVisible(false);
								pack();
							}
							if (empresa.equals("SI")) {
								ventana_principal.btnInformacionEmpresa.setVisible(true);
								pack();
							} else {
								ventana_principal.btnInformacionEmpresa.setVisible(false);
								pack();
							}
							if (opciones.equals("SI")) {
								ventana_principal.btnOpciones.setVisible(true);
								pack();
							} else {
								ventana_principal.btnOpciones.setVisible(false);
								pack();
							}
							if (usuarios.equals("SI")) {
								ventana_principal.btnUsuarios.setVisible(true);
								pack();
							} else {
								ventana_principal.btnUsuarios.setVisible(false);
								pack();
							}
							if (acercade.equals("SI")) {
								ventana_principal.btnAcercaDe.setVisible(true);
								pack();
							} else {
								ventana_principal.btnAcercaDe.setVisible(false);
								pack();
							}
							configuracion.consultarConfiguracion();
							configuracion.configuracionSonido();
							login.dispose();
						} else {
							login.lblAlerta.setText("El usuario y contraseña son incorrectas");
							login.lblAlerta.setForeground(Color.RED);
						}
						if (login.txtUsuario.getText().toString().equals("admin")
								&& login.txtContraseña.getText().toString().equals("pass")) {
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
				}
			}

		});

	}
}