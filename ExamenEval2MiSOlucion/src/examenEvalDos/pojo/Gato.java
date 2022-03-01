package examenEvalDos.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Gato extends Mascota{

	public static final String PELO_CORTO = "C";
	public static final String PELO_MEDIO = "M";
	public static final String PELO_LARGO = "L";
	
	public String pelo = null;
	public String colorPelo = null;
	
	public Gato () {
		super();
	}
	public Gato(String nombre, int edad, Date fechaNacimiento, String dNIDueño, String pelo, String colorPelo) {
		super(nombre, edad, fechaNacimiento, dNIDueño);
		this.pelo = pelo;
		this.colorPelo = colorPelo;
	}
	public String getPelo() {
		return pelo;
	}
	public void setPelo(String pelo) {
		this.pelo = pelo;
	}
	public String getColorPelo() {
		return colorPelo;
	}
	public void setColorPelo(String colorPelo) {
		this.colorPelo = colorPelo;
	}
	
	@Override
	public String toString() {
		return "Gato [pelo=" + pelo + ", colorPelo=" + colorPelo + ", nombre=" + nombre + ", edad=" + edad
				+ ", fechaNacimiento=" + (fechaNacimiento==null? null : (new SimpleDateFormat("dd-MM-yyyy")).format(fechaNacimiento)) + ", DNIDueño=" + DNIDueño + "]";
	}
}
