package diseño.television;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
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
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBounds(27, 40, 347, 391);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnNuevoCargo = new JButton("NUEVO");
		btnNuevoCargo.setBounds(78, 327, 99, 23);
		panel.add(btnNuevoCargo);
		btnNuevoCargo.setBackground(new Color(0, 128, 0));
		
		btnBorrarCargo = new JButton("Borrar");
		btnBorrarCargo.setBounds(186, 327, 99, 23);
		panel.add(btnBorrarCargo);
		btnBorrarCargo.setBackground(Color.RED);
		
		
		btnActualizarCargo = new JButton("Actualizar");
		btnActualizarCargo.setBounds(186, 297, 99, 23);
		panel.add(btnActualizarCargo);
		btnActualizarCargo.setBackground(new Color(0, 128, 0));
		
		btnGuardarCargo = new JButton("GUARDAR");
		btnGuardarCargo.setBounds(78, 297, 99, 23);
		panel.add(btnGuardarCargo);
		btnGuardarCargo.setBackground(new Color(0, 128, 0));
		
		JLabel lblHoraExtraCargo = new JLabel("4. Valor hora extra :");
		lblHoraExtraCargo.setBounds(43, 166, 120, 22);
		panel.add(lblHoraExtraCargo);
		
		txtHoraExtraCargo = new JTextField();
		txtHoraExtraCargo.setBounds(147, 166, 165, 20);
		panel.add(txtHoraExtraCargo);
		txtHoraExtraCargo.setColumns(10);
		
		txtSueldoCargo = new JTextField();
		txtSueldoCargo.setBounds(147, 198, 165, 20);
		panel.add(txtSueldoCargo);
		txtSueldoCargo.setColumns(10);
		
		JLabel lblSueldoCargo = new JLabel("5. Sueldo :");
		lblSueldoCargo.setBounds(43, 201, 100, 23);
		panel.add(lblSueldoCargo);
		
		txtNombreCargo = new JTextField();
		txtNombreCargo.setBounds(147, 135, 165, 20);
		panel.add(txtNombreCargo);
		txtNombreCargo.setColumns(10);
		
		JLabel lblNombreCargo = new JLabel("3. Nombre cargo:");
		lblNombreCargo.setBounds(43, 138, 100, 14);
		panel.add(lblNombreCargo);
		
		JLabel lblTipoDeCargo = new JLabel("2. Tipo de cargo :");
		lblTipoDeCargo.setBounds(43, 98, 105, 29);
		panel.add(lblTipoDeCargo);
		
		 txtCodigoCargo = new JTextField();
		 txtCodigoCargo.setEditable(false);
		 txtCodigoCargo.setBounds(147, 71, 28, 18);
		 panel.add(txtCodigoCargo);
		 txtCodigoCargo.setColumns(10);
		 
		 JLabel lblCodigoCargo = new JLabel("1. Codigo :");
		 lblCodigoCargo.setBounds(43, 73, 63, 14);
		 panel.add(lblCodigoCargo);
		 
		 JLabel lblRegistroCargos = new JLabel(" REGISTRO DE CARGOS");
		 lblRegistroCargos.setBounds(105, 45, 136, 23);
		 panel.add(lblRegistroCargos);
		 lblRegistroCargos.setFont(new Font("Tahoma", Font.BOLD, 11));
		 
		 txtTipoDeCargo = new JTextField();
		 txtTipoDeCargo.setColumns(10);
		 txtTipoDeCargo.setBounds(147, 102, 165, 20);
		 panel.add(txtTipoDeCargo);
		 
		 JLabel lblFuncionesCargo = new JLabel("6. Funciones :");
		 lblFuncionesCargo.setBounds(43, 237, 76, 14);
		 panel.add(lblFuncionesCargo);
		 
		 txtFunsionesCargo = new JTextField();
		 txtFunsionesCargo.setBounds(147, 229, 165, 57);
		 panel.add(txtFunsionesCargo);
		 txtFunsionesCargo.setColumns(10);
		 
		 JLabel lblImagenLibreta = new JLabel();
		 lblImagenLibreta.setBounds(0, 0, 347, 391);
		 panel.add(lblImagenLibreta);
		 final ImageIcon icono = new ImageIcon(getClass().getResource("/material/television/libreta.png"));
		 final ImageIcon logo = new ImageIcon(icono.getImage().getScaledInstance(lblImagenLibreta.getWidth(), lblImagenLibreta.getHeight(), Image.SCALE_DEFAULT));
		 lblImagenLibreta.setIcon(logo);
		 
		

		
		
		
		
		
		
	}
}
