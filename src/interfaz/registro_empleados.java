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
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 529);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistroDeEmpleados = new JLabel("REGISTRAR EMPLEADO");
		lblRegistroDeEmpleados.setBounds(277, 11, 147, 28);
		lblRegistroDeEmpleados.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblRegistroDeEmpleados);
		
		JLabel lblNombres = new JLabel("Nombres :");
		lblNombres.setBounds(96, 81, 63, 14);
		contentPane.add(lblNombres);
		
		JLabel lblApellidos = new JLabel("Apellidos :");
		lblApellidos.setBounds(96, 105, 63, 14);
		contentPane.add(lblApellidos);
		
		JLabel lblDireccion = new JLabel("Direccion :");
		lblDireccion.setBounds(96, 238, 63, 14);
		contentPane.add(lblDireccion);
		
		JLabel lblCodigo = new JLabel("Codigo :");
		lblCodigo.setBounds(96, 58, 53, 14);
		contentPane.add(lblCodigo);
		
		JLabel lblCorreo = new JLabel("Correo :");
		lblCorreo.setBounds(96, 177, 63, 14);
		contentPane.add(lblCorreo);
		
		JLabel lblGenero = new JLabel("Genero :");
		lblGenero.setBounds(266, 156, 53, 14);
		contentPane.add(lblGenero);
		
		JLabel lblIdentidad = new JLabel("Identidad :");
		lblIdentidad.setBounds(96, 130, 63, 14);
		contentPane.add(lblIdentidad);
		
		JLabel lblCargo = new JLabel("Cargo :");
		lblCargo.setBounds(392, 199, 48, 14);
		contentPane.add(lblCargo);
		
		JLabel lblHorario = new JLabel("Horario :");
		lblHorario.setBounds(392, 224, 48, 14);
		contentPane.add(lblHorario);
		
		JLabel lblTipoDeContrato = new JLabel("Tipo de Contrato :");
		lblTipoDeContrato.setBounds(392, 249, 93, 14);
		contentPane.add(lblTipoDeContrato);
		
		JLabel lblReferencia = new JLabel("Nombre completo de referencia :");
		lblReferencia.setBounds(392, 294, 184, 14);
		contentPane.add(lblReferencia);
		
		JPanel panel = new JPanel();
		panel.setBounds(478, 58, 128, 132);
		contentPane.add(panel);
		
		JLabel lblFotografia = new JLabel("Fotografia :");
		lblFotografia.setBounds(392, 58, 93, 14);
		contentPane.add(lblFotografia);
		
		JButton btnTomar = new JButton("Subir");
		btnTomar.setBounds(392, 111, 76, 23);
		contentPane.add(btnTomar);
		
		JButton button = new JButton("Tomar");
		button.setBounds(392, 83, 76, 23);
		contentPane.add(button);
		
		JLabel lblTelefonoDeLa = new JLabel("Telefono de Referencia :");
		lblTelefonoDeLa.setBounds(392, 348, 126, 14);
		contentPane.add(lblTelefonoDeLa);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento :");
		lblFechaDeNacimiento.setBounds(96, 300, 105, 14);
		contentPane.add(lblFechaDeNacimiento);
		
		JLabel lblFechaDeRegistro = new JLabel("Fecha de Registro :");
		lblFechaDeRegistro.setBounds(96, 348, 105, 14);
		contentPane.add(lblFechaDeRegistro);
		
		JLabel lblFechaDeComienso = new JLabel("Fecha de comienzo de labores :");
		lblFechaDeComienso.setBounds(96, 398, 151, 14);
		contentPane.add(lblFechaDeComienso);
		
		JLabel lblEstado = new JLabel("Estado :");
		lblEstado.setBounds(96, 444, 63, 14);
		contentPane.add(lblEstado);
		
		txtcodigo = new JTextField();
		txtcodigo.setBounds(161, 55, 28, 20);
		txtcodigo.setEditable(false);
		contentPane.add(txtcodigo);
		txtcodigo.setColumns(10);
		
		txtnombres = new JTextField();
		txtnombres.setBounds(161, 78, 196, 20);
		contentPane.add(txtnombres);
		txtnombres.setColumns(10);
		
		txtapellidos = new JTextField();
		txtapellidos.setBounds(161, 102, 196, 20);
		txtapellidos.setColumns(10);
		contentPane.add(txtapellidos);
		
		txtdireccion = new JTextField();
		txtdireccion.setBounds(161, 235, 196, 52);
		txtdireccion.setColumns(10);
		contentPane.add(txtdireccion);
		
		txtcorreo = new JTextField();
		txtcorreo.setBounds(161, 174, 196, 20);
		txtcorreo.setColumns(10);
		contentPane.add(txtcorreo);
		
		txtidentidad = new JTextField();
		txtidentidad.setBounds(161, 125, 196, 20);
		txtidentidad.setColumns(10);
		contentPane.add(txtidentidad);
		
		txttelefono = new JTextField();
		txttelefono.setBounds(264, 205, 93, 20);
		txttelefono.setColumns(10);
		contentPane.add(txttelefono);
		
		JComboBox comboBoxcargo = new JComboBox();
		comboBoxcargo.setBounds(443, 196, 163, 20);
		contentPane.add(comboBoxcargo);
		
		JComboBox comboBoxcontrato = new JComboBox();
		comboBoxcontrato.setBounds(443, 263, 163, 20);
		contentPane.add(comboBoxcontrato);
		
		txtnombrereferencia = new JTextField();
		txtnombrereferencia.setBounds(392, 317, 214, 20);
		txtnombrereferencia.setColumns(10);
		contentPane.add(txtnombrereferencia);
		
		txttelefonoreferencia = new JTextField();
		txttelefonoreferencia.setBounds(392, 368, 214, 20);
		txttelefonoreferencia.setColumns(10);
		contentPane.add(txttelefonoreferencia);
		
		JLabel lblDatosGenerales = new JLabel("Datos Generales:");
		lblDatosGenerales.setBounds(96, 33, 105, 14);
		lblDatosGenerales.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblDatosGenerales);
		
		JButton btnRegistrar = new JButton("GUARDAR");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRegistrar.setBounds(392, 404, 99, 23);
		btnRegistrar.setBackground(new Color(0, 128, 0));
		contentPane.add(btnRegistrar);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.setBounds(507, 438, 99, 23);
		btnSalir.setBackground(new Color(255, 0, 0));
		contentPane.add(btnSalir);
		
		txtfechanacimiento = new JTextField();
		txtfechanacimiento.setBounds(219, 317, 138, 20);
		txtfechanacimiento.setEditable(false);
		txtfechanacimiento.setColumns(10);
		contentPane.add(txtfechanacimiento);
		
		txtfecharegistro = new JTextField();
		txtfecharegistro.setBounds(219, 362, 138, 20);
		txtfecharegistro.setEditable(false);
		txtfecharegistro.setColumns(10);
		contentPane.add(txtfecharegistro);
		
		JButton btnFecha = new JButton("Seleccionar");
		btnFecha.setBounds(96, 314, 105, 23);
		contentPane.add(btnFecha);
		
		JButton button_1 = new JButton("Seleccionar");
		button_1.setBounds(96, 361, 105, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Seleccionar");
		button_2.setBounds(96, 410, 105, 23);
		contentPane.add(button_2);
		
		txtfechalabores = new JTextField();
		txtfechalabores.setBounds(219, 411, 138, 20);
		txtfechalabores.setEditable(false);
		txtfechalabores.setColumns(10);
		contentPane.add(txtfechalabores);
		
		JComboBox comboBoxgenero = new JComboBox();
		comboBoxgenero.setBounds(319, 151, 38, 20);
		contentPane.add(comboBoxgenero);
		
		JComboBox comboBoxestado = new JComboBox();
		comboBoxestado.setBounds(199, 438, 38, 20);
		contentPane.add(comboBoxestado);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(443, 224, 163, 20);
		contentPane.add(comboBox);
		
		JLabel lblEdad = new JLabel("Edad :");
		lblEdad.setBounds(96, 154, 31, 14);
		contentPane.add(lblEdad);
		
		textField = new JTextField();
		textField.setBounds(161, 151, 38, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblTelefonos = new JLabel("Telefonos :");
		lblTelefonos.setBounds(96, 208, 54, 14);
		contentPane.add(lblTelefonos);
		
		textField_1 = new JTextField();
		textField_1.setBounds(161, 205, 93, 20);
		textField_1.setColumns(10);
		contentPane.add(textField_1);
		
		JButton btnNuevo = new JButton("NUEVO");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNuevo.setBackground(new Color(0, 128, 0));
		btnNuevo.setBounds(507, 404, 99, 23);
		contentPane.add(btnNuevo);
		
		JButton btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.setBackground(new Color(0, 128, 0));
		btnActualizar.setBounds(392, 438, 99, 23);
		contentPane.add(btnActualizar);
	}
}
