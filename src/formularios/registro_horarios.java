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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.RowFilter;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;
import javax.swing.text.MaskFormatter;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.placeholder.PlaceHolder;

import clases.horario;
import conexion.conexion;
import consultas.consultas_horario;
import controles.control_horario;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class registro_horarios extends JFrame {
	public JTextField txtidhorario;
	public JTextField txttipohorario;
	public JScrollPane scrollPane;
	public PlaceHolder pista;
	public JPanel contentPane;
	public JButton btnAceptarHorario;
	public JButton btnActualizarHorario;
	public JButton btnActualizardDatosHorario;
	public JButton btnNuevoHorario;
	public JButton btnSalirHorario;
	public JButton btnAceptar;
	public JButton btnMostrar;
	public JButton btnRegresar;
	public JButton btnSiguiente;
	public JButton btnBorrarHorario;
	public JButton btnVerDetalleHorario;
	public JButton btnGuardarHorario;
	public JScrollPane barraHorarios;
	
	public JTextField textCodigoHorario;
	public JTextField textDescripcioHorario;
	public JTextField textObservacionHorario;
	public JTextField textBuscarHorario;
	public JTable tablaHorario;
	public TableRowSorter trsfiltroCodigo;
	String filtroCodigo;
	
	/**
	 * Create the frame.
	 */
	public registro_horarios() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTextField txtidhorario = new JTextField();
		contentPane.setLayout(null);
		
		btnRegresar= new JButton("Regresar");
	    btnRegresar.setBounds(10, 8, 99, 23);
		btnRegresar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnRegresar.setBackground(new Color(255, 127, 80));
		contentPane.add(btnRegresar);
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ventana_principal principal = new ventana_principal();
				principal.setVisible(true);
				principal.setLocationRelativeTo(null);
				dispose();
			}
		});
		
		JLabel lblAsignarUnHorario = new JLabel("Asignar un horario.");
		lblAsignarUnHorario.setBounds(271, 0, 197, 36);
		lblAsignarUnHorario.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
		contentPane.add(lblAsignarUnHorario);
		
		 btnSiguiente= new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registro_contratos_empleados contrato = new registro_contratos_empleados();
				contrato.setVisible(true);
				contrato.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnSiguiente.setBounds(871, 13, 99, 23);
		btnSiguiente.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnSiguiente.setBackground(new Color(0, 255, 127));
		contentPane.add(btnSiguiente);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(91, 59, 341, 401);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblObservacionHorario = new JLabel("6. Observacion horario :");
		lblObservacionHorario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblObservacionHorario.setBounds(30, 241, 150, 14);
		panel.add(lblObservacionHorario);
		
		JLabel lblDescripcionHorario = new JLabel("5. Descripcion Horario :");
		lblDescripcionHorario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblDescripcionHorario.setBounds(30, 181, 150, 14);
		panel.add(lblDescripcionHorario);
		
		JLabel lblDiasDelHorario = new JLabel("4. Dias del horario :");
		lblDiasDelHorario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblDiasDelHorario.setBounds(30, 152, 150, 14);
		panel.add(lblDiasDelHorario);
		
		JLabel lblHoraDelHorario = new JLabel("3. Horas al dia :");
		lblHoraDelHorario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblHoraDelHorario.setBounds(31, 128, 177, 14);
		panel.add(lblHoraDelHorario);
		
		JLabel lblTipoDeHorario = new JLabel("2. Tipo de horario :");
		lblTipoDeHorario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblTipoDeHorario.setBounds(31, 103, 130, 14);
		panel.add(lblTipoDeHorario);
		
		JLabel lblCodigo = new JLabel("1. Codigo :");
		lblCodigo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblCodigo.setBounds(31, 78, 63, 14);
		panel.add(lblCodigo);
		
		JLabel lblDatosDelRegistro = new JLabel("Datos del registro.");
		lblDatosDelRegistro.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblDatosDelRegistro.setBounds(30, 41, 197, 36);
		panel.add(lblDatosDelRegistro);
		
		btnAceptarHorario = new JButton("Aceptar");
		btnAceptarHorario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAceptarHorario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnAceptarHorario.setBackground(new Color(240, 230, 140));
		btnAceptarHorario.setBounds(40, 313, 99, 23);
		panel.add(btnAceptarHorario);
		
		btnNuevoHorario = new JButton("Nuevo");
		btnNuevoHorario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnNuevoHorario.setBackground(new Color(0, 139, 139));
		btnNuevoHorario.setBounds(40, 344, 99, 23);
		panel.add(btnNuevoHorario);
		
		btnActualizarHorario = new JButton("Actualizar");
		btnActualizarHorario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnActualizarHorario.setBackground(new Color(0, 255, 127));
		btnActualizarHorario.setBounds(214, 313, 99, 23);
		panel.add(btnActualizarHorario);
		
		textCodigoHorario = new JTextField();
		textCodigoHorario.setEditable(false);
		textCodigoHorario.setBounds(202, 76, 46, 20);
		panel.add(textCodigoHorario);
		textCodigoHorario.setColumns(10);
		
		JComboBox tipoHorario = new JComboBox();
		tipoHorario.setModel(new DefaultComboBoxModel(new String[] {"Matutino", "Vespertino", "Nocturno"}));
		tipoHorario.setBounds(202, 101, 111, 20);
		panel.add(tipoHorario);
		
		JComboBox HorasDia= new JComboBox();
		HorasDia.setModel(new DefaultComboBoxModel(new String[] {"6:00 am - 2:00 pm", "2:00 pm - 10:00 pm", "8:00 am - 2:00 pm", "2:00 pm - 9:00 pm", "10:00 pm - 6:00 am"}));
		HorasDia.setBounds(202, 126, 111, 20);
		panel.add(HorasDia);
		
		JComboBox diasHorario= new JComboBox();
		diasHorario.setModel(new DefaultComboBoxModel(new String[] {"De Lunes a Viernes", "Sabado y Domingo", "Toda la semana"}));
		diasHorario.setBounds(202, 150, 111, 20);
		panel.add(diasHorario);
		
	    textDescripcioHorario = new JTextField();
		textDescripcioHorario.setColumns(20);
		textDescripcioHorario.setBounds(172, 185, 141, 57);
		panel.add(textDescripcioHorario);
		
		textObservacionHorario = new JTextField();
		textObservacionHorario.setColumns(10);
		textObservacionHorario.setBounds(172, 245, 141, 57);
		panel.add(textObservacionHorario);
		
		JLabel label_1 = new JLabel();
		label_1.setBounds(264, 41, 49, 44);
		panel.add(label_1);
		final ImageIcon icono1 = new ImageIcon(getClass().getResource("/material/logo.png"));
		final ImageIcon logo1 = new ImageIcon(icono1.getImage().getScaledInstance(label_1.getWidth(),label_1.getHeight(), Image.SCALE_DEFAULT));
		label_1.setIcon(logo1);
		
		btnGuardarHorario = new JButton("Guardar");
		btnGuardarHorario.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGuardarHorario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGuardarHorario.setBounds(214, 345, 99, 23);
		panel.add(btnGuardarHorario);
		final ImageIcon icono = new ImageIcon(getClass().getResource("/material/libreta.png"));
		
		JLabel label = new JLabel();
		label.setBounds(31, 47, 341, 401);
		contentPane.add(label);
		final ImageIcon logo = new ImageIcon(icono.getImage().getScaledInstance(label.getWidth(),label.getHeight(), Image.SCALE_DEFAULT));
		label.setIcon(logo);
		
		JPanel panelTablaHorario = new JPanel();
		panelTablaHorario.setLayout(null);
		panelTablaHorario.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelTablaHorario.setBackground(Color.WHITE);
		panelTablaHorario.setBounds(499, 59, 431, 401);
		contentPane.add(panelTablaHorario);
		
		JLabel lblHorarioRegistrados = new JLabel("Horario registrados :");
		lblHorarioRegistrados.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblHorarioRegistrados.setBounds(30, 41, 166, 19);
		panelTablaHorario.add(lblHorarioRegistrados);
		
		JLabel lblBuscarHorario = new JLabel("Buscar Horario :");
		lblBuscarHorario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblBuscarHorario.setBounds(30, 63, 99, 22);
		panelTablaHorario.add(lblBuscarHorario);
		
		textBuscarHorario = new JTextField();
		textBuscarHorario.setHorizontalAlignment(SwingConstants.CENTER);
		textBuscarHorario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		textBuscarHorario.setColumns(10);
		textBuscarHorario.setBounds(128, 64, 228, 21);
		panelTablaHorario.add(textBuscarHorario);
		InputMap map4 = textBuscarHorario.getInputMap(textBuscarHorario.WHEN_FOCUSED);
		map4.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		textBuscarHorario.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent ke) {
				trsfiltroCodigo = new TableRowSorter(tablaHorario.getModel());
				 tablaHorario.setRowSorter(trsfiltroCodigo);
			}

			public void keyPressed(KeyEvent ke) {

			}

			public void keyReleased(KeyEvent ke) {
				String cadena = (textBuscarHorario.getText());
				textBuscarHorario.setText(cadena);
				repaint();
				filtro();
			}
			public void construirTabla() {
				String titulos[] = { "CodigoHorario", "descripciOnHorario", "observacionHorario", "buscarHorario" };
				String informacion[][] = control_horario.obtenerMatriz();
				tablaHorario = new JTable(informacion, titulos);
				barraHorarios.setViewportView(tablaHorario);
				for (int c = 0; c < tablaHorario.getColumnCount(); c++) {
					Class<?> col_class = tablaHorario.getColumnClass(c);
					tablaHorario.setDefaultEditor(col_class, null);
					
					// alinear datos de sueldo y horaextra a la derecha
					DefaultTableCellRenderer tcr;
					tcr = new DefaultTableCellRenderer();
					tcr.setHorizontalAlignment(SwingConstants.RIGHT);
					tablaHorario.getColumnModel().getColumn(3).setCellRenderer(tcr);
					tablaHorario.getColumnModel().getColumn(4).setCellRenderer(tcr);
				}
			}

			
				
			
		});

		
		btnBorrarHorario= new JButton("Borrar");
		btnBorrarHorario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnBorrarHorario.setBackground(new Color(220, 20, 60));
		btnBorrarHorario.setBounds(30, 354, 99, 23);
		panelTablaHorario.add(btnBorrarHorario);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 96, 376, 233);
		panelTablaHorario.add(scrollPane);
		
		JLabel label_4 = new JLabel();
		label_4.setBounds(355, 41, 49, 44);
		panelTablaHorario.add(label_4);
		
		btnActualizardDatosHorario = new JButton("Actualizar Datos");
	    btnActualizardDatosHorario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnActualizardDatosHorario.setBackground(new Color(60, 179, 113));
		btnActualizardDatosHorario.setBounds(267, 354, 137, 23);
        panelTablaHorario.add(btnActualizardDatosHorario);
		
	    btnVerDetalleHorario = new JButton("Ver detalles");
		btnVerDetalleHorario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
	    btnVerDetalleHorario.setBackground(new Color(0, 206, 209));
		btnVerDetalleHorario.setBounds(139, 354, 108, 23);
		panelTablaHorario.add(btnVerDetalleHorario);
		
	}
		
		public void pistas() {
			pista = new PlaceHolder(textBuscarHorario, "Escriba para buscar.");
			pista = new PlaceHolder(textBuscarHorario, "Ingrese el nombre del Horario.");
			pista = new PlaceHolder(textBuscarHorario, "Digite las horas laborales.");
			
		}
		
		
		public void filtro() {
			filtroCodigo = textBuscarHorario.getText();
			trsfiltroCodigo.setRowFilter(RowFilter.regexFilter(textBuscarHorario.getText(), 0, 1, 2, 3, 4, 5));
		}
			

		public void obtenerUltimoId() {
			String ultimoValor = null;
			int valor;
			String id = null;
			conexion objCon = new conexion();
			Connection conn = objCon.getConexion();
			try {
				PreparedStatement stmtr = conn.prepareStatement("SELECT * FROM horarioss ORDER BY id_horario DESC");
				ResultSet rsr = stmtr.executeQuery();
				if (rsr.next()) {
					ultimoValor = rsr.getString("id_horario");
					valor = Integer.parseInt(ultimoValor);
					valor = valor + 1;
					id = String.valueOf(valor);
				}
				textCodigoHorario.setText(id);
				;
				stmtr.close();
				rsr.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		
		
		
	}

