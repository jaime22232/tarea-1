import java.util.Random;

public class ejercicio_2 {
    public static void main(String[] args) {
        Random random = new Random();
        int pico = 100;
        int minerales = 0;

        while (pico > 0) {
            int desgaste = random.nextInt(5, 11);
            if (pico - desgaste < 0) {
               
                minerales += random.nextInt(1, 4);
                pico = 0;
                System.out.println("El pico se rompió en el último uso");
            } else {
                
                pico -= desgaste;
                minerales += random.nextInt(1, 4);
                System.out.println("Durabilidad restante: " + pico);
            }
        }
        
        System.out.println("Total de minerales obtenidos: " + minerales);
    }
}