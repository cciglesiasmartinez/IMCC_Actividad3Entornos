package es.empresa.torneo.vista;

import java.util.Scanner;

import es.empresa.torneo.control.GestionTorneos;

public class Menu {
	
	public static Scanner entradaTeclado = new Scanner(System.in);
	public static GestionTorneos gestionTorneos = GestionTorneos.getInstance();
	
	public static void procesarMenu() {
		System.out.println("> Aplicación para la gestión de torneos e-Sports");
		System.out.println("");
		System.out.println("1. Torneos");
		System.out.println("2. Equipos");
		System.out.println("3. Jugadores");
		System.out.println("4. Resultados");
		System.out.println("");
		System.out.println("Por favor, escoge una opción: ");
		Integer opcion = entradaTeclado.nextInt();
		switch(opcion) {
			case(1):
				procesarSubmenuTorneos();
				break;
			default:
				System.out.println("Opción no disponible\n");
				procesarMenu();
				break;
		}
	}
	
	public static void procesarSubmenuTorneos() {
		System.out.println("> Submenú de torneos");
		System.out.println("");
		System.out.println("1. Listar torneos");
		System.out.println("");
		System.out.println("Por favor, escoge una opción: ");
		Integer opcion = entradaTeclado.nextInt();
		switch(opcion) {
			case(1):
				System.out.println("Lista de torneos activos: ");
				System.out.println(gestionTorneos.getTorneos().toString() + "\n");
				break;
			default:
				System.out.println("Opción no disponible.");
				break;
		}
		procesarMenu();
	}
	
	public static void procesarSubmenuEquipos() {
		System.out.println("> Submenú de equipos");
		System.out.println("");
		System.out.println("1. Mostrar equipos");
		System.out.println("2. Registrar");
	}
}
