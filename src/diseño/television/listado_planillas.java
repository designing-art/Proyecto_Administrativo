package diseño.television;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class listado_planillas extends JFrame {

	private JPanel contentPane;
	private JTable tablaplanillas;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					listado_planillas frame = new listado_planillas();
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
	public listado_planillas() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPlanillasCreadas = new JLabel("PLANILLAS");
		lblPlanillasCreadas.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPlanillasCreadas.setBounds(301, 21, 90, 28);
		contentPane.add(lblPlanillasCreadas);
		
		tablaplanillas = new JTable();
		tablaplanillas.setBackground(Color.LIGHT_GRAY);
		tablaplanillas.setBounds(63, 87, 570, 261);
		contentPane.add(tablaplanillas);
		
		JButton btnNuevaPlanilla = new JButton("CREAR PLANILLA");
		btnNuevaPlanilla.setBackground(new Color(0, 128, 0));
		btnNuevaPlanilla.setBounds(63, 361, 141, 23);
		contentPane.add(btnNuevaPlanilla);
		
		JButton button_3 = new JButton("SALIR");
		button_3.setBackground(Color.RED);
		button_3.setBounds(534, 359, 99, 23);
		contentPane.add(button_3);
		
		JLabel lblListaDePlanillas = new JLabel("Lista de planillas creadas :");
		lblListaDePlanillas.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblListaDePlanillas.setBounds(63, 62, 176, 14);
		contentPane.add(lblListaDePlanillas);
		
		JLabel lblBuscarPor = new JLabel("Buscar por : ");
		lblBuscarPor.setBounds(236, 62, 66, 14);
		contentPane.add(lblBuscarPor);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(311, 56, 125, 20);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(446, 56, 187, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
