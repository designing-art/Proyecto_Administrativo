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
	 private JLabel lblNewLabel;
	 private JLabel label;
	 private JTextField textField;
	 private JTextField textField_1;
	 private JTextField textField_2;
	 private JTextField textField_3;
	 private JTextField textField_4;
	 private JTextField textField_5;
	
	

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
		 
		 JLabel lblImagenLibretaRegistro = new JLabel();
		 lblImagenLibretaRegistro.setBounds(0, 0, 347, 391);
		 panel.add(lblImagenLibretaRegistro);
		 final ImageIcon icono = new ImageIcon(getClass().getResource("/material/television/libreta.png"));
		 final ImageIcon logo = new ImageIcon(icono.getImage().getScaledInstance(lblImagenLibretaRegistro.getWidth(), lblImagenLibretaRegistro.getHeight(), Image.SCALE_DEFAULT));
		 lblImagenLibretaRegistro.setIcon(logo);
		 
		 JPanel panel_1 = new JPanel();
		 panel_1.setLayout(null);
		 panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		 panel_1.setBounds(387, 40, 347, 391);
		 contentPane.add(panel_1);
		 
		 JLabel labelImagenLibretaLista = new JLabel();
		 labelImagenLibretaLista.setBounds(0, 0, 347, 391);
		 panel_1.add(labelImagenLibretaLista);
		 final ImageIcon iconolista = new ImageIcon(getClass().getResource("/material/television/libreta.png"));
		 final ImageIcon logolista = new ImageIcon(iconolista.getImage().getScaledInstance(labelImagenLibretaLista.getWidth(), labelImagenLibretaLista.getHeight(), Image.SCALE_DEFAULT));
		 lblImagenLibretaRegistro.setIcon(logolista);
		 
		 JButton button = new JButton("NUEVO");
		 button.setBackground(new Color(0, 128, 0));
		 button.setBounds(78, 327, 99, 23);
		 panel_1.add(button);
		 
		 JButton button_1 = new JButton("Borrar");
		 button_1.setBackground(Color.RED);
		 button_1.setBounds(186, 327, 99, 23);
		 panel_1.add(button_1);
		 
		 JButton button_2 = new JButton("Actualizar");
		 button_2.setBackground(new Color(0, 128, 0));
		 button_2.setBounds(186, 297, 99, 23);
		 panel_1.add(button_2);
		 
		 JButton button_3 = new JButton("GUARDAR");
		 button_3.setBackground(new Color(0, 128, 0));
		 button_3.setBounds(78, 297, 99, 23);
		 panel_1.add(button_3);
		 
		 JLabel label_1 = new JLabel("4. Valor hora extra :");
		 label_1.setBounds(43, 166, 120, 22);
		 panel_1.add(label_1);
		 
		 textField = new JTextField();
		 textField.setColumns(10);
		 textField.setBounds(147, 166, 165, 20);
		 panel_1.add(textField);
		 
		 textField_1 = new JTextField();
		 textField_1.setColumns(10);
		 textField_1.setBounds(147, 198, 165, 20);
		 panel_1.add(textField_1);
		 
		 JLabel label_2 = new JLabel("5. Sueldo :");
		 label_2.setBounds(43, 201, 100, 23);
		 panel_1.add(label_2);
		 
		 textField_2 = new JTextField();
		 textField_2.setColumns(10);
		 textField_2.setBounds(147, 135, 165, 20);
		 panel_1.add(textField_2);
		 
		 JLabel label_3 = new JLabel("3. Nombre cargo:");
		 label_3.setBounds(43, 138, 100, 14);
		 panel_1.add(label_3);
		 
		 JLabel label_4 = new JLabel("2. Tipo de cargo :");
		 label_4.setBounds(43, 98, 105, 29);
		 panel_1.add(label_4);
		 
		 textField_3 = new JTextField();
		 textField_3.setEditable(false);
		 textField_3.setColumns(10);
		 textField_3.setBounds(147, 71, 28, 18);
		 panel_1.add(textField_3);
		 
		 JLabel label_5 = new JLabel("1. Codigo :");
		 label_5.setBounds(43, 73, 63, 14);
		 panel_1.add(label_5);
		 
		 JLabel label_6 = new JLabel(" REGISTRO DE CARGOS");
		 label_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		 label_6.setBounds(105, 45, 136, 23);
		 panel_1.add(label_6);
		 
		 textField_4 = new JTextField();
		 textField_4.setColumns(10);
		 textField_4.setBounds(147, 102, 165, 20);
		 panel_1.add(textField_4);
		 
		 JLabel label_7 = new JLabel("6. Funciones :");
		 label_7.setBounds(43, 237, 76, 14);
		 panel_1.add(label_7);
		 
		 textField_5 = new JTextField();
		 textField_5.setColumns(10);
		 textField_5.setBounds(147, 229, 165, 57);
		 panel_1.add(textField_5);
		 
		 
		

		
		
		
		
		
		
	}
}
