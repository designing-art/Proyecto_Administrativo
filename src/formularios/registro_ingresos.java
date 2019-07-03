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
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;
import javax.swing.text.MaskFormatter;

import com.placeholder.PlaceHolder;

import clases.empleado;
import conexion.conexion;
import consultas.consultas_empleado;
import controles.control_cargo;
import controles.control_empleado;
import controles.control_sar;
import controles.control_venta;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

public class registro_ingresos extends JFrame {
	public JScrollPane scrollFunciones;
	public PlaceHolder pista;
	public JButton btnAtras;
	public JButton btnMostrar;
	public JButton btnAceptar;

	public int pagina = 0;

	public JPanel contentPane;
	public JTextField txtBusquedaCargos;
	public JScrollPane barraSar;
	public JTable tabla;
	public JTextField txtCodigo;

	public TableRowSorter trsfiltroCodigo;
	String filtroCodigo;
	public static String hora_fecha_reporte;
	public static String ruta_logo;

	public static JLabel label;
	public static JLabel label_2;
	public JTextFieldDateEditor editor;
	public JDateChooser dateFechaLimite;
	public JTextField txtIngreso;
	public JTextField txtCantidad;
	public JTextArea txtDescripcion;

	public registro_ingresos() {
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 850, 550);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/iconos/icono_d_a.jpg")));
		final ImageIcon icono = new ImageIcon(getClass().getResource("/iconos/libreta.png"));
		final ImageIcon icono2 = new ImageIcon(getClass().getResource("/iconos/libreta.png"));

		btnAtras = new JButton("Regresar");
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
				principal.consultarEmpresa();
			}
		});

		JLabel lblRegistrarCargo = new JLabel("INFORMACION DE LOS INGRESOS DE LA EMPRESA.");
		lblRegistrarCargo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblRegistrarCargo.setBounds(37, 0, 639, 39);
		contentPane.add(lblRegistrarCargo);
		scrollFunciones = new JScrollPane();

		JPanel panelTablaCargos = new JPanel();
		panelTablaCargos.setLayout(null);
		panelTablaCargos.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		panelTablaCargos.setBackground(Color.WHITE);
		panelTablaCargos.setBounds(388, 44, 431, 466);
		contentPane.add(panelTablaCargos);

		JLabel lblCargosRegistrados = new JLabel("Registros de ingresos :");
		lblCargosRegistrados.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblCargosRegistrados.setBounds(30, 41, 166, 19);
		panelTablaCargos.add(lblCargosRegistrados);

		JLabel lblBuscarRegistroDe = new JLabel("Buscar  ingresos :");
		lblBuscarRegistroDe.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblBuscarRegistroDe.setBounds(30, 63, 166, 22);
		panelTablaCargos.add(lblBuscarRegistroDe);

		txtBusquedaCargos = new JTextField();
		txtBusquedaCargos.setHorizontalAlignment(SwingConstants.CENTER);
		txtBusquedaCargos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtBusquedaCargos.setColumns(10);
		txtBusquedaCargos.setBounds(152, 64, 195, 21);
		panelTablaCargos.add(txtBusquedaCargos);
		InputMap map4 = txtBusquedaCargos.getInputMap(JComponent.WHEN_FOCUSED);
		txtBusquedaCargos.addKeyListener(new KeyListener() {
			@Override
			// metodo para buscar en la tabla
			public void keyTyped(KeyEvent ke) {
				trsfiltroCodigo = new TableRowSorter(tabla.getModel());
				tabla.setRowSorter(trsfiltroCodigo);
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

		barraSar = new JScrollPane(tabla, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panelTablaCargos.add(barraSar);
		barraSar.setBounds(28, 90, 376, 314);

		tabla = new JTable();
		barraSar.setViewportView(tabla);

		label_2 = new JLabel();
		label_2.setBounds(355, 41, 49, 44);
		panelTablaCargos.add(label_2);

		btnMostrar = new JButton("Ver detalles");
		btnMostrar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnMostrar.setBackground(new Color(0, 206, 209));
		btnMostrar.setBounds(296, 417, 108, 23);
		panelTablaCargos.add(btnMostrar);

		JButton btnImprimirReporte = new JButton("Imprimir Reporte");
		btnImprimirReporte.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String ampm;
				String horas;
				Calendar cal = new GregorianCalendar();
				ampm = cal.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";
				if (ampm.equals("PM")) {
					int h = cal.get(Calendar.HOUR_OF_DAY) - 12;
					horas = h > 9 ? "" + h : "0" + h;
				} else {
					horas = cal.get(Calendar.HOUR_OF_DAY) > 9 ? "" + cal.get(Calendar.HOUR_OF_DAY)
							: "0" + cal.get(Calendar.HOUR_OF_DAY);
				}
				String fecha = getFechaYHora() + ampm;
				String nombreEmpresa = ventana_principal.lbl_nombre_empresa_principal.getText();
				String encabezado = "Reporte de cargos de " + nombreEmpresa;
				utilJTablePrint(tabla, encabezado,
						"Pagina {0}" + "                                             " + fecha, true);
			}
		});
		btnImprimirReporte.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnImprimirReporte.setBackground(new Color(60, 179, 113));
		btnImprimirReporte.setBounds(204, 40, 143, 19);
		panelTablaCargos.add(btnImprimirReporte);

		JLabel label_5 = new JLabel();
		label_5.setBounds(0, 0, 431, 466);
		panelTablaCargos.add(label_5);
		final ImageIcon logo1 = new ImageIcon(
				icono.getImage().getScaledInstance(label_5.getWidth(), label_5.getHeight(), Image.SCALE_DEFAULT));
		label_5.setIcon(logo1);

		JPanel panelRegistro = new JPanel();
		panelRegistro.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		panelRegistro.setBounds(37, 130, 341, 279);
		contentPane.add(panelRegistro);
		panelRegistro.setLayout(null);

		label = new JLabel();
		label.setBounds(265, 29, 49, 44);
		panelRegistro.add(label);

		JLabel lblHoraExtraCargo = new JLabel("3. Fecha de registro :");
		lblHoraExtraCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblHoraExtraCargo.setBounds(24, 200, 196, 20);
		panelRegistro.add(lblHoraExtraCargo);

		JLabel lblTipoDeCargo = new JLabel("2. Ingreso por :");
		lblTipoDeCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblTipoDeCargo.setBounds(24, 84, 105, 18);
		panelRegistro.add(lblTipoDeCargo);

		JLabel lblCodigoCargo = new JLabel("1. C\u00F3digo :");
		lblCodigoCargo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblCodigoCargo.setBounds(24, 59, 63, 14);
		panelRegistro.add(lblCodigoCargo);

		JLabel lblRegistroCargos = new JLabel("Datos del registro del ingreso :");
		lblRegistroCargos.setBounds(24, 23, 254, 32);
		panelRegistro.add(lblRegistroCargos);
		lblRegistroCargos.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));

		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(137, 55, 43, 18);
		panelRegistro.add(txtCodigo);
		txtCodigo.setColumns(10);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnAceptar.setBackground(new Color(255, 255, 255));
		btnAceptar.setBounds(24, 231, 99, 23);
		panelRegistro.add(btnAceptar);

		MaskFormatter formato = null;
		try {
			formato = new MaskFormatter("#???#?-?###?#-#?##?#-####?#-#??###-#?");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		dateFechaLimite = new JDateChooser();
		dateFechaLimite.setBounds(159, 200, 155, 20);
		dateFechaLimite.setDateFormatString("dd-MMMMM-yyyy");
		panelRegistro.add(dateFechaLimite);
		editor = (JTextFieldDateEditor) dateFechaLimite.getDateEditor();
		editor.setEditable(false);
		editor.setHorizontalAlignment(SwingConstants.CENTER);

		MaskFormatter formato2 = null;
		try {
			formato2 = new MaskFormatter("###");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		MaskFormatter formato3 = null;
		try {
			formato3 = new MaskFormatter("###");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		MaskFormatter formato4 = null;
		try {
			formato4 = new MaskFormatter("##");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		MaskFormatter formato5 = null;
		try {
			formato5 = new MaskFormatter("########");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		MaskFormatter formato7 = null;
		try {
			formato7 = new MaskFormatter("###-###-##");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		txtIngreso = new JTextField();
		txtIngreso.setEditable(false);
		txtIngreso.setHorizontalAlignment(SwingConstants.CENTER);
		txtIngreso.setColumns(10);
		txtIngreso.setBounds(137, 84, 177, 19);
		panelRegistro.add(txtIngreso);

		JLabel lblCantidad = new JLabel("3. Cantidad :");
		lblCantidad.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblCantidad.setBounds(24, 113, 105, 18);
		panelRegistro.add(lblCantidad);

		txtCantidad = new JTextField();
		txtCantidad.setEditable(false);
		txtCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(137, 113, 177, 19);
		panelRegistro.add(txtCantidad);

		JLabel lblDescripcion = new JLabel("2. Descripcion :");
		lblDescripcion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblDescripcion.setBounds(24, 142, 105, 18);
		panelRegistro.add(lblDescripcion);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(137, 143, 177, 44);
		panelRegistro.add(scrollPane);

		txtDescripcion = new JTextArea();
		txtDescripcion.setEditable(false);
		scrollPane.setViewportView(txtDescripcion);

		JLabel lblImagenLibreta = new JLabel();
		lblImagenLibreta.setBounds(0, 0, 341, 279);
		panelRegistro.add(lblImagenLibreta);
		final ImageIcon logo = new ImageIcon(icono.getImage().getScaledInstance(lblImagenLibreta.getWidth(),
				lblImagenLibreta.getHeight(), Image.SCALE_DEFAULT));
		lblImagenLibreta.setIcon(logo);

		map4.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

	}

	public void construirTabla() {
		String titulos[] = { "Codigo", "Ingreso por", "Cantidad", "Descripcion", "Fecha"};
		String informacion[][] = control_venta.obtenerMatriz2();
		tabla = new JTable(informacion, titulos);
		barraSar.setViewportView(tabla);
		for (int c = 0; c < tabla.getColumnCount(); c++) {
			Class<?> col_class = tabla.getColumnClass(c);
			tabla.setDefaultEditor(col_class, null);
			tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			tabla.getTableHeader().setReorderingAllowed(false);
		}
	}

	public void filtro() {
		filtroCodigo = txtBusquedaCargos.getText();
		trsfiltroCodigo.setRowFilter(RowFilter.regexFilter(txtBusquedaCargos.getText(), 0, 1, 2, 3, 4, 5));
	}

	public void utilJTablePrint(JTable jTable, String header, String footer, boolean showPrintDialog) {
		boolean fitWidth = true;
		boolean interactive = true;
		JTable.PrintMode mode = fitWidth ? JTable.PrintMode.FIT_WIDTH : JTable.PrintMode.NORMAL;
		try {
			boolean complete = jTable.print(mode, new MessageFormat(header), new MessageFormat(footer), showPrintDialog,
					null, interactive);
			if (complete) {
				JOptionPane.showMessageDialog(jTable, "Print complete (Impresión completa)",
						"Print result (Resultado de la impresión)", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(jTable, "Print canceled (Impresión cancelada)",
						"Print result (Resultado de la impresión)", JOptionPane.WARNING_MESSAGE);
			}
		} catch (PrinterException pe) {
			JOptionPane.showMessageDialog(jTable, "Print fail (Fallo de impresión): " + pe.getMessage(),
					"Print result (Resultado de la impresión)", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static String getFechaYHora() {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		SimpleDateFormat df = new SimpleDateFormat("'Dia' EEEEEEEEE dd 'de' MMMMM 'del' yyyy 'a las' HH:mm:ss ");
		date = cal.getTime();
		return df.format(date);
	}

	public void consultarEmpresa() {
		conexion conex = new conexion();
		try {
			Statement estatuto = conex.getConexion().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT direccion_logo_empresa FROM empresa where id_empresa = 1");

			if (rs.next()) {
				ruta_logo = (rs.getString("direccion_logo_empresa"));
				final ImageIcon logo = new ImageIcon(ruta_logo);

				final ImageIcon icono = new ImageIcon(
						logo.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
				label.setIcon(icono);

				final ImageIcon icono2 = new ImageIcon(logo.getImage().getScaledInstance(label_2.getWidth(),
						label_2.getHeight(), Image.SCALE_DEFAULT));
				label_2.setIcon(icono2);
			} else {
				JOptionPane.showMessageDialog(null,
						"Para una mejor experiencia Personalice su empresa en :" + " MAS INFORMACIONS DE LA EMPRESA.");
			}
			rs.close();
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error al consultar", "Error", JOptionPane.ERROR_MESSAGE);

		}

	}
}
