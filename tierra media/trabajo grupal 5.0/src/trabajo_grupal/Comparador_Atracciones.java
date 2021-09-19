package trabajo_grupal;
import java.util.Comparator;




public class Comparador_Atracciones implements Comparator<Atraccion_Promo>{
	private TipoAtraccion preferencia;
	
	public Comparador_Atracciones(TipoAtraccion preferencia) {
		this.preferencia = preferencia;
	}
	
public int compare(Atraccion_Promo a, Atraccion_Promo b) {

		
	if(this.preferencia == a.getTipo() && this.preferencia != b.getTipo()) 
		return -1;
	else if(this.preferencia != a.getTipo() && this.preferencia == b.getTipo()) 
		return 1;
	
	else if(a instanceof Promocion && b instanceof Atraccion) 
			return -1;
		else if(b instanceof Promocion && a instanceof Atraccion) 
			return 1;
	
else {

			
      int resultado=  Double.compare(b.getCosto(), a.getCosto());
		
		if(resultado==0) {
			return resultado = Double.compare(b.getTiempo(), a.getTiempo());
		}else {
			return resultado;
		}
		
	}
}
}