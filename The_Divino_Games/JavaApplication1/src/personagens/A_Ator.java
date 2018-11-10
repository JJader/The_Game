package personagens;

import sistemas.Visao;



public class A_Ator extends Visao{

	private char n[] = {'A','B','C','D','E','F','G'};
	private static int a = 0;
	
	
	public int localizacao[] = new int[2]; // (x,y)
	public int energia;
	public char nome;
	
//----------------------------------------------------------------------------------------------

	public A_Ator() {
		nome = n[a];
		a++;
		energia = 10;		
	}}
