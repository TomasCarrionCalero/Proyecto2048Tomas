package Proyecto;

import java.util.Random;
import java.util.Scanner;

public class try1 {

	public static void imprimirMatriz(int[][] tablero) {
		for (int fila = 0; fila < 4; fila++) {
			System.out.print("|");
			for (int col = 0; col < 4; col++) {
				System.out.print(tablero[fila][col] + "|");
			}
			System.out.println();
		}
	}

	public static int[][] generarTablero() {
		int[][] tablero = new int[4][4];

		for (int fila = 0; fila < 4; fila++) {
			for (int col = 0; col < 4; col++) {
				tablero[fila][col] = 0;
			}
		}
		return tablero;
	}

	public static int[] obtenerPosicionVacia(int[][] tablero) {
		Random rand = new Random();
		int fila, columna;

		do {
			fila = rand.nextInt(tablero.length);
			columna = rand.nextInt(tablero[0].length);

		} while (tablero[fila][columna] != 0);

		return new int[] { fila, columna };
	}

	public static void agregarNumeroAleatorio(int[][] tablero) {
		int[] posicionVacia = obtenerPosicionVacia(tablero);

		if (posicionVacia != null) {
			Random random = new Random();
			int nuevoNumero = (random.nextInt(2) + 1) * 2;
			tablero[posicionVacia[0]][posicionVacia[1]] = nuevoNumero;
		}
	}

	public static String imprimirReglas() {
		
		String reglas = "Reglas del Juego 2048: Desentrañando el Baile de las Fichas\n"
				+ "Profundizando en las reglas del juego 2048, nos encontramos con las complejidades del movimiento de fichas, la formación de patrones y la fusión de valores iguales. "
				+ "Las fichas se deslizan suavemente por la cuadrícula hasta que encuentran un obstáculo, como otra ficha o el borde de la cuadrícula. "
				+ "Los movimientos solo tienen éxito si dos fichas con el mismo valor numérico entran en contacto, fusionándose en una sola ficha que representa su valor combinado.\n"
				+ "Las fichas de valor bajo se fusionan con más frecuencia, lo que permite una planificación fluida y un movimiento de esquina a esquina. "
				+ "A medida que estas fichas crecen y se fusionan en sumas más grandes, es esencial mantener una congruencia de la matriz, permitiendo la fusión adecuada de valores. "
				+ "El éxito en 2048 requiere armonizar entre el orden y el caos, abrazando las reglas fundamentales y al mismo tiempo siendo capaz de adaptarse a cualquier cambio inesperado que ocurra en el tablero de juego.";

		return reglas;
	}

	public static int[][] moverArriba(int[][] tablero) {
		boolean movimientoExitoso = false;

		for (int col = 0; col < 4; col++) {
			for (int fila = 1; fila < 4; fila++) {
				if (tablero[fila][col] != 0) {
					int filaActual = fila;
					while (filaActual > 0 && (tablero[filaActual - 1][col] == 0
							|| tablero[filaActual - 1][col] == tablero[filaActual][col])) {
						if (tablero[filaActual - 1][col] == 0) {
							tablero[filaActual - 1][col] = tablero[filaActual][col];
							tablero[filaActual][col] = 0;
							filaActual--;
							movimientoExitoso = true;
						} else if (tablero[filaActual - 1][col] == tablero[filaActual][col]) {
							tablero[filaActual - 1][col] *= 2;
							tablero[filaActual][col] = 0;
							movimientoExitoso = true;
						}
					}
				}
			}
		}

		if (movimientoExitoso) {
			agregarNumeroAleatorio(tablero);
		}

		return tablero;
	}

	public static int[][] moverIzquierda(int[][] tablero) {
		boolean movimientoExitoso = false;

		for (int fila = 0; fila < 4; fila++) {
			for (int col = 1; col < 4; col++) {
				if (tablero[fila][col] != 0) {
					int colActual = col;
					while (colActual > 0 && (tablero[fila][colActual - 1] == 0
							|| tablero[fila][colActual - 1] == tablero[fila][colActual])) {
						if (tablero[fila][colActual - 1] == 0) {
							tablero[fila][colActual - 1] = tablero[fila][colActual];
							tablero[fila][colActual] = 0;
							colActual--;
							movimientoExitoso = true;
						} else if (tablero[fila][colActual - 1] == tablero[fila][colActual]) {
							tablero[fila][colActual - 1] *= 2;
							tablero[fila][colActual] = 0;
							movimientoExitoso = true;
						}
					}
				}
			}
		}

		if (movimientoExitoso) {
			agregarNumeroAleatorio(tablero);
		}

		return tablero;
	}

	public static int[][] moverAbajo(int[][] tablero) {
		boolean movimientoExitoso = false;

		for (int col = 0; col < 4; col++) {
			for (int fila = 2; fila >= 0; fila--) {
				if (tablero[fila][col] != 0) {
					int filaActual = fila;
					while (filaActual < 3 && (tablero[filaActual + 1][col] == 0
							|| tablero[filaActual + 1][col] == tablero[filaActual][col])) {
						if (tablero[filaActual + 1][col] == 0) {
							tablero[filaActual + 1][col] = tablero[filaActual][col];
							tablero[filaActual][col] = 0;
							filaActual++;
							movimientoExitoso = true;
						} else if (tablero[filaActual + 1][col] == tablero[filaActual][col]) {
							tablero[filaActual + 1][col] *= 2;
							tablero[filaActual][col] = 0;
							movimientoExitoso = true;
						}
					}
				}
			}
		}

		if (movimientoExitoso) {
			agregarNumeroAleatorio(tablero);
		}

		return tablero;
	}

	public static int[][] moverDerecha(int[][] tablero) {
		boolean movimientoExitoso = false;

		for (int fila = 0; fila < 4; fila++) {
			for (int col = 2; col >= 0; col--) {
				if (tablero[fila][col] != 0) {
					int colActual = col;
					while (colActual < 3 && (tablero[fila][colActual + 1] == 0
							|| tablero[fila][colActual + 1] == tablero[fila][colActual])) {
						if (tablero[fila][colActual + 1] == 0) {
							tablero[fila][colActual + 1] = tablero[fila][colActual];
							tablero[fila][colActual] = 0;
							colActual++;
							movimientoExitoso = true;
						} else if (tablero[fila][colActual + 1] == tablero[fila][colActual]) {
							tablero[fila][colActual + 1] *= 2;
							tablero[fila][colActual] = 0;
							movimientoExitoso = true;
						}
					}
				}
			}
		}

		if (movimientoExitoso) {
			agregarNumeroAleatorio(tablero);
		}

		return tablero;
	}

	public static boolean verificarFinDeJuego(int[][] tablero) {
		for (int fila = 0; fila < 4; fila++) {
			for (int col = 0; col < 4; col++) {
				if (tablero[fila][col] == 2048) {
					System.out.println("¡Felicidades! Has alcanzado el valor 2048. ¡Has ganado!");
					return true;
				}
			}
		}

		for (int fila = 0; fila < 4; fila++) {
			for (int col = 0; col < 3; col++) {
				if (tablero[fila][col] == tablero[fila][col + 1] || tablero[col][fila] == tablero[col + 1][fila]) {
					return false; //  siguen habiendo posibles fusiones 
				}
			}
		}

		for (int fila = 0; fila < 4; fila++) {
			for (int col = 0; col < 4; col++) {
				if (tablero[fila][col] == 0) {
					return false; // Hay celdas vacías
				}
			}
		}

		System.out.println("Partida perdida. No hay más movimientos disponibles.");
        imprimirMatriz(tablero);

		return true;
	}

	public static int[][] copiarTablero(int[][] tablero) {
	    int[][] copia = new int[4][4];
	    for (int fila = 0; fila < 4; fila++) {
	        for (int col = 0; col < 4; col++) {
	            copia[fila][col] = tablero[fila][col];
	        }
	    }
	    return copia;
	}


	private static boolean sonTablerosIguales(int[][] tablero1, int[][] tablero2) {
		for (int fila = 0; fila < 4; fila++) {
			for (int col = 0; col < 4; col++) {
				if (tablero1[fila][col] != tablero2[fila][col]) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
	    Scanner tec = new Scanner(System.in);

	    int[][] tablero = generarTablero();
	    agregarNumeroAleatorio(tablero);
	    agregarNumeroAleatorio(tablero);

	    String rg = imprimirReglas();
	    System.out.println(rg);
	    System.out.println("Elige una opción \n 1.Jugar \n 2.Salir");
	    int opción = tec.nextInt();

	    while (true) {

	        if (opción == 1) {
	            imprimirMatriz(tablero);
	            boolean movimientoValido = false;

	            while (!movimientoValido) {
	                System.out.println("Ingrese una dirección: w(arriba), a(izquierda), (d)derecha o (s)abajo");
	                String direccion = tec.next().toLowerCase();

	                int[][] tableroAntes = copiarTablero(tablero);

	                switch (direccion) {
	                    case "w":
	                        tablero = moverArriba(tablero);
	                        break;
	                    case "a":
	                        tablero = moverIzquierda(tablero);
	                        break;
	                    case "s":
	                        tablero = moverAbajo(tablero);
	                        break;
	                    case "d":
	                        tablero = moverDerecha(tablero);
	                        break;
	                    default:
	                        System.out.println("Dirección no válida.");
	                        continue;  // Reinicia el bucle para que se ingrese otra dirección
	                }

	                if (!sonTablerosIguales(tablero, tableroAntes)) {
	                    movimientoValido = true;
	                }
	            }

	            if (verificarFinDeJuego(tablero)) {
	                break;
	            }

	        } else if (opción == 2) {
	            System.out.println("Se ha salido del juego.");
	            break;
	        } else {
	            System.out.println("Opción no válida.");
	        }
	    }
	}


}
