package formularios;

import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import javax.swing.table.TableRowSorter;
import javax.swing.text.MaskFormatter;

import com.placeholder.PlaceHolder;

import conexion.conexion;
import controles.control_sar;

import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

public class registro_sar extends JFrame {
	public JScrollPane scrollFunciones;
	public PlaceHolder pista;
	public JButton btnAtras;

	public JButton btnGuardar;
	public JButton btnNuevo;
	public JButton btnActualizarDatos;
	public JButton btnBorrar;
	public JButton btnActualizar;
	public JButton btnMostrar;
	public JButton btnAceptar;

	public int pagina = 0;

	public static String nombreEmpresa = null;
	public static String totalDatos = null;

	public JPanel contentPane;
	public JTextField txtBusquedaCargos;
	public JScrollPane barraSar;
	public JTable tablaSAR;
	public JTextField txtCodigoSar;

	public TableRowSorter trsfiltroCodigo;
	String filtroCodigo;
	public static String hora_fecha_reporte;
	public static String ruta_logo;

	public static JLabel label;
	public static JLabel label_2;
	public JFormattedTextField txtCaiSar;
	public JFormattedTextField txtFormatoSar;
	public JTextField txtTotalFacturas;
	public JTextField txtFacturasUtilizadas;
	public JTextField txtFacturasNoUtilizadas;
	public JTextField txtNota;
	public JTextField txtRangoInicial;
	public JTextField txtRangoFinal;
	public JFormattedTextField txtD;
	public JTextFieldDateEditor editor;
	public JDateChooser dateFechaLimite;

	public String r_i = null;
	public String r_f = null;
	public String f_a = null;
	public int a = 0;
	public int b = 0;
	public int total = 0;
	public int no_util = 0;
	public int util = 0;
	public String c = null;
	public int fa = 0;
	public String utilizadas = null;
	public String no_utilizadas = null;

	public registro_sar() {
		setResizable(false);
		setDefaultCloseOperation(0);
		setBounds(100, 100, 850, 550);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/iconos/icono_d_a.jpg")));
		final ImageIcon icono = new ImageIcon(getClass().getResource("/iconos/libreta.png"));
		final ImageIcon icono2 = new ImageIcon(getClass().getResource("/iconos/libreta.png"));

		btnAtras = new JButton("Regresar");
		btnAtras.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnAtras.setBackground(new Color(255, 127, 80));
		btnAtras.setBounds(717, 10, 102, 23);
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

		JLabel lblRegistrarCargo = new JLabel("REGISTRO Y MANTENIMIENTO DE SAR");
		lblRegistrarCargo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblRegistrarCargo.setBounds(10, 0, 466, 39);
		contentPane.add(lblRegistrarCargo);
		scrollFunciones = new JScrollPane();

		JPanel panelTablaCargos = new JPanel();
		panelTablaCargos.setLayout(null);
		panelTablaCargos.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		panelTablaCargos.setBackground(Color.WHITE);
		panelTablaCargos.setBounds(388, 44, 431, 466);
		contentPane.add(panelTablaCargos);

		JLabel lblCargosRegistrados = new JLabel("Registros de SAR :");
		lblCargosRegistrados.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblCargosRegistrados.setBounds(30, 41, 166, 19);
		panelTablaCargos.add(lblCargosRegistrados);

		JLabel lblBuscarRegistroDe = new JLabel("Buscar registro de SAR :");
		lblBuscarRegistroDe.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblBuscarRegistroDe.setBounds(30, 63, 166, 22);
		panelTablaCargos.add(lblBuscarRegistroDe);

		txtBusquedaCargos = new JTextField();
		txtBusquedaCargos.setHorizontalAlignment(SwingConstants.CENTER);
		txtBusquedaCargos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtBusquedaCargos.setColumns(10);
		txtBusquedaCargos.setBounds(204, 64, 143, 21);
		panelTablaCargos.add(txtBusquedaCargos);
		InputMap map4 = txtBusquedaCargos.getInputMap(JComponent.WHEN_FOCUSED);
		txtBusquedaCargos.addKeyListener(new KeyListener() {
			@Override
			// metodo para buscar en la tabla
			public void keyTyped(KeyEvent ke) {
				trsfiltroCodigo = new TableRowSorter(tablaSAR.getModel());
				tablaSAR.setRowSorter(trsfiltroCodigo);
			}

			@Override
			public void keyPressed(KeyEvent ke) {

			}

			@Override
			public void keyReleased(KeyEvent ke) {
				String cadena = (txtBusquedaCargos.getText());
				txtBusquedaCargos.setText(cadena);
				repaint();
				filtro();
			}
		});

		btnBorrar = new JButton("Borrar");
		btnBorrar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnBorrar.setBackground(new Color(220, 20, 60));
		btnBorrar.setBounds(30, 415, 99, 23);
		panelTablaCargos.add(btnBorrar);

		barraSar = new JScrollPane(tablaSAR, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panelTablaCargos.add(barraSar);
		barraSar.setBounds(28, 90, 376, 314);

		tablaSAR = new JTable();
		barraSar.setViewportView(tablaSAR);

		label_2 = new JLabel();
		label_2.setBounds(355, 41, 49, 44);
		panelTablaCargos.add(label_2);

		btnActualizarDatos = new JButton("Actualizar Datos");
		btnActualizarDatos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnActualizarDatos.setBackground(new Color(60, 179, 113));
		btnActualizarDatos.setBounds(267, 416, 137, 23);
		panelTablaCargos.add(btnActualizarDatos);

		btnMostrar = new JButton("Ver detalles");
		btnMostrar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnMostrar.setBackground(new Color(0, 206, 209));
		btnMostrar.setBounds(149, 415, 108, 23);
		panelTablaCargos.add(btnMostrar);

		JButton btnImprimirReporte = new JButton("Imprimir Reporte");
		btnImprimirReporte.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
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

					String encabezado = "Reporte de SAR de " + login_usuario.nombre.toString();

					utilJTablePrint(tablaSAR, encabezado, "Pagina {0} de " + i + "          Impreso por: "
							+ login_usuario.nombreCompletoUsuario.toString() + "          " + fecha, true);

				}
			}
		});
		btnImprimirReporte.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnImprimirReporte.setBackground(new Color(60, 179, 113));
		btnImprimirReporte.setBounds(210, 40, 137, 19);
		panelTablaCargos.add(btnImprimirReporte);

		JLabel label_5 = new JLabel();
		label_5.setBounds(0, 0, 431, 466);
		panelTablaCargos.add(label_5);
		final ImageIcon logo1 = new ImageIcon(
				icono.getImage().getScaledInstance(label_5.getWidth(), label_5.getHeight(), Image.SCALE_DEFAULT));
		label_5.setIcon(logo1);

		JPanel panelRegistro = new JPanel();
		panelRegistro.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		panelRegistro.setBounds(28, 231, 341, 279);
		contentPane.add(panelRegistro);
		panelRegistro.setLayout(null);

		label = new JLabel();
		label.setBounds(265, 29, 49, 44);
		panelRegistro.add(label);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnNuevo.setBounds(24, 231, 99, 23);
		panelRegistro.add(btnNuevo);
		btnNuevo.setBackground(new Color(255, 255, 255));

		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnGuardar.setBounds(215, 231, 99, 23);
		panelRegistro.add(btnGuardar);
		btnGuardar.setBackground(new Color(60, 179, 113));

		JLabel lblHoraExtraCargo = new JLabel("3. Fecha Limite de emision :");
		lblHoraExtraCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblHoraExtraCargo.setBounds(24, 110, 196, 20);
		panelRegistro.add(lblHoraExtraCargo);

		JLabel lblTipoDeCargo = new JLabel("2. CAI :");
		lblTipoDeCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblTipoDeCargo.setBounds(24, 84, 105, 18);
		panelRegistro.add(lblTipoDeCargo);

		JLabel lblCodigoCargo = new JLabel("1. C\u00F3digo :");
		lblCodigoCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblCodigoCargo.setBounds(24, 59, 63, 14);
		panelRegistro.add(lblCodigoCargo);

		JLabel lblRegistroCargos = new JLabel("Datos del registro de SAR :");
		lblRegistroCargos.setBounds(24, 23, 254, 32);
		panelRegistro.add(lblRegistroCargos);
		lblRegistroCargos.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));

		txtCodigoSar = new JTextField();
		txtCodigoSar.setEditable(false);
		txtCodigoSar.setBounds(101, 59, 43, 18);
		panelRegistro.add(txtCodigoSar);
		txtCodigoSar.setColumns(10);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnActualizar.setBackground(new Color(60, 179, 113));
		btnActualizar.setBounds(215, 207, 99, 23);
		panelRegistro.add(btnActualizar);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnAceptar.setBackground(new Color(255, 255, 255));
		btnAceptar.setBounds(24, 207, 99, 23);
		panelRegistro.add(btnAceptar);

		MaskFormatter formato = null;
		try {
			formato = new MaskFormatter("#???#?-?###?#-#?##?#-####?#-#??###-#?");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtCaiSar = new JFormattedTextField(formato);
		txtCaiSar.setHorizontalAlignment(SwingConstants.CENTER);
		txtCaiSar.setColumns(10);
		txtCaiSar.setBounds(101, 84, 213, 19);
		panelRegistro.add(txtCaiSar);

		dateFechaLimite = new JDateChooser();
		dateFechaLimite.setBounds(189, 110, 125, 20);
		dateFechaLimite.setDateFormatString("dd-MMMMM-yyyy");
		panelRegistro.add(dateFechaLimite);
		dateFechaLimite.setMinSelectableDate(new Date());
		editor = (JTextFieldDateEditor) dateFechaLimite.getDateEditor();
		editor.setEditable(false);
		editor.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblFacturas = new JLabel("4. Facturas :");
		lblFacturas.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblFacturas.setBounds(24, 138, 93, 18);
		panelRegistro.add(lblFacturas);

		txtRangoInicial = new JTextField();
		txtRangoInicial.setHorizontalAlignment(SwingConstants.CENTER);
		txtRangoInicial.setColumns(10);
		txtRangoInicial.setBounds(137, 137, 63, 19);
		panelRegistro.add(txtRangoInicial);
		InputMap map2 = txtRangoInicial.getInputMap(JComponent.WHEN_FOCUSED);
		map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtRangoInicial.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();
				if ((c < '0' || c > '9'))
					ke.consume();

				if (txtRangoInicial.getText().length() == 8)
					ke.consume();
			}

			@Override
			public void keyPressed(KeyEvent ke) {
			}

			@Override
			public void keyReleased(KeyEvent ke) {
			}
		});

		JLabel lblSar = new JLabel("5. SAR :");
		lblSar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblSar.setBounds(24, 165, 105, 18);
		panelRegistro.add(lblSar);

		MaskFormatter formato2 = null;
		try {
			formato2 = new MaskFormatter("###");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		txtRangoFinal = new JTextField();
		txtRangoFinal.setHorizontalAlignment(SwingConstants.CENTER);
		txtRangoFinal.setColumns(10);
		txtRangoFinal.setBounds(251, 138, 63, 19);
		panelRegistro.add(txtRangoFinal);
		InputMap map3 = txtRangoFinal.getInputMap(JComponent.WHEN_FOCUSED);
		map3.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtRangoFinal.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();
				if ((c < '0' || c > '9'))
					ke.consume();

				if (txtRangoFinal.getText().length() == 8)
					ke.consume();
			}

			@Override
			public void keyPressed(KeyEvent ke) {
			}

			@Override
			public void keyReleased(KeyEvent ke) {
			}
		});

		JLabel lblDe = new JLabel("de");
		lblDe.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblDe.setBounds(111, 137, 43, 18);
		panelRegistro.add(lblDe);

		JLabel lblHasta = new JLabel("Hasta :");
		lblHasta.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblHasta.setBounds(189, 108, 105, 18);
		panelRegistro.add(lblHasta);

		MaskFormatter formato3 = null;
		try {
			formato3 = new MaskFormatter("###");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		MaskFormatter formato4 = null;
		try {
			formato4 = new MaskFormatter("##");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		MaskFormatter formato5 = null;
		try {
			formato5 = new MaskFormatter("########");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtD = new JFormattedTextField(formato5);
		txtD.setText("00000000");
		txtD.setEditable(false);
		txtD.setHorizontalAlignment(SwingConstants.CENTER);
		txtD.setColumns(10);
		txtD.setBounds(245, 165, 69, 19);
		panelRegistro.add(txtD);

		JLabel lblA = new JLabel("hasta");
		lblA.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblA.setBounds(210, 138, 43, 18);
		panelRegistro.add(lblA);

		MaskFormatter formato7 = null;
		try {
			formato7 = new MaskFormatter("###-###-##");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtFormatoSar = new JFormattedTextField(formato7);
		txtFormatoSar.setHorizontalAlignment(SwingConstants.CENTER);
		txtFormatoSar.setColumns(10);
		txtFormatoSar.setBounds(101, 165, 131, 19);
		panelRegistro.add(txtFormatoSar);

		JLabel label_3 = new JLabel("-");
		label_3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		label_3.setBounds(235, 165, 43, 18);
		panelRegistro.add(label_3);

		JLabel lblImagenLibreta = new JLabel();
		lblImagenLibreta.setBounds(0, 0, 341, 279);
		panelRegistro.add(lblImagenLibreta);
		final ImageIcon logo = new ImageIcon(icono.getImage().getScaledInstance(lblImagenLibreta.getWidth(),
				lblImagenLibreta.getHeight(), Image.SCALE_DEFAULT));
		lblImagenLibreta.setIcon(logo);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(28, 44, 341, 176);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblDatosActualesDe = new JLabel("Datos actuales utilizados de SAR.");
		lblDatosActualesDe.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblDatosActualesDe.setBounds(25, 11, 291, 42);
		panel.add(lblDatosActualesDe);

		JLabel lblRangoInicial = new JLabel("N\u00BA de Facturas  :");
		lblRangoInicial.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblRangoInicial.setBounds(25, 54, 121, 14);
		panel.add(lblRangoInicial);

		txtTotalFacturas = new JTextField();
		txtTotalFacturas.setEditable(false);
		txtTotalFacturas.setColumns(10);
		txtTotalFacturas.setBounds(156, 51, 160, 23);
		panel.add(txtTotalFacturas);

		JLabel label_8 = new JLabel("1. N\u00BA Facturas  :");
		label_8.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		label_8.setBounds(210, 54, 61, 14);
		panel.add(label_8);

		JLabel lblNDeFacturas = new JLabel("N\u00BA de Facturas utilizadas  :");
		lblNDeFacturas.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblNDeFacturas.setBounds(25, 82, 185, 20);
		panel.add(lblNDeFacturas);

		txtFacturasUtilizadas = new JTextField();
		txtFacturasUtilizadas.setEditable(false);
		txtFacturasUtilizadas.setColumns(10);
		txtFacturasUtilizadas.setBounds(220, 79, 96, 23);
		panel.add(txtFacturasUtilizadas);

		JLabel lblNDeFacturas_1 = new JLabel("N\u00BA de Facturas no utilizadas :");
		lblNDeFacturas_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblNDeFacturas_1.setBounds(25, 111, 185, 20);
		panel.add(lblNDeFacturas_1);

		txtFacturasNoUtilizadas = new JTextField();
		txtFacturasNoUtilizadas.setEditable(false);
		txtFacturasNoUtilizadas.setColumns(10);
		txtFacturasNoUtilizadas.setBounds(220, 108, 96, 23);
		panel.add(txtFacturasNoUtilizadas);

		JLabel lblNota = new JLabel("Nota :");
		lblNota.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblNota.setBounds(25, 142, 69, 20);
		panel.add(lblNota);

		txtNota = new JTextField();
		txtNota.setFont(new Font("Dialog", Font.BOLD, 10));
		txtNota.setHorizontalAlignment(SwingConstants.CENTER);
		txtNota.setEditable(false);
		txtNota.setColumns(10);
		txtNota.setBounds(69, 138, 247, 23);
		panel.add(txtNota);

		JLabel label_1 = new JLabel();
		label_1.setBounds(0, 0, 341, 176);
		panel.add(label_1);
		final ImageIcon logo5 = new ImageIcon(
				icono.getImage().getScaledInstance(label_1.getWidth(), label_1.getHeight(), Image.SCALE_DEFAULT));
		label_1.setIcon(logo5);

		map4.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

	}

	public void construirTabla() {
		String titulos[] = { "Codigo", "CAI", "Formato SAR", "R-I", "R-F", "Factura Actual", "Fecha Limite" };
		String informacion[][] = control_sar.obtenerMatriz();
		tablaSAR = new JTable(informacion, titulos);
		barraSar.setViewportView(tablaSAR);
		for (int c = 0; c < tablaSAR.getColumnCount(); c++) {
			Class<?> col_class = tablaSAR.getColumnClass(c);
			tablaSAR.setDefaultEditor(col_class, null);
			tablaSAR.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			tablaSAR.getTableHeader().setReorderingAllowed(false);
		}
	}

	public void filtro() {
		filtroCodigo = txtBusquedaCargos.getText();
		trsfiltroCodigo.setRowFilter(RowFilter.regexFilter(txtBusquedaCargos.getText(), 0, 1, 2, 3, 4, 5));
	}

	public void obtenerUltimoId() {
		String ultimoValor = null;
		int valor;
		String id = null;
		conexion objCon = new conexion();
		Connection conn = objCon.getConexion();
		try {
			PreparedStatement stmtr = conn.prepareStatement("SELECT * FROM sar ORDER BY id_sar DESC");
			ResultSet rsr = stmtr.executeQuery();
			if (rsr.next()) {
				ultimoValor = rsr.getString("id_sar");
				valor = Integer.parseInt(ultimoValor);
				valor = valor + 1;
				id = String.valueOf(valor);
			}
			txtCodigoSar.setText(id);
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

	public void ObtenerUltimosDatosSar() {
		conexion objCon = new conexion();
		Connection conn = objCon.getConexion();
		try {
			PreparedStatement stmtr = conn.prepareStatement("SELECT * FROM sar ORDER BY id_sar DESC");
			ResultSet rsr = stmtr.executeQuery();
			if (rsr.next()) {
				r_i = rsr.getString("rango_inicial_sar");
				r_f = rsr.getString("rango_final_sar");
				f_a = rsr.getString("factura_actual_sar");
				a = Integer.parseInt(r_i);
				b = Integer.parseInt(r_f);
				total = b - a;
				c = String.valueOf(total);
				fa = Integer.parseInt(f_a);
				no_util = b - fa;
				no_utilizadas = String.valueOf(no_util);
				util = total - no_util;
				utilizadas = String.valueOf(util);
			}
			txtTotalFacturas.setText(c);
			txtFacturasNoUtilizadas.setText(no_utilizadas);
			txtFacturasUtilizadas.setText(utilizadas);
			;
			stmtr.close();
			rsr.close();
			conn.close();
		} catch (

		Exception e) {
			e.printStackTrace();
		}
	}

	public void obtenerTotalDatosReporte() {
		conexion objCon = new conexion();
		Connection conn = objCon.getConexion();
		try {
			PreparedStatement stmtr = conn.prepareStatement("SELECT * FROM sar ORDER BY id_sar DESC");
			ResultSet rsr = stmtr.executeQuery();
			if (rsr.next()) {
				totalDatos = rsr.getString("id_sar");
			}
			;
			stmtr.close();
			rsr.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void calcularDatosFacturas() {
		double existencia = 0.50 * total;
		double existencia2 = 0.10 * total;

		if (txtTotalFacturas.getText().isEmpty()) {
			txtNota.setText("Agrege un nuevo rango SAR de facturas.");
			txtNota.setForeground(Color.BLUE);
			repaint();
		} else {
			if (no_util <= existencia) {
				txtNota.setText("Hay menos de la mitad de facturas.");
				txtNota.setForeground(Color.ORANGE);
				repaint();
			} else {
				if (no_util >= existencia) {
					txtNota.setText("Hay suficientes Facturas");
					txtNota.setForeground(Color.BLUE);
					repaint();
				} else {
					if (no_util <= existencia2) {
						txtNota.setText("Las Facturas se agotan!");
						txtNota.setForeground(Color.RED);
						repaint();
					} else {
						if (txtFacturasNoUtilizadas.getText().equals("0")) {
							txtNota.setText("No hay facturas!");
							txtNota.setForeground(Color.RED);
							repaint();
						}
					}
				}
			}

		}
	}

}
