/* Essa classe é reponsável por ler o arquivo scm e criar o cenário da interface.
O arquivo scm pode ser compreendido como um arquivo de texto, de tal forma que cada
caracter é substituido por um sprite correspondente a ele.
*/
package Interface;
import jplay.Scene;
import jplay.Window;

public class Cenario {
private Window janela;
private Scene cena;

    public Cenario(Window janela) {
            this.janela = janela;
            cena = new Scene(); 
            run();
    }
    
    public void run(){ 
        
            cena.loadFromFile("src/Interface/scm/arq.scm");// caminho do arquivo scm
            cena.draw();
            janela.update();
    }
}
