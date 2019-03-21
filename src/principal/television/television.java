
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
        
        
    }
    
}