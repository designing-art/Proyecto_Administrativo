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

public class historial_planillas extends JFrame {

	public JPanel contentPane;
	public JPanel panel_2;
	public JLabel label_8;
	public JTextField txtBusquedaPlanilla;
	public JTextField txtTotalPlanilla;
	public JButton button;
	public PlaceHolder pista;

	public JButton btnBorrarPlanilla;
	public JButton btnActualizarDatosPlanilla;
	public JLabel lblTotalDeducciones;
	public JTextFieldDateEditor editor;

	public JScrollPane barraTablaPlanilla;
	public JTable tablaPlanilla;

	public TableRowSorter trsfiltro;
	String filtro;

	public static String ruta;
	public static ImageIcon imagen;

	public static String bonificaciones = null;
	public static String deducciones = null;
	public JLabel label;
	public JLabel lblPlanillaCanal;
	public JPanel panel_3;
	public JLabel lbl_hora;
	public JPanel panel_4;
	public JLabel label_17;
	public static String hora_fecha_reporte;

	public historial_planillas() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 610, 646);
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
		panel_2.setBounds(10, 33, 584, 575);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblBuscarDeduccion = new JLabel("Buscar planilla :");
		lblBuscarDeduccion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblBuscarDeduccion.setBounds(37, 104, 136, 22);
		panel_2.add(lblBuscarDeduccion);

		txtBusquedaPlanilla = new JTextField();
		txtBusquedaPlanilla.setHorizontalAlignment(SwingConstants.CENTER);
		InputMap map41 = txtBusquedaPlanilla.getInputMap(JComponent.WHEN_FOCUSED);
		map41.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtBusquedaPlanilla.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtBusquedaPlanilla.setColumns(10);
		txtBusquedaPlanilla.setBounds(145, 104, 260, 23);
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

		JLabel label_10 = new JLabel();
		label_10.setBounds(494, 61, 49, 44);
		panel_2.add(label_10);
		final ImageIcon logo2 = new ImageIcon(
				icono2.getImage().getScaledInstance(label_10.getWidth(), label_10.getHeight(), Image.SCALE_DEFAULT));
		label_10.setIcon(logo2);

		JLabel lblDeduccionesRegistradas = new JLabel("Empleados agregados a la planilla.");
		lblDeduccionesRegistradas.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblDeduccionesRegistradas.setBounds(37, 75, 283, 29);
		panel_2.add(lblDeduccionesRegistradas);

		btnBorrarPlanilla = new JButton("Borrar");
		btnBorrarPlanilla.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnBorrarPlanilla.setBackground(new Color(220, 20, 60));
		btnBorrarPlanilla.setBounds(37, 513, 99, 23);
		panel_2.add(btnBorrarPlanilla);

		btnActualizarDatosPlanilla = new JButton("Actualizar");
		btnActualizarDatosPlanilla.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnActualizarDatosPlanilla.setBackground(new Color(60, 179, 113));
		btnActualizarDatosPlanilla.setBounds(444, 513, 99, 23);
		panel_2.add(btnActualizarDatosPlanilla);

		barraTablaPlanilla = new JScrollPane((Component) null, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		barraTablaPlanilla.setBounds(38, 137, 505, 334);
		panel_2.add(barraTablaPlanilla);

		lblTotalDeducciones = new JLabel("Total Pago :");
		lblTotalDeducciones.setBounds(37, 480, 87, 22);
		panel_2.add(lblTotalDeducciones);
		lblTotalDeducciones.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));

		txtTotalPlanilla = new JTextField();
		txtTotalPlanilla.setBounds(156, 480, 164, 20);
		panel_2.add(txtTotalPlanilla);
		txtTotalPlanilla.setEditable(false);
		txtTotalPlanilla.setColumns(10);
		txtTotalPlanilla.setHorizontalAlignment(SwingConstants.RIGHT);

		JButton btnCalcularPlanilla = new JButton("Calcular");
		btnCalcularPlanilla.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				totalizar();
			}
		});
		btnCalcularPlanilla.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 10));
		btnCalcularPlanilla.setBounds(330, 480, 82, 21);
		panel_2.add(btnCalcularPlanilla);
		btnCalcularPlanilla.setBackground(new Color(60, 179, 113));

		label = new JLabel("L.");
		label.setBounds(134, 482, 28, 18);
		panel_2.add(label);
		label.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));

		lblPlanillaCanal = new JLabel("Historial de planillas");
		lblPlanillaCanal.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		lblPlanillaCanal.setBounds(39, 54, 188, 19);
		panel_2.add(lblPlanillaCanal);

		panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(355, 83, 129, 18);
		panel_2.add(panel_3);

		panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(224, 49, 260, 24);
		panel_2.add(panel_4);

		label_17 = new JLabel();
		label_17.setBounds(10, 0, 253, 35);
		panel_4.add(label_17);
		label_17.setText("Dia jueves 25 de abril del 2019");
		label_17.setHorizontalAlignment(SwingConstants.CENTER);
		label_17.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		label_17.setBackground(Color.WHITE);

		label_8 = new JLabel("");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setBounds(0, 0, 584, 575);
		panel_2.add(label_8);
		final ImageIcon logo = new ImageIcon(
				icono.getImage().getScaledInstance(label_8.getWidth(), label_8.getHeight(), Image.SCALE_DEFAULT));
		label_8.setIcon(logo);

		lbl_hora = new JLabel();
		lbl_hora.setBounds(372, 49, 123, 22);
		panel_2.add(lbl_hora);
		lbl_hora.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_hora.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		lbl_hora.setBackground(SystemColor.menu);

		JLabel lblRegistroYMantenimiento = new JLabel("HISTORIAL DE PLANILLAS REGISTRADAS");
		lblRegistroYMantenimiento.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblRegistroYMantenimiento.setBounds(10, 1, 551, 39);
		contentPane.add(lblRegistroYMantenimiento);

		MaskFormatter formato = null;
		try {
			formato = new MaskFormatter("####-####-#####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		editor.setEditable(false);
		editor.setHorizontalAlignment(SwingConstants.CENTER);

		button = new JButton("Regresar");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ventana_principal principal = new ventana_principal();
				principal.setVisible(true);
				principal.setLocationRelativeTo(null);
				dispose();
				Timer time = new Timer();
				time.schedule(principal.tarea, 0, 1000);
			}
		});
		button.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		button.setBackground(new Color(255, 127, 80));
		button.setBounds(492, 1, 102, 26);
		contentPane.add(button);
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

	public void totalizar() {
		double t = 0;
		double p = 0;
		if (tablaPlanilla.getRowCount() > 0) {
			for (int i = 0; i < tablaPlanilla.getRowCount(); i++) {
				p = Double.parseDouble(tablaPlanilla.getValueAt(i, 11).toString());
				t += p;
			}
			txtTotalPlanilla.setText(String.valueOf(t));
		} else {
			JOptionPane.showMessageDialog(null, "No hay datos que totalizar");
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
				JOptionPane.showMessageDialog(jTable, "Print complete (Impresi�n completa)",
						"Print result (Resultado de la impresi�n)", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(jTable, "Print canceled (Impresi�n cancelada)",
						"Print result (Resultado de la impresi�n)", JOptionPane.WARNING_MESSAGE);
			}
		} catch (PrinterException pe) {
			JOptionPane.showMessageDialog(jTable, "Print fail (Fallo de impresi�n): " + pe.getMessage(),
					"Print result (Resultado de la impresi�n)", JOptionPane.ERROR_MESSAGE);
		}
	}
}