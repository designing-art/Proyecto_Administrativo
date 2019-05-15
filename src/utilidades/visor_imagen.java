package utilidades;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.WindowConstants;
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
import javax.swing.ScrollPaneConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class visor_imagen extends JFrame {

	public JPanel contentPane;
	public JTextField txtRutaImagen;
	public String ruta;
	public static JScrollPane scrollPane;
	public static JLabel lblImagen;

	public visor_imagen() {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setTitle("Visor by Designing Art.");
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/iconos/logo_corchetes.png")));

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(BorderFactory.createTitledBorder("Controles de imagen"));
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout());

		JLabel label = new JLabel("Ruta :");
		panel.add(label);

		txtRutaImagen = new JTextField();
		txtRutaImagen.setEditable(false);
		txtRutaImagen.setColumns(10);
		panel.add(txtRutaImagen);

		JMenuBar menuBar = new JMenuBar();
		contentPane.add(menuBar, BorderLayout.NORTH);

		JMenu menu = new JMenu("Archivo");
		menu.setBackground(new Color(32, 178, 170));
		menuBar.add(menu);

		JMenuItem IMPRIMIR = new JMenuItem("Imprimir");
		IMPRIMIR.setBackground(Color.WHITE);
		menu.add(IMPRIMIR);

		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane, BorderLayout.CENTER);

		lblImagen = new JLabel();
		lblImagen.setSize(scrollPane.getWidth(), lblImagen.getHeight());
		scrollPane.setViewportView(lblImagen);

	}

	public void imprimirImagen() throws IOException {
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(txtRutaImagen.getText().toString());
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
