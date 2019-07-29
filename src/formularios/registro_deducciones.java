package formularios;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;
import javax.swing.text.MaskFormatter;

import com.placeholder.PlaceHolder;

import clases.empleado;
import conexion.conexion;
import consultas.consultas_deduccion;
import controles.control_deduccion;
import utilidades.visor_imagen;

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
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Event;

import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

public class registro_deducciones extends JFrame {

	public JPanel contentPane;
	public JTextField txtApellidosDeduccion;
	public JTextField txtNombresDeduccion;
	public JTextField txtCodigoDeduccion;
	public JLabel label_2;
	public JLabel label_3;
	public JLabel label_4;
	public JLabel label_5;
	public JTextField txtIdentidadDeduccion;
	public JLabel lblBuscarEmpleadoPor;
	public JButton btnSinDeduc;

	public static String nombreEmpresa = null;
	public static String totalDatos = null;
	public static JFormattedTextField txtIdentidadEmpleadoDeduccion;
	public JPanel panel;
	public JLabel label_6;
	public JLabel lblTipo;
	public JLabel lblCantidad;
	public JTextField txtCantidadDeduccion;
	public JLabel lblObservacion;
	public JLabel lblAgregarDeduccion;
	public JPanel panel_2;
	public JLabel label_8;
	public static JTextField txtBusquedaDeduccion;
	public JTextField txtTotalDeducciones;
	public JLabel lblFotoDeduccion;
	public JButton btnAtras;
	public PlaceHolder pista;
	public JDateChooser dateFechaDeduccion;
	public static String hora_fecha_reporte;

	public static String ruta_logo;
	public static JLabel label_22;

	public JButton btnBorrarDeduccion;
	public JButton btnVerDeduccion;
	public JButton btnActualizarDatosDeduccion;

	public JScrollPane scrollPane_1;
	public JTextArea txtObservacionDeduccion;
	public JButton btnAceptar;
	public JButton btnNuevo;
	public JButton btnActualizar;
	public JButton btnGuardar;
	public JLabel lblTotalDeducciones;
	public JButton btnBuscarIdentidadDeduccion;
	public JTextFieldDateEditor editor;

	public JScrollPane barraTablaDeduccion;
	public JTable tablaDeducciones;

	public TableRowSorter trsfiltro;
	String filtro;

	public static String ruta;
	public static ImageIcon imagen;

	public JComboBox<?> cbxTipoDeduccion;
	public JTextField txtDireccionFoto;
	public JButton btnVer;
	public JLabel lblL;
	public JLabel label;
	public JTextField txtCodigo;
	private JLabel lblFecha;
	public JButton btnPlanillaDeducciones;
	private JButton button;

	public registro_deducciones() {
		setResizable(false);
		setDefaultCloseOperation(0);
		setBounds(100, 100, 900, 550);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/iconos/icono_d_a.jpg")));
		final ImageIcon icono = new ImageIcon(getClass().getResource("/iconos/libreta.png"));
		final ImageIcon usuario = new ImageIcon(getClass().getResource("/iconos/usuario.png"));

		panel_2 = new JPanel();
		panel_2.setBounds(444, 46, 430, 467);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblBuscarDeduccion = new JLabel("Buscar deduccion :");
		lblBuscarDeduccion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblBuscarDeduccion.setBounds(28, 63, 136, 22);
		panel_2.add(lblBuscarDeduccion);

		txtBusquedaDeduccion = new JTextField();
		txtBusquedaDeduccion.setHorizontalAlignment(SwingConstants.CENTER);
		InputMap map41 = txtBusquedaDeduccion.getInputMap(JComponent.WHEN_FOCUSED);
		map41.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtBusquedaDeduccion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtBusquedaDeduccion.setColumns(10);
		txtBusquedaDeduccion.setBounds(157, 64, 186, 21);
		panel_2.add(txtBusquedaDeduccion);
		txtBusquedaDeduccion.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				trsfiltro = new TableRowSorter(tablaDeducciones.getModel());
				tablaDeducciones.setRowSorter(trsfiltro);
			}

			@Override
			public void keyPressed(KeyEvent ke) {

			}

			@Override
			public void keyReleased(KeyEvent ke) {
				String cadena = (txtBusquedaDeduccion.getText());
				txtBusquedaDeduccion.setText(cadena);
				repaint();
				filtro();
			}
		});

		label_22 = new JLabel();
		label_22.setBounds(353, 41, 49, 44);
		panel_2.add(label_22);

		JLabel lblDeduccionesRegistradas = new JLabel("Deducciones registradas");
		lblDeduccionesRegistradas.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblDeduccionesRegistradas.setBounds(28, 41, 227, 19);
		panel_2.add(lblDeduccionesRegistradas);

		btnBorrarDeduccion = new JButton("Borrar");
		btnBorrarDeduccion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnBorrarDeduccion.setBackground(new Color(220, 20, 60));
		btnBorrarDeduccion.setBounds(28, 401, 99, 23);
		panel_2.add(btnBorrarDeduccion);

		btnVerDeduccion = new JButton("Ver detalles");
		btnVerDeduccion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnVerDeduccion.setBackground(new Color(0, 206, 209));
		btnVerDeduccion.setBounds(147, 401, 108, 23);
		panel_2.add(btnVerDeduccion);

		btnActualizarDatosDeduccion = new JButton("Actualizar Datos");
		btnActualizarDatosDeduccion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnActualizarDatosDeduccion.setBackground(new Color(60, 179, 113));
		btnActualizarDatosDeduccion.setBounds(265, 402, 137, 23);
		panel_2.add(btnActualizarDatosDeduccion);

		barraTablaDeduccion = new JScrollPane((Component) null, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		barraTablaDeduccion.setBounds(26, 95, 376, 239);
		panel_2.add(barraTablaDeduccion);

		lblTotalDeducciones = new JLabel("Total deducciones :");
		lblTotalDeducciones.setBounds(28, 347, 150, 14);
		panel_2.add(lblTotalDeducciones);
		lblTotalDeducciones.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));

		txtTotalDeducciones = new JTextField();
		txtTotalDeducciones.setBounds(184, 345, 108, 20);
		panel_2.add(txtTotalDeducciones);
		txtTotalDeducciones.setEditable(false);
		txtTotalDeducciones.setColumns(10);
		txtTotalDeducciones.setHorizontalAlignment(SwingConstants.RIGHT);

		JButton btnCalcularDeducciones = new JButton("Calcular");
		btnCalcularDeducciones.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				totalizar();
			}
		});
		btnCalcularDeducciones.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 10));
		btnCalcularDeducciones.setBounds(303, 345, 99, 21);
		panel_2.add(btnCalcularDeducciones);
		btnCalcularDeducciones.setBackground(new Color(60, 179, 113));

		label = new JLabel("L.");
		label.setBounds(168, 345, 28, 18);
		panel_2.add(label);
		label.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));

		btnPlanillaDeducciones = new JButton("Planilla");
		btnPlanillaDeducciones.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (txtTotalDeducciones.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "No hay deducciones para este empleado.");
				} else {
					registro_planillas.txtTotalDeduccionesPlanilla.setText(txtTotalDeducciones.getText());
					double a = 0;
					double b = 0;
					double c = 0;
					a = Double.valueOf(registro_planillas.txtSueldoNetoPlanilla.getText());
					b = Double.valueOf(registro_planillas.txtTotalDeduccionesPlanilla.getText());
					c = a - b;
					registro_planillas.txtTotalPagoEmpleado.setText(String.valueOf(c));
					JOptionPane.showMessageDialog(null, "Deducciones agregadas a la planilla.");
					dispose();

				}
			}
		});
		btnPlanillaDeducciones.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 10));
		btnPlanillaDeducciones.setBackground(Color.YELLOW);
		btnPlanillaDeducciones.setBounds(303, 371, 99, 23);
		btnPlanillaDeducciones.setVisible(false);
		panel_2.add(btnPlanillaDeducciones);

		button = new JButton("Imprimir Reporte");
		button.addActionListener(new ActionListener() {
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

					String encabezado = "Reporte de deducciones de " + login_usuario.nombre.toString();

					utilJTablePrint(tablaDeducciones, encabezado,
							"Pagina {0} de " + i + "                                  " + fecha, true);
				}
			}
		});
		button.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		button.setBackground(new Color(60, 179, 113));
		button.setBounds(206, 41, 137, 19);
		panel_2.add(button);
		
		btnSinDeduc = new JButton("Sin Deducciones");
		btnSinDeduc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					JOptionPane.showMessageDialog(null, "Sin Deducciones.");
					registro_planillas.txtTotalDeduccionesPlanilla.setText("0");
					double a = 0;
					double b = 0;
					double c = 0;
					a = Double.valueOf(registro_planillas.txtSueldoNetoPlanilla.getText());
					b = Double.valueOf(registro_planillas.txtTotalDeduccionesPlanilla.getText());
					c = a - b;
					registro_planillas.txtTotalPagoEmpleado.setText(String.valueOf(c));
					dispose();
			}
		});
		btnSinDeduc.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSinDeduc.setBounds(147, 371, 150, 23);
		panel_2.add(btnSinDeduc);
		
				label_8 = new JLabel("");
				label_8.setBounds(0, 0, 430, 456);
				panel_2.add(label_8);
				final ImageIcon logo = new ImageIcon(
						icono.getImage().getScaledInstance(label_8.getWidth(), label_8.getHeight(), Image.SCALE_DEFAULT));
				label_8.setIcon(logo);

		JLabel lblRegistroYMantenimiento = new JLabel("REGISTRO Y MANTENIMIENTO DE DEDUCCIONES");
		lblRegistroYMantenimiento.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblRegistroYMantenimiento.setBounds(10, 1, 551, 39);
		contentPane.add(lblRegistroYMantenimiento);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 46, 424, 454);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblRegistrarDeducciones = new JLabel("Registrar Deduccion.");
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
		txtIdentidadEmpleadoDeduccion = new JFormattedTextField(formato);
		txtIdentidadEmpleadoDeduccion.setBounds(168, 71, 132, 20);
		txtIdentidadEmpleadoDeduccion.setHorizontalAlignment(SwingConstants.CENTER);
		InputMap map42 = txtIdentidadEmpleadoDeduccion.getInputMap(JComponent.WHEN_FOCUSED);
		map42.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		panel_1.add(txtIdentidadEmpleadoDeduccion);
		txtIdentidadEmpleadoDeduccion.setColumns(10);
		txtIdentidadEmpleadoDeduccion.addKeyListener(new KeyListener() {
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
		lblDatosDelEmpleado.setBounds(35, 98, 168, 14);
		panel_1.add(lblDatosDelEmpleado);
		lblDatosDelEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));

		label_4 = new JLabel("Codigo :");
		label_4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		label_4.setBounds(35, 126, 63, 14);
		panel_1.add(label_4);

		txtCodigoDeduccion = new JTextField();
		txtCodigoDeduccion.setBounds(102, 123, 28, 20);
		panel_1.add(txtCodigoDeduccion);
		txtCodigoDeduccion.setEditable(false);
		txtCodigoDeduccion.setColumns(10);
		txtCodigoDeduccion.setHorizontalAlignment(SwingConstants.CENTER);

		label_2 = new JLabel("Nombres :");
		label_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		label_2.setBounds(35, 152, 63, 14);
		panel_1.add(label_2);

		txtNombresDeduccion = new JTextField();
		txtNombresDeduccion.setEditable(false);
		txtNombresDeduccion.setBounds(102, 149, 186, 20);
		panel_1.add(txtNombresDeduccion);
		txtNombresDeduccion.setColumns(10);
		txtNombresDeduccion.setHorizontalAlignment(SwingConstants.CENTER);

		label_3 = new JLabel("Apellidos :");
		label_3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		label_3.setBounds(35, 177, 63, 14);
		panel_1.add(label_3);

		txtApellidosDeduccion = new JTextField();
		txtApellidosDeduccion.setEditable(false);
		txtApellidosDeduccion.setBounds(102, 174, 186, 20);
		panel_1.add(txtApellidosDeduccion);
		txtApellidosDeduccion.setColumns(10);
		txtApellidosDeduccion.setHorizontalAlignment(SwingConstants.CENTER);

		label_5 = new JLabel("Identidad :");
		label_5.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		label_5.setBounds(35, 205, 63, 14);
		panel_1.add(label_5);

		txtIdentidadDeduccion = new JTextField();
		txtIdentidadDeduccion.setEditable(false);
		txtIdentidadDeduccion.setBounds(102, 199, 186, 20);
		panel_1.add(txtIdentidadDeduccion);
		txtIdentidadDeduccion.setColumns(10);
		txtIdentidadDeduccion.setHorizontalAlignment(SwingConstants.CENTER);

		label_6 = new JLabel("Fotografia :");
		label_6.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		label_6.setBounds(225, 118, 82, 14);
		panel_1.add(label_6);

		panel = new JPanel();
		panel.setBounds(298, 113, 94, 87);
		panel_1.add(panel);
		panel.setLayout(null);

		lblFotoDeduccion = new JLabel();
		lblFotoDeduccion.setBounds(0, 0, 94, 87);
		panel.add(lblFotoDeduccion);
		final ImageIcon logo22 = new ImageIcon(usuario.getImage().getScaledInstance(lblFotoDeduccion.getWidth(),
				lblFotoDeduccion.getHeight(), Image.SCALE_DEFAULT));
		lblFotoDeduccion.setIcon(logo22);

		lblAgregarDeduccion = new JLabel("Agregar deduccion :");
		lblAgregarDeduccion.setBounds(35, 230, 168, 14);
		panel_1.add(lblAgregarDeduccion);
		lblAgregarDeduccion.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));

		lblTipo = new JLabel("Tipo :");
		lblTipo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblTipo.setBounds(35, 257, 63, 14);
		panel_1.add(lblTipo);

		cbxTipoDeduccion = new JComboBox();
		cbxTipoDeduccion.setModel(
				new DefaultComboBoxModel(new String[] { "Prestamo", "Embargo", "Adelanto", "Da\u00F1os al inventario",
						"Seguro Social", "Cooperativa", "Prestamo Bancario", "Plan telefonico", "Otra deduccion." }));
		cbxTipoDeduccion.setBounds(137, 255, 132, 20);
		panel_1.add(cbxTipoDeduccion);

		lblCantidad = new JLabel("Cantidad :");
		lblCantidad.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblCantidad.setBounds(35, 282, 63, 14);
		panel_1.add(lblCantidad);

		txtCantidadDeduccion = new JTextField();
		txtCantidadDeduccion.setBounds(137, 280, 132, 20);
		panel_1.add(txtCantidadDeduccion);
		txtCantidadDeduccion.setColumns(10);
		txtCantidadDeduccion.setHorizontalAlignment(SwingConstants.RIGHT);
		InputMap map44 = txtCantidadDeduccion.getInputMap(JComponent.WHEN_FOCUSED);
		map44.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtCantidadDeduccion.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();
				if ((c < '0' || c > '9'))
					ke.consume();
				if (txtCantidadDeduccion.getText().length() == 8)
					ke.consume();
			}

			@Override
			public void keyPressed(KeyEvent ke) {
			}

			@Override
			public void keyReleased(KeyEvent ke) {
			}
		});

		lblObservacion = new JLabel("Observacion :");
		lblObservacion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblObservacion.setBounds(35, 307, 109, 34);
		panel_1.add(lblObservacion);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(137, 307, 255, 34);
		panel_1.add(scrollPane_1);

		txtObservacionDeduccion = new JTextArea();
		InputMap map45 = txtObservacionDeduccion.getInputMap(JComponent.WHEN_FOCUSED);
		map45.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		scrollPane_1.setViewportView(txtObservacionDeduccion);
		txtObservacionDeduccion.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				if (txtObservacionDeduccion.getText().length() == 100) {
					ke.consume();
				}
					
			}

			@Override
			public void keyPressed(KeyEvent ke) {
			}

			@Override
			public void keyReleased(KeyEvent ke) {
				char c = ke.getKeyChar();
				if (ke.getKeyChar() == '\n' || ke.getKeyChar() == '\t') {
		            String str = txtObservacionDeduccion.getText().trim();
		            txtObservacionDeduccion.setText(str);
		        }
			}
		});

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnAceptar.setBackground(Color.WHITE);
		btnAceptar.setBounds(35, 374, 99, 23);
		panel_1.add(btnAceptar);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnNuevo.setBackground(Color.WHITE);
		btnNuevo.setBounds(35, 399, 99, 23);
		panel_1.add(btnNuevo);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnActualizar.setBackground(new Color(60, 179, 113));
		btnActualizar.setBounds(293, 374, 99, 23);
		panel_1.add(btnActualizar);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnGuardar.setBackground(new Color(60, 179, 113));
		btnGuardar.setBounds(293, 399, 99, 23);
		panel_1.add(btnGuardar);

		btnBuscarIdentidadDeduccion = new JButton("Buscar");
		btnBuscarIdentidadDeduccion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (txtIdentidadEmpleadoDeduccion.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor ingrese la identidad antes buscar");
				} else {
					busquedaDatosEmpleado();
				}

			}
		});
		btnBuscarIdentidadDeduccion.setBackground(new Color(60, 179, 113));
		btnBuscarIdentidadDeduccion.setBounds(310, 70, 82, 23);
		panel_1.add(btnBuscarIdentidadDeduccion);

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
		lblL.setBounds(116, 280, 28, 18);
		panel_1.add(lblL);

		JLabel label_1 = new JLabel("Codigo :");
		label_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		label_1.setBounds(305, 257, 63, 14);
		panel_1.add(label_1);

		txtCodigo = new JTextField();
		txtCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(364, 255, 28, 20);
		panel_1.add(txtCodigo);

		lblFecha = new JLabel("Fecha :");
		lblFecha.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblFecha.setBounds(35, 348, 109, 20);
		panel_1.add(lblFecha);
		lblFecha.setVisible(false);

		dateFechaDeduccion = new JDateChooser();
		dateFechaDeduccion.setBounds(137, 348, 132, 20);
		dateFechaDeduccion.setDateFormatString("dd-MMMMM-yyyy");
		panel_1.add(dateFechaDeduccion);
		editor = (JTextFieldDateEditor) dateFechaDeduccion.getDateEditor();
		editor.setEditable(false);
		editor.setHorizontalAlignment(SwingConstants.CENTER);
		dateFechaDeduccion.setVisible(false);

		JLabel label_7 = new JLabel("");
		label_7.setBounds(0, 0, 424, 454);
		panel_1.add(label_7);
		final ImageIcon logo21 = new ImageIcon(
				icono.getImage().getScaledInstance(label_7.getWidth(), label_7.getHeight(), Image.SCALE_DEFAULT));
		label_7.setIcon(logo21);

		btnAtras = new JButton("Regresar");
		btnAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
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
				principal.setTitle("Sesión iniciada por: "+login_usuario.nombreCompletoUsuario);
				
				dispose();
			}
		});
		btnAtras.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnAtras.setBackground(new Color(255, 127, 80));
		btnAtras.setBounds(772, 12, 102, 23);
		contentPane.add(btnAtras);
	}

	public void establecerFechaRegistro() {
		try {
			LocalDate fechaActual = LocalDate.now();
			Date date = Date.from(fechaActual.atStartOfDay(ZoneId.systemDefault()).toInstant());
			dateFechaDeduccion.setDate(date);
		} catch (Exception e) {

		}

	}

	public void construirTabla() {
		String titulos[] = { "Codigo", "Tipo", "Observacion", "Identidad", "Cantidad", "Fecha" };
		String informacion[][] = control_deduccion.obtenerMatriz();
		tablaDeducciones = new JTable(informacion, titulos);
		barraTablaDeduccion.setViewportView(tablaDeducciones);
		for (int c = 0; c < tablaDeducciones.getColumnCount(); c++) {
			Class<?> col_class = tablaDeducciones.getColumnClass(c);
			tablaDeducciones.setDefaultEditor(col_class, null);
			tablaDeducciones.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			tablaDeducciones.getTableHeader().setReorderingAllowed(false);

			DefaultTableCellRenderer tcr;
			tcr = new DefaultTableCellRenderer();
			tcr.setHorizontalAlignment(SwingConstants.RIGHT);
			tablaDeducciones.getColumnModel().getColumn(4).setCellRenderer(tcr);
		}
	}

	public void filtro() {
		filtro = txtBusquedaDeduccion.getText();
		trsfiltro.setRowFilter(RowFilter.regexFilter(txtBusquedaDeduccion.getText(), 0, 1, 2, 3, 4));
	}

	public void pistas() {
		pista = new PlaceHolder(txtBusquedaDeduccion, "Escriba para buscar.");
		pista = new PlaceHolder(txtNombresDeduccion, "Nombres del empleado.");
		pista = new PlaceHolder(txtApellidosDeduccion, "Apellidos del empleado.");
		pista = new PlaceHolder(txtIdentidadEmpleadoDeduccion, "Escriba la identidad.");
		pista = new PlaceHolder(txtIdentidadDeduccion, "Identidad del empleado");
		pista = new PlaceHolder(txtCantidadDeduccion, "Digite la cantidad.");
		pista = new PlaceHolder(txtObservacionDeduccion, "Escriba una observacion.");
	}

	public void obtenerUltimoId() {
		String ultimoValor = null;
		int valor;
		String id = null;
		conexion objCon = new conexion();
		Connection conn = objCon.getConexion();
		try {
			PreparedStatement stmtr = conn.prepareStatement("SELECT * FROM deducciones ORDER BY id_deduccion DESC");
			ResultSet rsr = stmtr.executeQuery();
			if (rsr.next()) {
				ultimoValor = rsr.getString("id_deduccion");
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
		if (tablaDeducciones.getRowCount() > 0) {
			for (int i = 0; i < tablaDeducciones.getRowCount(); i++) {
				p = Double.parseDouble(tablaDeducciones.getValueAt(i, 4).toString());
				t += p;
			}
			txtTotalDeducciones.setText(String.valueOf(t));
		} else {
			JOptionPane.showMessageDialog(null, "No hay datos que totalizar");
		}
	}

	public void busquedaDatosEmpleado() {
		consultas_deduccion consulta = new consultas_deduccion();
		empleado clase = new empleado();
		clase.setIdentidad_empleado(txtIdentidadEmpleadoDeduccion.getText());
		if (consulta.buscar(clase)) {
			txtCodigoDeduccion.setText(String.valueOf(clase.getId_empleado()));
			txtNombresDeduccion.setText(String.valueOf(clase.getNombres_empleado()));
			txtApellidosDeduccion.setText(String.valueOf(clase.getApellidos_empleado()));
			txtIdentidadDeduccion.setText(String.valueOf(clase.getIdentidad_empleado()));
			txtDireccionFoto.setText(String.valueOf(clase.getDireccion_foto_empleado()));
			String ruta = txtDireccionFoto.getText().toString();
			final ImageIcon foto = new ImageIcon(ruta);
			final ImageIcon logo = new ImageIcon(foto.getImage().getScaledInstance(lblFotoDeduccion.getWidth(),
					lblFotoDeduccion.getHeight(), Image.SCALE_DEFAULT));
			lblFotoDeduccion.setIcon(logo);

			txtCodigoDeduccion.setForeground(Color.BLACK);
			txtNombresDeduccion.setForeground(Color.BLACK);
			txtApellidosDeduccion.setForeground(Color.BLACK);
			txtIdentidadDeduccion.setForeground(Color.BLACK);

		} else {
			JOptionPane.showMessageDialog(null, "No se encontro ningun registro");

		}
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
		SimpleDateFormat df = new SimpleDateFormat("'Dia' EEEEEEEEE dd 'de' MMMMM 'del' yyyy 'a las' HH:mm:ss");
		date = cal.getTime();
		return df.format(date);
	}

	public void consultarEmpresa() {
		conexion conex = new conexion();
		try {
			Statement estatuto = conex.getConexion().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT direccion_logo_empresa FROM empresa where id_empresa = 1");

			if (rs.next()) {
				ruta_logo = (rs.getString("direccion_logo_empresa"));
				final ImageIcon logo = new ImageIcon(ruta_logo);

				final ImageIcon icono = new ImageIcon(logo.getImage().getScaledInstance(label_22.getWidth(),
						label_22.getHeight(), Image.SCALE_DEFAULT));
				label_22.setIcon(icono);

			} else {
				JOptionPane.showMessageDialog(null,
						"Para una mejor experiencia Personalice su empresa en :" + " MAS INFORMACIONS DE LA EMPRESA.");
			}
			rs.close();
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error al consultar", "Error", JOptionPane.ERROR_MESSAGE);

		}

	}
	
	public void obtenerTotalDatosReporte() {
		conexion objCon = new conexion();
		Connection conn = objCon.getConexion();
		try {
			PreparedStatement stmtr = conn.prepareStatement("SELECT * FROM deducciones ORDER BY id_deduccion DESC");
			ResultSet rsr = stmtr.executeQuery();
			if (rsr.next()) {
				totalDatos = rsr.getString("id_deduccion");
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
