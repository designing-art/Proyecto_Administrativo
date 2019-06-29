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
import java.io.File;
import java.io.IOException;
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
import controles.control_cliente;
import controles.control_inventario;
import utilidades.visor_imagen;

import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.JTextArea;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class registro_facturas_clientes extends JFrame {
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

	public static String ruta_logo;
	public static JLabel label;
	public static JLabel label_2;

	public TableRowSorter<TableModel> trsfiltroCodigo;
	String filtroCodigo;

	public ImageIcon icono = new ImageIcon(getClass().getResource("/iconos/libreta.png"));
	public ImageIcon icono2 = new ImageIcon(getClass().getResource("/iconos/libreta.png"));
	public ImageIcon iconoProducto = new ImageIcon(getClass().getResource("/iconos/usb.png"));
	public JButton btnAtras;
	public JButton button;
	public JTextFieldDateEditor editor;
	public JLabel lblNDeFactura;
	public JLabel lblFecha;
	public JTextField txtFactura;
	public JTextField txtFecha;
	public JLabel lblCai;
	public JLabel lblCliente;
	public JTextField txtCliente;
	public JTextField txtRTN;
	public JTextField txtDireccion;
	public JLabel lblRtn;
	public JLabel lblDireccion_1;
	public JTextField txtCodigo;
	public JTextField textField;
	public JLabel lblFacturasPermitidas;
	public JTextField textField_1;
	public JLabel lblHasta;
	public JTextField textField_2;
	public JLabel lblPorConceptoDe;
	public JTextField textField_3;
	public JTextField textField_4;
	public JLabel lblLaFacturaEs;
	public JLabel lblDe;
	public static JLabel lblNombreEmpresa;
	public static JLabel lblDireccion;
	public static JLabel lblCorreo;
	public static JLabel lblTelefono_1;
	public static JLabel lblRtnEmpresa;

	public registro_facturas_clientes() {
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1016, 650);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/iconos/icono_d_a.jpg")));

		btnAtras = new JButton("Regresar");
		btnAtras.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnAtras.setBackground(new Color(255, 127, 80));
		btnAtras.setBounds(882, 25, 102, 23);
		contentPane.add(btnAtras);
		btnAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ventana_principal principal = new ventana_principal();
				principal.setVisible(true);
				principal.setLocationRelativeTo(null);
				dispose();
				Timer time = new Timer();
				time.schedule(principal.tarea, 0, 1000);
				principal.consultarEmpresa();
			}
		});

		JLabel lblRegistrarCargo = new JLabel("REGISTRO Y MANTENIMIENTO DE FACTURAS DE LOS CLIENTES DE LA EMPRESA");
		lblRegistrarCargo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblRegistrarCargo.setBounds(28, 20, 844, 29);
		contentPane.add(lblRegistrarCargo);
		scrollFunciones = new JScrollPane();

		JPanel panelRegistro = new JPanel();
		panelRegistro.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		panelRegistro.setBounds(28, 60, 465, 550);
		contentPane.add(panelRegistro);
		panelRegistro.setLayout(null);

		label = new JLabel();
		label.setBounds(390, 48, 49, 44);
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

		txtFactura = new JTextField();
		txtFactura.setEditable(false);
		txtFactura.setHorizontalAlignment(SwingConstants.CENTER);
		txtFactura.setColumns(10);
		txtFactura.setBounds(27, 148, 207, 15);
		panelRegistro.add(txtFactura);

		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		txtFecha.setHorizontalAlignment(SwingConstants.CENTER);
		txtFecha.setColumns(10);
		txtFecha.setBounds(232, 148, 207, 15);
		panelRegistro.add(txtFecha);
		txtFecha.setText(getFechaYHora());

		lblCai = new JLabel("cai");
		lblCai.setHorizontalAlignment(SwingConstants.CENTER);
		lblCai.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblCai.setBounds(27, 166, 412, 15);
		panelRegistro.add(lblCai);

		lblCliente = new JLabel("Cliente :");
		lblCliente.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblCliente.setBounds(27, 181, 99, 15);
		panelRegistro.add(lblCliente);

		txtCliente = new JTextField();
		txtCliente.setHorizontalAlignment(SwingConstants.CENTER);
		txtCliente.setColumns(10);
		txtCliente.setBounds(111, 180, 328, 15);
		panelRegistro.add(txtCliente);

		txtRTN = new JTextField();
		txtRTN.setHorizontalAlignment(SwingConstants.CENTER);
		txtRTN.setColumns(10);
		txtRTN.setBounds(111, 200, 328, 15);
		panelRegistro.add(txtRTN);

		txtDireccion = new JTextField();
		txtDireccion.setHorizontalAlignment(SwingConstants.CENTER);
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(111, 220, 328, 15);
		panelRegistro.add(txtDireccion);

		lblRtn = new JLabel("RTN :");
		lblRtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblRtn.setBounds(27, 201, 99, 15);
		panelRegistro.add(lblRtn);

		lblDireccion_1 = new JLabel("Direccion :");
		lblDireccion_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblDireccion_1.setBounds(27, 221, 99, 15);
		panelRegistro.add(lblDireccion_1);

		txtCodigo = new JTextField();
		txtCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(27, 48, 49, 15);
		panelRegistro.add(txtCodigo);

		JLabel lblEmpleado = new JLabel("Empleado :");
		lblEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblEmpleado.setBounds(27, 441, 99, 15);
		panelRegistro.add(lblEmpleado);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);
		textField.setBounds(111, 440, 328, 15);
		panelRegistro.add(textField);

		lblFacturasPermitidas = new JLabel("Facturas permitidas :");
		lblFacturasPermitidas.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblFacturasPermitidas.setBounds(27, 417, 148, 15);
		panelRegistro.add(lblFacturasPermitidas);

		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		textField_1.setBounds(197, 417, 86, 15);
		panelRegistro.add(textField_1);

		lblHasta = new JLabel("Hasta");
		lblHasta.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblHasta.setBounds(301, 417, 69, 15);
		panelRegistro.add(lblHasta);

		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setColumns(10);
		textField_2.setBounds(353, 417, 86, 15);
		panelRegistro.add(textField_2);

		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(27, 241, 412, 164);
		panelRegistro.add(panel);
		panel.setLayout(null);

		lblPorConceptoDe = new JLabel("Por Concepto de :");
		lblPorConceptoDe.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblPorConceptoDe.setBounds(10, 11, 134, 15);
		panel.add(lblPorConceptoDe);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 34, 392, 69);
		panel.add(scrollPane);

		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		JLabel lblCantidad = new JLabel("Cantidad en letras :");
		lblCantidad.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblCantidad.setBounds(10, 115, 149, 15);
		panel.add(lblCantidad);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(160, 114, 242, 15);
		panel.add(textField_3);

		JLabel lblCantidadEnNumeros = new JLabel("Cantidad en numeros :");
		lblCantidadEnNumeros.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblCantidadEnNumeros.setBounds(10, 134, 149, 15);
		panel.add(lblCantidadEnNumeros);

		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_4.setColumns(10);
		textField_4.setBounds(160, 133, 86, 15);
		panel.add(textField_4);

		lblLaFacturaEs = new JLabel("La factura es derecho de todos, EXIJALA!");
		lblLaFacturaEs.setHorizontalAlignment(SwingConstants.CENTER);
		lblLaFacturaEs.setFont(new Font("Bernard MT Condensed", Font.BOLD, 12));
		lblLaFacturaEs.setBounds(27, 461, 412, 32);
		panelRegistro.add(lblLaFacturaEs);

		lblDe = new JLabel("De");
		lblDe.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblDe.setBounds(167, 418, 58, 15);
		panelRegistro.add(lblDe);

		JLabel lblLibreta = new JLabel();
		lblLibreta.setBounds(0, 0, 465, 550);
		panelRegistro.add(lblLibreta);
		final ImageIcon logo = new ImageIcon(
				icono.getImage().getScaledInstance(lblLibreta.getWidth(), lblLibreta.getHeight(), Image.SCALE_DEFAULT));
		lblLibreta.setIcon(logo);

		JPanel panelTablaCargos = new JPanel();
		panelTablaCargos.setLayout(null);
		panelTablaCargos.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		panelTablaCargos.setBackground(Color.WHITE);
		panelTablaCargos.setBounds(503, 59, 481, 549);
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
		txtBusqueda.setBounds(138, 73, 257, 21);
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
		barra.setBounds(28, 101, 426, 378);

		tabla = new JTable();
		barra.setViewportView(tabla);

		label_2 = new JLabel();
		label_2.setBounds(405, 50, 49, 44);
		panelTablaCargos.add(label_2);

		btnActualizarDatos = new JButton("Actualizar Datos");
		btnActualizarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnActualizarDatos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnActualizarDatos.setBackground(new Color(60, 179, 113));
		btnActualizarDatos.setBounds(317, 490, 137, 23);
		panelTablaCargos.add(btnActualizarDatos);

		btnVer = new JButton("Ver detalles");
		btnVer.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnVer.setBackground(new Color(0, 206, 209));
		btnVer.setBounds(199, 490, 108, 23);
		panelTablaCargos.add(btnVer);

		button = new JButton("Imprimir Reporte");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String fecha = getFechaYHora();
				String nombreEmpresa = ventana_principal.lbl_nombre_empresa_principal.getText();
				String encabezado = "Reporte de clientes de " + nombreEmpresa;
				utilJTablePrint(tabla, encabezado,
						"Pagina {0}" + "                                                  " + fecha, true);
			}
		});
		button.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		button.setBackground(new Color(60, 179, 113));
		button.setBounds(258, 50, 137, 19);
		panelTablaCargos.add(button);

		JLabel label_5 = new JLabel();
		label_5.setBounds(0, 0, 481, 549);
		panelTablaCargos.add(label_5);
		final ImageIcon logo1 = new ImageIcon(
				icono.getImage().getScaledInstance(label_5.getWidth(), label_5.getHeight(), Image.SCALE_DEFAULT));
		label_5.setIcon(logo1);

	}

	public void construirTabla() {
		String titulos[] = { "Codigo", "Nombres", "Apellidos", "Direccion", "Telefono", "Correo", "Genero", "Identidad",
				"Foto", "Empresa", "Descripcion Empresa", "Direccion Empresa", "RTN", "Telefono Empresa",
				"Correo Empresa" };
		String informacion[][] = control_cliente.obtenerMatriz();
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
			PreparedStatement stmtr = conn.prepareStatement("SELECT * FROM clientes ORDER BY id_cliente DESC");
			ResultSet rsr = stmtr.executeQuery();
			if (rsr.next()) {
				ultimoValor = rsr.getString("id_cliente");
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
		String ampm;
		ampm = cal.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";
		SimpleDateFormat df = new SimpleDateFormat("dd '/' MMMMM '/' yyyy 'a las' HH:mm:ss '"+ampm+"'");
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
	
	public void establecerDatosEmpresa() {
		conexion conex = new conexion();
		try {
			Statement estatuto = conex.getConexion().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT nombre_empresa, direccion_empresa, telefono_empresa, rtn_empresa, correo_empresa FROM empresa where id_empresa = 1");

			
			if (rs.next()) {
				nombre = (rs.getString("nombre_empresa"));
				direccion = (rs.getString("direccion_empresa"));
				correo = (rs.getString("correo_empresa"));
				telefono = (rs.getString("telefono_empresa"));
				rtn = (rs.getString("rtn_empresa"));
				
				lblNombreEmpresa.setText(nombre);
				lblDireccion.setText(direccion);
				lblCorreo.setText("Correo : "+correo);
				lblTelefono_1.setText("Telefono : "+telefono);
				lblRtnEmpresa.setText("RTN : "+rtn);
				
				
				
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
	

}
