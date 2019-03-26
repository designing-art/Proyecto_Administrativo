package formularios;

import java.awt.Color;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;

import com.placeholder.PlaceHolder;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class registro_cargos extends JFrame {

	public JTextField txtCodigoCargo;
	public JComboBox<?> cbxNombreCargo;
	public JComboBox<?> cbxTipoCargo;
	public JTextField txtHoraExtraCargo;
	public JTextField txtSueldoCargo;
	public JTextArea txtFuncionesCargo;
	public JScrollPane scrollFunciones;

	public JButton btnGuardarCargo;
	public JButton btnNuevoCargo;
	public JButton btnActualizarCargo;

	public JPanel contentPane;
	public JTable tablaCargos;

	public registro_cargos() {
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 510);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBounds(217, 36, 341, 434);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel label = new JLabel();
		label.setBounds(267, 42, 49, 44);
		panel.add(label);
		final ImageIcon logopeq = new ImageIcon(getClass().getResource("/material/logo.png"));
		final ImageIcon iconopeq = new ImageIcon(
				logopeq.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
		label.setIcon(iconopeq);

		btnNuevoCargo = new JButton("Nuevo");
		btnNuevoCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnNuevoCargo.setBounds(27, 360, 99, 23);
		panel.add(btnNuevoCargo);
		btnNuevoCargo.setBackground(new Color(0, 128, 128));

		btnGuardarCargo = new JButton("Guardar");
		btnGuardarCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnGuardarCargo.setBounds(217, 325, 99, 23);
		panel.add(btnGuardarCargo);
		btnGuardarCargo.setBackground(new Color(60, 179, 113));

		JLabel lblHoraExtraCargo = new JLabel("5. Precio hora extra :");
		lblHoraExtraCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblHoraExtraCargo.setBounds(27, 200, 136, 22);
		panel.add(lblHoraExtraCargo);

		txtSueldoCargo = new JTextField();
		txtSueldoCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtSueldoCargo.setBounds(168, 169, 148, 20);
		txtSueldoCargo.setColumns(10);
		txtSueldoCargo.setHorizontalAlignment(JTextField.RIGHT);
		panel.add(txtSueldoCargo);
		txtSueldoCargo.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();
				if ((c < '0' || c > '9'))
					ke.consume();
			}

			public void keyPressed(KeyEvent ke) {
			}

			public void keyReleased(KeyEvent ke) {
			}
		});

		txtHoraExtraCargo = new JTextField();
		txtHoraExtraCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtHoraExtraCargo.setBounds(168, 201, 148, 20);
		panel.add(txtHoraExtraCargo);
		txtHoraExtraCargo.setColumns(10);
		txtHoraExtraCargo.setHorizontalAlignment(JTextField.RIGHT);
		txtHoraExtraCargo.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();
				if ((c < '0' || c > '9'))
					ke.consume();
			}

			public void keyPressed(KeyEvent ke) {
			}

			public void keyReleased(KeyEvent ke) {
			}
		});

		JLabel lblSueldoCargo = new JLabel("4. Sueldo :");
		lblSueldoCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblSueldoCargo.setBounds(27, 168, 100, 23);
		panel.add(lblSueldoCargo);

		JLabel lblNombreCargo = new JLabel("3. Nombre cargo:");
		lblNombreCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblNombreCargo.setBounds(27, 143, 121, 14);
		panel.add(lblNombreCargo);

		JLabel lblTipoDeCargo = new JLabel("2. Tipo de cargo :");
		lblTipoDeCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblTipoDeCargo.setBounds(27, 109, 105, 23);
		panel.add(lblTipoDeCargo);

		txtCodigoCargo = new JTextField();
		txtCodigoCargo.setEditable(false);
		txtCodigoCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtCodigoCargo.setBounds(158, 82, 28, 18);
		panel.add(txtCodigoCargo);
		txtCodigoCargo.setColumns(10);

		JLabel lblCodigoCargo = new JLabel("1. Codigo :");
		lblCodigoCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblCodigoCargo.setBounds(27, 84, 63, 14);
		panel.add(lblCodigoCargo);

		JLabel lblRegistroCargos = new JLabel("Datos del registro :");
		lblRegistroCargos.setBounds(27, 48, 136, 23);
		panel.add(lblRegistroCargos);
		lblRegistroCargos.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));

		JLabel lblFuncionesCargo = new JLabel("6. Funciones :");
		lblFuncionesCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblFuncionesCargo.setBounds(27, 235, 99, 14);
		panel.add(lblFuncionesCargo);
		final ImageIcon icono = new ImageIcon(getClass().getResource("/material/libreta.png"));

		cbxTipoCargo = new JComboBox();
		cbxTipoCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		cbxTipoCargo.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar", "Administrativo", "Gerencial", "Operario", "Servicio", "Seguridad"}));
		cbxTipoCargo.setBounds(158, 110, 159, 22);
		panel.add(cbxTipoCargo);

		cbxNombreCargo = new JComboBox();
		cbxNombreCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		cbxNombreCargo.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar", "Gerente de Operaciones", "Administrador", "Operador", "Editor", "Camarografo", "Conserge", "Vigilante"}));
		cbxNombreCargo.setBounds(158, 140, 159, 22);
		panel.add(cbxNombreCargo);

		JLabel lblL = new JLabel("L.");
		lblL.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblL.setBounds(156, 169, 17, 19);
		panel.add(lblL);

		JLabel label_1 = new JLabel("L.");
		label_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		label_1.setBounds(156, 203, 17, 14);
		panel.add(label_1);

		btnActualizarCargo = new JButton("Actualizar");
		btnActualizarCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnActualizarCargo.setBackground(new Color(240, 230, 140));
		btnActualizarCargo.setBounds(27, 325, 99, 23);
		panel.add(btnActualizarCargo);
		final ImageIcon icono2 = new ImageIcon(getClass().getResource("/material/libreta.png"));

		JButton btnAtras = new JButton("Regresar");
		btnAtras.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnAtras.setBackground(new Color(255, 127, 80));
		btnAtras.setBounds(10, 11, 99, 23);
		contentPane.add(btnAtras);

		JLabel lblRegistrarCargo = new JLabel("Registrar Cargos");
		lblRegistrarCargo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		lblRegistrarCargo.setBounds(312, 3, 177, 36);
		contentPane.add(lblRegistrarCargo);
		scrollFunciones = new JScrollPane();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(157, 238, 159, 70);
		panel.add(scrollPane);
		txtFuncionesCargo = new JTextArea();
		scrollPane.setViewportView(txtFuncionesCargo);
		
				JLabel lblImagenLibreta = new JLabel();
				lblImagenLibreta.setBounds(0, 0, 341, 445);
				panel.add(lblImagenLibreta);
				final ImageIcon logo = new ImageIcon(icono.getImage().getScaledInstance(lblImagenLibreta.getWidth(),
						lblImagenLibreta.getHeight(), Image.SCALE_DEFAULT));
				lblImagenLibreta.setIcon(logo);

		JButton button = new JButton("Siguiente");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registro_horarios horario = new registro_horarios();
				horario.setVisible(true);
				horario.setLocationRelativeTo(null);
				dispose();
			}
		});
		button.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		button.setBackground(new Color(0, 255, 127));
		button.setBounds(685, 12, 99, 23);
		contentPane.add(button);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registro_empleados empleado = new registro_empleados();
				empleado.setVisible(true);
				empleado.setLocationRelativeTo(null);
				dispose();
			}
		});

		
		pistas();
	}

	public void pistas() {
		PlaceHolder pistas;
		pistas = new PlaceHolder(txtSueldoCargo, "Ingrese el sueldo");
		pistas = new PlaceHolder(txtHoraExtraCargo, "Ingrese precio hora extra.");
		pistas = new PlaceHolder(txtFuncionesCargo, "Escriba funciones del empleado.");
	}
}
