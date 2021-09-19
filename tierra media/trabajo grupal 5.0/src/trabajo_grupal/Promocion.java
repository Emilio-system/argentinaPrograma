package trabajo_grupal;

import java.util.ArrayList;



public abstract class Promocion implements Atraccion_Promo {
public String nombre;
public ArrayList<Atraccion> atracciones;


public String getNombre() {
	return nombre;
}
public ArrayList<Atraccion> getAtracciones() {
	return atracciones;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}



}
