package examenEvalDos.pojo;

import java.util.Date;

public class Mascota {

	public String nombre = null;
	public int edad = 0;
	public Date fechaNacimiento = null; 
	public String DNIDueño = null;

	public String prueba = null;
	
	public Mascota() {
		super();
	}
	public Mascota(String nombre, int edad, Date fechaNacimiento, String dNIDueño) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.fechaNacimiento = fechaNacimiento;
		DNIDueño = dNIDueño;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getDNIDueño() {
		return DNIDueño;
	}
	public void setDNIDueño(String dNIDueño) {
		DNIDueño = dNIDueño;
	}
}
