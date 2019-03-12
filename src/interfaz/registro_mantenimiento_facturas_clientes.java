package interfaz;

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

public class registro_mantenimiento_facturas_clientes extends JFrame {

	private JPanel contentPane;
	private JTextField txtcodigofacturaclientes;
	private JTextField txtfirmacliente;
	private JTextField txtconcepto;
	private JTextField txtcantidad;
	private JTextField txtfechafacturacliente;
	private JTextField txthorafacturacliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registro_mantenimiento_facturas_clientes frame = new registro_mantenimiento_facturas_clientes();
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
	public registro_mantenimiento_facturas_clientes() {
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 529);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblfacturasclientes = new JLabel("REGISTRO FACTURAS PARA CLIENTES");
		lblfacturasclientes.setBounds(224, 65, 233, 28);
		lblfacturasclientes.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblfacturasclientes);
		
		JLabel lblCodigoFactura = new JLabel("Codigo factura cliente:");
		lblCodigoFactura.setBounds(174, 147, 146, 14);
		contentPane.add(lblCodigoFactura);
		
		JLabel lblFirmaCliente = new JLabel("Firma Cliente :");
		lblFirmaCliente.setBounds(174, 172, 109, 14);
		contentPane.add(lblFirmaCliente);
		
		JLabel lblPorConceptoDe = new JLabel("Por Concepto de :");
		lblPorConceptoDe.setBounds(174, 197, 111, 14);
		contentPane.add(lblPorConceptoDe);
		
		JLabel lblCantidadPagada = new JLabel("Cantidad Pagada :");
		lblCantidadPagada.setBounds(174, 230, 109, 14);
		contentPane.add(lblCantidadPagada);
		
		JLabel lblFecha = new JLabel("Fecha :");
		lblFecha.setBounds(174, 255, 46, 17);
		contentPane.add(lblFecha);
		
		JLabel lblHora = new JLabel("Hora : ");
		lblHora.setBounds(174, 283, 46, 14);
		contentPane.add(lblHora);
		
		txtcodigofacturaclientes = new JTextField();
		txtcodigofacturaclientes.setBounds(373, 144, 22, 20);
		contentPane.add(txtcodigofacturaclientes);
		txtcodigofacturaclientes.setColumns(10);
		txtcodigofacturaclientes.setEditable(false);
		
		txtfirmacliente = new JTextField();
		txtfirmacliente.setBounds(373, 169, 138, 20);
		contentPane.add(txtfirmacliente);
		txtfirmacliente.setColumns(10);
		
		txtconcepto = new JTextField();
		txtconcepto.setBounds(373, 197, 138, 20);
		contentPane.add(txtconcepto);
		txtconcepto.setColumns(10);
		
		txtcantidad = new JTextField();
		txtcantidad.setBounds(373, 228, 138, 20);
		contentPane.add(txtcantidad);
		txtcantidad.setColumns(10);
		
		txtfechafacturacliente = new JTextField();
		txtfechafacturacliente.setBounds(373, 259, 138, 20);
		contentPane.add(txtfechafacturacliente);
		txtfechafacturacliente.setColumns(10);
		
		txthorafacturacliente = new JTextField();
		txthorafacturacliente.setBounds(373, 290, 86, 20);
		contentPane.add(txthorafacturacliente);
		txthorafacturacliente.setColumns(10);
		
		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.setBounds(211, 347, 109, 23);
		contentPane.add(btnGuardar);
		
		JButton btnNuevo = new JButton("NUEVO");
		btnNuevo.setBounds(373, 347, 109, 23);
		contentPane.add(btnNuevo);
		
		JButton btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.setBounds(211, 381, 109, 23);
		contentPane.add(btnActualizar);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.setBounds(373, 381, 109, 23);
		contentPane.add(btnSalir);
	}

}
