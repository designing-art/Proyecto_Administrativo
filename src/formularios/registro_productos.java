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
import javax.swing.JFileChooser;
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
import java.io.File;
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
import javax.swing.border.MatteBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.MaskFormatter;

import com.placeholder.PlaceHolder;

import conexion.conexion;
import controles.control_producto;
import utilidades.visor_imagen;

import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

public class registro_productos extends JFrame {
	public JScrollPane scrollFunciones;
	public PlaceHolder pista;

	public JButton btnGuardar;
	public JButton btnNuevoProducto;
	public JButton btnActualizarDatosProducto;
	public JButton btnBorrarProducto;
	public JButton btnActualizarProducto;
	public JButton btnVerProducto;
	public JButton btnAceptar;
	public static String hora_fecha_reporte;

	public static String nombreEmpresa = null;
	public static String totalDatos = null;

	public static String ruta;
	public static ImageIcon imagen;

	public JPanel contentPane;
	public JTextField txtBusquedaContratosEmpleados;
	public JScrollPane barraProductos;
	public JTable tablaProductos;
	public JTextField txtCodigoProducto;

	public static String ruta_logo;
	public static JLabel label;
	public static JLabel label_2;

	public JDateChooser dateRegistro;
	public JTextFieldDateEditor editor;

	public TableRowSorter<TableModel> trsfiltroCodigo;
	String filtroCodigo;
	public JTextField txtDireccionFotoProducto;
	public JButton btnSubirFotoContrato;
	public JButton btnVerFotoProducto;
	public JLabel lbl_foto_contrato;

	public ImageIcon icono = new ImageIcon(getClass().getResource("/iconos/libreta.png"));
	public ImageIcon icono2 = new ImageIcon(getClass().getResource("/iconos/libreta.png"));
	public ImageIcon iconoProducto = new ImageIcon(getClass().getResource("/iconos/usb.png"));
	public JButton btnAtras;
	public JButton button;
	public JTextField txtDispositivo;
	public JTextField txtMarca;
	public JTextField txtCapasidad;
	public JTextField txtColor;
	public JTextField txtPrecio;
	public JTextField txtCantidad;
	private JLabel lblL;
	private JLabel label_1;
	public JTextField txtTotalExistenciaProductos;
	private JButton button_1;

	public registro_productos() {
		setResizable(false);
		setDefaultCloseOperation(0);
		setBounds(100, 100, 850, 550);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/iconos/icono_d_a.jpg")));

		btnAtras = new JButton("Regresar");
		btnAtras.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnAtras.setBackground(new Color(255, 127, 80));
		btnAtras.setBounds(717, 25, 102, 23);
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

		JLabel lblRegistrarCargo = new JLabel("REGISTRO Y MANTENIMIENTO DE PRODUCTOS");
		lblRegistrarCargo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblRegistrarCargo.setBounds(28, 20, 693, 29);
		contentPane.add(lblRegistrarCargo);
		scrollFunciones = new JScrollPane();

		JPanel panelRegistro = new JPanel();
		panelRegistro.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		panelRegistro.setBounds(28, 60, 341, 450);
		contentPane.add(panelRegistro);
		panelRegistro.setLayout(null);

		label = new JLabel();
		label.setBounds(265, 48, 49, 44);
		panelRegistro.add(label);

		btnNuevoProducto = new JButton("Nuevo");
		btnNuevoProducto.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnNuevoProducto.setBounds(27, 393, 99, 23);
		panelRegistro.add(btnNuevoProducto);
		btnNuevoProducto.setBackground(new Color(255, 255, 255));

		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnGuardar.setBounds(218, 393, 99, 23);
		panelRegistro.add(btnGuardar);
		btnGuardar.setBackground(new Color(60, 179, 113));

		JLabel lblNombreCargo = new JLabel("3. Marca :");
		lblNombreCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblNombreCargo.setBounds(27, 143, 136, 14);
		panelRegistro.add(lblNombreCargo);

		JLabel lblTipo = new JLabel("2. Producto :");
		lblTipo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblTipo.setBounds(27, 109, 158, 23);
		panelRegistro.add(lblTipo);

		JLabel lblCodigo = new JLabel("1. Codigo :");
		lblCodigo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblCodigo.setBounds(27, 84, 63, 14);
		panelRegistro.add(lblCodigo);

		JLabel lblRegistroCargos = new JLabel("Datos del registro :");
		lblRegistroCargos.setBounds(27, 48, 136, 23);
		panelRegistro.add(lblRegistroCargos);
		lblRegistroCargos.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));

		txtCodigoProducto = new JTextField();
		txtCodigoProducto.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigoProducto.setEditable(false);
		txtCodigoProducto.setBounds(173, 81, 43, 23);
		panelRegistro.add(txtCodigoProducto);
		txtCodigoProducto.setColumns(10);

		btnActualizarProducto = new JButton("Actualizar");
		btnActualizarProducto.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnActualizarProducto.setBackground(new Color(60, 179, 113));
		btnActualizarProducto.setBounds(218, 370, 99, 23);
		panelRegistro.add(btnActualizarProducto);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnAceptar.setBackground(new Color(255, 255, 255));
		btnAceptar.setBounds(27, 370, 99, 23);
		panelRegistro.add(btnAceptar);

		lbl_foto_contrato = new JLabel();
		lbl_foto_contrato.setBounds(218, 286, 96, 73);
		panelRegistro.add(lbl_foto_contrato);
		final ImageIcon iconofoto = new ImageIcon(iconoProducto.getImage()
				.getScaledInstance(lbl_foto_contrato.getWidth(), lbl_foto_contrato.getHeight(), Image.SCALE_DEFAULT));
		lbl_foto_contrato.setIcon(iconofoto);

		JLabel lblFoto = new JLabel("8. Foto del producto :");
		lblFoto.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblFoto.setBounds(27, 287, 136, 17);
		panelRegistro.add(lblFoto);

		btnSubirFotoContrato = new JButton("Subir");
		btnSubirFotoContrato.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				selecionarFoto();
			}
		});
		btnSubirFotoContrato.setBackground(new Color(250, 128, 114));
		btnSubirFotoContrato.setBounds(27, 305, 70, 23);
		panelRegistro.add(btnSubirFotoContrato);

		txtDireccionFotoProducto = new JTextField();
		txtDireccionFotoProducto.setText("Sin fotografia.");
		txtDireccionFotoProducto.setEditable(false);
		txtDireccionFotoProducto.setColumns(10);
		txtDireccionFotoProducto.setBounds(27, 339, 145, 20);
		panelRegistro.add(txtDireccionFotoProducto);

		btnVerFotoProducto = new JButton("Ver");
		btnVerFotoProducto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				verFotoContratoEmpleado();
			}
		});
		btnVerFotoProducto.setBackground(Color.WHITE);
		btnVerFotoProducto.setBounds(102, 305, 70, 23);
		panelRegistro.add(btnVerFotoProducto);

		MaskFormatter formato = null;
		try {
			formato = new MaskFormatter("####-####-#####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		txtDispositivo = new JTextField();
		txtDispositivo.setColumns(10);
		txtDispositivo.setBounds(173, 111, 141, 23);
		panelRegistro.add(txtDispositivo);
		InputMap map1 = txtDispositivo.getInputMap(JComponent.WHEN_FOCUSED);
		map1.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtDispositivo.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				
				if (txtDispositivo.getText().length() == 20)
					ke.consume();
			}

			@Override
			public void keyPressed(KeyEvent ke) {
			}

			@Override
			public void keyReleased(KeyEvent ke) {
			}
		});

		txtMarca = new JTextField();
		txtMarca.setColumns(10);
		txtMarca.setBounds(173, 140, 141, 23);
		panelRegistro.add(txtMarca);
		InputMap map2 = txtMarca.getInputMap(JComponent.WHEN_FOCUSED);
		map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtMarca.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				
				if (txtMarca.getText().length() == 20)
					ke.consume();
			}

			@Override
			public void keyPressed(KeyEvent ke) {
			}

			@Override
			public void keyReleased(KeyEvent ke) {
			}
		});

		txtCapasidad = new JTextField();
		txtCapasidad.setColumns(10);
		txtCapasidad.setBounds(173, 167, 141, 23);
		panelRegistro.add(txtCapasidad);
		InputMap map4 = txtCapasidad.getInputMap(JComponent.WHEN_FOCUSED);
		map4.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtCapasidad.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				
				if (txtCapasidad.getText().length() == 20)
					ke.consume();
			}

			@Override
			public void keyPressed(KeyEvent ke) {
			}

			@Override
			public void keyReleased(KeyEvent ke) {
			}
		});

		JLabel lblCapasidad = new JLabel("4. Capacidad :");
		lblCapasidad.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblCapasidad.setBounds(27, 168, 136, 22);
		panelRegistro.add(lblCapasidad);

		JLabel lblColor = new JLabel("5. Color :");
		lblColor.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblColor.setBounds(27, 195, 136, 22);
		panelRegistro.add(lblColor);

		txtColor = new JTextField();
		txtColor.setColumns(10);
		txtColor.setBounds(173, 194, 141, 23);
		panelRegistro.add(txtColor);
		InputMap map3 = txtColor.getInputMap(JComponent.WHEN_FOCUSED);
		map3.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtCapasidad.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				
				if (txtCapasidad.getText().length() == 20)
					ke.consume();
			}

			@Override
			public void keyPressed(KeyEvent ke) {
			}

			@Override
			public void keyReleased(KeyEvent ke) {
			}
		});

		JLabel lblPrecio = new JLabel("6. Precio :");
		lblPrecio.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblPrecio.setBounds(27, 225, 136, 22);
		panelRegistro.add(lblPrecio);

		txtPrecio = new JTextField();
		txtPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(173, 224, 141, 23);
		panelRegistro.add(txtPrecio);
		InputMap map5 = txtPrecio.getInputMap(JComponent.WHEN_FOCUSED);
		map5.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtPrecio.addKeyListener(new KeyListener() {
			@Override
			// Metodo que valida el ingreso de solo numeros
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();
				if ((c < '0' || c > '9'))
					ke.consume();
				if (txtPrecio.getText().length() == 8)
					ke.consume();
			}

			@Override
			public void keyPressed(KeyEvent ke) {
			}

			@Override
			public void keyReleased(KeyEvent ke) {
			}
		});

		JLabel lblCantidad = new JLabel("7. Cantidad :");
		lblCantidad.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblCantidad.setBounds(27, 253, 136, 22);
		panelRegistro.add(lblCantidad);

		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(173, 252, 141, 23);
		panelRegistro.add(txtCantidad);
		InputMap map51 = txtPrecio.getInputMap(JComponent.WHEN_FOCUSED);
		map51.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtCantidad.addKeyListener(new KeyListener() {
			@Override
			// Metodo que valida el ingreso de solo numeros
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();
				if ((c < '0' || c > '9'))
					ke.consume();
				if (txtPrecio.getText().length() == 8)
					ke.consume();
			}

			@Override
			public void keyPressed(KeyEvent ke) {
			}

			@Override
			public void keyReleased(KeyEvent ke) {
			}
		});

		lblL = new JLabel("L.");
		lblL.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblL.setBounds(155, 230, 17, 14);
		panelRegistro.add(lblL);

		dateRegistro = new JDateChooser();
		dateRegistro.setBounds(219, 84, 95, 20);
		dateRegistro.setDateFormatString("dd-MMMMM-yyyy");
		panelRegistro.add(dateRegistro);
		editor = (JTextFieldDateEditor) dateRegistro.getDateEditor();
		editor.setEditable(false);
		editor.setHorizontalAlignment(SwingConstants.CENTER);
		dateRegistro.setVisible(false);

		JLabel lblLibreta = new JLabel();
		lblLibreta.setBounds(0, 0, 341, 450);
		panelRegistro.add(lblLibreta);
		final ImageIcon logo = new ImageIcon(
				icono.getImage().getScaledInstance(lblLibreta.getWidth(), lblLibreta.getHeight(), Image.SCALE_DEFAULT));
		lblLibreta.setIcon(logo);

		JPanel panelTablaCargos = new JPanel();
		panelTablaCargos.setLayout(null);
		panelTablaCargos.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		panelTablaCargos.setBackground(Color.WHITE);
		panelTablaCargos.setBounds(388, 61, 431, 449);
		contentPane.add(panelTablaCargos);

		JLabel lblCargosRegistrados = new JLabel("Productos registrados :");
		lblCargosRegistrados.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblCargosRegistrados.setBounds(30, 41, 166, 19);
		panelTablaCargos.add(lblCargosRegistrados);

		JLabel lblBuscarContrato = new JLabel("Buscar Producto :");
		lblBuscarContrato.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblBuscarContrato.setBounds(30, 63, 119, 22);
		panelTablaCargos.add(lblBuscarContrato);

		txtBusquedaContratosEmpleados = new JTextField();
		txtBusquedaContratosEmpleados.setHorizontalAlignment(SwingConstants.CENTER);
		txtBusquedaContratosEmpleados.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtBusquedaContratosEmpleados.setColumns(10);
		txtBusquedaContratosEmpleados.setBounds(138, 64, 209, 21);
		panelTablaCargos.add(txtBusquedaContratosEmpleados);
		InputMap map6 = txtBusquedaContratosEmpleados.getInputMap(JComponent.WHEN_FOCUSED);
		map6.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtBusquedaContratosEmpleados.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				trsfiltroCodigo = new TableRowSorter(tablaProductos.getModel());
				tablaProductos.setRowSorter(trsfiltroCodigo);
			}

			@Override
			public void keyPressed(KeyEvent ke) {

			}

			@Override
			public void keyReleased(KeyEvent ke) {
				String cadena = (txtBusquedaContratosEmpleados.getText());
				txtBusquedaContratosEmpleados.setText(cadena);
				repaint();
				filtro();
			}
		});

		btnBorrarProducto = new JButton("Borrar");
		btnBorrarProducto.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnBorrarProducto.setBackground(new Color(220, 20, 60));
		btnBorrarProducto.setBounds(30, 395, 99, 23);
		panelTablaCargos.add(btnBorrarProducto);

		barraProductos = new JScrollPane(tablaProductos, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panelTablaCargos.add(barraProductos);
		barraProductos.setBounds(28, 90, 376, 262);

		tablaProductos = new JTable();
		barraProductos.setViewportView(tablaProductos);

		label_2 = new JLabel();
		label_2.setBounds(355, 41, 49, 44);
		panelTablaCargos.add(label_2);

		btnActualizarDatosProducto = new JButton("Actualizar Datos");
		btnActualizarDatosProducto.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnActualizarDatosProducto.setBackground(new Color(60, 179, 113));
		btnActualizarDatosProducto.setBounds(267, 396, 137, 23);
		panelTablaCargos.add(btnActualizarDatosProducto);

		btnVerProducto = new JButton("Ver detalles");
		btnVerProducto.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnVerProducto.setBackground(new Color(0, 206, 209));
		btnVerProducto.setBounds(149, 395, 108, 23);
		panelTablaCargos.add(btnVerProducto);

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

					String encabezado = "Reporte de productos de " + login_usuario.nombre.toString();

					utilJTablePrint(tablaProductos, encabezado,
							"Pagina {0} de " + i + "                                  " + fecha, true);
				}
			}
		});
		button.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		button.setBackground(new Color(60, 179, 113));
		button.setBounds(210, 40, 137, 19);
		panelTablaCargos.add(button);

		label_1 = new JLabel("Total Existencia :");
		label_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		label_1.setBounds(30, 365, 150, 14);
		panelTablaCargos.add(label_1);

		txtTotalExistenciaProductos = new JTextField();
		txtTotalExistenciaProductos.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalExistenciaProductos.setEditable(false);
		txtTotalExistenciaProductos.setColumns(10);
		txtTotalExistenciaProductos.setBounds(162, 363, 132, 20);
		panelTablaCargos.add(txtTotalExistenciaProductos);

		button_1 = new JButton("Obtener");
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (txtBusquedaContratosEmpleados.equals("")) {
					JOptionPane.showMessageDialog(null, "Debe buscar el producto para conocer su existencia total.");
				} else {
					totalizarExistencia();
				}
			}
		});
		button_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 10));
		button_1.setBackground(new Color(60, 179, 113));
		button_1.setBounds(305, 363, 99, 21);
		panelTablaCargos.add(button_1);

		JLabel label_5 = new JLabel();
		label_5.setBounds(0, 0, 431, 449);
		panelTablaCargos.add(label_5);
		final ImageIcon logo1 = new ImageIcon(
				icono.getImage().getScaledInstance(label_5.getWidth(), label_5.getHeight(), Image.SCALE_DEFAULT));
		label_5.setIcon(logo1);
		map4.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

	}

	public void construirTabla() {
		String titulos[] = { "Codigo", "Producto", "Marca", "Capacidad", "Color", "Precio", "Foto", "Cantidad",
				"Existencia", "Registrado" };
		String informacion[][] = control_producto.obtenerMatriz();
		tablaProductos = new JTable(informacion, titulos);
		barraProductos.setViewportView(tablaProductos);
		for (int c = 0; c < tablaProductos.getColumnCount(); c++) {
			Class<?> col_class = tablaProductos.getColumnClass(c);
			tablaProductos.setDefaultEditor(col_class, null);
			tablaProductos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			tablaProductos.getTableHeader().setReorderingAllowed(false);

			DefaultTableCellRenderer tcr;
			tcr = new DefaultTableCellRenderer();
			tcr.setHorizontalAlignment(SwingConstants.RIGHT);
			tablaProductos.getColumnModel().getColumn(5).setCellRenderer(tcr);

			DefaultTableCellRenderer tcr2;
			tcr2 = new DefaultTableCellRenderer();
			tcr2.setHorizontalAlignment(SwingConstants.CENTER);
			tablaProductos.getColumnModel().getColumn(7).setCellRenderer(tcr2);

			DefaultTableCellRenderer tcr3;
			tcr3 = new DefaultTableCellRenderer();
			tcr3.setHorizontalAlignment(SwingConstants.CENTER);
			tablaProductos.getColumnModel().getColumn(8).setCellRenderer(tcr2);

		}
	}

	public void filtro() {
		filtroCodigo = txtBusquedaContratosEmpleados.getText();
		trsfiltroCodigo
				.setRowFilter(RowFilter.regexFilter(txtBusquedaContratosEmpleados.getText(), 0, 1, 2, 3, 4, 5, 6));
	}

	public void pistas() {
		pista = new PlaceHolder(txtBusquedaContratosEmpleados, "Escriba para buscar.");
	}

	public void selecionarFoto() {
		JFileChooser archivo = new JFileChooser();
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Formatos de Archivos JPEG(*.JPG;*.JPEG)", "jpg",
				"jpeg");
		archivo.addChoosableFileFilter(filtro);
		archivo.setDialogTitle("Abrir Archivo");
		File ruta = new File("\\\\"+conexion.urlGlobal+"\\Sistema Administrativo\\Productos");
		archivo.setCurrentDirectory(ruta);
		int ventana = archivo.showOpenDialog(null);
		if (ventana == JFileChooser.APPROVE_OPTION) {
			File file = archivo.getSelectedFile();
			txtDireccionFotoProducto.setText(String.valueOf(file));
			Image foto = getToolkit().getImage(txtDireccionFotoProducto.getText());
			foto = foto.getScaledInstance(lbl_foto_contrato.getHeight(), lbl_foto_contrato.getWidth(),
					Image.SCALE_DEFAULT);
			lbl_foto_contrato.setIcon(new ImageIcon(foto));
		}
	}

	public void obtenerUltimoId() {
		String ultimoValor = null;
		int valor;
		String id = null;
		conexion objCon = new conexion();
		Connection conn = objCon.getConexion();
		try {
			PreparedStatement stmtr = conn.prepareStatement("SELECT * FROM productos ORDER BY id_producto DESC");
			ResultSet rsr = stmtr.executeQuery();
			if (rsr.next()) {
				ultimoValor = rsr.getString("id_producto");
				valor = Integer.parseInt(ultimoValor);
				valor = valor + 1;
				id = String.valueOf(valor);
			}
			txtCodigoProducto.setText(id);
			;
			stmtr.close();
			rsr.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verFotoContratoEmpleado() {
		if (txtDireccionFotoProducto.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hay imagen que mostrar");
		} else {
			visor_imagen visor = new visor_imagen();
			ruta = txtDireccionFotoProducto.getText().toString();
			visor.txtRutaImagen.setText(ruta);
			visor.setVisible(true);
			visor.setLocationRelativeTo(null);
			imagen = new ImageIcon(ruta);
			visor_imagen.lblImagen.setIcon(imagen);
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

	public void totalizarExistencia() {
		int t = 0;
		int p = 0;
		if (tablaProductos.getRowCount() > 0) {
			for (int i = 0; i < tablaProductos.getRowCount(); i++) {
				p = Integer.parseInt(tablaProductos.getValueAt(i, 8).toString());
				t += p;
			}
			txtTotalExistenciaProductos.setText(String.valueOf(t));
		} else {
			JOptionPane.showMessageDialog(null, "No hay datos que totalizar");
		}
	}

	public void establecerFechaRegistro() {
		try {
			LocalDate fechaActual = LocalDate.now();
			Date date = Date.from(fechaActual.atStartOfDay(ZoneId.systemDefault()).toInstant());
			dateRegistro.setDate(date);
		} catch (Exception e) {

		}

	}
	

	public void obtenerTotalDatosReporte() {
		conexion objCon = new conexion();
		Connection conn = objCon.getConexion();
		try {
			PreparedStatement stmtr = conn.prepareStatement("SELECT * FROM productos ORDER BY id_producto DESC");
			ResultSet rsr = stmtr.executeQuery();
			if (rsr.next()) {
				totalDatos = rsr.getString("id_producto");
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
