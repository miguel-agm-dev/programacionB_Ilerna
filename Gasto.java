
public class Gasto extends Dinero{

	//Constructor con parametros modificados de clase padre, asigna valores a la clase de la que hereda
	
	public Gasto(double gasto, String description) {
		super.dinero=gasto;
		super.description=description;
	}

	//toString de clase Gasto que lo define y devuelve contenido
	
	@Override
	public String toString() {
		return "Dinero : " + dinero + "€   Descripción : " + description;
	}
	
	
	
}
