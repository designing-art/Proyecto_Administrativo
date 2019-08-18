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
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.MaskFormatter;

import com.placeholder.PlaceHolder;

import conexion.conexion;
import controles.control_cliente;
import utilidades.visor_imagen;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import com.toedter.calendar.JTextFieldDateEditor;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class registro_clientes extends JFrame {
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

	public static String nombreEmpresa = null;
	public static String totalDatos = null;

	public static String ruta;
	public static ImageIcon imagen;

	public JPanel contentPane;
	public JTextField txtBusqueda;
	public JScrollPane barra;
	public JTable tabla;
	public JTextField txtCodigo;

	public static String ruta_logo;
	public static JLabel label;
	public static JLabel label_2;

	public JComboBox<?> cbxGeneroCliente;

	public TableRowSorter<TableModel> trsfiltroCodigo;
	String filtroCodigo;

	public ImageIcon icono = new ImageIcon(getClass().getResource("/iconos/libreta.png"));
	public ImageIcon icono2 = new ImageIcon(getClass().getResource("/iconos/libreta.png"));
	public ImageIcon iconoProducto = new ImageIcon(getClass().getResource("/iconos/usb.png"));
	public JButton btnAtras;
	public JButton button;
	public JTextField txtNombresCliente;
	public JTextField txtApellidosCliente;
	public JFormattedTextField txtTelefonoCliente;
	public JTextField txtCorreoCliente;
	public JTextField txtNombreEmpresa;
	public JTextArea txtDireccionCliente;
	public JLabel lblCantidad_1;
	public JTextFieldDateEditor editor;
	public JLabel lblFoto;
	public JLabel lblFotoC;
	public JLabel lblDatosDeLa;
	public JTextField txtFotoCliente;
	public JLabel lblTelefono;
	public JFormattedTextField txtTelefonoEmpresa;
	public JLabel lblCorreo;
	public JTextField txtCorreoEmpresa;
	public JLabel lblRtn;
	public JFormattedTextField txtRTNEmpresa;
	public JFormattedTextField txtIdentidadCliente;
	public JTextArea txtDireccionEmpresa;
	private JScrollPane scrollPane_2;
	public JTextArea txtDescripcionEmpresa;

	public registro_clientes() {
		setResizable(false);
		setDefaultCloseOperation(0);
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

		JLabel lblRegistrarCargo = new JLabel("REGISTRO Y MANTENIMIENTO DE CLIENTES DE LA EMPRESA");
		lblRegistrarCargo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblRegistrarCargo.setBounds(28, 20, 693, 29);
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

		JLabel txt = new JLabel("3. Apellidos :");
		txt.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txt.setBounds(27, 124, 99, 22);
		panelRegistro.add(txt);

		JLabel lblTipo = new JLabel("2. Nombres :");
		lblTipo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblTipo.setBounds(27, 97, 120, 23);
		panelRegistro.add(lblTipo);

		JLabel lblCodigo = new JLabel("1. Codigo :");
		lblCodigo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblCodigo.setBounds(27, 73, 63, 14);
		panelRegistro.add(lblCodigo);

		JLabel lblRegistroCargos = new JLabel("Datos del cliente:");
		lblRegistroCargos.setBounds(27, 39, 136, 32);
		panelRegistro.add(lblRegistroCargos);
		lblRegistroCargos.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));

		txtCodigo = new JTextField();
		txtCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(136, 70, 43, 23);
		panelRegistro.add(txtCodigo);
		txtCodigo.setColumns(10);

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

		txtNombresCliente = new JTextField();
		txtNombresCliente.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombresCliente.setColumns(10);
		txtNombresCliente.setBounds(136, 97, 178, 23);
		panelRegistro.add(txtNombresCliente);
		InputMap map1 = txtNombresCliente.getInputMap(JComponent.WHEN_FOCUSED);
		map1.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtNombresCliente.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();
				if (!Character.isLetter(ke.getKeyChar()) && !(ke.getKeyChar() == KeyEvent.VK_SPACE)
						&& !(ke.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
					ke.consume();
				}
				if (txtNombresCliente.getText().length() == 30)
					ke.consume();
			}

			@Override
			public void keyPressed(KeyEvent ke) {
			}

			@Override
			public void keyReleased(KeyEvent ke) {
			}
		});

		txtApellidosCliente = new JTextField();
		txtApellidosCliente.setHorizontalAlignment(SwingConstants.CENTER);
		txtApellidosCliente.setColumns(10);
		txtApellidosCliente.setBounds(136, 123, 178, 23);
		panelRegistro.add(txtApellidosCliente);
		InputMap map2 = txtApellidosCliente.getInputMap(JComponent.WHEN_FOCUSED);
		map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtApellidosCliente.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();
				if (!Character.isLetter(ke.getKeyChar()) && !(ke.getKeyChar() == KeyEvent.VK_SPACE)
						&& !(ke.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
					ke.consume();
				}
				if (txtApellidosCliente.getText().length() == 30)
					ke.consume();
			}

			@Override
			public void keyPressed(KeyEvent ke) {
			}

			@Override
			public void keyReleased(KeyEvent ke) {
			}
		});

		JLabel lblCapasidad = new JLabel("4. Direccion :");
		lblCapasidad.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblCapasidad.setBounds(27, 145, 136, 32);
		panelRegistro.add(lblCapasidad);

		JLabel lblColor = new JLabel("6. Telefono :");
		lblColor.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblColor.setBounds(27, 205, 136, 21);
		panelRegistro.add(lblColor);

		MaskFormatter formatter1 = null;
		try {
			formatter1 = new MaskFormatter("####-####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtTelefonoCliente = new JFormattedTextField(formatter1);
		txtTelefonoCliente.setHorizontalAlignment(SwingConstants.CENTER);
		txtTelefonoCliente.setColumns(10);
		txtTelefonoCliente.setBounds(136, 205, 178, 23);
		panelRegistro.add(txtTelefonoCliente);
		InputMap map3 = txtTelefonoCliente.getInputMap(JComponent.WHEN_FOCUSED);
		map3.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtTelefonoCliente.addKeyListener(new KeyListener() {
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

		JLabel lblPrecio = new JLabel("7. Correo :");
		lblPrecio.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblPrecio.setBounds(27, 231, 136, 23);
		panelRegistro.add(lblPrecio);

		txtCorreoCliente = new JTextField();
		txtCorreoCliente.setColumns(10);
		txtCorreoCliente.setBounds(136, 231, 178, 23);
		panelRegistro.add(txtCorreoCliente);
		InputMap map5 = txtCorreoCliente.getInputMap(JComponent.WHEN_FOCUSED);
		map5.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtCorreoCliente.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				if (txtCorreoCliente.getText().length() == 40)
					ke.consume();
			}

			@Override
			public void keyPressed(KeyEvent ke) {
			}

			@Override
			public void keyReleased(KeyEvent ke) {
			}
		});

		JLabel lblCantidad = new JLabel("8. Genero :");
		lblCantidad.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblCantidad.setBounds(27, 259, 136, 22);
		panelRegistro.add(lblCantidad);
		InputMap map51 = txtCorreoCliente.getInputMap(JComponent.WHEN_FOCUSED);
		map51.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

		JLabel lblModelo = new JLabel("10. Nombre :");
		lblModelo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblModelo.setBounds(27, 312, 136, 22);
		panelRegistro.add(lblModelo);

		txtNombreEmpresa = new JTextField();
		txtNombreEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombreEmpresa.setColumns(10);
		txtNombreEmpresa.setBounds(136, 312, 296, 23);
		panelRegistro.add(txtNombreEmpresa);
		InputMap map54 = txtNombreEmpresa.getInputMap(JComponent.WHEN_FOCUSED);
		map54.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtNombreEmpresa.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				if (txtNombreEmpresa.getText().length() == 30)
					ke.consume();
			}

			@Override
			public void keyPressed(KeyEvent ke) {
			}

			@Override
			public void keyReleased(KeyEvent ke) {
			}
		});

		JLabel lblExistencia = new JLabel("12. Direccion :");
		lblExistencia.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblExistencia.setBounds(27, 369, 88, 22);
		panelRegistro.add(lblExistencia);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(136, 147, 178, 30);
		panelRegistro.add(scrollPane);

		txtDireccionCliente = new JTextArea();
		scrollPane.setViewportView(txtDireccionCliente);
		InputMap map52 = txtDireccionCliente.getInputMap(JComponent.WHEN_FOCUSED);
		map52.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtDireccionCliente.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				if (txtDireccionCliente.getText().length() == 50) {
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
					String str = txtDireccionCliente.getText().trim();
					txtDireccionCliente.setText(str);
				}
			}
		});

		lblCantidad_1 = new JLabel("11. Descripcion :");
		lblCantidad_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblCantidad_1.setBounds(27, 339, 136, 22);
		panelRegistro.add(lblCantidad_1);

		lblFoto = new JLabel("9. Foto :");
		lblFoto.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblFoto.setBounds(324, 98, 75, 21);
		panelRegistro.add(lblFoto);

		lblFotoC = new JLabel("");
		lblFotoC.setBackground(Color.LIGHT_GRAY);
		lblFotoC.setBounds(324, 126, 108, 100);
		panelRegistro.add(lblFotoC);
		final ImageIcon iconoFoto = new ImageIcon(getClass().getResource("/iconos/usuario.png"));
		final ImageIcon logoFoto = new ImageIcon(
				iconoFoto.getImage().getScaledInstance(lblFotoC.getWidth(), lblFotoC.getHeight(), Image.SCALE_DEFAULT));
		lblFotoC.setIcon(logoFoto);

		cbxGeneroCliente = new JComboBox();
		cbxGeneroCliente.setModel(new DefaultComboBoxModel(new String[] { "F", "M" }));
		cbxGeneroCliente.setBounds(135, 261, 43, 20);
		panelRegistro.add(cbxGeneroCliente);

		lblDatosDeLa = new JLabel("Datos de la empresa del cliente :");
		lblDatosDeLa.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblDatosDeLa.setBounds(27, 282, 287, 32);
		panelRegistro.add(lblDatosDeLa);

		JButton button_1 = new JButton("Tomar");
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tomarFoto();
			}
		});
		button_1.setBackground(new Color(0, 255, 127));
		button_1.setBounds(340, 231, 83, 20);
		panelRegistro.add(button_1);

		JButton button_2 = new JButton("Ver");
		button_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				verFotoEmpleado();
			}
		});
		button_2.setBackground(Color.WHITE);
		button_2.setBounds(376, 97, 63, 22);
		panelRegistro.add(button_2);

		JButton button_3 = new JButton("Subir");
		button_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				selecionarFoto();

			}
		});
		button_3.setBackground(new Color(250, 128, 114));
		button_3.setBounds(340, 259, 83, 20);
		panelRegistro.add(button_3);

		txtFotoCliente = new JTextField();
		txtFotoCliente.setText("Sin Fotografia.");
		txtFotoCliente.setEditable(false);
		txtFotoCliente.setColumns(10);
		txtFotoCliente.setBounds(189, 260, 125, 23);
		panelRegistro.add(txtFotoCliente);

		lblTelefono = new JLabel("14. Telefono :");
		lblTelefono.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblTelefono.setBounds(27, 437, 88, 20);
		panelRegistro.add(lblTelefono);

		MaskFormatter formatter11 = null;
		try {
			formatter11 = new MaskFormatter("####-####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtTelefonoEmpresa = new JFormattedTextField(formatter11);
		txtTelefonoEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		txtTelefonoEmpresa.setColumns(10);
		txtTelefonoEmpresa.setBounds(136, 435, 296, 22);
		panelRegistro.add(txtTelefonoEmpresa);
		InputMap map31 = txtTelefonoEmpresa.getInputMap(JComponent.WHEN_FOCUSED);
		map31.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtTelefonoEmpresa.addKeyListener(new KeyListener() {
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

		lblCorreo = new JLabel("15. Correo:");
		lblCorreo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblCorreo.setBounds(27, 459, 88, 22);
		panelRegistro.add(lblCorreo);

		txtCorreoEmpresa = new JTextField();
		txtCorreoEmpresa.setColumns(10);
		txtCorreoEmpresa.setBounds(136, 460, 296, 22);
		panelRegistro.add(txtCorreoEmpresa);
		InputMap map30 = txtCorreoEmpresa.getInputMap(JComponent.WHEN_FOCUSED);
		map30.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtCorreoEmpresa.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				if (txtCorreoEmpresa.getText().length() == 40)
					ke.consume();
			}

			@Override
			public void keyPressed(KeyEvent ke) {
			}

			@Override
			public void keyReleased(KeyEvent ke) {
			}
		});

		lblRtn = new JLabel("13. RTN :");
		lblRtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblRtn.setBounds(27, 412, 88, 20);
		panelRegistro.add(lblRtn);

		MaskFormatter formato11 = null;
		try {
			formato11 = new MaskFormatter("##############");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtRTNEmpresa = new JFormattedTextField(formato11);
		txtRTNEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		txtRTNEmpresa.setColumns(10);
		txtRTNEmpresa.setBounds(136, 410, 296, 22);
		panelRegistro.add(txtRTNEmpresa);
		InputMap map28 = txtRTNEmpresa.getInputMap(JComponent.WHEN_FOCUSED);
		map28.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtRTNEmpresa.addKeyListener(new KeyListener() {
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

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(136, 375, 296, 32);
		panelRegistro.add(scrollPane_1);

		txtDireccionEmpresa = new JTextArea();
		scrollPane_1.setViewportView(txtDireccionEmpresa);
		InputMap map57 = txtDireccionEmpresa.getInputMap(JComponent.WHEN_FOCUSED);
		map57.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtDireccionEmpresa.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				if (txtDireccionEmpresa.getText().length() == 50) {
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
					String str = txtDireccionEmpresa.getText().trim();
					txtDireccionEmpresa.setText(str);
				}
			}
		});

		JLabel lblIdentidad = new JLabel("5. Identidad :");
		lblIdentidad.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblIdentidad.setBounds(27, 178, 99, 22);
		panelRegistro.add(lblIdentidad);

		MaskFormatter formato1 = null;
		try {
			formato1 = new MaskFormatter("####-####-#####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtIdentidadCliente = new JFormattedTextField(formato1);
		txtIdentidadCliente.setHorizontalAlignment(SwingConstants.CENTER);
		txtIdentidadCliente.setColumns(10);
		txtIdentidadCliente.setBounds(136, 179, 178, 23);
		panelRegistro.add(txtIdentidadCliente);
		InputMap map22 = txtIdentidadCliente.getInputMap(JComponent.WHEN_FOCUSED);
		map22.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtIdentidadCliente.addKeyListener(new KeyListener() {
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

		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(136, 339, 296, 32);
		panelRegistro.add(scrollPane_2);

		txtDescripcionEmpresa = new JTextArea();
		scrollPane_2.setViewportView(txtDescripcionEmpresa);
		InputMap map56 = txtDescripcionEmpresa.getInputMap(JComponent.WHEN_FOCUSED);
		map56.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtDescripcionEmpresa.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				if (txtDescripcionEmpresa.getText().length() == 50) {
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
					String str = txtDescripcionEmpresa.getText().trim();
					txtDescripcionEmpresa.setText(str);
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

		JLabel lblCargosRegistrados = new JLabel("Clientes registrados :");
		lblCargosRegistrados.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblCargosRegistrados.setBounds(30, 50, 166, 19);
		panelTablaCargos.add(lblCargosRegistrados);

		JLabel lblBuscar = new JLabel("Buscar Cliente :");
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
			@Override
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

					String encabezado = "Reporte de clientes de " + login_usuario.nombre.toString();

					utilJTablePrint(tabla, encabezado, "Pagina {0} de " + i + "          Impreso por: "
							+ login_usuario.nombreCompletoUsuario.toString() + "          " + fecha, true);

				}
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

	public void verFotoEmpleado() {
		if (txtFotoCliente.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hay imagen que mostrar");
		} else {
			visor_imagen visor = new visor_imagen();
			ruta = txtFotoCliente.getText().toString();
			visor.txtRutaImagen.setText(ruta);
			visor.setVisible(true);
			visor.setLocationRelativeTo(null);
			imagen = new ImageIcon(ruta);
			visor_imagen.lblImagen.setIcon(imagen);
		}
	}

	public void tomarFoto() {
		Runtime camara = Runtime.getRuntime();
		try {
			camara.exec("src/utilidades/cam.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void selecionarFoto() {
		JFileChooser archivo = new JFileChooser();
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Formatos de Archivos JPEG(*.JPG;*.JPEG)", "jpg",
				"jpeg");
		archivo.addChoosableFileFilter(filtro);
		archivo.setDialogTitle("Abrir Archivo");
		File ruta = new File("\\\\" + conexion.urlGlobal + "\\Sistema Administrativo\\Clientes");
		archivo.setCurrentDirectory(ruta);
		int ventana = archivo.showOpenDialog(null);
		if (ventana == JFileChooser.APPROVE_OPTION) {
			File file = archivo.getSelectedFile();
			txtFotoCliente.setText(String.valueOf(file));
			Image foto = getToolkit().getImage(txtFotoCliente.getText());
			foto = foto.getScaledInstance(lblFotoC.getHeight(), lblFotoC.getWidth(), Image.SCALE_DEFAULT);
			lblFotoC.setIcon(new ImageIcon(foto));
		}
	}

	public void obtenerTotalDatosReporte() {
		conexion objCon = new conexion();
		Connection conn = objCon.getConexion();
		try {
			PreparedStatement stmtr = conn.prepareStatement("SELECT * FROM clientes ORDER BY id_cliente DESC");
			ResultSet rsr = stmtr.executeQuery();
			if (rsr.next()) {
				totalDatos = rsr.getString("id_cliente");
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
