package es.empresa.torneo.modelo;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
	
	private String nombre;
	private List<Jugador> jugadores;

	public Equipo() {
		super();
		this.jugadores = new ArrayList<Jugador>();
	}
	
	public Equipo(String nombre, List<Jugador> jugadores) {
		super();
		this.nombre = nombre;
		this.jugadores = jugadores;
	}
	
	// Getter & Setter
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Jugador> getJugadores() {
		return jugadores;
	}
	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	@Override
	public String toString() {
		return "Equipo [nombre=" + nombre + ", jugadores=" + jugadores + "]";
	}
	
	// Métodos propios
	public boolean agregaJugador(Jugador jugador) {
		return this.jugadores.add(jugador);
	}
	
	public boolean borraJugador(Jugador jugador) {
		return this.jugadores.remove(jugador);
	}
}
