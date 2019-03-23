package formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;

public class registro_deducciones extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JTextField textField_3;
	private JLabel label_1;
	private JComboBox comboBox;
	private JTextField textField_4;
	private JTable table;
	private JPanel panel;
	private JLabel label_6;
	private JTable table_1;
	private JLabel lblListaDeDeducciones;
	private JLabel lblTipo;
	private JLabel lblCantidad;
	private JTextField textField_6;
	private JLabel lblObservacion;
	private JTextField textField_7;
	private JLabel lblAgregarDeduccion;
	private JTextField textField_8;
	private JLabel lblTotalDeduciones;
	private JButton btnGuardarDeduccion;
	private JButton btnNuevoDeduccion;
	private JButton btnActualizarDeduccion;
	private JButton btnSalirDeduccion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registro_deducciones frame = new registro_deducciones();
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
	public registro_deducciones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistrarDeducciones = new JLabel("REGISTRAR DEDUCCIONES");
		lblRegistrarDeducciones.setBounds(10, 11, 147, 28);
		lblRegistrarDeducciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrarDeducciones.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblRegistrarDeducciones);
		
		textField = new JTextField();
		textField.setBounds(75, 223, 186, 20);
		textField.setColumns(10);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setBounds(75, 198, 186, 20);
		textField_1.setColumns(10);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(75, 172, 28, 20);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		contentPane.add(textField_2);
		
		JLabel lblDatosDelEmpleado = new JLabel("Datos del empleado :");
		lblDatosDelEmpleado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDatosDelEmpleado.setBounds(14, 147, 118, 14);
		contentPane.add(lblDatosDelEmpleado);
		
		label_2 = new JLabel("Nombres :");
		label_2.setBounds(14, 201, 63, 14);
		contentPane.add(label_2);
		
		label_3 = new JLabel("Apellidos :");
		label_3.setBounds(14, 226, 63, 14);
		contentPane.add(label_3);
		
		label_4 = new JLabel("Codigo :");
		label_4.setBounds(14, 175, 63, 14);
		contentPane.add(label_4);
		
		label_5 = new JLabel("Identidad :");
		label_5.setBounds(14, 254, 63, 14);
		contentPane.add(label_5);
		
		textField_3 = new JTextField();
		textField_3.setBounds(75, 248, 186, 20);
		textField_3.setColumns(10);
		contentPane.add(textField_3);
		
		label_1 = new JLabel("Buscar empleado por : ");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(10, 36, 128, 27);
		contentPane.add(label_1);
		
		comboBox = new JComboBox();
		comboBox.setBounds(136, 39, 125, 20);
		contentPane.add(comboBox);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(271, 39, 141, 20);
		contentPane.add(textField_4);
		
		table = new JTable();
		table.setBackground(Color.LIGHT_GRAY);
		table.setBounds(10, 71, 403, 68);
		contentPane.add(table);
		
		panel = new JPanel();
		panel.setBounds(293, 155, 120, 113);
		contentPane.add(panel);
		
		label_6 = new JLabel("Fotografia :");
		label_6.setBounds(234, 173, 206, 14);
		contentPane.add(label_6);
		
		table_1 = new JTable();
		table_1.setBackground(Color.LIGHT_GRAY);
		table_1.setBounds(423, 71, 251, 302);
		contentPane.add(table_1);
		
		lblListaDeDeducciones = new JLabel("Lista de deducciones : ");
		lblListaDeDeducciones.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblListaDeDeducciones.setBounds(422, 36, 128, 27);
		contentPane.add(lblListaDeDeducciones);
		
		lblTipo = new JLabel("Tipo :");
		lblTipo.setBounds(14, 306, 63, 14);
		contentPane.add(lblTipo);
		
		lblCantidad = new JLabel("Cantidad :");
		lblCantidad.setBounds(14, 331, 63, 14);
		contentPane.add(lblCantidad);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(87, 328, 207, 20);
		contentPane.add(textField_6);
		
		lblObservacion = new JLabel("Observacion :");
		lblObservacion.setBounds(14, 359, 80, 14);
		contentPane.add(lblObservacion);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(88, 353, 206, 39);
		contentPane.add(textField_7);
		
		lblAgregarDeduccion = new JLabel("Agregar deduccion :");
		lblAgregarDeduccion.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAgregarDeduccion.setBounds(14, 281, 118, 14);
		contentPane.add(lblAgregarDeduccion);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBounds(423, 404, 251, 20);
		contentPane.add(textField_8);
		
		lblTotalDeduciones = new JLabel("Total deduciones :");
		lblTotalDeduciones.setBounds(423, 384, 127, 14);
		contentPane.add(lblTotalDeduciones);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(87, 303, 205, 20);
		contentPane.add(comboBox_1);
		
		btnGuardarDeduccion = new JButton("GUARDAR");
		btnGuardarDeduccion.setBackground(new Color(0, 128, 0));
		btnGuardarDeduccion.setBounds(87, 403, 99, 23);
		contentPane.add(btnGuardarDeduccion);
		
		btnNuevoDeduccion= new JButton("NUEVO");
		btnNuevoDeduccion.setBackground(new Color(0, 128, 0));
		btnNuevoDeduccion.setBounds(423, 427, 99, 23);
		contentPane.add(btnNuevoDeduccion);
		
		btnActualizarDeduccion= new JButton("ACTUALIZAR");
		btnActualizarDeduccion.setBackground(new Color(0, 128, 0));
		btnActualizarDeduccion.setBounds(195, 403, 99, 23);
		contentPane.add(btnActualizarDeduccion);
		
		btnSalirDeduccion = new JButton("SALIR");
		btnSalirDeduccion.setBackground(Color.RED);
		btnSalirDeduccion.setBounds(575, 427, 99, 23);
		contentPane.add(btnSalirDeduccion);
	}
}
