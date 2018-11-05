package the_game;



public class A_Ator {

	private char n[] = {'A','B','C','D','E','F','G'};
	private static int a = 0;
	
	
	int localizacao[] = new int[2]; // (x,y)
	int energia;
	char nome;
	
//----------------------------------------------------------------------------------------------

	public A_Ator() {
		nome = n[a];
		a++;
		energia = 10;		
	}}
