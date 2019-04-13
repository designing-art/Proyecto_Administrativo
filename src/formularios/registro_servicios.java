package formularios;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class registro_servicios extends JFrame {
	private JTextField txtidservicio;
	private JTextField txtduracionservicio;
	private JTextField txtprecioservicio;
	private JTextField txttomasservicio;
	private JTextField txtedicionservicio;


 JPanel contentPane;
 private JTextField textField;
 private JButton btnGuardar;
 private JButton btnNuevo;
 private JButton btnActualizar;
 private JButton btnSalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					registro_servicios frame = new registro_servicios();
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
	public registro_servicios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblRegistroservicios = new JLabel("REGISTRO DE SERVICIOS");
		lblRegistroservicios.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRegistroservicios.setBounds(273, 53, 147, 28);
		contentPane.add(lblRegistroservicios);
		
		
		
		JLabel lblidservicio = new JLabel("Codigo:");
		lblidservicio.setBounds(215, 112, 63, 14);
		contentPane.add(lblidservicio);
		
		JLabel lblduracionservicio = new JLabel("Duracion :");
		lblduracionservicio.setBounds(215, 150, 100, 14);
		contentPane.add(lblduracionservicio);
		
		JLabel lblprecioservicio = new JLabel("Precio : L.");
		lblprecioservicio.setBounds(215, 183, 100, 14);
		contentPane.add(lblprecioservicio);
		
		JLabel lbltomaservicio = new JLabel("Tomas :");
		lbltomaservicio.setBounds(215, 216, 100, 14);
		contentPane.add(lbltomaservicio);
		
		
		JLabel lbldescripcionservicio = new JLabel("Descripcion :");
		lbldescripcionservicio.setBounds(217,246, 120, 14);
		contentPane.add(lbldescripcionservicio);
		
		

		
		txtidservicio = new JTextField();
		txtidservicio.setEditable(false);
		txtidservicio.setBounds(377, 109, 28, 20);
		contentPane.add(txtidservicio);
		txtidservicio.setColumns(10);
		
		txtduracionservicio = new JTextField();
		txtduracionservicio.setBounds(377,180 , 100, 20);
		contentPane.add(txtduracionservicio);
		txtduracionservicio.setColumns(10);
		
		
		txtprecioservicio = new JTextField();
		txtprecioservicio.setBounds(377,213 , 100, 20);
		contentPane.add(txtprecioservicio);
		txtprecioservicio.setColumns(10);
		
		
		txttomasservicio = new JTextField();
		txttomasservicio.setBounds(377,243 , 100, 20);
		contentPane.add(txttomasservicio);
		txttomasservicio.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(377, 147, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setBounds(215, 303, 111, 23);
		contentPane.add(btnGuardar);
		
		btnNuevo = new JButton("NUEVO");
		btnNuevo.setBounds(350, 303, 127, 23);
		contentPane.add(btnNuevo);
		
		btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.setBounds(215, 337, 111, 23);
		contentPane.add(btnActualizar);
		
		btnSalir = new JButton("SALIR");
		btnSalir.setBounds(350, 337, 127, 23);
		contentPane.add(btnSalir);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

