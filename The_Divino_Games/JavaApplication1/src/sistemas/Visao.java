
package sistemas;

import mapa.Z_Mapa;
import personagens.A_Ator;
import java.util.ArrayList;
import java.util.Random;


public class Visao extends Z_Mapa{

    Locomotor x= new Locomotor();
    

public void olhar(int a[], char mapa[][], A_Ator ator){
    
    int[][] localizacoes = new int[4][2];
    int cont=0;
    int c = 0, d = 0;
    for (int i = -1; i<=2; i++){
    
     if (i == -1){ c = -1; d = 0;}
else if (i == 0){ c = 1; d = 0;}
else if (i == 1){ c = 0; d = -1;}
else if (i == 2){ c = 0; d = 1;}
    
        
        try{
        if ( mapa[a[0]+c][a[1]+d] == carnivoro){ 
            System.out.println("perigo"); 
            
           
        try {
            int b[]= {a[0]-c,a[1]-d};
             x.andar(mapa, b, ator); 
        }catch(IndexOutOfBoundsException e) {
            if (mapa[a[0]+c][a[1]-d]==vazio){
             int b[]= {a[0]+c,a[1]-d};
             x.andar(mapa, b, ator);
            }
            else if (mapa[a[0]-c][a[1]+d]==vazio){
            int b[]= {a[0]-c,a[1]+d};
             x.andar(mapa, b, ator);
        }
            else if (mapa[a[0]+c][a[1]+d]==vazio) {
                int b[]= {a[0]+c,a[1]+d};
             x.andar(mapa, b, ator);
            }
        }
       
        
        return;  
        }
  else  if ( (mapa[a[0]+c][a[1]+d] == planta) || (mapa[a[1]+c][a[0]+d] == herbivoro) ){ 
     
      System.out.println("comida"); 
      
       int b[]= {a[0]+c,a[1]+d};
        x.andar(mapa, b, ator);
      
      return;  
  
  }
  
 
  else if ((mapa[a[0]+c][a[1]+d] == vazio )){
      System.out.println("Vazio");
      
          localizacoes[cont][0]=a[0]+c;
          localizacoes[cont][1]=a[1]+d;
          cont++;
  } 
        if (i==2){
            x.andar(mapa, localizacoes, ator);
        }
        }catch(IndexOutOfBoundsException e){}
    }
    
}    
}
