package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;

public class sar extends JFrame {

	private JPanel contentPane;
	private JTextField txtidsar;
	private JTextField txtcai;
	private JTextField txtrangoinicial;
	private JTextField txtrangofinal;
	private JTextField txtfechalimite;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sar frame = new sar();
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
	public sar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 432, 538);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblsar = new JLabel("SAR");
		lblsar.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblsar.setHorizontalAlignment(SwingConstants.CENTER);
		lblsar.setBounds(188, 23, 46, 14);
		contentPane.add(lblsar);
		
		JLabel lblIdSar = new JLabel("ID SAR:");
		lblIdSar.setBounds(25, 66, 46, 14);
		contentPane.add(lblIdSar);
		
		txtidsar = new JTextField();
		txtidsar.setEditable(false);
		txtidsar.setBounds(156, 63, 65, 20);
		contentPane.add(txtidsar);
		txtidsar.setColumns(10);
		
		JLabel lblCai = new JLabel("CAI:");
		lblCai.setBounds(25, 129, 46, 14);
		contentPane.add(lblCai);
		
		txtcai = new JTextField();
		txtcai.setBounds(156, 126, 156, 20);
		contentPane.add(txtcai);
		txtcai.setColumns(10);
		
		JLabel lblRangoInicial = new JLabel("Rango Inicial:");
		lblRangoInicial.setBounds(25, 201, 86, 14);
		contentPane.add(lblRangoInicial);
		
		txtrangoinicial = new JTextField();
		txtrangoinicial.setBounds(156, 198, 156, 20);
		contentPane.add(txtrangoinicial);
		txtrangoinicial.setColumns(10);
		
		JLabel lblRangoFinal = new JLabel("Rango Final:");
		lblRangoFinal.setBounds(25, 277, 74, 14);
		contentPane.add(lblRangoFinal);
		
		txtrangofinal = new JTextField();
		txtrangofinal.setBounds(156, 274, 156, 20);
		contentPane.add(txtrangofinal);
		txtrangofinal.setColumns(10);
		
		JLabel lblFechaLimite = new JLabel("Fecha limite:");
		lblFechaLimite.setBounds(25, 349, 74, 14);
		contentPane.add(lblFechaLimite);
		
		txtfechalimite = new JTextField();
		txtfechalimite.setBounds(156, 346, 156, 20);
		contentPane.add(txtfechalimite);
		txtfechalimite.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(new Color(0, 128, 0));
		btnGuardar.setBounds(25, 425, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBackground(new Color(0, 128, 0));
		btnEditar.setBounds(162, 425, 89, 23);
		contentPane.add(btnEditar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBackground(Color.RED);
		btnSalir.setBounds(293, 425, 89, 23);
		contentPane.add(btnSalir);
		
		
	}
}
