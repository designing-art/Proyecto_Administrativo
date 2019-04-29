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
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import java.text.ParseException;
import java.util.Timer;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.MaskFormatter;

import com.placeholder.PlaceHolder;

import conexion.conexion;
import controles.control_contrato_empleado;
import utilidades.visor_imagen;

import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

public class registro_contratos_empleados extends JFrame {
	public JComboBox<?> cbxTiempoContratoEmpleado;
	public JComboBox<?> cbxTipoContratoEmpleado;
	public JScrollPane scrollFunciones;
	public PlaceHolder pista;

	public JButton btnGuardarContrato;
	public JButton btnNuevoContrato;
	public JButton btnActualizarDatosContrato;
	public JButton btnBorrarContrato;
	public JButton btnActualizarContrato;
	public JButton btnMostrarContrato;
	public JButton btnAceptar;

	public static String ruta;
	public static ImageIcon imagen;

	public JPanel contentPane;
	public JTextField txtBusquedaContratosEmpleados;
	public JScrollPane barraContratos;
	public JTable tablaContratosEmpleados;
	public JTextField txtCodigoContratoEmpleado;

	public TableRowSorter<TableModel> trsfiltroCodigo;
	String filtroCodigo;
	public JTextField txtDireccionFotoContrato;
	public JButton btnSubirFotoContrato;
	public JButton btnVerFotoContrato;
	public JLabel lbl_foto_contrato;

	public ImageIcon logopeq = new ImageIcon(getClass().getResource("/material/logo.png"));
	public ImageIcon icono = new ImageIcon(getClass().getResource("/material/libreta.png"));
	public ImageIcon icono2 = new ImageIcon(getClass().getResource("/material/libreta.png"));
	public ImageIcon iconoContrato = new ImageIcon(getClass().getResource("/material/contrato.png"));
	public JLabel lblNumeroDe;
	public JFormattedTextField txtIdentidadContratoEmpleado;

	public registro_contratos_empleados() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 550);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/material/logo.png")));

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

		JLabel lblRegistrarCargo = new JLabel("REGISTRO Y MANTENIMIENTO DE CONTRATOS DE LOS EMPLEADOS");
		lblRegistrarCargo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblRegistrarCargo.setBounds(28, 10, 693, 39);
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

		btnNuevoContrato = new JButton("Nuevo");
		btnNuevoContrato.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnNuevoContrato.setBounds(27, 393, 99, 23);
		panelRegistro.add(btnNuevoContrato);
		btnNuevoContrato.setBackground(new Color(255, 255, 255));

		btnGuardarContrato = new JButton("Guardar");
		btnGuardarContrato.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnGuardarContrato.setBounds(218, 393, 99, 23);
		panelRegistro.add(btnGuardarContrato);
		btnGuardarContrato.setBackground(new Color(60, 179, 113));

		JLabel lblNombreCargo = new JLabel("3. Tiempo de contrato :");
		lblNombreCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblNombreCargo.setBounds(27, 143, 136, 14);
		panelRegistro.add(lblNombreCargo);

		JLabel lblTipo = new JLabel("2. Tipo de contrato :");
		lblTipo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblTipo.setBounds(27, 109, 158, 23);
		panelRegistro.add(lblTipo);

		JLabel lblCodigo = new JLabel("1. Codigo :");
		lblCodigo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblCodigo.setBounds(27, 84, 63, 14);
		panelRegistro.add(lblCodigo);

		JLabel lblRegistroCargos = new JLabel("Datos del registro :");
		lblRegistroCargos.setBounds(27, 48, 136, 23);
		panelRegistro.add(lblRegistroCargos);
		lblRegistroCargos.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));

		cbxTiempoContratoEmpleado = new JComboBox();
		cbxTiempoContratoEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		cbxTiempoContratoEmpleado.setModel(new DefaultComboBoxModel(
				new String[] { "Indefinido", "6 meses", "1 a\u00F1o", "2 a\u00F1os", "Permanente" }));
		cbxTiempoContratoEmpleado.setBounds(173, 139, 141, 22);
		panelRegistro.add(cbxTiempoContratoEmpleado);

		txtCodigoContratoEmpleado = new JTextField();
		txtCodigoContratoEmpleado.setEditable(false);
		txtCodigoContratoEmpleado.setBounds(173, 81, 43, 23);
		panelRegistro.add(txtCodigoContratoEmpleado);
		txtCodigoContratoEmpleado.setColumns(10);

		btnActualizarContrato = new JButton("Actualizar");
		btnActualizarContrato.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnActualizarContrato.setBackground(new Color(60, 179, 113));
		btnActualizarContrato.setBounds(218, 359, 99, 23);
		panelRegistro.add(btnActualizarContrato);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnAceptar.setBackground(new Color(255, 255, 255));
		btnAceptar.setBounds(27, 359, 99, 23);
		panelRegistro.add(btnAceptar);

		cbxTipoContratoEmpleado = new JComboBox();
		cbxTipoContratoEmpleado.setModel(new DefaultComboBoxModel(new String[] { "Temporal", "Permanente" }));
		cbxTipoContratoEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		cbxTipoContratoEmpleado.setBounds(172, 109, 142, 22);
		panelRegistro.add(cbxTipoContratoEmpleado);

		lbl_foto_contrato = new JLabel();
		lbl_foto_contrato.setBounds(173, 201, 141, 147);
		panelRegistro.add(lbl_foto_contrato);
		final ImageIcon iconofoto = new ImageIcon(iconoContrato.getImage()
				.getScaledInstance(lbl_foto_contrato.getWidth(), lbl_foto_contrato.getHeight(), Image.SCALE_DEFAULT));
		lbl_foto_contrato.setIcon(iconofoto);

		JLabel lblFoto = new JLabel("4. Foto del contrato :");
		lblFoto.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblFoto.setBounds(27, 170, 136, 17);
		panelRegistro.add(lblFoto);

		btnSubirFotoContrato = new JButton("Subir");
		btnSubirFotoContrato.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				selecionarFoto();
			}
		});
		btnSubirFotoContrato.setBackground(new Color(250, 128, 114));
		btnSubirFotoContrato.setBounds(202, 172, 83, 23);
		panelRegistro.add(btnSubirFotoContrato);

		txtDireccionFotoContrato = new JTextField();
		txtDireccionFotoContrato.setEditable(false);
		txtDireccionFotoContrato.setColumns(10);
		txtDireccionFotoContrato.setBounds(27, 190, 136, 20);
		panelRegistro.add(txtDireccionFotoContrato);

		btnVerFotoContrato = new JButton("Ver");
		btnVerFotoContrato.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				verFotoContratoEmpleado();
			}
		});
		btnVerFotoContrato.setBackground(Color.WHITE);
		btnVerFotoContrato.setBounds(51, 222, 83, 23);
		panelRegistro.add(btnVerFotoContrato);

		lblNumeroDe = new JLabel("5. N\u00BA de Identidad :");
		lblNumeroDe.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblNumeroDe.setBounds(27, 256, 158, 17);
		panelRegistro.add(lblNumeroDe);

		MaskFormatter formato = null;
		try {
			formato = new MaskFormatter("####-####-#####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtIdentidadContratoEmpleado = new JFormattedTextField(formato);
		txtIdentidadContratoEmpleado.setColumns(10);
		txtIdentidadContratoEmpleado.setBounds(27, 276, 136, 20);
		txtIdentidadContratoEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		panelRegistro.add(txtIdentidadContratoEmpleado);
		InputMap map2 = txtIdentidadContratoEmpleado.getInputMap(JComponent.WHEN_FOCUSED);
		map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtIdentidadContratoEmpleado.addKeyListener(new KeyListener() {
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

		JLabel lblLibreta = new JLabel();
		lblLibreta.setBounds(0, 0, 341, 450);
		panelRegistro.add(lblLibreta);
		final ImageIcon logo = new ImageIcon(
				icono.getImage().getScaledInstance(lblLibreta.getWidth(), lblLibreta.getHeight(), Image.SCALE_DEFAULT));
		lblLibreta.setIcon(logo);

		JPanel panelTablaCargos = new JPanel();
		panelTablaCargos.setLayout(null);
		panelTablaCargos.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		panelTablaCargos.setBackground(Color.WHITE);
		panelTablaCargos.setBounds(388, 61, 431, 449);
		contentPane.add(panelTablaCargos);

		JLabel lblCargosRegistrados = new JLabel("Contratos registrados :");
		lblCargosRegistrados.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblCargosRegistrados.setBounds(30, 41, 166, 19);
		panelTablaCargos.add(lblCargosRegistrados);

		JLabel lblBuscarContrato = new JLabel("Buscar Contrato :");
		lblBuscarContrato.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblBuscarContrato.setBounds(30, 63, 119, 22);
		panelTablaCargos.add(lblBuscarContrato);

		txtBusquedaContratosEmpleados = new JTextField();
		txtBusquedaContratosEmpleados.setHorizontalAlignment(SwingConstants.CENTER);
		txtBusquedaContratosEmpleados.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtBusquedaContratosEmpleados.setColumns(10);
		txtBusquedaContratosEmpleados.setBounds(138, 64, 209, 21);
		panelTablaCargos.add(txtBusquedaContratosEmpleados);
		InputMap map4 = txtBusquedaContratosEmpleados.getInputMap(JComponent.WHEN_FOCUSED);
		txtBusquedaContratosEmpleados.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				trsfiltroCodigo = new TableRowSorter(tablaContratosEmpleados.getModel());
				tablaContratosEmpleados.setRowSorter(trsfiltroCodigo);
			}

			@Override
			public void keyPressed(KeyEvent ke) {

			}

			@Override
			public void keyReleased(KeyEvent ke) {
				String cadena = (txtBusquedaContratosEmpleados.getText());
				txtBusquedaContratosEmpleados.setText(cadena);
				repaint();
				filtro();
			}
		});

		btnBorrarContrato = new JButton("Borrar");
		btnBorrarContrato.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnBorrarContrato.setBackground(new Color(220, 20, 60));
		btnBorrarContrato.setBounds(30, 395, 99, 23);
		panelTablaCargos.add(btnBorrarContrato);

		barraContratos = new JScrollPane(tablaContratosEmpleados, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panelTablaCargos.add(barraContratos);
		barraContratos.setBounds(28, 90, 376, 294);

		tablaContratosEmpleados = new JTable();
		barraContratos.setViewportView(tablaContratosEmpleados);

		JLabel label_2 = new JLabel();
		label_2.setBounds(355, 41, 49, 44);
		panelTablaCargos.add(label_2);
		final ImageIcon logo2 = new ImageIcon(
				iconopeq.getImage().getScaledInstance(label_2.getWidth(), label_2.getHeight(), Image.SCALE_DEFAULT));
		label_2.setIcon(logo2);

		btnActualizarDatosContrato = new JButton("Actualizar Datos");
		btnActualizarDatosContrato.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnActualizarDatosContrato.setBackground(new Color(60, 179, 113));
		btnActualizarDatosContrato.setBounds(267, 396, 137, 23);
		panelTablaCargos.add(btnActualizarDatosContrato);

		btnMostrarContrato = new JButton("Ver detalles");
		btnMostrarContrato.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnMostrarContrato.setBackground(new Color(0, 206, 209));
		btnMostrarContrato.setBounds(149, 395, 108, 23);
		panelTablaCargos.add(btnMostrarContrato);

		JLabel label_5 = new JLabel();
		label_5.setBounds(0, 0, 431, 449);
		panelTablaCargos.add(label_5);
		final ImageIcon logo1 = new ImageIcon(
				icono.getImage().getScaledInstance(label_5.getWidth(), label_5.getHeight(), Image.SCALE_DEFAULT));
		label_5.setIcon(logo1);
		map4.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

	}

	public void construirTabla() {
		String titulos[] = { "Codigo", "Identidad", "Tipo", "Tiempo", "Foto" };
		String informacion[][] = control_contrato_empleado.obtenerMatriz();
		tablaContratosEmpleados = new JTable(informacion, titulos);
		barraContratos.setViewportView(tablaContratosEmpleados);
		for (int c = 0; c < tablaContratosEmpleados.getColumnCount(); c++) {
			Class<?> col_class = tablaContratosEmpleados.getColumnClass(c);
			tablaContratosEmpleados.setDefaultEditor(col_class, null);
			tablaContratosEmpleados.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			tablaContratosEmpleados.getTableHeader().setReorderingAllowed(false);

		}
	}

	public void filtro() {
		filtroCodigo = txtBusquedaContratosEmpleados.getText();
		trsfiltroCodigo
				.setRowFilter(RowFilter.regexFilter(txtBusquedaContratosEmpleados.getText(), 0, 1, 2, 3, 4, 5, 6));
	}

	public void pistas() {
		pista = new PlaceHolder(txtBusquedaContratosEmpleados, "Escriba para buscar.");
	}

	public void selecionarFoto() {
		JFileChooser archivo = new JFileChooser();
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Formatos de Archivos JPEG(*.JPG;*.JPEG)", "jpg",
				"jpeg");
		archivo.addChoosableFileFilter(filtro);
		archivo.setDialogTitle("Abrir Archivo");
		File ruta = new File("C:\\Users\\hp\\Documents\\GitHub\\Proyecto_Administrativo\\fotografias_empleados");
		archivo.setCurrentDirectory(ruta);
		int ventana = archivo.showOpenDialog(null);
		if (ventana == JFileChooser.APPROVE_OPTION) {
			File file = archivo.getSelectedFile();
			txtDireccionFotoContrato.setText(String.valueOf(file));
			Image foto = getToolkit().getImage(txtDireccionFotoContrato.getText());
			foto = foto.getScaledInstance(lbl_foto_contrato.getHeight(), lbl_foto_contrato.getWidth(),
					Image.SCALE_DEFAULT);
			lbl_foto_contrato.setIcon(new ImageIcon(foto));
		}
	}

	public void obtenerUltimoId() {
		String ultimoValor = null;
		int valor;
		String id = null;
		conexion objCon = new conexion();
		Connection conn = objCon.getConexion();
		try {
			PreparedStatement stmtr = conn
					.prepareStatement("SELECT * FROM contrato_empleado ORDER BY id_contrato_empleado DESC");
			ResultSet rsr = stmtr.executeQuery();
			if (rsr.next()) {
				ultimoValor = rsr.getString("id_contrato_empleado");
				valor = Integer.parseInt(ultimoValor);
				valor = valor + 1;
				id = String.valueOf(valor);
			}
			txtCodigoContratoEmpleado.setText(id);
			;
			stmtr.close();
			rsr.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verFotoContratoEmpleado() {
		if (txtDireccionFotoContrato.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hay imagen que mostrar");
		} else {
			visor_imagen visor = new visor_imagen();
			ruta = txtDireccionFotoContrato.getText().toString();
			visor.txtRutaImagen.setText(ruta);
			visor.setVisible(true);
			visor.setLocationRelativeTo(null);
			imagen = new ImageIcon(ruta);
			visor_imagen.lblImagen.setIcon(imagen);
		}
	}
}
