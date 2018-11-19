package the_game;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import personagens.A_Ator;
import mapa.Z_Mapa;

public class Main {

    
	public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
            Z_Mapa kMapa = new Z_Mapa();
            int numero;
            System.out.println("Quantos atores você quer no ambiente???");
            numero = in.nextInt();
            
            for (int i = 0; i<numero; i++){
        	kMapa.alocando();
            }
            
            kMapa.apresenta_mapa();    
           
           while (kMapa.atores.size()>0){   
               
           for (int k = 0; k<kMapa.atores.size(); k++){
               kMapa.HeroiOlhar(k);
               try {Thread.sleep(2000);}
               catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);}
               kMapa.apresenta_mapa();
           }
           
           }   
}}