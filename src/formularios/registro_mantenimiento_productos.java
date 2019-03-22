package formularios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window.Type;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

public class registro_mantenimiento_productos extends JFrame {

	private JPanel contentPane;
	private JTextField txtcodigoproducto;
	
	private JTextField txttipodedispositivo;
	
	private JTextField txtmarcaproducto;
	
	private JTextField txtcapacidadproducto;
	
	private JTextField txtcolorproducto;
	
	private JTextField txtprecioproducto;
	private JButton btnGuardar;
	private JButton btnActualizar;
	private JButton btnNuevo;
	private JButton btnSalir;
	private JLabel lblPrecioDelProducto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registro_mantenimiento_productos frame = new registro_mantenimiento_productos();
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
	public registro_mantenimiento_productos() {
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 529);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProductos = new JLabel("PRODUCTOS");
		lblProductos.setBounds(303, 46, 147, 28);
		lblProductos.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblProductos);
		
		JLabel lblCodigoDeProducto = new JLabel("Codigo de Producto :");
		lblCodigoDeProducto.setBounds(155, 121, 130, 14);
		contentPane.add(lblCodigoDeProducto);
		
		txtcodigoproducto = new JTextField();
		txtcodigoproducto.setBounds(378, 118, 43, 20);
		contentPane.add(txtcodigoproducto);
		txtcodigoproducto.setColumns(10);
		txtcodigoproducto.setEditable(false);
		
		JLabel lblTipoDeDispositivo = new JLabel("Tipo de dispositivo de entrega :");
		lblTipoDeDispositivo.setBounds(155, 162, 213, 14);
		contentPane.add(lblTipoDeDispositivo);
		
		txttipodedispositivo = new JTextField();
		txttipodedispositivo.setBounds(378, 159, 130, 20);
		contentPane.add(txttipodedispositivo);
		txttipodedispositivo.setColumns(10);
		
		JLabel lblMarcaDelProducto = new JLabel("Marca del producto :");
		lblMarcaDelProducto.setBounds(155, 201, 138, 14);
		contentPane.add(lblMarcaDelProducto);
		
		txtmarcaproducto = new JTextField();
		txtmarcaproducto.setBounds(378, 198, 129, 20);
		contentPane.add(txtmarcaproducto);
		txtmarcaproducto.setColumns(10);
		
		JLabel lblCapacidadDelProducto = new JLabel("Capacidad del Producto :");
		lblCapacidadDelProducto.setBounds(155, 237, 147, 14);
		contentPane.add(lblCapacidadDelProducto);
		
		txtcapacidadproducto = new JTextField();
		txtcapacidadproducto.setBounds(378, 234, 129, 20);
		contentPane.add(txtcapacidadproducto);
		txtcapacidadproducto.setColumns(10);
		
		JLabel lblColorDelProducto = new JLabel("Color del producto :");
		lblColorDelProducto.setBounds(155, 272, 138, 14);
		contentPane.add(lblColorDelProducto);
		
		txtcolorproducto = new JTextField();
		txtcolorproducto.setBounds(378, 269, 129, 20);
		contentPane.add(txtcolorproducto);
		txtcolorproducto.setColumns(10);
		
		txtprecioproducto = new JTextField();
		txtprecioproducto.setBounds(378, 307, 129, 20);
		contentPane.add(txtprecioproducto);
		txtprecioproducto.setColumns(10);
		
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setBounds(209, 376, 116, 23);
		contentPane.add(btnGuardar);
		
		btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.setBounds(209, 422, 116, 23);
		contentPane.add(btnActualizar);
		
		btnNuevo = new JButton("NUEVO");
		btnNuevo.setBounds(342, 376, 108, 23);
		contentPane.add(btnNuevo);
		
		btnSalir = new JButton("SALIR");
		btnSalir.setBounds(342, 422, 108, 23);
		contentPane.add(btnSalir);
		
		lblPrecioDelProducto = new JLabel("Precio del producto : L.");
		lblPrecioDelProducto.setBounds(155, 310, 138, 14);
		contentPane.add(lblPrecioDelProducto);
		
		
	}

}
