import java.util.ArrayList;
import java.util.List;

public class Cuenta {

	//Atributos determinados privados, se usarán objetos de clase Usuario, Gasto e Ingreso, estos en listas
	
	private double saldo;
	private Usuario usuario;
	private List<Gasto> gastos;
	private List<Ingreso> ingresos;
	
	
	//Constructor con parametro de Usuario empieza con saldo 0, usuario el definido al principio del programa
	
	public Cuenta(Usuario usuario) {
		super();
		this.saldo = 0;
		this.usuario = usuario;
		this.gastos = new ArrayList<Gasto>();
		this.ingresos = new ArrayList<Ingreso>();
	}
	
	//Funciones públicas, con getters y setters
	
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	//En este método se añaden los nuevos ingresos en una lista con cantidad y descripción
	//Se suma al saldo el ingreso y retorna el saldo real
	
	public double addIngresos(String description, double cantidad) {
		ingresos.add(new Ingreso(cantidad, description));
		saldo+=cantidad;
		return saldo;
	};
	
	/*En este método se añaden los nuevos gastos en una lista con cantidad y descripción si queda saldo para cubrir el gasto
	Se prueba a lanzar una excepción restando la cantidad al saldo, si se puede se resta, si no se captura la excepción
	"GastoException", y retorna saldo restante*/
	
	public double addGastos(String description, double cantidad) {
		if(cantidad<=saldo) {
		gastos.add(new Gasto(cantidad, description));
		}
		
		try {
			
			if(saldo<cantidad) {
				throw new GastoException();
			}else {
				saldo-=cantidad;
			}
		}catch(GastoException e) {
			System.out.println(e.getMessage());
		}
		return saldo;
		
	};
	
	/*Método donde se obtiene cada ingreso de su lista. Se recorren mediante un for retornandolos 
	si existen ingresos, si no se muestra un texto*/
	
	public List<Ingreso> getIngresos() {
		
	
		if(ingresos.size()>0) {
			System.out.println("Lista de Ingresos:");
			for(int i=0; i<ingresos.size();i++) {
				System.out.println(ingresos.get(i));
			}
		}else {
			System.out.println("No hay ingresos para mostrar");
		}
		return ingresos;
	}

	
	/*Método donde se obtiene cada gasto de su lista. Se recorren mediante un for retornandolos 
	si existen gastos, si no se muestra un texto*/
	
	public List<Gasto> getGastos() {
	
		if(gastos.size()>0) {
			System.out.println("Lista de Gastos:");
			
			for(int i=0; i<gastos.size();i++) {
				System.out.println(gastos.get(i));
				}
		}else {
			System.out.println("No hay gastos para mostrar");
		}
		return gastos;
	}
	
	//toString que devuelve información de la cuenta con saldo y el usuario de ella
	
	@Override
	public String toString() {
		return "Información de Cuenta  Saldo : " + saldo + "€   Usuario : " + usuario;
	}



	
	
	
	
	
	
}
