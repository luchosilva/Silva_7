package GUIs;

import GestionadorTextos.GestionadorTextos;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.event.*;

public class SegundaVentana extends JFrame implements ActionListener {

    private VentanaPrincipal ventanaPrincipal;
    private JScrollPane barraDeslizante;
    private JPanel panelInferior;
    private JTextArea ingresoTexto;
    private JButton botonReinicio;
    private JButton botonVolver;

    public SegundaVentana(VentanaPrincipal ventanaPrincipal) {
        super();
        iniciarVentana();
        iniciarBotones();
        iniciarPanel();
        this.ventanaPrincipal = ventanaPrincipal;
    }

    /**
     * Inicializa la ventana
     *
     * @param
     * @return void
     */
    private void iniciarVentana() {
        this.setTitle("TEXTO");
        this.setSize(700, 450);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Inicializa los componentes de la ventana
     *
     * @param
     * @return void
     */
    private void iniciarBotones() {
        botonVolver = new JButton("Subir otro archivo");
        botonVolver.setBounds(370, 80, 230, 50);
        botonVolver.addActionListener(this);
        this.add(botonVolver);
        botonReinicio = new JButton("Mostrar texto");
        botonReinicio.setBounds(100, 80, 230, 50);
        botonReinicio.addActionListener(this);
        this.add(botonReinicio);
    }

    /**
     * Inicializa el panel de la ventana
     *
     * @param
     * @return void
     */
    private void iniciarPanel() {
        panelInferior = new JPanel();
        panelInferior.setBounds(100, 140, 500, 200);
        panelInferior.setLayout(new BorderLayout());
        ingresoTexto = new JTextArea("");
        panelInferior.add(ingresoTexto);
        barraDeslizante = new JScrollPane(ingresoTexto, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        panelInferior.add(barraDeslizante, BorderLayout.CENTER);
        this.add(panelInferior);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonReinicio) {
            try {
                mostrarTexto();
            } catch (IOException ex) {
                Logger.getLogger(SegundaVentana.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource() == botonVolver) {
            ventanaPrincipal.setVisible(true);
            this.setVisible(false);
        }
    }

    /**
     * Llama al gestor de archivos
     *
     * @param
     * @return void
     */
    public void mostrarTexto() throws IOException {
        GestionadorTextos gestor = new GestionadorTextos();
        String ubicacion = ventanaPrincipal.getCuadro().getText();
        if (ubicacion.equals("archivo1.txt")) {
            ingresoTexto.setText(gestor.leerPrimerTexto(ubicacion));
        } else if (ubicacion.equals("archivo2.txt")) {
            ingresoTexto.setText(gestor.leerSegundoTexto(ubicacion));
        } else {
            JOptionPane.showMessageDialog(this, "¡Debe introducir una ruta válida!");
        }

    }
}