package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;

public class registro_mantenimiento_detalle_compras extends JFrame {

	private JPanel contentPane;
	private JTextField textcodigocompra;
	private JTextField textnombrecompra;
	private JTextField textcantidadcompra;
	private JTextField textpreciocompra;
	private JTextField textimpuestocompra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registro_mantenimiento_detalle_compras frame = new registro_mantenimiento_detalle_compras();
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
	public registro_mantenimiento_detalle_compras() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblcompras = new JLabel("Registrar Compras");
		lblcompras.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblcompras.setHorizontalAlignment(SwingConstants.CENTER);
		lblcompras.setBounds(257, 103, 180, 14);
		contentPane.add(lblcompras);
		

		JLabel lblcodigodetallecompra = new JLabel("Codigo de  compra:");
		lblcodigodetallecompra.setBounds(67, 159,127, 14);
		contentPane.add(lblcodigodetallecompra);
		
		JLabel lblnombredetallecompra= new JLabel("Nombre de compra :");
		lblnombredetallecompra.setBounds(67, 184, 180, 24);
		contentPane.add(lblnombredetallecompra);
		
		JLabel lblcantidaddetallecompra = new JLabel("Cantidad de compra :");
		lblcantidaddetallecompra.setBounds(67, 248, 180, 14);
		contentPane.add(lblcantidaddetallecompra);
		
		JLabel lblpreciodetallecompra = new JLabel("Precio  de la compra:");
		lblpreciodetallecompra.setBounds(67, 219, 180, 14);
		contentPane.add(lblpreciodetallecompra);
		
		JLabel lblimpuestodetallecompra = new JLabel("Impuesto  sobre la compra:");
		lblimpuestodetallecompra.setBounds(67, 277, 180, 15);
		contentPane.add(lblimpuestodetallecompra);
		
		textcodigocompra= new JTextField();
		textcodigocompra.setEditable(false);
		textcodigocompra.setBounds(204, 154, 39, 24);
		contentPane.add(textcodigocompra);
		textcodigocompra.setColumns(10);
		
		textnombrecompra = new JTextField();
		textnombrecompra.setColumns(10);
		textnombrecompra.setBounds(204, 180, 180, 24);
		contentPane.add(textnombrecompra);
		
		textcantidadcompra = new JTextField();
		textcantidadcompra.setColumns(10);
		textcantidadcompra.setBounds(204, 210, 180, 24);
		contentPane.add(textcantidadcompra);
		
		textpreciocompra = new JTextField();
		textpreciocompra.setColumns(10);
		textpreciocompra.setBounds(204, 238, 180, 24);
		contentPane.add(textpreciocompra);
		
		textimpuestocompra = new JTextField();
		textimpuestocompra.setColumns(10);
		textimpuestocompra.setBounds(204, 268, 180, 24);
		contentPane.add(textimpuestocompra);
		
		JButton btnguardarcompra = new JButton("Guardar");
		btnguardarcompra.setBounds(394, 200, 99, 23);
		contentPane.add(btnguardarcompra);
		
		JButton btnnuevocompra = new JButton("Nuevo");
		btnnuevocompra.setBounds(503, 200, 89, 23);
		contentPane.add(btnnuevocompra);
		
		JButton btnactualizarcompra = new JButton("Actualizar");
		btnactualizarcompra.setBounds(394, 236, 99, 23);
		contentPane.add(btnactualizarcompra);
		
		JButton btnsalircompra = new JButton("Salir");
		btnsalircompra.setBounds(503, 236, 89, 23);
		contentPane.add(btnsalircompra);
		
		
	}

}
