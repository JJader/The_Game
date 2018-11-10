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
                kMapa.alocando();
                kMapa.alocando();
                
           
		kMapa.apresenta_mapa();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            kMapa.HeroiOlhar(0);
            kMapa.HeroiOlhar(1);
            kMapa.HeroiOlhar(2);
            kMapa.HeroiOlhar(3);
            kMapa.HeroiOlhar(4);
            kMapa.HeroiOlhar(5);
            kMapa.HeroiOlhar(6);
            kMapa.apresenta_mapa();
         
                /* int i = 0;
                while (true){
                    try { 
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                    System.out.println(i);
                i++;
                }*/
}
        
}