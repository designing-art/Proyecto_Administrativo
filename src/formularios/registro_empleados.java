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
import java.awt.Image;

import javax.swing.SpringLayout;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import clases.cargo;
import consultas.consultas_cargo;
import controles.control_cargo;

public class registro_empleados extends JFrame {


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
	 public JTextField txtedad;
	 public JTextField txttelefono1;
	 public JButton btnGuardar;
	 public JButton btnActualizar;
	 public JButton btnNuevo;
	 public JButton btnSalir;
	 
	 public JButton btnBuscar;
	 public JTextField txtbuscar;
	 
	 

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
		final ImageIcon icono = new ImageIcon(getClass().getResource("/material/libreta.png"));

		
		JLabel lblRegistroDeEmpleados = new JLabel("Registro del empleado.");
		lblRegistroDeEmpleados.setBounds(245, 4, 197, 21);
		lblRegistroDeEmpleados.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
		contentPane.add(lblRegistroDeEmpleados);
		
		JLabel lblNombres = new JLabel("Nombres :");
		lblNombres.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblNombres.setBounds(46, 131, 83, 14);
		contentPane.add(lblNombres);
		
		JLabel lblApellidos = new JLabel("Apellidos :");
		lblApellidos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblApellidos.setBounds(46, 155, 83, 14);
		contentPane.add(lblApellidos);
		
		JLabel lblDireccion = new JLabel("Direccion :");
		lblDireccion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblDireccion.setBounds(46, 309, 83, 14);
		contentPane.add(lblDireccion);
		
		JLabel lblCodigo = new JLabel("Codigo :");
		lblCodigo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblCodigo.setBounds(46, 105, 83, 17);
		contentPane.add(lblCodigo);
		
		JLabel lblCorreo = new JLabel("Correo :");
		lblCorreo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblCorreo.setBounds(46, 259, 83, 14);
		contentPane.add(lblCorreo);
		
		JLabel lblGenero = new JLabel("Genero :");
		lblGenero.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblGenero.setBounds(46, 234, 76, 14);
		contentPane.add(lblGenero);
		
		JLabel lblIdentidad = new JLabel("Identidad :");
		lblIdentidad.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblIdentidad.setBounds(46, 181, 83, 14);
		contentPane.add(lblIdentidad);
		
		JLabel lblReferencia = new JLabel("Nombre completo de referencia :");
		lblReferencia.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblReferencia.setBounds(379, 214, 248, 23);
		contentPane.add(lblReferencia);
		
		JPanel panel = new JPanel();
		panel.setBounds(465, 83, 126, 132);
		contentPane.add(panel);
		
		JLabel lblFotografia = new JLabel("Fotografia :");
		lblFotografia.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblFotografia.setBounds(379, 80, 93, 17);
		contentPane.add(lblFotografia);
		
		JButton btnTomar = new JButton("Subir");
		btnTomar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnTomar.setBounds(379, 136, 76, 23);
		contentPane.add(btnTomar);
		
		JButton button = new JButton("Tomar");
		button.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		button.setBounds(379, 108, 76, 23);
		contentPane.add(button);
		
		JLabel lblTelefonoDeLa = new JLabel("Telefono de Referencia :");
		lblTelefonoDeLa.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblTelefonoDeLa.setBounds(379, 259, 202, 14);
		contentPane.add(lblTelefonoDeLa);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento :");
		lblFechaDeNacimiento.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblFechaDeNacimiento.setBounds(46, 364, 151, 28);
		contentPane.add(lblFechaDeNacimiento);
		
		JLabel lblFechaDeRegistro = new JLabel("Fecha de Registro :");
		lblFechaDeRegistro.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblFechaDeRegistro.setBounds(46, 403, 151, 17);
		contentPane.add(lblFechaDeRegistro);
		
		JLabel lblFechaDeComienso = new JLabel("Fecha Inicio Labores :");
		lblFechaDeComienso.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblFechaDeComienso.setBounds(46, 430, 151, 28);
		contentPane.add(lblFechaDeComienso);
		
		JLabel lblEstado = new JLabel("Estado :");
		lblEstado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblEstado.setBounds(379, 306, 63, 14);
		contentPane.add(lblEstado);
		
		txtcodigo = new JTextField();
		txtcodigo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtcodigo.setEditable(false);
		txtcodigo.setBounds(120, 103, 47, 20);
		contentPane.add(txtcodigo);
		txtcodigo.setColumns(10);
		
		txtnombres = new JTextField();
		txtnombres.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtnombres.setBounds(120, 128, 215, 20);
		contentPane.add(txtnombres);
		txtnombres.setColumns(10);
		
		txtapellidos = new JTextField();
		txtapellidos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtapellidos.setBounds(120, 152, 215, 20);
		txtapellidos.setColumns(10);
		contentPane.add(txtapellidos);
		
		txtdireccion = new JTextField();
		txtdireccion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtdireccion.setBounds(120, 309, 215, 48);
		txtdireccion.setColumns(10);
		contentPane.add(txtdireccion);
		
		txtcorreo = new JTextField();
		txtcorreo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtcorreo.setBounds(120, 259, 215, 20);
		txtcorreo.setColumns(10);
		contentPane.add(txtcorreo);
		
		txtidentidad = new JTextField();
		txtidentidad.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtidentidad.setBounds(120, 178, 215, 20);
		txtidentidad.setColumns(10);
		contentPane.add(txtidentidad);
		
		txttelefono2 = new JTextField();
		txttelefono2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txttelefono2.setBounds(236, 284, 99, 20);
		txttelefono2.setColumns(10);
		contentPane.add(txttelefono2);
		
		txtnombrereferencia = new JTextField();
		txtnombrereferencia.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtnombrereferencia.setBounds(379, 235, 260, 20);
		txtnombrereferencia.setColumns(10);
		contentPane.add(txtnombrereferencia);
		
		txttelefonoreferencia = new JTextField();
		txttelefonoreferencia.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txttelefonoreferencia.setBounds(379, 275, 260, 20);
		txttelefonoreferencia.setColumns(10);
		contentPane.add(txttelefonoreferencia);
		
		JLabel lblDatosGenerales = new JLabel("Datos del Registro :");
		lblDatosGenerales.setBounds(46, 80, 151, 14);
		lblDatosGenerales.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		contentPane.add(lblDatosGenerales);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnGuardar.setBounds(540, 334, 99, 23);
		btnGuardar.setBackground(new Color(0, 255, 127));
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
		btnSalir.setBounds(10, 4, 99, 23);
		btnSalir.setBackground(new Color(255, 127, 80));
		contentPane.add(btnSalir);
		
		JLabel lblEdad = new JLabel("Edad :");
		lblEdad.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblEdad.setBounds(46, 206, 83, 14);
		contentPane.add(lblEdad);
		
		txtedad = new JTextField();
		txtedad.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtedad.setBounds(120, 203, 50, 20);
		contentPane.add(txtedad);
		txtedad.setColumns(10);
		
		JLabel lblTelefonos = new JLabel("Telefonos :");
		lblTelefonos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblTelefonos.setBounds(46, 285, 83, 14);
		contentPane.add(lblTelefonos);
		
		txttelefono1 = new JTextField();
		txttelefono1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txttelefono1.setBounds(120, 284, 93, 20);
		txttelefono1.setColumns(10);
		contentPane.add(txttelefono1);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnNuevo.setBackground(new Color(0, 139, 139));
		btnNuevo.setBounds(379, 366, 99, 23);
		contentPane.add(btnNuevo);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnActualizar.setBackground(new Color(240, 230, 140));
		btnActualizar.setBounds(379, 335, 99, 23);
		contentPane.add(btnActualizar);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"F", "M"}));
		comboBox_1.setBounds(120, 231, 50, 20);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Activo", "Inactivo"}));
		comboBox_2.setBounds(439, 303, 76, 20);
		contentPane.add(comboBox_2);
		
		JButton btnListaDeEmpleados = new JButton("Siguiente");
		btnListaDeEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargo clase = new cargo();
		        consultas_cargo consulta = new consultas_cargo();
		        registro_cargos formulario = new registro_cargos();
		        control_cargo control = new control_cargo(clase, consulta, formulario);
		        formulario.setVisible(true);
		        formulario.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnListaDeEmpleados.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnListaDeEmpleados.setBackground(new Color(0, 255, 127));
		btnListaDeEmpleados.setBounds(585, 4, 99, 23);
		contentPane.add(btnListaDeEmpleados);
		
		JDateChooser dateFechaNacimiento = new JDateChooser();
		dateFechaNacimiento.setBounds(172, 368, 163, 20);
		contentPane.add(dateFechaNacimiento);
		
		JDateChooser dateFechaRegistro = new JDateChooser();
		dateFechaRegistro.setBounds(172, 399, 163, 20);
		contentPane.add(dateFechaRegistro);
		
		JDateChooser dateFechaLabores = new JDateChooser();
		dateFechaLabores.setBounds(172, 431, 163, 20);
		contentPane.add(dateFechaLabores);
		
		JLabel lblMensajeConfirmacionRegistroEmpleado = new JLabel("");
		lblMensajeConfirmacionRegistroEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblMensajeConfirmacionRegistroEmpleado.setBounds(379, 392, 260, 66);
		contentPane.add(lblMensajeConfirmacionRegistroEmpleado);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(601, 83, 46, 39);
		contentPane.add(label_1);
		final ImageIcon icono1 = new ImageIcon(getClass().getResource("/material/logo.png"));
		final ImageIcon logo1 = new ImageIcon(icono1.getImage().getScaledInstance(label_1.getWidth(),label_1.getHeight(), Image.SCALE_DEFAULT));
		label_1.setIcon(logo1);
		
		JLabel label = new JLabel();
		label.setBounds(0, 34, 695, 455);
		contentPane.add(label);
		final ImageIcon logo = new ImageIcon(icono.getImage().getScaledInstance(label.getWidth(),
				label.getHeight(), Image.SCALE_DEFAULT));
		label.setIcon(logo);
	}
}
