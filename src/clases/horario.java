package clases;

public class horario {
	
	int id_horario;
	String tipo_horario;   
	String hora_inicio_horario;
	String hora_final_horario;
	String dias_horario;
	String descripcion_horario;
	String observacion_horario;
	
	
	    public horario(int id_horario, String tipo_horario, String hora_inicio_horario, String hora_final_horario,
			String dias_horario, String descripcion_horario, String observacion_horario) {
		super();
		this.id_horario = id_horario;
		this.tipo_horario = tipo_horario;
		this.hora_inicio_horario = hora_inicio_horario;
		this.hora_final_horario = hora_final_horario;
		this.dias_horario = dias_horario;
		this.descripcion_horario = descripcion_horario;
		this.observacion_horario = observacion_horario;
	}
	public int getId_horario() {
		return id_horario;
	}
	public void setId_horario(int id_horario) {
		this.id_horario = id_horario;
	}
	
	public String getTipo_horario() {
		return tipo_horario;
	}
	public void setTipo_horario(String tipo_horario) {
		this.tipo_horario = tipo_horario;
	}
	public String getHora_inicio_horario() {
		return hora_inicio_horario;
	}
	public void setHora_inicio_horario(String hora_inicio_horario) {
		this.hora_inicio_horario = hora_inicio_horario;
	}
	public String getHora_final_horario() {
		return hora_final_horario;
	}
	public void setHora_final_horario(String hora_final_horario) {
		this.hora_final_horario = hora_final_horario;
	}
	public String getDias_horario() {
		return dias_horario;
	}
	public void setDias_horario(String dias_horario) {
		this.dias_horario = dias_horario;
	}
	public String getDescripcion_horario() {
		return descripcion_horario;
	}
	public void setDescripcion_horario(String descripcion_horario) {
		this.descripcion_horario = descripcion_horario;
	}
	public String getObservacion_horario() {
		return observacion_horario;
	}
	public void setObservacion_horario(String observacion_horario) {
		this.observacion_horario = observacion_horario;
	}
	
	

}
