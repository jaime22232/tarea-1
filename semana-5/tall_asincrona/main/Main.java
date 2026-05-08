package tall_asincrona.main;

import tall_asincrona.controlador.ArchivoControlador;
import tall_asincrona.vista.VentanaPrincipal;
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


