import java.util.Scanner;

class UnLaberinto {
	public static void main(String[] args) {

		int[][] unMapa = {
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,2,2,2,2,2,2,2,2,2,2,2,2,1,1,2,2,2,2,2,2,2,2,2,2,2,2,1},
			{1,2,1,1,1,1,2,1,1,1,1,1,2,1,1,2,1,1,1,1,1,2,1,1,1,1,2,1},
			{1,2,1,1,1,1,2,1,1,1,1,1,2,1,1,2,1,1,1,1,1,2,1,1,1,1,2,1},
			{1,2,1,1,1,1,2,1,1,1,1,1,2,1,1,2,1,1,1,1,1,2,1,1,1,1,2,1},
			{1,4,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,4,1},
			{1,2,1,1,1,1,2,1,2,1,1,1,1,1,1,1,1,1,1,2,1,2,1,1,1,1,2,1},
			{1,2,1,1,1,1,2,1,2,1,1,1,1,1,1,1,1,1,1,2,1,2,1,1,1,1,2,1},
			{1,2,2,2,2,2,2,1,2,2,2,2,2,1,1,2,2,2,2,2,1,2,2,2,2,2,2,1},
			{1,1,1,1,1,1,2,1,1,1,1,1,0,1,1,0,1,1,1,1,1,2,1,1,1,1,1,1},
			{1,1,1,1,1,1,2,1,1,1,1,1,0,1,1,0,1,1,1,1,1,2,1,1,1,1,1,1},
			{1,1,1,1,1,1,2,1,0,0,0,0,0,0,0,0,0,0,0,0,1,2,1,1,1,1,1,1},
			{1,1,1,1,1,1,2,1,0,1,1,1,1,0,0,1,1,1,1,0,1,2,1,1,1,1,1,1},
			{0,0,0,0,0,0,2,0,0,1,0,0,0,0,0,0,0,0,1,0,0,2,0,0,0,0,0,0},
			{1,1,1,1,1,1,2,1,0,1,1,1,1,1,1,1,1,1,1,0,1,2,1,1,1,1,1,1},
			{1,1,1,1,1,1,2,1,0,0,0,0,0,6,0,0,0,0,0,0,1,2,1,1,1,1,1,1},
			{1,1,1,1,1,1,2,1,0,1,1,1,1,1,1,1,1,1,1,0,1,2,1,1,1,1,1,1},
			{1,1,1,1,1,1,2,1,0,1,1,1,1,1,1,1,1,1,1,0,1,2,1,1,1,1,1,1},
			{1,2,2,2,2,2,2,2,2,2,2,2,2,1,1,2,2,2,2,2,2,2,2,2,2,2,2,1},
			{1,2,1,1,1,1,2,1,1,1,1,1,2,1,1,2,1,1,1,1,1,2,1,1,1,1,2,1},
			{1,2,1,1,1,1,2,2,2,1,1,1,2,1,1,2,1,1,1,2,2,2,1,1,1,1,2,1},
			{1,4,2,2,1,1,2,1,2,2,2,2,2,2,2,2,2,2,2,2,1,2,1,1,2,2,4,1},
			{1,1,1,2,1,1,2,1,2,1,1,1,1,1,1,1,1,1,1,2,1,2,1,1,2,1,1,1},
			{1,1,1,2,1,1,2,1,2,1,1,1,1,1,1,1,1,1,1,2,1,2,1,1,2,1,1,1},
			{1,2,2,2,2,2,2,1,2,2,2,2,2,1,1,2,2,2,2,2,1,2,2,2,2,2,2,1},
			{1,2,1,1,1,1,1,1,1,1,1,1,2,1,1,2,1,1,1,1,1,1,1,1,1,1,2,1},
			{1,2,1,1,1,1,1,1,1,1,1,1,2,1,1,2,1,1,1,1,1,1,1,1,1,1,2,1},
			{1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
		};
		int[][] elPersonaje = { { 12, 21 }, { 0, 0 } };
		int[][] losNPCs = {
				{ 10, 13 },
				{ 12, 13 },
				{ 14, 13 },
				{ 16, 13 },
		};

		do {
			imprimeMundo(unMapa, elPersonaje, losNPCs);
		} while (procesaMovimiento(unMapa, elPersonaje, losNPCs));
		imprimeMundo(unMapa, elPersonaje, losNPCs);
	}

	private static boolean procesaMovimiento(int[][] elMapa, int[][] elPersonaje, int[][] losNPCs) {

		mueveNPCs(elMapa, losNPCs);

		Scanner entrada = new Scanner(System.in);
		String inputUsuario;

		inputUsuario = entrada.nextLine();
		int elPersonajeX, elPersonajeY;
		int elPersonajePasos, elPersonajePuntos;

		elPersonajeX = elPersonaje[0][0];
		elPersonajeY = elPersonaje[0][1];

		elPersonajePasos = elPersonaje[1][0];
		elPersonajePuntos = elPersonaje[1][1];

		if (inputUsuario.equals("a") && elMapa[elPersonajeY][elPersonajeX - 1] % 2 == 0) {
			elPersonajeX = elPersonajeX - 1;
		} else if (inputUsuario.equals("d") && elMapa[elPersonajeY][elPersonajeX + 1] % 2 == 0) {
			elPersonajeX = elPersonajeX + 1;
		} else if (inputUsuario.equals("w") && elMapa[elPersonajeY - 1][elPersonajeX] % 2 == 0) {
			elPersonajeY = elPersonajeY - 1;
		} else if (inputUsuario.equals("s") && elMapa[elPersonajeY + 1][elPersonajeX] % 2 == 0) {
			elPersonajeY = elPersonajeY + 1;
		} else if (inputUsuario.equals("f")) {
			return false;
		}

		elPersonajePasos++;

		if (elMapa[elPersonajeY][elPersonajeX]==2){elPersonajePuntos++;};

		if (hayNPC(losNPCs, elPersonajeX, elPersonajeY)) {return false;}
		
		elMapa[elPersonajeY][elPersonajeX]=0;

		elPersonaje[0][0] = elPersonajeX;
		elPersonaje[0][1] = elPersonajeY;
		elPersonaje[1][0] = elPersonajePasos;
		elPersonaje[1][1] = elPersonajePuntos;

		return tableroConPastillas(elMapa);
	}

	private static boolean tableroConPastillas(int[][] elMapa) {

		for (int i=0;i<elMapa.length;i++){
			for (int j=0;j<elMapa[i].length;j++) {
				if (elMapa[i][j]==2) {return true;}
			}
		}
		return false;
	}

	private static void mueveNPCs(int[][] elMapa, int[][] losNPCs) {
		double movimiento;
		int npcX, npcY;

		for (int unNPC = 0; unNPC < losNPCs.length; unNPC++) {
			movimiento = Math.random();
			npcX = losNPCs[unNPC][0];
			npcY = losNPCs[unNPC][1];
			if (movimiento <= 0.25 && elMapa[npcY][npcX - 1] % 2 == 0) {
				npcX = npcX - 1;
			} else if (movimiento <= 0.5 && elMapa[npcY][npcX + 1] % 2 == 0) {
				npcX = npcX + 1;
			} else if (movimiento <= 0.75 && elMapa[npcY - 1][npcX] % 2 == 0) {
				npcY = npcY - 1;
			} else if (movimiento <= 1 && elMapa[npcY + 1][npcX] % 2 == 0) {
				npcY = npcY + 1;
			}
			losNPCs[unNPC][0] = npcX;
			losNPCs[unNPC][1] = npcY;
		}
	}

	private static void imprimeMundo(int[][] elMapa, int[][] elPersonaje, int[][] losNPCs) {

		limpiaPantalla();
		imprimeBordeHorizontal(elMapa[0].length);

		for (int i = 0; i < elMapa.length; i = i + 1) {
			imprimeBordeVertical(false);
			for (int j = 0; j < elMapa[i].length; j = j + 1) {
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
			imprimeBordeVertical(true);
		}
		imprimeBordeHorizontal(elMapa[0].length);
		imprimeStatus(elPersonaje, losNPCs);
	}

	private static void imprimeStatus(int[][] elPersonaje, int[][] losNPCs) {

		System.out.println("Personaje en X:[" + elPersonaje[0][0] + "] Y:[" + elPersonaje[0][1] + "] / Pasos:["+elPersonaje[1][0]+"] / Puntos: ["+elPersonaje[1][1]+"]");
		for (int unNPC = 0; unNPC < losNPCs.length; unNPC++) {
			System.out.print("NPC[" + unNPC + "]=(" + losNPCs[unNPC][0] + "," + losNPCs[unNPC][1] + ") - ");
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

	private static void imprimeElemento(int elementoDelMapa) {
		String[] matrizDeElementos = {
				INICIO + YELLOW + GREEN_BACKGROUND + " . " + RESET,
				INICIO + WHITE + WHITE_BACKGROUND + "[#]" + RESET,
				INICIO + YELLOW_BOLD + GREEN_BACKGROUND + " * " + RESET,
				INICIO + BLUE_BOLD + BLUE_BACKGROUND + "~ ~" + RESET,
				INICIO + RED_BOLD + BLUE_BACKGROUND + " * " + RESET,
				INICIO + BLUE_BOLD + BLUE_BACKGROUND + "~ ~" + RESET,
				INICIO + GREEN_BOLD + BLUE_BACKGROUND + "() " + RESET,
				INICIO + BLUE_BOLD + BLUE_BACKGROUND + "~ ~" + RESET
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

		System.out.print(INICIO + YELLOW_BOLD + RED_BACKGROUND + "^V^" + RESET);

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

	private static int ALCANCE_ANTORCHA = 100;

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