package formularios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import clases.cargo;
import clases.contrato_empleado;
import clases.historial_planilla;
import clases.horario;
import conexion.conexion;
import consultas.consultas_cargo;
import consultas.consultas_contrato_empleado;
import consultas.consultas_historial_planilla;
import consultas.consultas_horario;
import controles.control_cargo;
import controles.control_contrato_empleado;
import controles.control_historial_planilla;
import controles.control_horario;
import utilidades.visor_imagen;

import java.awt.Color;
import java.awt.Event;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Timer;

import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class historial_planillas extends JFrame {

	public JPanel contentPane;
	public static JComboBox<String> cbxPlanillasCreadas;
	public int contador1 = 0;
	public int contador2 = 0;
	public int contador3 = 0;
	public static String ruta;
	public static ImageIcon imagen;
	public static String identidad = null;
	public static JTextField txtFechaPagoHistorialPlanilla;
	public static JTextField txtNombreHistorialPlanilla;
	public static JTextField txtFechaCreacionHistorialPlanilla;
	public static JTextField txtTotalPagoHistorialPlanilla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					historial_planillas frame = new historial_planillas();
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
	public historial_planillas() {
		setType(Type.UTILITY);
		setResizable(false);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 470, 303);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		final ImageIcon icono = new ImageIcon(getClass().getResource("/iconos/libreta.png"));

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(26, 32, 410, 222);
		contentPane.add(panel);

		JLabel lblPlanillas = new JLabel("PLANILLAS CREADAS :");
		lblPlanillas.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblPlanillas.setBounds(38, 28, 166, 17);
		panel.add(lblPlanillas);

		cbxPlanillasCreadas = new JComboBox<String>();
		cbxPlanillasCreadas.setForeground(new Color(0, 0, 0));
		cbxPlanillasCreadas.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		cbxPlanillasCreadas.setBackground(new Color(255, 255, 255));
		cbxPlanillasCreadas.setBounds(209, 25, 157, 23);
		panel.add(cbxPlanillasCreadas);
		cbxPlanillasCreadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarPlanillasCreadas();
			}
		});

		JLabel lblFuncionesDelEmpleado = new JLabel("Datos de la planilla.");
		lblFuncionesDelEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblFuncionesDelEmpleado.setBounds(38, 49, 166, 25);
		panel.add(lblFuncionesDelEmpleado);

		MaskFormatter formato = null;
		try {
			formato = new MaskFormatter("####-####-#####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		JButton btnTrabajar = new JButton("Trabajar");
		btnTrabajar.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnTrabajar.setBackground(new Color(255, 165, 0));
		btnTrabajar.setBounds(38, 179, 128, 23);
		panel.add(btnTrabajar);

		JLabel lblNombreDeLa = new JLabel("Nombre de la planilla :");
		lblNombreDeLa.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblNombreDeLa.setBounds(38, 75, 166, 25);
		panel.add(lblNombreDeLa);

		JLabel lblFechaDeCreacion = new JLabel("Fecha de creaci\u00F3n :");
		lblFechaDeCreacion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblFechaDeCreacion.setBounds(38, 98, 166, 25);
		panel.add(lblFechaDeCreacion);

		JLabel lblFechaDePago = new JLabel("Fecha de pago :");
		lblFechaDePago.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblFechaDePago.setBounds(38, 121, 166, 25);
		panel.add(lblFechaDePago);

		JLabel lblTotalPagoDe = new JLabel("Total pago de la planilla :");
		lblTotalPagoDe.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblTotalPagoDe.setBounds(38, 143, 166, 25);
		panel.add(lblTotalPagoDe);

		JButton btnNueva = new JButton("Nueva");
		btnNueva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				historial_planilla clase = new historial_planilla();
				consultas_historial_planilla consulta = new consultas_historial_planilla();
				registro_nuevas_planillas formulario = new registro_nuevas_planillas();
				control_historial_planilla control = new control_historial_planilla(clase, consulta, formulario);
				formulario.setVisible(true);
				formulario.setLocationRelativeTo(null);
				formulario.txtNombrePlanilla.requestFocusInWindow();
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
				formulario.iniciarEncero();
				Timer time = new Timer();
				time.schedule(formulario.tarea, 0, 1000);
				dispose();
			}
		});
		btnNueva.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnNueva.setBackground(new Color(50, 205, 50));
		btnNueva.setBounds(238, 179, 128, 23);
		panel.add(btnNueva);

		txtFechaPagoHistorialPlanilla = new JTextField();
		txtFechaPagoHistorialPlanilla.setBounds(209, 124, 157, 20);
		panel.add(txtFechaPagoHistorialPlanilla);
		txtFechaPagoHistorialPlanilla.setColumns(10);

		txtNombreHistorialPlanilla = new JTextField();
		txtNombreHistorialPlanilla.setColumns(10);
		txtNombreHistorialPlanilla.setBounds(209, 78, 157, 20);
		panel.add(txtNombreHistorialPlanilla);

		txtFechaCreacionHistorialPlanilla = new JTextField();
		txtFechaCreacionHistorialPlanilla.setColumns(10);
		txtFechaCreacionHistorialPlanilla.setBounds(209, 101, 157, 20);
		panel.add(txtFechaCreacionHistorialPlanilla);

		txtTotalPagoHistorialPlanilla = new JTextField();
		txtTotalPagoHistorialPlanilla.setColumns(10);
		txtTotalPagoHistorialPlanilla.setBounds(209, 146, 157, 20);
		panel.add(txtTotalPagoHistorialPlanilla);

		JLabel label_12 = new JLabel("");
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setBounds(0, 0, 409, 221);
		panel.add(label_12);
		final ImageIcon logo = new ImageIcon(
				icono.getImage().getScaledInstance(label_12.getWidth(), label_12.getHeight(), Image.SCALE_DEFAULT));
		label_12.setIcon(logo);

		JLabel lblRegistroYMantenimiento = new JLabel("HISTORIAL DE PLANILLAS CREADAS");
		lblRegistroYMantenimiento.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroYMantenimiento.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblRegistroYMantenimiento.setBounds(26, 11, 410, 23);
		contentPane.add(lblRegistroYMantenimiento);

	}

	public void cargarPlanillasCreadas() {
		try {
			conexion objCon = new conexion();
			Connection conn = objCon.getConexion();
			if (contador3 > 0) {
				PreparedStatement stmtr = conn.prepareStatement(
						"SELECT nombre_planilla_final, fecha_crecion_planilla_final, fecha_pago_planilla_final, total_pago_planilla_final FROM historial_planillas where nombre_planilla_final = '"
								+ cbxPlanillasCreadas.getSelectedItem().toString() + "'");
				ResultSet rsr = stmtr.executeQuery();
				rsr.next();
				txtNombreHistorialPlanilla.setText(rsr.getString("nombre_planilla_final"));
				txtFechaCreacionHistorialPlanilla.setText(rsr.getString("fecha_crecion_planilla_final"));
				txtFechaPagoHistorialPlanilla.setText(rsr.getString("fecha_pago_planilla_final"));
				txtTotalPagoHistorialPlanilla.setText(rsr.getString("total_pago_planilla_final"));
				;
				stmtr.close();
				rsr.close();
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void consultarPlanillas() {
		conexion conex = new conexion();
		try {
			Statement estatuto = conex.getConexion().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT nombre_planilla_final FROM historial_planillas");

			while (rs.next()) {
			cbxPlanillasCreadas.addItem(rs.getString("nombre_planilla_final"));
			}
			contador3++;
			rs.close();
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error al consultar", "Error", JOptionPane.ERROR_MESSAGE);

		}

	}
}
