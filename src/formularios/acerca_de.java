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

public class acerca_de extends JFrame {

	public JPanel contentPane;
	public int contador1 = 0;
	public int contador2 = 0;
	public int contador3 = 0;
	public static String ruta;
	public static ImageIcon imagen;
	public static String identidad = null;
	public ButtonGroup grupo1;
	public ButtonGroup grupo2;
	public static String sonido = null;
	public static String tema = null;
	ventana_principal principal = new ventana_principal();

	public acerca_de() {
		setType(Type.UTILITY);
		setResizable(false);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 525, 335);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		final ImageIcon icono = new ImageIcon(getClass().getResource("/iconos/libreta.png"));

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 23, 499, 240);
		contentPane.add(panel);

		grupo1 = new ButtonGroup();

		grupo2 = new ButtonGroup();

		JLabel label_12 = new JLabel("");
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setBounds(0, 0, 499, 240);
		panel.add(label_12);
		final ImageIcon logo = new ImageIcon(
				icono.getImage().getScaledInstance(label_12.getWidth(), label_12.getHeight(), Image.SCALE_DEFAULT));
		label_12.setIcon(logo);

		JLabel lblRegistroYMantenimiento = new JLabel("Acerca de.");
		lblRegistroYMantenimiento.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroYMantenimiento.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblRegistroYMantenimiento.setBounds(10, 0, 499, 21);
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
