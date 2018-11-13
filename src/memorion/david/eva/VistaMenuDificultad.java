/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorion.david.eva;

import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author dvdsa
 */
public class VistaMenuDificultad extends JFrame {

    private JButton JBDifBaja, difMedia, JBDifAlta;
    private JLabel JLFondo;
    private Label LTitulo;
    private ImageIcon IGImagenFondo;

    public VistaMenuDificultad() {
       // configurarTitulo();
        configurarBotonoes();
        configurarVentana();
    }

    private void configurarVentana() {
        this.setSize(720, 905);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        IGImagenFondo = new ImageIcon(this.getClass().getResource("/assets/portadaLazarillo.jpg"));
        JLFondo = new JLabel();
        JLFondo.setIcon(IGImagenFondo);
        JLFondo.setBounds(0, -30, 700, 910);
        this.add(JLFondo);
    }

    private void configurarBotonoes() {
        int alto = 60;
        int ancho = 250;
        int x = 220;
        Font f = new Font("Cambria", Font.ITALIC, 45);

        //BOTON RANKING
        JBDifBaja = new JButton("Low");
        JBDifBaja.setBounds(x, 300, ancho, alto);
        JBDifBaja.setFont(f);
        this.add(JBDifBaja);
        //BOTON DE COMENZAR A JUGAR
        difMedia = new JButton("Medium");
        difMedia.setBounds(x, 400, ancho, alto);
        difMedia.setFont(f);
        this.add(difMedia);

        //BONTON DE PARTIDAS GUARDADAS
        JBDifAlta = new JButton("High");
        JBDifAlta.setBounds(x, 500, ancho, alto);
        JBDifAlta.setFont(f);
        this.add(JBDifAlta);

    }

    private void configurarTitulo() {
        //Crear titulo
        LTitulo = new Label("Level", Label.CENTER);
        LTitulo.setFont(new Font("Cambria", Font.ITALIC, 45));
        LTitulo.setBounds(240, 150, 200, 100);
        LTitulo.setBackground(null);
        this.add(LTitulo);
    }
}
