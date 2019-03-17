
package principal.television;

import controles.television.*;
import mantenimiento.television.*;
import clases.television.*;
import diseño.television.*;

public class television {

    public static void main(String[] args) {
      
        empleado mod = new empleado();
        consultas_empleado modC = new consultas_empleado();
        registro_mantenimiento_empleados frm = new registro_mantenimiento_empleados();
        
        control_empleado ctrl = new control_empleado(mod, modC, frm);
        frm.setVisible(true);
        
    }
    
}