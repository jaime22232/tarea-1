package tall_asincrona.controlador;

import tall_asincrona.modelo.*;
import tall_asincrona.vista.VentanaPrincipal;
import javax.swing.SwingWorker;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ArchivoControlador {
    private final VentanaPrincipal vista;
    private final GestorArchivos gestor;

    public ArchivoControlador(VentanaPrincipal vista) {
        this.vista = vista;
        this.gestor = new GestorArchivos();
        this.vista.addBtnProcesarListener(new ProcesarListener());
    }

    // Clase para enviar datos del hilo secundario al hilo de la interfaz
    private static class Progreso {
        String msg; int val;
        Progreso(String m, int v) { msg = m; val = v; }
    }

    private class ProcesarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vista.limpiarLog();
            vista.setBotonEstado(false);
            ArchivoCliente archivo = new ArchivoCliente("backup_sistema.zip");

            // Creamos el trabajador asíncrono
            SwingWorker<Void, Progreso> worker = new SwingWorker<>() {
                @Override
                protected Void doInBackground() throws Exception {
                    // Esto corre en un hilo secundario. NO bloquea la ventana.
                    publish(new Progreso("Iniciando descarga...", 10));
                    gestor.ejecutarDescarga(archivo);

                    publish(new Progreso("Validando integridad...", 40));
                    gestor.ejecutarValidacion(archivo);

                    publish(new Progreso("Procesando datos finales...", 70));
                    gestor.ejecutarProcesamiento(archivo);

                    return null;
                }

                @Override
                protected void process(List<Progreso> chunks) {
                    // Esto corre en el hilo de la interfaz (EDT). Es seguro actualizar Swing.
                    Progreso ultimo = chunks.get(chunks.size() - 1);
                    vista.actualizarUI(ultimo.msg, ultimo.val);
                }

                @Override
                protected void done() {
                    // Se ejecuta al finalizar el proceso
                    vista.actualizarUI("¡Proceso completado exitosamente!", 100);
                    vista.setBotonEstado(true);
                }
            };

            worker.execute(); // Inicia el hilo
        }
    }
}