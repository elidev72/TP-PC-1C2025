package matrices;

import java.util.Random;

public class MatrizUtils {

	/*
     * Inicializa una matriz cuadrada con números enteros aleatorios
     */
    public static int[][] inicializarMatriz(int iDimension) {
        int[][] matriz = new int[iDimension][iDimension];
        
        Random aleatorio = new Random();
        
        for (int i = 0; i < iDimension; i++) {
            for (int j = 0; j < iDimension; j++) {
                matriz[i][j] = aleatorio.nextInt(21) - 10; // Valores enteros entre -10 y 10
            }
        }
        
        return matriz;
    }

    /*
     * Muestra el contenido de una matriz en la consola
     */
    public static void mostrarMatriz(int[][] matriz, String nombre) {
        int iDimension = matriz.length;
        
        System.out.println("\n--- Matriz " + nombre + " (" + iDimension + "x" + iDimension + ") ---");
        
        for (int i = 0; i < iDimension; i++) {
            for (int j = 0; j < iDimension; j++) {
                System.out.printf("%5d", matriz[i][j]); // Formatea el espacio que ocupa cada numero
            }
            System.out.println();
        }
        
        System.out.println("----------------------------------------");
    }
	
}
