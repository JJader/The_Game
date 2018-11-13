
package sistemas;

import mapa.Z_Mapa;
import personagens.A_Ator;
import java.util.ArrayList;
import java.util.Random;


public class Visao extends Z_Mapa{

    Locomotor x= new Locomotor();
    

public void olhar(int[] a, char[][] mapa, A_Ator ator){
    
    int[][] localizacoes = new int[4][2];
    int cont=0;
    int c = 0, d = 0;
    
    for (int i = 0; i<4; i++){
            switch (i) {
            case 0: c = -1;d = 0;break;
            case 1: c =  1;d = 0;break;
            case 2: c = 0 ;d =-1;break;
            case 3: c = 0 ;d = 1;break;
            default:break;
        }
                
            if ((a[0]+c < 16) && (a[0]+c >= 0) && (a[1]+d < 16) && (a[1]+d) >= 0){
                
        if ( mapa[a[0]+c][a[1]+d] == carnivoro){ 
     //       System.out.println("perigo"); 
           try{
            if (mapa[a[0]-(c*2)][a[1]-(d*2)] != carnivoro){
            if (mapa[a[0]-c][a[1]-d]==vazio || mapa[a[0]-c][a[1]-d]==herbivoro || mapa[a[0]-c][a[1]-d]==planta){
                int b[]= {a[0]-c,a[1]-d};
                x.andar(mapa, b, ator);return;}
            }
           } catch(IndexOutOfBoundsException e1){
               try{
               if (mapa[a[0]-c][a[1]-d]==vazio || mapa[a[0]-c][a[1]-d]==herbivoro || mapa[a[0]-c][a[1]-d]==planta){
               int b[]= {a[0]-c,a[1]-d};
               x.andar(mapa, b, ator);return;}
               }catch(IndexOutOfBoundsException e2){}}
           
           try{
            if (mapa[a[0]+c][a[1]-d]==vazio || mapa[a[0]+c][a[1]-d]==herbivoro || mapa[a[0]+c][a[1]-d]==planta){
             int b[]= {a[0]+c,a[1]-d};
             x.andar(mapa, b, ator);return;}
           }catch(IndexOutOfBoundsException e1){}
           
           try{
            if (mapa[a[0]-c][a[1]+d]==vazio || mapa[a[0]+c][a[1]-d]==herbivoro || mapa[a[0]+c][a[1]-d]==planta){
            int b[]= {a[0]-c,a[1]+d};
            x.andar(mapa, b, ator);return;}
           }catch(IndexOutOfBoundsException e1){}
           
        }// fim do if carnivoro
        
      else  if ( (mapa[a[0]+c][a[1]+d] == planta) || (mapa[a[0]+c][a[1]+d] == herbivoro) ){ 
      //System.out.println("comida"); 
       int b[]= {a[0]+c,a[1]+d};
        x.andar(mapa, b, ator);
      return;}//fim do if comida
  
  else if ((mapa[a[0]+c][a[1]+d] == vazio )){
      //System.out.println("Vazio");
          localizacoes[cont][0]=a[0]+c;
          localizacoes[cont][1]=a[1]+d;
          cont++;
  } 
        
} // fim do if de exessão
}// fim do for
    x.andar(mapa, localizacoes, ator, cont);
            
}// fim do método 
}// fim da clase
