package controles.television;

import mantenimiento.television.consultas_empleado;
import clases.television.empleado;
import diseño.television.registro_mantenimiento_empleados;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class control_empleado implements ActionListener {

    private empleado mod;
    private consultas_empleado modC;
    private registro_mantenimiento_empleados frm;

    public control_empleado(empleado mod, consultas_empleado modC, registro_mantenimiento_empleados frm) {
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        this.frm.btnGuardar.addActionListener(this);
        this.frm.btnActualizar.addActionListener(this);
        this.frm.btnBorrar.addActionListener(this);
        this.frm.btnNuevo.addActionListener(this);
        this.frm.btnSalir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == frm.btnGuardar) {
            mod.setId_empleado(Integer.parseInt(frm.txtcodigo.getText()));
            mod.setNombres_empleado(frm.txtnombres.getText());
            mod.setApellidos_empleado(frm.txtapellidos.getText());
            mod.setIdentidad_empleado(frm.txtidentidad.getText());
            mod.setGenero_empleado(frm.txtgenero.getText());
            mod.setEdad_empleado(Integer.parseInt(frm.txtedad.getText()));
            mod.setTelefono1_empleado(frm.txttelefono1.getText());
            mod.setTelefono2_empleado(frm.txttelefono2.getText());
            mod.setCorreo_empleado(frm.txtcorreo.getText());
            mod.setDireccion_empleado(frm.txtdireccion.getText());
            mod.setReferencia_empleado(frm.txtnombrereferencia.getText());
            mod.setTelefono_referencia(frm.txttelefonoreferencia.getText());
            mod.setFecha_nacimiento_empleado(frm.txtfechanacimiento.getText());
            mod.setFecha_registro_empleado(frm.txtfecharegistro.getText());
            mod.setFecha_inicio_labores_empleado(frm.txtfechalabores.getText());
            mod.setEstado_empleado(frm.txtestado.getText());
            
            if(modC.registrar(mod))
            {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                limpiar();
            }
        }
        
        if (e.getSource() == frm.btnActualizar) {
            
            mod.setId_empleado(Integer.parseInt(frm.txtcodigo.getText()));
            mod.setNombres_empleado(frm.txtnombres.getText());
            mod.setApellidos_empleado(frm.txtapellidos.getText());
            mod.setIdentidad_empleado(frm.txtidentidad.getText());
            mod.setGenero_empleado(frm.txtgenero.getText());
            mod.setEdad_empleado(Integer.parseInt(frm.txtedad.getText()));
            mod.setTelefono1_empleado(frm.txttelefono1.getText());
            mod.setTelefono2_empleado(frm.txttelefono2.getText());
            mod.setCorreo_empleado(frm.txtcorreo.getText());
            mod.setDireccion_empleado(frm.txtdireccion.getText());
            mod.setReferencia_empleado(frm.txtnombrereferencia.getText());
            mod.setTelefono_referencia(frm.txttelefonoreferencia.getText());
            mod.setFecha_nacimiento_empleado(frm.txtfechanacimiento.getText());
            mod.setFecha_registro_empleado(frm.txtfecharegistro.getText());
            mod.setFecha_inicio_labores_empleado(frm.txtfechalabores.getText());
            mod.setEstado_empleado(frm.txtestado.getText());
            
            if(modC.modificar(mod))
            {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
            }
        }
        
        if (e.getSource() == frm.btnBorrar) {
            mod.setId_empleado(Integer.parseInt(frm.txtcodigo.getText()));
            
            if(modC.eliminar(mod))
            {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                limpiar();
            }
        }
        
        if (e.getSource() == frm.btnBuscar) {
            mod.setId_empleado(Integer.parseInt(frm.txtcodigo.getText()));
            
            if(modC.buscar(mod))
            {
            	
            	frm.txtcodigo.setText(String.valueOf(mod.getId_empleado()));
                frm.txtnombres.setText(mod.getNombres_empleado());
                frm.txtapellidos.setText(mod.getApellidos_empleado());
                frm.txtidentidad.setText(mod.getIdentidad_empleado());
                frm.txtgenero.setText(mod.getGenero_empleado());
                frm.txtedad.setText(String.valueOf(mod.getEdad_empleado()));
                frm.txttelefono1.setText(mod.getTelefono1_empleado());
                frm.txttelefono2.setText(mod.getTelefono2_empleado());
                frm.txtcorreo.setText(mod.getCorreo_empleado());
                frm.txtdireccion.setText(mod.getDireccion_empleado());
                frm.txtnombrereferencia.setText(mod.getReferencia_empleado());
                frm.txttelefonoreferencia.setText(mod.getTelefono_referencia());
                frm.txtfechanacimiento.setText(mod.getFecha_nacimiento_empleado());
                frm.txtfecharegistro.setText(mod.getFecha_registro_empleado());
                frm.txtfechalabores.setText(mod.getFecha_inicio_labores_empleado());
                frm.txtestado.setText(mod.getEstado_empleado());
                

            } else {
                JOptionPane.showMessageDialog(null, "No se encontro registro");
                limpiar();
            }
        }
        
        if (e.getSource() == frm.btnNuevo) {
            limpiar();
        }

    }
    
    public void limpiar()
    {
    	frm.txtcodigo.setText(null);
        frm.txtnombres.setText(null);
        frm.txtapellidos.setText(null);
        frm.txtidentidad.setText(null);
        frm.txtgenero.setText(null);
        frm.txtedad.setText(null);
        frm.txttelefono1.setText(null);
        frm.txttelefono2.setText(null);
        frm.txtcorreo.setText(null);
        frm.txtdireccion.setText(null);
        frm.txtnombrereferencia.setText(null);
        frm.txttelefonoreferencia.setText(null);
        frm.txtfechanacimiento.setText(null);
        frm.txtfecharegistro.setText(null);
        frm.txtfechalabores.setText(null);
        frm.txtestado.setText(null);
    }

}
