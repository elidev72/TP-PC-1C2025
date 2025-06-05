package test;

import matrices.MatrizUtils;

/*
 * Test pequeño para probar que el calculo se realiza de forma correcta
 */
public class TestSecuencial {

	public static void main(String[] args) {
		int iDimension = 2; // Dimensión para una prueba rápida

        int[][] matrizA = MatrizUtils.inicializarMatriz(iDimension);
        int[][] matrizB = MatrizUtils.inicializarMatriz(iDimension);

        MatrizUtils.mostrarMatriz(matrizA, "A");
        MatrizUtils.mostrarMatriz(matrizB, "B");

        int[][] matrizResultadoSecuencial = matrices.Secuencial.multiplicarMatricesSecuencial(matrizA, matrizB);
        MatrizUtils.mostrarMatriz(matrizResultadoSecuencial, "AB");
	}

}
