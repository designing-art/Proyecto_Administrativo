package formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class configuracion_servidor extends JFrame {

	private JPanel contentPane;
	public JTextField txtDireccionServidor;
	public JToggleButton btnUnServidor;
	public JToggleButton btnVariosServidores;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					configuracion_servidor frame = new configuracion_servidor();
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
	public configuracion_servidor() {
		setResizable(false);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 310);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConfiguracinDelServidor = new JLabel();
		lblConfiguracinDelServidor.setText("Configuraci\u00F3n del servidor.");
		lblConfiguracinDelServidor.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfiguracinDelServidor.setForeground(Color.BLACK);
		lblConfiguracinDelServidor.setFont(new Font("Eras Bold ITC", Font.BOLD, 17));
		lblConfiguracinDelServidor.setBounds(82, 11, 274, 33);
		contentPane.add(lblConfiguracinDelServidor);
		
		JLabel lblUnaComputadora = new JLabel();
		lblUnaComputadora.setText("Una Computadora.");
		lblUnaComputadora.setHorizontalAlignment(SwingConstants.CENTER);
		lblUnaComputadora.setForeground(Color.BLACK);
		lblUnaComputadora.setFont(new Font("Eras Bold ITC", Font.PLAIN, 15));
		lblUnaComputadora.setBounds(20, 49, 209, 33);
		contentPane.add(lblUnaComputadora);
		
		JLabel lblVariasComputadoras = new JLabel();
		lblVariasComputadoras.setText("Varias Computadoras.");
		lblVariasComputadoras.setHorizontalAlignment(SwingConstants.CENTER);
		lblVariasComputadoras.setForeground(Color.BLACK);
		lblVariasComputadoras.setFont(new Font("Eras Bold ITC", Font.PLAIN, 15));
		lblVariasComputadoras.setBounds(189, 49, 245, 33);
		contentPane.add(lblVariasComputadoras);
		
		btnUnServidor = new JToggleButton("");
		btnUnServidor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (btnUnServidor.isSelected()) {
					btnVariosServidores.setSelected(false);
					txtDireccionServidor.setText("localhost:3306");
				}
			}
		});
		btnUnServidor.setToolTipText("Se usar\u00E1 solamente este computador para trabajar en este software.");
		btnUnServidor.setBounds(52, 80, 146, 124);
		contentPane.add(btnUnServidor);
		
		btnVariosServidores = new JToggleButton("");
		btnVariosServidores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (btnVariosServidores.isSelected()) {
					btnUnServidor.setSelected(false);
					txtDireccionServidor.setText("");
					txtDireccionServidor.setEditable(true);
					
				}
			}
		});
		btnVariosServidores.setToolTipText("Se usar\u00E1 este computador como servidor y utilizar\u00E1 varias computadoras clientes. ");
		btnVariosServidores.setBounds(239, 80, 142, 124);
		contentPane.add(btnVariosServidores);
		
		txtDireccionServidor = new JTextField();
		txtDireccionServidor.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		txtDireccionServidor.setHorizontalAlignment(SwingConstants.CENTER);
		txtDireccionServidor.setEditable(false);
		txtDireccionServidor.setBounds(52, 209, 329, 20);
		contentPane.add(txtDireccionServidor);
		txtDireccionServidor.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(new Color(60, 179, 113));
		btnGuardar.setBounds(151, 250, 131, 20);
		contentPane.add(btnGuardar);

	}
}
