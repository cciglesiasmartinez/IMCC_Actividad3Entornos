package es.empresa.torneo.modelo;

public class Premio {
	
	private String nombre;
	
	public Premio() {
		super();
	}
	
	public Premio(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Premio [nombre=" + nombre + "]";
	}
	
}
