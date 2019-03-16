package dise�o.television;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;

public class contratos_empleados extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					contratos_empleados frame = new contratos_empleados();
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
	public contratos_empleados() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblContratosEmpleados = new JLabel("CONTRATOS EMPLEADOS");
		lblContratosEmpleados.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContratosEmpleados.setBounds(297, 11, 72, 28);
		contentPane.add(lblContratosEmpleados);
		
		JLabel lblBuscarContratoEmpleado = new JLabel("Busqueda de contrato de empleados :");
		lblBuscarContratoEmpleado.setBounds(77, 53, 125, 14);
		contentPane.add(lblBuscarContratoEmpleado);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(213, 50, 156, 20);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(379, 49, 219, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		table = new JTable();
		table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		table.setBounds(30, 78, 617, 322);
		contentPane.add(table);
		
		JButton btnRegistrarContratoEmpleado = new JButton("Registrar Contrato Empleado");
		btnRegistrarContratoEmpleado.setBackground(Color.GREEN);
		btnRegistrarContratoEmpleado.setBounds(30, 411, 154, 23);
		contentPane.add(btnRegistrarContratoEmpleado);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBackground(Color.RED);
		btnSalir.setBounds(564, 411, 83, 23);
		contentPane.add(btnSalir);
	}
	
}


