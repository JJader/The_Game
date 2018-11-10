package the_game;

import java.util.logging.Level;
import java.util.logging.Logger;
import personagens.A_Ator;

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
                kMapa.retornaPosicao('A');
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