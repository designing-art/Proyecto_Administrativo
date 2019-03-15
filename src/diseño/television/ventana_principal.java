package diseño.television;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Window.Type;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;

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
		setResizable(false);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCanalCoffee = new JLabel("CANAL 40 COFFEE TV CHANNEL");
		lblCanalCoffee.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 20));
		lblCanalCoffee.setBounds(419, 58, 180, 36);
		contentPane.add(lblCanalCoffee);
		
		JLabel btnEmpresa = new JLabel();
		btnEmpresa.setBounds(344, 89, 328, 323);
		contentPane.add(btnEmpresa);
		final ImageIcon logo = new ImageIcon(getClass().getResource("/iconos/logo.png"));
		final ImageIcon icono = new ImageIcon(logo.getImage().getScaledInstance(btnEmpresa.getWidth(), btnEmpresa.getHeight(), Image.SCALE_DEFAULT));
		btnEmpresa.setIcon(icono);
		
		
		JLabel lblMenu = new JLabel("Menu de opciones:");
		lblMenu.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 20));
		lblMenu.setBounds(118, 117, 121, 29);
		contentPane.add(lblMenu);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(182, 157, 150, 255);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnEmpleados = new JButton("Bonificaciones");
		btnEmpleados.setBounds(10, 11, 130, 23);
		panel_1.add(btnEmpleados);
		btnEmpleados.setBackground(Color.WHITE);
		
		JButton btnPlanillas = new JButton("Deducciones");
		btnPlanillas.setBounds(10, 45, 130, 23);
		panel_1.add(btnPlanillas);
		btnPlanillas.setBackground(Color.WHITE);
		
		JButton btnFacturas = new JButton("Cargos");
		btnFacturas.setBounds(10, 79, 130, 23);
		panel_1.add(btnFacturas);
		btnFacturas.setBackground(Color.WHITE);
		
		JButton btnContratos = new JButton("Contratos");
		btnContratos.setBounds(10, 113, 130, 23);
		panel_1.add(btnContratos);
		btnContratos.setBackground(Color.WHITE);
		
		JButton btnInvetario = new JButton("Invetario");
		btnInvetario.setBackground(Color.WHITE);
		btnInvetario.setBounds(10, 181, 130, 23);
		panel_1.add(btnInvetario);
		
		JButton btnFacturas_1 = new JButton("Facturas");
		btnFacturas_1.setBackground(Color.WHITE);
		btnFacturas_1.setBounds(10, 147, 130, 23);
		panel_1.add(btnFacturas_1);
		
		JButton btnSar = new JButton("SAR");
		btnSar.setBackground(Color.WHITE);
		btnSar.setBounds(10, 215, 130, 23);
		panel_1.add(btnSar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(21, 157, 150, 255);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton button_1 = new JButton("Empleados");
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(10, 11, 130, 23);
		panel_2.add(button_1);
		
		JButton btnCargos = new JButton("Clientes");
		btnCargos.setBounds(10, 45, 130, 23);
		panel_2.add(btnCargos);
		btnCargos.setBackground(Color.WHITE);
		
		JButton btnServicios = new JButton("Servicios");
		btnServicios.setBounds(10, 79, 130, 23);
		panel_2.add(btnServicios);
		btnServicios.setBackground(Color.WHITE);
		
		JButton btnIngresos = new JButton("Ingresos");
		btnIngresos.setBounds(10, 147, 130, 23);
		panel_2.add(btnIngresos);
		btnIngresos.setBackground(Color.WHITE);
		
		JButton btnEgresos = new JButton("Egresos");
		btnEgresos.setBounds(10, 181, 130, 23);
		panel_2.add(btnEgresos);
		btnEgresos.setBackground(Color.WHITE);
		
		JButton btnProductos = new JButton("Productos");
		btnProductos.setBounds(10, 113, 130, 23);
		panel_2.add(btnProductos);
		btnProductos.setBackground(Color.WHITE);
		
		JButton btnHorarios = new JButton("Horarios");
		btnHorarios.setBackground(Color.WHITE);
		btnHorarios.setBounds(10, 215, 130, 23);
		panel_2.add(btnHorarios);
		
		JLabel lblBienvenidoAlSistema = new JLabel("Bienvenido al sistema administrativo.");
		lblBienvenidoAlSistema.setFont(new Font("Berlin Sans FB", Font.BOLD, 20));
		lblBienvenidoAlSistema.setBounds(174, 11, 498, 36);
		contentPane.add(lblBienvenidoAlSistema);
		btnEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
	}
}
