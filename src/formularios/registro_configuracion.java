package formularios;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import clases.configuracion;
import conexion.conexion;
import consultas.consultas_configuracion;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.JRadioButton;

public class registro_configuracion extends JFrame {

	public JPanel contentPane;
	public int contador1 = 0;
	public int contador2 = 0;
	public int contador3 = 0;
	public static String ruta;
	public static ImageIcon imagen;
	public static String identidad = null;
	public JButton btnGuardar;
	public JButton btnActualizar;
	public JTextField txtCodigo;
	public JRadioButton rdbtnDesactvar;
	public JRadioButton rdbtnActivar;
	public JRadioButton rdbtnClaro;
	public JRadioButton rdbtnObscuro;
	public JRadioButton rdbtnAzul;
	public JRadioButton rdbtnVerdoso;
	public ButtonGroup grupo1;
	public ButtonGroup grupo2;
	public static String sonido = null;
	public static String tema = null;
	ventana_principal principal = new ventana_principal();
	private JLabel lblTemasDelSistema;
	private JLabel lblFraseMotivadora;
	private JLabel lblEscribaUnaFrase;
	public static JTextField txtFrase;

	public registro_configuracion() {
		setType(Type.UTILITY);
		setResizable(false);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 262, 377);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		final ImageIcon icono = new ImageIcon(getClass().getResource("/iconos/libreta.png"));

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 41, 236, 296);
		contentPane.add(panel);

		JLabel lblFuncionesDelEmpleado = new JLabel("Configuracion de audio.");
		lblFuncionesDelEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblFuncionesDelEmpleado.setBounds(20, 23, 220, 25);
		panel.add(lblFuncionesDelEmpleado);

		JLabel lblNombreDeLa = new JLabel("Sonidos del sistema :");
		lblNombreDeLa.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblNombreDeLa.setBounds(20, 41, 166, 25);
		panel.add(lblNombreDeLa);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnGuardar.setBackground(new Color(50, 205, 50));
		btnGuardar.setBounds(111, 251, 104, 23);
		panel.add(btnGuardar);

		rdbtnDesactvar = new JRadioButton("Desactivar");
		rdbtnDesactvar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		rdbtnDesactvar.setBounds(20, 63, 89, 23);
		panel.add(rdbtnDesactvar);

		rdbtnActivar = new JRadioButton("Activar");
		rdbtnActivar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		rdbtnActivar.setBounds(126, 63, 89, 23);
		panel.add(rdbtnActivar);

		grupo1 = new ButtonGroup();
		grupo1.add(rdbtnDesactvar);
		grupo1.add(rdbtnActivar);

		JLabel lblConfiguracionDeDiseo = new JLabel("Configuracion de dise\u00F1o.");
		lblConfiguracionDeDiseo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblConfiguracionDeDiseo.setBounds(20, 88, 220, 25);
		panel.add(lblConfiguracionDeDiseo);

		rdbtnClaro = new JRadioButton("Claro");
		rdbtnClaro.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		rdbtnClaro.setBounds(20, 128, 89, 23);
		panel.add(rdbtnClaro);

		rdbtnObscuro = new JRadioButton("Obscuro");
		rdbtnObscuro.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		rdbtnObscuro.setBounds(131, 128, 84, 23);
		panel.add(rdbtnObscuro);

		rdbtnAzul = new JRadioButton("Azulado");
		rdbtnAzul.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		rdbtnAzul.setBounds(20, 154, 89, 23);
		panel.add(rdbtnAzul);

		rdbtnVerdoso = new JRadioButton("Verdoso");
		rdbtnVerdoso.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		rdbtnVerdoso.setBounds(131, 154, 84, 23);
		panel.add(rdbtnVerdoso);

		grupo2 = new ButtonGroup();
		grupo2.add(rdbtnClaro);
		grupo2.add(rdbtnObscuro);
		grupo2.add(rdbtnAzul);
		grupo2.add(rdbtnVerdoso);

		txtCodigo = new JTextField();
		txtCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(192, 26, 23, 20);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);
		txtCodigo.setVisible(false);

		btnActualizar = new JButton("Guardar");
		btnActualizar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnActualizar.setBackground(new Color(50, 205, 50));
		btnActualizar.setBounds(20, 251, 104, 23);
		panel.add(btnActualizar);

		lblTemasDelSistema = new JLabel("Temas del sistema :");
		lblTemasDelSistema.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblTemasDelSistema.setBounds(20, 106, 166, 25);
		panel.add(lblTemasDelSistema);

		lblFraseMotivadora = new JLabel("Frase Motivadora.");
		lblFraseMotivadora.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblFraseMotivadora.setBounds(20, 180, 220, 25);
		panel.add(lblFraseMotivadora);

		lblEscribaUnaFrase = new JLabel("Escriba una frase motivadora.");
		lblEscribaUnaFrase.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 10));
		lblEscribaUnaFrase.setBounds(20, 198, 210, 25);
		panel.add(lblEscribaUnaFrase);

		txtFrase = new JTextField();
		txtFrase.setBounds(20, 220, 195, 20);
		panel.add(txtFrase);
		txtFrase.setColumns(10);

		JLabel label_12 = new JLabel("");
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setBounds(0, 0, 236, 296);
		panel.add(label_12);
		final ImageIcon logo = new ImageIcon(
				icono.getImage().getScaledInstance(label_12.getWidth(), label_12.getHeight(), Image.SCALE_DEFAULT));
		label_12.setIcon(logo);

		JLabel lblRegistroYMantenimiento = new JLabel("CONFIGURACIONES");
		lblRegistroYMantenimiento.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroYMantenimiento.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblRegistroYMantenimiento.setBounds(10, 0, 230, 45);
		contentPane.add(lblRegistroYMantenimiento);

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
			btnGuardar.setVisible(true);
			btnActualizar.setVisible(false);
		}
	}

	public void vozBienvenido() throws FileNotFoundException, JavaLayerException {
		Player apl = new Player(new FileInputStream("src/audios/bienvenido.mp3"));
		apl.play();
	}

	public void configuracionSonido() {
		conexion conex = new conexion();
		try {
			Statement estatuto = conex.getConexion().createStatement();
			ResultSet rs = estatuto.executeQuery(
					"SELECT sonido_configuracion, tema_configuracion FROM configuraciones WHERE id_configuracion = 1");

			if (rs.next()) {
				sonido = (rs.getString("sonido_configuracion"));
				tema = (rs.getString("tema_configuracion"));
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
					"SELECT sonido_configuracion, tema_configuracion FROM configuraciones WHERE id_configuracion = 1");

			if (rs.next()) {
				sonido = (rs.getString("sonido_configuracion"));
				tema = (rs.getString("tema_configuracion"));

				if (sonido.equals("Activar")) {
					rdbtnActivar.setSelected(true);
					repaint();
				} else {
					rdbtnDesactvar.setSelected(true);
					repaint();
				}

				if (tema.equals("Claro")) {
					rdbtnClaro.setSelected(true);
					repaint();
				} else {
					if (tema.equals("Obscuro")) {
						rdbtnObscuro.setSelected(true);
						repaint();
					} else {
						if (tema.equals("Verdoso")) {
							rdbtnVerdoso.setSelected(true);
							repaint();
						} else {
							rdbtnAzul.setSelected(true);
							repaint();
						}
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

}
