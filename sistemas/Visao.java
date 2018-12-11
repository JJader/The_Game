package sistemas;

import mapa.Z_Mapa;
import personagens.A_Ator;

public class Visao{

    Locomotor loco= new Locomotor(); 
    Reprodutor repr = new Reprodutor();
    Digestivo dige = new Digestivo();

public void olhar(int[] a, char[][] mapa, A_Ator ator, Z_Mapa m){
    
    if (ator.infectado){ // se ele for infectado ele vai olhar de forma infectada
        olharInfectado(a, mapa, ator, m);
        return;
    }
    
    int[][] localizacoes = new int[4][2]; // possiveis localizações para ir
    int cont=0;
    int c = 0, d = 0; // variáveis auxiliares para andar para cima, baixo, esquerda e direita
    boolean reproduzir = false, batalhar = false, comer = false;
    int[] ninho = new int [2];// localização do ninho
    int[] inimigo = new int [2]; // localização do inimigo
    int[] comida = new int [2]; // localização da comida
    
    for (int i = 0; i<4; i++){
            switch (i) {
            case 0: c = -1;d = 0;break; // aqui vou setando cada auxiliar para depois somar com
            case 1: c =  1;d = 0;break; // a posição do meu ator, assim vejo nas quatro diferentes
            case 2: c = 0 ;d =-1;break; // posições
            case 3: c = 0 ;d = 1;break;
            default:break;
        }
                
        if ((a[0]+c < 16) && (a[0]+c >= 0) && (a[1]+d < 16) && (a[1]+d) >= 0){ // olho se não tem excessão
        
        if ( (mapa[a[0]+c][a[1]+d] == m.planta) || (mapa[a[0]+c][a[1]+d] == m.herbivoro) || (mapa[a[0]+c][a[1]+d] == m.Planta_zumbir)){ 
      //System.out.println("comida"); se ele ver algo comestivel
            comida[0] = a[0]+c; 
            comida[1] = a[1]+d;
            comer = true;
         }//fim do if comida
    
        else if (mapa[a[0]+c][a[1]+d] == m.ninho){ // se ele ver um ninho
            ninho[0] = a[0]+c;
            ninho[1] = a[1]+d;
            reproduzir = true;
         }//fim do if ninho
      
        else if ((mapa[a[0]+c][a[1]+d] == m.vazio )){ // se ele ver apenas espaços vazios
      //System.out.println("Vazio");
            localizacoes[cont][0]=a[0]+c;
            localizacoes[cont][1]=a[1]+d;
            cont++;
         }//fim do if vazio
           
      else if (mapa[a[0]+c][a[1]+d] != ator.nome) { // se ele ver um inimigo
            inimigo[0] = a[0]+c;
            inimigo[1] = a[1]+d;
            batalhar = true;
      }// fim do if batalha
      
       else if (mapa[a[0]+c][a[1]+d] == ator.nome && ator.ciclo<=0) { // se ele ver alguem da especie dele e ele estiver em um ciclo reprodutivo
       int[] b= {a[0]+c,a[1]+d};
       repr.reproduzir(m, m.HeroiLocaliza(b), ator);
       m.c.setText(ator.nome + " Reproduziu com outro");
       return;
      }//fim do if reproduzir
       
} // fim do if de exessão
}// fim do for
    if ((comer && ator.energia<300) || (comer && !reproduzir)){ // se ele tiver visto comida e sua energia for menor que 300, ou ele ter visto comida e não ter visto ninho
        if (mapa[comida[0]][comida[1]] == m.planta){dige.energia(ator, 20);}
        else if(mapa[comida[0]][comida[1]] == m.herbivoro){dige.energia(ator, 40);}
        else if (mapa[comida[0]][comida[1]] == m.Planta_zumbir){dige.infectar(ator);}
        loco.andar(mapa, comida, ator);
        m.c.setText("Ator " + ator.nome + " " + ator.energia);
        return;
    }
    else if (reproduzir){ // se ele viu um ninho
          repr.reproduzir(m, ninho, ator);
          System.out.println(ator.nome + " reproduziu");
          m.c.setText(ator.nome + " Clonou-se");
          return;
    }
    else if(batalhar){ // se ele viu um inimigo
        dige.devora(ator, m.HeroiLocaliza(inimigo));
        loco.andar(mapa, ator.localizacao, ator);
        m.HeroiMorre();
        m.c.setText(ator.nome + " Batalhou");
        return;
    }
    
    loco.andar(mapa, localizacoes, ator, cont); // se nada disso ocorreu então ele sorteará uma posição vazia para andar
    dige.energia(ator, -10);
    m.c.setText("Ator " + ator.nome + " " + ator.energia);  
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
      
       if (mapa[a[0]+c][a[1]+d] != m.Planta_zumbir && mapa[a[0]+c][a[1]+d] != dige.zumbi && mapa[a[0]+c][a[1]+d] != m.vazio && mapa[a[0]+c][a[1]+d] != m.planta && mapa[a[0]+c][a[1]+d] != m.herbivoro && mapa[a[0]+c][a[1]+d] != m.ninho) {
          int[] b= {a[0]+c,a[1]+d}; // se ele tiver visto um outro ator não zumbi
          A_Ator des = m.HeroiLocaliza(b);
          dige.devora(des, ator);
          loco.andar(mapa, des.localizacao, des);
          m.HeroiMorre();
          m.c.setText("Zumbi atacou");
          return;
      }
      
      else if ((mapa[a[0]+c][a[1]+d] == m.vazio )){
      //System.out.println("Vazio");
          localizacoes[cont][0]=a[0]+c;
          localizacoes[cont][1]=a[1]+d;
          cont++;
      }         
} // fim do if de exessão
}// fim do for
    loco.andar(mapa, localizacoes, ator, cont);
    dige.energia(ator, -10);
    m.c.setText("Zumbi "+ ator.energia);
        
}// fim do método
}// fim da clase