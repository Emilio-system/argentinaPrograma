package trabajo_grupal;

import java.util.ArrayList;

public class Promocion_Total extends Promocion{
private double total;

public Promocion_Total( String nombre, ArrayList<Atraccion> atracciones,double total) {
	this.total=total;
	this.nombre=nombre;
	this.atracciones=atracciones;
	
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
public String toString() {
		
	String promo= "\nNombre Promocion: "+this.nombre+"; Tipo: Total "+
		"; Costo: "+this.getCosto()+"; Tiempo: "+this.getTiempo();
		
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
public ArrayList<Atraccion> getAtracciones() {
return	atracciones;
}

public void descontar_Cupo() {
	for(Atraccion a : atracciones) {
		a.descontar_Cupo();
	}
}

public double getCosto() {
	
	return this.total;
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
