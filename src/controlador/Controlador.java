package controlador;

import java.util.ArrayList;

import modelo.Main;
import modelo.Persona;

//6
public class Controlador {

	Main modelo;
	
	public Controlador(Main modelo) {
		this.modelo=modelo;
		
	}

	public Persona[] getPersonas()
	{
		return modelo.getArregloPersonas();
	}
	//9
	public void infectar(int id) throws Exception
	{
		modelo.infectar(id);
	}
	
	public ArrayList<Persona> actualizar()
	{
		return modelo.getArregloRecuperados();
	}
}
