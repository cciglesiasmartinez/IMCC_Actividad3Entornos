package es.empresa.torneo.modelo;

public class Jugador {

	private String nombre;
	private Equipo equipo;

	public Jugador() {
		super();
	}
	
	public Jugador(String nombre, Equipo equipo) {
		super();
		this.nombre = nombre;
		this.equipo = equipo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Equipo getEquipo() {
		return equipo;
	}
	
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	
	
	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + "]";
	}
	
	
}
