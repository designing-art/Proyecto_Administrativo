package controles;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import clases.deduccion;
import consultas.cosultas_deduccion;
import formularios.registro_deducciones;

public class control_deduccion {
	
	public deduccion modDeduccion;
	public cosultas_deduccion modCDeduccion;
	public registro_deducciones frmDeduccion;
	
	
	public control_deduccion(deduccion modDeduccion, cosultas_deduccion modCDeduccion,
			registro_deducciones frmDeduccion) {
		super();
		this.modDeduccion = modDeduccion;
		this.modCDeduccion = modCDeduccion;
		this.frmDeduccion = frmDeduccion;
		
	}
	
	
}
