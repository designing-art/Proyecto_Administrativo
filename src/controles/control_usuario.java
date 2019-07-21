package controles;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import clases.empleado;
import clases.usuario;
import conexion.conexion;
import consultas.consultas_usuario;
import formularios.configuraciones;
import formularios.registro_usuarios;
import formularios.ventana_principal;

public class control_usuario implements ActionListener {

	public usuario clase;
	public consultas_usuario consulta;
	public registro_usuarios formulario;
	public static String identidad = null;
	public static String usuario = null;

	public static String todo;
	public static String empleado;
	public static String cargoe;
	public static String horario;
	public static String contrato_e;
	public static String cliente;
	public static String contrato_c;
	public static String compra;
	public static String proveedor;
	public static String inventario;
	public static String factura_c;
	public static String factura_e;
	public static String sar;
	public static String ingreso;
	public static String producto;
	public static String servicio;
	public static String venta;
	public static String egreso;
	public static String bonificacion;
	public static String deduccion;
	public static String planilla;
	public static String empresa;
	public static String opciones;
	public static String usuarios;
	public static String acercade;

	public control_usuario(usuario clase, consultas_usuario consulta, registro_usuarios formulario) {
		this.clase = clase;
		this.consulta = consulta;
		this.formulario = formulario;
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
			validarUsuarioPorIdentidad();
			if (formulario.txtNombres.getText().isEmpty() || formulario.txtCargo.getText().isEmpty()
					|| formulario.txtIdentidad.getText().isEmpty() || formulario.txtUsuario.getText().isEmpty()
					|| formulario.txtContraseña.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Porfavor llene los campos para guardar el usuario!");
			} else {
				if (formulario.txtIdentidad.getText().toString().equals(identidad)) {
					JOptionPane.showMessageDialog(null, "Se encontrado un registro con esta identidad : "+identidad, "Alerta!\n"
							+"Nota: Un empleado no puede ser registrado 2 o mas veces", 
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					if (formulario.txtUsuario.getText().toString().equals(usuario)) {
						JOptionPane.showMessageDialog(null, "Se encontrado un usuario que ya pertenece a : " + identidad, "Alerta!\n"
								+"Nota: Un empleado no puede tener 2 o mas usuarios",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						definirPermisos();
						clase.setUsuario(formulario.txtUsuario.getText().toString());
						clase.setContraseña(formulario.txtContraseña.getText().toString());
						clase.setIdentidad(formulario.txtIdentidad.getText().toString());
						clase.setNombre(formulario.txtNombres.getText().toString());
						clase.setCargo(formulario.txtCargo.getText().toString());
						clase.setTipo_usuario(formulario.cbxTipoUsuario.getSelectedItem().toString());
						clase.setPermiso_todo(todo);
						clase.setPermiso_empleado(empleado);
						clase.setPermiso_cargo(cargoe);
						clase.setPermiso_horario(horario);
						clase.setPermiso_contrato_e(contrato_e);
						clase.setPermiso_cliente(cliente);
						clase.setPermiso_contrato_c(contrato_c);
						clase.setPermiso_compra(compra);
						clase.setPermiso_proveedor(proveedor);
						clase.setPermiso_inventario(inventario);
						clase.setPermiso_factura_c(factura_c);
						clase.setPermiso_factura_e(factura_e);
						clase.setPermiso_sar(sar);
						clase.setPermiso_ingreso(ingreso);
						clase.setPermiso_producto(producto);
						clase.setPermiso_servicio(servicio);
						clase.setPermiso_venta(venta);
						clase.setPermiso_egreso(egreso);
						clase.setPermiso_bonificacion(bonificacion);
						clase.setPermiso_deduccion(deduccion);
						clase.setPermiso_planilla(planilla);
						clase.setPermiso_empresa(empresa);
						clase.setPermiso_opciones(opciones);
						clase.setPermiso_usuarios(usuarios);
						clase.setPermiso_acercade(acercade);
						clase.setDireccion_foto_usuario(formulario.txtDirecFoto.getText().toString());

						if (consulta.insertar(clase)) {
							JOptionPane.showMessageDialog(null, "Usuario registrado!");
							limpiar();
							formulario.construirTabla();
							formulario.obtenerUltimoId();
							formulario.txtDirecFoto.setText("");
							final ImageIcon iconoContrato = new ImageIcon(
									getClass().getResource("/iconos/usuario.png"));
							final ImageIcon iconofoto = new ImageIcon(iconoContrato.getImage().getScaledInstance(
									formulario.lblFotoUsuario.getWidth(),
									formulario.lblFotoUsuario.getHeight(), Image.SCALE_DEFAULT));
							formulario.lblFotoUsuario.setIcon(iconofoto);
						} else {
							JOptionPane.showMessageDialog(null, "Error! Usuario no registrado");
							limpiar();
						}
					}

				}
			}
		}

		if (e.getSource() == formulario.btnActualizar) {
			if (formulario.txtNombres.getText().isEmpty()

					|| formulario.txtCargo.getText().isEmpty() || formulario.txtIdentidad.getText().isEmpty()
					|| formulario.txtUsuario.getText().isEmpty() || formulario.txtContraseña.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Porfavor llene los campos para guardar el usuario!");
			} else {
				consultas_usuario consulta = new consultas_usuario();
				usuario clase = new usuario();
				clase.setUsuario(formulario.txtUsuario.getText().toString());
				clase.setContraseña(formulario.txtContraseña.getText().toString());
				if (consulta.buscarUsuario(clase)) {

					JOptionPane.showMessageDialog(null,
							"Imposible realizar la accion no tiene permisos para actualizar\n"
									+ "Sus propias credenciales o permisos.");
				} else {
					definirPermisos();
					clase.setId_usuario(Integer.parseInt(formulario.txtCodigo.getText().toString()));
					clase.setUsuario(formulario.txtUsuario.getText().toString());
					clase.setContraseña(formulario.txtContraseña.getText().toString());
					clase.setIdentidad(formulario.txtIdentidad.getText().toString());
					clase.setNombre(formulario.txtNombres.getText().toString());
					clase.setCargo(formulario.txtCargo.getText().toString());
					clase.setTipo_usuario(formulario.cbxTipoUsuario.getSelectedItem().toString());
					clase.setPermiso_todo(todo);
					clase.setPermiso_empleado(empleado);
					clase.setPermiso_cargo(cargoe);
					clase.setPermiso_horario(horario);
					clase.setPermiso_contrato_e(contrato_e);
					clase.setPermiso_cliente(cliente);
					clase.setPermiso_contrato_c(contrato_c);
					clase.setPermiso_compra(compra);
					clase.setPermiso_proveedor(proveedor);
					clase.setPermiso_inventario(inventario);
					clase.setPermiso_factura_c(factura_c);
					clase.setPermiso_factura_e(factura_e);
					clase.setPermiso_sar(sar);
					clase.setPermiso_ingreso(ingreso);
					clase.setPermiso_producto(producto);
					clase.setPermiso_servicio(servicio);
					clase.setPermiso_venta(venta);
					clase.setPermiso_egreso(egreso);
					clase.setPermiso_bonificacion(bonificacion);
					clase.setPermiso_deduccion(deduccion);
					clase.setPermiso_planilla(planilla);
					clase.setPermiso_empresa(empresa);
					clase.setPermiso_opciones(opciones);
					clase.setPermiso_usuarios(usuarios);
					clase.setPermiso_acercade(acercade);
					clase.setDireccion_foto_usuario(formulario.txtDirecFoto.getText().toString());

					if (consulta.actualizar(clase)) {
						JOptionPane.showMessageDialog(null, "Usuario actualizado!");
						limpiar();
						formulario.construirTabla();
						formulario.obtenerUltimoId();
						formulario.txtDirecFoto.setText("");
						final ImageIcon iconoContrato = new ImageIcon(
								getClass().getResource("/iconos/usuario.png"));
						final ImageIcon iconofoto = new ImageIcon(iconoContrato.getImage().getScaledInstance(
								formulario.lblFotoUsuario.getWidth(),
								formulario.lblFotoUsuario.getHeight(), Image.SCALE_DEFAULT));
						formulario.lblFotoUsuario.setIcon(iconofoto);
					} else {
						JOptionPane.showMessageDialog(null, "Error! Usuario no actualizado");
						limpiar();
					}
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
					String usuario = formulario.tabla.getValueAt(filaseleccionada, 1).toString();
					String contraseña = formulario.tabla.getValueAt(filaseleccionada, 2).toString();
					String identidad = formulario.tabla.getValueAt(filaseleccionada, 3).toString();
					String nombre = formulario.tabla.getValueAt(filaseleccionada, 4).toString();
					String cargo = formulario.tabla.getValueAt(filaseleccionada, 5).toString();
					String tipo = formulario.tabla.getValueAt(filaseleccionada, 6).toString();
					String todo = formulario.tabla.getValueAt(filaseleccionada, 7).toString();
					String empleado = formulario.tabla.getValueAt(filaseleccionada, 8).toString();
					String cargoe = formulario.tabla.getValueAt(filaseleccionada, 9).toString();
					String horario = formulario.tabla.getValueAt(filaseleccionada, 10).toString();
					String contrato_e = formulario.tabla.getValueAt(filaseleccionada, 11).toString();
					String cliente = formulario.tabla.getValueAt(filaseleccionada, 12).toString();
					String contrato_c = formulario.tabla.getValueAt(filaseleccionada, 13).toString();
					String compra = formulario.tabla.getValueAt(filaseleccionada, 14).toString();
					String proveedor = formulario.tabla.getValueAt(filaseleccionada, 15).toString();
					String inventario = formulario.tabla.getValueAt(filaseleccionada, 16).toString();
					String factura_c = formulario.tabla.getValueAt(filaseleccionada, 17).toString();
					String factura_e = formulario.tabla.getValueAt(filaseleccionada, 18).toString();
					String sar = formulario.tabla.getValueAt(filaseleccionada, 19).toString();
					String ingreso = formulario.tabla.getValueAt(filaseleccionada, 20).toString();
					String producto = formulario.tabla.getValueAt(filaseleccionada, 21).toString();
					String servicio = formulario.tabla.getValueAt(filaseleccionada, 22).toString();
					String venta = formulario.tabla.getValueAt(filaseleccionada, 23).toString();
					String egreso = formulario.tabla.getValueAt(filaseleccionada, 24).toString();
					String bonificacion = formulario.tabla.getValueAt(filaseleccionada, 25).toString();
					String deduccion = formulario.tabla.getValueAt(filaseleccionada, 26).toString();
					String planilla = formulario.tabla.getValueAt(filaseleccionada, 27).toString();
					String empresa = formulario.tabla.getValueAt(filaseleccionada, 28).toString();
					String opciones = formulario.tabla.getValueAt(filaseleccionada, 29).toString();
					String usuarios = formulario.tabla.getValueAt(filaseleccionada, 30).toString();
					String acercade = formulario.tabla.getValueAt(filaseleccionada, 31).toString();
					String foto = formulario.tabla.getValueAt(filaseleccionada, 32).toString();

					if (todo.equals("SI")) {
						registro_usuarios.rbdTodos.setSelected(true);
					} else {
						registro_usuarios.rbdTodos.setSelected(false);
					}
					if (empleado.equals("SI")) {
						registro_usuarios.rdbtnEmpleados.setSelected(true);
					} else {
						registro_usuarios.rdbtnEmpleados.setSelected(false);
					}
					if (cargoe.equals("SI")) {
						registro_usuarios.rdbtnCargos.setSelected(true);
					} else {
						registro_usuarios.rdbtnCargos.setSelected(false);
					}
					if (horario.equals("SI")) {
						registro_usuarios.rdbtnHorarios.setSelected(true);
					} else {
						registro_usuarios.rdbtnHorarios.setSelected(false);
					}

					if (contrato_e.equals("SI")) {
						registro_usuarios.rdbtnContratos_e.setSelected(true);
					} else {
						registro_usuarios.rdbtnContratos_e.setSelected(false);
					}

					if (cliente.equals("SI")) {
						registro_usuarios.rdbtnClientes.setSelected(true);
					} else {
						registro_usuarios.rdbtnClientes.setSelected(false);
					}
					if (contrato_c.equals("SI")) {
						registro_usuarios.rdbtnContratos_c.setSelected(true);
					} else {
						registro_usuarios.rdbtnContratos_c.setSelected(false);
					}

					if (compra.equals("SI")) {
						registro_usuarios.rdbtnCompras.setSelected(true);
					} else {
						registro_usuarios.rdbtnCompras.setSelected(false);
					}

					if (proveedor.equals("SI")) {
						registro_usuarios.rdbtnProveedores.setSelected(true);
					} else {
						registro_usuarios.rdbtnProveedores.setSelected(false);

					}
					if (inventario.equals("SI")) {
						registro_usuarios.rdbtnInventario.setSelected(true);
					} else {
						registro_usuarios.rdbtnInventario.setSelected(false);
					}

					if (factura_c.equals("SI")) {
						registro_usuarios.rdbtnFactCliente.setSelected(true);
					} else {
						registro_usuarios.rdbtnFactCliente.setSelected(false);
					}

					if (factura_e.equals("SI")) {
						registro_usuarios.rdbtnFactEmpresa.setSelected(true);
					} else {
						registro_usuarios.rdbtnFactEmpresa.setSelected(false);
					}

					if (sar.equals("SI")) {
						registro_usuarios.rdbtnSar.setSelected(true);
					} else {
						registro_usuarios.rdbtnSar.setSelected(false);
					}

					if (ingreso.equals("SI")) {
						registro_usuarios.rdbtnIngresos.setSelected(true);
					} else {
						registro_usuarios.rdbtnIngresos.setSelected(false);
					}

					if (producto.equals("SI")) {
						registro_usuarios.rdbtnProductos.setSelected(true);
					} else {
						registro_usuarios.rdbtnProductos.setSelected(false);
					}

					if (servicio.equals("SI")) {
						registro_usuarios.rdbtnServicios.setSelected(true);
					} else {
						registro_usuarios.rdbtnServicios.setSelected(false);
					}

					if (venta.equals("SI")) {
						registro_usuarios.rdbtnVentas.setSelected(true);
					} else {
						registro_usuarios.rdbtnVentas.setSelected(false);
					}

					if (egreso.equals("SI")) {
						registro_usuarios.rdbtnEgresos.setSelected(true);
					} else {
						registro_usuarios.rdbtnEgresos.setSelected(false);

					}
					if (bonificacion.equals("SI")) {
						registro_usuarios.rdbtnBonificaciones.setSelected(true);
					} else {
						registro_usuarios.rdbtnBonificaciones.setSelected(false);
					}

					if (deduccion.equals("SI")) {
						registro_usuarios.rdbtnDeducc.setSelected(true);
					} else {
						registro_usuarios.rdbtnDeducc.setSelected(false);
					}

					if (planilla.equals("SI")) {
						registro_usuarios.rdbtnPlanillas.setSelected(true);
					} else {
						registro_usuarios.rdbtnPlanillas.setSelected(false);
					}

					if (empresa.equals("SI")) {
						registro_usuarios.rdbtnEmpresa.setSelected(true);
					} else {
						registro_usuarios.rdbtnEmpresa.setSelected(false);
					}

					if (opciones.equals("SI")) {
						registro_usuarios.rdbtnConfiguracion.setSelected(true);
					} else {
						registro_usuarios.rdbtnConfiguracion.setSelected(false);
					}

					if (usuarios.equals("SI")) {
						registro_usuarios.rdbtnUsuarios.setSelected(true);
					} else {
						registro_usuarios.rdbtnUsuarios.setSelected(false);
					}

					if (acercade.equals("SI")) {
						registro_usuarios.rdbtnAcercaDe.setSelected(true);
					} else {
						registro_usuarios.rdbtnAcercaDe.setSelected(false);
					}

					todo = "Todos";
					empleado = "Empleados";
					cargoe = "Cargos";
					horario = "Horarios";
					contrato_e = "Contratos E.";
					cliente = "Planillas";
					contrato_c = "Proveedores";
					compra = "Compras";
					proveedor = "Proveedores";
					inventario = "Invetario";
					factura_c = "Fact. Cliente";
					factura_e = "Fact. Empre";
					sar = "SAR";
					ingreso = "Ingresos";
					producto = "Productos";
					servicio = "Servicios";
					venta = "Ventas";
					egreso = "Egresos";
					bonificacion = "Bonific.";
					deduccion = "Deducc.";
					planilla = "Planillas";
					empresa = "Empresa";
					opciones = "Opciones";
					usuarios = "Usuarios";
					acercade = "Acerca de.";

					formulario.txtCodigo.setText(codigo);
					formulario.txtUsuario.setText(usuario);
					formulario.txtContraseña.setText(contraseña);
					formulario.txtIdentidad.setText(identidad);
					formulario.txtNombres.setText(nombre);
					formulario.txtCargo.setText(cargo);
					formulario.cbxTipoUsuario.setSelectedItem(tipo);
					registro_usuarios.rbdTodos.setText(todo);
					registro_usuarios.rdbtnEmpleados.setText(empleado);
					registro_usuarios.rdbtnCargos.setText(cargoe);
					registro_usuarios.rdbtnHorarios.setText(horario);
					registro_usuarios.rdbtnContratos_e.setText(contrato_e);
					registro_usuarios.rdbtnClientes.setText(cliente);
					registro_usuarios.rdbtnContratos_c.setText(contrato_c);
					registro_usuarios.rdbtnCompras.setText(compra);
					registro_usuarios.rdbtnProveedores.setText(proveedor);
					registro_usuarios.rdbtnInventario.setText(inventario);
					registro_usuarios.rdbtnFactCliente.setText(factura_c);
					registro_usuarios.rdbtnFactEmpresa.setText(factura_e);
					registro_usuarios.rdbtnSar.setText(sar);
					registro_usuarios.rdbtnIngresos.setText(ingreso);
					registro_usuarios.rdbtnProductos.setText(producto);
					registro_usuarios.rdbtnServicios.setText(servicio);
					registro_usuarios.rdbtnVentas.setText(venta);
					registro_usuarios.rdbtnEgresos.setText(egreso);
					registro_usuarios.rdbtnBonificaciones.setText(bonificacion);
					registro_usuarios.rdbtnDeducc.setText(deduccion);
					registro_usuarios.rdbtnPlanillas.setText(planilla);
					registro_usuarios.rdbtnEmpresa.setText(empresa);
					registro_usuarios.rdbtnConfiguracion.setText(opciones);
					registro_usuarios.rdbtnUsuarios.setText(usuarios);
					registro_usuarios.rdbtnAcercaDe.setText(acercade);
					formulario.txtDirecFoto.setText(foto);

					formulario.txtCodigo.setForeground(Color.BLACK);
					formulario.txtUsuario.setForeground(Color.BLACK);
					formulario.txtContraseña.setForeground(Color.BLACK);
					formulario.txtIdentidad.setForeground(Color.BLACK);
					formulario.txtNombres.setForeground(Color.BLACK);
					formulario.txtCargo.setForeground(Color.BLACK);
					formulario.cbxTipoUsuario.setForeground(Color.BLACK);
					registro_usuarios.rbdTodos.setForeground(Color.BLACK);
					registro_usuarios.rdbtnEmpleados.setForeground(Color.BLACK);
					registro_usuarios.rdbtnCargos.setForeground(Color.BLACK);
					registro_usuarios.rdbtnHorarios.setForeground(Color.BLACK);
					registro_usuarios.rdbtnContratos_e.setForeground(Color.BLACK);
					registro_usuarios.rdbtnClientes.setForeground(Color.BLACK);
					registro_usuarios.rdbtnContratos_c.setForeground(Color.BLACK);
					registro_usuarios.rdbtnCompras.setForeground(Color.BLACK);
					registro_usuarios.rdbtnProveedores.setForeground(Color.BLACK);
					registro_usuarios.rdbtnInventario.setForeground(Color.BLACK);
					registro_usuarios.rdbtnFactCliente.setForeground(Color.BLACK);
					registro_usuarios.rdbtnFactEmpresa.setForeground(Color.BLACK);
					registro_usuarios.rdbtnSar.setForeground(Color.BLACK);
					registro_usuarios.rdbtnIngresos.setForeground(Color.BLACK);
					registro_usuarios.rdbtnProductos.setForeground(Color.BLACK);
					registro_usuarios.rdbtnServicios.setForeground(Color.BLACK);
					registro_usuarios.rdbtnVentas.setForeground(Color.BLACK);
					registro_usuarios.rdbtnEgresos.setForeground(Color.BLACK);
					registro_usuarios.rdbtnBonificaciones.setForeground(Color.BLACK);
					registro_usuarios.rdbtnDeducc.setForeground(Color.BLACK);
					registro_usuarios.rdbtnPlanillas.setForeground(Color.BLACK);
					registro_usuarios.rdbtnEmpresa.setForeground(Color.BLACK);
					registro_usuarios.rdbtnConfiguracion.setForeground(Color.BLACK);
					registro_usuarios.rdbtnUsuarios.setForeground(Color.BLACK);
					registro_usuarios.rdbtnAcercaDe.setForeground(Color.BLACK);
					
					formulario.validarModificacionUsuarioLogeado();

					formulario.txtIdentidad.setEditable(false);
					formulario.txtNombres.setEditable(false);
					formulario.txtCargo.setEditable(false);
					formulario.btnBorrar.setVisible(true);
					formulario.btnGuardar.setVisible(false);
					formulario.btnNuevo.setVisible(false);
					formulario.btnActualizar.setVisible(true);
					formulario.btnActualizarDatos.setVisible(true);
					formulario.btnVer.setVisible(false);
					formulario.btnAceptar.setText("Cancelar");
					formulario.btnAceptar.setVisible(true);
					formulario.txtBusqueda.setText("");
					formulario.txtBusqueda.setEditable(false);
					
					final ImageIcon icono = new ImageIcon(foto);
					final ImageIcon iconofoto = new ImageIcon(icono.getImage().getScaledInstance(
							formulario.lblFotoUsuario.getWidth(),
							formulario.lblFotoUsuario.getHeight(), Image.SCALE_DEFAULT));
					formulario.lblFotoUsuario.setIcon(iconofoto);
					

					formulario.txtUsuario.requestFocusInWindow();

				}

			} catch (HeadlessException ex) {
				JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente",
						" .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);
			}
		}

		/* Pasar datos de la tabla al formulario para ver los datos */
		if (e.getSource() == formulario.btnVer) {
			int filaseleccionada;
			try {
				filaseleccionada = formulario.tabla.getSelectedRow();
				if (filaseleccionada == -1) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
				} else {
					String codigo = formulario.tabla.getValueAt(filaseleccionada, 0).toString();
					String usuario = formulario.tabla.getValueAt(filaseleccionada, 1).toString();
					String contraseña = formulario.tabla.getValueAt(filaseleccionada, 2).toString();
					String identidad = formulario.tabla.getValueAt(filaseleccionada, 3).toString();
					String nombre = formulario.tabla.getValueAt(filaseleccionada, 4).toString();
					String cargo = formulario.tabla.getValueAt(filaseleccionada, 5).toString();
					String tipo = formulario.tabla.getValueAt(filaseleccionada, 6).toString();
					String todo = formulario.tabla.getValueAt(filaseleccionada, 7).toString();
					String empleado = formulario.tabla.getValueAt(filaseleccionada, 8).toString();
					String cargoe = formulario.tabla.getValueAt(filaseleccionada, 9).toString();
					String horario = formulario.tabla.getValueAt(filaseleccionada, 10).toString();
					String contrato_e = formulario.tabla.getValueAt(filaseleccionada, 11).toString();
					String cliente = formulario.tabla.getValueAt(filaseleccionada, 12).toString();
					String contrato_c = formulario.tabla.getValueAt(filaseleccionada, 13).toString();
					String compra = formulario.tabla.getValueAt(filaseleccionada, 14).toString();
					String proveedor = formulario.tabla.getValueAt(filaseleccionada, 15).toString();
					String inventario = formulario.tabla.getValueAt(filaseleccionada, 16).toString();
					String factura_c = formulario.tabla.getValueAt(filaseleccionada, 17).toString();
					String factura_e = formulario.tabla.getValueAt(filaseleccionada, 18).toString();
					String sar = formulario.tabla.getValueAt(filaseleccionada, 19).toString();
					String ingreso = formulario.tabla.getValueAt(filaseleccionada, 20).toString();
					String producto = formulario.tabla.getValueAt(filaseleccionada, 21).toString();
					String servicio = formulario.tabla.getValueAt(filaseleccionada, 22).toString();
					String venta = formulario.tabla.getValueAt(filaseleccionada, 23).toString();
					String egreso = formulario.tabla.getValueAt(filaseleccionada, 24).toString();
					String bonificacion = formulario.tabla.getValueAt(filaseleccionada, 25).toString();
					String deduccion = formulario.tabla.getValueAt(filaseleccionada, 26).toString();
					String planilla = formulario.tabla.getValueAt(filaseleccionada, 27).toString();
					String empresa = formulario.tabla.getValueAt(filaseleccionada, 28).toString();
					String opciones = formulario.tabla.getValueAt(filaseleccionada, 29).toString();
					String usuarios = formulario.tabla.getValueAt(filaseleccionada, 30).toString();
					String acercade = formulario.tabla.getValueAt(filaseleccionada, 31).toString();
					String foto = formulario.tabla.getValueAt(filaseleccionada, 32).toString();

					if (todo.equals("SI")) {
						registro_usuarios.rbdTodos.setSelected(true);
					} else {
						registro_usuarios.rbdTodos.setSelected(false);
					}
					if (empleado.equals("SI")) {
						registro_usuarios.rdbtnEmpleados.setSelected(true);
					} else {
						registro_usuarios.rdbtnEmpleados.setSelected(false);
					}
					if (cargoe.equals("SI")) {
						registro_usuarios.rdbtnCargos.setSelected(true);
					} else {
						registro_usuarios.rdbtnCargos.setSelected(false);
					}
					if (horario.equals("SI")) {
						registro_usuarios.rdbtnHorarios.setSelected(true);
					} else {
						registro_usuarios.rdbtnHorarios.setSelected(false);
					}

					if (contrato_e.equals("SI")) {
						registro_usuarios.rdbtnContratos_e.setSelected(true);
					} else {
						registro_usuarios.rdbtnContratos_e.setSelected(false);
					}

					if (cliente.equals("SI")) {
						registro_usuarios.rdbtnClientes.setSelected(true);
					} else {
						registro_usuarios.rdbtnClientes.setSelected(false);
					}
					if (contrato_c.equals("SI")) {
						registro_usuarios.rdbtnContratos_c.setSelected(true);
					} else {
						registro_usuarios.rdbtnContratos_c.setSelected(false);
					}

					if (compra.equals("SI")) {
						registro_usuarios.rdbtnCompras.setSelected(true);
					} else {
						registro_usuarios.rdbtnCompras.setSelected(false);
					}

					if (proveedor.equals("SI")) {
						registro_usuarios.rdbtnProveedores.setSelected(true);
					} else {
						registro_usuarios.rdbtnProveedores.setSelected(false);

					}
					if (inventario.equals("SI")) {
						registro_usuarios.rdbtnInventario.setSelected(true);
					} else {
						registro_usuarios.rdbtnInventario.setSelected(false);
					}

					if (factura_c.equals("SI")) {
						registro_usuarios.rdbtnFactCliente.setSelected(true);
					} else {
						registro_usuarios.rdbtnFactCliente.setSelected(false);
					}

					if (factura_e.equals("SI")) {
						registro_usuarios.rdbtnFactEmpresa.setSelected(true);
					} else {
						registro_usuarios.rdbtnFactEmpresa.setSelected(false);
					}

					if (sar.equals("SI")) {
						registro_usuarios.rdbtnSar.setSelected(true);
					} else {
						registro_usuarios.rdbtnSar.setSelected(false);
					}

					if (ingreso.equals("SI")) {
						registro_usuarios.rdbtnIngresos.setSelected(true);
					} else {
						registro_usuarios.rdbtnIngresos.setSelected(false);
					}

					if (producto.equals("SI")) {
						registro_usuarios.rdbtnProductos.setSelected(true);
					} else {
						registro_usuarios.rdbtnProductos.setSelected(false);
					}

					if (servicio.equals("SI")) {
						registro_usuarios.rdbtnServicios.setSelected(true);
					} else {
						registro_usuarios.rdbtnServicios.setSelected(false);
					}

					if (venta.equals("SI")) {
						registro_usuarios.rdbtnVentas.setSelected(true);
					} else {
						registro_usuarios.rdbtnVentas.setSelected(false);
					}

					if (egreso.equals("SI")) {
						registro_usuarios.rdbtnEgresos.setSelected(true);
					} else {
						registro_usuarios.rdbtnEgresos.setSelected(false);

					}
					if (bonificacion.equals("SI")) {
						registro_usuarios.rdbtnBonificaciones.setSelected(true);
					} else {
						registro_usuarios.rdbtnBonificaciones.setSelected(false);
					}

					if (deduccion.equals("SI")) {
						registro_usuarios.rdbtnDeducc.setSelected(true);
					} else {
						registro_usuarios.rdbtnDeducc.setSelected(false);
					}

					if (planilla.equals("SI")) {
						registro_usuarios.rdbtnPlanillas.setSelected(true);
					} else {
						registro_usuarios.rdbtnPlanillas.setSelected(false);
					}

					if (empresa.equals("SI")) {
						registro_usuarios.rdbtnEmpresa.setSelected(true);
					} else {
						registro_usuarios.rdbtnEmpresa.setSelected(false);
					}

					if (opciones.equals("SI")) {
						registro_usuarios.rdbtnConfiguracion.setSelected(true);
					} else {
						registro_usuarios.rdbtnConfiguracion.setSelected(false);
					}

					if (usuarios.equals("SI")) {
						registro_usuarios.rdbtnUsuarios.setSelected(true);
					} else {
						registro_usuarios.rdbtnUsuarios.setSelected(false);
					}

					if (acercade.equals("SI")) {
						registro_usuarios.rdbtnAcercaDe.setSelected(true);
					} else {
						registro_usuarios.rdbtnAcercaDe.setSelected(false);
					}

					todo = "Todos";
					empleado = "Empleados";
					cargoe = "Cargos";
					horario = "Horarios";
					contrato_e = "Contratos E.";
					cliente = "Planillas";
					contrato_c = "Proveedores";
					compra = "Compras";
					proveedor = "Proveedores";
					inventario = "Invetario";
					factura_c = "Fact. Cliente";
					factura_e = "Fact. Empre";
					sar = "SAR";
					ingreso = "Ingresos";
					producto = "Productos";
					servicio = "Servicios";
					venta = "Ventas";
					egreso = "Egresos";
					bonificacion = "Bonific.";
					deduccion = "Deducc.";
					planilla = "Planillas";
					empresa = "Empresa";
					opciones = "Opciones";
					usuarios = "Usuarios";
					acercade = "Acerca de.";

					formulario.txtCodigo.setText(codigo);
					formulario.txtUsuario.setText(usuario);
					formulario.txtContraseña.setText(contraseña);
					formulario.txtIdentidad.setText(identidad);
					formulario.txtNombres.setText(nombre);
					formulario.txtCargo.setText(cargo);
					formulario.cbxTipoUsuario.setSelectedItem(tipo);
					registro_usuarios.rbdTodos.setText(todo);
					registro_usuarios.rdbtnEmpleados.setText(empleado);
					registro_usuarios.rdbtnCargos.setText(cargoe);
					registro_usuarios.rdbtnHorarios.setText(horario);
					registro_usuarios.rdbtnContratos_e.setText(contrato_e);
					registro_usuarios.rdbtnClientes.setText(cliente);
					registro_usuarios.rdbtnContratos_c.setText(contrato_c);
					registro_usuarios.rdbtnCompras.setText(compra);
					registro_usuarios.rdbtnProveedores.setText(proveedor);
					registro_usuarios.rdbtnInventario.setText(inventario);
					registro_usuarios.rdbtnFactCliente.setText(factura_c);
					registro_usuarios.rdbtnFactEmpresa.setText(factura_e);
					registro_usuarios.rdbtnSar.setText(sar);
					registro_usuarios.rdbtnIngresos.setText(ingreso);
					registro_usuarios.rdbtnProductos.setText(producto);
					registro_usuarios.rdbtnServicios.setText(servicio);
					registro_usuarios.rdbtnVentas.setText(venta);
					registro_usuarios.rdbtnEgresos.setText(egreso);
					registro_usuarios.rdbtnBonificaciones.setText(bonificacion);
					registro_usuarios.rdbtnDeducc.setText(deduccion);
					registro_usuarios.rdbtnPlanillas.setText(planilla);
					registro_usuarios.rdbtnEmpresa.setText(empresa);
					registro_usuarios.rdbtnConfiguracion.setText(opciones);
					registro_usuarios.rdbtnUsuarios.setText(usuarios);
					registro_usuarios.rdbtnAcercaDe.setText(acercade);
					formulario.txtDirecFoto.setText(foto);

					formulario.txtCodigo.setForeground(Color.BLACK);
					formulario.txtUsuario.setForeground(Color.BLACK);
					formulario.txtContraseña.setForeground(Color.BLACK);
					formulario.txtIdentidad.setForeground(Color.BLACK);
					formulario.txtNombres.setForeground(Color.BLACK);
					formulario.txtCargo.setForeground(Color.BLACK);
					formulario.cbxTipoUsuario.setForeground(Color.BLACK);
					registro_usuarios.rbdTodos.setForeground(Color.BLACK);
					registro_usuarios.rdbtnEmpleados.setForeground(Color.BLACK);
					registro_usuarios.rdbtnCargos.setForeground(Color.BLACK);
					registro_usuarios.rdbtnHorarios.setForeground(Color.BLACK);
					registro_usuarios.rdbtnContratos_e.setForeground(Color.BLACK);
					registro_usuarios.rdbtnClientes.setForeground(Color.BLACK);
					registro_usuarios.rdbtnContratos_c.setForeground(Color.BLACK);
					registro_usuarios.rdbtnCompras.setForeground(Color.BLACK);
					registro_usuarios.rdbtnProveedores.setForeground(Color.BLACK);
					registro_usuarios.rdbtnInventario.setForeground(Color.BLACK);
					registro_usuarios.rdbtnFactCliente.setForeground(Color.BLACK);
					registro_usuarios.rdbtnFactEmpresa.setForeground(Color.BLACK);
					registro_usuarios.rdbtnSar.setForeground(Color.BLACK);
					registro_usuarios.rdbtnIngresos.setForeground(Color.BLACK);
					registro_usuarios.rdbtnProductos.setForeground(Color.BLACK);
					registro_usuarios.rdbtnServicios.setForeground(Color.BLACK);
					registro_usuarios.rdbtnVentas.setForeground(Color.BLACK);
					registro_usuarios.rdbtnEgresos.setForeground(Color.BLACK);
					registro_usuarios.rdbtnBonificaciones.setForeground(Color.BLACK);
					registro_usuarios.rdbtnDeducc.setForeground(Color.BLACK);
					registro_usuarios.rdbtnPlanillas.setForeground(Color.BLACK);
					registro_usuarios.rdbtnEmpresa.setForeground(Color.BLACK);
					registro_usuarios.rdbtnConfiguracion.setForeground(Color.BLACK);
					registro_usuarios.rdbtnUsuarios.setForeground(Color.BLACK);
					registro_usuarios.rdbtnAcercaDe.setForeground(Color.BLACK);
					
					final ImageIcon icono = new ImageIcon(foto);
					final ImageIcon iconofoto = new ImageIcon(icono.getImage().getScaledInstance(
							formulario.lblFotoUsuario.getWidth(),
							formulario.lblFotoUsuario.getHeight(), Image.SCALE_DEFAULT));
					formulario.lblFotoUsuario.setIcon(iconofoto);

					formulario.txtUsuario.setEditable(false);
					formulario.txtContraseña.setEditable(false);
					formulario.txtIdentidad.setEditable(false);
					formulario.txtNombres.setEditable(false);
					formulario.txtCargo.setEditable(false);
					formulario.cbxTipoUsuario.setEditable(false);

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

		/* Borrar */
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
					ps = conn.prepareStatement("DELETE FROM usuario WHERE id_usuario=?");
					ps.setString(1, codigo);
					ps.execute();
					JOptionPane.showMessageDialog(null, "Usuario Eliminado!");
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
			formulario.btnBorrar.setVisible(false);
			formulario.btnGuardar.setVisible(true);
			formulario.btnNuevo.setVisible(true);
			formulario.btnActualizar.setVisible(false);
			formulario.btnActualizarDatos.setVisible(true);
			formulario.btnVer.setVisible(true);
			formulario.btnAceptar.setVisible(false);
			formulario.pistas();
			formulario.construirTabla();formulario.txtCodigo.setEditable(false);
			formulario.txtUsuario.setEditable(true);
			formulario.txtContraseña.setEditable(true);
			formulario.txtIdentidad.setEditable(false);
			formulario.txtNombres.setEditable(false);
			formulario.txtCargo.setEditable(false);
			formulario.txtBusqueda.setEditable(true);
			formulario.txtDirecFoto.setText("");
			final ImageIcon iconoContrato = new ImageIcon(
					getClass().getResource("/iconos/usuario.png"));
			final ImageIcon iconofoto = new ImageIcon(iconoContrato.getImage().getScaledInstance(
					formulario.lblFotoUsuario.getWidth(),
					formulario.lblFotoUsuario.getHeight(), Image.SCALE_DEFAULT));
			formulario.lblFotoUsuario.setIcon(iconofoto);
			registro_usuarios.txtBusqueda.requestFocusInWindow();

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
			formulario.construirTabla();
			formulario.txtCodigo.setEditable(false);
			formulario.txtUsuario.setEditable(true);
			formulario.txtContraseña.setEditable(true);
			formulario.txtIdentidad.setEditable(false);
			formulario.txtNombres.setEditable(false);
			formulario.txtCargo.setEditable(false);
			formulario.txtBusqueda.setEditable(true);
			formulario.txtDirecFoto.setText("");
			final ImageIcon iconoContrato = new ImageIcon(
					getClass().getResource("/iconos/usuario.png"));
			final ImageIcon iconofoto = new ImageIcon(iconoContrato.getImage().getScaledInstance(
					formulario.lblFotoUsuario.getWidth(),
					formulario.lblFotoUsuario.getHeight(), Image.SCALE_DEFAULT));
			formulario.lblFotoUsuario.setIcon(iconofoto);
			registro_usuarios.txtBusqueda.requestFocusInWindow();
		}

	}

	/* Metodos para implementar */

	/* Metodo para el boton nuevo que limpia los datos de los txtFields */
	public void limpiar() {
		registro_usuarios.txtBusqueda.setText(null);
		formulario.txtCodigo.setText(null);
		formulario.txtUsuario.setText(null);
		formulario.txtContraseña.setText(null);
		formulario.txtIdentidad.setText(null);
		formulario.txtNombres.setText(null);
		formulario.txtCargo.setText(null);

		registro_usuarios.rbdTodos.setSelected(false);
		registro_usuarios.rdbtnEmpleados.setSelected(false);
		registro_usuarios.rdbtnCargos.setSelected(false);
		registro_usuarios.rdbtnHorarios.setSelected(false);
		registro_usuarios.rdbtnContratos_e.setSelected(false);
		registro_usuarios.rdbtnClientes.setSelected(false);
		registro_usuarios.rdbtnContratos_c.setSelected(false);
		registro_usuarios.rdbtnCompras.setSelected(false);
		registro_usuarios.rdbtnProveedores.setSelected(false);
		registro_usuarios.rdbtnInventario.setSelected(false);
		registro_usuarios.rdbtnFactCliente.setSelected(false);
		registro_usuarios.rdbtnFactEmpresa.setSelected(false);
		registro_usuarios.rdbtnSar.setSelected(false);
		registro_usuarios.rdbtnIngresos.setSelected(false);
		registro_usuarios.rdbtnProductos.setSelected(false);
		registro_usuarios.rdbtnServicios.setSelected(false);
		registro_usuarios.rdbtnVentas.setSelected(false);
		registro_usuarios.rdbtnEgresos.setSelected(false);
		registro_usuarios.rdbtnBonificaciones.setSelected(false);
		registro_usuarios.rdbtnDeducc.setSelected(false);
		registro_usuarios.rdbtnPlanillas.setSelected(false);
		registro_usuarios.rdbtnEmpresa.setSelected(false);
		registro_usuarios.rdbtnConfiguracion.setSelected(false);
		registro_usuarios.rdbtnUsuarios.setSelected(false);
		registro_usuarios.rdbtnAcercaDe.setSelected(false);

		registro_usuarios.txtBusqueda.requestFocusInWindow();
	}

	public static ArrayList<usuario> buscarUsuariosConMatriz() {
		conexion conex = new conexion();
		ArrayList<usuario> miLista = new ArrayList<usuario>();
		usuario usuario;
		try {
			Statement estatuto = conex.getConexion().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT * FROM usuario");

			while (rs.next()) {
				usuario = new usuario();
				usuario.setId_usuario(Integer.parseInt(rs.getString("id_usuario")));
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setContraseña(rs.getString("contraseña"));
				usuario.setIdentidad(rs.getString("identidad"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setCargo(rs.getString("cargo"));
				usuario.setTipo_usuario(rs.getString("tipo_usuario"));
				usuario.setPermiso_todo(rs.getString("permiso_todo"));
				usuario.setPermiso_empleado(rs.getString("permiso_empleado"));
				usuario.setPermiso_cargo(rs.getString("permiso_cargo"));
				usuario.setPermiso_horario(rs.getString("permiso_horario"));
				usuario.setPermiso_contrato_e(rs.getString("permiso_contrato_e"));
				usuario.setPermiso_cliente(rs.getString("permiso_cliente"));
				usuario.setPermiso_contrato_c(rs.getString("permiso_contrato_c"));
				usuario.setPermiso_compra(rs.getString("permiso_compra"));
				usuario.setPermiso_proveedor(rs.getString("permiso_proveedor"));
				usuario.setPermiso_inventario(rs.getString("permiso_inventario"));
				usuario.setPermiso_factura_c(rs.getString("permiso_factura_c"));
				usuario.setPermiso_factura_e(rs.getString("permiso_factura_e"));
				usuario.setPermiso_sar(rs.getString("permiso_sar"));
				usuario.setPermiso_ingreso(rs.getString("permiso_ingreso"));
				usuario.setPermiso_producto(rs.getString("permiso_producto"));
				usuario.setPermiso_servicio(rs.getString("permiso_servicio"));
				usuario.setPermiso_venta(rs.getString("permiso_venta"));
				usuario.setPermiso_egreso(rs.getString("permiso_egreso"));
				usuario.setPermiso_bonificacion(rs.getString("permiso_bonificacion"));
				usuario.setPermiso_deduccion(rs.getString("permiso_deduccion"));
				usuario.setPermiso_planilla(rs.getString("permiso_planilla"));
				usuario.setPermiso_empresa(rs.getString("permiso_empresa"));
				usuario.setPermiso_opciones(rs.getString("permiso_opciones"));
				usuario.setPermiso_usuarios(rs.getString("permiso_usuarios"));
				usuario.setPermiso_acercade(rs.getString("permiso_acercade"));
				usuario.setDireccion_foto_usuario(rs.getString("direccion_foto_usuario"));
				miLista.add(usuario);
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
		ArrayList<usuario> miLista = buscarUsuariosConMatriz();
		String matrizInfo[][] = new String[miLista.size()][33];
		for (int i = 0; i < miLista.size(); i++) {
			matrizInfo[i][0] = miLista.get(i).getId_usuario() + "";
			matrizInfo[i][1] = miLista.get(i).getUsuario() + "";
			matrizInfo[i][2] = miLista.get(i).getContraseña() + "";
			matrizInfo[i][3] = miLista.get(i).getIdentidad() + "";
			matrizInfo[i][4] = miLista.get(i).getNombre() + "";
			matrizInfo[i][5] = miLista.get(i).getCargo() + "";
			matrizInfo[i][6] = miLista.get(i).getTipo_usuario() + "";
			matrizInfo[i][7] = miLista.get(i).getPermiso_todo() + "";
			matrizInfo[i][8] = miLista.get(i).getPermiso_empleado() + "";
			matrizInfo[i][9] = miLista.get(i).getPermiso_cargo() + "";
			matrizInfo[i][10] = miLista.get(i).getPermiso_horario() + "";
			matrizInfo[i][11] = miLista.get(i).getPermiso_contrato_e() + "";
			matrizInfo[i][12] = miLista.get(i).getPermiso_cliente() + "";
			matrizInfo[i][13] = miLista.get(i).getPermiso_contrato_c() + "";
			matrizInfo[i][14] = miLista.get(i).getPermiso_compra() + "";
			matrizInfo[i][15] = miLista.get(i).getPermiso_proveedor() + "";
			matrizInfo[i][16] = miLista.get(i).getPermiso_inventario() + "";
			matrizInfo[i][17] = miLista.get(i).getPermiso_factura_c() + "";
			matrizInfo[i][18] = miLista.get(i).getPermiso_factura_e() + "";
			matrizInfo[i][19] = miLista.get(i).getPermiso_sar() + "";
			matrizInfo[i][20] = miLista.get(i).getPermiso_ingreso() + "";
			matrizInfo[i][21] = miLista.get(i).getPermiso_producto() + "";
			matrizInfo[i][22] = miLista.get(i).getPermiso_servicio() + "";
			matrizInfo[i][23] = miLista.get(i).getPermiso_venta() + "";
			matrizInfo[i][24] = miLista.get(i).getPermiso_egreso() + "";
			matrizInfo[i][25] = miLista.get(i).getPermiso_bonificacion() + "";
			matrizInfo[i][26] = miLista.get(i).getPermiso_deduccion() + "";
			matrizInfo[i][27] = miLista.get(i).getPermiso_planilla() + "";
			matrizInfo[i][28] = miLista.get(i).getPermiso_empresa() + "";
			matrizInfo[i][29] = miLista.get(i).getPermiso_opciones() + "";
			matrizInfo[i][30] = miLista.get(i).getPermiso_usuarios() + "";
			matrizInfo[i][31] = miLista.get(i).getPermiso_acercade() + "";
			matrizInfo[i][32] = miLista.get(i).getDireccion_foto_usuario() + "";
		}

		return matrizInfo;
	}

	public void validarUsuarioPorIdentidad() {
		conexion conex = new conexion();
		try {
			Statement estatuto = conex.getConexion().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT identidad FROM usuario where identidad = '"
					+ formulario.txtIdentidad.getText().toString() + "'");

			if (rs.next()) {
				identidad = (rs.getString("identidad"));
			}

			rs.close();
			estatuto.close();
			conex.desconectar();

		} catch (SQLException exx) {
			System.out.println(exx.getMessage());
			JOptionPane.showMessageDialog(null, "Error al consultar", "Error", JOptionPane.ERROR_MESSAGE);

		}

	}

	public void definirPermisos() {
		if (registro_usuarios.rbdTodos.isSelected()) {
			todo = "SI";
		} else {
			todo = "NO";
		}
		if (registro_usuarios.rdbtnEmpleados.isSelected()) {
			empleado = "SI";
		} else {
			empleado = "NO";
		}
		if (registro_usuarios.rdbtnCargos.isSelected()) {
			cargoe = "SI";
		} else {
			cargoe = "NO";
		}
		if (registro_usuarios.rdbtnHorarios.isSelected()) {
			horario = "SI";
		} else {
			horario = "NO";
		}

		if (registro_usuarios.rdbtnContratos_e.isSelected()) {
			contrato_e = "SI";
		} else {
			contrato_e = "NO";
		}

		if (registro_usuarios.rdbtnClientes.isSelected()) {
			cliente = "SI";
		} else {
			cliente = "NO";
		}
		if (registro_usuarios.rdbtnContratos_c.isSelected()) {
			contrato_c = "SI";
		} else {
			contrato_c = "NO";
		}

		if (registro_usuarios.rdbtnCompras.isSelected()) {
			compra = "SI";
		} else {
			compra = "NO";
		}

		if (registro_usuarios.rdbtnProveedores.isSelected()) {
			proveedor = "SI";
		} else {
			proveedor = "NO";

		}
		if (registro_usuarios.rdbtnInventario.isSelected()) {
			inventario = "SI";
		} else {
			inventario = "NO";
		}

		if (registro_usuarios.rdbtnFactCliente.isSelected()) {
			factura_c = "SI";
		} else {
			factura_c = "NO";
		}

		if (registro_usuarios.rdbtnFactEmpresa.isSelected()) {
			factura_e = "SI";
		} else {
			factura_e = "NO";
		}

		if (registro_usuarios.rdbtnSar.isSelected()) {
			sar = "SI";
		} else {
			sar = "NO";
		}

		if (registro_usuarios.rdbtnIngresos.isSelected()) {
			ingreso = "SI";
		} else {
			ingreso = "NO";
		}

		if (registro_usuarios.rdbtnProductos.isSelected()) {
			producto = "SI";
		} else {
			producto = "NO";
		}

		if (registro_usuarios.rdbtnServicios.isSelected()) {
			servicio = "SI";
		} else {
			servicio = "NO";
		}

		if (registro_usuarios.rdbtnVentas.isSelected()) {
			venta = "SI";
		} else {
			venta = "NO";
		}

		if (registro_usuarios.rdbtnEgresos.isSelected()) {
			egreso = "SI";
		} else {
			egreso = "NO";

		}
		if (registro_usuarios.rdbtnBonificaciones.isSelected()) {
			bonificacion = "SI";
		} else {
			bonificacion = "NO";
		}

		if (registro_usuarios.rdbtnDeducc.isSelected()) {
			deduccion = "SI";
		} else {
			deduccion = "NO";
		}

		if (registro_usuarios.rdbtnPlanillas.isSelected()) {
			planilla = "SI";
		} else {
			planilla = "NO";
		}

		if (registro_usuarios.rdbtnEmpresa.isSelected()) {
			empresa = "SI";
		} else {
			empresa = "NO";
		}

		if (registro_usuarios.rdbtnConfiguracion.isSelected()) {
			opciones = "SI";
		} else {
			opciones = "NO";
		}

		if (registro_usuarios.rdbtnUsuarios.isSelected()) {
			usuarios = "SI";
		} else {
			usuarios = "NO";
		}

		if (registro_usuarios.rdbtnAcercaDe.isSelected()) {
			acercade = "SI";
		} else {
			acercade = "NO";
		}
	}

}
