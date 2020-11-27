package vista;
import java.util.Random;

import controlador.Controlador;
import modelo.Main;

import processing.core.PApplet;
public class Bolita implements Runnable{
	int rad; 
	int radHeight=rad;
	int radWidth=rad;
	float xpos, ypos;
	PApplet sketch;
	float xspeed = 1;  
	float yspeed = 1; 
	int id;
	int xdirection;  
	int ydirection;  
	int r;
	int g;
	int b;
	Bolita [] bolitas;
	Controlador controlador;

	boolean infectado;
	boolean sano;
	boolean recuperado;
	
	} // CLASS