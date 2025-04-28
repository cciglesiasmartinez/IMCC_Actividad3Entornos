package testing;

import es.empresa.torneo.control.GestionEquiposYJugadores;
import es.empresa.torneo.control.GestionTorneos;
import es.empresa.torneo.modelo.Equipo;
import es.empresa.torneo.modelo.Jugador;
import es.empresa.torneo.modelo.Torneo;

public class TestGeneral {

	public static void main(String[] args) {

		Equipo inglaterra = new Equipo();
		inglaterra.setNombre("Inglaterra");
		Jugador jugador1 = new Jugador();
		jugador1.setNombre("Alice");
		Jugador jugador2 = new Jugador();
		jugador2.setNombre("Bob");
		
		Equipo españa = new Equipo();
		españa.setNombre("España");
		Jugador jugador3 = new Jugador();
		jugador3.setNombre("Carlos");
		Jugador jugador4 = new Jugador();
		jugador4.setNombre("Diana");
		
		Equipo francia = new Equipo();
		francia.setNombre("Francia");
		Jugador jugador5 = new Jugador();
		jugador5.setNombre("Eva");
		Jugador jugador6 = new Jugador();
		jugador6.setNombre("François");
		
		Equipo alemania = new Equipo();
		alemania.setNombre("Alemania");
		Jugador jugador7 = new Jugador();
		jugador7.setNombre("George");
		Jugador jugador8 = new Jugador();
		jugador8.setNombre("Helga");
		
		Equipo italia = new Equipo();
		italia.setNombre("Italia");
		Jugador jugador9 = new Jugador();
		jugador9.setNombre("Isabella");
		Jugador jugador10 = new Jugador();
		jugador10.setNombre("Luca");
		
		Equipo portugal = new Equipo();
		portugal.setNombre("Portugal");
		Jugador jugador11 = new Jugador();
		jugador11.setNombre("Marta");
		Jugador jugador12 = new Jugador();
		jugador12.setNombre("Nuno");
		
		// Invocamos la clase de gestión
		GestionEquiposYJugadores gestionEquipos = GestionEquiposYJugadores.getInstance();
		
		// Agregar jugadores al sistema
		System.out.println(gestionEquipos.agregaJugador(jugador1));
		System.out.println(gestionEquipos.agregaJugador(jugador2));
		System.out.println(gestionEquipos.agregaJugador(jugador3));
		System.out.println(gestionEquipos.agregaJugador(jugador4));
		System.out.println(gestionEquipos.agregaJugador(jugador5));
		System.out.println(gestionEquipos.agregaJugador(jugador6));
		System.out.println(gestionEquipos.agregaJugador(jugador7));
		System.out.println(gestionEquipos.agregaJugador(jugador8));
		System.out.println(gestionEquipos.agregaJugador(jugador9));
		System.out.println(gestionEquipos.agregaJugador(jugador10));
		System.out.println(gestionEquipos.agregaJugador(jugador11));
		System.out.println(gestionEquipos.agregaJugador(jugador12));

		// Agregar equipos al sistema
		System.out.println(gestionEquipos.agregarEquipo(inglaterra));
		System.out.println(gestionEquipos.agregarEquipo(españa));
		System.out.println(gestionEquipos.agregarEquipo(francia));
		System.out.println(gestionEquipos.agregarEquipo(alemania));
		System.out.println(gestionEquipos.agregarEquipo(italia));
		System.out.println(gestionEquipos.agregarEquipo(portugal));
		
		// Agregar jugadores a los equipos
		System.out.println(gestionEquipos.agregaJugadorAEquipo(jugador1, inglaterra));
		System.out.println(gestionEquipos.agregaJugadorAEquipo(jugador2, inglaterra));

		System.out.println(gestionEquipos.agregaJugadorAEquipo(jugador3, españa));
		System.out.println(gestionEquipos.agregaJugadorAEquipo(jugador4, españa));

		System.out.println(gestionEquipos.agregaJugadorAEquipo(jugador5, francia));
		System.out.println(gestionEquipos.agregaJugadorAEquipo(jugador6, francia));

		System.out.println(gestionEquipos.agregaJugadorAEquipo(jugador7, alemania));
		System.out.println(gestionEquipos.agregaJugadorAEquipo(jugador8, alemania));

		System.out.println(gestionEquipos.agregaJugadorAEquipo(jugador9, italia));
		System.out.println(gestionEquipos.agregaJugadorAEquipo(jugador10, italia));

		System.out.println(gestionEquipos.agregaJugadorAEquipo(jugador11, portugal));
		System.out.println(gestionEquipos.agregaJugadorAEquipo(jugador12, portugal));	

		
		System.out.println(gestionEquipos.toString());
		
		System.out.println(gestionEquipos.getJugadores().get(0).getEquipo());
		
		
		// Invocamos la clase de gestión de torneos
		GestionTorneos gestionTorneos = GestionTorneos.getInstance();
		
		Torneo eligaEuropa = new Torneo();
		eligaEuropa.setNombre("E-Liga Europa");
		
		System.out.println(gestionTorneos.crearUnTorneo(eligaEuropa));
		System.out.println(gestionTorneos.inscribirEquipoEnTorneo(inglaterra, eligaEuropa));
		System.out.println(gestionTorneos.inscribirEquipoEnTorneo(españa, eligaEuropa));
		System.out.println(gestionTorneos.inscribirEquipoEnTorneo(francia, eligaEuropa));
		System.out.println(gestionTorneos.inscribirEquipoEnTorneo(alemania, eligaEuropa));
		System.out.println(gestionTorneos.inscribirEquipoEnTorneo(italia, eligaEuropa));
		System.out.println(gestionTorneos.inscribirEquipoEnTorneo(portugal, eligaEuropa));
		System.out.println(gestionTorneos.generaEmparejamientos(eligaEuropa));
		System.out.println(gestionTorneos.getTorneos().get(0).getEmparejamientos());
		
	}

}
