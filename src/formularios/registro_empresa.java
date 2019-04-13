package formularios;

import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.RowFilter;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import com.placeholder.PlaceHolder;

import conexion.conexion;
import controles.control_contrato_empleado;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;

public class registro_empresa extends JFrame {
	public JScrollPane scrollFunciones;
	public PlaceHolder pista;
	public JButton btnActualizarContrato;

	public JPanel contentPane;

	public TableRowSorter<TableModel> trsfiltroCodigo;
	String filtroCodigo;

	public ImageIcon logoCanal = new ImageIcon(getClass().getResource("/material/logo.png"));
	public ImageIcon logoEmpresa = new ImageIcon(getClass().getResource("/material/logoEmpresa.jpg"));
	public ImageIcon icono = new ImageIcon(getClass().getResource("/material/libro_empresa.png"));
	public ImageIcon icono2 = new ImageIcon(getClass().getResource("/material/libreta.png"));
	public ImageIcon logofacebook = new ImageIcon(getClass().getResource("/material/logof.jpg"));
	public ImageIcon logoyoutube = new ImageIcon(getClass().getResource("/material/logoy.jpg"));
	public ImageIcon logowhatsapp = new ImageIcon(getClass().getResource("/material/logow.jpg"));
	private JTextField textField;
	private JTextField txtNombreEmpresa;
	private JTextField textField_3;
	private JTextField txtTelefonoEmpresa;
	private JTextField txtRTNempresa;
	private JTextField txtCorreo;
	private JTextField textField_2;

	public registro_empresa() {
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 808, 550);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnAtras = new JButton("Regresar");
		btnAtras.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnAtras.setBackground(new Color(255, 127, 80));
		btnAtras.setBounds(666, 7, 102, 23);
		contentPane.add(btnAtras);
		btnAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ventana_principal principal = new ventana_principal();
				principal.setVisible(true);
				principal.setLocationRelativeTo(null);
				dispose();
				Timer time = new Timer();
				time.schedule(principal.tarea, 0, 1000);
			}
		});

		JLabel lblRegistrarCargo = new JLabel("EMPRESA CANAL 40 COFFEE TV CHANNEL");
		lblRegistrarCargo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblRegistrarCargo.setBounds(28, 0, 431, 33);
		contentPane.add(lblRegistrarCargo);
		scrollFunciones = new JScrollPane();

		JPanel panelRegistro = new JPanel();
		panelRegistro.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		panelRegistro.setBounds(28, 34, 740, 476);
		contentPane.add(panelRegistro);
		panelRegistro.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(389, 43, 309, 404);
		panelRegistro.add(panel);
		panel.setLayout(null);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(85, 375, 99, 23);
		panel.add(btnGuardar);
		btnGuardar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnGuardar.setBackground(new Color(60, 179, 113));

		btnActualizarContrato = new JButton("Editar");
		btnActualizarContrato.setBounds(187, 375, 99, 23);
		panel.add(btnActualizarContrato);
		btnActualizarContrato.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnActualizarContrato.setBackground(new Color(60, 179, 113));

		JLabel label_1 = new JLabel();
		label_1.setBounds(27, 246, 164, 119);
		panel.add(label_1);
		final ImageIcon logo00 = new ImageIcon(
				logoEmpresa.getImage().getScaledInstance(label_1.getWidth(), label_1.getHeight(), Image.SCALE_DEFAULT));
		label_1.setIcon(logo00);

		JButton button_2 = new JButton("Ver");
		button_2.setBounds(203, 280, 83, 23);
		panel.add(button_2);
		button_2.setBackground(Color.WHITE);

		JButton button = new JButton("Subir");
		button.setBounds(203, 246, 83, 23);
		panel.add(button);
		button.setBackground(new Color(250, 128, 114));

		textField_2 = new JTextField();
		textField_2.setBounds(27, 213, 258, 20);
		panel.add(textField_2);
		textField_2.setEditable(false);
		textField_2.setColumns(10);

		JLabel lblFotografiaDelLocal = new JLabel("Fotografia del local de la empresa.");
		lblFotografiaDelLocal.setBounds(27, 190, 258, 17);
		panel.add(lblFotografiaDelLocal);
		lblFotografiaDelLocal.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));

		JLabel label_5 = new JLabel();
		label_5.setBounds(27, 65, 131, 119);
		panel.add(label_5);
		final ImageIcon logo5 = new ImageIcon(
				logoCanal.getImage().getScaledInstance(label_5.getWidth(), label_5.getHeight(), Image.SCALE_DEFAULT));
		label_5.setIcon(logo5);

		JButton btnVer = new JButton("Ver");
		btnVer.setBounds(203, 99, 83, 23);
		panel.add(btnVer);
		btnVer.setBackground(Color.WHITE);

		JButton button_1 = new JButton("Subir");
		button_1.setBounds(203, 65, 83, 23);
		panel.add(button_1);
		button_1.setBackground(new Color(250, 128, 114));

		textField_3 = new JTextField();
		textField_3.setBounds(27, 34, 258, 20);
		panel.add(textField_3);
		textField_3.setEditable(false);
		textField_3.setColumns(10);

		JLabel lblLogoOficialDe = new JLabel("Logo Oficial de la empresa.");
		lblLogoOficialDe.setBounds(27, 11, 259, 17);
		panel.add(lblLogoOficialDe);
		lblLogoOficialDe.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(31, 43, 326, 404);
		panelRegistro.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setBounds(10, 36, 83, 14);
		panel_1.add(lblNombre);
		lblNombre.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

		txtNombreEmpresa = new JTextField();
		txtNombreEmpresa.setBounds(93, 33, 210, 20);
		panel_1.add(txtNombreEmpresa);
		txtNombreEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombreEmpresa.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtNombreEmpresa.setColumns(10);

		JLabel lblDatosDeLa = new JLabel("Datos de la empresa :");
		lblDatosDeLa.setBounds(10, 0, 175, 31);
		panel_1.add(lblDatosDeLa);
		lblDatosDeLa.setForeground(Color.BLACK);
		lblDatosDeLa.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));

		JLabel lblDireccion = new JLabel("Direccion :");
		lblDireccion.setBounds(10, 64, 83, 14);
		panel_1.add(lblDireccion);
		lblDireccion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(93, 61, 210, 44);
		panel_1.add(scrollPane);

		JTextArea txtDireccion = new JTextArea();
		scrollPane.setViewportView(txtDireccion);

		JLabel lblTelefono = new JLabel("Telefono :");
		lblTelefono.setBounds(10, 119, 83, 14);
		panel_1.add(lblTelefono);
		lblTelefono.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

		txtTelefonoEmpresa = new JTextField();
		txtTelefonoEmpresa.setBounds(93, 116, 210, 20);
		panel_1.add(txtTelefonoEmpresa);
		txtTelefonoEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		txtTelefonoEmpresa.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtTelefonoEmpresa.setColumns(10);

		JLabel lblRtn = new JLabel("RTN :");
		lblRtn.setBounds(10, 147, 83, 14);
		panel_1.add(lblRtn);
		lblRtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

		txtRTNempresa = new JTextField();
		txtRTNempresa.setBounds(93, 144, 210, 20);
		panel_1.add(txtRTNempresa);
		txtRTNempresa.setHorizontalAlignment(SwingConstants.CENTER);
		txtRTNempresa.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtRTNempresa.setColumns(10);

		txtCorreo = new JTextField();
		txtCorreo.setBounds(93, 172, 210, 20);
		panel_1.add(txtCorreo);
		txtCorreo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCorreo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtCorreo.setColumns(10);

		JLabel lblCorreo = new JLabel("Correo :");
		lblCorreo.setBounds(10, 175, 83, 14);
		panel_1.add(lblCorreo);
		lblCorreo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

		JLabel lblCuentaBancaria = new JLabel("Cuentas :");
		lblCuentaBancaria.setBounds(10, 203, 83, 14);
		panel_1.add(lblCuentaBancaria);
		lblCuentaBancaria.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(93, 203, 210, 106);
		panel_1.add(scrollPane_1);

		JTextArea txtCuentaEmpresa = new JTextArea();
		scrollPane_1.setViewportView(txtCuentaEmpresa);

		JButton btnFacebook = new JButton("");
		btnFacebook.setBounds(93, 320, 62, 58);
		panel_1.add(btnFacebook);
		final ImageIcon logo = new ImageIcon(logofacebook.getImage().getScaledInstance(btnFacebook.getWidth(),
				btnFacebook.getHeight(), Image.SCALE_DEFAULT));
		btnFacebook.setIcon(logo);

		JLabel lblSociales = new JLabel("\r\nSociales.");
		lblSociales.setBounds(10, 336, 125, 14);
		panel_1.add(lblSociales);
		lblSociales.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

		JButton btnYoutube = new JButton("");
		btnYoutube.setBounds(169, 320, 62, 58);
		panel_1.add(btnYoutube);
		final ImageIcon logo1 = new ImageIcon(logoyoutube.getImage().getScaledInstance(btnYoutube.getWidth(),
				btnYoutube.getHeight(), Image.SCALE_DEFAULT));
		btnYoutube.setIcon(logo1);

		JButton btnWhatsapp = new JButton("");
		btnWhatsapp.setBounds(241, 320, 62, 58);
		panel_1.add(btnWhatsapp);
		final ImageIcon logo2 = new ImageIcon(logowhatsapp.getImage().getScaledInstance(btnWhatsapp.getWidth(),
				btnWhatsapp.getHeight(), Image.SCALE_DEFAULT));
		btnWhatsapp.setIcon(logo2);

		JLabel lblRedesSociales = new JLabel("Redes");
		lblRedesSociales.setBounds(10, 320, 125, 14);
		panel_1.add(lblRedesSociales);
		lblRedesSociales.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

		textField = new JTextField();
		textField.setBounds(10, 373, 50, 20);
		panel_1.add(textField);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		textField.setEditable(false);
		textField.setColumns(10);
		
				JLabel lblLibreta = new JLabel();
				lblLibreta.setBounds(0, 0, 740, 476);
				panelRegistro.add(lblLibreta);
				final ImageIcon logo3 = new ImageIcon(
						icono.getImage().getScaledInstance(lblLibreta.getWidth(), lblLibreta.getHeight(), Image.SCALE_DEFAULT));
				lblLibreta.setIcon(logo3);
		btnWhatsapp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				goToURL("https://www.whatsapp.com/");
			}
		});
		btnYoutube.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				goToURL("https://www.youtube.com/");
			}
		});
		btnFacebook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				goToURL("https://es-la.facebook.com/");
			}
		});

	}

	public void goToURL(String URL) {
		if (java.awt.Desktop.isDesktopSupported()) {
			java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

			if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
				try {
					java.net.URI uri = new java.net.URI(URL);
					desktop.browse(uri);
				} catch (URISyntaxException | IOException ex) {
					Logger.getLogger(registro_empresa.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
	}
}