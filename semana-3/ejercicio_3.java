import java.util.Random;

public class ejercicio_3 {
    public static void main(String[] args) {
        Random random = new Random();
        int descuento;
        int numeroGiro = 1;

        System.out.println(" Inicio de la Ruleta de Descuentos ");

        do {
            
            descuento = random.nextInt(1, 41);

            System.out.println("Giro " + numeroGiro + ": Descuento del " + descuento + "%");

            if (descuento < 10) {
                System.out.println(">>> El descuento es menor al 10%. Tienes derecho a un giro extra.");
                numeroGiro++;
            }
        } while (descuento < 10);

        System.out.println("------------------------------------------");
        System.out.println("¡Felicidades! Descuento final aplicado: " + descuento + "%");
    }
}