package test;

import matrices.MatrizUtils;

public class TestParaComparar {

	public static void main(String[] args) {
        int iDimension = 400; 

        System.out.println("--- COMPARACIÓN DE RENDIMIENTO PARA N=" + iDimension + " ---");
        
        // 1. Inicializar las matrices de entrada
        int[][] matrizA = MatrizUtils.inicializarMatriz(iDimension);
        int[][] matrizB = MatrizUtils.inicializarMatriz(iDimension);

        // 2. Ejecutar la multiplicación secuencial
        matrices.Secuencial.multiplicarMatricesSecuencial(matrizA, matrizB);

        // 3. Ejecutar la multiplicación concurrente
        matrices.Concurrente.multiplicarMatricesConcurrente(matrizA, matrizB);
	}

}
