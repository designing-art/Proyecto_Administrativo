package formularios;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;
import com.placeholder.PlaceHolder;

import conexion.conexion;
import consultas.consultas_planilla;
import controles.control_historial_planilla;
import controles.control_planilla;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.RowFilter;
import javax.swing.JComboBox;
import javax.swing.JComponent;
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

import clases.historial_planilla;
import clases.planilla;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import javax.swing.border.MatteBorder;
import javax.swing.JToggleButton;

public class registro_nuevas_planillas extends JFrame {

	public JPanel contentPane;
	public JPanel panel_2;
	public JLabel label_8;
	public JTextField txtBusquedaPlanilla;
	public JButton btnAceptar;
	public JButton btnGuardar;
	public JButton btnActualizar;
	public JButton btnBorrar;
	public JButton btnNuevo;
	public JButton btnContinuar;

	public static String nombreEmpresa = null;
	public static String totalDatos = null;

	public PlaceHolder pista;
	public static JTextField txtEstadoPlanilla;
	public JComboBox cbxTipoPlanillaFinal;

	public JButton btnBorrarPlanilla;
	public JButton btnVerPlanilla;
	public JButton btnActualizarDatosPlanilla;
	public JTextFieldDateEditor editor;
	public JTextFieldDateEditor editor2;
	public JTextFieldDateEditor editor3;

	public JDateChooser dateRegistro;

	public JScrollPane barraTablaPlanilla;
	public JTable tablaPlanilla;

	public TableRowSorter trsfiltro;
	String filtro;

	private JLabel label_4;
	private JLabel labelFechaRegistro;
	public JToggleButton btnupanddown;

	public static String ruta;
	public static ImageIcon imagen;

	public JButton btnImprimir;
	public JLabel lblCrearNuevaPlanilla;
	public JLabel lblNewLabel;
	public JTextField txtCodigoPlanilla;
	public JTextField txtNombrePlanilla;
	public JTextField txtTotalSueldos;
	public JTextField txtTotalBonos;
	public JTextField txtTotalDeducciones;
	public JTextField txtTotalPlanilla;
	public JDateChooser datePago;

	public static String bonificaciones = null;
	public static String deducciones = null;
	public JLabel lblPlanillaCanal;
	public JPanel panel_3;
	public JLabel lbl_hora;
	public JPanel panel_4;
	public JLabel label_17;
	public static String hora_fecha_reporte;

	public registro_nuevas_planillas() {
		setResizable(false);
		setDefaultCloseOperation(0);
		setBounds(100, 100, 761, 575);
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
		panel_2.setBounds(316, 36, 430, 496);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblBuscarDeduccion = new JLabel("Buscar :");
		lblBuscarDeduccion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblBuscarDeduccion.setBounds(28, 112, 136, 22);
		panel_2.add(lblBuscarDeduccion);

		txtBusquedaPlanilla = new JTextField();
		txtBusquedaPlanilla.setHorizontalAlignment(SwingConstants.CENTER);
		InputMap map41 = txtBusquedaPlanilla.getInputMap(JComponent.WHEN_FOCUSED);
		map41.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtBusquedaPlanilla.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtBusquedaPlanilla.setColumns(10);
		txtBusquedaPlanilla.setBounds(86, 114, 179, 18);
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

		btnBorrarPlanilla = new JButton("Borrar");
		btnBorrarPlanilla.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnBorrarPlanilla.setBackground(new Color(220, 20, 60));
		btnBorrarPlanilla.setBounds(28, 440, 99, 23);
		panel_2.add(btnBorrarPlanilla);

		btnVerPlanilla = new JButton("Ver detalles");
		btnVerPlanilla.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnVerPlanilla.setBackground(new Color(0, 206, 209));
		btnVerPlanilla.setBounds(147, 440, 108, 23);
		panel_2.add(btnVerPlanilla);

		btnActualizarDatosPlanilla = new JButton("Actualizar Datos");
		btnActualizarDatosPlanilla.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnActualizarDatosPlanilla.setBackground(new Color(60, 179, 113));
		btnActualizarDatosPlanilla.setBounds(265, 441, 137, 23);
		panel_2.add(btnActualizarDatosPlanilla);

		barraTablaPlanilla = new JScrollPane((Component) null, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		barraTablaPlanilla.setBounds(28, 137, 376, 298);
		panel_2.add(barraTablaPlanilla);

		lblPlanillaCanal = new JLabel("Historial Planillas");
		lblPlanillaCanal.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlanillaCanal.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		lblPlanillaCanal.setBounds(28, 50, 227, 22);
		panel_2.add(lblPlanillaCanal);

		panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(283, 79, 116, 22);
		panel_2.add(panel_3);

		lbl_hora = new JLabel();
		lbl_hora.setBounds(0, 0, 116, 22);
		panel_3.add(lbl_hora);
		lbl_hora.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_hora.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		lbl_hora.setBackground(SystemColor.menu);

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

		btnImprimir = new JButton("Imprimir Reporte");
		btnImprimir.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnImprimir.setBackground(new Color(60, 179, 113));
		btnImprimir.setBounds(265, 52, 137, 21);
		panel_2.add(btnImprimir);
		btnImprimir.addActionListener(new ActionListener() {
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

					String encabezado = "Reporte de planillas de " + login_usuario.nombre.toString();

					utilJTablePrint(tablaPlanilla, encabezado, "Pagina {0} de " + i + "          Impreso por: "
							+ login_usuario.nombreCompletoUsuario.toString() + "          " + fecha, true);

				}
			}
		});

		btnContinuar = new JButton("Continuar");
		btnContinuar.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnContinuar.setBackground(new Color(255, 165, 0));
		btnContinuar.setBounds(275, 112, 99, 23);
		panel_2.add(btnContinuar);

		btnupanddown = new JToggleButton("");
		btnupanddown.setBounds(381, 113, 21, 18);
		panel_2.add(btnupanddown);
		final ImageIcon logoq = new ImageIcon(upand.getImage().getScaledInstance(btnupanddown.getWidth(),
				btnupanddown.getHeight(), Image.SCALE_DEFAULT));
		btnupanddown.setIcon(logoq);

		label_8 = new JLabel("");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setBounds(0, 0, 430, 496);
		panel_2.add(label_8);
		final ImageIcon logo = new ImageIcon(
				icono.getImage().getScaledInstance(label_8.getWidth(), label_8.getHeight(), Image.SCALE_DEFAULT));
		label_8.setIcon(logo);

		JLabel lblRegistroYMantenimiento = new JLabel("REGISTRO Y MANTENIMIENTO DE HISTORIAL DE PLANILLAS");
		lblRegistroYMantenimiento.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblRegistroYMantenimiento.setBounds(10, 2, 698, 40);
		contentPane.add(lblRegistroYMantenimiento);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 36, 286, 496);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		lblCrearNuevaPlanilla = new JLabel("Informaci\u00F3n de la planilla.");
		lblCrearNuevaPlanilla.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrearNuevaPlanilla.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		lblCrearNuevaPlanilla.setBounds(22, 41, 221, 22);
		panel_1.add(lblCrearNuevaPlanilla);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		panel.setBounds(22, 74, 242, 338);
		panel_1.add(panel);
		panel.setLayout(null);

		lblNewLabel = new JLabel("C\u00F3digo :");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 11, 63, 20);
		panel.add(lblNewLabel);

		txtCodigoPlanilla = new JTextField();
		txtCodigoPlanilla.setEditable(false);
		txtCodigoPlanilla.setBounds(81, 12, 46, 20);
		panel.add(txtCodigoPlanilla);
		txtCodigoPlanilla.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblNombre.setBounds(10, 35, 74, 20);
		panel.add(lblNombre);

		txtNombrePlanilla = new JTextField();
		txtNombrePlanilla.setColumns(10);
		txtNombrePlanilla.setBounds(81, 35, 148, 20);
		panel.add(txtNombrePlanilla);
		InputMap map5 = txtNombrePlanilla.getInputMap(JComponent.WHEN_FOCUSED);
		map5.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtNombrePlanilla.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombrePlanilla.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				if (txtNombrePlanilla.getText().length() == 45)
					ke.consume();
			}

			@Override
			public void keyPressed(KeyEvent ke) {
			}

			@Override
			public void keyReleased(KeyEvent ke) {
				try {
					conexion conex = new conexion();
					Statement estatuto = conex.getConexion().createStatement();
					ResultSet rs = estatuto
							.executeQuery("SELECT nombre_planilla FROM planillas where nombre_planilla = '"
									+ txtNombrePlanilla.getText().toString() + "'");
					if (rs.next() == true) {
						JOptionPane.showMessageDialog(null, "Este nombre de planilla ya existe");
						txtNombrePlanilla.setText("");
					} else {
						rs.close();
						estatuto.close();
						conex.desconectar();

					}

				} catch (SQLException exx) {
					System.out.println(exx.getMessage());
					JOptionPane.showMessageDialog(null, "Error al consultar", "Error", JOptionPane.ERROR_MESSAGE);

				}

			}
		});

		JLabel lblFechaDePago = new JLabel("Fecha de pago :");
		lblFechaDePago.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblFechaDePago.setBounds(10, 87, 119, 20);
		panel.add(lblFechaDePago);

		datePago = new JDateChooser();
		datePago.setBounds(113, 87, 116, 20);
		panel.add(datePago);
		editor = (JTextFieldDateEditor) datePago.getDateEditor();
		editor.setEditable(false);
		editor.setHorizontalAlignment(SwingConstants.CENTER);
		datePago.setMinSelectableDate(new Date());

		txtEstadoPlanilla = new JTextField();
		txtEstadoPlanilla.setHorizontalAlignment(SwingConstants.CENTER);
		txtEstadoPlanilla.setText("Abierta");
		txtEstadoPlanilla.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtEstadoPlanilla.setBounds(150, 11, 79, 20);
		panel.add(txtEstadoPlanilla);
		txtEstadoPlanilla.setEditable(false);
		txtEstadoPlanilla.setBackground(new Color(60, 179, 113));

		JLabel lblTotalSueldosPlanilla = new JLabel("Total Sueldos Planilla");
		lblTotalSueldosPlanilla.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblTotalSueldosPlanilla.setBounds(10, 140, 139, 14);
		panel.add(lblTotalSueldosPlanilla);

		JLabel label_1 = new JLabel("L.");
		label_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		label_1.setBounds(10, 160, 18, 18);
		panel.add(label_1);

		txtTotalSueldos = new JTextField();
		txtTotalSueldos.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTotalSueldos.setEditable(false);
		txtTotalSueldos.setColumns(10);
		txtTotalSueldos.setBounds(27, 160, 148, 20);
		panel.add(txtTotalSueldos);

		JLabel label_3 = new JLabel("L.");
		label_3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		label_3.setBounds(10, 212, 18, 18);
		panel.add(label_3);

		txtTotalBonos = new JTextField();
		txtTotalBonos.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTotalBonos.setEditable(false);
		txtTotalBonos.setColumns(10);
		txtTotalBonos.setBounds(27, 211, 148, 20);
		panel.add(txtTotalBonos);

		JLabel label_5 = new JLabel("L.");
		label_5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		label_5.setBounds(10, 266, 18, 18);
		panel.add(label_5);

		txtTotalDeducciones = new JTextField();
		txtTotalDeducciones.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTotalDeducciones.setEditable(false);
		txtTotalDeducciones.setColumns(10);
		txtTotalDeducciones.setBounds(27, 264, 148, 20);
		panel.add(txtTotalDeducciones);

		JLabel lblTotalBonificacionesPlanilla = new JLabel("Total Bonificaciones Planilla");
		lblTotalBonificacionesPlanilla.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblTotalBonificacionesPlanilla.setBounds(10, 189, 195, 14);
		panel.add(lblTotalBonificacionesPlanilla);

		JLabel lblTotalDeduccionesPlanilla = new JLabel("Total Deducciones Planilla");
		lblTotalDeduccionesPlanilla.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblTotalDeduccionesPlanilla.setBounds(10, 241, 181, 14);
		panel.add(lblTotalDeduccionesPlanilla);

		JLabel lblTotalPlanilla = new JLabel("Total Planilla : ");
		lblTotalPlanilla.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblTotalPlanilla.setBounds(10, 287, 100, 20);
		panel.add(lblTotalPlanilla);

		txtTotalPlanilla = new JTextField();
		txtTotalPlanilla.setEditable(false);
		txtTotalPlanilla.setColumns(10);
		txtTotalPlanilla.setBounds(27, 310, 148, 20);
		panel.add(txtTotalPlanilla);
		txtTotalPlanilla.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblTipoDePlanilla = new JLabel("Tipo de planilla :");
		lblTipoDePlanilla.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblTipoDePlanilla.setBounds(10, 112, 117, 20);
		panel.add(lblTipoDePlanilla);

		cbxTipoPlanillaFinal = new JComboBox();
		cbxTipoPlanillaFinal.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		cbxTipoPlanillaFinal.setModel(new DefaultComboBoxModel(new String[] { "Mensual", "Quincenal", "Eventual" }));
		cbxTipoPlanillaFinal.setBounds(113, 112, 116, 20);
		panel.add(cbxTipoPlanillaFinal);

		JLabel label_2 = new JLabel("Creacion :");
		label_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		label_2.setBounds(10, 61, 74, 20);
		panel.add(label_2);

		dateRegistro = new JDateChooser();
		dateRegistro.setBounds(113, 61, 116, 20);
		panel.add(dateRegistro);
		dateRegistro.setVisible(false);

		label_4 = new JLabel("L.");
		label_4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		label_4.setBounds(10, 312, 18, 18);
		panel.add(label_4);

		labelFechaRegistro = new JLabel("");
		labelFechaRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		labelFechaRegistro.setBounds(81, 61, 148, 18);
		panel.add(labelFechaRegistro);
		labelFechaRegistro.setText(getFecha());
		editor2 = (JTextFieldDateEditor) dateRegistro.getDateEditor();
		editor2.setEditable(false);
		editor2.setHorizontalAlignment(SwingConstants.CENTER);
		editor2.setForeground(Color.BLACK);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnAceptar.setBackground(Color.WHITE);
		btnAceptar.setBounds(22, 415, 99, 23);
		panel_1.add(btnAceptar);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnNuevo.setBackground(Color.WHITE);
		btnNuevo.setBounds(22, 440, 99, 23);
		panel_1.add(btnNuevo);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnActualizar.setBackground(new Color(60, 179, 113));
		btnActualizar.setBounds(162, 415, 99, 23);
		panel_1.add(btnActualizar);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnGuardar.setBackground(new Color(60, 179, 113));
		btnGuardar.setBounds(162, 440, 99, 23);
		panel_1.add(btnGuardar);

		JLabel label_7 = new JLabel("");
		label_7.setBounds(0, 0, 286, 496);
		panel_1.add(label_7);
		final ImageIcon logo21 = new ImageIcon(
				icono.getImage().getScaledInstance(label_7.getWidth(), label_7.getHeight(), Image.SCALE_DEFAULT));
		label_7.setIcon(logo21);

		JButton button = new JButton("Regresar");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				planilla clase = new planilla();
				historial_planilla clase2 = new historial_planilla();
				consultas_planilla consulta = new consultas_planilla();
				registro_planillas formulario = new registro_planillas();
				control_planilla control = new control_planilla(clase, clase2, consulta, formulario);
				formulario.setVisible(true);
				formulario.setLocationRelativeTo(null);
				registro_planillas.txtIdentidadEmpleadoPlanilla.requestFocusInWindow();
				formulario.btnBorrarPlanilla.setVisible(false);
				formulario.btnGuardar.setVisible(true);
				formulario.btnNuevo.setVisible(true);
				formulario.btnActualizar.setVisible(false);
				formulario.btnActualizarDatosPlanilla.setVisible(true);
				formulario.btnVerPlanilla.setVisible(true);
				formulario.btnAceptar.setVisible(false);
				formulario.consultarPlanillaActual();
				formulario.construirTabla();
				formulario.construirTablaEmpleados();
				formulario.obtenerUltimoId();
				formulario.establecerFechaRegistro();
				formulario.pistas();
				Timer time = new Timer();
				time.schedule(formulario.tarea, 0, 1000);
				formulario.setTitle("Sesi�n iniciada por: " + login_usuario.nombreCompletoUsuario);
				dispose();
			}
		});
		button.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		button.setBackground(new Color(255, 127, 80));
		button.setBounds(644, 13, 102, 23);
		contentPane.add(button);
	}

	public void establecerFechaRegistro() {
		try {
			LocalDate fechaActual = LocalDate.now();
			Date date = Date.from(fechaActual.atStartOfDay(ZoneId.systemDefault()).toInstant());
			dateRegistro.setDate(date);
		} catch (Exception e) {

		}

	}

	public void construirTabla() {
		String titulos[] = { "C�digo", "Estado", "Tipo", "Nombre", "Fecha de creaci�n", "Fecha de pago", "Deducciones",
				"Bonificaciones", "Sueldos", "Total Planilla" };
		String informacion[][] = control_historial_planilla.obtenerMatriz();
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
			tablaPlanilla.getColumnModel().getColumn(6).setCellRenderer(tcr);
			tablaPlanilla.getColumnModel().getColumn(7).setCellRenderer(tcr);
			tablaPlanilla.getColumnModel().getColumn(8).setCellRenderer(tcr);
			tablaPlanilla.getColumnModel().getColumn(9).setCellRenderer(tcr);
		}
	}

	public void construirTabla2() {
		String titulos[] = { "C�digo", "Estado", "Tipo", "Nombre", "Fecha de creaci�n", "Fecha de pago", "Deducciones",
				"Bonificaciones", "Sueldos", "Total Planilla" };
		String informacion[][] = control_historial_planilla.obtenerMatriz2();
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
			tablaPlanilla.getColumnModel().getColumn(6).setCellRenderer(tcr);
			tablaPlanilla.getColumnModel().getColumn(7).setCellRenderer(tcr);
			tablaPlanilla.getColumnModel().getColumn(8).setCellRenderer(tcr);
			tablaPlanilla.getColumnModel().getColumn(9).setCellRenderer(tcr);
		}
	}

	public void filtro() {
		filtro = txtBusquedaPlanilla.getText();
		trsfiltro.setRowFilter(RowFilter.regexFilter(txtBusquedaPlanilla.getText(), 0, 1, 2, 3, 4));
	}

	public void pistas() {
		pista = new PlaceHolder(txtBusquedaPlanilla, "Escriba para buscar.");
		pista = new PlaceHolder(txtNombrePlanilla, "Escriba el nombre de la planilla.");
	}

	public void obtenerUltimoId() {
		String ultimoValor = null;
		int valor;
		String id = null;
		conexion objCon = new conexion();
		Connection conn = objCon.getConexion();
		try {
			PreparedStatement stmtr = conn
					.prepareStatement("SELECT * FROM historial_planillas ORDER BY id_planilla_final DESC");
			ResultSet rsr = stmtr.executeQuery();
			if (rsr.next()) {
				ultimoValor = rsr.getString("id_planilla_final");
				valor = Integer.parseInt(ultimoValor);
				valor = valor + 1;
				id = String.valueOf(valor);
			}
			txtCodigoPlanilla.setText(id);
			;
			stmtr.close();
			rsr.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
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

	public void utilJTablePrint(JTable jTable, String header, String footer, boolean showPrintDialog) {
		boolean fitWidth = true;
		boolean interactive = true;
		JTable.PrintMode mode = fitWidth ? JTable.PrintMode.FIT_WIDTH : JTable.PrintMode.NORMAL;
		try {
			boolean complete = jTable.print(mode, new MessageFormat(header), new MessageFormat(footer), showPrintDialog,
					null, interactive);
			if (complete) {
				JOptionPane.showMessageDialog(jTable, "Print complete (Impresi�n completa)",
						"Print result (Resultado de la impresi�n)", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(jTable, "Print canceled (Impresi�n cancelada)",
						"Print result (Resultado de la impresi�n)", JOptionPane.WARNING_MESSAGE);
			}
		} catch (PrinterException pe) {
			JOptionPane.showMessageDialog(jTable, "Print fail (Fallo de impresi�n): " + pe.getMessage(),
					"Print result (Resultado de la impresi�n)", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void iniciarEncero() {
		double cero = 0.0;
		String numero = String.valueOf(cero);
		txtTotalSueldos.setText(numero);
		txtTotalDeducciones.setText(numero);
		txtTotalBonos.setText(numero);
		txtTotalPlanilla.setText(numero);
	}

	public static String getFecha() {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		SimpleDateFormat df = new SimpleDateFormat("EEEEEEEEE dd'-'MMMMM'-'yyyy");
		date = cal.getTime();
		return df.format(date);
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
			PreparedStatement stmtr = conn
					.prepareStatement("SELECT * FROM historial_planillas ORDER BY id_planilla_final DESC");
			ResultSet rsr = stmtr.executeQuery();
			if (rsr.next()) {
				totalDatos = rsr.getString("id_planilla_final");
			}
			;
			stmtr.close();
			rsr.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
