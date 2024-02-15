
public class GastoException extends RuntimeException {

	public GastoException() {
		
		//Clase de excepcion con constructor sin parametros y que genera el comentario de abajo
		super("La cantidad del gasto excede el saldo de su cuenta");
	}
}
