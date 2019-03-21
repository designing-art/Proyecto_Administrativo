package dise�o.television;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import conexion.television.conexion;

import java.awt.Window.Type;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import javax.swing.JList;
import javax.swing.border.BevelBorder;

public class registro_mantenimiento_cargos extends JFrame {
	
	public JTextField txtCodigoCargo ;
	public JComboBox cbNombreCargo ;
	public JComboBox cbTipoCargo ;
	 public JTextField txtSueldoCargo ;
	 public JTextField txtHoraExtraCargo ;
	 
	 public JButton btnGuardarCargo;
	 public JButton btnActualizarCargo;
	 public JButton btnNuevoCargo;
	 public JButton btnBorrarCargo;
	
	 public JPanel contentPane;
	 private JLabel lblNewLabel;
	 private JPanel panel_1;
	 private JLabel lblListaDeCargos;
	 private JLabel label_7;
	 public JTable tablaCargos;
	 private static JTable table;
	 private JTextField textField;
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DefaultTableModel modelo = new DefaultTableModel();
					table.setModel(modelo);
		            PreparedStatement ps = null;
		            ResultSet rs = null;
		            conexion conn = new conexion();
		            java.sql.Connection con = conn.getConexion();

		            String sql = "SELECT id_cargo, tipo_cargo, nombre_cargo, sueldo_cargo, funsiones_cargo FROM cargos";
		            ps = con.prepareStatement(sql);
		            rs = ps.executeQuery();

		            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
		            int cantidadColumnas = rsMd.getColumnCount();

		            modelo.addColumn("C�digo");
		            modelo.addColumn("Producto");
		            modelo.addColumn("Precio");
		            modelo.addColumn("Cantidad");

		            int[] anchos = {50, 200, 50, 50};
		            for (int i = 0; i < table.getColumnCount(); i++) {
		                table.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
		            }

		            while (rs.next()) {
		                Object[] filas = new Object[cantidadColumnas];
		                for (int i = 0; i < cantidadColumnas; i++) {
		                    filas[i] = rs.getObject(i + 1);
		                }
		                modelo.addRow(filas);
		            }
					registro_mantenimiento_cargos frame = new registro_mantenimiento_cargos();
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
	public registro_mantenimiento_cargos() {
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 510);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBounds(21, 38, 341, 434);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JEditorPane txtFunsionesCargo = new JEditorPane();
		txtFunsionesCargo.setBackground(Color.LIGHT_GRAY);
		txtFunsionesCargo.setBounds(135, 249, 181, 90);
		panel.add(txtFunsionesCargo);
		
		JLabel label = new JLabel();
		label.setBounds(256, 69, 49, 44);
		panel.add(label);
		final ImageIcon logopeq = new ImageIcon(getClass().getResource("/material/television/logo.png"));
		final ImageIcon iconopeq = new ImageIcon(logopeq.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
		label.setIcon(iconopeq);
		
		btnNuevoCargo = new JButton("NUEVO");
		btnNuevoCargo.setBounds(26, 378, 99, 23);
		panel.add(btnNuevoCargo);
		btnNuevoCargo.setBackground(new Color(0, 128, 128));
		
		btnGuardarCargo = new JButton("GUARDAR");
		btnGuardarCargo.setBounds(217, 378, 99, 23);
		panel.add(btnGuardarCargo);
		btnGuardarCargo.setBackground(new Color(60, 179, 113));
		
		JLabel lblHoraExtraCargo = new JLabel("4. Valor hora extra :");
		lblHoraExtraCargo.setBounds(26, 186, 99, 22);
		panel.add(lblHoraExtraCargo);
		
		txtHoraExtraCargo = new JTextField();
		txtHoraExtraCargo.setBounds(197, 187, 119, 20);
		panel.add(txtHoraExtraCargo);
		txtHoraExtraCargo.setColumns(10);
		
		txtSueldoCargo = new JTextField();
		txtSueldoCargo.setBounds(197, 218, 119, 20);
		panel.add(txtSueldoCargo);
		txtSueldoCargo.setColumns(10);
		
		JLabel lblSueldoCargo = new JLabel("5. Sueldo :");
		lblSueldoCargo.setBounds(25, 215, 100, 23);
		panel.add(lblSueldoCargo);
		
		JLabel lblNombreCargo = new JLabel("3. Nombre cargo:");
		lblNombreCargo.setBounds(26, 161, 100, 14);
		panel.add(lblNombreCargo);
		
		JLabel lblTipoDeCargo = new JLabel("2. Tipo de cargo :");
		lblTipoDeCargo.setBounds(26, 127, 105, 23);
		panel.add(lblTipoDeCargo);
		
		 txtCodigoCargo = new JTextField();
		 txtCodigoCargo.setEditable(false);
		 txtCodigoCargo.setBounds(135, 100, 28, 18);
		 panel.add(txtCodigoCargo);
		 txtCodigoCargo.setColumns(10);
		 
		 JLabel lblCodigoCargo = new JLabel("1. Codigo :");
		 lblCodigoCargo.setBounds(26, 102, 63, 14);
		 panel.add(lblCodigoCargo);
		 
		 JLabel lblRegistroCargos = new JLabel("Registro de Cargos");
		 lblRegistroCargos.setBounds(26, 66, 136, 23);
		 panel.add(lblRegistroCargos);
		 lblRegistroCargos.setFont(new Font("Tahoma", Font.BOLD, 11));
		 
		 JLabel lblFuncionesCargo = new JLabel("6. Funciones :");
		 lblFuncionesCargo.setBounds(26, 249, 76, 14);
		 panel.add(lblFuncionesCargo);
		 final ImageIcon icono = new ImageIcon(getClass().getResource("/material/television/libreta.png"));
		 
		 JComboBox cbTipoCargo = new JComboBox();
		 
		 cbTipoCargo.setBounds(135, 128, 181, 22);
		 panel.add(cbTipoCargo);
		 
		 JComboBox cbNombreCargo = new JComboBox();
		 cbNombreCargo.setBounds(135, 158, 181, 22);
		 panel.add(cbNombreCargo);
		 
		 JLabel lblL = new JLabel("L.");
		 lblL.setBounds(181, 190, 17, 14);
		 panel.add(lblL);
		 
		 JLabel label_1 = new JLabel("L.");
		 label_1.setBounds(181, 224, 17, 14);
		 panel.add(label_1);
		 
		 JLabel lblImagenLibreta = new JLabel();
		 lblImagenLibreta.setBounds(0, 0, 341, 434);
		 panel.add(lblImagenLibreta);
		 final ImageIcon logo = new ImageIcon(icono.getImage().getScaledInstance(lblImagenLibreta.getWidth(), lblImagenLibreta.getHeight(), Image.SCALE_DEFAULT));
		 lblImagenLibreta.setIcon(logo);
		 
		 panel_1 = new JPanel();
		 panel_1.setLayout(null);
		 panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		 panel_1.setBounds(373, 38, 400, 434);
		 contentPane.add(panel_1);
		 
		 
		 btnActualizarCargo = new JButton("Actualizar");
		 btnActualizarCargo.setBounds(27, 379, 99, 23);
		 panel_1.add(btnActualizarCargo);
		 btnActualizarCargo.setBackground(new Color(0, 128, 0));
		 
		 btnBorrarCargo = new JButton("Borrar");
		 btnBorrarCargo.setBounds(272, 379, 99, 23);
		 panel_1.add(btnBorrarCargo);
		 btnBorrarCargo.setBackground(Color.RED);
		 
		 lblListaDeCargos = new JLabel("Lista de Cargos Registrados");
		 lblListaDeCargos.setFont(new Font("Tahoma", Font.BOLD, 11));
		 lblListaDeCargos.setBounds(27, 46, 190, 23);
		 panel_1.add(lblListaDeCargos);
		 final ImageIcon icono2 = new ImageIcon(getClass().getResource("/material/television/libreta.png"));
		 
		 table = new JTable();
		 table.setModel(new DefaultTableModel(
		 	new Object[][] {
		 		{null, null, null, null, null, null},
		 		{null, null, null, null, null, null},
		 		{null, null, null, null, null, null},
		 		{null, null, null, null, null, null},
		 		{null, null, null, null, null, null},
		 		{null, null, null, null, null, null},
		 		{null, null, null, null, null, null},
		 		{null, null, null, null, null, null},
		 		{null, null, null, null, null, null},
		 		{null, null, null, null, null, null},
		 		{null, null, null, null, null, null},
		 		{null, null, null, null, null, null},
		 		{null, null, null, null, null, null},
		 		{null, null, null, null, null, null},
		 		{null, null, null, null, null, null},
		 		{null, null, null, null, null, null},
		 	},
		 	new String[] {
		 		"Codigo", "Tipo", "Nombre", "Hora Extra", "Sueldo", "Funsiones"
		 	}
		 ) {
		 	Class[] columnTypes = new Class[] {
		 		Integer.class, String.class, String.class, Double.class, Double.class, String.class
		 	};
		 	public Class getColumnClass(int columnIndex) {
		 		return columnTypes[columnIndex];
		 	}
		 	boolean[] columnEditables = new boolean[] {
		 		false, false, false, false, false, false
		 	};
		 	public boolean isCellEditable(int row, int column) {
		 		return columnEditables[column];
		 	}
		 });
		 table.getColumnModel().getColumn(0).setResizable(false);
		 table.getColumnModel().getColumn(1).setResizable(false);
		 table.getColumnModel().getColumn(2).setResizable(false);
		 table.getColumnModel().getColumn(3).setResizable(false);
		 table.getColumnModel().getColumn(4).setResizable(false);
		 table.getColumnModel().getColumn(5).setResizable(false);
		 table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		 table.setBackground(Color.LIGHT_GRAY);
		 table.setBounds(27, 100, 344, 264);
		 panel_1.add(table);
		 
		 JLabel lblBuscar = new JLabel("Buscar");
		 lblBuscar.setBounds(27, 68, 60, 31);
		 panel_1.add(lblBuscar);
		 
		 textField = new JTextField();
		 textField.setColumns(10);
		 textField.setBounds(88, 73, 283, 20);
		 panel_1.add(textField);
		 
		 JLabel lblTaa = new JLabel();
		 lblTaa.setBounds(0, 0, 400, 434);
		 panel_1.add(lblTaa);
		 final ImageIcon logo2 = new ImageIcon(icono2.getImage().getScaledInstance(lblTaa.getWidth(), lblTaa.getHeight(), Image.SCALE_DEFAULT));
		 lblTaa.setIcon(logo2);
		 
		 JLabel lblCargos = new JLabel("Cargos");
		 lblCargos.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
		 lblCargos.setBounds(21, 6, 86, 30);
		 contentPane.add(lblCargos);
		 
		 JButton btnRegresar = new JButton("Regresar");
		 btnRegresar.setForeground(new Color(0, 0, 0));
		 btnRegresar.setFont(new Font("Showcard Gothic", Font.PLAIN, 15));
		 btnRegresar.setBackground(new Color(184, 134, 11));
		 btnRegresar.setBounds(655, 11, 118, 23);
		 contentPane.add(btnRegresar);
		
	}
}
