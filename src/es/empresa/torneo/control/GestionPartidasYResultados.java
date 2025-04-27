package es.empresa.torneo.control;

import es.empresa.torneo.modelo.Equipo;
import es.empresa.torneo.modelo.Partida;
import es.empresa.torneo.modelo.Torneo;

public class GestionPartidasYResultados {
	
	private static GestionPartidasYResultados instancia;
	
	private GestionPartidasYResultados() {
		super();
	}
	
	public static GestionPartidasYResultados of() {
		if (instancia == null) {
			instancia = new GestionPartidasYResultados();
		}
		return instancia;
	}
	
	/* Registrar resultado de una partida */
	public boolean registrarResultadoPartida(Torneo torneo, Partida partida, Equipo ganador) {
		GestionTorneos gestionTorneos = GestionTorneos.of();
		for(Torneo t: gestionTorneos.getTorneos()) {
			if (t.getNombre().equals(torneo.getNombre())) {
				/*
				 *  Busca la partida en la última ronda de emparejamientos. Esto debe ser
				 *  refactorizado.
				 */
				for (Partida p: t.getEmparejamientos().get(t.getEmparejamientos().size()-1)) {
					if ((p.getEquipos().get(0).getNombre().equals(partida.getEquipos().get(0).getNombre())) 
							&& (p.getEquipos().get(1).getNombre().equals(partida.getEquipos().get(1).getNombre()))) {
						p.setGanador(ganador);
					}
				}
				return true;
			}
		}
		return false;
	}
	
	/* Actualiza la clasificación del torneo */
	public boolean actualizaClasificacionTorneo(Torneo torneo) {
		GestionTorneos gestionTorneos = GestionTorneos.of();
		for(Torneo t: gestionTorneos.getTorneos()) {
			if (t.getNombre().equals(torneo.getNombre())) {
				/*
				 * Habría que verificar que todas las partidas tienen un ganador antes de hacer esto (:
				 */
				t.getClasificados().clear();
				// Recorremos las partidas del último emparejamiento
				for (Partida p: t.getEmparejamientos().get(t.getEmparejamientos().size()-1)) {
					t.getClasificados().add(p.getGanador());
				}
			}
		}
		return false;
	}

}
