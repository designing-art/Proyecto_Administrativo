package formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import java.awt.Color;
import java.awt.Event;
import java.awt.Window.Type;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import javax.swing.KeyStroke;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;

public class configuracion_servidor extends JFrame {

	private JPanel contentPane;
	public JFormattedTextField txtDireccionServidor;
	public JToggleButton btnUnServidor;
	public JToggleButton btnVariosServidores;
	public JLabel txtmsjServidor;
	public JButton btnGuardar;
	public JTextField txtCodigoServidor;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		final ImageIcon logo2 = new ImageIcon(getClass().getResource("/iconos/red.png"));
		final ImageIcon logo1 = new ImageIcon(getClass().getResource("/iconos/ordenador.png"));

		JLabel lblConfiguracinDelServidor = new JLabel();
		lblConfiguracinDelServidor.setText("Configuraci\u00F3n del servidor.");
		lblConfiguracinDelServidor.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfiguracinDelServidor.setForeground(Color.BLACK);
		lblConfiguracinDelServidor.setFont(new Font("Eras Bold ITC", Font.BOLD, 17));
		lblConfiguracinDelServidor.setBounds(82, 0, 274, 21);
		contentPane.add(lblConfiguracinDelServidor);

		JLabel lblUnaComputadora = new JLabel();
		lblUnaComputadora.setText("Una Computadora.");
		lblUnaComputadora.setHorizontalAlignment(SwingConstants.CENTER);
		lblUnaComputadora.setForeground(Color.BLACK);
		lblUnaComputadora.setFont(new Font("Eras Bold ITC", Font.PLAIN, 15));
		lblUnaComputadora.setBounds(20, 22, 209, 33);
		contentPane.add(lblUnaComputadora);

		JLabel lblVariasComputadoras = new JLabel();
		lblVariasComputadoras.setText("Varias Computadoras.");
		lblVariasComputadoras.setHorizontalAlignment(SwingConstants.CENTER);
		lblVariasComputadoras.setForeground(Color.BLACK);
		lblVariasComputadoras.setFont(new Font("Eras Bold ITC", Font.PLAIN, 15));
		lblVariasComputadoras.setBounds(189, 22, 245, 33);
		contentPane.add(lblVariasComputadoras);

		btnUnServidor = new JToggleButton("");
		btnUnServidor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (btnUnServidor.isSelected()) {
					btnVariosServidores.setSelected(false);
					txtDireccionServidor.setText("localhost:3306");
					txtDireccionServidor.setEditable(false);
					txtmsjServidor.setText("Dirección predeterminada del servidor.");
				}
			}
		});
		btnUnServidor.setToolTipText("Se usar\u00E1 solamente este computador para trabajar en este software.");
		btnUnServidor.setBounds(52, 53, 146, 124);
		contentPane.add(btnUnServidor);
		final ImageIcon icono1 = new ImageIcon(logo1.getImage().getScaledInstance(btnUnServidor.getWidth(),
				btnUnServidor.getHeight(), Image.SCALE_DEFAULT));
		btnUnServidor.setIcon(icono1);

		btnVariosServidores = new JToggleButton("");
		btnVariosServidores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (btnVariosServidores.isSelected()) {
					btnUnServidor.setSelected(false);
					txtDireccionServidor.setText("");
					txtDireccionServidor.setEditable(true);
					txtDireccionServidor.requestFocusInWindow();
					txtmsjServidor.setText("Por favor escriba la dirección IP del servidor.");

				}
			}
		});
		btnVariosServidores.setToolTipText(
				"Se usar\u00E1 este computador como servidor y utilizar\u00E1 varias computadoras clientes. ");
		btnVariosServidores.setBounds(239, 53, 142, 124);
		contentPane.add(btnVariosServidores);
		final ImageIcon icono2 = new ImageIcon(logo2.getImage().getScaledInstance(btnVariosServidores.getWidth(),
				btnVariosServidores.getHeight(), Image.SCALE_DEFAULT));
		btnVariosServidores.setIcon(icono2);

		MaskFormatter formato = null;
		try {
			formato = new MaskFormatter("###.###.###.###");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtDireccionServidor = new JFormattedTextField();
		txtDireccionServidor.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		txtDireccionServidor.setHorizontalAlignment(SwingConstants.CENTER);
		txtDireccionServidor.setEditable(false);
		txtDireccionServidor.setBounds(52, 213, 329, 20);
		contentPane.add(txtDireccionServidor);
		txtDireccionServidor.setColumns(10);
		InputMap map2 = txtDireccionServidor.getInputMap(JComponent.WHEN_FOCUSED);
		map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtDireccionServidor.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();

				if (Character.isLetter(c)) {
					getToolkit().beep();

					ke.consume();
				}
				
				if (txtDireccionServidor.getText().length() == 15)
					ke.consume();

			}

			@Override
			public void keyPressed(KeyEvent ke) {
			}

			@Override
			public void keyReleased(KeyEvent ke) {
			}
		});

		btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(new Color(60, 179, 113));
		btnGuardar.setBounds(150, 244, 131, 20);
		contentPane.add(btnGuardar);

		txtmsjServidor = new JLabel("");
		txtmsjServidor.setForeground(new Color(34, 139, 34));
		txtmsjServidor.setHorizontalAlignment(SwingConstants.CENTER);
		txtmsjServidor.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtmsjServidor.setBounds(52, 188, 329, 14);
		contentPane.add(txtmsjServidor);
		
		txtCodigoServidor = new JTextField();
		txtCodigoServidor.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigoServidor.setEditable(false);
		txtCodigoServidor.setText("1");
		txtCodigoServidor.setBounds(10, 11, 33, 20);
		contentPane.add(txtCodigoServidor);
		txtCodigoServidor.setColumns(10);
		txtCodigoServidor.setVisible(false);

	}
}
