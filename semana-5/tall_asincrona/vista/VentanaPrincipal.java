package tall_asincrona.vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {
    private JButton btnProcesar;
    private JTextArea txtLog;
    private JProgressBar barraProgreso;

    public VentanaPrincipal() {
        configurarVentana();
        inicializarComponentes();
    }

    private void configurarVentana() {
        setTitle("DataFast - Sistema de Procesamiento Asíncrono");
        setSize(550, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(240, 242, 245));
    }

    private void inicializarComponentes() {
        setLayout(new BorderLayout(15, 15));
        ((JPanel)getContentPane()).setBorder(new EmptyBorder(20, 20, 20, 20));

        btnProcesar = new JButton("Iniciar Procesamiento Asíncrono");
        btnProcesar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnProcesar.setBackground(new Color(34, 139, 34)); // Verde Bosque para diferenciar del síncrono
        btnProcesar.setForeground(Color.WHITE);
        btnProcesar.setFocusPainted(false);

        txtLog = new JTextArea();
        txtLog.setEditable(false);
        txtLog.setFont(new Font("Consolas", Font.PLAIN, 13));

        barraProgreso = new JProgressBar(0, 100);
        barraProgreso.setStringPainted(true);
        barraProgreso.setPreferredSize(new Dimension(0, 25));

        JPanel panelCentro = new JPanel(new BorderLayout(10, 10));
        panelCentro.setOpaque(false);
        panelCentro.add(new JScrollPane(txtLog), BorderLayout.CENTER);
        panelCentro.add(barraProgreso, BorderLayout.SOUTH);

        add(btnProcesar, BorderLayout.NORTH);
        add(panelCentro, BorderLayout.CENTER);
    }

    public void addBtnProcesarListener(ActionListener listener) {
        btnProcesar.addActionListener(listener);
    }

    public void setBotonEstado(boolean activo) {
        btnProcesar.setEnabled(activo);
        btnProcesar.setText(activo ? "Iniciar Procesamiento Asíncrono" : "Procesando...");
    }

    public void actualizarUI(String mensaje, int porcentaje) {
        txtLog.append("[ASINC] " + mensaje + "\n");
        barraProgreso.setValue(porcentaje);
    }

    public void limpiarLog() {
        txtLog.setText("");
        barraProgreso.setValue(0);
    }
}