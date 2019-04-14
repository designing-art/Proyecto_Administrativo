package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class visor_imagen extends JFrame {

	public JPanel contentPane;
	public JTextField txtRutaImagen;
	public JLabel lblImagen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					visor_imagen frame = new visor_imagen();
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
	public visor_imagen() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setTitle("Visor by Designing Art.");
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/material/logo.png")));

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		lblImagen = new JLabel();
		scrollPane.setViewportView(lblImagen);

		JMenuBar menuBar = new JMenuBar();
		scrollPane.setColumnHeaderView(menuBar);

		JMenu menu = new JMenu("Archivo");
		menu.setBackground(new Color(32, 178, 170));
		menuBar.add(menu);

		JMenuItem IMPRIMIR = new JMenuItem("Imprimir");
		IMPRIMIR.setBackground(Color.WHITE);
		menu.add(IMPRIMIR);


		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Controles de imagen"));
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout());

		JLabel label = new JLabel("Ruta :");
		panel.add(label);

		txtRutaImagen = new JTextField();
		txtRutaImagen.setEditable(false);
		txtRutaImagen.setColumns(10);
		panel.add(txtRutaImagen);

		JButton btnZoomMenos = new JButton("(-) Zoom ");
		btnZoomMenos.setBackground(Color.WHITE);
		panel.add(btnZoomMenos);

		JButton btnZoomMas = new JButton("(+) Zoom ");
		btnZoomMas.setBackground(Color.WHITE);
		panel.add(btnZoomMas);

		IMPRIMIR.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					imprimirImagen();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	public void imprimirImagen() throws IOException {
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream("c:/archivo.pdf");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		if (inputStream == null) {
			return;
		}
		DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
		Doc document = new SimpleDoc(inputStream, docFormat, null);
		PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();
		PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();
		if (defaultPrintService != null) {
			DocPrintJob printJob = defaultPrintService.createPrintJob();
			try {
				printJob.print(document, attributeSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, "No existen impresoras instaladas.");
		}
		inputStream.close();

	}

}
