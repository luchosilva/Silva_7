package GUIs;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;

public class VentanaPrincipal extends JFrame implements ActionListener {

    private int contador;
    private JTextField rutaTexto;
    private JButton botonCargar;

    public VentanaPrincipal() {
        super();
        iniciarVentana();
        iniciarBotones();
    }

    /**
     * Inicializa la ventana
     *
     * @param
     * @return void
     */
    private void iniciarVentana() {
        this.setTitle("Presentador de texto");
        this.setSize(700, 350);
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
        contador = 0;
        Font fuente = new Font("Agency FB", 4, 25);
        rutaTexto = new JTextField("Ingrese la ruta del texto");
        botonCargar = new JButton("Cargar texto");
        botonCargar.setBounds(240, 160, 200, 70);
        rutaTexto.setBounds(150, 80, 400, 70);
        botonCargar.addActionListener(this);
        botonCargar.setFont(fuente);
        rutaTexto.setFont(fuente);
        rutaTexto.setForeground(Color.BLACK);
        botonCargar.setForeground(Color.BLACK);
        this.add(botonCargar);
        this.add(rutaTexto);
    }

    /**
     * Retorna el estado del objeto
     *
     * @param
     * @return VentanaPrincipal
     */
    public VentanaPrincipal getVentana() {
        return this;
    }

    /**
     * Rotorna la ruta del texto
     *
     * @param
     * @return JTextField
     */
    public JTextField getCuadro() {
        return rutaTexto;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonCargar) {
            if (contador == 0) {
                SegundaVentana texto = new SegundaVentana(getVentana());
                texto.setVisible(true);
                this.setVisible(false);
            }
        }
    }
}