package examenEvalDos.menu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import examenEvalDos.pojo.Gato;
import examenEvalDos.pojo.Mascota;
import examenEvalDos.pojo.Perro;

public class MenuUtils {

	public static final String DATE_PATTERN = "dd-MM-yyyy";
	public static final int MAIN_MENU_MIN = 0;
	public static final int MAIN_MENU_MAX = 6;
	private Scanner teclado = null;

	public MenuUtils() {
		teclado = new Scanner(System.in);
	}

	// -- Menus --//

	public void writeMainMenu() {
		System.out.println("---- MENU ----");
		System.out.println("---- 0 - SALIR ");
		System.out.println("---- 1 - Añadir Mascota");
		System.out.println("---- 2 - Mostrar todas mascotas");
		System.out.println("---- 3 - Modificar mascota");
		System.out.println("---- 4 - Eliminar mascota");
		System.out.println("---- 5 - Eliminar todas las mascota por DNI del dueño");
		System.out.println("---- 6 - Listar mascotas por DNI del dueño");
		System.out.println("--------------");
	}

	public Gato askForGato() {
		Gato ret = new Gato();
		System.out.println("-- Datos del Gato --");
		System.out.print("Nombre - ");
		ret.setNombre(scannerReadString());
		System.out.print("Edad - ");
		ret.setEdad(scannerReadInt());
		System.out.print("Fecha Nacimiento (" + DATE_PATTERN + ")- ");
		ret.setFechaNacimiento(scannerReadDate());
		System.out.print("DNI Dueño - ");
		ret.setDNIDueño(scannerReadString());
		System.out.print("Pelo - ");
		ret.setPelo(scannerReadString());
		System.out.print("Color Pelo - ");
		ret.setColorPelo(scannerReadString());
		System.out.println("----------");
		return ret;
	}

	public Perro askForPerro() {
		Perro ret = new Perro();
		System.out.println("-- Datos del Perro --");
		System.out.print("Nombre - ");
		ret.setNombre(scannerReadString());
		System.out.print("Edad - ");
		ret.setEdad(scannerReadInt());
		System.out.print("Fecha Nacimiento (" + DATE_PATTERN + ") - ");
		ret.setFechaNacimiento(scannerReadDate());
		System.out.print("DNI Dueño - ");
		ret.setDNIDueño(scannerReadString());
		System.out.print("Raza - ");
		ret.setRaza(scannerReadString());
		System.out.print("Pulgas (S, N) - ");
		ret.setPulgas(scannerReadBoolean());
		System.out.println("----------");
		return ret;
	}

	public Mascota alterForPet(Mascota mascota) {
		System.out.println("-- Datos de la mascota --");
		System.out.print("Nombre - ");
		mascota.setNombre(scannerReadString());
		System.out.print("Edad - ");
		mascota.setEdad(scannerReadInt());
		System.out.print("Fecha Nacimiento (" + DATE_PATTERN + ") - ");
		mascota.setFechaNacimiento(scannerReadDate());
		System.out.println("----------");
		return mascota;
	}

	
	public int askCatOrDog() {
		int ret = -1;
		do {
			System.out.println("¿Qué tipo de Mascota? [Perro=0 | Gato=1]");
			ret = scannerReadInt();
		} while ((ret < 0) && (ret > 1));
		return ret;
	}

	public String askPetName() {
		String ret = null;
		System.out.print("Nombre de la mascota - ");
		ret = scannerReadString();
		return ret;
	}

	public String askOwnerDNI() {
		String ret = null;
		System.out.print("Dni del dueño - ");
		ret = scannerReadString();
		return ret;
	}
	
	public void showMascotas(ArrayList<Mascota> mascotas) {
		for (Mascota mascota : mascotas) {
			showMascota(mascota);
		}
	}

	public void showMascota(Mascota mascota) {
		System.out.println(mascota.toString());
	}

	// -- Scanner -- //

	public int scannerReadInt() {
		int ret = 0;
		do {
			try {
				ret = teclado.nextInt();
				teclado.nextLine();
			} catch (Exception e) {
				ret = scannerReset();
			}
		} while (ret < 0);
		return ret;
	}

	public double scannerReadDouble() {
		double ret = 0;
		do {
			try {
				ret = teclado.nextDouble();
				teclado.nextLine();
			} catch (Exception e) {
				ret = scannerReset();
			}
		} while (ret < 0);
		return ret;
	}

	public String scannerReadString() {
		String ret = null;
		try {
			ret = teclado.nextLine();
		} catch (Exception e) {
			scannerReset();
		}
		return ret;
	}

	public boolean scannerReadBoolean() {
		boolean ret = false;
		try {
			String text = teclado.nextLine();
			ret = text.equalsIgnoreCase("S") ? true : false;
		} catch (Exception e) {
			scannerReset();
		}
		return ret;
	}

	public Date scannerReadDate() {
		Date ret = null;
		try {
			String unparsedDate = teclado.nextLine();
			ret = (new SimpleDateFormat(DATE_PATTERN)).parse(unparsedDate);
		} catch (ParseException e) {
			System.out.print("ERROR - Fecha no se puede parsear");
		} catch (Exception e) {
			scannerReset();
		}
		return ret;
	}
	
	public int scannerReset() {
		teclado.nextLine();
		return -1;
	}
}
