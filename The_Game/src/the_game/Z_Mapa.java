package the_game;

import java.util.Random;

public class Z_Mapa {

	public char mapa[][] = new char[16][16];
	Random p = new Random();
	
	public Z_Mapa() {
		
		for (int i = 0; i<16; i++) {
			for(int j = 0; j<16; j++) {
				mapa[i][j] = '-';
			}}}
	
//----------------------------------------------------------------------------------------------
	
	public void apresenta_mapa() {
		for (int i = 0; i<16; i++) {
			for(int j = 0; j<16; j++) {
				System.out.print(mapa[i][j] + " ");
			}
			System.out.println();
		}}
	
//----------------------------------------------------------------------------------------------

	public void alocando(A_Ator ator) {
		boolean a = true;
		
		while(a) {
		int x = p.nextInt(16);
		int y = p.nextInt(16);
		if (mapa[x][y] == '-') {
			ator.localizacao[0] = x;
			ator.localizacao[1] = y;
			mapa[x][y] = ator.nome;
			a = false;
		}}}

//----------------------------------------------------------------------------------------------

}
