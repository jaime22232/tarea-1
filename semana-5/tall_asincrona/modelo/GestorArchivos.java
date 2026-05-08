package tall_asincrona.modelo;

public class GestorArchivos {
    private final TareaDescarga descarga = new TareaDescarga();
    private final ProcesadorArchivo procesador = new ProcesadorArchivo();

    // Métodos individuales para que el SwingWorker pueda reportar progreso entre cada uno
    public void ejecutarDescarga(ArchivoCliente a) { descarga.descargar(a); }
    public void ejecutarValidacion(ArchivoCliente a) { procesador.validar(a); }
    public void ejecutarProcesamiento(ArchivoCliente a) { procesador.procesar(a); }
}