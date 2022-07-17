import java.util.Random;
import java.util.Scanner;

class UnLaberinto {
	public static void main(String[] args) {

		int[][] unMapa = {
				{ 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 2, 2, 0, 0, 3, 3, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 3, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1 },
				{ 1, 2, 2, 0, 0, 3, 3, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 3, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1 },
				{ 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1 },
				{ 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1 },
				{ 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1 },
				{ 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1 },
				{ 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1 },
				{ 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1 },
				{ 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1 },
				{ 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1 },
				{ 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1 },
				{ 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1 },
				{ 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1 },
				{ 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1 },
				{ 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1 },
				{ 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1 },
				{ 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1 },
				{ 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1 },
				{ 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1 },
				{ 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1 },
				{ 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1 },
				{ 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1 },
				{ 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1 },
				{ 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1 },								
				{ 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
		};
		int[][] elPersonaje = { { 7, 7 } };
		int[] elReloj = {16,0};
		int[][] losNPCs = {
				{ 12, 14 },
				{ 12, 12 },
				{ 14, 14 },
				{ 14, 12 }
		};

		do {
			pasaElTiempo(elReloj);
			imprimeMundo(unMapa, elPersonaje, losNPCs, elReloj);
		} while (procesaMovimiento(unMapa, elPersonaje, losNPCs));
	}

	private static void pasaElTiempo(int[] elReloj) {

		elReloj[1]=elReloj[1]+10;
		if (elReloj[1]==60){
			elReloj[0]++;
			elReloj[1]=0;
		}
		if (elReloj[0]==24){
			elReloj[0]=0;
			elReloj[1]=0;
		}

		ALCANCE_ANTORCHA = alcanceAntorcha(elReloj);
	}

	private static int alcanceAntorcha(int[] elReloj) {
		
		int hora, minuto;
		double minutos;
		hora = elReloj[0];
		minuto = elReloj[1];
		minutos = hora*60+minuto;

		if (hora<4||hora>=21){return 3;}
		if (hora>=4 && hora <8) {return ((int)(3.0+((32.0/240.0)*(minutos-240.0))));}
		if (hora>=17 && hora <21) {return ((int)(35.0+((-32.0/240.0)*(minutos-1030.0))));}
		return 35;
	}

	private static boolean procesaMovimiento(int[][] elMapa, int[][] elPersonaje, int[][] losNPCs) {

		Scanner entrada = new Scanner(System.in);
		String inputUsuario;
		char laDireccion=' ';

		inputUsuario = entrada.nextLine();

		if (inputUsuario.equals("f")) {return false;} else
		if (inputUsuario.equals("w")) {laDireccion='N';} else
		if (inputUsuario.equals("a")) {laDireccion='O';} else
		if (inputUsuario.equals("s")) {laDireccion='S';} else
		if (inputUsuario.equals("d")) {laDireccion='E';} 

		mueveNPCs(elMapa, losNPCs);
		mueve(elPersonaje[0], elMapa, laDireccion);
		return true;
	}

	private static void mueve(int[] unPersonaje, int[][] unMapa, char unaDireccion ){

		int elPersonajeX, elPersonajeY;
		elPersonajeX = unPersonaje[0];
		elPersonajeY = unPersonaje[1];

		if (unaDireccion=='O') {
			if (elPersonajeX == 0) { elPersonajeX = unMapa[0].length - 1; } 
			else if  (unMapa[elPersonajeY][elPersonajeX - 1] % 2 == 0) { elPersonajeX = elPersonajeX - 1; }
		} else if (unaDireccion=='N') {
			if (elPersonajeY == 0) {elPersonajeY = unMapa.length - 1;} 
			else if  (unMapa[elPersonajeY - 1][elPersonajeX] % 2 == 0) { elPersonajeY = elPersonajeY - 1; }
		} else if (unaDireccion=='E') {
			if (elPersonajeX == unMapa[0].length - 1) { elPersonajeX = 0;} 
			else if  (unMapa[elPersonajeY][elPersonajeX + 1] % 2 == 0) { elPersonajeX = elPersonajeX + 1; }
		} else if (unaDireccion=='S') {
			if (elPersonajeY == unMapa.length - 1) { elPersonajeY = 0;} 
			else if  (unMapa[elPersonajeY + 1][elPersonajeX] % 2 == 0) { elPersonajeY = elPersonajeY + 1; }
		} 

		unPersonaje[0] = elPersonajeX;
		unPersonaje[1] = elPersonajeY;	
	}

	private static void mueveNPCs(int[][] elMapa, int[][] losNPCs) {

		char[] laDireccion = {'N','S','E','O'};
		char unaDireccion = ' ';

		for (int unNPC = 0; unNPC < losNPCs.length; unNPC++) {
			Random random = new Random();
			unaDireccion = laDireccion[random.nextInt(3)];
			mueve(losNPCs[unNPC], elMapa, unaDireccion);
		}
	}

	private static boolean hayNPC(int[][] losNPCs, int i, int j) {

		for (int unNPC = 0; unNPC < losNPCs.length; unNPC++) {
			if (losNPCs[unNPC][0] == j && losNPCs[unNPC][1] == i) {
				return true;
			}
		}
		return false;
	}

	private static void limpiaPantalla() {

		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	private static void imprimeMundo(int[][] elMapa, int[][] elPersonaje, int[][] losNPCs, int[] elReloj) {

		limpiaPantalla();
		imprimeBordeHorizontal(VIEWPORT*2+1);

		for (int i = 0; i < elMapa.length; i = i + 1) {
			if (i>elPersonaje[0][1]-VIEWPORT && i<elPersonaje[0][1]+VIEWPORT) {
				imprimeBordeVertical(false);
				for (int j = 0; j < elMapa[i].length; j = j + 1) {
					if (j>elPersonaje[0][0]-VIEWPORT && j<elPersonaje[0][0]+VIEWPORT) {
						if (puedoVer(i, j, elPersonaje)) {
							if (i == elPersonaje[0][1] && j == elPersonaje[0][0]) {
								imprimePersonaje();
							} else {
								if (hayNPC(losNPCs, i, j)) {
									imprimeNPC();
								} else {
									imprimeElemento(elMapa[i][j]);
								}
							}
						} else {
							imprimeVacio();
						}	
					}
				}
				imprimeBordeVertical(true);
		}
		}
		
		imprimeBordeHorizontal(VIEWPORT*2+1);
		imprimeStatus(elPersonaje, losNPCs, elReloj);
	}

	private static void imprimeStatus(int[][] elPersonaje, int[][] losNPCs, int[] elReloj) {

		System.out.println("Son las ["+elReloj[0]+"]:["+elReloj[1]+"] / El personaje está en X:[" + elPersonaje[0][0] + "] Y:[" + elPersonaje[0][1] + "]");
		for (int unNPC = 0; unNPC < losNPCs.length; unNPC++) {
			System.out.print("NPC[" + unNPC + "]=(" + losNPCs[unNPC][0] + "," + losNPCs[unNPC][1] + ") - ");
		}
		System.out.println("\n" + ALCANCE_ANTORCHA);
	}

	private static void imprimeElemento(int elementoDelMapa) {

		String[] matrizDeElementos = {
				INICIO + YELLOW + GREEN_BACKGROUND + " . " + RESET,
				INICIO + WHITE + WHITE_BACKGROUND + "[#]" + RESET,
				INICIO + RED + GREEN_BACKGROUND + "*" + RESET + INICIO + GREEN_BOLD + GREEN_BACKGROUND + "Y" + RESET + INICIO + RED + GREEN_BACKGROUND + "*" + RESET,
				INICIO + BLUE_BOLD + BLUE_BACKGROUND + "~ ~" + RESET,
				INICIO + YELLOW + GREEN_BACKGROUND + " : " + RESET
		};
		System.out.print(matrizDeElementos[elementoDelMapa]);
	}

	private static void imprimeVacio() {

		System.out.print(INICIO + BLACK + BLACK_BACKGROUND + "   " + RESET);

	}

	private static boolean puedoVer(int i, int j, int[][] elPersonaje) {

		return Math.pow(elPersonaje[0][0]-j,2)+Math.pow(elPersonaje[0][1]-i,2)<=Math.pow(ALCANCE_ANTORCHA,2);

	}

	private static void imprimePersonaje() {

		System.out.print(INICIO + BLACK + GREEN_BACKGROUND + "\\O/" + RESET);

	}

	private static void imprimeNPC() {

		System.out.print(INICIO + YELLOW_BOLD + GREEN_BACKGROUND + "^V^" + RESET);

	}

	private static void imprimeBordeHorizontal(int laLongitud) {

		System.out.print("+");
		for (int j = 0; j < laLongitud; j = j + 1) {
			System.out.print("---");
		}
		System.out.println("+");

	}

	private static void imprimeBordeVertical(boolean esBordeDerecho) {

		System.out.print("|");
		if (esBordeDerecho) {
			System.out.println();
		}

	}

	private static int ALCANCE_ANTORCHA = 3;
	private static int VIEWPORT = 7;

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
}