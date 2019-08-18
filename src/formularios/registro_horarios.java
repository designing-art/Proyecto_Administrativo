package formularios;

import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.RowFilter;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
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
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import com.placeholder.PlaceHolder;

import conexion.conexion;
import controles.control_horario;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class registro_horarios extends JFrame {
	public JTextField txtIdHorario;
	public JTextField txttipohorario;
	public JScrollPane scrollPane;
	public PlaceHolder pista;
	public JPanel contentPane;
	public JButton btnAceptarHorario;
	public JButton btnActualizarHorario;
	public JButton btnActualizarDatosHorario;
	public JButton btnNuevoHorario;
	public JButton btnSalirHorario;
	public JButton btnAceptar;
	public JButton btnMostrar;
	public JButton btnAtras;
	public JButton btnBorrarHorario;
	public JButton btnMostrarHorario;
	public JButton btnGuardarHorario;
	public JScrollPane barraHorarios;
	public JTextArea txtDescripcionHorario;
	public JTextArea txtObservacionHorario;
	public JComboBox<?> cbxTipoHorario;
	public JComboBox<?> cbxHorasDia;
	public JComboBox<?> cbxDiasHorario;
	public static String nombreEmpresa = null;
	public static String totalDatos = null;

	public JTextField txtCodigoHorario;
	public JTextField txtBusquedaHorario;
	public JTable tablaHorario;
	public TableRowSorter<TableModel> trsfiltroCodigo;
	String filtroCodigo;
	private JButton button;
	public static String hora_fecha_reporte;

	public static String ruta_logo;
	public static JLabel label;
	public static JLabel label_2;
	public JButton btnAsignar;

	public registro_horarios() {
		setResizable(false);
		setDefaultCloseOperation(0);
		setBounds(100, 100, 865, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/iconos/icono_d_a.jpg")));

		JTextField txtidhorario = new JTextField();
		contentPane.setLayout(null);

		btnAtras = new JButton("Regresar");
		btnAtras.setBounds(727, 11, 99, 23);
		btnAtras.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnAtras.setBackground(new Color(255, 127, 80));
		contentPane.add(btnAtras);
		btnAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
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

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(24, 59, 341, 401);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblObservacionHorario = new JLabel("6. Observacion horario :");
		lblObservacionHorario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblObservacionHorario.setBounds(30, 247, 150, 14);
		panel.add(lblObservacionHorario);

		JLabel lblDescripcionHorario = new JLabel("5. Descripcion Horario :");
		lblDescripcionHorario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblDescripcionHorario.setBounds(30, 182, 150, 19);
		panel.add(lblDescripcionHorario);

		JLabel lblDiasDelHorario = new JLabel("3. Dias del horario :");
		lblDiasDelHorario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblDiasDelHorario.setBounds(30, 130, 150, 14);
		panel.add(lblDiasDelHorario);

		JLabel lblHoraDelHorario = new JLabel("4. Horas al dia :");
		lblHoraDelHorario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblHoraDelHorario.setBounds(30, 157, 177, 14);
		panel.add(lblHoraDelHorario);

		JLabel lblTipoDeHorario = new JLabel("2. Tipo de horario :");
		lblTipoDeHorario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblTipoDeHorario.setBounds(31, 103, 130, 14);
		panel.add(lblTipoDeHorario);

		JLabel lblCodigo = new JLabel("1. Codigo :");
		lblCodigo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblCodigo.setBounds(31, 78, 63, 14);
		panel.add(lblCodigo);

		JLabel lblDatosDelRegistro = new JLabel("Datos del registro.");
		lblDatosDelRegistro.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblDatosDelRegistro.setBounds(30, 41, 197, 36);
		panel.add(lblDatosDelRegistro);

		btnAceptarHorario = new JButton("Aceptar");
		btnAceptarHorario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAceptarHorario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnAceptarHorario.setBackground(new Color(255, 255, 224));
		btnAceptarHorario.setBounds(30, 317, 99, 23);
		panel.add(btnAceptarHorario);

		btnNuevoHorario = new JButton("Nuevo");
		btnNuevoHorario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnNuevoHorario.setBackground(Color.WHITE);
		btnNuevoHorario.setBounds(30, 348, 99, 23);
		panel.add(btnNuevoHorario);

		btnActualizarHorario = new JButton("Actualizar");
		btnActualizarHorario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnActualizarHorario.setBackground(new Color(60, 179, 113));
		btnActualizarHorario.setBounds(214, 317, 99, 23);
		panel.add(btnActualizarHorario);

		txtCodigoHorario = new JTextField();
		txtCodigoHorario.setEditable(false);
		txtCodigoHorario.setBounds(202, 76, 46, 20);
		panel.add(txtCodigoHorario);
		txtCodigoHorario.setColumns(10);

		cbxTipoHorario = new JComboBox();
		cbxTipoHorario.setModel(new DefaultComboBoxModel(new String[] { "Matutino", "Vespertino", "Nocturno" }));
		cbxTipoHorario.setBounds(202, 101, 111, 20);
		panel.add(cbxTipoHorario);

		cbxHorasDia = new JComboBox();
		cbxHorasDia.setModel(new DefaultComboBoxModel(new String[] { "6:00 am - 2:00 pm", "2:00 pm - 10:00 pm",
				"8:00 am - 2:00 pm", "2:00 pm - 9:00 pm", "10:00 pm - 6:00 am" }));
		cbxHorasDia.setBounds(201, 155, 111, 20);
		panel.add(cbxHorasDia);

		cbxDiasHorario = new JComboBox();
		cbxDiasHorario.setModel(
				new DefaultComboBoxModel(new String[] { "De Lunes a Viernes", "Sabado y Domingo", "Toda la semana" }));
		cbxDiasHorario.setBounds(202, 128, 111, 20);
		panel.add(cbxDiasHorario);

		label = new JLabel();
		label.setBounds(264, 41, 49, 44);
		panel.add(label);

		btnGuardarHorario = new JButton("Guardar");
		btnGuardarHorario.setBackground(new Color(60, 179, 113));
		btnGuardarHorario.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGuardarHorario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGuardarHorario.setBounds(214, 349, 99, 23);
		panel.add(btnGuardarHorario);
		final ImageIcon icono = new ImageIcon(getClass().getResource("/iconos/libreta.png"));

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(30, 200, 283, 44);
		panel.add(scrollPane_1);

		txtDescripcionHorario = new JTextArea();
		scrollPane_1.setViewportView(txtDescripcionHorario);
		InputMap map5 = txtDescripcionHorario.getInputMap(JComponent.WHEN_FOCUSED);
		map5.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtDescripcionHorario.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				if (txtDescripcionHorario.getText().length() == 100)
					ke.consume();
			}

			@Override
			public void keyPressed(KeyEvent ke) {
			}

			@Override
			public void keyReleased(KeyEvent ke) {
				char c = ke.getKeyChar();
				if (ke.getKeyChar() == '\n' || ke.getKeyChar() == '\t') {
					String str = txtDescripcionHorario.getText().trim();
					txtDescripcionHorario.setText(str);
				}
			}
		});

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(30, 262, 283, 44);
		panel.add(scrollPane_2);

		txtObservacionHorario = new JTextArea();
		scrollPane_2.setViewportView(txtObservacionHorario);
		InputMap map6 = txtObservacionHorario.getInputMap(JComponent.WHEN_FOCUSED);
		map6.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtObservacionHorario.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				if (txtObservacionHorario.getText().length() == 100)
					ke.consume();
			}

			@Override
			public void keyPressed(KeyEvent ke) {
			}

			@Override
			public void keyReleased(KeyEvent ke) {
				char c = ke.getKeyChar();
				if (ke.getKeyChar() == '\n' || ke.getKeyChar() == '\t') {
					String str = txtObservacionHorario.getText().trim();
					txtObservacionHorario.setText(str);
				}
			}
		});

		JLabel label = new JLabel();
		label.setBounds(0, 0, 341, 401);
		panel.add(label);
		final ImageIcon logo = new ImageIcon(
				icono.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
		label.setIcon(logo);

		JPanel panelTablaHorario = new JPanel();
		panelTablaHorario.setLayout(null);
		panelTablaHorario.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		panelTablaHorario.setBackground(Color.WHITE);
		panelTablaHorario.setBounds(386, 59, 440, 401);
		contentPane.add(panelTablaHorario);

		JLabel lblHorarioRegistrados = new JLabel("Horario registrados :");
		lblHorarioRegistrados.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblHorarioRegistrados.setBounds(30, 40, 166, 19);
		panelTablaHorario.add(lblHorarioRegistrados);

		JLabel lblBuscarHorario = new JLabel("Buscar Horario :");
		lblBuscarHorario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblBuscarHorario.setBounds(30, 62, 99, 22);
		panelTablaHorario.add(lblBuscarHorario);

		txtBusquedaHorario = new JTextField();
		txtBusquedaHorario.setHorizontalAlignment(SwingConstants.CENTER);
		txtBusquedaHorario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtBusquedaHorario.setColumns(10);
		txtBusquedaHorario.setBounds(128, 63, 219, 21);
		panelTablaHorario.add(txtBusquedaHorario);
		InputMap map4 = txtBusquedaHorario.getInputMap(JComponent.WHEN_FOCUSED);
		map4.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtBusquedaHorario.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent ke) {
				trsfiltroCodigo = new TableRowSorter(tablaHorario.getModel());
				tablaHorario.setRowSorter(trsfiltroCodigo);
			}

			@Override
			public void keyPressed(KeyEvent ke) {

			}

			@Override
			public void keyReleased(KeyEvent ke) {
				String cadena = (txtBusquedaHorario.getText());
				txtBusquedaHorario.setText(cadena);
				repaint();
				filtro();
			}
		});

		barraHorarios = new JScrollPane(tablaHorario, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		barraHorarios.setBounds(30, 95, 377, 231);
		panelTablaHorario.add(barraHorarios);

		tablaHorario = new JTable();
		barraHorarios.setViewportView(tablaHorario);

		label_2 = new JLabel();
		label_2.setBounds(358, 40, 49, 44);
		panelTablaHorario.add(label_2);

		btnActualizarDatosHorario = new JButton("Actualizar Datos");
		btnActualizarDatosHorario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnActualizarDatosHorario.setBackground(new Color(60, 179, 113));
		btnActualizarDatosHorario.setBounds(270, 347, 137, 23);
		panelTablaHorario.add(btnActualizarDatosHorario);

		btnMostrarHorario = new JButton("Ver detalles");
		btnMostrarHorario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnMostrarHorario.setBackground(new Color(0, 206, 209));
		btnMostrarHorario.setBounds(152, 347, 108, 23);
		panelTablaHorario.add(btnMostrarHorario);
		final ImageIcon icono2 = new ImageIcon(getClass().getResource("/iconos/libreta.png"));

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

					String encabezado = "Reporte de horarios de " + login_usuario.nombre.toString();

					utilJTablePrint(tablaHorario, encabezado, "Pagina {0} de " + i + "          Impreso por: "
							+ login_usuario.nombreCompletoUsuario.toString() + "          " + fecha, true);

				}
			}
		});
		button.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		button.setBackground(new Color(60, 179, 113));
		button.setBounds(210, 39, 137, 19);
		panelTablaHorario.add(button);

		btnAsignar = new JButton("Asignar");
		btnAsignar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnAsignar.setBackground(new Color(34, 139, 34));
		btnAsignar.setBounds(30, 347, 99, 23);
		panelTablaHorario.add(btnAsignar);

		btnBorrarHorario = new JButton("Borrar");
		btnBorrarHorario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnBorrarHorario.setBackground(new Color(220, 20, 60));
		btnBorrarHorario.setBounds(30, 347, 99, 23);
		panelTablaHorario.add(btnBorrarHorario);

		JLabel label_2_1 = new JLabel();
		label_2_1.setBounds(0, 0, 440, 401);
		panelTablaHorario.add(label_2_1);
		final ImageIcon logo2 = new ImageIcon(
				icono2.getImage().getScaledInstance(label_2_1.getWidth(), label_2_1.getHeight(), Image.SCALE_DEFAULT));
		label_2_1.setIcon(logo2);

		JLabel lblRegistroYMantenimiento = new JLabel("REGISTRO Y MANTENIMIENTO DE HORARIOS");
		lblRegistroYMantenimiento.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblRegistroYMantenimiento.setBounds(24, 11, 466, 39);
		contentPane.add(lblRegistroYMantenimiento);

	}

	public void pistas() {
		pista = new PlaceHolder(txtBusquedaHorario, "Escriba para buscar.");
		pista = new PlaceHolder(txtDescripcionHorario, "Escriba una descripcion.");
		pista = new PlaceHolder(txtObservacionHorario, "Escriba una observacion.");
	}

	public void filtro() {
		filtroCodigo = txtBusquedaHorario.getText();
		trsfiltroCodigo.setRowFilter(RowFilter.regexFilter(txtBusquedaHorario.getText(), 0, 1, 2, 3, 4, 5));
	}

	public void construirTabla() {
		String titulos[] = { "Codigo", "Tipo", "Dias", "Horas", "Descripcion", "Observacion" };
		String informacion[][] = control_horario.obtenerMatriz();
		tablaHorario = new JTable(informacion, titulos);
		barraHorarios.setViewportView(tablaHorario);
		tablaHorario.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tablaHorario.getTableHeader().setReorderingAllowed(false);
		for (int c = 0; c < tablaHorario.getColumnCount(); c++) {
			Class<?> col_class = tablaHorario.getColumnClass(c);
			tablaHorario.setDefaultEditor(col_class, null);
		}
	}

	public void obtenerUltimoId() {
		String ultimoValor = null;
		int valor;
		String id = null;
		conexion objCon = new conexion();
		Connection conn = objCon.getConexion();
		try {
			PreparedStatement stmtr = conn.prepareStatement("SELECT * FROM horarios ORDER BY id_horario DESC");
			ResultSet rsr = stmtr.executeQuery();
			if (rsr.next()) {
				ultimoValor = rsr.getString("id_horario");
				valor = Integer.parseInt(ultimoValor);
				valor = valor + 1;
				id = String.valueOf(valor);
			}
			txtCodigoHorario.setText(id);
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

				final ImageIcon icono = new ImageIcon(
						logo.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
				label.setIcon(icono);

				final ImageIcon icono2 = new ImageIcon(logo.getImage().getScaledInstance(label_2.getWidth(),
						label_2.getHeight(), Image.SCALE_DEFAULT));
				label_2.setIcon(icono2);
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
			PreparedStatement stmtr = conn.prepareStatement("SELECT * FROM horarios ORDER BY id_horario DESC");
			ResultSet rsr = stmtr.executeQuery();
			if (rsr.next()) {
				totalDatos = rsr.getString("id_horario");
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
