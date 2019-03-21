
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
        frmCargo.setVisible(false);
        
        horario modHorario = new horario(0, null, null, null, null, null, null);
        consultas_horario modCHorario = new consultas_horario();
        registro_mantenimiento_horarios frmHorario = new registro_mantenimiento_horarios();
        control_horario ctrlhorario = new control_horario(modHorario, modCHorario, frmHorario);
        ctrlhorario.iniciar();
        frmHorario.setVisible(false);
        
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