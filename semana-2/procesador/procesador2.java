import com.sun.management.OperatingSystemMXBean;
import java.lang.management.ManagementFactory;

public class procesador2 {
    public static void main(String[] args) throws InterruptedException {
        OperatingSystemMXBean os = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        
        int nucleos = Runtime.getRuntime().availableProcessors();
        System.out.println("Nucleos detectados: " + nucleos);

        double antes = os.getCpuLoad() * 100;
        System.out.printf("CPU antes: %.2f%%%n", antes);

        Thread[] hilos = new Thread[nucleos];
        for (int i = 0; i < nucleos; i++) {
            hilos[i] = new Thread(() -> {
                long tiempoLimite = System.currentTimeMillis() + 3000;
                while (System.currentTimeMillis() < tiempoLimite) {
                    String texto = "Java".repeat(10_000);
                    texto.hashCode();
                }
            });
            hilos[i].start();
        }
        for (Thread t : hilos) t.join();

        double despues = os.getCpuLoad() * 100;
        System.out.printf("CPU despues: %.2f%%%n", despues);
    }
}