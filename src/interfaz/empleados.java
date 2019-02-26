package interfaz;

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

public class empleados extends JFrame {

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
					empleados frame = new empleados();
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
	public empleados() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 466);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmpleadosRegistrados = new JLabel("EMPLEADOS");
		lblEmpleadosRegistrados.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmpleadosRegistrados.setBounds(245, 11, 72, 28);
		contentPane.add(lblEmpleadosRegistrados);
		
		JLabel lblBuscarEmpleado = new JLabel("Busqueda de empleados :");
		lblBuscarEmpleado.setBounds(32, 50, 125, 14);
		contentPane.add(lblBuscarEmpleado);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(161, 47, 125, 20);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(513, 46, 30, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(287, 46, 226, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		table = new JTable();
		table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		table.setBounds(32, 96, 521, 273);
		contentPane.add(table);
		
		JButton btnRegistrarEmpleado = new JButton("Registrar Empleado");
		btnRegistrarEmpleado.setBackground(Color.GREEN);
		btnRegistrarEmpleado.setBounds(32, 382, 154, 23);
		contentPane.add(btnRegistrarEmpleado);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBackground(Color.RED);
		btnSalir.setBounds(470, 382, 83, 23);
		contentPane.add(btnSalir);
	}
}
