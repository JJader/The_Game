/*
Essa classe é basicamente nosso mundo, é aqui que são produzidos o mapa, onde são
alocados os atores, herbivoros, plantas, e etc. É aqui que são localizado cada ator
e onde há o controle dos atores.
*/
package mapa;
//bibliotecas para a interface
import Interface.Cenario;
import java.awt.Color;
import java.awt.Label;
import jplay.Window;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
//bibliotecas para os atores
import java.util.ArrayList;
import java.util.Random;
import personagens.A_Ator;

public class Z_Mapa{

	public char[][] mapa = new char[16][16];
	public ArrayList<A_Ator> atores;
        public char vazio = ' ';
        public char planta = '+';
        public char ninho = '^';
        public char herbivoro = '#';
        public char Planta_zumbir = '$';
        
        Random p = new Random();
        
        public Window janela;
        Cenario cenario;
        FileWriter arq;
        PrintWriter escvr;
        public Label c = new Label();
	
	public Z_Mapa() throws IOException {
            //configuração inicial das variáveis (inicialização)
            arq = new FileWriter("src/Interface/scm/arq.scm");
            escvr = new PrintWriter(arq);
            escvr.printf("01\n" +
            "src/Interface/sprite/grama.png\n" +
            "01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 \n" +
            "01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 \n" +
            "01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 \n" +
            "01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 \n" +
            "01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 \n" +
            "01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 \n" +
            "01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 \n" +
            "01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 \n" +
            "01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 \n" +
            "01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 \n" +
            "01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 \n" +
            "01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 \n" +
            "01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 \n" +
            "01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 \n" +
            "01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 \n" +
            "01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 \n" +
            "%%"+ "\nsrc/Interface/sprite/fund.png");
            arq.close();
            
            c.setText("ola mundo doido");
            c.setBounds(600, 0, 200, 20);
            c.setBackground(Color.BLACK);
            c.setForeground(Color.GREEN);
            janela = new Window(800, 600);
            janela.add(c);
            cenario = new Cenario(janela);
            atores = new ArrayList<>();
            //------------------------------------------------------------------    
            // criando mapa, adicionando planta e herbivoros
            for (int i = 0; i<16; i++) {
		for(int j = 0; j<16; j++){
			mapa[i][j] = vazio;
                }
            }
            for (int i = 0; i<60; i++){
                addSeres(planta);
            }
            for (int i = 0; i<40; i++){
                addSeres(herbivoro);
            }
           } // criando mapa, alocando seres do ambiente, iniciando variaveis
	
	public void apresenta_mapa() throws IOException {
            HeroiMorre();
            System.out.println("    0     1     2     3     4     5     6     7     8     9     10    11    12    13    14    15");
            for (int i = 0; i<16; i++) {
                if (i<10){
                System.out.print(" " +i);
                } else {System.out.print(i);}
            for(int j = 0; j<16; j++) {
		System.out.print("[ " + mapa[i][j] + " ]" + " ");
	    }
		System.out.println();
		}
            escreve_mapa();
        } // apresentando o mapa como string
        
        public void escreve_mapa() throws IOException{ 
            
            String str = "01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 \n";
            for(int i = 0; i < 16; i++){
                for(int j = 0; j < 16; j++){
                    if(mapa[i][j] == vazio){ str += "01 ";}
                    else if(mapa[i][j] == planta){str += "02 ";}
                    else if(mapa[i][j] == herbivoro){str += "03 ";}
                    else if(mapa[i][j] == ninho){str += "04 ";}
                    else if(mapa[i][j] == 'A'){str += "05 ";}
                    else if(mapa[i][j] == 'B'){str += "06 ";}
                    else if(mapa[i][j] == 'C'){str += "07 ";}
                    else if(mapa[i][j] == 'D'){str += "08 ";}
                    else if(mapa[i][j] == 'E'){str += "09 ";}
                    else if(mapa[i][j] == 'F'){str += "10 ";}
                    else if(mapa[i][j] == 'G'){str += "11 ";}
                    else if(mapa[i][j] == 'Ꮸ'){str += "12 ";}
                    else if(mapa[i][j] == Planta_zumbir){str += "13 ";}        
                }
                str += "\n";
            }
        arq = new FileWriter("src/Interface/scm/arq.scm");
        escvr = new PrintWriter(arq);  
        escvr.printf(
        "15\n" +
        "src/Interface/sprite/grama.png\n" +
        "src/Interface/sprite/arvore.png\n" +
        "src/Interface/sprite/herbivoro.png\n" +
        "src/Interface/sprite/ninho.png\n" +
        "src/Interface/sprite/A.png\n" +
        "src/Interface/sprite/B.png\n" +
        "src/Interface/sprite/C.png\n" +
        "src/Interface/sprite/D.png\n" +
        "src/Interface/sprite/E.png\n" +
        "src/Interface/sprite/F.png\n" +
        "src/Interface/sprite/G.png\n" +
        "src/Interface/sprite/H.png\n" +
        "src/Interface/sprite/badPlant.png\n" +
        "src/Interface/sprite/terra.png\n" + 
        str + "%%" + "\nsrc/Interface/sprite/fund.png");
        arq.close();
        cenario.run();
        } // escrevendo arquivo scm para interface

	public void alocando() {
            
            try{
            A_Ator ator = new A_Ator();
            atores.add(ator);
            while(true) {
		int x = p.nextInt(16);
		int y = p.nextInt(16);
		if (mapa[x][y] == vazio) {
			ator.localizacao[0] = x;
			ator.localizacao[1] = y;
			mapa[x][y] = ator.nome;
			return;
                }}}catch(IndexOutOfBoundsException e){
                    System.out.println("Você não pode colocar mais atores");
                }
        } // Alocando os atores no mapa
        
        public void addSeres(char ser){
            int x,y;
            while (true){
                x = p.nextInt(16);
                y = p.nextInt(16);
                if (mapa[x][y] == vazio){mapa[x][y] = ser; return;}
            }
        }// adicionando caracter ao mapa, pode ser uma planta, herbivoro etc
       
        public void addNinho (){
            for (int i = 0; i < atores.size(); i++){
                    addSeres(ninho);
                    addSeres(ninho);
                }
            for (int i = 0; i<atores.size()*0.5; i++){
                addSeres(Planta_zumbir);
            }
        }//adicionando ninho e plantas zumbi
        
        public A_Ator HeroiLocaliza(int[] nu){
            int i;
            for (i = 0; i < atores.size(); i++){
                if (atores.get(i).localizacao[0] == nu[0] && atores.get(i).localizacao[1] == nu[1]){
                    return atores.get(i);
                }}
            return new A_Ator('0');
        } // função para localizar ator com base no vetor posição
         
        public void HeroiPensa(int nu, Z_Mapa m){
            try{
                atores.get(nu).olhar(atores.get(nu).localizacao, mapa, atores.get(nu), m); 
            }
            catch(IndexOutOfBoundsException e){System.out.println("Não tem heroi");}
            } // aqui vou chamar o sistema de visão para meu ator pensar
        
        public void HeroiMorre(){
            for(int i = 0; i< atores.size(); i++){
                if (atores.get(i).energia <= 0){
                    mapa[atores.get(i).localizacao[0]][atores.get(i).localizacao[1]] = vazio;
                    atores.remove(i);
                    }}
        } // exclui todos os atores que possuem energia zero
        
        public void HeroiNasce(A_Ator a){
            atores.add(a);
            mapa[a.localizacao[0]][a.localizacao[1]] = a.nome; 
        }// alocar novos atores que nasce durante o jogo 
        
        public void HeroiNasce(char nome) {
            A_Ator ator = new A_Ator(nome);
            while(true) {
		int x = p.nextInt(16);
		int y = p.nextInt(16);
		if (mapa[x][y] == vazio) {
			ator.localizacao[0] = x;
			ator.localizacao[1] = y;
			HeroiNasce(ator);
                        System.out.println(ator.nome +" nasceu em (" + ator.localizacao[0]  +" , " + ator.localizacao[1] + ")");
                        c.setText(" nasceu em (" + ator.localizacao[0]  +" , " + ator.localizacao[1] + ")");
			return;
                }}
        }

}        

