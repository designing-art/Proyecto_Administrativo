package controles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JOptionPane;

import clases.empleado;
import consultas.consultas_empleado;
import formularios.registro_empleados;

public class control_empleado implements ActionListener {

    private empleado claseEmpleado;
    private consultas_empleado consultaEmpleado;
    private registro_empleados formularioEmpleado;

    public control_empleado(empleado modEmpleado, consultas_empleado modCempleado, registro_empleados frmEmpleado) {
        this.claseEmpleado = modEmpleado;
        this.consultaEmpleado = modCempleado;
        this.formularioEmpleado = frmEmpleado;
        this.formularioEmpleado.btnGuardarEmpleado.addActionListener(this);
        this.formularioEmpleado.btnActualizarEmpleado.addActionListener(this);
        this.formularioEmpleado.btnNuevoEmpleado.addActionListener(this);
        this.formularioEmpleado.btnCancelarEmpleado.addActionListener(this);
        this.formularioEmpleado.btnEmpleados.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == formularioEmpleado.btnGuardarEmpleado) {
            claseEmpleado.setNombres_empleado(formularioEmpleado.txtNombresEmpleado.getText());
            claseEmpleado.setApellidos_empleado(formularioEmpleado.txtApellidosEmpleado.getText());
            claseEmpleado.setIdentidad_empleado(formularioEmpleado.txtIdentidadEmpleado.getText());
            claseEmpleado.setGenero_empleado(formularioEmpleado.cbxGeneroEmpleado.getSelectedItem().toString());
            claseEmpleado.setEdad_empleado(Integer.parseInt(formularioEmpleado.txtEdadEmpleado.getText()));
            claseEmpleado.setTelefono_empleado(formularioEmpleado.txtTelefonoEmpleado.getText());
            claseEmpleado.setCorreo_empleado(formularioEmpleado.txtCorreoEmpleado.getText());
            claseEmpleado.setDireccion_empleado(formularioEmpleado.txtDireccionEmpleado.getText());
            claseEmpleado.setReferencia_empleado(formularioEmpleado.txtNombreReferencia.getText());
            claseEmpleado.setTelefono_referencia(formularioEmpleado.txtTelefonoReferencia.getText());
            claseEmpleado.setFecha_nacimiento_empleado(Date.valueOf(formularioEmpleado.dateFechaNacimiento.getToolTipText()));
            claseEmpleado.setFecha_registro_empleado((Date)formularioEmpleado.dateFechaRegistro.getDate());
            claseEmpleado.setFecha_inicio_labores_empleado((Date)formularioEmpleado.dateFechaLabores.getDate());
            claseEmpleado.setEstado_empleado(formularioEmpleado.cbxEstadoEmpleado.getSelectedItem().toString());
            
            if(consultaEmpleado.registrar(claseEmpleado))
            {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                limpiar();
            }
        }
        
        if (e.getSource() == formularioEmpleado.btnActualizarEmpleado) {
            
        	  claseEmpleado.setId_empleado(Integer.parseInt(formularioEmpleado.txtCodigoEmpleado.getText()));
              claseEmpleado.setNombres_empleado(formularioEmpleado.txtNombresEmpleado.getText());
              claseEmpleado.setApellidos_empleado(formularioEmpleado.txtApellidosEmpleado.getText());
              claseEmpleado.setIdentidad_empleado(formularioEmpleado.txtIdentidadEmpleado.getText());
              claseEmpleado.setGenero_empleado(formularioEmpleado.cbxGeneroEmpleado.getSelectedItem().toString());
              claseEmpleado.setEdad_empleado(Integer.parseInt(formularioEmpleado.txtEdadEmpleado.getText()));
              claseEmpleado.setTelefono_empleado(formularioEmpleado.txtTelefonoEmpleado.getText());
              claseEmpleado.setCorreo_empleado(formularioEmpleado.txtCorreoEmpleado.getText());
              claseEmpleado.setDireccion_empleado(formularioEmpleado.txtDireccionEmpleado.getText());
              claseEmpleado.setReferencia_empleado(formularioEmpleado.txtNombreReferencia.getText());
              claseEmpleado.setTelefono_referencia(formularioEmpleado.txtTelefonoReferencia.getText());
              claseEmpleado.setFecha_nacimiento_empleado((Date) formularioEmpleado.dateFechaNacimiento.getDate());
              claseEmpleado.setFecha_registro_empleado((Date)formularioEmpleado.dateFechaRegistro.getDate());
              claseEmpleado.setFecha_inicio_labores_empleado((Date)formularioEmpleado.dateFechaLabores.getDate());
              claseEmpleado.setEstado_empleado(formularioEmpleado.cbxEstadoEmpleado.getSelectedItem().toString());
             
            if(consultaEmpleado.modificar(claseEmpleado))
            {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
            }
        }
        
        
        
        if (e.getSource() == formularioEmpleado.btnNuevoEmpleado) {
            limpiar();
        }

    }
    
    public void limpiar()
    {
    	formularioEmpleado.txtCodigoEmpleado.setText(null);
        formularioEmpleado.txtNombresEmpleado.setText(null);
        formularioEmpleado.txtApellidosEmpleado.setText(null);
        formularioEmpleado.txtIdentidadEmpleado.setText(null);
        formularioEmpleado.cbxGeneroEmpleado.setDefaultLocale(null);
        formularioEmpleado.txtEdadEmpleado.setText(null);
        formularioEmpleado.txtTelefonoEmpleado.setText(null);
        formularioEmpleado.txtCorreoEmpleado.setText(null);
        formularioEmpleado.txtDireccionEmpleado.setText(null);
        formularioEmpleado.txtNombreReferencia.setText(null);
        formularioEmpleado.txtTelefonoReferencia.setText(null);
        formularioEmpleado.dateFechaLabores.setToolTipText(null);
        formularioEmpleado.dateFechaNacimiento.setToolTipText(null);
        formularioEmpleado.dateFechaRegistro.setToolTipText(null);
        formularioEmpleado.cbxEstadoEmpleado.setToolTipText(null);
    }

	

}
