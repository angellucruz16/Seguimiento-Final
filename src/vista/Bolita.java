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
	
	

	public Bolita(int id, PApplet sketch, boolean infectado, boolean sano, boolean recuperado, Controlador controlador) {
		this.id=id;
		Random rand = new Random(); //instance of random class
		rad= 7;
		xpos = rand.nextInt(sketch.width-rad)+rad;
		ypos = rand.nextInt(sketch.height-rad)+rad;
		xdirection = (int) Math.pow(-1, rand.nextInt(5));
		ydirection = (int) Math.pow(-1, rand.nextInt(5));
		this.infectado = infectado;
		this.sano = sano;
		this.recuperado = recuperado;
		color();
		this.sketch=sketch;
		setControlador(controlador);
	}
	


	public void setBolitas(Bolita[] bolitas) {
		this.bolitas = bolitas;
	}
	
	public void setControlador(Controlador controlador) {
		this.controlador=controlador;
	}

	public void speed() {
		xpos = xpos + ( xspeed * xdirection );
		ypos = ypos + ( yspeed * ydirection );
	}

	public void bounce() {

		if (xpos > sketch.width-rad || xpos < radWidth) {
			xdirection *= -1;
		}

		if (ypos > sketch.height-radHeight || ypos < rad) {
			ydirection *= -1;
		}
		sketch.fill(r,g, b);
		
	}
	
	public void render() {
		speed();
		bounce();
		color();
		//sketch.fill(r,g, b);
		sketch.ellipse(xpos, ypos, rad, rad);
	}
	
	public void color() {
		r=0;
		g=0;
		b=0;
		if(infectado)	{
			r=255;
		}
		else if(sano) {
			g=255;
		}
		else if (recuperado) {
			b=255;
		}

	}

	public void infection(Bolita [] bolitas)
	{
		for (Bolita b : bolitas) {
			double dist = Math.hypot(xpos-b.xpos, ypos-b.ypos);
			if(dist<14)
			{
				if(b.infectado && sano)
				{
					
					sano=false;
					infectado=true;
					try {
					controlador.infectar(this.id);
					}
					catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}

			}
		}

	}
	
	public void azul(){
		sano=false;
		infectado=false;
		recuperado=true;
	}

	public void run() {
		render();
		infection(bolitas);

	}
	} // CLASS