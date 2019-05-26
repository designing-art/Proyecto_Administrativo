package formularios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

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
		setBounds(100, 100, 470, 409);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		final ImageIcon icono = new ImageIcon(getClass().getResource("/iconos/libreta.png"));

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(26, 37, 410, 332);
		contentPane.add(panel);

		JLabel lblPlanillas = new JLabel("Planillas :");
		lblPlanillas.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblPlanillas.setBounds(39, 62, 76, 17);
		panel.add(lblPlanillas);

		cbxPlanillasCreadas = new JComboBox<String>();
		cbxPlanillasCreadas.setForeground(new Color(0, 0, 0));
		cbxPlanillasCreadas.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		cbxPlanillasCreadas.setBackground(new Color(255, 255, 255));
		cbxPlanillasCreadas.setBounds(109, 60, 128, 23);
		panel.add(cbxPlanillasCreadas);
		cbxPlanillasCreadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarDatosCargoAsignado();
			}
		});

		JLabel lblListaDePlanillas = new JLabel("Lista de planillas creadas :");
		lblListaDePlanillas.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblListaDePlanillas.setBounds(39, 24, 293, 33);
		panel.add(lblListaDePlanillas);

		JLabel lblFuncionesDelEmpleado = new JLabel("Datos de la planilla.");
		lblFuncionesDelEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblFuncionesDelEmpleado.setBounds(39, 87, 166, 25);
		panel.add(lblFuncionesDelEmpleado);

		MaskFormatter formato = null;
		try {
			formato = new MaskFormatter("####-####-#####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

		JButton btnGuardarAsignaciones = new JButton("Nueva");
		btnGuardarAsignaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtSueldoAsignacion.getText().isEmpty()
						|| txtHoraExtraAsignacion.getText().isEmpty()
						|| txtFuncionesAsignacion.getText().isEmpty()
						|| txtDiasAsignacion.getText().isEmpty()
						|| txtHorasAsignacion.getText().isEmpty()
						|| txtTipoContratoAsignacion.getText().isEmpty()
						|| txtTiempoContratoAsignacion.getText().isEmpty()
						|| txtFuncionesAsignacion.getText().isEmpty()) 
				{
					JOptionPane.showMessageDialog(null, "Porfavor llene todos los campos para continuar.");
				} else {
					registro_empleados.lbl_nombre_cargo_asignacion.setText(cbxPlanillasCreadas.getSelectedItem().toString());
					registro_empleados.lbl_sueldo_cargo_asignacion.setText(txtSueldoAsignacion.getText().toString());
					registro_empleados.lbl_horaextra_cargo_asignacion.setText(txtHoraExtraAsignacion.getText().toString());
					registro_empleados.lbl_funciones_cargo_asignacion.setText(txtFuncionesAsignacion.getText().toString());
					registro_empleados.lbl_tipo_horario_asignacion.setText(cbxHorarioAsignacion.getSelectedItem().toString());
					registro_empleados.lbl_dias_horario_asignacion.setText(txtDiasAsignacion.getText().toString());
					registro_empleados.lbl_horas_horario_asignacion.setText(txtHorasAsignacion.getText().toString());
					registro_empleados.lbl_contrato_empleado_asignacion.setText(cbxContratoAsignacion.getSelectedItem().toString());
					registro_empleados.lbl_tipo_empleado_asignacion.setText(txtTipoContratoAsignacion.getText().toString());
					registro_empleados.lbl_tiempo_empleado_asignacion.setText(txtTiempoContratoAsignacion.getText().toString());
					registro_empleados.lbl_foto_empleado_asignacion.setText(txtDireccionFotoContratoAsignacion.getText().toString());
					dispose();
					JOptionPane.showMessageDialog(null, "Exito! Empleado asignado correctamente");
				}
			}
		});
		btnGuardarAsignaciones.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnGuardarAsignaciones.setBackground(new Color(152, 251, 152));
		btnGuardarAsignaciones.setBounds(230, 287, 141, 23);
		panel.add(btnGuardarAsignaciones);
		
		JButton btnTrabajar = new JButton("Trabajar");
		btnTrabajar.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnTrabajar.setBackground(new Color(255, 165, 0));
		btnTrabajar.setBounds(39, 287, 141, 23);
		panel.add(btnTrabajar);
		
				JLabel label_12 = new JLabel("");
				label_12.setHorizontalAlignment(SwingConstants.CENTER);
				label_12.setBounds(0, 0, 409, 332);
				panel.add(label_12);
				final ImageIcon logo = new ImageIcon(
						icono.getImage().getScaledInstance(label_12.getWidth(), label_12.getHeight(), Image.SCALE_DEFAULT));
				label_12.setIcon(logo);

		JLabel lblRegistroYMantenimiento = new JLabel("PLANILLAS CREADAS");
		lblRegistroYMantenimiento.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroYMantenimiento.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblRegistroYMantenimiento.setBounds(26, 11, 410, 23);
		contentPane.add(lblRegistroYMantenimiento);

	}

	public void cargarDatosCargoAsignado() {
		try {
			conexion objCon = new conexion();
			Connection conn = objCon.getConexion();
			if (contador1 > 0) {
				PreparedStatement stmtr = conn.prepareStatement(
						"SELECT sueldo_cargo, valor_hora_extra_cargo, funciones_cargo FROM cargos where nombre_cargo = '"
								+ cbxPlanillasCreadas.getSelectedItem().toString() + "'");
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
}
