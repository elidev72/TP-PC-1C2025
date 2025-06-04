package test;

import matrices.Secuencial;

/*
 * Test basico para probar que los calculos sean correctos
 */
public class testSecuencial {

	public static void main(String[] args) {
		int iDimension = 2; // Dimensión para una prueba rápida

        int[][] matrizA = Secuencial.inicializarMatriz(iDimension);
        int[][] matrizB = Secuencial.inicializarMatriz(iDimension);

        Secuencial.mostrarMatriz(matrizA, "A");
        Secuencial.mostrarMatriz(matrizB, "B");

        int[][] matrizResultadoSecuencial = Secuencial.multiplicarMatricesSecuencial(matrizA, matrizB);
        Secuencial.mostrarMatriz(matrizResultadoSecuencial, "AB");
	}

}
