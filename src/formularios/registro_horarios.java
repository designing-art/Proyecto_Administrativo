package formularios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextArea;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class registro_horarios extends JFrame {
	public JTextField txtidhorario;
	public JTextField txttipohorario;


	public JPanel contentPane;
	public JButton btnGuardarHorario;
	public JButton btnActualizarHorario;
	public JButton btnNuevoHorario;
	public JButton btnSalirHorario;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registro_horarios frame = new registro_horarios();
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
	public registro_horarios() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTextField txtidhorario = new JTextField();
		contentPane.setLayout(null);
		
		JButton button_1 = new JButton("Regresar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registro_cargos cargos = new registro_cargos();
				cargos.setVisible(true);
				cargos.setLocationRelativeTo(null);
				dispose();	
			}
		});
		button_1.setBounds(10, 8, 99, 23);
		button_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		button_1.setBackground(new Color(255, 127, 80));
		contentPane.add(button_1);
		
		JLabel lblAsignarUnHorario = new JLabel("Asignar un horario.");
		lblAsignarUnHorario.setBounds(271, 0, 197, 36);
		lblAsignarUnHorario.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
		contentPane.add(lblAsignarUnHorario);
		
		JButton button_2 = new JButton("Siguiente");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registro_contratos_empleados contrato = new registro_contratos_empleados();
				contrato.setVisible(true);
				contrato.setLocationRelativeTo(null);
				dispose();
			}
		});
		button_2.setBounds(585, 9, 99, 23);
		button_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		button_2.setBackground(new Color(0, 255, 127));
		contentPane.add(button_2);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(176, 47, 341, 401);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblObservacionHorario = new JLabel("6. Observacion horario :");
		lblObservacionHorario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblObservacionHorario.setBounds(30, 241, 150, 14);
		panel.add(lblObservacionHorario);
		
		JLabel lblDescripcionHorario = new JLabel("5. Descripcion Horario :");
		lblDescripcionHorario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblDescripcionHorario.setBounds(30, 181, 150, 14);
		panel.add(lblDescripcionHorario);
		
		JLabel lblDiasDel = new JLabel("4. Dias del horario :");
		lblDiasDel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblDiasDel.setBounds(30, 152, 150, 14);
		panel.add(lblDiasDel);
		
		JLabel lblHoraDe = new JLabel("3. Horas al dia :");
		lblHoraDe.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblHoraDe.setBounds(31, 128, 177, 14);
		panel.add(lblHoraDe);
		
		JLabel lblTipoDe = new JLabel("2. Tipo de horario :");
		lblTipoDe.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblTipoDe.setBounds(31, 103, 130, 14);
		panel.add(lblTipoDe);
		
		JLabel lblCodigo = new JLabel("1. Codigo :");
		lblCodigo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblCodigo.setBounds(31, 78, 63, 14);
		panel.add(lblCodigo);
		
		JLabel lblDatosDelRegistro = new JLabel("Datos del registro.");
		lblDatosDelRegistro.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblDatosDelRegistro.setBounds(31, 41, 197, 36);
		panel.add(lblDatosDelRegistro);
		
		JButton button = new JButton("Actualizar");
		button.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		button.setBackground(new Color(240, 230, 140));
		button.setBounds(40, 313, 99, 23);
		panel.add(button);
		
		JButton button_3 = new JButton("Nuevo");
		button_3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		button_3.setBackground(new Color(0, 139, 139));
		button_3.setBounds(40, 344, 99, 23);
		panel.add(button_3);
		
		JButton button_4 = new JButton("Guardar");
		button_4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		button_4.setBackground(new Color(0, 255, 127));
		button_4.setBounds(214, 313, 99, 23);
		panel.add(button_4);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(202, 76, 46, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Matutino", "Vespertino", "Nocturno"}));
		comboBox.setBounds(202, 101, 111, 20);
		panel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"6:00 am - 2:00 pm", "2:00 pm - 10:00 pm", "8:00 am - 2:00 pm", "2:00 pm - 9:00 pm", "10:00 pm - 6:00 am"}));
		comboBox_1.setBounds(202, 126, 111, 20);
		panel.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"De Lunes a Viernes", "Sabado y Domingo", "Toda la semana"}));
		comboBox_2.setBounds(202, 150, 111, 20);
		panel.add(comboBox_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(20);
		textField_1.setBounds(172, 185, 141, 57);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(172, 245, 141, 57);
		panel.add(textField_2);
		
		JLabel label_1 = new JLabel();
		label_1.setBounds(264, 41, 49, 44);
		panel.add(label_1);
		final ImageIcon icono1 = new ImageIcon(getClass().getResource("/material/logo.png"));
		final ImageIcon logo1 = new ImageIcon(icono1.getImage().getScaledInstance(label_1.getWidth(),label_1.getHeight(), Image.SCALE_DEFAULT));
		label_1.setIcon(logo1);
		
		JLabel label = new JLabel();
		label.setBounds(0, 0, 341, 401);
		panel.add(label);
		final ImageIcon icono = new ImageIcon(getClass().getResource("/material/libreta.png"));
		final ImageIcon logo = new ImageIcon(icono.getImage().getScaledInstance(label.getWidth(),label.getHeight(), Image.SCALE_DEFAULT));
		label.setIcon(logo);
		
		
		
		
		
		
		
		
		
		
		
	}
}
