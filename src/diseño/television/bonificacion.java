package dise�o.television;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class bonificacion extends JFrame {

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
					bonificacion frame = new bonificacion();
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
	public bonificacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblBonificacionesregistrados = new JLabel("BONIFICACIONES");
		lblBonificacionesregistrados.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBonificacionesregistrados.setBounds(297, 11, 100, 28);
		contentPane.add(lblBonificacionesregistrados);
		
		JLabel lblBuscarbonificacion = new JLabel("Busqueda de bonificacion :");
		lblBuscarbonificacion.setBounds(77, 53, 150, 14);
		contentPane.add(lblBuscarbonificacion);
		
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
		
		JButton btnRegistrarbonificacion= new JButton("Registrar bonificacion");
		btnRegistrarbonificacion.setBackground(Color.GREEN);
		btnRegistrarbonificacion.setBounds(30, 411, 154, 23);
		contentPane.add(btnRegistrarbonificacion);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBackground(Color.RED);
		btnSalir.setBounds(564, 411, 83, 23);
		contentPane.add(btnSalir);
	}

}
