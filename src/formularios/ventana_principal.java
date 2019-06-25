package formularios;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Color;
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
import clases.empleado;
import clases.empresa;
import clases.horario;
import clases.inventario;
import clases.planilla;

import clases.producto;
import clases.proveedor;
import clases.sar;
import clases.servicio;
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
import consultas.consultas_empleado;
import consultas.consultas_empresa;
import consultas.consultas_horario;
import consultas.consultas_inventario;
import consultas.consultas_planilla;
import consultas.consultas_producto;
import consultas.consultas_proveedor;
import consultas.consultas_sar;
import consultas.consultas_servicio;
import consultas.consultas_venta;
import controles.control_bonificacion;
import controles.control_cargo;
import controles.control_cliente;
import controles.control_compra;
import controles.control_configuracion;
import controles.control_contrato_cliente;
import controles.control_contrato_empleado;
import controles.control_deduccion;
import controles.control_empleado;
import controles.control_empresa;
import controles.control_horario;
import controles.control_inventario;
import controles.control_planilla;
import controles.control_producto;
import controles.control_proveedor;
import controles.control_sar;
import controles.control_servicio;
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

public class ventana_principal extends JFrame {

	public static JPanel contentPane;
	public JButton registroPlanilla;
	public JButton registroContrato;
	public JButton registroEmpleado;
	public JButton registroCargo;
	public JButton registroDeduccion;
	public JButton registroBonificacion;
	public JButton btnInformacionEmpresa;
	public JButton registroHorario;
	public JLabel lbl_horaSistema;
	public JLabel lbl_fechaSistema;
	public static JTextField txtFrase;

	public JButton btnRegistroProductos;

	public static JLabel lbl_logo_empresa_principal;
	public static JLabel lbl_nombre_empresa_principal;
	public static String nombre = null;
	public static String ruta_logo = null;
	public empresa clase;
	public consultas_empresa consulta;
	public registro_empresa formulario;

	public ventana_principal() {
		setType(Type.POPUP);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 580);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
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

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(46, 111, 327, 86);
		contentPane.add(panel);
		panel.setLayout(null);

		registroPlanilla = new JButton("Planillas");
		registroPlanilla.setForeground(Color.BLACK);
		registroPlanilla.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		registroPlanilla.setBackground(new Color(102, 205, 170));
		registroPlanilla.setBounds(10, 64, 97, 21);
		panel.add(registroPlanilla);
		registroPlanilla.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				planilla clase = new planilla();
				consultas_planilla consulta = new consultas_planilla();
				registro_planillas formulario = new registro_planillas();
				control_planilla control = new control_planilla(clase, consulta, formulario);
				formulario.setVisible(true);
				formulario.setLocationRelativeTo(null);
				registro_planillas.txtIdentidadEmpleadoPlanilla.requestFocusInWindow();
				formulario.construirTabla();
				formulario.obtenerUltimoId();
				formulario.establecerFechaRegistro();
				formulario.pistas();
				formulario.btnBorrarPlanilla.setVisible(false);
				formulario.btnGuardar.setVisible(true);
				formulario.btnNuevo.setVisible(true);
				formulario.btnActualizar.setVisible(false);
				formulario.btnActualizarDatosPlanilla.setVisible(true);
				formulario.btnVerPlanilla.setVisible(true);
				formulario.btnAceptar.setVisible(false);
				Timer time = new Timer();
				time.schedule(formulario.tarea, 0, 1000);
				dispose();
			}
		});

		registroContrato = new JButton("Contratos");
		registroContrato.setForeground(Color.BLACK);
		registroContrato.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		registroContrato.setBackground(new Color(102, 205, 170));
		registroContrato.setBounds(10, 41, 97, 21);
		panel.add(registroContrato);
		registroContrato.addActionListener(new ActionListener() {
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
				dispose();
			}
		});

		registroEmpleado = new JButton("Empleados");
		registroEmpleado.setForeground(Color.BLACK);
		registroEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		registroEmpleado.setBackground(new Color(102, 205, 170));
		registroEmpleado.setBounds(10, 19, 97, 21);
		panel.add(registroEmpleado);
		registroEmpleado.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				empleado clase = new empleado();
				consultas_empleado consulta = new consultas_empleado();
				registro_empleados formulario = new registro_empleados();
				registro_asignaciones_empleados formulario2 = new registro_asignaciones_empleados();
				control_empleado control = new control_empleado(clase, consulta, formulario, formulario2);
				formulario.setVisible(true);
				formulario.setLocationRelativeTo(null);
				formulario.txtNombresEmpleado.requestFocusInWindow();
				formulario.obtenerUltimoId();
				formulario.pistas();
				formulario.consultarEmpresa();
				formulario.establecerFechaRegistro();
				formulario.construirTablaEmpleados();
				formulario.btnNuevoEmpleado.setVisible(true);
				formulario.btnMostrarEmpleado.setVisible(true);
				formulario.btnActualizarDatosEmpleado.setVisible(true);
				formulario.btnActualizarEmpleado.setVisible(false);
				formulario.btnCancelarEmpleado.setVisible(false);
				formulario.btnBorrarEmpleado.setVisible(false);
				dispose();
			}
		});

		registroCargo = new JButton("Cargos");
		registroCargo.setForeground(Color.BLACK);
		registroCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		registroCargo.setBackground(new Color(102, 205, 170));
		registroCargo.setBounds(117, 19, 97, 21);
		panel.add(registroCargo);
		registroCargo.addActionListener(new ActionListener() {
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
				formulario.pistas();
				formulario.consultarEmpresa();
				formulario.btnBorrarCargo.setVisible(false);
				formulario.btnGuardarCargo.setVisible(true);
				formulario.btnNuevoCargo.setVisible(true);
				formulario.btnActualizarCargo.setVisible(false);
				formulario.btnActualizarDatosCargo.setVisible(true);
				formulario.btnMostrar.setVisible(true);
				formulario.btnAceptar.setVisible(false);
				dispose();
			}
		});

		registroBonificacion = new JButton("Bonificaciones");
		registroBonificacion.setForeground(Color.BLACK);
		registroBonificacion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		registroBonificacion.setBackground(new Color(102, 205, 170));
		registroBonificacion.setBounds(117, 41, 97, 21);
		panel.add(registroBonificacion);
		registroBonificacion.addActionListener(new ActionListener() {
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
				dispose();
			}
		});

		registroDeduccion = new JButton("Deducciones");
		registroDeduccion.setForeground(Color.BLACK);
		registroDeduccion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		registroDeduccion.setBackground(new Color(102, 205, 170));
		registroDeduccion.setBounds(224, 41, 97, 21);
		panel.add(registroDeduccion);
		registroDeduccion.addActionListener(new ActionListener() {
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
				dispose();
			}
		});

		registroHorario = new JButton("Horarios");
		registroHorario.setForeground(Color.BLACK);
		registroHorario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		registroHorario.setBackground(new Color(102, 205, 170));
		registroHorario.setBounds(224, 19, 97, 21);
		panel.add(registroHorario);
		registroHorario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				horario clase = new horario();
				consultas_horario consulta = new consultas_horario();
				registro_horarios formulario = new registro_horarios();
				control_horario control = new control_horario(clase, consulta, formulario);
				formulario.setVisible(true);
				formulario.setLocationRelativeTo(null);
				formulario.txtDescripcionHorario.requestFocusInWindow();
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
				dispose();
			}
		});

		JLabel label_2 = new JLabel("Empleados :");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		label_2.setBounds(10, 0, 97, 21);
		panel.add(label_2);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("Button.background"));
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(46, 198, 327, 73);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel label_3 = new JLabel("Clientes :");
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		label_3.setBounds(10, 0, 97, 21);
		panel_1.add(label_3);

		JButton button_7 = new JButton("Clientes");
		button_7.setForeground(Color.BLACK);
		button_7.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		button_7.setBackground(new Color(95, 158, 160));
		button_7.setBounds(10, 19, 97, 21);
		panel_1.add(button_7);
		button_7.addActionListener(new ActionListener() {
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
				dispose();
			}
		});

		JButton button_8 = new JButton("Contratos");
		button_8.setForeground(Color.BLACK);
		button_8.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		button_8.setBackground(new Color(95, 158, 160));
		button_8.setBounds(10, 41, 97, 21);
		panel_1.add(button_8);
		button_8.addActionListener(new ActionListener() {
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
				dispose();
			}
		});

		btnRegistroProductos = new JButton("Productos");
		btnRegistroProductos.setForeground(Color.BLACK);
		btnRegistroProductos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		btnRegistroProductos.setBackground(new Color(95, 158, 160));
		btnRegistroProductos.setBounds(224, 19, 97, 21);
		panel_1.add(btnRegistroProductos);
		btnRegistroProductos.addActionListener(new ActionListener() {
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
				dispose();

			}
		});

		JButton button_9 = new JButton("Servicios");
		button_9.setBounds(117, 19, 97, 21);
		panel_1.add(button_9);
		button_9.setForeground(Color.BLACK);
		button_9.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		button_9.setBackground(new Color(95, 158, 160));
		button_9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				servicio clase = new servicio();
				consultas_servicio consulta = new consultas_servicio();
				registro_servicios formulario = new registro_servicios();
				control_servicio control = new control_servicio(clase, consulta, formulario);
				formulario.setVisible(true);
				formulario.setLocationRelativeTo(null);
				formulario.txtServicio.requestFocusInWindow();
				formulario.obtenerUltimoId();
				formulario.pistas();
				formulario.consultarEmpresa();
				formulario.construirTabla();
				formulario.btnGuardar.setVisible(true);
				formulario.btnNuevo.setVisible(true);
				formulario.btnActualizar.setVisible(false);
				formulario.btnAceptar.setVisible(false);
				formulario.btnBorrar.setVisible(false);
				control.consultarProductos();
				dispose();
			}
		});

		JButton button_16 = new JButton("Proveedores");
		button_16.setBounds(117, 41, 97, 21);
		button_16.setForeground(Color.BLACK);
		button_16.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		button_16.setBackground(new Color(95, 158, 160));
		panel_1.add(button_16);
		button_16.addActionListener(new ActionListener() {
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
				dispose();
			}
		});

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(UIManager.getColor("Button.background"));
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.setBounds(46, 312, 327, 46);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel label_4 = new JLabel("Finanzas :");
		label_4.setForeground(Color.BLACK);
		label_4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		label_4.setBounds(10, 0, 174, 21);
		panel_2.add(label_4);

		JButton button_11 = new JButton("Ingresos");
		button_11.setForeground(Color.BLACK);
		button_11.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		button_11.setBackground(new Color(70, 130, 180));
		button_11.setBounds(10, 19, 97, 21);
		panel_2.add(button_11);

		JButton button_12 = new JButton("Egresos");
		button_12.setForeground(Color.BLACK);
		button_12.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		button_12.setBackground(new Color(70, 130, 180));
		button_12.setBounds(117, 19, 97, 21);
		panel_2.add(button_12);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_3.setBounds(46, 268, 327, 46);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JLabel label_6 = new JLabel("Inventario :");
		label_6.setForeground(Color.BLACK);
		label_6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		label_6.setBounds(10, 0, 174, 21);
		panel_3.add(label_6);

		JButton button_15 = new JButton("Inventario");
		button_15.setForeground(Color.BLACK);
		button_15.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		button_15.setBackground(Color.PINK);
		button_15.setBounds(117, 19, 97, 21);
		panel_3.add(button_15);
		button_15.addActionListener(new ActionListener() {
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

		JButton button_17 = new JButton("Compras");
		button_17.setForeground(Color.BLACK);
		button_17.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		button_17.setBackground(Color.PINK);
		button_17.setBounds(10, 19, 97, 21);
		panel_3.add(button_17);
		button_17.addActionListener(new ActionListener() {
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
				dispose();
			}
		});

		JButton btnVentas = new JButton("Ventas");
		btnVentas.setForeground(Color.BLACK);
		btnVentas.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		btnVentas.setBackground(Color.PINK);
		btnVentas.setBounds(224, 18, 97, 21);
		panel_3.add(btnVentas);
		btnVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				venta clase = new venta();
				inventario clase2 = new inventario();
				consultas_venta consulta = new consultas_venta();
				registro_ventas formulario = new registro_ventas();
				control_venta control = new control_venta(clase, clase2, consulta, formulario);
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
				dispose();
			}
		});

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4.setBounds(481, 41, 133, 26);
		contentPane.add(panel_4);
		panel_4.setLayout(null);

		lbl_horaSistema = new JLabel();
		lbl_horaSistema.setBounds(0, 0, 131, 26);
		panel_4.add(lbl_horaSistema);
		lbl_horaSistema.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lbl_horaSistema.setBackground(UIManager.getColor("Button.background"));
		lbl_horaSistema.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(410, 73, 274, 175);
		contentPane.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblSuperUsuario = new JLabel("Super usuario");
		lblSuperUsuario.setBounds(10, 148, 119, 14);
		panel_5.add(lblSuperUsuario);
		lblSuperUsuario.setForeground(Color.BLACK);
		lblSuperUsuario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

		JLabel lblUsuario_1 = new JLabel("Usuario :");
		lblUsuario_1.setBounds(10, 134, 75, 14);
		panel_5.add(lblUsuario_1);
		lblUsuario_1.setForeground(Color.BLACK);
		lblUsuario_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));

		JLabel lblDeveloper = new JLabel("Developer");
		lblDeveloper.setBounds(10, 116, 119, 20);
		panel_5.add(lblDeveloper);
		lblDeveloper.setForeground(Color.BLACK);
		lblDeveloper.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

		JLabel lblCargo = new JLabel("Cargo :");
		lblCargo.setBounds(10, 105, 75, 14);
		panel_5.add(lblCargo);
		lblCargo.setForeground(Color.BLACK);
		lblCargo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));

		JLabel lblDiazRodriguez = new JLabel("Diaz Rodriguez");
		lblDiazRodriguez.setBounds(10, 90, 131, 14);
		panel_5.add(lblDiazRodriguez);
		lblDiazRodriguez.setForeground(Color.BLACK);
		lblDiazRodriguez.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

		JLabel lblCristianDiaz = new JLabel("Cristian Emmanuel");
		lblCristianDiaz.setBounds(10, 76, 131, 14);
		panel_5.add(lblCristianDiaz);
		lblCristianDiaz.setForeground(Color.BLACK);
		lblCristianDiaz.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

		JLabel lblUsuario = new JLabel("Nombre completo :");
		lblUsuario.setBounds(10, 60, 131, 20);
		panel_5.add(lblUsuario);
		lblUsuario.setForeground(Color.BLACK);
		lblUsuario.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));

		JLabel labelfotousuario = new JLabel();
		labelfotousuario.setBounds(151, 45, 113, 117);
		panel_5.add(labelfotousuario);
		labelfotousuario.setHorizontalAlignment(SwingConstants.CENTER);
		labelfotousuario.setForeground(Color.LIGHT_GRAY);
		final ImageIcon iconousuario = new ImageIcon(logousuario.getImage()
				.getScaledInstance(labelfotousuario.getWidth(), labelfotousuario.getHeight(), Image.SCALE_DEFAULT));
		labelfotousuario.setIcon(iconousuario);

		JLabel lblInformacionDelUsuario = new JLabel();
		lblInformacionDelUsuario.setText("Administraci\u00F3n del Usuario\r\n. ");
		lblInformacionDelUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformacionDelUsuario.setForeground(Color.BLACK);
		lblInformacionDelUsuario.setFont(new Font("Cooper Black", Font.PLAIN, 15));
		lblInformacionDelUsuario.setBounds(10, 0, 254, 36);
		panel_5.add(lblInformacionDelUsuario);

		JLabel lblDatos = new JLabel("Datos del usuario.");
		lblDatos.setForeground(Color.BLACK);
		lblDatos.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblDatos.setBounds(10, 36, 131, 20);
		panel_5.add(lblDatos);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(410, 11, 274, 26);
		contentPane.add(panel_6);
		panel_6.setLayout(null);

		lbl_fechaSistema = new JLabel();
		lbl_fechaSistema.setBounds(0, 0, 274, 26);
		panel_6.add(lbl_fechaSistema);
		lbl_fechaSistema.setFont(new Font("Cooper Black", Font.PLAIN, 15));
		lbl_fechaSistema.setBackground(Color.WHITE);
		lbl_fechaSistema.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fechaSistema.setText(getFecha());

		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(410, 250, 274, 290);
		contentPane.add(panel_7);
		panel_7.setLayout(null);

		lbl_logo_empresa_principal = new JLabel();
		lbl_logo_empresa_principal.setBounds(10, 32, 252, 215);
		panel_7.add(lbl_logo_empresa_principal);
		lbl_logo_empresa_principal.setHorizontalAlignment(SwingConstants.CENTER);
		final ImageIcon icono = new ImageIcon(logo.getImage().getScaledInstance(lbl_logo_empresa_principal.getWidth(),
				lbl_logo_empresa_principal.getHeight(), Image.SCALE_DEFAULT));
		lbl_logo_empresa_principal.setIcon(icono);

		lbl_nombre_empresa_principal = new JLabel();
		lbl_nombre_empresa_principal.setBounds(0, 0, 274, 35);
		panel_7.add(lbl_nombre_empresa_principal);
		lbl_nombre_empresa_principal.setForeground(Color.BLACK);
		lbl_nombre_empresa_principal.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_nombre_empresa_principal.setFont(new Font("Cooper Black", Font.PLAIN, 18));
		lbl_nombre_empresa_principal.setText("Nombre de la empresa.");

		btnInformacionEmpresa = new JButton("\u00BFMas Informaci\u00F3n de la empresa?");
		btnInformacionEmpresa.setBounds(10, 256, 252, 23);
		panel_7.add(btnInformacionEmpresa);
		btnInformacionEmpresa.setBackground(Color.WHITE);
		btnInformacionEmpresa.setForeground(Color.BLACK);
		btnInformacionEmpresa.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 11));
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
				dispose();
			}
		});

		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_8.setBackground(Color.WHITE);
		panel_8.setBounds(21, 11, 379, 34);
		contentPane.add(panel_8);

		JLabel lblBienvenidoAlSistema = new JLabel("Bienvenido al Sistema Administrativo.");
		panel_8.add(lblBienvenidoAlSistema);
		lblBienvenidoAlSistema.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenidoAlSistema.setForeground(Color.BLACK);
		lblBienvenidoAlSistema.setFont(new Font("Cooper Black", Font.PLAIN, 18));

		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_9.setBackground(Color.WHITE);
		panel_9.setBounds(46, 363, 327, 46);
		contentPane.add(panel_9);

		JLabel label = new JLabel("Facturas :");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		label.setBounds(10, 0, 97, 15);
		panel_9.add(label);

		JButton btnFacturasDeLos = new JButton("Clientes");
		btnFacturasDeLos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFacturasDeLos.setForeground(Color.BLACK);
		btnFacturasDeLos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		btnFacturasDeLos.setBackground(new Color(255, 215, 0));
		btnFacturasDeLos.setBounds(117, 15, 97, 21);
		panel_9.add(btnFacturasDeLos);

		JButton btnFacturasDeLa = new JButton("Empresa");
		btnFacturasDeLa.setForeground(Color.BLACK);
		btnFacturasDeLa.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		btnFacturasDeLa.setBackground(new Color(255, 215, 0));
		btnFacturasDeLa.setBounds(10, 15, 97, 21);
		panel_9.add(btnFacturasDeLa);

		JButton btnSar = new JButton("Sar");
		btnSar.setForeground(Color.BLACK);
		btnSar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		btnSar.setBackground(new Color(255, 215, 0));
		btnSar.setBounds(224, 15, 97, 21);
		panel_9.add(btnSar);
		btnSar.addActionListener(new ActionListener() {
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
				formulario.btnGuardar.setVisible(true);
				formulario.btnNuevo.setVisible(true);
				formulario.btnActualizar.setVisible(false);
				formulario.btnAceptar.setVisible(false);
				formulario.btnBorrar.setVisible(false);
				dispose();
				
			}
		});

		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_10.setBackground(SystemColor.menu);
		panel_10.setBounds(46, 407, 327, 53);
		contentPane.add(panel_10);
		panel_10.setLayout(null);

		JLabel lblOpciones = new JLabel("Opciones :");
		lblOpciones.setBounds(10, 0, 87, 19);
		panel_10.add(lblOpciones);
		lblOpciones.setForeground(Color.BLACK);
		lblOpciones.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));

		JButton btnConfiguracionDelSistema = new JButton("Configuraci\u00F3n");
		btnConfiguracionDelSistema.setBounds(10, 20, 103, 21);
		panel_10.add(btnConfiguracionDelSistema);
		btnConfiguracionDelSistema.setForeground(Color.BLACK);
		btnConfiguracionDelSistema.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		btnConfiguracionDelSistema.setBackground(new Color(219, 112, 147));

		JButton btnAcercaDe = new JButton("Acerca de.");
		btnAcercaDe.setBounds(225, 20, 94, 21);
		panel_10.add(btnAcercaDe);
		btnAcercaDe.setForeground(Color.BLACK);
		btnAcercaDe.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		btnAcercaDe.setBackground(new Color(219, 112, 147));

		JButton btnUsers = new JButton("Usuarios");
		btnUsers.setBounds(123, 20, 92, 21);
		panel_10.add(btnUsers);
		btnUsers.setForeground(Color.BLACK);
		btnUsers.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		btnUsers.setBackground(new Color(219, 112, 147));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(46, 471, 327, 34);
		contentPane.add(scrollPane);
		scrollPane.setViewportBorder(UIManager.getBorder("ComboBox.editorBorder"));

		txtFrase = new JTextField();
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
			public void actionPerformed(ActionEvent arg0) {
				acerca_de info = new acerca_de();
				info.setLocationRelativeTo(null);
				info.setVisible(true);
			}
		});
		btnConfiguracionDelSistema.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				configuracion clase = new configuracion();
				consultas_configuracion consulta = new consultas_configuracion();
				registro_configuracion formulario = new registro_configuracion();
				control_configuracion control = new control_configuracion(clase, consulta, formulario);
				formulario.consultarConfiguracion();
				formulario.mostrarConfiguracion();
				formulario.setVisible(true);
				formulario.setLocationRelativeTo(null);

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
						"BIENVENIDO AL SISTEMA ADMINISTRATIVO\n" + "         Antes de comensar\n"
								+ "         podria hacer algunos ajustes.\n" + "         Ingrese a:\n"
								+ "   ¿MAS INFORMACION DE LA EMPRESA?\n" + "          y personalice su empresa!\n"
								+ "            ******* Buen Dia! *******");
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
