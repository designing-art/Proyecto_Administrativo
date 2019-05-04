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
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import javax.swing.DefaultComboBoxModel;

public class registro_nueva_planilla extends JFrame {

	public JPanel contentPane;
	public int contador1 = 0;
	public int contador2 = 0;
	public int contador3 = 0;
	public static String ruta;
	public static ImageIcon imagen;
	public static String identidad = null;
	private JTextField txtCodigoNuevaPlanila;
	private JTextField txtNombreNuevaPlanilla;
	
	public JTextFieldDateEditor editor1;
	public JTextFieldDateEditor editor2;
	
	public JDateChooser dateFechaCreacionNuevaPlanilla;
	public JDateChooser dateFechaPagoNuevaPlanilla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					registro_nueva_planilla frame = new registro_nueva_planilla();
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
	public registro_nueva_planilla() {
		setType(Type.UTILITY);
		setResizable(false);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 360, 278);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		final ImageIcon icono = new ImageIcon(getClass().getResource("/material/libreta.png"));

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 37, 334, 203);
		contentPane.add(panel);

		MaskFormatter formato = null;
		try {
			formato = new MaskFormatter("####-####-#####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCancelar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setBounds(22, 162, 99, 20);
		panel.add(btnCancelar);

		JLabel label = new JLabel("Codigo :");
		label.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		label.setBounds(22, 48, 63, 18);
		panel.add(label);

		txtCodigoNuevaPlanila = new JTextField();
		txtCodigoNuevaPlanila.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigoNuevaPlanila.setEditable(false);
		txtCodigoNuevaPlanila.setColumns(10);
		txtCodigoNuevaPlanila.setBounds(95, 46, 28, 20);
		panel.add(txtCodigoNuevaPlanila);

		JLabel lblDatosDeLa = new JLabel("Datos generales de la planilla.");
		lblDatosDeLa.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblDatosDeLa.setBounds(22, 21, 253, 26);
		panel.add(lblDatosDeLa);

		JLabel label_2 = new JLabel("Tipo :");
		label_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		label_2.setBounds(22, 77, 63, 18);
		panel.add(label_2);

		JComboBox cbxTipoNuevaPlanilla = new JComboBox();
		cbxTipoNuevaPlanilla.setModel(new DefaultComboBoxModel(new String[] { "Mensual", "Eventual", "Quincenal" }));
		cbxTipoNuevaPlanilla.setBounds(95, 75, 116, 20);
		panel.add(cbxTipoNuevaPlanilla);

		JLabel lblNombre_1 = new JLabel("Nombre :");
		lblNombre_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblNombre_1.setBounds(22, 106, 63, 18);
		panel.add(lblNombre_1);

		txtNombreNuevaPlanilla = new JTextField();
		txtNombreNuevaPlanilla.setBounds(95, 106, 217, 18);
		panel.add(txtNombreNuevaPlanilla);
		txtNombreNuevaPlanilla.setColumns(10);

		dateFechaCreacionNuevaPlanilla = new JDateChooser();
		dateFechaCreacionNuevaPlanilla.setBounds(213, 75, 99, 20);
		panel.add(dateFechaCreacionNuevaPlanilla);
		editor2 = (JTextFieldDateEditor) dateFechaCreacionNuevaPlanilla.getDateEditor();
		editor2.setEditable(false);
		editor2.setHorizontalAlignment(SwingConstants.CENTER);
		dateFechaCreacionNuevaPlanilla.setVisible(false);


		JLabel lblFechaEnQue = new JLabel("Fecha de pago :");
		lblFechaEnQue.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblFechaEnQue.setBounds(22, 135, 116, 18);
		panel.add(lblFechaEnQue);

		dateFechaPagoNuevaPlanilla = new JDateChooser();
		dateFechaPagoNuevaPlanilla.setBounds(128, 135, 116, 20);
		panel.add(dateFechaPagoNuevaPlanilla);
		editor1 = (JTextFieldDateEditor) dateFechaPagoNuevaPlanilla.getDateEditor();
		editor1.setEditable(false);
		editor1.setHorizontalAlignment(SwingConstants.CENTER);
		dateFechaPagoNuevaPlanilla.setVisible(false);

		JButton btnGuardarNuevaPlanilla = new JButton("Guardar");
		btnGuardarNuevaPlanilla.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnGuardarNuevaPlanilla.setBackground(new Color(34, 139, 34));
		btnGuardarNuevaPlanilla.setBounds(213, 162, 99, 20);
		panel.add(btnGuardarNuevaPlanilla);

		JLabel lblNombre = new JLabel("");
		lblNombre.setBounds(0, 0, 334, 203);
		panel.add(lblNombre);
		final ImageIcon logo = new ImageIcon(
				icono.getImage().getScaledInstance(lblNombre.getWidth(), lblNombre.getHeight(), Image.SCALE_DEFAULT));
		lblNombre.setIcon(logo);

		JLabel lblRegistroYMantenimiento = new JLabel("REGISTRO NUEVA PLANILLA");
		lblRegistroYMantenimiento.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroYMantenimiento.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblRegistroYMantenimiento.setBounds(10, 3, 334, 32);
		contentPane.add(lblRegistroYMantenimiento);

	}
}
