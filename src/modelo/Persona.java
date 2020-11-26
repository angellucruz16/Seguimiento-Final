package modelo;


public class Persona implements Comparable, Runnable {

	public Persona (boolean sano, boolean infectado, boolean recuperado, int id) {
		this.infectado = infectado;
		this.sano = sano;
		this.recuperado = recuperado;
		this.id = id;
		
	} //CONSTRUCTOR
	
	
	private boolean infectado;
	private boolean sano;
	private boolean recuperado;
	private int tiempoInfectado;
	private int momentoInfeccion;
	private int id;
	
	

	public boolean getInfectado () {
		return infectado;
	};
	public boolean getSano () {
		return sano;
	}

	public boolean getRecuperado () {
		return recuperado;
	}

	public int getTiempoInfectado () {
		return tiempoInfectado;
	}
	public int getMomentoInfeccion () {
		return momentoInfeccion;
	}

	public int getId () {
		return id;
	}

	public void infectar (int momentoInfeccion) {

		sano = false;
		infectado = true;
		recuperado = false;

		this.momentoInfeccion = momentoInfeccion; 

	}
	public void recuperar () {

		infectado = false;
		sano = false;
		recuperado = true;

	}
	public int compareTo (Persona p) {
		return 0;
	}
	
	public void setTiempoInfectado (int tiempo) {
		tiempoInfectado = tiempo;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}




