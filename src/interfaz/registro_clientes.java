package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class registro_clientes extends JFrame {

	private JPanel contentPane;
	private JTextField txtcodigo;
	private JTextField txtnombres;
	private JTextField txtapellidos;
	private JTextField txtdireccion;
	private JTextField txtcorreo;
	private JTextField txtidentidad;
	private JTextField txttelefono;
	private JTextField txtnombreempresa;
	private JTextField textFielddescripcionempresa;
	private JTextField textFielddireccion;
	private JTextField textFieldrtnempresa;
	private JTextField textFieldtelefonoempresa;
	private JTextField textFieldcorreoempresa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registro_clientes frame = new registro_clientes();
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
	public registro_clientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistroDeEmpleados = new JLabel("REGISTRAR CLIENTES");
		lblRegistroDeEmpleados.setBounds(250, 11, 147, 28);
		lblRegistroDeEmpleados.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroDeEmpleados.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblRegistroDeEmpleados);
		
		JLabel lblDatosGenerales = new JLabel("Datos Generales:");
		lblDatosGenerales.setBounds(50, 45, 118, 14);
		contentPane.add(lblDatosGenerales);
		
		JLabel lblNombres = new JLabel("Nombres :");
		lblNombres.setBounds(50, 96, 63, 14);
		contentPane.add(lblNombres);
		
		JLabel lblApellidos = new JLabel("Apellidos :");
		lblApellidos.setBounds(50, 121, 63, 14);
		contentPane.add(lblApellidos);
		
		JLabel lblTelefono = new JLabel("Direccion :");
		lblTelefono.setBounds(50, 146, 63, 14);
		contentPane.add(lblTelefono);
		
		JLabel lblCodigo = new JLabel("Codigo :");
		lblCodigo.setBounds(50, 70, 63, 14);
		contentPane.add(lblCodigo);
		
		JLabel label = new JLabel("Telefono :");
		label.setBounds(50, 271, 63, 14);
		contentPane.add(label);
		
		JLabel lblCorreo = new JLabel("Correo :");
		lblCorreo.setBounds(50, 196, 63, 14);
		contentPane.add(lblCorreo);
		
		JLabel lblGenero = new JLabel("Genero :");
		lblGenero.setBounds(50, 221, 63, 14);
		contentPane.add(lblGenero);
		
		JLabel lblIdentidad = new JLabel("Identidad :");
		lblIdentidad.setBounds(50, 246, 63, 14);
		contentPane.add(lblIdentidad);
		
		JLabel lblNombreEmpresa = new JLabel("Nombre empresa:");
		lblNombreEmpresa.setBounds(50, 296, 184, 14);
		contentPane.add(lblNombreEmpresa);
		
		JPanel panel = new JPanel();
		panel.setBounds(508, 64, 120, 132);
		contentPane.add(panel);
		
		JLabel lblFotografia = new JLabel("Fotografia :");
		lblFotografia.setBounds(422, 64, 206, 14);
		contentPane.add(lblFotografia);
		
		JButton btnSubir = new JButton("Subir");
		btnSubir.setBounds(408, 111, 90, 23);
		contentPane.add(btnSubir);
		
		JButton btnTomar = new JButton("Tomar");
		btnTomar.setBounds(408, 86, 90, 23);
		contentPane.add(btnTomar);
		
		JLabel lblTelefonoEmpresa = new JLabel("Telefono empresa:");
		lblTelefonoEmpresa.setBounds(50, 405, 151, 14);
		contentPane.add(lblTelefonoEmpresa);
		
		JLabel lblDireccionEmpresa = new JLabel("Direccion empresa:");
		lblDireccionEmpresa.setBounds(50, 346, 118, 14);
		contentPane.add(lblDireccionEmpresa);
		
		JLabel lblDescripcionEmpresa = new JLabel("Descripcion empresa:");
		lblDescripcionEmpresa.setBounds(50, 321, 128, 14);
		contentPane.add(lblDescripcionEmpresa);
		
		JLabel lblCorreoEmpresa = new JLabel("Correo empresa :");
		lblCorreoEmpresa.setBounds(50, 426, 118, 14);
		contentPane.add(lblCorreoEmpresa);
		
		txtcodigo = new JTextField();
		txtcodigo.setBounds(188, 67, 28, 20);
		txtcodigo.setEditable(false);
		contentPane.add(txtcodigo);
		txtcodigo.setColumns(10);
		
		txtnombres = new JTextField();
		txtnombres.setBounds(188, 93, 186, 20);
		contentPane.add(txtnombres);
		txtnombres.setColumns(10);
		
		txtapellidos = new JTextField();
		txtapellidos.setBounds(188, 118, 186, 20);
		txtapellidos.setColumns(10);
		contentPane.add(txtapellidos);
		
		txtdireccion = new JTextField();
		txtdireccion.setBounds(188, 146, 186, 44);
		txtdireccion.setColumns(10);
		contentPane.add(txtdireccion);
		
		txtcorreo = new JTextField();
		txtcorreo.setBounds(188, 193, 186, 20);
		txtcorreo.setColumns(10);
		contentPane.add(txtcorreo);
		
		txtidentidad = new JTextField();
		txtidentidad.setBounds(188, 243, 186, 20);
		txtidentidad.setColumns(10);
		contentPane.add(txtidentidad);
		
		txttelefono = new JTextField();
		txttelefono.setBounds(188, 268, 186, 20);
		txttelefono.setColumns(10);
		contentPane.add(txttelefono);
		
		txtnombreempresa = new JTextField();
		txtnombreempresa.setBounds(188, 293, 186, 20);
		txtnombreempresa.setColumns(10);
		contentPane.add(txtnombreempresa);
		
		JComboBox comboBoxgenero = new JComboBox();
		comboBoxgenero.setBounds(188, 218, 46, 20);
		contentPane.add(comboBoxgenero);
		
		
		
		textFielddescripcionempresa = new JTextField();
		textFielddescripcionempresa.setBounds(188, 321, 186, 20);
		textFielddescripcionempresa.setColumns(10);
		contentPane.add(textFielddescripcionempresa);
		
		
		
		textFielddireccion = new JTextField();
		textFielddireccion.setBounds(188, 345, 186, 20);
		textFielddireccion.setColumns(10);
		contentPane.add(textFielddireccion);
		
		JLabel lblRtnEmpresa = new JLabel("RTN empresa:");
		lblRtnEmpresa.setBounds(50, 371, 184, 14);
		contentPane.add(lblRtnEmpresa);
		
		textFieldrtnempresa = new JTextField();
		textFieldrtnempresa.setBounds(188, 374, 186, 20);
		textFieldrtnempresa.setColumns(10);
		contentPane.add(textFieldrtnempresa);
		
		textFieldtelefonoempresa = new JTextField();
		textFieldtelefonoempresa.setBounds(188, 402, 186, 20);
		textFieldtelefonoempresa.setColumns(10);
		contentPane.add(textFieldtelefonoempresa);
		
		
		
		textFieldcorreoempresa = new JTextField();
		textFieldcorreoempresa.setBounds(188, 430, 186, 20);
		textFieldcorreoempresa.setColumns(10);
		contentPane.add(textFieldcorreoempresa);
		
		JButton btnRegistrar = new JButton("GUARDAR");
		btnRegistrar.setBounds(408, 242, 109, 23);
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRegistrar.setBackground(new Color(0, 128, 0));
		contentPane.add(btnRegistrar);
		
		JButton btnGuardar = new JButton("NUEVO");
		btnGuardar.setBounds(527, 242, 101, 23);
		btnGuardar.setBackground(new Color(0, 128, 0));
		contentPane.add(btnGuardar);
		
		JButton btnBorrar = new JButton("ACTUALIZAR");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBorrar.setBounds(408, 271, 109, 23);
		btnBorrar.setBackground(new Color(255, 0, 0));
		contentPane.add(btnBorrar);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.setBounds(527, 271, 101, 23);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalir.setBackground(new Color(255, 0, 0));
		contentPane.add(btnSalir);
	}
}
