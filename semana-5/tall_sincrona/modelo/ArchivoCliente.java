package tall_sincrona.modelo;

public class ArchivoCliente {
    private final String nombreArchivo;
    private String estadoActual;

    public ArchivoCliente(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
        this.estadoActual = "Pendiente";
    }

    public String getNombreArchivo() { return nombreArchivo; }
    public String getEstadoActual() { return estadoActual; }
    public void setEstadoActual(String estadoActual) { this.estadoActual = estadoActual; }
}