package formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class registro_contratos_empleados extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registro_contratos_empleados frame = new registro_contratos_empleados();
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
	public registro_contratos_empleados() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		final ImageIcon icono1 = new ImageIcon(getClass().getResource("/material/libreta.png"));
		
		JButton button_1 = new JButton("Regresar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registro_horarios horarios = new registro_horarios();
				horarios.setVisible(true);
				horarios.setLocationRelativeTo(null);
				dispose();
			}
		});
		button_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		button_1.setBackground(new Color(255, 127, 80));
		button_1.setBounds(10, 8, 99, 23);
		contentPane.add(button_1);
		
		JButton FinalizarRegistroEmpleado = new JButton("Finalizar");
		FinalizarRegistroEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		FinalizarRegistroEmpleado.setBackground(new Color(0, 255, 127));
		FinalizarRegistroEmpleado.setBounds(583, 403, 91, 47);
		contentPane.add(FinalizarRegistroEmpleado);
		FinalizarRegistroEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lista_empleados ListaEmpleados = new lista_empleados();
				ListaEmpleados.setVisible(true);
				ListaEmpleados.setLocationRelativeTo(null);
				dispose();
			}
		});
		
		JLabel lblContratoDelEmpleado = new JLabel("Contrato del empleado.");
		lblContratoDelEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		lblContratoDelEmpleado.setBounds(259, -5, 197, 47);
		contentPane.add(lblContratoDelEmpleado);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(151, 29, 385, 421);
		panel_1.setBackground(Color.WHITE);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblRegistrarContratos = new JLabel("Datos del registro.");
		lblRegistrarContratos.setBounds(30, 38, 213, 28);
		panel_1.add(lblRegistrarContratos);
		lblRegistrarContratos.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		
		JLabel lblTipoDeContrato = new JLabel("2. Tipo de contrato :");
		lblTipoDeContrato.setBounds(30, 115, 145, 14);
		lblTipoDeContrato.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		panel_1.add(lblTipoDeContrato);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Permanente", "Indefinido"}));
		comboBox.setBounds(185, 112, 174, 20);
		comboBox.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		panel_1.add(comboBox);
		
		JLabel lblTiempoDelContrato = new JLabel("3. Tiempo del contrato :");
		lblTiempoDelContrato.setBounds(30, 146, 145, 14);
		lblTiempoDelContrato.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		panel_1.add(lblTiempoDelContrato);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"6 meses", "1 a\u00F1o", "2 a\u00F1os", "permanente"}));
		comboBox_1.setBounds(185, 143, 174, 20);
		comboBox_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		panel_1.add(comboBox_1);
		
		JLabel lblFotografia = new JLabel("4. Fotografia :");
		lblFotografia.setBounds(30, 183, 99, 14);
		lblFotografia.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		panel_1.add(lblFotografia);
		
		JButton button = new JButton("Subir");
		button.setBounds(111, 183, 72, 23);
		button.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		panel_1.add(button);
		
		JButton button_3 = new JButton("Actualizar");
		button_3.setBounds(30, 332, 99, 23);
		button_3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		button_3.setBackground(new Color(240, 230, 140));
		panel_1.add(button_3);
		
		JButton button_4 = new JButton("Guardar");
		button_4.setBounds(260, 332, 99, 23);
		button_4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		button_4.setBackground(new Color(0, 255, 127));
		panel_1.add(button_4);
		
		JButton button_5 = new JButton("Nuevo");
		button_5.setBounds(30, 363, 99, 23);
		button_5.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		button_5.setBackground(new Color(0, 139, 139));
		panel_1.add(button_5);
		
		JPanel panel = new JPanel();
		panel.setBounds(185, 182, 174, 139);
		panel_1.add(panel);
		
		JLabel lblCodigo = new JLabel("1. Codigo :");
		lblCodigo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblCodigo.setBounds(30, 80, 145, 14);
		panel_1.add(lblCodigo);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(185, 77, 49, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel();
		label_1.setBounds(0, 0, 385, 421);
		panel_1.add(label_1);
		label_1.setBackground(Color.LIGHT_GRAY);
		final ImageIcon logo2 = new ImageIcon(icono1.getImage().getScaledInstance(label_1.getWidth(),label_1.getHeight(), Image.SCALE_DEFAULT));
		label_1.setIcon(logo2);
		final ImageIcon icono2 = new ImageIcon(getClass().getResource("/material/libreta.png"));
	}
}
