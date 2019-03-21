
package principal.television;

import controles.television.*;
import mantenimiento.television.*;
import clases.television.*;
import diseño.television.*;

public class television {

    public static void main(String[] args) {
    	
    	ventana_principal principal = new ventana_principal();
    	
    	cargo modCargo = new cargo();
        consultas_cargo modCCargo = new consultas_cargo();
        registro_mantenimiento_cargos frmCargo = new registro_mantenimiento_cargos();
        control_cargo ctrlcargo = new control_cargo(modCargo, modCCargo, frmCargo);
        ctrlcargo.iniciar();
        
        
        principal.setVisible(true);
        
        
        bonificacion modBonificacion = new bonificacion();
        consultas_bonificacion modCBonificacion = new consultas_bonificacion();
        registro_mantenimiento_bonificaciones frmBonificaciones = new registro_mantenimiento_bonificaciones();
        control_bonificacion ctrlbonificacion= new control_bonificacion(modBonificacion, modCBonificacion, frmBonificaciones);
        ctrlbonificacion.iniciar();
        frmBonificaciones.setVisible(false);
        
        principal.setVisible(true);
        
        
    
        
        
    }
    
}