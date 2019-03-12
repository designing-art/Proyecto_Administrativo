package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class registro_mantenimiento_contratos extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registro_mantenimiento_contratos frame = new registro_mantenimiento_contratos();
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
	public registro_mantenimiento_contratos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistrarContratos = new JLabel("REGISTRAR CONTRATOS");
		lblRegistrarContratos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRegistrarContratos.setBounds(263, 34, 147, 28);
		contentPane.add(lblRegistrarContratos);
		
		JLabel lblTipoDeContrato = new JLabel("Tipo de contrato :");
		lblTipoDeContrato.setBounds(169, 73, 113, 14);
		contentPane.add(lblTipoDeContrato);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(285, 70, 213, 20);
		contentPane.add(comboBox);
		
		JLabel lblTiempoDelContrato = new JLabel("Tiempo del contrato :");
		lblTiempoDelContrato.setBounds(169, 104, 113, 14);
		contentPane.add(lblTiempoDelContrato);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(285, 101, 213, 20);
		contentPane.add(comboBox_1);
		
		JLabel label = new JLabel("Fotografia :");
		label.setBounds(169, 129, 93, 14);
		contentPane.add(label);
		
		JPanel panel = new JPanel();
		panel.setBounds(282, 133, 216, 217);
		contentPane.add(panel);
		
		JButton button = new JButton("Subir");
		button.setBounds(169, 154, 76, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("GUARDAR");
		button_1.setBackground(new Color(0, 128, 0));
		button_1.setBounds(284, 361, 99, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("NUEVO");
		button_2.setBackground(new Color(0, 128, 0));
		button_2.setBounds(399, 361, 99, 23);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("ACTUALIZAR");
		button_3.setBackground(new Color(0, 128, 0));
		button_3.setBounds(284, 395, 99, 23);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("SALIR");
		button_4.setBackground(Color.RED);
		button_4.setBounds(399, 395, 99, 23);
		contentPane.add(button_4);
	}
}
