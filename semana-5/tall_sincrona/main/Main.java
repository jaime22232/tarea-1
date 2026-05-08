package tall_sincrona.main;

import tall_sincrona.controlador.ArchivoControlador;
import tall_sincrona.vista.VentanaPrincipal;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal vista = new VentanaPrincipal();
            new ArchivoControlador(vista);
            vista.setVisible(true);
        });
    }
}