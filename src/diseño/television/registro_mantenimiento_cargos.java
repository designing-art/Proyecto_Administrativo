package diseño.television;

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
import javax.swing.border.MatteBorder;

public class registro_mantenimiento_cargos extends JFrame {
	
	 public JTextField txtCodigoCargo ;
	 public JTextField txtNombreCargo;
	 public JTextField txtTipoDeCargo;
	 public JTextField txtFunsionesCargo ;
	 public JTextField txtSueldoCargo ;
	 public JTextField txtsueldoCargo ;
	 public JTextField txtHoraExtraCargo ;
	 
	 public JButton btnGuardarCargo;
	 public JButton btnActualizarCargo;
	 public JButton btnNuevoCargo;
	 public JButton btnBorrarCargo;
	
	 public JPanel contentPane;
	 public JTextField txtBusquedaCargo;
	 public JButton btnBuscarCargo;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registro_mantenimiento_cargos frame = new registro_mantenimiento_cargos();
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
	public registro_mantenimiento_cargos() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBounds(173, 26, 346, 349);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnNuevoCargo = new JButton("NUEVO");
		btnNuevoCargo.setBounds(118, 287, 99, 23);
		panel.add(btnNuevoCargo);
		btnNuevoCargo.setBackground(new Color(0, 128, 0));
		
		btnBorrarCargo = new JButton("Borrar");
		btnBorrarCargo.setBounds(226, 287, 99, 23);
		panel.add(btnBorrarCargo);
		btnBorrarCargo.setBackground(Color.RED);
		
		
		btnActualizarCargo = new JButton("Actualizar");
		btnActualizarCargo.setBounds(226, 257, 99, 23);
		panel.add(btnActualizarCargo);
		btnActualizarCargo.setBackground(new Color(0, 128, 0));
		
		btnGuardarCargo = new JButton("GUARDAR");
		btnGuardarCargo.setBounds(118, 257, 99, 23);
		panel.add(btnGuardarCargo);
		btnGuardarCargo.setBackground(new Color(0, 128, 0));
		
		JLabel lblHoraExtraCargo = new JLabel("Valor hora extra :");
		lblHoraExtraCargo.setBounds(15, 137, 120, 14);
		panel.add(lblHoraExtraCargo);
		
		txtHoraExtraCargo = new JTextField();
		txtHoraExtraCargo.setBounds(118, 134, 207, 20);
		panel.add(txtHoraExtraCargo);
		txtHoraExtraCargo.setColumns(10);
		
		txtSueldoCargo = new JTextField();
		txtSueldoCargo.setBounds(118, 162, 207, 20);
		panel.add(txtSueldoCargo);
		txtSueldoCargo.setColumns(10);
		
		JLabel lblSueldoCargo = new JLabel("Sueldo :");
		lblSueldoCargo.setBounds(15, 162, 100, 14);
		panel.add(lblSueldoCargo);
		
		txtNombreCargo = new JTextField();
		txtNombreCargo.setBounds(118, 106, 207, 20);
		panel.add(txtNombreCargo);
		txtNombreCargo.setColumns(10);
		
		JLabel lblNombreCargo = new JLabel("Nombre cargo:");
		lblNombreCargo.setBounds(15, 112, 100, 14);
		panel.add(lblNombreCargo);
		
		JLabel lblTipoDeCargo = new JLabel("Tipo de cargo :");
		lblTipoDeCargo.setBounds(15, 82, 105, 14);
		panel.add(lblTipoDeCargo);
		
		 txtCodigoCargo = new JTextField();
		 txtCodigoCargo.setBounds(118, 54, 28, 20);
		 panel.add(txtCodigoCargo);
		 txtCodigoCargo.setColumns(10);
		 
		 JLabel lblCodigoCargo = new JLabel("Codigo :");
		 lblCodigoCargo.setBounds(15, 57, 63, 14);
		 panel.add(lblCodigoCargo);
		 
		 JLabel lblRegistroCargos = new JLabel(" REGISTRO DE CARGOS");
		 lblRegistroCargos.setBounds(10, 11, 136, 28);
		 panel.add(lblRegistroCargos);
		 lblRegistroCargos.setFont(new Font("Tahoma", Font.BOLD, 11));
		 
		 txtTipoDeCargo = new JTextField();
		 txtTipoDeCargo.setColumns(10);
		 txtTipoDeCargo.setBounds(118, 79, 207, 20);
		 panel.add(txtTipoDeCargo);
		 
		 JLabel lblFuncionesCargo = new JLabel("Funciones :");
		 lblFuncionesCargo.setBounds(15, 187, 76, 14);
		 panel.add(lblFuncionesCargo);
		 
		 txtFunsionesCargo = new JTextField();
		 txtFunsionesCargo.setBounds(118, 190, 207, 56);
		 panel.add(txtFunsionesCargo);
		 txtFunsionesCargo.setColumns(10);
		 
		 txtBusquedaCargo = new JTextField();
		 txtBusquedaCargo.setColumns(10);
		 txtBusquedaCargo.setBounds(295, 383, 116, 20);
		 contentPane.add(txtBusquedaCargo);
		 
		 btnBuscarCargo = new JButton("Buscar");
		 btnBuscarCargo.setBackground(new Color(0, 128, 0));
		 btnBuscarCargo.setBounds(421, 382, 99, 23);
		 contentPane.add(btnBuscarCargo);
		 
		 JLabel lblBuscarPorCodigo = new JLabel("Buscar por codigo :");
		 lblBuscarPorCodigo.setBounds(173, 386, 138, 14);
		 contentPane.add(lblBuscarPorCodigo);
		
		

		
		
		
		
		
		
	}
}
