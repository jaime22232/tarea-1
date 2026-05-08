package tall_sincrona.modelo;

public class ProcesadorArchivo {
    public void validar(ArchivoCliente archivo) {
        try {
            archivo.setEstadoActual("Validando: " + archivo.getNombreArchivo());
            Thread.sleep(2000); // Bloqueo de 2 segundos
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void procesar(ArchivoCliente archivo) {
        try {
            archivo.setEstadoActual("Procesando: " + archivo.getNombreArchivo());
            Thread.sleep(3000); // Bloqueo de 3 segundos
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}