package the_game;

import java.util.logging.Level;
import java.util.logging.Logger;
import personagens.A_Ator;
import mapa.Z_Mapa;

public class Main {

    
	public static void main(String[] args) {
		
        	Z_Mapa kMapa = new Z_Mapa();
		kMapa.alocando();
		kMapa.alocando();
                kMapa.alocando();
                kMapa.alocando();
                kMapa.alocando();
                kMapa.apresenta_mapa();    
           
           while (true){   
               
           for (int k = 0; k<kMapa.atores.size(); k++){
               System.out.println(kMapa.atores.size());
               kMapa.HeroiOlhar(k);
               try {Thread.sleep(2000);}
               catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);}
               kMapa.apresenta_mapa();
           }
           
           }   
}}