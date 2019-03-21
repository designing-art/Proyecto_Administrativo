package controles.television;

import mantenimiento.television.consultas_bonificacion;
import clases.television.bonificacion;

import diseño.television.registro_mantenimiento_bonificaciones;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class control_bonificacion implements ActionListener {
	
	public bonificacion modBonificacion;
    public consultas_bonificacion modCBonificacion;
    public registro_mantenimiento_bonificaciones frmBonificaciones;

    public control_bonificacion(bonificacion modBonificacion, consultas_bonificacion modCBonificacion, registro_mantenimiento_bonificaciones frmBonificaciones) {
        this.modBonificacion = modBonificacion;
        this.modCBonificacion = modCBonificacion;
        this.frmBonificaciones = frmBonificaciones;
        this.frmBonificaciones.btnGuardarBonificacion.addActionListener(this);
        this.frmBonificaciones.btnActualizarBonificacion.addActionListener(this);
        this.frmBonificaciones.btnSalirBonificacion.addActionListener(this);
        this.frmBonificaciones.btnNuevaBonificacion.addActionListener(this);
        
        
    }


	public void iniciar() {
        frmBonificaciones.setTitle("Registro de Bonificaciones");
        frmBonificaciones.setVisible(true);
        frmBonificaciones.setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == frmBonificaciones.btnGuardarBonificacion) {
        	modBonificacion.setId_bonificacion(Integer.parseInt(frmBonificaciones.txtCodigoBonificacion.getText()));
            modBonificacion.setIdentidad_bonificacion(frmBonificaciones.txtidentidadbonificacion.getText());
            modBonificacion.setNombres_bonificacion(frmBonificaciones.txtnombresBonificacion.getText());
            modBonificacion.setApellidos_bonificacion(frmBonificaciones.txtapellidosbonificacion.getText());
            modBonificacion.setObservacion_bonificacion(frmBonificaciones.txtobservacionbonificacion.getText());
            modBonificacion.setCantidad_bonificacion(frmBonificaciones.txtcantidadbonificacion.getText());
            modBonificacion.setTotal_bonificacion(frmBonificaciones.txtTotalBonificacion.getText());
            modBonificacion.setTipo_bonificacion(frmBonificaciones.txttipobonificacion.getText());
            
            if(modCBonificacion.registrar(modBonificacion))
            {
                JOptionPane.showMessageDialog(null, "Exito! Horario Registrado.");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Lo sentimos, Horario no registrado, Verifique los datos del horario, he intentelo de nuevo.");
                limpiar();
            }
        }
        
        if (e.getSource() == frmBonificaciones.btnActualizarBonificacion) {
        	 modBonificacion.setId_bonificacion(Integer.parseInt(frmBonificaciones.txtCodigoBonificacion.getText()));
             modBonificacion.setIdentidad_bonificacion(frmBonificaciones.txtidentidadbonificacion.getText());
             modBonificacion.setNombres_bonificacion(frmBonificaciones.txtnombresBonificacion.getText());
             modBonificacion.setApellidos_bonificacion(frmBonificaciones.txtapellidosbonificacion.getText());
             modBonificacion.setObservacion_bonificacion(frmBonificaciones.txtobservacionbonificacion.getText());
             modBonificacion.setCantidad_bonificacion(frmBonificaciones.txtcantidadbonificacion.getText());
             modBonificacion.setTotal_bonificacion(frmBonificaciones.txtTotalBonificacion.getText());
             modBonificacion.setTipo_bonificacion(frmBonificaciones.txttipobonificacion.getText());
             
            if(modCBonificacion.modificar(modBonificacion))
            {
                JOptionPane.showMessageDialog(null, "Exito! Bonificacion Registrado.");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Lo sentimos, Bonificacion no registrado, Verifique los datos del empleado, he intentelo de nuevo.");
                limpiar();
            }
        }
        
        if (e.getSource() == frmBonificaciones.btnSalirBonificacion) {
            modBonificacion.setId_bonificacion(Integer.parseInt(frmBonificaciones.txtCodigoBonificacion.getText()));
            
            if(modCBonificacion.eliminar(modBonificacion))
            {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                limpiar();
            }
        } 
        
        if (e.getSource() == frmBonificaciones.btnNuevaBonificacion) {
            limpiar();
        }

    }
    
    public void limpiar()
    {
    	frmBonificaciones.txtCodigoBonificacion.setText(null);
        frmBonificaciones.txtnombresBonificacion.setText(null);
        frmBonificaciones.txtapellidosbonificacion.setText(null);
        frmBonificaciones.txtidentidadbonificacion.setText(null);
        frmBonificaciones.txtcantidadbonificacion.setText(null);
        frmBonificaciones.txtobservacionbonificacion.setText(null);
        frmBonificaciones.txttipobonificacion.setText(null);
        frmBonificaciones.txtTotalBonificacion.setText(null);

    }

	

}




