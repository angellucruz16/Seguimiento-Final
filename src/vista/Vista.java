package vista;

import controlador.Controlador;
import modelo.Main;
import modelo.Persona;

import processing.core.PApplet;

public class Vista extends PApplet{
	
	public static void main(String[] args) {
		String[] processingArgs = { "Main" };
		Vista mySketch = new Vista();
		PApplet.runSketch(processingArgs, mySketch);
		// PApplet.main("process.Pro");
	}
	
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
		
		background(250);
		
		for (Bolita bolita : bolitas) {
			bolita.setBolitas(bolitas);
			bolita.run();
		}
		
		actualizarBolitas();
		
		//TEXTO:
		
		this.fill(255, 0, 0);
		this.text("Infectados: " + controlador.getInfectados(), 20, 20);
		this.fill(0, 0, 255);

		this.text("Recuperados: " + controlador.getRecuperados(), 20, 60);
		this.fill(0, 255, 0);

		this.text("Sanos: " + controlador.getSanos(), 20, 100);
	}

	
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
	


} //CLASE

