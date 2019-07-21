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
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import controles.control_servicio;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.JTextArea;

public class registro_servicios extends JFrame {
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
	public int contador = 0;

	public static String ruta;
	public static String cantidad;
	public static ImageIcon imagen;

	public JPanel contentPane;
	public JTextField txtBusqueda;
	public JScrollPane barraServicios;
	public JTable tablaServicios;
	public JTextField txtCodigo;

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
	public JTextField txtServicio;
	public JTextField txtTiempo;
	public JTextField txtPrecio;
	public JTextArea txtDescripcion;
	private JLabel lblL;
	public static JComboBox<String> cbxProductos;
	public static JTextField txtDispositivo;
	public static JTextField txtCapasidad;
	public static JTextField txtPrecioProducto;
	public static JTextField txtMarca;

	public registro_servicios() {
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
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

		JLabel lblRegistrarCargo = new JLabel("REGISTRO Y MANTENIMIENTO DE SERVICIOS");
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

		btnNuevo = new JButton("Nuevo");
		btnNuevo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnNuevo.setBounds(27, 393, 99, 23);
		panelRegistro.add(btnNuevo);
		btnNuevo.setBackground(new Color(255, 255, 255));

		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnGuardar.setBounds(218, 393, 99, 23);
		panelRegistro.add(btnGuardar);
		btnGuardar.setBackground(new Color(60, 179, 113));

		JLabel lblNombreCargo = new JLabel("3. Tiempo :");
		lblNombreCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblNombreCargo.setBounds(27, 143, 136, 14);
		panelRegistro.add(lblNombreCargo);

		JLabel lblTipo = new JLabel("2. Servicio :");
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

		txtCodigo = new JTextField();
		txtCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(124, 81, 43, 23);
		panelRegistro.add(txtCodigo);
		txtCodigo.setColumns(10);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnActualizar.setBackground(new Color(60, 179, 113));
		btnActualizar.setBounds(218, 369, 99, 23);
		panelRegistro.add(btnActualizar);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnAceptar.setBackground(new Color(255, 255, 255));
		btnAceptar.setBounds(27, 369, 99, 23);
		panelRegistro.add(btnAceptar);

		MaskFormatter formato = null;
		try {
			formato = new MaskFormatter("####-####-#####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		txtServicio = new JTextField();
		txtServicio.setColumns(10);
		txtServicio.setBounds(124, 111, 190, 23);
		panelRegistro.add(txtServicio);
		InputMap map1 = txtServicio.getInputMap(JComponent.WHEN_FOCUSED);
		map1.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

		txtTiempo = new JTextField();
		txtTiempo.setColumns(10);
		txtTiempo.setBounds(124, 140, 190, 23);
		panelRegistro.add(txtTiempo);
		InputMap map2 = txtTiempo.getInputMap(JComponent.WHEN_FOCUSED);
		map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

		JLabel lblCapasidad = new JLabel("4. Descripci\u00F3n :");
		lblCapasidad.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblCapasidad.setBounds(27, 168, 136, 22);
		panelRegistro.add(lblCapasidad);

		JLabel lblPrecio = new JLabel("5. Precio :");
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
			}

			@Override
			public void keyPressed(KeyEvent ke) {
			}

			@Override
			public void keyReleased(KeyEvent ke) {
			}
		});

		JLabel lblCantidad = new JLabel("6. Productos :");
		lblCantidad.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblCantidad.setBounds(27, 285, 158, 22);
		panelRegistro.add(lblCantidad);

		lblL = new JLabel("L.");
		lblL.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblL.setBounds(155, 230, 17, 14);
		panelRegistro.add(lblL);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(124, 168, 190, 52);
		panelRegistro.add(scrollPane);

		txtDescripcion = new JTextArea();
		txtDescripcion.setFont(new Font("Dialog", Font.PLAIN, 12));
		scrollPane.setViewportView(txtDescripcion);

		cbxProductos = new JComboBox<String>();
		cbxProductos.setModel(new DefaultComboBoxModel<String>(new String[] { "Ninguno" }));
		cbxProductos.setBounds(173, 287, 141, 20);
		panelRegistro.add(cbxProductos);
		cbxProductos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (cbxProductos.getSelectedItem().equals("Ninguno")) {
					txtDispositivo.setText("");
					txtMarca.setText("");
					txtCapasidad.setText("");
					txtPrecioProducto.setText("");
				} else {
					cargarDatosProducto();
				}
			}
		});

		txtDispositivo = new JTextField();
		txtDispositivo.setEditable(false);
		txtDispositivo.setHorizontalAlignment(SwingConstants.CENTER);
		txtDispositivo.setColumns(10);
		txtDispositivo.setBounds(27, 310, 141, 23);
		panelRegistro.add(txtDispositivo);

		txtCapasidad = new JTextField();
		txtCapasidad.setEditable(false);
		txtCapasidad.setHorizontalAlignment(SwingConstants.CENTER);
		txtCapasidad.setColumns(10);
		txtCapasidad.setBounds(27, 336, 141, 23);
		panelRegistro.add(txtCapasidad);

		txtPrecioProducto = new JTextField();
		txtPrecioProducto.setEditable(false);
		txtPrecioProducto.setHorizontalAlignment(SwingConstants.CENTER);
		txtPrecioProducto.setColumns(10);
		txtPrecioProducto.setBounds(173, 310, 141, 23);
		panelRegistro.add(txtPrecioProducto);

		txtMarca = new JTextField();
		txtMarca.setEditable(false);
		txtMarca.setHorizontalAlignment(SwingConstants.CENTER);
		txtMarca.setColumns(10);
		txtMarca.setBounds(173, 336, 141, 23);
		panelRegistro.add(txtMarca);

		JTextArea txtrNotaSiEs = new JTextArea();
		txtrNotaSiEs.setBackground(new Color(192, 192, 192));
		txtrNotaSiEs.setText(
				"Nota: Si es necesario, y el cliente lo necesita, la empresa\r\nle ofrece los siguientes productos.");
		txtrNotaSiEs.setFont(new Font("Dialog", Font.BOLD, 10));
		txtrNotaSiEs.setEditable(false);
		txtrNotaSiEs.setBounds(27, 248, 287, 38);
		panelRegistro.add(txtrNotaSiEs);

		JLabel lblLibreta = new JLabel();
		lblLibreta.setBounds(0, 0, 341, 450);
		panelRegistro.add(lblLibreta);
		final ImageIcon logo = new ImageIcon(
				icono.getImage().getScaledInstance(lblLibreta.getWidth(), lblLibreta.getHeight(), Image.SCALE_DEFAULT));
		lblLibreta.setIcon(logo);

		JPanel panelTabla = new JPanel();
		panelTabla.setLayout(null);
		panelTabla.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		panelTabla.setBackground(Color.WHITE);
		panelTabla.setBounds(388, 61, 431, 449);
		contentPane.add(panelTabla);

		JLabel lblCargosRegistrados = new JLabel("Servicios registrados :");
		lblCargosRegistrados.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblCargosRegistrados.setBounds(30, 41, 166, 19);
		panelTabla.add(lblCargosRegistrados);

		JLabel lblBuscarContrato = new JLabel("Buscar Servicio:");
		lblBuscarContrato.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblBuscarContrato.setBounds(30, 63, 119, 22);
		panelTabla.add(lblBuscarContrato);

		txtBusqueda = new JTextField();
		txtBusqueda.setHorizontalAlignment(SwingConstants.CENTER);
		txtBusqueda.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtBusqueda.setColumns(10);
		txtBusqueda.setBounds(138, 64, 209, 21);
		panelTabla.add(txtBusqueda);
		InputMap map6 = txtBusqueda.getInputMap(JComponent.WHEN_FOCUSED);
		map6.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtBusqueda.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				trsfiltroCodigo = new TableRowSorter(tablaServicios.getModel());
				tablaServicios.setRowSorter(trsfiltroCodigo);
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
		btnBorrar.setBounds(30, 395, 99, 23);
		panelTabla.add(btnBorrar);

		barraServicios = new JScrollPane(tablaServicios, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panelTabla.add(barraServicios);
		barraServicios.setBounds(28, 90, 376, 294);

		tablaServicios = new JTable();
		barraServicios.setViewportView(tablaServicios);

		label_2 = new JLabel();
		label_2.setBounds(355, 41, 49, 44);
		panelTabla.add(label_2);

		btnActualizarDatos = new JButton("Actualizar Datos");
		btnActualizarDatos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnActualizarDatos.setBackground(new Color(60, 179, 113));
		btnActualizarDatos.setBounds(267, 396, 137, 23);
		panelTabla.add(btnActualizarDatos);

		btnVer = new JButton("Ver detalles");
		btnVer.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnVer.setBackground(new Color(0, 206, 209));
		btnVer.setBounds(149, 395, 108, 23);
		panelTabla.add(btnVer);

		button = new JButton("Imprimir Reporte");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String fecha = getFechaYHora();
				String nombreEmpresa = ventana_principal.lbl_nombre_empresa_principal.getText();
				String encabezado = "Reporte de servicios de " + nombreEmpresa;
				utilJTablePrint(tablaServicios, encabezado,
						"Pagina {0}" + "                                                  " + fecha, true);
			}
		});
		button.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		button.setBackground(new Color(60, 179, 113));
		button.setBounds(210, 40, 137, 19);
		panelTabla.add(button);

		JLabel label_5 = new JLabel();
		label_5.setBounds(0, 0, 431, 449);
		panelTabla.add(label_5);
		final ImageIcon logo1 = new ImageIcon(
				icono.getImage().getScaledInstance(label_5.getWidth(), label_5.getHeight(), Image.SCALE_DEFAULT));
		label_5.setIcon(logo1);

	}

	public void construirTabla() {
		String titulos[] = { "Codigo", "Servicio", "Tiempo", "Precio", "Descripcion", "Producto" };
		String informacion[][] = control_servicio.obtenerMatriz();
		tablaServicios = new JTable(informacion, titulos);
		barraServicios.setViewportView(tablaServicios);
		for (int c = 0; c < tablaServicios.getColumnCount(); c++) {
			Class<?> col_class = tablaServicios.getColumnClass(c);
			tablaServicios.setDefaultEditor(col_class, null);
			tablaServicios.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			tablaServicios.getTableHeader().setReorderingAllowed(false);

			DefaultTableCellRenderer tcr;
			tcr = new DefaultTableCellRenderer();
			tcr.setHorizontalAlignment(SwingConstants.RIGHT);
			tablaServicios.getColumnModel().getColumn(5).setCellRenderer(tcr);

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
			PreparedStatement stmtr = conn.prepareStatement("SELECT * FROM servicios ORDER BY id_servicio DESC");
			ResultSet rsr = stmtr.executeQuery();
			if (rsr.next()) {
				ultimoValor = rsr.getString("id_servicio");
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
			} else {
				JOptionPane.showMessageDialog(null,
						"Para una mejor experiencia Personalice su empresa en :" + " MAS INFORMACION DE LA EMPRESA.");
			}
			rs.close();
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error al consultar", "Error", JOptionPane.ERROR_MESSAGE);

		}

	}

	public void cargarDatosProducto() {
		conexion objCon = new conexion();
		Connection conn = objCon.getConexion();
		try {
			if (contador > 0) {
				PreparedStatement stmtr = conn.prepareStatement(
						"SELECT dispositivo_de_entrega_producto, marca_producto, capacidad_produto, precio_producto FROM productos where dispositivo_de_entrega_producto = '"
								+ cbxProductos.getSelectedItem() + "'");
				ResultSet rsr = stmtr.executeQuery();
				rsr.next();
				txtDispositivo.setText(rsr.getString("dispositivo_de_entrega_producto"));
				txtMarca.setText(rsr.getString("marca_producto"));
				txtCapasidad.setText(rsr.getString("capacidad_produto"));
				txtPrecioProducto.setText(rsr.getString("precio_producto"));
				;
				stmtr.close();
				rsr.close();
			}
			conn.close();
		} catch (Exception e21) {
			e21.printStackTrace();
		}
	}

	public void restar() {
		conexion objCon = new conexion();
		Connection conn = objCon.getConexion();
		try {
			int total = Integer.parseInt(cantidad);
			int existencia = total - 1;
			String resultado = String.valueOf(existencia);
			PreparedStatement stmtr2 = conn.prepareStatement("UPDATE productos SET existencia_producto='" + resultado
					+ "' WHERE dispositivo_de_entrega_producto='" + txtDispositivo.getText().toString() + "'");
			ResultSet rsr2 = stmtr2.executeQuery();
			rsr2.next();
			;
			stmtr2.close();
			rsr2.close();
			conn.close();

		} catch (Exception e21) {
			e21.printStackTrace();
		}
	}

}
