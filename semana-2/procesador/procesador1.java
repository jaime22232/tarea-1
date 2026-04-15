import com.sun.management.OperatingSystemMXBean;
import java.lang.management.ManagementFactory;

public class procesador1 {
    public static void main(String[] args) {
        OperatingSystemMXBean os = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

        double antes = os.getCpuLoad() * 100;
        
        int[][] si = new int[10000][10000];
        for (int i = 1; i <= 1000000; i++) {
            int x = i * i;
        }

        double despues = os.getCpuLoad() * 100;

        System.out.println("CPU antes : " + antes + " %");
        System.out.println("CPU despues: " + despues + " %");
    }
}