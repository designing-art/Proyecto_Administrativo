package formularios;

import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import conexion.conexion;
import consultas.*;
import clases.*;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;

public class configuraciones extends JFrame {

	public JPanel contentPane;
	public static JTextField txtFrase;
	public static JRadioButton rdbtnDesactivar;
	public static JRadioButton rdbtnActivar;
	public static String sonido = null;
	public static String frase = null;
	public static String tema = null;
	public JButton btnGuardar;
	public JButton btnActualizar;
	public JTextField txtCodigo;
	public ButtonGroup grupo;
	public ButtonGroup grupo2;
	public JLabel lblTemasDelSistema;
	public static JRadioButton rdbtnClaro;
	public static JRadioButton rdbtnObscuro;
	private JPanel panel;

	public configuraciones() {
		setType(Type.UTILITY);
		setDefaultCloseOperation(0);
		setBounds(100, 100, 387, 453);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAcercaDe = new JLabel("Configuraci\u00F3n del sistema administrativo.");
		lblAcercaDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblAcercaDe.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		lblAcercaDe.setBounds(0, 11, 371, 26);
		contentPane.add(lblAcercaDe);

		JLabel lblSistemaAdministrativoBy = new JLabel("Sistema Administrativo by Designing_Art");
		lblSistemaAdministrativoBy.setHorizontalAlignment(SwingConstants.CENTER);
		lblSistemaAdministrativoBy.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblSistemaAdministrativoBy.setBounds(10, 35, 371, 26);
		contentPane.add(lblSistemaAdministrativoBy);
		final ImageIcon logo = new ImageIcon(getClass().getResource("/iconos/logo_estandar.png"));

		JLabel label = new JLabel("");
		label.setBounds(115, 61, 164, 154);
		contentPane.add(label);
		final ImageIcon logo2 = new ImageIcon(getClass().getResource("/iconos/icono_d_a.jpg"));
		final ImageIcon icono2 = new ImageIcon(
				logo2.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
		label.setIcon(icono2);

		rdbtnDesactivar = new JRadioButton("Desactivar");
		rdbtnDesactivar.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnDesactivar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		rdbtnDesactivar.setBounds(115, 233, 89, 23);
		contentPane.add(rdbtnDesactivar);

		rdbtnActivar = new JRadioButton("Activar");
		rdbtnActivar.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnActivar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		rdbtnActivar.setBounds(206, 233, 89, 23);
		contentPane.add(rdbtnActivar);

		grupo = new ButtonGroup();
		grupo.add(rdbtnActivar);
		grupo.add(rdbtnDesactivar);

		JLabel label_1 = new JLabel("Sonidos del sistema :");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
		label_1.setBounds(105, 213, 188, 25);
		contentPane.add(label_1);

		txtFrase = new JTextField();
		txtFrase.setHorizontalAlignment(SwingConstants.CENTER);
		txtFrase.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 10));
		txtFrase.setColumns(10);
		txtFrase.setBounds(20, 382, 351, 26);
		contentPane.add(txtFrase);
		InputMap map8 = txtFrase.getInputMap(JComponent.WHEN_FOCUSED);
		map8.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtFrase.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				if (txtFrase.getText().length() == 90)
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
		btnGuardar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnGuardar.setBackground(new Color(50, 205, 50));
		btnGuardar.setBounds(32, 419, 104, 23);
		contentPane.add(btnGuardar);

		btnActualizar = new JButton("Guardar");
		btnActualizar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnActualizar.setBackground(new Color(50, 205, 50));
		btnActualizar.setBounds(256, 419, 104, 23);
		contentPane.add(btnActualizar);

		JLabel lblFraseMotivadora = new JLabel("Frase Motivadora :");
		lblFraseMotivadora.setHorizontalAlignment(SwingConstants.CENTER);
		lblFraseMotivadora.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
		lblFraseMotivadora.setBounds(97, 343, 190, 26);
		contentPane.add(lblFraseMotivadora);

		JLabel lblEscribaUnaFrase = new JLabel("Escriba una frase motivadora.");
		lblEscribaUnaFrase.setHorizontalAlignment(SwingConstants.CENTER);
		lblEscribaUnaFrase.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblEscribaUnaFrase.setBounds(10, 361, 371, 23);
		contentPane.add(lblEscribaUnaFrase);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(10, 64, 86, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);

		grupo2 = new ButtonGroup();

		panel = new JPanel();
		panel.setBounds(20, 259, 357, 91);
		contentPane.add(panel);
		panel.setLayout(null);

		lblTemasDelSistema = new JLabel("Temas del sistema :");
		lblTemasDelSistema.setBounds(82, 0, 188, 26);
		panel.add(lblTemasDelSistema);
		lblTemasDelSistema.setHorizontalAlignment(SwingConstants.CENTER);
		lblTemasDelSistema.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));

		rdbtnClaro = new JRadioButton("Claro");
		rdbtnClaro.setEnabled(false);
		rdbtnClaro.setBounds(61, 21, 119, 23);
		panel.add(rdbtnClaro);
		rdbtnClaro.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnClaro.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		grupo2.add(rdbtnClaro);

		rdbtnObscuro = new JRadioButton("Obscuro");
		rdbtnObscuro.setEnabled(false);
		rdbtnObscuro.setBounds(182, 21, 119, 23);
		panel.add(rdbtnObscuro);
		rdbtnObscuro.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnObscuro.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		grupo2.add(rdbtnObscuro);

		JTextArea txtrNotaApartado = new JTextArea();
		txtrNotaApartado.setEditable(false);
		txtrNotaApartado.setForeground(new Color(0, 128, 128));
		txtrNotaApartado.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 10));
		txtrNotaApartado.setText("Nota : Apartado de temas bloqueado. \r\nDisponible en futuras actualizaciones.");
		txtrNotaApartado.setBounds(82, 47, 202, 33);
		panel.add(txtrNotaApartado);

		txtCodigo.setVisible(false);

	}

	public void mostrarConfiguracion() {
		consultas_configuracion consulta = new consultas_configuracion();
		configuracion clase = new configuracion();
		if (consulta.buscar(clase)) {
			txtCodigo.setText(String.valueOf(clase.getId_configuracion()));
			btnGuardar.setVisible(false);
			btnActualizar.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(null, "Bienvenido a las configuraciones");
			rdbtnClaro.setSelected(true);
			btnGuardar.setVisible(true);
			btnActualizar.setVisible(false);
		}
	}

	public void vozBienvenido() throws FileNotFoundException, JavaLayerException {
		Player apl = new Player(new FileInputStream("src/audios/bienvenido.mp3"));
		apl.play();
	}

	public void establecerSonidoInicial() {
		conexion conex = new conexion();
		try {
			Statement estatuto = conex.getConexion().createStatement();
			ResultSet rs = estatuto
					.executeQuery("SELECT sonido_configuracion FROM configuraciones WHERE id_configuracion = 1");

			if (rs.next()) {
				sonido = (rs.getString("sonido_configuracion"));

				if (sonido.equals("Activar")) {
					try {
						vozBienvenido();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (JavaLayerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
			rs.close();
			estatuto.close();
			conex.desconectar();
		} catch (SQLException exx) {
			System.out.println(exx.getMessage());
			JOptionPane.showMessageDialog(null, "Error al consultar", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void consultarConfiguracion() {
		conexion conex = new conexion();
		try {
			Statement estatuto = conex.getConexion().createStatement();
			ResultSet rs = estatuto.executeQuery(
					"SELECT sonido_configuracion, tema_configuracion, frase_configuracion FROM configuraciones WHERE id_configuracion = 1");

			if (rs.next()) {

				sonido = (rs.getString("sonido_configuracion"));
				tema = (rs.getString("tema_configuracion"));
				frase = (rs.getString("frase_configuracion"));

				if (sonido.equals("Activar")) {
					rdbtnActivar.setSelected(true);
					repaint();
				} else {
					rdbtnDesactivar.setSelected(true);
					repaint();
				}

				if (tema.equals("Claro")) {
					rdbtnClaro.setSelected(true);
					repaint();
				} else {
					if (tema.equals("Obscuro")) {
						rdbtnObscuro.setSelected(true);
						repaint();

					}
				}

				if (frase.equals("")) {
					txtFrase.setText(
							"La primera obligación de todo ser humano es ser feliz, la segunda hacer feliz a los demás.");
					repaint();
				} else {
					txtFrase.setText(frase);
					repaint();
				}
			}

			rs.close();
			estatuto.close();
			conex.desconectar();
		} catch (

		SQLException exx) {
			System.out.println(exx.getMessage());
			JOptionPane.showMessageDialog(null, "Error al consultar", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void establecerConfiguraciones() {

		ventana_principal.txtFrase.setText(login_usuario.frase);

	}

}
