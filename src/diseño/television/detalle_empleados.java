package diseño.television;

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

public class detalle_empleados extends JFrame {

	private JPanel contentPane;
	private JTextField txtcodigo;
	private JTextField txtnombres;
	private JTextField txtapellidos;
	private JTextField txtdireccion;
	private JTextField txtcorreo;
	private JTextField txtidentidad;
	private JTextField txttelefono;
	private JTextField txthorario;
	private JTextField txtnombrereferencia;
	private JTextField txttelefonoreferencia;
	private JTextField txtfechanacimiento;
	private JTextField txtfecharegistro;
	private JTextField txtfechalabores;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					detalle_empleados frame = new detalle_empleados();
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
	public detalle_empleados() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 538);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistroDeEmpleados = new JLabel("DETALLES DEL EMPLEADO");
		lblRegistroDeEmpleados.setBounds(163, 11, 147, 28);
		lblRegistroDeEmpleados.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblRegistroDeEmpleados);
		
		JLabel lblNombres = new JLabel("Nombres :");
		lblNombres.setBounds(10, 95, 63, 14);
		contentPane.add(lblNombres);
		
		JLabel lblApellidos = new JLabel("Apellidos :");
		lblApellidos.setBounds(10, 120, 63, 14);
		contentPane.add(lblApellidos);
		
		JLabel lblTelefono = new JLabel("Direccion :");
		lblTelefono.setBounds(10, 145, 63, 14);
		contentPane.add(lblTelefono);
		
		JLabel lblDireccion = new JLabel("Codigo :");
		lblDireccion.setBounds(10, 69, 63, 14);
		contentPane.add(lblDireccion);
		
		JLabel label = new JLabel("Telefono :");
		label.setBounds(10, 270, 63, 14);
		contentPane.add(label);
		
		JLabel lblCorreo = new JLabel("Correo :");
		lblCorreo.setBounds(10, 195, 63, 14);
		contentPane.add(lblCorreo);
		
		JLabel lblGenero = new JLabel("Genero :");
		lblGenero.setBounds(10, 220, 63, 14);
		contentPane.add(lblGenero);
		
		JLabel lblIdentidad = new JLabel("Identidad :");
		lblIdentidad.setBounds(10, 245, 63, 14);
		contentPane.add(lblIdentidad);
		
		JLabel lblCargo = new JLabel("Cargo :");
		lblCargo.setBounds(271, 245, 48, 14);
		contentPane.add(lblCargo);
		
		JLabel lblHorario = new JLabel("Horario :");
		lblHorario.setBounds(271, 270, 48, 14);
		contentPane.add(lblHorario);
		
		JLabel lblTipoDeContrato = new JLabel("Tipo de Contrato :");
		lblTipoDeContrato.setBounds(271, 295, 93, 14);
		contentPane.add(lblTipoDeContrato);
		
		JLabel lblReferencia = new JLabel("Nombre completo de referencia :");
		lblReferencia.setBounds(271, 320, 184, 14);
		contentPane.add(lblReferencia);
		
		JPanel panel = new JPanel();
		panel.setBounds(345, 69, 118, 132);
		contentPane.add(panel);
		
		JLabel lblFotografia = new JLabel("Fotografia :");
		lblFotografia.setBounds(271, 69, 93, 14);
		contentPane.add(lblFotografia);
		
		JLabel lblTelefonoDeLa = new JLabel("Telefono de Referencia :");
		lblTelefonoDeLa.setBounds(271, 371, 126, 14);
		contentPane.add(lblTelefonoDeLa);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento :");
		lblFechaDeNacimiento.setBounds(10, 295, 105, 14);
		contentPane.add(lblFechaDeNacimiento);
		
		JLabel lblFechaDeRegistro = new JLabel("Fecha de Registro :");
		lblFechaDeRegistro.setBounds(10, 343, 105, 14);
		contentPane.add(lblFechaDeRegistro);
		
		JLabel lblFechaDeComienso = new JLabel("Fecha de comienzo de labores :");
		lblFechaDeComienso.setBounds(10, 393, 151, 14);
		contentPane.add(lblFechaDeComienso);
		
		JLabel lblEstado = new JLabel("Estado :");
		lblEstado.setBounds(10, 450, 63, 14);
		contentPane.add(lblEstado);
		
		txtcodigo = new JTextField();
		txtcodigo.setBounds(75, 66, 28, 20);
		txtcodigo.setEditable(false);
		contentPane.add(txtcodigo);
		txtcodigo.setColumns(10);
		
		txtnombres = new JTextField();
		txtnombres.setBounds(75, 92, 186, 20);
		txtnombres.setEditable(false);
		contentPane.add(txtnombres);
		txtnombres.setColumns(10);
		
		txtapellidos = new JTextField();
		txtapellidos.setBounds(75, 117, 186, 20);
		txtapellidos.setEditable(false);
		txtapellidos.setColumns(10);
		contentPane.add(txtapellidos);
		
		txtdireccion = new JTextField();
		txtdireccion.setBounds(75, 142, 186, 44);
		txtdireccion.setEditable(false);
		txtdireccion.setColumns(10);
		contentPane.add(txtdireccion);
		
		txtcorreo = new JTextField();
		txtcorreo.setBounds(75, 192, 186, 20);
		txtcorreo.setEditable(false);
		txtcorreo.setColumns(10);
		contentPane.add(txtcorreo);
		
		txtidentidad = new JTextField();
		txtidentidad.setBounds(75, 242, 186, 20);
		txtidentidad.setEditable(false);
		txtidentidad.setColumns(10);
		contentPane.add(txtidentidad);
		
		txttelefono = new JTextField();
		txttelefono.setBounds(75, 267, 186, 20);
		txttelefono.setEditable(false);
		txttelefono.setColumns(10);
		contentPane.add(txttelefono);
		
		txthorario = new JTextField();
		txthorario.setBounds(345, 267, 118, 20);
		txthorario.setEditable(false);
		txthorario.setColumns(10);
		contentPane.add(txthorario);
		
		txtnombrereferencia = new JTextField();
		txtnombrereferencia.setBounds(271, 340, 184, 20);
		txtnombrereferencia.setEditable(false);
		txtnombrereferencia.setColumns(10);
		contentPane.add(txtnombrereferencia);
		
		txttelefonoreferencia = new JTextField();
		txttelefonoreferencia.setBounds(271, 387, 184, 20);
		txttelefonoreferencia.setEditable(false);
		txttelefonoreferencia.setColumns(10);
		contentPane.add(txttelefonoreferencia);
		
		JLabel lblDatosGenerales = new JLabel("Datos Generales:");
		lblDatosGenerales.setBounds(10, 44, 118, 14);
		contentPane.add(lblDatosGenerales);
		
		JButton btnRegistrar = new JButton("ACTUALIZAR");
		btnRegistrar.setBounds(337, 418, 118, 23);
		btnRegistrar.setBackground(new Color(0, 128, 0));
		contentPane.add(btnRegistrar);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.setBounds(380, 446, 75, 23);
		btnSalir.setBackground(new Color(255, 0, 0));
		contentPane.add(btnSalir);
		
		txtfechanacimiento = new JTextField();
		txtfechanacimiento.setBounds(75, 317, 186, 20);
		txtfechanacimiento.setEditable(false);
		txtfechanacimiento.setColumns(10);
		contentPane.add(txtfechanacimiento);
		
		txtfecharegistro = new JTextField();
		txtfecharegistro.setBounds(75, 368, 186, 20);
		txtfecharegistro.setEditable(false);
		txtfecharegistro.setColumns(10);
		contentPane.add(txtfecharegistro);
		
		txtfechalabores = new JTextField();
		txtfechalabores.setBounds(75, 417, 186, 20);
		txtfechalabores.setEditable(false);
		txtfechalabores.setColumns(10);
		contentPane.add(txtfechalabores);
		
		textField = new JTextField();
		textField.setBounds(75, 217, 28, 20);
		textField.setEditable(false);
		textField.setColumns(10);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setBounds(75, 447, 28, 20);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(345, 242, 118, 20);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(370, 292, 93, 20);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		contentPane.add(textField_3);
	}
}
