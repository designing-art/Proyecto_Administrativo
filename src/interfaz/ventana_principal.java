package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class ventana_principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventana_principal frame = new ventana_principal();
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
	public ventana_principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 448);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCanalCoffee = new JLabel("CANAL 40 COFFEE TV CHANNEL");
		lblCanalCoffee.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 20));
		lblCanalCoffee.setBounds(254, 24, 180, 36);
		contentPane.add(lblCanalCoffee);
		
		JButton btnEmpleados = new JButton("Empleados");
		btnEmpleados.setBackground(Color.WHITE);
		btnEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEmpleados.setBounds(41, 158, 109, 23);
		contentPane.add(btnEmpleados);
		
		JButton btnNewButton = new JButton("Logo de la empresa");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setSelectedIcon(new ImageIcon("C:\\Users\\hp\\Documents\\Proyecto_Canal40\\Proyecto_Administrativo\\src\\archivos\\button.png"));
		btnNewButton.setBounds(192, 62, 311, 323);
		contentPane.add(btnNewButton);
		
		JButton btnPlanillas = new JButton("Planillas");
		btnPlanillas.setBackground(Color.WHITE);
		btnPlanillas.setBounds(41, 362, 109, 23);
		contentPane.add(btnPlanillas);
		
		JButton btnCargos = new JButton("Clientes");
		btnCargos.setBackground(Color.WHITE);
		btnCargos.setBounds(41, 192, 109, 23);
		contentPane.add(btnCargos);
		
		JLabel lblMenu = new JLabel("Menu de opciones:");
		lblMenu.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 20));
		lblMenu.setBounds(41, 126, 121, 29);
		contentPane.add(lblMenu);
		
		JButton btnServicios = new JButton("Servicios");
		btnServicios.setBackground(Color.WHITE);
		btnServicios.setBounds(41, 226, 109, 23);
		contentPane.add(btnServicios);
		
		JButton btnIngresos = new JButton("Ingresos");
		btnIngresos.setBackground(Color.WHITE);
		btnIngresos.setBounds(41, 260, 109, 23);
		contentPane.add(btnIngresos);
		
		JButton btnEgresos = new JButton("Egresos");
		btnEgresos.setBackground(Color.WHITE);
		btnEgresos.setBounds(41, 294, 109, 23);
		contentPane.add(btnEgresos);
		
		JButton btnFacturas = new JButton("Facturas");
		btnFacturas.setBackground(Color.WHITE);
		btnFacturas.setBounds(41, 328, 109, 23);
		contentPane.add(btnFacturas);
		
		JPanel panel = new JPanel();
		panel.setBounds(41, 11, 107, 92);
		contentPane.add(panel);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 11));
		lblUsuario.setBounds(80, 101, 36, 14);
		contentPane.add(lblUsuario);
	}
}
