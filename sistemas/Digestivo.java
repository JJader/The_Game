package sistemas;

import personagens.A_Ator;

public class Digestivo {
    
    public void andar(A_Ator a, int energia){
    a.energia += energia;
        System.out.println("Ator " + a.nome + " " + a.energia);
    }
    
}
