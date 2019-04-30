package formularios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.cargo;
import clases.contrato_empleado;
import clases.horario;
import conexion.conexion;
import consultas.consultas_cargo;
import consultas.consultas_contrato_empleado;
import consultas.consultas_horario;
import controles.control_cargo;
import controles.control_contrato_empleado;
import controles.control_horario;
import utilidades.visor_imagen;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextArea;

public class registro_asignaciones_empleados extends JFrame {

	public JPanel contentPane;
	public JTextField txtSueldoAsignacion;
	public JTextField txtHoraExtraAsignacion;
	public JTextField txtDiasAsignacion;
	public JTextField txtHorasAsignacion;
	public JTextField txtDireccionFotoContratoAsignacion;
	public JTextField txtTiempoContratoAsignacion;
	public JTextField txtTipoContratoAsignacion;
	public JTextArea txtFuncionesAsignacion;
	public JButton btnAgregarCargo;
	public JButton btnAgregarHorario;
	public JButton btnAgregarContrato;
	public JButton btnGuardarEmpleado;
	public static JComboBox<String> cbxCargoAsignacion;
	public static JComboBox<String> cbxHorarioAsignacion;
	public static JComboBox<String> cbxContratoAsignacion;
	public int contador1 = 0;
	public int contador2 = 0;
	public int contador3 = 0;
	public static String ruta;
	public static ImageIcon imagen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					registro_asignaciones_empleados frame = new registro_asignaciones_empleados();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public registro_asignaciones_empleados() {
		setType(Type.UTILITY);
		setResizable(false);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 639, 391);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		final ImageIcon icono = new ImageIcon(getClass().getResource("/material/libreta.png"));

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(26, 37, 579, 304);
		contentPane.add(panel);

		JLabel label = new JLabel("Sueldo.");
		label.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		label.setBounds(294, 43, 83, 14);
		panel.add(label);

		txtSueldoAsignacion = new JTextField();
		txtSueldoAsignacion.setForeground(new Color(0, 0, 0));
		txtSueldoAsignacion.setHorizontalAlignment(SwingConstants.CENTER);
		txtSueldoAsignacion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtSueldoAsignacion.setEditable(false);
		txtSueldoAsignacion.setColumns(10);
		txtSueldoAsignacion.setBounds(294, 60, 123, 20);
		panel.add(txtSueldoAsignacion);

		JLabel label_1 = new JLabel("Cargo :");
		label_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		label_1.setBounds(39, 62, 76, 17);
		panel.add(label_1);

		cbxCargoAsignacion = new JComboBox<String>();
		cbxCargoAsignacion.setForeground(new Color(0, 0, 0));
		cbxCargoAsignacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarDatosCargoAsignado();
			}
		});
		cbxCargoAsignacion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		cbxCargoAsignacion.setBackground(new Color(255, 255, 255));
		cbxCargoAsignacion.setBounds(109, 60, 128, 23);
		panel.add(cbxCargoAsignacion);

		JLabel label_2 = new JLabel("Asignaciones del empleado :");
		label_2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		label_2.setBounds(39, 24, 293, 33);
		panel.add(label_2);

		JLabel label_3 = new JLabel("Valor hora extra.");
		label_3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		label_3.setBounds(423, 43, 123, 14);
		panel.add(label_3);

		txtHoraExtraAsignacion = new JTextField();
		txtHoraExtraAsignacion.setForeground(new Color(0, 0, 0));
		txtHoraExtraAsignacion.setHorizontalAlignment(SwingConstants.CENTER);
		txtHoraExtraAsignacion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtHoraExtraAsignacion.setEditable(false);
		txtHoraExtraAsignacion.setColumns(10);
		txtHoraExtraAsignacion.setBounds(423, 60, 123, 20);
		panel.add(txtHoraExtraAsignacion);

		JLabel label_4 = new JLabel("Horario :");
		label_4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		label_4.setBounds(39, 150, 76, 17);
		panel.add(label_4);

		cbxHorarioAsignacion = new JComboBox<String>();
		cbxHorarioAsignacion.setForeground(new Color(0, 0, 0));
		cbxHorarioAsignacion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		cbxHorarioAsignacion.setBackground(new Color(255, 255, 255));
		cbxHorarioAsignacion.setBounds(109, 147, 128, 23);
		panel.add(cbxHorarioAsignacion);

		txtDiasAsignacion = new JTextField();
		txtDiasAsignacion.setForeground(new Color(0, 0, 0));
		txtDiasAsignacion.setHorizontalAlignment(SwingConstants.CENTER);
		txtDiasAsignacion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtDiasAsignacion.setEditable(false);
		txtDiasAsignacion.setColumns(10);
		txtDiasAsignacion.setBounds(294, 146, 123, 20);
		panel.add(txtDiasAsignacion);

		JLabel label_5 = new JLabel("Horas.");
		label_5.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		label_5.setBounds(423, 129, 83, 14);
		panel.add(label_5);

		JLabel label_6 = new JLabel("Dias.");
		label_6.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		label_6.setBounds(294, 129, 123, 14);
		panel.add(label_6);

		txtHorasAsignacion = new JTextField();
		txtHorasAsignacion.setForeground(new Color(0, 0, 0));
		txtHorasAsignacion.setHorizontalAlignment(SwingConstants.CENTER);
		txtHorasAsignacion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtHorasAsignacion.setEditable(false);
		txtHorasAsignacion.setColumns(10);
		txtHorasAsignacion.setBounds(423, 146, 123, 20);
		panel.add(txtHorasAsignacion);

		JLabel label_7 = new JLabel("Contrato :");
		label_7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		label_7.setBounds(39, 197, 76, 17);
		panel.add(label_7);

		cbxContratoAsignacion = new JComboBox<String>();
		cbxContratoAsignacion.setForeground(new Color(0, 0, 0));
		cbxContratoAsignacion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		cbxContratoAsignacion.setBackground(new Color(255, 255, 255));
		cbxContratoAsignacion.setBounds(109, 195, 128, 23);
		panel.add(cbxContratoAsignacion);

		JLabel label_8 = new JLabel("Fotografia del Contrato.");
		label_8.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		label_8.setBounds(147, 225, 146, 19);
		panel.add(label_8);

		txtDireccionFotoContratoAsignacion = new JTextField();
		txtDireccionFotoContratoAsignacion.setForeground(new Color(0, 0, 0));
		txtDireccionFotoContratoAsignacion.setHorizontalAlignment(SwingConstants.CENTER);
		txtDireccionFotoContratoAsignacion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtDireccionFotoContratoAsignacion.setEditable(false);
		txtDireccionFotoContratoAsignacion.setColumns(10);
		txtDireccionFotoContratoAsignacion.setBounds(294, 224, 183, 20);
		panel.add(txtDireccionFotoContratoAsignacion);

		JLabel label_9 = new JLabel("Tiempo");
		label_9.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		label_9.setBounds(423, 177, 83, 14);
		panel.add(label_9);

		txtTiempoContratoAsignacion = new JTextField();
		txtTiempoContratoAsignacion.setForeground(new Color(0, 0, 0));
		txtTiempoContratoAsignacion.setHorizontalAlignment(SwingConstants.CENTER);
		txtTiempoContratoAsignacion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtTiempoContratoAsignacion.setEditable(false);
		txtTiempoContratoAsignacion.setColumns(10);
		txtTiempoContratoAsignacion.setBounds(423, 194, 123, 20);
		panel.add(txtTiempoContratoAsignacion);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(294, 86, 252, 38);
		panel.add(scrollPane);

		txtFuncionesAsignacion = new JTextArea();
		txtFuncionesAsignacion.setForeground(new Color(0, 0, 0));
		txtFuncionesAsignacion.setBackground(new Color(230, 230, 250));
		txtFuncionesAsignacion.setEditable(false);
		scrollPane.setViewportView(txtFuncionesAsignacion);

		JLabel lblFuncionesDelEmpleado = new JLabel("Funciones del empleado.");
		lblFuncionesDelEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblFuncionesDelEmpleado.setBounds(141, 86, 152, 25);
		panel.add(lblFuncionesDelEmpleado);

		JButton button = new JButton("Ver");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				verFotoEmpleado();
			}
		});
		button.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 10));
		button.setBackground(Color.WHITE);
		button.setBounds(487, 225, 59, 21);
		panel.add(button);

		txtTipoContratoAsignacion = new JTextField();
		txtTipoContratoAsignacion.setForeground(new Color(0, 0, 0));
		txtTipoContratoAsignacion.setHorizontalAlignment(SwingConstants.CENTER);
		txtTipoContratoAsignacion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtTipoContratoAsignacion.setEditable(false);
		txtTipoContratoAsignacion.setColumns(10);
		txtTipoContratoAsignacion.setBounds(294, 194, 123, 20);
		panel.add(txtTipoContratoAsignacion);

		JLabel label_11 = new JLabel("Tipo.");
		label_11.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		label_11.setBounds(294, 177, 123, 14);
		panel.add(label_11);

		btnAgregarCargo = new JButton("+");
		btnAgregarCargo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 11));
		btnAgregarCargo.setBackground(new Color(0, 250, 154));
		btnAgregarCargo.setBounds(240, 60, 46, 23);
		panel.add(btnAgregarCargo);
		btnAgregarCargo.addActionListener(new ActionListener() {
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
				formulario.btnBorrarCargo.setVisible(false);
				formulario.btnGuardarCargo.setVisible(true);
				formulario.btnNuevoCargo.setVisible(true);
				formulario.btnActualizarCargo.setVisible(false);
				formulario.btnActualizarDatosCargo.setVisible(true);
				formulario.btnMostrar.setVisible(true);
				formulario.btnAceptar.setVisible(false);
				formulario.btnAtras.setVisible(false);
				formulario.btnRegresarALas.setVisible(true);
				dispose();
			}
		});

		btnAgregarHorario = new JButton("+");
		btnAgregarHorario.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 11));
		btnAgregarHorario.setBackground(new Color(0, 250, 154));
		btnAgregarHorario.setBounds(240, 147, 46, 23);
		panel.add(btnAgregarHorario);
		btnAgregarHorario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				formulario.btnBorrarHorario.setVisible(false);
				formulario.btnGuardarHorario.setVisible(true);
				formulario.btnNuevoHorario.setVisible(true);
				formulario.btnActualizarHorario.setVisible(false);
				formulario.btnActualizarDatosHorario.setVisible(true);
				formulario.btnMostrarHorario.setVisible(true);
				formulario.btnAceptarHorario.setVisible(false);
				formulario.btnAtras.setVisible(false);
				formulario.btnRegresarALas.setVisible(true);
				dispose();
			}
		});

		btnAgregarContrato = new JButton("+");
		btnAgregarContrato.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 11));
		btnAgregarContrato.setBackground(new Color(0, 250, 154));
		btnAgregarContrato.setBounds(240, 195, 46, 23);
		panel.add(btnAgregarContrato);
		btnAgregarContrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contrato_empleado clase = new contrato_empleado();
				consultas_contrato_empleado consulta = new consultas_contrato_empleado();
				registro_contratos_empleados formulario = new registro_contratos_empleados();
				control_contrato_empleado control = new control_contrato_empleado(clase, consulta, formulario);
				formulario.setVisible(true);
				formulario.setLocationRelativeTo(null);
				formulario.txtBusquedaContratosEmpleados.requestFocusInWindow();
				formulario.obtenerUltimoId();
				formulario.pistas();
				formulario.construirTabla();
				formulario.btnGuardarContrato.setVisible(true);
				formulario.btnNuevoContrato.setVisible(true);
				formulario.btnActualizarContrato.setVisible(false);
				formulario.btnAceptar.setVisible(false);
				formulario.btnBorrarContrato.setVisible(false);
				formulario.btnAtras.setVisible(false);
				formulario.btnRegresarALas.setVisible(true);
				dispose();
			}
		});

		btnGuardarEmpleado = new JButton("Guardar");
		btnGuardarEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnGuardarEmpleado.setBackground(new Color(60, 179, 113));
		btnGuardarEmpleado.setBounds(447, 255, 99, 23);
		panel.add(btnGuardarEmpleado);

		JLabel label_12 = new JLabel("");
		label_12.setBounds(0, 0, 579, 304);
		panel.add(label_12);
		final ImageIcon logo = new ImageIcon(
				icono.getImage().getScaledInstance(label_12.getWidth(), label_12.getHeight(), Image.SCALE_DEFAULT));
		label_12.setIcon(logo);

		JLabel lblRegistroYMantenimiento = new JLabel("REGISTRO Y MANTENIMIENTO DE ASIGNACIONES.");
		lblRegistroYMantenimiento.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblRegistroYMantenimiento.setBounds(26, 11, 579, 23);
		contentPane.add(lblRegistroYMantenimiento);
		
		cbxContratoAsignacion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e1) {
				conexion objCon = new conexion();
				Connection conn = objCon.getConexion();
				try {
					if (contador3 > 0) {
						PreparedStatement stmtr = conn.prepareStatement(
								"SELECT identidad_contrato_empleado, tipo_contrato_empleado, tiempo_contrato_empleado, direccion_foto_contrato_empleado FROM contrato_empleado where identidad_contrato_empleado = '"
										+ cbxContratoAsignacion.getSelectedItem() + "'");
						ResultSet rsr = stmtr.executeQuery();
						rsr.next();
						txtTipoContratoAsignacion.setText(rsr.getString("tipo_contrato_empleado"));
						txtTiempoContratoAsignacion.setText(rsr.getString("tiempo_contrato_empleado"));
						txtDireccionFotoContratoAsignacion.setText(rsr.getString("direccion_foto_contrato_empleado"));
						;
						stmtr.close();
						rsr.close();
					}
					conn.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		cbxHorarioAsignacion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				conexion objCon = new conexion();
				Connection conn = objCon.getConexion();
				try {
					if (contador2 > 0) {
						PreparedStatement stmtr = conn.prepareStatement(
								"SELECT dias_horario, horas_horario FROM horarios where tipo_horario = '"
										+ cbxHorarioAsignacion.getSelectedItem() + "'");
						ResultSet rsr = stmtr.executeQuery();
						rsr.next();
						txtDiasAsignacion.setText(rsr.getString("dias_horario"));
						txtHorasAsignacion.setText(rsr.getString("horas_horario"));
						;
						stmtr.close();
						rsr.close();
					}
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}
		

	public void verFotoEmpleado() {
		if (txtDireccionFotoContratoAsignacion.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hay imagen que mostrar");
		} else {
			visor_imagen visor = new visor_imagen();
			ruta = txtDireccionFotoContratoAsignacion.getText().toString();
			visor.txtRutaImagen.setText(ruta);
			visor.setVisible(true);
			visor.setLocationRelativeTo(null);
			imagen = new ImageIcon(ruta);
			visor_imagen.lblImagen.setIcon(imagen);
		}
	}
	
	public void cargarDatosCargoAsignado() {
		try {
			conexion objCon = new conexion();
			Connection conn = objCon.getConexion();
			if (contador1 > 0) {	
				PreparedStatement stmtr = conn.prepareStatement(
						"SELECT sueldo_cargo, valor_hora_extra_cargo, funciones_cargo FROM cargos where nombre_cargo = '"
								+ cbxCargoAsignacion.getSelectedItem().toString() + "'");
				ResultSet rsr = stmtr.executeQuery();
				rsr.next();
				txtSueldoAsignacion.setText(rsr.getString("sueldo_cargo"));
				txtHoraExtraAsignacion.setText(rsr.getString("valor_hora_extra_cargo"));
				txtFuncionesAsignacion.setText(rsr.getString("funciones_cargo"));
				;
				stmtr.close();
				rsr.close();	
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void cargarDatosHorarioAsignado() {

	}

	public void cargarDatosContratoAsignado() {

	}
}
