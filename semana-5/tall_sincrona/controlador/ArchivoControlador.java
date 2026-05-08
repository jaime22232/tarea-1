package tall_sincrona.controlador;

import tall_sincrona.modelo.*;
import tall_sincrona.vista.VentanaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ArchivoControlador {
    private final VentanaPrincipal vista;
    private final GestorArchivos gestor;

    public ArchivoControlador(VentanaPrincipal vista) {
        this.vista = vista;
        this.gestor = new GestorArchivos();
        this.vista.addBtnProcesarListener(new ProcesarListener());
    }

    private class ProcesarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // 1. Limpiamos el log (Ahora sí se verá vacío al instante)
            vista.limpiarLog();

            ArchivoCliente archivo = new ArchivoCliente("transacciones_mayo.xlsx");

            // 2. Ejecución síncrona: El hilo se bloquea aquí por 8 segundos.
            // Durante este tiempo, el log se verá en blanco (reiniciado).
            String resultado = gestor.procesarFlujoSincrono(archivo);

            // 3. Al terminar todo el proceso, soltamos los logs de golpe
            vista.setLogText(resultado);
        }
    }
}