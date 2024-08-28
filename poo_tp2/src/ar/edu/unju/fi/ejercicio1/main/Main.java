package ar.edu.unju.fi.ejercicio1.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;


public class Main {
	
	static Scanner scanner;

	public static void main(String[] args) {
		
		int cantidad = 20;
		List<Integer> lista = new ArrayList<>();
		lista=cargarArray(lista, cantidad);
			
		scanner= new Scanner(System.in);
		
		menuOpciones(lista);		

	}
	
	/**
	 * Menu de opciones, recibe por parametro una lista de enteros
	 * mediante un ciclo while y un switch muestra un menu de opciones y deriva a las funciones
	 * asociadas
	 * @param lista
	 */
	
	
	public static void menuOpciones(List<Integer> lista) {
		
		int opcion;
		
		do {			
			
			mostrarMenu();
			opcion=scanner.nextInt();			
			
			switch (opcion) {
			
			case 1: 
				eliminarMultiplosDeX(lista);
				break;			
				
			case 2:
				modificarMaximoAlCuadrado(lista);
				break;
			
			case 3:
				sumarFactorialAValoresMenoresQueCinco(lista);
				break;
				
			case 4: 
				mostrarNumeroMenosRepetido(lista);
				break;
				
			case 5:
				particionarListaEnParesEImpares(lista);
				break;
			
			case 6: 
				mostrarListaX(lista);
				break;
			
			case 9: System.out.println("salir");			
				break;
				
			default: System.out.println("opcion inválida");
				break;
			
			
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
		
		System.out.println("ingrese opcion");
		
	}
	
	
	/**
	 * La idea de estos metodos es sacar la lógica del switch y que cada operacion tenga su logica
	 * @param lista
	 */
	
	private static void eliminarMultiplosDeX(List<Integer> lista) {
	    lista = eliminarMultiplos(lista); 
	}

	private static void modificarMaximoAlCuadrado(List<Integer> lista) {
	    maximoAlCuadrado(lista); 
	}

	private static void sumarFactorialAValoresMenoresQueCinco(List<Integer> lista) {
	    sumarFactorial(lista); 
	}

	private static void mostrarNumeroMenosRepetido(List<Integer> lista) {
	    numeroMenosRepetido(lista); 
	}

	private static void particionarListaEnParesEImpares(List<Integer> lista) {
	    divisorDeListas(lista); 
	}

	private static void mostrarListaX(List<Integer> lista) {
	    mostrarLista(lista); 
	}
		
	
	/**
	 * funcion que carga una lista con numeros de tipo Integer
	 * no se verifica que los numeros se repitan
	 * se hizo esto para que sea mas evidente la busqueda de repetidos en los otros metodos
	 * @param lista
	 * @param cantidad
	 * @return
	 */
	
	private static ArrayList<Integer> cargarArray (List<Integer> lista, int cantidad){
		
		Random random= new Random();
		
		
		for(int i =0; i<cantidad; i++) {
			
			lista.add(random.nextInt(100));
			
		}
		
		
		return (ArrayList<Integer>) lista;
		
	}
	
	
	/**
	 * Elimina los números de la lista que sean múltiplos de un número ingresado por el usuario
	 * @param lista
	 * @return
	 */
	
	private static List<Integer> eliminarMultiplos(List<Integer> lista) {
		
		int multiplo, numero;
		
		System.out.println("ingrese un nro para eliminar los multiplos");
		multiplo = scanner.nextInt();
		
		// se crea un iterador para recorrer la lista
		Iterator<Integer> iterador = lista.iterator();
		
		while(iterador.hasNext()) {
			
			numero= iterador.next();
			
			if(numero % multiplo==0) {
				
				iterador.remove();
				
			}
			
		}
		
		return lista;
		
	}
	
	
	/**
	 * procedimiento de muestra simple, recibe un lista de tipo List
	 * @param lista
	 */
	public static void mostrarLista(List<Integer> lista) {
		
		System.out.println("******** Lista  ********");
		System.out.println(" ");
		
		for(Integer lisInteger : lista) {
			System.out.println(" - " +lisInteger);
		}
		
		
	}
	
	/**
	 * Encuentra el número máximo en la lista y lo reemplaza con su cuadrado
	 * con Collections.max(lista) obtengo el maximo
	 * @param lista
	 */
	private static void maximoAlCuadrado(List<Integer> lista) {
		
		int maximo;
		int maximoAlCuadrado;
		
		maximo=Collections.max(lista);
		maximoAlCuadrado = maximo * maximo;
		
		lista.set(lista.indexOf(maximo), maximoAlCuadrado);
		
		System.out.println(maximo);
		
	}
	
	
	/**
	 * Suma el factorial a todos los números menores que 5 en la lista
	 * se apoya en la funcion calcularFactorial()
	 * @param lista
	 */
	private static void sumarFactorial(List<Integer> lista) {
		
		int i, valores, factorial;
		
		for (i=0; i<lista.size(); i++) {
			
			valores=lista.get(i);
			
			if (valores<5) {
				
				factorial = calcularFactorial(valores);
				
				lista.set(i, valores + factorial);
				
			}
			
			
		}
		
		
	}
	
	/**
	 * calcula el factorial de un numero
	 * recibe un valor por parametro y devuelve el factorial
	 * @param valor
	 * @return
	 */
	private static int calcularFactorial(int valor) {
		
		int i, factorial = 1;	
		
		for(i=1; i <= valor; i++) {
			
			factorial *= i; 
			
		}
		
		return factorial;
		
	}
	
	/**
	 * Encuentra y muestra el número que se repite menos veces en la lista
	 * creo un Mapa para contar cuantas veces aparece cada numero en la lista
	 * @param lista
	 */
	private static void numeroMenosRepetido(List<Integer> lista) {
		
		Boolean hayRepetidos;
		
		
		Map<Integer, Integer> listaRepetidos = new HashMap<>();
		
		listaRepetidos = contarRepetidos(lista, listaRepetidos); 
		
		hayRepetidos= verificarRepetidos(listaRepetidos);
		
		if(!hayRepetidos) {
			
			System.out.println("No hay numeros repetidos");
			
		}else {
			
			buscarMenorRepetido(listaRepetidos);
			
		}
		
	}
	
	/**
	 * Cuenta cuántas veces se repite cada número en la lista
	 * la idea es recorrer la lista y a cada numero ponerlo como clave en el mapa
	 * y como valor las repeticiones
	 * los numeros sin repeticion tendran el 1
	 * @param lista
	 * @param listaRepetidos
	 * @return
	 */
	private static Map<Integer, Integer> contarRepetidos(List<Integer> lista, Map<Integer, Integer> listaRepetidos){
		
		
		for(Integer numero: lista) {
			
			// con el getOrDefault determino si el numero existe devuelve las veces que se repitió o si no 0 si no esta agregado
			// 
			listaRepetidos.put(numero, listaRepetidos.getOrDefault(numero, 0)+1);
			
			
		}
		
		return listaRepetidos;
		
	}
	
	/**
	 * Recorre los valores del mapa para verificar si alguno se repite más de una vez.
	 * @param listaRepetidos
	 * @return
	 */
	private static boolean verificarRepetidos(Map<Integer, Integer> listaRepetidos) {
		
		boolean hayRepetidos= false;
		
		for(int contador : listaRepetidos.values()) {
			
			if(contador>1) {
				
				hayRepetidos = true;
				break;
				
			}
			
		}
		
		return hayRepetidos;		
		
	}
	
	
	/**
	 * Encuentra y muestra el número que se repite menos veces en la lista
	 * Recorre el mapa y encuentra el número con menor cantidad de repeticiones
	 * @param listaRepetidos
	 */
	
	private static void buscarMenorRepetido(Map<Integer, Integer> listaRepetidos) {
		
		int cantidadRepeticiones=Integer.MAX_VALUE;
		int numeroMenosRepetido=-1;
		
		for(Map.Entry<Integer, Integer> parClaveValor : listaRepetidos.entrySet()) {
			
			if(parClaveValor.getValue()> 1 && parClaveValor.getValue() < cantidadRepeticiones) {
				
				cantidadRepeticiones = parClaveValor.getValue();
				numeroMenosRepetido = parClaveValor.getKey();
				
			}
			
		}
		
		System.out.println("El número que se repite menos veces es: " + numeroMenosRepetido + " con " + cantidadRepeticiones + " repeticiones.");
		
	} 
	
	
	/**
	 * Divide la lista original en dos sublistas: una de números pares y otra de impares, y las muestra en la consola
	 * @param lista
	 */
	private static void divisorDeListas(List<Integer> lista) {
		
		List<Integer> listaPares = new ArrayList<>();
		List<Integer> listaImpares = new ArrayList<>();
		
		for(Integer numero : lista) {
			
			boolean resultado = (numero % 2 == 0) ? listaPares.add(numero) : listaImpares.add(numero);			
		}
		
		System.out.println(" ***  pares  ***");
		mostrarLista(listaPares);
		
		System.out.println(" ***  impares ****");
		mostrarLista(listaImpares);
		
	}
	
}