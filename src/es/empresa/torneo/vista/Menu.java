package es.empresa.torneo.vista;

import java.util.Scanner;

public class Menu {
	
	public static Scanner entradaTeclado = new Scanner(System.in);
	
	public static void mostrarMenu() {
		System.out.println("Aplicación para la gestión de torneos e-Sports");
		System.out.println("\n");
		System.out.println("1. Torneos");
		System.out.println("2. Equipos");
		System.out.println("3. Jugadores");
		System.out.println("4. Resultados");
		System.out.println("\n");
		System.out.println("Por favor, escoge una opción");
		Integer opcion = entradaTeclado.nextInt();
		procesarMenu(opcion);
	}
	
	public static void procesarMenu(Integer opcion) {
		switch(opcion) {
			case(1):
				mostrarSubmenuTorneos();
				break;
			default:
				System.out.println("Opción no disponible\n");
				break;
			}
	}
	
	public static void mostrarSubmenuTorneos() {
		System.out.println("Submenú de torneos\n");
		mostrarMenu();
	}
}
