package formularios;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
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
	public JScrollPane scrollPane;
	public JTextArea txtDireccionEmpleado;
	public JDateChooser dateFechaLabores;
	public JDateChooser dateFechaRegistro;
	public JDateChooser dateFechaNacimiento;
	public PlaceHolder pista;

	public JButton btnTomarFoto;
	public JButton btnSubirFoto;

	public JButton btnNuevoEmpleado;
	public JButton btnGuardarEmpleado;
	public JButton btnActualizarEmpleado;
	public JButton btnCancelarEmpleado;
	public JButton btnEmpleados;
	public JButton btnAgregarEdad;

	public JTextField txtHoraEntrada;
	public JTextField txtHoraSalida;
	public JTextField txtTiempoContrato;
	public JTextField txtTipoContrato;
	public JTextField txtNombreCargo;
	public JTextField txtSueldoCargo;
	public JTextField txtFuncionesCargo;

	public JButton btnRegresar;
	public JTextField txtDireccionFoto;

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
		setBounds(100, 100, 800, 720);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		final ImageIcon icono = new ImageIcon(getClass().getResource("/material/libreta.png"));
		final ImageIcon icono1 = new ImageIcon(getClass().getResource("/material/logo.png"));

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(18, 36, 766, 644);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblDatosGenerales = new JLabel("Datos del Registro :");
		lblDatosGenerales.setBounds(57, 60, 151, 14);
		panel.add(lblDatosGenerales);
		lblDatosGenerales.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));

		JLabel lblCodigo = new JLabel("1. Codigo :");
		lblCodigo.setBounds(57, 85, 83, 17);
		panel.add(lblCodigo);
		lblCodigo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

		txtCodigoEmpleado = new JTextField();
		txtCodigoEmpleado.setBounds(140, 85, 50, 20);
		panel.add(txtCodigoEmpleado);
		txtCodigoEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtCodigoEmpleado.setEditable(false);
		txtCodigoEmpleado.setColumns(10);
		txtCodigoEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		InputMap map9 = txtCodigoEmpleado.getInputMap(txtCodigoEmpleado.WHEN_FOCUSED);
		map9.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

		JLabel lblNombres = new JLabel("2. Nombres :");
		lblNombres.setBounds(57, 111, 83, 14);
		panel.add(lblNombres);
		lblNombres.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

		txtNombresEmpleado = new JTextField();
		txtNombresEmpleado.setBounds(140, 108, 210, 20);
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
		lblApellidos.setBounds(57, 135, 83, 14);
		panel.add(lblApellidos);
		lblApellidos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		InputMap map6 = lblApellidos.getInputMap(lblApellidos.WHEN_FOCUSED);
		map6.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

		txtApellidosEmpleado = new JTextField();
		txtApellidosEmpleado.setBounds(140, 132, 210, 20);
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
		lblIdentidad.setBounds(57, 161, 83, 14);
		panel.add(lblIdentidad);
		lblIdentidad.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

		MaskFormatter formatter = null;
		try {
			formatter = new MaskFormatter("####-####-#####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtIdentidadEmpleado = new JFormattedTextField(formatter);
		txtIdentidadEmpleado.setBounds(140, 158, 210, 20);
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
		lblEdad.setBounds(57, 352, 83, 14);
		panel.add(lblEdad);
		lblEdad.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

		txtEdadEmpleado = new JTextField();
		txtEdadEmpleado.setEditable(false);
		txtEdadEmpleado.setBounds(234, 352, 93, 20);
		txtEdadEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtEdadEmpleado.setColumns(10);
		txtEdadEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(txtEdadEmpleado);

		JLabel lblGenero = new JLabel("5. Genero :");
		lblGenero.setBounds(57, 186, 76, 17);
		panel.add(lblGenero);
		lblGenero.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

		cbxGeneroEmpleado = new JComboBox();
		cbxGeneroEmpleado.setBounds(140, 186, 50, 20);
		panel.add(cbxGeneroEmpleado);
		cbxGeneroEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		cbxGeneroEmpleado.setModel(new DefaultComboBoxModel(new String[] { "M", "F" }));

		JLabel lblCorreo = new JLabel("6. Correo :");
		lblCorreo.setBounds(57, 211, 83, 14);
		panel.add(lblCorreo);
		lblCorreo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

		txtCorreoEmpleado = new JTextField();
		txtCorreoEmpleado.setBounds(140, 211, 210, 20);
		panel.add(txtCorreoEmpleado);
		txtCorreoEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtCorreoEmpleado.setColumns(10);
		txtCorreoEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		InputMap map8 = txtCorreoEmpleado.getInputMap(txtCorreoEmpleado.WHEN_FOCUSED);
		map8.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

		JLabel lblTelefonos = new JLabel("7. Telefono :");
		lblTelefonos.setBounds(57, 237, 83, 14);
		panel.add(lblTelefonos);
		lblTelefonos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

		MaskFormatter formatter1 = null;
		try {
			formatter1 = new MaskFormatter("+(504) ####-####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtTelefonoEmpleado = new JFormattedTextField(formatter1);
		txtTelefonoEmpleado.setBounds(140, 236, 210, 20);
		panel.add(txtTelefonoEmpleado);
		txtIdentidadEmpleado = new JFormattedTextField(formatter);
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
		lblDireccion.setBounds(57, 262, 83, 14);
		panel.add(lblDireccion);
		lblDireccion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

		JLabel lblFechaDeNacimiento = new JLabel("9. Fecha de nacimiento :");
		lblFechaDeNacimiento.setBounds(58, 322, 167, 20);
		panel.add(lblFechaDeNacimiento);
		lblFechaDeNacimiento.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

		JLabel lblFechaDeRegistro = new JLabel("11. Fecha de registro :");
		lblFechaDeRegistro.setBounds(57, 380, 167, 20);
		panel.add(lblFechaDeRegistro);
		lblFechaDeRegistro.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

		JLabel lblFechaDeComienso = new JLabel("12. Fecha inicio labores :");
		lblFechaDeComienso.setBounds(57, 411, 167, 20);
		panel.add(lblFechaDeComienso);
		lblFechaDeComienso.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

		dateFechaLabores = new JDateChooser();
		dateFechaLabores.setBounds(234, 411, 115, 20);
		panel.add(dateFechaLabores);
		JTextFieldDateEditor editor = (JTextFieldDateEditor) dateFechaLabores.getDateEditor();
		editor.setEditable(false);

		dateFechaRegistro = new JDateChooser();
		dateFechaRegistro.setBounds(234, 380, 115, 20);
		panel.add(dateFechaRegistro);
		JTextFieldDateEditor editor2 = (JTextFieldDateEditor) dateFechaRegistro.getDateEditor();
		editor2.setEditable(false);

		dateFechaNacimiento = new JDateChooser();
		dateFechaNacimiento.setBounds(235, 322, 115, 20);
		panel.add(dateFechaNacimiento);
		JTextFieldDateEditor editor3 = (JTextFieldDateEditor) dateFechaNacimiento.getDateEditor();
		editor3.setEditable(false);

		JLabel label_1 = new JLabel("");
		label_1.setBounds(652, 67, 63, 58);
		panel.add(label_1);
		final ImageIcon logo1 = new ImageIcon(icono1.getImage().getScaledInstance(label_1.getWidth(), label_1.getHeight(), Image.SCALE_DEFAULT));
		label_1.setIcon(logo1);

		JLabel lblReferencia = new JLabel("13. Nombre completo de referencia :");
		lblReferencia.setBounds(56, 442, 248, 23);
		panel.add(lblReferencia);
		lblReferencia.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

		txtNombreReferencia = new JTextField();
		txtNombreReferencia.setBounds(56, 463, 293, 20);
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

		JLabel lblTelefonoDeLa = new JLabel("14. Telefono de referencia :");
		lblTelefonoDeLa.setBounds(56, 487, 202, 14);
		panel.add(lblTelefonoDeLa);
		lblTelefonoDeLa.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

		MaskFormatter formatter3 = null;
		try {
			formatter3 = new MaskFormatter("+(504) ####-####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtTelefonoReferencia = new JFormattedTextField(formatter3);
		txtTelefonoReferencia.setBounds(56, 503, 293, 20);
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
		lblEstado.setBounds(56, 534, 83, 14);
		panel.add(lblEstado);
		lblEstado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

		cbxEstadoEmpleado = new JComboBox();
		cbxEstadoEmpleado.setBounds(139, 534, 72, 20);
		panel.add(cbxEstadoEmpleado);
		cbxEstadoEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		cbxEstadoEmpleado.setModel(new DefaultComboBoxModel(new String[] { "Activo", "Inactivo" }));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(387, 208, 324, 293);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblAsignaciones = new JLabel("Asignaciones : ");
		lblAsignaciones.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblAsignaciones.setBounds(10, 11, 151, 14);
		panel_1.add(lblAsignaciones);

		JLabel lblCargo = new JLabel("Cargo :");
		lblCargo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblCargo.setBounds(10, 36, 83, 14);
		panel_1.add(lblCargo);

		JComboBox cbxCargoAsignado = new JComboBox();
		cbxCargoAsignado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		cbxCargoAsignado.setBounds(81, 33, 151, 20);
		panel_1.add(cbxCargoAsignado);

		JLabel lblHorario = new JLabel("Horario :");
		lblHorario.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblHorario.setBounds(10, 156, 83, 14);
		panel_1.add(lblHorario);

		JComboBox cbxHorarioAsignado = new JComboBox();
		cbxHorarioAsignado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		cbxHorarioAsignado.setBounds(81, 153, 151, 20);
		panel_1.add(cbxHorarioAsignado);

		JLabel lblContrato = new JLabel("Contrato :");
		lblContrato.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblContrato.setBounds(10, 225, 83, 14);
		panel_1.add(lblContrato);

		JComboBox cbxContratoAsignado = new JComboBox();
		cbxContratoAsignado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		cbxContratoAsignado.setBounds(81, 222, 151, 20);
		panel_1.add(cbxContratoAsignado);

		txtHoraEntrada = new JTextField();
		txtHoraEntrada.setEditable(false);
		txtHoraEntrada.setBounds(10, 196, 142, 20);
		panel_1.add(txtHoraEntrada);
		txtHoraEntrada.setColumns(10);

		txtHoraSalida = new JTextField();
		txtHoraSalida.setEditable(false);
		txtHoraSalida.setColumns(10);
		txtHoraSalida.setBounds(172, 196, 142, 20);
		panel_1.add(txtHoraSalida);

		JLabel lblEntra = new JLabel("Entrada :");
		lblEntra.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblEntra.setBounds(10, 181, 83, 14);
		panel_1.add(lblEntra);

		JLabel lblSalida = new JLabel("Salida :");
		lblSalida.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblSalida.setBounds(172, 181, 100, 14);
		panel_1.add(lblSalida);

		txtTiempoContrato = new JTextField();
		txtTiempoContrato.setEditable(false);
		txtTiempoContrato.setColumns(10);
		txtTiempoContrato.setBounds(172, 256, 142, 20);
		panel_1.add(txtTiempoContrato);

		JLabel lblTipo = new JLabel("Tipo :");
		lblTipo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblTipo.setBounds(10, 241, 83, 14);
		panel_1.add(lblTipo);

		txtTipoContrato = new JTextField();
		txtTipoContrato.setEditable(false);
		txtTipoContrato.setColumns(10);
		txtTipoContrato.setBounds(10, 256, 142, 20);
		panel_1.add(txtTipoContrato);

		JLabel lblTiempo = new JLabel("Tiempo :");
		lblTiempo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblTiempo.setBounds(172, 241, 83, 14);
		panel_1.add(lblTiempo);

		JLabel lblNombreDelCargo = new JLabel("Nombre del cargo :");
		lblNombreDelCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblNombreDelCargo.setBounds(10, 58, 136, 14);
		panel_1.add(lblNombreDelCargo);

		txtNombreCargo = new JTextField();
		txtNombreCargo.setEditable(false);
		txtNombreCargo.setColumns(10);
		txtNombreCargo.setBounds(10, 73, 142, 20);
		panel_1.add(txtNombreCargo);

		JLabel lblSueldo = new JLabel("Sueldo");
		lblSueldo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblSueldo.setBounds(172, 58, 100, 14);
		panel_1.add(lblSueldo);

		txtSueldoCargo = new JTextField();
		txtSueldoCargo.setEditable(false);
		txtSueldoCargo.setColumns(10);
		txtSueldoCargo.setBounds(172, 73, 142, 20);
		panel_1.add(txtSueldoCargo);

		JLabel lblFunciones = new JLabel("Funciones :");
		lblFunciones.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblFunciones.setBounds(10, 96, 83, 14);
		panel_1.add(lblFunciones);

		txtFuncionesCargo = new JTextField();
		txtFuncionesCargo.setEditable(false);
		txtFuncionesCargo.setColumns(10);
		txtFuncionesCargo.setBounds(10, 113, 304, 37);
		panel_1.add(txtFuncionesCargo);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(140, 262, 210, 49);
		panel.add(scrollPane);

		txtDireccionEmpleado = new JTextArea();
		InputMap map90 = txtDireccionEmpleado.getInputMap(txtDireccionEmpleado.WHEN_FOCUSED);
		map90.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		scrollPane.setViewportView(txtDireccionEmpleado);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(59, 562, 290, 39);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel label_2 = new JLabel("Usuario del sistema :");
		label_2.setBounds(10, 14, 157, 14);
		panel_2.add(label_2);
		label_2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Si", "No" }));
		comboBox.setBounds(167, 11, 55, 20);
		panel_2.add(comboBox);
		comboBox.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

		JButton btnAsignarUsuario = new JButton("");
		btnAsignarUsuario.setBackground(new Color(0, 128, 0));
		btnAsignarUsuario.setBounds(232, 11, 48, 23);
		panel_2.add(btnAsignarUsuario);

		btnTomarFoto = new JButton("Tomar");
		btnTomarFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tomarFoto();
			}
		});
		btnTomarFoto.setBackground(new Color(0, 255, 127));
		btnTomarFoto.setBounds(387, 82, 83, 23);
		panel.add(btnTomarFoto);

		btnSubirFoto = new JButton("Subir");
		btnSubirFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecionarFoto();
			}
		});
		btnSubirFoto.setBackground(new Color(250, 128, 114));
		btnSubirFoto.setBounds(387, 107, 83, 23);
		panel.add(btnSubirFoto);

		JLabel lblFoto = new JLabel("16. Foto :");
		lblFoto.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblFoto.setBounds(387, 60, 83, 17);
		panel.add(lblFoto);

		btnCancelarEmpleado = new JButton("Cancelar");
		btnCancelarEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnCancelarEmpleado.setBackground(new Color(0, 206, 209));
		btnCancelarEmpleado.setBounds(491, 564, 99, 23);
		panel.add(btnCancelarEmpleado);

		btnActualizarEmpleado = new JButton("Actualizar");
		btnActualizarEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnActualizarEmpleado.setBackground(new Color(60, 179, 113));
		btnActualizarEmpleado.setBounds(491, 534, 99, 23);
		panel.add(btnActualizarEmpleado);

		btnNuevoEmpleado = new JButton("Nuevo");
		btnNuevoEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnNuevoEmpleado.setBackground(new Color(107, 142, 35));
		btnNuevoEmpleado.setBounds(387, 564, 99, 23);
		panel.add(btnNuevoEmpleado);

		btnGuardarEmpleado = new JButton("Guardar");
		btnGuardarEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnGuardarEmpleado.setBackground(new Color(60, 179, 113));
		btnGuardarEmpleado.setBounds(387, 534, 99, 23);
		panel.add(btnGuardarEmpleado);

		// Boton de lista de empleados en la tabla.

		btnEmpleados = new JButton("Empleados");
		btnEmpleados.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnEmpleados.setBackground(new Color(107, 142, 35));
		btnEmpleados.setBounds(596, 512, 115, 89);
		panel.add(btnEmpleados);
		btnEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				empleado claseEmpleado = new empleado();
				consultas_empleado consultaEmpleado = new consultas_empleado();
				registro_empleados formularioEmpleado = new registro_empleados();
				lista_empleados listaEmpleados = new lista_empleados();
				control_empleado controlEmpleado = new control_empleado(claseEmpleado, consultaEmpleado,
						formularioEmpleado, listaEmpleados);
				listaEmpleados.btnBorrarEmpleado.setVisible(true);
				listaEmpleados.btnNuevoEmpleado.setVisible(true);
				listaEmpleados.btnActualizarDatosEmpleado.setVisible(true);
				listaEmpleados.btnMostrarEmpleado.setVisible(true);
				listaEmpleados.setVisible(true);
				listaEmpleados.setLocationRelativeTo(null);
				listaEmpleados.construirTablaEmpleados();
				dispose();
			}
		});

		txtDireccionFoto = new JTextField();
		txtDireccionFoto.setEditable(false);
		txtDireccionFoto.setBounds(387, 135, 83, 20);
		panel.add(txtDireccionFoto);
		txtDireccionFoto.setColumns(10);
		InputMap map10 = txtDireccionFoto.getInputMap(txtDireccionFoto.WHEN_FOCUSED);
		map10.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

		JButton btnCalcularEdad = new JButton("");
		btnCalcularEdad.setBackground(new Color(220, 20, 60));
		btnCalcularEdad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calcularEdad();
				btnCalcularEdad.setBackground(Color.GREEN);
			}
		});
		btnCalcularEdad.setBounds(326, 352, 24, 20);
		panel.add(btnCalcularEdad);

		lblFotoEmpleado = new JLabel("");
		lblFotoEmpleado.setBackground(new Color(255, 255, 224));
		lblFotoEmpleado.setBounds(491, 60, 151, 143);
		panel.add(lblFotoEmpleado);
		final ImageIcon iconoFoto = new ImageIcon(getClass().getResource("/material/usuario.png"));
		final ImageIcon logoFoto = new ImageIcon(iconoFoto.getImage().getScaledInstance(lblFotoEmpleado.getWidth(), lblFotoEmpleado.getHeight(), Image.SCALE_DEFAULT));
		lblFotoEmpleado.setIcon(logoFoto);

		JLabel label = new JLabel();
		label.setBounds(0, 0, 766, 644);
		panel.add(label);
		final ImageIcon logo = new ImageIcon(icono.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
		label.setIcon(logo);

		JLabel lblRegistroYMantenimiento = new JLabel("REGISTRO Y MANTENIMIENTO DE EMPLEADOS");
		lblRegistroYMantenimiento.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblRegistroYMantenimiento.setBounds(18, 0, 466, 39);
		contentPane.add(lblRegistroYMantenimiento);

		btnRegresar = new JButton("Regresar");
		btnRegresar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnRegresar.setBackground(new Color(255, 127, 80));
		btnRegresar.setBounds(882, 10, 102, 23);
		contentPane.add(btnRegresar);

		JButton btnRegresar_1 = new JButton("Regresar");
		btnRegresar_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnRegresar_1.setBackground(new Color(255, 165, 0));
		btnRegresar_1.setBounds(685, 10, 99, 23);
		contentPane.add(btnRegresar_1);
		btnRegresar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ventana_principal principal = new ventana_principal();
				principal.setVisible(true);
				principal.setLocationRelativeTo(null);
				dispose();
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
		pista = new PlaceHolder(txtIdentidadEmpleado, "Ingrese la identidad del empleado.");
		pista = new PlaceHolder(txtTelefonoEmpleado, "Ingrese el telefono del empleado.");
		pista = new PlaceHolder(txtDireccionEmpleado, "Ingrese la direccion del empleado.");
		pista = new PlaceHolder(txtNombreReferencia, "Ingrese nombre completo de la referencia.");
		pista = new PlaceHolder(txtTelefonoReferencia, "Ingrese el telefono de la referencia.");
		pista = new PlaceHolder(txtCorreoEmpleado, "Ingrese el correo del la empleado");
		pista = new PlaceHolder(txtDireccionFoto, "Foto.");
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
			txtEdadEmpleado.setText(resultado);
		} catch (Exception e) {

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
