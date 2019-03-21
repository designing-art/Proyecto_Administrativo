package controles.television;

import mantenimiento.television.consultas_horario;
import clases.television.horario;
import clases.television.horario;
import diseño.television.registro_mantenimiento_horarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class control_horario implements ActionListener {

    public horario modHorario;
    public consultas_horario modCHorario;
    public registro_mantenimiento_horarios frmHorario;

    public control_horario(horario modHorario, consultas_horario modCHorario, registro_mantenimiento_horarios frmHorario) {
        this.modHorario = modHorario;
        this.modCHorario = modCHorario;
        this.frmHorario = frmHorario;
        this.frmHorario.btnGuardarHorario.addActionListener(this);
        this.frmHorario.btnActualizarHorario.addActionListener(this);
        this.frmHorario.btnSalirHorario.addActionListener(this);
        this.frmHorario.btnNuevoHorario.addActionListener(this);
    }


	public void iniciar() {
        frmHorario.setTitle("Registro de horarios");
        frmHorario.setVisible(true);
        frmHorario.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == frmHorario.btnGuardarHorario) {
            modHorario.setId_horario(Integer.parseInt(frmHorario.txtidhorario.getText()));
            modHorario.setHora_inicio_horario(frmHorario.txthorainicio_horario.getText());
            modHorario.setHora_final_horario(frmHorario.txthorafinal_horario.getText());
            modHorario.setDias_horario(frmHorario.txtdias_horario.getText());
            modHorario.setDescripcion_horario(frmHorario.txtdescripciohorario.getText());
            modHorario.setObservacion_horario(frmHorario.txtobservacionhorario.getText());
            
            if(modCHorario.registrar(modHorario))
            {
                JOptionPane.showMessageDialog(null, "Exito! Horario Registrado.");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Lo sentimos, Horario no registrado, Verifique los datos del horario, he intentelo de nuevo.");
                limpiar();
            }
        }
        
        if (e.getSource() == frmHorario.btnActualizarHorario) {
            modHorario.setId_horario(Integer.parseInt(frmHorario.txtidhorario.getText()));
            modHorario.setHora_inicio_horario(frmHorario.txthorainicio_horario.getText());
            modHorario.setHora_final_horario(frmHorario.txthorafinal_horario.getText());
            modHorario.setDias_horario(frmHorario.txtdias_horario.getText());
            modHorario.setDescripcion_horario(frmHorario.txtdescripciohorario.getText());
            modHorario.setObservacion_horario(frmHorario.txtobservacionhorario.getText());
            
            if(modCHorario.registrar(modHorario))
            {
                JOptionPane.showMessageDialog(null, "Exito! Horario Registrado.");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Lo sentimos, Horario no registrado, Verifique los datos del horario, he intentelo de nuevo.");
                limpiar();
            }
        }
        
        if (e.getSource() == frmHorario.btnSalirHorario) {
            modHorario.setId_horario(Integer.parseInt(frmHorario.txtidhorario.getText()));
            
            if(modCHorario.eliminar(modHorario))
            {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                limpiar();
            }
        } 
        
        if (e.getSource() == frmHorario.btnNuevoHorario) {
            limpiar();
        }

    }
    
    public void limpiar()
    {
    	frmHorario.txtidhorario.setText(null);
        frmHorario.txthorainicio_horario.setText(null);
        frmHorario.txthorafinal_horario.setText(null);
        frmHorario.txtdias_horario.setText(null);
        frmHorario.txtdescripciohorario.setText(null);
        frmHorario.txtobservacionhorario.setText(null);

    }

	

}

