package formularios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import clases.cargo;
import clases.contrato_empleado;
import clases.historial_planilla;
import clases.horario;
import conexion.conexion;
import consultas.consultas_cargo;
import consultas.consultas_contrato_empleado;
import consultas.consultas_historial_planilla;
import consultas.consultas_horario;
import controles.control_cargo;
import controles.control_contrato_empleado;
import controles.control_historial_planilla;
import controles.control_horario;
import utilidades.visor_imagen;

import java.awt.Color;
import java.awt.Event;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Timer;

import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JToggleButton;

public class configuracion extends JFrame {

	public JPanel contentPane;
	public int contador1 = 0;
	public int contador2 = 0;
	public int contador3 = 0;
	public static String ruta;
	public static ImageIcon imagen;
	public static String identidad = null;
	
	public JButton btnGuardar;
	public JToggleButton btnAudio;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					configuracion frame = new configuracion();
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
	public configuracion() {
		setType(Type.UTILITY);
		setResizable(false);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 314, 303);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		final ImageIcon icono = new ImageIcon(getClass().getResource("/iconos/libreta.png"));

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(26, 32, 260, 222);
		contentPane.add(panel);

		JLabel lblFuncionesDelEmpleado = new JLabel("Configuracion de audio :");
		lblFuncionesDelEmpleado.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblFuncionesDelEmpleado.setBounds(20, 23, 220, 25);
		panel.add(lblFuncionesDelEmpleado);

		JLabel lblNombreDeLa = new JLabel("Sonidos del sistema :");
		lblNombreDeLa.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblNombreDeLa.setBounds(20, 48, 166, 25);
		panel.add(lblNombreDeLa);

		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			}
		});
		btnGuardar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnGuardar.setBackground(new Color(50, 205, 50));
		btnGuardar.setBounds(82, 176, 104, 23);
		panel.add(btnGuardar);

		JLabel lblConfiguracionDeNotificaciones = new JLabel("Configuracion de notificaciones :");
		lblConfiguracionDeNotificaciones.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		lblConfiguracionDeNotificaciones.setBounds(20, 71, 239, 25);
		panel.add(lblConfiguracionDeNotificaciones);

		btnAudio = new JToggleButton("OFF");
		btnAudio.setBackground(Color.RED);
		btnAudio.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAudio.setBounds(158, 52, 70, 17);
		panel.add(btnAudio);
		btnAudio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnAudio.isSelected()){
					btnAudio.setBackground(Color.GREEN);
					btnAudio.setText("ON");
					JOptionPane.showMessageDialog(null, "Sonido del sistema ACTIVADO!");
					
				}else {
					btnAudio.setBackground(Color.red);
					btnAudio.setText("OFF");
					JOptionPane.showMessageDialog(null, "Sonido del sistema DESACTIVADO!");
					
				}
			}
		});	
		

		JLabel label_12 = new JLabel("");
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setBounds(0, 0, 259, 221);
		panel.add(label_12);
		final ImageIcon logo = new ImageIcon(
				icono.getImage().getScaledInstance(label_12.getWidth(), label_12.getHeight(), Image.SCALE_DEFAULT));
		label_12.setIcon(logo);

		JLabel lblRegistroYMantenimiento = new JLabel("CONFIGURACIONES");
		lblRegistroYMantenimiento.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroYMantenimiento.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblRegistroYMantenimiento.setBounds(26, 11, 260, 23);
		contentPane.add(lblRegistroYMantenimiento);

	}
	
	public void ON() {
		if(btnAudio.isSelected()) {
			btnAudio.setBackground(Color.GREEN);
			btnAudio.setText("ON");
			JOptionPane.showMessageDialog(null, "Sonido del sistema ACTIVADO!");
		}else {
			btnAudio.setBackground(Color.RED);
			btnAudio.setText("OFF");
			JOptionPane.showMessageDialog(null, "Sonido del sistema DESACTIVADO!");
		}
	}

}
