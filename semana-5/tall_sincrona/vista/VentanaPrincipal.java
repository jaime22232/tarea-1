package tall_sincrona.vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {
    private JButton btnProcesar;
    private JTextArea txtLog;

    public VentanaPrincipal() {
        configurarVentana();
        inicializarComponentes();
    }

    private void configurarVentana() {
        setTitle("DataFast - Sistema de Procesamiento Síncrono");
        setSize(550, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(240, 242, 245));
    }

    private void inicializarComponentes() {
        setLayout(new BorderLayout(15, 15));
        ((JPanel)getContentPane()).setBorder(new EmptyBorder(20, 20, 20, 20));

        btnProcesar = new JButton("Ejecutar Tarea Pesada");
        btnProcesar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnProcesar.setBackground(new Color(0, 120, 215));
        btnProcesar.setForeground(Color.WHITE);
        btnProcesar.setFocusPainted(false);

        txtLog = new JTextArea();
        txtLog.setEditable(false);
        txtLog.setFont(new Font("Consolas", Font.PLAIN, 13));

        JScrollPane scroll = new JScrollPane(txtLog);
        scroll.setBorder(BorderFactory.createTitledBorder("Consola de Actividad"));

        add(btnProcesar, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
    }

    public void addBtnProcesarListener(ActionListener listener) {
        btnProcesar.addActionListener(listener);
    }

    public void setLogText(String texto) {
        txtLog.setText(texto);
        // Aquí no forzamos el repintado para cumplir con tu requisito
        // de que aparezca todo al final.
    }

    public void limpiarLog() {
        txtLog.setText("");
        // CLAVE: Forzamos el repintado del área vacía inmediatamente.
        // Esto hace que el log se vea limpio justo antes de que el hilo se bloquee.
        txtLog.paintImmediately(txtLog.getVisibleRect());
    }
}