import com.sun.management.OperatingSystemMXBean;
import java.lang.management.ManagementFactory;

public class procesador1 {
    public static void main(String[] args) throws InterruptedException {
        OperatingSystemMXBean os = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

        // 1. Necesitas darle tiempo al sistema para medir
        double antes = os.getCpuLoad() * 100;
        
        // 2. Hacer el trabajo realmente intensivo
        long startTime = System.currentTimeMillis();
        double dummy = 0;
        // Aumentamos la carga: un bucle mucho más grande y con operación matemática costosa
        while (System.currentTimeMillis() - startTime < 2000) { // Ejecutar por 2 segundos
            for (int i = 0; i < 1000000; i++) {
                dummy += Math.sin(i) * Math.cos(i); 
            }
        }

        double despues = os.getCpuLoad() * 100;

        System.out.println("CPU antes : " + antes + " %");
        System.out.println("CPU despues: " + despues + " %");
        System.out.println("Resultado de cálculo (para evitar optimización): " + dummy);
    }
}