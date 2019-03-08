package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class ingresos extends JFrame {
	
	private JTextField txtcodigoingresos;
	private JTextField txtingresosedicion;
	private JTextField txtingresospublicidad;
	private JTextField txtingresospublicidadgobierno;
	private JTextField txtingresosotrosservicios;
	private JTextField txttotalingresos;
	private JTextField txtdescripcioningresos;

	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ingresos frame = new ingresos();
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
	public ingresos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 421, 545);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIngresos = new JLabel("INGRESOS");
		lblIngresos.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresos.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIngresos.setBounds(125, 11, 147,40);
		contentPane.add(lblIngresos);
		
		JLabel lblCodigoIngresos = new JLabel("Codigo Ingresos : ");
		lblCodigoIngresos.setBounds(10, 67, 150, 14);
		contentPane.add(lblCodigoIngresos);
		
		JLabel lblIngresosPorEdicion = new JLabel("Ingresos por Edicion : L.");
		lblIngresosPorEdicion.setBounds(10, 117, 180, 14);
		contentPane.add(lblIngresosPorEdicion);
		
		JLabel lblIngresosPorPublicidad = new JLabel("Ingresos por Publicidad :  L.");
		lblIngresosPorPublicidad.setBounds(10, 167, 180, 14);
		contentPane.add(lblIngresosPorPublicidad);
		
		JLabel lblPublicidadGobierno = new JLabel("Ingresos por Publicidad del Gobierno :  L.");
		lblPublicidadGobierno.setBounds(10, 217, 240, 14);
		contentPane.add(lblPublicidadGobierno);
		
		JLabel lblIngresosOtros = new JLabel("Ingresos por Otros Servicios :  L.");
		lblIngresosOtros.setBounds(10, 267, 240, 14);
		contentPane.add(lblIngresosOtros);
		
		JLabel lblCantidadIngresos = new JLabel("Total Ingresos :  L.");
		lblCantidadIngresos.setBounds(10, 319, 280, 14);
		contentPane.add(lblCantidadIngresos);
		
		JLabel lblDescripcionIngresos = new JLabel("Descripcion de Ingresos :");
		lblDescripcionIngresos.setBounds(10, 367, 320, 14);
		contentPane.add(lblDescripcionIngresos);
		
		txtcodigoingresos = new JTextField();
		txtcodigoingresos.setEditable(false);
		txtcodigoingresos.setBounds(212, 62, 60, 25);
		contentPane.add(txtcodigoingresos);
		txtcodigoingresos.setColumns(10);
		
		txtingresosedicion = new JTextField();
		txtingresosedicion.setEditable(true);
		txtingresosedicion.setBounds(212, 112, 180, 25);
		contentPane.add(txtingresosedicion);
		txtingresosedicion.setColumns(10);
		
		txtingresospublicidad = new JTextField();
		txtingresospublicidad.setEditable(true);
		txtingresospublicidad.setBounds(212, 162, 180, 25);
		contentPane.add(txtingresospublicidad);
		txtingresospublicidad.setColumns(10);
		
		txtingresospublicidadgobierno = new JTextField();
		txtingresospublicidadgobierno.setBounds(212, 214, 180, 25);
		contentPane.add(txtingresospublicidadgobierno);
		txtingresospublicidadgobierno.setColumns(10);
		
		txtingresosotrosservicios = new JTextField();
		txtingresosotrosservicios.setBounds(212, 262, 180, 25);
		contentPane.add(txtingresosotrosservicios);
		txtingresosotrosservicios.setColumns(10);
		
		txttotalingresos = new JTextField();
		txttotalingresos.setBounds(212, 314, 180, 25);
		txttotalingresos.setEditable(false);
		contentPane.add(txttotalingresos);
		txttotalingresos.setColumns(10);
		
		txtdescripcioningresos = new JTextField();
		txtdescripcioningresos.setBounds(210, 362, 180, 74);
		contentPane.add(txtdescripcioningresos);
		txtdescripcioningresos.setColumns(10);
		
		JButton button = new JButton("Guardar");
		button.setBackground(new Color(0, 128, 0));
		button.setBounds(35, 453, 89, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Editar");
		button_1.setBackground(new Color(0, 128, 0));
		button_1.setBounds(172, 453, 89, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Salir");
		button_2.setBackground(Color.RED);
		button_2.setBounds(303, 453, 89, 23);
		contentPane.add(button_2);
		
		
		
		
		
		
	}
}
