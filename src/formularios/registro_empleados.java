package formularios;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.Event;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.RowFilter;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.awt.event.ActionEvent;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.InputMap;

import com.github.sarxos.webcam.Webcam;
import com.placeholder.PlaceHolder;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import clases.cargo;
import clases.empleado;
import conexion.conexion;
import consultas.consultas_cargo;
import consultas.consultas_empleado;
import controles.control_cargo;
import controles.control_empleado;

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
	public JTextField lblFechaDeRegistro;
	public JScrollPane scrollPane;
	public JTextArea txtDireccionEmpleado;
	public JDateChooser dateFechaLabores;
	public JDateChooser dateFechaRegistro;
	public JDateChooser dateFechaNacimiento;
	public PlaceHolder pista;
	
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
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
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
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1250, 720);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		final ImageIcon icono = new ImageIcon(getClass().getResource("/material/libreta.png"));
		final ImageIcon icono1 = new ImageIcon(getClass().getResource("/material/logo.png"));
		final ImageIcon lista_empleados = new ImageIcon(getClass().getResource("/material/lista_empleados.png"));

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(18, 54, 571, 605);
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
		InputMap map9 = txtCodigoEmpleado.getInputMap(txtCodigoEmpleado.WHEN_FOCUSED);
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
		InputMap map5 = txtNombresEmpleado.getInputMap(txtNombresEmpleado.WHEN_FOCUSED);
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

			public void keyPressed(KeyEvent ke) {
			}

			public void keyReleased(KeyEvent ke) {
			}
		});

		JLabel lblApellidos = new JLabel("3. Apellidos :");
		lblApellidos.setBounds(39, 142, 83, 14);
		panel.add(lblApellidos);
		lblApellidos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		InputMap map6 = lblApellidos.getInputMap(lblApellidos.WHEN_FOCUSED);
		map6.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

		txtApellidosEmpleado = new JTextField();
		txtApellidosEmpleado.setBounds(122, 139, 210, 20);
		panel.add(txtApellidosEmpleado);
		txtApellidosEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtApellidosEmpleado.setColumns(10);
		txtApellidosEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		InputMap map7 = txtApellidosEmpleado.getInputMap(txtApellidosEmpleado.WHEN_FOCUSED);
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

			public void keyPressed(KeyEvent ke) {
			}

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
		InputMap map2 = txtIdentidadEmpleado.getInputMap(txtIdentidadEmpleado.WHEN_FOCUSED);
		map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtIdentidadEmpleado.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();
				if ((c < '0' || c > '9'))
					ke.consume();
			}

			public void keyPressed(KeyEvent ke) {
			}

			public void keyReleased(KeyEvent ke) {
			}
		});

		JLabel lblEdad = new JLabel("10. Edad :");
		lblEdad.setBounds(39, 362, 83, 14);
		panel.add(lblEdad);
		lblEdad.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

		txtEdadEmpleado = new JTextField();
		txtEdadEmpleado.setEditable(false);
		txtEdadEmpleado.setBounds(199, 356, 111, 20);
		txtEdadEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtEdadEmpleado.setColumns(10);
		txtEdadEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(txtEdadEmpleado);

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
		InputMap map8 = txtCorreoEmpleado.getInputMap(txtCorreoEmpleado.WHEN_FOCUSED);
		map8.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

		JLabel lblTelefonos = new JLabel("7. Telefono :");
		lblTelefonos.setBounds(39, 244, 83, 14);
		panel.add(lblTelefonos);
		lblTelefonos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

		MaskFormatter formatter1 = null;
		try {
			formatter1 = new MaskFormatter("+(504) ####-####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtTelefonoEmpleado = new JFormattedTextField(formatter1);
		txtTelefonoEmpleado.setBounds(122, 243, 210, 20);
		panel.add(txtTelefonoEmpleado);
		txtTelefonoEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtTelefonoEmpleado.setColumns(10);
		txtTelefonoEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		InputMap map3 = txtTelefonoEmpleado.getInputMap(txtTelefonoEmpleado.WHEN_FOCUSED);
		map3.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtTelefonoEmpleado.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();
				if ((c < '0' || c > '9'))
					ke.consume();
			}

			public void keyPressed(KeyEvent ke) {
			}

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

		lblFechaDeRegistro = new JTextField("16. Fecha de registro :");
		lblFechaDeRegistro.setEditable(false);
		lblFechaDeRegistro.setBounds(354, 382, 157, 20);
		panel.add(lblFechaDeRegistro);
		lblFechaDeRegistro.setVisible(false);
		lblFechaDeRegistro.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

		JLabel lblFechaDeComienso = new JLabel("13. Fecha inicio labores :");
		lblFechaDeComienso.setBounds(39, 478, 167, 20);
		panel.add(lblFechaDeComienso);
		lblFechaDeComienso.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

		dateFechaLabores = new JDateChooser();
		dateFechaLabores.setBounds(199, 478, 133, 20);
		panel.add(dateFechaLabores);
		JTextFieldDateEditor editor = (JTextFieldDateEditor) dateFechaLabores.getDateEditor();
		editor.setEditable(false);

		dateFechaRegistro = new JDateChooser();
		dateFechaRegistro.setBackground(Color.WHITE);
		dateFechaRegistro.setBounds(354, 407, 179, 20);
		panel.add(dateFechaRegistro);
		dateFechaRegistro.setVisible(false);
		JTextFieldDateEditor editor2 = (JTextFieldDateEditor) dateFechaRegistro.getDateEditor();
		editor2.setEditable(false);

		dateFechaNacimiento = new JDateChooser();
		dateFechaNacimiento.setBounds(199, 331, 132, 20);
		panel.add(dateFechaNacimiento);
		JTextFieldDateEditor editor3 = (JTextFieldDateEditor) dateFechaNacimiento.getDateEditor();
		editor3.setEditable(false);

		JLabel label_1 = new JLabel("");
		label_1.setBounds(461, 58, 72, 62);
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
		InputMap map14 = txtNombreReferencia.getInputMap(txtNombreReferencia.WHEN_FOCUSED);
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

			public void keyPressed(KeyEvent ke) {
			}

			public void keyReleased(KeyEvent ke) {
			}
		});

		JLabel lblTelefonoDeLa = new JLabel("12. Telefono de referencia :");
		lblTelefonoDeLa.setBounds(39, 432, 202, 14);
		panel.add(lblTelefonoDeLa);
		lblTelefonoDeLa.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

		MaskFormatter formatter3 = null;
		try {
			formatter3 = new MaskFormatter("+(504) ####-####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtTelefonoReferencia = new JFormattedTextField(formatter3);
		txtTelefonoReferencia.setBounds(39, 447, 293, 20);
		panel.add(txtTelefonoReferencia);
		txtTelefonoReferencia.setHorizontalAlignment(SwingConstants.CENTER);
		txtTelefonoReferencia.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtTelefonoReferencia.setColumns(10);
		InputMap map4 = txtTelefonoReferencia.getInputMap(txtTelefonoReferencia.WHEN_FOCUSED);
		map4.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtTelefonoReferencia.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();
				if ((c < '0' || c > '9'))
					ke.consume();
			}

			public void keyPressed(KeyEvent ke) {
			}

			public void keyReleased(KeyEvent ke) {
			}
		});

		JLabel lblEstado = new JLabel("15. Estado :");
		lblEstado.setBounds(354, 357, 83, 14);
		panel.add(lblEstado);
		lblEstado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

		cbxEstadoEmpleado = new JComboBox();
		cbxEstadoEmpleado.setBounds(461, 354, 72, 20);
		panel.add(cbxEstadoEmpleado);
		cbxEstadoEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		cbxEstadoEmpleado.setModel(new DefaultComboBoxModel(new String[] { "Activo", "Inactivo" }));

		scrollPane = new JScrollPane();
		scrollPane.setBounds(122, 271, 210, 55);
		panel.add(scrollPane);

		txtDireccionEmpleado = new JTextArea();
		scrollPane.setViewportView(txtDireccionEmpleado);
		InputMap map90 = txtDireccionEmpleado.getInputMap(txtDireccionEmpleado.WHEN_FOCUSED);
		map90.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

		btnTomarFoto = new JButton("Tomar");
		btnTomarFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tomarFoto();
			}
		});
		btnTomarFoto.setBackground(new Color(0, 255, 127));
		btnTomarFoto.setBounds(354, 114, 83, 23);
		panel.add(btnTomarFoto);

		btnSubirFoto = new JButton("Subir");
		btnSubirFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecionarFoto();
			}
		});
		btnSubirFoto.setBackground(new Color(250, 128, 114));
		btnSubirFoto.setBounds(354, 139, 83, 23);
		panel.add(btnSubirFoto);

		JLabel lblFoto = new JLabel("14. Foto :");
		lblFoto.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblFoto.setBounds(354, 92, 83, 17);
		panel.add(lblFoto);

		btnCancelarEmpleado = new JButton("Cancelar");
		btnCancelarEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnCancelarEmpleado.setBackground(new Color(255, 255, 255));
		btnCancelarEmpleado.setBounds(39, 509, 99, 23);
		panel.add(btnCancelarEmpleado);

		btnActualizarEmpleado = new JButton("Actualizar");
		btnActualizarEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnActualizarEmpleado.setBackground(new Color(60, 179, 113));
		btnActualizarEmpleado.setBounds(434, 509, 99, 23);
		panel.add(btnActualizarEmpleado);

		btnNuevoEmpleado = new JButton("Nuevo");
		btnNuevoEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNuevoEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnNuevoEmpleado.setBackground(new Color(255, 255, 255));
		btnNuevoEmpleado.setBounds(39, 543, 99, 23);
		panel.add(btnNuevoEmpleado);

		btnGuardarEmpleado = new JButton("Guardar");
		btnGuardarEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnGuardarEmpleado.setBackground(new Color(60, 179, 113));
		btnGuardarEmpleado.setBounds(434, 543, 99, 23);
		panel.add(btnGuardarEmpleado);

		txtDireccionFoto = new JTextField();
		txtDireccionFoto.setEditable(false);
		txtDireccionFoto.setBounds(354, 166, 179, 20);
		panel.add(txtDireccionFoto);
		txtDireccionFoto.setColumns(10);
		InputMap map10 = txtDireccionFoto.getInputMap(txtDireccionFoto.WHEN_FOCUSED);
		map10.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

		btnCalcularEdad = new JButton();
		btnCalcularEdad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				calcularEdad();
				btnCalcularEdad.setBackground(Color.GREEN);

			}
		});
		btnCalcularEdad.setBackground(new Color(220, 20, 60));
		btnCalcularEdad.setBounds(308, 356, 24, 20);
		panel.add(btnCalcularEdad);
		final ImageIcon iconoFoto = new ImageIcon(getClass().getResource("/material/usuario.png"));

		lblFotoEmpleado = new JLabel();
		lblFotoEmpleado.setBounds(354, 193, 175, 155);
		panel.add(lblFotoEmpleado);
		final ImageIcon logoFoto = new ImageIcon(iconoFoto.getImage().getScaledInstance(lblFotoEmpleado.getWidth(),
				lblFotoEmpleado.getHeight(), Image.SCALE_DEFAULT));
		lblFotoEmpleado.setIcon(logoFoto);

		JLabel label = new JLabel();
		label.setBounds(0, 0, 571, 604);
		panel.add(label);
		final ImageIcon logo = new ImageIcon(
				icono.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
		label.setIcon(logo);

		JLabel lblRegistroYMantenimiento = new JLabel("REGISTRO Y MANTENIMIENTO DE EMPLEADOS");
		lblRegistroYMantenimiento.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblRegistroYMantenimiento.setBounds(18, 11, 466, 39);
		contentPane.add(lblRegistroYMantenimiento);

		JButton btnRegresar_1 = new JButton("Regresar");
		btnRegresar_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnRegresar_1.setBackground(new Color(255, 165, 0));
		btnRegresar_1.setBounds(1122, 11, 99, 23);
		contentPane.add(btnRegresar_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(599, 54, 622, 605);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblEmpleadosRegistrados = new JLabel("Empleados registrados :");
		lblEmpleadosRegistrados.setBounds(34, 54, 206, 19);
		panel_1.add(lblEmpleadosRegistrados);
		lblEmpleadosRegistrados.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		
		JLabel label_2 = new JLabel("Buscar empleado :");
		label_2.setBounds(34, 81, 142, 14);
		panel_1.add(label_2);
		label_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		
		txtBusquedaEmpleado = new JTextField();
		txtBusquedaEmpleado.setBounds(157, 78, 360, 20);
		panel_1.add(txtBusquedaEmpleado);
		txtBusquedaEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtBusquedaEmpleado.setColumns(10);
		txtBusquedaEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		InputMap map41 = txtBusquedaEmpleado.getInputMap(txtBusquedaEmpleado.WHEN_FOCUSED);
		map41.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtBusquedaEmpleado.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				trsfiltroCodigoEmpleado = new TableRowSorter(tablaEmpleados.getModel());
				tablaEmpleados.setRowSorter(trsfiltroCodigoEmpleado);
			}

			public void keyPressed(KeyEvent ke) {

			}

			public void keyReleased(KeyEvent ke) {
				String cadena = (txtBusquedaEmpleado.getText());
				txtBusquedaEmpleado.setText(cadena);
				repaint();
				filtro();
			}
		});
		
		barraTablaEmpleados = new JScrollPane(tablaEmpleados, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		barraTablaEmpleados.setBounds(34, 109, 553, 422);
		panel_1.add(barraTablaEmpleados);
		
		tablaEmpleados = new JTable();
		barraTablaEmpleados.setViewportView(tablaEmpleados);
		
		
		btnBorrarEmpleado = new JButton("Borrar");
		btnBorrarEmpleado.setBounds(34, 542, 99, 23);
		panel_1.add(btnBorrarEmpleado);
		btnBorrarEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnBorrarEmpleado.setBackground(new Color(220, 20, 60));
		
		btnMostrarEmpleado = new JButton("Ver detalles");
		btnMostrarEmpleado.setBounds(332, 542, 108, 23);
		panel_1.add(btnMostrarEmpleado);
		btnMostrarEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnMostrarEmpleado.setBackground(new Color(0, 206, 209));
		
		btnActualizarDatosEmpleado = new JButton("Actualizar Datos");
		btnActualizarDatosEmpleado.setBounds(450, 542, 137, 23);
		panel_1.add(btnActualizarDatosEmpleado);
		btnActualizarDatosEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnActualizarDatosEmpleado.setBackground(new Color(60, 179, 113));
		
		JLabel label_6 = new JLabel();
		label_6.setBounds(527, 54, 58, 50);
		panel_1.add(label_6);
		final ImageIcon iconoo22 = new ImageIcon(getClass().getResource("/material/logo.png"));
		final ImageIcon logo12 = new ImageIcon(iconoo22.getImage().getScaledInstance(label_6.getWidth(),label_6.getHeight(), Image.SCALE_DEFAULT));
		label_6.setIcon(logo12);
		
		JLabel lblEmpleados = new JLabel("");
		lblEmpleados.setBounds(0, 0, 622, 605);
		panel_1.add(lblEmpleados);
		final ImageIcon iconoo = new ImageIcon(getClass().getResource("/material/libreta.png"));
		final ImageIcon logo11 = new ImageIcon(iconoo.getImage().getScaledInstance(lblEmpleados.getWidth(),lblEmpleados.getHeight(), Image.SCALE_DEFAULT));
		lblEmpleados.setIcon(logo11);
		
		btnRegresar_1.addActionListener(new ActionListener() {
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
		pista = new PlaceHolder(txtCorreoEmpleado, "Ingrese el correo del la empleado");
		pista = new PlaceHolder(txtBusquedaEmpleado, "Escriba para buscar");
		pista = new PlaceHolder(txtEdadEmpleado, "Calcular edad");
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
		try {
			Date fechaNacimiento = new Date();
			fechaNacimiento = dateFechaNacimiento.getDate();
			LocalDate fechaCumpleaños = fechaNacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			LocalDate fechaActual = LocalDate.now();
			Period periodo = Period.between(fechaCumpleaños, fechaActual);
			String resultado = periodo.getYears() + " Años.";
			txtEdadEmpleado.setForeground(Color.BLACK);
			txtEdadEmpleado.setText(resultado);
		} catch (Exception e) {

		}
	}
	
	public void construirTablaEmpleados() {
		String titulos[] = { "Codigo", "Nombres", "Apellidos", "Identidad", "Genero",
				"Edad", "Telefono", "Correo", "Direccion", "Foto", "Nombre_Referencia",
				"Telefono_Referencia", "Fecha_Nacimiento", "Fecha_Registro", "Fecha_Labores", "Estado" };
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
		trsfiltroCodigoEmpleado.setRowFilter(RowFilter.regexFilter(txtBusquedaEmpleado.getText(), 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15));
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
