import com.sun.management.OperatingSystemMXBean;
import java.lang.management.ManagementFactory;

public class procesador2 {
    public static void main(String[] args) {
        OperatingSystemMXBean os = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        double antes = os.getCpuLoad() * 100;

        long tiempoLimite = System.currentTimeMillis() + 2000;
        while (System.currentTimeMillis() < tiempoLimite) {
            String texto = "Java".repeat(100_000);
            texto.hashCode(); // Obligamos al CPU a procesar el String
        }

        double despues = os.getCpuLoad() * 100;

        System.out.printf("CPU antes : %.2f %%%n", antes);
        System.out.printf("CPU despues: %.2f %%%n", despues);
    }
}