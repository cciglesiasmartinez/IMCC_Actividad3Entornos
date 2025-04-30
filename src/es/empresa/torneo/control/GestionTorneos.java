package es.empresa.torneo.control;

import java.util.ArrayList;
import java.util.List;
import es.empresa.torneo.modelo.Equipo;
import es.empresa.torneo.modelo.Jugador;
import es.empresa.torneo.modelo.Partida;
import es.empresa.torneo.modelo.Torneo;

/**
 * Clase controladora para la gestión de torneos.
 * 
 * Gestiona la creación de torneos, la inscripción de equipos y  la generación de emparejamientos de partidas 
 * entre los equipos participantes. Implementa el patrón Singleton para garantizar una única instancia de 
 * gestión de torneos.
 * 
 * Esta clase maneja principalmente tres listas, una lista de torneos, una lista de equipos general
 * (para todos los torneos) y una lista de jugadores (para todos los equipos y todos los torneos).
 * 
 * @author cciglesiasmartinez
 */

public class GestionTorneos {

	private static GestionTorneos instancia;
	private List<Torneo> torneos;
	private List<Equipo> equipos;
	private List<Jugador> jugadores;
	
	/**
	 * Constructor privado para implementar el patrón Singleton
	 */
	private GestionTorneos() {
		super();
		this.torneos = new ArrayList<Torneo>();
		this.equipos = new ArrayList<Equipo>();
		this.jugadores = new ArrayList<Jugador>();
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
	 * Obtiene la lista de equipos registrados en el torneo.
	 * 
	 * @return lista de equipos.
	 */
	public List<Equipo> getEquipos() {
	    return equipos;
	}

	/**
	 * Establece la lista de equipos participantes en el torneo.
	 * 
	 * @param equipos lista de equipos a asignar.
	 */
	public void setEquipos(List<Equipo> equipos) {
	    this.equipos = equipos;
	}

	/**
	 * Obtiene la lista de jugadores inscritos en el torneo.
	 * 
	 * @return lista de jugadores.
	 */
	public List<Jugador> getJugadores() {
	    return jugadores;
	}

	/**
	 * Establece la lista de jugadores participantes en el torneo.
	 * 
	 * @param jugadores lista de jugadores a asignar.
	 */
	public void setJugadores(List<Jugador> jugadores) {
	    this.jugadores = jugadores;
	}
	
	/**
	 * Agrega un jugador si este no está registrado previamente en la lista interna del controlador
	 * 
	 * @param jugador el jugador que será añadido
	 * @return {@code true} si ha podido ser añadido, {@code false} si el jugador ya está inscrito
	 */
	public boolean agregaJugador(Jugador jugador) {
		if (this.jugadores.contains(jugador)) return false;
		return this.jugadores.add(jugador);
	}
	
	/**
	 * Agrega un jugador a un equipo si este no está inscrito ya
	 * 
	 * @param jugador el jugador al que queremos añadir
	 * @param equipo el equipo donde queremos añadir a este jugador
	 * @return {@code true} si el jugador ha podido ser inscrito, {@code false} 
	 */
	public boolean agregaJugadorAEquipo(Jugador jugador, Equipo equipo) {
		for (Equipo e : equipos) {
			if (e.getNombre().equals(equipo.getNombre()) && !e.getJugadores().contains(jugador) ) {
				e.getJugadores().add(jugador);
				jugadores.add(jugador);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Agrega un equipo a la lista general
	 * 
	 * @param equipo el equipo que vamos a agregar
	 * @return {@code true} si el equipo se ha añadido, {@code false} si ya existía dicho equipo
	 */
	public boolean agregarEquipo(Equipo equipo) {
		if(this.equipos.contains(equipo)) return false; 
		return this.equipos.add(equipo);
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
	 * Empareja los equipos inscritos si es la primera ronda, o los clasificados si se trata de rondas posteriores.
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
	
	/**
	 * Método para actualizar la clasificación de torneos
	 * 
	 * @param torneo El torneo sobre el cual se desea ejecutar 
	 * @return {@code true} si se actualiza correctamente y {@code false} si el torneo no se encuentra en la lista
	 */
	public boolean actualizaClasificacionTorneo(Torneo torneo) {
		for (Torneo t: this.torneos) {
			if (t.getNombre().equals(torneo.getNombre())) {
				// Es necesario comprobar que todas las partidas tienen un ganador antes de esto :)
				// Borrar la lista de clasificados actual
				t.getClasificados().clear();
				// Recorrer las partidas del último emparejamiento
				for (Partida p: t.getEmparejamientos().get(t.getEmparejamientos().size()-1)) {
					t.getClasificados().add(p.getGanador());
				}
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Este método registra el resultado de una partida; es decir, registra uno de los equipos como ganador de la misma.
	 * 
	 * @param torneo El torneo al que pertence la partida
	 * @param partida La partida que queremos actualizar
	 * @param ganador El ganador de la partida
	 * @return {@code true} si se ha actualizado correctamente el resultado, y {@code false} si es que no se ha encontrado la partida o el torneo 
	 */
	public boolean registrarResultadoPartida(Torneo torneo, Partida partida, Equipo ganador) {
		for (Torneo t: this.torneos) {
			if (t.getNombre().equals(torneo.getNombre())) {
				// Busca la partida en la última ronda de emparejamientos. Refactorizar.
				for (Partida p: t.getEmparejamientos().get(t.getEmparejamientos().size()-1)) {
					// Comprueba si la partida es la que buscamos
					if ((p.getEquipos().get(0).getNombre().equals(partida.getEquipos().get(0).getNombre())) 
							&& (p.getEquipos().get(1).getNombre().equals(partida.getEquipos().get(1).getNombre()))) {
						p.setGanador(ganador);
						return true;
					}
				}
			}
		}
		return false;
	}
	
}
