
package principal.television;

import controles.television.*;
import mantenimiento.television.*;
import clases.television.*;
import dise�o.television.*;

public class television {

    public static void main(String[] args) {
      
        cargo modCargo = new cargo();
        consultas_cargo modCCargo = new consultas_cargo();
        registro_mantenimiento_cargos frmCargo = new registro_mantenimiento_cargos();
        
        control_cargo ctrl = new control_cargo(modCargo, modCCargo, frmCargo);
        ctrl.iniciar();
        frmCargo.setVisible(true);
        
    }
    
}