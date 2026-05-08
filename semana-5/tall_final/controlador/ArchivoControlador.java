package tall_final.controlador;

import tall_final.modelo.*;
import tall_final.vista.VentanaPrincipal;
import javax.swing.SwingWorker;
import java.util.ArrayList;
import java.util.List;

public class ArchivoControlador {
    private final VentanaPrincipal vista;
    private final GestorArchivos gestor;
    private SwingWorker<Void, String> worker;

    public ArchivoControlador(VentanaPrincipal vista) {
        this.vista = vista;
        this.gestor = new GestorArchivos();
        this.vista.addBtnIniciarListener(e -> iniciarProceso());
        this.vista.addBtnCancelarListener(e -> cancelarProceso());
    }

    private void iniciarProceso() {
        vista.limpiar();
        vista.setEstadoBotones(true);

        List<ArchivoCliente> lista = new ArrayList<>();
        for(int i=1; i<=5; i++) lista.add(new ArchivoCliente("archivo_00" + i + ".dat"));

        worker = new SwingWorker<>() {
            int exitosos = 0;
            int fallidos = 0;
            long inicio = System.currentTimeMillis();

            @Override
            protected Void doInBackground() throws Exception {
                for (int i = 0; i < lista.size(); i++) {
                    if (isCancelled()) break;

                    ArchivoCliente arc = lista.get(i);
                    publish("Procesando " + arc.getNombre() + "...");

                    try {
                        gestor.procesarArchivo(arc);
                        exitosos++;
                        publish("   -> [OK]");
                    } catch (Exception ex) {
                        fallidos++;
                        publish("   -> [ERROR] " + ex.getMessage());
                    }

                    setProgress((i + 1) * 100 / lista.size());
                }
                return null;
            }

            @Override
            protected void process(List<String> chunks) {
                for (String msg : chunks) {
                    vista.actualizarProgreso(getProgress(), msg);
                }
            }

            @Override
            protected void done() {
                long fin = System.currentTimeMillis();
                vista.setEstadoBotones(false);

                if (isCancelled()) {
                    vista.actualizarProgreso(0, "!!! PROCESO CANCELADO POR EL USUARIO !!!");
                } else {
                    String resumen = String.format(
                            "Archivos procesados: %d\nExitosos: %d\nFallidos: %d\nTiempo total: %.2f seg",
                            lista.size(), exitosos, fallidos, (fin - inicio) / 1000.0
                    );
                    vista.mostrarResumen(resumen);
                }
            }
        };
        worker.execute();
    }

    private void cancelarProceso() {
        if (worker != null) worker.cancel(true);
    }
}