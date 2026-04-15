import java.util.Random;
public class memoria2 {
    public static void main(String[] args) {
        Runtime rt = Runtime.getRuntime();
        Random random = new Random() ;
        
        long antes = rt.freeMemory();

        int[] numeros = new int[100000];
        int i=0;
        while(i<numeros.length)
        {
            numeros[i] = random.nextInt(100000);
            i++;
        }

        long despues = rt.freeMemory();
        System.out.println("Memoria usada: " + (antes - despues) + " bytes");
    }
}