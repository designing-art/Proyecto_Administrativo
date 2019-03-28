package formularios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTable;


import consultas.consultas_cargo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import clases.cargo;
import consultas.consultas_cargo;

public class tabla_cargos extends JFrame {

	public JPanel contentPane;
	public JTable tablaCargos;
	
	public JLabel labelTitulo;
	 JScrollPane mibarra1;
	 public JButton btnNewButton;

	 tablaCargos = new JTable();
		tablaCargos.setBounds(40, 61, 534, 327);
		contentPane.add(tablaCargos);
		
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tabla_cargos frame = new tabla_cargos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public tabla_cargos() {
		setResizable(false);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 617, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		inicializaComponentes();
		  construirTabla();
	}
	
	private void inicializaComponentes() {
		getContentPane().setLayout(null);
		 
		  labelTitulo = new JLabel();
		  labelTitulo.setBounds(27, 11, 400, 30);
		  labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		  labelTitulo.setText("CONSULTA DE PERSONAS");
		  labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));
		  getContentPane().add(labelTitulo);
		   
		  mibarra1=new JScrollPane();
		  mibarra1.setBounds(27, 72,400,130);
		  getContentPane().add(mibarra1);
		   
		  btnNewButton = new JButton("Actualizar");
		  btnNewButton.setBounds(335, 219, 89, 23);
		  getContentPane().add(btnNewButton);
		  btnNewButton.addActionListener(this);
		
	}

	private void construirTabla() {
		  String titulos[]={ "Codigo", "Area", "Nombre", "Sueldo","Hora Extra", "Funsiones"};
		  String informacion[][]=obtenerMatriz();
		   
		  tablaCargos = new JTable(informacion,titulos);
		  mibarra1.setViewportView(tablaCargos);
		   
		 }

	private String[][] obtenerMatriz() {
		   
		  consultas_cargo cargo = new consultas_cargo();
		  ArrayList<cargo>miLista = cargo.cargarTablaCargos();
		   
		  String matrizInfo[][]=new String[miLista.size()][5];
		   
		  for (int i = 0; i < miLista.size(); i++) {
		   matrizInfo[i][0]=miLista.get(i).getId_cargo()+"";
		   matrizInfo[i][1]=miLista.get(i).getArea_cargo()+"";
		   matrizInfo[i][2]=miLista.get(i).getNombre_cargo()+"";
		   matrizInfo[i][3]=miLista.get(i).getSueldo_cargo()+"";
		   matrizInfo[i][4]=miLista.get(i).getValor_hora_extra_cargo()+"";
		   matrizInfo[i][5]=miLista.get(i).getFunciones_cargo()+"";
		  }
		    
		  return matrizInfo;
		 }
		 
		 public void actionPerformed(ActionEvent e) {
		  if (e.getSource()==btnNewButton) {
		   construirTabla();
		  }
		 }
		}

