package personagens;

import java.util.ArrayList;
import sistemas.Visao;



public class A_Ator extends Visao{

	//private char n[] = {'A','B','C','D','E','F','G'};
    
     ArrayList<Character> n = new ArrayList<Character>();
	public static int a = 0;
	public int id;
	
	public int localizacao[] = new int[2]; // (x,y)
	public int energia;
	public char nome;
	
//----------------------------------------------------------------------------------------------

	public A_Ator() {
            n.add('A');
            n.add('B');
            n.add('C');
            n.add('D');
            n.add('E');
            n.add('F');
            n.add('G');
            n.add('H');
            n.add('I');
            n.add('J');
            
                nome = n.get(a);
		id = a;
                a++;
		energia = 40;
                
                 
	}
        
        public A_Ator(char c){
            nome = c;
            energia = 40;
            id = a;
            a++;
            
        }



}
