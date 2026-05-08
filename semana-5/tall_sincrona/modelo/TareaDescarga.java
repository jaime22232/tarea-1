package tall_sincrona.modelo;

public class TareaDescarga {
    public void descargar(ArchivoCliente archivo) {
        try {
            archivo.setEstadoActual("Descargando: " + archivo.getNombreArchivo());
            Thread.sleep(3000); // Bloqueo de 3 segundos
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}