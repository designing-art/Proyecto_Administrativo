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
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.MaskFormatter;

import com.placeholder.PlaceHolder;

import conexion.conexion;
import consultas.consultas_inventario;
import controles.control_inventario;
import controles.control_venta;

import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.JTextArea;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import clases.inventario;

import java.awt.SystemColor;

public class registro_ventas extends JFrame {
	public JScrollPane scrollFunciones;
	public PlaceHolder pista;

	public JButton btnGuardar;
	public JButton btnNuevo;
	public JButton btnActualizarDatos;
	public JButton btnBorrar;
	public JButton btnActualizar;
	public JButton btnVer;
	public JButton btnAceptar;
	public static String hora_fecha_reporte;
	public static String nuevaExstencia = null;
	public static int cantidad = 0;
	public static int existencia = 0;

	public static String ruta;
	public static ImageIcon imagen;

	public JPanel contentPane;
	public JTextField txtBusquedaVentas;
	public JScrollPane barraVentas;
	public JTable tablaVentas;
	public JTable tablaInventario;
	public JTextField txtCodigo;

	public static String ruta_logo;
	public static JLabel label;
	public static JLabel label_2;

	public JDateChooser dateRegistro;

	public TableRowSorter<TableModel> trsfiltroCodigo;
	String filtroCodigo;

	public ImageIcon icono = new ImageIcon(getClass().getResource("/iconos/libreta.png"));
	public ImageIcon icono2 = new ImageIcon(getClass().getResource("/iconos/libreta.png"));
	public ImageIcon iconoProducto = new ImageIcon(getClass().getResource("/iconos/usb.png"));
	public JButton btnAtras;
	public JButton button;
	public JTextField txtNombre;
	public JTextField txtPrecioCompra;
	public JTextField txtPeso;
	public JTextField txtColor;
	public JTextField txtMarca;
	public JLabel lblL;
	public JTextField txtModelo;
	public JTextField txtExistencia;
	public JTextArea txtDescripcion;
	public JLabel lblCantidad_1;
	public JTextField txtCantidadVenta;
	public JTextFieldDateEditor editor;
	public JPanel panel;
	public JLabel label_3;
	public JTextField txtBusquedaInventario;
	public JScrollPane barraInventario;
	public JLabel label_4;
	public JButton btnVerder;
	public JLabel label_7;
	public JTextField txtPrecioVenta;
	public JTextField txtCodigoInventario;
	private JLabel lblInventarioDeLa_1;
	private JLabel lblDetalleDeLa;
	private JLabel lblRegistroDeLa;

	public registro_ventas() {
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 550);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/iconos/icono_d_a.jpg")));

		btnAtras = new JButton("Regresar");
		btnAtras.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnAtras.setBackground(new Color(255, 127, 80));
		btnAtras.setBounds(1082, 11, 102, 23);
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

		JLabel lblRegistrarCargo = new JLabel("REGISTRO Y MANTENIMIENTO DE VENTAS DE LA EMPRESA");
		lblRegistrarCargo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblRegistrarCargo.setBounds(10, 6, 693, 29);
		contentPane.add(lblRegistrarCargo);
		scrollFunciones = new JScrollPane();

		JPanel panelRegistro = new JPanel();
		panelRegistro.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		panelRegistro.setBounds(424, 60, 341, 450);
		contentPane.add(panelRegistro);
		panelRegistro.setLayout(null);

		label = new JLabel();
		label.setBounds(265, 48, 49, 44);
		panelRegistro.add(label);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnNuevo.setBounds(24, 394, 99, 23);
		panelRegistro.add(btnNuevo);
		btnNuevo.setBackground(new Color(255, 255, 255));

		btnGuardar = new JButton("Guardar Venta");
		btnGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnGuardar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnGuardar.setBounds(178, 394, 136, 23);
		panelRegistro.add(btnGuardar);
		btnGuardar.setBackground(new Color(60, 179, 113));

		JLabel txt = new JLabel("10. Precio de compra :");
		txt.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txt.setBounds(27, 317, 136, 22);
		panelRegistro.add(txt);

		JLabel lblTipo = new JLabel("2. Nombre :");
		lblTipo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblTipo.setBounds(27, 97, 106, 23);
		panelRegistro.add(lblTipo);

		JLabel lblCodigo = new JLabel("1. Codigo :");
		lblCodigo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblCodigo.setBounds(27, 72, 63, 14);
		panelRegistro.add(lblCodigo);

		JLabel lblRegistroCargos = new JLabel("Datos de la venta :");
		lblRegistroCargos.setBounds(27, 36, 136, 37);
		panelRegistro.add(lblRegistroCargos);
		lblRegistroCargos.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));

		txtCodigo = new JTextField();
		txtCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(136, 69, 43, 23);
		panelRegistro.add(txtCodigo);
		txtCodigo.setColumns(10);

		btnActualizar = new JButton("Actualizar Venta");
		btnActualizar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnActualizar.setBackground(new Color(60, 179, 113));
		btnActualizar.setBounds(178, 371, 136, 23);
		panelRegistro.add(btnActualizar);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnAceptar.setBackground(new Color(255, 255, 255));
		btnAceptar.setBounds(24, 371, 99, 23);
		panelRegistro.add(btnAceptar);

		MaskFormatter formato = null;
		try {
			formato = new MaskFormatter("####-####-#####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);
		txtNombre.setBounds(136, 97, 178, 23);
		panelRegistro.add(txtNombre);
		InputMap map1 = txtNombre.getInputMap(JComponent.WHEN_FOCUSED);
		map1.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtNombre.addKeyListener(new KeyListener() {
			@Override
			// metodo de solo letras y simbolos
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

		txtPrecioCompra = new JTextField();
		txtPrecioCompra.setEditable(false);
		txtPrecioCompra.setHorizontalAlignment(SwingConstants.RIGHT);
		txtPrecioCompra.setColumns(10);
		txtPrecioCompra.setBounds(181, 314, 133, 23);
		panelRegistro.add(txtPrecioCompra);
		InputMap map2 = txtPrecioCompra.getInputMap(JComponent.WHEN_FOCUSED);
		map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtPrecioCompra.addKeyListener(new KeyListener() {
			@Override
			// Metodo que valida el ingreso de solo numeros
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

		JLabel lblCapasidad = new JLabel("3. Descripcion:");
		lblCapasidad.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblCapasidad.setBounds(27, 120, 136, 31);
		panelRegistro.add(lblCapasidad);

		JLabel lblColor = new JLabel("4. Peso :");
		lblColor.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblColor.setBounds(27, 156, 136, 21);
		panelRegistro.add(lblColor);

		txtPeso = new JTextField();
		txtPeso.setEditable(false);
		txtPeso.setColumns(10);
		txtPeso.setBounds(136, 157, 178, 23);
		panelRegistro.add(txtPeso);
		InputMap map3 = txtPeso.getInputMap(JComponent.WHEN_FOCUSED);
		map3.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

		JLabel lblPrecio = new JLabel("5. Color :");
		lblPrecio.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblPrecio.setBounds(27, 182, 136, 23);
		panelRegistro.add(lblPrecio);

		txtColor = new JTextField();
		txtColor.setEditable(false);
		txtColor.setColumns(10);
		txtColor.setBounds(136, 183, 178, 23);
		panelRegistro.add(txtColor);
		InputMap map5 = txtColor.getInputMap(JComponent.WHEN_FOCUSED);
		map5.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

		JLabel lblCantidad = new JLabel("6. Marca :");
		lblCantidad.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblCantidad.setBounds(27, 210, 136, 22);
		panelRegistro.add(lblCantidad);

		txtMarca = new JTextField();
		txtMarca.setEditable(false);
		txtMarca.setColumns(10);
		txtMarca.setBounds(136, 210, 178, 23);
		panelRegistro.add(txtMarca);
		InputMap map51 = txtColor.getInputMap(JComponent.WHEN_FOCUSED);
		map51.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

		lblL = new JLabel("L.");
		lblL.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblL.setBounds(162, 340, 17, 20);
		panelRegistro.add(lblL);

		JLabel lblModelo = new JLabel("7. Modelo :");
		lblModelo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblModelo.setBounds(27, 237, 136, 22);
		panelRegistro.add(lblModelo);

		txtModelo = new JTextField();
		txtModelo.setEditable(false);
		txtModelo.setColumns(10);
		txtModelo.setBounds(136, 237, 178, 23);
		panelRegistro.add(txtModelo);
		InputMap map54 = txtModelo.getInputMap(JComponent.WHEN_FOCUSED);
		map54.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

		JLabel lblExistencia = new JLabel("8. Existencia :");
		lblExistencia.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblExistencia.setBounds(27, 262, 88, 22);
		panelRegistro.add(lblExistencia);

		txtExistencia = new JTextField();
		txtExistencia.setEditable(false);
		txtExistencia.setHorizontalAlignment(SwingConstants.CENTER);
		txtExistencia.setColumns(10);
		txtExistencia.setBounds(136, 263, 178, 22);
		panelRegistro.add(txtExistencia);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(136, 123, 178, 30);
		panelRegistro.add(scrollPane);

		txtDescripcion = new JTextArea();
		txtDescripcion.setBackground(SystemColor.menu);
		txtDescripcion.setEditable(false);
		scrollPane.setViewportView(txtDescripcion);
		InputMap map52 = txtDescripcion.getInputMap(JComponent.WHEN_FOCUSED);
		map52.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

		lblCantidad_1 = new JLabel("9. Cantidad a vender :");
		lblCantidad_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblCantidad_1.setBounds(27, 295, 136, 22);
		panelRegistro.add(lblCantidad_1);

		txtCantidadVenta = new JTextField();
		txtCantidadVenta.setHorizontalAlignment(SwingConstants.CENTER);
		txtCantidadVenta.setColumns(10);
		txtCantidadVenta.setBounds(181, 288, 133, 23);
		panelRegistro.add(txtCantidadVenta);
		InputMap map57 = txtCantidadVenta.getInputMap(JComponent.WHEN_FOCUSED);
		map57.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtCantidadVenta.addKeyListener(new KeyListener() {
			@Override
			// Metodo que valida el ingreso de solo numeros
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

		dateRegistro = new JDateChooser();
		dateRegistro.setBounds(189, 69, 66, 23);
		dateRegistro.setDateFormatString("dd-MMMMM-yyyy");
		panelRegistro.add(dateRegistro);
		editor = (JTextFieldDateEditor) dateRegistro.getDateEditor();
		editor.setEditable(false);
		editor.setHorizontalAlignment(SwingConstants.CENTER);
		dateRegistro.setVisible(false);

		txtPrecioVenta = new JTextField();
		txtPrecioVenta.setHorizontalAlignment(SwingConstants.RIGHT);
		txtPrecioVenta.setColumns(10);
		txtPrecioVenta.setBounds(181, 340, 133, 23);
		panelRegistro.add(txtPrecioVenta);

		JLabel lblPrecioDe = new JLabel("11. Precio de venta :");
		lblPrecioDe.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblPrecioDe.setBounds(27, 339, 136, 22);
		panelRegistro.add(lblPrecioDe);

		JLabel label_1 = new JLabel("L.");
		label_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		label_1.setBounds(162, 318, 17, 20);
		panelRegistro.add(label_1);

		txtCodigoInventario = new JTextField();
		txtCodigoInventario.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigoInventario.setEditable(false);
		txtCodigoInventario.setColumns(10);
		txtCodigoInventario.setBounds(189, 69, 17, 23);
		panelRegistro.add(txtCodigoInventario);
		txtCodigoInventario.setVisible(false);

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
		panelTablaCargos.setBounds(775, 60, 409, 449);
		contentPane.add(panelTablaCargos);

		JLabel lblCargosRegistrados = new JLabel("Registro de ventas :");
		lblCargosRegistrados.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblCargosRegistrados.setBounds(24, 42, 166, 19);
		panelTablaCargos.add(lblCargosRegistrados);

		JLabel lblBuscar = new JLabel("Buscar Venta:");
		lblBuscar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblBuscar.setBounds(24, 64, 119, 22);
		panelTablaCargos.add(lblBuscar);

		txtBusquedaVentas = new JTextField();
		txtBusquedaVentas.setHorizontalAlignment(SwingConstants.CENTER);
		txtBusquedaVentas.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtBusquedaVentas.setColumns(10);
		txtBusquedaVentas.setBounds(156, 65, 175, 21);
		panelTablaCargos.add(txtBusquedaVentas);
		InputMap map6 = txtBusquedaVentas.getInputMap(JComponent.WHEN_FOCUSED);
		map6.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtBusquedaVentas.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				trsfiltroCodigo = new TableRowSorter(tablaVentas.getModel());
				tablaVentas.setRowSorter(trsfiltroCodigo);
			}

			@Override
			public void keyPressed(KeyEvent ke) {

			}

			@Override
			public void keyReleased(KeyEvent ke) {
				String cadena = (txtBusquedaVentas.getText());
				txtBusquedaVentas.setText(cadena);
				repaint();
				filtro();
			}
		});

		btnBorrar = new JButton("Borrar");
		btnBorrar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnBorrar.setBackground(new Color(220, 20, 60));
		btnBorrar.setBounds(24, 398, 99, 23);
		panelTablaCargos.add(btnBorrar);

		barraVentas = new JScrollPane(tablaVentas, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panelTablaCargos.add(barraVentas);
		barraVentas.setBounds(24, 93, 362, 294);

		tablaVentas = new JTable();
		barraVentas.setViewportView(tablaVentas);

		label_2 = new JLabel();
		label_2.setBounds(337, 42, 49, 44);
		panelTablaCargos.add(label_2);

		btnActualizarDatos = new JButton("Actualizar Datos");
		btnActualizarDatos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnActualizarDatos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnActualizarDatos.setBackground(new Color(60, 179, 113));
		btnActualizarDatos.setBounds(249, 398, 137, 23);
		panelTablaCargos.add(btnActualizarDatos);

		btnVer = new JButton("Ver detalles");
		btnVer.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnVer.setBackground(new Color(0, 206, 209));
		btnVer.setBounds(133, 397, 108, 23);
		panelTablaCargos.add(btnVer);

		button = new JButton("Imprimir Reporte");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String fecha = getFechaYHora();
				String nombreEmpresa = ventana_principal.lbl_nombre_empresa_principal.getText();
				String encabezado = "Reporte de inventario de " + nombreEmpresa;
				utilJTablePrint(tablaVentas, encabezado,
						"Pagina {0}" + "                                                  " + fecha, true);
			}
		});
		button.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		button.setBackground(new Color(60, 179, 113));
		button.setBounds(194, 41, 137, 19);
		panelTablaCargos.add(button);

		JLabel label_5 = new JLabel();
		label_5.setBounds(0, 0, 409, 449);
		panelTablaCargos.add(label_5);
		final ImageIcon logo1 = new ImageIcon(
				icono.getImage().getScaledInstance(label_5.getWidth(), label_5.getHeight(), Image.SCALE_DEFAULT));
		label_5.setIcon(logo1);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 60, 404, 449);
		contentPane.add(panel);

		label_3 = new JLabel("Buscar Objeto :");
		label_3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		label_3.setBounds(28, 63, 119, 22);
		panel.add(label_3);

		txtBusquedaInventario = new JTextField();
		txtBusquedaInventario.setHorizontalAlignment(SwingConstants.CENTER);
		txtBusquedaInventario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtBusquedaInventario.setColumns(10);
		txtBusquedaInventario.setBounds(136, 64, 187, 21);
		panel.add(txtBusquedaInventario);

		barraInventario = new JScrollPane(tablaInventario, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		barraInventario.setBounds(28, 90, 350, 304);
		panel.add(barraInventario);

		tablaInventario = new JTable();
		barraInventario.setViewportView(tablaInventario);

		label_4 = new JLabel();
		label_4.setBounds(329, 41, 49, 44);
		panel.add(label_4);

		btnVerder = new JButton("Vender");
		btnVerder.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnVerder.setBackground(new Color(60, 179, 113));
		btnVerder.setBounds(259, 398, 119, 23);
		panel.add(btnVerder);

		JLabel lblInventarioDeLa = new JLabel("Inventario de la empresa.");
		lblInventarioDeLa.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblInventarioDeLa.setBounds(28, 41, 195, 23);
		panel.add(lblInventarioDeLa);

		JButton btnInventario = new JButton("Inventario");
		btnInventario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnInventario.setBackground(new Color(100, 149, 237));
		btnInventario.setBounds(28, 399, 119, 23);
		panel.add(btnInventario);
		btnInventario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				inventario clase = new inventario();
				consultas_inventario consulta = new consultas_inventario();
				registro_inventario formulario = new registro_inventario();
				control_inventario control = new control_inventario(clase, consulta, formulario);
				formulario.setVisible(true);
				formulario.setLocationRelativeTo(null);
				formulario.txtNombre.requestFocusInWindow();
				formulario.obtenerUltimoId();
				formulario.pistas();
				formulario.consultarEmpresa();
				formulario.construirTabla();
				formulario.establecerFechaRegistro();
				formulario.btnGuardar.setVisible(true);
				formulario.btnNuevo.setVisible(true);
				formulario.btnActualizar.setVisible(false);
				formulario.btnAceptar.setVisible(false);
				formulario.btnBorrar.setVisible(false);
				formulario.txtExistencia.setText("0");
				dispose();
			}
		});

		label_7 = new JLabel();
		label_7.setBounds(0, 0, 404, 449);
		panel.add(label_7);
		final ImageIcon logo2 = new ImageIcon(
				icono.getImage().getScaledInstance(label_7.getWidth(), label_7.getHeight(), Image.SCALE_DEFAULT));
		label_7.setIcon(logo2);

		lblInventarioDeLa_1 = new JLabel("1. Inventario de la empresa.");
		lblInventarioDeLa_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblInventarioDeLa_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblInventarioDeLa_1.setBounds(10, 31, 404, 29);
		contentPane.add(lblInventarioDeLa_1);

		lblDetalleDeLa = new JLabel("2. Detalle de la venta.");
		lblDetalleDeLa.setHorizontalAlignment(SwingConstants.CENTER);
		lblDetalleDeLa.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblDetalleDeLa.setBounds(424, 31, 341, 29);
		contentPane.add(lblDetalleDeLa);

		lblRegistroDeLa = new JLabel("3. Registro de la venta.");
		lblRegistroDeLa.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroDeLa.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblRegistroDeLa.setBounds(775, 31, 409, 29);
		contentPane.add(lblRegistroDeLa);

	}

	public void construirTablaInventario() {
		String titulos[] = { "Codigo", "Nombre", "Precio", "Descripcion", "Peso", "Color", "Marca", "Modelo",
				"Cantidad", "Existencia", "Registro" };
		String informacion[][] = control_inventario.obtenerMatriz();
		tablaInventario = new JTable(informacion, titulos);
		barraInventario.setViewportView(tablaInventario);
		for (int c = 0; c < tablaInventario.getColumnCount(); c++) {
			Class<?> col_class = tablaInventario.getColumnClass(c);
			tablaInventario.setDefaultEditor(col_class, null);
			tablaInventario.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			tablaInventario.getTableHeader().setReorderingAllowed(false);

			DefaultTableCellRenderer tcr;
			tcr = new DefaultTableCellRenderer();
			tcr.setHorizontalAlignment(SwingConstants.RIGHT);
			tablaInventario.getColumnModel().getColumn(2).setCellRenderer(tcr);

		}
	}

	public void construirTablaVenta() {
		String titulos[] = { "Codigo", "Nombre", "Descripcion", "Peso", "Color", "Marca", "Modelo", "Cantidad",
				"Existencia", "Precio de compra", "Precio de venta", "Registro" };
		String informacion[][] = control_venta.obtenerMatriz();
		tablaVentas = new JTable(informacion, titulos);
		barraVentas.setViewportView(tablaVentas);
		for (int c = 0; c < tablaVentas.getColumnCount(); c++) {
			Class<?> col_class = tablaVentas.getColumnClass(c);
			tablaVentas.setDefaultEditor(col_class, null);
			tablaVentas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			tablaVentas.getTableHeader().setReorderingAllowed(false);

			DefaultTableCellRenderer tcr;
			tcr = new DefaultTableCellRenderer();
			tcr.setHorizontalAlignment(SwingConstants.RIGHT);
			tablaVentas.getColumnModel().getColumn(9).setCellRenderer(tcr);

			DefaultTableCellRenderer tcr2;
			tcr2 = new DefaultTableCellRenderer();
			tcr2.setHorizontalAlignment(SwingConstants.RIGHT);
			tablaVentas.getColumnModel().getColumn(10).setCellRenderer(tcr2);

		}
	}

	public void filtro() {
		filtroCodigo = txtBusquedaVentas.getText();
		trsfiltroCodigo.setRowFilter(RowFilter.regexFilter(txtBusquedaVentas.getText(), 0, 1, 2, 3, 4, 5, 6));
	}

	public void pistas() {
		pista = new PlaceHolder(txtBusquedaVentas, "Escriba para buscar.");
	}

	public void obtenerUltimoId() {
		String ultimoValor = null;
		int valor;
		String id = null;
		conexion objCon = new conexion();
		Connection conn = objCon.getConexion();
		try {
			PreparedStatement stmtr = conn.prepareStatement("SELECT * FROM ventas ORDER BY id_venta DESC");
			ResultSet rsr = stmtr.executeQuery();
			if (rsr.next()) {
				ultimoValor = rsr.getString("id_venta");
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

				final ImageIcon icono3 = new ImageIcon(logo.getImage().getScaledInstance(label_4.getWidth(),
						label_4.getHeight(), Image.SCALE_DEFAULT));
				label_4.setIcon(icono3);
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

	public void establecerFechaRegistro() {
		try {
			LocalDate fechaActual = LocalDate.now();
			Date date = Date.from(fechaActual.atStartOfDay(ZoneId.systemDefault()).toInstant());
			dateRegistro.setDate(date);
		} catch (Exception e) {

		}

	}

	public void restarVenta() {
		existencia = Integer.parseInt(txtExistencia.getText().toString());
		cantidad = Integer.parseInt(txtCantidadVenta.getText().toString());
		nuevaExstencia = String.valueOf(existencia - cantidad);
		txtExistencia.setText(nuevaExstencia);
	}
}
