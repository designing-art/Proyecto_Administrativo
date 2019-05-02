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
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class registro_ingresos extends JFrame {

	private JTextField txtcodigoingresos;
	private JTextField txtingresosedicion;
	private JTextField txttotalingresos;
	private JTextField txtdescripcioningresos;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					registro_ingresos frame = new registro_ingresos();
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
	public registro_ingresos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 545);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblIngresos = new JLabel("INGRESOS");
		lblIngresos.setBounds(262, 53, 147, 40);
		lblIngresos.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresos.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblIngresos);

		JLabel lblCodigoIngresos = new JLabel("Codigo Ingresos : ");
		lblCodigoIngresos.setBounds(144, 132, 150, 14);
		contentPane.add(lblCodigoIngresos);

		JLabel lblIngresosPorEdicion = new JLabel("Tipo de Ingresos : ");
		lblIngresosPorEdicion.setBounds(144, 181, 180, 14);
		contentPane.add(lblIngresosPorEdicion);

		JLabel lblCantidadIngresos = new JLabel("Cantidad de Ingresos :  L.");
		lblCantidadIngresos.setBounds(142, 228, 280, 14);
		contentPane.add(lblCantidadIngresos);

		JLabel lblDescripcionIngresos = new JLabel("Descripcion de Ingresos :");
		lblDescripcionIngresos.setBounds(142, 271, 320, 14);
		contentPane.add(lblDescripcionIngresos);

		txtcodigoingresos = new JTextField();
		txtcodigoingresos.setBounds(349, 127, 60, 25);
		txtcodigoingresos.setEditable(false);
		contentPane.add(txtcodigoingresos);
		txtcodigoingresos.setColumns(10);

		txtingresosedicion = new JTextField();
		txtingresosedicion.setBounds(348, 176, 180, 25);
		txtingresosedicion.setEditable(true);
		contentPane.add(txtingresosedicion);
		txtingresosedicion.setColumns(10);

		txttotalingresos = new JTextField();
		txttotalingresos.setBounds(348, 223, 180, 25);
		txttotalingresos.setEditable(false);
		contentPane.add(txttotalingresos);
		txttotalingresos.setColumns(10);

		txtdescripcioningresos = new JTextField();
		txtdescripcioningresos.setBounds(348, 271, 180, 74);
		contentPane.add(txtdescripcioningresos);
		txtdescripcioningresos.setColumns(10);

		JButton btnNuevo = new JButton("NUEVO");
		btnNuevo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNuevo.setBounds(349, 395, 117, 23);
		btnNuevo.setBackground(new Color(0, 128, 0));
		contentPane.add(btnNuevo);

		JButton btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.setBounds(195, 437, 117, 23);
		btnActualizar.setBackground(Color.RED);
		contentPane.add(btnActualizar);

		JButton btnSalir = new JButton("SALIR");
		btnSalir.setBounds(349, 437, 120, 23);
		contentPane.add(btnSalir);

		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.setBounds(195, 395, 117, 23);
		contentPane.add(btnGuardar);

	}
}
