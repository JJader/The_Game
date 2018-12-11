package the_game;

import Interface.Menu;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import mapa.Z_Mapa;

public class Main {
	public static void main(String[] args) throws IOException {
	    Scanner in = new Scanner(System.in);
        
            Menu menu = new Menu();
            int numero = menu.numero;
            while(numero == 0){numero = menu.numero; System.out.println(numero);} // fico esperando até o usuário inserir um valor
            
            Z_Mapa kMapa = new Z_Mapa();
            //-------------------------------------------------------------------------------------------
            
            for (int i = 0; i<numero; i++){
                kMapa.alocando();
            }
                kMapa.addNinho();
                kMapa.apresenta_mapa();    
           
           numero = 0;
           while (kMapa.atores.size()>0){       
           for (int k = 0; k<kMapa.atores.size(); k++){
               kMapa.HeroiPensa(k, kMapa);
               try {Thread.sleep(1000);} // espera 1 segundo
               catch (InterruptedException ex) {Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);}
               kMapa.apresenta_mapa();   
           }
           if (numero > 2){kMapa.addSeres(kMapa.planta); numero = 0;}
           else{numero++;}
           }  
           kMapa.janela.exit();
           
}}