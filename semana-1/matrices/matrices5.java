//Imprimir solo la primera columna
public class matrices5 {
    public static void main(String[] args) {
        int[][] matriz = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        for (int i = 0; i < matriz.length; i++) {
            System.out.println(matriz[i][0]);
        }
    }
}