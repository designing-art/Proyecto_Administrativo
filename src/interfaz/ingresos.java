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
		setBounds(100, 100, 486, 538);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIngresos = new JLabel("INGRESOS");
		lblIngresos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIngresos.setBounds(170, 11, 147,40);
		contentPane.add(lblIngresos);
		
		JLabel lblCodigoIngresos = new JLabel("Codigo Ingresos : ");
		lblCodigoIngresos.setBounds(10, 95, 150, 14);
		contentPane.add(lblCodigoIngresos);
		
		JLabel lblIngresosPorEdicion = new JLabel("Ingresos por Edicion : L.");
		lblIngresosPorEdicion.setBounds(10, 150, 180, 14);
		contentPane.add(lblIngresosPorEdicion);
		
		JLabel lblIngresosPorPublicidad = new JLabel("Ingresos por Publicidad :  L.");
		lblIngresosPorPublicidad.setBounds(10, 200, 180, 14);
		contentPane.add(lblIngresosPorPublicidad);
		
		JLabel lblPublicidadGobierno = new JLabel("Ingresos por Publicidad del Gobierno :  L.");
		lblPublicidadGobierno.setBounds(10, 250, 240, 14);
		contentPane.add(lblPublicidadGobierno);
		
		JLabel lblIngresosOtros = new JLabel("Ingresos por Otros Servicios :  L.");
		lblIngresosOtros.setBounds(10, 300, 240, 14);
		contentPane.add(lblIngresosOtros);
		
		JLabel lblCantidadIngresos = new JLabel("Total Ingresos :  L.");
		lblCantidadIngresos.setBounds(10, 352, 280, 14);
		contentPane.add(lblCantidadIngresos);
		
		JLabel lblDescripcionIngresos = new JLabel("Descripcion de Ingresos :");
		lblDescripcionIngresos.setBounds(10, 400, 320, 14);
		contentPane.add(lblDescripcionIngresos);
		
		txtcodigoingresos = new JTextField();
		txtcodigoingresos.setEditable(false);
		txtcodigoingresos.setBounds(120, 95, 60, 25);
		contentPane.add(txtcodigoingresos);
		txtcodigoingresos.setColumns(10);
		
		txtingresosedicion = new JTextField();
		txtingresosedicion.setEditable(true);
		txtingresosedicion.setBounds(212, 145, 180, 25);
		contentPane.add(txtingresosedicion);
		txtingresosedicion.setColumns(10);
		
		txtingresospublicidad = new JTextField();
		txtingresospublicidad.setEditable(true);
		txtingresospublicidad.setBounds(212, 195, 180, 25);
		contentPane.add(txtingresospublicidad);
		txtingresospublicidad.setColumns(10);
		
		txtingresospublicidadgobierno = new JTextField();
		txtingresospublicidadgobierno.setBounds(256, 247, 136, 25);
		contentPane.add(txtingresospublicidadgobierno);
		txtingresospublicidadgobierno.setColumns(10);
		
		txtingresosotrosservicios = new JTextField();
		txtingresosotrosservicios.setBounds(223, 295, 169, 25);
		contentPane.add(txtingresosotrosservicios);
		txtingresosotrosservicios.setColumns(10);
		
		txttotalingresos = new JTextField();
		txttotalingresos.setBounds(185, 347, 207, 25);
		txttotalingresos.setEditable(false);
		contentPane.add(txttotalingresos);
		txttotalingresos.setColumns(10);
		
		txtdescripcioningresos = new JTextField();
		txtdescripcioningresos.setBounds(185, 395, 207, 74);
		contentPane.add(txtdescripcioningresos);
		txtdescripcioningresos.setColumns(10);
		
		JButton btnguardaringresos = new JButton("GUARDAR");
		btnguardaringresos.setBackground(new Color(0, 128, 0));
		btnguardaringresos.setForeground(new Color(0, 0, 0));
		btnguardaringresos.setBounds(42, 476, 118, 23);
		contentPane.add(btnguardaringresos);
		
		
		
		
		
		
	}
}
