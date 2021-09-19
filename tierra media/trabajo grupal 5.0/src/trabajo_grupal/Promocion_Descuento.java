package trabajo_grupal;

import java.util.ArrayList;

public class Promocion_Descuento extends Promocion {
private double descuento;

public Promocion_Descuento(String nombre, ArrayList<Atraccion> atracciones, double descuento) {
	this.descuento=descuento;
	this.nombre=nombre;
	this.atracciones=atracciones;
}

	public double getDescuento() {
	return descuento;
}


public void setDescuento(double descuento) {
	this.descuento = descuento;
}


	
	
	public String toString() {
		
		String promo= "Nombre Promocion: "+this.nombre+"; Tipo: Descuento "+"; Descuento: "+this.descuento+"; Costo: "+this.getCosto()+"; Tiempo: "+this.getTiempo();
		for(Atraccion a : atracciones) {
			promo=promo+"\n       "+a;
		}
		return promo;
		
	}
	
	public int getPersonas() {
		int v=0;
		for(Atraccion a : atracciones) {
			v=v+a.getPersonas();
		}
		return v;
	}
	
	public void descontar_Cupo() {
		for(Atraccion a : atracciones) {
			a.descontar_Cupo();
		}
	}
	
	public ArrayList<Atraccion> getAtracciones() {
	return	atracciones;
	}

	public double getCosto() {
		double v=0;
		for(Atraccion a : atracciones) {
			v=v+a.getCosto();
		}
		return v-(v*(this.descuento/100));
	}

	public double getTiempo() {
		double v=0;
		for(Atraccion a : atracciones) {
			v=v+a.getPersonas();
		}
		return v;
	}
	
	public  TipoAtraccion getTipo() {
		return atracciones.get(0).getTipo();
	}

}
