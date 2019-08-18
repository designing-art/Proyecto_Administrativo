package formularios;

import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
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
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.MaskFormatter;

import com.placeholder.PlaceHolder;

import conexion.conexion;
import consultas.consultas_cliente;
import controles.control_cliente;
import controles.control_factura_cliente;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import com.toedter.calendar.JTextFieldDateEditor;

import clases.cliente;

public class registro_facturas_clientes extends JFrame implements Printable {
	public JScrollPane scrollFunciones;
	public PlaceHolder pista;
	public JPanel panelRegistro;
	public JLabel lblLibreta;
	public JButton btnFactura;
	public static JLabel label_3;

	public JButton btnGuardar;
	public JButton btnNuevo;
	public JButton btnActualizarDatos;
	public JButton btnBorrar;
	public JButton btnActualizar;
	public JButton btnVer;
	public JButton btnAceptar;
	public static String hora_fecha_reporte;

	public static String nombreEmpresa = null;
	public static String totalDatos = null;

	public static String nombre;
	public static String direccion;
	public static String correo;
	public static String telefono;
	public static String rtn;

	public static String ruta;
	public static ImageIcon imagen;

	public JPanel contentPane;
	public JTextField txtBusqueda;
	public JScrollPane barra;
	public JTable tabla;

	public JScrollPane barraCliente;
	public JTable tablaCliente;

	public static String ruta_logo;
	public static JLabel label;
	public static JLabel label_2;

	public TableRowSorter<TableModel> trsfiltroCodigo;
	String filtroCodigo;

	public TableRowSorter<TableModel> trsfiltroCodigoCliente;
	String filtroCodigoCliente;

	public ImageIcon icono = new ImageIcon(getClass().getResource("/iconos/libreta.png"));
	public ImageIcon icono2 = new ImageIcon(getClass().getResource("/iconos/libreta.png"));
	public ImageIcon iconoProducto = new ImageIcon(getClass().getResource("/iconos/usb.png"));
	public JButton btnAtras;
	public JButton button;
	public JTextFieldDateEditor editor;
	public JLabel lblNDeFactura;
	public JLabel lblFecha;
	public JTextField txtNumeroFactura;
	public static JTextField txtFechaHoraFactura;
	public JLabel lblCai;
	public JLabel lblCliente;
	public JTextField txtCliente;
	public JFormattedTextField txtRTN;
	public JTextField txtDireccion;
	public JLabel lblRtn;
	public JLabel lblDireccion_1;
	public JTextField txtCodigo;
	public JTextField txtEmpleado;
	public JLabel lblFacturasPermitidas;
	public JTextField txtRI;
	public JLabel lblHasta;
	public JTextField txtRF;
	public JLabel lblPorConceptoDe;
	public JTextField txtCantidadLetras;
	public JTextField txtCantidadNumeros;
	public JLabel lblLaFacturaEs;
	public JLabel lblDe;
	public JTextArea txtPorConceptoDe;
	public static JLabel lblNombreEmpresa;
	public static JLabel lblDireccion;
	public static JLabel lblCorreo;
	public static JLabel lblTelefono_1;
	public static JLabel lblRtnEmpresa;

	public static String factura = null;
	public static String nuevaFactura = null;
	public static int cantidad = 0;
	public static int nuevaCantidad = 0;
	public JTextField txtNuevaFactura;
	public JTextField txtCodigoSAR;

	public static String codSAR = null;
	public static JTextField txtBusquedaCliente;

	public registro_facturas_clientes() {
		setResizable(false);
		setDefaultCloseOperation(0);
		setBounds(100, 100, 1326, 650);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/iconos/icono_d_a.jpg")));

		btnAtras = new JButton("Regresar");
		btnAtras.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnAtras.setBackground(new Color(255, 127, 80));
		btnAtras.setBounds(1197, 11, 102, 23);
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

		JLabel lblRegistrarCargo = new JLabel("REGISTRO Y MANTENIMIENTO DE FACTURAS DE LOS CLIENTES DE LA EMPRESA");
		lblRegistrarCargo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblRegistrarCargo.setBounds(28, 11, 844, 38);
		contentPane.add(lblRegistrarCargo);
		scrollFunciones = new JScrollPane();

		panelRegistro = new JPanel();
		panelRegistro.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		panelRegistro.setBounds(417, 45, 465, 550);
		contentPane.add(panelRegistro);
		panelRegistro.setLayout(null);

		label = new JLabel();
		label.setBounds(384, 48, 55, 49);
		panelRegistro.add(label);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnNuevo.setBounds(27, 493, 99, 23);
		panelRegistro.add(btnNuevo);
		btnNuevo.setBackground(new Color(255, 255, 255));

		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnGuardar.setBounds(340, 493, 99, 23);
		panelRegistro.add(btnGuardar);
		btnGuardar.setBackground(new Color(60, 179, 113));

		lblNombreEmpresa = new JLabel("Nombre de la empresa.");
		lblNombreEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreEmpresa.setBounds(27, 48, 412, 32);
		panelRegistro.add(lblNombreEmpresa);
		lblNombreEmpresa.setFont(new Font("Bernard MT Condensed", Font.BOLD, 15));

		btnActualizar = new JButton("Actualizar");
		btnActualizar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnActualizar.setBackground(new Color(60, 179, 113));
		btnActualizar.setBounds(238, 493, 99, 23);
		panelRegistro.add(btnActualizar);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnAceptar.setBackground(new Color(255, 255, 255));
		btnAceptar.setBounds(129, 493, 105, 23);
		panelRegistro.add(btnAceptar);

		lblDireccion = new JLabel("direccion");
		lblDireccion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDireccion.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblDireccion.setBounds(27, 75, 412, 23);
		panelRegistro.add(lblDireccion);

		lblTelefono_1 = new JLabel("telefono");
		lblTelefono_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefono_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblTelefono_1.setBounds(27, 93, 207, 23);
		panelRegistro.add(lblTelefono_1);

		lblCorreo = new JLabel("correo");
		lblCorreo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCorreo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblCorreo.setBounds(27, 109, 412, 23);
		panelRegistro.add(lblCorreo);

		lblRtnEmpresa = new JLabel("rtn");
		lblRtnEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblRtnEmpresa.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblRtnEmpresa.setBounds(238, 94, 207, 20);
		panelRegistro.add(lblRtnEmpresa);

		lblNDeFactura = new JLabel("N\u00BA de factura :");
		lblNDeFactura.setHorizontalAlignment(SwingConstants.CENTER);
		lblNDeFactura.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblNDeFactura.setBounds(27, 127, 207, 23);
		panelRegistro.add(lblNDeFactura);

		lblFecha = new JLabel("Fecha y Hora :");
		lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecha.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblFecha.setBounds(232, 127, 207, 23);
		panelRegistro.add(lblFecha);

		txtNumeroFactura = new JTextField();
		txtNumeroFactura.setEditable(false);
		txtNumeroFactura.setHorizontalAlignment(SwingConstants.CENTER);
		txtNumeroFactura.setColumns(10);
		txtNumeroFactura.setBounds(27, 148, 207, 15);
		panelRegistro.add(txtNumeroFactura);

		txtFechaHoraFactura = new JTextField();
		txtFechaHoraFactura.setEditable(false);
		txtFechaHoraFactura.setHorizontalAlignment(SwingConstants.CENTER);
		txtFechaHoraFactura.setColumns(10);
		txtFechaHoraFactura.setBounds(232, 148, 207, 15);
		panelRegistro.add(txtFechaHoraFactura);
		txtFechaHoraFactura.setText(getFechaYHora());

		lblCai = new JLabel("cai");
		lblCai.setHorizontalAlignment(SwingConstants.CENTER);
		lblCai.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblCai.setBounds(27, 169, 412, 23);
		panelRegistro.add(lblCai);

		lblCliente = new JLabel("Cliente :");
		lblCliente.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblCliente.setBounds(27, 203, 99, 15);
		panelRegistro.add(lblCliente);

		txtCliente = new JTextField();
		txtCliente.setHorizontalAlignment(SwingConstants.CENTER);
		txtCliente.setColumns(10);
		txtCliente.setBounds(111, 202, 328, 15);
		panelRegistro.add(txtCliente);
		InputMap map501 = txtCliente.getInputMap(JComponent.WHEN_FOCUSED);
		map501.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtCliente.setHorizontalAlignment(SwingConstants.CENTER);
		txtCliente.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();
				if (!Character.isLetter(ke.getKeyChar()) && !(ke.getKeyChar() == KeyEvent.VK_SPACE)
						&& !(ke.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
					ke.consume();
				}
				if (txtCliente.getText().length() == 50)
					ke.consume();
			}

			@Override
			public void keyPressed(KeyEvent ke) {
			}

			@Override
			public void keyReleased(KeyEvent ke) {
			}
		});

		MaskFormatter formato1 = null;
		try {
			formato1 = new MaskFormatter("##############");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtRTN = new JFormattedTextField(formato1);
		txtRTN.setHorizontalAlignment(SwingConstants.CENTER);
		txtRTN.setColumns(10);
		txtRTN.setBounds(111, 222, 328, 15);
		panelRegistro.add(txtRTN);
		txtRTN.addKeyListener(new KeyListener() {
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

		txtDireccion = new JTextField();
		txtDireccion.setHorizontalAlignment(SwingConstants.CENTER);
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(111, 242, 328, 15);
		panelRegistro.add(txtDireccion);
		InputMap map5 = txtDireccion.getInputMap(JComponent.WHEN_FOCUSED);
		map5.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtDireccion.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				if (txtDireccion.getText().length() == 50)
					ke.consume();
			}

			@Override
			public void keyPressed(KeyEvent ke) {
			}

			@Override
			public void keyReleased(KeyEvent ke) {
				char c = ke.getKeyChar();
				if (ke.getKeyChar() == '\n' || ke.getKeyChar() == '\t') {
					String str = txtDireccion.getText().trim();
					txtDireccion.setText(str);
				}
			}
		});

		lblRtn = new JLabel("RTN :");
		lblRtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblRtn.setBounds(27, 223, 99, 15);
		panelRegistro.add(lblRtn);

		lblDireccion_1 = new JLabel("Direccion :");
		lblDireccion_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblDireccion_1.setBounds(27, 243, 99, 15);
		panelRegistro.add(lblDireccion_1);

		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(27, 48, 49, 15);
		panelRegistro.add(txtCodigo);
		txtCodigo.setVisible(false);

		JLabel lblEmpleado = new JLabel("Empleado :");
		lblEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblEmpleado.setBounds(27, 441, 99, 15);
		panelRegistro.add(lblEmpleado);

		txtEmpleado = new JTextField();
		txtEmpleado.setEditable(false);
		txtEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmpleado.setColumns(10);
		txtEmpleado.setBounds(111, 440, 328, 15);
		panelRegistro.add(txtEmpleado);

		lblFacturasPermitidas = new JLabel("Rango permitido :");
		lblFacturasPermitidas.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblFacturasPermitidas.setBounds(27, 417, 114, 15);
		panelRegistro.add(lblFacturasPermitidas);

		txtRI = new JTextField();
		txtRI.setEditable(false);
		txtRI.setHorizontalAlignment(SwingConstants.CENTER);
		txtRI.setColumns(10);
		txtRI.setBounds(158, 417, 114, 15);
		panelRegistro.add(txtRI);

		lblHasta = new JLabel("Hasta");
		lblHasta.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblHasta.setBounds(282, 417, 65, 15);
		panelRegistro.add(lblHasta);

		txtRF = new JTextField();
		txtRF.setEditable(false);
		txtRF.setHorizontalAlignment(SwingConstants.CENTER);
		txtRF.setColumns(10);
		txtRF.setBounds(325, 417, 114, 15);
		panelRegistro.add(txtRF);

		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(27, 269, 412, 137);
		panelRegistro.add(panel);
		panel.setLayout(null);

		lblPorConceptoDe = new JLabel("Por Concepto de :");
		lblPorConceptoDe.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblPorConceptoDe.setBounds(10, 8, 134, 15);
		panel.add(lblPorConceptoDe);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 26, 392, 55);
		panel.add(scrollPane);

		txtPorConceptoDe = new JTextArea();
		scrollPane.setViewportView(txtPorConceptoDe);
		InputMap map52 = txtPorConceptoDe.getInputMap(JComponent.WHEN_FOCUSED);
		map52.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtPorConceptoDe.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				if (txtPorConceptoDe.getText().length() == 100)
					ke.consume();
			}

			@Override
			public void keyPressed(KeyEvent ke) {
			}

			@Override
			public void keyReleased(KeyEvent ke) {
				char c = ke.getKeyChar();
				if (ke.getKeyChar() == '\n' || ke.getKeyChar() == '\t') {
					String str = txtPorConceptoDe.getText().trim();
					txtPorConceptoDe.setText(str);
				}
			}
		});

		JLabel lblCantidad = new JLabel("Cantidad en letras :");
		lblCantidad.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblCantidad.setBounds(10, 92, 149, 15);
		panel.add(lblCantidad);

		txtCantidadLetras = new JTextField();
		txtCantidadLetras.setColumns(10);
		txtCantidadLetras.setBounds(160, 91, 242, 15);
		panel.add(txtCantidadLetras);
		InputMap map54 = txtCantidadLetras.getInputMap(JComponent.WHEN_FOCUSED);
		map54.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtCantidadLetras.setHorizontalAlignment(SwingConstants.CENTER);
		txtCantidadLetras.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();
				if (!Character.isLetter(ke.getKeyChar()) && !(ke.getKeyChar() == KeyEvent.VK_SPACE)
						&& !(ke.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
					ke.consume();
				}
				if (txtCantidadLetras.getText().length() == 50)
					ke.consume();
			}

			@Override
			public void keyPressed(KeyEvent ke) {
			}

			@Override
			public void keyReleased(KeyEvent ke) {
			}
		});

		JLabel lblCantidadEnNumeros = new JLabel("Cantidad en numeros :");
		lblCantidadEnNumeros.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblCantidadEnNumeros.setBounds(10, 111, 149, 15);
		panel.add(lblCantidadEnNumeros);

		txtCantidadNumeros = new JTextField();
		txtCantidadNumeros.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCantidadNumeros.setColumns(10);
		txtCantidadNumeros.setBounds(160, 110, 86, 15);
		panel.add(txtCantidadNumeros);
		InputMap map51 = txtCantidadNumeros.getInputMap(JComponent.WHEN_FOCUSED);
		map51.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtCantidadNumeros.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCantidadNumeros.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();
				if ((c < '0' || c > '9'))
					ke.consume();

				if (txtCantidadNumeros.getText().length() == 8)
					ke.consume();
			}

			@Override
			public void keyPressed(KeyEvent ke) {
			}

			@Override
			public void keyReleased(KeyEvent ke) {
			}
		});

		lblLaFacturaEs = new JLabel("La factura es derecho de todos, EXIJALA!");
		lblLaFacturaEs.setHorizontalAlignment(SwingConstants.CENTER);
		lblLaFacturaEs.setFont(new Font("Bernard MT Condensed", Font.BOLD, 12));
		lblLaFacturaEs.setBounds(27, 461, 412, 32);
		panelRegistro.add(lblLaFacturaEs);

		lblDe = new JLabel("De");
		lblDe.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblDe.setBounds(135, 417, 34, 15);
		panelRegistro.add(lblDe);

		txtNuevaFactura = new JTextField();
		txtNuevaFactura.setEditable(false);
		txtNuevaFactura.setHorizontalAlignment(SwingConstants.CENTER);
		txtNuevaFactura.setColumns(10);
		txtNuevaFactura.setBounds(27, 77, 49, 15);
		panelRegistro.add(txtNuevaFactura);
		txtNuevaFactura.setVisible(false);

		txtCodigoSAR = new JTextField();
		txtCodigoSAR.setEditable(false);
		txtCodigoSAR.setBounds(27, 109, 49, 20);
		panelRegistro.add(txtCodigoSAR);
		txtCodigoSAR.setColumns(10);
		txtCodigoSAR.setVisible(false);

		JButton btnImprimir = new JButton("Imprimir");
		btnImprimir.setBackground(new Color(0, 139, 139));
		btnImprimir.setBounds(27, 49, 83, 20);
		panelRegistro.add(btnImprimir);
		btnImprimir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnImprimir.setVisible(false);
				btnNuevo.setVisible(false);
				btnGuardar.setVisible(false);
				lblLibreta.setVisible(false);
				btnAceptar.setVisible(false);
				panelRegistro.setBackground(Color.WHITE);
				lblNombreEmpresa.setBounds(27, 2, 412, 32);
				label.setBounds(205, 29, 55, 49);
				panelRegistro.setBounds(417, 45, 465, 497);
				imprimirFactura();
				btnImprimir.setVisible(true);
				btnNuevo.setVisible(true);
				btnGuardar.setVisible(true);
				lblLibreta.setVisible(true);
				btnAceptar.setVisible(true);
				panelRegistro.setBackground(Color.WHITE);
				lblNombreEmpresa.setBounds(27, 48, 412, 32);
				label.setBounds(384, 48, 55, 49);
				panelRegistro.setBounds(417, 45, 465, 550);
			}
		});

		lblLibreta = new JLabel();
		lblLibreta.setBounds(0, 0, 465, 550);
		panelRegistro.add(lblLibreta);
		final ImageIcon logo = new ImageIcon(
				icono.getImage().getScaledInstance(lblLibreta.getWidth(), lblLibreta.getHeight(), Image.SCALE_DEFAULT));
		lblLibreta.setIcon(logo);

		JPanel panelTablaCargos = new JPanel();
		panelTablaCargos.setLayout(null);
		panelTablaCargos.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		panelTablaCargos.setBackground(Color.WHITE);
		panelTablaCargos.setBounds(892, 45, 425, 549);
		contentPane.add(panelTablaCargos);

		JLabel lblCargosRegistrados = new JLabel("Facturas registradas :");
		lblCargosRegistrados.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblCargosRegistrados.setBounds(30, 50, 166, 19);
		panelTablaCargos.add(lblCargosRegistrados);

		JLabel lblBuscar = new JLabel("Buscar Factura :");
		lblBuscar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblBuscar.setBounds(30, 72, 119, 22);
		panelTablaCargos.add(lblBuscar);

		txtBusqueda = new JTextField();
		txtBusqueda.setHorizontalAlignment(SwingConstants.CENTER);
		txtBusqueda.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtBusqueda.setColumns(10);
		txtBusqueda.setBounds(138, 73, 199, 21);
		panelTablaCargos.add(txtBusqueda);
		InputMap map6 = txtBusqueda.getInputMap(JComponent.WHEN_FOCUSED);
		map6.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtBusqueda.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				trsfiltroCodigo = new TableRowSorter(tabla.getModel());
				tabla.setRowSorter(trsfiltroCodigo);
			}

			@Override
			public void keyPressed(KeyEvent ke) {

			}

			@Override
			public void keyReleased(KeyEvent ke) {
				String cadena = (txtBusqueda.getText());
				txtBusqueda.setText(cadena);
				repaint();
				filtro();
			}
		});

		btnBorrar = new JButton("Borrar");
		btnBorrar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnBorrar.setBackground(new Color(220, 20, 60));
		btnBorrar.setBounds(30, 490, 99, 23);
		panelTablaCargos.add(btnBorrar);

		barra = new JScrollPane(tabla, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panelTablaCargos.add(barra);
		barra.setBounds(28, 101, 368, 378);

		tabla = new JTable();
		barra.setViewportView(tabla);

		label_2 = new JLabel();
		label_2.setBounds(340, 50, 56, 48);
		panelTablaCargos.add(label_2);

		btnActualizarDatos = new JButton("Actualizar Datos");
		btnActualizarDatos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnActualizarDatos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnActualizarDatos.setBackground(new Color(60, 179, 113));
		btnActualizarDatos.setBounds(256, 490, 137, 23);
		panelTablaCargos.add(btnActualizarDatos);

		btnVer = new JButton("Ver detalles");
		btnVer.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnVer.setBackground(new Color(0, 206, 209));
		btnVer.setBounds(138, 490, 108, 23);
		panelTablaCargos.add(btnVer);

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

					String encabezado = "Reporte de fact. cliente de " + login_usuario.nombre.toString();

					utilJTablePrint(tabla, encabezado, "Pagina {0} de " + i + "          Impreso por: "
							+ login_usuario.nombreCompletoUsuario.toString() + "          " + fecha, true);

				}
			}
		});
		button.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		button.setBackground(new Color(60, 179, 113));
		button.setBounds(191, 50, 146, 19);
		panelTablaCargos.add(button);

		JLabel label_5 = new JLabel();
		label_5.setBounds(0, 0, 426, 549);
		panelTablaCargos.add(label_5);
		final ImageIcon logo1 = new ImageIcon(
				icono.getImage().getScaledInstance(label_5.getWidth(), label_5.getHeight(), Image.SCALE_DEFAULT));
		label_5.setIcon(logo1);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(3, 45, 404, 550);
		contentPane.add(panel_1);

		JLabel lblBuscarCliente = new JLabel("Buscar Cliente:");
		lblBuscarCliente.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblBuscarCliente.setBounds(28, 77, 119, 22);
		panel_1.add(lblBuscarCliente);

		txtBusquedaCliente = new JTextField();
		txtBusquedaCliente.setHorizontalAlignment(SwingConstants.CENTER);
		txtBusquedaCliente.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtBusquedaCliente.setColumns(10);
		txtBusquedaCliente.setBounds(136, 78, 180, 21);
		panel_1.add(txtBusquedaCliente);
		InputMap map61 = txtBusquedaCliente.getInputMap(JComponent.WHEN_FOCUSED);
		map61.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtBusquedaCliente.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				trsfiltroCodigoCliente = new TableRowSorter(tablaCliente.getModel());
				tablaCliente.setRowSorter(trsfiltroCodigoCliente);
			}

			@Override
			public void keyPressed(KeyEvent ke) {

			}

			@Override
			public void keyReleased(KeyEvent ke) {
				String cadena = (txtBusquedaCliente.getText());
				txtBusquedaCliente.setText(cadena);
				repaint();
				filtroClientes();
			}
		});

		barraCliente = new JScrollPane(tablaCliente, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		barraCliente.setBounds(28, 106, 350, 381);
		panel_1.add(barraCliente);
		tablaCliente = new JTable();
		barraCliente.setViewportView(tablaCliente);

		label_3 = new JLabel();
		label_3.setBounds(321, 49, 57, 50);
		panel_1.add(label_3);

		btnFactura = new JButton("Factura");
		btnFactura.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnFactura.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnFactura.setBackground(new Color(60, 179, 113));
		btnFactura.setBounds(259, 492, 119, 23);
		panel_1.add(btnFactura);

		JLabel lblClientesRegistradosEn = new JLabel("Clientes registrados en la empresa.");
		lblClientesRegistradosEn.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientesRegistradosEn.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblClientesRegistradosEn.setBounds(28, 49, 299, 29);
		panel_1.add(lblClientesRegistradosEn);

		JButton btnClientes = new JButton("Clientes");
		btnClientes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cliente clase = new cliente();
				consultas_cliente consulta = new consultas_cliente();
				registro_clientes formulario = new registro_clientes();
				control_cliente control = new control_cliente(clase, consulta, formulario);
				formulario.setVisible(true);
				formulario.setLocationRelativeTo(null);
				formulario.txtNombresCliente.requestFocusInWindow();
				formulario.obtenerUltimoId();
				formulario.consultarEmpresa();
				formulario.construirTabla();
				formulario.btnGuardar.setVisible(true);
				formulario.btnNuevo.setVisible(true);
				formulario.btnActualizar.setVisible(false);
				formulario.btnAceptar.setVisible(false);
				formulario.btnBorrar.setVisible(false);
				formulario.setTitle("Sesión iniciada por: " + login_usuario.nombreCompletoUsuario);
				dispose();
			}
		});
		btnClientes.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnClientes.setBackground(new Color(100, 149, 237));
		btnClientes.setBounds(28, 493, 119, 23);
		panel_1.add(btnClientes);

		JLabel label_6 = new JLabel();
		label_6.setBounds(0, 0, 404, 550);
		panel_1.add(label_6);
		final ImageIcon logo2 = new ImageIcon(
				icono.getImage().getScaledInstance(label_6.getWidth(), label_6.getHeight(), Image.SCALE_DEFAULT));
		label_6.setIcon(logo2);

	}

	public void construirTabla() {
		String titulos[] = { "Codigo", "Factura", "Fecha", "Cliente", "RTN", "Direccion", "Concepto",
				"Cantidad en Letras", "Cantidad en Numeros", "Atendido por" };
		String informacion[][] = control_factura_cliente.obtenerMatriz();
		tabla = new JTable(informacion, titulos);
		barra.setViewportView(tabla);
		for (int c = 0; c < tabla.getColumnCount(); c++) {
			Class<?> col_class = tabla.getColumnClass(c);
			tabla.setDefaultEditor(col_class, null);
			tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			tabla.getTableHeader().setReorderingAllowed(false);

		}
	}

	public void filtro() {
		filtroCodigo = txtBusqueda.getText();
		trsfiltroCodigo.setRowFilter(RowFilter.regexFilter(txtBusqueda.getText(), 0, 1, 2, 3, 4, 5, 6));
	}

	public void pistas() {
		pista = new PlaceHolder(txtBusqueda, "Escriba para buscar.");
	}

	public void obtenerUltimoId() {
		String ultimoValor = null;
		int valor;
		String id = null;
		conexion objCon = new conexion();
		Connection conn = objCon.getConexion();
		try {
			PreparedStatement stmtr = conn
					.prepareStatement("SELECT * FROM facturas_clientes ORDER BY id_facturas_cliente DESC");
			ResultSet rsr = stmtr.executeQuery();
			if (rsr.next()) {
				ultimoValor = rsr.getString("id_facturas_cliente");
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

				final ImageIcon icono4 = new ImageIcon(logo.getImage().getScaledInstance(label_3.getWidth(),
						label_3.getHeight(), Image.SCALE_DEFAULT));
				label_3.setIcon(icono4);

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

	public void establecerDatosEmpresa() {
		conexion conex = new conexion();
		try {
			Statement estatuto = conex.getConexion().createStatement();
			ResultSet rs = estatuto.executeQuery(
					"SELECT nombre_empresa, direccion_empresa, telefono_empresa, rtn_empresa, correo_empresa FROM empresa where id_empresa = 1");

			if (rs.next()) {
				nombre = (rs.getString("nombre_empresa"));
				direccion = (rs.getString("direccion_empresa"));
				correo = (rs.getString("correo_empresa"));
				telefono = (rs.getString("telefono_empresa"));
				rtn = (rs.getString("rtn_empresa"));

				lblNombreEmpresa.setText(nombre);
				lblDireccion.setText(direccion);
				lblCorreo.setText("Correo : " + correo);
				lblTelefono_1.setText("Telefono : " + telefono);
				lblRtnEmpresa.setText("RTN : " + rtn);

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
		String cai = null;
		String formato = null;
		String factura = null;
		String ri = null;
		String rf = null;
		conexion objCon = new conexion();
		Connection conn = objCon.getConexion();
		try {
			PreparedStatement stmtr = conn.prepareStatement("SELECT * FROM sar ORDER BY id_sar DESC");
			ResultSet rsr = stmtr.executeQuery();
			if (rsr.next()) {

				cai = rsr.getString("cai_sar");
				formato = rsr.getString("formato_sar");
				factura = rsr.getString("factura_actual_sar");
				ri = rsr.getString("rango_inicial_sar");
				rf = rsr.getString("rango_final_sar");
			}
			lblCai.setText("CAI: " + cai);
			txtNumeroFactura.setText(formato + "-" + factura);
			txtRI.setText(formato + "-" + ri);
			txtRF.setText(formato + "-" + rf);

			;
			stmtr.close();
			rsr.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sumarFactura() {
		conexion objCon = new conexion();
		Connection conn = objCon.getConexion();
		try {
			PreparedStatement stmtr = conn.prepareStatement("SELECT * FROM sar ORDER BY id_sar DESC");
			ResultSet rsr = stmtr.executeQuery();
			if (rsr.next()) {
				codSAR = rsr.getString("id_sar");
				factura = rsr.getString("factura_actual_sar");
				cantidad = Integer.parseInt(factura);
				nuevaCantidad = cantidad + 1;
				nuevaFactura = String.valueOf(nuevaCantidad);
			}
			txtCodigoSAR.setText(codSAR);
			txtNuevaFactura.setText(nuevaFactura);

			;
			stmtr.close();
			rsr.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
		if (pageIndex == 0) {
			Graphics2D g2d = (Graphics2D) graphics;
			g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
			panelRegistro.printAll(graphics);
			panelRegistro.printAll(graphics);
			return PAGE_EXISTS;
		} else {
			return NO_SUCH_PAGE;
		}
	}

	public void imprimirFactura() {
		PrinterJob printerJob = PrinterJob.getPrinterJob();
		printerJob.setPrintable(this);
		try {
			printerJob.print();
		} catch (PrinterException ex) {
			System.out.println("Error:" + ex);
		}
	}

	public void obtenerTotalDatosReporte() {
		conexion objCon = new conexion();
		Connection conn = objCon.getConexion();
		try {
			PreparedStatement stmtr = conn
					.prepareStatement("SELECT * FROM facturas_clientes ORDER BY id_facturas_cliente DESC");
			ResultSet rsr = stmtr.executeQuery();
			if (rsr.next()) {
				totalDatos = rsr.getString("id_facturas_cliente");
			}
			;
			stmtr.close();
			rsr.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void construirTablaClientes() {
		String titulos[] = { "Codigo", "Nombres", "Apellidos", "Direccion", "Telefono", "Correo", "Genero", "Identidad",
				"Foto", "Empresa", "Descripcion Empresa", "Direccion Empresa", "RTN", "Telefono Empresa",
				"Correo Empresa" };
		String informacion[][] = control_cliente.obtenerMatriz();
		tablaCliente = new JTable(informacion, titulos);
		barraCliente.setViewportView(tablaCliente);
		for (int c = 0; c < tablaCliente.getColumnCount(); c++) {
			Class<?> col_class = tablaCliente.getColumnClass(c);
			tablaCliente.setDefaultEditor(col_class, null);
			tablaCliente.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			tablaCliente.getTableHeader().setReorderingAllowed(false);

		}
	}

	public void filtroClientes() {
		filtroCodigoCliente = txtBusquedaCliente.getText();
		trsfiltroCodigoCliente.setRowFilter(
				RowFilter.regexFilter(txtBusquedaCliente.getText(), 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14));
	}
}
