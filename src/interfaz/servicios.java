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

public class servicios extends JFrame {
	private JTextField txtidservicio;
	private JTextField txtduracionservicio;
	private JTextField txtprecioservicio;
	private JTextField txttomasservicio;
	private JTextField txttransmisionesservicio;
	private JTextField txtgrabacionesservicio;
	private JTextField txtpublicidadservicio;
	private JTextField txtdescripcionservicio;
	private JTextField txtgrabacioneventoservicio;
	private JTextField txtedicionservicio;
	private JTextField txtrecuperacionvhsservicio;


 JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					servicios frame = new servicios();
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
	public servicios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 671);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblRegistroservicios = new JLabel("REGISTRO DE SERVICIOS");
		lblRegistroservicios.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRegistroservicios.setBounds(170, 11, 147, 28);
		contentPane.add(lblRegistroservicios);
		
		
		
		JLabel lblidservicio = new JLabel("Codigo:");
		lblidservicio.setBounds(10, 69, 63, 14);
		contentPane.add(lblidservicio);
		
		JLabel lblduracionservicio = new JLabel("Duracion :");
		lblduracionservicio.setBounds(10, 120, 100, 14);
		contentPane.add(lblduracionservicio);
		
		JLabel lblprecioservicio = new JLabel("Precio :");
		lblprecioservicio.setBounds(10, 173, 100, 14);
		contentPane.add(lblprecioservicio);
		
		JLabel lbltomaservicio = new JLabel("Tomas :");
		lbltomaservicio.setBounds(10, 220, 100, 14);
		contentPane.add(lbltomaservicio);
		
		JLabel lbltransmisionservicio = new JLabel("Transmisiones :");
		lbltransmisionservicio.setBounds(10,270, 120, 14);
		contentPane.add(lbltransmisionservicio);
		
		JLabel lblgrabacionservicio = new JLabel("Grabaciones :");
		lblgrabacionservicio.setBounds(10,320, 120, 14);
		contentPane.add(lblgrabacionservicio);
		
		JLabel lblpublicidadservicio = new JLabel("Publicidad :");
		lblpublicidadservicio.setBounds(10,370, 120, 14);
		contentPane.add(lblpublicidadservicio);
		
		JLabel lbldescripcionservicio = new JLabel("Descripcion :");
		lbldescripcionservicio.setBounds(10,420, 120, 14);
		contentPane.add(lbldescripcionservicio);
		
		
		JLabel lblgrabacioneventoservicio = new JLabel("Grabacion de Eventos :");
		lblgrabacioneventoservicio.setBounds(10,470, 150, 14);
		contentPane.add(lblgrabacioneventoservicio);
		
		JLabel lbledicionservicio= new JLabel("Ediciones :");
		lbledicionservicio.setBounds(10,520, 120, 14);
		contentPane.add(lbledicionservicio);
		
		txtidservicio = new JTextField();
		txtidservicio.setEditable(false);
		txtidservicio.setBounds(190, 69, 28, 20);
		contentPane.add(txtidservicio);
		txtidservicio.setColumns(10);
		
		txtduracionservicio = new JTextField();
		txtduracionservicio.setBounds(190,120 , 100, 20);
		contentPane.add(txtduracionservicio);
		txtduracionservicio.setColumns(10);
		
		
		txtprecioservicio = new JTextField();
		txtprecioservicio.setBounds(190,173 , 100, 20);
		contentPane.add(txtprecioservicio);
		txtprecioservicio.setColumns(10);
		
		
		txttomasservicio = new JTextField();
		txttomasservicio.setBounds(190,220 , 100, 20);
		contentPane.add(txttomasservicio);
		txttomasservicio.setColumns(10);
		
		txttransmisionesservicio = new JTextField();
		txttransmisionesservicio.setBounds(190,270, 100, 20);
		contentPane.add(txttransmisionesservicio);
		txttransmisionesservicio.setColumns(10);
		
		txtgrabacionesservicio = new JTextField();
		txtgrabacionesservicio.setBounds(190,320, 100, 20);
		contentPane.add(txtgrabacionesservicio);
		txtgrabacionesservicio.setColumns(10);
		
		txtpublicidadservicio = new JTextField();
		txtpublicidadservicio.setBounds(190,370, 100, 20);
		contentPane.add(txtpublicidadservicio);
		txtpublicidadservicio.setColumns(10);
		
		txtrecuperacionvhsservicio = new JTextField();
		txtrecuperacionvhsservicio.setBounds(190,420, 100, 20);
		contentPane.add(txtrecuperacionvhsservicio);
		txtrecuperacionvhsservicio.setColumns(10);
		
		txtdescripcionservicio = new JTextField();
		txtdescripcionservicio.setBounds(190,470, 100, 20);
		contentPane.add(txtdescripcionservicio);
		txtdescripcionservicio.setColumns(10);
		
		txtgrabacioneventoservicio= new JTextField();
		txtgrabacioneventoservicio.setBounds(190,520, 100, 20);
		contentPane.add(txtgrabacioneventoservicio);
		txtgrabacioneventoservicio.setColumns(10);
		
		JButton button = new JButton("Guardar");
		button.setBackground(new Color(0, 128, 0));
		button.setBounds(10, 581, 89, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Editar");
		button_1.setBackground(new Color(0, 128, 0));
		button_1.setBounds(190, 581, 89, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Salir");
		button_2.setBackground(Color.RED);
		button_2.setBounds(371, 581, 89, 23);
		contentPane.add(button_2);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

