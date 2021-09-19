package trabajo_grupal;

import java.util.ArrayList;

public class Atraccion implements Atraccion_Promo {
private double costo;
private double tiempo;
private int personas;
private String nombre;
private TipoAtraccion tipo;

public Atraccion(String nombre,double costo,double tiempo,int personas, TipoAtraccion tipo ) {
	this.nombre=nombre;
	this.costo=costo;
	this.tiempo=tiempo;
	this.personas=personas;
	
	this.tipo=tipo;
	
	
}
public Atraccion() {}

public double getCosto() {
	return costo;
}
public void setCosto(double costo) {
	this.costo = costo;
}
public double getTiempo() {
	return tiempo;
}
public void setTiempo(double tiempo) {
	this.tiempo = tiempo;
}
public int getPersonas() {
	return personas;
}
public String getNombre() {
	return nombre;
}
public void setPersonas(int personas) {
	this.personas = personas;
};
public TipoAtraccion getTipo() {
	return this.tipo;
}

public void descontar_Cupo() {
	this.personas = personas-1;
};
public ArrayList<Atraccion> getAtracciones() {
	ArrayList<Atraccion> atracciones=new ArrayList<>();
	
	atracciones.add(this);
return	atracciones;
}
public String toString() {
	String promo= "Nombre: "+this.nombre+"; Costo: "+this.costo+"; Cupo diponibre: "+this.personas+"; Tiempo: "+this.tiempo+"; Tipo: "+this.tipo;
	
	return promo;
}
public boolean esOcontiene(Atraccion_Promo atraccion_Promo) {
	return true;
}
}
