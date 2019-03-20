package diseño.television;

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
		
		JLabel label_8 = new JLabel();
		label_8.setBounds(289, 99, 31, 29);
		contentPane.add(label_8);
		final ImageIcon logopeq = new ImageIcon(getClass().getResource("/material/television/logo.png"));
		final ImageIcon iconopeq = new ImageIcon(logopeq.getImage().getScaledInstance(label_8.getWidth(), label_8.getHeight(), Image.SCALE_DEFAULT));
		label_8.setIcon(iconopeq);
		
		JLabel lblCanalCoffee = new JLabel("CANAL 40 COFFEE TV CHANNEL");
		lblCanalCoffee.setBounds(392, 58, 255, 36);
		lblCanalCoffee.setFont(new Font("Showcard Gothic", Font.BOLD, 15));
		contentPane.add(lblCanalCoffee);
		
		JLabel lblEmpresa = new JLabel();
		lblEmpresa.setBounds(366, 90, 299, 318);
		contentPane.add(lblEmpresa);
		final ImageIcon logo = new ImageIcon(getClass().getResource("/material/television/logo.png"));
		final ImageIcon icono = new ImageIcon(logo.getImage().getScaledInstance(lblEmpresa.getWidth(), lblEmpresa.getHeight(), Image.SCALE_DEFAULT));
		lblEmpresa.setIcon(icono);
		
		
		JLabel lblMenu = new JLabel("Menu de opciones:");
		lblMenu.setBounds(119, 90, 176, 29);
		lblMenu.setFont(new Font("Britannic Bold", Font.BOLD, 15));
		contentPane.add(lblMenu);
		
		JLabel lblBienvenidoAlSistema = new JLabel("Bienvenido al sistema administrativo.");
		lblBienvenidoAlSistema.setBounds(167, 11, 498, 36);
		lblBienvenidoAlSistema.setForeground(SystemColor.textHighlight);
		lblBienvenidoAlSistema.setFont(new Font("Showcard Gothic", Font.BOLD, 18));
		contentPane.add(lblBienvenidoAlSistema);
		
		JLabel lblInformacionEmpresa = new JLabel("\u00BFmas informacion sobre la empresa?");
		lblInformacionEmpresa.setBounds(392, 419, 255, 14);
		lblInformacionEmpresa.setForeground(new Color(0, 128, 0));
		lblInformacionEmpresa.setFont(new Font("Showcard Gothic", Font.BOLD, 11));
		contentPane.add(lblInformacionEmpresa);
		
		JLabel lblEmpleados = new JLabel("Empleados.");
		lblEmpleados.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
		lblEmpleados.setBounds(94, 114, 75, 22);
		contentPane.add(lblEmpleados);
		
		JLabel lblClientes = new JLabel("Clientes.");
		lblClientes.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
		lblClientes.setBounds(94, 157, 75, 22);
		contentPane.add(lblClientes);
		
		JLabel lblProductosYServicios = new JLabel("Productos y Servicios.");
		lblProductosYServicios.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
		lblProductosYServicios.setBounds(94, 201, 150, 22);
		contentPane.add(lblProductosYServicios);
		
		JLabel lblIngresosYEgresos = new JLabel("Ingresos y Egresos.");
		lblIngresosYEgresos.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
		lblIngresosYEgresos.setBounds(94, 245, 137, 22);
		contentPane.add(lblIngresosYEgresos);
		
		JLabel lblFacturas = new JLabel("Facturas.");
		lblFacturas.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
		lblFacturas.setBounds(94, 290, 75, 22);
		contentPane.add(lblFacturas);
		
		JLabel lblFacturas_1 = new JLabel("Planillas.");
		lblFacturas_1.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
		lblFacturas_1.setBounds(94, 386, 75, 22);
		contentPane.add(lblFacturas_1);
		
		JLabel lblCargos = new JLabel("Cargos.");
		lblCargos.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
		lblCargos.setBounds(94, 331, 75, 29);
		contentPane.add(lblCargos);
		
		JButton button_4 = new JButton("Registrar");
		button_4.setForeground(new Color(0, 128, 0));
		button_4.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
		button_4.setBackground(Color.WHITE);
		button_4.setBounds(94, 135, 106, 22);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("Listar");
		button_5.setForeground(new Color(0, 128, 128));
		button_5.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
		button_5.setBackground(Color.WHITE);
		button_5.setBounds(199, 135, 106, 22);
		contentPane.add(button_5);
		
		JButton button = new JButton("Registrar");
		button.setForeground(new Color(0, 128, 0));
		button.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
		button.setBackground(Color.WHITE);
		button.setBounds(94, 179, 106, 22);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Listar");
		button_1.setForeground(new Color(0, 128, 128));
		button_1.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(199, 179, 106, 22);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Registrar");
		button_2.setForeground(new Color(0, 128, 0));
		button_2.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
		button_2.setBackground(Color.WHITE);
		button_2.setBounds(94, 223, 106, 22);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("Listar");
		button_3.setForeground(new Color(0, 128, 128));
		button_3.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
		button_3.setBackground(Color.WHITE);
		button_3.setBounds(199, 223, 106, 22);
		contentPane.add(button_3);
		
		JButton button_6 = new JButton("Registrar");
		button_6.setForeground(new Color(0, 128, 0));
		button_6.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
		button_6.setBackground(Color.WHITE);
		button_6.setBounds(94, 269, 106, 22);
		contentPane.add(button_6);
		
		JButton button_7 = new JButton("Listar");
		button_7.setForeground(new Color(0, 128, 128));
		button_7.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
		button_7.setBackground(Color.WHITE);
		button_7.setBounds(199, 269, 106, 22);
		contentPane.add(button_7);
		
		JButton button_8 = new JButton("Registrar");
		button_8.setForeground(new Color(0, 128, 0));
		button_8.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
		button_8.setBackground(Color.WHITE);
		button_8.setBounds(94, 313, 106, 22);
		contentPane.add(button_8);
		
		JButton button_9 = new JButton("Listar");
		button_9.setForeground(new Color(0, 128, 128));
		button_9.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
		button_9.setBackground(Color.WHITE);
		button_9.setBounds(199, 313, 106, 22);
		contentPane.add(button_9);
		
		JButton btnRegistrarCargos = new JButton("Registrar");
		btnRegistrarCargos.setForeground(new Color(0, 128, 0));
		btnRegistrarCargos.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
		btnRegistrarCargos.setBackground(Color.WHITE);
		btnRegistrarCargos.setBounds(94, 359, 106, 22);
		contentPane.add(btnRegistrarCargos);
		btnRegistrarCargos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registro_mantenimiento_cargos registroCargos = new registro_mantenimiento_cargos();
				registroCargos.show();
				dispose();
			}
		});
		
		JButton button_11 = new JButton("Listar");
		button_11.setForeground(new Color(0, 128, 128));
		button_11.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
		button_11.setBackground(Color.WHITE);
		button_11.setBounds(199, 359, 106, 22);
		contentPane.add(button_11);
		
		JLabel label = new JLabel("1.");
		label.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
		label.setBounds(78, 114, 20, 22);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("2.");
		label_1.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
		label_1.setBounds(78, 157, 20, 22);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("3.");
		label_2.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
		label_2.setBounds(78, 201, 20, 22);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("4.");
		label_3.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
		label_3.setBounds(78, 245, 20, 22);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("5.");
		label_4.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
		label_4.setBounds(78, 290, 20, 22);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("6.");
		label_5.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
		label_5.setBounds(78, 334, 20, 22);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("7.");
		label_6.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
		label_6.setBounds(78, 386, 20, 22);
		contentPane.add(label_6);
		
		JLabel lblMenuOpciones = new JLabel();
		lblMenuOpciones.setBounds(28, 58, 319, 389);
		contentPane.add(lblMenuOpciones);
		final ImageIcon logo2 = new ImageIcon(getClass().getResource("/material/television/libreta.png"));
		final ImageIcon icono2 = new ImageIcon(logo2.getImage().getScaledInstance(lblMenuOpciones.getWidth(), lblMenuOpciones.getHeight(), Image.SCALE_DEFAULT));
		lblMenuOpciones.setIcon(icono2);

		
		
	}
}
