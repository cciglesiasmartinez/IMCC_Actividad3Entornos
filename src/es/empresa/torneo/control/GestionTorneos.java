package es.empresa.torneo.control;

import java.util.ArrayList;
import java.util.List;

import es.empresa.torneo.modelo.Equipo;
import es.empresa.torneo.modelo.Partida;
import es.empresa.torneo.modelo.Torneo;

public class GestionTorneos {

	private static GestionTorneos instancia;
	private List<Torneo> torneos;
	
	private GestionTorneos() {
		super();
		this.torneos = new ArrayList<Torneo>();
	}
	
	public static GestionTorneos of() {
		if (instancia == null ) {
			instancia = new GestionTorneos();
		}
		return instancia;
	}

	public List<Torneo> getTorneos() {
		return torneos;
	}

	public void setTorneos(List<Torneo> torneos) {
		this.torneos = torneos;
	}

	/*
	 * Crea un torneo
	 */
	public boolean crearUnTorneo(Torneo torneo) {
		if (this.torneos.contains(torneo)) return false;
		return this.torneos.add(torneo);
	}
	
	/*
	 * Agrega equipo a torneo si torneo existe y el equipo no se encuentra ya inscrito
	 */
	public boolean inscribirEquipoEnTorneo(Equipo equipo, Torneo torneo) {
		for (Torneo t: this.torneos) {
			if (t.getNombre().equals(torneo.getNombre()) && !t.getEquipos().contains(equipo) ) {
				return t.getEquipos().add(equipo);
			}
		}
		return false;
	}
	
	/* Genera los emparejamientos 
	 * Pendiente de refactorizar, se puede extraer al menos un método de ayuda para hacer
	 * el emparejamiento en sí, puesto que hay código repetido.
	 */
	public boolean generaEmparejamientos(Torneo torneo) {
		for (Torneo t: this.torneos) {
			// Comprobamos si el torneo existe previamente y si el número de equipos es par
			if (t.getNombre().equals(torneo.getNombre()) && (t.getEquipos().size() % 2 == 0)) {
				List<Partida> emparejamientos = new ArrayList<Partida>();
				// Comprobamos si hay clasificados previamente o es la primera ronda
				System.out.println("ESTaMOS AQUI");
				if (t.getClasificados().size() == 0) {
					System.out.println("DENTRO DEL IF");
					for (int i = 0; i < t.getEquipos().size()-1; i+=2) {
						System.out.println("ESTAMOS AQUI");
						Partida partida = new Partida();
						partida.agregaEquipo(t.getEquipos().get(i));
						partida.agregaEquipo(t.getEquipos().get(i+1));
						t.getPartidas().add(partida);
						emparejamientos.add(partida);
					}
					t.getEmparejamientos().add(emparejamientos);
					return true;
				}
				// Si no es la primera ronda, acudimos a los clasificados para emparejar
				else {
					for (int i = 0; i < t.getClasificados().size()-1; i+=2) {
						Partida partida = new Partida();
						partida.agregaEquipo(t.getClasificados().get(i));
						partida.agregaEquipo(t.getClasificados().get(i+1));
						t.getPartidas().add(partida);
						emparejamientos.add(partida);
					}
					t.getEmparejamientos().add(emparejamientos);
					return true;
				}
			}
		}
		return false;
	}
	
}
