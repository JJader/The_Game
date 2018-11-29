
package sistemas;

import java.util.Random;
import mapa.Z_Mapa;
import personagens.A_Ator;


public class Reprodutor {
    
    Random deficiencia = new Random();
    
    public void reproduzir(Z_Mapa m, int[] a, char nome, int energia){
            boolean x = deficiencia.nextBoolean();    
            A_Ator d = new A_Ator(nome);
            
            if (x){d.energia = energia;}
            else{d.energia = 20;}
            d.localizacao[0] = a[0];
            d.localizacao[1] = a[1];
            m.HeroiNasce(d);
    }
    
}
