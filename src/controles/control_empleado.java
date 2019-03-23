package controles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import clases.empleado;
import consultas.consultas_empleado;
import formularios.registro_empleados;

public class control_empleado implements ActionListener {

    private empleado modEmpleado;
    private consultas_empleado modCEmpleado;
    private registro_empleados frmEmpleado;

    public control_empleado(empleado modEmpleado, consultas_empleado modCempleado, registro_empleados frmEmpleado) {
        this.modEmpleado = modEmpleado;
        this.modCEmpleado = modCempleado;
        this.frmEmpleado = frmEmpleado;
        this.frmEmpleado.btnGuardar.addActionListener(this);
        this.frmEmpleado.btnActualizar.addActionListener(this);
        this.frmEmpleado.btnBorrar.addActionListener(this);
        this.frmEmpleado.btnNuevo.addActionListener(this);
        this.frmEmpleado.btnSalir.addActionListener(this);
    }
    
    public void iniciar() {
        frmEmpleado.setTitle("Registro de empleados");
        frmEmpleado.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == frmEmpleado.btnGuardar) {
            modEmpleado.setId_empleado(Integer.parseInt(frmEmpleado.txtcodigo.getText()));
            modEmpleado.setNombres_empleado(frmEmpleado.txtnombres.getText());
            modEmpleado.setApellidos_empleado(frmEmpleado.txtapellidos.getText());
            modEmpleado.setIdentidad_empleado(frmEmpleado.txtidentidad.getText());
            modEmpleado.setGenero_empleado(frmEmpleado.txtgenero.getText());
            modEmpleado.setEdad_empleado(Integer.parseInt(frmEmpleado.txtedad.getText()));
            modEmpleado.setTelefono1_empleado(frmEmpleado.txttelefono1.getText());
            modEmpleado.setTelefono2_empleado(frmEmpleado.txttelefono2.getText());
            modEmpleado.setCorreo_empleado(frmEmpleado.txtcorreo.getText());
            modEmpleado.setDireccion_empleado(frmEmpleado.txtdireccion.getText());
            modEmpleado.setReferencia_empleado(frmEmpleado.txtnombrereferencia.getText());
            modEmpleado.setTelefono_referencia(frmEmpleado.txttelefonoreferencia.getText());
            modEmpleado.setFecha_nacimiento_empleado(frmEmpleado.txtfechanacimiento.getText());
            modEmpleado.setFecha_registro_empleado(frmEmpleado.txtfecharegistro.getText());
            modEmpleado.setFecha_inicio_labores_empleado(frmEmpleado.txtfechalabores.getText());
            modEmpleado.setEstado_empleado(frmEmpleado.txtestado.getText());
            
            if(modCEmpleado.registrar(modEmpleado))
            {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                limpiar();
            }
        }
        
        if (e.getSource() == frmEmpleado.btnActualizar) {
            
            modEmpleado.setId_empleado(Integer.parseInt(frmEmpleado.txtcodigo.getText()));
            modEmpleado.setNombres_empleado(frmEmpleado.txtnombres.getText());
            modEmpleado.setApellidos_empleado(frmEmpleado.txtapellidos.getText());
            modEmpleado.setIdentidad_empleado(frmEmpleado.txtidentidad.getText());
            modEmpleado.setGenero_empleado(frmEmpleado.txtgenero.getText());
            modEmpleado.setEdad_empleado(Integer.parseInt(frmEmpleado.txtedad.getText()));
            modEmpleado.setTelefono1_empleado(frmEmpleado.txttelefono1.getText());
            modEmpleado.setTelefono2_empleado(frmEmpleado.txttelefono2.getText());
            modEmpleado.setCorreo_empleado(frmEmpleado.txtcorreo.getText());
            modEmpleado.setDireccion_empleado(frmEmpleado.txtdireccion.getText());
            modEmpleado.setReferencia_empleado(frmEmpleado.txtnombrereferencia.getText());
            modEmpleado.setTelefono_referencia(frmEmpleado.txttelefonoreferencia.getText());
            modEmpleado.setFecha_nacimiento_empleado(frmEmpleado.txtfechanacimiento.getText());
            modEmpleado.setFecha_registro_empleado(frmEmpleado.txtfecharegistro.getText());
            modEmpleado.setFecha_inicio_labores_empleado(frmEmpleado.txtfechalabores.getText());
            modEmpleado.setEstado_empleado(frmEmpleado.txtestado.getText());
            
            if(modCEmpleado.modificar(modEmpleado))
            {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
            }
        }
        
        if (e.getSource() == frmEmpleado.btnBorrar) {
            modEmpleado.setId_empleado(Integer.parseInt(frmEmpleado.txtcodigo.getText()));
            
            if(modCEmpleado.eliminar(modEmpleado))
            {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                limpiar();
            }
        }
        
        if (e.getSource() == frmEmpleado.btnBuscar) {
            modEmpleado.setId_empleado(Integer.parseInt(frmEmpleado.txtcodigo.getText()));
            
            if(modCEmpleado.buscar(modEmpleado))
            {
            	
            	frmEmpleado.txtcodigo.setText(String.valueOf(modEmpleado.getId_empleado()));
                frmEmpleado.txtnombres.setText(modEmpleado.getNombres_empleado());
                frmEmpleado.txtapellidos.setText(modEmpleado.getApellidos_empleado());
                frmEmpleado.txtidentidad.setText(modEmpleado.getIdentidad_empleado());
                frmEmpleado.txtgenero.setText(modEmpleado.getGenero_empleado());
                frmEmpleado.txtedad.setText(String.valueOf(modEmpleado.getEdad_empleado()));
                frmEmpleado.txttelefono1.setText(modEmpleado.getTelefono1_empleado());
                frmEmpleado.txttelefono2.setText(modEmpleado.getTelefono2_empleado());
                frmEmpleado.txtcorreo.setText(modEmpleado.getCorreo_empleado());
                frmEmpleado.txtdireccion.setText(modEmpleado.getDireccion_empleado());
                frmEmpleado.txtnombrereferencia.setText(modEmpleado.getReferencia_empleado());
                frmEmpleado.txttelefonoreferencia.setText(modEmpleado.getTelefono_referencia());
                frmEmpleado.txtfechanacimiento.setText(modEmpleado.getFecha_nacimiento_empleado());
                frmEmpleado.txtfecharegistro.setText(modEmpleado.getFecha_registro_empleado());
                frmEmpleado.txtfechalabores.setText(modEmpleado.getFecha_inicio_labores_empleado());
                frmEmpleado.txtestado.setText(modEmpleado.getEstado_empleado());
                

            } else {
                JOptionPane.showMessageDialog(null, "No se encontro registro");
                limpiar();
            }
        }
        
        if (e.getSource() == frmEmpleado.btnNuevo) {
            limpiar();
        }

    }
    
    public void limpiar()
    {
    	frmEmpleado.txtcodigo.setText(null);
        frmEmpleado.txtnombres.setText(null);
        frmEmpleado.txtapellidos.setText(null);
        frmEmpleado.txtidentidad.setText(null);
        frmEmpleado.txtgenero.setText(null);
        frmEmpleado.txtedad.setText(null);
        frmEmpleado.txttelefono1.setText(null);
        frmEmpleado.txttelefono2.setText(null);
        frmEmpleado.txtcorreo.setText(null);
        frmEmpleado.txtdireccion.setText(null);
        frmEmpleado.txtnombrereferencia.setText(null);
        frmEmpleado.txttelefonoreferencia.setText(null);
        frmEmpleado.txtfechanacimiento.setText(null);
        frmEmpleado.txtfecharegistro.setText(null);
        frmEmpleado.txtfechalabores.setText(null);
        frmEmpleado.txtestado.setText(null);
    }

	

}
