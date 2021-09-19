package trabajo_grupal;

import java.util.ArrayList;

public interface Atraccion_Promo {
	public int getPersonas();

	public double getCosto();

	public double getTiempo();
	
	public  TipoAtraccion getTipo();
	
	public void descontar_Cupo();
	
	public ArrayList<Atraccion> getAtracciones();
		
	//public boolean esOcontiene(Atraccion_Promo atraccion_Promo);
}
