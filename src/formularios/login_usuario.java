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
import javax.swing.border.LineBorder;

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
	
	public static String nombreCompletoUsuario;
	public static String cargoUsuario;
	public static String tipoUsuario;
	public static String direccionFotoUsuario;
	public static String nombreUsuario;

	public login_usuario() {
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 396, 386);
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
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBackground(Color.WHITE);
		panel.setBounds(31, 27, 327, 302);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblUsuario = new JLabel("Usuario :");
		lblUsuario.setForeground(new Color(0, 0, 0));
		lblUsuario.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblUsuario.setBounds(136, 165, 108, 20);
		panel.add(lblUsuario);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a :");
		lblContrasea.setForeground(new Color(0, 0, 0));
		lblContrasea.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblContrasea.setBounds(122, 206, 98, 20);
		panel.add(lblContrasea);

		txtUsuario = new JTextField();
		txtUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsuario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtUsuario.setBounds(74, 185, 181, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		InputMap map4 = txtUsuario.getInputMap(JComponent.WHEN_FOCUSED);
		map4.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

		btnIngresar = new JButton("Ingresar");
		btnIngresar.setForeground(new Color(0, 0, 0));
		btnIngresar.setFont(new Font("Dubai", Font.BOLD, 14));
		btnIngresar.setBackground(new Color(60, 179, 113));
		btnIngresar.setBounds(107, 253, 113, 20);
		panel.add(btnIngresar);

		txtContraseña = new JPasswordField();
		txtContraseña.setHorizontalAlignment(SwingConstants.CENTER);
		txtContraseña.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtContraseña.setBounds(74, 225, 181, 20);
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
		lblAlerta.setBounds(10, 277, 307, 14);
		panel.add(lblAlerta);
		final ImageIcon logo2 = new ImageIcon(getClass().getResource("/iconos/logo_estandar.png"));

		lblNombreEmpresa = new JLabel("Empresa");
		lblNombreEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreEmpresa.setFont(new Font("Bauhaus 93", Font.PLAIN, 18));
		lblNombreEmpresa.setBounds(10, 0, 303, 33);
		panel.add(lblNombreEmpresa);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(88, 27, 152, 135);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
				lblFotoEmpresa = new JLabel("");
				lblFotoEmpresa.setBounds(10, 11, 132, 113);
				panel_1.add(lblFotoEmpresa);
				final ImageIcon icono2 = new ImageIcon(logo2.getImage().getScaledInstance(lblFotoEmpresa.getWidth(),
						lblFotoEmpresa.getHeight(), Image.SCALE_DEFAULT));
				lblFotoEmpresa.setIcon(icono2);

		JLabel lblLoginSistemaAdministrativo = new JLabel("LOGIN SISTEMA ADMINISTRATIVO");
		lblLoginSistemaAdministrativo.setBackground(new Color(0, 128, 128));
		lblLoginSistemaAdministrativo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginSistemaAdministrativo.setFont(new Font("Bauhaus 93", Font.PLAIN, 18));
		lblLoginSistemaAdministrativo.setBounds(31, 0, 327, 30);
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

	public void consultarPermisos() {
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

	

	public void definirPermisos() {
		if (login_usuario.empleado.equals("SI")) {
			ventana_principal.btnEmpleado.setVisible(true);
		} else {
			ventana_principal.btnEmpleado.setVisible(false);
		}

		if (login_usuario.cargoe.equals("SI")) {
			ventana_principal.btnCargo.setVisible(true);
		} else {
			ventana_principal.btnCargo.setVisible(false);
		}

		if (login_usuario.horario.equals("SI")) {
			ventana_principal.btnHorario.setVisible(true);
		} else {
			ventana_principal.btnHorario.setVisible(false);
		}

		if (login_usuario.contrato_e.equals("SI")) {
			ventana_principal.btnContratoEmpleado.setVisible(true);
		} else {
			ventana_principal.btnContratoEmpleado.setVisible(false);
		}

		if (login_usuario.cliente.equals("SI")) {
			ventana_principal.btnCliente.setVisible(true);
		} else {
			ventana_principal.btnCliente.setVisible(false);
		}

		if (login_usuario.contrato_c.equals("SI")) {
			ventana_principal.btnContratoCliente.setVisible(true);
		} else {
			ventana_principal.btnContratoCliente.setVisible(false);
		}

		if (login_usuario.compra.equals("SI")) {
			ventana_principal.btnCompras.setVisible(true);
		} else {
			ventana_principal.btnCompras.setVisible(false);
		}

		if (login_usuario.proveedor.equals("SI")) {
			ventana_principal.btnProveedores.setVisible(true);
		} else {
			ventana_principal.btnProveedores.setVisible(false);
		}

		if (login_usuario.inventario.equals("SI")) {
			ventana_principal.btnInventario.setVisible(true);
		} else {
			ventana_principal.btnInventario.setVisible(false);
		}

		if (login_usuario.factura_c.equals("SI")) {
			ventana_principal.btnFacturasClientes.setVisible(true);
		} else {
			ventana_principal.btnFacturasClientes.setVisible(false);
		}

		if (login_usuario.factura_e.equals("SI")) {
			ventana_principal.btnFacturasEmpresa.setVisible(true);
		} else {
			ventana_principal.btnFacturasEmpresa.setVisible(false);
		}

		if (login_usuario.sar.equals("SI")) {
			ventana_principal.btnSar.setVisible(true);
		} else {
			ventana_principal.btnSar.setVisible(false);
		}

		if (login_usuario.ingreso.equals("SI")) {
			ventana_principal.btnIngreso.setVisible(true);
		} else {
			ventana_principal.btnIngreso.setVisible(false);
		}

		if (login_usuario.producto.equals("SI")) {
			ventana_principal.btnProducto.setVisible(true);
		} else {
			ventana_principal.btnProducto.setVisible(false);
		}

		if (login_usuario.servicio.equals("SI")) {
			ventana_principal.btnServicio.setVisible(true);
		} else {
			ventana_principal.btnServicio.setVisible(false);
		}

		if (login_usuario.venta.equals("SI")) {
			ventana_principal.btnVentas.setVisible(true);
		} else {
			ventana_principal.btnVentas.setVisible(false);
		}

		if (login_usuario.egreso.equals("SI")) {
			ventana_principal.btnEgreso.setVisible(true);
		} else {
			ventana_principal.btnEgreso.setVisible(false);
		}

		if (login_usuario.bonificacion.equals("SI")) {
			ventana_principal.btnBonificaciones.setVisible(true);
		} else {
			ventana_principal.btnBonificaciones.setVisible(false);
		}

		if (login_usuario.deduccion.equals("SI")) {
			ventana_principal.btnDeducciones.setVisible(true);
		} else {
			ventana_principal.btnDeducciones.setVisible(false);
		}

		if (login_usuario.planilla.equals("SI")) {
			ventana_principal.btnPlanilla.setVisible(true);
		} else {
			ventana_principal.btnPlanilla.setVisible(false);
		}

		if (login_usuario.empresa.equals("SI")) {
			ventana_principal.btnInformacionEmpresa.setVisible(true);
		} else {
			ventana_principal.btnInformacionEmpresa.setVisible(false);

		}
		if (login_usuario.opciones.equals("SI")) {
			ventana_principal.btnOpciones.setVisible(true);
		} else {
			ventana_principal.btnOpciones.setVisible(false);

		}
		if (login_usuario.usuarios.equals("SI")) {
			ventana_principal.btnUsuarios.setVisible(true);
		} else {
			ventana_principal.btnUsuarios.setVisible(false);

		}
		if (login_usuario.acercade.equals("SI")) {
			ventana_principal.btnAcercaDe.setVisible(true);
		} else {
			ventana_principal.btnAcercaDe.setVisible(false);
		}
		
		ventana_principal VENTANA = new ventana_principal();
		VENTANA.pack();
	}
	
	public void consultarDatosInicioSesionUsuario() {
		conexion conex = new conexion();
		try {
			Statement estatuto = conex.getConexion().createStatement();
			ResultSet rs = estatuto.executeQuery(
					"SELECT * FROM usuario WHERE usuario='" + login_usuario.txtUsuario.getText().toString() + "'");
			if (rs.next()) {
				nombreCompletoUsuario = (rs.getString("nombre"));
				cargoUsuario = (rs.getString("cargo"));
				tipoUsuario = (rs.getString("tipo_usuario"));
				direccionFotoUsuario = (rs.getString("direccion_foto_usuario"));
				nombreUsuario = (rs.getString("usuario"));
			}
			rs.close();
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error al consultar", "Error", JOptionPane.ERROR_MESSAGE);

		}

	}
	
	public void establecerDatosInicioSesionUsuario() {
		ventana_principal.lblNombreUsuario.setText(nombreCompletoUsuario);
		ventana_principal.lblCargoUsuario.setText(cargoUsuario);
		ventana_principal.lblTipoUsuario.setText(tipoUsuario);
		final ImageIcon icono = new ImageIcon(direccionFotoUsuario);
		final ImageIcon iconofoto = new ImageIcon(icono.getImage().getScaledInstance(
				ventana_principal.labelfotousuario.getWidth(),
				ventana_principal.labelfotousuario.getHeight(), Image.SCALE_DEFAULT));
		ventana_principal.labelfotousuario.setIcon(iconofoto);
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
					principal.setLocationRelativeTo(null);
					principal.setVisible(true);
					principal.consultarEmpresa();
					principal.consultarSAR();
					consultarDatosInicioSesionUsuario();
					establecerDatosInicioSesionUsuario();
					consultarPermisos();
					definirPermisos();
					principal.setTitle("Sesión iniciada por: "+nombreCompletoUsuario);
					Timer time = new Timer();
					time.schedule(principal.tarea, 0, 1000);
					configuraciones configuracion = new configuraciones();
					configuracion.consultarConfiguracion();
					configuracion.establecerConfiguraciones();
					dispose();
				} else {
					lblAlerta.setText("El usuario y contraseña son incorrectas");
					lblAlerta.setForeground(Color.RED);
				}
			}
		}

	}
}
