package interfaz;

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

public class horarios extends JFrame {
	private JTextField txtidhorario;
	private JTextField txttipohorario;
	private JTextField txtdescripciohorario;
	private JTextField txtobservacionhorario;


	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					horarios frame = new horarios();
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
	public horarios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 538);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		JLabel lblhorario = new JLabel(" REGISTRO DE HORARIOS");
		lblhorario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblhorario.setBounds(170, 11, 147, 28);
		contentPane.add(lblhorario);
		
		JLabel lblidhorario = new JLabel("Id Horario :");
		lblidhorario.setBounds(10, 69, 63, 14);
		contentPane.add(lblidhorario);
		
		JLabel lblTipohorario = new JLabel("Tipo de Horario :");
		lblTipohorario.setBounds(10, 120, 100, 14);
		contentPane.add(lblTipohorario);
		
		JLabel lbldescripcionhorario = new JLabel("Descripcion Horario :");
		lbldescripcionhorario.setBounds(10, 174, 120, 14);
		contentPane.add(lbldescripcionhorario);
		
		JLabel lblobservacionhorario = new JLabel("Observacion horario :");
		lblobservacionhorario.setBounds(10, 230, 150, 14);
		contentPane.add(lblobservacionhorario);
		
		
		txtidhorario = new JTextField();
		txtidhorario.setEditable(false);
		txtidhorario.setBounds(138, 66, 28, 20);
		contentPane.add(txtidhorario);
		txtidhorario.setColumns(10);
		
		JComboBox comboBoxtipohorario = new JComboBox();
		comboBoxtipohorario.setBounds(138, 117, 50, 20);
		contentPane.add(comboBoxtipohorario);
		

		txtdescripciohorario = new JTextField();
		txtdescripciohorario.setEditable(false);
		txtdescripciohorario.setBounds(140, 166, 200, 30);
		contentPane.add(txtdescripciohorario);
		txtdescripciohorario.setColumns(10);
		
		
		txtobservacionhorario = new JTextField();
		txtobservacionhorario.setEditable(false);
		txtobservacionhorario.setBounds(140, 230, 200, 30);
		contentPane.add(txtobservacionhorario);
		txtobservacionhorario.setColumns(10);
		
		
		
		
		
		
		
		
		
		
		
	}
}
