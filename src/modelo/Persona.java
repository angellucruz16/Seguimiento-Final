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
	private long momentoInfeccion;
	private int id;
	
	

	public boolean getInfectado () {
		return infectado;
	} //GET INFECTADO
	
	public boolean getSano () {
		return sano;
	} //SANO

	public boolean getRecuperado () {
		return recuperado;
		
	} //GET RECUPERADO

	public int getTiempoInfectado () {
		return tiempoInfectado;
		
	} //GET TIEMPO INFECTADO
	
	public long getMomentoInfeccion () {
		return momentoInfeccion;
		
	} //GET MOMENTO INFECCION

	public int getId () {
		return id;
	} //GET ID

	public void infectar (long l) throws Exception {

		sano = false;
		infectado = true;
		recuperado = false;

		this.momentoInfeccion = (long) l; 
		
		Exception contagioException = new Exception("Contagiado");
		throw contagioException;

	} //INFECTAR
	
	public void recuperar () {

		infectado = false;
		sano = false;
		recuperado = true;

	} //RECUPERAR
	
	public int compareTo (Persona p) {
		return 0;
		
	} //PERSONA P
	
	public void setTiempoInfectado (int tiempo) {
		tiempoInfectado = tiempo;
		
	} //SET TIEMPO
	
	
	@Override
	public void run() {
		
		System.out.println(infectado);
		while(infectado  && System.currentTimeMillis()-momentoInfeccion<=14000)
		{
			
		}
		recuperar();
		
	} //RUN
	
	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}




