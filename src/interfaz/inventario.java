package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JProgressBar;

public class inventario extends JFrame {

	private JPanel contentPane;
	private JTable tableinventario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inventario frame = new inventario();
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
	public inventario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 538);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInventario = new JLabel("Inventario");
		lblInventario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblInventario.setHorizontalAlignment(SwingConstants.CENTER);
		lblInventario.setBounds(174, 32, 98, 14);
		contentPane.add(lblInventario);
		
		tableinventario = new JTable();
		tableinventario.setToolTipText("");
		tableinventario.setBackground(new Color(255, 255, 255));
		tableinventario.setModel(new DefaultTableModel(
			new Object[][] {
				{"", null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Nombre del Equipo", "Precio", "Descripcion", "Peso", "Color", "Marca", "Existencia", "Modelo"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, true, true, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableinventario.getColumnModel().getColumn(1).setPreferredWidth(113);
		tableinventario.setBounds(25, 89, 435, 200);
		contentPane.add(tableinventario);
		
		
		
		
		
		
	}
}
