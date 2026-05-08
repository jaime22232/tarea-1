package tall_final.modelo;
import java.util.Random;

public class ProcesadorArchivo {
    private final Random random = new Random();

    public void ejecutar(ArchivoCliente archivo) throws Exception {
        archivo.setEstado("Procesando...");
        Thread.sleep(1000);

        // Simulación de error aleatorio (15% de probabilidad)
        if (random.nextInt(100) < 15) {
            throw new Exception("Error de redundancia cíclica");
        }

        archivo.setExitoso(true);
        archivo.setEstado("Completado");
    }
}