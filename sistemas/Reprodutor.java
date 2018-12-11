package sistemas;

import java.util.Random;
import mapa.Z_Mapa;
import personagens.A_Ator;

public class Reprodutor {
    
    Random deficiencia = new Random(); // o ator se for produzido em um ninho ele pode nascer com deficiencia
    // ou seja, uma quantidade muito pouca de energia
    
    public void reproduzir(Z_Mapa m, int[] a, A_Ator pai){
            boolean x = deficiencia.nextBoolean();    
            A_Ator d = new A_Ator(pai.nome);
            if (x){d.energia = pai.energia;}
            else{d.energia = 20;}
            d.localizacao[0] = a[0];
            d.localizacao[1] = a[1];
            pai.ciclo = 3;
            m.HeroiNasce(d);
    }
    
    public void reproduzir(Z_Mapa m, A_Ator mae, A_Ator pai){
            mae.ciclo = 3;
            pai.ciclo = 3;
            m.HeroiNasce(mae.nome);
    }
}
