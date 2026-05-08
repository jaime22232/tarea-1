package tall_final.vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {
    private JButton btnIniciar, btnCancelar;
    private JTextArea txtLog;
    private JProgressBar barraProgreso;

    public VentanaPrincipal() {
        setTitle("DataFast V.Final - Procesador Multitarea");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        setLayout(new BorderLayout(15, 15));
        ((JPanel)getContentPane()).setBorder(new EmptyBorder(20, 20, 20, 20));

        // Panel Norte: Botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        btnIniciar = new JButton("Iniciar Proceso");
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setEnabled(false);
        panelBotones.add(btnIniciar);
        panelBotones.add(btnCancelar);

        // Panel Central: Log y Progreso
        txtLog = new JTextArea();
        txtLog.setEditable(false);
        txtLog.setFont(new Font("Consolas", Font.PLAIN, 12));

        barraProgreso = new JProgressBar(0, 100);
        barraProgreso.setStringPainted(true);

        JPanel panelCentro = new JPanel(new BorderLayout(10, 10));
        panelCentro.add(new JScrollPane(txtLog), BorderLayout.CENTER);
        panelCentro.add(barraProgreso, BorderLayout.SOUTH);

        add(panelBotones, BorderLayout.NORTH);
        add(panelCentro, BorderLayout.CENTER);
    }

    public void addBtnIniciarListener(ActionListener l) { btnIniciar.addActionListener(l); }
    public void addBtnCancelarListener(ActionListener l) { btnCancelar.addActionListener(l); }

    public void setEstadoBotones(boolean procesando) {
        btnIniciar.setEnabled(!procesando);
        btnCancelar.setEnabled(procesando);
    }

    public void actualizarProgreso(int valor, String mensaje) {
        barraProgreso.setValue(valor);
        txtLog.append(mensaje + "\n");
        txtLog.setCaretPosition(txtLog.getDocument().getLength());
    }

    public void mostrarResumen(String resumen) {
        JOptionPane.showMessageDialog(this, resumen, "Resumen Final", JOptionPane.INFORMATION_MESSAGE);
    }

    public void limpiar() { txtLog.setText(""); barraProgreso.setValue(0); }
}