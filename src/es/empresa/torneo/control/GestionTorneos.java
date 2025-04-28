package es.empresa.torneo.control;

import java.util.ArrayList;
import java.util.List;
import es.empresa.torneo.modelo.Equipo;
import es.empresa.torneo.modelo.Partida;
import es.empresa.torneo.modelo.Torneo;

/**
 * Clase controladora para la gestión de torneos.
 * 
 * Gestiona la creación de torneos, la inscripción de equipos y  la generación de emparejamientos de partidas 
 * entre los equipos participantes. Implementa el patrón Singleton para garantizar una única instancia de 
 * gestión de torneos.
 * 
 * @author cciglesiasmartinez
 */

public class GestionTorneos {

	private static GestionTorneos instancia;
	private List<Torneo> torneos;
	
	/**
	 * Constructor privado para implementar el patrón Singleton
	 */
	private GestionTorneos() {
		super();
		this.torneos = new ArrayList<Torneo>();
	}
	
    /**
     * Obtiene la instancia única de {@code GestionTorneos}.
     * 
     * @return instancia única de {@code GestionTorneos}
     */
	public static GestionTorneos getInstance() {
		if (instancia == null ) {
			instancia = new GestionTorneos();
		}
		return instancia;
	}

    /**
     * Obtiene la lista de torneos gestionados.
     * 
     * @return lista de torneos
     */
	public List<Torneo> getTorneos() {
		return torneos;
	}

    /**
     * Establece la lista de torneos gestionados.
     * 
     * @param torneos nueva lista de torneos
     */
	public void setTorneos(List<Torneo> torneos) {
		this.torneos = torneos;
	}


    /**
     * Crea un nuevo torneo si no existe previamente.
     * 
     * @param torneo torneo a crear
     * @return {@code true} si el torneo fue creado, {@code false} si ya existía
     */
	public boolean crearUnTorneo(Torneo torneo) {
		if (this.torneos.contains(torneo)) return false;
		return this.torneos.add(torneo);
	}
	
    /**
     * Inscribe un equipo en un torneo existente, siempre que el equipo no esté ya inscrito.
     * 
     * @param equipo equipo a inscribir
     * @param torneo torneo donde inscribir el equipo
     * @return {@code true} si el equipo fue inscrito, {@code false} si el torneo no existe o el equipo ya estaba inscrito
     */
	public boolean inscribirEquipoEnTorneo(Equipo equipo, Torneo torneo) {
		for (Torneo t: this.torneos) {
			if (t.getNombre().equals(torneo.getNombre()) && !t.getEquipos().contains(equipo) ) {
				return t.getEquipos().add(equipo);
			}
		}
		return false;
	}
	
    /**
     * Genera los emparejamientos de partidas para un torneo determinado.
     * 
     *Empareja los equipos inscritos si es la primera ronda, o los clasificados si se trata de rondas posteriores.
     * 
     * @param torneo torneo para el que generar los emparejamientos
     * @return {@code true} si se generaron emparejamientos correctamente, {@code false} en caso contrario
     */
	public boolean generaEmparejamientos(Torneo torneo) {
		for (Torneo t: this.torneos) {
			// Comprobamos si el torneo existe previamente y si el número de equipos es par
			if (t.getNombre().equals(torneo.getNombre()) && (t.getEquipos().size() % 2 == 0)) {
				List<Partida> emparejamientos = new ArrayList<Partida>();
				// Comprobamos si hay clasificados previamente o es la primera ronda
				if (t.getClasificados().size() == 0) {
					emparejaListasEnTorneo(t, t.getEquipos(), emparejamientos);
				}
				// Si no es la primera ronda, acudimos a los clasificados para emparejar
				else {
					emparejaListasEnTorneo(t, t.getClasificados(), emparejamientos);
				}
				t.getEmparejamientos().add(emparejamientos);
				return true;
			}
		}
		return false;
	}
	
    /**
     * Método auxiliar que empareja equipos en partidas de dos en dos.
     * 
     * @param t torneo en el que añadir las partidas
     * @param listaEquipos lista de equipos a emparejar
     * @param emparejamientos lista donde se añadirán las nuevas partidas generadas
     */
	public void emparejaListasEnTorneo(Torneo t, List<Equipo> listaEquipos, List<Partida> emparejamientos) {
	    for (int i = 0; i < listaEquipos.size()-1; i += 2) {
	        Partida partida = new Partida();
	        partida.agregaEquipo(listaEquipos.get(i));
	        partida.agregaEquipo(listaEquipos.get(i+1));
	        emparejamientos.add(partida);
	    }
	}
	
}
