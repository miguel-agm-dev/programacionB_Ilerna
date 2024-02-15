
public class Ingreso extends Dinero{

	//Constructor con parametros modificados de la clase padre, asigna valores a la clase de la que hereda
	
	public Ingreso(double ingreso, String description){
		super.dinero=ingreso;
		super.description=description;
	}

	//toString de clase Ingreso que lo define y devuelve contenido
	
	@Override
	public String toString() {
		return "Dinero : " + dinero + "€   Descripción : " + description;
	}
	
	

	
}
