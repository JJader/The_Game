
package sistemas;

import mapa.Z_Mapa;
import personagens.A_Ator;



public class Visao extends Z_Mapa{

    Locomotor loco= new Locomotor();
    Reprodutor repr = new Reprodutor();
    Digestivo dige = new Digestivo();

public void olhar(int[] a, char[][] mapa, A_Ator ator, Z_Mapa m){
    
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
        
       if ( (mapa[a[0]+c][a[1]+d] == planta) || (mapa[a[0]+c][a[1]+d] == herbivoro) ){ 
      //System.out.println("comida"); 
        int[] b= {a[0]+c,a[1]+d};
        loco.andar(mapa, b, ator);
        if (mapa[a[0]+c][a[1]+d] == planta){dige.energia(ator, 20);}
        else{dige.energia(ator, 40);}
        
        return;}//fim do if comida
    
      else if (mapa[a[0]+c][a[1]+d] == ninho){
          int[] b= {a[0]+c,a[1]+d};
          repr.reproduzir(m, b, ator.nome, ator.energia);
           System.out.println(ator.nome + " reproduziu");
          return;
      }
      
      else if ((mapa[a[0]+c][a[1]+d] == vazio )){
      //System.out.println("Vazio");
          localizacoes[cont][0]=a[0]+c;
          localizacoes[cont][1]=a[1]+d;
          cont++;
  }   
      else if (mapa[a[0]+c][a[1]+d] == Planta_zumbir){ 
      //System.out.println("comida"); 
        int[] b= {a[0]+c,a[1]+d};
        loco.andar(mapa, b, ator);
        dige.infectar(ator);
        return;}//fim do if comida
      
           
      else if (mapa[a[0]+c][a[1]+d] != ator.nome) {
          int[] b= {a[0]+c,a[1]+d};
           dige.devora(ator, m.HeroiLocaliza(b));
            m.HeroiMorre();
           return;
      }
} // fim do if de exessão
}// fim do for
    loco.andar(mapa, localizacoes, ator, cont);
    dige.energia(ator, -10);
}// fim do método 


public void olharInfectado(int[] a, char[][] mapa, A_Ator ator, Z_Mapa m){
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
      
      if (mapa[a[0]+c][a[1]+d] != Planta_zumbir && mapa[a[0]+c][a[1]+d] != dige.zumbir && mapa[a[0]+c][a[1]+d] != vazio && mapa[a[0]+c][a[1]+d] != planta && mapa[a[0]+c][a[1]+d] != herbivoro && mapa[a[0]+c][a[1]+d] != ninho) {
          int[] b= {a[0]+c,a[1]+d};
          dige.devora(m.HeroiLocaliza(b), ator);
           m.HeroiMorre();
           return;
      }
      
      else if ((mapa[a[0]+c][a[1]+d] == vazio )){
      //System.out.println("Vazio");
          localizacoes[cont][0]=a[0]+c;
          localizacoes[cont][1]=a[1]+d;
          cont++;
      }         
} // fim do if de exessão
}// fim do for
    loco.andar(mapa, localizacoes, ator, cont);
    dige.energia(ator, -10);
}// fim do método

}// fim da clase