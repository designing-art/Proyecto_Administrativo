package formularios;
 
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
 
public class lista_cargos_completa extends JFrame implements ActionListener {
 
 private JLabel labelTitulo;
 JTable miTabla1;
 JScrollPane mibarra1;
 private JButton btnNewButton;
 
 public lista_cargos_completa() {
  setSize(462, 281);
  setTitle("CoDejaVu : Componentes JTable");
  setLocationRelativeTo(null);
  setResizable(false);
   
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
   
  miTabla1=new JTable(informacion,titulos);
  mibarra1.setViewportView(miTabla1);
   
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
 
 
 
 @Override
 public void actionPerformed(ActionEvent e) {
  if (e.getSource()==btnNewButton) {
   construirTabla();
  }
 }
}
