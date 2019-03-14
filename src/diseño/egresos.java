package diseño;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class egresos extends JFrame {

	private JPanel contentPane;
	private JTextField txtcodigoegresos;
	private JTextField txtalquiler;
	private JTextField txtenergiaelectrica;
	private JTextField txtaguapotable;
	private JTextField txttelefonia;
	private JTextField txtinternet;
	private JTextField txtcombustibles;
	private JTextField txtviaticos;
	private JTextField txtotrosegresos;
	private JTextField txttotalegresos;
	private JTextField txtfechaegresos;
	private JTextField txtdescripcionegresos;
	/**
	 * @wbp.nonvisual location=-28,359
	 */
	private final JTextArea textArea = new JTextArea();
	private JTextField textField_6;
	private JTextField textField_7;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					egresos frame = new egresos();
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
	public egresos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 529);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEgresos = new JLabel("EGRESOS");
		lblEgresos.setHorizontalAlignment(SwingConstants.CENTER);
		lblEgresos.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEgresos.setBounds(170, 11, 147,40);
		contentPane.add(lblEgresos);
		
		
		JLabel lblCodigoEgresos = new JLabel("Codigo Egresos : ");
		lblCodigoEgresos.setBounds(10, 95, 118, 14);
		contentPane.add(lblCodigoEgresos);
		
		JLabel lblegresosalquiler = new JLabel("Alquiler : L.");
		lblegresosalquiler.setBounds(10, 150, 124, 14);
		contentPane.add(lblegresosalquiler);
		
		JLabel lblegresosenergia = new JLabel("Energia Electrica :  L.");
		lblegresosenergia.setBounds(10, 200, 86, 14);
		contentPane.add(lblegresosenergia);
		
		JLabel lblegresosaguapotable = new JLabel("Agua potable :  L.");
		lblegresosaguapotable.setBounds(10, 250, 240, 14);
		contentPane.add(lblegresosaguapotable);
		
		JLabel lblegresostelefono = new JLabel("Telefonia :  L.");
		lblegresostelefono.setBounds(10, 300, 240, 14);
		contentPane.add(lblegresostelefono);
		
		JLabel lblegresosinternet = new JLabel("Internet :  L.");
		lblegresosinternet.setBounds(10, 352, 280, 14);
		contentPane.add(lblegresosinternet);
		
		JLabel lblegresoscombustibles = new JLabel("Combustibles :  L");
		lblegresoscombustibles.setBounds(10, 400, 320, 14);
		contentPane.add(lblegresoscombustibles);
		
		JLabel lblegresosviaticos = new JLabel("Viaticos :  L.");
		lblegresosviaticos.setBounds(10, 446, 78, 14);
		contentPane.add(lblegresosviaticos);
		
		
		JLabel lblotrosegresos = new JLabel("Otros Egresos :  L.");
		lblotrosegresos.setBounds(10, 500, 109, 14);
		contentPane.add(lblotrosegresos);
		
		
		JLabel lbltotalegresos = new JLabel("Total Egresos :  L.");
		lbltotalegresos.setBounds(10, 545, 105, 14);
		contentPane.add(lbltotalegresos);
		
		
		JLabel lblfechaegresos = new JLabel("Fecha Egresos : ");
		lblfechaegresos.setBounds(10, 585, 105, 14);
		contentPane.add(lblfechaegresos);
		
		
		JLabel lbldescripcionegresos = new JLabel("Descripcion Egresos : ");
		lbldescripcionegresos.setBounds(10, 630, 130, 14);
		contentPane.add(lbldescripcionegresos);
		
		JButton btnguardaregresos = new JButton("GUARDAR");
		btnguardaregresos.setBackground(new Color(0, 128, 0));
		btnguardaregresos.setForeground(new Color(0, 0, 0));
		btnguardaregresos.setBounds(42, 676, 118, 23);
		contentPane.add(btnguardaregresos);
		
		txtcodigoegresos = new JTextField();
		txtcodigoegresos.setEditable(false);
		txtcodigoegresos.setBounds(146, 92, 86, 20);
		contentPane.add(txtcodigoegresos);
		txtcodigoegresos.setColumns(10);
		
		txtalquiler = new JTextField();
		txtalquiler.setBounds(146, 147, 86, 20);
		contentPane.add(txtalquiler);
		txtalquiler.setColumns(10);
		
		txtenergiaelectrica = new JTextField();
		txtenergiaelectrica.setBounds(146, 197, 86, 20);
		contentPane.add(txtenergiaelectrica);
		txtenergiaelectrica.setColumns(10);
		
		txtaguapotable = new JTextField();
		txtaguapotable.setBounds(146, 247, 86, 20);
		contentPane.add(txtaguapotable);
		txtaguapotable.setColumns(10);
		
		txttelefonia = new JTextField();
		txttelefonia.setBounds(146, 297, 86, 20);
		contentPane.add(txttelefonia);
		txttelefonia.setColumns(10);
		
		txtinternet = new JTextField();
		txtinternet.setBounds(146, 349, 86, 20);
		contentPane.add(txtinternet);
		txtinternet.setColumns(10);
		
		txtcombustibles = new JTextField();
		txtcombustibles.setBounds(146, 397, 86, 20);
		contentPane.add(txtcombustibles);
		txtcombustibles.setColumns(10);
		
		txtviaticos = new JTextField();
		txtviaticos.setBounds(146, 446, 86, 20);
		contentPane.add(txtviaticos);
		txtviaticos.setColumns(10);
		
		
		txtotrosegresos = new JTextField();
		txtotrosegresos.setBounds(146, 500, 86, 20);
		contentPane.add(txtotrosegresos);
		txtotrosegresos.setColumns(10);
		
		
		txttotalegresos = new JTextField();
		txttotalegresos.setBounds(146, 545, 86, 20);
		contentPane.add(txttotalegresos);
		txttotalegresos.setEditable(false);
		txttotalegresos.setColumns(10);
		
		txtfechaegresos = new JTextField();
		txtfechaegresos.setBounds(146, 585, 86, 20);
		contentPane.add(txtfechaegresos);
		txtfechaegresos.setEditable(false);
		txtfechaegresos.setColumns(10);
		
		
		txtdescripcionegresos = new JTextField();
		txtdescripcionegresos.setBounds(146, 630, 86, 20);
		contentPane.add(txtdescripcionegresos);
		txtdescripcionegresos.setColumns(10);
		
		
		
		
		
		
		
		
	}
}
