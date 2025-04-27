package es.empresa.torneo.control;

import java.util.ArrayList;
import java.util.List;
import es.empresa.torneo.modelo.Equipo;
import es.empresa.torneo.modelo.Jugador;

public class GestionEquiposYJugadores {

	private static GestionEquiposYJugadores instancia;
	private List<Equipo> equipos;
	private List<Jugador> jugadores;
	
	private GestionEquiposYJugadores() {
		super();
		this.equipos = new ArrayList<Equipo>();
		this.jugadores = new ArrayList<Jugador>();
		
	}
	
	public static GestionEquiposYJugadores of() {
		if (instancia == null) { 
			instancia = new GestionEquiposYJugadores();
		}
		return instancia;
	}
	
	public List<Equipo> getEquipos() {
		return equipos;
	}
	
	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}
	
	public List<Jugador> getJugadores() {
		return jugadores;
	}
	
	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	
	
	
	
	// Métodos propios
	
	@Override
	public String toString() {
		return "GestionEquiposYJugadores [equipos=" + equipos + ", jugadores=" + jugadores + "]";
	}

	/*
	 * Agrega un jugador si no está en la lista
	 */
	public boolean agregaJugador(Jugador jugador) {
		if (this.jugadores.contains(jugador)) return false;
		return this.jugadores.add(jugador);
	}
	
	/*
	 * Agrega un jugador a un equipo si este no está en el equipo 
	 */
	public boolean agregaJugadorAEquipo(Jugador jugador, Equipo equipo) {
		for (Equipo e : equipos) {
			if (e.getNombre().equals(equipo.getNombre()) && !e.getJugadores().contains(jugador) ) {
				e.getJugadores().add(jugador);
				//jugadores.add(jugador);
				// Añadimos el equipo al jugador
				jugador.setEquipo(equipo);
				return true;
			}
		}
		return false;
	}
	
	/*
	 * Agrega un equipo si no está en la lista
	 */
	public boolean agregarEquipo(Equipo equipo) {
		if(this.equipos.contains(equipo)) return false; 
		return this.equipos.add(equipo);
	}
	
}
