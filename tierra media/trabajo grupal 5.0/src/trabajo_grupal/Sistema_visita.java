package trabajo_grupal;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;






public class Sistema_visita {
	private static ArrayList<Atraccion> atracciones;
	private static ArrayList<Promocion> promociones;
	private static ArrayList<Visitante> visitantes;
	private static ArrayList<Atraccion_Promo> atraccion_Promo;
	
	
	
	
	public static void main(String[] args) {	
		
	
		
		//System.out.println("Visitantes:\n");
		visitantes = Administrador_Archivo.leerVisitantes();
		
	//	for(Visitante v : visitantes) System.out.println(v);
		
		//System.out.println("\nAtracciones:\n");
		atracciones = Administrador_Archivo.leerAtracciones();
		
		//for(Atraccion v : atracciones) System.out.println(v);
		
		//System.out.println("\nPromociones:\n");
		promociones = Administrador_Archivo.leerPromociones(atracciones);
		
		/**for(Promocion v : promociones) {
			System.out.println(v);
			for(Atraccion a : v.getAtracciones()) System.out.println(a);
		}
		**/
		atraccion_Promo= new ArrayList<>();
		atraccion_Promo.addAll(atracciones);
		atraccion_Promo.addAll(promociones);
		
		
		
		for(Visitante v : visitantes) {
			System.out.println("\nVisitante:  ");
			System.out.println(v);
			System.out.println("--------------------------------------------------------------  ");
			// ordenar las atracciones segun preferencia costo y tiempo
		atraccion_Promo.sort(new Comparador_Atracciones(v.getPreferencia()));
		
		
		double dinero_disponible = v.getPresupuesto();
		double tiempo_disponible= v.getTiempo();
		double dinero_gastado= 0;
		double tiempo_consumido= 0 ;	
		
		ArrayList<Atraccion> atracciones_contratadas;
		
		atracciones_contratadas = new ArrayList<Atraccion>();
		
		for(Atraccion_Promo p : atraccion_Promo) { 
		// verificar li la atraccion tiene cupo
			boolean	atraccion_Comprada=false;
			for(Atraccion i : atracciones_contratadas) {
				if(p instanceof Atraccion) {
				if(i.equals(p)) {
					atraccion_Comprada = true;
				}
				}else {
					
					for(Atraccion h : p.getAtracciones()) {	
						if(i.equals(h)) {
							atraccion_Comprada = true;
						}
				}
				}
			}
			
		if(p.getPersonas()>0&&!atraccion_Comprada) {
			
			//if(dinero_disponible>=p.getCosto()&& tiempo_disponible>=p.getTiempo()) {
			if (v.puedeComprar(p)) {
				Scanner in = new Scanner(System.in);
				System.out.println("Promociones y/o atraccion ofrecida:\n");
				System.out.println(p);
			
				System.out.println("\nDesea aquirir??\n [v] adquirir, [q] no adquirir");
				
				String entrada = in.nextLine();
				if (entrada.equalsIgnoreCase("v")) {
					dinero_disponible = dinero_disponible - p.getCosto();
					tiempo_disponible = tiempo_disponible - p.getTiempo();
					dinero_gastado = dinero_gastado + p.getCosto();
					tiempo_consumido = tiempo_consumido + p.getTiempo();
					p.descontar_Cupo();
					v.comprar(p);
					
					atracciones_contratadas.addAll(p.getAtracciones());
					System.out.println("--------------------------------------------------------------  ");
					System.out.println("Dinero disponible:  "+v.getPresupuesto());
					System.out.println("Tiempo disponible:  "+v.getTiempo());
					System.out.println("--------------------------------------------------------------  ");
			}
		
		}
		
		
		
		}
		}
		System.out.println("\nNo tenemos mas promociones ni atracciones para ofrecerte:\n");
		System.out.println("Itinerario:\n");
		
		try {
            PrintWriter writer = new PrintWriter("files/Itinerario"+v.getNombre()+".txt", "UTF-8");
            writer.println("Visitante: "+v);
            writer.println("--------------------------------------------------------------  ");
            writer.println("Itinerario");
            writer.println("--------------------------------------------------------------  ");
            for(Atraccion_Promo x : v.getItinerario()) {
            	//System.out.println(x);
            	writer.println(x);
            	}
            writer.println("--------------------------------------------------------------  ");
            writer.println("Total a pagar: "+dinero_gastado+" Tiempo: "+tiempo_consumido);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		for(Atraccion_Promo x : v.getItinerario()) System.out.println(x);
		System.out.println("\n================================================================\n");
		
	}
	
	

	
	
	}

	}

