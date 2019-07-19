package controles;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import clases.factura_cliente;
import clases.sar;
import conexion.conexion;
import consultas.consultas_factura_cliente;
import consultas.consultas_sar;
import formularios.registro_facturas_clientes;
import formularios.registro_sar;

public class control_factura_cliente implements ActionListener {

	public factura_cliente clase;
	public consultas_factura_cliente consulta;
	public registro_facturas_clientes formulario;
	public sar clase2;
	public consultas_sar consulta2;
	public registro_sar formulario2;

	public static String identidad = null;
	public static int cantidad = 0;
	public static int existencia = 0;

	public control_factura_cliente(factura_cliente clase, consultas_factura_cliente consulta,
			registro_facturas_clientes formulario, sar clase2) {
		this.clase = clase;
		this.consulta = consulta;
		this.formulario = formulario;
		this.clase2 = clase2;
		this.formulario.btnGuardar.addActionListener(this);
		this.formulario.btnNuevo.addActionListener(this);
		this.formulario.btnActualizar.addActionListener(this);
		this.formulario.btnActualizarDatos.addActionListener(this);
		this.formulario.btnBorrar.addActionListener(this);
		this.formulario.btnVer.addActionListener(this);
		this.formulario.btnAceptar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == formulario.btnGuardar) {
			if (registro_facturas_clientes.txtFechaHoraFactura.getText().isEmpty()
					|| formulario.txtPorConceptoDe.getText().isEmpty()
					|| formulario.txtNumeroFactura.getText().isEmpty()
					|| formulario.txtCantidadLetras.getText().isEmpty() || formulario.txtCliente.getText().isEmpty()
					|| formulario.txtCantidadNumeros.getText().isEmpty() || formulario.txtDireccion.getText().isEmpty()
					|| formulario.txtEmpleado.getText().isEmpty() || formulario.txtRTN.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Porfavor llene los campos para guardar la factura!");
			} else {
				formulario.sumarFactura();
				clase.setNumero_factura_cliente(formulario.txtNumeroFactura.getText().toString());
				clase.setFecha_hora_factura_cliente(
						registro_facturas_clientes.txtFechaHoraFactura.getText().toString());
				clase.setFirma_cliente(formulario.txtCliente.getText().toString());
				clase.setRtn_factura_cliente(formulario.txtRTN.getText().toString());
				clase.setDireccion_cliente(formulario.txtDireccion.getText().toString());
				clase.setPor_concepto_cliente(formulario.txtPorConceptoDe.getText().toString());
				clase.setCantidad_letras_cliente(formulario.txtCantidadLetras.getText().toString());
				clase.setCantidad_pagada_cliente(
						Double.parseDouble(formulario.txtCantidadNumeros.getText().toString()));
				clase.setEmpleado_atencion_cliente(formulario.txtEmpleado.getText().toString());

				clase2.setId_sar(Integer.parseInt(formulario.txtCodigoSAR.getText().toString()));
				clase2.setFactura_actual_sar(Integer.parseInt(formulario.txtNuevaFactura.getText().toString()));

				if (consulta.insertar(clase) && consulta.actualizarDatosSAR(clase2)) {
					JOptionPane.showMessageDialog(null, "Factura registrada!");
					limpiar();
					formulario.obtenerUltimoId();
					formulario.pistas();
					formulario.consultarEmpresa();
					formulario.construirTabla();
					formulario.establecerDatosEmpresa();
					formulario.ObtenerUltimosDatosSar();
					registro_facturas_clientes.txtFechaHoraFactura.setText(registro_facturas_clientes.getFechaYHora());
				} else {
					JOptionPane.showMessageDialog(null, "Error! objeto no registrado");
					limpiar();
				}

			}
		}

		if (e.getSource() == formulario.btnActualizar) {
			if (registro_facturas_clientes.txtFechaHoraFactura.getText().isEmpty()
					|| formulario.txtPorConceptoDe.getText().isEmpty()
					|| formulario.txtNumeroFactura.getText().isEmpty()
					|| formulario.txtCantidadLetras.getText().isEmpty() || formulario.txtCliente.getText().isEmpty()
					|| formulario.txtCantidadNumeros.getText().isEmpty() || formulario.txtDireccion.getText().isEmpty()
					|| formulario.txtEmpleado.getText().isEmpty() || formulario.txtRTN.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Porfavor llene los campos para actualizar la factura!");
			} else {
				clase.setId_facturas_cliente(Integer.parseInt(formulario.txtCodigo.getText().toString()));
				clase.setNumero_factura_cliente(formulario.txtNumeroFactura.getText().toString());
				clase.setFecha_hora_factura_cliente(
						registro_facturas_clientes.txtFechaHoraFactura.getText().toString());
				clase.setFirma_cliente(formulario.txtCliente.getText().toString());
				clase.setRtn_factura_cliente(formulario.txtRTN.getText().toString());
				clase.setDireccion_cliente(formulario.txtDireccion.getText().toString());
				clase.setPor_concepto_cliente(formulario.txtPorConceptoDe.getText().toString());
				clase.setCantidad_letras_cliente(formulario.txtCantidadLetras.getText().toString());
				clase.setCantidad_pagada_cliente(
						Double.parseDouble(formulario.txtCantidadNumeros.getText().toString()));
				clase.setEmpleado_atencion_cliente(formulario.txtEmpleado.getText().toString());
				if (consulta.actualizar(clase)) {
					JOptionPane.showMessageDialog(null, "Factura Actualizada!");
					limpiar();
					formulario.obtenerUltimoId();
					formulario.pistas();
					formulario.consultarEmpresa();
					formulario.construirTabla();
					formulario.establecerDatosEmpresa();
					formulario.ObtenerUltimosDatosSar();
					registro_facturas_clientes.txtFechaHoraFactura.setText(registro_facturas_clientes.getFechaYHora());
				} else {
					JOptionPane.showMessageDialog(null, "Error! objeto no registrado");
					limpiar();
				}
			}
		}

		if (e.getSource() == formulario.btnActualizarDatos) {
			int filaseleccionada;
			try {
				filaseleccionada = formulario.tabla.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					String codigo = formulario.tabla.getValueAt(filaseleccionada, 0).toString();
					String factura = formulario.tabla.getValueAt(filaseleccionada, 1).toString();
					String fecha = formulario.tabla.getValueAt(filaseleccionada, 2).toString();
					String firma = formulario.tabla.getValueAt(filaseleccionada, 3).toString();
					String rtn = formulario.tabla.getValueAt(filaseleccionada, 4).toString();
					String direccion = formulario.tabla.getValueAt(filaseleccionada, 5).toString();
					String concepto = formulario.tabla.getValueAt(filaseleccionada, 6).toString();
					String letras = formulario.tabla.getValueAt(filaseleccionada, 7).toString();
					String numeros = formulario.tabla.getValueAt(filaseleccionada, 8).toString();
					String empleado = formulario.tabla.getValueAt(filaseleccionada, 9).toString();

					formulario.txtCodigo.setText(codigo);
					formulario.txtNumeroFactura.setText(factura);
					registro_facturas_clientes.txtFechaHoraFactura.setText(fecha);
					formulario.txtCliente.setText(firma);
					formulario.txtRTN.setText(rtn);
					formulario.txtDireccion.setText(direccion);
					formulario.txtPorConceptoDe.setText(concepto);
					formulario.txtCantidadLetras.setText(letras);
					formulario.txtCantidadNumeros.setText(numeros);
					formulario.txtEmpleado.setText(empleado);

					formulario.txtCodigo.setForeground(Color.BLACK);
					formulario.txtNumeroFactura.setForeground(Color.BLACK);
					registro_facturas_clientes.txtFechaHoraFactura.setForeground(Color.BLACK);
					formulario.txtCliente.setForeground(Color.BLACK);
					formulario.txtRTN.setForeground(Color.BLACK);
					formulario.txtDireccion.setForeground(Color.BLACK);
					formulario.txtPorConceptoDe.setForeground(Color.BLACK);
					formulario.txtCantidadLetras.setForeground(Color.BLACK);
					formulario.txtCantidadNumeros.setForeground(Color.BLACK);
					formulario.txtEmpleado.setForeground(Color.BLACK);

					formulario.btnBorrar.setVisible(true);
					formulario.btnGuardar.setVisible(false);
					formulario.btnNuevo.setVisible(false);
					formulario.btnActualizar.setVisible(true);
					formulario.btnActualizarDatos.setVisible(true);
					formulario.btnVer.setVisible(false);
					formulario.btnAceptar.setText("Cancelar");
					formulario.btnAceptar.setVisible(true);

					formulario.txtCliente.requestFocusInWindow();

				}

			} catch (HeadlessException ex) {
				JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente",
						" .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);
			}
		}

		if (e.getSource() == formulario.btnVer) {
			int filaseleccionada;
			try {
				filaseleccionada = formulario.tabla.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					String codigo = formulario.tabla.getValueAt(filaseleccionada, 0).toString();
					String factura = formulario.tabla.getValueAt(filaseleccionada, 1).toString();
					String fecha = formulario.tabla.getValueAt(filaseleccionada, 2).toString();
					String firma = formulario.tabla.getValueAt(filaseleccionada, 3).toString();
					String rtn = formulario.tabla.getValueAt(filaseleccionada, 4).toString();
					String direccion = formulario.tabla.getValueAt(filaseleccionada, 5).toString();
					String concepto = formulario.tabla.getValueAt(filaseleccionada, 6).toString();
					String letras = formulario.tabla.getValueAt(filaseleccionada, 7).toString();
					String numeros = formulario.tabla.getValueAt(filaseleccionada, 8).toString();
					String empleado = formulario.tabla.getValueAt(filaseleccionada, 9).toString();

					formulario.txtCodigo.setText(codigo);
					formulario.txtNumeroFactura.setText(factura);
					registro_facturas_clientes.txtFechaHoraFactura.setText(fecha);
					formulario.txtCliente.setText(firma);
					formulario.txtRTN.setText(rtn);
					formulario.txtDireccion.setText(direccion);
					formulario.txtPorConceptoDe.setText(concepto);
					formulario.txtCantidadLetras.setText(letras);
					formulario.txtCantidadNumeros.setText(numeros);
					formulario.txtEmpleado.setText(empleado);

					formulario.txtCodigo.setForeground(Color.BLACK);
					formulario.txtNumeroFactura.setForeground(Color.BLACK);
					registro_facturas_clientes.txtFechaHoraFactura.setForeground(Color.BLACK);
					formulario.txtCliente.setForeground(Color.BLACK);
					formulario.txtRTN.setForeground(Color.BLACK);
					formulario.txtDireccion.setForeground(Color.BLACK);
					formulario.txtPorConceptoDe.setForeground(Color.BLACK);
					formulario.txtCantidadLetras.setForeground(Color.BLACK);
					formulario.txtCantidadNumeros.setForeground(Color.BLACK);
					formulario.txtEmpleado.setForeground(Color.BLACK);

					formulario.txtCodigo.setEditable(false);
					formulario.txtNumeroFactura.setEditable(false);
					registro_facturas_clientes.txtFechaHoraFactura.setEditable(false);
					formulario.txtCliente.setEditable(false);
					formulario.txtRTN.setEditable(false);
					formulario.txtDireccion.setEditable(false);
					formulario.txtPorConceptoDe.setEditable(false);
					formulario.txtCantidadLetras.setEditable(false);
					formulario.txtCantidadNumeros.setEditable(false);
					formulario.txtEmpleado.setEditable(false);

					formulario.btnBorrar.setVisible(false);
					formulario.btnGuardar.setVisible(false);
					formulario.btnNuevo.setVisible(false);
					formulario.btnActualizar.setVisible(false);
					formulario.btnActualizarDatos.setVisible(false);
					formulario.btnAceptar.setText("Aceptar");
					formulario.btnAceptar.setVisible(true);

				}

			} catch (HeadlessException ex) {
				JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente",
						" .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);
			}
		}

		if (e.getSource() == formulario.btnBorrar) {
			PreparedStatement ps = null;
			int filaseleccionada;
			try {
				filaseleccionada = formulario.tabla.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					conexion objCon = new conexion();
					Connection conn = objCon.getConexion();
					int Fila = formulario.tabla.getSelectedRow();
					String codigo = formulario.tabla.getValueAt(Fila, 0).toString();
					ps = conn.prepareStatement("DELETE FROM facturas_clientes WHERE id_facturas_cliente=?");
					ps.setString(1, codigo);
					ps.execute();
					JOptionPane.showMessageDialog(null, "Factura Eliminada!");
					limpiar();
					formulario.construirTabla();
					formulario.txtCodigo.setText(null);
					formulario.btnAceptar.setEnabled(true);
					formulario.btnActualizar.setVisible(false);
					formulario.btnGuardar.setVisible(false);
					formulario.btnNuevo.setVisible(false);

				}
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "Error al Eliminar");
				System.out.println(ex.toString());
			}
		}

		/* Nuevo */
		if (e.getSource() == formulario.btnNuevo) {
			limpiar();
			formulario.obtenerUltimoId();
			formulario.pistas();
			formulario.consultarEmpresa();
			formulario.construirTabla();
			formulario.establecerDatosEmpresa();
			formulario.ObtenerUltimosDatosSar();
			registro_facturas_clientes.txtFechaHoraFactura.setText(registro_facturas_clientes.getFechaYHora());
			formulario.btnBorrar.setVisible(false);
			formulario.btnGuardar.setVisible(true);
			formulario.btnNuevo.setVisible(true);
			formulario.btnActualizar.setVisible(false);
			formulario.btnActualizarDatos.setVisible(true);
			formulario.btnVer.setVisible(true);
			formulario.btnAceptar.setVisible(false);
		}

		/* Aceptar */
		if (e.getSource() == formulario.btnAceptar) {
			limpiar();
			formulario.btnBorrar.setVisible(false);
			formulario.btnGuardar.setVisible(true);
			formulario.btnNuevo.setVisible(true);
			formulario.btnActualizar.setVisible(false);
			formulario.btnActualizarDatos.setVisible(true);
			formulario.btnVer.setVisible(true);
			formulario.btnAceptar.setVisible(false);
			formulario.txtCodigo.setEnabled(true);
			formulario.txtCodigo.setEditable(false);
			formulario.obtenerUltimoId();
			formulario.pistas();
			formulario.consultarEmpresa();
			formulario.construirTabla();
			formulario.establecerDatosEmpresa();
			formulario.ObtenerUltimosDatosSar();
			formulario.txtCliente.setEditable(true);
			formulario.txtRTN.setEditable(true);
			formulario.txtDireccion.setEditable(true);
			formulario.txtPorConceptoDe.setEditable(true);
			formulario.txtCantidadLetras.setEditable(true);
			formulario.txtCantidadNumeros.setEditable(true);
			formulario.txtEmpleado.setEditable(true);
			registro_facturas_clientes.txtFechaHoraFactura.setText(registro_facturas_clientes.getFechaYHora());
			formulario.txtCliente.requestFocusInWindow();

		}

	}

	public void limpiar() {
		formulario.txtBusqueda.setText(null);
		formulario.txtCodigo.setText(null);
		formulario.txtNumeroFactura.setText(null);
		registro_facturas_clientes.txtFechaHoraFactura.setText(null);
		formulario.txtCliente.setText(null);
		formulario.txtRTN.setText(null);
		formulario.txtDireccion.setText(null);
		formulario.txtPorConceptoDe.setText(null);
		formulario.txtCantidadLetras.setText(null);
		formulario.txtCantidadNumeros.setText(null);
		formulario.txtEmpleado.setText(null);
	}

	public static ArrayList<factura_cliente> buscarUsuariosConMatriz() {
		conexion conex = new conexion();
		ArrayList<factura_cliente> miLista = new ArrayList<factura_cliente>();
		factura_cliente factura_cliente;
		try {
			Statement estatuto = conex.getConexion().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT * FROM facturas_clientes");

			while (rs.next()) {
				factura_cliente = new factura_cliente();
				factura_cliente.setId_facturas_cliente(Integer.parseInt(rs.getString("id_facturas_cliente")));
				factura_cliente.setNumero_factura_cliente(rs.getString("numero_factura_cliente"));
				factura_cliente.setFecha_hora_factura_cliente(rs.getString("fecha_hora_factura_cliente"));
				factura_cliente.setFirma_cliente(rs.getString("firma_cliente"));
				factura_cliente.setRtn_factura_cliente(rs.getString("rtn_factura_cliente"));
				factura_cliente.setDireccion_cliente(rs.getString("direccion_cliente"));
				factura_cliente.setPor_concepto_cliente(rs.getString("por_concepto_cliente"));
				factura_cliente.setCantidad_letras_cliente(rs.getString("cantidad_letras_cliente"));
				factura_cliente.setCantidad_pagada_cliente(Double.parseDouble(rs.getString("cantidad_pagada_cliente")));
				factura_cliente.setEmpleado_atencion_cliente(rs.getString("empleado_atencion_cliente"));
				miLista.add(factura_cliente);
			}
			rs.close();
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error al consultar", "Error", JOptionPane.ERROR_MESSAGE);

		}
		return miLista;
	}

	public static String[][] obtenerMatriz() {
		ArrayList<factura_cliente> miLista = buscarUsuariosConMatriz();
		String matrizInfo[][] = new String[miLista.size()][10];
		for (int i = 0; i < miLista.size(); i++) {
			matrizInfo[i][0] = miLista.get(i).getId_facturas_cliente() + "";
			matrizInfo[i][1] = miLista.get(i).getNumero_factura_cliente() + "";
			matrizInfo[i][2] = miLista.get(i).getFecha_hora_factura_cliente() + "";
			matrizInfo[i][3] = miLista.get(i).getFirma_cliente() + "";
			matrizInfo[i][4] = miLista.get(i).getRtn_factura_cliente() + "";
			matrizInfo[i][5] = miLista.get(i).getDireccion_cliente() + "";
			matrizInfo[i][6] = miLista.get(i).getPor_concepto_cliente() + "";
			matrizInfo[i][7] = miLista.get(i).getCantidad_letras_cliente() + "";
			matrizInfo[i][8] = miLista.get(i).getCantidad_pagada_cliente() + "";
			matrizInfo[i][9] = miLista.get(i).getEmpleado_atencion_cliente() + "";

		}

		return matrizInfo;
	}

}
