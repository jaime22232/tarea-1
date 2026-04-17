//Imprimir solo la primera fila
public class matrices4 {
    public static void main(String[] args) {
        int[][] matriz = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        for (int j = 0; j < matriz[0].length; j++) {
            System.out.print(matriz[0][j] + " ");
        }
    }
}