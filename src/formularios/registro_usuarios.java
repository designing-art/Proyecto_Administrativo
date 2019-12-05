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
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
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
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.MaskFormatter;

import com.placeholder.PlaceHolder;

import conexion.conexion;
import consultas.consultas_usuario;
import controles.control_usuario;
import utilidades.visor_imagen;

import javax.swing.SwingConstants;
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
	public static String nombreEmpresa = null;
	public static String totalDatos = null;

	public static String ruta;
	public static String usuario;
	public static ImageIcon imagen;

	public JPanel contentPane;
	public JTextField txtBusquedaDato;
	public JScrollPane barra;
	public JTable tabla;

	public static String ruta_logo;
	public static JLabel label_2;

	public JComboBox<?> cbxTipoUsuario;

	public TableRowSorter<TableModel> trsfiltroCodigo;
	String filtroCodigo;

	public ImageIcon icono = new ImageIcon(getClass().getResource("/iconos/libreta.png"));
	public ImageIcon icono2 = new ImageIcon(getClass().getResource("/iconos/libreta.png"));
	public ImageIcon iconoProducto = new ImageIcon(getClass().getResource("/iconos/usb.png"));
	final ImageIcon ver = new ImageIcon(getClass().getResource("/iconos/ver.png"));
	final ImageIcon ocultar = new ImageIcon(getClass().getResource("/iconos/ocultar.png"));

	public JButton btnAtras;
	public JButton button;
	public static JTextField txtNombres;
	public JTextFieldDateEditor editor;
	public JLabel lblDatosDeLa;
	public static JFormattedTextField txtIdentidad;
	public static JTextField txtCargo;
	public JLabel lblPermisos;
	public JLabel lblCargo;
	public JTextField txtUsuario;
	public JLabel lblContrasea;
	public JPasswordField txtContraseña;
	public JTextField txtCodigo;
	public static JFormattedTextField txtBusqueda;
	public JLabel label;
	public JButton btnBuscar;
	public static int contador;
	public static JLabel lblestadocontraseña;

	public static JRadioButton rdbtnEmpleados;
	public static JRadioButton rdbtnCargos;
	public static JRadioButton rdbtnHorarios;
	public static JRadioButton rdbtnContratos_e;
	public static JRadioButton rdbtnClientes;
	public static JRadioButton rdbtnContratos_c;
	public static JRadioButton rdbtnCompras;
	public static JRadioButton rdbtnProveedores;
	public static JRadioButton rdbtnInventario;
	public static JRadioButton rdbtnFactCliente;
	public static JRadioButton rdbtnFactEmpresa;
	public static JRadioButton rdbtnSar;
	public static JRadioButton rdbtnIngresos;
	public static JRadioButton rdbtnProductos;
	public static JRadioButton rdbtnServicios;
	public static JRadioButton rdbtnVentas;
	public static JRadioButton rdbtnEgresos;
	public static JRadioButton rdbtnBonificaciones;
	public static JRadioButton rdbtnDeducc;
	public static JRadioButton rdbtnPlanillas;
	public static JRadioButton rdbtnEmpresa;
	public static JRadioButton rdbtnConfiguracion;
	public static JRadioButton rdbtnAcercaDe;
	public static JRadioButton rdbtnUsuarios;
	public static JToggleButton rbdTodos;

	public static JRadioButton rdbtnPass;

	public static JTextField txtDirecFoto;
	public static JLabel lblFotoUsuario;
	public static JTextField lblUsuarioLogeado;;

	public registro_usuarios() {
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

		JLabel lblRegistrarCargo = new JLabel("REGISTRO Y MANTENIMIENTO DE PERMISOS Y USUARIOS DE LA EMPRESA");
		lblRegistrarCargo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblRegistrarCargo.setBounds(28, 26, 819, 23);
		contentPane.add(lblRegistrarCargo);
		scrollFunciones = new JScrollPane();

		JPanel panelRegistro = new JPanel();
		panelRegistro.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		panelRegistro.setBounds(28, 60, 465, 550);
		contentPane.add(panelRegistro);
		panelRegistro.setLayout(null);

		JPanel panelPermisos = new JPanel();
		panelPermisos.setBounds(37, 301, 387, 106);
		panelRegistro.add(panelPermisos);
		panelPermisos.setLayout(null);

		rdbtnEmpleados = new JRadioButton("Empleados");
		rdbtnEmpleados.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		rdbtnEmpleados.setBounds(6, 7, 90, 15);
		panelPermisos.add(rdbtnEmpleados);

		rdbtnCargos = new JRadioButton("Cargos");
		rdbtnCargos.setBounds(98, 7, 90, 15);
		panelPermisos.add(rdbtnCargos);

		rdbtnHorarios = new JRadioButton("Horarios");
		rdbtnHorarios.setBounds(190, 7, 90, 15);
		panelPermisos.add(rdbtnHorarios);

		rdbtnContratos_e = new JRadioButton("Contratos E.");
		rdbtnContratos_e.setBounds(282, 7, 90, 15);
		panelPermisos.add(rdbtnContratos_e);

		rdbtnClientes = new JRadioButton("Clientes");
		rdbtnClientes.setBounds(6, 21, 90, 15);
		panelPermisos.add(rdbtnClientes);

		rdbtnContratos_c = new JRadioButton("Contratos C.");
		rdbtnContratos_c.setBounds(98, 21, 90, 15);
		panelPermisos.add(rdbtnContratos_c);

		rdbtnCompras = new JRadioButton("Compras");
		rdbtnCompras.setBounds(190, 21, 90, 15);
		panelPermisos.add(rdbtnCompras);

		rdbtnProveedores = new JRadioButton("Proveedores");
		rdbtnProveedores.setBounds(282, 21, 90, 15);
		panelPermisos.add(rdbtnProveedores);

		rdbtnInventario = new JRadioButton("Inventario");
		rdbtnInventario.setBounds(6, 35, 90, 15);
		panelPermisos.add(rdbtnInventario);

		rdbtnFactCliente = new JRadioButton("Fact. Cliente");
		rdbtnFactCliente.setBounds(98, 35, 90, 15);
		panelPermisos.add(rdbtnFactCliente);

		rdbtnFactEmpresa = new JRadioButton("Fact. Empre");
		rdbtnFactEmpresa.setBounds(190, 35, 90, 15);
		panelPermisos.add(rdbtnFactEmpresa);

		rdbtnSar = new JRadioButton("SAR");
		rdbtnSar.setBounds(282, 35, 90, 15);
		panelPermisos.add(rdbtnSar);

		rdbtnIngresos = new JRadioButton("Ingresos");
		rdbtnIngresos.setBounds(6, 50, 90, 15);
		panelPermisos.add(rdbtnIngresos);

		rdbtnProductos = new JRadioButton("Productos");
		rdbtnProductos.setBounds(98, 50, 90, 15);
		panelPermisos.add(rdbtnProductos);

		rdbtnServicios = new JRadioButton("Servicios");
		rdbtnServicios.setBounds(190, 50, 90, 15);
		panelPermisos.add(rdbtnServicios);

		rdbtnVentas = new JRadioButton("Ventas");
		rdbtnVentas.setBounds(282, 50, 90, 15);
		panelPermisos.add(rdbtnVentas);

		rdbtnEgresos = new JRadioButton("Egresos");
		rdbtnEgresos.setBounds(6, 64, 90, 15);
		panelPermisos.add(rdbtnEgresos);

		rdbtnBonificaciones = new JRadioButton("Bonific.");
		rdbtnBonificaciones.setBounds(98, 64, 90, 15);
		panelPermisos.add(rdbtnBonificaciones);

		rdbtnDeducc = new JRadioButton("Deducc.");
		rdbtnDeducc.setBounds(190, 64, 90, 15);
		panelPermisos.add(rdbtnDeducc);

		rdbtnPlanillas = new JRadioButton("Planillas.");
		rdbtnPlanillas.setBounds(282, 64, 90, 15);
		panelPermisos.add(rdbtnPlanillas);

		rdbtnEmpresa = new JRadioButton("Empresa");
		rdbtnEmpresa.setBounds(6, 84, 90, 15);
		panelPermisos.add(rdbtnEmpresa);

		rdbtnConfiguracion = new JRadioButton("Opciones");
		rdbtnConfiguracion.setBounds(98, 84, 90, 15);
		panelPermisos.add(rdbtnConfiguracion);

		rdbtnAcercaDe = new JRadioButton("Usuarios");
		rdbtnAcercaDe.setBounds(190, 84, 90, 15);
		panelPermisos.add(rdbtnAcercaDe);

		rdbtnUsuarios = new JRadioButton("Acerca de.");
		rdbtnUsuarios.setBounds(282, 84, 90, 15);
		panelPermisos.add(rdbtnUsuarios);

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

		JLabel lblTipo = new JLabel("1. Nombre :");
		lblTipo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblTipo.setBounds(37, 136, 120, 23);
		panelRegistro.add(lblTipo);

		JLabel lblRegistroCargos = new JLabel("Datos del empleado:");
		lblRegistroCargos.setBounds(37, 104, 197, 32);
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
		txtNombres.setBounds(129, 134, 197, 23);
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
		JLabel lblCantidad = new JLabel("4. Tipo :");
		lblCantidad.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblCantidad.setBounds(37, 242, 136, 22);
		panelRegistro.add(lblCantidad);
		final ImageIcon iconoFoto = new ImageIcon(getClass().getResource("/iconos/usuario.png"));

		cbxTipoUsuario = new JComboBox();
		cbxTipoUsuario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				contador++;
				if (cbxTipoUsuario.getSelectedItem().equals("Usuario Normal") && contador > 0) {
					rdbtnEmpleados.setSelected(false);
					rdbtnCargos.setSelected(false);
					rdbtnHorarios.setSelected(false);
					rdbtnContratos_e.setSelected(false);
					rdbtnClientes.setSelected(false);
					rdbtnContratos_c.setSelected(false);
					rdbtnCompras.setSelected(false);
					rdbtnProveedores.setSelected(false);
					rdbtnInventario.setSelected(true);
					rdbtnFactCliente.setSelected(true);
					rdbtnFactEmpresa.setSelected(false);
					rdbtnSar.setSelected(true);
					rdbtnIngresos.setSelected(false);
					rdbtnProductos.setSelected(true);
					rdbtnServicios.setSelected(true);
					rdbtnVentas.setSelected(true);
					rdbtnEgresos.setSelected(false);
					rdbtnBonificaciones.setSelected(false);
					rdbtnDeducc.setSelected(false);
					rdbtnPlanillas.setSelected(false);
					rdbtnEmpresa.setSelected(false);
					rdbtnConfiguracion.setSelected(true);
					rdbtnAcercaDe.setSelected(true);
					rdbtnUsuarios.setSelected(false);
					rbdTodos.setSelected(false);
				} else {
					if (cbxTipoUsuario.getSelectedItem().equals("Usuario Administrador") && contador > 0) {
						rdbtnEmpleados.setSelected(true);
						rdbtnCargos.setSelected(true);
						rdbtnHorarios.setSelected(true);
						rdbtnContratos_e.setSelected(true);
						rdbtnClientes.setSelected(true);
						rdbtnContratos_c.setSelected(true);
						rdbtnCompras.setSelected(true);
						rdbtnProveedores.setSelected(true);
						rdbtnInventario.setSelected(true);
						rdbtnFactCliente.setSelected(true);
						rdbtnFactEmpresa.setSelected(true);
						rdbtnSar.setSelected(true);
						rdbtnIngresos.setSelected(false);
						rdbtnProductos.setSelected(true);
						rdbtnServicios.setSelected(true);
						rdbtnVentas.setSelected(true);
						rdbtnEgresos.setSelected(false);
						rdbtnBonificaciones.setSelected(true);
						rdbtnDeducc.setSelected(true);
						rdbtnPlanillas.setSelected(true);
						rdbtnEmpresa.setSelected(true);
						rdbtnConfiguracion.setSelected(true);
						rdbtnAcercaDe.setSelected(true);
						rdbtnUsuarios.setSelected(true);
						rbdTodos.setSelected(false);
					} else {
						if (cbxTipoUsuario.getSelectedItem().equals("Usuario Avanzado") && contador > 0) {
							rdbtnEmpleados.setSelected(true);
							rdbtnCargos.setSelected(true);
							rdbtnHorarios.setSelected(true);
							rdbtnContratos_e.setSelected(true);
							rdbtnClientes.setSelected(true);
							rdbtnContratos_c.setSelected(true);
							rdbtnCompras.setSelected(true);
							rdbtnProveedores.setSelected(true);
							rdbtnInventario.setSelected(true);
							rdbtnFactCliente.setSelected(true);
							rdbtnFactEmpresa.setSelected(true);
							rdbtnSar.setSelected(true);
							rdbtnIngresos.setSelected(true);
							rdbtnProductos.setSelected(true);
							rdbtnServicios.setSelected(true);
							rdbtnVentas.setSelected(true);
							rdbtnEgresos.setSelected(true);
							rdbtnBonificaciones.setSelected(true);
							rdbtnDeducc.setSelected(true);
							rdbtnPlanillas.setSelected(true);
							rdbtnEmpresa.setSelected(true);
							rdbtnConfiguracion.setSelected(true);
							rdbtnAcercaDe.setSelected(true);
							rdbtnUsuarios.setSelected(true);
							rbdTodos.setSelected(true);
						} else {
							if (cbxTipoUsuario.getSelectedItem().equals("Usuario Personalizado") && contador > 0) {
								rdbtnEmpleados.setSelected(false);
								rdbtnCargos.setSelected(false);
								rdbtnHorarios.setSelected(false);
								rdbtnContratos_e.setSelected(false);
								rdbtnClientes.setSelected(false);
								rdbtnContratos_c.setSelected(false);
								rdbtnCompras.setSelected(false);
								rdbtnProveedores.setSelected(false);
								rdbtnInventario.setSelected(false);
								rdbtnFactCliente.setSelected(false);
								rdbtnFactEmpresa.setSelected(false);
								rdbtnSar.setSelected(false);
								rdbtnIngresos.setSelected(false);
								rdbtnProductos.setSelected(false);
								rdbtnServicios.setSelected(false);
								rdbtnVentas.setSelected(false);
								rdbtnEgresos.setSelected(false);
								rdbtnBonificaciones.setSelected(false);
								rdbtnDeducc.setSelected(false);
								rdbtnPlanillas.setSelected(false);
								rdbtnEmpresa.setSelected(false);
								rdbtnConfiguracion.setSelected(false);
								rdbtnAcercaDe.setSelected(false);
								rdbtnUsuarios.setSelected(false);
								rbdTodos.setSelected(false);
							}

						}
					}
				}
			}
		});
		cbxTipoUsuario.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		cbxTipoUsuario.setModel(new DefaultComboBoxModel(new String[] { "Usuario Normal", "Usuario Administrador",
				"Usuario Avanzado", "Usuario Personalizado" }));
		cbxTipoUsuario.setBounds(129, 244, 147, 20);
		panelRegistro.add(cbxTipoUsuario);

		lblDatosDeLa = new JLabel("Registro de permisos y acceso del usuario :");
		lblDatosDeLa.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblDatosDeLa.setBounds(37, 214, 356, 32);
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

		JLabel lblIdentidad = new JLabel("2. Identidad :");
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
		txtIdentidad.setBounds(129, 160, 197, 23);
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

		JLabel lblApellidos = new JLabel("3. Cargo :");
		lblApellidos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblApellidos.setBounds(37, 185, 99, 22);
		panelRegistro.add(lblApellidos);

		txtCargo = new JTextField();
		txtCargo.setEditable(false);
		txtCargo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCargo.setColumns(10);
		txtCargo.setBounds(129, 186, 197, 23);
		panelRegistro.add(txtCargo);

		lblPermisos = new JLabel("5. Permisos :");
		lblPermisos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblPermisos.setBounds(37, 269, 136, 22);
		panelRegistro.add(lblPermisos);

		lblCargo = new JLabel("7. Usuario :");
		lblCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblCargo.setBounds(37, 418, 99, 22);
		panelRegistro.add(lblCargo);

		txtUsuario = new JTextField();
		txtUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(129, 419, 147, 23);
		panelRegistro.add(txtUsuario);
		InputMap map5 = txtUsuario.getInputMap(JComponent.WHEN_FOCUSED);
		map5.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsuario.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				if (txtUsuario.getText().length() == 15)
					ke.consume();
				
				if(txtUsuario.getText().toString().equals(" ")){
					JOptionPane.showMessageDialog(null, "No esta permitido escribir espacios vacios!");	
					txtUsuario.setText("");
				}
			}

			@Override
			public void keyPressed(KeyEvent ke) {
			}

			@Override
			public void keyReleased(KeyEvent ke) {
				try {
					conexion conex = new conexion();
					Statement estatuto = conex.getConexion().createStatement();
					ResultSet rs = estatuto.executeQuery(
							"SELECT usuario FROM usuario where usuario = '" + txtUsuario.getText().toString() + "'");
					if (rs.next() == true) {
						JOptionPane.showMessageDialog(null, "Este nombre de usuario ya existe");
						txtUsuario.setText("");
					} else {
						if (txtUsuario.getText().toString().equals("admin")) {
							JOptionPane.showMessageDialog(null, "Este nombre de usuario ya existe");
							txtUsuario.setText("");
						} else {
							rs.close();
							estatuto.close();
							conex.desconectar();
						}
					}

				} catch (SQLException exx) {
					System.out.println(exx.getMessage());
					JOptionPane.showMessageDialog(null, "Error al consultar", "Error", JOptionPane.ERROR_MESSAGE);

				}

			}
		});

		lblContrasea = new JLabel("8. Contrase\u00F1a :");
		lblContrasea.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblContrasea.setBounds(37, 446, 99, 22);
		panelRegistro.add(lblContrasea);

		txtContraseña = new JPasswordField();
		txtContraseña.setHorizontalAlignment(SwingConstants.CENTER);
		txtContraseña.setColumns(10);
		txtContraseña.setBounds(129, 447, 147, 23);
		panelRegistro.add(txtContraseña);
		InputMap map51 = txtContraseña.getInputMap(JComponent.WHEN_FOCUSED);
		map51.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtContraseña.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent ke) {
				if (txtContraseña.getText().toString().length() == 15)
					ke.consume();
				
				if(txtContraseña.getText().toString().equals(" ")){
					JOptionPane.showMessageDialog(null, "No esta permitido escribir espacios vacios!");	
					txtContraseña.setText("");
				}
			}

			@Override
			public void keyPressed(KeyEvent ke) {
			}

			@Override
			public void keyReleased(KeyEvent ke) {
			}
		});

		txtCodigo = new JTextField();
		txtCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(366, 243, 58, 23);
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
		txtBusqueda.setBounds(170, 84, 167, 20);
		panelRegistro.add(txtBusqueda);
		InputMap map42 = txtBusqueda.getInputMap(JComponent.WHEN_FOCUSED);
		map42.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtBusqueda.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();
				if ((c < '0' || c > '9'))
					ke.consume();
				
				if(txtBusqueda.getText().toString().equals(" ")){
					JOptionPane.showMessageDialog(null, "No esta permitido escribir espacios vacios!");	
					txtBusqueda.setText("");
				}
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
		label.setBounds(37, 80, 168, 27);
		panelRegistro.add(label);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(new Color(60, 179, 113));
		btnBuscar.setBounds(342, 83, 82, 23);
		panelRegistro.add(btnBuscar);
		btnBuscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (txtBusqueda.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor ingrese la identidad antes buscar");
				} else {
					busquedaDatosEmpleado();
				}
			}
		});

		rbdTodos = new JToggleButton("Todos");
		rbdTodos.setBackground(new Color(60, 179, 113));
		rbdTodos.setBounds(129, 271, 76, 19);
		panelRegistro.add(rbdTodos);
		rbdTodos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (rbdTodos.isSelected()) {
					rdbtnEmpleados.setSelected(true);
					rdbtnCargos.setSelected(true);
					rdbtnHorarios.setSelected(true);
					rdbtnContratos_e.setSelected(true);
					rdbtnClientes.setSelected(true);
					rdbtnContratos_c.setSelected(true);
					rdbtnCompras.setSelected(true);
					rdbtnProveedores.setSelected(true);
					rdbtnInventario.setSelected(true);
					rdbtnFactCliente.setSelected(true);
					rdbtnFactEmpresa.setSelected(true);
					rdbtnSar.setSelected(true);
					rdbtnIngresos.setSelected(true);
					rdbtnProductos.setSelected(true);
					rdbtnServicios.setSelected(true);
					rdbtnVentas.setSelected(true);
					rdbtnEgresos.setSelected(true);
					rdbtnBonificaciones.setSelected(true);
					rdbtnDeducc.setSelected(true);
					rdbtnPlanillas.setSelected(true);
					rdbtnEmpresa.setSelected(true);
					rdbtnConfiguracion.setSelected(true);
					rdbtnAcercaDe.setSelected(true);
					rdbtnUsuarios.setSelected(true);
					rbdTodos.setSelected(true);
					cbxTipoUsuario.setSelectedItem("Usuario Avanzado");
				} else {
					rdbtnEmpleados.setSelected(false);
					rdbtnCargos.setSelected(false);
					rdbtnHorarios.setSelected(false);
					rdbtnContratos_e.setSelected(false);
					rdbtnClientes.setSelected(false);
					rdbtnContratos_c.setSelected(false);
					rdbtnCompras.setSelected(false);
					rdbtnProveedores.setSelected(false);
					rdbtnInventario.setSelected(false);
					rdbtnFactCliente.setSelected(false);
					rdbtnFactEmpresa.setSelected(false);
					rdbtnSar.setSelected(false);
					rdbtnIngresos.setSelected(false);
					rdbtnProductos.setSelected(false);
					rdbtnServicios.setSelected(false);
					rdbtnVentas.setSelected(false);
					rdbtnEgresos.setSelected(false);
					rdbtnBonificaciones.setSelected(false);
					rdbtnDeducc.setSelected(false);
					rdbtnPlanillas.setSelected(false);
					rdbtnEmpresa.setSelected(false);
					rdbtnConfiguracion.setSelected(false);
					rdbtnAcercaDe.setSelected(false);
					rdbtnUsuarios.setSelected(false);
					rbdTodos.setSelected(false);
					cbxTipoUsuario.setSelectedItem("Usuario Personalizado");

				}

			}

		});

		JLabel lblBusquedaDelEmpleado = new JLabel("Busqueda del empleado :");
		lblBusquedaDelEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblBusquedaDelEmpleado.setBounds(37, 50, 249, 32);
		panelRegistro.add(lblBusquedaDelEmpleado);

		lblFotoUsuario = new JLabel("");
		lblFotoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblFotoUsuario.setBackground(Color.LIGHT_GRAY);
		lblFotoUsuario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblFotoUsuario.setBounds(340, 134, 84, 73);
		panelRegistro.add(lblFotoUsuario);
		final ImageIcon usu = new ImageIcon(getClass().getResource("/iconos/usuario.png"));
		final ImageIcon iconousuario = new ImageIcon(usu.getImage().getScaledInstance(lblFotoUsuario.getWidth(),
				lblFotoUsuario.getHeight(), Image.SCALE_DEFAULT));
		lblFotoUsuario.setIcon(iconousuario);

		txtDirecFoto = new JTextField();
		txtDirecFoto.setEditable(false);
		txtDirecFoto.setBounds(340, 115, 86, 12);
		panelRegistro.add(txtDirecFoto);
		txtDirecFoto.setColumns(10);

		JButton btnVerfoto = new JButton("Ver");
		btnVerfoto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (txtDirecFoto.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "No hay imagen que mostrar");
				} else {
					visor_imagen visor = new visor_imagen();
					ruta = txtDirecFoto.getText().toString();
					visor.txtRutaImagen.setText(ruta);
					visor.setVisible(true);
					visor.setLocationRelativeTo(null);
					imagen = new ImageIcon(ruta);
					visor_imagen.lblImagen.setIcon(imagen);
				}
			}
		});
		btnVerfoto.setBackground(new Color(255, 255, 255));
		btnVerfoto.setBounds(340, 209, 84, 12);
		panelRegistro.add(btnVerfoto);

		rdbtnPass = new JRadioButton("");
		rdbtnPass.setBackground(Color.WHITE);
		rdbtnPass.setBounds(282, 448, 21, 20);
		panelRegistro.add(rdbtnPass);

		lblestadocontraseña = new JLabel("");
		lblestadocontraseña.setBounds(309, 451, 21, 20);
		panelRegistro.add(lblestadocontraseña);
		final ImageIcon iconoocultar = new ImageIcon(ocultar.getImage().getScaledInstance(
				lblestadocontraseña.getWidth(), lblestadocontraseña.getHeight(), Image.SCALE_DEFAULT));
		lblestadocontraseña.setIcon(iconoocultar);

		JLabel lblLibreta = new JLabel();
		lblLibreta.setBounds(0, 0, 465, 550);
		panelRegistro.add(lblLibreta);
		final ImageIcon logo = new ImageIcon(
				icono.getImage().getScaledInstance(lblLibreta.getWidth(), lblLibreta.getHeight(), Image.SCALE_DEFAULT));
		lblLibreta.setIcon(logo);
		rdbtnPass.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtnPass.isSelected()) {
					txtContraseña.setEchoChar((char) 0);
					final ImageIcon iconover = new ImageIcon(ver.getImage().getScaledInstance(
							lblestadocontraseña.getWidth(), lblestadocontraseña.getHeight(), Image.SCALE_DEFAULT));
					lblestadocontraseña.setIcon(iconover);
				} else {
					txtContraseña.setEchoChar('*');
					final ImageIcon iconoocultar = new ImageIcon(ocultar.getImage().getScaledInstance(
							lblestadocontraseña.getWidth(), lblestadocontraseña.getHeight(), Image.SCALE_DEFAULT));
					lblestadocontraseña.setIcon(iconoocultar);
					setBackground(Color.BLACK);
				}
			}
		});

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

					String encabezado = "Reporte de usuarios de " + login_usuario.nombre.toString();

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

		lblUsuarioLogeado = new JTextField("usuario");
		lblUsuarioLogeado.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuarioLogeado.setBackground(Color.WHITE);
		lblUsuarioLogeado.setEditable(false);
		lblUsuarioLogeado.setForeground(new Color(220, 20, 60));
		lblUsuarioLogeado.setFont(new Font("Bauhaus 93", Font.BOLD, 15));
		lblUsuarioLogeado.setBounds(28, 0, 131, 23);
		contentPane.add(lblUsuarioLogeado);

	}

	public void construirTabla() {
		String titulos[] = { "Codigo", "Usuario", "Contraseña", "Identidad", "Nombre", "Cargo", "Tipo", "Permiso Todo",
				"Permiso Empleados", "Permiso Cargos", "Permiso Horarios", "Permiso Contr. Empl", "Permiso Clientes",
				"Permiso Contr. Clientes", "Permiso Compra", "Permiso Proveedor", "Permiso Inventario",
				"Permiso Fact. Client", "Permiso Fact. Empl", "Permiso SAR", "Permiso Ingreso", "Permiso Producto",
				"Permiso Servicio", "Permiso Venta", "Permiso Egreso", "Permiso Bonificacion", "Permiso Deduccion",
				"Permiso Planilla", "Permiso Empresa", "Permiso Opciones", "Permiso Usuarios", "Permiso Acerca De",
				"Foto" };
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
			txtNombres.setText(String.valueOf(clase.getNombres_empleado()) + " "
					+ (String.valueOf(clase.getApellidos_empleado())));
			txtIdentidad.setText(String.valueOf(clase.getIdentidad_empleado()));
			txtCargo.setText(String.valueOf(clase.getNombre_cargo_empleado()));
			txtDirecFoto.setText(String.valueOf(clase.getDireccion_foto_empleado()));
			String foto = String.valueOf(clase.getDireccion_foto_empleado());

			txtNombres.setForeground(Color.BLACK);
			txtIdentidad.setForeground(Color.BLACK);
			txtCargo.setForeground(Color.BLACK);

			final ImageIcon icono = new ImageIcon(foto);
			final ImageIcon iconofoto = new ImageIcon(icono.getImage().getScaledInstance(lblFotoUsuario.getWidth(),
					lblFotoUsuario.getHeight(), Image.SCALE_DEFAULT));
			lblFotoUsuario.setIcon(iconofoto);

		} else {
			JOptionPane.showMessageDialog(null, "No se encontro ningun registro");

		}
	}

	public void obtenerTotalDatosReporte() {
		conexion objCon = new conexion();
		Connection conn = objCon.getConexion();
		try {
			PreparedStatement stmtr = conn.prepareStatement("SELECT * FROM usuario ORDER BY id_usuario DESC");
			ResultSet rsr = stmtr.executeQuery();
			if (rsr.next()) {
				totalDatos = rsr.getString("id_usuario");
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
