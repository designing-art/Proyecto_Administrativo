package formularios;

import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.RowFilter;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Timer;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import com.placeholder.PlaceHolder;

import conexion.conexion;
import controles.control_contrato_empleado;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class registro_empresa extends JFrame {
	public JScrollPane scrollFunciones;
	public PlaceHolder pista;
	public JButton btnActualizarContrato;

	public JPanel contentPane;

	public TableRowSorter<TableModel> trsfiltroCodigo;
	String filtroCodigo;

	public ImageIcon logopeq = new ImageIcon(getClass().getResource("/material/logo.png"));
	public ImageIcon icono = new ImageIcon(getClass().getResource("/material/libreta.png"));
	public ImageIcon icono2 = new ImageIcon(getClass().getResource("/material/libreta.png"));
	public ImageIcon iconoContrato = new ImageIcon(getClass().getResource("/material/contrato.png"));
	private JTextField textField;
	private JTextField txtNombreEmpresa;
	private JTextField textField_3;
	private JTextField textField_1;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_2;

	public registro_empresa() {
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 550);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnAtras = new JButton("Regresar");
		btnAtras.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnAtras.setBackground(new Color(255, 127, 80));
		btnAtras.setBounds(717, 10, 102, 23);
		contentPane.add(btnAtras);
		btnAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ventana_principal principal = new ventana_principal();
				principal.setVisible(true);
				principal.setLocationRelativeTo(null);
				dispose();
				Timer time = new Timer();
				time.schedule(principal.tarea, 0, 1000);
			}
		});

		JLabel lblRegistrarCargo = new JLabel("EMPRESA CANAL 40 COFFEE TV CHANNEL");
		lblRegistrarCargo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblRegistrarCargo.setBounds(28, 0, 431, 39);
		contentPane.add(lblRegistrarCargo);
		scrollFunciones = new JScrollPane();

		JPanel panelRegistro = new JPanel();
		panelRegistro.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		panelRegistro.setBounds(28, 42, 791, 468);
		contentPane.add(panelRegistro);
		panelRegistro.setLayout(null);

		btnActualizarContrato = new JButton("Editar");
		btnActualizarContrato.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnActualizarContrato.setBackground(new Color(60, 179, 113));
		btnActualizarContrato.setBounds(650, 417, 99, 23);
		panelRegistro.add(btnActualizarContrato);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnGuardar.setBackground(new Color(60, 179, 113));
		btnGuardar.setBounds(548, 417, 99, 23);
		panelRegistro.add(btnGuardar);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(44, 45, 50, 20);
		panelRegistro.add(textField);

		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblNombre.setBounds(104, 85, 83, 14);
		panelRegistro.add(lblNombre);

		txtNombreEmpresa = new JTextField();
		txtNombreEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombreEmpresa.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtNombreEmpresa.setColumns(10);
		txtNombreEmpresa.setBounds(187, 82, 210, 20);
		panelRegistro.add(txtNombreEmpresa);

		JLabel lblRedesSociales = new JLabel("Redes Sociales.");
		lblRedesSociales.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblRedesSociales.setBounds(104, 375, 125, 14);
		panelRegistro.add(lblRedesSociales);

		JLabel lblLogoOficialDe = new JLabel("Logo Oficial de la empresa.");
		lblLogoOficialDe.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblLogoOficialDe.setBounds(428, 54, 179, 17);
		panelRegistro.add(lblLogoOficialDe);

		JButton button_1 = new JButton("Subir");
		button_1.setBackground(new Color(250, 128, 114));
		button_1.setBounds(428, 82, 83, 23);
		panelRegistro.add(button_1);

		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(522, 83, 164, 20);
		panelRegistro.add(textField_3);

		JLabel label_5 = new JLabel();
		label_5.setBounds(428, 116, 131, 106);
		panelRegistro.add(label_5);

		JLabel lblDatosDeLa = new JLabel("Datos de la empresa :");
		lblDatosDeLa.setForeground(Color.BLACK);
		lblDatosDeLa.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblDatosDeLa.setBounds(104, 51, 175, 23);
		panelRegistro.add(lblDatosDeLa);

		JLabel lblDireccion = new JLabel("Direccion :");
		lblDireccion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblDireccion.setBounds(104, 113, 83, 14);
		panelRegistro.add(lblDireccion);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(187, 113, 210, 44);
		panelRegistro.add(scrollPane);

		JTextArea txtDireccion = new JTextArea();
		scrollPane.setViewportView(txtDireccion);

		JLabel lblTelefono = new JLabel("Telefono :");
		lblTelefono.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblTelefono.setBounds(104, 171, 83, 14);
		panelRegistro.add(lblTelefono);

		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(187, 168, 210, 20);
		panelRegistro.add(textField_1);

		JLabel lblRtn = new JLabel("RTN :");
		lblRtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblRtn.setBounds(104, 199, 83, 14);
		panelRegistro.add(lblRtn);

		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		textField_4.setColumns(10);
		textField_4.setBounds(187, 196, 210, 20);
		panelRegistro.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		textField_5.setColumns(10);
		textField_5.setBounds(187, 224, 210, 20);
		panelRegistro.add(textField_5);

		JLabel lblCorreo = new JLabel("Correo :");
		lblCorreo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblCorreo.setBounds(104, 227, 83, 14);
		panelRegistro.add(lblCorreo);

		JLabel lblCuentaBancaria = new JLabel("Cuentas :");
		lblCuentaBancaria.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblCuentaBancaria.setBounds(104, 255, 83, 14);
		panelRegistro.add(lblCuentaBancaria);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(187, 255, 210, 106);
		panelRegistro.add(scrollPane_1);

		JTextArea textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
				
				JLabel label_1 = new JLabel();
				label_1.setBounds(428, 289, 164, 119);
				panelRegistro.add(label_1);
				
				JLabel label_2 = new JLabel("Logo Oficial de la empresa.");
				label_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
				label_2.setBounds(428, 227, 179, 17);
				panelRegistro.add(label_2);
				
				JButton button = new JButton("Subir");
				button.setBackground(new Color(250, 128, 114));
				button.setBounds(428, 255, 83, 23);
				panelRegistro.add(button);
				
				textField_2 = new JTextField();
				textField_2.setEditable(false);
				textField_2.setColumns(10);
				textField_2.setBounds(522, 256, 164, 20);
				panelRegistro.add(textField_2);
						
						JButton btnNewButton = new JButton("New button");
						btnNewButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								
							}
						});
						btnNewButton.setBounds(214, 366, 89, 74);
						panelRegistro.add(btnNewButton);
						
						JButton button_2 = new JButton("New button");
						button_2.setBounds(308, 366, 89, 74);
						panelRegistro.add(button_2);
						
								JLabel lblLibreta = new JLabel();
								lblLibreta.setBounds(0, 0, 791, 468);
								panelRegistro.add(lblLibreta);
								final ImageIcon logo = new ImageIcon(
										icono.getImage().getScaledInstance(lblLibreta.getWidth(), lblLibreta.getHeight(), Image.SCALE_DEFAULT));
								lblLibreta.setIcon(logo);
		map4.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

	}
	
 public void goToURL(String URL){
           if (java.awt.Desktop.isDesktopSupported()) {
            java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
 
            if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
                try {
                    java.net.URI uri = new java.net.URI(URL);
                    desktop.browse(uri);
                } catch (URISyntaxException | IOException ex) {
                    Logger.getLogger(Acerca.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

	
	
}
