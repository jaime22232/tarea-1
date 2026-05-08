package tall_asincrona.modelo;

public class TareaDescarga {
    public void descargar(ArchivoCliente archivo) {
        try {
            archivo.setEstadoActual("Descargando archivo...");
            Thread.sleep(3000); // Tarea pesada simulada
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}