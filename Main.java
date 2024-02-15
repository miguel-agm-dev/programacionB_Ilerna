import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//Declaracion variable de accion
		int numAccion;
		
		//Se instancia la clase Scanner
		Scanner sc= new Scanner(System.in);
		
		//Se instancian usuario y cuenta para usuario
		Usuario usuario=new Usuario();
		Cuenta cuenta=new Cuenta(usuario);
		
		//Se toman los datos del usuario
		System.out.println("Introduzca un nombre :");
		usuario.setNombre(sc.nextLine());
		System.out.println("Introduzca la edad :");
		usuario.setEdad(sc.nextInt());
		sc.nextLine();
		
		//Bucle para confirmar que DNI tenga el formato correcto, si no se repite la pregunta
		do {
		System.out.print("Introduzca su DNI :\n");
		usuario.setDNI(sc.nextLine());
		if(usuario.getDNI()==null)System.out.println("El DNI introducido es incorrecto");
		}while (usuario.getDNI()==null);
		
		//Mensaje de confirmación del DNI
		System.out.println("Usuario Creado Correctamente");
		
		//toString para definir al usuario
		System.out.println(usuario.toString());
		
		//Elección de opción, bucle do while hasta marcar 0 que saldra del bucle y finalizará, o repetición si introduce otro valor diferente
		do {
		System.out.print("  Realizar una nueva acción:\n"
				+ "   (1) Introducir un nuevo gasto\n"
				+ "   (2) Introducir un nuevo ingreso\n"
				+ "   (3) Mostrar gastos\n"
				+ "   (4) Mostrar ingresos\n"
				+ "   (5) Mostrar saldo\n"
				+ "   (0) Salir\n"
				+ "#:");
			
		
		numAccion=sc.nextInt();
		sc.nextLine();
		
		if(numAccion<0||numAccion>5){
			System.out.println("La opción elegida no existe.\nElige una opción entre el 0 y el 5.");
		}
		
		//Switch con casos según la opción
		switch(numAccion){
		
			//Se introduce cantidad y descripción de gasto
			case 1:
				System.out.println("Introduzca la descripción del gasto:");
				String descrGasto=sc.nextLine();
				
				System.out.println("Introduzca la cantidad del gasto:");
				double cantGasto=sc.nextDouble();
				sc.nextLine();
				
				//Imprime saldo previo, gasto a realizar
				System.out.println("Saldo : "+comaDouble(cuenta.getSaldo())+"€  Gasto : "+comaDouble(cantGasto)+"€");
				//Llama a método addGastos para saber si puede hacer el gasto o no y realizar método
				double resulSaldo=cuenta.addGastos(descrGasto,cantGasto);
				//Imprime saldo restante, después de la operación
				System.out.println("Saldo restante : "+comaDouble(resulSaldo)+"€");
				
				break;
				
			//Se introduce cantidad y descripción del ingreso
			case 2:
				System.out.println("Introduzca la descripción del ingreso:");
				String descrIngre=sc.nextLine();
				
				System.out.println("Introduzca la cantidad del ingreso:");
				double cantIngre=sc.nextDouble();
				sc.nextLine();
				
				//Imprime saldo previo, ingreso a realizar
				System.out.println("Saldo : "+comaDouble(cuenta.getSaldo())+"€  Ingreso : "+comaDouble(cantIngre)+"€");
				//Llama al método addIngresos para sumar el ingreso al saldo
				double totalSaldo=cuenta.addIngresos(descrIngre, cantIngre);
				//Imprime el saldo total después de la operación
				System.out.println("Saldo total : "+comaDouble(totalSaldo)+"€");
				
				break;
				
			case 3:
				//Llama al método para obtener lista de gastos si existe, si no se indica
				cuenta.getGastos();
				
				break;
				
			case 4:
				//Llama al método para obtener lista de ingresos si existe, si no se indica
				cuenta.getIngresos();
				
				break;
				
			case 5:
				//Imprime la información de la cuenta, con saldo y usuario
				//Se usa una función para reemplazar los puntos por comas en los double
				System.out.println(cuenta.toString().replace(".", ","));
				
				break;
				
			//Mensaje final de ejecución, finaliza	
			case 0:
				System.out.println("Fin del programa.\nGracias por utilizar la aplicación de M03B en el curso 2s2223.");
				
				break;
		}
		
		}while(numAccion!=0);
		
		//Se cierra Scanner
		sc.close();
		
		
		}
	
	//Método para sustituir los puntos por las comas en los double, realizar el formateo a sistema europeo
	public static String comaDouble (double numero) {
		long partEntera=(long)numero;
		double partDecimal=numero-partEntera;
		String comaFormat=String.format("%,d", partEntera);
		comaFormat+=String.format("%.2f", partDecimal).substring(1).replace(".",",");
		return comaFormat;
	}
	
	

}
