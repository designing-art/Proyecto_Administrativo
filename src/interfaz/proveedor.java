package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class proveedor extends JFrame {
	private JTextField txtcodigoproveedor;
	private JTextField txtnombresproveedor;
	private JTextField txtapellidosproveedor;
	private JTextField txtidentidadproveedor;
	private JTextField txtcorreoproveedor;
	private JTextField txttelefonoproveedor;
	private JTextField txtdireccionproveedor;
	private JTextField txtgeneroproveedor;
	


	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					proveedor frame = new proveedor();
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
	public proveedor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 538);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistroProveedores = new JLabel("REGISTRAR PROVEEDORES");
		lblRegistroProveedores.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRegistroProveedores.setBounds(170, 11, 147, 28);
		contentPane.add(lblRegistroProveedores);
		
		JLabel lblNombresproveedor = new JLabel("Nombres :");
		lblNombresproveedor.setBounds(10, 95, 63, 14);
		contentPane.add(lblNombresproveedor);
		
		JLabel lblApellidosproveedor = new JLabel("Apellidos :");
		lblApellidosproveedor.setBounds(10, 120, 63, 14);
		contentPane.add(lblApellidosproveedor);
		
		JLabel lbldireccionproveedor = new JLabel("Direccion :");
		lbldireccionproveedor.setBounds(10, 145, 63, 14);
		contentPane.add(lbldireccionproveedor);
		
		JLabel lblcodigoproveedor = new JLabel("Codigo :");
		lblcodigoproveedor.setBounds(10, 69, 63, 14);
		contentPane.add(lblcodigoproveedor);
		
		JLabel lbltelefonoproveedor = new JLabel("Telefono :");
		lbltelefonoproveedor.setBounds(10, 270, 63, 14);
		contentPane.add(lbltelefonoproveedor);
		
		JLabel lblCorreoproveedor = new JLabel("Correo :");
		lblCorreoproveedor.setBounds(10, 195, 63, 14);
		contentPane.add(lblCorreoproveedor);
		
		JLabel lblGeneroproveedor = new JLabel("Genero :");
		lblGeneroproveedor.setBounds(10, 220, 63, 14);
		contentPane.add(lblGeneroproveedor);
		
		JLabel lblIdentidadproveedor = new JLabel("Identidad :");
		lblIdentidadproveedor.setBounds(10, 245, 63, 14);
		contentPane.add(lblIdentidadproveedor);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(345, 69, 118, 132);
		contentPane.add(panel);
		
		JLabel lblFotografiaproveedor = new JLabel("Fotografia :");
		lblFotografiaproveedor.setBounds(271, 69, 93, 14);
		contentPane.add(lblFotografiaproveedor);
		
		JButton btnsubirproveedor = new JButton("Subir");
		btnsubirproveedor.setBounds(260, 116, 80, 23);
		contentPane.add(btnsubirproveedor);
		
		JButton btntomarproveedor = new JButton("Tomar");
		btntomarproveedor.setBounds(260, 150, 80, 23);
		contentPane.add(btntomarproveedor);
		
		
		txtnombresproveedor = new JTextField();
		txtnombresproveedor.setEditable(false);
		txtnombresproveedor.setBounds(75, 66, 28, 20);
		contentPane.add(txtnombresproveedor);
		txtnombresproveedor.setColumns(10);
		
		txtapellidosproveedor = new JTextField();
		txtapellidosproveedor.setBounds(75, 92, 186, 20);
		contentPane.add(txtapellidosproveedor);
		txtapellidosproveedor.setColumns(10);
		
		txtdireccionproveedor = new JTextField();
		txtdireccionproveedor.setColumns(10);
		txtdireccionproveedor.setBounds(75, 117, 186, 20);
		contentPane.add(txtdireccionproveedor);
		
		txtcodigoproveedor = new JTextField();
		txtcodigoproveedor.setColumns(10);
		txtcodigoproveedor.setBounds(75, 142, 186, 44);
		contentPane.add(txtcodigoproveedor);
		
		txttelefonoproveedor = new JTextField();
		txttelefonoproveedor.setColumns(10);
		txttelefonoproveedor.setBounds(75, 192, 186, 20);
		contentPane.add(txttelefonoproveedor);
		
		txtcorreoproveedor= new JTextField();
		txtcorreoproveedor.setColumns(10);
		txtcorreoproveedor.setBounds(75, 242, 186, 20);
		contentPane.add(txtcorreoproveedor);
		
		txtgeneroproveedor = new JTextField();
		txtgeneroproveedor.setColumns(10);
		txtgeneroproveedor.setBounds(75, 267, 186, 20);
		contentPane.add(txtgeneroproveedor);
	
		txtidentidadproveedor= new JTextField();
		txtidentidadproveedor.setColumns(10);
		txtidentidadproveedor.setBounds(75, 220, 186, 20);
		contentPane.add(txtidentidadproveedor);
		
		
		
		
		
		
		
	}

}
