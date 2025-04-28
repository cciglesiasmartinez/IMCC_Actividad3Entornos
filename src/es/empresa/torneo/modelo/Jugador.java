package es.empresa.torneo.modelo;

public class Jugador {

	private String nombre;

	public Jugador() {
		super();
	}
	
	public Jugador(String nombre, Equipo equipo) {
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
		return "Jugador [nombre=" + nombre + "]";
	}
	
	
}
