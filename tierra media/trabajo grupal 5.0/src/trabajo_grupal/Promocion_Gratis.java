package trabajo_grupal;

import java.util.ArrayList;

public class Promocion_Gratis extends Promocion {
private Atraccion atraccion;

public Promocion_Gratis(String nombre, ArrayList<Atraccion> atracciones, Atraccion atraccion) {
	this.atraccion=atraccion;
	this.nombre=nombre;
	this.atracciones=atracciones;
}

	
	public Atraccion getAtraccion() {
		return atraccion;
	}
	public void setAtraccion(Atraccion atraccion) {
		this.atraccion = atraccion;
	}
	
public String toString() {
		
	String promo= "Nombre Promocion: "+this.nombre+"; Tipo: Gratis "+"; Atraccion gratuita: "+
		this.atraccion.getNombre()+"; Costo: "+this.getCosto()+"; Tiempo: "+this.getTiempo();
	for(Atraccion a : atracciones) {
		promo=promo+"\n       "+a;
	}
	return promo+"\n       "+atraccion;
	}

public int getPersonas() {
	int v=0;
	for(Atraccion a : atracciones) {
		v=v+a.getPersonas();
	}
	return v+atraccion.getPersonas();
}

public double getCosto() {
	double v=0;
	for(Atraccion a : atracciones) {
		v=v+a.getCosto();
	}
	return v;
}
public void descontar_Cupo() {
	for(Atraccion a : atracciones) {
		a.descontar_Cupo();
	}
	atraccion.descontar_Cupo();
}
public ArrayList<Atraccion> getAtracciones() {
	ArrayList<Atraccion> atraccionesmasgratis=new ArrayList<>();
	for(Atraccion a : atracciones) {
		atraccionesmasgratis.add(a);
	}
	atraccionesmasgratis.add(atraccion);
return	atraccionesmasgratis;
}

public double getTiempo() {
	double v=0;
	for(Atraccion a : atracciones) {
		v=v+a.getPersonas();
	}
	return v+atraccion.getTiempo();
}

public  TipoAtraccion getTipo() {
	return atracciones.get(0).getTipo();
}
}
