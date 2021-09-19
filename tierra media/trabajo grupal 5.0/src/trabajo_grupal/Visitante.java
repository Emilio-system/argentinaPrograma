package trabajo_grupal;

import java.util.ArrayList;

public class Visitante {
private String nombre;
private double presupuesto;
private double tiempo;
private TipoAtraccion preferencia;

private  ArrayList<Atraccion_Promo> itinerario;

public Visitante( String nombre,double presupuesto,double tiempo,TipoAtraccion preferencia) {
	this.nombre=nombre;
	this.presupuesto=presupuesto;
	this.tiempo=tiempo;
	this.preferencia=preferencia;
	this.itinerario=new ArrayList<>();
}

public void agregarItinerario(Atraccion_Promo atraccion_promo) {
	itinerario.add(atraccion_promo);
}
public ArrayList<Atraccion_Promo> getItinerario() {
	return itinerario;
}

public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public double getPresupuesto() {
	return presupuesto;
}
public void setPresupuesto(double presupuesto) {
	this.presupuesto = presupuesto;
}
public double getTiempo() {
	return tiempo;
}

public TipoAtraccion getPreferencia() {
	return preferencia;
}
public void setTiempo(double tiempo) {
	this.tiempo = tiempo;
}

public void comprar(Atraccion_Promo atraccion_promo){
	this.agregarItinerario(atraccion_promo);
	this.setTiempo(this.tiempo-atraccion_promo.getTiempo());
	this.setPresupuesto(this.presupuesto-atraccion_promo.getCosto());
}

public boolean puedeComprar(Atraccion_Promo atraccion_promo){
	return (this.tiempo>atraccion_promo.getTiempo()&&this.presupuesto>atraccion_promo.getCosto());
}


public String toString() {
	return "Nombre: "+this.nombre+"; Presupuesto: "+this.presupuesto+"; Tiempo: "+this.tiempo+"; Preferencia: "+this.preferencia;
}
}
