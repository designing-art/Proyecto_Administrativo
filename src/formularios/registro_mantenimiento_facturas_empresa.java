package formularios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class registro_mantenimiento_facturas_empresa extends JFrame {

	private JPanel contentPane;
	private JTextField textcodigofactura;
	private JTextField textnumerofactura;
	private JTextField textdescripcionfactura;
	private JTextField textfechafactura;
	private JTextField texthorafactura;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registro_mantenimiento_facturas_empresa frame = new registro_mantenimiento_facturas_empresa();
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
	public registro_mantenimiento_facturas_empresa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblfacturas = new JLabel("Registrar Facturas");
		lblfacturas.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblfacturas.setHorizontalAlignment(SwingConstants.CENTER);
		lblfacturas.setBounds(266, 75, 180, 14);
		contentPane.add(lblfacturas);
		JLabel lblcodigodetallecompra = new JLabel("Codigo De  Factura:");
		lblcodigodetallecompra.setBounds(54, 169,154, 14);
		contentPane.add(lblcodigodetallecompra);
		
		JLabel lblnombredetallecompra= new JLabel("Numero De Factura :");
		lblnombredetallecompra.setBounds(54, 128, 154, 23);
		contentPane.add(lblnombredetallecompra);
		
		JLabel lblcantidaddetallecompra = new JLabel("Descripcion De Factura :");
		lblcantidaddetallecompra.setBounds(54, 233, 154, 15);
		contentPane.add(lblcantidaddetallecompra);
		
		JLabel lblpreciodetallecompra = new JLabel("Fecha De Factura:");
		lblpreciodetallecompra.setBounds(54, 204, 154, 14);
		contentPane.add(lblpreciodetallecompra);
		
		JLabel lblimpuestodetallecompra = new JLabel("Hora De Factura:");
		lblimpuestodetallecompra.setBounds(54, 259, 154, 28);
		contentPane.add(lblimpuestodetallecompra);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(518, 142, 118, 132);
		contentPane.add(panel);
		
		JLabel lblFotografiafactura = new JLabel("Fotografia :");
		lblFotografiafactura.setBounds(415, 142, 93, 14);
		contentPane.add(lblFotografiafactura);
		
		JButton btnsubirproveedor = new JButton("Subir");
		btnsubirproveedor.setBounds(402, 169, 89, 23);
		contentPane.add(btnsubirproveedor);
		
		JButton btntomarproveedor = new JButton("Tomar");
		btntomarproveedor.setBounds(402, 200, 89, 23);
		contentPane.add(btntomarproveedor);
		
		textcodigofactura = new JTextField();
		textcodigofactura.setEditable(false);
		textcodigofactura.setBounds(215, 126, 43, 26);
		contentPane.add(textcodigofactura);
		textcodigofactura.setColumns(10);
		
		textnumerofactura = new JTextField();
		textnumerofactura.setBounds(215, 160, 143, 28);
		contentPane.add(textnumerofactura);
		textnumerofactura.setColumns(10);
		
		textdescripcionfactura = new JTextField();
		textdescripcionfactura.setBounds(215, 194, 143, 28);
		contentPane.add(textdescripcionfactura);
		textdescripcionfactura.setColumns(10);
		
		
		
		texthorafactura = new JTextField();
		texthorafactura.setBounds(215, 226, 143, 28);
		contentPane.add(texthorafactura);
		texthorafactura.setColumns(10);
		
		textfechafactura = new JTextField();
		textfechafactura.setBounds(215, 261, 143, 28);
		contentPane.add(textfechafactura);
		textfechafactura.setColumns(10);
		
		JButton btnguardarfactura = new JButton("Guardar");
		btnguardarfactura.setBounds(218, 309, 118, 23);
		contentPane.add(btnguardarfactura);
		
		JButton btnnuevafactura = new JButton("Nuevo");
		btnnuevafactura.setBounds(346, 309, 103, 23);
		contentPane.add(btnnuevafactura);
		
		JButton btnactualizarfactura = new JButton("Actualizar");
		btnactualizarfactura.setBounds(218, 343, 118, 23);
		contentPane.add(btnactualizarfactura);
		
		JButton btnsalirfactura = new JButton("Salir");
		btnsalirfactura.setBounds(346, 343, 103, 23);
		contentPane.add(btnsalirfactura);
		
	}

}
