
package principal;

import clases.*;
import consultas.*;
import controles.*;
import formularios.*;

public class television {

    public static void main(String[] args) {
    	
    	cargo modCargo = new cargo();
        consultas_cargo modCCargo = new consultas_cargo();
        registro_mantenimiento_cargos frmCargo = new registro_mantenimiento_cargos();
        control_cargo ctrlcargo = new control_cargo(modCargo, modCCargo, frmCargo);
        ctrlcargo.iniciar();
        
        bonificacion modBonificacion = new bonificacion();
        consultas_bonificacion modCBonificacion = new consultas_bonificacion();
        registro_mantenimiento_bonificaciones frmBonificaciones = new registro_mantenimiento_bonificaciones();
        control_bonificacion ctrlbonificacion= new control_bonificacion(modBonificacion, modCBonificacion, frmBonificaciones);
        ctrlbonificacion.iniciar();
        
        ventana_principal principal = new ventana_principal();
        principal.setVisible(true);
        
        
    
        
        
    }
    
}