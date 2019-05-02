package formularios;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;
import javax.swing.text.MaskFormatter;

import com.placeholder.PlaceHolder;

import clases.bonificacion;
import clases.deduccion;
import clases.empleado;
import conexion.conexion;
import consultas.consultas_bonificacion;
import consultas.consultas_deduccion;
import consultas.consultas_planilla;
import controles.control_bonificacion;
import controles.control_deduccion;
import controles.control_planilla;
import utilidades.visor_imagen;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.RowFilter;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Event;

import javax.swing.ScrollPaneConstants;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;

public class registro_planillas extends JFrame {

	public JPanel contentPane;
	public JTextField txtApellidosPlanilla;
	public JTextField txtNombresPlanilla;
	public JTextField txtCodigoPlanilla;
	public JLabel label_2;
	public JLabel label_3;
	public JLabel label_4;
	public JLabel label_5;
	public JTextField txtIdentidadPlanilla;
	public JLabel lblBuscarEmpleadoPor;
	public JFormattedTextField txtIdentidadEmpleadoPlanilla;
	public JPanel panel;
	public JLabel label_6;
	public JLabel lblTipo;
	public JLabel lblCantidad;
	public static JTextField txtCantidadPlanilla;
	public JLabel lblAgregarDeduccion;
	public JPanel panel_2;
	public JLabel label_8;
	public JTextField txtBusquedaPlanilla;
	public JTextField txtTotalPlanilla;
	public JLabel lblFotoPlanilla;
	public JButton button;
	public PlaceHolder pista;
	public JDateChooser dateFechaPlanilla;
	public JButton button_1;
	public JButton button_2;

	public JButton btnBorrarPlanilla;
	public JButton btnVerPlanilla;
	public JButton btnActualizarDatosPlanilla;
	public JButton btnAceptar;
	public JButton btnNuevo;
	public JButton btnActualizar;
	public JButton btnGuardar;
	public JLabel lblTotalDeducciones;
	public JButton btnBuscarIdentidadPlanilla;
	public JTextFieldDateEditor editor;

	public JScrollPane barraTablaPlanilla;
	public JTable tablaPlanilla;

	public TableRowSorter trsfiltro;
	String filtro;

	public static String ruta;
	public static ImageIcon imagen;

	public static String bonificaciones = null;
	public static String deducciones = null;

	public JComboBox<?> cbxTipoPlanilla;
	public JTextField txtDireccionFoto;
	public JButton btnVer;
	public JLabel lblL;
	public JLabel label;
	public JTextField txtCodigo;
	public JLabel lblFecha;
	public static JTextField txtTotalBonificacionesPlanilla;
	public static JTextField txtTotalDeduccionesPlanilla;
	public JLabel lblCargo;
	public JTextField txtCargoPlanilla;
	public JLabel lblSueldoNeto;
	public static JTextField txtSueldoNetoPlanilla;
	public JLabel label_12;
	public JLabel lblTotalAPagar;
	public static JTextField txtTotalPagoEmpleado;
	public JLabel label_14;
	public JLabel label_15;
	public JLabel label_16;
	public JLabel lblPlanillaCanal;
	public JPanel panel_3;
	public JLabel lbl_hora;
	public JPanel panel_4;
	public JLabel label_17;
	public JButton btnActualizar_Bonificaciones;
	public JButton btnActualizar_Deducciones;
	public static String hora_fecha_reporte;

	public registro_planillas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 650);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/material/logo.png")));
		final ImageIcon icono = new ImageIcon(getClass().getResource("/material/libreta.png"));
		final ImageIcon icono2 = new ImageIcon(getClass().getResource("/material/logo.png"));
		final ImageIcon usuario = new ImageIcon(getClass().getResource("/material/usuario.png"));

		panel_2 = new JPanel();
		panel_2.setBounds(444, 46, 430, 554);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblBuscarDeduccion = new JLabel("Buscar :");
		lblBuscarDeduccion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblBuscarDeduccion.setBounds(28, 123, 136, 22);
		panel_2.add(lblBuscarDeduccion);

		txtBusquedaPlanilla = new JTextField();
		txtBusquedaPlanilla.setHorizontalAlignment(SwingConstants.CENTER);
		InputMap map41 = txtBusquedaPlanilla.getInputMap(JComponent.WHEN_FOCUSED);
		map41.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtBusquedaPlanilla.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtBusquedaPlanilla.setColumns(10);
		txtBusquedaPlanilla.setBounds(87, 124, 159, 21);
		panel_2.add(txtBusquedaPlanilla);
		txtBusquedaPlanilla.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				trsfiltro = new TableRowSorter(tablaPlanilla.getModel());
				tablaPlanilla.setRowSorter(trsfiltro);
			}

			@Override
			public void keyPressed(KeyEvent ke) {

			}

			@Override
			public void keyReleased(KeyEvent ke) {
				String cadena = (txtBusquedaPlanilla.getText());
				txtBusquedaPlanilla.setText(cadena);
				repaint();
				filtro();
			}
		});

		JLabel label_10 = new JLabel();
		label_10.setBounds(353, 49, 49, 44);
		panel_2.add(label_10);
		final ImageIcon logo2 = new ImageIcon(
				icono2.getImage().getScaledInstance(label_10.getWidth(), label_10.getHeight(), Image.SCALE_DEFAULT));
		label_10.setIcon(logo2);

		JLabel lblDeduccionesRegistradas = new JLabel("Empleados agregados a la planilla.");
		lblDeduccionesRegistradas.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblDeduccionesRegistradas.setBounds(28, 95, 283, 30);
		panel_2.add(lblDeduccionesRegistradas);

		btnBorrarPlanilla = new JButton("Borrar");
		btnBorrarPlanilla.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnBorrarPlanilla.setBackground(new Color(220, 20, 60));
		btnBorrarPlanilla.setBounds(28, 496, 99, 23);
		panel_2.add(btnBorrarPlanilla);

		btnVerPlanilla = new JButton("Ver detalles");
		btnVerPlanilla.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnVerPlanilla.setBackground(new Color(0, 206, 209));
		btnVerPlanilla.setBounds(147, 496, 108, 23);
		panel_2.add(btnVerPlanilla);

		btnActualizarDatosPlanilla = new JButton("Actualizar Datos");
		btnActualizarDatosPlanilla.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnActualizarDatosPlanilla.setBackground(new Color(60, 179, 113));
		btnActualizarDatosPlanilla.setBounds(265, 497, 137, 23);
		panel_2.add(btnActualizarDatosPlanilla);

		barraTablaPlanilla = new JScrollPane((Component) null, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		barraTablaPlanilla.setBounds(26, 152, 376, 304);
		panel_2.add(barraTablaPlanilla);

		lblTotalDeducciones = new JLabel("Total Pago :");
		lblTotalDeducciones.setBounds(28, 467, 150, 14);
		panel_2.add(lblTotalDeducciones);
		lblTotalDeducciones.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));

		txtTotalPlanilla = new JTextField();
		txtTotalPlanilla.setBounds(188, 465, 122, 20);
		panel_2.add(txtTotalPlanilla);
		txtTotalPlanilla.setEditable(false);
		txtTotalPlanilla.setColumns(10);
		txtTotalPlanilla.setHorizontalAlignment(SwingConstants.RIGHT);

		JButton btnCalcularPlanilla = new JButton("Calcular");
		btnCalcularPlanilla.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				totalizar();
			}
		});
		btnCalcularPlanilla.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 10));
		btnCalcularPlanilla.setBounds(320, 465, 82, 21);
		panel_2.add(btnCalcularPlanilla);
		btnCalcularPlanilla.setBackground(new Color(60, 179, 113));

		label = new JLabel("L.");
		label.setBounds(173, 467, 28, 18);
		panel_2.add(label);
		label.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));

		lblPlanillaCanal = new JLabel("Planilla Canal 40.");
		lblPlanillaCanal.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		lblPlanillaCanal.setBounds(129, 49, 182, 19);
		panel_2.add(lblPlanillaCanal);

		panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(273, 95, 129, 22);
		panel_2.add(panel_3);

		lbl_hora = new JLabel();
		lbl_hora.setBounds(0, 0, 123, 22);
		panel_3.add(lbl_hora);
		lbl_hora.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_hora.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		lbl_hora.setBackground(SystemColor.menu);

		panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(69, 69, 274, 24);
		panel_2.add(panel_4);

		label_17 = new JLabel();
		label_17.setBounds(10, 0, 253, 22);
		panel_4.add(label_17);
		label_17.setText("Dia jueves 25 de abril del 2019");
		label_17.setHorizontalAlignment(SwingConstants.CENTER);
		label_17.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		label_17.setBackground(Color.WHITE);
		
		button_3 = new JButton("Imprimir Reporte");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date date = new Date();
				DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
				hora_fecha_reporte = ("Hora y fecha del reporte : " + hourdateFormat.format(date));
				utilJTablePrint(tablaPlanilla, "Canal 40 (COFFEE TV CHANNEL)",
						"Reporte de la Planilla.____. " + hora_fecha_reporte, true);
			}
		});
		button_3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		button_3.setBackground(new Color(60, 179, 113));
		button_3.setBounds(256, 124, 146, 19);
		panel_2.add(button_3);
		
				label_8 = new JLabel("");
				label_8.setBounds(0, 0, 430, 554);
				panel_2.add(label_8);
				final ImageIcon logo = new ImageIcon(
						icono.getImage().getScaledInstance(label_8.getWidth(), label_8.getHeight(), Image.SCALE_DEFAULT));
				label_8.setIcon(logo);

		JLabel lblRegistroYMantenimiento = new JLabel("REGISTRO Y MANTENIMIENTO DE PLANILLAS");
		lblRegistroYMantenimiento.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblRegistroYMantenimiento.setBounds(10, 1, 551, 39);
		contentPane.add(lblRegistroYMantenimiento);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 46, 424, 554);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		button_1 = new JButton("=");
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (txtCantidadPlanilla.getText().isEmpty() && txtTotalBonificacionesPlanilla.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Se requieren los datos de sueldo y bonificaciones");
				} else {
					double a = 0;
					double b = 0;
					double c = 0;
					a = Double.valueOf(txtCantidadPlanilla.getText());
					b = Double.valueOf(txtTotalBonificacionesPlanilla.getText());
					c = a + b;
					txtSueldoNetoPlanilla.setText(String.valueOf(c));
				}

			}
		});

		button_2 = new JButton("=");
		button_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (txtSueldoNetoPlanilla.getText().isEmpty() && txtTotalDeduccionesPlanilla.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Se requieren los datos de sueldo y bonificaciones");
				} else {
					double a = 0;
					double b = 0;
					double c = 0;
					a = Double.valueOf(txtSueldoNetoPlanilla.getText());
					b = Double.valueOf(txtTotalDeduccionesPlanilla.getText());
					c = a - b;
					txtTotalPagoEmpleado.setText(String.valueOf(c));
				}

			}
		});
		button_2.setBackground(new Color(255, 215, 0));
		button_2.setBounds(274, 428, 46, 20);
		panel_1.add(button_2);
		button_1.setBackground(new Color(255, 215, 0));
		button_1.setBounds(274, 363, 46, 20);
		panel_1.add(button_1);

		JLabel lblRegistrarDeducciones = new JLabel("Registrar Planilla.");
		lblRegistrarDeducciones.setBounds(35, 39, 207, 28);
		panel_1.add(lblRegistrarDeducciones);
		lblRegistrarDeducciones.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));

		lblBuscarEmpleadoPor = new JLabel("Ingrese la Identidad :");
		lblBuscarEmpleadoPor.setForeground(new Color(0, 128, 0));
		lblBuscarEmpleadoPor.setBounds(35, 67, 168, 27);
		panel_1.add(lblBuscarEmpleadoPor);
		lblBuscarEmpleadoPor.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

		MaskFormatter formato = null;
		try {
			formato = new MaskFormatter("####-####-#####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtIdentidadEmpleadoPlanilla = new JFormattedTextField(formato);
		txtIdentidadEmpleadoPlanilla.setBounds(168, 71, 132, 20);
		txtIdentidadEmpleadoPlanilla.setHorizontalAlignment(SwingConstants.CENTER);
		InputMap map42 = txtIdentidadEmpleadoPlanilla.getInputMap(JComponent.WHEN_FOCUSED);
		map42.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		panel_1.add(txtIdentidadEmpleadoPlanilla);
		txtIdentidadEmpleadoPlanilla.setColumns(10);
		txtIdentidadEmpleadoPlanilla.addKeyListener(new KeyListener() {
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

		JLabel lblDatosDelEmpleado = new JLabel("Datos del empleado :");
		lblDatosDelEmpleado.setBounds(35, 91, 168, 28);
		panel_1.add(lblDatosDelEmpleado);
		lblDatosDelEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));

		label_4 = new JLabel("Codigo :");
		label_4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		label_4.setBounds(35, 126, 63, 14);
		panel_1.add(label_4);

		txtCodigoPlanilla = new JTextField();
		txtCodigoPlanilla.setBounds(102, 123, 28, 20);
		panel_1.add(txtCodigoPlanilla);
		txtCodigoPlanilla.setEditable(false);
		txtCodigoPlanilla.setColumns(10);
		txtCodigoPlanilla.setHorizontalAlignment(SwingConstants.CENTER);

		label_2 = new JLabel("Nombres :");
		label_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		label_2.setBounds(35, 152, 63, 14);
		panel_1.add(label_2);

		txtNombresPlanilla = new JTextField();
		txtNombresPlanilla.setEditable(false);
		txtNombresPlanilla.setBounds(102, 149, 186, 20);
		panel_1.add(txtNombresPlanilla);
		txtNombresPlanilla.setColumns(10);
		txtNombresPlanilla.setHorizontalAlignment(SwingConstants.CENTER);

		label_3 = new JLabel("Apellidos :");
		label_3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		label_3.setBounds(35, 177, 63, 14);
		panel_1.add(label_3);

		txtApellidosPlanilla = new JTextField();
		txtApellidosPlanilla.setEditable(false);
		txtApellidosPlanilla.setBounds(102, 174, 186, 20);
		panel_1.add(txtApellidosPlanilla);
		txtApellidosPlanilla.setColumns(10);
		txtApellidosPlanilla.setHorizontalAlignment(SwingConstants.CENTER);

		label_5 = new JLabel("Identidad :");
		label_5.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		label_5.setBounds(35, 205, 63, 14);
		panel_1.add(label_5);

		txtIdentidadPlanilla = new JTextField();
		txtIdentidadPlanilla.setEditable(false);
		txtIdentidadPlanilla.setBounds(102, 199, 186, 20);
		panel_1.add(txtIdentidadPlanilla);
		txtIdentidadPlanilla.setColumns(10);
		txtIdentidadPlanilla.setHorizontalAlignment(SwingConstants.CENTER);

		label_6 = new JLabel("Fotografia :");
		label_6.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		label_6.setBounds(310, 98, 82, 14);
		panel_1.add(label_6);

		panel = new JPanel();
		panel.setBounds(298, 113, 94, 87);
		panel_1.add(panel);
		panel.setLayout(null);

		lblFotoPlanilla = new JLabel();
		lblFotoPlanilla.setBounds(0, 0, 94, 87);
		panel.add(lblFotoPlanilla);
		final ImageIcon logo22 = new ImageIcon(usuario.getImage().getScaledInstance(lblFotoPlanilla.getWidth(),
				lblFotoPlanilla.getHeight(), Image.SCALE_DEFAULT));
		lblFotoPlanilla.setIcon(logo22);

		lblAgregarDeduccion = new JLabel("Datos monetarios del empleado :");
		lblAgregarDeduccion.setBounds(35, 225, 253, 26);
		panel_1.add(lblAgregarDeduccion);
		lblAgregarDeduccion.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));

		lblTipo = new JLabel("Tipo :");
		lblTipo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblTipo.setBounds(35, 282, 63, 14);
		panel_1.add(lblTipo);

		cbxTipoPlanilla = new JComboBox();
		cbxTipoPlanilla.setModel(new DefaultComboBoxModel(new String[] { "Mensual", "Eventual" }));
		cbxTipoPlanilla.setBounds(153, 280, 116, 20);
		panel_1.add(cbxTipoPlanilla);

		lblCantidad = new JLabel("Sueldo");
		lblCantidad.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblCantidad.setBounds(35, 313, 63, 14);
		panel_1.add(lblCantidad);

		txtCantidadPlanilla = new JTextField();
		txtCantidadPlanilla.setEditable(false);
		txtCantidadPlanilla.setBounds(153, 311, 116, 20);
		txtCantidadPlanilla.setColumns(10);
		txtCantidadPlanilla.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(txtCantidadPlanilla);
		

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnAceptar.setBackground(Color.WHITE);
		btnAceptar.setBounds(35, 474, 99, 23);
		panel_1.add(btnAceptar);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnNuevo.setBackground(Color.WHITE);
		btnNuevo.setBounds(35, 499, 99, 23);
		panel_1.add(btnNuevo);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnActualizar.setBackground(new Color(60, 179, 113));
		btnActualizar.setBounds(293, 474, 99, 23);
		panel_1.add(btnActualizar);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnGuardar.setBackground(new Color(60, 179, 113));
		btnGuardar.setBounds(293, 499, 99, 23);
		panel_1.add(btnGuardar);

		btnBuscarIdentidadPlanilla = new JButton("Buscar");
		btnBuscarIdentidadPlanilla.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (txtIdentidadEmpleadoPlanilla.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor ingrese la identidad antes buscar");
				} else {
					busquedaDatosEmpleado();
				}

			}
		});
		btnBuscarIdentidadPlanilla.setBackground(new Color(60, 179, 113));
		btnBuscarIdentidadPlanilla.setBounds(310, 70, 82, 23);
		panel_1.add(btnBuscarIdentidadPlanilla);

		txtDireccionFoto = new JTextField();
		txtDireccionFoto.setEditable(false);
		txtDireccionFoto.setColumns(10);
		txtDireccionFoto.setBounds(298, 199, 94, 20);
		panel_1.add(txtDireccionFoto);

		btnVer = new JButton("Ver");
		btnVer.setBounds(308, 218, 73, 15);
		panel_1.add(btnVer);
		btnVer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
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
		});
		btnVer.setBackground(new Color(60, 179, 113));

		lblL = new JLabel("L.");
		lblL.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblL.setBounds(136, 313, 18, 18);
		panel_1.add(lblL);

		JLabel label_1 = new JLabel("Codigo :");
		label_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		label_1.setBounds(35, 255, 63, 14);
		panel_1.add(label_1);

		txtCodigo = new JTextField();
		txtCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(153, 251, 28, 20);
		panel_1.add(txtCodigo);

		lblFecha = new JLabel("Fecha :");
		lblFecha.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblFecha.setBounds(279, 253, 109, 20);
		panel_1.add(lblFecha);
		lblFecha.setVisible(false);

		dateFechaPlanilla = new JDateChooser();
		dateFechaPlanilla.setBounds(279, 280, 109, 20);
		dateFechaPlanilla.setDateFormatString("dd-MMMMM-yyyy");
		panel_1.add(dateFechaPlanilla);
		editor = (JTextFieldDateEditor) dateFechaPlanilla.getDateEditor();
		editor.setEditable(false);
		editor.setHorizontalAlignment(SwingConstants.CENTER);
		dateFechaPlanilla.setVisible(false);

		JLabel lblBonificaciones = new JLabel("Bonificaciones :");
		lblBonificaciones.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblBonificaciones.setBounds(35, 340, 95, 14);
		panel_1.add(lblBonificaciones);

		JLabel label_11 = new JLabel("L.");
		label_11.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		label_11.setBounds(136, 339, 18, 18);
		panel_1.add(label_11);

		txtTotalBonificacionesPlanilla = new JTextField();
		txtTotalBonificacionesPlanilla.setEditable(false);
		txtTotalBonificacionesPlanilla.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTotalBonificacionesPlanilla.setColumns(10);
		txtTotalBonificacionesPlanilla.setBounds(153, 338, 116, 20);
		panel_1.add(txtTotalBonificacionesPlanilla);

		JLabel lblDeducciones = new JLabel("(Deducciones) :");
		lblDeducciones.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblDeducciones.setBounds(35, 402, 95, 20);
		panel_1.add(lblDeducciones);

		JLabel label_13 = new JLabel("L.");
		label_13.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		label_13.setBounds(136, 404, 18, 18);
		panel_1.add(label_13);

		txtTotalDeduccionesPlanilla = new JTextField();
		txtTotalDeduccionesPlanilla.setEditable(false);
		txtTotalDeduccionesPlanilla.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTotalDeduccionesPlanilla.setColumns(10);
		txtTotalDeduccionesPlanilla.setBounds(153, 402, 116, 20);
		panel_1.add(txtTotalDeduccionesPlanilla);

		lblCargo = new JLabel("Cargo :");
		lblCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblCargo.setBounds(140, 126, 63, 14);
		panel_1.add(lblCargo);

		txtCargoPlanilla = new JTextField();
		txtCargoPlanilla.setHorizontalAlignment(SwingConstants.CENTER);
		txtCargoPlanilla.setEditable(false);
		txtCargoPlanilla.setColumns(10);
		txtCargoPlanilla.setBounds(194, 120, 94, 20);
		panel_1.add(txtCargoPlanilla);

		lblSueldoNeto = new JLabel("Sueldo Neto :");
		lblSueldoNeto.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblSueldoNeto.setBounds(35, 377, 95, 14);
		panel_1.add(lblSueldoNeto);

		txtSueldoNetoPlanilla = new JTextField();
		txtSueldoNetoPlanilla.setEditable(false);
		txtSueldoNetoPlanilla.setHorizontalAlignment(SwingConstants.RIGHT);
		txtSueldoNetoPlanilla.setColumns(10);
		txtSueldoNetoPlanilla.setBounds(153, 375, 116, 20);
		panel_1.add(txtSueldoNetoPlanilla);

		label_12 = new JLabel("L.");
		label_12.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		label_12.setBounds(136, 376, 18, 18);
		panel_1.add(label_12);

		lblTotalAPagar = new JLabel("Total a pagar :");
		lblTotalAPagar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblTotalAPagar.setBounds(35, 455, 95, 14);
		panel_1.add(lblTotalAPagar);

		txtTotalPagoEmpleado = new JTextField();
		txtTotalPagoEmpleado.setEditable(false);
		txtTotalPagoEmpleado.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTotalPagoEmpleado.setColumns(10);
		txtTotalPagoEmpleado.setBounds(153, 453, 116, 20);
		panel_1.add(txtTotalPagoEmpleado);

		label_14 = new JLabel("L.");
		label_14.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		label_14.setBounds(136, 454, 18, 18);
		panel_1.add(label_14);

		label_15 = new JLabel("______________________");
		label_15.setBounds(146, 356, 154, 14);
		panel_1.add(label_15);

		label_16 = new JLabel("______________________");
		label_16.setBounds(147, 422, 154, 20);
		panel_1.add(label_16);

		btnActualizar_Bonificaciones = new JButton("Calcular");
		btnActualizar_Bonificaciones.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bonificacion clase = new bonificacion();
				consultas_bonificacion consulta = new consultas_bonificacion();
				registro_bonificaciones formulario = new registro_bonificaciones();
				control_bonificacion control = new control_bonificacion(clase, consulta, formulario);
				formulario.setVisible(true);
				formulario.setLocationRelativeTo(null);
				formulario.txtIdentidadEmpleadoBonificacion.requestFocusInWindow();
				formulario.construirTabla();
				formulario.obtenerUltimoId();
				formulario.establecerFechaRegistro();
				formulario.pistas();
				formulario.btnBorrarBonificacion.setVisible(false);
				formulario.btnGuardar.setVisible(true);
				formulario.btnNuevo.setVisible(true);
				formulario.btnActualizar.setVisible(false);
				formulario.btnActualizarDatosBonificacion.setVisible(true);
				formulario.btnVerBonificacion.setVisible(true);
				formulario.btnAceptar.setVisible(false);
				formulario.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				formulario.btnAtras.setVisible(false);
			}
		});
		btnActualizar_Bonificaciones.setBackground(new Color(60, 179, 113));
		btnActualizar_Bonificaciones.setBounds(274, 338, 109, 20);
		panel_1.add(btnActualizar_Bonificaciones);

		btnActualizar_Deducciones = new JButton("Calcular");
		btnActualizar_Deducciones.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deduccion clase = new deduccion();
				consultas_deduccion consulta = new consultas_deduccion();
				registro_deducciones formulario = new registro_deducciones();
				control_deduccion control = new control_deduccion(clase, consulta, formulario);
				formulario.setVisible(true);
				formulario.setLocationRelativeTo(null);
				formulario.txtIdentidadEmpleadoDeduccion.requestFocusInWindow();
				formulario.construirTabla();
				formulario.obtenerUltimoId();
				formulario.establecerFechaRegistro();
				formulario.pistas();
				formulario.btnBorrarDeduccion.setVisible(false);
				formulario.btnGuardar.setVisible(true);
				formulario.btnNuevo.setVisible(true);
				formulario.btnActualizar.setVisible(false);
				formulario.btnActualizarDatosDeduccion.setVisible(true);
				formulario.btnVerDeduccion.setVisible(true);
				formulario.btnAceptar.setVisible(false);
				formulario.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				formulario.btnAtras.setVisible(false);
			}
		});
		btnActualizar_Deducciones.setBackground(new Color(60, 179, 113));
		btnActualizar_Deducciones.setBounds(274, 403, 107, 20);
		panel_1.add(btnActualizar_Deducciones);

		JLabel label_7 = new JLabel("");
		label_7.setBounds(0, 0, 424, 554);
		panel_1.add(label_7);
		final ImageIcon logo21 = new ImageIcon(
				icono.getImage().getScaledInstance(label_7.getWidth(), label_7.getHeight(), Image.SCALE_DEFAULT));
		label_7.setIcon(logo21);

		button = new JButton("Regresar");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ventana_principal principal = new ventana_principal();
				principal.setVisible(true);
				principal.setLocationRelativeTo(null);
				dispose();
				Timer time = new Timer();
				time.schedule(principal.tarea, 0, 1000);
			}
		});
		button.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		button.setBackground(new Color(255, 127, 80));
		button.setBounds(772, 12, 102, 23);
		contentPane.add(button);
	}

	public void establecerFechaRegistro() {
		try {
			LocalDate fechaActual = LocalDate.now();
			Date date = Date.from(fechaActual.atStartOfDay(ZoneId.systemDefault()).toInstant());
			dateFechaPlanilla.setDate(date);
		} catch (Exception e) {

		}

	}

	public void construirTabla() {
		String titulos[] = { "Codigo", "Tipo", "Fecha", "Nombres", "Apellidos", "Identidad", "Cargo", "Sueldo",
				"Deducciones", "Bonificaciones", "Sueldo Neto", "Total" };
		String informacion[][] = control_planilla.obtenerMatriz();
		tablaPlanilla = new JTable(informacion, titulos);
		barraTablaPlanilla.setViewportView(tablaPlanilla);
		for (int c = 0; c < tablaPlanilla.getColumnCount(); c++) {
			Class<?> col_class = tablaPlanilla.getColumnClass(c);
			tablaPlanilla.setDefaultEditor(col_class, null);
			tablaPlanilla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			tablaPlanilla.getTableHeader().setReorderingAllowed(false);

			DefaultTableCellRenderer tcr;
			tcr = new DefaultTableCellRenderer();
			tcr.setHorizontalAlignment(SwingConstants.RIGHT);
			tablaPlanilla.getColumnModel().getColumn(11).setCellRenderer(tcr);
			tablaPlanilla.getColumnModel().getColumn(10).setCellRenderer(tcr);
			tablaPlanilla.getColumnModel().getColumn(9).setCellRenderer(tcr);
			tablaPlanilla.getColumnModel().getColumn(8).setCellRenderer(tcr);
			tablaPlanilla.getColumnModel().getColumn(7).setCellRenderer(tcr);
		}
	}

	public void filtro() {
		filtro = txtBusquedaPlanilla.getText();
		trsfiltro.setRowFilter(RowFilter.regexFilter(txtBusquedaPlanilla.getText(), 0, 1, 2, 3, 4));
	}

	public void pistas() {
		pista = new PlaceHolder(txtBusquedaPlanilla, "Escriba para buscar.");
		pista = new PlaceHolder(txtNombresPlanilla, "Nombres del empleado.");
		pista = new PlaceHolder(txtApellidosPlanilla, "Apellidos del empleado.");
		pista = new PlaceHolder(txtIdentidadEmpleadoPlanilla, "Escriba la identidad.");
		pista = new PlaceHolder(txtIdentidadPlanilla, "Identidad del empleado");
	}

	public void obtenerUltimoId() {
		String ultimoValor = null;
		int valor;
		String id = null;
		conexion objCon = new conexion();
		Connection conn = objCon.getConexion();
		try {
			PreparedStatement stmtr = conn
					.prepareStatement("SELECT * FROM planillas ORDER BY id_planilla DESC");
			ResultSet rsr = stmtr.executeQuery();
			if (rsr.next()) {
				ultimoValor = rsr.getString("id_planilla");
				valor = Integer.parseInt(ultimoValor);
				valor = valor + 1;
				id = String.valueOf(valor);
			}
			txtCodigo.setText(id);
			;
			stmtr.close();
			rsr.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void totalizar() {
		double t = 0;
		double p = 0;
		if (tablaPlanilla.getRowCount() > 0) {
			for (int i = 0; i < tablaPlanilla.getRowCount(); i++) {
				p = Double.parseDouble(tablaPlanilla.getValueAt(i, 11).toString());
				t += p;
			}
			txtTotalPlanilla.setText(String.valueOf(t));
		} else {
			JOptionPane.showMessageDialog(null, "No hay datos que totalizar");
		}
	}

	public void busquedaDatosEmpleado() {
		consultas_planilla consulta = new consultas_planilla();
		empleado clase = new empleado();
		clase.setIdentidad_empleado(txtIdentidadEmpleadoPlanilla.getText());
		if (consulta.buscar(clase)) {
			txtCodigoPlanilla.setText(String.valueOf(clase.getId_empleado()));
			txtNombresPlanilla.setText(String.valueOf(clase.getNombres_empleado()));
			txtApellidosPlanilla.setText(String.valueOf(clase.getApellidos_empleado()));
			txtIdentidadPlanilla.setText(String.valueOf(clase.getIdentidad_empleado()));
			txtDireccionFoto.setText(String.valueOf(clase.getDireccion_foto_empleado()));
			txtCargoPlanilla.setText(String.valueOf(clase.getNombre_cargo_empleado()));
			txtCantidadPlanilla.setText(String.valueOf(clase.getSueldo_cargo_empleado()));

			String ruta = txtDireccionFoto.getText().toString();
			final ImageIcon foto = new ImageIcon(ruta);
			final ImageIcon logo = new ImageIcon(foto.getImage().getScaledInstance(lblFotoPlanilla.getWidth(),
					lblFotoPlanilla.getHeight(), Image.SCALE_DEFAULT));
			lblFotoPlanilla.setIcon(logo);

			txtCodigoPlanilla.setForeground(Color.BLACK);
			txtNombresPlanilla.setForeground(Color.BLACK);
			txtApellidosPlanilla.setForeground(Color.BLACK);
			txtIdentidadPlanilla.setForeground(Color.BLACK);
			txtCargoPlanilla.setForeground(Color.BLACK);

		} else {
			JOptionPane.showMessageDialog(null, "No se encontro ningun registro");

		}
	}

	Timer time = new Timer();
	public TimerTask tarea = new TimerTask() {
		@Override
		public void run() {
			Calendar calendario = new GregorianCalendar();
			Date fechaHoraActual = new Date();
			calendario.setTime(fechaHoraActual);
			String horas;
			String minutos;
			String segundos;
			String ampm;
			Thread hilo = null;
			Thread hilo2;
			hilo2 = Thread.currentThread();
			hilo = new Thread();
			hilo.start();
			ampm = calendario.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";
			if (ampm.equals("PM")) {
				int h = calendario.get(Calendar.HOUR_OF_DAY) - 12;
				horas = h > 9 ? "" + h : "0" + h;
			} else {
				horas = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY)
						: "0" + calendario.get(Calendar.HOUR_OF_DAY);
			}
			minutos = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE)
					: "0" + calendario.get(Calendar.MINUTE);
			segundos = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND)
					: "0" + calendario.get(Calendar.SECOND);

			lbl_hora.setText(horas + ":" + minutos + ":" + segundos + " " + ampm);
		}
	};
	private JButton button_3;

	public static String getFecha() {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		SimpleDateFormat df = new SimpleDateFormat("'Dia' EEEEEEEEE dd 'de' MMMMM 'del' yyyy");
		date = cal.getTime();
		return df.format(date);
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
}
