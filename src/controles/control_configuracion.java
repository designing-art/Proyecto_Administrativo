package controles;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import clases.configuracion;
import consultas.consultas_configuracion;
import formularios.registro_configuracion;
import formularios.ventana_principal;

public class control_configuracion implements ActionListener {

	public configuracion clase;
	public consultas_configuracion consulta;
	public registro_configuracion formulario;
	public ventana_principal formulario2 = new ventana_principal();

	public control_configuracion(configuracion clase, consultas_configuracion consulta,
			registro_configuracion formulario) {
		this.clase = clase;
		this.consulta = consulta;
		this.formulario = formulario;
		this.formulario = formulario;
		this.formulario.btnGuardar.addActionListener(this);
		this.formulario.btnActualizar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == formulario.btnGuardar) {

			if (formulario.rdbtnActivar.isSelected()) {
				clase.setSonido_configuracion(formulario.rdbtnActivar.getText().toString());
			} else {
				clase.setSonido_configuracion(formulario.rdbtnDesactvar.getText().toString());
			}

			if (formulario.rdbtnClaro.isSelected()) {
				clase.setTema_configuracion(formulario.rdbtnClaro.getText().toString());
			} else {
				if (formulario.rdbtnObscuro.isSelected()) {
					clase.setTema_configuracion(formulario.rdbtnObscuro.getText().toString());
				} else {
					if (formulario.rdbtnAzul.isSelected()) {
						clase.setTema_configuracion(formulario.rdbtnAzul.getText().toString());
					} else {
						clase.setTema_configuracion(formulario.rdbtnVerdoso.getText().toString());
					}
				}
			}
			
			clase.setFrase_configuracion(registro_configuracion.txtFrase.getText().toString());

			if (consulta.insertar(clase)) {
				JOptionPane.showMessageDialog(null, "Exito! Configuracion guardada!");
				formulario.dispose();

			} else {
				JOptionPane.showMessageDialog(null, "Error! datos no registrados");
			}
		}
	
	if (e.getSource() == formulario.btnActualizar) {
		
		clase.setId_configuracion(Integer.parseInt(formulario.txtCodigo.getText().toString()));

		if (formulario.rdbtnActivar.isSelected()) {
			clase.setSonido_configuracion(formulario.rdbtnActivar.getText().toString());
		} else {
			clase.setSonido_configuracion(formulario.rdbtnDesactvar.getText().toString());
		}

		if (formulario.rdbtnClaro.isSelected()) {
			clase.setTema_configuracion(formulario.rdbtnClaro.getText().toString());
		} else {
			if (formulario.rdbtnObscuro.isSelected()) {
				clase.setTema_configuracion(formulario.rdbtnObscuro.getText().toString());
			} else {
				if (formulario.rdbtnAzul.isSelected()) {
					clase.setTema_configuracion(formulario.rdbtnAzul.getText().toString());
				} else {
					clase.setTema_configuracion(formulario.rdbtnVerdoso.getText().toString());
				}
			}
		}
		
		clase.setFrase_configuracion(registro_configuracion.txtFrase.getText().toString());
		
		if (consulta.actualizar(clase)) {
			JOptionPane.showMessageDialog(null, "Exito Configuracion guardada!");
			formulario.dispose();

		} else {
			JOptionPane.showMessageDialog(null, "Error! datos no actualizados");
		}
	}
}

}
