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
import consultas.consultas_bonificacion;
import consultas.consultas_planilla;
import consultas.consultas_usuario;
import controles.control_cliente;
import controles.control_inventario;
import controles.control_usuario;
import utilidades.visor_imagen;

import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.JTextArea;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import clases.empleado;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;

public class registro_usuarios extends JFrame {
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
	public JTextField txtBusquedaDato;
	public JScrollPane barra;
	public JTable tabla;

	public static String ruta_logo;
	public static JLabel label_2;

	public JComboBox<?> cbxTipoUsuario;
	public JComboBox<?> cbxPermiso;

	public TableRowSorter<TableModel> trsfiltroCodigo;
	String filtroCodigo;

	public ImageIcon icono = new ImageIcon(getClass().getResource("/iconos/libreta.png"));
	public ImageIcon icono2 = new ImageIcon(getClass().getResource("/iconos/libreta.png"));
	public ImageIcon iconoProducto = new ImageIcon(getClass().getResource("/iconos/usb.png"));
	public JButton btnAtras;
	public JButton button;
	public JTextField txtNombres;
	public JTextField txtApellidos;
	public JTextFieldDateEditor editor;
	public JLabel lblDatosDeLa;
	public JFormattedTextField txtIdentidad;
	public JTextField txtCargo;
	public JLabel lblPermisos;
	public JLabel lblCargo;
	public JTextField txtUsuario;
	public JLabel lblContrasea;
	public JTextField txtContraseña;
	private JTextArea txtrNivel;
	private JTextArea txtrNivel_1;
	private JTextArea txtrNivel_2;
	public JTextField txtCodigo;
	public JFormattedTextField txtBusqueda;
	public JLabel label;
	public JButton btnBuscar;

	public registro_usuarios() {
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

		JLabel lblRegistrarCargo = new JLabel("REGISTRO Y MANTENIMIENTO DE PERMISOS Y USUARIOS DE LA EMPRESA");
		lblRegistrarCargo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblRegistrarCargo.setBounds(28, 20, 819, 29);
		contentPane.add(lblRegistrarCargo);
		scrollFunciones = new JScrollPane();

		JPanel panelRegistro = new JPanel();
		panelRegistro.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		panelRegistro.setBounds(28, 60, 465, 550);
		contentPane.add(panelRegistro);
		panelRegistro.setLayout(null);

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

		JLabel txt = new JLabel("2. Apellidos :");
		txt.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txt.setBounds(37, 135, 99, 20);
		panelRegistro.add(txt);

		JLabel lblTipo = new JLabel("1. Nombres :");
		lblTipo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblTipo.setBounds(37, 110, 120, 23);
		panelRegistro.add(lblTipo);

		JLabel lblRegistroCargos = new JLabel("Datos del usuario :");
		lblRegistroCargos.setBounds(37, 81, 136, 32);
		panelRegistro.add(lblRegistroCargos);
		lblRegistroCargos.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));

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

		MaskFormatter formato = null;
		try {
			formato = new MaskFormatter("####-####-#####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		txtNombres = new JTextField();
		txtNombres.setEditable(false);
		txtNombres.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombres.setColumns(10);
		txtNombres.setBounds(129, 108, 295, 23);
		panelRegistro.add(txtNombres);
		InputMap map1 = txtNombres.getInputMap(JComponent.WHEN_FOCUSED);
		map1.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtNombres.addKeyListener(new KeyListener() {
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

		txtApellidos = new JTextField();
		txtApellidos.setEditable(false);
		txtApellidos.setHorizontalAlignment(SwingConstants.CENTER);
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(129, 134, 295, 23);
		panelRegistro.add(txtApellidos);
		InputMap map2 = txtApellidos.getInputMap(JComponent.WHEN_FOCUSED);
		map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtNombres.addKeyListener(new KeyListener() {
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

		MaskFormatter formatter1 = null;
		try {
			formatter1 = new MaskFormatter("####-####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		JLabel lblCantidad = new JLabel("5. Tipo :");
		lblCantidad.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblCantidad.setBounds(37, 242, 136, 22);
		panelRegistro.add(lblCantidad);
		final ImageIcon iconoFoto = new ImageIcon(getClass().getResource("/iconos/usuario.png"));

		cbxTipoUsuario = new JComboBox();
		cbxTipoUsuario.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		cbxTipoUsuario.setModel(new DefaultComboBoxModel(
				new String[] { "Usuario Normal", "Usuario Administrador", "Usuario Avanzado" }));
		cbxTipoUsuario.setBounds(129, 244, 147, 20);
		panelRegistro.add(cbxTipoUsuario);

		lblDatosDeLa = new JLabel("Registro de permisos y acceso del usuario :");
		lblDatosDeLa.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblDatosDeLa.setBounds(37, 214, 387, 32);
		panelRegistro.add(lblDatosDeLa);

		MaskFormatter formatter11 = null;
		try {
			formatter11 = new MaskFormatter("####-####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		MaskFormatter formato11 = null;
		try {
			formato11 = new MaskFormatter("##############");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		JLabel lblIdentidad = new JLabel("3. Identidad :");
		lblIdentidad.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblIdentidad.setBounds(38, 160, 99, 22);
		panelRegistro.add(lblIdentidad);

		MaskFormatter formato1 = null;
		try {
			formato1 = new MaskFormatter("####-####-#####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtIdentidad = new JFormattedTextField(formato1);
		txtIdentidad.setEditable(false);
		txtIdentidad.setHorizontalAlignment(SwingConstants.CENTER);
		txtIdentidad.setColumns(10);
		txtIdentidad.setBounds(129, 160, 295, 23);
		panelRegistro.add(txtIdentidad);
		InputMap map22 = txtIdentidad.getInputMap(JComponent.WHEN_FOCUSED);
		map22.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtIdentidad.addKeyListener(new KeyListener() {
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

		JLabel lblApellidos = new JLabel("4. Cargo :");
		lblApellidos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblApellidos.setBounds(37, 185, 99, 22);
		panelRegistro.add(lblApellidos);

		txtCargo = new JTextField();
		txtCargo.setEditable(false);
		txtCargo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCargo.setColumns(10);
		txtCargo.setBounds(129, 186, 295, 23);
		panelRegistro.add(txtCargo);

		lblPermisos = new JLabel("6. Permisos :");
		lblPermisos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblPermisos.setBounds(37, 269, 136, 22);
		panelRegistro.add(lblPermisos);

		lblCargo = new JLabel("7. Usuario :");
		lblCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblCargo.setBounds(37, 406, 99, 22);
		panelRegistro.add(lblCargo);

		txtUsuario = new JTextField();
		txtUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(129, 407, 147, 23);
		panelRegistro.add(txtUsuario);

		lblContrasea = new JLabel("8. Contrase\u00F1a :");
		lblContrasea.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblContrasea.setBounds(37, 434, 99, 22);
		panelRegistro.add(lblContrasea);

		txtContraseña = new JTextField();
		txtContraseña.setHorizontalAlignment(SwingConstants.CENTER);
		txtContraseña.setColumns(10);
		txtContraseña.setBounds(129, 435, 147, 23);
		panelRegistro.add(txtContraseña);
		
		cbxPermiso = new JComboBox();
		cbxPermiso.setModel(new DefaultComboBoxModel(new String[] {"Nivel 3 (Empleado)", "Nivel 2 (Administrador)", "Nivel 1 (Due\u00F1o)"}));
		cbxPermiso.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		cbxPermiso.setBounds(129, 270, 147, 20);
		panelRegistro.add(cbxPermiso);
		
		txtrNivel = new JTextArea();
		txtrNivel.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 12));
		txtrNivel.setText("Nivel 3 : Acceso a : Compras, Inventario, Ventas, Productos, Servicios, Ingresos.");
		txtrNivel.setBackground(new Color(192, 192, 192));
		txtrNivel.setEditable(false);
		txtrNivel.setBounds(37, 296, 397, 32);
		panelRegistro.add(txtrNivel);
		
		txtrNivel_1 = new JTextArea();
		txtrNivel_1.setText("Nivel 2 : Acceso a : Empleados, Cargos, Horarios, Contratos, Bonificaciones\r\nDeducciones, Planillas, Clientes, Contratos, Facturas, Ingresos, Egresos.");
		txtrNivel_1.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 12));
		txtrNivel_1.setEditable(false);
		txtrNivel_1.setBackground(Color.LIGHT_GRAY);
		txtrNivel_1.setBounds(37, 334, 397, 32);
		panelRegistro.add(txtrNivel_1);
		
		txtrNivel_2 = new JTextArea();
		txtrNivel_2.setText("Nivel 1 : Acceso a : Todo.");
		txtrNivel_2.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 12));
		txtrNivel_2.setEditable(false);
		txtrNivel_2.setBackground(Color.LIGHT_GRAY);
		txtrNivel_2.setBounds(37, 371, 397, 32);
		panelRegistro.add(txtrNivel_2);
		
		txtCodigo = new JTextField();
		txtCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(347, 242, 58, 23);
		panelRegistro.add(txtCodigo);
		txtCodigo.setVisible(false);
		
		MaskFormatter formatooo = null;
		try {
			formatooo = new MaskFormatter("####-####-#####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtBusqueda = new JFormattedTextField(formatooo);
		txtBusqueda.setHorizontalAlignment(SwingConstants.CENTER);
		txtBusqueda.setColumns(10);
		txtBusqueda.setBounds(170, 60, 167, 20);
		panelRegistro.add(txtBusqueda);
		InputMap map42 = txtBusqueda.getInputMap(JComponent.WHEN_FOCUSED);
		map42.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtBusqueda.addKeyListener(new KeyListener() {
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

		
		label = new JLabel("Ingrese la Identidad :");
		label.setForeground(new Color(0, 128, 0));
		label.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		label.setBounds(37, 56, 168, 27);
		panelRegistro.add(label);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(new Color(60, 179, 113));
		btnBuscar.setBounds(342, 59, 82, 23);
		panelRegistro.add(btnBuscar);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtBusqueda.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor ingrese la identidad antes buscar");
				} else {
					busquedaDatosEmpleado();
				}
			}
		});
		

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

		JLabel lblCargosRegistrados = new JLabel("Usuarios registrados :");
		lblCargosRegistrados.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblCargosRegistrados.setBounds(30, 50, 166, 19);
		panelTablaCargos.add(lblCargosRegistrados);

		JLabel lblBuscar = new JLabel("Buscar Usuario :");
		lblBuscar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblBuscar.setBounds(30, 72, 119, 22);
		panelTablaCargos.add(lblBuscar);

		txtBusquedaDato = new JTextField();
		txtBusquedaDato.setHorizontalAlignment(SwingConstants.CENTER);
		txtBusquedaDato.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtBusquedaDato.setColumns(10);
		txtBusquedaDato.setBounds(138, 73, 257, 21);
		panelTablaCargos.add(txtBusquedaDato);
		InputMap map6 = txtBusquedaDato.getInputMap(JComponent.WHEN_FOCUSED);
		map6.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtBusquedaDato.addKeyListener(new KeyListener() {
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
				String cadena = (txtBusquedaDato.getText());
				txtBusquedaDato.setText(cadena);
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
				String encabezado = "Reporte de usuarios de " + nombreEmpresa;
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
		String titulos[] = { "Codigo", "Usuario", "Contraseña", "Identidad", "Nombre", "Cargo", "Tipo", "Permisos"};
		String informacion[][] = control_usuario.obtenerMatriz();
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
		filtroCodigo = txtBusquedaDato.getText();
		trsfiltroCodigo.setRowFilter(RowFilter.regexFilter(txtBusquedaDato.getText(), 0, 1, 2, 3, 4, 5, 6));
	}

	public void pistas() {
		pista = new PlaceHolder(txtBusquedaDato, "Escriba para buscar.");
	}

	public void obtenerUltimoId() {
		String ultimoValor = null;
		int valor;
		String id = null;
		conexion objCon = new conexion();
		Connection conn = objCon.getConexion();
		try {
			PreparedStatement stmtr = conn.prepareStatement("SELECT * FROM usuario ORDER BY id_usuario DESC");
			ResultSet rsr = stmtr.executeQuery();
			if (rsr.next()) {
				ultimoValor = rsr.getString("id_usuario");
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
	
	public void busquedaDatosEmpleado() {
		consultas_usuario consulta = new consultas_usuario();
		empleado clase = new empleado();
		clase.setIdentidad_empleado(txtBusqueda.getText());
		if (consulta.buscar(clase)) {
			txtNombres.setText(String.valueOf(clase.getNombres_empleado()));
			txtApellidos.setText(String.valueOf(clase.getApellidos_empleado()));
			txtIdentidad.setText(String.valueOf(clase.getIdentidad_empleado()));
			txtCargo.setText(String.valueOf(clase.getNombre_cargo_empleado()));

			txtNombres.setForeground(Color.BLACK);
			txtApellidos.setForeground(Color.BLACK);
			txtIdentidad.setForeground(Color.BLACK);
			txtCargo.setForeground(Color.BLACK);

		} else {
			JOptionPane.showMessageDialog(null, "No se encontro ningun registro");

		}
	}

}
