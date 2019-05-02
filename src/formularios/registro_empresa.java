package formularios;

import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.MaskFormatter;

import com.placeholder.PlaceHolder;

import clases.empresa;
import consultas.consultas_empresa;
import utilidades.visor_imagen;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;

public class registro_empresa extends JFrame {
	public JScrollPane scrollFunciones;
	public PlaceHolder pista;
	public JButton btnActualizarEmpresa;
	public JButton btnGuardarEmpresa;
	public JButton btnSubirFotoEmpresa;
	public JButton btnSubirLogoEmpresa;
	public JButton btnVerFotoEmpresa;
	public JButton btnActualizarDatos;
	public JButton btnVerLogoEmpresa;
	public JButton btnCancelar;
	public JLabel lblFotoEmpresa;
	public JLabel lblLogoEmpresa;
	public JPanel contentPane;

	public static String ruta;
	public static ImageIcon imagen;
	public static ImageIcon imagenLogo;
	public static ImageIcon imagenFoto;

	public TableRowSorter<TableModel> trsfiltroCodigo;
	String filtroCodigo;

	public ImageIcon logoCanal = new ImageIcon(getClass().getResource("/material/logo.png"));
	public ImageIcon logoEmpresa = new ImageIcon(getClass().getResource("/material/logoEmpresa.jpg"));
	public ImageIcon icono = new ImageIcon(getClass().getResource("/material/libro.png"));
	public ImageIcon icono2 = new ImageIcon(getClass().getResource("/material/libreta.png"));
	public ImageIcon logofacebook = new ImageIcon(getClass().getResource("/material/logof.jpg"));
	public ImageIcon logoyoutube = new ImageIcon(getClass().getResource("/material/logoy.jpg"));
	public ImageIcon logowhatsapp = new ImageIcon(getClass().getResource("/material/logow.jpg"));
	public JTextField txtCodigoEmpresa;
	public JTextField txtNombreEmpresa;
	public JTextField txtDireccionLogoEmpresa;
	public JFormattedTextField txtTelefonoEmpresa;
	public JFormattedTextField txtRTNempresa;
	public JTextField txtCorreoEmpresa;
	public JTextField txtDireccionFotoEmpresa;
	public JTextArea txtDireccionEmpresa;
	public JTextArea txtCuentaEmpresa;

	public registro_empresa() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 808, 580);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/material/logo.png")));

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

		btnActualizarDatos = new JButton("Actualizar Datos");
		btnActualizarDatos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				txtCodigoEmpresa.setEditable(true);
				txtNombreEmpresa.setEditable(true);
				txtDireccionEmpresa.setEditable(true);
				txtDireccionEmpresa.setBackground(Color.WHITE);
				txtTelefonoEmpresa.setEditable(true);
				txtRTNempresa.setEditable(true);
				txtDireccionLogoEmpresa.setVisible(true);
				txtDireccionFotoEmpresa.setVisible(true);
				txtCorreoEmpresa.setEditable(true);
				txtCuentaEmpresa.setEditable(true);
				txtCuentaEmpresa.setBackground(Color.white);
				btnActualizarEmpresa.setVisible(true);
				btnGuardarEmpresa.setVisible(false);
				btnCancelar.setVisible(true);
				btnSubirFotoEmpresa.setVisible(true);
				btnSubirLogoEmpresa.setVisible(true);
				btnVerFotoEmpresa.setVisible(false);
				btnVerLogoEmpresa.setVisible(false);
				btnActualizarDatos.setVisible(false);

			}
		});
		btnActualizarDatos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnActualizarDatos.setBackground(new Color(60, 179, 113));
		btnActualizarDatos.setBounds(518, 8, 138, 23);
		contentPane.add(btnActualizarDatos);

		JPanel panelRegistro = new JPanel();
		panelRegistro.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		panelRegistro.setBounds(28, 56, 740, 462);
		contentPane.add(panelRegistro);
		panelRegistro.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(395, 34, 309, 404);
		panelRegistro.add(panel);
		panel.setLayout(null);

		btnGuardarEmpresa = new JButton("Guardar");
		btnGuardarEmpresa.setBounds(27, 375, 99, 23);
		panel.add(btnGuardarEmpresa);
		btnGuardarEmpresa.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnGuardarEmpresa.setBackground(new Color(60, 179, 113));

		btnActualizarEmpresa = new JButton("Actualizar");
		btnActualizarEmpresa.setBounds(200, 375, 99, 23);
		panel.add(btnActualizarEmpresa);
		btnActualizarEmpresa.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnActualizarEmpresa.setBackground(new Color(60, 179, 113));

		lblFotoEmpresa = new JLabel();
		lblFotoEmpresa.setBounds(27, 236, 164, 129);
		panel.add(lblFotoEmpresa);
		final ImageIcon logo00 = new ImageIcon(logoEmpresa.getImage().getScaledInstance(lblFotoEmpresa.getWidth(),
				lblFotoEmpresa.getHeight(), Image.SCALE_DEFAULT));
		lblFotoEmpresa.setIcon(logo00);

		btnVerFotoEmpresa = new JButton("Ver");
		btnVerFotoEmpresa.setBounds(203, 280, 83, 23);
		panel.add(btnVerFotoEmpresa);
		btnVerFotoEmpresa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				verFoto();
			}
		});
		btnVerFotoEmpresa.setBackground(Color.WHITE);

		btnSubirFotoEmpresa = new JButton("Subir");
		btnSubirFotoEmpresa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selecionarFoto();
			}
		});
		btnSubirFotoEmpresa.setBounds(203, 246, 83, 23);
		panel.add(btnSubirFotoEmpresa);
		btnSubirFotoEmpresa.setBackground(new Color(250, 128, 114));

		txtDireccionFotoEmpresa = new JTextField();
		txtDireccionFotoEmpresa.setBounds(28, 195, 258, 20);
		panel.add(txtDireccionFotoEmpresa);
		txtDireccionFotoEmpresa.setEditable(false);
		txtDireccionFotoEmpresa.setColumns(10);
		InputMap map18 = txtDireccionFotoEmpresa.getInputMap(JComponent.WHEN_FOCUSED);
		map18.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

		JLabel lblFotografiaDelLocal = new JLabel("Fotografia del local de la empresa.");
		lblFotografiaDelLocal.setBounds(27, 213, 258, 17);
		panel.add(lblFotografiaDelLocal);
		lblFotografiaDelLocal.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));

		lblLogoEmpresa = new JLabel();
		lblLogoEmpresa.setBounds(27, 55, 164, 129);
		panel.add(lblLogoEmpresa);
		final ImageIcon logo5 = new ImageIcon(logoCanal.getImage().getScaledInstance(lblLogoEmpresa.getWidth(),
				lblLogoEmpresa.getHeight(), Image.SCALE_DEFAULT));
		lblLogoEmpresa.setIcon(logo5);

		btnVerLogoEmpresa = new JButton("Ver");
		btnVerLogoEmpresa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				verLogo();
			}
		});
		btnVerLogoEmpresa.setBounds(203, 99, 83, 23);
		panel.add(btnVerLogoEmpresa);
		btnVerLogoEmpresa.setBackground(Color.WHITE);

		btnSubirLogoEmpresa = new JButton("Subir");
		btnSubirLogoEmpresa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				selecionarLogo();
			}
		});
		btnSubirLogoEmpresa.setBounds(203, 65, 83, 23);
		panel.add(btnSubirLogoEmpresa);
		btnSubirLogoEmpresa.setBackground(new Color(250, 128, 114));

		txtDireccionLogoEmpresa = new JTextField();
		txtDireccionLogoEmpresa.setBounds(27, 11, 258, 20);
		panel.add(txtDireccionLogoEmpresa);
		txtDireccionLogoEmpresa.setEditable(false);
		txtDireccionLogoEmpresa.setColumns(10);
		InputMap map17 = txtDireccionLogoEmpresa.getInputMap(JComponent.WHEN_FOCUSED);
		map17.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

		JLabel lblLogoOficialDe = new JLabel("Logo Oficial de la empresa.");
		lblLogoOficialDe.setBounds(27, 30, 259, 17);
		panel.add(lblLogoOficialDe);
		lblLogoOficialDe.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				txtCodigoEmpresa.setVisible(false);
				txtNombreEmpresa.setEditable(false);
				txtDireccionEmpresa.setEditable(false);
				txtDireccionEmpresa.setBackground(Color.lightGray);
				txtTelefonoEmpresa.setEditable(false);
				txtRTNempresa.setEditable(false);
				txtDireccionLogoEmpresa.setVisible(false);
				txtDireccionFotoEmpresa.setVisible(false);
				txtCorreoEmpresa.setEditable(false);
				txtCuentaEmpresa.setEditable(false);
				txtCuentaEmpresa.setBackground(Color.lightGray);

				btnActualizarEmpresa.setVisible(false);
				btnGuardarEmpresa.setVisible(false);
				btnCancelar.setVisible(false);
				btnSubirFotoEmpresa.setVisible(false);
				btnSubirLogoEmpresa.setVisible(false);
				btnVerFotoEmpresa.setVisible(true);
				btnVerLogoEmpresa.setVisible(true);
				btnCancelar.setVisible(false);

				btnActualizarDatos.setVisible(true);

			}
		});
		btnCancelar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnCancelar.setBackground(new Color(60, 179, 113));
		btnCancelar.setBounds(200, 341, 99, 23);
		panel.add(btnCancelar);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(38, 34, 326, 404);
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
		InputMap map10 = txtNombreEmpresa.getInputMap(JComponent.WHEN_FOCUSED);
		map10.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

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

		txtDireccionEmpresa = new JTextArea();
		scrollPane.setViewportView(txtDireccionEmpresa);
		InputMap map11 = txtDireccionEmpresa.getInputMap(JComponent.WHEN_FOCUSED);
		map11.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

		JLabel lblTelefono = new JLabel("Telefono :");
		lblTelefono.setBounds(10, 119, 83, 14);
		panel_1.add(lblTelefono);
		lblTelefono.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

		MaskFormatter formato = null;
		try {
			formato = new MaskFormatter("####-####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtTelefonoEmpresa = new JFormattedTextField(formato);
		txtTelefonoEmpresa.setBounds(93, 116, 210, 20);
		panel_1.add(txtTelefonoEmpresa);
		txtTelefonoEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		txtTelefonoEmpresa.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtTelefonoEmpresa.setColumns(10);
		InputMap map12 = txtTelefonoEmpresa.getInputMap(JComponent.WHEN_FOCUSED);
		map12.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtTelefonoEmpresa.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();
				if ((c < '0' || c > '9'))
					ke.consume();
			}

			@Override
			public void keyPressed(KeyEvent ke) {
			}

			@Override
			public void keyReleased(KeyEvent ke) {
			}
		});

		JLabel lblRtn = new JLabel("RTN :");
		lblRtn.setBounds(10, 147, 83, 14);
		panel_1.add(lblRtn);
		lblRtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

		MaskFormatter formato1 = null;
		try {
			formato1 = new MaskFormatter("##############");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtRTNempresa = new JFormattedTextField(formato1);
		txtRTNempresa.setBounds(93, 144, 210, 20);
		panel_1.add(txtRTNempresa);
		txtRTNempresa.setHorizontalAlignment(SwingConstants.CENTER);
		txtRTNempresa.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtRTNempresa.setColumns(10);
		InputMap map13 = txtRTNempresa.getInputMap(JComponent.WHEN_FOCUSED);
		map13.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtRTNempresa.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();
				if ((c < '0' || c > '9'))
					ke.consume();
			}

			@Override
			public void keyPressed(KeyEvent ke) {
			}

			@Override
			public void keyReleased(KeyEvent ke) {
			}
		});

		txtCorreoEmpresa = new JTextField();
		txtCorreoEmpresa.setBounds(93, 172, 210, 20);
		panel_1.add(txtCorreoEmpresa);
		txtCorreoEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		txtCorreoEmpresa.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtCorreoEmpresa.setColumns(10);
		InputMap map14 = txtCorreoEmpresa.getInputMap(JComponent.WHEN_FOCUSED);
		map14.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

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

		txtCuentaEmpresa = new JTextArea();
		scrollPane_1.setViewportView(txtCuentaEmpresa);
		InputMap map15 = txtCuentaEmpresa.getInputMap(JComponent.WHEN_FOCUSED);
		map15.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

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

		txtCodigoEmpresa = new JTextField();
		txtCodigoEmpresa.setBounds(10, 373, 50, 20);
		txtCodigoEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigoEmpresa.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtCodigoEmpresa.setEditable(false);
		txtCodigoEmpresa.setColumns(10);
		panel_1.add(txtCodigoEmpresa);
		InputMap map16 = txtCodigoEmpresa.getInputMap(JComponent.WHEN_FOCUSED);
		map16.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

		JLabel lblLibreta = new JLabel();
		lblLibreta.setBounds(0, 0, 740, 462);
		panelRegistro.add(lblLibreta);
		final ImageIcon logo3 = new ImageIcon(
				icono.getImage().getScaledInstance(lblLibreta.getWidth(), lblLibreta.getHeight(), Image.SCALE_DEFAULT));
		lblLibreta.setIcon(logo3);

		btnWhatsapp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				goToURL("https://www.whatsapp.com/");
			}
		});
		btnYoutube.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				goToURL("https://www.youtube.com/");
			}
		});
		btnFacebook.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				goToURL("https://es-la.facebook.com/");
			}
		});

	}

	public void mostrarEmpresa() {
		consultas_empresa consulta = new consultas_empresa();
		empresa clase = new empresa();
		if (consulta.buscar(clase)) {
			txtCodigoEmpresa.setText(String.valueOf(clase.getId_empresa()));
			txtNombreEmpresa.setText(String.valueOf(clase.getNombre_empresa()));
			txtDireccionEmpresa.setText(String.valueOf(clase.getDireccion_empresa()));
			txtTelefonoEmpresa.setText(String.valueOf(clase.getTelefono_empresa()));
			txtRTNempresa.setText(String.valueOf(clase.getRtn_empresa()));
			txtDireccionLogoEmpresa.setText(String.valueOf(clase.getDireccion_logo_empresa()));
			txtDireccionFotoEmpresa.setText(String.valueOf(clase.getDireccion_foto_empresa()));
			txtCorreoEmpresa.setText(String.valueOf(clase.getCorreo_empresa()));
			txtCuentaEmpresa.setText(String.valueOf(clase.getCuenta_bancaria_empresa()));
			txtCodigoEmpresa.setVisible(false);
			txtNombreEmpresa.setEditable(false);
			txtDireccionEmpresa.setEditable(false);
			txtDireccionEmpresa.setBackground(Color.lightGray);
			txtTelefonoEmpresa.setEditable(false);
			txtRTNempresa.setEditable(false);
			txtDireccionLogoEmpresa.setVisible(false);
			txtDireccionFotoEmpresa.setVisible(false);
			txtCorreoEmpresa.setEditable(false);
			txtCuentaEmpresa.setEditable(false);
			txtCuentaEmpresa.setBackground(Color.lightGray);
			btnActualizarEmpresa.setVisible(false);
			btnGuardarEmpresa.setVisible(false);
			btnCancelar.setVisible(false);
			btnSubirFotoEmpresa.setVisible(false);
			btnSubirLogoEmpresa.setVisible(false);
			btnVerFotoEmpresa.setVisible(true);
			btnVerLogoEmpresa.setVisible(true);
			btnCancelar.setVisible(false);

			String foto = txtDireccionFotoEmpresa.getText().toString();
			String logo = txtDireccionLogoEmpresa.getText().toString();
			final ImageIcon foto_empresa = new ImageIcon(foto);
			final ImageIcon logo1 = new ImageIcon(foto_empresa.getImage().getScaledInstance(lblFotoEmpresa.getWidth(),
					lblFotoEmpresa.getHeight(), Image.SCALE_DEFAULT));
			lblFotoEmpresa.setIcon(logo1);
			final ImageIcon logo_empresa = new ImageIcon(logo);
			final ImageIcon logo2 = new ImageIcon(logo_empresa.getImage().getScaledInstance(lblLogoEmpresa.getWidth(),
					lblLogoEmpresa.getHeight(), Image.SCALE_DEFAULT));
			lblLogoEmpresa.setIcon(logo2);
		} else {
			JOptionPane.showMessageDialog(null, "No se encontro ningun registro");
			JOptionPane.showMessageDialog(null, "Por favor ingrese los datos de la empresa.");
			txtNombreEmpresa.requestFocusInWindow();
			btnGuardarEmpresa.setVisible(true);
			btnActualizarEmpresa.setVisible(false);
			txtDireccionFotoEmpresa.setVisible(true);
			txtDireccionLogoEmpresa.setVisible(true);
			btnSubirFotoEmpresa.setVisible(true);
			btnSubirFotoEmpresa.setVisible(true);
		}
	}

	public void selecionarFoto() {
		JFileChooser archivo = new JFileChooser();
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Formatos de Archivos JPEG(*.JPG;*.JPEG)", "jpg",
				"jpeg");
		archivo.addChoosableFileFilter(filtro);
		archivo.setDialogTitle("Abrir Archivo");
		File ruta = new File("C:\\Users\\hp\\Documents\\GitHub\\Proyecto_Administrativo\\fotografias_empleados");
		archivo.setCurrentDirectory(ruta);
		int ventana = archivo.showOpenDialog(null);
		if (ventana == JFileChooser.APPROVE_OPTION) {
			File file = archivo.getSelectedFile();
			txtDireccionFotoEmpresa.setText(String.valueOf(file));
			Image foto = getToolkit().getImage(txtDireccionFotoEmpresa.getText());
			foto = foto.getScaledInstance(lblFotoEmpresa.getHeight(), lblFotoEmpresa.getWidth(), Image.SCALE_DEFAULT);
			lblFotoEmpresa.setIcon(new ImageIcon(foto));
		}
	}

	public void selecionarLogo() {
		JFileChooser archivo = new JFileChooser();
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Formatos de Archivos JPEG(*.JPG;*.JPEG)", "jpg",
				"jpeg");
		archivo.addChoosableFileFilter(filtro);
		archivo.setDialogTitle("Abrir Archivo");
		File ruta = new File("C:\\Users\\hp\\Documents\\GitHub\\Proyecto_Administrativo\\fotografias_empleados");
		archivo.setCurrentDirectory(ruta);
		int ventana = archivo.showOpenDialog(null);
		if (ventana == JFileChooser.APPROVE_OPTION) {
			File file = archivo.getSelectedFile();
			txtDireccionLogoEmpresa.setText(String.valueOf(file));
			Image foto = getToolkit().getImage(txtDireccionLogoEmpresa.getText());
			foto = foto.getScaledInstance(lblLogoEmpresa.getHeight(), lblLogoEmpresa.getWidth(), Image.SCALE_DEFAULT);
			lblLogoEmpresa.setIcon(new ImageIcon(foto));
		}
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

	public void verFoto() {
		if (txtDireccionFotoEmpresa.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hay imagen que mostrar");
		} else {
			visor_imagen visor = new visor_imagen();
			ruta = txtDireccionFotoEmpresa.getText().toString();
			visor.txtRutaImagen.setText(ruta);
			visor.setVisible(true);
			visor.setLocationRelativeTo(null);
			imagen = new ImageIcon(ruta);
			visor_imagen.lblImagen.setIcon(imagen);
		}
	}

	public void verLogo() {
		if (txtDireccionLogoEmpresa.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hay imagen que mostrar");
		} else {
			visor_imagen visor = new visor_imagen();
			ruta = txtDireccionLogoEmpresa.getText().toString();
			visor.txtRutaImagen.setText(ruta);
			visor.setVisible(true);
			visor.setLocationRelativeTo(null);
			imagen = new ImageIcon(ruta);
			visor_imagen.lblImagen.setIcon(imagen);
		}
	}

	public void pistas() {
		pista = new PlaceHolder(txtNombreEmpresa, "Ingrese el nombre de la empresa.");
		pista = new PlaceHolder(txtDireccionEmpresa, "Ingrese la direccion de la empresa.");
		pista = new PlaceHolder(txtCorreoEmpresa, "Ingrese el correo del la empresa.");
		pista = new PlaceHolder(txtCuentaEmpresa, "Escriba la o las cuentas bancarias.");
	}

}
