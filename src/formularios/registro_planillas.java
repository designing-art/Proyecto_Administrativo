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
import clases.historial_planilla;
import clases.usuario;
import conexion.conexion;
import consultas.consultas_bonificacion;
import consultas.consultas_deduccion;
import consultas.consultas_empleado;
import consultas.consultas_historial_planilla;
import consultas.consultas_planilla;
import consultas.consultas_usuario;
import controles.control_bonificacion;
import controles.control_deduccion;
import controles.control_empleado;
import controles.control_historial_planilla;
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
import java.sql.SQLException;
import java.sql.Statement;
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
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import javax.swing.JToggleButton;

public class registro_planillas extends JFrame {

	public JPanel contentPane;
	public static JTextField txtApellidosPlanilla;
	public static JTextField txtNombresPlanilla;
	public static JTextField txtCodigoPlanilla;
	public JLabel label_2;
	public JLabel label_3;
	public JLabel label_4;
	public JLabel label_5;
	public JToggleButton up_down;
	public static JLabel lblNombrePlanillaNueva;
	public static JTextField txtIdentidadPlanilla;
	public JLabel lblBuscarEmpleadoPor;
	public static JFormattedTextField txtIdentidadEmpleadoPlanilla;
	public JPanel panel;
	public JLabel label_6;
	public JButton btnAgregar;
	public JLabel lblCantidad;

	public static String idPlanilla;
	public static String nombrePlanilla;
	public static JTextField txtCantidadPlanilla;
	public JLabel lblAgregarDeduccion;
	public JPanel panel_2;
	public JLabel label_8;
	public JTextField txtBusquedaPlanilla;
	public static JTextField txtTotaPlanilla;
	public static JLabel lblFotoPlanilla;
	public JButton button;
	public PlaceHolder pista;
	public JDateChooser dateFechaPlanilla;

	public static String nombreEmpresa = null;
	public static String totalDatos = null;

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
	public JScrollPane barraTablaEmpleados;
	public JTable tablaPlanilla;
	public JTable tablaEmpleados;

	public TableRowSorter trsfiltro;
	String filtro;

	public TableRowSorter trsfiltro2;
	String filtro2;
	public JLabel lblDetalleDeLa;
	public JTextField txtBusquedaEmpleados;

	public static String ruta;
	public static ImageIcon imagen;

	public static String bonificaciones = null;
	public static String deducciones = null;
	public static JTextField txtDireccionFoto;
	public JButton btnVer;
	public JLabel lblL;
	public JLabel label;
	public JTextField txtCodigo;
	public static JTextField txtSueldosPlanilla;
	public static JTextField txtSueldosTotalPlanilla;
	public static JTextField txtDeduccionesPlanilla;
	public static JTextField txtBonificacionesPlanilla;
	private JLabel lblPlanillasCreadasCon;
	public static JTextField txtTotalBonificacionesPlanilla;
	public static JTextField txtTotalDeduccionesPlanilla;
	public JLabel lblCargo;
	public static JTextField txtCargoPlanilla;
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

	public static String ruta_logo;
	public static JLabel label_22;

	public JButton button_3;
	public JTextField txtNumeroPlanilla;
	public static JTextField txtCodigoPlanillaNueva;
	public JButton btnNuevaPlanilla;
	public JButton btnGuardarPlanilla;

	public registro_planillas() {
		setResizable(false);
		setDefaultCloseOperation(0);
		setBounds(100, 100, 1336, 670);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/iconos/icono_d_a.jpg")));
		final ImageIcon icono = new ImageIcon(getClass().getResource("/iconos/libreta.png"));
		final ImageIcon usuario = new ImageIcon(getClass().getResource("/iconos/usuario.png"));
		final ImageIcon upand = new ImageIcon(getClass().getResource("/iconos/upandown.png"));

		panel_2 = new JPanel();
		panel_2.setBounds(885, 39, 430, 575);
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

		txtBusquedaPlanilla.setBounds(87, 124, 317, 18);

		txtBusquedaPlanilla.setBounds(87, 124, 312, 18);

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

		lblNombrePlanillaNueva = new JLabel("Nombre de la planilla.");
		lblNombrePlanillaNueva.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombrePlanillaNueva.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblNombrePlanillaNueva.setBounds(28, 101, 374, 22);
		panel_2.add(lblNombrePlanillaNueva);

		btnBorrarPlanilla = new JButton("Borrar");
		btnBorrarPlanilla.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnBorrarPlanilla.setBackground(new Color(220, 20, 60));
		btnBorrarPlanilla.setBounds(38, 513, 99, 23);
		panel_2.add(btnBorrarPlanilla);

		btnVerPlanilla = new JButton("Ver detalles");
		btnVerPlanilla.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnVerPlanilla.setBackground(new Color(0, 206, 209));
		btnVerPlanilla.setBounds(147, 513, 108, 23);
		panel_2.add(btnVerPlanilla);

		btnActualizarDatosPlanilla = new JButton("Actualizar Datos");
		btnActualizarDatosPlanilla.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnActualizarDatosPlanilla.setBackground(new Color(60, 179, 113));
		btnActualizarDatosPlanilla.setBounds(265, 514, 137, 23);
		panel_2.add(btnActualizarDatosPlanilla);

		barraTablaPlanilla = new JScrollPane((Component) null, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		barraTablaPlanilla.setBounds(28, 169, 376, 260);
		panel_2.add(barraTablaPlanilla);

		lblTotalDeducciones = new JLabel("Bonificaciones :");
		lblTotalDeducciones.setBounds(167, 428, 88, 15);
		panel_2.add(lblTotalDeducciones);
		lblTotalDeducciones.setFont(new Font("Arial Narrow", Font.BOLD, 12));

		txtTotaPlanilla = new JTextField();
		txtTotaPlanilla.setBounds(50, 474, 87, 18);
		panel_2.add(txtTotaPlanilla);
		txtTotaPlanilla.setEditable(false);
		txtTotaPlanilla.setColumns(10);
		txtTotaPlanilla.setHorizontalAlignment(SwingConstants.RIGHT);

		JButton btnCalcularPlanilla = new JButton("Calcular");
		btnCalcularPlanilla.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				totalizar();
			}
		});
		btnCalcularPlanilla.setFont(new Font("Dialog", Font.BOLD, 12));
		btnCalcularPlanilla.setBounds(147, 471, 108, 22);
		panel_2.add(btnCalcularPlanilla);
		btnCalcularPlanilla.setBackground(new Color(0, 139, 139));

		label = new JLabel("L.");
		label.setBounds(150, 440, 18, 18);
		panel_2.add(label);
		label.setFont(new Font("Arial Narrow", Font.BOLD, 12));

		lblPlanillaCanal = new JLabel("Planilla.");
		lblPlanillaCanal.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlanillaCanal.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));

		lblPlanillaCanal.setBounds(73, 52, 194, 22);

		lblPlanillaCanal.setBounds(82, 52, 173, 22);

		panel_2.add(lblPlanillaCanal);

		panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBackground(Color.WHITE);

		panel_3.setBounds(283, 79, 116, 22);
		panel_2.add(panel_3);

		lbl_hora = new JLabel();
		lbl_hora.setBounds(0, 0, 108, 22);
		panel_3.add(lbl_hora);
		lbl_hora.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_hora.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		lbl_hora.setBackground(SystemColor.menu);
		panel_3.setBounds(291, 79, 108, 22);
		panel_2.add(panel_3);

		panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(28, 79, 253, 22);
		panel_2.add(panel_4);

		label_17 = new JLabel();
		label_17.setBounds(0, 0, 238, 22);
		panel_4.add(label_17);
		label_17.setText("Dia jueves 25 de abril del 2019");
		label_17.setHorizontalAlignment(SwingConstants.CENTER);
		label_17.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		label_17.setBackground(Color.WHITE);
		label_17.setText(getFecha());

		button_3 = new JButton("Imprimir Reporte");
		button_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				obtenerTotalDatosReporte();
				if (totalDatos == null) {
					JOptionPane.showMessageDialog(null, "No hay registros disponibles para imprimir un reporte");
				} else {
					String ampm;
					Calendar cal = new GregorianCalendar();
					ampm = cal.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";
					String fecha = getFechaYHora() + ampm;
					nombreEmpresa = login_usuario.nombre.toString();
					int total = Integer.valueOf(totalDatos);
					String i = null;
					if (total <= 46) {
						i = "1";
					} else {
						if (total > 46 && total <= 92) {
							i = "2";
						} else {
							if (total > 92 && total <= 138) {
								i = "3";
							} else {
								if (total > 138 && total <= 184) {
									i = "4";
								} else {
									if (total > 184 && total <= 230) {
										i = "5";
									} else {
										if (total > 230 && total <= 276) {
											i = "6";
										} else {
											if (total > 276 && total <= 322) {
												i = "7";
											} else {
												if (total > 322 && total <= 368) {
													i = "8";
												} else {
													if (total > 368 && total <= 414) {
														i = "9";
													} else {
														if (total > 414 && total <= 460) {
															i = "10";
														} else {
															i = "Mas de 10 paginas";

														}

													}

												}
											}
										}
									}
								}
							}
						}
					}

					String encabezado = "Reporte de planilla de " + login_usuario.nombre.toString();

					utilJTablePrint(tablaPlanilla, encabezado, "Pagina {0} de " + i + "          Impreso por: "
							+ login_usuario.nombreCompletoUsuario.toString() + "          " + fecha, true);

				}
			}
		});
		button_3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		button_3.setBackground(new Color(60, 179, 113));

		button_3.setBounds(266, 52, 136, 21);
		panel_2.add(button_3);

		txtNumeroPlanilla = new JTextField();
		txtNumeroPlanilla.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		txtNumeroPlanilla.setHorizontalAlignment(SwingConstants.CENTER);
		txtNumeroPlanilla.setText("1");
		txtNumeroPlanilla.setBackground(new Color(244, 164, 96));

		button_3.setBounds(256, 52, 146, 21);
		panel_2.add(button_3);

		txtCodigoPlanillaNueva = new JTextField();
		txtCodigoPlanillaNueva.setFont(new Font("Berlin Sans FB", Font.BOLD, 15));
		txtCodigoPlanillaNueva.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigoPlanillaNueva.setBackground(new Color(255, 255, 255));

		txtCodigoPlanillaNueva.setEditable(false);
		txtCodigoPlanillaNueva.setBounds(28, 54, 44, 18);
		panel_2.add(txtCodigoPlanillaNueva);
		txtCodigoPlanillaNueva.setColumns(10);

		btnNuevaPlanilla = new JButton("Historial de Planillas");
		btnNuevaPlanilla.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				historial_planilla clase = new historial_planilla();
				consultas_historial_planilla consulta = new consultas_historial_planilla();
				registro_nuevas_planillas formulario = new registro_nuevas_planillas();
				control_historial_planilla control = new control_historial_planilla(clase, consulta, formulario);
				formulario.setVisible(true);
				formulario.setLocationRelativeTo(null);
				formulario.txtNombrePlanilla.requestFocusInWindow();
				formulario.construirTabla();
				formulario.obtenerUltimoId();
				formulario.establecerFechaRegistro();
				formulario.pistas();
				formulario.btnBorrarPlanilla.setVisible(false);
				formulario.btnGuardar.setVisible(true);
				formulario.btnNuevo.setVisible(true);
				formulario.btnActualizar.setVisible(false);
				formulario.btnActualizarDatosPlanilla.setVisible(true);
				formulario.btnVerPlanilla.setVisible(true);
				formulario.btnAceptar.setVisible(false);
				formulario.iniciarEncero();
				Timer time = new Timer();
				time.schedule(formulario.tarea, 0, 1000);
				formulario.setTitle("Sesión iniciada por: " + login_usuario.nombreCompletoUsuario);
			}
		});
		btnNuevaPlanilla.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnNuevaPlanilla.setBackground(new Color(0, 250, 154));
		btnNuevaPlanilla.setBounds(157, 145, 156, 22);
		panel_2.add(btnNuevaPlanilla);

		btnGuardarPlanilla = new JButton("Guardar Planilla");
		btnGuardarPlanilla.setFont(new Font("Dialog", Font.BOLD, 12));
		btnGuardarPlanilla.setBackground(new Color(60, 179, 113));
		btnGuardarPlanilla.setBounds(265, 471, 134, 22);
		panel_2.add(btnGuardarPlanilla);

		JLabel lblSueldos = new JLabel("Sueldos :");
		lblSueldos.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		lblSueldos.setBounds(53, 428, 87, 15);
		panel_2.add(lblSueldos);

		JLabel label_10 = new JLabel("L.");
		label_10.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		label_10.setBounds(38, 442, 21, 15);
		panel_2.add(label_10);

		JLabel lblDeducciones_1 = new JLabel("Deducciones :");
		lblDeducciones_1.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		lblDeducciones_1.setBounds(279, 428, 88, 15);
		panel_2.add(lblDeducciones_1);

		JLabel label_18 = new JLabel("L.");
		label_18.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		label_18.setBounds(262, 442, 18, 15);
		panel_2.add(label_18);

		txtDeduccionesPlanilla = new JTextField();
		txtDeduccionesPlanilla.setHorizontalAlignment(SwingConstants.RIGHT);
		txtDeduccionesPlanilla.setEditable(false);
		txtDeduccionesPlanilla.setColumns(10);
		txtDeduccionesPlanilla.setBounds(274, 441, 87, 19);
		panel_2.add(txtDeduccionesPlanilla);

		JLabel label_19 = new JLabel("L.");
		label_19.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		label_19.setBounds(38, 475, 18, 15);
		panel_2.add(label_19);

		JLabel lblTotalPlanilla = new JLabel("Total Planilla :");
		lblTotalPlanilla.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		lblTotalPlanilla.setBounds(50, 459, 87, 18);
		panel_2.add(lblTotalPlanilla);

		txtBonificacionesPlanilla = new JTextField();
		txtBonificacionesPlanilla.setHorizontalAlignment(SwingConstants.RIGHT);
		txtBonificacionesPlanilla.setEditable(false);
		txtBonificacionesPlanilla.setColumns(10);
		txtBonificacionesPlanilla.setBounds(161, 441, 87, 18);
		panel_2.add(txtBonificacionesPlanilla);

		lblPlanillasCreadasCon = new JLabel("Planillas Creadas :");
		lblPlanillasCreadasCon.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblPlanillasCreadasCon.setBounds(28, 145, 208, 22);
		panel_2.add(lblPlanillasCreadasCon);

		txtSueldosPlanilla = new JTextField();
		txtSueldosPlanilla.setHorizontalAlignment(SwingConstants.RIGHT);
		txtSueldosPlanilla.setEditable(false);
		txtSueldosPlanilla.setColumns(10);
		txtSueldosPlanilla.setBounds(50, 441, 87, 19);
		panel_2.add(txtSueldosPlanilla);

		up_down = new JToggleButton("");
		up_down.setBounds(378, 149, 21, 18);
		panel_2.add(up_down);
		final ImageIcon logoq = new ImageIcon(
				upand.getImage().getScaledInstance(up_down.getWidth(), up_down.getHeight(), Image.SCALE_DEFAULT));
		up_down.setIcon(logoq);

		label_8 = new JLabel("");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setBounds(0, 0, 430, 575);
		panel_2.add(label_8);
		final ImageIcon logo = new ImageIcon(
				icono.getImage().getScaledInstance(label_8.getWidth(), label_8.getHeight(), Image.SCALE_DEFAULT));
		label_8.setIcon(logo);

		JLabel lblRegistroYMantenimiento = new JLabel("REGISTRO Y MANTENIMIENTO DE PLANILLAS");
		lblRegistroYMantenimiento.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblRegistroYMantenimiento.setBounds(10, 1, 551, 39);
		contentPane.add(lblRegistroYMantenimiento);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(451, 39, 424, 575);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		MaskFormatter formato = null;
		try {
			formato = new MaskFormatter("####-####-#####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		JLabel lblDatosDelEmpleado = new JLabel("Datos del empleado :");
		lblDatosDelEmpleado.setBounds(35, 114, 168, 28);
		panel_1.add(lblDatosDelEmpleado);
		lblDatosDelEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));

		label_4 = new JLabel("Codigo :");
		label_4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		label_4.setBounds(35, 149, 63, 14);
		panel_1.add(label_4);

		txtCodigoPlanilla = new JTextField();
		txtCodigoPlanilla.setBounds(102, 146, 28, 20);
		panel_1.add(txtCodigoPlanilla);
		txtCodigoPlanilla.setEditable(false);
		txtCodigoPlanilla.setColumns(10);
		txtCodigoPlanilla.setHorizontalAlignment(SwingConstants.CENTER);

		label_2 = new JLabel("Nombres :");
		label_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		label_2.setBounds(35, 197, 63, 19);
		panel_1.add(label_2);

		txtNombresPlanilla = new JTextField();
		txtNombresPlanilla.setEditable(false);
		txtNombresPlanilla.setBounds(102, 197, 186, 20);
		panel_1.add(txtNombresPlanilla);
		txtNombresPlanilla.setColumns(10);
		txtNombresPlanilla.setHorizontalAlignment(SwingConstants.CENTER);

		label_3 = new JLabel("Apellidos :");
		label_3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		label_3.setBounds(35, 224, 63, 17);
		panel_1.add(label_3);

		txtApellidosPlanilla = new JTextField();
		txtApellidosPlanilla.setEditable(false);
		txtApellidosPlanilla.setBounds(102, 224, 186, 20);
		panel_1.add(txtApellidosPlanilla);
		txtApellidosPlanilla.setColumns(10);
		txtApellidosPlanilla.setHorizontalAlignment(SwingConstants.CENTER);

		label_5 = new JLabel("Identidad :");
		label_5.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		label_5.setBounds(35, 250, 63, 19);
		panel_1.add(label_5);

		txtIdentidadPlanilla = new JTextField();
		txtIdentidadPlanilla.setEditable(false);
		txtIdentidadPlanilla.setBounds(102, 250, 186, 20);
		panel_1.add(txtIdentidadPlanilla);
		txtIdentidadPlanilla.setColumns(10);
		txtIdentidadPlanilla.setHorizontalAlignment(SwingConstants.CENTER);

		label_6 = new JLabel("Fotografia :");
		label_6.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		label_6.setBounds(310, 138, 82, 14);
		panel_1.add(label_6);

		panel = new JPanel();
		panel.setBounds(298, 153, 94, 87);
		panel_1.add(panel);
		panel.setLayout(null);

		lblFotoPlanilla = new JLabel();
		lblFotoPlanilla.setBounds(0, 0, 94, 87);
		panel.add(lblFotoPlanilla);
		final ImageIcon logo22 = new ImageIcon(usuario.getImage().getScaledInstance(lblFotoPlanilla.getWidth(),
				lblFotoPlanilla.getHeight(), Image.SCALE_DEFAULT));
		lblFotoPlanilla.setIcon(logo22);

		lblAgregarDeduccion = new JLabel("Datos monetarios del empleado :");
		lblAgregarDeduccion.setBounds(34, 280, 253, 26);
		panel_1.add(lblAgregarDeduccion);
		lblAgregarDeduccion.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));

		lblCantidad = new JLabel("Sueldo");
		lblCantidad.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblCantidad.setBounds(34, 317, 63, 14);
		panel_1.add(lblCantidad);

		txtCantidadPlanilla = new JTextField();
		txtCantidadPlanilla.setEditable(false);
		txtCantidadPlanilla.setBounds(152, 317, 116, 20);
		txtCantidadPlanilla.setColumns(10);
		txtCantidadPlanilla.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(txtCantidadPlanilla);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnAceptar.setBackground(Color.WHITE);
		btnAceptar.setBounds(35, 490, 99, 23);
		panel_1.add(btnAceptar);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnNuevo.setBackground(Color.WHITE);
		btnNuevo.setBounds(35, 515, 99, 23);
		panel_1.add(btnNuevo);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnActualizar.setBackground(new Color(60, 179, 113));
		btnActualizar.setBounds(293, 490, 99, 23);
		panel_1.add(btnActualizar);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnGuardar.setBackground(new Color(60, 179, 113));
		btnGuardar.setBounds(293, 515, 99, 23);
		panel_1.add(btnGuardar);

		txtDireccionFoto = new JTextField();
		txtDireccionFoto.setEditable(false);
		txtDireccionFoto.setColumns(10);
		txtDireccionFoto.setBounds(298, 241, 94, 14);
		panel_1.add(txtDireccionFoto);

		btnVer = new JButton("Ver");
		btnVer.setBounds(308, 254, 73, 15);
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
		lblL.setBounds(135, 317, 18, 18);
		panel_1.add(lblL);

		txtCodigo = new JTextField();
		txtCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(364, 257, 28, 20);
		panel_1.add(txtCodigo);
		txtCodigo.setVisible(false);

		dateFechaPlanilla = new JDateChooser();
		dateFechaPlanilla.setBounds(283, 288, 109, 20);
		dateFechaPlanilla.setDateFormatString("dd-MMMMM-yyyy");
		panel_1.add(dateFechaPlanilla);
		editor = (JTextFieldDateEditor) dateFechaPlanilla.getDateEditor();
		editor.setEditable(false);
		editor.setHorizontalAlignment(SwingConstants.CENTER);
		dateFechaPlanilla.setVisible(false);

		JLabel lblBonificaciones = new JLabel("Bonificaciones :");
		lblBonificaciones.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblBonificaciones.setBounds(34, 344, 95, 14);
		panel_1.add(lblBonificaciones);

		JLabel label_11 = new JLabel("L.");
		label_11.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		label_11.setBounds(135, 343, 18, 18);
		panel_1.add(label_11);

		txtTotalBonificacionesPlanilla = new JTextField();
		txtTotalBonificacionesPlanilla.setEditable(false);
		txtTotalBonificacionesPlanilla.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTotalBonificacionesPlanilla.setColumns(10);
		txtTotalBonificacionesPlanilla.setBounds(152, 344, 116, 20);
		panel_1.add(txtTotalBonificacionesPlanilla);

		JLabel lblDeducciones = new JLabel("(Deducciones) :");
		lblDeducciones.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblDeducciones.setBounds(34, 406, 95, 20);
		panel_1.add(lblDeducciones);

		JLabel label_13 = new JLabel("L.");
		label_13.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		label_13.setBounds(135, 408, 18, 18);
		panel_1.add(label_13);

		txtTotalDeduccionesPlanilla = new JTextField();
		txtTotalDeduccionesPlanilla.setEditable(false);
		txtTotalDeduccionesPlanilla.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTotalDeduccionesPlanilla.setColumns(10);
		txtTotalDeduccionesPlanilla.setBounds(152, 408, 116, 20);
		panel_1.add(txtTotalDeduccionesPlanilla);

		lblCargo = new JLabel("Cargo :");
		lblCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblCargo.setBounds(35, 171, 63, 20);
		panel_1.add(lblCargo);

		txtCargoPlanilla = new JTextField();
		txtCargoPlanilla.setHorizontalAlignment(SwingConstants.CENTER);
		txtCargoPlanilla.setEditable(false);
		txtCargoPlanilla.setColumns(10);
		txtCargoPlanilla.setBounds(102, 171, 186, 20);
		panel_1.add(txtCargoPlanilla);

		lblSueldoNeto = new JLabel("Sueldo Neto :");
		lblSueldoNeto.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblSueldoNeto.setBounds(34, 381, 95, 14);
		panel_1.add(lblSueldoNeto);

		txtSueldoNetoPlanilla = new JTextField();
		txtSueldoNetoPlanilla.setEditable(false);
		txtSueldoNetoPlanilla.setHorizontalAlignment(SwingConstants.RIGHT);
		txtSueldoNetoPlanilla.setColumns(10);
		txtSueldoNetoPlanilla.setBounds(152, 381, 116, 20);
		panel_1.add(txtSueldoNetoPlanilla);

		label_12 = new JLabel("L.");
		label_12.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		label_12.setBounds(135, 380, 18, 18);
		panel_1.add(label_12);

		lblTotalAPagar = new JLabel("Total a pagar :");
		lblTotalAPagar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblTotalAPagar.setBounds(34, 459, 95, 14);
		panel_1.add(lblTotalAPagar);

		txtTotalPagoEmpleado = new JTextField();
		txtTotalPagoEmpleado.setEditable(false);
		txtTotalPagoEmpleado.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTotalPagoEmpleado.setColumns(10);
		txtTotalPagoEmpleado.setBounds(152, 459, 116, 20);
		panel_1.add(txtTotalPagoEmpleado);

		label_14 = new JLabel("L.");
		label_14.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		label_14.setBounds(135, 458, 18, 18);
		panel_1.add(label_14);

		label_15 = new JLabel("______________________");
		label_15.setBounds(145, 362, 154, 14);
		panel_1.add(label_15);

		label_16 = new JLabel("______________________");
		label_16.setBounds(146, 428, 154, 20);
		panel_1.add(label_16);

		btnActualizar_Bonificaciones = new JButton("Calcular");
		btnActualizar_Bonificaciones.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (txtCantidadPlanilla.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor busque el empleado para continuar.");
				} else {
					bonificacion clase = new bonificacion();
					consultas_bonificacion consulta = new consultas_bonificacion();
					registro_bonificaciones formulario = new registro_bonificaciones();
					control_bonificacion control = new control_bonificacion(clase, consulta, formulario);
					formulario.setVisible(true);
					formulario.setLocationRelativeTo(null);
					registro_bonificaciones.txtIdentidadEmpleadoBonificacion.requestFocusInWindow();
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
					formulario.btnPlanilla.setVisible(true);
					formulario.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
					formulario.btnAtras.setVisible(false);

					String a = null;
					String b = null;
					a = String.valueOf(txtIdentidadEmpleadoPlanilla.getText());
					b = String.valueOf(txtIdentidadEmpleadoPlanilla.getText());
					registro_bonificaciones.txtBusquedaBonificacion.setText(String.valueOf(a));
					registro_bonificaciones.txtIdentidadEmpleadoBonificacion.setText(String.valueOf(a));
				}

			}
		});
		btnActualizar_Bonificaciones.setBackground(new Color(60, 179, 113));
		btnActualizar_Bonificaciones.setBounds(283, 343, 109, 20);
		panel_1.add(btnActualizar_Bonificaciones);

		btnActualizar_Deducciones = new JButton("Calcular");
		btnActualizar_Deducciones.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (txtCantidadPlanilla.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, busque el empleado para continuar.");
				} else {
					if (txtSueldoNetoPlanilla.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null,
								"Por favor, primero calcule las bonificaciones para continuar.");
					} else {
						deduccion clase = new deduccion();
						consultas_deduccion consulta = new consultas_deduccion();
						registro_deducciones formulario = new registro_deducciones();
						control_deduccion control = new control_deduccion(clase, consulta, formulario);
						formulario.setVisible(true);
						formulario.setLocationRelativeTo(null);
						registro_deducciones.txtIdentidadEmpleadoDeduccion.requestFocusInWindow();
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
						formulario.btnPlanillaDeducciones.setVisible(true);
						formulario.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
						formulario.btnAtras.setVisible(false);

						String a = null;
						String b = null;
						a = String.valueOf(txtIdentidadEmpleadoPlanilla.getText());
						b = String.valueOf(txtIdentidadEmpleadoPlanilla.getText());
						registro_deducciones.txtBusquedaDeduccion.setText(String.valueOf(a));
						registro_deducciones.txtIdentidadEmpleadoDeduccion.setText(String.valueOf(a));
					}
				}
			}
		});
		btnActualizar_Deducciones.setBackground(new Color(60, 179, 113));
		btnActualizar_Deducciones.setBounds(283, 408, 107, 20);
		panel_1.add(btnActualizar_Deducciones);

		lblDetalleDeLa = new JLabel("Detalle de la planilla.");
		lblDetalleDeLa.setHorizontalAlignment(SwingConstants.CENTER);
		lblDetalleDeLa.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		lblDetalleDeLa.setBounds(35, 59, 371, 22);
		panel_1.add(lblDetalleDeLa);

		lblBuscarEmpleadoPor = new JLabel("Ingrese la Identidad :");
		lblBuscarEmpleadoPor.setBounds(35, 82, 168, 27);
		panel_1.add(lblBuscarEmpleadoPor);
		lblBuscarEmpleadoPor.setForeground(new Color(0, 128, 0));
		lblBuscarEmpleadoPor.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtIdentidadEmpleadoPlanilla = new JFormattedTextField(formato);
		txtIdentidadEmpleadoPlanilla.setBounds(168, 86, 132, 20);
		panel_1.add(txtIdentidadEmpleadoPlanilla);
		txtIdentidadEmpleadoPlanilla.setHorizontalAlignment(SwingConstants.CENTER);
		InputMap map42 = txtIdentidadEmpleadoPlanilla.getInputMap(JComponent.WHEN_FOCUSED);
		txtIdentidadEmpleadoPlanilla.setColumns(10);

		btnBuscarIdentidadPlanilla = new JButton("Buscar");
		btnBuscarIdentidadPlanilla.setBounds(310, 85, 82, 23);
		panel_1.add(btnBuscarIdentidadPlanilla);
		btnBuscarIdentidadPlanilla.setBackground(new Color(60, 179, 113));

		JLabel label_7 = new JLabel("");
		label_7.setBounds(0, 0, 424, 575);
		panel_1.add(label_7);
		final ImageIcon logo21 = new ImageIcon(
				icono.getImage().getScaledInstance(label_7.getWidth(), label_7.getHeight(), Image.SCALE_DEFAULT));
		label_7.setIcon(logo21);
		btnBuscarIdentidadPlanilla.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (txtIdentidadEmpleadoPlanilla.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor ingrese la identidad antes buscar");
				} else {
					busquedaDatosEmpleadoPlanilla();
				}
			}
		});
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

		button = new JButton("Regresar");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int resp = JOptionPane.showConfirmDialog(null,
						"Saliendo de planillas!, Antes, debe confirmar si guardo sus cambios.");
				if (JOptionPane.OK_OPTION == resp) {
					ventana_principal principal = new ventana_principal();
					principal.setLocationRelativeTo(null);
					principal.setVisible(true);
					principal.consultarEmpresa();
					login_usuario usuario = new login_usuario();
					usuario.consultarDatosInicioSesionUsuario();
					usuario.establecerDatosInicioSesionUsuario();
					usuario.consultarPermisos();
					usuario.definirPermisos();
					Timer time = new Timer();
					time.schedule(principal.tarea, 0, 1000);
					configuraciones configuracion = new configuraciones();
					configuracion.consultarConfiguracion();
					configuracion.establecerConfiguraciones();
					principal.setTitle("Sesión iniciada por: " + login_usuario.nombreCompletoUsuario);
					dispose();
				}
			}
		});
		button.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		button.setBackground(new Color(255, 127, 80));
		button.setBounds(1213, 11, 102, 23);
		contentPane.add(button);

		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBounds(10, 39, 430, 575);
		contentPane.add(panel_5);

		barraTablaEmpleados = new JScrollPane(tablaEmpleados, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		barraTablaEmpleados.setBounds(28, 107, 376, 397);
		panel_5.add(barraTablaEmpleados);

		btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Dialog", Font.BOLD, 12));
		btnAgregar.setBackground(new Color(0, 139, 139));
		btnAgregar.setBounds(241, 515, 108, 22);
		panel_5.add(btnAgregar);

		JLabel lblEmpleadosRegistrados = new JLabel("Empleados registrados.");
		lblEmpleadosRegistrados.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpleadosRegistrados.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		lblEmpleadosRegistrados.setBounds(28, 58, 371, 22);
		panel_5.add(lblEmpleadosRegistrados);

		JLabel label_1 = new JLabel("Buscar :");
		label_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		label_1.setBounds(28, 78, 136, 17);
		panel_5.add(label_1);

		txtBusquedaEmpleados = new JTextField();
		txtBusquedaEmpleados.setHorizontalAlignment(SwingConstants.CENTER);
		txtBusquedaEmpleados.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtBusquedaEmpleados.setColumns(10);
		txtBusquedaEmpleados.setBounds(87, 78, 317, 18);
		panel_5.add(txtBusquedaEmpleados);
		InputMap map411 = txtBusquedaEmpleados.getInputMap(JComponent.WHEN_FOCUSED);
		map411.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtBusquedaEmpleados.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				trsfiltro2 = new TableRowSorter(tablaEmpleados.getModel());
				tablaEmpleados.setRowSorter(trsfiltro2);
			}

			@Override
			public void keyPressed(KeyEvent ke) {

			}

			@Override
			public void keyReleased(KeyEvent ke) {
				String cadena = (txtBusquedaEmpleados.getText());
				txtBusquedaEmpleados.setText(cadena);
				repaint();
				filtro2();
			}
		});

		JButton btnEmpleados = new JButton("Empleados");
		btnEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				empleado clase = new empleado();
				consultas_empleado consulta = new consultas_empleado();
				usuario clase2 = new usuario();
				consultas_usuario consulta2 = new consultas_usuario();
				registro_empleados formulario = new registro_empleados();
				control_empleado control = new control_empleado(clase, clase2, consulta, consulta2, formulario);
				formulario.setVisible(true);
				formulario.setLocationRelativeTo(null);
				formulario.txtNombresEmpleado.requestFocusInWindow();
				formulario.obtenerUltimoId();
				formulario.consultarEmpresa();
				formulario.establecerFechaRegistro();
				formulario.construirTablaEmpleados();
				formulario.btnNuevoEmpleado.setVisible(true);
				formulario.btnMostrarEmpleado.setVisible(true);
				formulario.btnActualizarDatosEmpleado.setVisible(true);
				formulario.btnActualizarEmpleado.setVisible(false);
				formulario.btnCancelarEmpleado.setVisible(false);
				formulario.btnBorrarEmpleado.setVisible(false);
				formulario.setTitle("Sesión iniciada por: " + login_usuario.nombreCompletoUsuario);
				dispose();
			}
		});
		btnEmpleados.setFont(new Font("Dialog", Font.BOLD, 12));
		btnEmpleados.setBackground(new Color(147, 112, 219));
		btnEmpleados.setBounds(87, 515, 108, 22);
		panel_5.add(btnEmpleados);

		JLabel label_34 = new JLabel("");
		label_34.setBounds(0, 0, 430, 575);
		panel_5.add(label_34);
		final ImageIcon logo212 = new ImageIcon(
				icono.getImage().getScaledInstance(label_34.getWidth(), label_34.getHeight(), Image.SCALE_DEFAULT));
		label_34.setIcon(logo212);
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
		String titulos[] = { "Codigo", "Fecha", "Nombres", "Apellidos", "Identidad", "Cargo", "Sueldo", "Deducciones",
				"Bonificaciones", "Sueldo Neto", "Total", "Planilla" };
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
			tablaPlanilla.getColumnModel().getColumn(10).setCellRenderer(tcr);
			tablaPlanilla.getColumnModel().getColumn(9).setCellRenderer(tcr);
			tablaPlanilla.getColumnModel().getColumn(8).setCellRenderer(tcr);
			tablaPlanilla.getColumnModel().getColumn(7).setCellRenderer(tcr);
			tablaPlanilla.getColumnModel().getColumn(6).setCellRenderer(tcr);
		}
	}

	public void construirTabla2() {
		String titulos[] = { "Codigo", "Fecha", "Nombres", "Apellidos", "Identidad", "Cargo", "Sueldo", "Deducciones",
				"Bonificaciones", "Sueldo Neto", "Total", "Planilla" };
		String informacion[][] = control_planilla.obtenerMatriz2();
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
			tablaPlanilla.getColumnModel().getColumn(10).setCellRenderer(tcr);
			tablaPlanilla.getColumnModel().getColumn(9).setCellRenderer(tcr);
			tablaPlanilla.getColumnModel().getColumn(8).setCellRenderer(tcr);
			tablaPlanilla.getColumnModel().getColumn(7).setCellRenderer(tcr);
			tablaPlanilla.getColumnModel().getColumn(6).setCellRenderer(tcr);
		}
	}

	public void filtro() {
		filtro = txtBusquedaPlanilla.getText();
		trsfiltro.setRowFilter(RowFilter.regexFilter(txtBusquedaPlanilla.getText(), 0, 1, 2, 3, 4));
	}

	public void filtro2() {
		filtro2 = txtBusquedaEmpleados.getText();
		trsfiltro2.setRowFilter(RowFilter.regexFilter(txtBusquedaEmpleados.getText(), 0, 1, 2, 3, 4));
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
			PreparedStatement stmtr = conn.prepareStatement("SELECT * FROM planillas ORDER BY id_planilla DESC");
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
		double t1 = 0;
		double p1 = 0;
		double t2 = 0;
		double p2 = 0;
		double t3 = 0;
		double p3 = 0;
		double t4 = 0;
		double p4 = 0;
		if (tablaPlanilla.getRowCount() > 0) {
			for (int i = 0; i < tablaPlanilla.getRowCount(); i++) {
				p1 = Double.parseDouble(tablaPlanilla.getValueAt(i, 6).toString());
				t1 += p1;
			}
			txtSueldosPlanilla.setText(String.valueOf(t1));

			for (int i = 0; i < tablaPlanilla.getRowCount(); i++) {
				p2 = Double.parseDouble(tablaPlanilla.getValueAt(i, 8).toString());
				t2 += p2;
			}
			txtBonificacionesPlanilla.setText(String.valueOf(t2));

			for (int i = 0; i < tablaPlanilla.getRowCount(); i++) {
				p3 = Double.parseDouble(tablaPlanilla.getValueAt(i, 7).toString());
				t3 += p3;
			}
			txtDeduccionesPlanilla.setText(String.valueOf(t3));

			for (int i = 0; i < tablaPlanilla.getRowCount(); i++) {
				p4 = Double.parseDouble(tablaPlanilla.getValueAt(i, 10).toString());
				t4 += p4;
			}
			txtTotaPlanilla.setText(String.valueOf(t4));

		} else {
			JOptionPane.showMessageDialog(null, "No hay datos que totalizar");
		}
	}

	public void busquedaDatosEmpleadoPlanilla() {
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
		JTable.PrintMode mode = fitWidth ? JTable.PrintMode.FIT_WIDTH : JTable.PrintMode.NORMAL;
		try {
			boolean complete = jTable.print(mode, new MessageFormat(header), new MessageFormat(footer), showPrintDialog,
					null, interactive);
			if (complete) {
				JOptionPane.showMessageDialog(jTable, "Print complete (Impresión completa)",
						"Print result (Resultado de la impresión)", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(jTable, "Print canceled (Impresión cancelada)",
						"Print result (Resultado de la impresión)", JOptionPane.WARNING_MESSAGE);
			}
		} catch (PrinterException pe) {
			JOptionPane.showMessageDialog(jTable, "Print fail (Fallo de impresión): " + pe.getMessage(),
					"Print result (Resultado de la impresión)", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static String getFechaYHora() {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		SimpleDateFormat df = new SimpleDateFormat("dd'/'MMMMM'/'yyyy HH:mm:ss ");
		date = cal.getTime();
		return df.format(date);
	}

	public void obtenerTotalDatosReporte() {
		conexion objCon = new conexion();
		Connection conn = objCon.getConexion();
		try {
			PreparedStatement stmtr = conn.prepareStatement("SELECT * FROM planillas ORDER BY id_planilla DESC");
			ResultSet rsr = stmtr.executeQuery();
			if (rsr.next()) {
				totalDatos = rsr.getString("id_planilla");
			}
			;
			stmtr.close();
			rsr.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void consultarPlanillaActual() {
		conexion conex = new conexion();
		try {
			Statement estatuto = conex.getConexion().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT * FROM historial_planillas ORDER BY id_planilla_final DESC");
			if (rs.next()) {
				idPlanilla = (rs.getString("id_planilla_final"));
				nombrePlanilla = (rs.getString("nombre_planilla_final"));

				registro_planillas.txtCodigoPlanillaNueva.setText(idPlanilla);
				registro_planillas.lblNombrePlanillaNueva.setText(nombrePlanilla);

			} else {
				JOptionPane.showMessageDialog(null, "BIENVENIDO A LAS PLANILLAS\n" + "         Antes de comenzar\n"
						+ "  es necesario crear una nueva planilla.\n" + "  Ingresaremos a:\n" + "  Nuevas Planillas\n"
						+ "   y crearemos una nueva!\n" + "            ******* Buen Dia! *******");
				dispose();
				historial_planilla clase = new historial_planilla();
				consultas_historial_planilla consulta = new consultas_historial_planilla();
				registro_nuevas_planillas formulario = new registro_nuevas_planillas();
				control_historial_planilla control = new control_historial_planilla(clase, consulta, formulario);
				formulario.setVisible(true);
				formulario.setLocationRelativeTo(null);
				formulario.txtNombrePlanilla.requestFocusInWindow();
				formulario.construirTabla();
				formulario.obtenerUltimoId();
				formulario.establecerFechaRegistro();
				formulario.pistas();
				formulario.btnBorrarPlanilla.setVisible(false);
				formulario.btnGuardar.setVisible(true);
				formulario.btnNuevo.setVisible(true);
				formulario.btnActualizar.setVisible(false);
				formulario.btnActualizarDatosPlanilla.setVisible(true);
				formulario.btnVerPlanilla.setVisible(true);
				formulario.btnAceptar.setVisible(false);
				formulario.iniciarEncero();
				Timer time = new Timer();
				time.schedule(formulario.tarea, 0, 1000);
				formulario.setTitle("Sesión iniciada por: " + login_usuario.nombreCompletoUsuario);
			}

			rs.close();
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error al consultar", "Error", JOptionPane.ERROR_MESSAGE);

		}

	}

	public void construirTablaEmpleados() {
		String titulos[] = { "Codigo", "Nombres", "Apellidos", "Identidad", "Genero", "Edad", "Telefono", "Correo",
				"Direccion", "Foto", "Nombre_Referencia", "Telefono_Referencia", "Fecha_Nacimiento", "Fecha_Registro",
				"Fecha_Labores", "Usuario", "Cargo", "Sueldo", "Hora Extra", "Obligaciones", "Horario", "Dias", "Horas",
				"Identidad_Contrato", "Tipo", "Tiempo", "Foto" };
		String informacion[][] = control_empleado.obtenerMatriz();
		tablaEmpleados = new JTable(informacion, titulos);
		barraTablaEmpleados.setViewportView(tablaEmpleados);
		tablaEmpleados.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tablaEmpleados.getTableHeader().setReorderingAllowed(false);

		DefaultTableCellRenderer tcr;
		tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.RIGHT);
		tablaEmpleados.getColumnModel().getColumn(17).setCellRenderer(tcr);
		tablaEmpleados.getColumnModel().getColumn(18).setCellRenderer(tcr);

		for (int c = 0; c < tablaEmpleados.getColumnCount(); c++) {
			Class<?> col_class = tablaEmpleados.getColumnClass(c);
			tablaEmpleados.setDefaultEditor(col_class, null);
		}
	}
}
