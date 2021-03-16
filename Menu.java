package gestisimal;

import java.io.IOException;
import java.util.Scanner;

/**
 * Clase utilizada para la gestión de un menu. Se dedica a: Mostrar las opciones
 * del menu y recoger y devolver las opciones de un menu
 * 
 * @author villarroel Molina Jesu David
 */

public class Menu {
	static Scanner entrada = new Scanner(System.in);
	String titulo = null;
	String opciones[] = null;
	int numOpciones = 0;

	public Menu(String titulo, String[] opciones) {
		this.titulo = titulo; /** Titulo del menu */
		this.opciones = opciones; /** OPCIONES DEL MENU */
		this.numOpciones = this.opciones.length;
	}

	public int gestionar() throws NoEsEnteroException, NumberFormatExeption, IOException {
		mostrar(); /* @throws NumberFormatException */
		return recogerOpcion(); /* @throws NoEsEnteroException */
	}

	/* Muestra las opciones del menu */
	private void mostrar() {
		int i = 1;
		System.out.println("***" + titulo + "***");
		for (String elemento : opciones) {
			System.out.println("(" + (i++) + ")" + elemento);
		}
	}

	/**
	 * Recoge la opcion valida del menu
	 * 
	 * @return opcion valida
	 * @throws NoEsEnteroException
	 */
	private int recogerOpcion() {
		int opcion = -1;
		do {
			System.out.println("Introduce una opción válida [1, " + numOpciones + "]");
			opcion = Integer.parseInt(((String) leerCadena()).trim());
		} while (opcion < 1 || opcion > numOpciones);
		return opcion;
	}

	private static Object leerCadena() {
		// TODO Auto-generated method stub
		return entrada.nextLine();
	}
}
