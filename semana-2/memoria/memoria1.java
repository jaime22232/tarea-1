public class memoria1 {
    public static void main(String[] args) {
        Runtime rt = Runtime.getRuntime();
        long antes = rt.freeMemory();

        String texto = "Java".repeat(1_000_000);
        System.out.println(texto);

        long despues = rt.freeMemory();
        System.out.println("Memoria usada: " + (antes - despues) + " bytes");
    }
}