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
import javax.swing.SpringLayout;

public class registro_empleados extends JFrame {

	private JPanel contentPane;
	private JTextField txtcodigo;
	private JTextField txtnombres;
	private JTextField txtapellidos;
	private JTextField txtdireccion;
	private JTextField txtcorreo;
	private JTextField txtidentidad;
	private JTextField txttelefono;
	private JTextField txtnombrereferencia;
	private JTextField txttelefonoreferencia;
	private JTextField txtfechanacimiento;
	private JTextField txtfecharegistro;
	private JTextField txtfechalabores;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registro_empleados frame = new registro_empleados();
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
	public registro_empleados() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 529);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblRegistroDeEmpleados = new JLabel("REGISTRAR EMPLEADO");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblRegistroDeEmpleados, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblRegistroDeEmpleados, 38, SpringLayout.NORTH, contentPane);
		lblRegistroDeEmpleados.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblRegistroDeEmpleados);
		
		JLabel lblNombres = new JLabel("Nombres :");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNombres, 10, SpringLayout.WEST, contentPane);
		contentPane.add(lblNombres);
		
		JLabel lblApellidos = new JLabel("Apellidos :");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblApellidos, 0, SpringLayout.WEST, lblNombres);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblApellidos, 73, SpringLayout.WEST, contentPane);
		contentPane.add(lblApellidos);
		
		JLabel lblDireccion = new JLabel("Direccion :");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblDireccion, 0, SpringLayout.WEST, lblNombres);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblDireccion, 0, SpringLayout.EAST, lblNombres);
		contentPane.add(lblDireccion);
		
		JLabel lblCodigo = new JLabel("Codigo :");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblCodigo, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNombres, 9, SpringLayout.SOUTH, lblCodigo);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblCodigo, 53, SpringLayout.NORTH, contentPane);
		contentPane.add(lblCodigo);
		
		JLabel lblCorreo = new JLabel("Correo :");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblCorreo, 0, SpringLayout.WEST, lblNombres);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblCorreo, 73, SpringLayout.WEST, contentPane);
		contentPane.add(lblCorreo);
		
		JLabel lblGenero = new JLabel("Genero :");
		contentPane.add(lblGenero);
		
		JLabel lblIdentidad = new JLabel("Identidad :");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblIdentidad, 0, SpringLayout.WEST, lblNombres);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblIdentidad, 0, SpringLayout.EAST, lblNombres);
		contentPane.add(lblIdentidad);
		
		JLabel lblCargo = new JLabel("Cargo :");
		sl_contentPane.putConstraint(SpringLayout.EAST, lblRegistroDeEmpleados, -10, SpringLayout.EAST, lblCargo);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblCargo, 220, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblCargo, 306, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblCargo, 354, SpringLayout.WEST, contentPane);
		contentPane.add(lblCargo);
		
		JLabel lblHorario = new JLabel("Horario :");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblHorario, 245, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblHorario, 306, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblHorario, 354, SpringLayout.WEST, contentPane);
		contentPane.add(lblHorario);
		
		JLabel lblTipoDeContrato = new JLabel("Tipo de Contrato :");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblTipoDeContrato, 280, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblTipoDeContrato, 306, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblTipoDeContrato, 399, SpringLayout.WEST, contentPane);
		contentPane.add(lblTipoDeContrato);
		
		JLabel lblReferencia = new JLabel("Nombre completo de referencia :");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblReferencia, 315, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblReferencia, 336, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblReferencia, 520, SpringLayout.WEST, contentPane);
		contentPane.add(lblReferencia);
		
		JPanel panel = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 69, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 409, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, 201, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, 527, SpringLayout.WEST, contentPane);
		contentPane.add(panel);
		
		JLabel lblFotografia = new JLabel("Fotografia :");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblFotografia, 44, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblFotografia, 434, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblFotografia, 527, SpringLayout.WEST, contentPane);
		contentPane.add(lblFotografia);
		
		JButton btnTomar = new JButton("Subir");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblIdentidad, 0, SpringLayout.SOUTH, btnTomar);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnTomar, 116, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnTomar, 323, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnTomar, 399, SpringLayout.WEST, contentPane);
		contentPane.add(btnTomar);
		
		JButton button = new JButton("Tomar");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblApellidos, 0, SpringLayout.SOUTH, button);
		sl_contentPane.putConstraint(SpringLayout.NORTH, button, 91, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, button, 323, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, button, 399, SpringLayout.WEST, contentPane);
		contentPane.add(button);
		
		JLabel lblTelefonoDeLa = new JLabel("Telefono de Referencia :");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblTelefonoDeLa, 371, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblTelefonoDeLa, 365, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblTelefonoDeLa, 491, SpringLayout.WEST, contentPane);
		contentPane.add(lblTelefonoDeLa);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento :");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblFechaDeNacimiento, 295, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblFechaDeNacimiento, 10, SpringLayout.WEST, contentPane);
		contentPane.add(lblFechaDeNacimiento);
		
		JLabel lblFechaDeRegistro = new JLabel("Fecha de Registro :");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblFechaDeRegistro, 343, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblFechaDeRegistro, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblFechaDeRegistro, 115, SpringLayout.WEST, contentPane);
		contentPane.add(lblFechaDeRegistro);
		
		JLabel lblFechaDeComienso = new JLabel("Fecha de comienzo de labores :");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblFechaDeComienso, 393, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblFechaDeComienso, 10, SpringLayout.WEST, contentPane);
		contentPane.add(lblFechaDeComienso);
		
		JLabel lblEstado = new JLabel("Estado :");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblEstado, 450, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblEstado, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblEstado, 73, SpringLayout.WEST, contentPane);
		contentPane.add(lblEstado);
		
		txtcodigo = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.EAST, lblCodigo, -12, SpringLayout.WEST, txtcodigo);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtcodigo, 75, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtcodigo, -306, SpringLayout.WEST, panel);
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtcodigo, -3, SpringLayout.NORTH, lblCodigo);
		txtcodigo.setEditable(false);
		contentPane.add(txtcodigo);
		txtcodigo.setColumns(10);
		
		txtnombres = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, txtnombres, 75, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtnombres, -52, SpringLayout.WEST, button);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNombres, -2, SpringLayout.WEST, txtnombres);
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtnombres, -3, SpringLayout.NORTH, lblNombres);
		contentPane.add(txtnombres);
		txtnombres.setColumns(10);
		
		txtapellidos = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtapellidos, -3, SpringLayout.NORTH, lblApellidos);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtapellidos, 2, SpringLayout.EAST, lblApellidos);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtapellidos, -52, SpringLayout.WEST, btnTomar);
		txtapellidos.setColumns(10);
		contentPane.add(txtapellidos);
		
		txtdireccion = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtdireccion, -3, SpringLayout.NORTH, lblDireccion);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtdireccion, 0, SpringLayout.WEST, txtcodigo);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtdireccion, 0, SpringLayout.SOUTH, lblTipoDeContrato);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtdireccion, 0, SpringLayout.EAST, txtnombres);
		txtdireccion.setColumns(10);
		contentPane.add(txtdireccion);
		
		txtcorreo = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblCorreo, 3, SpringLayout.NORTH, txtcorreo);
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtcorreo, 6, SpringLayout.SOUTH, lblGenero);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtcorreo, 75, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtcorreo, 0, SpringLayout.EAST, txtnombres);
		txtcorreo.setColumns(10);
		contentPane.add(txtcorreo);
		
		txtidentidad = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, txtidentidad, 2, SpringLayout.EAST, lblIdentidad);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtidentidad, -52, SpringLayout.WEST, btnTomar);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblGenero, 9, SpringLayout.SOUTH, txtidentidad);
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtidentidad, 6, SpringLayout.SOUTH, lblApellidos);
		txtidentidad.setColumns(10);
		contentPane.add(txtidentidad);
		
		txttelefono = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txttelefono, 11, SpringLayout.SOUTH, txtcorreo);
		sl_contentPane.putConstraint(SpringLayout.WEST, txttelefono, 14, SpringLayout.WEST, lblGenero);
		sl_contentPane.putConstraint(SpringLayout.EAST, txttelefono, 0, SpringLayout.EAST, txtnombres);
		txttelefono.setColumns(10);
		contentPane.add(txttelefono);
		
		JComboBox comboBoxcargo = new JComboBox();
		sl_contentPane.putConstraint(SpringLayout.NORTH, comboBoxcargo, 217, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, comboBoxcargo, 364, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, comboBoxcargo, 527, SpringLayout.WEST, contentPane);
		contentPane.add(comboBoxcargo);
		
		JComboBox comboBoxcontrato = new JComboBox();
		sl_contentPane.putConstraint(SpringLayout.NORTH, comboBoxcontrato, 277, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, comboBoxcontrato, 409, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, comboBoxcontrato, 527, SpringLayout.WEST, contentPane);
		contentPane.add(comboBoxcontrato);
		
		txtnombrereferencia = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtnombrereferencia, 340, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtnombrereferencia, 323, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtnombrereferencia, 527, SpringLayout.WEST, contentPane);
		txtnombrereferencia.setColumns(10);
		contentPane.add(txtnombrereferencia);
		
		txttelefonoreferencia = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txttelefonoreferencia, 390, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, txttelefonoreferencia, 323, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txttelefonoreferencia, 527, SpringLayout.WEST, contentPane);
		txttelefonoreferencia.setColumns(10);
		contentPane.add(txttelefonoreferencia);
		
		JLabel lblDatosGenerales = new JLabel("Datos Generales:");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblDatosGenerales, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblDatosGenerales, -413, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblRegistroDeEmpleados, 82, SpringLayout.EAST, lblDatosGenerales);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblDatosGenerales, -433, SpringLayout.SOUTH, contentPane);
		lblDatosGenerales.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblDatosGenerales);
		
		JButton btnRegistrar = new JButton("REGISTRAR");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnRegistrar, 435, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnRegistrar, 323, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnRegistrar, 422, SpringLayout.WEST, contentPane);
		btnRegistrar.setBackground(new Color(0, 128, 0));
		contentPane.add(btnRegistrar);
		
		JButton btnSalir = new JButton("SALIR");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnSalir, 435, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnSalir, 452, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnSalir, 527, SpringLayout.WEST, contentPane);
		btnSalir.setBackground(new Color(255, 0, 0));
		contentPane.add(btnSalir);
		
		txtfechanacimiento = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtfechanacimiento, 317, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtfechanacimiento, 113, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtfechanacimiento, 271, SpringLayout.WEST, contentPane);
		txtfechanacimiento.setEditable(false);
		txtfechanacimiento.setColumns(10);
		contentPane.add(txtfechanacimiento);
		
		txtfecharegistro = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtfecharegistro, 368, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtfecharegistro, 113, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtfecharegistro, 271, SpringLayout.WEST, contentPane);
		txtfecharegistro.setEditable(false);
		txtfecharegistro.setColumns(10);
		contentPane.add(txtfecharegistro);
		
		JButton btnFecha = new JButton("Seleccionar");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnFecha, 316, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnFecha, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnFecha, 103, SpringLayout.WEST, contentPane);
		contentPane.add(btnFecha);
		
		JButton button_1 = new JButton("Seleccionar");
		sl_contentPane.putConstraint(SpringLayout.NORTH, button_1, 367, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, button_1, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, button_1, 103, SpringLayout.WEST, contentPane);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Seleccionar");
		sl_contentPane.putConstraint(SpringLayout.NORTH, button_2, 416, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, button_2, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, button_2, 103, SpringLayout.WEST, contentPane);
		contentPane.add(button_2);
		
		txtfechalabores = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtfechalabores, 417, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtfechalabores, 113, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtfechalabores, 271, SpringLayout.WEST, contentPane);
		txtfechalabores.setEditable(false);
		txtfechalabores.setColumns(10);
		contentPane.add(txtfechalabores);
		
		JComboBox comboBoxgenero = new JComboBox();
		sl_contentPane.putConstraint(SpringLayout.WEST, comboBoxgenero, 243, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblGenero, -6, SpringLayout.WEST, comboBoxgenero);
		sl_contentPane.putConstraint(SpringLayout.NORTH, comboBoxgenero, -3, SpringLayout.NORTH, lblGenero);
		sl_contentPane.putConstraint(SpringLayout.EAST, comboBoxgenero, 0, SpringLayout.EAST, txtnombres);
		contentPane.add(comboBoxgenero);
		
		JComboBox comboBoxestado = new JComboBox();
		sl_contentPane.putConstraint(SpringLayout.NORTH, comboBoxestado, 447, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, comboBoxestado, 75, SpringLayout.WEST, contentPane);
		contentPane.add(comboBoxestado);
		
		JComboBox comboBox = new JComboBox();
		sl_contentPane.putConstraint(SpringLayout.NORTH, comboBox, 242, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, comboBox, 364, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, comboBox, 527, SpringLayout.WEST, contentPane);
		contentPane.add(comboBox);
		
		JLabel lblEdad = new JLabel("Edad :");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblEdad, -317, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblEdad, 0, SpringLayout.WEST, lblNombres);
		contentPane.add(lblEdad);
		
		textField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, lblGenero, 36, SpringLayout.EAST, textField);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField, -400, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, 34, SpringLayout.EAST, lblEdad);
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField, -3, SpringLayout.NORTH, lblGenero);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblTelefonos = new JLabel("Telefonos :");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblTelefonos, -263, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblDireccion, 16, SpringLayout.SOUTH, lblTelefonos);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblTelefonos, 0, SpringLayout.WEST, lblNombres);
		contentPane.add(lblTelefonos);
		
		textField_1 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_1, 11, SpringLayout.SOUTH, txtcorreo);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_1, 11, SpringLayout.EAST, lblTelefonos);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_1, -10, SpringLayout.WEST, txttelefono);
		textField_1.setColumns(10);
		contentPane.add(textField_1);
	}
}
