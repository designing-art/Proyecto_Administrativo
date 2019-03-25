package formularios;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class lista_empleados extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JLabel lblAreasDelModulo;
	private JComboBox comboBox;
	private JLabel label_4;
	private JLabel lblCantidadTotalDe;
	private JTextField textField_1;
	private JLabel lblPaginaN;
	private JTextField textField_2;
	private JLabel lblDe;
	private JTextField textField_3;
	private JButton button;
	private JButton button_1;
	private JButton btnMenuInicial;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lista_empleados frame = new lista_empleados();
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
	public lista_empleados() {
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 630);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBackground(Color.LIGHT_GRAY);
		table.setBounds(29, 89, 961, 452);
		contentPane.add(table);
		
		JLabel lblEmpleados = new JLabel("Empleados");
		lblEmpleados.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		lblEmpleados.setBounds(467, 32, 119, 21);
		contentPane.add(lblEmpleados);
		
		JLabel lblCanalCoffee = new JLabel("Canal 40 Coffee TV  Channel ");
		lblCanalCoffee.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		lblCanalCoffee.setBounds(405, 11, 253, 21);
		contentPane.add(lblCanalCoffee);
		
		JLabel lblBuscarEmpleado = new JLabel("Buscar empleado :");
		lblBuscarEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblBuscarEmpleado.setBounds(29, 61, 142, 14);
		contentPane.add(lblBuscarEmpleado);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		textField.setColumns(10);
		textField.setBounds(181, 58, 215, 20);
		contentPane.add(textField);
		
		lblAreasDelModulo = new JLabel("Areas del modulo :");
		lblAreasDelModulo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblAreasDelModulo.setBounds(435, 64, 117, 14);
		contentPane.add(lblAreasDelModulo);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Empleados", "Cargos", "Horarios", "Contratos"}));
		comboBox.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		comboBox.setBounds(579, 58, 215, 20);
		contentPane.add(comboBox);
		
		label_4 = new JLabel("");
		label_4.setBounds(927, 11, 63, 67);
		contentPane.add(label_4);
		final ImageIcon icono1 = new ImageIcon(getClass().getResource("/material/logo.png"));
		final ImageIcon logo1 = new ImageIcon(icono1.getImage().getScaledInstance(label_4.getWidth(),label_4.getHeight(), Image.SCALE_DEFAULT));
		label_4.setIcon(logo1);
		
		lblCantidadTotalDe = new JLabel("Cantidad Total de Registros :");
		lblCantidadTotalDe.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblCantidadTotalDe.setBounds(29, 552, 201, 14);
		contentPane.add(lblCantidadTotalDe);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(214, 552, 77, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		lblPaginaN = new JLabel("Pagina N\u00BA");
		lblPaginaN.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblPaginaN.setBounds(310, 552, 86, 14);
		contentPane.add(lblPaginaN);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(376, 552, 63, 20);
		contentPane.add(textField_2);
		
		lblDe = new JLabel("De :");
		lblDe.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblDe.setBounds(449, 552, 41, 14);
		contentPane.add(lblDe);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(483, 552, 63, 20);
		contentPane.add(textField_3);
		
		button = new JButton("Nuevo");
		button.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		button.setBackground(new Color(0, 139, 139));
		button.setBounds(782, 552, 99, 23);
		contentPane.add(button);
		
		button_1 = new JButton("Actualizar");
		button_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		button_1.setBackground(new Color(240, 230, 140));
		button_1.setBounds(891, 552, 99, 23);
		contentPane.add(button_1);
		
		btnMenuInicial = new JButton("Menu Inicial");
		btnMenuInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana_principal principal = new ventana_principal();
		 		principal.setVisible(true);
		 		principal.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnMenuInicial.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnMenuInicial.setBackground(new Color(0, 255, 127));
		btnMenuInicial.setBounds(29, 11, 133, 23);
		contentPane.add(btnMenuInicial);
	}
}
