package diseño.television;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

import clases.television.usuario;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class login_usuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtContraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login_usuario frame = new login_usuario();
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
	public login_usuario() {
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(129, 159, 435, 223);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario :");
		lblUsuario.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 15));
		lblUsuario.setBounds(61, 64, 113, 14);
		panel.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a :");
		lblContrasea.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 15));
		lblContrasea.setBounds(61, 95, 113, 14);
		panel.add(lblContrasea);
		
		JLabel lblNewLabel = new JLabel("Olvido su contrase\u00F1a?");
		lblNewLabel.setBounds(164, 126, 162, 14);
		panel.add(lblNewLabel);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(164, 64, 220, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblLogin = new JLabel("Ingresar");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLogin.setBounds(10, 11, 162, 32);
		panel.add(lblLogin);
		
		JButton btnLogo = new JButton("Logo");
		btnLogo.setBounds(263, 11, 169, 137);
		contentPane.add(btnLogo);
		final ImageIcon logo = new ImageIcon(getClass().getResource("/material/television/logo.png"));
		final ImageIcon icono = new ImageIcon(logo.getImage().getScaledInstance(btnLogo.getWidth(), btnLogo.getHeight(), Image.SCALE_DEFAULT));
		btnLogo.setIcon(icono);
		
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(164, 151, 127, 32);
		panel.add(btnIngresar);
		
		txtContraseña = new JPasswordField();
		txtContraseña.setBounds(164, 95, 220, 20);
		panel.add(txtContraseña);
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresar();
			}
		});
		
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(586, 426, 98, 34);
		contentPane.add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salir();
			}
		});
		
	}

	protected void ingresar() {

	}


	protected void salir() {
		System.exit(0);
	}
}
