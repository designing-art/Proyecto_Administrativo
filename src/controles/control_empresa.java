package controles;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import clases.empresa;
import consultas.consultas_empresa;
import formularios.registro_empresa;

public class control_empresa implements ActionListener {

	public empresa clase;
	public consultas_empresa consulta;
	public registro_empresa formulario;

	public control_empresa(empresa clase, consultas_empresa consulta,
			registro_empresa formulario) {
		this.clase = clase;
		this.consulta = consulta;
		this.formulario = formulario;
		this.formulario.btnGuardarEmpresa.addActionListener(this);
		this.formulario.btnActualizarEmpresa.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/* Insertar */
		if (e.getSource() == formulario.btnGuardarEmpresa) {

			if (formulario.txtNombreEmpresa.getText().isEmpty()
					||formulario.txtDireccionEmpresa.getText().isEmpty()
					||formulario.txtTelefonoEmpresa.getText().isEmpty()
					||formulario.txtRTNempresa.getText().isEmpty()
					||formulario.txtDireccionLogoEmpresa.getText().isEmpty()
					||formulario.txtDireccionFotoEmpresa.getText().isEmpty()
					||formulario.txtCorreoEmpresa.getText().isEmpty()
					||formulario.txtCuentaEmpresa.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Porfavor llene los campos para guardar la informacion!");

			} else {

				clase.setNombre_empresa(formulario.txtNombreEmpresa.getText().toString());
				clase.setDireccion_empresa(formulario.txtDireccionEmpresa.getText().toString());
				clase.setTelefono_empresa(formulario.txtTelefonoEmpresa.getText().toString());
				clase.setRtn_empresa(formulario.txtRTNempresa.getText().toString());
				clase.setDireccion_logo_empresa(formulario.txtDireccionLogoEmpresa.getText().toString());
				clase.setDireccion_foto_empresa(formulario.txtDireccionFotoEmpresa.getText().toString());
				clase.setCorreo_empresa(formulario.txtCorreoEmpresa.getText().toString());
				clase.setCuenta_bancaria_empresa(formulario.txtCuentaEmpresa.getText().toString());
				
				if (consulta.insertar(clase)) {
					JOptionPane.showMessageDialog(null, "Exito! se guardo la informacion de la empresa!");
				} else {
					JOptionPane.showMessageDialog(null, "Error! datos no registrados");
				}
			}
		}

		/* Actualizar */
		if (e.getSource() == formulario.btnActualizarEmpresa) {

			if (formulario.txtNombreEmpresa.getText().isEmpty()
					||formulario.txtDireccionEmpresa.getText().isEmpty()
					||formulario.txtTelefonoEmpresa.getText().isEmpty()
					||formulario.txtRTNempresa.getText().isEmpty()
					||formulario.txtDireccionLogoEmpresa.getText().isEmpty()
					||formulario.txtDireccionFotoEmpresa.getText().isEmpty()
					||formulario.txtCorreoEmpresa.getText().isEmpty()
					||formulario.txtCuentaEmpresa.getText().isEmpty()) {
				
				JOptionPane.showMessageDialog(null, "Porfavor llene los campos para guardar la informacion.");

			} else {

				clase.setId_empresa(Integer.parseInt(formulario.txtCodigoEmpresa.getText()));
				clase.setNombre_empresa(formulario.txtNombreEmpresa.getText().toString());
				clase.setDireccion_empresa(formulario.txtDireccionEmpresa.getText().toString());
				clase.setTelefono_empresa(formulario.txtTelefonoEmpresa.getText().toString());
				clase.setRtn_empresa(formulario.txtRTNempresa.getText().toString());
				clase.setDireccion_logo_empresa(formulario.txtDireccionLogoEmpresa.getText().toString());
				clase.setDireccion_foto_empresa(formulario.txtDireccionFotoEmpresa.getText().toString());
				clase.setCorreo_empresa(formulario.txtCorreoEmpresa.getText().toString());
				clase.setCuenta_bancaria_empresa(formulario.txtCuentaEmpresa.getText().toString());
				clase.setId_empresa(Integer.parseInt(formulario.txtCodigoEmpresa.getText()));
				
				if (consulta.actualizar(clase)) {
					JOptionPane.showMessageDialog(null, "Exito! se actualizo la informacion de la empresa!");
				} else {
					JOptionPane.showMessageDialog(null, "Error! datos no registrados");
				}

			}
		}
	}
}


