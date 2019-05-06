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

public class registro_nuevas_planillas extends JFrame {

	public JPanel contentPane;
	public JPanel panel_2;
	public JLabel label_8;
	public JTextField txtBusquedaPlanilla;
	public JButton button;
	public PlaceHolder pista;

	public JButton btnBorrarPlanilla;
	public JButton btnVerPlanilla;
	public JButton btnActualizarDatosPlanilla;
	public JTextFieldDateEditor editor;

	public JScrollPane barraTablaPlanilla;
	public JTable tablaPlanilla;

	public TableRowSorter trsfiltro;
	String filtro;

	public static String ruta;
	public static ImageIcon imagen;

	public static String bonificaciones = null;
	public static String deducciones = null;
	public JLabel lblPlanillaCanal;
	public JPanel panel_3;
	public JLabel lbl_hora;
	public JPanel panel_4;
	public JLabel label_17;
	public static String hora_fecha_reporte;

	public registro_nuevas_planillas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 671);
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
		panel_2.setBounds(444, 46, 430, 575);
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
		btnBorrarPlanilla.setBounds(28, 513, 99, 23);
		panel_2.add(btnBorrarPlanilla);

		btnVerPlanilla = new JButton("Ver detalles");
		btnVerPlanilla.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnVerPlanilla.setBackground(new Color(0, 206, 209));
		btnVerPlanilla.setBounds(147, 513, 108, 23);
		panel_2.add(btnVerPlanilla);

		btnActualizarDatosPlanilla = new JButton("Actualizar Datos");
		btnActualizarDatosPlanilla.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnActualizarDatosPlanilla.setBackground(new Color(60, 179, 113));
		btnActualizarDatosPlanilla.setBounds(265, 514, 137, 23);
		panel_2.add(btnActualizarDatosPlanilla);

		barraTablaPlanilla = new JScrollPane((Component) null, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		barraTablaPlanilla.setBounds(28, 137, 376, 365);
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

		button_3 = new JButton("Imprimir Reporte");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date date = new Date();
				DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
				hora_fecha_reporte = ("Hora y fecha del reporte : " + hourdateFormat.format(date));
				utilJTablePrint(tablaPlanilla, "Canal 40 (COFFEE TV CHANNEL)",
						"Reporte de la Planilla.____. " + hora_fecha_reporte, true);
			}
		});
		button_3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		button_3.setBackground(new Color(60, 179, 113));
		button_3.setBounds(265, 52, 137, 21);
		panel_2.add(button_3);

		label_8 = new JLabel("");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setBounds(0, 0, 430, 575);
		panel_2.add(label_8);
		final ImageIcon logo = new ImageIcon(
				icono.getImage().getScaledInstance(label_8.getWidth(), label_8.getHeight(), Image.SCALE_DEFAULT));
		label_8.setIcon(logo);

		JLabel lblRegistroYMantenimiento = new JLabel("REGISTRO Y MANTENIMIENTO DE HISTORIAL DE PLANILLAS");
		lblRegistroYMantenimiento.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblRegistroYMantenimiento.setBounds(10, 1, 698, 39);
		contentPane.add(lblRegistroYMantenimiento);

		MaskFormatter formato = null;
		try {
			formato = new MaskFormatter("####-####-#####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		map42.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
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
				principal.consultarEmpresa();
			}
		});
		button.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		button.setBackground(new Color(255, 127, 80));
		button.setBounds(772, 12, 102, 23);
		contentPane.add(button);
				
						JPanel panel_1 = new JPanel();
						panel_1.setBounds(10, 46, 424, 575);
						contentPane.add(panel_1);
						panel_1.setLayout(null);
																																																																																																								
																																																																																																										JLabel label_7 = new JLabel("");
																																																																																																										label_7.setBounds(0, 0, 424, 575);
																																																																																																										panel_1.add(label_7);
																																																																																																										final ImageIcon logo21 = new ImageIcon(
																																																																																																												icono.getImage().getScaledInstance(label_7.getWidth(), label_7.getHeight(), Image.SCALE_DEFAULT));
																																																																																																										label_7.setIcon(logo21);
	}

	public void establecerFechaRegistro() {
		try {
			LocalDate fechaActual = LocalDate.now();
			Date date = Date.from(fechaActual.atStartOfDay(ZoneId.systemDefault()).toInstant());
			dateFechaPlanilla.setDate(date);
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
		pista = new PlaceHolder(txtNombresPlanilla, "Nombres del empleado.");
		pista = new PlaceHolder(txtApellidosPlanilla, "Apellidos del empleado.");
		pista = new PlaceHolder(txtIdentidadEmpleadoPlanilla, "Escriba la identidad.");
		pista = new PlaceHolder(txtIdentidadPlanilla, "Identidad del empleado");
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
			txtCodigo.setText(id);
			;
			stmtr.close();
			rsr.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void busquedaDatosEmpleado() {
		consultas_planilla consulta = new consultas_planilla();
		empleado clase = new empleado();
		clase.setIdentidad_empleado(txtIdentidadEmpleadoPlanilla.getText());
		if (consulta.buscar(clase)) {
			txtCodigoPlanilla.setText(String.valueOf(clase.getId_empleado()));
			txtNombresPlanilla.setText(String.valueOf(clase.getNombres_empleado()));
			txtApellidosPlanilla.setText(String.valueOf(clase.getApellidos_empleado()));
			txtIdentidadPlanilla.setText(String.valueOf(clase.getIdentidad_empleado()));
			txtDireccionFoto.setText(String.valueOf(clase.getDireccion_foto_empleado()));
			txtCargoPlanilla.setText(String.valueOf(clase.getNombre_cargo_empleado()));
			txtCantidadPlanilla.setText(String.valueOf(clase.getSueldo_cargo_empleado()));

			String ruta = txtDireccionFoto.getText().toString();
			final ImageIcon foto = new ImageIcon(ruta);
			final ImageIcon logo = new ImageIcon(foto.getImage().getScaledInstance(lblFotoPlanilla.getWidth(),
					lblFotoPlanilla.getHeight(), Image.SCALE_DEFAULT));
			lblFotoPlanilla.setIcon(logo);

			txtCodigoPlanilla.setForeground(Color.BLACK);
			txtNombresPlanilla.setForeground(Color.BLACK);
			txtApellidosPlanilla.setForeground(Color.BLACK);
			txtIdentidadPlanilla.setForeground(Color.BLACK);
			txtCargoPlanilla.setForeground(Color.BLACK);

		} else {
			JOptionPane.showMessageDialog(null, "No se encontro ningun registro");

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
	private JButton button_3;

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
		// We define the print mode (Definimos el modo de impresión)
		JTable.PrintMode mode = fitWidth ? JTable.PrintMode.FIT_WIDTH : JTable.PrintMode.NORMAL;
		try {
			// Print the table (Imprimo la tabla)
			boolean complete = jTable.print(mode, new MessageFormat(header), new MessageFormat(footer), showPrintDialog,
					null, interactive);
			if (complete) {
				// Mostramos el mensaje de impresión existosa
				JOptionPane.showMessageDialog(jTable, "Print complete (Impresión completa)",
						"Print result (Resultado de la impresión)", JOptionPane.INFORMATION_MESSAGE);
			} else {
				// Mostramos un mensaje indicando que la impresión fue cancelada
				JOptionPane.showMessageDialog(jTable, "Print canceled (Impresión cancelada)",
						"Print result (Resultado de la impresión)", JOptionPane.WARNING_MESSAGE);
			}
		} catch (PrinterException pe) {
			JOptionPane.showMessageDialog(jTable, "Print fail (Fallo de impresión): " + pe.getMessage(),
					"Print result (Resultado de la impresión)", JOptionPane.ERROR_MESSAGE);
		}
	}
}
