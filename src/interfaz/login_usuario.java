package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;

public class login_usuario extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

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
		panel.setBounds(140, 157, 435, 180);
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
		
		textField = new JTextField();
		textField.setBounds(164, 64, 220, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(164, 95, 220, 20);
		panel.add(textField_1);
		
		JLabel lblLogin = new JLabel("Ingresar");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLogin.setBounds(10, 11, 162, 32);
		panel.add(lblLogin);
		
		JButton btnNewButton = new JButton("Logo");
		btnNewButton.setBounds(267, 11, 169, 137);
		contentPane.add(btnNewButton);
		
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.setBounds(140, 348, 141, 34);
		contentPane.add(btnEntrar);
		
		JButton btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setBounds(419, 348, 156, 34);
		contentPane.add(btnRegistrar);
	}

}
