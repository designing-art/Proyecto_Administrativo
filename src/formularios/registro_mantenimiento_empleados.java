package formularios;

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
import javax.swing.DefaultComboBoxModel;

public class registro_mantenimiento_empleados extends JFrame {


	 JPanel contentPane;
	 public JTextField txtcodigo;
	 public JTextField txtnombres;
	 public JTextField txtapellidos;
	 public JTextField txtdireccion;
	 public JTextField txtcorreo;
	 public JTextField txtidentidad;
	 public JTextField txttelefono2;
	 public JTextField txtnombrereferencia;
	 public JTextField txttelefonoreferencia;
	 public JTextField txtfechanacimiento;
	 public JTextField txtedad;
	 public JTextField txttelefono1;
	 public JButton btnGuardar;
	 public JButton btnActualizar;
	 public JButton btnNuevo;
	 public JButton btnSalir;
	 
	 public JButton btnBuscar;
	 public JTextField txtbuscar;
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
		lblRegistroDeEmpleados.setBounds(34, 0, 197, 36);
		lblRegistroDeEmpleados.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
		contentPane.add(lblRegistroDeEmpleados);
		
		JLabel lblNombres = new JLabel("Nombres :");
		lblNombres.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNombres.setBounds(37, 84, 83, 14);
		contentPane.add(lblNombres);
		
		JLabel lblApellidos = new JLabel("Apellidos :");
		lblApellidos.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblApellidos.setBounds(37, 108, 83, 14);
		contentPane.add(lblApellidos);
		
		JLabel lblDireccion = new JLabel("Direccion :");
		lblDireccion.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblDireccion.setBounds(37, 241, 83, 14);
		contentPane.add(lblDireccion);
		
		JLabel lblCodigo = new JLabel("Codigo :");
		lblCodigo.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblCodigo.setBounds(37, 58, 83, 17);
		contentPane.add(lblCodigo);
		
		JLabel lblCorreo = new JLabel("Correo :");
		lblCorreo.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblCorreo.setBounds(37, 180, 83, 14);
		contentPane.add(lblCorreo);
		
		JLabel lblGenero = new JLabel("Genero :");
		lblGenero.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblGenero.setBounds(171, 162, 76, 14);
		contentPane.add(lblGenero);
		
		JLabel lblIdentidad = new JLabel("Identidad :");
		lblIdentidad.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblIdentidad.setBounds(37, 133, 83, 14);
		contentPane.add(lblIdentidad);
		
		JLabel lblCargo = new JLabel("Cargo :");
		lblCargo.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblCargo.setBounds(354, 196, 70, 17);
		contentPane.add(lblCargo);
		
		JLabel lblHorario = new JLabel("Horario :");
		lblHorario.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblHorario.setBounds(354, 224, 70, 14);
		contentPane.add(lblHorario);
		
		JLabel lblTipoDeContrato = new JLabel("Tipo de Contrato :");
		lblTipoDeContrato.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblTipoDeContrato.setBounds(354, 249, 137, 22);
		contentPane.add(lblTipoDeContrato);
		
		JLabel lblReferencia = new JLabel("Nombre completo de referencia :");
		lblReferencia.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblReferencia.setBounds(392, 294, 248, 14);
		contentPane.add(lblReferencia);
		
		JPanel panel = new JPanel();
		panel.setBounds(514, 58, 126, 132);
		contentPane.add(panel);
		
		JLabel lblFotografia = new JLabel("Fotografia :");
		lblFotografia.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblFotografia.setBounds(428, 55, 93, 17);
		contentPane.add(lblFotografia);
		
		JButton btnTomar = new JButton("Subir");
		btnTomar.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnTomar.setBounds(428, 111, 76, 23);
		contentPane.add(btnTomar);
		
		JButton button = new JButton("Tomar");
		button.setFont(new Font("Dialog", Font.PLAIN, 12));
		button.setBounds(428, 83, 76, 23);
		contentPane.add(button);
		
		JLabel lblTelefonoDeLa = new JLabel("Telefono de Referencia :");
		lblTelefonoDeLa.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblTelefonoDeLa.setBounds(392, 348, 202, 14);
		contentPane.add(lblTelefonoDeLa);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento :");
		lblFechaDeNacimiento.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblFechaDeNacimiento.setBounds(37, 294, 151, 23);
		contentPane.add(lblFechaDeNacimiento);
		
		JLabel lblFechaDeRegistro = new JLabel("Fecha de Registro :");
		lblFechaDeRegistro.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblFechaDeRegistro.setBounds(37, 348, 141, 17);
		contentPane.add(lblFechaDeRegistro);
		
		JLabel lblFechaDeComienso = new JLabel("Fecha de comienzo de labores :");
		lblFechaDeComienso.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblFechaDeComienso.setBounds(37, 397, 261, 18);
		contentPane.add(lblFechaDeComienso);
		
		JLabel lblEstado = new JLabel("Estado :");
		lblEstado.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblEstado.setBounds(37, 447, 63, 14);
		contentPane.add(lblEstado);
		
		txtcodigo = new JTextField();
		txtcodigo.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtcodigo.setEditable(false);
		txtcodigo.setBounds(111, 61, 47, 20);
		contentPane.add(txtcodigo);
		txtcodigo.setColumns(10);
		
		txtnombres = new JTextField();
		txtnombres.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtnombres.setBounds(111, 84, 215, 20);
		contentPane.add(txtnombres);
		txtnombres.setColumns(10);
		
		txtapellidos = new JTextField();
		txtapellidos.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtapellidos.setBounds(111, 108, 215, 20);
		txtapellidos.setColumns(10);
		contentPane.add(txtapellidos);
		
		txtdireccion = new JTextField();
		txtdireccion.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtdireccion.setBounds(130, 241, 196, 52);
		txtdireccion.setColumns(10);
		contentPane.add(txtdireccion);
		
		txtcorreo = new JTextField();
		txtcorreo.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtcorreo.setBounds(111, 180, 215, 20);
		txtcorreo.setColumns(10);
		contentPane.add(txtcorreo);
		
		txtidentidad = new JTextField();
		txtidentidad.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtidentidad.setBounds(111, 131, 215, 20);
		txtidentidad.setColumns(10);
		contentPane.add(txtidentidad);
		
		txttelefono2 = new JTextField();
		txttelefono2.setFont(new Font("Dialog", Font.PLAIN, 12));
		txttelefono2.setBounds(227, 210, 99, 20);
		txttelefono2.setColumns(10);
		contentPane.add(txttelefono2);
		
		txtnombrereferencia = new JTextField();
		txtnombrereferencia.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtnombrereferencia.setBounds(392, 317, 260, 20);
		txtnombrereferencia.setColumns(10);
		contentPane.add(txtnombrereferencia);
		
		txttelefonoreferencia = new JTextField();
		txttelefonoreferencia.setFont(new Font("Dialog", Font.PLAIN, 12));
		txttelefonoreferencia.setBounds(392, 368, 260, 20);
		txttelefonoreferencia.setColumns(10);
		contentPane.add(txttelefonoreferencia);
		
		JLabel lblDatosGenerales = new JLabel("Datos Generales:");
		lblDatosGenerales.setBounds(37, 36, 105, 14);
		lblDatosGenerales.setFont(new Font("Dialog", Font.PLAIN, 12));
		contentPane.add(lblDatosGenerales);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		btnGuardar.setBounds(553, 397, 99, 23);
		btnGuardar.setBackground(new Color(0, 128, 0));
		contentPane.add(btnGuardar);
		
		btnSalir = new JButton("Regresar");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana_principal principal = new ventana_principal();
		 		principal.setVisible(true);
		 		principal.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnSalir.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnSalir.setBounds(585, 11, 99, 23);
		btnSalir.setBackground(new Color(255, 127, 80));
		contentPane.add(btnSalir);
		
		txtfechanacimiento = new JTextField();
		txtfechanacimiento.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtfechanacimiento.setEditable(false);
		txtfechanacimiento.setBounds(102, 317, 196, 23);
		txtfechanacimiento.setColumns(10);
		contentPane.add(txtfechanacimiento);
		
		JButton btnFecha = new JButton("Seleccionar");
		btnFecha.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnFecha.setBounds(37, 317, 63, 23);
		contentPane.add(btnFecha);
		
		JLabel lblEdad = new JLabel("Edad :");
		lblEdad.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblEdad.setBounds(37, 157, 83, 14);
		contentPane.add(lblEdad);
		
		txtedad = new JTextField();
		txtedad.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtedad.setBounds(111, 158, 50, 20);
		contentPane.add(txtedad);
		txtedad.setColumns(10);
		
		JLabel lblTelefonos = new JLabel("Telefonos :");
		lblTelefonos.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblTelefonos.setBounds(37, 205, 83, 14);
		contentPane.add(lblTelefonos);
		
		txttelefono1 = new JTextField();
		txttelefono1.setFont(new Font("Dialog", Font.PLAIN, 12));
		txttelefono1.setBounds(111, 210, 105, 20);
		txttelefono1.setColumns(10);
		contentPane.add(txttelefono1);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		btnNuevo.setBackground(new Color(0, 139, 139));
		btnNuevo.setBounds(392, 397, 99, 23);
		contentPane.add(btnNuevo);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		btnActualizar.setBackground(new Color(240, 230, 140));
		btnActualizar.setBounds(470, 431, 111, 23);
		contentPane.add(btnActualizar);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Femenino", "Masculino"}));
		comboBox_1.setBounds(233, 159, 93, 20);
		contentPane.add(comboBox_1);
		
		JButton button_1 = new JButton("Seleccionar");
		button_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		button_1.setBounds(37, 367, 63, 23);
		contentPane.add(button_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(102, 367, 196, 23);
		contentPane.add(textField);
		
		JButton button_2 = new JButton("Seleccionar");
		button_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		button_2.setBounds(37, 413, 63, 23);
		contentPane.add(button_2);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(102, 413, 196, 23);
		contentPane.add(textField_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Activo", "Inactivo"}));
		comboBox_2.setBounds(102, 444, 76, 20);
		contentPane.add(comboBox_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Dialog", Font.PLAIN, 12));
		comboBox.setBounds(444, 196, 169, 20);
		contentPane.add(comboBox);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setFont(new Font("Dialog", Font.PLAIN, 12));
		comboBox_3.setBounds(444, 221, 169, 20);
		contentPane.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setFont(new Font("Dialog", Font.PLAIN, 12));
		comboBox_4.setBounds(444, 270, 169, 20);
		contentPane.add(comboBox_4);
		
		JButton button_3 = new JButton("+");
		button_3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		button_3.setBackground(new Color(0, 139, 139));
		button_3.setBounds(623, 193, 47, 22);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("+");
		button_4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		button_4.setBackground(new Color(0, 139, 139));
		button_4.setBounds(623, 220, 47, 22);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("+");
		button_5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		button_5.setBackground(new Color(0, 139, 139));
		button_5.setBounds(623, 268, 47, 22);
		contentPane.add(button_5);
		
		JButton btnListaDeEmpleados = new JButton("Lista de Empleados Registrados.");
		btnListaDeEmpleados.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnListaDeEmpleados.setBackground(new Color(240, 230, 140));
		btnListaDeEmpleados.setBounds(404, 465, 238, 23);
		contentPane.add(btnListaDeEmpleados);
	}
}
