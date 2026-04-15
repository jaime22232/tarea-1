public class tiempo2 {
    public static void main(String[] args) {
        long inicio = System.nanoTime();

        String texto = "";
        for (int i = 0; i < 1000; i++) {
            texto = texto + i;
        }

        long fin = System.nanoTime();
        System.out.println("Tiempo: " + (fin - inicio) + " ns");
    }
}