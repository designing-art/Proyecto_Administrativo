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
import consultas.consultas_bonificacion;
import controles.control_bonificacion;
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

public class registro_bonificaciones extends JFrame {

	public JPanel contentPane;
	public JTextField txtApellidosBonificacion;
	public JTextField txtNombresBonificacion;
	public JTextField txtCodigoBonificacion;
	public JLabel label_2;
	public JLabel label_3;
	public JLabel label_4;
	public JLabel label_5;
	public JTextField txtIdentidadBonificacion;
	public JLabel lblBuscarEmpleadoPor;
	public static JFormattedTextField txtIdentidadEmpleadoBonificacion;
	public JPanel panel;
	public JLabel label_6;
	public JLabel lblTipo;
	public JLabel lblCantidad;
	public JTextField txtCantidadBonificacion;
	public JLabel lblObservacion;
	public JLabel lblAgregarDeduccion;

	public static String nombreEmpresa = null;
	public static String totalDatos = null;
	public JPanel panel_2;
	public JLabel label_8;
	public static JTextField txtBusquedaBonificacion;
	public static JTextField txtTotalBonificacion;
	public JLabel lblFotoBonificacion;
	public JButton btnAtras;
	public PlaceHolder pista;
	public JDateChooser dateFechaBonificacion;

	public JButton btnBorrarBonificacion;
	public JButton btnVerBonificacion;
	public JButton btnActualizarDatosBonificacion;

	public static String ruta_logo;
	public static JLabel label_21;
	public static JLabel label_22;

	public JScrollPane scrollPane_1;
	public JTextArea txtObservacionBonificacion;
	public JButton btnAceptar;
	public JButton btnNuevo;
	public JButton btnActualizar;
	public JButton btnGuardar;
	public JLabel lblTotalDeducciones;
	public JButton btnBuscarIdentidadDeduccion;
	public JTextFieldDateEditor editor;

	public JScrollPane barraTablaBonificacion;
	public JTable tablaBonificaciones;

	public TableRowSorter trsfiltro;
	String filtro;
	public static String hora_fecha_reporte;

	public static String ruta;
	public static ImageIcon imagen;

	public static String bonificaciones;

	public JComboBox<?> cbxTipoBonificacion;
	public JTextField txtDireccionFoto;
	public JButton btnVer;
	public JLabel lblL;
	public JLabel label;
	public JTextField txtCodigo;
	public JLabel lblFecha;
	public JButton btnPlanilla;
	private JButton button;
	public JButton btnSinBonif;

	public registro_bonificaciones() {
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

		JLabel lblBuscarDeduccion = new JLabel("Buscar bonificacion:");
		lblBuscarDeduccion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblBuscarDeduccion.setBounds(28, 63, 136, 22);
		panel_2.add(lblBuscarDeduccion);

		txtBusquedaBonificacion = new JTextField();
		txtBusquedaBonificacion.setHorizontalAlignment(SwingConstants.CENTER);
		InputMap map41 = txtBusquedaBonificacion.getInputMap(JComponent.WHEN_FOCUSED);
		map41.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtBusquedaBonificacion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtBusquedaBonificacion.setColumns(10);
		txtBusquedaBonificacion.setBounds(157, 64, 186, 21);
		panel_2.add(txtBusquedaBonificacion);
		txtBusquedaBonificacion.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				trsfiltro = new TableRowSorter(tablaBonificaciones.getModel());
				tablaBonificaciones.setRowSorter(trsfiltro);
			}

			@Override
			public void keyPressed(KeyEvent ke) {

			}

			@Override
			public void keyReleased(KeyEvent ke) {
				String cadena = (txtBusquedaBonificacion.getText());
				txtBusquedaBonificacion.setText(cadena);
				repaint();
				filtro();
			}
		});

		label_21 = new JLabel();
		label_21.setBounds(353, 41, 49, 44);
		panel_2.add(label_21);

		JLabel lblDeduccionesRegistradas = new JLabel("Bonificaciones");
		lblDeduccionesRegistradas.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblDeduccionesRegistradas.setBounds(28, 41, 150, 19);
		panel_2.add(lblDeduccionesRegistradas);

		btnBorrarBonificacion = new JButton("Borrar");
		btnBorrarBonificacion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnBorrarBonificacion.setBackground(new Color(220, 20, 60));
		btnBorrarBonificacion.setBounds(28, 406, 99, 23);
		panel_2.add(btnBorrarBonificacion);

		btnVerBonificacion = new JButton("Ver detalles");
		btnVerBonificacion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnVerBonificacion.setBackground(new Color(0, 206, 209));
		btnVerBonificacion.setBounds(147, 406, 108, 23);
		panel_2.add(btnVerBonificacion);

		btnActualizarDatosBonificacion = new JButton("Actualizar Datos");
		btnActualizarDatosBonificacion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnActualizarDatosBonificacion.setBackground(new Color(60, 179, 113));
		btnActualizarDatosBonificacion.setBounds(265, 407, 137, 23);
		panel_2.add(btnActualizarDatosBonificacion);

		barraTablaBonificacion = new JScrollPane((Component) null, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		barraTablaBonificacion.setBounds(26, 95, 376, 247);
		panel_2.add(barraTablaBonificacion);

		lblTotalDeducciones = new JLabel("Total bonificaciones:");
		lblTotalDeducciones.setBounds(28, 349, 150, 26);
		panel_2.add(lblTotalDeducciones);
		lblTotalDeducciones.setFont(new Font("Dialog", Font.BOLD, 12));

		txtTotalBonificacion = new JTextField();
		txtTotalBonificacion.setBounds(178, 353, 115, 22);
		panel_2.add(txtTotalBonificacion);
		txtTotalBonificacion.setEditable(false);
		txtTotalBonificacion.setColumns(10);
		txtTotalBonificacion.setHorizontalAlignment(SwingConstants.RIGHT);

		JButton btnCalcularBonificacion = new JButton("Calcular");
		btnCalcularBonificacion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				totalizar();
			}
		});
		btnCalcularBonificacion.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 10));
		btnCalcularBonificacion.setBounds(303, 353, 99, 23);
		panel_2.add(btnCalcularBonificacion);
		btnCalcularBonificacion.setBackground(new Color(60, 179, 113));

		label = new JLabel("L.");
		label.setBounds(157, 353, 28, 18);
		panel_2.add(label);
		label.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));

		btnPlanilla = new JButton("Planilla");
		btnPlanilla.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (txtTotalBonificacion.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "No hay bonificaciones para este empleado.");
				} else {
					registro_planillas.txtTotalBonificacionesPlanilla.setText(txtTotalBonificacion.getText());
					double a = 0;
					double b = 0;
					double c = 0;
					a = Double.valueOf(registro_planillas.txtCantidadPlanilla.getText());
					b = Double.valueOf(registro_planillas.txtTotalBonificacionesPlanilla.getText());
					c = a + b;
					registro_planillas.txtSueldoNetoPlanilla.setText(String.valueOf(c));
					JOptionPane.showMessageDialog(null, "Bonificaciones agregadas a la planilla.");
					dispose();
				}

			}
		});
		btnPlanilla.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 10));
		btnPlanilla.setBackground(new Color(255, 255, 0));
		btnPlanilla.setBounds(303, 378, 99, 23);
		panel_2.add(btnPlanilla);
		btnPlanilla.setVisible(false);

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

					String encabezado = "Reporte de bonos de " + login_usuario.nombre.toString();

					utilJTablePrint(tablaBonificaciones, encabezado,
							"Pagina {0} de " + i + "          Impreso por: "+login_usuario.nombreCompletoUsuario.toString()+"          "+fecha, true);
					
				}
			}
		});
		button.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		button.setBackground(new Color(60, 179, 113));
		button.setBounds(206, 41, 137, 19);
		panel_2.add(button);

		btnSinBonif = new JButton("Sin Deducciones");
		btnSinBonif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Sin bonificaciones.");
				registro_planillas.txtTotalBonificacionesPlanilla.setText("0");
				double a = 0;
				double b = 0;
				double c = 0;
				a = Double.valueOf(registro_planillas.txtCantidadPlanilla.getText());
				b = Double.valueOf(registro_planillas.txtTotalBonificacionesPlanilla.getText());
				c = a + b;
				registro_planillas.txtSueldoNetoPlanilla.setText(String.valueOf(c));
				dispose();
			}
		});
		btnSinBonif.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSinBonif.setBounds(147, 378, 150, 23);
		panel_2.add(btnSinBonif);

		label_8 = new JLabel("");
		label_8.setBounds(0, 0, 430, 456);
		panel_2.add(label_8);
		final ImageIcon logo = new ImageIcon(
				icono.getImage().getScaledInstance(label_8.getWidth(), label_8.getHeight(), Image.SCALE_DEFAULT));
		label_8.setIcon(logo);

		JLabel lblRegistroYMantenimiento = new JLabel("REGISTRO Y MANTENIMIENTO DE BONIFICACIONES");
		lblRegistroYMantenimiento.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblRegistroYMantenimiento.setBounds(10, 1, 551, 39);
		contentPane.add(lblRegistroYMantenimiento);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 46, 424, 454);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblRegistrarDeducciones = new JLabel("Registrar Bonificacion.");
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
		txtIdentidadEmpleadoBonificacion = new JFormattedTextField(formato);
		txtIdentidadEmpleadoBonificacion.setBounds(168, 71, 132, 20);
		txtIdentidadEmpleadoBonificacion.setHorizontalAlignment(SwingConstants.CENTER);
		InputMap map42 = txtIdentidadEmpleadoBonificacion.getInputMap(JComponent.WHEN_FOCUSED);
		map42.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		panel_1.add(txtIdentidadEmpleadoBonificacion);
		txtIdentidadEmpleadoBonificacion.setColumns(10);
		txtIdentidadEmpleadoBonificacion.addKeyListener(new KeyListener() {
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

		txtCodigoBonificacion = new JTextField();
		txtCodigoBonificacion.setBounds(102, 123, 28, 20);
		panel_1.add(txtCodigoBonificacion);
		txtCodigoBonificacion.setEditable(false);
		txtCodigoBonificacion.setColumns(10);
		txtCodigoBonificacion.setHorizontalAlignment(SwingConstants.CENTER);

		label_2 = new JLabel("Nombres :");
		label_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		label_2.setBounds(35, 152, 63, 14);
		panel_1.add(label_2);

		txtNombresBonificacion = new JTextField();
		txtNombresBonificacion.setEditable(false);
		txtNombresBonificacion.setBounds(102, 149, 186, 20);
		panel_1.add(txtNombresBonificacion);
		txtNombresBonificacion.setColumns(10);
		txtNombresBonificacion.setHorizontalAlignment(SwingConstants.CENTER);

		label_3 = new JLabel("Apellidos :");
		label_3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		label_3.setBounds(35, 177, 63, 14);
		panel_1.add(label_3);

		txtApellidosBonificacion = new JTextField();
		txtApellidosBonificacion.setEditable(false);
		txtApellidosBonificacion.setBounds(102, 174, 186, 20);
		panel_1.add(txtApellidosBonificacion);
		txtApellidosBonificacion.setColumns(10);
		txtApellidosBonificacion.setHorizontalAlignment(SwingConstants.CENTER);

		label_5 = new JLabel("Identidad :");
		label_5.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		label_5.setBounds(35, 205, 63, 14);
		panel_1.add(label_5);

		txtIdentidadBonificacion = new JTextField();
		txtIdentidadBonificacion.setEditable(false);
		txtIdentidadBonificacion.setBounds(102, 199, 186, 20);
		panel_1.add(txtIdentidadBonificacion);
		txtIdentidadBonificacion.setColumns(10);
		txtIdentidadBonificacion.setHorizontalAlignment(SwingConstants.CENTER);

		label_6 = new JLabel("Fotografia :");
		label_6.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		label_6.setBounds(225, 118, 82, 14);
		panel_1.add(label_6);

		panel = new JPanel();
		panel.setBounds(298, 113, 94, 87);
		panel_1.add(panel);
		panel.setLayout(null);

		lblFotoBonificacion = new JLabel();
		lblFotoBonificacion.setBounds(0, 0, 94, 87);
		panel.add(lblFotoBonificacion);
		final ImageIcon logo22 = new ImageIcon(usuario.getImage().getScaledInstance(lblFotoBonificacion.getWidth(),
				lblFotoBonificacion.getHeight(), Image.SCALE_DEFAULT));
		lblFotoBonificacion.setIcon(logo22);

		lblAgregarDeduccion = new JLabel("Agregar bonificacion :");
		lblAgregarDeduccion.setBounds(35, 230, 168, 14);
		panel_1.add(lblAgregarDeduccion);
		lblAgregarDeduccion.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));

		lblTipo = new JLabel("Tipo :");
		lblTipo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblTipo.setBounds(35, 257, 63, 14);
		panel_1.add(lblTipo);

		cbxTipoBonificacion = new JComboBox();
		cbxTipoBonificacion.setModel(new DefaultComboBoxModel(new String[] { "Bono navide\u00F1o.",
				"Bono por antiguedad.", "Bono por  publicidad.", "Pago por editar.", "Pago por filmar evento.",
				"Pago por tomas.", "Pago por venta de publicidad.", "Bono por trabajos terminados." }));
		cbxTipoBonificacion.setBounds(137, 255, 132, 20);
		panel_1.add(cbxTipoBonificacion);

		lblCantidad = new JLabel("Cantidad :");
		lblCantidad.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblCantidad.setBounds(35, 282, 63, 14);
		panel_1.add(lblCantidad);

		txtCantidadBonificacion = new JTextField();
		txtCantidadBonificacion.setBounds(137, 280, 132, 20);
		panel_1.add(txtCantidadBonificacion);
		txtCantidadBonificacion.setColumns(10);
		txtCantidadBonificacion.setHorizontalAlignment(SwingConstants.RIGHT);
		InputMap map44 = txtCantidadBonificacion.getInputMap(JComponent.WHEN_FOCUSED);
		map44.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtCantidadBonificacion.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();
				if ((c < '0' || c > '9'))
					ke.consume();
				if (txtCantidadBonificacion.getText().length() == 8)
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

		txtObservacionBonificacion = new JTextArea();
		InputMap map45 = txtObservacionBonificacion.getInputMap(JComponent.WHEN_FOCUSED);
		map45.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		scrollPane_1.setViewportView(txtObservacionBonificacion);
		txtObservacionBonificacion.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				if (txtObservacionBonificacion.getText().length() == 100) {
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
					String str = txtObservacionBonificacion.getText().trim();
					txtObservacionBonificacion.setText(str);
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
				if (txtIdentidadEmpleadoBonificacion.getText().isEmpty()) {
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

		dateFechaBonificacion = new JDateChooser();
		dateFechaBonificacion.setBounds(137, 348, 132, 20);
		dateFechaBonificacion.setDateFormatString("dd-MMMMM-yyyy");
		panel_1.add(dateFechaBonificacion);
		editor = (JTextFieldDateEditor) dateFechaBonificacion.getDateEditor();
		editor.setEditable(false);
		editor.setHorizontalAlignment(SwingConstants.CENTER);
		dateFechaBonificacion.setVisible(false);

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
				principal.setTitle("Sesión iniciada por: " + login_usuario.nombreCompletoUsuario);
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
			dateFechaBonificacion.setDate(date);
		} catch (Exception e) {

		}

	}

	public void construirTabla() {
		String titulos[] = { "Codigo", "Tipo", "Observacion", "Identidad", "Cantidad", "Fecha" };
		String informacion[][] = control_bonificacion.obtenerMatriz();
		tablaBonificaciones = new JTable(informacion, titulos);
		barraTablaBonificacion.setViewportView(tablaBonificaciones);
		for (int c = 0; c < tablaBonificaciones.getColumnCount(); c++) {
			Class<?> col_class = tablaBonificaciones.getColumnClass(c);
			tablaBonificaciones.setDefaultEditor(col_class, null);
			tablaBonificaciones.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			tablaBonificaciones.getTableHeader().setReorderingAllowed(false);

			DefaultTableCellRenderer tcr;
			tcr = new DefaultTableCellRenderer();
			tcr.setHorizontalAlignment(SwingConstants.RIGHT);
			tablaBonificaciones.getColumnModel().getColumn(4).setCellRenderer(tcr);
		}
	}

	public void filtro() {
		filtro = txtBusquedaBonificacion.getText();
		trsfiltro.setRowFilter(RowFilter.regexFilter(txtBusquedaBonificacion.getText(), 0, 1, 2, 3, 4));
	}

	public void pistas() {
		pista = new PlaceHolder(txtBusquedaBonificacion, "Escriba para buscar.");
		pista = new PlaceHolder(txtNombresBonificacion, "Nombres del empleado.");
		pista = new PlaceHolder(txtApellidosBonificacion, "Apellidos del empleado.");
		pista = new PlaceHolder(txtIdentidadEmpleadoBonificacion, "Escriba la identidad.");
		pista = new PlaceHolder(txtIdentidadBonificacion, "Identidad del empleado");
		pista = new PlaceHolder(txtCantidadBonificacion, "Digite la cantidad.");
		pista = new PlaceHolder(txtObservacionBonificacion, "Escriba una observacion.");
	}

	public void obtenerUltimoId() {
		String ultimoValor = null;
		int valor;
		String id = null;
		conexion objCon = new conexion();
		Connection conn = objCon.getConexion();
		try {
			PreparedStatement stmtr = conn
					.prepareStatement("SELECT * FROM bonificaciones ORDER BY id_bonificacion DESC");
			ResultSet rsr = stmtr.executeQuery();
			if (rsr.next()) {
				ultimoValor = rsr.getString("id_bonificacion");
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
		if (tablaBonificaciones.getRowCount() > 0) {
			for (int i = 0; i < tablaBonificaciones.getRowCount(); i++) {
				p = Double.parseDouble(tablaBonificaciones.getValueAt(i, 4).toString());
				t += p;
			}
			txtTotalBonificacion.setText(String.valueOf(t));
		} else {
			JOptionPane.showMessageDialog(null, "No hay datos que totalizar");
		}
	}

	public void busquedaDatosEmpleado() {
		consultas_bonificacion consulta = new consultas_bonificacion();
		empleado clase = new empleado();
		clase.setIdentidad_empleado(txtIdentidadEmpleadoBonificacion.getText());
		if (consulta.buscar(clase)) {
			txtCodigoBonificacion.setText(String.valueOf(clase.getId_empleado()));
			txtNombresBonificacion.setText(String.valueOf(clase.getNombres_empleado()));
			txtApellidosBonificacion.setText(String.valueOf(clase.getApellidos_empleado()));
			txtIdentidadBonificacion.setText(String.valueOf(clase.getIdentidad_empleado()));
			txtDireccionFoto.setText(String.valueOf(clase.getDireccion_foto_empleado()));
			String ruta = txtDireccionFoto.getText().toString();
			final ImageIcon foto = new ImageIcon(ruta);
			final ImageIcon logo = new ImageIcon(foto.getImage().getScaledInstance(lblFotoBonificacion.getWidth(),
					lblFotoBonificacion.getHeight(), Image.SCALE_DEFAULT));
			lblFotoBonificacion.setIcon(logo);

			txtCodigoBonificacion.setForeground(Color.BLACK);
			txtNombresBonificacion.setForeground(Color.BLACK);
			txtApellidosBonificacion.setForeground(Color.BLACK);
			txtIdentidadBonificacion.setForeground(Color.BLACK);

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
		SimpleDateFormat df = new SimpleDateFormat("dd'/'MMMMM'/'yyyy HH:mm:ss ");
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

				final ImageIcon icono = new ImageIcon(logo.getImage().getScaledInstance(label_21.getWidth(),
						label_21.getHeight(), Image.SCALE_DEFAULT));
				label_21.setIcon(icono);

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
			PreparedStatement stmtr = conn
					.prepareStatement("SELECT * FROM bonificaciones ORDER BY id_bonificacion DESC");
			ResultSet rsr = stmtr.executeQuery();
			if (rsr.next()) {
				totalDatos = rsr.getString("id_bonificacion");
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
