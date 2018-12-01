package Interface;

import jplay.Scene;
import jplay.Window;

public class Cenario {

private Window janela;
private Scene cena;

    public Cenario(Window janela) {
            this.janela = janela;
            cena = new Scene();
            cena.loadFromFile("src/Interface/scm/arq.scm");
            run();
    }
    
    public void run(){ 
        cena.loadFromFile("src/Interface/scm/arq.scm");
        cena.draw();
        janela.update();
    }


    
}
