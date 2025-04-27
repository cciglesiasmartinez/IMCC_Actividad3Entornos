package es.empresa.torneo.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Partida {

	private List<Equipo> equipos;
	private Map<Equipo, Integer> resultado;
	private Equipo ganador;
	
	
	public Partida() {
		super();
		this.equipos = new ArrayList<Equipo>();
	}
	
	public Partida(List<Equipo> equipos, Map<Equipo, Integer> resultado, Equipo ganador) {
		super();
		this.equipos = equipos;
		this.resultado = resultado;
		this.ganador = ganador;
	}
	
	
	public List<Equipo> getEquipos() {
		return equipos;
	}
	
	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}
	
	public Map<Equipo, Integer> getResultado() {
		return resultado;
	}
	
	public void setResultado(Map<Equipo, Integer> resultado) {
		this.resultado = resultado;
	}
	
	public Equipo getGanador() {
		return ganador;
	}
	
	public void setGanador(Equipo ganador) {
		this.ganador = ganador;
	}
	
	
	@Override
	public String toString() {
		return "Partida [equipos=" + equipos + ", resultado=" + resultado + ", ganador=" + ganador + "]";
	}
	
	
	public boolean agregaEquipo(Equipo equipo) {
		if (equipos.size() < 2) {
			return this.equipos.add(equipo);
		} else {
			return false;
		}
	}
	
	public boolean eliminaEquipo(Equipo equipo) {
		return this.equipos.remove(equipo);
	}
	
	
	// Repensar esto :)
	public boolean ajustaResultado(String nombreEquipo, Integer puntos) {
		
		return false;
	}
	
}
