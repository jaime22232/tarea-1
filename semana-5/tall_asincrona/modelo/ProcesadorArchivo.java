package tall_asincrona.modelo;

public class ProcesadorArchivo {
    public void validar(ArchivoCliente archivo) {
        try {
            archivo.setEstadoActual("Validando archivo...");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void procesar(ArchivoCliente archivo) {
        try {
            archivo.setEstadoActual("Procesando archivo...");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}