package formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class registro_permisos extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registro_permisos frame = new registro_permisos();
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
	public registro_permisos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u00A1Registrate!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(291, 50, 91, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblUsuario = new JLabel("Usuario: ");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblUsuario.setBounds(221, 91, 69, 14);
		contentPane.add(lblUsuario);
		
		textField = new JTextField();
		textField.setBounds(372, 89, 140, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblContrasea.setBounds(221, 116, 69, 14);
		contentPane.add(lblContrasea);
		
		textField_1 = new JTextField();
		textField_1.setBounds(372, 113, 140, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblConfirmarContrasea = new JLabel("Confirmar Contrase\u00F1a:");
		lblConfirmarContrasea.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblConfirmarContrasea.setBounds(221, 141, 126, 14);
		contentPane.add(lblConfirmarContrasea);
		
		textField_2 = new JTextField();
		textField_2.setBounds(372, 138, 140, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblEsteUsuarioTiene = new JLabel("Este usuario tiene acceso a:");
		lblEsteUsuarioTiene.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEsteUsuarioTiene.setBounds(221, 197, 169, 14);
		contentPane.add(lblEsteUsuarioTiene);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Crear Planillas");
		chckbxNewCheckBox.setBounds(221, 227, 97, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JCheckBox chckbxRegistrarCompras = new JCheckBox("Registrar Compras");
		chckbxRegistrarCompras.setBounds(221, 253, 115, 23);
		contentPane.add(chckbxRegistrarCompras);
		
		JCheckBox chckbxRegistrarContratosDe = new JCheckBox("Registrar Contratos de Empleados");
		chckbxRegistrarContratosDe.setBounds(221, 279, 189, 23);
		contentPane.add(chckbxRegistrarContratosDe);
		
		JCheckBox chckbxRegistrarContratosDe_1 = new JCheckBox("Registrar Contratos de Clientes");
		chckbxRegistrarContratosDe_1.setBounds(221, 305, 189, 23);
		contentPane.add(chckbxRegistrarContratosDe_1);
		
		JCheckBox chckbxRegistrarFacturasDe = new JCheckBox("Registrar Facturas de Clientes");
		chckbxRegistrarFacturasDe.setBounds(221, 331, 177, 23);
		contentPane.add(chckbxRegistrarFacturasDe);
		
		JCheckBox chckbxRegistrarFacturasDe_1 = new JCheckBox("Registrar Facturas de la Empresa");
		chckbxRegistrarFacturasDe_1.setBounds(221, 357, 189, 23);
		contentPane.add(chckbxRegistrarFacturasDe_1);
		
		JCheckBox chckbxRegistrarHorarios = new JCheckBox("Registrar Horarios");
		chckbxRegistrarHorarios.setBounds(221, 383, 126, 23);
		contentPane.add(chckbxRegistrarHorarios);
		
		JCheckBox chckbxRegistrarInventario = new JCheckBox("Registrar Inventario");
		chckbxRegistrarInventario.setBounds(430, 305, 126, 23);
		contentPane.add(chckbxRegistrarInventario);
		
		JCheckBox chckbxRegistrarIngresos = new JCheckBox("Registrar Ingresos");
		chckbxRegistrarIngresos.setBounds(430, 227, 126, 23);
		contentPane.add(chckbxRegistrarIngresos);
		
		JCheckBox chckbxRegistrarProductos = new JCheckBox("Registrar Productos");
		chckbxRegistrarProductos.setBounds(430, 253, 130, 23);
		contentPane.add(chckbxRegistrarProductos);
		
		JCheckBox chckbxRegistrarProveedores = new JCheckBox("Registrar Proveedores");
		chckbxRegistrarProveedores.setBounds(430, 279, 147, 23);
		contentPane.add(chckbxRegistrarProveedores);
		
		JCheckBox chckbxRegistrarServicios = new JCheckBox("Registrar Servicios");
		chckbxRegistrarServicios.setBounds(430, 331, 126, 23);
		contentPane.add(chckbxRegistrarServicios);
		
		JCheckBox chckbxCrearReportes = new JCheckBox("Crear Reportes");
		chckbxCrearReportes.setBounds(429, 357, 127, 23);
		contentPane.add(chckbxCrearReportes);
		
		JCheckBox chckbxRegistroDeLa = new JCheckBox("Registro de la SAR");
		chckbxRegistroDeLa.setBounds(430, 383, 126, 23);
		contentPane.add(chckbxRegistroDeLa);
		
		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.setBounds(563, 428, 89, 23);
		contentPane.add(btnGuardar);
	}
}
