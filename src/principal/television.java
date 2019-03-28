
package principal;

import formularios.*;

public class television {

    public static void main(String[] args) {
        ventana_principal principal = new ventana_principal();
        principal.setLocationRelativeTo(null);
        principal.setVisible(true);
       
          lista_cargos_completa miVentanaConsulta;
          miVentanaConsulta= new lista_cargos_completa();
          miVentanaConsulta.setVisible(true);
         
    }
    
}