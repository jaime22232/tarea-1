package tall_final.main;

import tall_final.controlador.ArchivoControlador;
import tall_final.vista.VentanaPrincipal;
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