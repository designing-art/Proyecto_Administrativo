package diseño.television;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;

public class crear_planilla extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					crear_planilla frame = new crear_planilla();
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
	public crear_planilla() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_1 = new JLabel("Codigo :");
		label_1.setBounds(22, 50, 53, 14);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(69, 47, 28, 20);
		contentPane.add(textField);
		
		JLabel lblTipoDePlanilla = new JLabel("Tipo de planilla :");
		lblTipoDePlanilla.setBounds(22, 75, 97, 14);
		contentPane.add(lblTipoDePlanilla);
		
		JLabel lblFechaDeLa = new JLabel("Fecha de la planilla :");
		lblFechaDeLa.setBounds(22, 100, 113, 14);
		contentPane.add(lblFechaDeLa);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(247, 97, 97, 20);
		contentPane.add(textField_2);
		
		JLabel lblRegistrarPlanilla = new JLabel("CREAR NUEVA PLANILLA");
		lblRegistrarPlanilla.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRegistrarPlanilla.setBounds(23, 11, 147, 28);
		contentPane.add(lblRegistrarPlanilla);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(148, 72, 196, 20);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Seleccionar");
		btnNewButton.setBounds(148, 96, 89, 23);
		contentPane.add(btnNewButton);
		
		table = new JTable();
		table.setBackground(Color.LIGHT_GRAY);
		table.setBounds(22, 163, 448, 287);
		contentPane.add(table);
		
		JLabel lblDatosDelEmpleado = new JLabel("Datos del empleado :");
		lblDatosDelEmpleado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDatosDelEmpleado.setBounds(572, 11, 147, 28);
		contentPane.add(lblDatosDelEmpleado);
		
		JPanel panel = new JPanel();
		panel.setBounds(510, 163, 248, 374);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(10, 28, 228, 20);
		panel.add(textField_1);
		
		JLabel lblNombresDelEmpleado = new JLabel("Nombres :");
		lblNombresDelEmpleado.setBounds(10, 14, 115, 14);
		panel.add(lblNombresDelEmpleado);
		
		JLabel lblApellidos = new JLabel("Apellidos :");
		lblApellidos.setBounds(10, 59, 115, 14);
		panel.add(lblApellidos);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(10, 73, 228, 20);
		panel.add(textField_3);
		
		JLabel lblIdentidad = new JLabel("Identidad :");
		lblIdentidad.setBounds(10, 104, 115, 14);
		panel.add(lblIdentidad);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(10, 118, 228, 20);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(10, 163, 228, 20);
		panel.add(textField_5);
		
		JLabel lblSueldoBruto = new JLabel("Sueldo bruto :");
		lblSueldoBruto.setBounds(10, 149, 115, 14);
		panel.add(lblSueldoBruto);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(10, 208, 228, 20);
		panel.add(textField_6);
		
		JLabel lbldeducciones = new JLabel("(Deducciones):");
		lbldeducciones.setBounds(10, 194, 115, 14);
		panel.add(lbldeducciones);
		
		JLabel lblBonificaciones = new JLabel("Bonificaciones :");
		lblBonificaciones.setBounds(10, 236, 115, 14);
		panel.add(lblBonificaciones);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(10, 250, 228, 20);
		panel.add(textField_7);
		
		JLabel lblSueldoNeto = new JLabel("Sueldo neto :");
		lblSueldoNeto.setBounds(10, 281, 115, 14);
		panel.add(lblSueldoNeto);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBounds(10, 295, 228, 20);
		panel.add(textField_8);
		
		JLabel lblTotalAPagar = new JLabel("Total a pagar :");
		lblTotalAPagar.setBounds(82, 326, 115, 14);
		panel.add(lblTotalAPagar);
		
		textField_9 = new JTextField();
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		textField_9.setBounds(10, 340, 228, 20);
		panel.add(textField_9);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(572, 41, 119, 112);
		contentPane.add(btnNewButton_1);
		
		JLabel lblBuscarEmpleadoPor = new JLabel("Buscar empleado por : ");
		lblBuscarEmpleadoPor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBuscarEmpleadoPor.setBounds(22, 125, 128, 27);
		contentPane.add(lblBuscarEmpleadoPor);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(148, 128, 125, 20);
		contentPane.add(comboBox_1);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(283, 128, 187, 20);
		contentPane.add(textField_10);
		
		JButton button = new JButton("NUEVO");
		button.setBackground(new Color(0, 128, 0));
		button.setBounds(251, 480, 99, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("GUARDAR");
		button_1.setBackground(new Color(0, 128, 0));
		button_1.setBounds(148, 480, 99, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("ACTUALIZAR");
		button_2.setBackground(new Color(0, 128, 0));
		button_2.setBounds(148, 514, 99, 23);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("SALIR");
		button_3.setBackground(Color.RED);
		button_3.setBounds(251, 514, 99, 23);
		contentPane.add(button_3);
	}
}
