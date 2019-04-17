package formularios;

import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Timer;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;
import com.placeholder.PlaceHolder;

import conexion.conexion;
import controles.control_cargo;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class registro_cargos extends JFrame {
	public JComboBox<?> cbxTipoCargo;
	public JTextField txtNombreCargo;
	public JTextField txtHoraExtraCargo;
	public JTextField txtSueldoCargo;
	public JTextArea txtFuncionesCargo;
	public JScrollPane scrollFunciones;
	public PlaceHolder pista;
	public JScrollPane scrollPane;

	public JButton btnGuardarCargo;
	public JButton btnNuevoCargo;
	public JButton btnActualizarDatosCargo;
	public JButton btnBorrarCargo;
	public JButton btnActualizarCargo;
	public JButton btnMostrar;
	public JButton btnAceptar;

	public JPanel contentPane;
	public JTextField txtBusquedaCargos;
	public JScrollPane barraCargos;
	public JTable tablaCargos;
	public JTextField txtCodigoCargo;

	public TableRowSorter trsfiltroCodigo;
	String filtroCodigo;

	public registro_cargos() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 550);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/material/logo.png")));

		final ImageIcon logopeq = new ImageIcon(getClass().getResource("/material/logo.png"));
		final ImageIcon icono = new ImageIcon(getClass().getResource("/material/libreta.png"));
		final ImageIcon icono2 = new ImageIcon(getClass().getResource("/material/libreta.png"));

		JButton btnAtras = new JButton("Regresar");
		btnAtras.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnAtras.setBackground(new Color(255, 127, 80));
		btnAtras.setBounds(717, 20, 102, 23);
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

		JLabel lblRegistrarCargo = new JLabel("REGISTRO Y MANTENIMIENTO DE CARGOS");
		lblRegistrarCargo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblRegistrarCargo.setBounds(28, 10, 466, 39);
		contentPane.add(lblRegistrarCargo);
		scrollFunciones = new JScrollPane();

		JPanel panelRegistro = new JPanel();
		panelRegistro.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		panelRegistro.setBounds(28, 60, 341, 450);
		contentPane.add(panelRegistro);
		panelRegistro.setLayout(null);

		JLabel label = new JLabel();
		label.setBounds(265, 48, 49, 44);
		panelRegistro.add(label);
		final ImageIcon iconopeq = new ImageIcon(
				logopeq.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
		label.setIcon(iconopeq);

		btnNuevoCargo = new JButton("Nuevo");
		btnNuevoCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnNuevoCargo.setBounds(27, 393, 99, 23);
		panelRegistro.add(btnNuevoCargo);
		btnNuevoCargo.setBackground(new Color(255, 255, 255));

		btnGuardarCargo = new JButton("Guardar");
		btnGuardarCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnGuardarCargo.setBounds(218, 393, 99, 23);
		panelRegistro.add(btnGuardarCargo);
		btnGuardarCargo.setBackground(new Color(60, 179, 113));

		JLabel lblHoraExtraCargo = new JLabel("5. Precio hora extra :");
		lblHoraExtraCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblHoraExtraCargo.setBounds(27, 200, 136, 22);
		panelRegistro.add(lblHoraExtraCargo);

		txtSueldoCargo = new JTextField();
		txtSueldoCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtSueldoCargo.setBounds(188, 169, 128, 20);
		txtSueldoCargo.setColumns(10);
		txtSueldoCargo.setHorizontalAlignment(SwingConstants.RIGHT);
		panelRegistro.add(txtSueldoCargo);
		InputMap map2 = txtSueldoCargo.getInputMap(JComponent.WHEN_FOCUSED);
		map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

		txtSueldoCargo.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();
				if ((c < '0' || c > '9'))
					ke.consume();
			}

			@Override
			public void keyPressed(KeyEvent ke) {
			}

			@Override
			public void keyReleased(KeyEvent ke) {
			}
		});

		txtHoraExtraCargo = new JTextField();
		txtHoraExtraCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtHoraExtraCargo.setBounds(188, 201, 128, 20);
		panelRegistro.add(txtHoraExtraCargo);
		InputMap map = txtHoraExtraCargo.getInputMap(JComponent.WHEN_FOCUSED);
		map.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtHoraExtraCargo.setColumns(10);
		txtHoraExtraCargo.setHorizontalAlignment(SwingConstants.RIGHT);
		txtHoraExtraCargo.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();
				if ((c < '0' || c > '9'))
					ke.consume();
			}

			@Override
			public void keyPressed(KeyEvent ke) {
			}

			@Override
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
		cbxTipoCargo.setBounds(142, 110, 175, 22);
		panelRegistro.add(cbxTipoCargo);

		JLabel lblL = new JLabel("L.");
		lblL.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblL.setBounds(168, 174, 17, 19);
		panelRegistro.add(lblL);

		JLabel label_1 = new JLabel("L.");
		label_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		label_1.setBounds(168, 208, 17, 14);
		panelRegistro.add(label_1);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(122, 233, 193, 111);
		panelRegistro.add(scrollPane);
		txtFuncionesCargo = new JTextArea();
		txtFuncionesCargo.setBackground(Color.WHITE);
		scrollPane.setViewportView(txtFuncionesCargo);
		InputMap map5 = txtFuncionesCargo.getInputMap(JComponent.WHEN_FOCUSED);
		map5.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

		txtNombreCargo = new JTextField();
		txtNombreCargo.setHorizontalAlignment(SwingConstants.LEFT);
		txtNombreCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtNombreCargo.setColumns(10);
		txtNombreCargo.setBounds(142, 141, 174, 20);
		panelRegistro.add(txtNombreCargo);
		InputMap map3 = txtNombreCargo.getInputMap(JComponent.WHEN_FOCUSED);
		map3.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

		txtNombreCargo.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();
				if (Character.isDigit(c)) {
					Toolkit.getDefaultToolkit().beep();
					ke.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent ke) {
			}

			@Override
			public void keyReleased(KeyEvent ke) {
			}
		});

		txtCodigoCargo = new JTextField();
		txtCodigoCargo.setEditable(false);
		txtCodigoCargo.setBounds(142, 81, 43, 23);
		panelRegistro.add(txtCodigoCargo);
		txtCodigoCargo.setColumns(10);

		btnActualizarCargo = new JButton("Actualizar");
		btnActualizarCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnActualizarCargo.setBackground(new Color(60, 179, 113));
		btnActualizarCargo.setBounds(218, 355, 99, 23);
		panelRegistro.add(btnActualizarCargo);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnAceptar.setBackground(new Color(255, 255, 255));
		btnAceptar.setBounds(27, 355, 99, 23);
		panelRegistro.add(btnAceptar);

		JLabel lblImagenLibreta = new JLabel();
		lblImagenLibreta.setBounds(0, 0, 341, 450);
		panelRegistro.add(lblImagenLibreta);
		final ImageIcon logo = new ImageIcon(icono.getImage().getScaledInstance(lblImagenLibreta.getWidth(),
				lblImagenLibreta.getHeight(), Image.SCALE_DEFAULT));
		lblImagenLibreta.setIcon(logo);

		JPanel panelTablaCargos = new JPanel();
		panelTablaCargos.setLayout(null);
		panelTablaCargos.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		panelTablaCargos.setBackground(Color.WHITE);
		panelTablaCargos.setBounds(388, 61, 431, 449);
		contentPane.add(panelTablaCargos);

		JLabel lblCargosRegistrados = new JLabel("Cargos registrados :");
		lblCargosRegistrados.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblCargosRegistrados.setBounds(30, 41, 166, 19);
		panelTablaCargos.add(lblCargosRegistrados);

		JLabel label_3 = new JLabel("Buscar Cargo :");
		label_3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		label_3.setBounds(30, 63, 99, 22);
		panelTablaCargos.add(label_3);

		txtBusquedaCargos = new JTextField();
		txtBusquedaCargos.setHorizontalAlignment(SwingConstants.CENTER);
		txtBusquedaCargos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtBusquedaCargos.setColumns(10);
		txtBusquedaCargos.setBounds(119, 64, 228, 21);
		panelTablaCargos.add(txtBusquedaCargos);
		InputMap map4 = txtBusquedaCargos.getInputMap(JComponent.WHEN_FOCUSED);
		txtBusquedaCargos.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				trsfiltroCodigo = new TableRowSorter(tablaCargos.getModel());
				tablaCargos.setRowSorter(trsfiltroCodigo);
			}

			@Override
			public void keyPressed(KeyEvent ke) {

			}

			@Override
			public void keyReleased(KeyEvent ke) {
				String cadena = (txtBusquedaCargos.getText());
				txtBusquedaCargos.setText(cadena);
				repaint();
				filtro();
			}
		});

		btnBorrarCargo = new JButton("Borrar");
		btnBorrarCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnBorrarCargo.setBackground(new Color(220, 20, 60));
		btnBorrarCargo.setBounds(30, 395, 99, 23);
		panelTablaCargos.add(btnBorrarCargo);

		barraCargos = new JScrollPane(tablaCargos, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panelTablaCargos.add(barraCargos);
		barraCargos.setBounds(28, 90, 376, 294);

		tablaCargos = new JTable();
		barraCargos.setViewportView(tablaCargos);

		JLabel label_2 = new JLabel();
		label_2.setBounds(355, 41, 49, 44);
		panelTablaCargos.add(label_2);
		final ImageIcon logo2 = new ImageIcon(
				iconopeq.getImage().getScaledInstance(label_2.getWidth(), label_2.getHeight(), Image.SCALE_DEFAULT));
		label_2.setIcon(logo2);

		btnActualizarDatosCargo = new JButton("Actualizar Datos");
		btnActualizarDatosCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnActualizarDatosCargo.setBackground(new Color(60, 179, 113));
		btnActualizarDatosCargo.setBounds(267, 396, 137, 23);
		panelTablaCargos.add(btnActualizarDatosCargo);

		btnMostrar = new JButton("Ver detalles");
		btnMostrar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnMostrar.setBackground(new Color(0, 206, 209));
		btnMostrar.setBounds(149, 395, 108, 23);
		panelTablaCargos.add(btnMostrar);

		JLabel label_5 = new JLabel();
		label_5.setBounds(0, 0, 431, 449);
		panelTablaCargos.add(label_5);
		final ImageIcon logo1 = new ImageIcon(
				icono.getImage().getScaledInstance(label_5.getWidth(), label_5.getHeight(), Image.SCALE_DEFAULT));
		label_5.setIcon(logo1);
		map4.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

	}

	public void construirTabla() {
		String titulos[] = { "Codigo", "Area", "Nombre", "Sueldo", "Hora extra", "Funciones" };
		String informacion[][] = control_cargo.obtenerMatriz();
		tablaCargos = new JTable(informacion, titulos);
		barraCargos.setViewportView(tablaCargos);
		for (int c = 0; c < tablaCargos.getColumnCount(); c++) {
			Class<?> col_class = tablaCargos.getColumnClass(c);
			tablaCargos.setDefaultEditor(col_class, null);
			tablaCargos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			tablaCargos.getTableHeader().setReorderingAllowed(false);

			// alinear datos de sueldo y horaextra a la derecha
			DefaultTableCellRenderer tcr;
			tcr = new DefaultTableCellRenderer();
			tcr.setHorizontalAlignment(SwingConstants.RIGHT);
			tablaCargos.getColumnModel().getColumn(3).setCellRenderer(tcr);
			tablaCargos.getColumnModel().getColumn(4).setCellRenderer(tcr);
		}
	}

	public void filtro() {
		filtroCodigo = txtBusquedaCargos.getText();
		trsfiltroCodigo.setRowFilter(RowFilter.regexFilter(txtBusquedaCargos.getText(), 0, 1, 2, 3, 4, 5));
	}

	public void pistas() {
		pista = new PlaceHolder(txtBusquedaCargos, "Escriba para buscar.");
		pista = new PlaceHolder(txtNombreCargo, "Ingrese el nombre del cargo.");
		pista = new PlaceHolder(txtSueldoCargo, "Digite el sueldo.");
		pista = new PlaceHolder(txtHoraExtraCargo, "Digite precio hora extra.");
		pista = new PlaceHolder(txtFuncionesCargo, "Ingrese las Funciones.");
	}

	public void obtenerUltimoId() {
		String ultimoValor = null;
		int valor;
		String id = null;
		conexion objCon = new conexion();
		Connection conn = objCon.getConexion();
		try {
			PreparedStatement stmtr = conn.prepareStatement("SELECT * FROM cargos ORDER BY id_cargo DESC");
			ResultSet rsr = stmtr.executeQuery();
			if (rsr.next()) {
				ultimoValor = rsr.getString("id_cargo");
				valor = Integer.parseInt(ultimoValor);
				valor = valor + 1;
				id = String.valueOf(valor);
			}
			txtCodigoCargo.setText(id);
			;
			stmtr.close();
			rsr.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
