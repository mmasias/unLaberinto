import java.util.Scanner;
class UnRepaso{	
	static int posicionX, posicionY;
	public static void main(String[] args){
			
		int[][] unMapa = {
			{0,0,0,0,1,1,1,0,1,0,0,0,0,1,1,1,0,1,0},
			{0,1,1,0,0,0,0,0,1,0,1,1,0,0,0,0,0,1,0},
			{0,0,1,0,1,1,1,0,1,0,0,0,0,1,0,1,0,1,0},
			{0,0,1,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
			{1,0,0,0,1,0,1,1,1,1,1,0,0,1,1,1,0,1,0},
			{1,0,0,1,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
			{1,1,0,0,1,1,1,0,1,0,0,0,0,1,1,1,0,1,0},
			{0,1,1,0,0,0,0,0,1,0,0,1,0,1,0,0,0,0,0},
			{0,0,0,0,1,0,1,0,1,0,1,0,0,0,0,0,0,0,0},
			{0,1,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,1,0},
			{0,0,0,0,1,1,1,0,1,0,0,0,0,1,1,1,0,1,0},
			{0,1,1,0,0,0,0,0,1,0,1,1,0,0,0,0,0,1,0},
			{0,0,1,0,1,1,1,0,1,0,0,0,0,1,0,1,0,1,0},
			{0,0,1,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
			{0,0,1,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
			{1,0,0,0,1,0,1,1,1,1,1,0,0,1,1,1,0,1,0},
			{1,0,0,1,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
			{1,0,0,0,1,0,1,1,1,1,1,0,0,1,1,1,0,1,0},
			{0,0,0,0,1,0,1,0,1,0,1,0,0,0,0,0,0,0,0},
			{0,1,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,1,0},
			{0,0,0,0,1,1,1,0,1,0,0,0,0,1,1,1,0,1,0}
			};
		posicionX=2; 
		posicionY=0;

		do {
			imprimeMapa(unMapa);
			
		} while (procesaMovimiento(unMapa));
	
	}

	static boolean procesaMovimiento(int[][] elMapa){

		Scanner entrada = new Scanner(System.in);
		String inputUsuario;
		inputUsuario = entrada.nextLine();
		
		if (inputUsuario.equals("a") && elMapa[posicionY][posicionX-1]==0) {posicionX=posicionX-1;} else 
		if (inputUsuario.equals("d") && elMapa[posicionY][posicionX+1]==0) {posicionX=posicionX+1;} else 
		if (inputUsuario.equals("w") && elMapa[posicionY-1][posicionX]==0) {posicionY=posicionY-1;} else 
		if (inputUsuario.equals("s") && elMapa[posicionY+1][posicionX]==0) {posicionY=posicionY+1;} else 
		if (inputUsuario.equals("f")) { return false;}
		
		return true;
	}
	
	static void imprimePared(){
		System.out.print("[#]");
	}
	
	static void imprimeSuelo(){
		System.out.print(" . ");
	}

	static void imprimePersonaje(){
		System.out.print("\\O/");
	}

	static void imprimeBordeHorizontal(int laLongitud){

		for (int j=0;j<laLongitud;j=j+1){
			System.out.print("---");
		}
		System.out.println();		
	}
	
	static void imprimeMapa(int[][] mapaPorImprimir){
		
		imprimeBordeHorizontal(mapaPorImprimir[0].length);
		
		for (int i=0; i<mapaPorImprimir.length; i=i+1){
			for (int j=0; j<mapaPorImprimir[i].length; j=j+1) {
				if (i==posicionY && j==posicionX) {
					imprimePersonaje();
				} else {
					if (mapaPorImprimir[i][j]==0) {			imprimeSuelo();	} 
					else if (mapaPorImprimir[i][j]==1) {	imprimePared();	}
				}

			}
			System.out.println();
		}		
		imprimeBordeHorizontal(mapaPorImprimir[0].length);
		
		System.out.println("Personaje en X:["+posicionX+"] Y:["+posicionY+"]");
	}
	
}