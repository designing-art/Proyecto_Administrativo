package diseño.television;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JProgressBar;
import javax.swing.JButton;

public class registro_mantenimiento_inventario extends JFrame {

	private JPanel contentPane;
	
	private JTextField textcodigoinventario;
	private JTextField textnombreinventario;
	private JTextField textdescripcioninventario;
	private JTextField textprecioinventario;
	private JTextField textpesoinventario;
	private JTextField textmarcainventario;
	private JTextField textmodeloinventario;
	private JTextField textexistenciainventario;
	private JTextField textcolorinventario;
	private JTextField textField;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registro_mantenimiento_inventario frame = new registro_mantenimiento_inventario();
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
	public registro_mantenimiento_inventario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInventario = new JLabel(" Registro Del Inventario");
		lblInventario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblInventario.setHorizontalAlignment(SwingConstants.CENTER);
		lblInventario.setBounds(248, 75, 180, 40);
		contentPane.add(lblInventario);
		

		JLabel lblcodigoinventario = new JLabel("Codigo  Del Articulo:");
		lblcodigoinventario.setBounds(122, 128,180, 14);
		contentPane.add(lblcodigoinventario);
		
		JLabel lblnombreinventario= new JLabel("Nombre Del Inventario :");
		lblnombreinventario.setBounds(122, 154, 180, 14);
		contentPane.add(lblnombreinventario);
		
		JLabel lblprecioinventario = new JLabel("Precio Del Articulo :");
		lblprecioinventario.setBounds(122, 204, 180, 14);
		contentPane.add(lblprecioinventario);
		
		JLabel lbldescripcioninventario = new JLabel("Descripcion Del Articulo :");
		lbldescripcioninventario.setBounds(122, 179, 180, 14);
		contentPane.add(lbldescripcioninventario);
		
		JLabel lblpesoinventario = new JLabel("Peso Del Articulo :");
		lblpesoinventario.setBounds(122, 229, 180, 14);
		contentPane.add(lblpesoinventario);
		
		JLabel lblcolorinventarior = new JLabel("Color Del Articulo :");
		lblcolorinventarior.setBounds(122, 254, 180, 14);
		contentPane.add(lblcolorinventarior);
		
		JLabel lblmarcainventario = new JLabel("Marca Del Articulo :");
		lblmarcainventario.setBounds(122, 279, 180, 14);
		contentPane.add(lblmarcainventario);
		
		JLabel lblmodeloinventario = new JLabel("Modelo Del Articulo:");
		lblmodeloinventario.setBounds(122, 304, 180, 14);
		contentPane.add(lblmodeloinventario);
		
		
		JLabel lblexistenciainventario = new JLabel("Existencia Del Articulo:");
		lblexistenciainventario.setBounds(122, 329, 180, 14);
		contentPane.add(lblexistenciainventario);
		
	
		
		textcodigoinventario= new JTextField();
		textcodigoinventario.setEditable(false);
		textcodigoinventario.setBounds(296, 125, 99, 20);
		contentPane.add(textcodigoinventario);
		
		textnombreinventario= new JTextField();
		textnombreinventario.setBounds(296, 153, 99, 20);
		contentPane.add(textnombreinventario);
		
		textdescripcioninventario= new JTextField();
		textdescripcioninventario.setBounds(296, 179, 99, 20);
		contentPane.add(textdescripcioninventario);
		
		textprecioinventario = new JTextField();
		textprecioinventario.setBounds(296, 201, 99, 20);
		contentPane.add(textprecioinventario);
		
		textpesoinventario = new JTextField();
		textpesoinventario.setBounds(296, 226, 99, 20);
		contentPane.add(textpesoinventario);
		
		textcolorinventario = new JTextField();
		textcolorinventario.setBounds(296, 251, 99, 20);
		contentPane.add(textcolorinventario);
		
		textmarcainventario = new JTextField();
		textmarcainventario.setBounds(296, 276, 99, 20);
		contentPane.add(textmarcainventario);
		
		textmodeloinventario = new JTextField();
		textmodeloinventario.setBounds(296, 301, 99, 20);
		contentPane.add(textmodeloinventario);
		
		textexistenciainventario = new JTextField();
		textexistenciainventario.setEditable(false);
		textexistenciainventario.setBounds(296, 326, 99, 20);
		contentPane.add(textexistenciainventario);
		
		JButton btnnuevoinventario = new JButton("Nuevo");
		btnnuevoinventario.setBounds(443, 158, 113, 23);
		contentPane.add(btnnuevoinventario);
		
		JButton btnguardarinventario = new JButton("Guardar");
		btnguardarinventario.setBounds(443, 208, 113, 23);
		contentPane.add(btnguardarinventario);
		
		JButton btnborrarinventario = new JButton("Borrar");
		btnborrarinventario.setBounds(443, 253, 113, 23);
		contentPane.add(btnborrarinventario);
		
		
	}
}
