package personagens;
import sistemas.Visao;

public class A_Ator extends Visao{

        private static char[] n = {'A','B','C','D','E','F','G'}; // seto os nomes dos meus atores nesse vetor
    	public static int a = 0;
	public int id;
	
	public int[] localizacao = new int[2]; // (x,y)
        public int ciclo; // ciclo reprodutivo, até ele reproduzir novamente
	public int energia;
	public char nome;
        public boolean infectado;

	public A_Ator() {
                ciclo = 3;
                infectado = false;
                nome = n[a];
		id = a;
                a++;
		energia = 40;                 
	}
        
        public A_Ator(char c){
            ciclo = 3;
            infectado = false;
            nome = c;
            energia = 40;
            id = a;
            a++;
        }

}
