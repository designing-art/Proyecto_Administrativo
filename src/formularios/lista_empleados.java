package formularios;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;

import controles.control_cargo;
import controles.control_empleado;

import java.awt.Window.Type;
import java.awt.Color;
import java.awt.Event;

import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class lista_empleados extends JFrame {

	public JPanel contentPane;
	public JTextField txtBusquedaEmpleado;
	public JLabel lblAreasDelModulo;
	public JComboBox comboBox;
	public JLabel label_4;
	public JLabel lblCantidadTotalDe;
	public JTextField textField_1;
	public JLabel lblPaginaN;
	public JTextField textField_2;
	public JLabel lblDe;
	public JTextField textField_3;
	public JButton btnMenuInicial;
	public JTable tablaEmpleados;
	public JScrollPane barraTablaEmpleados;
	
	public TableRowSorter trsfiltroCodigoEmpleado;
	String filtroCodigoEmpleado;
	
	public JButton btnBorrarEmpleado;
	public JButton btnActualizarDatosEmpleado;
	public JButton btnMostrarEmpleado;
	public JButton btnNuevoEmpleado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lista_empleados frame = new lista_empleados();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public lista_empleados() {
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 650);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmpleados = new JLabel("Empleados");
		lblEmpleados.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		lblEmpleados.setBounds(467, 32, 119, 21);
		contentPane.add(lblEmpleados);
		
		JLabel lblCanalCoffee = new JLabel("Canal 40 Coffee TV  Channel ");
		lblCanalCoffee.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		lblCanalCoffee.setBounds(405, 11, 253, 21);
		contentPane.add(lblCanalCoffee);
		
		JLabel lblBuscarEmpleado = new JLabel("Buscar empleado :");
		lblBuscarEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblBuscarEmpleado.setBounds(39, 61, 142, 14);
		contentPane.add(lblBuscarEmpleado);
		
		txtBusquedaEmpleado = new JTextField();
		txtBusquedaEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		txtBusquedaEmpleado.setColumns(10);
		txtBusquedaEmpleado.setBounds(181, 58, 215, 20);
		contentPane.add(txtBusquedaEmpleado);
		InputMap map4 = txtBusquedaEmpleado.getInputMap(txtBusquedaEmpleado.WHEN_FOCUSED);
		map4.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		txtBusquedaEmpleado.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
				trsfiltroCodigoEmpleado = new TableRowSorter(tablaEmpleados.getModel());
				tablaEmpleados.setRowSorter(trsfiltroCodigoEmpleado);
			}

			public void keyPressed(KeyEvent ke) {

			}

			public void keyReleased(KeyEvent ke) {
				String cadena = (txtBusquedaEmpleado.getText());
				txtBusquedaEmpleado.setText(cadena);
				repaint();
				filtro();
			}
		});
		
		lblAreasDelModulo = new JLabel("Areas del modulo :");
		lblAreasDelModulo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblAreasDelModulo.setBounds(435, 64, 117, 14);
		contentPane.add(lblAreasDelModulo);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Empleados", "Cargos", "Horarios", "Contratos"}));
		comboBox.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		comboBox.setBounds(579, 58, 215, 20);
		contentPane.add(comboBox);
		
		label_4 = new JLabel("");
		label_4.setBounds(927, 8, 63, 67);
		contentPane.add(label_4);
		final ImageIcon icono1 = new ImageIcon(getClass().getResource("/material/logo.png"));
		final ImageIcon logo1 = new ImageIcon(icono1.getImage().getScaledInstance(label_4.getWidth(),label_4.getHeight(), Image.SCALE_DEFAULT));
		label_4.setIcon(logo1);
		
		lblCantidadTotalDe = new JLabel("Cantidad Total de Registros :");
		lblCantidadTotalDe.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblCantidadTotalDe.setBounds(29, 552, 201, 14);
		contentPane.add(lblCantidadTotalDe);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(214, 552, 77, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		lblPaginaN = new JLabel("Pagina N\u00BA");
		lblPaginaN.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblPaginaN.setBounds(310, 552, 86, 14);
		contentPane.add(lblPaginaN);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(376, 552, 63, 20);
		contentPane.add(textField_2);
		
		lblDe = new JLabel("De :");
		lblDe.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblDe.setBounds(449, 552, 41, 14);
		contentPane.add(lblDe);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(483, 552, 63, 20);
		contentPane.add(textField_3);
		
		btnMenuInicial = new JButton("Menu Inicial");
		btnMenuInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana_principal principal = new ventana_principal();
		 		principal.setVisible(true);
		 		principal.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnMenuInicial.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnMenuInicial.setBackground(new Color(0, 255, 127));
		btnMenuInicial.setBounds(39, 11, 133, 23);
		contentPane.add(btnMenuInicial);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(39, 86, 951, 432);
		contentPane.add(panel);
		panel.setLayout(null);
		
		barraTablaEmpleados = new JScrollPane();
		barraTablaEmpleados.setBounds(0, 0, 951, 432);
		panel.add(barraTablaEmpleados);
		
		tablaEmpleados = new JTable();
		barraTablaEmpleados.setViewportView(tablaEmpleados);
		
		btnBorrarEmpleado = new JButton("Borrar");
		btnBorrarEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnBorrarEmpleado.setBackground(new Color(220, 20, 60));
		btnBorrarEmpleado.setBounds(632, 563, 99, 23);
		contentPane.add(btnBorrarEmpleado);
		
		btnMostrarEmpleado = new JButton("Ver detalles");
		btnMostrarEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnMostrarEmpleado.setBackground(new Color(0, 206, 209));
		btnMostrarEmpleado.setBounds(741, 563, 108, 23);
		contentPane.add(btnMostrarEmpleado);
		
		btnActualizarDatosEmpleado = new JButton("Actualizar Datos");
		btnActualizarDatosEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnActualizarDatosEmpleado.setBackground(new Color(60, 179, 113));
		btnActualizarDatosEmpleado.setBounds(853, 563, 137, 23);
		contentPane.add(btnActualizarDatosEmpleado);
		
		btnNuevoEmpleado = new JButton("Nuevo");
		btnNuevoEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnNuevoEmpleado.setBackground(new Color(60, 179, 113));
		btnNuevoEmpleado.setBounds(632, 529, 99, 23);
		contentPane.add(btnNuevoEmpleado);
		
		
	}
	
	public void construirTablaEmpleados() {
		String titulos[] = { "Codigo", "Nombres", "Apellidos", "Identidad", "Genero",
				"Edad", "Telefono", "Correo", "Direccion", "Foto", "Nombre_Referencia",
				"Telefono_Referencia", "Fecha_Nacimiento", "Fecha_Registro", "Fecha_Labores", "Estado" };
		String informacion[][] = control_empleado.obtenerMatriz();
		tablaEmpleados = new JTable(informacion, titulos);
		barraTablaEmpleados.setViewportView(tablaEmpleados);
		for (int c = 0; c < tablaEmpleados.getColumnCount(); c++) {
			Class<?> col_class = tablaEmpleados.getColumnClass(c);
			tablaEmpleados.setDefaultEditor(col_class, null);
		}
	}

	public void filtro() {
		filtroCodigoEmpleado = txtBusquedaEmpleado.getText();
		trsfiltroCodigoEmpleado.setRowFilter(RowFilter.regexFilter(txtBusquedaEmpleado.getText(), 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15));
	}
}
