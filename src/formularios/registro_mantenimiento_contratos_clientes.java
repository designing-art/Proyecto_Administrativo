package formularios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

public class registro_mantenimiento_contratos_clientes extends JFrame {

	private JPanel contentPane;
	private JTextField txtcodigocontrato;
	private JTextField txttipodecontrato;
	private JLabel lblTiempoDeContrato;
	private JTextField txttiempocontrato;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registro_mantenimiento_contratos_clientes frame = new registro_mantenimiento_contratos_clientes();
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
	public registro_mantenimiento_contratos_clientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistroContratoClientes = new JLabel("REGISTRO DE CONTRATOS DE LOS CLIENTES");
		lblRegistroContratoClientes.setBounds(210, 27, 263, 28);
		lblRegistroContratoClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroContratoClientes.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblRegistroContratoClientes);
		
		JLabel lblCodigoDeContrato = new JLabel("Codigo de Contrato :");
		lblCodigoDeContrato.setBounds(100, 119, 122, 14);
		contentPane.add(lblCodigoDeContrato);
		
		JLabel lblFotocontratocliente = new JLabel("Fotografia :");
		lblFotocontratocliente.setBounds(376, 107, 206, 14);
		contentPane.add(lblFotocontratocliente);
		
		
		txtcodigocontrato = new JTextField();
		txtcodigocontrato.setBounds(232, 116, 44, 20);
		txtcodigocontrato.setEditable(false);
		
		contentPane.add(txtcodigocontrato);
		txtcodigocontrato.setColumns(10);
		
		JLabel lblTipodecontrato = new JLabel("Tipo de Contrato :");
		 lblTipodecontrato.setBounds(100, 169, 128, 14);
		contentPane.add(lblTipodecontrato);
		
		txttipodecontrato = new JTextField();
		txttipodecontrato.setBounds(232, 166, 86, 20);
		contentPane.add(txttipodecontrato);
		txttipodecontrato.setColumns(10);
		
		lblTiempoDeContrato = new JLabel("Tiempo de Contrato :");
		lblTiempoDeContrato.setBounds(100, 221, 128, 14);
		contentPane.add(lblTiempoDeContrato);
		
		txttiempocontrato = new JTextField();
		txttiempocontrato.setBounds(232, 218, 86, 20);
		contentPane.add(txttiempocontrato);
		txttiempocontrato.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(456, 103, 128, 132);
		contentPane.add(panel);
		
		JButton btnTomar = new JButton("Tomar");
		btnTomar.setBounds(363, 132, 89, 23);
		contentPane.add(btnTomar);
		
		JButton btnSubir = new JButton("Subir");
		btnSubir.setBounds(363, 165, 89, 23);
		contentPane.add(btnSubir);
		
		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.setBounds(232, 292, 106, 23);
		contentPane.add(btnGuardar);
		
		JButton btnNuevo = new JButton("NUEVO");
		btnNuevo.setBounds(368, 292, 107, 23);
		contentPane.add(btnNuevo);
		
		JButton btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.setBounds(232, 335, 106, 23);
		contentPane.add(btnActualizar);
		
		JButton btnBorrar = new JButton("SALIR");
		btnBorrar.setBounds(368, 335, 107, 23);
		contentPane.add(btnBorrar);
		
	}
}
