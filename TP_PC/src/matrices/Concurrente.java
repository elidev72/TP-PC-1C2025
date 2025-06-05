package matrices;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
 * Clase para la multiplicación de matrices cuadradas de números enteros de forma concurrente
 */
public class Concurrente {

    /*
     * Clase interna que implementa Runnable, lo que significa que puede ser ejecutada por un hilo
     * Cada instancia de esta tarea calculará un rango específico de filas de la matriz resultante
     */
    private static class TareaMultiplicacionMatrices implements Runnable {
        private final int[][] matrizA;
        private final int[][] matrizB;
        private final int[][] matrizResultante;
        private final int iFilaInicio; // Fila de inicio (inclusive) para el cálculo de este hilo
        private final int iFilaFin;   // Fila de fin (exclusiva) para el cálculo de este hilo

        /*
         * Constructor de la tarea.
         */
        public TareaMultiplicacionMatrices(int[][] matrizA, int[][] matrizB, int[][] matrizResultante, int iFilaInicio, int iFilaFin) {
            this.matrizA = matrizA;
            this.matrizB = matrizB;
            this.matrizResultante = matrizResultante;
            this.iFilaInicio = iFilaInicio;
            this.iFilaFin = iFilaFin;
        }

        /**
         * Método run() que contiene la lógica de la multiplicación para el rango de filas asignado.
         * Se ejecuta cuando el hilo comienza.
         */
        @Override
        public void run() {
            int iDimension = matrizA.length;
            		
            // Bucle para las filas de la matriz
            for (int i = iFilaInicio; i < iFilaFin; i++) {
                // Bucle para las columnas de la matriz
                for (int j = 0; j < iDimension; j++) {
                	// Bucle para el calculo del producto escalar
                    for (int k = 0; k < iDimension; k++) {
                    	matrizResultante[i][j] += matrizA[i][k] * matrizB[k][j];
                    }
                }
            }
            
        }
        
    }

    /*
     * Multiplica dos matrices cuadradas de números enteros de forma concurrente utilizando un pool de hilos
     */
    public static int[][] multiplicarMatricesConcurrente(int[][] matrizA, int[][] matrizB) {
        int iDimension = matrizA.length;
        int[][] matrizResultante = new int[iDimension][iDimension]; // Crea la matriz resultante inicializada con ceros

        // Determina el número de hilos a usar.
        int iHilos = Runtime.getRuntime().availableProcessors();
        System.out.println("\nIniciando multiplicación concurrente (N=" + iDimension + ", Hilos=" + iHilos + ")...");

        // Crea un pool de hilos con un número fijo de hilos
        ExecutorService ejecutor = Executors.newFixedThreadPool(iHilos);

        long tiempoInicio = System.nanoTime(); // Marca el tiempo de inicio

        // Calcula cuántas filas asignará a cada hilo
        int iFilasPorHilo = iDimension / iHilos;
        int iFilasRestantes = iDimension % iHilos; // Filas restantes para el último hilo

        // Divide el trabajo en tareas y las envía al pool de hilos
        int iFilaInicio, iFilaFin;
        for (int i = 0; i < iHilos; i++) {
            iFilaInicio = i * iFilasPorHilo;
            iFilaFin = iFilaInicio + iFilasPorHilo;

            // Asegura que el último hilo procese las filas restantes
            if (i == iHilos - 1) {
                iFilaFin += iFilasRestantes;
            }

            // Crea una nueva tarea y la envía al ejecutor
            ejecutor.submit(new TareaMultiplicacionMatrices(matrizA, matrizB, matrizResultante, iFilaInicio, iFilaFin));
        }

        // Apaga el ejecutor y espera a que todas las tareas terminen
        ejecutor.shutdown();
        try {
            // Espera hasta que todas las tareas se hayan completado, o se exceda el tiempo límite
            if (!ejecutor.awaitTermination(10, TimeUnit.MINUTES)) {
                System.err.println("Las tareas no terminaron en el tiempo esperado.");
            }
        } catch (InterruptedException e) {
            System.err.println("La espera fue interrumpida: " + e.getMessage());
            Thread.currentThread().interrupt(); // Reestablece el estado de interrupción
        }

        long tiempoFin = System.nanoTime(); // Marca el tiempo de fin
        long duracionMs = (tiempoFin - tiempoInicio) / 1_000_000; // Calcula la duración en milisegundos
        System.out.println("Multiplicación concurrente completada en: " + duracionMs + " ms");
        
        return matrizResultante;
    }
    
}
