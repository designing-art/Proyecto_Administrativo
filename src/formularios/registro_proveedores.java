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
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.MaskFormatter;

import com.placeholder.PlaceHolder;

import conexion.conexion;
import controles.control_proveedor;
import utilidades.visor_imagen;

import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class registro_proveedores extends JFrame {
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

	public static String ruta;
	public static ImageIcon imagen;

	public JPanel contentPane;
	public JTextField txtBusqueda;
	public JScrollPane barraProveedores;
	public JTable tablaProveedores;
	public JTextField txtCodigoProveedor;

	public static String ruta_logo;
	public static JLabel label;
	public static JLabel label_2;

	public TableRowSorter<TableModel> trsfiltroCodigo;
	String filtroCodigo;
	public JTextField txtDireccionFotoProveedor;
	public JButton btnSubirFotoContrato;
	public JButton btnVerFotoProducto;
	public JLabel lbl_foto_contrato;

	public ImageIcon icono = new ImageIcon(getClass().getResource("/iconos/libreta.png"));
	public ImageIcon icono2 = new ImageIcon(getClass().getResource("/iconos/libreta.png"));
	public ImageIcon iconoProducto = new ImageIcon(getClass().getResource("/iconos/usuario.png"));
	public JButton btnAtras;
	public JButton button;
	public JTextField txtNombresProveedor;
	public JFormattedTextField txtCuentaProveedor;
	public JTextField txtDireccionProveedor;
	public JFormattedTextField txtRtnProveedor;
	public JFormattedTextField txtTelefonoProveedor;
	public JTextField txtCorreoProveedor;

	public registro_proveedores() {
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
				principal.setVisible(true);
				principal.setLocationRelativeTo(null);
				dispose();
				Timer time = new Timer();
				time.schedule(principal.tarea, 0, 1000);
				principal.consultarEmpresa();
			}
		});

		JLabel lblRegistrarCargo = new JLabel("REGISTRO Y MANTENIMIENTO DE PROVEEDORES");
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
		btnNuevo.setBounds(24, 402, 99, 23);
		panelRegistro.add(btnNuevo);
		btnNuevo.setBackground(new Color(255, 255, 255));

		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnGuardar.setBounds(218, 402, 99, 23);
		panelRegistro.add(btnGuardar);
		btnGuardar.setBackground(new Color(60, 179, 113));

		JLabel lblNombreCargo = new JLabel("3. Cuenta:");
		lblNombreCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblNombreCargo.setBounds(27, 143, 136, 14);
		panelRegistro.add(lblNombreCargo);

		JLabel lblNombreProveedor = new JLabel("2. Nombre :");
		lblNombreProveedor.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblNombreProveedor.setBounds(27, 109, 158, 23);
		panelRegistro.add(lblNombreProveedor);

		JLabel lblCodigo = new JLabel("1. Codigo :");
		lblCodigo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblCodigo.setBounds(27, 84, 63, 14);
		panelRegistro.add(lblCodigo);

		JLabel lblRegistroCargos = new JLabel("Datos del registro :");
		lblRegistroCargos.setBounds(27, 48, 136, 23);
		panelRegistro.add(lblRegistroCargos);
		lblRegistroCargos.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));

		txtCodigoProveedor = new JTextField();
		txtCodigoProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigoProveedor.setEditable(false);
		txtCodigoProveedor.setBounds(125, 81, 43, 23);
		panelRegistro.add(txtCodigoProveedor);
		txtCodigoProveedor.setColumns(10);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnActualizar.setBackground(new Color(60, 179, 113));
		btnActualizar.setBounds(218, 378, 99, 23);
		panelRegistro.add(btnActualizar);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnAceptar.setBackground(new Color(255, 255, 255));
		btnAceptar.setBounds(24, 378, 99, 23);
		panelRegistro.add(btnAceptar);

		lbl_foto_contrato = new JLabel();
		lbl_foto_contrato.setBounds(218, 286, 96, 81);
		panelRegistro.add(lbl_foto_contrato);
		final ImageIcon iconofoto = new ImageIcon(iconoProducto.getImage()
				.getScaledInstance(lbl_foto_contrato.getWidth(), lbl_foto_contrato.getHeight(), Image.SCALE_DEFAULT));
		lbl_foto_contrato.setIcon(iconofoto);

		JLabel lblFoto = new JLabel("7. Correo :");
		lblFoto.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblFoto.setBounds(27, 258, 136, 17);
		panelRegistro.add(lblFoto);

		btnSubirFotoContrato = new JButton("Subir");
		btnSubirFotoContrato.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				selecionarFoto();
			}
		});
		btnSubirFotoContrato.setBackground(new Color(250, 128, 114));
		btnSubirFotoContrato.setBounds(24, 313, 70, 23);
		panelRegistro.add(btnSubirFotoContrato);

		txtDireccionFotoProveedor = new JTextField();
		txtDireccionFotoProveedor.setText("Sin Fotografia.");
		txtDireccionFotoProveedor.setEditable(false);
		txtDireccionFotoProveedor.setColumns(10);
		txtDireccionFotoProveedor.setBounds(24, 347, 145, 20);
		panelRegistro.add(txtDireccionFotoProveedor);

		btnVerFotoProducto = new JButton("Ver");
		btnVerFotoProducto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				verFotoContratoEmpleado();
			}
		});
		btnVerFotoProducto.setBackground(Color.WHITE);
		btnVerFotoProducto.setBounds(99, 313, 70, 23);
		panelRegistro.add(btnVerFotoProducto);

		txtNombresProveedor = new JTextField();
		txtNombresProveedor.setColumns(10);
		txtNombresProveedor.setBounds(125, 111, 189, 23);
		panelRegistro.add(txtNombresProveedor);
		InputMap map3 = txtNombresProveedor.getInputMap(JComponent.WHEN_FOCUSED);
		map3.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtNombresProveedor.addKeyListener(new KeyListener() {
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

		MaskFormatter formato4 = null;
		try {
			formato4 = new MaskFormatter("############");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtCuentaProveedor = new JFormattedTextField(formato4);
		txtCuentaProveedor.setColumns(10);
		txtCuentaProveedor.setBounds(125, 140, 189, 23);
		txtCuentaProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		panelRegistro.add(txtCuentaProveedor);
		InputMap map5 = txtCuentaProveedor.getInputMap(JComponent.WHEN_FOCUSED);
		map5.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtCuentaProveedor.addKeyListener(new KeyListener() {
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

		txtDireccionProveedor = new JTextField();
		txtDireccionProveedor.setColumns(10);
		txtDireccionProveedor.setBounds(125, 167, 189, 23);
		panelRegistro.add(txtDireccionProveedor);
		InputMap map51 = txtDireccionProveedor.getInputMap(JComponent.WHEN_FOCUSED);
		map51.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

		JLabel lblCapasidad = new JLabel("4. Direcci\u00F3n :");
		lblCapasidad.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblCapasidad.setBounds(27, 168, 136, 22);
		panelRegistro.add(lblCapasidad);

		JLabel lblColor = new JLabel("5. RTN:");
		lblColor.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblColor.setBounds(27, 195, 136, 22);
		panelRegistro.add(lblColor);

		MaskFormatter formato1 = null;
		try {
			formato1 = new MaskFormatter("##############");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtRtnProveedor = new JFormattedTextField(formato1);
		txtRtnProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		txtRtnProveedor.setColumns(10);
		txtRtnProveedor.setBounds(125, 194, 189, 23);
		panelRegistro.add(txtRtnProveedor);
		InputMap map2 = txtRtnProveedor.getInputMap(JComponent.WHEN_FOCUSED);
		map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtRtnProveedor.addKeyListener(new KeyListener() {
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

		JLabel lblPrecio = new JLabel("6. Telefono :");
		lblPrecio.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblPrecio.setBounds(27, 225, 136, 22);
		panelRegistro.add(lblPrecio);

		MaskFormatter formato2 = null;
		try {
			formato2 = new MaskFormatter("####-####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtTelefonoProveedor = new JFormattedTextField(formato2);
		txtTelefonoProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		txtTelefonoProveedor.setColumns(10);
		txtTelefonoProveedor.setBounds(125, 224, 189, 23);
		panelRegistro.add(txtTelefonoProveedor);
		InputMap map21 = txtTelefonoProveedor.getInputMap(JComponent.WHEN_FOCUSED);
		map21.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtTelefonoProveedor.addKeyListener(new KeyListener() {
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

		txtCorreoProveedor = new JTextField();
		txtCorreoProveedor.setColumns(10);
		txtCorreoProveedor.setBounds(125, 257, 189, 23);
		panelRegistro.add(txtCorreoProveedor);
		InputMap map22 = txtCorreoProveedor.getInputMap(JComponent.WHEN_FOCUSED);
		map22.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

		JLabel lblFotografiaDel = new JLabel("8. Fotografia del proveedor :");
		lblFotografiaDel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblFotografiaDel.setBounds(27, 285, 181, 17);
		panelRegistro.add(lblFotografiaDel);

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

		JLabel lblCargosRegistrados = new JLabel("Proveedores registrados :");
		lblCargosRegistrados.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblCargosRegistrados.setBounds(30, 41, 178, 19);
		panelTablaCargos.add(lblCargosRegistrados);

		JLabel lblBuscar = new JLabel("Buscar proveedor :");
		lblBuscar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblBuscar.setBounds(30, 63, 119, 22);
		panelTablaCargos.add(lblBuscar);

		txtBusqueda = new JTextField();
		txtBusqueda.setHorizontalAlignment(SwingConstants.CENTER);
		txtBusqueda.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtBusqueda.setColumns(10);
		txtBusqueda.setBounds(157, 64, 190, 21);
		panelTablaCargos.add(txtBusqueda);
		InputMap map4 = txtBusqueda.getInputMap(JComponent.WHEN_FOCUSED);
		txtBusqueda.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				trsfiltroCodigo = new TableRowSorter(tablaProveedores.getModel());
				tablaProveedores.setRowSorter(trsfiltroCodigo);
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
		panelTablaCargos.add(btnBorrar);

		barraProveedores = new JScrollPane(tablaProveedores, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panelTablaCargos.add(barraProveedores);
		barraProveedores.setBounds(28, 90, 376, 294);

		tablaProveedores = new JTable();
		barraProveedores.setViewportView(tablaProveedores);

		label_2 = new JLabel();
		label_2.setBounds(355, 41, 49, 44);
		panelTablaCargos.add(label_2);

		btnActualizarDatos = new JButton("Actualizar Datos");
		btnActualizarDatos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnActualizarDatos.setBackground(new Color(60, 179, 113));
		btnActualizarDatos.setBounds(267, 396, 137, 23);
		panelTablaCargos.add(btnActualizarDatos);

		btnVer = new JButton("Ver detalles");
		btnVer.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnVer.setBackground(new Color(0, 206, 209));
		btnVer.setBounds(149, 395, 108, 23);
		panelTablaCargos.add(btnVer);

		button = new JButton("Imprimir Reporte");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String fecha = getFechaYHora();
				String nombreEmpresa = ventana_principal.lbl_nombre_empresa_principal.getText();
				String encabezado = "Reporte de proveedores de " + nombreEmpresa;
				utilJTablePrint(tablaProveedores, encabezado,
						"Pagina {0}" + "                                                  " + fecha, true);
			}
		});
		button.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		button.setBackground(new Color(60, 179, 113));
		button.setBounds(214, 40, 133, 19);
		panelTablaCargos.add(button);

		JLabel label_5 = new JLabel();
		label_5.setBounds(0, 0, 431, 449);
		panelTablaCargos.add(label_5);
		final ImageIcon logo1 = new ImageIcon(
				icono.getImage().getScaledInstance(label_5.getWidth(), label_5.getHeight(), Image.SCALE_DEFAULT));
		label_5.setIcon(logo1);
		map4.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

	}

	public void construirTabla() {
		String titulos[] = { "Codigo", "Nombre", "Cuenta", "Direccion", "RTN", "Telefono", "Correo", "Foto" };
		String informacion[][] = control_proveedor.obtenerMatriz();
		tablaProveedores = new JTable(informacion, titulos);
		barraProveedores.setViewportView(tablaProveedores);
		for (int c = 0; c < tablaProveedores.getColumnCount(); c++) {
			Class<?> col_class = tablaProveedores.getColumnClass(c);
			tablaProveedores.setDefaultEditor(col_class, null);
			tablaProveedores.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			tablaProveedores.getTableHeader().setReorderingAllowed(false);

		}
	}

	public void filtro() {
		filtroCodigo = txtBusqueda.getText();
		trsfiltroCodigo.setRowFilter(RowFilter.regexFilter(txtBusqueda.getText(), 0, 1, 2, 3, 4, 5, 6));
	}

	public void pistas() {
		pista = new PlaceHolder(txtBusqueda, "Escriba para buscar.");
	}

	public void selecionarFoto() {
		JFileChooser archivo = new JFileChooser();
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Formatos de Archivos JPEG(*.JPG;*.JPEG)", "jpg",
				"jpeg");
		archivo.addChoosableFileFilter(filtro);
		archivo.setDialogTitle("Abrir Archivo");
		File ruta = new File("C:\\Users\\hp\\Documents\\GitHub\\Proyecto_Administrativo\\fotografias_empleados");
		archivo.setCurrentDirectory(ruta);
		int ventana = archivo.showOpenDialog(null);
		if (ventana == JFileChooser.APPROVE_OPTION) {
			File file = archivo.getSelectedFile();
			txtDireccionFotoProveedor.setText(String.valueOf(file));
			Image foto = getToolkit().getImage(txtDireccionFotoProveedor.getText());
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
			PreparedStatement stmtr = conn.prepareStatement("SELECT * FROM proveedores ORDER BY id_proveedor DESC");
			ResultSet rsr = stmtr.executeQuery();
			if (rsr.next()) {
				ultimoValor = rsr.getString("id_proveedor");
				valor = Integer.parseInt(ultimoValor);
				valor = valor + 1;
				id = String.valueOf(valor);
			}
			txtCodigoProveedor.setText(id);
			;
			stmtr.close();
			rsr.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verFotoContratoEmpleado() {
		if (txtDireccionFotoProveedor.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hay imagen que mostrar");
		} else {
			visor_imagen visor = new visor_imagen();
			ruta = txtDireccionFotoProveedor.getText().toString();
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
}
