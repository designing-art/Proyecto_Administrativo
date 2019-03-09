package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class registro_productos extends JFrame {
	private JTextField txtcodigoproducto;
	private JTextField txtdispositivoproducto;
	private JTextField txtmarcaproducto;
	private JTextField txtcapacidadproducto;
	private JTextField txtcolorproducto;
	private JTextField txtprecioproducto;
	

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registro_productos frame = new registro_productos();
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
	public registro_productos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 460);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblRegistroproducto = new JLabel("REGISTRO DE PRODUCTO");
		lblRegistroproducto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRegistroproducto.setBounds(170, 11, 147, 28);
		contentPane.add(lblRegistroproducto);
		
		JLabel lblidproducto = new JLabel("Codigo:");
		lblidproducto.setBounds(10, 69, 63, 14);
		contentPane.add(lblidproducto);
		
		JLabel lbldispositivoproducto = new JLabel("Dispositivo de entrega :");
		lbldispositivoproducto.setBounds(10, 120, 150, 14);
		contentPane.add(lbldispositivoproducto);
		
		JLabel lblmarcaproducto = new JLabel("Marca :");
		lblmarcaproducto.setBounds(10, 173, 100, 14);
		contentPane.add(lblmarcaproducto);
		
		JLabel lblcapacidadproducto = new JLabel("Capacidad :");
		lblcapacidadproducto.setBounds(10, 220, 100, 14);
		contentPane.add(lblcapacidadproducto);
		
		JLabel lblcolorproducto = new JLabel("Color :");
		lblcolorproducto.setBounds(10,270, 120, 14);
		contentPane.add(lblcolorproducto);
		
		JLabel lblprecioproducto = new JLabel("Precio:");
		lblprecioproducto.setBounds(10,320, 120, 14);
		contentPane.add(lblprecioproducto);
		
		txtcodigoproducto = new JTextField();
		txtcodigoproducto.setEditable(false);
		txtcodigoproducto.setBounds(190, 69, 28, 20);
		contentPane.add(txtcodigoproducto);
		txtcodigoproducto.setColumns(10);
		
		txtdispositivoproducto = new JTextField();
		txtdispositivoproducto.setBounds(190,120 , 100, 20);
		contentPane.add(txtdispositivoproducto);
		txtdispositivoproducto.setColumns(10);
		
		
		txtmarcaproducto = new JTextField();
		txtmarcaproducto.setBounds(190,173 , 100, 20);
		contentPane.add(txtmarcaproducto);
		txtmarcaproducto.setColumns(10);
		
		
		txtcapacidadproducto= new JTextField();
		txtcapacidadproducto.setBounds(190,220 , 100, 20);
		contentPane.add(txtcapacidadproducto);
		txtcapacidadproducto.setColumns(10);
		
		txtcolorproducto = new JTextField();
		txtcolorproducto.setBounds(190,270, 100, 20);
		contentPane.add(txtcolorproducto);
		txtcolorproducto.setColumns(10);
		
		txtprecioproducto= new JTextField();
		txtprecioproducto.setBounds(190,320, 100, 20);
		contentPane.add(txtprecioproducto);
		txtprecioproducto.setColumns(10);
		
		JButton button = new JButton("Guardar");
		button.setBackground(new Color(0, 128, 0));
		button.setBounds(51, 366, 89, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Editar");
		button_1.setBackground(new Color(0, 128, 0));
		button_1.setBounds(188, 366, 89, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Salir");
		button_2.setBackground(Color.RED);
		button_2.setBounds(319, 366, 89, 23);
		contentPane.add(button_2);
		
		
		
	}

}
