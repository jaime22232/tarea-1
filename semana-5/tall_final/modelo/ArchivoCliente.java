package tall_final.modelo;

public class ArchivoCliente {
    private final String nombre;
    private String estado;
    private boolean exitoso;

    public ArchivoCliente(String nombre) {
        this.nombre = nombre;
        this.estado = "Pendiente";
        this.exitoso = false;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public boolean isExitoso() { return exitoso; }
    public void setExitoso(boolean exitoso) { this.exitoso = exitoso; }
}