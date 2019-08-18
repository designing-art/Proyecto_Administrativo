package formularios;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.ImageIcon;

import clases.bonificacion;
import clases.cargo;
import clases.cliente;
import clases.compra;
import clases.configuracion;
import clases.contrato_cliente;
import clases.contrato_empleado;
import clases.deduccion;
import clases.egreso;
import clases.empleado;
import clases.empresa;
import clases.factura_cliente;
import clases.factura_empresa;
import clases.historial_planilla;
import clases.horario;
import clases.ingreso;
import clases.inventario;
import clases.planilla;

import clases.producto;
import clases.proveedor;
import clases.sar;
import clases.servicio;
import clases.usuario;
import clases.venta;
import conexion.conexion;
import consultas.consultas_bonificacion;
import consultas.consultas_cargo;
import consultas.consultas_cliente;
import consultas.consultas_compra;
import consultas.consultas_configuracion;
import consultas.consultas_contrato_cliente;
import consultas.consultas_contrato_empleado;
import consultas.consultas_deduccion;
import consultas.consultas_egreso;
import consultas.consultas_empleado;
import consultas.consultas_empresa;
import consultas.consultas_factura_cliente;
import consultas.consultas_factura_empresa;
import consultas.consultas_historial_planilla;
import consultas.consultas_horario;
import consultas.consultas_inventario;
import consultas.consultas_planilla;
import consultas.consultas_producto;
import consultas.consultas_proveedor;
import consultas.consultas_sar;
import consultas.consultas_servicio;
import consultas.consultas_usuario;
import consultas.consultas_venta;
import controles.control_bonificacion;
import controles.control_cargo;
import controles.control_cliente;
import controles.control_compra;
import controles.control_configuracion;
import controles.control_contrato_cliente;
import controles.control_contrato_empleado;
import controles.control_deduccion;
import controles.control_egresos;
import controles.control_empleado;
import controles.control_empresa;
import controles.control_factura_cliente;
import controles.control_factura_empresa;
import controles.control_historial_planilla;
import controles.control_horario;
import controles.control_inventario;
import controles.control_planilla;
import controles.control_producto;
import controles.control_proveedor;
import controles.control_sar;
import controles.control_servicio;
import controles.control_usuario;
import controles.control_venta;
import java.awt.event.ActionListener;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

public class ventana_principal extends JFrame {

	public static JPanel contentPane;
	public static JButton btnPlanilla;
	public static JButton btnContratoEmpleado;
	public static JButton btnEmpleado;
	public static JButton btnCargo;
	public static JButton btnDeducciones;
	public static JButton btnBonificaciones;
	public static JButton btnInformacionEmpresa;
	public static JButton btnHorario;
	public JLabel lbl_horaSistema;
	public JLabel lbl_fechaSistema;
	public static JTextField txtFrase;
	public static JLabel labelfotousuario;

	public static JButton btnProducto;

	public static JLabel lbl_logo_empresa_principal;
	public static JLabel lbl_nombre_empresa_principal;
	public static String nombre = null;
	public static String ruta_logo = null;
	public empresa clase;
	public consultas_empresa consulta;
	public registro_empresa formulario;
	public static JButton btnProveedores;
	public static JButton btnContratoCliente;
	public static JButton btnServicio;
	public static JButton btnCliente;
	public static JButton btnCompras;
	public static JButton btnInventario;
	public static JButton btnVentas;
	public static JButton btnIngreso;
	public static JButton btnEgreso;
	public static JButton btnSar;
	public static JButton btnFacturasClientes;
	public static JButton btnFacturasEmpresa;
	public static JButton btnAcercaDe;
	public static JButton btnOpciones;
	public static JButton btnUsuarios;

	public static JLabel lblTipoUsuario;
	public static JLabel lblCargoUsuario;
	public static JLabel lblNombreUsuario;

	public static JPanel panelEmpleados;
	public static JPanel panelClientes;
	public static JPanel panelFacturas;
	public static JPanel panelFinanzas;
	public static JPanel panelOpciones;
	public static JPanel panelInventario;

	public static String sardato = null;
	public static String productodato = null;

	public static String todo;
	public static String empleado;
	public static String cargoe;
	public static String horario;
	public static String contrato_e;
	public static String cliente;
	public static String contrato_c;
	public static String compra;
	public static String proveedor;
	public static String inventario;
	public static String factura_c;
	public static String factura_e;
	public static String sar;
	public static String ingreso;
	public static String producto;
	public static String servicio;
	public static String venta;
	public static String egreso;
	public static String bonificacion;
	public static String deduccion;
	public static String planilla;
	public static String empresa;
	public static String opciones;
	public static String usuarios;
	public static String acercade;

	public ventana_principal() {
		setType(Type.POPUP);
		setResizable(false);
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent evt) {
				close();
			}
		});
		setBounds(100, 100, 700, 580);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/iconos/icono_d_a.jpg")));
		final ImageIcon logo2 = new ImageIcon(getClass().getResource("/iconos/libreta.png"));
		final ImageIcon logousuario = new ImageIcon(getClass().getResource("/iconos/usuario.png"));
		final ImageIcon logo = new ImageIcon(getClass().getResource("/iconos/logo_estandar.png"));

		JLabel lblMenuDeOpciones = new JLabel("Men\u00FA de Opciones :");
		lblMenuDeOpciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuDeOpciones.setForeground(Color.BLACK);
		lblMenuDeOpciones.setFont(new Font("Cooper Black", Font.PLAIN, 15));
		lblMenuDeOpciones.setBounds(46, 79, 327, 34);
		contentPane.add(lblMenuDeOpciones);

		panelEmpleados = new JPanel();
		panelEmpleados.setBackground(Color.WHITE);
		panelEmpleados.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelEmpleados.setBounds(46, 111, 327, 86);
		contentPane.add(panelEmpleados);
		panelEmpleados.setLayout(null);

		btnPlanilla = new JButton("Planillas");
		btnPlanilla.setForeground(Color.BLACK);
		btnPlanilla.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		btnPlanilla.setBackground(new Color(102, 205, 170));
		btnPlanilla.setBounds(10, 64, 97, 21);
		panelEmpleados.add(btnPlanilla);
		btnPlanilla.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				planilla clase = new planilla();
				historial_planilla clase2 = new historial_planilla();
				consultas_planilla consulta = new consultas_planilla();
				registro_planillas formulario = new registro_planillas();
				control_planilla control = new control_planilla(clase, clase2, consulta, formulario);
				formulario.setVisible(true);
				formulario.setLocationRelativeTo(null);
				registro_planillas.txtIdentidadEmpleadoPlanilla.requestFocusInWindow();
				formulario.btnBorrarPlanilla.setVisible(false);
				formulario.btnGuardar.setVisible(true);
				formulario.btnNuevo.setVisible(true);
				formulario.btnActualizar.setVisible(false);
				formulario.btnActualizarDatosPlanilla.setVisible(true);
				formulario.btnVerPlanilla.setVisible(true);
				formulario.btnAceptar.setVisible(false);
				formulario.consultarPlanillaActual();
				formulario.construirTabla();
				formulario.construirTablaEmpleados();
				formulario.obtenerUltimoId();
				formulario.establecerFechaRegistro();
				Timer time = new Timer();
				time.schedule(formulario.tarea, 0, 1000);
				formulario.setTitle("Sesión iniciada por: " + login_usuario.nombreCompletoUsuario);
				dispose();
			}
		});

		btnContratoEmpleado = new JButton("Contratos");
		btnContratoEmpleado.setForeground(Color.BLACK);
		btnContratoEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		btnContratoEmpleado.setBackground(new Color(102, 205, 170));
		btnContratoEmpleado.setBounds(10, 41, 97, 21);
		panelEmpleados.add(btnContratoEmpleado);
		btnContratoEmpleado.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				contrato_empleado clase = new contrato_empleado();
				consultas_contrato_empleado consulta = new consultas_contrato_empleado();
				registro_contratos_empleados formulario = new registro_contratos_empleados();
				control_contrato_empleado control = new control_contrato_empleado(clase, consulta, formulario);
				formulario.setVisible(true);
				formulario.setLocationRelativeTo(null);
				formulario.txtBusquedaContratosEmpleados.requestFocusInWindow();
				formulario.obtenerUltimoId();
				formulario.pistas();
				formulario.consultarEmpresa();
				formulario.construirTabla();
				formulario.btnGuardarContrato.setVisible(true);
				formulario.btnNuevoContrato.setVisible(true);
				formulario.btnActualizarContrato.setVisible(false);
				formulario.btnAceptar.setVisible(false);
				formulario.btnBorrarContrato.setVisible(false);
				formulario.btnAsignar.setVisible(false);
				formulario.setTitle("Sesión iniciada por: " + login_usuario.nombreCompletoUsuario);
				dispose();
			}
		});

		btnEmpleado = new JButton("Empleados");
		btnEmpleado.setForeground(Color.BLACK);
		btnEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		btnEmpleado.setBackground(new Color(102, 205, 170));
		btnEmpleado.setBounds(10, 19, 97, 21);
		panelEmpleados.add(btnEmpleado);
		btnEmpleado.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				empleado clase = new empleado();
				consultas_empleado consulta = new consultas_empleado();
				usuario clase2 = new usuario();
				consultas_usuario consulta2 = new consultas_usuario();
				registro_empleados formulario = new registro_empleados();
				control_empleado control = new control_empleado(clase, clase2, consulta, consulta2, formulario);
				formulario.setVisible(true);
				formulario.setLocationRelativeTo(null);
				formulario.txtNombresEmpleado.requestFocusInWindow();
				formulario.obtenerUltimoId();
				formulario.consultarEmpresa();
				formulario.establecerFechaRegistro();
				formulario.construirTablaEmpleados();
				formulario.btnNuevoEmpleado.setVisible(true);
				formulario.btnMostrarEmpleado.setVisible(true);
				formulario.btnActualizarDatosEmpleado.setVisible(true);
				formulario.btnActualizarEmpleado.setVisible(false);
				formulario.btnCancelarEmpleado.setVisible(false);
				formulario.btnBorrarEmpleado.setVisible(false);
				formulario.setTitle("Sesión iniciada por: " + login_usuario.nombreCompletoUsuario);
				dispose();
			}
		});

		btnCargo = new JButton("Cargos");
		btnCargo.setForeground(Color.BLACK);
		btnCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		btnCargo.setBackground(new Color(102, 205, 170));
		btnCargo.setBounds(117, 19, 97, 21);
		panelEmpleados.add(btnCargo);
		btnCargo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cargo clase = new cargo();
				consultas_cargo consulta = new consultas_cargo();
				registro_cargos formulario = new registro_cargos();
				control_cargo control = new control_cargo(clase, consulta, formulario);
				formulario.setVisible(true);
				formulario.setLocationRelativeTo(null);
				formulario.txtNombreCargo.requestFocusInWindow();
				formulario.construirTabla();
				formulario.obtenerUltimoId();
				formulario.consultarEmpresa();
				formulario.btnBorrarCargo.setVisible(false);
				formulario.btnGuardarCargo.setVisible(true);
				formulario.btnNuevoCargo.setVisible(true);
				formulario.btnActualizarCargo.setVisible(false);
				formulario.btnActualizarDatosCargo.setVisible(true);
				formulario.btnMostrar.setVisible(true);
				formulario.btnAceptar.setVisible(false);
				formulario.btnAsignar.setVisible(false);
				formulario.setTitle("Sesión iniciada por: " + login_usuario.nombreCompletoUsuario);
				dispose();
			}
		});

		btnBonificaciones = new JButton("Bonificaciones");
		btnBonificaciones.setForeground(Color.BLACK);
		btnBonificaciones.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		btnBonificaciones.setBackground(new Color(102, 205, 170));
		btnBonificaciones.setBounds(117, 41, 97, 21);
		panelEmpleados.add(btnBonificaciones);
		btnBonificaciones.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				bonificacion clase = new bonificacion();
				consultas_bonificacion consulta = new consultas_bonificacion();
				registro_bonificaciones formulario = new registro_bonificaciones();
				control_bonificacion control = new control_bonificacion(clase, consulta, formulario);
				formulario.setVisible(true);
				formulario.setLocationRelativeTo(null);
				registro_bonificaciones.txtIdentidadEmpleadoBonificacion.requestFocusInWindow();
				formulario.construirTabla();
				formulario.obtenerUltimoId();
				formulario.establecerFechaRegistro();
				formulario.pistas();
				formulario.consultarEmpresa();
				formulario.btnBorrarBonificacion.setVisible(false);
				formulario.btnGuardar.setVisible(true);
				formulario.btnNuevo.setVisible(true);
				formulario.btnActualizar.setVisible(false);
				formulario.btnActualizarDatosBonificacion.setVisible(true);
				formulario.btnVerBonificacion.setVisible(true);
				formulario.btnAceptar.setVisible(false);
				formulario.btnPlanilla.setVisible(false);
				formulario.btnSinBonif.setVisible(false);
				formulario.setTitle("Sesión iniciada por: " + login_usuario.nombreCompletoUsuario);
				dispose();
			}
		});

		btnDeducciones = new JButton("Deducciones");
		btnDeducciones.setForeground(Color.BLACK);
		btnDeducciones.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		btnDeducciones.setBackground(new Color(102, 205, 170));
		btnDeducciones.setBounds(224, 41, 97, 21);
		panelEmpleados.add(btnDeducciones);
		btnDeducciones.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deduccion clase = new deduccion();
				consultas_deduccion consulta = new consultas_deduccion();
				registro_deducciones formulario = new registro_deducciones();
				control_deduccion control = new control_deduccion(clase, consulta, formulario);
				formulario.setVisible(true);
				formulario.setLocationRelativeTo(null);
				registro_deducciones.txtIdentidadEmpleadoDeduccion.requestFocusInWindow();
				formulario.construirTabla();
				formulario.obtenerUltimoId();
				formulario.establecerFechaRegistro();
				formulario.pistas();
				formulario.consultarEmpresa();
				formulario.btnBorrarDeduccion.setVisible(false);
				formulario.btnGuardar.setVisible(true);
				formulario.btnNuevo.setVisible(true);
				formulario.btnActualizar.setVisible(false);
				formulario.btnActualizarDatosDeduccion.setVisible(true);
				formulario.btnVerDeduccion.setVisible(true);
				formulario.btnAceptar.setVisible(false);
				formulario.btnPlanillaDeducciones.setVisible(false);
				formulario.btnSinDeduc.setVisible(false);
				formulario.setTitle("Sesión iniciada por: " + login_usuario.nombreCompletoUsuario);
				dispose();
			}
		});

		btnHorario = new JButton("Horarios");
		btnHorario.setForeground(Color.BLACK);
		btnHorario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		btnHorario.setBackground(new Color(102, 205, 170));
		btnHorario.setBounds(224, 19, 97, 21);
		panelEmpleados.add(btnHorario);
		btnHorario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				horario clase = new horario();
				consultas_horario consulta = new consultas_horario();
				registro_horarios formulario = new registro_horarios();
				control_horario control = new control_horario(clase, consulta, formulario);
				formulario.setVisible(true);
				formulario.setLocationRelativeTo(null);
				formulario.txtObservacionHorario.requestFocusInWindow();
				formulario.construirTabla();
				formulario.obtenerUltimoId();
				formulario.pistas();
				formulario.consultarEmpresa();
				formulario.btnBorrarHorario.setVisible(false);
				formulario.btnGuardarHorario.setVisible(true);
				formulario.btnNuevoHorario.setVisible(true);
				formulario.btnActualizarHorario.setVisible(false);
				formulario.btnActualizarDatosHorario.setVisible(true);
				formulario.btnMostrarHorario.setVisible(true);
				formulario.btnAceptarHorario.setVisible(false);
				formulario.btnAsignar.setVisible(false);
				formulario.setTitle("Sesión iniciada por: " + login_usuario.nombreCompletoUsuario);
				dispose();
			}
		});

		JLabel label_2 = new JLabel("Empleados :");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		label_2.setBounds(10, 0, 97, 21);
		panelEmpleados.add(label_2);

		panelClientes = new JPanel();
		panelClientes.setBackground(UIManager.getColor("Button.background"));
		panelClientes.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelClientes.setBounds(46, 198, 327, 73);
		contentPane.add(panelClientes);
		panelClientes.setLayout(null);

		JLabel label_3 = new JLabel("Clientes :");
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		label_3.setBounds(10, 0, 97, 21);
		panelClientes.add(label_3);

		btnCliente = new JButton("Clientes");
		btnCliente.setForeground(Color.BLACK);
		btnCliente.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		btnCliente.setBackground(new Color(95, 158, 160));
		btnCliente.setBounds(10, 19, 97, 21);
		panelClientes.add(btnCliente);
		btnCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
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

		btnContratoCliente = new JButton("Contratos");
		btnContratoCliente.setForeground(Color.BLACK);
		btnContratoCliente.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		btnContratoCliente.setBackground(new Color(95, 158, 160));
		btnContratoCliente.setBounds(10, 41, 97, 21);
		panelClientes.add(btnContratoCliente);
		btnContratoCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				contrato_cliente clase = new contrato_cliente();
				consultas_contrato_cliente consulta = new consultas_contrato_cliente();
				registro_contratos_clientes formulario = new registro_contratos_clientes();
				control_contrato_cliente control = new control_contrato_cliente(clase, consulta, formulario);
				formulario.setVisible(true);
				formulario.setLocationRelativeTo(null);
				formulario.txtBusquedaContratosEmpleados.requestFocusInWindow();
				formulario.obtenerUltimoId();
				formulario.pistas();
				formulario.consultarEmpresa();
				formulario.construirTabla();
				formulario.btnGuardarContrato.setVisible(true);
				formulario.btnNuevoContrato.setVisible(true);
				formulario.btnActualizarContrato.setVisible(false);
				formulario.btnAceptar.setVisible(false);
				formulario.btnBorrarContrato.setVisible(false);
				formulario.setTitle("Sesión iniciada por: " + login_usuario.nombreCompletoUsuario);
				dispose();
			}
		});

		btnProducto = new JButton("Productos");
		btnProducto.setForeground(Color.BLACK);
		btnProducto.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		btnProducto.setBackground(new Color(95, 158, 160));
		btnProducto.setBounds(224, 19, 97, 21);
		panelClientes.add(btnProducto);
		btnProducto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				producto clase = new producto();
				consultas_producto consulta = new consultas_producto();
				registro_productos formulario = new registro_productos();
				control_producto control = new control_producto(clase, consulta, formulario);
				formulario.setVisible(true);
				formulario.setLocationRelativeTo(null);
				formulario.txtDispositivo.requestFocusInWindow();
				formulario.obtenerUltimoId();
				formulario.pistas();
				formulario.consultarEmpresa();
				formulario.construirTabla();
				formulario.establecerFechaRegistro();
				formulario.btnGuardar.setVisible(true);
				formulario.btnNuevoProducto.setVisible(true);
				formulario.btnActualizarProducto.setVisible(false);
				formulario.btnAceptar.setVisible(false);
				formulario.btnBorrarProducto.setVisible(false);
				formulario.setTitle("Sesión iniciada por: " + login_usuario.nombreCompletoUsuario);
				dispose();

			}
		});

		btnServicio = new JButton("Servicios");
		btnServicio.setBounds(117, 19, 97, 21);
		panelClientes.add(btnServicio);
		btnServicio.setForeground(Color.BLACK);
		btnServicio.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		btnServicio.setBackground(new Color(95, 158, 160));
		btnServicio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				consultarProductos();
				if (productodato == null) {
					JOptionPane.showMessageDialog(null,
							"BIENVENIDO AL SISTEMA ADMINISTRATIVO\n" + "         Antes de comenzar\n"
									+ "         debe hacer algunos ajustes.\n" + "         Ingrese a:\n"
									+ "                Productos\n"
									+ "          y agrege nuevos productos al inventario!\n"
									+ "            ******* Buen Dia! *******");

				} else {
					servicio clase = new servicio();
					producto clase2 = new producto();
					ingreso clase3 = new ingreso();
					consultas_servicio consulta = new consultas_servicio();
					registro_servicios formulario = new registro_servicios();
					control_servicio control = new control_servicio(clase, clase2, clase3, consulta, formulario);
					formulario.setVisible(true);
					formulario.setLocationRelativeTo(null);
					formulario.txtServicio.requestFocusInWindow();
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
					control.consultarProductos();
					formulario.setTitle("Sesión iniciada por: " + login_usuario.nombreCompletoUsuario);
					dispose();
				}
			}
		});

		btnProveedores = new JButton("Proveedores");
		btnProveedores.setBounds(117, 41, 97, 21);
		btnProveedores.setForeground(Color.BLACK);
		btnProveedores.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		btnProveedores.setBackground(new Color(95, 158, 160));
		panelClientes.add(btnProveedores);
		btnProveedores.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				proveedor clase = new proveedor();
				consultas_proveedor consulta = new consultas_proveedor();
				registro_proveedores formulario = new registro_proveedores();
				control_proveedor control = new control_proveedor(clase, consulta, formulario);
				formulario.setVisible(true);
				formulario.setLocationRelativeTo(null);
				formulario.txtNombresProveedor.requestFocusInWindow();
				formulario.obtenerUltimoId();
				formulario.pistas();
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

		panelFinanzas = new JPanel();
		panelFinanzas.setBackground(UIManager.getColor("Button.background"));
		panelFinanzas.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelFinanzas.setBounds(46, 312, 327, 46);
		contentPane.add(panelFinanzas);
		panelFinanzas.setLayout(null);

		JLabel label_4 = new JLabel("Finanzas :");
		label_4.setForeground(Color.BLACK);
		label_4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		label_4.setBounds(10, 0, 174, 21);
		panelFinanzas.add(label_4);

		btnIngreso = new JButton("Ingresos");
		btnIngreso.setForeground(Color.BLACK);
		btnIngreso.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		btnIngreso.setBackground(new Color(70, 130, 180));
		btnIngreso.setBounds(10, 19, 97, 21);
		panelFinanzas.add(btnIngreso);
		btnIngreso.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				venta clase = new venta();
				inventario clase2 = new inventario();
				ingreso clase3 = new ingreso();
				consultas_venta consulta = new consultas_venta();
				registro_ventas formulario = new registro_ventas();
				registro_ingresos formulario2 = new registro_ingresos();
				control_venta control = new control_venta(clase, clase2, clase3, consulta, formulario, formulario2);
				formulario2.setVisible(true);
				formulario2.setLocationRelativeTo(null);
				formulario2.txtBusquedaCargos.requestFocusInWindow();
				formulario2.consultarEmpresa();
				formulario2.construirTabla();
				formulario2.setTitle("Sesión iniciada por: " + login_usuario.nombreCompletoUsuario);
				dispose();
			}
		});

		btnEgreso = new JButton("Egresos");
		btnEgreso.setForeground(Color.BLACK);
		btnEgreso.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		btnEgreso.setBackground(new Color(70, 130, 180));
		btnEgreso.setBounds(117, 19, 97, 21);
		panelFinanzas.add(btnEgreso);
		btnEgreso.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				egreso clase = new egreso();
				consultas_egreso consulta = new consultas_egreso();
				registro_egresos formulario = new registro_egresos();
				control_egresos control = new control_egresos(clase, consulta, formulario);
				formulario.setVisible(true);
				formulario.setLocationRelativeTo(null);
				formulario.txtEgreso.requestFocusInWindow();
				formulario.construirTabla();
				formulario.obtenerUltimoId();
				formulario.consultarEmpresa();
				formulario.btnBorrar.setVisible(false);
				formulario.btnGuardar.setVisible(true);
				formulario.btnNuevo.setVisible(true);
				formulario.btnActualizar.setVisible(false);
				formulario.btnActualizarDatos.setVisible(true);
				formulario.btnMostrar.setVisible(true);
				formulario.btnAceptar.setVisible(false);
				formulario.setTitle("Sesión iniciada por: " + login_usuario.nombreCompletoUsuario);
				dispose();
			}
		});

		panelInventario = new JPanel();
		panelInventario.setBackground(Color.WHITE);
		panelInventario.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelInventario.setBounds(46, 268, 327, 46);
		contentPane.add(panelInventario);
		panelInventario.setLayout(null);

		JLabel label_6 = new JLabel("Inventario :");
		label_6.setForeground(Color.BLACK);
		label_6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		label_6.setBounds(10, 0, 174, 21);
		panelInventario.add(label_6);

		btnInventario = new JButton("Inventario");
		btnInventario.setForeground(Color.BLACK);
		btnInventario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		btnInventario.setBackground(Color.PINK);
		btnInventario.setBounds(117, 19, 97, 21);
		panelInventario.add(btnInventario);
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
				formulario.setTitle("Sesión iniciada por: " + login_usuario.nombreCompletoUsuario);
				dispose();
			}
		});

		btnCompras = new JButton("Compras");
		btnCompras.setForeground(Color.BLACK);
		btnCompras.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		btnCompras.setBackground(Color.PINK);
		btnCompras.setBounds(10, 19, 97, 21);
		panelInventario.add(btnCompras);
		btnCompras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				compra clase = new compra();
				consultas_compra consulta = new consultas_compra();
				registro_compras formulario = new registro_compras();

				inventario clase2 = new inventario();
				consultas_inventario consulta2 = new consultas_inventario();
				registro_inventario formulario2 = new registro_inventario();

				control_compra control = new control_compra(clase, clase2, consulta, consulta2, formulario,
						formulario2);
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
				formulario.setTitle("Sesión iniciada por: " + login_usuario.nombreCompletoUsuario);
				dispose();
			}
		});

		btnVentas = new JButton("Ventas");
		btnVentas.setForeground(Color.BLACK);
		btnVentas.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		btnVentas.setBackground(Color.PINK);
		btnVentas.setBounds(224, 18, 97, 21);
		panelInventario.add(btnVentas);
		btnVentas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				venta clase = new venta();
				inventario clase2 = new inventario();
				ingreso clase3 = new ingreso();
				consultas_venta consulta = new consultas_venta();
				registro_ventas formulario = new registro_ventas();
				registro_ingresos formulario2 = new registro_ingresos();
				control_venta control = new control_venta(clase, clase2, clase3, consulta, formulario, formulario2);
				formulario.setVisible(true);
				formulario.setLocationRelativeTo(null);
				formulario.txtBusquedaInventario.requestFocusInWindow();
				formulario.obtenerUltimoId();
				formulario.pistas();
				formulario.consultarEmpresa();
				formulario.construirTablaInventario();
				formulario.construirTablaVenta();
				formulario.establecerFechaRegistro();
				formulario.btnGuardar.setVisible(true);
				formulario.btnNuevo.setVisible(true);
				formulario.btnActualizar.setVisible(false);
				formulario.btnAceptar.setVisible(false);
				formulario.btnBorrar.setVisible(false);
				formulario.txtExistencia.setText("0");
				formulario.setTitle("Sesión iniciada por: " + login_usuario.nombreCompletoUsuario);
				dispose();
			}
		});

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_4.setBounds(481, 41, 133, 26);
		contentPane.add(panel_4);
		panel_4.setLayout(null);

		lbl_horaSistema = new JLabel();
		lbl_horaSistema.setForeground(new Color(0, 0, 0));
		lbl_horaSistema.setBounds(0, 0, 131, 26);
		panel_4.add(lbl_horaSistema);
		lbl_horaSistema.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 16));
		lbl_horaSistema.setBackground(UIManager.getColor("Button.background"));
		lbl_horaSistema.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(410, 73, 274, 175);
		contentPane.add(panel_5);
		panel_5.setLayout(null);

		lblTipoUsuario = new JLabel("tipo");
		lblTipoUsuario.setBounds(10, 111, 131, 28);
		panel_5.add(lblTipoUsuario);
		lblTipoUsuario.setForeground(new Color(0, 0, 128));
		lblTipoUsuario.setFont(new Font("Dialog", Font.BOLD, 12));

		JLabel lblUsuario_1 = new JLabel("Tipo de usuario.");
		lblUsuario_1.setBounds(10, 97, 177, 14);
		panel_5.add(lblUsuario_1);
		lblUsuario_1.setForeground(Color.BLACK);
		lblUsuario_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));

		lblCargoUsuario = new JLabel("cargo");
		lblCargoUsuario.setBounds(10, 68, 131, 32);
		panel_5.add(lblCargoUsuario);
		lblCargoUsuario.setForeground(new Color(0, 0, 128));
		lblCargoUsuario.setFont(new Font("Dialog", Font.BOLD, 12));

		JLabel lblCargo = new JLabel("Cargo del usuario.");
		lblCargo.setBounds(10, 56, 177, 14);
		panel_5.add(lblCargo);
		lblCargo.setForeground(Color.BLACK);
		lblCargo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));

		lblNombreUsuario = new JLabel("Nombre completo del empleado.");
		lblNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreUsuario.setBounds(10, 150, 254, 14);
		panel_5.add(lblNombreUsuario);
		lblNombreUsuario.setForeground(new Color(0, 0, 128));
		lblNombreUsuario.setFont(new Font("Dialog", Font.BOLD, 12));

		JLabel lblInformacionDelUsuario = new JLabel();
		lblInformacionDelUsuario.setText("Administraci\u00F3n del Usuario\r\n. ");
		lblInformacionDelUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformacionDelUsuario.setForeground(Color.BLACK);
		lblInformacionDelUsuario.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
		lblInformacionDelUsuario.setBounds(10, 0, 254, 25);
		panel_5.add(lblInformacionDelUsuario);

		JLabel lblDatos = new JLabel("Datos del usuario :");
		lblDatos.setForeground(Color.BLACK);
		lblDatos.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblDatos.setBounds(10, 31, 177, 14);
		panel_5.add(lblDatos);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(145, 23, 119, 125);
		panel_5.add(panel);
		panel.setLayout(null);

		labelfotousuario = new JLabel();
		labelfotousuario.setBounds(10, 11, 99, 103);
		panel.add(labelfotousuario);
		labelfotousuario.setHorizontalAlignment(SwingConstants.CENTER);
		labelfotousuario.setForeground(Color.LIGHT_GRAY);
		final ImageIcon iconousuario = new ImageIcon(logousuario.getImage()
				.getScaledInstance(labelfotousuario.getWidth(), labelfotousuario.getHeight(), Image.SCALE_DEFAULT));
		labelfotousuario.setIcon(iconousuario);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(410, 11, 274, 26);
		contentPane.add(panel_6);
		panel_6.setLayout(null);

		lbl_fechaSistema = new JLabel();
		lbl_fechaSistema.setForeground(new Color(0, 0, 128));
		lbl_fechaSistema.setBounds(0, 0, 274, 26);
		panel_6.add(lbl_fechaSistema);
		lbl_fechaSistema.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
		lbl_fechaSistema.setBackground(Color.WHITE);
		lbl_fechaSistema.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fechaSistema.setText(getFecha());

		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(410, 250, 274, 290);
		contentPane.add(panel_7);
		panel_7.setLayout(null);

		lbl_nombre_empresa_principal = new JLabel();
		lbl_nombre_empresa_principal.setBounds(0, 0, 274, 33);
		panel_7.add(lbl_nombre_empresa_principal);
		lbl_nombre_empresa_principal.setForeground(new Color(0, 0, 128));
		lbl_nombre_empresa_principal.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_nombre_empresa_principal.setFont(new Font("Eras Bold ITC", Font.PLAIN, 18));
		lbl_nombre_empresa_principal.setText("Nombre de la empresa.");

		btnInformacionEmpresa = new JButton("\u00BFMas Informaci\u00F3n de la empresa?");
		btnInformacionEmpresa.setBounds(10, 256, 252, 23);
		panel_7.add(btnInformacionEmpresa);
		btnInformacionEmpresa.setBackground(new Color(255, 255, 255));
		btnInformacionEmpresa.setForeground(new Color(0, 0, 128));
		btnInformacionEmpresa.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 11));

		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(10, 32, 252, 223);
		panel_7.add(panel_1);

		lbl_logo_empresa_principal = new JLabel();
		lbl_logo_empresa_principal.setBounds(10, 11, 232, 201);
		panel_1.add(lbl_logo_empresa_principal);
		lbl_logo_empresa_principal.setHorizontalAlignment(SwingConstants.CENTER);
		final ImageIcon icono = new ImageIcon(logo.getImage().getScaledInstance(lbl_logo_empresa_principal.getWidth(),
				lbl_logo_empresa_principal.getHeight(), Image.SCALE_DEFAULT));
		lbl_logo_empresa_principal.setIcon(icono);
		btnInformacionEmpresa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				empresa clase = new empresa();
				consultas_empresa consulta = new consultas_empresa();
				registro_empresa formulario = new registro_empresa();
				control_empresa control = new control_empresa(clase, consulta, formulario);
				formulario.setVisible(true);
				formulario.setLocationRelativeTo(null);
				formulario.mostrarEmpresa();
				formulario.pistas();
				nombre = lbl_nombre_empresa_principal.getText().toString();
				registro_empresa.txtNombre_Empresa.setText(nombre);
				formulario.setTitle("Sesión iniciada por: " + login_usuario.nombreCompletoUsuario);
				dispose();
				formulario.setTitle("Sesión iniciada por: " + login_usuario.nombreCompletoUsuario);
			}
		});

		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_8.setBackground(Color.WHITE);
		panel_8.setBounds(21, 11, 379, 34);
		contentPane.add(panel_8);

		JLabel lblBienvenidoAlSistema = new JLabel("Bienvenido al Sistema Administrativo.");
		panel_8.add(lblBienvenidoAlSistema);
		lblBienvenidoAlSistema.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenidoAlSistema.setForeground(new Color(0, 0, 128));
		lblBienvenidoAlSistema.setFont(new Font("Cooper Black", Font.PLAIN, 18));

		panelFacturas = new JPanel();
		panelFacturas.setLayout(null);
		panelFacturas.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelFacturas.setBackground(Color.WHITE);
		panelFacturas.setBounds(46, 363, 327, 46);
		contentPane.add(panelFacturas);

		JLabel label = new JLabel("Facturas :");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		label.setBounds(10, 0, 97, 15);
		panelFacturas.add(label);

		btnFacturasClientes = new JButton("Clientes");
		btnFacturasClientes.setForeground(Color.BLACK);
		btnFacturasClientes.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		btnFacturasClientes.setBackground(new Color(255, 215, 0));
		btnFacturasClientes.setBounds(117, 15, 97, 21);
		panelFacturas.add(btnFacturasClientes);
		btnFacturasClientes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				consultarEmpresa();
				if (nombre == null) {
					JOptionPane.showMessageDialog(null,
							"BIENVENIDO AL SISTEMA ADMINISTRATIVO\n" + "         Antes de comenzar\n"
									+ "         debe hacer algunos ajustes.\n" + "         Ingrese a:\n"
									+ "   ¿MAS INFORMACION DE LA EMPRESA?\n" + "          y personalice su empresa!\n"
									+ "            ******* Buen Dia! *******");

				} else {
					consultarSAR();
					if (sardato == null) {
						JOptionPane.showMessageDialog(null,
								"BIENVENIDO AL SISTEMA ADMINISTRATIVO\n" + "         Antes de comensar\n"
										+ "         debe hacer algunos ajustes.\n" + "         Ingrese a:\n"
										+ "                SAR\n" + "          y agrege un nuevo rango SAR!\n"
										+ "            ******* Buen Dia! *******");

					} else {
						factura_cliente clase = new factura_cliente();
						consultas_factura_cliente consulta = new consultas_factura_cliente();
						registro_facturas_clientes formulario = new registro_facturas_clientes();
						sar clase2 = new sar();
						control_factura_cliente control = new control_factura_cliente(clase, consulta, formulario,
								clase2);
						formulario.setVisible(true);
						formulario.setLocationRelativeTo(null);
						formulario.txtCliente.requestFocusInWindow();
						formulario.obtenerUltimoId();
						formulario.pistas();
						formulario.consultarEmpresa();
						formulario.construirTabla();
						formulario.construirTablaClientes();
						formulario.establecerDatosEmpresa();
						formulario.ObtenerUltimosDatosSar();
						formulario.btnGuardar.setVisible(true);
						formulario.btnNuevo.setVisible(true);
						formulario.btnActualizar.setVisible(false);
						formulario.btnAceptar.setVisible(false);
						formulario.btnBorrar.setVisible(false);
						formulario.setTitle("Sesión iniciada por: " + login_usuario.nombreCompletoUsuario);
						formulario.txtEmpleado.setText(login_usuario.nombreCompletoUsuario);
						dispose();
					}
				}
			}
		});

		btnFacturasEmpresa = new JButton("Empresa");
		btnFacturasEmpresa.setForeground(Color.BLACK);
		btnFacturasEmpresa.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		btnFacturasEmpresa.setBackground(new Color(255, 215, 0));
		btnFacturasEmpresa.setBounds(10, 15, 97, 21);
		panelFacturas.add(btnFacturasEmpresa);
		btnFacturasEmpresa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				factura_empresa clase = new factura_empresa();
				consultas_factura_empresa consulta = new consultas_factura_empresa();
				registro_facturas_empresa formulario = new registro_facturas_empresa();
				control_factura_empresa control = new control_factura_empresa(clase, consulta, formulario);
				formulario.setVisible(true);
				formulario.setLocationRelativeTo(null);
				formulario.txtCompra.requestFocusInWindow();
				formulario.obtenerUltimoId();
				formulario.pistas();
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

		btnSar = new JButton("Sar");
		btnSar.setForeground(Color.BLACK);
		btnSar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		btnSar.setBackground(new Color(255, 215, 0));
		btnSar.setBounds(224, 15, 97, 21);
		panelFacturas.add(btnSar);
		btnSar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				sar clase = new sar();
				consultas_sar consulta = new consultas_sar();
				registro_sar formulario = new registro_sar();
				control_sar control = new control_sar(clase, consulta, formulario);
				formulario.setVisible(true);
				formulario.setLocationRelativeTo(null);
				formulario.txtCaiSar.requestFocusInWindow();
				formulario.obtenerUltimoId();
				formulario.consultarEmpresa();
				formulario.construirTabla();
				formulario.ObtenerUltimosDatosSar();
				formulario.calcularDatosFacturas();
				formulario.btnGuardar.setVisible(true);
				formulario.btnNuevo.setVisible(true);
				formulario.btnActualizar.setVisible(false);
				formulario.btnAceptar.setVisible(false);
				formulario.btnBorrar.setVisible(false);
				formulario.setTitle("Sesión iniciada por: " + login_usuario.nombreCompletoUsuario);
				dispose();

			}
		});

		panelOpciones = new JPanel();
		panelOpciones.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelOpciones.setBackground(SystemColor.menu);
		panelOpciones.setBounds(46, 407, 327, 53);
		contentPane.add(panelOpciones);
		panelOpciones.setLayout(null);

		JLabel lblOpciones = new JLabel("Opciones :");
		lblOpciones.setBounds(10, 0, 87, 19);
		panelOpciones.add(lblOpciones);
		lblOpciones.setForeground(Color.BLACK);
		lblOpciones.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));

		btnOpciones = new JButton("Configuraci\u00F3n");
		btnOpciones.setBounds(10, 20, 103, 21);
		btnOpciones.setForeground(Color.BLACK);
		btnOpciones.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		btnOpciones.setBackground(new Color(219, 112, 147));
		panelOpciones.add(btnOpciones);
		btnOpciones.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				configuracion clase = new configuracion();
				consultas_configuracion consulta = new consultas_configuracion();
				configuraciones formulario = new configuraciones();
				control_configuracion control = new control_configuracion(clase, consulta, formulario);
				formulario.consultarConfiguracion();
				formulario.mostrarConfiguracion();
				formulario.setVisible(true);
				formulario.setLocationRelativeTo(null);
				formulario.setTitle("Sesión iniciada por: " + login_usuario.nombreCompletoUsuario);
				dispose();
			}
		});

		btnAcercaDe = new JButton("Acerca de.");
		btnAcercaDe.setBounds(225, 20, 94, 21);
		panelOpciones.add(btnAcercaDe);
		btnAcercaDe.setForeground(Color.BLACK);
		btnAcercaDe.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		btnAcercaDe.setBackground(new Color(219, 112, 147));

		btnUsuarios = new JButton("Usuarios");
		btnUsuarios.setBounds(123, 20, 92, 21);
		panelOpciones.add(btnUsuarios);
		btnUsuarios.setForeground(Color.BLACK);
		btnUsuarios.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		btnUsuarios.setBackground(new Color(219, 112, 147));
		btnUsuarios.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				usuario clase = new usuario();
				consultas_usuario consulta = new consultas_usuario();
				registro_usuarios formulario = new registro_usuarios();
				control_usuario control = new control_usuario(clase, consulta, formulario);
				formulario.setVisible(true);
				formulario.setLocationRelativeTo(null);
				registro_usuarios.txtBusqueda.requestFocusInWindow();
				formulario.obtenerUltimoId();
				formulario.pistas();
				formulario.consultarEmpresa();
				formulario.construirTabla();
				formulario.btnNuevo.setVisible(true);
				formulario.btnVer.setVisible(true);
				formulario.btnActualizarDatos.setVisible(true);
				formulario.btnActualizar.setVisible(false);
				formulario.btnAceptar.setVisible(false);
				formulario.btnBorrar.setVisible(false);
				registro_usuarios.lblUsuarioLogeado.setText(login_usuario.nombreUsuario);
				formulario.setTitle("Sesión iniciada por: " + login_usuario.nombreCompletoUsuario);
				dispose();
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(46, 471, 327, 34);
		contentPane.add(scrollPane);
		scrollPane.setViewportBorder(UIManager.getBorder("ComboBox.editorBorder"));

		txtFrase = new JTextField();
		txtFrase.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setViewportView(txtFrase);
		txtFrase.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 12));
		txtFrase.setText(
				"El sabio no dice nunca todo lo que piensa, pero siempre piensa todo lo que dice. Arist\u00F3teles.");
		txtFrase.setBackground(Color.WHITE);
		txtFrase.setColumns(10);

		JLabel lblMenuOpciones = new JLabel();
		lblMenuOpciones.setBounds(21, 43, 379, 497);
		contentPane.add(lblMenuOpciones);
		final ImageIcon icono2 = new ImageIcon(logo2.getImage().getScaledInstance(lblMenuOpciones.getWidth(),
				lblMenuOpciones.getHeight(), Image.SCALE_DEFAULT));
		lblMenuOpciones.setIcon(icono2);
		btnAcercaDe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				acerca_de info = new acerca_de();
				info.setLocationRelativeTo(null);
				info.setVisible(true);
				info.setTitle("Sesión iniciada por: " + login_usuario.nombreCompletoUsuario);
			}
		});

	}

	Timer time = new Timer();
	public TimerTask tarea = new TimerTask() {
		@Override
		public void run() {
			Calendar calendario = new GregorianCalendar();
			Date fechaHoraActual = new Date();
			calendario.setTime(fechaHoraActual);
			String horas;
			String minutos;
			String segundos;
			String ampm;
			Thread hilo = null;
			Thread hilo2;
			hilo2 = Thread.currentThread();
			hilo = new Thread();
			hilo.start();
			ampm = calendario.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";
			if (ampm.equals("PM")) {
				int h = calendario.get(Calendar.HOUR_OF_DAY) - 12;
				horas = h > 9 ? "" + h : "0" + h;
			} else {
				horas = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY)
						: "0" + calendario.get(Calendar.HOUR_OF_DAY);
			}
			minutos = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE)
					: "0" + calendario.get(Calendar.MINUTE);
			segundos = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND)
					: "0" + calendario.get(Calendar.SECOND);

			lbl_horaSistema.setText(horas + ":" + minutos + ":" + segundos + " " + ampm);
		}
	};
	private JPanel panel_1;

	public static String getFecha() {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		SimpleDateFormat df = new SimpleDateFormat("'Dia' EEEEEEEEE dd 'de' MMMMM 'del' yyyy");
		date = cal.getTime();
		return df.format(date);
	}

	public void consultarEmpresa() {
		conexion conex = new conexion();
		try {
			Statement estatuto = conex.getConexion().createStatement();
			ResultSet rs = estatuto
					.executeQuery("SELECT nombre_empresa, direccion_logo_empresa FROM empresa where id_empresa = 1");
			if (rs.next()) {
				nombre = (rs.getString("nombre_empresa"));
				ruta_logo = (rs.getString("direccion_logo_empresa"));

				lbl_nombre_empresa_principal.setText(nombre);
				final ImageIcon logo = new ImageIcon(ruta_logo);
				final ImageIcon icono = new ImageIcon(
						logo.getImage().getScaledInstance(lbl_logo_empresa_principal.getWidth(),
								lbl_logo_empresa_principal.getHeight(), Image.SCALE_DEFAULT));
				lbl_logo_empresa_principal.setIcon(icono);
			} else {
				JOptionPane.showMessageDialog(null,
						"BIENVENIDO AL SISTEMA ADMINISTRATIVO\n" + "         Antes de comenzar\n"
								+ "         podria hacer algunos ajustes.\n" + "         Ingresaremos a:\n"
								+ "   ¿MAS INFORMACION DE LA EMPRESA?\n" + "          a personalizar su empresa!\n"
								+ "            ******* Buen Dia! *******");
				empresa clase = new empresa();
				consultas_empresa consulta = new consultas_empresa();
				registro_empresa formulario = new registro_empresa();
				control_empresa control = new control_empresa(clase, consulta, formulario);
				formulario.setVisible(true);
				formulario.setLocationRelativeTo(null);
				formulario.mostrarEmpresa();
				formulario.pistas();
				formulario.btnActualizarDatos.setVisible(false);
				nombre = lbl_nombre_empresa_principal.getText().toString();
				registro_empresa.txtNombre_Empresa.setText(nombre);
				formulario.setTitle("Sesión iniciada por: " + login_usuario.nombreCompletoUsuario);
				dispose();
				formulario.setTitle("Sesión iniciada por: " + login_usuario.nombreCompletoUsuario);

			}

			rs.close();
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error al consultar", "Error", JOptionPane.ERROR_MESSAGE);

		}

	}

	public void consultarSAR() {
		conexion conex = new conexion();
		try {
			Statement estatuto = conex.getConexion().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT factura_actual_sar FROM sar");
			if (rs.next()) {
				sardato = (rs.getString("factura_actual_sar"));
			}
			rs.close();
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error al consultar", "Error", JOptionPane.ERROR_MESSAGE);

		}

	}

	public void consultarProductos() {
		conexion conex = new conexion();
		try {
			Statement estatuto = conex.getConexion().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT * FROM productos");
			if (rs.next()) {
				productodato = (rs.getString("existencia_producto"));
			}
			rs.close();
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error al consultar", "Error", JOptionPane.ERROR_MESSAGE);

		}

	}

	private void close() {
		if (JOptionPane.showConfirmDialog(rootPane, "¿Desea realmente salir del sistema?", "Salir del sistema",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
			System.exit(0);
	}

}
