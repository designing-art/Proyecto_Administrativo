package formularios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableRowSorter;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Event;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.RowFilter;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.Timer;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.InputMap;

import com.mysql.cj.xdevapi.Statement;
import com.placeholder.PlaceHolder;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import clases.cargo;
import clases.empleado;
import conexion.conexion;
import consultas.consultas_empleado;
import controles.control_empleado;
import utilidades.visor_imagen;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class registro_empleados extends JFrame {

	JPanel contentPane;
	public JTextField txtCodigoEmpleado;
	public JTextField txtNombresEmpleado;
	public JTextField txtApellidosEmpleado;
	public JTextField txtCorreoEmpleado;
	public JFormattedTextField txtIdentidadEmpleado;
	public JTextField txtNombreReferencia;
	public JTextField txtTelefonoReferencia;
	public JTextField txtEdadEmpleado;
	public JFormattedTextField txtTelefonoEmpleado;
	public JComboBox<?> cbxGeneroEmpleado;
	public JComboBox<?> cbxEstadoEmpleado;
	public JLabel lblFotoEmpleado;
	public JScrollPane scrollPane;
	public JTextArea txtDireccionEmpleado;
	public JDateChooser dateFechaLabores;
	public JDateChooser dateFechaRegistro;
	public JDateChooser dateFechaNacimiento;
	public PlaceHolder pista;
	public JButton btnVerFotoEmpleado;
	public static String ruta;
	public static ImageIcon imagen;
	public JLabel lblFechaDeRegistro;

	public JTextFieldDateEditor editor;
	public JTextFieldDateEditor editor2;
	public JTextFieldDateEditor editor3;

	public JTextField txtBusquedaEmpleado;
	public JLabel lblAreasDelModulo;
	public JComboBox comboBox;
	public JLabel label_4;
	public JLabel lblCantidadTotalDe;
	public JTextField textField_1;
	public JLabel lblPaginaN;
	public JTextField textField_2;
	public JLabel lblDe;
	public JTextField textField_3;
	public JButton btnMenuInicial;
	public JTable tablaEmpleados;
	public JScrollPane barraTablaEmpleados;
	public JTextArea txtObligacionesAsignado;

	public TableRowSorter trsfiltroCodigoEmpleado;
	String filtroCodigoEmpleado;

	public JButton btnBorrarEmpleado;
	public JButton btnActualizarDatosEmpleado;
	public JButton btnMostrarEmpleado;
	public JButton btnNuevoEmpleado;

	public JButton btnTomarFoto;
	public JButton btnSubirFoto;
	public JButton btnCalcularEdad;

	public JButton btnGuardarEmpleado;
	public JButton btnActualizarEmpleado;
	public JButton btnCancelarEmpleado;
	public JButton btnAgregarEdad;
	public JTextField txtDireccionFoto;
	public JTextField textField;
	public JLabel label_3;
	public JTextField txtSueldoAsignado;
	public JTextField txtHoraExtraAsignado;
	public JTextField txtDiasAsignado;
	public JTextField txtHorasAsignado;
	public JLabel lblContrato;
	public static JComboBox<String> cbxContratoAsignado;
	public static JComboBox<String> cbxCargoAsignado;
	public static JComboBox<String> cbxHorarioAsignado;
	public JLabel lblTipo;
	public JTextField txtFotoContratoAsignado;
	public JLabel lblTiempo;
	public JTextField txtTiempoContratoAsignado;
	public JLabel lblAsignacionesYLista;

	public int contador1 = 0;
	public int contador2 = 0;
	public int contador3 = 0;
	public JButton btnNewButton;
	public JTextField txtTipoContratoAsignado;
	public JLabel lblTipo_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					registro_empleados frame = new registro_empleados();
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
	public registro_empleados() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1221, 720);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/material/logo.png")));
		final ImageIcon icono = new ImageIcon(getClass().getResource("/material/libreta.png"));
		final ImageIcon icono1 = new ImageIcon(getClass().getResource("/material/logo.png"));
		final ImageIcon lista_empleados = new ImageIcon(getClass().getResource("/material/lista_empleados.png"));

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 45, 579, 635);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblDatosGenerales = new JLabel("Datos del registro :");
		lblDatosGenerales.setBounds(39, 58, 151, 29);
		panel.add(lblDatosGenerales);
		lblDatosGenerales.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));

		JLabel lblCodigo = new JLabel("1. Codigo :");
		lblCodigo.setBounds(39, 92, 83, 17);
		panel.add(lblCodigo);
		lblCodigo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

		txtCodigoEmpleado = new JTextField();
		txtCodigoEmpleado.setBounds(122, 92, 50, 20);
		panel.add(txtCodigoEmpleado);
		txtCodigoEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtCodigoEmpleado.setEditable(false);
		txtCodigoEmpleado.setColumns(10);
		txtCodigoEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		InputMap map9 = txtCodigoEmpleado.getInputMap(JComponent.WHEN_FOCUSED);
		map9.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

		JLabel lblNombres = new JLabel("2. Nombres :");
		lblNombres.setBounds(39, 118, 83, 14);
		panel.add(lblNombres);
		lblNombres.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

		txtNombresEmpleado = new JTextField();
		txtNombresEmpleado.setBounds(122, 115, 210, 20);
		panel.add(txtNombresEmpleado);
		txtNombresEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtNombresEmpleado.setColumns(10);
		InputMap map5 = txtNombresEmpleado.getInputMap(JComponent.WHEN_FOCUSED);
		map5.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtNombresEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombresEmpleado.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();
				if (Character.isDigit(c)) {
					Toolkit.getDefaultToolkit().beep();
					ke.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent ke) {
			}

			@Override
			public void keyReleased(KeyEvent ke) {
			}
		});

		JLabel lblApellidos = new JLabel("3. Apellidos :");
		lblApellidos.setBounds(39, 142, 83, 14);
		panel.add(lblApellidos);
		lblApellidos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		InputMap map6 = lblApellidos.getInputMap(JComponent.WHEN_FOCUSED);
		map6.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

		txtApellidosEmpleado = new JTextField();
		txtApellidosEmpleado.setBounds(122, 139, 210, 20);
		panel.add(txtApellidosEmpleado);
		txtApellidosEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtApellidosEmpleado.setColumns(10);
		txtApellidosEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		InputMap map7 = txtApellidosEmpleado.getInputMap(JComponent.WHEN_FOCUSED);
		map7.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtApellidosEmpleado.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();
				if (Character.isDigit(c)) {
					Toolkit.getDefaultToolkit().beep();
					ke.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent ke) {
			}

			@Override
			public void keyReleased(KeyEvent ke) {
			}
		});

		JLabel lblIdentidad = new JLabel("4. Identidad :");
		lblIdentidad.setBounds(39, 168, 83, 14);
		panel.add(lblIdentidad);
		lblIdentidad.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

		MaskFormatter formato = null;
		try {
			formato = new MaskFormatter("####-####-#####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtIdentidadEmpleado = new JFormattedTextField(formato);
		txtIdentidadEmpleado.setBounds(122, 165, 210, 20);
		txtIdentidadEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtIdentidadEmpleado.setColumns(10);
		txtIdentidadEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(txtIdentidadEmpleado);
		InputMap map2 = txtIdentidadEmpleado.getInputMap(JComponent.WHEN_FOCUSED);
		map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtIdentidadEmpleado.addKeyListener(new KeyListener() {
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

		JLabel lblEdad = new JLabel("10. Edad :");
		lblEdad.setBounds(39, 362, 83, 14);
		panel.add(lblEdad);
		lblEdad.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

		txtEdadEmpleado = new JTextField();
		txtEdadEmpleado.setBounds(199, 356, 111, 20);
		txtEdadEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtEdadEmpleado.setColumns(10);
		txtEdadEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(txtEdadEmpleado);
		txtEdadEmpleado.setEditable(false);

		JLabel lblGenero = new JLabel("5. Genero :");
		lblGenero.setBounds(39, 193, 76, 17);
		panel.add(lblGenero);
		lblGenero.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

		cbxGeneroEmpleado = new JComboBox();
		cbxGeneroEmpleado.setBounds(122, 193, 50, 20);
		panel.add(cbxGeneroEmpleado);
		cbxGeneroEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		cbxGeneroEmpleado.setModel(new DefaultComboBoxModel(new String[] { "M", "F" }));

		JLabel lblCorreo = new JLabel("6. Correo :");
		lblCorreo.setBounds(39, 218, 83, 14);
		panel.add(lblCorreo);
		lblCorreo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

		txtCorreoEmpleado = new JTextField();
		txtCorreoEmpleado.setBounds(122, 218, 210, 20);
		panel.add(txtCorreoEmpleado);
		txtCorreoEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtCorreoEmpleado.setColumns(10);
		txtCorreoEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		InputMap map8 = txtCorreoEmpleado.getInputMap(JComponent.WHEN_FOCUSED);
		map8.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

		JLabel lblTelefonos = new JLabel("7.Nº Celular :");
		lblTelefonos.setBounds(39, 244, 83, 14);
		panel.add(lblTelefonos);
		lblTelefonos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

		MaskFormatter formatter1 = null;
		try {
			formatter1 = new MaskFormatter("+504 ####-####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtTelefonoEmpleado = new JFormattedTextField(formatter1);
		txtTelefonoEmpleado.setBounds(122, 243, 210, 20);
		panel.add(txtTelefonoEmpleado);
		txtTelefonoEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtTelefonoEmpleado.setColumns(10);
		txtTelefonoEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		InputMap map3 = txtTelefonoEmpleado.getInputMap(JComponent.WHEN_FOCUSED);
		map3.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtTelefonoEmpleado.addKeyListener(new KeyListener() {
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

		JLabel lblDireccion = new JLabel("8. Direccion :");
		lblDireccion.setBounds(39, 269, 83, 14);
		panel.add(lblDireccion);
		lblDireccion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

		JLabel lblFechaDeNacimiento = new JLabel("9. Fecha de nacimiento :");
		lblFechaDeNacimiento.setBounds(39, 331, 167, 20);
		panel.add(lblFechaDeNacimiento);
		lblFechaDeNacimiento.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

		lblFechaDeRegistro = new JLabel("14. Fecha de registro :");
		lblFechaDeRegistro.setBounds(39, 504, 157, 20);
		panel.add(lblFechaDeRegistro);
		lblFechaDeRegistro.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblFechaDeRegistro.setVisible(false);

		JLabel lblFechaDeComienso = new JLabel("13. Fecha inicio labores :");
		lblFechaDeComienso.setBounds(39, 478, 167, 20);
		panel.add(lblFechaDeComienso);
		lblFechaDeComienso.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

		dateFechaLabores = new JDateChooser();
		dateFechaLabores.setBounds(199, 478, 133, 20);
		dateFechaLabores.setDateFormatString("dd-MMMMM-yyyy");
		panel.add(dateFechaLabores);
		editor = (JTextFieldDateEditor) dateFechaLabores.getDateEditor();
		editor.setEditable(false);
		editor.setHorizontalAlignment(SwingConstants.CENTER);

		dateFechaRegistro = new JDateChooser();
		dateFechaRegistro.setBounds(199, 504, 133, 20);
		dateFechaRegistro.setDateFormatString("dd-MMMMM-yyyy");
		panel.add(dateFechaRegistro);
		editor2 = (JTextFieldDateEditor) dateFechaRegistro.getDateEditor();
		editor2.setEditable(false);
		editor2.setHorizontalAlignment(SwingConstants.CENTER);
		dateFechaRegistro.setVisible(false);

		dateFechaNacimiento = new JDateChooser();
		dateFechaNacimiento.setBounds(199, 331, 132, 20);
		dateFechaNacimiento.setDateFormatString("dd-MMMMM-yyyy");
		panel.add(dateFechaNacimiento);
		editor3 = (JTextFieldDateEditor) dateFechaNacimiento.getDateEditor();
		editor3.setEditable(false);
		editor3.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel label_1 = new JLabel("");
		label_1.setBounds(471, 58, 72, 62);
		panel.add(label_1);
		final ImageIcon logo1 = new ImageIcon(
				icono1.getImage().getScaledInstance(label_1.getWidth(), label_1.getHeight(), Image.SCALE_DEFAULT));
		label_1.setIcon(logo1);

		JLabel lblReferencia = new JLabel("11. Nombre completo de referencia :");
		lblReferencia.setBounds(39, 387, 248, 23);
		panel.add(lblReferencia);
		lblReferencia.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

		txtNombreReferencia = new JTextField();
		txtNombreReferencia.setBounds(39, 407, 293, 20);
		panel.add(txtNombreReferencia);
		txtNombreReferencia.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtNombreReferencia.setColumns(10);
		txtNombreReferencia.setHorizontalAlignment(SwingConstants.CENTER);
		InputMap map14 = txtNombreReferencia.getInputMap(JComponent.WHEN_FOCUSED);
		map14.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtNombreReferencia.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();
				if (Character.isDigit(c)) {
					Toolkit.getDefaultToolkit().beep();
					ke.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent ke) {
			}

			@Override
			public void keyReleased(KeyEvent ke) {
			}
		});

		JLabel lblTelefonoDeLa = new JLabel("12.Nº Celular Referencia:");
		lblTelefonoDeLa.setBounds(39, 432, 202, 14);
		panel.add(lblTelefonoDeLa);
		lblTelefonoDeLa.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

		MaskFormatter formatter3 = null;
		try {
			formatter3 = new MaskFormatter("+504 ####-####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtTelefonoReferencia = new JFormattedTextField(formatter3);
		txtTelefonoReferencia.setBounds(39, 447, 293, 20);
		panel.add(txtTelefonoReferencia);
		txtTelefonoReferencia.setHorizontalAlignment(SwingConstants.CENTER);
		txtTelefonoReferencia.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtTelefonoReferencia.setColumns(10);
		InputMap map4 = txtTelefonoReferencia.getInputMap(JComponent.WHEN_FOCUSED);
		map4.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtTelefonoReferencia.addKeyListener(new KeyListener() {
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

		JLabel lblEstado = new JLabel("16. Estado :");
		lblEstado.setBounds(354, 390, 83, 14);
		panel.add(lblEstado);
		lblEstado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

		cbxEstadoEmpleado = new JComboBox();
		cbxEstadoEmpleado.setBounds(461, 387, 82, 20);
		panel.add(cbxEstadoEmpleado);
		cbxEstadoEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		cbxEstadoEmpleado.setModel(new DefaultComboBoxModel(new String[] { "Activo", "Inactivo" }));

		scrollPane = new JScrollPane();
		scrollPane.setBounds(122, 271, 210, 55);
		panel.add(scrollPane);

		txtDireccionEmpleado = new JTextArea();
		scrollPane.setViewportView(txtDireccionEmpleado);
		InputMap map90 = txtDireccionEmpleado.getInputMap(JComponent.WHEN_FOCUSED);
		map90.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

		btnTomarFoto = new JButton("Tomar");
		btnTomarFoto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				tomarFoto();
			}
		});
		btnTomarFoto.setBackground(new Color(0, 255, 127));
		btnTomarFoto.setBounds(354, 114, 83, 23);
		panel.add(btnTomarFoto);

		btnSubirFoto = new JButton("Subir");
		btnSubirFoto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selecionarFoto();
			}
		});
		btnSubirFoto.setBackground(new Color(250, 128, 114));
		btnSubirFoto.setBounds(354, 139, 83, 23);
		panel.add(btnSubirFoto);

		JLabel lblFoto = new JLabel("15. Foto :");
		lblFoto.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblFoto.setBounds(354, 92, 83, 17);
		panel.add(lblFoto);

		btnCancelarEmpleado = new JButton("Cancelar");
		btnCancelarEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnCancelarEmpleado.setBackground(new Color(255, 255, 255));
		btnCancelarEmpleado.setBounds(39, 548, 99, 23);
		panel.add(btnCancelarEmpleado);

		btnActualizarEmpleado = new JButton("Actualizar");
		btnActualizarEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnActualizarEmpleado.setBackground(new Color(60, 179, 113));
		btnActualizarEmpleado.setBounds(444, 548, 99, 23);
		panel.add(btnActualizarEmpleado);

		btnNuevoEmpleado = new JButton("Nuevo");
		btnNuevoEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnNuevoEmpleado.setBackground(new Color(255, 255, 255));
		btnNuevoEmpleado.setBounds(39, 571, 99, 23);
		panel.add(btnNuevoEmpleado);

		btnGuardarEmpleado = new JButton("Guardar");
		btnGuardarEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnGuardarEmpleado.setBackground(new Color(60, 179, 113));
		btnGuardarEmpleado.setBounds(444, 571, 99, 23);
		panel.add(btnGuardarEmpleado);

		txtDireccionFoto = new JTextField();
		txtDireccionFoto.setEditable(false);
		txtDireccionFoto.setBounds(354, 166, 189, 20);
		panel.add(txtDireccionFoto);
		txtDireccionFoto.setColumns(10);
		InputMap map10 = txtDireccionFoto.getInputMap(JComponent.WHEN_FOCUSED);
		map10.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

		btnCalcularEdad = new JButton();
		btnCalcularEdad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (editor3.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor ingrese su fecha de nacimiento");
				} else {
					calcularEdad();
				}

			}
		});
		btnCalcularEdad.setBackground(new Color(220, 20, 60));
		btnCalcularEdad.setBounds(308, 356, 24, 20);
		panel.add(btnCalcularEdad);
		final ImageIcon iconoFoto = new ImageIcon(getClass().getResource("/material/usuario.png"));

		lblFotoEmpleado = new JLabel();
		lblFotoEmpleado.setBounds(354, 193, 189, 183);
		panel.add(lblFotoEmpleado);
		final ImageIcon logoFoto = new ImageIcon(iconoFoto.getImage().getScaledInstance(lblFotoEmpleado.getWidth(),
				lblFotoEmpleado.getHeight(), Image.SCALE_DEFAULT));
		lblFotoEmpleado.setIcon(logoFoto);

		btnVerFotoEmpleado = new JButton("Ver");
		btnVerFotoEmpleado.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				verFotoEmpleado();
			}
		});
		btnVerFotoEmpleado.setBackground(Color.WHITE);
		btnVerFotoEmpleado.setBounds(460, 139, 83, 23);
		panel.add(btnVerFotoEmpleado);

		JLabel label = new JLabel();
		label.setBounds(0, 0, 579, 635);
		panel.add(label);
		final ImageIcon logo = new ImageIcon(
				icono.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
		label.setIcon(logo);

		JLabel lblRegistroYMantenimiento = new JLabel("REGISTRO Y MANTENIMIENTO DE EMPLEADOS");
		lblRegistroYMantenimiento.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblRegistroYMantenimiento.setBounds(10, 11, 466, 23);
		contentPane.add(lblRegistroYMantenimiento);

		JButton btnRegresar_1 = new JButton("Regresar");
		btnRegresar_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnRegresar_1.setBackground(new Color(255, 165, 0));
		btnRegresar_1.setBounds(1093, 11, 99, 23);
		contentPane.add(btnRegresar_1);
		final ImageIcon iconoo22 = new ImageIcon(getClass().getResource("/material/logo.png"));
		final ImageIcon iconoo = new ImageIcon(getClass().getResource("/material/libreta.png"));

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(599, 45, 593, 635);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblEmpleadosRegistrados = new JLabel("Empleados registrados :");
		lblEmpleadosRegistrados.setBounds(39, 284, 206, 19);
		panel_1.add(lblEmpleadosRegistrados);
		lblEmpleadosRegistrados.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));

		JLabel label_2 = new JLabel("Buscar empleado :");
		label_2.setBounds(39, 311, 142, 14);
		panel_1.add(label_2);
		label_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

		txtBusquedaEmpleado = new JTextField();
		txtBusquedaEmpleado.setBounds(158, 308, 239, 20);
		panel_1.add(txtBusquedaEmpleado);
		txtBusquedaEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtBusquedaEmpleado.setColumns(10);
		txtBusquedaEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		InputMap map41 = txtBusquedaEmpleado.getInputMap(JComponent.WHEN_FOCUSED);
		txtBusquedaEmpleado.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				trsfiltroCodigoEmpleado = new TableRowSorter(tablaEmpleados.getModel());
				tablaEmpleados.setRowSorter(trsfiltroCodigoEmpleado);
			}

			@Override
			public void keyPressed(KeyEvent ke) {

			}

			@Override
			public void keyReleased(KeyEvent ke) {
				String cadena = (txtBusquedaEmpleado.getText());
				txtBusquedaEmpleado.setText(cadena);
				repaint();
				filtro();
			}
		});

		barraTablaEmpleados = new JScrollPane(tablaEmpleados, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		barraTablaEmpleados.setBounds(39, 335, 514, 239);
		panel_1.add(barraTablaEmpleados);

		tablaEmpleados = new JTable();
		barraTablaEmpleados.setViewportView(tablaEmpleados);

		btnBorrarEmpleado = new JButton("Borrar");
		btnBorrarEmpleado.setBounds(39, 581, 99, 23);
		panel_1.add(btnBorrarEmpleado);
		btnBorrarEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnBorrarEmpleado.setBackground(new Color(220, 20, 60));

		btnMostrarEmpleado = new JButton("Ver detalles");
		btnMostrarEmpleado.setBounds(294, 581, 108, 23);
		panel_1.add(btnMostrarEmpleado);
		btnMostrarEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnMostrarEmpleado.setBackground(new Color(0, 206, 209));

		btnActualizarDatosEmpleado = new JButton("Actualizar Datos");
		btnActualizarDatosEmpleado.setBounds(416, 581, 137, 23);
		panel_1.add(btnActualizarDatosEmpleado);
		btnActualizarDatosEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnActualizarDatosEmpleado.setBackground(new Color(60, 179, 113));

		JLabel label_6 = new JLabel();
		label_6.setBounds(509, 293, 44, 32);
		panel_1.add(label_6);
		final ImageIcon logo12 = new ImageIcon(
				iconoo22.getImage().getScaledInstance(label_6.getWidth(), label_6.getHeight(), Image.SCALE_DEFAULT));
		label_6.setIcon(logo12);

		JLabel lblEmpleados = new JLabel("");
		lblEmpleados.setBounds(0, 250, 593, 385);
		panel_1.add(lblEmpleados);
		final ImageIcon logo11 = new ImageIcon(iconoo.getImage().getScaledInstance(lblEmpleados.getWidth(),
				lblEmpleados.getHeight(), Image.SCALE_DEFAULT));
		lblEmpleados.setIcon(logo11);

		JLabel lblNombreDelCargo = new JLabel("Sueldo.");
		lblNombreDelCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblNombreDelCargo.setBounds(294, 30, 83, 14);
		panel_1.add(lblNombreDelCargo);

		txtSueldoAsignado = new JTextField();
		txtSueldoAsignado.setEditable(false);
		txtSueldoAsignado.setHorizontalAlignment(SwingConstants.CENTER);
		txtSueldoAsignado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtSueldoAsignado.setColumns(10);
		txtSueldoAsignado.setBounds(294, 47, 123, 20);
		panel_1.add(txtSueldoAsignado);

		JLabel lblCargo = new JLabel("Cargo :");
		lblCargo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblCargo.setBounds(45, 50, 76, 17);
		panel_1.add(lblCargo);

		cbxCargoAsignado = new JComboBox<String>();
		cbxCargoAsignado.setBackground(Color.WHITE);
		cbxCargoAsignado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		cbxCargoAsignado.setBounds(123, 47, 152, 20);
		panel_1.add(cbxCargoAsignado);
		cbxCargoAsignado.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				conexion objCon = new conexion();
				Connection conn = objCon.getConexion();
				try {
					if (contador1 > 0) {
						PreparedStatement stmtr = conn.prepareStatement(
								"SELECT sueldo_cargo, valor_hora_extra_cargo, funciones_cargo FROM cargos where nombre_cargo = '"
										+ cbxCargoAsignado.getSelectedItem() + "'");
						ResultSet rsr = stmtr.executeQuery();
						rsr.next();
						txtSueldoAsignado.setText(rsr.getString("sueldo_cargo"));
						txtHoraExtraAsignado.setText(rsr.getString("valor_hora_extra_cargo"));
						txtObligacionesAsignado.setText(rsr.getString("funciones_cargo"));
						;
						stmtr.close();
						rsr.close();
					}
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		JLabel lblAsignacionesDelEmpleado = new JLabel("Asignaciones del empleado :");
		lblAsignacionesDelEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblAsignacionesDelEmpleado.setBounds(45, 24, 293, 19);
		panel_1.add(lblAsignacionesDelEmpleado);

		JLabel lblValorHoraExtra = new JLabel("Valor hora extra.");
		lblValorHoraExtra.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblValorHoraExtra.setBounds(423, 30, 123, 14);
		panel_1.add(lblValorHoraExtra);

		txtHoraExtraAsignado = new JTextField();
		txtHoraExtraAsignado.setEditable(false);
		txtHoraExtraAsignado.setHorizontalAlignment(SwingConstants.CENTER);
		txtHoraExtraAsignado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtHoraExtraAsignado.setColumns(10);
		txtHoraExtraAsignado.setBounds(423, 47, 123, 20);
		panel_1.add(txtHoraExtraAsignado);

		JLabel lblHorario = new JLabel("Horario :");
		lblHorario.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblHorario.setBounds(45, 136, 76, 17);
		panel_1.add(lblHorario);

		cbxHorarioAsignado = new JComboBox<String>();
		cbxHorarioAsignado.setBackground(Color.WHITE);
		cbxHorarioAsignado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		cbxHorarioAsignado.setBounds(123, 133, 152, 20);
		panel_1.add(cbxHorarioAsignado);
		cbxHorarioAsignado.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				conexion objCon = new conexion();
				Connection conn = objCon.getConexion();
				try {
					if (contador2 > 0) {
						PreparedStatement stmtr = conn.prepareStatement(
								"SELECT dias_horario, horas_horario FROM horarios where tipo_horario = '"
										+ cbxHorarioAsignado.getSelectedItem() + "'");
						ResultSet rsr = stmtr.executeQuery();
						rsr.next();
						txtDiasAsignado.setText(rsr.getString("dias_horario"));
						txtHorasAsignado.setText(rsr.getString("horas_horario"));
						;
						stmtr.close();
						rsr.close();
					}
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});

		txtDiasAsignado = new JTextField();
		txtDiasAsignado.setEditable(false);
		txtDiasAsignado.setHorizontalAlignment(SwingConstants.CENTER);
		txtDiasAsignado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtDiasAsignado.setColumns(10);
		txtDiasAsignado.setBounds(294, 133, 123, 20);
		panel_1.add(txtDiasAsignado);

		JLabel lblHoras = new JLabel("Horas.");
		lblHoras.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblHoras.setBounds(423, 116, 83, 14);
		panel_1.add(lblHoras);

		JLabel lblDias = new JLabel("Dias.");
		lblDias.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblDias.setBounds(294, 116, 123, 14);
		panel_1.add(lblDias);

		txtHorasAsignado = new JTextField();
		txtHorasAsignado.setEditable(false);
		txtHorasAsignado.setHorizontalAlignment(SwingConstants.CENTER);
		txtHorasAsignado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtHorasAsignado.setColumns(10);
		txtHorasAsignado.setBounds(423, 133, 123, 20);
		panel_1.add(txtHorasAsignado);

		lblContrato = new JLabel("Contrato :");
		lblContrato.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblContrato.setBounds(45, 184, 76, 17);
		panel_1.add(lblContrato);

		cbxContratoAsignado = new JComboBox<String>();
		cbxContratoAsignado.setBackground(Color.WHITE);
		cbxContratoAsignado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		cbxContratoAsignado.setBounds(123, 181, 152, 20);
		panel_1.add(cbxContratoAsignado);
		cbxContratoAsignado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				conexion objCon = new conexion();
				Connection conn = objCon.getConexion();
				try {
					if (contador3 > 0) {
						PreparedStatement stmtr = conn.prepareStatement(
								"SELECT identidad_contrato_empleado, tipo_contrato_empleado, tiempo_contrato_empleado, direccion_foto_contrato_empleado FROM contrato_empleado where identidad_contrato_empleado = '"
										+ cbxContratoAsignado.getSelectedItem() + "'");
						ResultSet rsr = stmtr.executeQuery();
						rsr.next();
						txtTipoContratoAsignado.setText(rsr.getString("tipo_contrato_empleado"));
						txtTiempoContratoAsignado.setText(rsr.getString("tiempo_contrato_empleado"));
						txtFotoContratoAsignado.setText(rsr.getString("direccion_foto_contrato_empleado"));
						;
						stmtr.close();
						rsr.close();
					}
					conn.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});

		lblTipo = new JLabel("Fotografia del Contrato.");
		lblTipo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblTipo.setBounds(145, 207, 152, 19);
		panel_1.add(lblTipo);

		txtFotoContratoAsignado = new JTextField();
		txtFotoContratoAsignado.setEditable(false);
		txtFotoContratoAsignado.setHorizontalAlignment(SwingConstants.CENTER);
		txtFotoContratoAsignado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtFotoContratoAsignado.setColumns(10);
		txtFotoContratoAsignado.setBounds(294, 206, 183, 20);
		panel_1.add(txtFotoContratoAsignado);

		lblTiempo = new JLabel("Tiempo");
		lblTiempo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblTiempo.setBounds(423, 164, 83, 14);
		panel_1.add(lblTiempo);

		txtTiempoContratoAsignado = new JTextField();
		txtTiempoContratoAsignado.setEditable(false);
		txtTiempoContratoAsignado.setHorizontalAlignment(SwingConstants.CENTER);
		txtTiempoContratoAsignado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtTiempoContratoAsignado.setColumns(10);
		txtTiempoContratoAsignado.setBounds(423, 181, 123, 20);
		panel_1.add(txtTiempoContratoAsignado);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(294, 73, 252, 38);
		panel_1.add(scrollPane_1);

		txtObligacionesAsignado = new JTextArea();
		txtObligacionesAsignado.setEditable(false);
		scrollPane_1.setViewportView(txtObligacionesAsignado);

		JLabel lblObligaciones = new JLabel("Obligaciones del empleado.");
		lblObligaciones.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblObligaciones.setBounds(123, 78, 174, 32);
		panel_1.add(lblObligaciones);

		btnNewButton = new JButton("Ver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verFotoEmpleado();
			}
		});
		btnNewButton.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 10));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(487, 206, 59, 21);
		panel_1.add(btnNewButton);

		txtTipoContratoAsignado = new JTextField();
		txtTipoContratoAsignado.setHorizontalAlignment(SwingConstants.CENTER);
		txtTipoContratoAsignado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtTipoContratoAsignado.setEditable(false);
		txtTipoContratoAsignado.setColumns(10);
		txtTipoContratoAsignado.setBounds(294, 181, 123, 20);
		panel_1.add(txtTipoContratoAsignado);

		lblTipo_1 = new JLabel("Tipo.");
		lblTipo_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblTipo_1.setBounds(294, 164, 123, 14);
		panel_1.add(lblTipo_1);

		label_3 = new JLabel("");
		label_3.setBounds(0, 0, 593, 250);
		panel_1.add(label_3);
		final ImageIcon logo13 = new ImageIcon(
				iconoo.getImage().getScaledInstance(label_3.getWidth(), label_3.getHeight(), Image.SCALE_DEFAULT));
		label_3.setIcon(logo13);

		lblAsignacionesYLista = new JLabel("ASIGNACIONES Y LISTA DE EMPLEADOS.");
		lblAsignacionesYLista.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblAsignacionesYLista.setBounds(599, 11, 466, 23);
		contentPane.add(lblAsignacionesYLista);

		btnRegresar_1.addActionListener(new ActionListener() {
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
			txtDireccionFoto.setText(String.valueOf(file));
			Image foto = getToolkit().getImage(txtDireccionFoto.getText());
			foto = foto.getScaledInstance(lblFotoEmpleado.getHeight(), lblFotoEmpleado.getWidth(), Image.SCALE_DEFAULT);
			lblFotoEmpleado.setIcon(new ImageIcon(foto));
		}
	}

	public void tomarFoto() {

		Runtime camara = Runtime.getRuntime();
		try {
			camara.exec("C:\\Users\\hp\\Documents\\GitHub\\Proyecto_Administrativo\\portable-webcam.exe");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void pistas() {
		pista = new PlaceHolder(txtNombresEmpleado, "Ingrese nombres del empleado.");
		pista = new PlaceHolder(txtApellidosEmpleado, "Ingrese apellidos del empleado.");
		pista = new PlaceHolder(txtDireccionEmpleado, "Ingrese la direccion del empleado.");
		pista = new PlaceHolder(txtNombreReferencia, "Ingrese nombre completo de la referencia.");
		pista = new PlaceHolder(txtCorreoEmpleado, "Ingrese el correo del empleado");
		pista = new PlaceHolder(txtBusquedaEmpleado, "Escriba para buscar");
		pista = new PlaceHolder(txtEdadEmpleado, "Calcular edad ->");
	}

	public void establecerFechaRegistro() {
		try {
			LocalDate fechaActual = LocalDate.now();
			Date date = Date.from(fechaActual.atStartOfDay(ZoneId.systemDefault()).toInstant());
			dateFechaRegistro.setDate(date);
		} catch (Exception e) {

		}

	}

	public void calcularEdad() {
		Date fechaNacimiento = new Date();
		fechaNacimiento = dateFechaNacimiento.getDate();
		LocalDate fechaCumpleaños = fechaNacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate fechaActual = LocalDate.now();
		Period periodo = Period.between(fechaCumpleaños, fechaActual);
		String resultado = periodo.getYears() + " Años.";
		int edad = 0;
		edad = periodo.getYears();

		if (edad < 18) {
			JOptionPane.showMessageDialog(null, "Ingrese su fecha de nacimiento correcta, "
					+ " (Menores de edad no pueden trabajar en esta empresa.)");
			editor3.setText("");
		} else {
			if (edad > 75) {
				JOptionPane.showMessageDialog(null, "Ingrese su fecha de nacimiento correcta, "
						+ " (Personas Mayores de 75 años no pueden trabajar en esta empresa.)");
				editor3.setText("");
			} else {
				txtEdadEmpleado.setForeground(Color.BLACK);
				txtEdadEmpleado.setText(resultado);
				btnCalcularEdad.setBackground(Color.GREEN);
			}
		}
	}

	public void construirTablaEmpleados() {
		String titulos[] = { "Codigo", "Nombres", "Apellidos", "Identidad", "Genero", "Edad", "Telefono", "Correo",
				"Direccion", "Foto", "Nombre_Referencia", "Telefono_Referencia", "Fecha_Nacimiento", "Fecha_Registro",
				"Fecha_Labores", "Estado", "Cargo", "Sueldo", "Hora Extra", "Obligaciones", "Horario", "Dias", "Horas", "Identidad_Contrato", "Tipo", "Tiempo", "Foto"};
		String informacion[][] = control_empleado.obtenerMatriz();
		tablaEmpleados = new JTable(informacion, titulos);
		barraTablaEmpleados.setViewportView(tablaEmpleados);
		tablaEmpleados.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tablaEmpleados.getTableHeader().setReorderingAllowed(false);

		for (int c = 0; c < tablaEmpleados.getColumnCount(); c++) {
			Class<?> col_class = tablaEmpleados.getColumnClass(c);
			tablaEmpleados.setDefaultEditor(col_class, null);
		}
	}

	public void filtro() {
		filtroCodigoEmpleado = txtBusquedaEmpleado.getText();
		trsfiltroCodigoEmpleado.setRowFilter(RowFilter.regexFilter(txtBusquedaEmpleado.getText(), 0, 1, 2, 3, 4, 5, 6,
				7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27));
	}

	public void verFotoEmpleado() {
		if (txtDireccionFoto.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hay imagen que mostrar");
		} else {
			visor_imagen visor = new visor_imagen();
			ruta = txtDireccionFoto.getText().toString();
			visor.txtRutaImagen.setText(ruta);
			visor.setVisible(true);
			visor.setLocationRelativeTo(null);
			imagen = new ImageIcon(ruta);
			visor_imagen.lblImagen.setIcon(imagen);
		}
	}

	public void obtenerUltimoId() {
		String ultimoValor = null;
		int valor;
		String id = null;
		conexion objCon = new conexion();
		Connection conn = objCon.getConexion();
		try {
			PreparedStatement stmtr = conn.prepareStatement("SELECT * FROM empleados ORDER BY id_empleado DESC");
			ResultSet rsr = stmtr.executeQuery();
			if (rsr.next()) {
				ultimoValor = rsr.getString("id_empleado");
				valor = Integer.parseInt(ultimoValor);
				valor = valor + 1;
				id = String.valueOf(valor);
			}
			txtCodigoEmpleado.setText(id);
			;
			stmtr.close();
			rsr.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
