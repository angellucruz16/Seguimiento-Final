package vista;

import controlador.Controlador;
import modelo.Main;
import modelo.Persona;
//5
import processing.core.PApplet;
public class Vista extends PApplet{

	Bolita [] bolitas;
	Controlador controlador;
	Main modelo;
	
	public void settings() {
		
		size(700, 700);
		modelo=new Main();
		controlador=new Controlador(modelo);
		crearBolitas();
		
	} //SETTINGS
	
	public void setup() {
		noStroke();
		frameRate(80);
		ellipseMode(RADIUS);

	} //SETUP
	
	public void draw() {	
	} //DRAW
	
	public void crearBolitas() {
		Persona[] arrPersonas = controlador.getPersonas();
		bolitas = new Bolita[arrPersonas.length];
		int i=0;
		for (Persona p: arrPersonas) {
			bolitas[i]= new Bolita(p.getId(), this, p.getInfectado(), p.getSano(), p.getRecuperado(), controlador);
			i++;
		}
		
	} //CREAR BOLITAS
	
	public void actualizarBolitas() {
		
		for (Persona persona : controlador.actualizar()) {
			for (Bolita bolita : bolitas) {
				if (bolita.id==persona.getId() && persona.getRecuperado()) {
					bolita.azul();
				}
			}
		}
	} // ACTUALIZAR BOLITAS
	

	public static void main(String[] args) {
		String[] processingArgs = {"Main"};
		Vista mySketch = new Vista();
		PApplet.runSketch(processingArgs, mySketch);
		//PApplet.main("process.Pro");
	}
	
} //CLASE

