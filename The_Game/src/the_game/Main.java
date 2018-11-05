package the_game;

public class Main {

	public static void main(String[] args) {
		
		A_Ator a = new A_Ator();
		A_Ator b = new A_Ator();
		A_Ator c = new A_Ator();
		A_Ator d = new A_Ator();
		A_Ator gustavo = new A_Ator();
		
		Z_Mapa kMapa = new Z_Mapa();
		kMapa.alocando(a);
		kMapa.alocando(b);
		kMapa.alocando(c);
		kMapa.alocando(d);
		kMapa.alocando(gustavo);
		
		

		kMapa.apresenta_mapa();
}
}