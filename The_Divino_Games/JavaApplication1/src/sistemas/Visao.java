
package sistemas;

import mapa.Z_Mapa;

public class Visao extends Z_Mapa{


public void olhar(int a[], char mapa[][]){
    int c = 0, d = 0;
    for (int i = -1; i<=2; i++){
    
     if (i == -1){ c = -1; d = 0;}
else if (i == 0){ c = 1; d = 0;}
else if (i == 1){ c = 0; d = -1;}
else if (i == 2){ c = 0; d = 1;}
    
        
        try{
        if ( mapa[a[0]+c][a[1]+d] == carnivoro ){ System.out.println("perigo"); return;  }
  else  if ( (mapa[a[0]+c][a[1]+d] == planta) || (mapa[a[1]+c][a[0]+d] == herbivoro) ){ System.out.println("comida"); return;  }
  else {System.out.println("Vazio");}      
        }catch(IndexOutOfBoundsException e){}
    }
    
}    
}
