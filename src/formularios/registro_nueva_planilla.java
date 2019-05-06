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
	
	public JTextFieldDateEditor editor1;
	public JTextFieldDateEditor editor2;

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
		editor2.setEditable(false);
		editor2.setHorizontalAlignment(SwingConstants.CENTER);
		editor1.setEditable(false);
		editor1.setHorizontalAlignment(SwingConstants.CENTER);

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
