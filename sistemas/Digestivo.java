package sistemas;
import personagens.A_Ator;

public class Digestivo {
    char zumbi = 'Ꮸ'; // caracter que representa um zumbi
    
    public void energia(A_Ator a, int energia){
        a.energia += energia;
        System.out.println("Ator " + a.nome + " " + a.energia);
    } // ator recebendo energia(pode ser negativa ou positiva)
    
    public void devora(A_Ator a, A_Ator b){
        if(a.energia < b.energia){
            b.energia += a.energia;
            a.energia = 0;
            if(b.infectado){infectar(a);}else{
                     System.out.println(b.nome + " matou " + a.nome );
            }
        }else{
            a.energia += b.energia;
            b.energia = 0;
            if(a.infectado){infectar(b);}else
            System.out.println(a.nome + " matou " + b.nome );
    }
    } // sistema de batalhar
    
    public void infectar(A_Ator a){
    System.out.println("Ator " + a.nome + " virou zumbir");
    a.energia += 100;
    a.nome = zumbi; 
    a.infectado = true;
    }
}
