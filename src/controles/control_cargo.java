package controles;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import com.placeholder.PlaceHolder;

import clases.cargo;
import consultas.consultas_cargo;
import formularios.registro_cargos;

public class control_cargo implements ActionListener {

    public cargo claseCargo;
    public consultas_cargo consultasCargo;
    public registro_cargos formularioCargo;

    public control_cargo(cargo claseCargo, consultas_cargo consultasCargo, registro_cargos formularioCargo) {
        this.claseCargo = claseCargo;
        this.consultasCargo = consultasCargo;
        this.formularioCargo = formularioCargo;
        this.formularioCargo.btnGuardarCargo.addActionListener(this);
        this.formularioCargo.btnNuevoCargo.addActionListener(this);
        this.formularioCargo.btnActualizarCargo.addActionListener(this);
        
    }
    
    //---------------------------------------------------------------------------------------------------------------------------//
    //---------------------------EVENTOS PARA INSERTAR Y ACTUALIZAR CARGOS-------------------------------------------------------//

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == formularioCargo.btnGuardarCargo) {
            claseCargo.setArea_cargo(formularioCargo.cbxTipoCargo.getSelectedItem().toString());
            claseCargo.setNombre_cargo(formularioCargo.txtNombreCargo.getText());
            claseCargo.setSueldo_cargo(Double.parseDouble(formularioCargo.txtSueldoCargo.getText()));
            claseCargo.setValor_hora_extra_cargo(Double.parseDouble(formularioCargo.txtHoraExtraCargo.getText()));
            claseCargo.setFunciones_cargo(formularioCargo.txtFuncionesCargo.getText());
       
                	 if(consultasCargo.registrar(claseCargo))
                     {
                		 if(formularioCargo.txtSueldoCargo.getText().isEmpty()) {
         					JOptionPane.showMessageDialog(null, "Porfavor, Ingrese el sueldo");
         				}
         				if(formularioCargo.txtHoraExtraCargo.getText().isEmpty()) {
         					JOptionPane.showMessageDialog(null, "Porfavor, Ingrese el valor de Hora extra.");
         				}
         				if(formularioCargo.txtFuncionesCargo.getText().isEmpty()) {
         					JOptionPane.showMessageDialog(null, "Porfavor, Escriba las funciones del empleado.");
         				}else {
         					JOptionPane.showMessageDialog(null, "Exito! Cargo Registrado.");
                            limpiar();
         				}    
                } 
        
        if (e.getSource() == formularioCargo.btnActualizarCargo) {
            claseCargo.setArea_cargo(formularioCargo.cbxTipoCargo.getSelectedItem().toString());
            claseCargo.setNombre_cargo(formularioCargo.txtNombreCargo.getText());
            claseCargo.setSueldo_cargo(Double.parseDouble(formularioCargo.txtSueldoCargo.getText()));
            claseCargo.setValor_hora_extra_cargo(Double.parseDouble(formularioCargo.txtHoraExtraCargo.getText()));
            claseCargo.setFunciones_cargo(formularioCargo.txtFuncionesCargo.getText());
            
            if(consultasCargo.modificar(claseCargo))
            {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
            }
        }
        
        if (e.getSource() == formularioCargo.btnNuevoCargo) {
            limpiar();
        }
        }

    }

    public void limpiar()
    {
        formularioCargo.txtNombreCargo.setToolTipText(null);
        formularioCargo.cbxTipoCargo.setToolTipText(null);
        formularioCargo.txtSueldoCargo.setText(null);
        formularioCargo.txtHoraExtraCargo.setText(null);
        formularioCargo.txtFuncionesCargo.setText(null);

    }
    
    //------------------------------------FIN DE LOS METODOS DE REGISTRO Y ACTUALIZAR CARGO-----------------------------------//
		 
		 
		 public void pistas() {
				PlaceHolder pistas;
				pistas = new PlaceHolder(formularioCargo.txtSueldoCargo, "Ingrese el sueldo");
				pistas = new PlaceHolder(formularioCargo.txtHoraExtraCargo, "Ingrese precio hora extra.");
				pistas = new PlaceHolder(formularioCargo.txtFuncionesCargo, "Escriba funciones del empleado.");
			}
			 
			 public static String[][] obtenerMatriz() {
			   
			  consultas_cargo consulta = new consultas_cargo();
			  ArrayList<cargo>miLista = consulta.buscarUsuariosConMatriz();
			   
			  String matrizInfo[][]=new String[miLista.size()][6];
			   
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
}
