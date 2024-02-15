
public class Usuario {

	//Atributos de usuario privados
	
	private String nombre;
	private int edad;
	private String DNI;
	
	
	//Constructor de usuario sin parámetros
	
	public Usuario() {
		super();
	}
	
	//Getters y setters. Métodos públicos
	
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
	
	public String getDNI() {
		return DNI;
	}
	
	/*La comprobacion de DNI esta en el setter con una expresion regular. Devuelve booleano, con true queda asignado, false queda nulo
	//La expresión dniRegex indica a cumplir 8 primeros digitos entre 0 y 9, posibilidad de guion o no, una letra de entre las que aparecen
	//Se ha descartado letras como la I, O , Ñ, que no aparecen en el dni español*/
	
	public boolean setDNI(String DNI) {
		String dniRegex="^[0-9]{8}[-]?[ABCDEFGHJKLMNPQRSTUVWXYZ]$";
		if (DNI.matches(dniRegex)) {
			this.DNI=DNI;
			return true;	
		} else {
			return false;
		}
	}
	
	//Parte del toString que recoge la descripcion de la clase y devuelve informacion
	
	@Override
	public String toString() {
		return "Nombre : \"" + nombre + "\"  Edad : " + edad + "  DNI : " + DNI;
	}
	
	
	
}
