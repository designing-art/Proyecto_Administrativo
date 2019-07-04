package formularios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

public class login_usuario extends JFrame {

	public JPanel contentPane;
	public static JTextField txtUsuario;
	public static JPasswordField txtContraseña;
	public JLabel lblAlerta;
	public JButton btnIngresar;

	public login_usuario() {
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 375);
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
		panel.setBounds(63, 66, 435, 223);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblUsuario = new JLabel("Usuario :");
		lblUsuario.setForeground(new Color(0, 0, 0));
		lblUsuario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblUsuario.setBounds(58, 85, 113, 14);
		panel.add(lblUsuario);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a :");
		lblContrasea.setForeground(new Color(0, 0, 0));
		lblContrasea.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblContrasea.setBounds(58, 116, 113, 14);
		panel.add(lblContrasea);

		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsuario.setBounds(161, 79, 220, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);

		JLabel lblLogin = new JLabel("Bienvenido por favor inicie sesi\u00F3n.");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblLogin.setBounds(58, 36, 323, 32);
		panel.add(lblLogin);

		btnIngresar = new JButton("Ingresar");
		btnIngresar.setForeground(new Color(0, 0, 0));
		btnIngresar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnIngresar.setBackground(new Color(60, 179, 113));
		btnIngresar.setBounds(161, 141, 113, 23);
		panel.add(btnIngresar);

		txtContraseña = new JPasswordField();
		txtContraseña.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtContraseña.setHorizontalAlignment(SwingConstants.CENTER);
		txtContraseña.setBounds(161, 110, 220, 20);
		panel.add(txtContraseña);

		lblAlerta = new JLabel("");
		lblAlerta.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlerta.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblAlerta.setBounds(58, 178, 323, 14);
		panel.add(lblAlerta);

		JLabel lblLoginSistemaAdministrativo = new JLabel("LOGIN SISTEMA ADMINISTRATIVO");
		lblLoginSistemaAdministrativo.setBackground(new Color(0, 128, 128));
		lblLoginSistemaAdministrativo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginSistemaAdministrativo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		lblLoginSistemaAdministrativo.setBounds(63, 35, 435, 32);
		contentPane.add(lblLoginSistemaAdministrativo);
		

	}
}
