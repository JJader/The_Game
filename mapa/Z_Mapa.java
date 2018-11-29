package mapa;

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
        
	
	public Z_Mapa() {
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
	
	public void apresenta_mapa() {
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
		}}
	
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
                if(!atores.get(nu).infectado){
                atores.get(nu).olhar(atores.get(nu).localizacao, mapa, atores.get(nu), m);
                }else{
                atores.get(nu).olharInfectado(atores.get(nu).localizacao, mapa, atores.get(nu), m);
                }
                
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

//----------------------------------------------------------------------------------------------
}        

