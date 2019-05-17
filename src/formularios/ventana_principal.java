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
import javax.print.attribute.standard.Media;
import javax.swing.ImageIcon;

import clases.bonificacion;
import clases.cargo;
import clases.contrato_empleado;
import clases.deduccion;
import clases.empleado;
import clases.empresa;
import clases.horario;
import clases.planilla;
import conexion.conexion;
import consultas.consultas_bonificacion;
import consultas.consultas_cargo;
import consultas.consultas_contrato_empleado;
import consultas.consultas_deduccion;
import consultas.consultas_empleado;
import consultas.consultas_empresa;
import consultas.consultas_horario;
import consultas.consultas_planilla;
import controles.control_bonificacion;
import controles.control_cargo;
import controles.control_contrato_empleado;
import controles.control_deduccion;
import controles.control_empleado;
import controles.control_empresa;
import controles.control_horario;
import controles.control_planilla;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

public class ventana_principal extends JFrame {

	private JPanel contentPane;
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
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/iconos/icono_d_a.jpg")));

		lbl_nombre_empresa_principal = new JLabel();
		lbl_nombre_empresa_principal.setForeground(Color.BLACK);
		lbl_nombre_empresa_principal.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_nombre_empresa_principal.setBounds(420, 219, 252, 19);
		lbl_nombre_empresa_principal.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
		contentPane.add(lbl_nombre_empresa_principal);
		lbl_nombre_empresa_principal.setText("Nombre de la empresa.");

		lbl_logo_empresa_principal = new JLabel();
		lbl_logo_empresa_principal.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_logo_empresa_principal.setBounds(420, 240, 252, 177);
		contentPane.add(lbl_logo_empresa_principal);
		final ImageIcon logo = new ImageIcon(getClass().getResource("/iconos/logo_estandar.png"));
		final ImageIcon icono = new ImageIcon(
				logo.getImage().getScaledInstance(lbl_logo_empresa_principal.getWidth(), lbl_logo_empresa_principal.getHeight(), Image.SCALE_DEFAULT));
		lbl_logo_empresa_principal.setIcon(icono);

		btnInformacionEmpresa = new JButton("\u00BFMas Informaci\u00F3n de la empresa?");
		btnInformacionEmpresa.setBackground(Color.WHITE);
		btnInformacionEmpresa.setBounds(420, 428, 252, 23);
		btnInformacionEmpresa.setForeground(Color.BLACK);
		btnInformacionEmpresa.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 11));
		contentPane.add(btnInformacionEmpresa);
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
				formulario.txtNombre_Empresa.setText(nombre);
				dispose();
			}
		});

		final ImageIcon logo2 = new ImageIcon(getClass().getResource("/iconos/libreta.png"));
		final ImageIcon logousuario = new ImageIcon(getClass().getResource("/iconos/usuario.png"));

		JLabel lblMenuDeOpciones = new JLabel("Men\u00FA de Opciones :");
		lblMenuDeOpciones.setForeground(Color.BLACK);
		lblMenuDeOpciones.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblMenuDeOpciones.setBounds(146, 77, 145, 23);
		contentPane.add(lblMenuDeOpciones);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(46, 99, 327, 92);
		contentPane.add(panel);
		panel.setLayout(null);

		registroPlanilla = new JButton("Planillas");
		registroPlanilla.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				planilla clase = new planilla();
				consultas_planilla consulta = new consultas_planilla();
				registro_planillas formulario = new registro_planillas();
				control_planilla control = new control_planilla(clase, consulta, formulario);
				formulario.setVisible(true);
				formulario.setLocationRelativeTo(null);
				formulario.txtIdentidadEmpleadoPlanilla.requestFocusInWindow();
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
		registroPlanilla.setForeground(Color.BLACK);
		registroPlanilla.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		registroPlanilla.setBackground(new Color(102, 205, 170));
		registroPlanilla.setBounds(117, 66, 97, 21);
		panel.add(registroPlanilla);

		registroContrato = new JButton("Contratos");
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
		registroContrato.setForeground(Color.BLACK);
		registroContrato.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		registroContrato.setBackground(new Color(102, 205, 170));
		registroContrato.setBounds(10, 41, 97, 21);
		panel.add(registroContrato);

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
		registroBonificacion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				bonificacion clase = new bonificacion();
				consultas_bonificacion consulta = new consultas_bonificacion();
				registro_bonificaciones formulario = new registro_bonificaciones();
				control_bonificacion control = new control_bonificacion(clase, consulta, formulario);
				formulario.setVisible(true);
				formulario.setLocationRelativeTo(null);
				formulario.txtIdentidadEmpleadoBonificacion.requestFocusInWindow();
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
		registroBonificacion.setForeground(Color.BLACK);
		registroBonificacion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		registroBonificacion.setBackground(new Color(102, 205, 170));
		registroBonificacion.setBounds(117, 41, 97, 21);
		panel.add(registroBonificacion);

		registroDeduccion = new JButton("Deducciones");
		registroDeduccion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deduccion clase = new deduccion();
				consultas_deduccion consulta = new consultas_deduccion();
				registro_deducciones formulario = new registro_deducciones();
				control_deduccion control = new control_deduccion(clase, consulta, formulario);
				formulario.setVisible(true);
				formulario.setLocationRelativeTo(null);
				formulario.txtIdentidadEmpleadoDeduccion.requestFocusInWindow();
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
		registroDeduccion.setForeground(Color.BLACK);
		registroDeduccion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		registroDeduccion.setBackground(new Color(102, 205, 170));
		registroDeduccion.setBounds(224, 41, 97, 21);
		panel.add(registroDeduccion);

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
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(46, 192, 327, 72);
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
		button_7.setBackground(new Color(60, 179, 113));
		button_7.setBounds(10, 19, 97, 21);
		panel_1.add(button_7);

		JButton button_8 = new JButton("Contratos");
		button_8.setForeground(Color.BLACK);
		button_8.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		button_8.setBackground(new Color(60, 179, 113));
		button_8.setBounds(117, 19, 97, 21);
		panel_1.add(button_8);

		JButton button_9 = new JButton("Servicios");
		button_9.setForeground(Color.BLACK);
		button_9.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		button_9.setBackground(new Color(60, 179, 113));
		button_9.setBounds(117, 46, 97, 21);
		panel_1.add(button_9);

		JButton button_10 = new JButton("Productos");
		button_10.setForeground(Color.BLACK);
		button_10.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		button_10.setBackground(new Color(60, 179, 113));
		button_10.setBounds(224, 19, 97, 21);
		panel_1.add(button_10);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(46, 263, 327, 92);
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

		JLabel label_5 = new JLabel("Facturas :");
		label_5.setForeground(Color.BLACK);
		label_5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		label_5.setBounds(10, 40, 97, 21);
		panel_2.add(label_5);

		JButton button_13 = new JButton("Facturas Clientes");
		button_13.setForeground(Color.BLACK);
		button_13.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		button_13.setBackground(new Color(255, 215, 0));
		button_13.setBounds(10, 59, 145, 21);
		panel_2.add(button_13);

		JButton button_14 = new JButton("Facturas Empresa");
		button_14.setForeground(Color.BLACK);
		button_14.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		button_14.setBackground(new Color(255, 215, 0));
		button_14.setBounds(176, 59, 145, 21);
		panel_2.add(button_14);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_3.setBounds(46, 354, 327, 83);
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
		button_15.setBounds(10, 19, 97, 21);
		panel_3.add(button_15);

		JButton button_16 = new JButton("Proveedores");
		button_16.setForeground(Color.BLACK);
		button_16.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		button_16.setBackground(Color.PINK);
		button_16.setBounds(117, 19, 97, 21);
		panel_3.add(button_16);

		JButton button_17 = new JButton("Compras");
		button_17.setForeground(Color.BLACK);
		button_17.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		button_17.setBackground(Color.PINK);
		button_17.setBounds(224, 19, 97, 21);
		panel_3.add(button_17);

		JLabel label_7 = new JLabel("Reportes :");
		label_7.setForeground(Color.BLACK);
		label_7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		label_7.setBounds(132, 39, 87, 21);
		panel_3.add(label_7);

		JButton button_18 = new JButton("Generar Reportes");
		button_18.setForeground(Color.BLACK);
		button_18.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		button_18.setBackground(new Color(255, 165, 0));
		button_18.setBounds(96, 57, 143, 21);
		panel_3.add(button_18);

		JLabel lblMenuOpciones = new JLabel();
		lblMenuOpciones.setBounds(21, 43, 379, 417);
		contentPane.add(lblMenuOpciones);
		final ImageIcon icono2 = new ImageIcon(logo2.getImage().getScaledInstance(lblMenuOpciones.getWidth(),
				lblMenuOpciones.getHeight(), Image.SCALE_DEFAULT));
		lblMenuOpciones.setIcon(icono2);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4.setBounds(481, 41, 133, 26);
		contentPane.add(panel_4);
		panel_4.setLayout(null);

		lbl_horaSistema = new JLabel();
		lbl_horaSistema.setBounds(0, 0, 131, 26);
		panel_4.add(lbl_horaSistema);
		lbl_horaSistema.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		lbl_horaSistema.setBackground(UIManager.getColor("Button.background"));
		lbl_horaSistema.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(410, 73, 274, 135);
		contentPane.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblSuperUsuario = new JLabel("Super usuario");
		lblSuperUsuario.setBounds(10, 110, 119, 14);
		panel_5.add(lblSuperUsuario);
		lblSuperUsuario.setForeground(Color.BLACK);
		lblSuperUsuario.setFont(new Font("Dialog", Font.PLAIN, 12));

		JLabel lblUsuario_1 = new JLabel("Usuario :");
		lblUsuario_1.setBounds(10, 96, 75, 14);
		panel_5.add(lblUsuario_1);
		lblUsuario_1.setForeground(Color.BLACK);
		lblUsuario_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 11));

		JLabel lblDeveloper = new JLabel("Developer");
		lblDeveloper.setBounds(10, 79, 119, 20);
		panel_5.add(lblDeveloper);
		lblDeveloper.setForeground(Color.BLACK);
		lblDeveloper.setFont(new Font("Dialog", Font.PLAIN, 12));

		JLabel lblCargo = new JLabel("Cargo :");
		lblCargo.setBounds(10, 68, 75, 14);
		panel_5.add(lblCargo);
		lblCargo.setForeground(Color.BLACK);
		lblCargo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 11));

		JLabel lblDiazRodriguez = new JLabel("Diaz Rodriguez");
		lblDiazRodriguez.setBounds(10, 54, 131, 14);
		panel_5.add(lblDiazRodriguez);
		lblDiazRodriguez.setForeground(Color.BLACK);
		lblDiazRodriguez.setFont(new Font("Dialog", Font.PLAIN, 12));

		JLabel lblCristianDiaz = new JLabel("Cristian Emmanuel");
		lblCristianDiaz.setBounds(10, 40, 131, 14);
		panel_5.add(lblCristianDiaz);
		lblCristianDiaz.setForeground(Color.BLACK);
		lblCristianDiaz.setFont(new Font("Dialog", Font.PLAIN, 12));

		JLabel lblUsuario = new JLabel("Nombre completo :");
		lblUsuario.setBounds(10, 23, 131, 20);
		panel_5.add(lblUsuario);
		lblUsuario.setForeground(Color.BLACK);
		lblUsuario.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 11));

		JLabel lblDatosDeUsuario = new JLabel("DATOS DEL USUARIO");
		lblDatosDeUsuario.setForeground(Color.BLACK);
		lblDatosDeUsuario.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 11));
		lblDatosDeUsuario.setBounds(10, 0, 144, 28);
		panel_5.add(lblDatosDeUsuario);

		JLabel labelfotousuario = new JLabel();
		labelfotousuario.setBounds(151, 12, 113, 112);
		panel_5.add(labelfotousuario);
		labelfotousuario.setHorizontalAlignment(SwingConstants.CENTER);
		labelfotousuario.setForeground(Color.LIGHT_GRAY);
		final ImageIcon iconousuario = new ImageIcon(logousuario.getImage()
				.getScaledInstance(labelfotousuario.getWidth(), labelfotousuario.getHeight(), Image.SCALE_DEFAULT));
		labelfotousuario.setIcon(iconousuario);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(410, 11, 274, 26);
		contentPane.add(panel_6);
		panel_6.setLayout(null);

		lbl_fechaSistema = new JLabel();
		lbl_fechaSistema.setBounds(0, 0, 274, 26);
		panel_6.add(lbl_fechaSistema);
		lbl_fechaSistema.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		lbl_fechaSistema.setBackground(Color.WHITE);
		lbl_fechaSistema.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fechaSistema.setText(getFecha());

		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(410, 219, 274, 241);
		contentPane.add(panel_7);
		panel_7.setLayout(null);

		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_8.setBackground(Color.WHITE);
		panel_8.setBounds(21, 11, 379, 34);
		contentPane.add(panel_8);

		JLabel lblBienvenidoAlSistema = new JLabel("Bienvenido al Sistema Administrativo.");
		panel_8.add(lblBienvenidoAlSistema);
		lblBienvenidoAlSistema.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenidoAlSistema.setForeground(Color.BLACK);
		lblBienvenidoAlSistema.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));

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
			ResultSet rs = estatuto.executeQuery("SELECT nombre_empresa, direccion_logo_empresa FROM empresa where id_empresa = 1");

			if (rs.next()) {
				nombre = (rs.getString("nombre_empresa"));
				ruta_logo = (rs.getString("direccion_logo_empresa"));
				lbl_nombre_empresa_principal.setText(nombre);
				final ImageIcon logo = new ImageIcon(ruta_logo);
				final ImageIcon icono = new ImageIcon(
						logo.getImage().getScaledInstance(lbl_logo_empresa_principal.getWidth(), lbl_logo_empresa_principal.getHeight(), Image.SCALE_DEFAULT));
				lbl_logo_empresa_principal.setIcon(icono);
			}else {
				JOptionPane.showMessageDialog(null, "BIENVENIDO AL SISTEMA ADMINISTRATIVO\n"
						+ "         Antes de comensar\n"
						+ "         podria hacer algunos ajustes.\n"
						+ "         Ingrese a:\n"
						+ "   ¿MAS INFORMACION DE LA EMPRESA?\n"
						+ "          y personalice su empresa!\n"
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
	
	public void vozBienvenido() throws FileNotFoundException, JavaLayerException {
		      Player apl = new Player(new FileInputStream(
		            "src/audios/bienvenido.mp3"));
		      apl.play();
	
	}

}
