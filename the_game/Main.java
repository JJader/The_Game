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
            System.out.println("Bem Vindo ao The Divinos Games");
            System.out.println("");
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("Notas dos desenvolvedores:");
            System.out.println("Esse Jogo trará a você experiências únicas, o mais legal: Você não mexerá um dedo");
            System.out.println("Personagens: ");
            System.out.println("A, B, C, D, E ... --> Atores ");
            System.out.println("# --> Herbivoro");
            System.out.println("+ --> Plantas");
            System.out.println("^ --> Ninho para reproduzir");
            System.out.println("O sistema será completamente autônomo, os atores serão independentes");
            System.out.println("As ações dos atores são baseadas em prioridades:");
            System.out.println("1) Comer \n2) Reproduzir \n3)Lutar \n4) Andar um espaço vazio");
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("");         
            System.out.println("Quantos atores você quer no ambiente???");
            numero = in.nextInt();
            //-------------------------------------------------------------------------------------------
            
            for (int i = 0; i<numero; i++){
        	kMapa.alocando();
            }
            kMapa.addNinho();
            kMapa.apresenta_mapa();    
           
           while (kMapa.atores.size()>0){   
               
           for (int k = 0; k<kMapa.atores.size(); k++){
               kMapa.HeroiPensa(k, kMapa);
               try {Thread.sleep(1000);}
               catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);}
               kMapa.apresenta_mapa();
           }
           }   
}}