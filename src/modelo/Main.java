package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {

	
	private int tamArregloPersonas;
	private int numInfectados;
	private int numSanos;
	private int numRecuperados;
	private long tiempo;


	private Persona [] arregloPersonas;

	//private Persona [] arregloInfectados;
	//private Persona [] arregloRecuperados;
	//private Persona [] arregloSanos;

	private ArrayList<Persona> arregloInfectados;
	private ArrayList<Persona> arregloRecuperados;
	private ArrayList<Persona> arregloSanos;

	public Main ( ) {

		try {
			
			leerTxt();
			llenarPersonas();
			System.out.println(arregloPersonas.length);
			
			tiempo = System.currentTimeMillis();

		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}

	} //MAIN

	public void actualizarEstado () {

		for (Persona persona : arregloPersonas) {
			if(persona.getInfectado()){
				
				arregloInfectados.remove(persona);
				arregloRecuperados.add(persona);
				numInfectados--;
				numRecuperados++;
			}
		}
	} //ACTUALIZAR ESTADO

	public Persona [] getArregloPersonas () {

		return arregloPersonas;
		
	}  //GET ARREGLO PERSONAS


	public ArrayList<Persona> getArregloRecuperados () {
		return arregloRecuperados;
	} //GET ARREGLO RECUPERADOS

	public int getInfectados() {
		return numInfectados;
	} //NUMINFECTADOS

	public int getRecuperados() {
		return numRecuperados;
	} //GET RECUPERADOS

	public int getSanos() {
		return numSanos;
	} //GETSANOS

	public void infectar (int id) throws Exception{

		for (Persona persona : arregloPersonas) {
			
			if (persona.getId()==id) {
				
				arregloInfectados.add(persona);
				arregloSanos.remove(persona);
				numSanos--;
				// persona.run();
				System.out.println(numInfectados);
				numInfectados++;
				if (numInfectados == 30) {
					System.out.println("Mas del 30% se ha contagiado.");
				}
				persona.infectar(System.currentTimeMillis());
			}
		}
	}
	
	public void leerTxt () throws Exception {

		File file = new File ("../file.txt"); 

		BufferedReader br = new BufferedReader(new FileReader(file)); 

		String linea; 

		int contador = 1;

		while ((linea = br.readLine()) != null) {	  

			String [] dividirLinea = linea.split(":");

			if (contador ==1) {

				numSanos = Integer.parseInt(dividirLinea [1]);

				arregloInfectados =new ArrayList<Persona>() ;

				for (int i = 0 ; i < numSanos; i++ ) {

					arregloSanos.add(new Persona(true, false, false, i+1));

				}

			} else if (contador ==2 ) {

				numInfectados = Integer.parseInt(dividirLinea[1]);

				arregloInfectados = new ArrayList<Persona>();

				for (int i = 0; i < numInfectados; i++) {

					arregloInfectados.add(new Persona(false, true, false, numSanos + i + 1));

				} 

			} else {

				numRecuperados = Integer.parseInt(dividirLinea [1]);

				arregloRecuperados = new ArrayList<Persona>() ;

				for (int i = 0 ; i < numRecuperados; i++ ) {

					arregloRecuperados.add(new Persona(false, false , true, numSanos + numInfectados + i+1));

				} 
				
			}		
			contador ++;
		}
		
	} //LEERTXT


	public void llenarPersonas () {

		tamArregloPersonas = numInfectados + numSanos + numRecuperados;

		arregloPersonas = new Persona [tamArregloPersonas];

		int i = 0;

		for (Persona persona : arregloInfectados ) {

			arregloPersonas [i] = persona ;
			i++;
		}

		for (Persona persona : arregloSanos ) {

			arregloPersonas [i] = persona ;
			i++;
		}
		
		for (Persona persona : arregloRecuperados ) {

			arregloPersonas [i] = persona ;
			i++;
		}
		
	} //LLENARPERSONAS
	
	public String [] ordenarColor () {
		return null;

	}

	public String [] ordenarNum () {
		return null;

	}
	
	public void recuperar(int id) {
		for (Persona persona : arregloPersonas) {
			if (persona.getId() == id) {
				persona.recuperar();
				arregloInfectados.remove(persona);
				arregloRecuperados.add(persona);
				numInfectados--;
				numRecuperados++;
			}
		}
	}
	

	

} //CLASE



