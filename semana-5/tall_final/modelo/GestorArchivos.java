package tall_final.modelo;

import java.util.Random;

public class GestorArchivos {
    private final Random random = new Random();

    public void procesarArchivo(ArchivoCliente archivo) throws Exception {
        // Simulación de pasos
        Thread.sleep(1000);

        // Simulación de error (20% de probabilidad)
        if (random.nextInt(100) < 20) {
            throw new Exception("Error crítico de E/S en " + archivo.getNombre());
        }

        Thread.sleep(1000);
        archivo.setExitoso(true);
        archivo.setEstado("Completado");
    }
}