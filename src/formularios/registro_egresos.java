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
import controles.control_egresos;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

public class registro_egresos extends JFrame {
	public JScrollPane scrollFunciones;
	public PlaceHolder pista;
	public JButton btnAtras;
	public JButton btnMostrar;
	public JButton btnAceptar;
	public JButton btnNuevo;
	public JButton btnGuardar;
	public JButton btnActualizar;
	public JButton btnBorrar;
	public JButton btnActualizarDatos;

	public static String nombreEmpresa = null;
	public static String totalDatos = null;

	public int pagina = 0;

	public JPanel contentPane;
	public JTextField txtBusquedaCargos;
	public JScrollPane barraSar;
	public JTable tabla;
	public JTextField txtCodigo;

	public TableRowSorter trsfiltroCodigo;
	String filtroCodigo;
	public static String hora_fecha_reporte;
	public static String ruta_logo;

	public static JLabel label;
	public static JLabel label_2;
	public JTextFieldDateEditor editor;
	public JDateChooser dateFechaLimite;
	public JTextField txtEgreso;
	public JTextField txtCantidad;
	public JTextArea txtDescripcion;
	public JTextField txtTotalIngresos;

	public registro_egresos() {
		setResizable(false);
		setDefaultCloseOperation(0);
		setBounds(100, 100, 850, 581);
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
				principal.setTitle("Sesión iniciada por: "+login_usuario.nombreCompletoUsuario);
				
				dispose();
			}
		});

		JLabel lblRegistrarCargo = new JLabel("INFORMACION DE LOS EGRESOS DE LA EMPRESA.");
		lblRegistrarCargo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblRegistrarCargo.setBounds(37, 0, 639, 39);
		contentPane.add(lblRegistrarCargo);
		scrollFunciones = new JScrollPane();

		JPanel panelTablaCargos = new JPanel();
		panelTablaCargos.setLayout(null);
		panelTablaCargos.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		panelTablaCargos.setBackground(Color.WHITE);
		panelTablaCargos.setBounds(388, 44, 431, 497);
		contentPane.add(panelTablaCargos);

		JLabel lblCargosRegistrados = new JLabel("Registros de egresos :");
		lblCargosRegistrados.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblCargosRegistrados.setBounds(30, 41, 166, 19);
		panelTablaCargos.add(lblCargosRegistrados);

		JLabel lblBuscarRegistroDe = new JLabel("Buscar  egresos :");
		lblBuscarRegistroDe.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblBuscarRegistroDe.setBounds(30, 63, 166, 22);
		panelTablaCargos.add(lblBuscarRegistroDe);

		txtBusquedaCargos = new JTextField();
		txtBusquedaCargos.setHorizontalAlignment(SwingConstants.CENTER);
		txtBusquedaCargos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtBusquedaCargos.setColumns(10);
		txtBusquedaCargos.setBounds(152, 64, 195, 21);
		panelTablaCargos.add(txtBusquedaCargos);
		InputMap map4 = txtBusquedaCargos.getInputMap(JComponent.WHEN_FOCUSED);
		txtBusquedaCargos.addKeyListener(new KeyListener() {
			@Override
			// metodo para buscar en la tabla
			public void keyTyped(KeyEvent ke) {
				trsfiltroCodigo = new TableRowSorter(tabla.getModel());
				tabla.setRowSorter(trsfiltroCodigo);
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

		barraSar = new JScrollPane(tabla, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panelTablaCargos.add(barraSar);
		barraSar.setBounds(28, 90, 376, 314);

		tabla = new JTable();
		barraSar.setViewportView(tabla);

		label_2 = new JLabel();
		label_2.setBounds(355, 41, 49, 44);
		panelTablaCargos.add(label_2);

		btnMostrar = new JButton("Ver detalles");
		btnMostrar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnMostrar.setBackground(new Color(0, 206, 209));
		btnMostrar.setBounds(152, 445, 108, 23);
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

					String encabezado = "Reporte de egresos de " + login_usuario.nombre.toString();

					utilJTablePrint(tabla, encabezado,
							"Pagina {0} de " + i + "                                  " + fecha, true);
				}
			}
		});
		btnImprimirReporte.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnImprimirReporte.setBackground(new Color(60, 179, 113));
		btnImprimirReporte.setBounds(204, 44, 143, 15);
		panelTablaCargos.add(btnImprimirReporte);

		JLabel lblTotalIngresos = new JLabel("Total  egresos :");
		lblTotalIngresos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblTotalIngresos.setBounds(30, 419, 166, 15);
		panelTablaCargos.add(lblTotalIngresos);

		txtTotalIngresos = new JTextField();
		txtTotalIngresos.setEditable(false);
		txtTotalIngresos.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTotalIngresos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtTotalIngresos.setColumns(10);
		txtTotalIngresos.setBounds(152, 415, 108, 21);
		panelTablaCargos.add(txtTotalIngresos);

		JButton btnObtener = new JButton("Obtener");
		btnObtener.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				totalizar();
			}
		});
		btnObtener.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnObtener.setBackground(new Color(60, 179, 113));
		btnObtener.setBounds(270, 415, 108, 22);
		panelTablaCargos.add(btnObtener);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnBorrar.setBackground(new Color(220, 20, 60));
		btnBorrar.setBounds(30, 445, 99, 23);
		panelTablaCargos.add(btnBorrar);

		btnActualizarDatos = new JButton("Actualizar Datos");
		btnActualizarDatos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnActualizarDatos.setBackground(new Color(60, 179, 113));
		btnActualizarDatos.setBounds(270, 446, 134, 23);
		panelTablaCargos.add(btnActualizarDatos);

		JLabel label_1 = new JLabel("L.");
		label_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		label_1.setBounds(134, 415, 63, 24);
		panelTablaCargos.add(label_1);

		JLabel label_5 = new JLabel();
		label_5.setBounds(0, 0, 431, 497);
		panelTablaCargos.add(label_5);
		final ImageIcon logo1 = new ImageIcon(
				icono.getImage().getScaledInstance(label_5.getWidth(), label_5.getHeight(), Image.SCALE_DEFAULT));
		label_5.setIcon(logo1);

		JPanel panelRegistro = new JPanel();
		panelRegistro.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		panelRegistro.setBounds(37, 130, 341, 325);
		contentPane.add(panelRegistro);
		panelRegistro.setLayout(null);

		label = new JLabel();
		label.setBounds(265, 29, 49, 44);
		panelRegistro.add(label);

		JLabel lblHoraExtraCargo = new JLabel("5. Fecha de registro :");
		lblHoraExtraCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblHoraExtraCargo.setBounds(24, 200, 196, 20);
		panelRegistro.add(lblHoraExtraCargo);

		JLabel lblTipoDeCargo = new JLabel("2. Egreso por :");
		lblTipoDeCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblTipoDeCargo.setBounds(24, 84, 105, 18);
		panelRegistro.add(lblTipoDeCargo);

		JLabel lblCodigoCargo = new JLabel("1. C\u00F3digo :");
		lblCodigoCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblCodigoCargo.setBounds(24, 59, 63, 14);
		panelRegistro.add(lblCodigoCargo);

		JLabel lblRegistroCargos = new JLabel("Datos del registro del egresos :");
		lblRegistroCargos.setBounds(24, 23, 254, 32);
		panelRegistro.add(lblRegistroCargos);
		lblRegistroCargos.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));

		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(137, 55, 43, 18);
		panelRegistro.add(txtCodigo);
		txtCodigo.setColumns(10);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnAceptar.setBackground(new Color(255, 255, 255));
		btnAceptar.setBounds(24, 247, 99, 23);
		panelRegistro.add(btnAceptar);

		MaskFormatter formato = null;
		try {
			formato = new MaskFormatter("#???#?-?###?#-#?##?#-####?#-#??###-#?");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		dateFechaLimite = new JDateChooser();
		dateFechaLimite.setBounds(159, 200, 155, 20);
		dateFechaLimite.setDateFormatString("dd-MMMMM-yyyy");
		panelRegistro.add(dateFechaLimite);
		editor = (JTextFieldDateEditor) dateFechaLimite.getDateEditor();
		editor.setEditable(false);
		editor.setHorizontalAlignment(SwingConstants.CENTER);

		MaskFormatter formato2 = null;
		try {
			formato2 = new MaskFormatter("###");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

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

		MaskFormatter formato7 = null;
		try {
			formato7 = new MaskFormatter("###-###-##");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		txtEgreso = new JTextField();
		txtEgreso.setHorizontalAlignment(SwingConstants.CENTER);
		txtEgreso.setColumns(10);
		txtEgreso.setBounds(137, 84, 177, 19);
		panelRegistro.add(txtEgreso);
		InputMap map22 = txtEgreso.getInputMap(JComponent.WHEN_FOCUSED);
		map22.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtEgreso.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				if (txtEgreso.getText().length() == 50)
					ke.consume();
			}

			@Override
			public void keyPressed(KeyEvent ke) {
			}

			@Override
			public void keyReleased(KeyEvent ke) {
			}
		});

		JLabel lblCantidad = new JLabel("3. Cantidad :");
		lblCantidad.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblCantidad.setBounds(24, 113, 105, 18);
		panelRegistro.add(lblCantidad);

		txtCantidad = new JTextField();
		txtCantidad.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(215, 113, 99, 19);
		panelRegistro.add(txtCantidad);
		InputMap map21 = txtCantidad.getInputMap(JComponent.WHEN_FOCUSED);
		map21.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtCantidad.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();
				if ((c < '0' || c > '9'))
					ke.consume();
				if (txtCantidad.getText().length() == 8)
					ke.consume();
			}

			@Override
			public void keyPressed(KeyEvent ke) {
			}

			@Override
			public void keyReleased(KeyEvent ke) {
			}
		});

		JLabel lblDescripcion = new JLabel("4. Descripcion :");
		lblDescripcion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblDescripcion.setBounds(24, 142, 105, 18);
		panelRegistro.add(lblDescripcion);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(137, 143, 177, 44);
		panelRegistro.add(scrollPane);

		txtDescripcion = new JTextArea();
		scrollPane.setViewportView(txtDescripcion);
		InputMap map90 = txtDescripcion.getInputMap(JComponent.WHEN_FOCUSED);
		map90.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtDescripcion.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				if (txtDescripcion.getText().length() == 100) {
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
		            String str = txtDescripcion.getText().trim();
		            txtDescripcion.setText(str);
		        }
			}
		});

		btnNuevo = new JButton("Nuevo");
		btnNuevo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnNuevo.setBackground(Color.WHITE);
		btnNuevo.setBounds(24, 274, 99, 23);
		panelRegistro.add(btnNuevo);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnActualizar.setBackground(new Color(60, 179, 113));
		btnActualizar.setBounds(215, 247, 99, 23);
		panelRegistro.add(btnActualizar);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnGuardar.setBackground(new Color(60, 179, 113));
		btnGuardar.setBounds(215, 274, 99, 23);
		panelRegistro.add(btnGuardar);

		JLabel lblL = new JLabel("L.");
		lblL.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblL.setBounds(189, 114, 63, 18);
		panelRegistro.add(lblL);

		JLabel lblImagenLibreta = new JLabel();
		lblImagenLibreta.setBounds(0, 0, 341, 325);
		panelRegistro.add(lblImagenLibreta);
		final ImageIcon logo = new ImageIcon(icono.getImage().getScaledInstance(lblImagenLibreta.getWidth(),
				lblImagenLibreta.getHeight(), Image.SCALE_DEFAULT));
		lblImagenLibreta.setIcon(logo);

		map4.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

	}

	public void construirTabla() {
		String titulos[] = { "Codigo", "Egreso por", "Cantidad", "Descripcion", "Fecha" };
		String informacion[][] = control_egresos.obtenerMatriz2();
		tabla = new JTable(informacion, titulos);
		barraSar.setViewportView(tabla);
		for (int c = 0; c < tabla.getColumnCount(); c++) {
			Class<?> col_class = tabla.getColumnClass(c);
			tabla.setDefaultEditor(col_class, null);
			tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			tabla.getTableHeader().setReorderingAllowed(false);
		}
	}

	public void filtro() {
		filtroCodigo = txtBusquedaCargos.getText();
		trsfiltroCodigo.setRowFilter(RowFilter.regexFilter(txtBusquedaCargos.getText(), 0, 1, 2, 3, 4, 5));
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
		SimpleDateFormat df = new SimpleDateFormat("'Dia' EEEEEEEEE dd 'de' MMMMM 'del' yyyy 'a las' HH:mm:ss ");
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

	public void obtenerUltimoId() {
		String ultimoValor = null;
		int valor;
		String id = null;
		conexion objCon = new conexion();
		Connection conn = objCon.getConexion();
		try {
			PreparedStatement stmtr = conn.prepareStatement("SELECT * FROM egresos ORDER BY id_egreso DESC");
			ResultSet rsr = stmtr.executeQuery();
			if (rsr.next()) {
				ultimoValor = rsr.getString("id_egreso");
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
		if (tabla.getRowCount() > 0) {
			for (int i = 0; i < tabla.getRowCount(); i++) {
				p = Double.parseDouble(tabla.getValueAt(i, 2).toString());
				t += p;
			}
			txtTotalIngresos.setText(String.valueOf(t));
		} else {
			JOptionPane.showMessageDialog(null, "No hay datos que totalizar");
		}
	}
	
	public void obtenerTotalDatosReporte() {
		conexion objCon = new conexion();
		Connection conn = objCon.getConexion();
		try {
			PreparedStatement stmtr = conn.prepareStatement("SELECT * FROM egresos ORDER BY id_egreso DESC");
			ResultSet rsr = stmtr.executeQuery();
			if (rsr.next()) {
				totalDatos = rsr.getString("id_egreso");
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
