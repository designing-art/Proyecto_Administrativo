package formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;

public class registro_bonificaciones extends JFrame {

	private JPanel contentPane;
	public JTextField txtCodigoBonificacion;
	public JTextField txtnombresBonificacion;
	public JTextField txtapellidosbonificacion;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
    public JTextField txtidentidadbonificacion;
	private JLabel label_1;
	private JComboBox comboBox;
	public JTextField txttipobonificacion;
	private JTable table;
	private JPanel panel;
	private JLabel label_6;
	private JTable table_1;
	private JLabel lblListaDeDeducciones;
	private JLabel lblTipo;
	private JLabel lblCantidad;
	public JTextField txtcantidadbonificacion;
	private JLabel lblObservacion;
	public JTextField txtobservacionbonificacion;
	private JLabel lblAgregarDeduccion;
	public JTextField txtTotalBonificacion;
	private JLabel lblTotalDeduciones;
	public JButton btnGuardarBonificacion;
	public JButton btnActualizarBonificacion;
	public JButton btnNuevaBonificacion;
	public JButton btnSalirBonificacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registro_bonificaciones frame = new registro_bonificaciones();
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
	public registro_bonificaciones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistrarDeducciones = new JLabel("REGISTRAR BONIFICACIONES");
		lblRegistrarDeducciones.setBounds(0, 11, 176, 28);
		lblRegistrarDeducciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrarDeducciones.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblRegistrarDeducciones);
		
		txtCodigoBonificacion= new JTextField();
		txtCodigoBonificacion.setBounds(75, 223, 186, 20);
		txtCodigoBonificacion.setColumns(10);
		contentPane.add(txtCodigoBonificacion);
		
		txtnombresBonificacion = new JTextField();
		txtnombresBonificacion.setBounds(75, 198, 186, 20);
		txtnombresBonificacion.setColumns(10);
		contentPane.add(txtnombresBonificacion);
		
		txtapellidosbonificacion = new JTextField();
		txtapellidosbonificacion.setBounds(75, 172, 28, 20);
		txtapellidosbonificacion.setEditable(false);
		txtapellidosbonificacion.setColumns(10);
		contentPane.add(txtapellidosbonificacion);
		
		JLabel lblDatosDelEmpleado = new JLabel("Datos del empleado :");
		lblDatosDelEmpleado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDatosDelEmpleado.setBounds(14, 147, 118, 14);
		contentPane.add(lblDatosDelEmpleado);
		
		label_2 = new JLabel("Nombres :");
		label_2.setBounds(14, 201, 63, 14);
		contentPane.add(label_2);
		
		label_3 = new JLabel("Apellidos :");
		label_3.setBounds(14, 226, 63, 14);
		contentPane.add(label_3);
		
		label_4 = new JLabel("Codigo :");
		label_4.setBounds(14, 175, 63, 14);
		contentPane.add(label_4);
		
		label_5 = new JLabel("Identidad :");
		label_5.setBounds(14, 254, 63, 14);
		contentPane.add(label_5);
		
		txtcantidadbonificacion = new JTextField();
		txtcantidadbonificacion.setBounds(75, 248, 186, 20);
		txtcantidadbonificacion.setColumns(10);
		contentPane.add(txtcantidadbonificacion);
		
		label_1 = new JLabel("Buscar empleado por : ");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(10, 36, 128, 27);
		contentPane.add(label_1);
		
		comboBox = new JComboBox();
		comboBox.setBounds(136, 39, 125, 20);
		contentPane.add(comboBox);
		
		txtobservacionbonificacion = new JTextField();
		txtobservacionbonificacion.setColumns(10);
		txtobservacionbonificacion.setBounds(271, 39, 141, 20);
		contentPane.add(txtobservacionbonificacion);
		
		table = new JTable();
		table.setBackground(Color.LIGHT_GRAY);
		table.setBounds(10, 71, 403, 68);
		contentPane.add(table);
		
		panel = new JPanel();
		panel.setBounds(293, 155, 120, 113);
		contentPane.add(panel);
		
		label_6 = new JLabel("Fotografia :");
		label_6.setBounds(234, 173, 206, 14);
		contentPane.add(label_6);
		
		table_1 = new JTable();
		table_1.setBackground(Color.LIGHT_GRAY);
		table_1.setBounds(423, 71, 251, 302);
		contentPane.add(table_1);
		
		lblListaDeDeducciones = new JLabel("Lista de bonificaciones : ");
		lblListaDeDeducciones.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblListaDeDeducciones.setBounds(422, 36, 146, 27);
		contentPane.add(lblListaDeDeducciones);
		
		lblTipo = new JLabel("Tipo :");
		lblTipo.setBounds(14, 306, 63, 14);
		contentPane.add(lblTipo);
		
		lblCantidad = new JLabel("Cantidad :");
		lblCantidad.setBounds(14, 331, 63, 14);
		contentPane.add(lblCantidad);
		
		txtidentidadbonificacion = new JTextField();
		txtidentidadbonificacion.setColumns(10);
		txtidentidadbonificacion.setBounds(87, 328, 207, 20);
		contentPane.add(txtidentidadbonificacion);
		
		lblObservacion = new JLabel("Observacion :");
		lblObservacion.setBounds(14, 359, 80, 14);
		contentPane.add(lblObservacion);
		
		txttipobonificacion = new JTextField();
		txttipobonificacion.setColumns(10);
		txttipobonificacion.setBounds(88, 353, 206, 39);
		contentPane.add(txttipobonificacion);
		
		lblAgregarDeduccion = new JLabel("Agregar bonificacion :");
		lblAgregarDeduccion.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAgregarDeduccion.setBounds(14, 281, 124, 14);
		contentPane.add(lblAgregarDeduccion);
		
		txtTotalBonificacion = new JTextField();
		txtTotalBonificacion.setEditable(false);
		txtTotalBonificacion.setColumns(10);
		txtTotalBonificacion.setBounds(423, 404, 251, 20);
		contentPane.add(txtTotalBonificacion);
		
		lblTotalDeduciones = new JLabel("Total bonificaciones :");
		lblTotalDeduciones.setBounds(423, 384, 127, 14);
		contentPane.add(lblTotalDeduciones);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(87, 303, 205, 20);
		contentPane.add(comboBox_1);
		
		btnGuardarBonificacion = new JButton("GUARDAR");
		btnGuardarBonificacion.setBackground(new Color(0, 128, 0));
		btnGuardarBonificacion.setBounds(87, 403, 99, 23);
		contentPane.add(btnGuardarBonificacion);
		
		btnNuevaBonificacion = new JButton("NUEVO");
		btnNuevaBonificacion.setBackground(new Color(0, 128, 0));
		btnNuevaBonificacion.setBounds(423, 427, 99, 23);
		contentPane.add(btnNuevaBonificacion);
		
		btnActualizarBonificacion = new JButton("ACTUALIZAR");
		btnActualizarBonificacion.setBackground(new Color(0, 128, 0));
		btnActualizarBonificacion.setBounds(195, 403, 99, 23);
		contentPane.add(btnActualizarBonificacion);
		
		btnSalirBonificacion = new JButton("SALIR");
		btnSalirBonificacion.setBackground(Color.RED);
		btnSalirBonificacion.setBounds(575, 427, 99, 23);
		contentPane.add(btnSalirBonificacion);
	}
}
