public class tiempo1 {
    public static void main(String[] args) {
        long inicio = System.nanoTime();

        int suma = 0;
        for (int i = 1; i <= 1000000; i++) {
            suma = suma + i;
        }

        long fin = System.nanoTime();
        System.out.println("Tiempo: " + (fin - inicio) + " ms");
    }
}

