package formularios;

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
import java.awt.JobAttributes;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.MessageFormat;
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

import com.placeholder.PlaceHolder;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import clases.cargo;
import clases.contrato_empleado;
import clases.empleado;
import clases.horario;
import conexion.conexion;
import consultas.consultas_cargo;
import consultas.consultas_contrato_empleado;
import consultas.consultas_empleado;
import consultas.consultas_horario;
import controles.control_cargo;
import controles.control_contrato_empleado;
import controles.control_empleado;
import controles.control_horario;
import utilidades.visor_imagen;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class registro_empleados extends JFrame {

	public JPanel contentPane;
	public JPanel panel;
	public JPanel panel_2;
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
	public static String identidad = null;
	public static String ruta;
	public static ImageIcon imagen;
	public JLabel lblFechaDeRegistro;
	public static String hora_fecha_reporte;

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

	public TableRowSorter trsfiltroCodigoEmpleado;
	String filtroCodigoEmpleado;

	public JButton btnBorrarEmpleado;
	public JButton btnActualizarDatosEmpleado;
	public JButton btnMostrarEmpleado;
	public JButton btnNuevoEmpleado;

	public JButton btnTomarFoto;
	public JButton btnSubirFoto;
	public JButton btnCalcularEdad;
	public JButton btnActualizarEmpleado;
	public JButton btnCancelarEmpleado;
	public JButton btnAgregarEdad;
	public JTextField txtDireccionFoto;
	public JTextField textField;
	public JLabel lblAsignacionesYLista;

	public int contador1 = 0;
	public int contador2 = 0;
	public int contador3 = 0;
	public JButton btnAsgnaciones;
	public JButton btnImprimirReporteEmpleados;
	public JButton btnGuardarEmpleado;
	public static JTextField lbl_nombre_cargo_asignacion;
	public static JTextField lbl_sueldo_cargo_asignacion;
	public static JTextField lbl_horaextra_cargo_asignacion;
	public static JTextField lbl_funciones_cargo_asignacion;
	public static JTextField lbl_tipo_horario_asignacion;
	public static JTextField lbl_dias_horario_asignacion;
	public static JTextField lbl_horas_horario_asignacion;
	public static JTextField lbl_contrato_empleado_asignacion;
	public static JTextField lbl_tipo_empleado_asignacion;
	public static JTextField lbl_tiempo_empleado_asignacion;
	public static JTextField lbl_foto_empleado_asignacion;
	private JLabel lblCargo;
	private JLabel lblHorario;
	private JLabel lblContrato;
	private JLabel lblNombre;
	private JLabel lblSueldo;
	private JLabel lblHext;
	private JLabel lblFunciones;
	private JLabel lblTipo;
	private JLabel lblDias;
	private JLabel lblHoras;
	private JLabel lblIdentidad_1;
	private JLabel lblTipo_1;
	private JLabel lblTiempo;
	private JLabel lblDireccion_1;
	private JButton btnvercontrato;
	
	public registro_asignaciones_empleados formularioAsignacion = new registro_asignaciones_empleados();

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

		panel = new JPanel();
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
		cbxGeneroEmpleado.setBounds(122, 193, 68, 20);
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
		lblFechaDeRegistro.setVisible(false);
		lblFechaDeRegistro.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

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
		dateFechaRegistro.setVisible(false);
		editor2.setHorizontalAlignment(SwingConstants.CENTER);

		dateFechaNacimiento = new JDateChooser();
		dateFechaNacimiento.setBounds(199, 331, 132, 20);
		dateFechaNacimiento.setDateFormatString("dd-MMMMM-yyyy");
		panel.add(dateFechaNacimiento);
		editor3 = (JTextFieldDateEditor) dateFechaNacimiento.getDateEditor();
		editor3.setEditable(false);
		editor3.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel label_1 = new JLabel("");
		label_1.setBounds(493, 58, 50, 51);
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
		lblEstado.setBounds(354, 359, 83, 14);
		panel.add(lblEstado);
		lblEstado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

		cbxEstadoEmpleado = new JComboBox();
		cbxEstadoEmpleado.setBounds(477, 356, 66, 20);
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
		btnTomarFoto.setBounds(354, 116, 83, 20);
		panel.add(btnTomarFoto);

		btnSubirFoto = new JButton("Subir");
		btnSubirFoto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selecionarFoto();
			}
		});
		btnSubirFoto.setBackground(new Color(250, 128, 114));
		btnSubirFoto.setBounds(460, 116, 83, 20);
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
		btnActualizarEmpleado.setBounds(233, 571, 99, 23);
		panel.add(btnActualizarEmpleado);

		btnNuevoEmpleado = new JButton("Nuevo");
		btnNuevoEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnNuevoEmpleado.setBackground(new Color(255, 255, 255));
		btnNuevoEmpleado.setBounds(39, 571, 99, 23);
		panel.add(btnNuevoEmpleado);

		txtDireccionFoto = new JTextField();
		txtDireccionFoto.setEditable(false);
		txtDireccionFoto.setBounds(354, 140, 189, 20);
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
		lblFotoEmpleado.setBounds(354, 165, 189, 186);
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
		btnVerFotoEmpleado.setBounds(416, 93, 68, 17);
		panel.add(btnVerFotoEmpleado);

		btnAsgnaciones = new JButton("Asignaciones");
		btnAsgnaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validarIdentidad();
				if (txtIdentidadEmpleado.getText().toString().equals(identidad)) {
					JOptionPane.showMessageDialog(null, "Se encontrado un registro con esta identidad : " + identidad,
							"Atencion datos duplicados", JOptionPane.INFORMATION_MESSAGE);
				} else {
					empleado clase = new empleado();
					consultas_empleado consulta = new consultas_empleado();
					registro_empleados formulario = new registro_empleados();
					registro_asignaciones_empleados formulario2 = new registro_asignaciones_empleados();
					control_empleado control = new control_empleado(clase, consulta, formulario, formulario2);
					formulario2.setVisible(true);
					formulario2.setLocationRelativeTo(null);
					control.consultarContratos();
					control.consultarCargos();
					control.consultarHorarios();
				}

			}
		});
		btnAsgnaciones.setFont(new Font("Dialog", Font.BOLD, 10));
		btnAsgnaciones.setBackground(new Color(218, 165, 32));
		btnAsgnaciones.setBounds(352, 387, 191, 23);
		panel.add(btnAsgnaciones);

		panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(141, 331, 191, 221);
		panel.add(panel_2);
		panel_2.setLayout(null);
		panel_2.setVisible(false);

		lbl_nombre_cargo_asignacion = new JTextField("");
		lbl_nombre_cargo_asignacion.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_nombre_cargo_asignacion.setFont(new Font("Dialog", Font.BOLD, 8));
		lbl_nombre_cargo_asignacion.setEditable(false);
		lbl_nombre_cargo_asignacion.setBackground(new Color(255, 255, 255));
		lbl_nombre_cargo_asignacion.setBounds(66, 14, 115, 14);
		panel_2.add(lbl_nombre_cargo_asignacion);

		lbl_sueldo_cargo_asignacion = new JTextField("");
		lbl_sueldo_cargo_asignacion.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_sueldo_cargo_asignacion.setFont(new Font("Dialog", Font.BOLD, 8));
		lbl_sueldo_cargo_asignacion.setEditable(false);
		lbl_sueldo_cargo_asignacion.setBackground(new Color(255, 255, 255));
		lbl_sueldo_cargo_asignacion.setBounds(66, 30, 115, 14);
		panel_2.add(lbl_sueldo_cargo_asignacion);

		lbl_horaextra_cargo_asignacion = new JTextField("");
		lbl_horaextra_cargo_asignacion.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_horaextra_cargo_asignacion.setFont(new Font("Dialog", Font.BOLD, 8));
		lbl_horaextra_cargo_asignacion.setEditable(false);
		lbl_horaextra_cargo_asignacion.setBackground(new Color(255, 255, 255));
		lbl_horaextra_cargo_asignacion.setBounds(66, 47, 115, 14);
		panel_2.add(lbl_horaextra_cargo_asignacion);

		lbl_funciones_cargo_asignacion = new JTextField("");
		lbl_funciones_cargo_asignacion.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_funciones_cargo_asignacion.setFont(new Font("Dialog", Font.BOLD, 8));
		lbl_funciones_cargo_asignacion.setEditable(false);
		lbl_funciones_cargo_asignacion.setBackground(new Color(255, 255, 255));
		lbl_funciones_cargo_asignacion.setBounds(66, 64, 115, 14);
		panel_2.add(lbl_funciones_cargo_asignacion);

		lbl_tipo_horario_asignacion = new JTextField("");
		lbl_tipo_horario_asignacion.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_tipo_horario_asignacion.setFont(new Font("Dialog", Font.BOLD, 8));
		lbl_tipo_horario_asignacion.setEditable(false);
		lbl_tipo_horario_asignacion.setBackground(new Color(255, 255, 255));
		lbl_tipo_horario_asignacion.setBounds(66, 89, 115, 14);
		panel_2.add(lbl_tipo_horario_asignacion);

		lbl_dias_horario_asignacion = new JTextField("");
		lbl_dias_horario_asignacion.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_dias_horario_asignacion.setFont(new Font("Dialog", Font.BOLD, 8));
		lbl_dias_horario_asignacion.setEditable(false);
		lbl_dias_horario_asignacion.setBackground(new Color(255, 255, 255));
		lbl_dias_horario_asignacion.setBounds(66, 104, 115, 14);
		panel_2.add(lbl_dias_horario_asignacion);

		lbl_horas_horario_asignacion = new JTextField("");
		lbl_horas_horario_asignacion.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_horas_horario_asignacion.setFont(new Font("Dialog", Font.BOLD, 8));
		lbl_horas_horario_asignacion.setEditable(false);
		lbl_horas_horario_asignacion.setBackground(new Color(255, 255, 255));
		lbl_horas_horario_asignacion.setBounds(66, 121, 115, 14);
		panel_2.add(lbl_horas_horario_asignacion);

		lbl_contrato_empleado_asignacion = new JTextField("");
		lbl_contrato_empleado_asignacion.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_contrato_empleado_asignacion.setFont(new Font("Dialog", Font.BOLD, 8));
		lbl_contrato_empleado_asignacion.setEditable(false);
		lbl_contrato_empleado_asignacion.setBackground(new Color(255, 255, 255));
		lbl_contrato_empleado_asignacion.setBounds(66, 146, 115, 14);
		panel_2.add(lbl_contrato_empleado_asignacion);

		lbl_tipo_empleado_asignacion = new JTextField("");
		lbl_tipo_empleado_asignacion.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_tipo_empleado_asignacion.setFont(new Font("Dialog", Font.BOLD, 8));
		lbl_tipo_empleado_asignacion.setEditable(false);
		lbl_tipo_empleado_asignacion.setBackground(new Color(255, 255, 255));
		lbl_tipo_empleado_asignacion.setBounds(66, 163, 115, 14);
		panel_2.add(lbl_tipo_empleado_asignacion);

		lbl_tiempo_empleado_asignacion = new JTextField("");
		lbl_tiempo_empleado_asignacion.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_tiempo_empleado_asignacion.setFont(new Font("Dialog", Font.BOLD, 8));
		lbl_tiempo_empleado_asignacion.setEditable(false);
		lbl_tiempo_empleado_asignacion.setBackground(new Color(255, 255, 255));
		lbl_tiempo_empleado_asignacion.setBounds(66, 179, 115, 14);
		panel_2.add(lbl_tiempo_empleado_asignacion);

		lbl_foto_empleado_asignacion = new JTextField("");
		lbl_foto_empleado_asignacion.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_foto_empleado_asignacion.setFont(new Font("Dialog", Font.BOLD, 8));
		lbl_foto_empleado_asignacion.setEditable(false);
		lbl_foto_empleado_asignacion.setBackground(new Color(255, 255, 255));
		lbl_foto_empleado_asignacion.setBounds(66, 196, 61, 14);
		panel_2.add(lbl_foto_empleado_asignacion);
		
		lblCargo = new JLabel("Cargo.");
		lblCargo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 10));
		lblCargo.setBounds(70, 0, 70, 14);
		panel_2.add(lblCargo);
		
		lblHorario = new JLabel("Horario.");
		lblHorario.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 10));
		lblHorario.setBounds(70, 72, 70, 21);
		panel_2.add(lblHorario);
		
		lblContrato = new JLabel("Contrato.");
		lblContrato.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 10));
		lblContrato.setBounds(70, 129, 70, 21);
		panel_2.add(lblContrato);
		
		lblNombre = new JLabel("Nombre.");
		lblNombre.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 10));
		lblNombre.setBounds(10, 14, 70, 14);
		panel_2.add(lblNombre);
		
		lblSueldo = new JLabel("Sueldo");
		lblSueldo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 10));
		lblSueldo.setBounds(10, 30, 70, 14);
		panel_2.add(lblSueldo);
		
		lblHext = new JLabel("H.ext");
		lblHext.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 10));
		lblHext.setBounds(10, 47, 70, 14);
		panel_2.add(lblHext);
		
		lblFunciones = new JLabel("Funcion");
		lblFunciones.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 10));
		lblFunciones.setBounds(10, 64, 70, 14);
		panel_2.add(lblFunciones);
		
		lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 10));
		lblTipo.setBounds(10, 89, 70, 14);
		panel_2.add(lblTipo);
		
		lblDias = new JLabel("Dias");
		lblDias.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 10));
		lblDias.setBounds(10, 104, 70, 14);
		panel_2.add(lblDias);
		
		lblHoras = new JLabel("Horas");
		lblHoras.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 10));
		lblHoras.setBounds(10, 121, 70, 14);
		panel_2.add(lblHoras);
		
		lblIdentidad_1 = new JLabel("Identidad");
		lblIdentidad_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 10));
		lblIdentidad_1.setBounds(10, 146, 70, 14);
		panel_2.add(lblIdentidad_1);
		
		lblTipo_1 = new JLabel("Tipo");
		lblTipo_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 10));
		lblTipo_1.setBounds(10, 163, 70, 14);
		panel_2.add(lblTipo_1);
		
		lblTiempo = new JLabel("Tiempo");
		lblTiempo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 10));
		lblTiempo.setBounds(10, 179, 70, 14);
		panel_2.add(lblTiempo);
		
		lblDireccion_1 = new JLabel("Contrato");
		lblDireccion_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 10));
		lblDireccion_1.setBounds(10, 196, 70, 14);
		panel_2.add(lblDireccion_1);
		
		btnvercontrato = new JButton("ver");
		btnvercontrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lbl_foto_empleado_asignacion.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "No hay imagen que mostrar");
				} else {
					visor_imagen visor = new visor_imagen();
					ruta = lbl_foto_empleado_asignacion.getText().toString();
					visor.txtRutaImagen.setText(ruta);
					visor.setVisible(true);
					visor.setLocationRelativeTo(null);
					imagen = new ImageIcon(ruta);
					visor_imagen.lblImagen.setIcon(imagen);
				}
			}
		});
		btnvercontrato.setBounds(129, 196, 52, 14);
		panel_2.add(btnvercontrato);

		btnGuardarEmpleado = new JButton("Guardar");
		btnGuardarEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnGuardarEmpleado.setBackground(new Color(60, 179, 113));
		btnGuardarEmpleado.setBounds(444, 572, 99, 23);
		panel.add(btnGuardarEmpleado);
		
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
		lblEmpleadosRegistrados.setBounds(39, 62, 206, 29);
		panel_1.add(lblEmpleadosRegistrados);
		lblEmpleadosRegistrados.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));

		JLabel label_2 = new JLabel("Buscar empleado :");
		label_2.setBounds(39, 102, 142, 14);
		panel_1.add(label_2);
		label_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

		txtBusquedaEmpleado = new JTextField();
		txtBusquedaEmpleado.setBounds(158, 99, 314, 20);
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
		barraTablaEmpleados.setBounds(39, 130, 514, 421);
		panel_1.add(barraTablaEmpleados);

		tablaEmpleados = new JTable();
		barraTablaEmpleados.setViewportView(tablaEmpleados);

		btnBorrarEmpleado = new JButton("Borrar");
		btnBorrarEmpleado.setBounds(39, 565, 99, 23);
		panel_1.add(btnBorrarEmpleado);
		btnBorrarEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnBorrarEmpleado.setBackground(new Color(220, 20, 60));

		btnMostrarEmpleado = new JButton("Ver detalles");
		btnMostrarEmpleado.setBounds(294, 565, 108, 23);
		panel_1.add(btnMostrarEmpleado);
		btnMostrarEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnMostrarEmpleado.setBackground(new Color(0, 206, 209));

		btnActualizarDatosEmpleado = new JButton("Actualizar Datos");
		btnActualizarDatosEmpleado.setBounds(416, 565, 137, 23);
		panel_1.add(btnActualizarDatosEmpleado);
		btnActualizarDatosEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnActualizarDatosEmpleado.setBackground(new Color(60, 179, 113));

		JLabel label_6 = new JLabel();
		label_6.setBounds(482, 62, 71, 60);
		panel_1.add(label_6);
		final ImageIcon logo12 = new ImageIcon(
				iconoo22.getImage().getScaledInstance(label_6.getWidth(), label_6.getHeight(), Image.SCALE_DEFAULT));
		label_6.setIcon(logo12);

		btnImprimirReporteEmpleados = new JButton("Imprimir Reporte");
		btnImprimirReporteEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date date = new Date();
				DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
				hora_fecha_reporte = ("Hora y fecha del reporte : " + hourdateFormat.format(date));
				utilJTablePrint(tablaEmpleados, "Canal 40 (COFFEE TV CHANNEL)",
						"Reporte de Empleados.____. " + hora_fecha_reporte, true);
			}
		});
		btnImprimirReporteEmpleados.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnImprimirReporteEmpleados.setBackground(new Color(60, 179, 113));
		btnImprimirReporteEmpleados.setBounds(335, 66, 137, 19);
		panel_1.add(btnImprimirReporteEmpleados);

		JLabel lblEmpleados = new JLabel("");
		lblEmpleados.setBounds(0, 0, 593, 635);
		panel_1.add(lblEmpleados);
		final ImageIcon logo11 = new ImageIcon(iconoo.getImage().getScaledInstance(lblEmpleados.getWidth(),
				lblEmpleados.getHeight(), Image.SCALE_DEFAULT));
		lblEmpleados.setIcon(logo11);

		lblAsignacionesYLista = new JLabel("LISTA DE EMPLEADOS REGISTRADOS.");
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
				"Fecha_Labores", "Estado", "Cargo", "Sueldo", "Hora Extra", "Obligaciones", "Horario", "Dias", "Horas",
				"Identidad_Contrato", "Tipo", "Tiempo", "Foto" };
		String informacion[][] = control_empleado.obtenerMatriz();
		tablaEmpleados = new JTable(informacion, titulos);
		barraTablaEmpleados.setViewportView(tablaEmpleados);
		tablaEmpleados.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tablaEmpleados.getTableHeader().setReorderingAllowed(false);

		DefaultTableCellRenderer tcr;
		tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.RIGHT);
		tablaEmpleados.getColumnModel().getColumn(18).setCellRenderer(tcr);
		tablaEmpleados.getColumnModel().getColumn(19).setCellRenderer(tcr);

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

	public void utilJTablePrint(JTable jTable, String header, String footer, boolean showPrintDialog) {
		boolean fitWidth = true;
		boolean interactive = true;
		// We define the print mode (Definimos el modo de impresión)
		JTable.PrintMode mode = fitWidth ? JTable.PrintMode.FIT_WIDTH : JTable.PrintMode.NORMAL;
		try {
			// Print the table (Imprimo la tabla)
			boolean complete = jTable.print(mode, new MessageFormat(header), new MessageFormat(footer), showPrintDialog,
					null, interactive);
			if (complete) {
				// Mostramos el mensaje de impresión existosa
				JOptionPane.showMessageDialog(jTable, "Print complete (Impresión completa)",
						"Print result (Resultado de la impresión)", JOptionPane.INFORMATION_MESSAGE);
			} else {
				// Mostramos un mensaje indicando que la impresión fue cancelada
				JOptionPane.showMessageDialog(jTable, "Print canceled (Impresión cancelada)",
						"Print result (Resultado de la impresión)", JOptionPane.WARNING_MESSAGE);
			}
		} catch (PrinterException pe) {
			JOptionPane.showMessageDialog(jTable, "Print fail (Fallo de impresión): " + pe.getMessage(),
					"Print result (Resultado de la impresión)", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void validarIdentidad() {
		conexion conex = new conexion();
		try {
			Statement estatuto = conex.getConexion().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT identidad_empleado FROM empleados where identidad_empleado = '"
					+ txtIdentidadEmpleado.getText().toString() + "'");

			if (rs.next()) {
				identidad = (rs.getString("identidad_empleado"));
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
