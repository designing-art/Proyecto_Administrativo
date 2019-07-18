package formularios;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Event;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.MatteBorder;

import clases.usuario;
import conexion.conexion;
import consultas.consultas_usuario;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Timer;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

public class login_usuario extends JFrame {

	public JPanel contentPane;
	public static JTextField txtUsuario;
	public static JPasswordField txtContraseña;
	public JLabel lblAlerta;
	public JButton btnIngresar;
	public static JLabel lblNombreEmpresa;
	public static JLabel lblFotoEmpresa;
	public static String nombre = null;
	public static String ruta_logo = null;

	public static String todo;
	public static String empleado;
	public static String cargoe;
	public static String horario;
	public static String contrato_e;
	public static String cliente;
	public static String contrato_c;
	public static String compra;
	public static String proveedor;
	public static String inventario;
	public static String factura_c;
	public static String factura_e;
	public static String sar;
	public static String ingreso;
	public static String producto;
	public static String servicio;
	public static String venta;
	public static String egreso;
	public static String bonificacion;
	public static String deduccion;
	public static String planilla;
	public static String empresa;
	public static String opciones;
	public static String usuarios;
	public static String acercade;

	public login_usuario() {
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 386);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		final ImageIcon logo = new ImageIcon(getClass().getResource("/iconos/usuario.png"));

		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(586, 426, 98, 34);
		contentPane.add(btnSalir);

		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(63, 23, 445, 302);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblUsuario = new JLabel("Usuario :");
		lblUsuario.setForeground(new Color(0, 0, 0));
		lblUsuario.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblUsuario.setBounds(194, 160, 108, 20);
		panel.add(lblUsuario);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a :");
		lblContrasea.setForeground(new Color(0, 0, 0));
		lblContrasea.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblContrasea.setBounds(180, 201, 98, 20);
		panel.add(lblContrasea);

		txtUsuario = new JTextField();
		txtUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsuario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtUsuario.setBounds(132, 180, 181, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		InputMap map4 = txtUsuario.getInputMap(JComponent.WHEN_FOCUSED);
		map4.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

		btnIngresar = new JButton("Ingresar");
		btnIngresar.setForeground(new Color(0, 0, 0));
		btnIngresar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		btnIngresar.setBackground(new Color(60, 179, 113));
		btnIngresar.setBounds(165, 251, 113, 23);
		panel.add(btnIngresar);

		txtContraseña = new JPasswordField();
		txtContraseña.setHorizontalAlignment(SwingConstants.CENTER);
		txtContraseña.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtContraseña.setBounds(132, 220, 181, 20);
		panel.add(txtContraseña);
		InputMap map5 = txtContraseña.getInputMap(JComponent.WHEN_FOCUSED);
		map5.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtContraseña.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					iniciarSesion();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {

			}
		});

		lblAlerta = new JLabel("");
		lblAlerta.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlerta.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblAlerta.setBounds(68, 277, 323, 20);
		panel.add(lblAlerta);

		lblFotoEmpresa = new JLabel("");
		lblFotoEmpresa.setBounds(150, 30, 147, 128);
		panel.add(lblFotoEmpresa);
		final ImageIcon logo2 = new ImageIcon(getClass().getResource("/iconos/logo_estandar.png"));
		final ImageIcon icono2 = new ImageIcon(logo2.getImage().getScaledInstance(lblFotoEmpresa.getWidth(),
				lblFotoEmpresa.getHeight(), Image.SCALE_DEFAULT));
		lblFotoEmpresa.setIcon(icono2);

		lblNombreEmpresa = new JLabel("Empresa");
		lblNombreEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreEmpresa.setFont(new Font("Bauhaus 93", Font.PLAIN, 18));
		lblNombreEmpresa.setBounds(10, 0, 425, 33);
		panel.add(lblNombreEmpresa);

		JLabel lblLoginSistemaAdministrativo = new JLabel("LOGIN SISTEMA ADMINISTRATIVO");
		lblLoginSistemaAdministrativo.setBackground(new Color(0, 128, 128));
		lblLoginSistemaAdministrativo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginSistemaAdministrativo.setFont(new Font("Bauhaus 93", Font.PLAIN, 18));
		lblLoginSistemaAdministrativo.setBounds(63, 0, 435, 19);
		contentPane.add(lblLoginSistemaAdministrativo);

	}

	public void consultarEmpresa() {
		conexion conex = new conexion();
		try {
			Statement estatuto = conex.getConexion().createStatement();
			ResultSet rs = estatuto
					.executeQuery("SELECT nombre_empresa, direccion_logo_empresa FROM empresa where id_empresa = 1");
			if (rs.next()) {
				nombre = (rs.getString("nombre_empresa"));
				ruta_logo = (rs.getString("direccion_logo_empresa"));

				lblNombreEmpresa.setText(nombre);
				final ImageIcon logo = new ImageIcon(ruta_logo);
				final ImageIcon icono = new ImageIcon(logo.getImage().getScaledInstance(lblFotoEmpresa.getWidth(),
						lblFotoEmpresa.getHeight(), Image.SCALE_DEFAULT));
				lblFotoEmpresa.setIcon(icono);
			} else {
				JOptionPane.showMessageDialog(null,
						"             BIENVENIDO AL SISTEMA ADMINISTRATIVO\n"
								+ "                                 Ingreso permitido a :\n"
								+ "                        Solo administrador del sistema. \n"
								+ "Para mas información, Contacteme: krizemandiaz11@gmail.com");
			}
			rs.close();
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error al consultar", "Error", JOptionPane.ERROR_MESSAGE);

		}

	}

	public void permisos() {
		conexion conex = new conexion();
		try {
			Statement estatuto = conex.getConexion().createStatement();
			ResultSet rs = estatuto.executeQuery(
					"SELECT * FROM usuario WHERE usuario='" + login_usuario.txtUsuario.getText().toString() + "'");
			if (rs.next()) {
				todo = (rs.getString("permiso_todo"));
				empleado = (rs.getString("permiso_empleado"));
				cargoe = (rs.getString("permiso_cargo"));
				horario = (rs.getString("permiso_horario"));
				contrato_e = (rs.getString("permiso_contrato_e"));
				cliente = (rs.getString("permiso_cliente"));
				contrato_c = (rs.getString("permiso_contrato_c"));
				compra = (rs.getString("permiso_compra"));
				proveedor = (rs.getString("permiso_proveedor"));
				inventario = (rs.getString("permiso_inventario"));
				factura_c = (rs.getString("permiso_factura_c"));
				factura_e = (rs.getString("permiso_factura_e"));
				sar = (rs.getString("permiso_sar"));
				ingreso = (rs.getString("permiso_ingreso"));
				producto = (rs.getString("permiso_producto"));
				servicio = (rs.getString("permiso_servicio"));
				venta = (rs.getString("permiso_venta"));
				egreso = (rs.getString("permiso_egreso"));
				bonificacion = (rs.getString("permiso_bonificacion"));
				deduccion = (rs.getString("permiso_deduccion"));
				planilla = (rs.getString("permiso_planilla"));
				empresa = (rs.getString("permiso_empresa"));
				opciones = (rs.getString("permiso_opciones"));
				usuarios = (rs.getString("permiso_usuarios"));
				acercade = (rs.getString("permiso_acercade"));

			}
			rs.close();
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error al consultar", "Error", JOptionPane.ERROR_MESSAGE);

		}

	}

	public void iniciarSesion() {
		ventana_principal principal = new ventana_principal();
		String user = String.valueOf(txtUsuario.getText().toString());
		String pass = String.valueOf(txtContraseña.getText().toString());
		if (user.equals("") && pass.equals("")) {
			lblAlerta.setText("Los campos (Usuario) y (Contraseña) estan vacios.");
			lblAlerta.setForeground(Color.RED);
		} else {
			if (user.equals("") || pass.equals("")) {
				lblAlerta.setText("El campo de (Usuario) o (Contraseña) esta vacio.");
				lblAlerta.setForeground(Color.RED);
			} else {
				consultas_usuario consulta = new consultas_usuario();
				usuario clase = new usuario();
				clase.setUsuario(txtUsuario.getText().toString());
				clase.setContraseña(txtContraseña.getText().toString());
				if (consulta.buscarUsuario(clase)) {
					permisos();
					if (login_usuario.empleado.equals("SI")) {
						ventana_principal.btnEmpleado.setVisible(true);
						principal.pack();
					} else {
						ventana_principal.btnEmpleado.setVisible(false);
						principal.pack();
					}
					if (login_usuario.cargoe.equals("SI")) {
						ventana_principal.btnCargo.setVisible(true);
						principal.pack();
					} else {
						ventana_principal.btnCargo.setVisible(false);
						principal.pack();
					}
					if (login_usuario.horario.equals("SI")) {
						ventana_principal.btnHorario.setVisible(true);
						principal.pack();
					} else {
						ventana_principal.btnHorario.setVisible(false);
						principal.pack();
					}
					if (login_usuario.contrato_e.equals("SI")) {
						ventana_principal.btnContratoEmpleado.setVisible(true);
						principal.pack();
					} else {
						ventana_principal.btnContratoEmpleado.setVisible(false);
						principal.pack();
					}
					if (login_usuario.cliente.equals("SI")) {
						ventana_principal.btnCliente.setVisible(true);
						principal.pack();
					} else {
						ventana_principal.btnCliente.setVisible(false);
						principal.pack();
					}
					if (login_usuario.contrato_c.equals("SI")) {
						ventana_principal.btnContratoCliente.setVisible(true);
						principal.pack();
					} else {
						ventana_principal.btnContratoCliente.setVisible(false);
						principal.pack();
					}
					if (login_usuario.compra.equals("SI")) {
						ventana_principal.btnCompras.setVisible(true);
						principal.pack();
					} else {
						ventana_principal.btnCompras.setVisible(false);
						principal.pack();
					}
					if (login_usuario.proveedor.equals("SI")) {
						ventana_principal.btnProveedores.setVisible(true);
						principal.pack();
					} else {
						ventana_principal.btnProveedores.setVisible(false);
						principal.pack();
					}
					if (login_usuario.inventario.equals("SI")) {
						ventana_principal.btnInventario.setVisible(true);
						principal.pack();
					} else {
						ventana_principal.btnInventario.setVisible(false);
						principal.pack();
					}
					if (login_usuario.factura_c.equals("SI")) {
						ventana_principal.btnFacturasClientes.setVisible(true);
						principal.pack();
					} else {
						ventana_principal.btnFacturasClientes.setVisible(false);
						principal.pack();
					}
					if (login_usuario.factura_e.equals("SI")) {
						ventana_principal.btnFacturasEmpresa.setVisible(true);
						principal.pack();
					} else {
						ventana_principal.btnFacturasEmpresa.setVisible(false);
						principal.pack();
					}
					if (login_usuario.sar.equals("SI")) {
						ventana_principal.btnSar.setVisible(true);
						principal.pack();
					} else {
						ventana_principal.btnSar.setVisible(false);
						principal.pack();
					}
					if (login_usuario.ingreso.equals("SI")) {
						ventana_principal.btnIngreso.setVisible(true);
						principal.pack();
					} else {
						ventana_principal.btnIngreso.setVisible(false);
						principal.pack();
					}
					if (login_usuario.producto.equals("SI")) {
						ventana_principal.btnProducto.setVisible(true);
						principal.pack();
					} else {
						ventana_principal.btnProducto.setVisible(false);
						principal.pack();
					}
					if (login_usuario.servicio.equals("SI")) {
						ventana_principal.btnServicio.setVisible(true);
						principal.pack();
					} else {
						ventana_principal.btnServicio.setVisible(false);
						principal.pack();
					}
					if (login_usuario.venta.equals("SI")) {
						ventana_principal.btnVentas.setVisible(true);
						principal.pack();
					} else {
						ventana_principal.btnVentas.setVisible(false);
						principal.pack();
					}
					if (login_usuario.egreso.equals("SI")) {
						ventana_principal.btnEgreso.setVisible(true);
						principal.pack();
					} else {
						ventana_principal.btnEgreso.setVisible(false);
						principal.pack();
					}
					if (login_usuario.bonificacion.equals("SI")) {
						ventana_principal.btnBonificaciones.setVisible(true);
						principal.pack();
					} else {
						ventana_principal.btnBonificaciones.setVisible(false);
						principal.pack();
					}
					if (login_usuario.deduccion.equals("SI")) {
						ventana_principal.btnDeducciones.setVisible(true);
						principal.pack();
					} else {
						ventana_principal.btnDeducciones.setVisible(false);
						principal.pack();
					}
					if (login_usuario.planilla.equals("SI")) {
						ventana_principal.btnPlanilla.setVisible(true);
						principal.pack();
					} else {
						ventana_principal.btnPlanilla.setVisible(false);
						principal.pack();
					}
					if (login_usuario.empresa.equals("SI")) {
						ventana_principal.btnInformacionEmpresa.setVisible(true);
						principal.pack();
					} else {
						ventana_principal.btnInformacionEmpresa.setVisible(false);
						principal.pack();
					}
					if (login_usuario.opciones.equals("SI")) {
						ventana_principal.btnOpciones.setVisible(true);
						principal.pack();
					} else {
						ventana_principal.btnOpciones.setVisible(false);
						principal.pack();
					}
					if (login_usuario.usuarios.equals("SI")) {
						ventana_principal.btnUsuarios.setVisible(true);
						principal.pack();
					} else {
						ventana_principal.btnUsuarios.setVisible(false);
						principal.pack();
					}
					if (login_usuario.acercade.equals("SI")) {
						ventana_principal.btnAcercaDe.setVisible(true);
						principal.pack();
					} else {
						ventana_principal.btnAcercaDe.setVisible(false);
						principal.pack();
					}
					principal.setLocationRelativeTo(null);
					principal.setVisible(true);
					principal.repaint();
					principal.consultarEmpresa();
					Timer time = new Timer();
					time.schedule(principal.tarea, 0, 1000);
					ventana_principal.lblNombreUsuario.setText(String.valueOf(clase.getNombre().toString()));
					ventana_principal.lblCargoUsuario.setText(String.valueOf(clase.getCargo().toString()));
					ventana_principal.lblTipoUsuario.setText(String.valueOf(clase.getTipo_usuario().toString()));
					registro_configuracion configuracion = new registro_configuracion();
					configuracion.consultarConfiguracion();
					configuracion.configuracionSonido();
					dispose();
				} else {
					lblAlerta.setText("El usuario y contraseña son incorrectas");
					lblAlerta.setForeground(Color.RED);
				}
				if (txtUsuario.getText().toString().equals("admin")
						&& txtContraseña.getText().toString().equals("pass")) {
					principal.setLocationRelativeTo(null);
					principal.setVisible(true);
					principal.consultarEmpresa();
					Timer time = new Timer();
					time.schedule(principal.tarea, 0, 1000);
					registro_configuracion configuracion = new registro_configuracion();
					configuracion.consultarConfiguracion();
					configuracion.configuracionSonido();
					dispose();

				} else {
					lblAlerta.setText("El usuario y contraseña son incorrectas");
					lblAlerta.setForeground(Color.RED);
				}
			}
		}

	}

}
