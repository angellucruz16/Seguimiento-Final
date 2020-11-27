package controlador;

import java.util.ArrayList;

import modelo.Main;
import modelo.Persona;


public class Controlador {

	Main modelo;
	
	public Controlador(Main modelo) {
		this.modelo=modelo;
		
	} //CONSTRUCTOR

	public ArrayList<Persona> actualizar() {
		return modelo.getArregloRecuperados();
	} //ARRAYLIST PERSONAS
	
	public int getInfectados() {
		return modelo.getInfectados();
	} //GET INFECTADOS
	
	public Persona[] getPersonas() {
		return modelo.getArregloPersonas();
	} //GET PERSONAS
	
	public int getRecuperados() {
		return modelo.getRecuperados();
	} //GET RECUPERADOS

	public int getSanos() {
		return modelo.getSanos();
	} //GET SANOS
	
	public void infectar(int id) throws Exception {
		modelo.infectar(id);
	} //INFECTAR
	
	public void recuperar(int id) {
		modelo.recuperar(id);
	} // RECUPERAR
	
} //CLASE
