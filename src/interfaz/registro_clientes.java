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

public class registro_clientes extends JFrame {

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
		setBounds(100, 100, 486, 538);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistroDeEmpleados = new JLabel("REGISTRAR EMPLEADO");
		lblRegistroDeEmpleados.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRegistroDeEmpleados.setBounds(170, 11, 147, 28);
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
		
		JButton btnTomar = new JButton("Subir");
		btnTomar.setBounds(271, 116, 63, 23);
		contentPane.add(btnTomar);
		
		JButton button = new JButton("Tomar");
		button.setBounds(271, 91, 63, 23);
		contentPane.add(button);
		
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
		txtcodigo.setEditable(false);
		txtcodigo.setBounds(75, 66, 28, 20);
		contentPane.add(txtcodigo);
		txtcodigo.setColumns(10);
		
		txtnombres = new JTextField();
		txtnombres.setBounds(75, 92, 186, 20);
		contentPane.add(txtnombres);
		txtnombres.setColumns(10);
		
		txtapellidos = new JTextField();
		txtapellidos.setColumns(10);
		txtapellidos.setBounds(75, 117, 186, 20);
		contentPane.add(txtapellidos);
		
		txtdireccion = new JTextField();
		txtdireccion.setColumns(10);
		txtdireccion.setBounds(75, 142, 186, 44);
		contentPane.add(txtdireccion);
		
		txtcorreo = new JTextField();
		txtcorreo.setColumns(10);
		txtcorreo.setBounds(75, 192, 186, 20);
		contentPane.add(txtcorreo);
		
		txtidentidad = new JTextField();
		txtidentidad.setColumns(10);
		txtidentidad.setBounds(75, 242, 186, 20);
		contentPane.add(txtidentidad);
		
		txttelefono = new JTextField();
		txttelefono.setColumns(10);
		txttelefono.setBounds(75, 267, 186, 20);
		contentPane.add(txttelefono);
		
		JComboBox comboBoxcargo = new JComboBox();
		comboBoxcargo.setBounds(345, 242, 118, 20);
		contentPane.add(comboBoxcargo);
		
		txthorario = new JTextField();
		txthorario.setEditable(false);
		txthorario.setColumns(10);
		txthorario.setBounds(345, 267, 118, 20);
		contentPane.add(txthorario);
		
		JComboBox comboBoxcontrato = new JComboBox();
		comboBoxcontrato.setBounds(374, 295, 89, 20);
		contentPane.add(comboBoxcontrato);
		
		txtnombrereferencia = new JTextField();
		txtnombrereferencia.setColumns(10);
		txtnombrereferencia.setBounds(271, 340, 184, 20);
		contentPane.add(txtnombrereferencia);
		
		txttelefonoreferencia = new JTextField();
		txttelefonoreferencia.setColumns(10);
		txttelefonoreferencia.setBounds(271, 387, 184, 20);
		contentPane.add(txttelefonoreferencia);
		
		JLabel lblDatosGenerales = new JLabel("Datos Generales:");
		lblDatosGenerales.setBounds(10, 44, 118, 14);
		contentPane.add(lblDatosGenerales);
		
		JButton btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setBackground(new Color(0, 128, 0));
		btnRegistrar.setBounds(318, 420, 99, 23);
		contentPane.add(btnRegistrar);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.setBackground(new Color(255, 0, 0));
		btnSalir.setBounds(329, 454, 75, 23);
		contentPane.add(btnSalir);
		
		txtfechanacimiento = new JTextField();
		txtfechanacimiento.setEditable(false);
		txtfechanacimiento.setColumns(10);
		txtfechanacimiento.setBounds(113, 317, 148, 20);
		contentPane.add(txtfechanacimiento);
		
		txtfecharegistro = new JTextField();
		txtfecharegistro.setEditable(false);
		txtfecharegistro.setColumns(10);
		txtfecharegistro.setBounds(113, 368, 148, 20);
		contentPane.add(txtfecharegistro);
		
		JButton btnFecha = new JButton("Seleccionar");
		btnFecha.setBounds(10, 316, 93, 23);
		contentPane.add(btnFecha);
		
		JButton button_1 = new JButton("Seleccionar");
		button_1.setBounds(10, 367, 93, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Seleccionar");
		button_2.setBounds(10, 416, 93, 23);
		contentPane.add(button_2);
		
		txtfechalabores = new JTextField();
		txtfechalabores.setEditable(false);
		txtfechalabores.setColumns(10);
		txtfechalabores.setBounds(113, 417, 148, 20);
		contentPane.add(txtfechalabores);
		
		JComboBox comboBoxgenero = new JComboBox();
		comboBoxgenero.setBounds(75, 217, 28, 20);
		contentPane.add(comboBoxgenero);
		
		JComboBox comboBoxestado = new JComboBox();
		comboBoxestado.setBounds(75, 447, 28, 20);
		contentPane.add(comboBoxestado);
	}
}
