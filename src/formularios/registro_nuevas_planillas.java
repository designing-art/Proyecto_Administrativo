package formularios;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;
import javax.swing.text.MaskFormatter;

import com.placeholder.PlaceHolder;

import clases.bonificacion;
import clases.deduccion;
import clases.empleado;
import conexion.conexion;
import consultas.consultas_bonificacion;
import consultas.consultas_deduccion;
import consultas.consultas_planilla;
import controles.control_bonificacion;
import controles.control_deduccion;
import controles.control_planilla;
import utilidades.visor_imagen;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.RowFilter;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Event;

import javax.swing.ScrollPaneConstants;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import javax.swing.JToggleButton;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.border.MatteBorder;

public class registro_nuevas_planillas extends JFrame {

	public JPanel contentPane;
	public JPanel panel_2;
	public JLabel label_8;
	public JTextField txtBusquedaPlanilla;
	public JButton btnAceptar;
	public JButton btnGuardar;
	public JButton btnActualizar;
	public JButton btnBorrar;
	public JButton btnNuevo;
	
	public PlaceHolder pista;
	public JComboBox cbxEstadoPlanilla;
	 
	public JButton btnBorrarPlanilla;
	public JButton btnVerPlanilla;
	public JButton btnActualizarDatosPlanilla;
	public JTextFieldDateEditor editor;
	public JTextFieldDateEditor editor2;

	public JScrollPane barraTablaPlanilla;
	public JTable tablaPlanilla;

	public TableRowSorter trsfiltro;
	String filtro;

	public static String ruta;
	public static ImageIcon imagen;

	public JButton btnImprimir;
	public JLabel lblCrearNuevaPlanilla;
	public JLabel lblNewLabel;
	public JTextField txtCodigoPlanilla;
	public JTextField txtNombrePlanilla;
	public JTextField txtTotalSueldos;
	public JTextField txtTotalBonos;
	public JTextField txtTotalDeducciones;
	public JTextField txtTotalPlanilla;
	public JDateChooser dateRegistro;
	public JDateChooser datePago;
	
	

	public static String bonificaciones = null;
	public static String deducciones = null;
	public JLabel lblPlanillaCanal;
	public JPanel panel_3;
	public JLabel lbl_hora;
	public JPanel panel_4;
	public JLabel label_17;
	public static String hora_fecha_reporte;

	public registro_nuevas_planillas() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 761, 575);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/material/logo.png")));
		final ImageIcon icono = new ImageIcon(getClass().getResource("/material/libreta.png"));
		final ImageIcon icono2 = new ImageIcon(getClass().getResource("/material/logo.png"));
		final ImageIcon usuario = new ImageIcon(getClass().getResource("/material/usuario.png"));

		panel_2 = new JPanel();
		panel_2.setBounds(316, 36, 430, 496);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblBuscarDeduccion = new JLabel("Buscar :");
		lblBuscarDeduccion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblBuscarDeduccion.setBounds(28, 112, 136, 22);
		panel_2.add(lblBuscarDeduccion);

		txtBusquedaPlanilla = new JTextField();
		txtBusquedaPlanilla.setHorizontalAlignment(SwingConstants.CENTER);
		InputMap map41 = txtBusquedaPlanilla.getInputMap(JComponent.WHEN_FOCUSED);
		map41.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtBusquedaPlanilla.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtBusquedaPlanilla.setColumns(10);
		txtBusquedaPlanilla.setBounds(86, 114, 315, 18);
		panel_2.add(txtBusquedaPlanilla);
		txtBusquedaPlanilla.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				trsfiltro = new TableRowSorter(tablaPlanilla.getModel());
				tablaPlanilla.setRowSorter(trsfiltro);
			}

			@Override
			public void keyPressed(KeyEvent ke) {

			}

			@Override
			public void keyReleased(KeyEvent ke) {
				String cadena = (txtBusquedaPlanilla.getText());
				txtBusquedaPlanilla.setText(cadena);
				repaint();
				filtro();
			}
		});

		btnBorrarPlanilla = new JButton("Borrar");
		btnBorrarPlanilla.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnBorrarPlanilla.setBackground(new Color(220, 20, 60));
		btnBorrarPlanilla.setBounds(28, 440, 99, 23);
		panel_2.add(btnBorrarPlanilla);

		btnVerPlanilla = new JButton("Ver detalles");
		btnVerPlanilla.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnVerPlanilla.setBackground(new Color(0, 206, 209));
		btnVerPlanilla.setBounds(147, 440, 108, 23);
		panel_2.add(btnVerPlanilla);

		btnActualizarDatosPlanilla = new JButton("Actualizar Datos");
		btnActualizarDatosPlanilla.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnActualizarDatosPlanilla.setBackground(new Color(60, 179, 113));
		btnActualizarDatosPlanilla.setBounds(265, 441, 137, 23);
		panel_2.add(btnActualizarDatosPlanilla);

		barraTablaPlanilla = new JScrollPane((Component) null, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		barraTablaPlanilla.setBounds(28, 137, 376, 298);
		panel_2.add(barraTablaPlanilla);

		lblPlanillaCanal = new JLabel("Historial Planillas");
		lblPlanillaCanal.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlanillaCanal.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		lblPlanillaCanal.setBounds(28, 50, 227, 22);
		panel_2.add(lblPlanillaCanal);

		panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(283, 79, 116, 22);
		panel_2.add(panel_3);

		lbl_hora = new JLabel();
		lbl_hora.setBounds(0, 0, 116, 22);
		panel_3.add(lbl_hora);
		lbl_hora.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_hora.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		lbl_hora.setBackground(SystemColor.menu);

		panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(28, 79, 253, 22);
		panel_2.add(panel_4);

		label_17 = new JLabel();
		label_17.setBounds(0, 0, 238, 22);
		panel_4.add(label_17);
		label_17.setText("Dia jueves 25 de abril del 2019");
		label_17.setHorizontalAlignment(SwingConstants.CENTER);
		label_17.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		label_17.setBackground(Color.WHITE);

		btnImprimir = new JButton("Imprimir Reporte");
		btnImprimir.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnImprimir.setBackground(new Color(60, 179, 113));
		btnImprimir.setBounds(265, 52, 137, 21);
		panel_2.add(btnImprimir);
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date date = new Date();
				DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
				hora_fecha_reporte = ("Hora y fecha del reporte : " + hourdateFormat.format(date));
				utilJTablePrint(tablaPlanilla, "Canal 40 (COFFEE TV CHANNEL)",
						"Reporte de la Planilla.____. " + hora_fecha_reporte, true);
			}
		});

		label_8 = new JLabel("");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setBounds(0, 0, 430, 496);
		panel_2.add(label_8);
		final ImageIcon logo = new ImageIcon(
				icono.getImage().getScaledInstance(label_8.getWidth(), label_8.getHeight(), Image.SCALE_DEFAULT));
		label_8.setIcon(logo);

		JLabel lblRegistroYMantenimiento = new JLabel("REGISTRO Y MANTENIMIENTO DE HISTORIAL DE PLANILLAS");
		lblRegistroYMantenimiento.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblRegistroYMantenimiento.setBounds(10, 0, 698, 40);
		contentPane.add(lblRegistroYMantenimiento);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 36, 286, 496);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		lblCrearNuevaPlanilla = new JLabel("Informaci\u00F3n de la planilla.");
		lblCrearNuevaPlanilla.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrearNuevaPlanilla.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		lblCrearNuevaPlanilla.setBounds(22, 41, 221, 22);
		panel_1.add(lblCrearNuevaPlanilla);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBounds(22, 74, 242, 327);
		panel_1.add(panel);
		panel.setLayout(null);

		lblNewLabel = new JLabel("C\u00F3digo :");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 11, 63, 20);
		panel.add(lblNewLabel);

		txtCodigoPlanilla = new JTextField();
		txtCodigoPlanilla.setEditable(false);
		txtCodigoPlanilla.setBounds(83, 12, 46, 20);
		panel.add(txtCodigoPlanilla);
		txtCodigoPlanilla.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblNombre.setBounds(10, 42, 74, 20);
		panel.add(lblNombre);

		txtNombrePlanilla = new JTextField();
		txtNombrePlanilla.setColumns(10);
		txtNombrePlanilla.setBounds(81, 42, 148, 20);
		panel.add(txtNombrePlanilla);

		JLabel lblFechaDePago = new JLabel("Fecha de pago :");
		lblFechaDePago.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblFechaDePago.setBounds(10, 73, 119, 20);
		panel.add(lblFechaDePago);

		datePago = new JDateChooser();
		datePago.setBounds(113, 73, 116, 20);
		panel.add(datePago);
		editor = (JTextFieldDateEditor) datePago.getDateEditor();
		editor.setEditable(false);
		editor.setHorizontalAlignment(SwingConstants.CENTER);
		datePago.setVisible(false);

		JLabel lblEstado = new JLabel("Estado :");
		lblEstado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblEstado.setBounds(10, 296, 91, 20);
		panel.add(lblEstado);

		cbxEstadoPlanilla = new JComboBox();
		cbxEstadoPlanilla.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		cbxEstadoPlanilla.setModel(new DefaultComboBoxModel(new String[] { "Planilla Vigente", "Planilla Cerrada" }));
		cbxEstadoPlanilla.setBounds(66, 296, 125, 20);
		panel.add(cbxEstadoPlanilla);

		JLabel lblTotalSueldosPlanilla = new JLabel("Total Sueldos Planilla");
		lblTotalSueldosPlanilla.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblTotalSueldosPlanilla.setBounds(10, 106, 139, 14);
		panel.add(lblTotalSueldosPlanilla);

		JLabel label_1 = new JLabel("L.");
		label_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		label_1.setBounds(10, 126, 18, 18);
		panel.add(label_1);

		txtTotalSueldos = new JTextField();
		txtTotalSueldos.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTotalSueldos.setEditable(false);
		txtTotalSueldos.setColumns(10);
		txtTotalSueldos.setBounds(27, 126, 116, 20);
		panel.add(txtTotalSueldos);

		JLabel label_3 = new JLabel("L.");
		label_3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		label_3.setBounds(10, 178, 18, 18);
		panel.add(label_3);

		txtTotalBonos = new JTextField();
		txtTotalBonos.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTotalBonos.setEditable(false);
		txtTotalBonos.setColumns(10);
		txtTotalBonos.setBounds(27, 177, 116, 20);
		panel.add(txtTotalBonos);

		JLabel label_5 = new JLabel("L.");
		label_5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		label_5.setBounds(10, 232, 18, 18);
		panel.add(label_5);

		txtTotalDeducciones = new JTextField();
		txtTotalDeducciones.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTotalDeducciones.setEditable(false);
		txtTotalDeducciones.setColumns(10);
		txtTotalDeducciones.setBounds(27, 230, 116, 20);
		panel.add(txtTotalDeducciones);

		JLabel lblTotalBonificacionesPlanilla = new JLabel("Total Bonificaciones Planilla");
		lblTotalBonificacionesPlanilla.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblTotalBonificacionesPlanilla.setBounds(10, 155, 195, 14);
		panel.add(lblTotalBonificacionesPlanilla);

		JLabel lblTotalDeduccionesPlanilla = new JLabel("Total Deducciones Planilla");
		lblTotalDeduccionesPlanilla.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblTotalDeduccionesPlanilla.setBounds(10, 207, 181, 14);
		panel.add(lblTotalDeduccionesPlanilla);

		JLabel lblTotalPlanilla = new JLabel("Total Planilla : ");
		lblTotalPlanilla.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblTotalPlanilla.setBounds(10, 265, 100, 20);
		panel.add(lblTotalPlanilla);

		txtTotalPlanilla = new JTextField();
		txtTotalPlanilla.setEditable(false);
		txtTotalPlanilla.setColumns(10);
		txtTotalPlanilla.setBounds(113, 265, 116, 20);
		panel.add(txtTotalPlanilla);

		dateRegistro = new JDateChooser();
		dateRegistro.setBounds(139, 11, 90, 20);
		panel.add(dateRegistro);
		editor2 = (JTextFieldDateEditor) dateRegistro.getDateEditor();
		dateRegistro.setVisible(false);
		editor2.setEditable(false);
		editor2.setHorizontalAlignment(SwingConstants.CENTER);
		dateRegistro.setVisible(false);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnAceptar.setBackground(Color.WHITE);
		btnAceptar.setBounds(22, 415, 99, 23);
		panel_1.add(btnAceptar);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnNuevo.setBackground(Color.WHITE);
		btnNuevo.setBounds(22, 440, 99, 23);
		panel_1.add(btnNuevo);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnActualizar.setBackground(new Color(60, 179, 113));
		btnActualizar.setBounds(162, 415, 99, 23);
		panel_1.add(btnActualizar);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnGuardar.setBackground(new Color(60, 179, 113));
		btnGuardar.setBounds(162, 440, 99, 23);
		panel_1.add(btnGuardar);

		JLabel label_7 = new JLabel("");
		label_7.setBounds(0, 0, 286, 496);
		panel_1.add(label_7);
		final ImageIcon logo21 = new ImageIcon(
				icono.getImage().getScaledInstance(label_7.getWidth(), label_7.getHeight(), Image.SCALE_DEFAULT));
		label_7.setIcon(logo21);
	}

	public void establecerFechaRegistro() {
		try {
			LocalDate fechaActual = LocalDate.now();
			Date date = Date.from(fechaActual.atStartOfDay(ZoneId.systemDefault()).toInstant());
			dateRegistro.setDate(date);
		} catch (Exception e) {

		}

	}

	public void construirTabla() {
		String titulos[] = { "Codigo", "Tipo", "Fecha", "Nombres", "Apellidos", "Identidad", "Cargo", "Sueldo",
				"Deducciones", "Bonificaciones", "Sueldo Neto", "Total" };
		String informacion[][] = control_planilla.obtenerMatriz();
		tablaPlanilla = new JTable(informacion, titulos);
		barraTablaPlanilla.setViewportView(tablaPlanilla);
		for (int c = 0; c < tablaPlanilla.getColumnCount(); c++) {
			Class<?> col_class = tablaPlanilla.getColumnClass(c);
			tablaPlanilla.setDefaultEditor(col_class, null);
			tablaPlanilla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			tablaPlanilla.getTableHeader().setReorderingAllowed(false);

			DefaultTableCellRenderer tcr;
			tcr = new DefaultTableCellRenderer();
			tcr.setHorizontalAlignment(SwingConstants.RIGHT);
			tablaPlanilla.getColumnModel().getColumn(11).setCellRenderer(tcr);
			tablaPlanilla.getColumnModel().getColumn(10).setCellRenderer(tcr);
			tablaPlanilla.getColumnModel().getColumn(9).setCellRenderer(tcr);
			tablaPlanilla.getColumnModel().getColumn(8).setCellRenderer(tcr);
			tablaPlanilla.getColumnModel().getColumn(7).setCellRenderer(tcr);
		}
	}

	public void filtro() {
		filtro = txtBusquedaPlanilla.getText();
		trsfiltro.setRowFilter(RowFilter.regexFilter(txtBusquedaPlanilla.getText(), 0, 1, 2, 3, 4));
	}

	public void pistas() {
		pista = new PlaceHolder(txtBusquedaPlanilla, "Escriba para buscar.");
		pista = new PlaceHolder(txtNombrePlanilla, "Escriba el nombre de la planilla.");
	}

	public void obtenerUltimoId() {
		String ultimoValor = null;
		int valor;
		String id = null;
		conexion objCon = new conexion();
		Connection conn = objCon.getConexion();
		try {
			PreparedStatement stmtr = conn.prepareStatement("SELECT * FROM planillas ORDER BY id_planilla DESC");
			ResultSet rsr = stmtr.executeQuery();
			if (rsr.next()) {
				ultimoValor = rsr.getString("id_planilla");
				valor = Integer.parseInt(ultimoValor);
				valor = valor + 1;
				id = String.valueOf(valor);
			}
			txtCodigoPlanilla.setText(id);
			;
			stmtr.close();
			rsr.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	Timer time = new Timer();
	public TimerTask tarea = new TimerTask() {
		@Override
		public void run() {
			Calendar calendario = new GregorianCalendar();
			Date fechaHoraActual = new Date();
			calendario.setTime(fechaHoraActual);
			String horas;
			String minutos;
			String segundos;
			String ampm;
			Thread hilo = null;
			Thread hilo2;
			hilo2 = Thread.currentThread();
			hilo = new Thread();
			hilo.start();
			ampm = calendario.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";
			if (ampm.equals("PM")) {
				int h = calendario.get(Calendar.HOUR_OF_DAY) - 12;
				horas = h > 9 ? "" + h : "0" + h;
			} else {
				horas = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY)
						: "0" + calendario.get(Calendar.HOUR_OF_DAY);
			}
			minutos = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE)
					: "0" + calendario.get(Calendar.MINUTE);
			segundos = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND)
					: "0" + calendario.get(Calendar.SECOND);

			lbl_hora.setText(horas + ":" + minutos + ":" + segundos + " " + ampm);
		}
	};

	public static String getFecha() {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		SimpleDateFormat df = new SimpleDateFormat("'Dia' EEEEEEEEE dd 'de' MMMMM 'del' yyyy");
		date = cal.getTime();
		return df.format(date);
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
}
