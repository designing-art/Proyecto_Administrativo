package controles.television;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import clases.television.deduccion;
import clases.television.deduccion;
import diseño.television.registro_mantenimiento_deducciones;
import mantenimiento.television.cosultas_deduccion;

public class control_deduccion {
	
	public deduccion modDeduccion;
	public cosultas_deduccion modCDeduccion;
	public registro_mantenimiento_deducciones frmDeduccion;
	
	
	public control_deduccion(deduccion modDeduccion, cosultas_deduccion modCDeduccion,
			registro_mantenimiento_deducciones frmDeduccion) {
		super();
		this.modDeduccion = modDeduccion;
		this.modCDeduccion = modCDeduccion;
		this.frmDeduccion = frmDeduccion;
		
	}
	
	
}
