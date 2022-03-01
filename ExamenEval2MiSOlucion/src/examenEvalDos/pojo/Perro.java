package examenEvalDos.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Perro extends Mascota{

	public String raza = null;
	public boolean pulgas = false;
	
	public Perro () {
		super();
	}
	public Perro(String nombre, int edad, Date fechaNacimiento, String dNIDueño, String raza, boolean pulgas) {
		super(nombre, edad, fechaNacimiento, dNIDueño);
		this.raza = raza;
		this.pulgas = pulgas;
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public boolean isPulgas() {
		return pulgas;
	}
	public void setPulgas(boolean pulgas) {
		this.pulgas = pulgas;
	}
	
	@Override
	public String toString() {
		return "Perro [raza=" + raza + ", pulgas=" + pulgas + ", nombre=" + nombre + ", edad=" + edad
				+ ", fechaNacimiento=" + (fechaNacimiento==null? null : (new SimpleDateFormat("dd-MM-yyyy")).format(fechaNacimiento)) + ", DNIDueño=" + DNIDueño + "]";
	}
}
