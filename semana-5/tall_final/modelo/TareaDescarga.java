package tall_final.modelo;

public class TareaDescarga {
    public void ejecutar(ArchivoCliente archivo) throws InterruptedException {
        archivo.setEstado("Descargando...");
        Thread.sleep(1000);
    }
}