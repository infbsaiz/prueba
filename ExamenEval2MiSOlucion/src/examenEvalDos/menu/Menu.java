package examenEvalDos.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;

import examenEvalDos.pojo.Gato;
import examenEvalDos.pojo.Mascota;
import examenEvalDos.pojo.Perro;

public class Menu {

	private ArrayList<Mascota> mascotas = null;
	private MenuUtils menuUtils = null;

	@SuppressWarnings("deprecation")
	public Menu() {
		Perro p1 = new Perro("Lur", 2, new Date(118, 9, 6), "12345679K", "Pastor alemán", false);
		Perro p2 = new Perro("Beethoven", 3, new Date(118, 2, 1), "56478936G", "San bernardo", true);
		Perro p3 = new Perro("Pongo", 4, new Date(116, 5, 1), "78965847F", "Dalmata", false);
		Gato g1 = new Gato("Baltzi", 10, new Date(109, 6, 1), "12345679K", "L", "Negro");
		Gato g2 = new Gato("Bola", 4, new Date(115, 1, 31), "14785469S", "C", "Tricolor (calicó)");
		Gato g3 = new Gato("Garfield", 6, new Date(112, 7, 31), "12345679K", "M", "Naranja");
		mascotas = new ArrayList<>(Arrays.asList(p1, g1, p2, p3, g2, g3));
		menuUtils = new MenuUtils();
	}

	public void iniciar() {
		int opcion = 0;
		do {
			opcion = opcionMenu();
			if (opcion != 0) {
				ejecutarOpcionMenu(opcion);
				System.out.println(" ");
			}
		} while (opcion != 0);
		System.out.print("Adios!!!");
	}

	private int opcionMenu() {
		int ret = 0;
		do {
			try {
				menuUtils.writeMainMenu();
				System.out.print("Elija una opcion: ");
				ret = menuUtils.scannerReadInt();
			} catch (Exception e) {
				ret = menuUtils.scannerReset();
			}
		} while ((ret < MenuUtils.MAIN_MENU_MIN) && (ret > MenuUtils.MAIN_MENU_MAX));
		return ret;
	}

	private void ejecutarOpcionMenu(int opcion) {
		switch (opcion) {
		case 1:
			anadirMascota();
			break;
		case 2:
			mostrarTodasMascotas();
			break;
		case 3:
			modificarMascota();
			break;
		case 4:
			eliminarMascota();
			break;
		case 5:
			eliminarTodasMascotasPorDueno();
			break;
		case 6:
			listarMascotaPorDueno();
			break;
		default:
			System.out.println("ADIOS!!!");
			break;
		}
	}

	private void anadirMascota() {
		System.out.println("Introduzca nueva mascota...");
		int type = menuUtils.askCatOrDog();
		Mascota mascota = null;
		if (type == 0) {
			mascota = menuUtils.askForPerro();
		} else {
			mascota = menuUtils.askForGato();
		}
		mascotas.add(mascota);
	}

	private void mostrarTodasMascotas() {
		System.out.println("Mostrando todas las mascotas...");
		menuUtils.showMascotas(mascotas);
	}

	private void modificarMascota() {
		System.out.println("Modificando mascota...");
		String nombre = menuUtils.askPetName();
		Mascota mascota = findPetName(nombre);
		if (null == mascota) {
			System.out.println("La mascota " + nombre + " no existe...");
		} else {
			menuUtils.alterForPet(mascota);
		}
	}

	private void eliminarMascota() {
		System.out.println("Eliminando mascota...");
		String nombreMascota = menuUtils.askPetName();
		if (remove(nombreMascota)) {
			System.out.println("Eliminada...");
		} else {
			System.out.println(nombreMascota + " no existe");
		}
	}

	private void eliminarTodasMascotasPorDueno() {
		System.out.println("Eliminando mascota por dueño...");
		System.out.println("Buscar mascota por dueño...");
		String dni = menuUtils.askOwnerDNI();
		int removed = removeAll(dni);
		if (removed <= 0) {
			System.out.println("El dueño " + dni + " no tenía mascotas");
		} else
			System.out.println(removed + " mascotas reliminadas de " + dni);
	}

	private void listarMascotaPorDueno() {
		System.out.println("Buscar mascota por dueño...");
		String dni = menuUtils.askOwnerDNI();
		ArrayList<Mascota> mascotasList = findByDni(dni);
		if (mascotasList.size() == 0) {
			System.out.println("El dueño " + dni + " no tiene mascotas");
		} else
			menuUtils.showMascotas(mascotasList);
	}

	private Mascota findPetName(String nombre) {
		Mascota ret = null;
		for (Mascota mascota : mascotas) {
			if (mascota.getNombre().equalsIgnoreCase((nombre))) {
				ret = mascota;
				break;
			}
		}
		return ret;
	}

	private ArrayList<Mascota> findByDni(String dni) {
		ArrayList<Mascota> ret = new ArrayList<Mascota>();
		for (Mascota mascota : mascotas) {
			if (mascota.getDNIDueño().equalsIgnoreCase((dni))) {
				ret.add(mascota);
			}
		}
		return ret;
	}

	private boolean remove(String nombre) {
		boolean ret = false;
		for (Mascota mascota : mascotas) {
			if (mascota.getNombre().equalsIgnoreCase((nombre))) {
				mascotas.remove(mascota);
				ret = true;
				break;
			}
		}
		return ret;
	}

	private int removeAll(String dni) {
		int ret = 0;
		Iterator<Mascota> i = mascotas.iterator();
		while (i.hasNext()) {
			Mascota mascota = i.next();
			if (mascota.getDNIDueño().equalsIgnoreCase((dni))) {
				i.remove();
				ret++;
			}
		}
		return ret;
	}
}
