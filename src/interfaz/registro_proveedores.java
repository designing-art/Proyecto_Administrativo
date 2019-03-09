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

public class registro_proveedores extends JFrame {
	private JTextField txtcodigoproveedor;
	private JTextField txtnombresproveedor;
	private JTextField txtcuentaproveedor;
	
	private JTextField txtcorreoproveedor;
	private JTextField txttelefonoproveedor;
	private JTextField txtdireccionproveedor;
	private JTextField txtrtnproveedor;
	


	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registro_proveedores frame = new registro_proveedores();
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
	public registro_proveedores() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistroProveedores = new JLabel("REGISTRAR PROVEEDORES");
		lblRegistroProveedores.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRegistroProveedores.setBounds(223, 42, 147, 28);
		contentPane.add(lblRegistroProveedores);
		
		JLabel lblNombresproveedor = new JLabel("Nombres Del Proveedor :");
		lblNombresproveedor.setBounds(67, 149, 174, 14);
		contentPane.add(lblNombresproveedor);
		
		JLabel lblcuentaproveedor = new JLabel("Cuenta Bancaria:");
		lblcuentaproveedor.setBounds(67, 174, 136, 14);
		contentPane.add(lblcuentaproveedor);
		
		JLabel lbldireccionproveedor = new JLabel("Direccion Del Proveedor :");
		lbldireccionproveedor.setBounds(67, 202, 174, 14);
		contentPane.add(lbldireccionproveedor);
		
		JLabel lblcodigoproveedor = new JLabel("Codigo Del Proveedor :");
		lblcodigoproveedor.setBounds(67, 124, 136, 14);
		contentPane.add(lblcodigoproveedor);
		
		JLabel lbltelefonoproveedor = new JLabel("Telefono Del Proveedor :");
		lbltelefonoproveedor.setBounds(67, 302, 156, 14);
		contentPane.add(lbltelefonoproveedor);
		
		JLabel lblCorreoproveedor = new JLabel("Correo Del Proveedor :");
		lblCorreoproveedor.setBounds(67, 252, 136, 14);
		contentPane.add(lblCorreoproveedor);
		
		JLabel lblGeneroproveedor = new JLabel("Rtn Del Proveedor:");
		lblGeneroproveedor.setBounds(67, 277, 136, 14);
		contentPane.add(lblGeneroproveedor);
		
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(539, 159, 118, 132);
		contentPane.add(panel);
		
		JLabel lblFotografiaproveedor = new JLabel("Fotografia :");
		lblFotografiaproveedor.setBounds(432, 115, 93, 14);
		contentPane.add(lblFotografiaproveedor);
		
		JButton btnsubirproveedor = new JButton("Subir");
		btnsubirproveedor.setBounds(423, 149, 89, 23);
		contentPane.add(btnsubirproveedor);
		
		JButton btntomarproveedor = new JButton("Tomar");
		btntomarproveedor.setBounds(423, 193, 89, 23);
		contentPane.add(btntomarproveedor);
		
		
		txtnombresproveedor = new JTextField();
		txtnombresproveedor.setEditable(false);
		txtnombresproveedor.setBounds(213, 121, 28, 20);
		contentPane.add(txtnombresproveedor);
		txtnombresproveedor.setColumns(10);
		
		txtcuentaproveedor = new JTextField();
		txtcuentaproveedor.setBounds(213, 146, 186, 20);
		contentPane.add(txtcuentaproveedor);
		txtcuentaproveedor.setColumns(10);
		
		txtdireccionproveedor = new JTextField();
		txtdireccionproveedor.setColumns(10);
		txtdireccionproveedor.setBounds(213, 171, 186, 20);
		contentPane.add(txtdireccionproveedor);
		
		txtcodigoproveedor = new JTextField();
		txtcodigoproveedor.setColumns(10);
		txtcodigoproveedor.setBounds(213, 202, 186, 44);
		contentPane.add(txtcodigoproveedor);
		
		txttelefonoproveedor = new JTextField();
		txttelefonoproveedor.setColumns(10);
		txttelefonoproveedor.setBounds(213, 249, 186, 20);
		contentPane.add(txttelefonoproveedor);
		
		txtcorreoproveedor= new JTextField();
		txtcorreoproveedor.setColumns(10);
		txtcorreoproveedor.setBounds(213, 277, 186, 20);
		contentPane.add(txtcorreoproveedor);
		
		txtrtnproveedor = new JTextField();
		txtrtnproveedor.setColumns(10);
		txtrtnproveedor.setBounds(213, 302, 186, 20);
		contentPane.add(txtrtnproveedor);
		
		JButton btnnuevoproveedor = new JButton("Nuevo");
		btnnuevoproveedor.setBounds(422, 231, 89, 23);
		contentPane.add(btnnuevoproveedor);
		
		JButton btnactualizarproveedor = new JButton("Actualizar");
		btnactualizarproveedor.setBounds(422, 268, 89, 23);
		contentPane.add(btnactualizarproveedor);
		
		JButton btnguardarproveedor = new JButton("Guardar");
		btnguardarproveedor.setBounds(422, 298, 89, 23);
		contentPane.add(btnguardarproveedor);
	
		
		
		
		
		
		
		
	}

}
