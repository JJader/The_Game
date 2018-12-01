package mapa;

import Interface.Cenario;
import jplay.GameImage;
import jplay.Keyboard;
import jplay.Window;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
        
        Window janela;
        GameImage fundo;
        Keyboard tecla;
        Cenario cenario;
        FileWriter arq;
        PrintWriter escvr;
	
	public Z_Mapa() throws IOException {
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
        "%%");
            arq.close();
            
            janela = new Window(401, 401);
            tecla = janela.getKeyboard();
            cenario = new Cenario(janela);
            atores = new ArrayList<>();
                
		for (int i = 0; i<16; i++) {
			for(int j = 0; j<16; j++) {
				mapa[i][j] = vazio;
			}}
                           
                for (int i = 0; i<60; i++){
                    addSeres(planta);
                }
                for (int i = 0; i<40; i++){
                    addSeres(herbivoro);
                }
           }
	
//----------------------------------------------------------------------------------------------
	
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
                        escreve_mapa();
		}}
        
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
        str + "%%");
        arq.close();
        cenario.run();
        }
	
//----------------------------------------------------------------------------------------------

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
        }
        
        public void addSeres(char ser){
            int x,y;
            while (true){
                x = p.nextInt(16);
                y = p.nextInt(16);
                if (mapa[x][y] == vazio){mapa[x][y] = ser; return;}
            }
        }
       
        public void addNinho (){
            for (int i = 0; i < atores.size(); i++){
                    addSeres(ninho);
                    addSeres(ninho);
                    addSeres(Planta_zumbir);
                }
        }
        
//----------------------------------------------------------------------------------------------
                
        public A_Ator HeroiLocaliza(int[] nu){
            int i;
                            
            for (i = 0; i < atores.size(); i++){
                if (atores.get(i).localizacao[0] == nu[0] && atores.get(i).localizacao[1] == nu[1]){
                    return atores.get(i);
                }}
            return new A_Ator('0');
        }
         
        public void HeroiPensa(int nu, Z_Mapa m){
            try{
                atores.get(nu).olhar(atores.get(nu).localizacao, mapa, atores.get(nu), m); 
            }
            catch(IndexOutOfBoundsException e){System.out.println("Não tem heroi");}
            }
        
        public void HeroiMorre(){
            for(int i = 0; i< atores.size(); i++){
                if (atores.get(i).energia <= 0){
                    mapa[atores.get(i).localizacao[0]][atores.get(i).localizacao[1]] = vazio;
                    atores.remove(i);
                    }}
        }
        
        public void HeroiNasce(A_Ator a){
            atores.add(a);
            mapa[a.localizacao[0]][a.localizacao[1]] = a.nome; 
        }
        
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
			return;
                }}
        }

//----------------------------------------------------------------------------------------------
}        

