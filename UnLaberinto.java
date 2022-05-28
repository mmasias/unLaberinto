import java.util.Scanner;
class UnLaberinto{	

	private static int posicionX, posicionY;
	private static int ALCANCE_ANTORCHA = 8;
	
	private static String INICIO = "\033[";
	private static String RESET = "\033[0m";

    private static String BLACK = "0;30";
    private static String RED = "0;31";
    private static String GREEN = "0;32";
    private static String YELLOW = "0;33";
    private static String BLUE = "0;34";
    private static String PURPLE = "0;35";
    private static String CYAN = "0;36";
    private static String WHITE = "0;37";

    private static String BLACK_BOLD = "1;30";  
    private static String RED_BOLD = "1;31";    
    private static String GREEN_BOLD = "1;32";  
    private static String YELLOW_BOLD = "1;33"; 
    private static String BLUE_BOLD = "1;34";   
    private static String PURPLE_BOLD = "1;35"; 
    private static String CYAN_BOLD = "1;36";   
    private static String WHITE_BOLD = "1;37";  	

	private static String BLACK_BACKGROUND = ";40m";
    private static String RED_BACKGROUND = ";41m";
    private static String GREEN_BACKGROUND = ";42m";
    private static String YELLOW_BACKGROUND = ";43m";
    private static String BLUE_BACKGROUND = ";44m";
    private static String PURPLE_BACKGROUND = ";45m";
    private static String CYAN_BACKGROUND = ";46m";
    private static String WHITE_BACKGROUND = ";47m";	

	public static void main(String[] args){
			
		int[][] unMapa = {
			{0,0,2,0,1,1,1,0,1,0,0,0,0,1,1,1,0,1,0},
			{2,2,2,0,3,3,3,0,1,0,1,1,0,0,0,0,0,1,0},
			{0,2,2,0,3,3,3,0,1,0,0,0,0,1,0,1,0,1,0},
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

	private static boolean procesaMovimiento(int[][] elMapa){

		Scanner entrada = new Scanner(System.in);
		String inputUsuario;
		
		inputUsuario = entrada.nextLine();
		
		if (inputUsuario.equals("a") && elMapa[posicionY][posicionX-1]%2==0) {posicionX=posicionX-1;} else 
		if (inputUsuario.equals("d") && elMapa[posicionY][posicionX+1]%2==0) {posicionX=posicionX+1;} else 
		if (inputUsuario.equals("w") && elMapa[posicionY-1][posicionX]%2==0) {posicionY=posicionY-1;} else 
		if (inputUsuario.equals("s") && elMapa[posicionY+1][posicionX]%2==0) {posicionY=posicionY+1;} else 
		if (inputUsuario.equals("f")) { return false;}

		return true;

	}
	
	private static void imprimeMapa(int[][] mapaPorImprimir){
		
		limpiaPantalla();
		imprimeBordeHorizontal(mapaPorImprimir[0].length);
		
		for (int i=0; i<mapaPorImprimir.length; i=i+1){
			imprimeBordeVertical(false);
			for (int j=0; j<mapaPorImprimir[i].length; j=j+1) {
				if (puedoVer(i,j,ALCANCE_ANTORCHA)) {
					if (i==posicionY && j==posicionX) {
						imprimePersonaje();
					} else {
						imprimeElemento(mapaPorImprimir[i][j]);
					}
				} else {
					imprimeVacio();
				}
			}
			imprimeBordeVertical(true);
		}		
		imprimeBordeHorizontal(mapaPorImprimir[0].length);
		
		System.out.println("Personaje en X:["+posicionX+"] Y:["+posicionY+"]");

	}

	private static void limpiaPantalla(){

		System.out.print("\033[H\033[2J");
		System.out.flush();

	}

	private static void imprimeElemento(int elementoDelMapa) {
		String[] matrizDeElementos = {
		 	INICIO + YELLOW + GREEN_BACKGROUND + " . " + RESET,
			INICIO + WHITE + WHITE_BACKGROUND +"[#]" + RESET, 
			INICIO + RED + GREEN_BACKGROUND + "*" + RESET + INICIO + GREEN_BOLD	+ GREEN_BACKGROUND + "Y" + RESET + INICIO + RED + GREEN_BACKGROUND + "*" + RESET,
			INICIO + BLUE_BOLD + BLUE_BACKGROUND + "~ ~" + RESET
		};

		System.out.print(matrizDeElementos[elementoDelMapa]);
	}

	private static void imprimeVacio(){

		System.out.print(INICIO + BLACK + BLACK_BACKGROUND + "   " + RESET);

	}

	private static boolean puedoVer(int i, int j, int alcanceVision) {

		return Math.pow(posicionX-j,2)+Math.pow(posicionY-i,2)<=Math.pow(alcanceVision,2);

	}	

	private static void imprimePersonaje(){

		System.out.print("\\O/");

	}

	private static void imprimeBordeHorizontal(int laLongitud){

		System.out.print("+");
		for (int j=0;j<laLongitud;j=j+1){
			System.out.print("---");
		}
		System.out.println("+");	

	}

	private static void imprimeBordeVertical(boolean bordeDerecho){

		System.out.print("|");
		if (bordeDerecho) {System.out.println();}

	}

}