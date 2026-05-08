package tall_sincrona.modelo;

public class GestorArchivos {
    private final TareaDescarga descarga = new TareaDescarga();
    private final ProcesadorArchivo procesador = new ProcesadorArchivo();

    public String procesarFlujoSincrono(ArchivoCliente archivo) {
        StringBuilder log = new StringBuilder();
        log.append(">>> INICIANDO PROCESO SÍNCRONO\n");
        log.append("Archivo: ").append(archivo.getNombreArchivo()).append("\n");
        log.append("-------------------------------------------\n");

        // Simulación de pasos con bloqueos
        descarga.descargar(archivo);
        log.append("[OK] ").append(archivo.getEstadoActual()).append("\n");

        procesador.validar(archivo);
        log.append("[OK] ").append(archivo.getEstadoActual()).append("\n");

        procesador.procesar(archivo);
        log.append("[OK] ").append(archivo.getEstadoActual()).append("\n");

        log.append("-------------------------------------------\n");
        log.append(">>> TAREA FINALIZADA EXITOSAMENTE");

        return log.toString();
    }
}