package formularios;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;
import javax.swing.text.MaskFormatter;

import com.placeholder.PlaceHolder;

import clases.empleado;
import conexion.conexion;
import consultas.consultas_bonificacion;
import controles.control_bonificacion;
import utilidades.visor_imagen;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
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
import java.util.Date;
import java.util.Timer;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Event;

import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

public class registro_bonificaciones extends JFrame {

	public JPanel contentPane;
	public JTextField txtApellidosBonificacion;
	public JTextField txtNombresBonificacion;
	public JTextField txtCodigoBonificacion;
	public JLabel label_2;
	public JLabel label_3;
	public JLabel label_4;
	public JLabel label_5;
	public JTextField txtIdentidadBonificacion;
	public JLabel lblBuscarEmpleadoPor;
	public JFormattedTextField txtIdentidadEmpleadoBonificacion;
	public JPanel panel;
	public JLabel label_6;
	public JLabel lblTipo;
	public JLabel lblCantidad;
	public JTextField txtCantidadBonificacion;
	public JLabel lblObservacion;
	public JLabel lblAgregarDeduccion;
	public JPanel panel_2;
	public JLabel label_8;
	public JTextField txtBusquedaBonificacion;
	public static JTextField txtTotalBonificacion;
	public JLabel lblFotoBonificacion;
	public JButton btnAtras;
	public PlaceHolder pista;
	public JDateChooser dateFechaBonificacion;

	public JButton btnBorrarBonificacion;
	public JButton btnVerBonificacion;
	public JButton btnActualizarDatosBonificacion;

	public JScrollPane scrollPane_1;
	public JTextArea txtObservacionBonificacion;
	public JButton btnAceptar;
	public JButton btnNuevo;
	public JButton btnActualizar;
	public JButton btnGuardar;
	public JLabel lblTotalDeducciones;
	public JButton btnBuscarIdentidadDeduccion;
	public JTextFieldDateEditor editor;

	public JScrollPane barraTablaBonificacion;
	public JTable tablaBonificaciones;

	public TableRowSorter trsfiltro;
	String filtro;
	public static String hora_fecha_reporte;

	public static String ruta;
	public static ImageIcon imagen;

	public static String bonificaciones;

	public JComboBox<?> cbxTipoBonificacion;
	public JTextField txtDireccionFoto;
	public JButton btnVer;
	public JLabel lblL;
	public JLabel label;
	public JTextField txtCodigo;
	public JLabel lblFecha;
	public JButton btnPlanilla;
	private JButton button;

	public registro_bonificaciones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 550);
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
		panel_2.setBounds(444, 46, 430, 467);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblBuscarDeduccion = new JLabel("Buscar bonificacion:");
		lblBuscarDeduccion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblBuscarDeduccion.setBounds(28, 63, 136, 22);
		panel_2.add(lblBuscarDeduccion);

		txtBusquedaBonificacion = new JTextField();
		txtBusquedaBonificacion.setHorizontalAlignment(SwingConstants.CENTER);
		InputMap map41 = txtBusquedaBonificacion.getInputMap(JComponent.WHEN_FOCUSED);
		map41.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtBusquedaBonificacion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtBusquedaBonificacion.setColumns(10);
		txtBusquedaBonificacion.setBounds(157, 64, 186, 21);
		panel_2.add(txtBusquedaBonificacion);
		txtBusquedaBonificacion.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				trsfiltro = new TableRowSorter(tablaBonificaciones.getModel());
				tablaBonificaciones.setRowSorter(trsfiltro);
			}

			@Override
			public void keyPressed(KeyEvent ke) {

			}

			@Override
			public void keyReleased(KeyEvent ke) {
				String cadena = (txtBusquedaBonificacion.getText());
				txtBusquedaBonificacion.setText(cadena);
				repaint();
				filtro();
			}
		});

		JLabel label_10 = new JLabel();
		label_10.setBounds(353, 41, 49, 44);
		panel_2.add(label_10);
		final ImageIcon logo2 = new ImageIcon(
				icono2.getImage().getScaledInstance(label_10.getWidth(), label_10.getHeight(), Image.SCALE_DEFAULT));
		label_10.setIcon(logo2);

		JLabel lblDeduccionesRegistradas = new JLabel("Bonificaciones");
		lblDeduccionesRegistradas.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblDeduccionesRegistradas.setBounds(28, 41, 150, 19);
		panel_2.add(lblDeduccionesRegistradas);

		btnBorrarBonificacion = new JButton("Borrar");
		btnBorrarBonificacion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnBorrarBonificacion.setBackground(new Color(220, 20, 60));
		btnBorrarBonificacion.setBounds(28, 406, 99, 23);
		panel_2.add(btnBorrarBonificacion);

		btnVerBonificacion = new JButton("Ver detalles");
		btnVerBonificacion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnVerBonificacion.setBackground(new Color(0, 206, 209));
		btnVerBonificacion.setBounds(147, 406, 108, 23);
		panel_2.add(btnVerBonificacion);

		btnActualizarDatosBonificacion = new JButton("Actualizar Datos");
		btnActualizarDatosBonificacion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnActualizarDatosBonificacion.setBackground(new Color(60, 179, 113));
		btnActualizarDatosBonificacion.setBounds(265, 407, 137, 23);
		panel_2.add(btnActualizarDatosBonificacion);

		barraTablaBonificacion = new JScrollPane((Component) null, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		barraTablaBonificacion.setBounds(26, 95, 376, 247);
		panel_2.add(barraTablaBonificacion);

		lblTotalDeducciones = new JLabel("Total bonificaciones:");
		lblTotalDeducciones.setBounds(28, 349, 150, 26);
		panel_2.add(lblTotalDeducciones);
		lblTotalDeducciones.setFont(new Font("Dialog", Font.BOLD, 12));

		txtTotalBonificacion = new JTextField();
		txtTotalBonificacion.setBounds(178, 353, 115, 22);
		panel_2.add(txtTotalBonificacion);
		txtTotalBonificacion.setEditable(false);
		txtTotalBonificacion.setColumns(10);
		txtTotalBonificacion.setHorizontalAlignment(SwingConstants.RIGHT);

		JButton btnCalcularBonificacion = new JButton("Calcular");
		btnCalcularBonificacion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				totalizar();
			}
		});
		btnCalcularBonificacion.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 10));
		btnCalcularBonificacion.setBounds(303, 353, 99, 23);
		panel_2.add(btnCalcularBonificacion);
		btnCalcularBonificacion.setBackground(new Color(60, 179, 113));

		label = new JLabel("L.");
		label.setBounds(157, 353, 28, 18);
		panel_2.add(label);
		label.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));

		btnPlanilla = new JButton("Planilla");
		btnPlanilla.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (txtTotalBonificacion.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "No hay bonificaciones para este empleado.");
				} else {
					registro_planillas.txtTotalBonificacionesPlanilla.setText(txtTotalBonificacion.getText());
					dispose();
					JOptionPane.showMessageDialog(null, "Bonificaciones agregadas a la planilla.");
				}

			}
		});
		btnPlanilla.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 10));
		btnPlanilla.setBackground(new Color(255, 255, 0));
		btnPlanilla.setBounds(303, 378, 99, 23);
		panel_2.add(btnPlanilla);
		btnPlanilla.setVisible(false);
		
		button = new JButton("Imprimir Reporte");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date date = new Date();
				DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
				hora_fecha_reporte = ("Hora y fecha del reporte : " + hourdateFormat.format(date));
				utilJTablePrint(tablaBonificaciones, "Canal 40 (COFFEE TV CHANNEL)",
						"Reporte de Bonificaciones.____. " + hora_fecha_reporte, true);
			}
		});
		button.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		button.setBackground(new Color(60, 179, 113));
		button.setBounds(206, 41, 137, 19);
		panel_2.add(button);
		
				label_8 = new JLabel("");
				label_8.setBounds(0, 0, 430, 456);
				panel_2.add(label_8);
				final ImageIcon logo = new ImageIcon(
						icono.getImage().getScaledInstance(label_8.getWidth(), label_8.getHeight(), Image.SCALE_DEFAULT));
				label_8.setIcon(logo);

		JLabel lblRegistroYMantenimiento = new JLabel("REGISTRO Y MANTENIMIENTO DE BONIFICACIONES");
		lblRegistroYMantenimiento.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblRegistroYMantenimiento.setBounds(10, 1, 551, 39);
		contentPane.add(lblRegistroYMantenimiento);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 46, 424, 454);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblRegistrarDeducciones = new JLabel("Registrar Bonificacion.");
		lblRegistrarDeducciones.setBounds(35, 39, 207, 28);
		panel_1.add(lblRegistrarDeducciones);
		lblRegistrarDeducciones.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));

		lblBuscarEmpleadoPor = new JLabel("Ingrese la Identidad :");
		lblBuscarEmpleadoPor.setForeground(new Color(0, 128, 0));
		lblBuscarEmpleadoPor.setBounds(35, 67, 168, 27);
		panel_1.add(lblBuscarEmpleadoPor);
		lblBuscarEmpleadoPor.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

		MaskFormatter formato = null;
		try {
			formato = new MaskFormatter("####-####-#####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtIdentidadEmpleadoBonificacion = new JFormattedTextField(formato);
		txtIdentidadEmpleadoBonificacion.setBounds(168, 71, 132, 20);
		txtIdentidadEmpleadoBonificacion.setHorizontalAlignment(SwingConstants.CENTER);
		InputMap map42 = txtIdentidadEmpleadoBonificacion.getInputMap(JComponent.WHEN_FOCUSED);
		map42.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		panel_1.add(txtIdentidadEmpleadoBonificacion);
		txtIdentidadEmpleadoBonificacion.setColumns(10);
		txtIdentidadEmpleadoBonificacion.addKeyListener(new KeyListener() {
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

		JLabel lblDatosDelEmpleado = new JLabel("Datos del empleado :");
		lblDatosDelEmpleado.setBounds(35, 98, 168, 14);
		panel_1.add(lblDatosDelEmpleado);
		lblDatosDelEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));

		label_4 = new JLabel("Codigo :");
		label_4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		label_4.setBounds(35, 126, 63, 14);
		panel_1.add(label_4);

		txtCodigoBonificacion = new JTextField();
		txtCodigoBonificacion.setBounds(102, 123, 28, 20);
		panel_1.add(txtCodigoBonificacion);
		txtCodigoBonificacion.setEditable(false);
		txtCodigoBonificacion.setColumns(10);
		txtCodigoBonificacion.setHorizontalAlignment(SwingConstants.CENTER);

		label_2 = new JLabel("Nombres :");
		label_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		label_2.setBounds(35, 152, 63, 14);
		panel_1.add(label_2);

		txtNombresBonificacion = new JTextField();
		txtNombresBonificacion.setEditable(false);
		txtNombresBonificacion.setBounds(102, 149, 186, 20);
		panel_1.add(txtNombresBonificacion);
		txtNombresBonificacion.setColumns(10);
		txtNombresBonificacion.setHorizontalAlignment(SwingConstants.CENTER);

		label_3 = new JLabel("Apellidos :");
		label_3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		label_3.setBounds(35, 177, 63, 14);
		panel_1.add(label_3);

		txtApellidosBonificacion = new JTextField();
		txtApellidosBonificacion.setEditable(false);
		txtApellidosBonificacion.setBounds(102, 174, 186, 20);
		panel_1.add(txtApellidosBonificacion);
		txtApellidosBonificacion.setColumns(10);
		txtApellidosBonificacion.setHorizontalAlignment(SwingConstants.CENTER);

		label_5 = new JLabel("Identidad :");
		label_5.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		label_5.setBounds(35, 205, 63, 14);
		panel_1.add(label_5);

		txtIdentidadBonificacion = new JTextField();
		txtIdentidadBonificacion.setEditable(false);
		txtIdentidadBonificacion.setBounds(102, 199, 186, 20);
		panel_1.add(txtIdentidadBonificacion);
		txtIdentidadBonificacion.setColumns(10);
		txtIdentidadBonificacion.setHorizontalAlignment(SwingConstants.CENTER);

		label_6 = new JLabel("Fotografia :");
		label_6.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		label_6.setBounds(225, 118, 82, 14);
		panel_1.add(label_6);

		panel = new JPanel();
		panel.setBounds(298, 113, 94, 87);
		panel_1.add(panel);
		panel.setLayout(null);

		lblFotoBonificacion = new JLabel();
		lblFotoBonificacion.setBounds(0, 0, 94, 87);
		panel.add(lblFotoBonificacion);
		final ImageIcon logo22 = new ImageIcon(usuario.getImage().getScaledInstance(lblFotoBonificacion.getWidth(),
				lblFotoBonificacion.getHeight(), Image.SCALE_DEFAULT));
		lblFotoBonificacion.setIcon(logo22);

		lblAgregarDeduccion = new JLabel("Agregar bonificacion :");
		lblAgregarDeduccion.setBounds(35, 230, 168, 14);
		panel_1.add(lblAgregarDeduccion);
		lblAgregarDeduccion.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));

		lblTipo = new JLabel("Tipo :");
		lblTipo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblTipo.setBounds(35, 257, 63, 14);
		panel_1.add(lblTipo);

		cbxTipoBonificacion = new JComboBox();
		cbxTipoBonificacion.setModel(new DefaultComboBoxModel(new String[] { "Bono por comision.",
				"Bono Navide\u00F1o.", "Bono por antiguedad.", "Bono por  publicidad.", "Pago por Edicion.",
				"Pago por Trabajo Grabacion.", "Pago or Tomas.", "Pago por venta de publicidad." }));
		cbxTipoBonificacion.setBounds(137, 255, 132, 20);
		panel_1.add(cbxTipoBonificacion);

		lblCantidad = new JLabel("Cantidad :");
		lblCantidad.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblCantidad.setBounds(35, 282, 63, 14);
		panel_1.add(lblCantidad);

		txtCantidadBonificacion = new JTextField();
		txtCantidadBonificacion.setBounds(137, 280, 132, 20);
		panel_1.add(txtCantidadBonificacion);
		txtCantidadBonificacion.setColumns(10);
		txtCantidadBonificacion.setHorizontalAlignment(SwingConstants.RIGHT);
		InputMap map44 = txtCantidadBonificacion.getInputMap(JComponent.WHEN_FOCUSED);
		map44.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtCantidadBonificacion.addKeyListener(new KeyListener() {
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

		lblObservacion = new JLabel("Observacion :");
		lblObservacion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblObservacion.setBounds(35, 307, 109, 34);
		panel_1.add(lblObservacion);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(137, 307, 255, 34);
		panel_1.add(scrollPane_1);

		txtObservacionBonificacion = new JTextArea();
		InputMap map45 = txtObservacionBonificacion.getInputMap(JComponent.WHEN_FOCUSED);
		map45.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		scrollPane_1.setViewportView(txtObservacionBonificacion);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnAceptar.setBackground(Color.WHITE);
		btnAceptar.setBounds(35, 374, 99, 23);
		panel_1.add(btnAceptar);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnNuevo.setBackground(Color.WHITE);
		btnNuevo.setBounds(35, 399, 99, 23);
		panel_1.add(btnNuevo);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnActualizar.setBackground(new Color(60, 179, 113));
		btnActualizar.setBounds(293, 374, 99, 23);
		panel_1.add(btnActualizar);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnGuardar.setBackground(new Color(60, 179, 113));
		btnGuardar.setBounds(293, 399, 99, 23);
		panel_1.add(btnGuardar);

		btnBuscarIdentidadDeduccion = new JButton("Buscar");
		btnBuscarIdentidadDeduccion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (txtIdentidadEmpleadoBonificacion.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor ingrese la identidad antes buscar");
				} else {
					busquedaDatosEmpleado();
				}

			}
		});
		btnBuscarIdentidadDeduccion.setBackground(new Color(60, 179, 113));
		btnBuscarIdentidadDeduccion.setBounds(310, 70, 82, 23);
		panel_1.add(btnBuscarIdentidadDeduccion);

		txtDireccionFoto = new JTextField();
		txtDireccionFoto.setEditable(false);
		txtDireccionFoto.setColumns(10);
		txtDireccionFoto.setBounds(298, 199, 94, 20);
		panel_1.add(txtDireccionFoto);

		btnVer = new JButton("Ver");
		btnVer.setBounds(308, 218, 73, 15);
		panel_1.add(btnVer);
		btnVer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (txtDireccionFoto.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "No hay imagen que mostrar");
				} else {
					visor_imagen visor = new visor_imagen();
					ruta = txtDireccionFoto.getText().toString();
					visor.txtRutaImagen.setText(ruta);
					visor.setVisible(true);
					visor.setLocationRelativeTo(null);
					imagen = new ImageIcon(ruta);
					visor_imagen.lblImagen.setIcon(imagen);
				}
			}
		});
		btnVer.setBackground(new Color(60, 179, 113));

		lblL = new JLabel("L.");
		lblL.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblL.setBounds(116, 280, 28, 18);
		panel_1.add(lblL);

		JLabel label_1 = new JLabel("Codigo :");
		label_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		label_1.setBounds(305, 257, 63, 14);
		panel_1.add(label_1);

		txtCodigo = new JTextField();
		txtCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(364, 255, 28, 20);
		panel_1.add(txtCodigo);

		lblFecha = new JLabel("Fecha :");
		lblFecha.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblFecha.setBounds(35, 348, 109, 20);
		panel_1.add(lblFecha);
		lblFecha.setVisible(false);

		dateFechaBonificacion = new JDateChooser();
		dateFechaBonificacion.setBounds(137, 348, 132, 20);
		dateFechaBonificacion.setDateFormatString("dd-MMMMM-yyyy");
		panel_1.add(dateFechaBonificacion);
		editor = (JTextFieldDateEditor) dateFechaBonificacion.getDateEditor();
		editor.setEditable(false);
		editor.setHorizontalAlignment(SwingConstants.CENTER);
		dateFechaBonificacion.setVisible(false);

		JLabel label_7 = new JLabel("");
		label_7.setBounds(0, 0, 424, 454);
		panel_1.add(label_7);
		final ImageIcon logo21 = new ImageIcon(
				icono.getImage().getScaledInstance(label_7.getWidth(), label_7.getHeight(), Image.SCALE_DEFAULT));
		label_7.setIcon(logo21);

		btnAtras = new JButton("Regresar");
		btnAtras.addActionListener(new ActionListener() {
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
		btnAtras.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnAtras.setBackground(new Color(255, 127, 80));
		btnAtras.setBounds(772, 12, 102, 23);
		contentPane.add(btnAtras);
	}

	public void establecerFechaRegistro() {
		try {
			LocalDate fechaActual = LocalDate.now();
			Date date = Date.from(fechaActual.atStartOfDay(ZoneId.systemDefault()).toInstant());
			dateFechaBonificacion.setDate(date);
		} catch (Exception e) {

		}

	}

	public void construirTabla() {
		String titulos[] = { "Codigo", "Tipo", "Observacion", "Identidad", "Cantidad", "Fecha" };
		String informacion[][] = control_bonificacion.obtenerMatriz();
		tablaBonificaciones = new JTable(informacion, titulos);
		barraTablaBonificacion.setViewportView(tablaBonificaciones);
		for (int c = 0; c < tablaBonificaciones.getColumnCount(); c++) {
			Class<?> col_class = tablaBonificaciones.getColumnClass(c);
			tablaBonificaciones.setDefaultEditor(col_class, null);
			tablaBonificaciones.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			tablaBonificaciones.getTableHeader().setReorderingAllowed(false);

			DefaultTableCellRenderer tcr;
			tcr = new DefaultTableCellRenderer();
			tcr.setHorizontalAlignment(SwingConstants.RIGHT);
			tablaBonificaciones.getColumnModel().getColumn(4).setCellRenderer(tcr);
		}
	}

	public void filtro() {
		filtro = txtBusquedaBonificacion.getText();
		trsfiltro.setRowFilter(RowFilter.regexFilter(txtBusquedaBonificacion.getText(), 0, 1, 2, 3, 4));
	}

	public void pistas() {
		pista = new PlaceHolder(txtBusquedaBonificacion, "Escriba para buscar.");
		pista = new PlaceHolder(txtNombresBonificacion, "Nombres del empleado.");
		pista = new PlaceHolder(txtApellidosBonificacion, "Apellidos del empleado.");
		pista = new PlaceHolder(txtIdentidadEmpleadoBonificacion, "Escriba la identidad.");
		pista = new PlaceHolder(txtIdentidadBonificacion, "Identidad del empleado");
		pista = new PlaceHolder(txtCantidadBonificacion, "Digite la cantidad.");
		pista = new PlaceHolder(txtObservacionBonificacion, "Escriba una observacion.");
	}

	public void obtenerUltimoId() {
		String ultimoValor = null;
		int valor;
		String id = null;
		conexion objCon = new conexion();
		Connection conn = objCon.getConexion();
		try {
			PreparedStatement stmtr = conn
					.prepareStatement("SELECT * FROM bonificaciones ORDER BY id_bonificacion DESC");
			ResultSet rsr = stmtr.executeQuery();
			if (rsr.next()) {
				ultimoValor = rsr.getString("id_bonificacion");
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

	public void totalizar() {
		double t = 0;
		double p = 0;
		if (tablaBonificaciones.getRowCount() > 0) {
			for (int i = 0; i < tablaBonificaciones.getRowCount(); i++) {
				p = Double.parseDouble(tablaBonificaciones.getValueAt(i, 4).toString());
				t += p;
			}
			txtTotalBonificacion.setText(String.valueOf(t));
			btnPlanilla.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(null, "No hay datos que totalizar");
		}
	}

	public void busquedaDatosEmpleado() {
		consultas_bonificacion consulta = new consultas_bonificacion();
		empleado clase = new empleado();
		clase.setIdentidad_empleado(txtIdentidadEmpleadoBonificacion.getText());
		if (consulta.buscar(clase)) {
			txtCodigoBonificacion.setText(String.valueOf(clase.getId_empleado()));
			txtNombresBonificacion.setText(String.valueOf(clase.getNombres_empleado()));
			txtApellidosBonificacion.setText(String.valueOf(clase.getApellidos_empleado()));
			txtIdentidadBonificacion.setText(String.valueOf(clase.getIdentidad_empleado()));
			txtDireccionFoto.setText(String.valueOf(clase.getDireccion_foto_empleado()));
			String ruta = txtDireccionFoto.getText().toString();
			final ImageIcon foto = new ImageIcon(ruta);
			final ImageIcon logo = new ImageIcon(foto.getImage().getScaledInstance(lblFotoBonificacion.getWidth(),
					lblFotoBonificacion.getHeight(), Image.SCALE_DEFAULT));
			lblFotoBonificacion.setIcon(logo);

			txtCodigoBonificacion.setForeground(Color.BLACK);
			txtNombresBonificacion.setForeground(Color.BLACK);
			txtApellidosBonificacion.setForeground(Color.BLACK);
			txtIdentidadBonificacion.setForeground(Color.BLACK);

		} else {
			JOptionPane.showMessageDialog(null, "No se encontro ningun registro");

		}
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
