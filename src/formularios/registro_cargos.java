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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;

import clases.cargo;
import consultas.consultas_cargo;
import controles.control_cargo;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class registro_cargos extends JFrame {

	public JTextField txtCodigoCargo;
	public JComboBox<?> cbxTipoCargo;
	public JTextField txtNombreCargo;
	public JTextField txtHoraExtraCargo;
	public JTextField txtSueldoCargo;
	public JTextArea txtFuncionesCargo;
	public JScrollPane scrollFunciones;

	public JButton btnGuardarCargo;
	public JButton btnNuevoCargo;
	public JButton btnActualizarCargo;

	public JPanel contentPane;
	public JTextField txtBusquedaCargos;
	public JScrollPane barraCargos;
	public JTable tablaCargos;

	public registro_cargos() {
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 550);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		final ImageIcon logopeq = new ImageIcon(getClass().getResource("/material/logo.png"));
		final ImageIcon icono = new ImageIcon(getClass().getResource("/material/libreta.png"));
		final ImageIcon icono2 = new ImageIcon(getClass().getResource("/material/libreta.png"));

		JButton btnAtras = new JButton("Regresar");
		btnAtras.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnAtras.setBackground(new Color(255, 127, 80));
		btnAtras.setBounds(10, 11, 99, 23);
		contentPane.add(btnAtras);

		JLabel lblRegistrarCargo = new JLabel("Registro y Mantenimiento de Cargos.");
		lblRegistrarCargo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		lblRegistrarCargo.setBounds(237, 11, 331, 39);
		contentPane.add(lblRegistrarCargo);
		scrollFunciones = new JScrollPane();

		JPanel panelRegistro = new JPanel();
		panelRegistro.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelRegistro.setBounds(31, 61, 341, 425);
		contentPane.add(panelRegistro);
		panelRegistro.setLayout(null);

		JLabel label = new JLabel();
		label.setBounds(267, 42, 49, 44);
		panelRegistro.add(label);
		final ImageIcon iconopeq = new ImageIcon(
				logopeq.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
		label.setIcon(iconopeq);

		btnNuevoCargo = new JButton("Nuevo");
		btnNuevoCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnNuevoCargo.setBounds(27, 360, 99, 23);
		panelRegistro.add(btnNuevoCargo);
		btnNuevoCargo.setBackground(new Color(0, 128, 128));

		btnGuardarCargo = new JButton("Guardar");
		btnGuardarCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnGuardarCargo.setBounds(217, 360, 99, 23);
		panelRegistro.add(btnGuardarCargo);
		btnGuardarCargo.setBackground(new Color(60, 179, 113));

		JLabel lblHoraExtraCargo = new JLabel("5. Precio hora extra :");
		lblHoraExtraCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblHoraExtraCargo.setBounds(27, 200, 136, 22);
		panelRegistro.add(lblHoraExtraCargo);

		txtSueldoCargo = new JTextField();
		txtSueldoCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtSueldoCargo.setBounds(168, 169, 148, 20);
		txtSueldoCargo.setColumns(10);
		txtSueldoCargo.setHorizontalAlignment(JTextField.RIGHT);
		panelRegistro.add(txtSueldoCargo);
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
		panelRegistro.add(txtHoraExtraCargo);
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
		panelRegistro.add(lblSueldoCargo);

		JLabel lblNombreCargo = new JLabel("3. Nombre cargo:");
		lblNombreCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblNombreCargo.setBounds(27, 143, 121, 14);
		panelRegistro.add(lblNombreCargo);

		JLabel lblTipoDeCargo = new JLabel("2. Tipo de cargo :");
		lblTipoDeCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblTipoDeCargo.setBounds(27, 109, 105, 23);
		panelRegistro.add(lblTipoDeCargo);

		txtCodigoCargo = new JTextField();
		txtCodigoCargo.setEditable(false);
		txtCodigoCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtCodigoCargo.setBounds(158, 82, 28, 18);
		panelRegistro.add(txtCodigoCargo);
		txtCodigoCargo.setColumns(10);

		JLabel lblCodigoCargo = new JLabel("1. Codigo :");
		lblCodigoCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblCodigoCargo.setBounds(27, 84, 63, 14);
		panelRegistro.add(lblCodigoCargo);

		JLabel lblRegistroCargos = new JLabel("Datos del registro :");
		lblRegistroCargos.setBounds(27, 48, 136, 23);
		panelRegistro.add(lblRegistroCargos);
		lblRegistroCargos.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));

		JLabel lblFuncionesCargo = new JLabel("6. Funciones :");
		lblFuncionesCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblFuncionesCargo.setBounds(27, 235, 99, 14);
		panelRegistro.add(lblFuncionesCargo);

		cbxTipoCargo = new JComboBox();
		cbxTipoCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		cbxTipoCargo.setModel(new DefaultComboBoxModel(
				new String[] { "Operativo", "Administrativo", "Gerencial", "Servicios", "Seguridad" }));
		cbxTipoCargo.setBounds(158, 110, 159, 22);
		panelRegistro.add(cbxTipoCargo);

		JLabel lblL = new JLabel("L.");
		lblL.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblL.setBounds(156, 169, 17, 19);
		panelRegistro.add(lblL);

		JLabel label_1 = new JLabel("L.");
		label_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		label_1.setBounds(156, 203, 17, 14);
		panelRegistro.add(label_1);

		btnActualizarCargo = new JButton("Actualizar");
		btnActualizarCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnActualizarCargo.setBackground(new Color(240, 230, 140));
		btnActualizarCargo.setBounds(27, 326, 99, 23);
		panelRegistro.add(btnActualizarCargo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(157, 238, 159, 111);
		panelRegistro.add(scrollPane);
		txtFuncionesCargo = new JTextArea();
		scrollPane.setViewportView(txtFuncionesCargo);

		txtNombreCargo = new JTextField();
		txtNombreCargo.setHorizontalAlignment(SwingConstants.RIGHT);
		txtNombreCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtNombreCargo.setColumns(10);
		txtNombreCargo.setBounds(158, 141, 158, 20);
		panelRegistro.add(txtNombreCargo);

		txtNombreCargo.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();
				if (Character.isDigit(c)) {
					Toolkit.getDefaultToolkit().beep();
					ke.consume();
				}
			}

			public void keyPressed(KeyEvent ke) {
			}

			public void keyReleased(KeyEvent ke) {
			}
		});

		JLabel lblImagenLibreta = new JLabel();
		lblImagenLibreta.setBounds(0, 0, 341, 425);
		panelRegistro.add(lblImagenLibreta);
		final ImageIcon logo = new ImageIcon(icono.getImage().getScaledInstance(lblImagenLibreta.getWidth(),
				lblImagenLibreta.getHeight(), Image.SCALE_DEFAULT));
		lblImagenLibreta.setIcon(logo);

		JPanel panelTablaCargos = new JPanel();
		panelTablaCargos.setLayout(null);
		panelTablaCargos.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelTablaCargos.setBackground(Color.WHITE);
		panelTablaCargos.setBounds(397, 61, 393, 425);
		contentPane.add(panelTablaCargos);

		JLabel label_2 = new JLabel("Cargos Registrados.");
		label_2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		label_2.setBounds(10, 11, 166, 23);
		panelTablaCargos.add(label_2);

		JLabel label_3 = new JLabel("Buscar Cargo :");
		label_3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		label_3.setBounds(10, 39, 136, 22);
		panelTablaCargos.add(label_3);

		txtBusquedaCargos = new JTextField();
		txtBusquedaCargos.setHorizontalAlignment(SwingConstants.RIGHT);
		txtBusquedaCargos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtBusquedaCargos.setColumns(10);
		txtBusquedaCargos.setBounds(105, 40, 278, 20);
		panelTablaCargos.add(txtBusquedaCargos);

		JButton button = new JButton("Editar");
		button.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		button.setBackground(new Color(0, 128, 128));
		button.setBounds(284, 385, 99, 23);
		panelTablaCargos.add(button);

		JButton button_1 = new JButton("Borrar");

		button_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		button_1.setBackground(new Color(220, 20, 60));
		button_1.setBounds(10, 385, 99, 23);
		panelTablaCargos.add(button_1);

		barraCargos = new JScrollPane();
		panelTablaCargos.add(barraCargos);
		barraCargos.setBounds(10, 83, 373, 291);

		tablaCargos = new JTable();
		barraCargos.setViewportView(tablaCargos);
		barraCargos.setViewportView(tablaCargos);

		String titulos[] = { "Codigo", "Area", "Nombre", "Sueldo", "Hora extra", "Funsiones" };
		String informacion[][] = control_cargo.obtenerMatriz();
		tablaCargos = new JTable(informacion, titulos);
		barraCargos.setViewportView(tablaCargos);

		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registro_empleados empleado = new registro_empleados();
				empleado.setVisible(true);
				empleado.setLocationRelativeTo(null);
				dispose();
			}
		});

	}

}
