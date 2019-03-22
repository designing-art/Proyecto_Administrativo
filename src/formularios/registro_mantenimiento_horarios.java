package formularios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class registro_mantenimiento_horarios extends JFrame {
	public JTextField txtidhorario;
	public JTextField txttipohorario;
	public JTextField txtdescripciohorario;
	public JTextField txtobservacionhorario;


	public JPanel contentPane;
	public JTextField txthorainicio_horario;
	public JTextField txtdias_horario;
	public JTextField txthorafinal_horario;
	public JButton btnGuardarHorario;
	public JButton btnActualizarHorario;
	public JButton btnNuevoHorario;
	public JButton btnSalirHorario;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registro_mantenimiento_horarios frame = new registro_mantenimiento_horarios();
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
	public registro_mantenimiento_horarios() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		JLabel lblhorario = new JLabel(" REGISTRO DE HORARIOS");
		lblhorario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblhorario.setBounds(264, 30, 147, 28);
		contentPane.add(lblhorario);
		
		JLabel lblidhorario = new JLabel("Id horario :");
		lblidhorario.setBounds(198, 65, 63, 14);
		contentPane.add(lblidhorario);
		
		JTextField txtidhorario = new JTextField();
		
		
		JLabel lblTipohorario = new JLabel("Tipo de horario :");
		lblTipohorario.setBounds(198, 97, 100, 14);
		contentPane.add(lblTipohorario);
		
		JLabel lbldescripcionhorario = new JLabel("Descripcion Horario :");
		lbldescripcionhorario.setBounds(198, 293, 120, 14);
		contentPane.add(lbldescripcionhorario);
		
		JLabel lblobservacionhorario = new JLabel("Observacion horario :");
		lblobservacionhorario.setBounds(198, 334, 150, 14);
		contentPane.add(lblobservacionhorario);
		
		
		txtidhorario = new JTextField();
		txtidhorario.setEditable(false);
		txtidhorario.setBounds(324, 62, 28, 20);
		contentPane.add(txtidhorario);
		txtidhorario.setColumns(10);
		
		JComboBox comboBoxtipohorario = new JComboBox();
		comboBoxtipohorario.setBounds(324, 94, 171, 20);
		contentPane.add(comboBoxtipohorario);
		

		txtdescripciohorario = new JTextField();
		
		txtdescripciohorario.setBounds(324, 293, 171, 30);
		contentPane.add(txtdescripciohorario);
		txtdescripciohorario.setColumns(10);
		
		
		txtobservacionhorario = new JTextField();
		
		txtobservacionhorario.setBounds(324, 166, 171, 20);
		contentPane.add(txtobservacionhorario);
		txtobservacionhorario.setColumns(10);
		
		JLabel lblHoraInicio = new JLabel("Hora de inicio del horario :");
		lblHoraInicio.setBounds(198, 141, 157, 14);
		contentPane.add(lblHoraInicio);
		
		JButton btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setBounds(198, 165, 100, 23);
		contentPane.add(btnSeleccionar);
		
		txthorainicio_horario = new JTextField();
		txthorainicio_horario.setEditable(false);
		txthorainicio_horario.setColumns(10);
		txthorainicio_horario.setBounds(324, 224, 171, 20);
		contentPane.add(txthorainicio_horario);
		
		JLabel lblHoraDeFinal = new JLabel("Hora de final del horario :");
		lblHoraDeFinal.setBounds(198, 199, 157, 14);
		contentPane.add(lblHoraDeFinal);
		
		JButton button = new JButton("Seleccionar");
		button.setBounds(198, 224, 100, 23);
		contentPane.add(button);
		
		txthorafinal_horario = new JTextField();
		txthorafinal_horario.setEditable(false);
		txthorafinal_horario.setColumns(10);
		txthorafinal_horario.setBounds(324, 224, 171, 20);
		contentPane.add(txthorafinal_horario);
		
		
		
		
		JLabel lblDiasDelHorario = new JLabel("Dias del horario :");
		lblDiasDelHorario.setBounds(198, 258, 100, 14);
		contentPane.add(lblDiasDelHorario);
		
		txtdias_horario = new JTextField();
		txtdias_horario.setEditable(false);
		txtdias_horario.setColumns(10);
		txtdias_horario.setBounds(324, 331, 171, 30);
		contentPane.add(txtdias_horario);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(324, 255, 171, 20);
		contentPane.add(comboBox);
		
		JButton btnGuardarHorario = new JButton("GUARDAR");
		btnGuardarHorario.setBackground(new Color(0, 128, 0));
		btnGuardarHorario.setBounds(198, 372, 99, 23);
		contentPane.add(btnGuardarHorario);
		
		JButton btnNuevoHorario = new JButton("NUEVO");
		btnNuevoHorario.setBackground(new Color(0, 128, 0));
		btnNuevoHorario.setBounds(324, 372, 99, 23);
		contentPane.add(btnNuevoHorario);
		
		JButton btnActualizarHorario = new JButton("ACTUALIZAR");
		btnActualizarHorario.setBackground(new Color(0, 128, 0));
		btnActualizarHorario.setBounds(198, 406, 99, 23);
		contentPane.add(btnActualizarHorario);
		
		JButton btnSalirHorario = new JButton("SALIR");
		btnSalirHorario.setBackground(Color.RED);
		btnSalirHorario.setBounds(324, 406, 99, 23);
		contentPane.add(btnSalirHorario);
		
		
		
		
		
		
		
		
		
		
		
	}
}
