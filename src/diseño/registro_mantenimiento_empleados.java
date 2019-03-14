package diseño;

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

public class registro_mantenimiento_empleados extends JFrame {

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
					registro_mantenimiento_empleados frame = new registro_mantenimiento_empleados();
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
	public registro_mantenimiento_empleados() {
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
		lblNombres.setBounds(37, 84, 63, 14);
		contentPane.add(lblNombres);
		
		JLabel lblApellidos = new JLabel("Apellidos :");
		lblApellidos.setBounds(37, 108, 63, 14);
		contentPane.add(lblApellidos);
		
		JLabel lblDireccion = new JLabel("Direccion :");
		lblDireccion.setBounds(37, 241, 63, 14);
		contentPane.add(lblDireccion);
		
		JLabel lblCodigo = new JLabel("Codigo :");
		lblCodigo.setBounds(37, 61, 53, 14);
		contentPane.add(lblCodigo);
		
		JLabel lblCorreo = new JLabel("Correo :");
		lblCorreo.setBounds(37, 180, 63, 14);
		contentPane.add(lblCorreo);
		
		JLabel lblGenero = new JLabel("Genero :");
		lblGenero.setBounds(205, 159, 53, 14);
		contentPane.add(lblGenero);
		
		JLabel lblIdentidad = new JLabel("Identidad :");
		lblIdentidad.setBounds(37, 133, 63, 14);
		contentPane.add(lblIdentidad);
		
		JLabel lblCargo = new JLabel("Cargo :");
		lblCargo.setBounds(392, 199, 48, 14);
		contentPane.add(lblCargo);
		
		JLabel lblHorario = new JLabel("Horario :");
		lblHorario.setBounds(392, 224, 48, 14);
		contentPane.add(lblHorario);
		
		JLabel lblTipoDeContrato = new JLabel("Tipo de Contrato :");
		lblTipoDeContrato.setBounds(392, 249, 112, 14);
		contentPane.add(lblTipoDeContrato);
		
		JLabel lblReferencia = new JLabel("Nombre completo de referencia :");
		lblReferencia.setBounds(392, 294, 184, 14);
		contentPane.add(lblReferencia);
		
		JPanel panel = new JPanel();
		panel.setBounds(514, 58, 128, 132);
		contentPane.add(panel);
		
		JLabel lblFotografia = new JLabel("Fotografia :");
		lblFotografia.setBounds(428, 58, 93, 14);
		contentPane.add(lblFotografia);
		
		JButton btnTomar = new JButton("Subir");
		btnTomar.setBounds(428, 111, 76, 23);
		contentPane.add(btnTomar);
		
		JButton button = new JButton("Tomar");
		button.setBounds(428, 83, 76, 23);
		contentPane.add(button);
		
		JLabel lblTelefonoDeLa = new JLabel("Telefono de Referencia :");
		lblTelefonoDeLa.setBounds(392, 348, 126, 14);
		contentPane.add(lblTelefonoDeLa);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento :");
		lblFechaDeNacimiento.setBounds(37, 303, 151, 14);
		contentPane.add(lblFechaDeNacimiento);
		
		JLabel lblFechaDeRegistro = new JLabel("Fecha de Registro :");
		lblFechaDeRegistro.setBounds(37, 351, 141, 14);
		contentPane.add(lblFechaDeRegistro);
		
		JLabel lblFechaDeComienso = new JLabel("Fecha de comienzo de labores :");
		lblFechaDeComienso.setBounds(37, 401, 178, 14);
		contentPane.add(lblFechaDeComienso);
		
		JLabel lblEstado = new JLabel("Estado :");
		lblEstado.setBounds(37, 447, 63, 14);
		contentPane.add(lblEstado);
		
		txtcodigo = new JTextField();
		txtcodigo.setBounds(102, 58, 28, 20);
		txtcodigo.setEditable(false);
		contentPane.add(txtcodigo);
		txtcodigo.setColumns(10);
		
		txtnombres = new JTextField();
		txtnombres.setBounds(102, 81, 196, 20);
		contentPane.add(txtnombres);
		txtnombres.setColumns(10);
		
		txtapellidos = new JTextField();
		txtapellidos.setBounds(102, 105, 196, 20);
		txtapellidos.setColumns(10);
		contentPane.add(txtapellidos);
		
		txtdireccion = new JTextField();
		txtdireccion.setBounds(102, 238, 196, 52);
		txtdireccion.setColumns(10);
		contentPane.add(txtdireccion);
		
		txtcorreo = new JTextField();
		txtcorreo.setBounds(102, 177, 196, 20);
		txtcorreo.setColumns(10);
		contentPane.add(txtcorreo);
		
		txtidentidad = new JTextField();
		txtidentidad.setBounds(102, 128, 196, 20);
		txtidentidad.setColumns(10);
		contentPane.add(txtidentidad);
		
		txttelefono = new JTextField();
		txttelefono.setBounds(205, 208, 93, 20);
		txttelefono.setColumns(10);
		contentPane.add(txttelefono);
		
		JComboBox comboBoxcargo = new JComboBox();
		comboBoxcargo.setBounds(443, 196, 199, 20);
		contentPane.add(comboBoxcargo);
		
		JComboBox comboBoxcontrato = new JComboBox();
		comboBoxcontrato.setBounds(443, 263, 199, 20);
		contentPane.add(comboBoxcontrato);
		
		txtnombrereferencia = new JTextField();
		txtnombrereferencia.setBounds(392, 317, 250, 20);
		txtnombrereferencia.setColumns(10);
		contentPane.add(txtnombrereferencia);
		
		txttelefonoreferencia = new JTextField();
		txttelefonoreferencia.setBounds(392, 368, 250, 20);
		txttelefonoreferencia.setColumns(10);
		contentPane.add(txttelefonoreferencia);
		
		JLabel lblDatosGenerales = new JLabel("Datos Generales:");
		lblDatosGenerales.setBounds(37, 36, 105, 14);
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
		btnSalir.setBounds(543, 438, 99, 23);
		btnSalir.setBackground(new Color(255, 0, 0));
		contentPane.add(btnSalir);
		
		txtfechanacimiento = new JTextField();
		txtfechanacimiento.setBounds(160, 320, 138, 20);
		txtfechanacimiento.setEditable(false);
		txtfechanacimiento.setColumns(10);
		contentPane.add(txtfechanacimiento);
		
		txtfecharegistro = new JTextField();
		txtfecharegistro.setBounds(160, 365, 138, 20);
		txtfecharegistro.setEditable(false);
		txtfecharegistro.setColumns(10);
		contentPane.add(txtfecharegistro);
		
		JButton btnFecha = new JButton("Seleccionar");
		btnFecha.setBounds(37, 317, 105, 23);
		contentPane.add(btnFecha);
		
		JButton button_1 = new JButton("Seleccionar");
		button_1.setBounds(37, 364, 105, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Seleccionar");
		button_2.setBounds(294, 80, 105, 23);
		contentPane.add(button_2);
		
		txtfechalabores = new JTextField();
		txtfechalabores.setBounds(160, 414, 138, 20);
		txtfechalabores.setEditable(false);
		txtfechalabores.setColumns(10);
		contentPane.add(txtfechalabores);
		
		JComboBox comboBoxgenero = new JComboBox();
		comboBoxgenero.setBounds(260, 154, 38, 20);
		contentPane.add(comboBoxgenero);
		
		JComboBox comboBoxestado = new JComboBox();
		comboBoxestado.setBounds(104, 444, 38, 20);
		contentPane.add(comboBoxestado);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(443, 224, 199, 20);
		contentPane.add(comboBox);
		
		JLabel lblEdad = new JLabel("Edad :");
		lblEdad.setBounds(37, 157, 53, 14);
		contentPane.add(lblEdad);
		
		textField = new JTextField();
		textField.setBounds(102, 154, 38, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblTelefonos = new JLabel("Telefonos :");
		lblTelefonos.setBounds(37, 211, 63, 14);
		contentPane.add(lblTelefonos);
		
		textField_1 = new JTextField();
		textField_1.setBounds(102, 208, 93, 20);
		textField_1.setColumns(10);
		contentPane.add(textField_1);
		
		JButton btnNuevo = new JButton("NUEVO");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNuevo.setBackground(new Color(0, 128, 0));
		btnNuevo.setBounds(543, 404, 99, 23);
		contentPane.add(btnNuevo);
		
		JButton btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.setBackground(new Color(0, 128, 0));
		btnActualizar.setBounds(392, 438, 99, 23);
		contentPane.add(btnActualizar);
	}
}
