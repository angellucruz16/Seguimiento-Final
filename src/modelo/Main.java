package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {

	public Main ( ) {

		try {

			leerTxt();
			llenarPersonas();

			tiempo = System.currentTimeMillis(); 

		} catch (Exception e) {
			// TODO: handle exception
		}
	}


	private int tamArregloPersonas;
	private int numInfectados;
	private int numSanos;
	private int numRecuperados;
	private long tiempo;

	private Persona [] arregloPersonas;
	private Persona [] arregloInfectados;
	private Persona [] arregloRecuperados;
	private Persona [] arregloSanos;

	public Persona [] getArregloPersonas () {

		return arregloPersonas;


	}

	public void leerTxt () throws Exception {

		File file = new File ("../file.txt"); 

		BufferedReader br = new BufferedReader(new FileReader(file)); 

		String linea; 

		int contador = 1;



		while ((linea = br.readLine()) != null) 
		{	  

			String [] dividirLinea = linea.split(":");

			if (contador ==1) {

				numSanos = Integer.parseInt(dividirLinea [1]);

				arregloSanos = new Persona [numSanos] ;

				for (int i = 0 ; i < numSanos; i++ ) {

					arregloSanos [i] = new Persona(true, false, false, i+1);

				} 

			} else if (contador ==2 ) {

				numInfectados = Integer.parseInt(dividirLinea [1]);

				arregloInfectados = new Persona [numInfectados];

				for (int i = 0 ; i < numInfectados; i++ ) {

					arregloInfectados [i] = new Persona(false, true , false, numSanos + i+1);

				} 

			} else {

				numRecuperados = Integer.parseInt(dividirLinea [1]);

				arregloRecuperados = new Persona [numRecuperados];

				for (int i = 0 ; i < numRecuperados; i++ ) {

					arregloRecuperados [i] = new Persona(false, false , true, numSanos + numInfectados + i+1);

				} 

				contador ++;
			}			
		}
	}


	public String [] ordenarColor () {
		return null;

	}

	public String [] ordenarNum () {
		return null;

	}

	public void actualizarEstado () {

	}
	public void infectar () {


	}

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
	}

} //CLASE



