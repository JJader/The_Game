
package sistemas;


import java.util.Random;
import personagens.A_Ator;

public class Locomotor extends mapa.Z_Mapa{
    Digestivo d = new Digestivo();
   public void andar (char[][] mapas, int[] vetor, A_Ator a ){
       
       mapas[a.localizacao[0]][a.localizacao[1]]=vazio;
       a.localizacao[0]=vetor[0];
       a.localizacao[1]=vetor[1];
       if(mapas[vetor[0]][vetor[1]] == herbivoro) {d.andar(a, 40);}
       else if(mapas[vetor[0]][vetor[1]] == planta) {d.andar(a, 20);}
       else if(mapas[vetor[0]][vetor[1]] == vazio) {d.andar(a, -10);}
       
       mapas[vetor[0]][vetor[1]]=a.nome;
   }
   
   public void andar (char[][] mapas, int[][] matriz, A_Ator a, int tam ){
      Random y = new Random();
     
      while(true){
     int k = y.nextInt(tam);
     try{
         mapas[a.localizacao[0]][a.localizacao[1]]=vazio;
         a.localizacao[0]=matriz[k][0];
         a.localizacao[1]=matriz[k][1];
         if (mapas[matriz[k][0]][matriz[k][1]] == vazio){ d.andar(a, -10);}
         mapas[a.localizacao[0]][a.localizacao[1]]=a.nome;
    return;
     } catch(IndexOutOfBoundsException e){}
   }
      
   }
    
}
