package clases;

public class usuario {

	private String usuario;
	private String contrase�a;

	public usuario(String usuario, String contrase�a) {
		this.usuario = usuario;
		this.contrase�a = contrase�a;
	}

	public usuario() {

	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

}
