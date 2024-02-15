
public abstract class Dinero {

	//Clase abstracta con atributos protegidos, heredarán gasto e ingreso
	
	protected double dinero;
	protected String description;
	
	
	//Métodos públicos declarados por no ser abstractos
	//Son getters y setters de la clase
	
	public double getDinero() {
		return dinero;
	}
	
	public void setDinero (double dinero) {
		this.dinero=dinero;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription (String description) {
		this.description=description;
	}
}
