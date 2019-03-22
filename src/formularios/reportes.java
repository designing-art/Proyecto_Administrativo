package formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Window.Type;

public class reportes extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reportes frame = new reportes();
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
	public reportes() {
		setResizable(false);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 600, 750);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 108, 533, 552);
		contentPane.add(scrollPane);
		
		JLabel Reportes = new JLabel("Reportes");
		Reportes.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		Reportes.setBounds(10, 12, 81, 28);
		contentPane.add(Reportes);
		
		JLabel lblCanalCoffee = new JLabel("CANAL 40 COFFEE TV CHANNEL");
		lblCanalCoffee.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		lblCanalCoffee.setBounds(160, 26, 290, 14);
		contentPane.add(lblCanalCoffee);
		
		JLabel lblElParaisoEl = new JLabel("El Paraiso, El Paraiso");
		lblElParaisoEl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblElParaisoEl.setBounds(214, 51, 172, 14);
		contentPane.add(lblElParaisoEl);
		
		JLabel lblSeleccioneElTipo = new JLabel("Tipo de reporte :");
		lblSeleccioneElTipo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblSeleccioneElTipo.setBounds(23, 70, 151, 27);
		contentPane.add(lblSeleccioneElTipo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(148, 77, 144, 20);
		contentPane.add(comboBox);
		
		JLabel lblBuscar = new JLabel("Buscar :");
		lblBuscar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblBuscar.setBounds(302, 77, 151, 20);
		contentPane.add(lblBuscar);
		
		textField = new JTextField();
		textField.setBounds(368, 77, 190, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("00/00/000");
		label.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		label.setBounds(481, 19, 81, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("00:00");
		label_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		label_1.setBounds(491, 40, 49, 14);
		contentPane.add(label_1);
		
		JButton btnNewButton = new JButton("Imprimir");
		btnNewButton.setBackground(new Color(0, 128, 0));
		btnNewButton.setBounds(469, 671, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(0, 139, 139));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana_principal vp = new ventana_principal();
				vp.setVisible(true);
				vp.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnCancelar.setBounds(25, 671, 89, 23);
		contentPane.add(btnCancelar);
	}
}
