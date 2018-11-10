package the_game;

import java.util.ArrayList;
import java.util.Random;
import personagens.A_Ator;

public class Z_Mapa{

	public char mapa[][] = new char[16][16];
	public ArrayList<A_Ator> atores;
        private char a = '-';
        
	
	public Z_Mapa() {
            
            	atores = new ArrayList<>();
		for (int i = 0; i<16; i++) {
			for(int j = 0; j<16; j++) {
				mapa[i][j] = a;
			}}}
	
//----------------------------------------------------------------------------------------------
	
	public void apresenta_mapa() {
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
            Random p = new Random();
            try{
            A_Ator ator = new A_Ator();
            atores.add(ator);
            while(true) {
		int x = p.nextInt(16);
		int y = p.nextInt(16);
		if (mapa[x][y] == a) {
			ator.localizacao[0] = x;
			ator.localizacao[1] = y;
			mapa[x][y] = ator.nome;
			return;
                }}}catch(IndexOutOfBoundsException e){
                    System.out.println("Você não pode colocar mais atores");
                }
        }

        public void retornaPosicao(char nome){
            for(int i = 0; i< atores.size(); i++){
                if(atores.get(i).nome == nome){
                    System.out.println("Posição: x = " + atores.get(i).localizacao[0]);
                    System.out.println("Posição: y = " + atores.get(i).localizacao[1]); 
                    return;}
            }
            }
//----------------------------------------------------------------------------------------------
        
}
