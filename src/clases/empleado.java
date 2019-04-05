package clases;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Date;

public class empleado {

	int id_empleado;
	String nombres_empleado;
	String apellidos_empleado;
	String identidad_empleado;
	String genero_empleado;
	int edad_empleado;
	String telefono_empleado;
	String correo_empleado;
	String direccion_empleado;
	String direccion_foto_empleado;
	String referencia_empleado;
	String telefono_referencia;
	String fecha_nacimiento_empleado;
	String fecha_registro_empleado;
	String fecha_inicio_labores_empleado;
	String estado_empleado;

	public int getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}

	public String getNombres_empleado() {
		return nombres_empleado;
	}

	public void setNombres_empleado(String nombres_empleado) {
		this.nombres_empleado = nombres_empleado;
	}

	public String getApellidos_empleado() {
		return apellidos_empleado;
	}

	public void setApellidos_empleado(String apellidos_empleado) {
		this.apellidos_empleado = apellidos_empleado;
	}

	public String getIdentidad_empleado() {
		return identidad_empleado;
	}

	public void setIdentidad_empleado(String identidad_empleado) {
		this.identidad_empleado = identidad_empleado;
	}

	public String getGenero_empleado() {
		return genero_empleado;
	}

	public void setGenero_empleado(String genero_empleado) {
		this.genero_empleado = genero_empleado;
	}

	public int getEdad_empleado() {
		return edad_empleado;
	}

	public void setEdad_empleado(int edad_empleado) {
		this.edad_empleado = edad_empleado;
	}

	public String getTelefono_empleado() {
		return telefono_empleado;
	}

	public void setTelefono_empleado(String telefono_empleado) {
		this.telefono_empleado = telefono_empleado;
	}

	public String getCorreo_empleado() {
		return correo_empleado;
	}

	public void setCorreo_empleado(String correo_empleado) {
		this.correo_empleado = correo_empleado;
	}

	public String getDireccion_empleado() {
		return direccion_empleado;
	}

	public void setDireccion_empleado(String direccion_empleado) {
		this.direccion_empleado = direccion_empleado;
	}
	

	public String getDireccion_foto_empleado() {
		return direccion_foto_empleado;
	}

	public void setDireccion_foto_empleado(String direccion_foto_empleado) {
		this.direccion_foto_empleado = direccion_foto_empleado;
	}

	public String getReferencia_empleado() {
		return referencia_empleado;
	}

	public void setReferencia_empleado(String referencia_empleado) {
		this.referencia_empleado = referencia_empleado;
	}

	public String getTelefono_referencia() {
		return telefono_referencia;
	}

	public void setTelefono_referencia(String telefono_referencia) {
		this.telefono_referencia = telefono_referencia;
	}

	public String getFecha_nacimiento_empleado() {
		return fecha_nacimiento_empleado;
	}

	public void setFecha_nacimiento_empleado(String fecha_nacimiento_empleado) {
		this.fecha_nacimiento_empleado = fecha_nacimiento_empleado;
	}

	public String getFecha_registro_empleado() {
		return fecha_registro_empleado;
	}

	public void setFecha_registro_empleado(String fecha_registro_empleado) {
		this.fecha_registro_empleado = fecha_registro_empleado;
	}

	public String getFecha_inicio_labores_empleado() {
		return fecha_inicio_labores_empleado;
	}

	public void setFecha_inicio_labores_empleado(String fecha_inicio_labores_empleado) {
		this.fecha_inicio_labores_empleado = fecha_inicio_labores_empleado;
	}

	public String getEstado_empleado() {
		return estado_empleado;
	}

	public void setEstado_empleado(String estado_empleado) {
		this.estado_empleado = estado_empleado;
	}

}
