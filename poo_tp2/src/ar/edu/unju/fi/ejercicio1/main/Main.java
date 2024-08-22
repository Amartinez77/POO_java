package ar.edu.unju.fi.ejercicio1.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Main {
	
	static Scanner scanner;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cantidad = 10;
		List<Integer> lista = new ArrayList<>();
		lista=cargarArray(lista, cantidad);
			
		scanner= new Scanner(System.in);
		int opcion;
		
		do {
			
			
			System.out.println("ingrese opcion");
			opcion=scanner.nextInt();
			
			
			
			switch (opcion) {
			case 1: {	
				
				System.out.println("mostrar lista");
				for(Integer numero : lista) {
					System.out.println("nro" + numero);
				}
				
				break;				
				}
			
			case 2: lista=eliminarMultiplos(lista);
				break;
				
			case 3: mostrarLista(lista);
				break;
				
			
			
			case 9: System.out.println("salir");
			
				break;
			
			}
		
		

		}while(opcion!=9);

	}
	
	
	
	public static ArrayList<Integer> cargarArray (List<Integer> lista, int cantidad){
		
		Random random= new Random();
		
		
		for(int i =0; i<cantidad; i++) {
			
			lista.add(random.nextInt(100));
			
		}
		
		
		return (ArrayList<Integer>) lista;
		
	}
	
	
	public static List<Integer> eliminarMultiplos(List<Integer> lista) {
		
		int multiplo, numero;
		
		System.out.println("ingrese un nro para eliminar los multiplos");
		multiplo = scanner.nextInt();
		
		Iterator<Integer> iterador = lista.iterator();
		
		while(iterador.hasNext()) {
			
			numero= iterador.next();
			
			if(numero % multiplo==0) {
				
				iterador.remove();
				
			}
			
		}
		
		return lista;
		
	}
	
	
	public static void mostrarLista(List<Integer> lista) {
		
		
		for(Integer lisInteger : lista) {
			System.out.println(lisInteger);
		}
		
		
	}
}