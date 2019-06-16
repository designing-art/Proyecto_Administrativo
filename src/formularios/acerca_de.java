package formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class acerca_de extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					acerca_de frame = new acerca_de();
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
	public acerca_de() {
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 387, 351);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAcercaDe = new JLabel("Acerca de.");
		lblAcercaDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblAcercaDe.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		lblAcercaDe.setBounds(0, 11, 371, 14);
		contentPane.add(lblAcercaDe);
		
		JLabel lblSistemaAdministrativoBy = new JLabel("Sistema Administrativo by Designing_Art");
		lblSistemaAdministrativoBy.setHorizontalAlignment(SwingConstants.CENTER);
		lblSistemaAdministrativoBy.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblSistemaAdministrativoBy.setBounds(0, 24, 371, 26);
		contentPane.add(lblSistemaAdministrativoBy);
		
		JTextArea txtrTodosLosDerechos = new JTextArea();
		txtrTodosLosDerechos.setText("Todos los derechos reservados a. Designing_Art\r\n                  Programador y Dise\u00F1ador:\r\n           Lic. en Inform\u00E1tica Administrativa.\r\n          Cristian Emmanuel D\u00EDaz Rodr\u00EDguez\r\n       Contacto: krizemandiaz11@gmail.com\r\n  UNAH-Tec Danl\u00ED, El Para\u00EDso Honduras 2019\r\n");
		txtrTodosLosDerechos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtrTodosLosDerechos.setBounds(41, 207, 303, 94);
		txtrTodosLosDerechos.setEditable(false);
		contentPane.add(txtrTodosLosDerechos);
		final ImageIcon logo = new ImageIcon(getClass().getResource("/iconos/logo_estandar.png"));
		
		JLabel label = new JLabel("");
		label.setBounds(96, 49, 161, 147);
		contentPane.add(label);
		final ImageIcon logo2 = new ImageIcon(getClass().getResource("/iconos/icono_d_a.jpg"));
		final ImageIcon icono2 = new ImageIcon(logo2.getImage().getScaledInstance(label.getWidth(),
				label.getHeight(), Image.SCALE_DEFAULT));
		label.setIcon(icono2);
	}
}
