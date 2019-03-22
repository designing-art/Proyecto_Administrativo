package formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Label;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Window.Type;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class ventana_principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventana_principal frame = new ventana_principal();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ventana_principal() {
		setResizable(false);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		final ImageIcon logopeq = new ImageIcon(getClass().getResource("/material/television/logo.png"));
		
		JLabel lblCanalCoffee = new JLabel("CANAL 40 COFFEE TV CHANNEL");
		lblCanalCoffee.setBounds(410, 202, 274, 36);
		lblCanalCoffee.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		contentPane.add(lblCanalCoffee);
		
		JLabel lblEmpresa = new JLabel();
		lblEmpresa.setBounds(448, 236, 201, 186);
		contentPane.add(lblEmpresa);
		final ImageIcon logo = new ImageIcon(getClass().getResource("/material/television/logo.png"));
		final ImageIcon icono = new ImageIcon(logo.getImage().getScaledInstance(lblEmpresa.getWidth(), lblEmpresa.getHeight(), Image.SCALE_DEFAULT));
		lblEmpresa.setIcon(icono);
		
		JLabel lblBienvenidoAlSistema = new JLabel("Bienvenido al Sistema Administrativo.");
		lblBienvenidoAlSistema.setBounds(21, 11, 379, 21);
		lblBienvenidoAlSistema.setForeground(Color.DARK_GRAY);
		lblBienvenidoAlSistema.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		contentPane.add(lblBienvenidoAlSistema);
		
		JLabel lblInformacionEmpresa = new JLabel("\u00BFmas informacion sobre la empresa?");
		lblInformacionEmpresa.setBounds(427, 433, 267, 14);
		lblInformacionEmpresa.setForeground(new Color(0, 128, 0));
		lblInformacionEmpresa.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 11));
		contentPane.add(lblInformacionEmpresa);
		final ImageIcon logo2 = new ImageIcon(getClass().getResource("/material/television/libreta.png"));
		
		JLabel labelfotousuario = new JLabel();
		labelfotousuario.setForeground(Color.LIGHT_GRAY);
		labelfotousuario.setBounds(495, 43, 109, 123);
		contentPane.add(labelfotousuario);
		final ImageIcon logousuario = new ImageIcon(getClass().getResource("/material/television/usuario.png"));
		final ImageIcon iconousuario = new ImageIcon(logousuario.getImage().getScaledInstance(labelfotousuario.getWidth(), labelfotousuario.getHeight(), Image.SCALE_DEFAULT));
		labelfotousuario.setIcon(iconousuario);
		
		JLabel lblUsuario = new JLabel("Usuario :");
		lblUsuario.setForeground(new Color(0, 128, 0));
		lblUsuario.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 11));
		lblUsuario.setBounds(467, 177, 75, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblCargo = new JLabel("Cargo :");
		lblCargo.setForeground(new Color(0, 128, 0));
		lblCargo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 11));
		lblCargo.setBounds(479, 191, 75, 14);
		contentPane.add(lblCargo);
		
		JLabel lblCristianDiaz = new JLabel("Cristian Diaz");
		lblCristianDiaz.setForeground(new Color(0, 128, 0));
		lblCristianDiaz.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 11));
		lblCristianDiaz.setBounds(540, 177, 97, 14);
		contentPane.add(lblCristianDiaz);
		
		JLabel lblDeveloper = new JLabel("Developer");
		lblDeveloper.setForeground(new Color(0, 128, 0));
		lblDeveloper.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 11));
		lblDeveloper.setBounds(552, 191, 83, 14);
		contentPane.add(lblDeveloper);
		
		JButton btnEmpleados = new JButton("Empleados");
		btnEmpleados.setBackground(Color.LIGHT_GRAY);
		btnEmpleados.setForeground(new Color(0, 0, 0));
		btnEmpleados.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		btnEmpleados.setBounds(51, 123, 97, 21);
		contentPane.add(btnEmpleados);
		btnEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registro_mantenimiento_empleados empleados = new registro_mantenimiento_empleados();
				empleados.setVisible(true);
				empleados.setLocationRelativeTo(null);
				dispose();
			}
		});
		
		JLabel lblHora = new JLabel("Hora  :");
		lblHora.setForeground(new Color(0, 0, 0));
		lblHora.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 11));
		lblHora.setBounds(427, 18, 50, 14);
		contentPane.add(lblHora);
		
		JLabel lblFecha = new JLabel("Fecha :");
		lblFecha.setForeground(new Color(0, 0, 0));
		lblFecha.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 11));
		lblFecha.setBounds(529, 18, 63, 14);
		contentPane.add(lblFecha);
		
		JLabel label = new JLabel("00:00");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 11));
		label.setBounds(475, 18, 55, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("00/00/0000");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 11));
		label_1.setBounds(585, 18, 87, 14);
		contentPane.add(label_1);
		
		JLabel lblMenuDeOpciones = new JLabel("Menu de Opciones :");
		lblMenuDeOpciones.setForeground(Color.DARK_GRAY);
		lblMenuDeOpciones.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblMenuDeOpciones.setBounds(146, 83, 145, 14);
		contentPane.add(lblMenuDeOpciones);
		
		JLabel lblEmpleados = new JLabel("Empleados :");
		lblEmpleados.setForeground(new Color(0, 128, 0));
		lblEmpleados.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 11));
		lblEmpleados.setBounds(51, 104, 97, 21);
		contentPane.add(lblEmpleados);
		
		JButton btnCargos = new JButton("Cargos");
		btnCargos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registro_mantenimiento_cargos cargos = new registro_mantenimiento_cargos();
				cargos.setVisible(true);
				cargos.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnCargos.setForeground(Color.BLACK);
		btnCargos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		btnCargos.setBackground(Color.LIGHT_GRAY);
		btnCargos.setBounds(158, 123, 97, 21);
		contentPane.add(btnCargos);
		
		JButton btnPlanillas = new JButton("Planillas");
		btnPlanillas.setForeground(Color.BLACK);
		btnPlanillas.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		btnPlanillas.setBackground(Color.LIGHT_GRAY);
		btnPlanillas.setBounds(158, 170, 97, 21);
		contentPane.add(btnPlanillas);
		
		JButton btnContratos = new JButton("Contratos");
		btnContratos.setForeground(Color.BLACK);
		btnContratos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		btnContratos.setBackground(Color.LIGHT_GRAY);
		btnContratos.setBounds(51, 145, 97, 21);
		contentPane.add(btnContratos);
		
		JButton btnHorarios = new JButton("Horarios");
		btnHorarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registro_mantenimiento_horarios horarios = new registro_mantenimiento_horarios();
				horarios.setVisible(true);
				horarios.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnHorarios.setForeground(Color.BLACK);
		btnHorarios.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		btnHorarios.setBackground(Color.LIGHT_GRAY);
		btnHorarios.setBounds(265, 123, 97, 21);
		contentPane.add(btnHorarios);
		
		JButton btnDeducciones = new JButton("Deducciones");
		btnDeducciones.setForeground(Color.BLACK);
		btnDeducciones.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		btnDeducciones.setBackground(Color.LIGHT_GRAY);
		btnDeducciones.setBounds(265, 145, 97, 21);
		contentPane.add(btnDeducciones);
		
		JButton btnBonificaciones = new JButton("Bonificaciones");
		btnBonificaciones.setForeground(Color.BLACK);
		btnBonificaciones.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		btnBonificaciones.setBackground(Color.LIGHT_GRAY);
		btnBonificaciones.setBounds(158, 145, 97, 21);
		contentPane.add(btnBonificaciones);
		
		JLabel lblClientes = new JLabel("Clientes :");
		lblClientes.setForeground(new Color(0, 128, 0));
		lblClientes.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 11));
		lblClientes.setBounds(51, 190, 97, 21);
		contentPane.add(lblClientes);
		
		JButton btnClientes = new JButton("Clientes");
		btnClientes.setForeground(Color.BLACK);
		btnClientes.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		btnClientes.setBackground(Color.LIGHT_GRAY);
		btnClientes.setBounds(51, 209, 97, 21);
		contentPane.add(btnClientes);
		
		JButton btnServicios = new JButton("Servicios");
		btnServicios.setForeground(Color.BLACK);
		btnServicios.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		btnServicios.setBackground(Color.LIGHT_GRAY);
		btnServicios.setBounds(51, 231, 97, 21);
		contentPane.add(btnServicios);
		
		JButton btnContratos_1 = new JButton("Contratos");
		btnContratos_1.setForeground(Color.BLACK);
		btnContratos_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		btnContratos_1.setBackground(Color.LIGHT_GRAY);
		btnContratos_1.setBounds(158, 209, 97, 21);
		contentPane.add(btnContratos_1);
		
		JButton btnProductos = new JButton("Productos");
		btnProductos.setForeground(Color.BLACK);
		btnProductos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		btnProductos.setBackground(Color.LIGHT_GRAY);
		btnProductos.setBounds(265, 209, 97, 21);
		contentPane.add(btnProductos);
		
		JLabel lblProductosYServicios = new JLabel("Finanzas :");
		lblProductosYServicios.setForeground(new Color(0, 128, 0));
		lblProductosYServicios.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 11));
		lblProductosYServicios.setBounds(51, 251, 174, 21);
		contentPane.add(lblProductosYServicios);
		
		JButton btnIngresos_1 = new JButton("Ingresos");
		btnIngresos_1.setForeground(Color.BLACK);
		btnIngresos_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		btnIngresos_1.setBackground(Color.LIGHT_GRAY);
		btnIngresos_1.setBounds(51, 270, 97, 21);
		contentPane.add(btnIngresos_1);
		
		JButton btnEgresos = new JButton("Egresos");
		btnEgresos.setForeground(Color.BLACK);
		btnEgresos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		btnEgresos.setBackground(Color.LIGHT_GRAY);
		btnEgresos.setBounds(158, 270, 97, 21);
		contentPane.add(btnEgresos);
		
		JLabel lblFacturas = new JLabel("Facturas :");
		lblFacturas.setForeground(new Color(0, 128, 0));
		lblFacturas.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 11));
		lblFacturas.setBounds(51, 291, 97, 21);
		contentPane.add(lblFacturas);
		
		JButton btnIngresos = new JButton("Facturas Clientes");
		btnIngresos.setForeground(Color.BLACK);
		btnIngresos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		btnIngresos.setBackground(Color.LIGHT_GRAY);
		btnIngresos.setBounds(51, 310, 145, 21);
		contentPane.add(btnIngresos);
		
		JButton btnFacturasEmpresa = new JButton("Facturas Empresa");
		btnFacturasEmpresa.setForeground(Color.BLACK);
		btnFacturasEmpresa.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		btnFacturasEmpresa.setBackground(Color.LIGHT_GRAY);
		btnFacturasEmpresa.setBounds(217, 310, 145, 21);
		contentPane.add(btnFacturasEmpresa);
		
		JLabel lblInventario = new JLabel("Inventario :");
		lblInventario.setForeground(new Color(0, 128, 0));
		lblInventario.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 11));
		lblInventario.setBounds(51, 332, 174, 21);
		contentPane.add(lblInventario);
		
		JButton btnInventario = new JButton("Inventario");
		btnInventario.setForeground(Color.BLACK);
		btnInventario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		btnInventario.setBackground(Color.LIGHT_GRAY);
		btnInventario.setBounds(51, 351, 97, 21);
		contentPane.add(btnInventario);
		
		JButton btnProveedores = new JButton("Proveedores");
		btnProveedores.setForeground(Color.BLACK);
		btnProveedores.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		btnProveedores.setBackground(Color.LIGHT_GRAY);
		btnProveedores.setBounds(158, 351, 97, 21);
		contentPane.add(btnProveedores);
		
		JButton btnCompras = new JButton("Compras");
		btnCompras.setForeground(Color.BLACK);
		btnCompras.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		btnCompras.setBackground(Color.LIGHT_GRAY);
		btnCompras.setBounds(265, 351, 97, 21);
		contentPane.add(btnCompras);
		
		JLabel lblReportes = new JLabel("Reportes :");
		lblReportes.setForeground(new Color(0, 128, 0));
		lblReportes.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 11));
		lblReportes.setBounds(168, 383, 87, 21);
		contentPane.add(lblReportes);
		
		JButton btnGenerarReportes = new JButton("Generar Reportes");
		btnGenerarReportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reportes reportes = new reportes();
				reportes.setVisible(true);
				reportes.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnGenerarReportes.setForeground(Color.BLACK);
		btnGenerarReportes.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		btnGenerarReportes.setBackground(Color.LIGHT_GRAY);
		btnGenerarReportes.setBounds(132, 401, 143, 21);
		contentPane.add(btnGenerarReportes);
		
		JLabel lblMenuOpciones = new JLabel();
		lblMenuOpciones.setBounds(21, 43, 371, 417);
		contentPane.add(lblMenuOpciones);
		final ImageIcon icono2 = new ImageIcon(logo2.getImage().getScaledInstance(lblMenuOpciones.getWidth(), lblMenuOpciones.getHeight(), Image.SCALE_DEFAULT));
		lblMenuOpciones.setIcon(icono2);

		
		
	}
}
