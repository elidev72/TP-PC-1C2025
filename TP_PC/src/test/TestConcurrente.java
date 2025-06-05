package test;

import matrices.MatrizUtils;

/*
 * Test pequeño para probar que el calculo se realiza de forma correcta
 */
public class TestConcurrente {

	public static void main(String[] args) {
		int iDimension = 2; // Dimensión para una prueba rápida

        int[][] matrizA = MatrizUtils.inicializarMatriz(iDimension);
        int[][] matrizB = MatrizUtils.inicializarMatriz(iDimension);

        MatrizUtils.mostrarMatriz(matrizA, "A");
        MatrizUtils.mostrarMatriz(matrizB, "B");

        int[][] matrizResultadoSecuencial = matrices.Concurrente.multiplicarMatricesConcurrente(matrizA, matrizB);
        MatrizUtils.mostrarMatriz(matrizResultadoSecuencial, "AB");
	}

}