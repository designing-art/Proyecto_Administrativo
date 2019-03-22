package controles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import clases.cargo;
import consultas.consultas_cargo;
import formularios.registro_mantenimiento_cargos;

public class control_cargo implements ActionListener {

    public cargo modCargo;
    public consultas_cargo modCCargo;
    public registro_mantenimiento_cargos frmCargo;

    public control_cargo(cargo modCargo, consultas_cargo modCCargo, registro_mantenimiento_cargos frmCargo) {
        this.modCargo = modCargo;
        this.modCCargo = modCCargo;
        this.frmCargo = frmCargo;
        this.frmCargo.btnGuardarCargo.addActionListener(this);
        this.frmCargo.btnActualizarCargo.addActionListener(this);
        this.frmCargo.btnBorrarCargo.addActionListener(this);
        this.frmCargo.btnNuevoCargo.addActionListener(this);
    }


	public void iniciar() {
        frmCargo.setTitle("Registro de cargos");
        frmCargo.setVisible(true);
        frmCargo.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == frmCargo.btnGuardarCargo) {
            modCargo.setId_cargo(Integer.parseInt(frmCargo.txtCodigoCargo.getText()));
            modCargo.setArea_cargo(frmCargo.cbxTipoCargo.getSelectedItem().toString());
            modCargo.setNombre_cargo(frmCargo.cbxNombreCargo.getSelectedItem().toString());
            modCargo.setValor_hora_extra_cargo(Double.parseDouble(frmCargo.txtHoraExtraCargo.getText()));
            modCargo.setSueldo_cargo(Double.parseDouble(frmCargo.txtSueldoCargo.getText()));
            modCargo.setFunciones_cargo(frmCargo.txtFunsionesCargo.getText());
            
            if(modCCargo.registrar(modCargo))
            {
                JOptionPane.showMessageDialog(null, "Exito! Cargo Registrado.");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Lo sentimos, Cargo no registrado, Verifique los datos del cargo, he intentelo de nuevo.");
                limpiar();
            }
        }
        
        if (e.getSource() == frmCargo.btnActualizarCargo) {
        	modCargo.setId_cargo(Integer.parseInt(frmCargo.txtCodigoCargo.getText()));
            modCargo.setArea_cargo(frmCargo.cbxTipoCargo.getSelectedItem().toString());
            modCargo.setNombre_cargo(frmCargo.cbxNombreCargo.getSelectedItem().toString());
            modCargo.setValor_hora_extra_cargo(Double.parseDouble(frmCargo.txtHoraExtraCargo.getText()));
            modCargo.setSueldo_cargo(Double.parseDouble(frmCargo.txtSueldoCargo.getText()));
            modCargo.setFunciones_cargo(frmCargo.txtFunsionesCargo.getText());
            
            if(modCCargo.modificar(modCargo))
            {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
            }
        }
        
        if (e.getSource() == frmCargo.btnBorrarCargo) {
            modCargo.setId_cargo(Integer.parseInt(frmCargo.txtCodigoCargo.getText()));
            
            if(modCCargo.eliminar(modCargo))
            {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                limpiar();
            }
        } 
        
        if (e.getSource() == frmCargo.btnNuevoCargo) {
            limpiar();
        }

    }
    
    public void limpiar()
    {
    	frmCargo.txtCodigoCargo.setText(null);
        frmCargo.cbxNombreCargo.setToolTipText(null);
        frmCargo.cbxTipoCargo.setToolTipText(null);
        frmCargo.txtHoraExtraCargo.setText(null);
        frmCargo.txtSueldoCargo.setText(null);
        frmCargo.txtFunsionesCargo.setText(null);

    }

	

}
