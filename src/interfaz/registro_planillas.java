package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class registro_planillas extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registro_planillas frame = new registro_planillas();
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
	public registro_planillas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_1 = new JLabel("Codigo :");
		label_1.setBounds(159, 35, 53, 14);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(344, 32, 28, 20);
		contentPane.add(textField);
		
		JLabel lblTipoDePlanilla = new JLabel("Tipo de planilla :");
		lblTipoDePlanilla.setBounds(159, 60, 125, 14);
		contentPane.add(lblTipoDePlanilla);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(344, 55, 196, 20);
		contentPane.add(textField_1);
		
		JLabel lblFechaDeLa = new JLabel("Fecha de la planilla :");
		lblFechaDeLa.setBounds(159, 85, 125, 14);
		contentPane.add(lblFechaDeLa);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(344, 79, 196, 20);
		contentPane.add(textField_2);
		
		JLabel label_4 = new JLabel("Identidad :");
		label_4.setBounds(159, 108, 63, 14);
		contentPane.add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(344, 102, 196, 20);
		contentPane.add(textField_3);
		
		JLabel lblRegistrarPlanilla = new JLabel("REGISTRAR PLANILLA");
		lblRegistrarPlanilla.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRegistrarPlanilla.setBounds(267, 4, 147, 28);
		contentPane.add(lblRegistrarPlanilla);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(344, 126, 196, 20);
		contentPane.add(textField_4);
		
		JLabel label = new JLabel("Nombres :");
		label.setBounds(159, 131, 63, 14);
		contentPane.add(label);
		
		JLabel label_5 = new JLabel("Apellidos :");
		label_5.setBounds(159, 156, 63, 14);
		contentPane.add(label_5);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(344, 150, 196, 20);
		contentPane.add(textField_5);
		
		JLabel label_6 = new JLabel("Identidad :");
		label_6.setBounds(159, 179, 63, 14);
		contentPane.add(label_6);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(344, 173, 196, 20);
		contentPane.add(textField_6);
	}

}
