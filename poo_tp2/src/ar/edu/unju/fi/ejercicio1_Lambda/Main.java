package ar.edu.unju.fi.ejercicio1_Lambda;

import java.util.ArrayList;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Function;

import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main {
	
	static Scanner scanner;

	public static void main(String[] args) {
		
		scanner= new Scanner(System.in);
		
		List<Integer> lista = new ArrayList<>();
		
		cargarLista(lista);

		menuOpciones(lista);
		

	}
	
	
	/**
	 * carga una lista con elementos ramdom no repetidos usando expresiones lambda
	 * @param lista
	 */
	private static void cargarLista(List<Integer> lista) {
		
		int cantidad = 20;
		
		new Random().ints(0, 100)
					.distinct()
					.limit(cantidad)
					.forEach(lista::add);		
	}
	
	

	/**
	 * Menu de opciones, recibe por parametro una lista de enteros
	 * mediante un ciclo while y un switch muestra un menu de opciones y deriva a las funciones
	 * asociadas
	 * el switch usa lambda
	 * @param lista
	 */
	
	
	public static void menuOpciones(List<Integer> lista) {
		
		int opcion;
		
		do {			
			
			mostrarMenu();
			opcion=scanner.nextInt();			
			
			switch (opcion) {
			
			case 1 -> eliminarMultiplosDeX(lista);			
				
			case 2 -> modificarMaximoAlCuadrado(lista);
			
			case 3 -> sumarFactorialAValoresMenoresQueCinco(lista);
				
			case 4 -> mostrarNumeroMenosRepetido(lista);
				
			case 5 -> particionarListaEnParesEImpares(lista);
			
			case 6 -> mostrarListaX(lista);
			
			case 9 -> System.out.println("salir");								
				
			default -> System.out.println("opcion inválida");			
			
			}		

		}while(opcion!=9);	
		
		
	}
	
	/**
	 * Menu de opciones
	 */
	
	private static void mostrarMenu() {
		
		System.out.println("***********");
		System.out.println(" 1- Eliminar los numeros multiplos de un nro ingresado");
		System.out.println(" 2- Modificar el maximo numero de la coleccion elevando su valor al cuadrado ");
		System.out.println(" 3- a todos los valores menores a 5 sumarle su factorial");
		System.out.println(" 4- Encontrar el numero que se repite menos veces, si no hay repetidos, mostrar un mensaje indicando que no hay repetidos");
		System.out.println(" 5- Particionar la lista en dos sublistas: una con numeros pares y otra con numeros impares, y mostrar las sublistas en consola");
		System.out.println(" 6- Mostrar coleccion");
		System.out.println(" 9- SALIR");
		
		System.out.println("ingrese opcion");
		
	}
	
	
	/**
	 * La idea de estos metodos es sacar la lógica del switch y que cada operacion tenga su logica
	 * @param lista
	 */
	
	private static void eliminarMultiplosDeX(List<Integer> lista) {
	    
		int multiplo;
		
		System.out.println("Ingrese un número para eliminar sus múltiplos: ");
        multiplo = scanner.nextInt();
        
        lista.removeIf(numero -> numero % multiplo == 0);
        mostrarListaX(lista);
		
	}
	

	private static void modificarMaximoAlCuadrado(List<Integer> lista) {
	    
		Optional<Integer> max = lista.stream()
				 .max(Comparator.comparingInt(Integer::intValue));
	
	if(max.isPresent()) {
		
		Integer maxAlCuadrado = max.get() * max.get();
		lista.replaceAll(numero -> numero.equals(max.get()) ? maxAlCuadrado : numero);
	}
	
	mostrarListaX(lista);
		
	}
	
	/**
	 * funcion que recorre una lista buscando los numeros menores a 5 para calcular su factorial
	 * luego suma ese valor al original y actualiza la lista
	 * @param lista
	 */
	
	private static void sumarFactorialAValoresMenoresQueCinco(List<Integer> lista) {
	    
		lista.replaceAll(numero -> numero < 5 ? numero + calcularFactorial(numero) : numero);
		
	}	
	
	/**
	 * funcion que retorna el factorial de un numero
	 * @param numero
	 * @return
	 */
	private static int calcularFactorial(int numero) {
		
		// IntStream.rangeClosed(1, numero) genera un stream de numeros desde 1 hasta "numero"
		return IntStream.rangeClosed(1, numero)
						.reduce(1, (a, b) -> a * b);
		// con reduce multiplica todos los numero del stream para obtener el factorial
	}

	/**
	 * Utiliza un Map<k, v> para almacenar los valores y las repeticiones
	 * luego se filtran los repetidos
	 * finalmente con min filtramos el que menos repeticiones tiene
	 * @param lista
	 */
	private static void mostrarNumeroMenosRepetido(List<Integer> lista) {
	    
		// Contar las repeticiones de cada número
		//con Function.identity se devuelve el valor como clave (igual que en la version sin lambda)
			    
		Map<Integer, Long> conteoRepeticiones = lista.stream()
			        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
			    
		// Filtrar números repetidos y encontrar el que se repite menos veces
			    
		Optional<Map.Entry<Integer, Long>> menorRepetido = conteoRepeticiones.entrySet().stream()
			        .filter(entry -> entry.getValue() > 1)
			        .min(Comparator.comparingLong(Map.Entry::getValue));
			    
		// in.Present verifica que la lista no sea null con el optional
			   
		if (menorRepetido.isPresent()) {
			    	
		  	// entry filtra las claves donde el valor que son las repeticiones sea mayor a 1
		      Map.Entry<Integer, Long> entry = menorRepetido.get();
		      System.out.println("El número que se repite menos veces es: " + entry.getKey() +
			                           " con " + entry.getValue() + " repeticiones.");
		   } else {
			       
		   	System.out.println("No hay números repetidos.");
			    	
		   }
		
	}
	
	
	
	/**
	 * divide una lista en 2 (pares - imapres) se apoya en un Map
	 * con claves verdadero o falso y los valores son los numeros de la lista
	 * @param lista
	 */
	private static void particionarListaEnParesEImpares(List<Integer> lista) {
	    
		// Particionar la lista en dos listas: pares e impares
		
	    Map<Boolean, List<Integer>> particionado = lista.stream()
	        .collect(Collectors.partitioningBy(numero -> numero % 2 == 0));
	    
	    
	    // se obtiene las listas en base a la clave (true o false) 
	    List<Integer> listaDePares = particionado.get(true);
	    List<Integer> listaDeImpares = particionado.get(false);
	    
	    // Imprimir lista de pares
	    System.out.println("Lista de pares:");
	    listaDePares.forEach(System.out::println);
	    
	    // Imprimir lista de impares
	    System.out.println("Lista de impares:");
	    listaDeImpares.forEach(System.out::println);
		
	}
	

	private static void mostrarListaX(List<Integer> lista) {
		lista.forEach(System.out::println); 
	}

}
