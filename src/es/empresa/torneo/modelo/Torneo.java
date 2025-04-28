package es.empresa.torneo.modelo;

import java.util.ArrayList;
import java.util.List;

public class Torneo {
	
	private String nombre;
	private List<Equipo> equipos;
	private List<List<Partida>> emparejamientos;
	private List<Equipo> clasificados;
	private Equipo ganador;
	
	public Torneo() {
		super();
		this.equipos = new ArrayList<Equipo>();
		this.clasificados = new ArrayList<Equipo>();
		this.emparejamientos = new ArrayList<List<Partida>>();
	}

	public Torneo(String nombre, List<Equipo> equipos, List<List<Partida>> emparejamientos, List<Partida> partidas,
			Equipo ganador) {
		super();
		this.nombre = nombre;
		this.equipos = equipos;
		this.emparejamientos = emparejamientos;
		this.ganador = ganador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}

	public List<List<Partida>> getEmparejamientos() {
		return emparejamientos;
	}

	public void setEmparejamientos(List<List<Partida>> emparejamientos) {
		this.emparejamientos = emparejamientos;
	}

	public Equipo getGanador() {
		return ganador;
	}

	public void setGanador(Equipo ganador) {
		this.ganador = ganador;
	}

	public List<Equipo> getClasificados() {
		return clasificados;
	}

	public void setClasificados(List<Equipo> clasificados) {
		this.clasificados = clasificados;
	}

	@Override
	public String toString() {
		return "Torneo [nombre=" + nombre + ", equipos=" + equipos + ", emparejamientos=" + emparejamientos
				 + ", ganador=" + ganador + "]";
	}
	
	
}
