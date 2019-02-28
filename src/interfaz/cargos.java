package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

public class cargos extends JFrame {
	private JTextField txtcodigoCargo ;
	private JTextField txttipoCargo ;
	private JTextField txtfuncionesCargo ;
	private JTextField txtsueldoCargo ;
	private JTextField txthoraExtraCargo ;
	
	
	
	

	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cargos frame = new cargos();
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
	public cargos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 538);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistroCargos = new JLabel(" REGISTRO Y MANTENIMIENTO DE CARGOS");
		lblRegistroCargos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRegistroCargos.setBounds(170, 11, 147, 28);
		contentPane.add(lblRegistroCargos);
		
		JLabel lblCodigoCargo = new JLabel("Codigo :");
		lblCodigoCargo.setBounds(10, 69, 63, 14);
		contentPane.add(lblCodigoCargo);
		
		JLabel lblTipoDeCargo = new JLabel("Tipo de Cargo :");
		lblTipoDeCargo.setBounds(10, 120, 100, 14);
		contentPane.add(lblTipoDeCargo);
		
		JLabel lblFuncionesCargo = new JLabel("Funciones :");
		lblFuncionesCargo.setBounds(10, 173, 100, 14);
		contentPane.add(lblFuncionesCargo);
		
		JLabel lblSueldoCargo = new JLabel("Sueldo :");
		lblSueldoCargo.setBounds(10, 220, 100, 14);
		contentPane.add(lblSueldoCargo);
		
		JLabel lblHoraExtraCargo = new JLabel("Valor Hora Extra :");
		lblHoraExtraCargo.setBounds(10,270, 120, 14);
		contentPane.add(lblHoraExtraCargo);
		
		 txtcodigoCargo = new JTextField();
		txtcodigoCargo.setEditable(false);
		txtcodigoCargo.setBounds(75, 66, 28, 20);
		contentPane.add(txtcodigoCargo);
		txtcodigoCargo.setColumns(10);
		
		txttipoCargo = new JTextField();
		txttipoCargo.setBounds(120,170 , 186, 20);
		contentPane.add(txttipoCargo);
		txttipoCargo.setColumns(10);
		
		txtfuncionesCargo = new JTextField();
		txtfuncionesCargo.setBounds(120,215 , 186, 20);
		contentPane.add(txtfuncionesCargo);
		txtfuncionesCargo.setColumns(10);
		
		txthoraExtraCargo = new JTextField();
		txthoraExtraCargo.setBounds(120,265 , 186, 20);
		contentPane.add(txthoraExtraCargo);
		txthoraExtraCargo.setColumns(10);
		
		
		JButton btnCancelarCargo = new JButton("CANCELAR");
		btnCancelarCargo.setBackground(new Color(0, 128, 0));
		btnCancelarCargo.setBounds(90, 310, 99, 23);
		contentPane.add(btnCancelarCargo);
		
		JButton btnGuardarCargo = new JButton("GUARDAR");
		btnGuardarCargo.setBackground(new Color(0, 128, 0));
		btnGuardarCargo.setBounds(210, 310, 99, 23);
		contentPane.add(btnGuardarCargo);
		
		
		JButton btnNuevoCargo = new JButton("NUEVO");
		btnNuevoCargo.setBackground(new Color(0, 128, 0));
		btnNuevoCargo.setBounds(90, 340, 99, 23);
		contentPane.add(btnNuevoCargo);
		
		JButton btnActualizarCargo = new JButton("ACTUALIZAR");
		btnActualizarCargo.setBackground(new Color(0, 128, 0));
		btnActualizarCargo.setBounds(210, 340, 99, 23);
		contentPane.add(btnActualizarCargo);
		
		
	
		JComboBox comboBoxtipoCargo = new JComboBox();
		comboBoxtipoCargo.setBounds(120, 120, 50, 20);
		contentPane.add(comboBoxtipoCargo);
		
		JLabel lblBuscarCargo = new JLabel("Buscar Por :");
		lblBuscarCargo.setBounds(10,380, 120, 14);
		contentPane.add(lblBuscarCargo);
		
		JComboBox comboBoxbuscarCargo = new JComboBox();
		comboBoxbuscarCargo.setBounds(120, 380, 50, 20);
		contentPane.add(comboBoxbuscarCargo);
		
		

		
		
		
		
		
		
	}
}
