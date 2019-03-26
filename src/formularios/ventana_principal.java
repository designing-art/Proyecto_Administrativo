package formularios;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

import clases.cargo;
import consultas.consultas_cargo;
import controles.control_cargo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ventana_principal extends JFrame {

	private JPanel contentPane;
	
	public JButton registroPlanilla;
	public JButton registroContrato;
	public JButton registroEmpleado;
	public JButton registroCargo;
	public JButton registroDeduccion;
	public JButton registroBonificacion;
	public JButton registroHorario;


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
		final ImageIcon logopeq = new ImageIcon(getClass().getResource("/material/logo.png"));
		
		JLabel lblCanalCoffee = new JLabel("CANAL 40 COFFEE TV CHANNEL");
		lblCanalCoffee.setBounds(410, 202, 274, 36);
		lblCanalCoffee.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		contentPane.add(lblCanalCoffee);
		
		JLabel lblEmpresa = new JLabel();
		lblEmpresa.setBounds(448, 236, 201, 186);
		contentPane.add(lblEmpresa);
		final ImageIcon logo = new ImageIcon(getClass().getResource("/material/logo.png"));
		final ImageIcon icono = new ImageIcon(logo.getImage().getScaledInstance(lblEmpresa.getWidth(), lblEmpresa.getHeight(), Image.SCALE_DEFAULT));
		lblEmpresa.setIcon(icono);
		
		JLabel lblBienvenidoAlSistema = new JLabel("Bienvenido al Sistema Administrativo.");
		lblBienvenidoAlSistema.setBounds(21, 0, 379, 32);
		lblBienvenidoAlSistema.setForeground(Color.DARK_GRAY);
		lblBienvenidoAlSistema.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		contentPane.add(lblBienvenidoAlSistema);
		
		JLabel lblInformacionEmpresa = new JLabel("\u00BFmas informacion sobre la empresa?");
		lblInformacionEmpresa.setBounds(427, 433, 267, 14);
		lblInformacionEmpresa.setForeground(new Color(0, 128, 0));
		lblInformacionEmpresa.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 11));
		contentPane.add(lblInformacionEmpresa);
		final ImageIcon logo2 = new ImageIcon(getClass().getResource("/material/libreta.png"));
		
		JLabel labelfotousuario = new JLabel();
		labelfotousuario.setForeground(Color.LIGHT_GRAY);
		labelfotousuario.setBounds(495, 43, 109, 123);
		contentPane.add(labelfotousuario);
		final ImageIcon logousuario = new ImageIcon(getClass().getResource("/material/usuario.png"));
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
		lblMenuDeOpciones.setBounds(146, 72, 145, 14);
		contentPane.add(lblMenuDeOpciones);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(46, 88, 327, 92);
		contentPane.add(panel);
		panel.setLayout(null);
		
		registroPlanilla = new JButton("Planillas");
		registroPlanilla.setForeground(Color.BLACK);
		registroPlanilla.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		registroPlanilla.setBackground(new Color(102, 205, 170));
		registroPlanilla.setBounds(117, 66, 97, 21);
		panel.add(registroPlanilla);
		
		registroContrato = new JButton("Contratos");
		registroContrato.setForeground(Color.BLACK);
		registroContrato.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		registroContrato.setBackground(new Color(102, 205, 170));
		registroContrato.setBounds(10, 41, 97, 21);
		panel.add(registroContrato);
		
		registroEmpleado = new JButton("Empleados");
		registroEmpleado.setForeground(Color.BLACK);
		registroEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		registroEmpleado.setBackground(new Color(102, 205, 170));
		registroEmpleado.setBounds(10, 19, 97, 21);
		panel.add(registroEmpleado);
		registroEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registro_empleados empleados = new registro_empleados();
				empleados.setVisible(true);
				empleados.setLocationRelativeTo(null);
				dispose();
				
			}
		});
		
		registroCargo = new JButton("Cargos");
		registroCargo.setForeground(Color.BLACK);
		registroCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		registroCargo.setBackground(new Color(102, 205, 170));
		registroCargo.setBounds(117, 19, 97, 21);
		panel.add(registroCargo);
		registroCargo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargo clase = new cargo();
		        consultas_cargo consulta = new consultas_cargo();
		        registro_cargos formulario = new registro_cargos();
		        control_cargo control = new control_cargo(clase, consulta, formulario);
		        formulario.setVisible(true);
		        formulario.setLocationRelativeTo(null);
		        formulario.txtSueldoCargo.requestFocusInWindow();
				dispose();	
			}
		});
		
		registroBonificacion = new JButton("Bonificaciones");
		registroBonificacion.setForeground(Color.BLACK);
		registroBonificacion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		registroBonificacion.setBackground(new Color(102, 205, 170));
		registroBonificacion.setBounds(117, 41, 97, 21);
		panel.add(registroBonificacion);
		
		registroDeduccion = new JButton("Deducciones");
		registroDeduccion.setForeground(Color.BLACK);
		registroDeduccion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		registroDeduccion.setBackground(new Color(102, 205, 170));
		registroDeduccion.setBounds(224, 41, 97, 21);
		panel.add(registroDeduccion);
		
		registroHorario = new JButton("Horarios");
		registroHorario.setForeground(Color.BLACK);
		registroHorario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		registroHorario.setBackground(new Color(102, 205, 170));
		registroHorario.setBounds(224, 19, 97, 21);
		panel.add(registroHorario);
		
		JLabel label_2 = new JLabel("Empleados :");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 11));
		label_2.setBounds(10, 0, 97, 21);
		panel.add(label_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(46, 180, 327, 69);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label_3 = new JLabel("Clientes :");
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 11));
		label_3.setBounds(10, 0, 97, 21);
		panel_1.add(label_3);
		
		JButton button_7 = new JButton("Clientes");
		button_7.setForeground(Color.BLACK);
		button_7.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		button_7.setBackground(new Color(60, 179, 113));
		button_7.setBounds(10, 19, 97, 21);
		panel_1.add(button_7);
		
		JButton button_8 = new JButton("Contratos");
		button_8.setForeground(Color.BLACK);
		button_8.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		button_8.setBackground(new Color(60, 179, 113));
		button_8.setBounds(117, 19, 97, 21);
		panel_1.add(button_8);
		
		JButton button_9 = new JButton("Servicios");
		button_9.setForeground(Color.BLACK);
		button_9.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		button_9.setBackground(new Color(60, 179, 113));
		button_9.setBounds(117, 46, 97, 21);
		panel_1.add(button_9);
		
		JButton button_10 = new JButton("Productos");
		button_10.setForeground(Color.BLACK);
		button_10.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		button_10.setBackground(new Color(60, 179, 113));
		button_10.setBounds(224, 19, 97, 21);
		panel_1.add(button_10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(46, 249, 327, 92);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label_4 = new JLabel("Finanzas :");
		label_4.setForeground(Color.BLACK);
		label_4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 11));
		label_4.setBounds(10, 0, 174, 21);
		panel_2.add(label_4);
		
		JButton button_11 = new JButton("Ingresos");
		button_11.setForeground(Color.BLACK);
		button_11.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		button_11.setBackground(new Color(70, 130, 180));
		button_11.setBounds(10, 19, 97, 21);
		panel_2.add(button_11);
		
		JButton button_12 = new JButton("Egresos");
		button_12.setForeground(Color.BLACK);
		button_12.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		button_12.setBackground(new Color(70, 130, 180));
		button_12.setBounds(117, 19, 97, 21);
		panel_2.add(button_12);
		
		JLabel label_5 = new JLabel("Facturas :");
		label_5.setForeground(Color.BLACK);
		label_5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 11));
		label_5.setBounds(10, 40, 97, 21);
		panel_2.add(label_5);
		
		JButton button_13 = new JButton("Facturas Clientes");
		button_13.setForeground(Color.BLACK);
		button_13.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		button_13.setBackground(new Color(255, 215, 0));
		button_13.setBounds(10, 59, 145, 21);
		panel_2.add(button_13);
		
		JButton button_14 = new JButton("Facturas Empresa");
		button_14.setForeground(Color.BLACK);
		button_14.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		button_14.setBackground(new Color(255, 215, 0));
		button_14.setBounds(176, 59, 145, 21);
		panel_2.add(button_14);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(46, 340, 327, 83);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel label_6 = new JLabel("Inventario :");
		label_6.setForeground(Color.BLACK);
		label_6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 11));
		label_6.setBounds(10, 0, 174, 21);
		panel_3.add(label_6);
		
		JButton button_15 = new JButton("Inventario");
		button_15.setForeground(Color.BLACK);
		button_15.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		button_15.setBackground(Color.PINK);
		button_15.setBounds(10, 19, 97, 21);
		panel_3.add(button_15);
		
		JButton button_16 = new JButton("Proveedores");
		button_16.setForeground(Color.BLACK);
		button_16.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		button_16.setBackground(Color.PINK);
		button_16.setBounds(117, 19, 97, 21);
		panel_3.add(button_16);
		
		JButton button_17 = new JButton("Compras");
		button_17.setForeground(Color.BLACK);
		button_17.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		button_17.setBackground(Color.PINK);
		button_17.setBounds(224, 19, 97, 21);
		panel_3.add(button_17);
		
		JLabel label_7 = new JLabel("Reportes :");
		label_7.setForeground(Color.BLACK);
		label_7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 11));
		label_7.setBounds(132, 39, 87, 21);
		panel_3.add(label_7);
		
		JButton button_18 = new JButton("Generar Reportes");
		button_18.setForeground(Color.BLACK);
		button_18.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		button_18.setBackground(new Color(255, 165, 0));
		button_18.setBounds(96, 57, 143, 21);
		panel_3.add(button_18);
		
		JLabel lblMenuOpciones = new JLabel();
		lblMenuOpciones.setBounds(21, 29, 379, 431);
		contentPane.add(lblMenuOpciones);
		final ImageIcon icono2 = new ImageIcon(logo2.getImage().getScaledInstance(lblMenuOpciones.getWidth(), lblMenuOpciones.getHeight(), Image.SCALE_DEFAULT));
		lblMenuOpciones.setIcon(icono2);

		
		
	}
}
