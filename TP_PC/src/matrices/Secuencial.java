package matrices;

/*
 * Clase para la multiplicación de matrices cuadradas de números enteros de forma secuencial
 */
public class Secuencial {

    /*
     * Multiplica dos matrices cuadradas de números enteros de forma secuencial
     * Se asume para el programa que siempre seran matrices cuadradas
     */
    public static int[][] multiplicarMatricesSecuencial(int[][] matrizA, int[][] matrizB) {
        int iDimension = matrizA.length;
        int[][] matrizResultado = new int[iDimension][iDimension];

        System.out.println("\nIniciando multiplicación secuencial (N=" + iDimension + ")...");
        long tiempoInicio = System.nanoTime(); // Marca el tiempo de inicio

        // Bucle para las filas de la matriz
        for (int i = 0; i < iDimension; i++) {
            // Bucle para las columnas de la matriz
            for (int j = 0; j < iDimension; j++) {
                // Bucle para el calculo del producto escalar
                for (int k = 0; k < iDimension; k++) {
                    matrizResultado[i][j] += matrizA[i][k] * matrizB[k][j];
                }
            }
        }

        long tiempoFin = System.nanoTime(); // Marca el tiempo de fin
        long duracionMs = (tiempoFin - tiempoInicio) / 1_000_000; // Calcula la duración en milisegundos
        
        System.out.println("Multiplicación secuencial completada en: " + duracionMs + " ms");
        
        return matrizResultado;
    }
    
}
