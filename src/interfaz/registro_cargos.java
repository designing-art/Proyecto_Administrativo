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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class registro_cargos extends JFrame {
	private JTextField txtcodigoCargo ;
	private JTextField txttipoCargo ;
	private JTextField txtfuncionesCargo ;
	private JTextField txtsueldoCargo ;
	private JTextField txthoraExtraCargo ;
	
	
	
	

	private JPanel contentPane;
	private JTextField textField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registro_cargos frame = new registro_cargos();
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
	public registro_cargos() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistroCargos = new JLabel(" REGISTRO DE CARGOS");
		lblRegistroCargos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRegistroCargos.setBounds(275, 45, 136, 28);
		contentPane.add(lblRegistroCargos);
		
		JLabel lblCodigoCargo = new JLabel("Codigo :");
		lblCodigoCargo.setBounds(201, 84, 63, 14);
		contentPane.add(lblCodigoCargo);
		
		JLabel lblTipoDeCargo = new JLabel("Tipo de Cargo :");
		lblTipoDeCargo.setBounds(201, 109, 105, 14);
		contentPane.add(lblTipoDeCargo);
		
		JLabel lblFuncionesCargo = new JLabel("Funciones :");
		lblFuncionesCargo.setBounds(201, 164, 76, 14);
		contentPane.add(lblFuncionesCargo);
		
		JLabel lblSueldoCargo = new JLabel("Sueldo :");
		lblSueldoCargo.setBounds(201, 231, 100, 14);
		contentPane.add(lblSueldoCargo);
		
		JLabel lblHoraExtraCargo = new JLabel("Valor Hora Extra :");
		lblHoraExtraCargo.setBounds(201,256, 120, 14);
		contentPane.add(lblHoraExtraCargo);
		
		 txtcodigoCargo = new JTextField();
		txtcodigoCargo.setEditable(false);
		txtcodigoCargo.setBounds(304, 81, 28, 20);
		contentPane.add(txtcodigoCargo);
		txtcodigoCargo.setColumns(10);
		
		txttipoCargo = new JTextField();
		txttipoCargo.setBounds(304,164 , 186, 56);
		contentPane.add(txttipoCargo);
		txttipoCargo.setColumns(10);
		
		txtfuncionesCargo = new JTextField();
		txtfuncionesCargo.setBounds(304,228 , 186, 20);
		contentPane.add(txtfuncionesCargo);
		txtfuncionesCargo.setColumns(10);
		
		txthoraExtraCargo = new JTextField();
		txthoraExtraCargo.setBounds(304,253 , 186, 20);
		contentPane.add(txthoraExtraCargo);
		txthoraExtraCargo.setColumns(10);
		
		
		JButton btnCancelarCargo = new JButton("ACTUALIZAR");
		btnCancelarCargo.setBackground(new Color(0, 128, 0));
		btnCancelarCargo.setBounds(201, 333, 99, 23);
		contentPane.add(btnCancelarCargo);
		
		JButton btnGuardarCargo = new JButton("GUARDAR");
		btnGuardarCargo.setBackground(new Color(0, 128, 0));
		btnGuardarCargo.setBounds(201, 299, 99, 23);
		contentPane.add(btnGuardarCargo);
		
		
		JButton btnNuevoCargo = new JButton("NUEVO");
		btnNuevoCargo.setBackground(new Color(0, 128, 0));
		btnNuevoCargo.setBounds(304, 299, 99, 23);
		contentPane.add(btnNuevoCargo);
		
		JButton btnActualizarCargo = new JButton("SALIR");
		btnActualizarCargo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnActualizarCargo.setBackground(Color.RED);
		btnActualizarCargo.setBounds(304, 333, 99, 23);
		contentPane.add(btnActualizarCargo);
		
		
	
		JComboBox comboBoxtipoCargo = new JComboBox();
		comboBoxtipoCargo.setBounds(304, 106, 186, 20);
		contentPane.add(comboBoxtipoCargo);
		
		JLabel lblNombreCargo = new JLabel("Nombre Cargo:");
		lblNombreCargo.setBounds(201, 139, 76, 14);
		contentPane.add(lblNombreCargo);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(304, 133, 186, 20);
		contentPane.add(textField);
		
		

		
		
		
		
		
		
	}
}
