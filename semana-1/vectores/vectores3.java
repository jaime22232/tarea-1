//Encontrar el mayor
public class vectores3 {
    public static void main(String[] args) {
        int[] numeros = {3, 7, 1, 9, 4};
        int mayor = numeros[0];
        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] > mayor) {
                mayor = numeros[i];
            }
        }
        System.out.println("Mayor: " + mayor);
    }
}