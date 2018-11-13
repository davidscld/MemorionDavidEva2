/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorion.david.eva;

import java.awt.Font;
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

    private JButton difBaja, difMedia, difAlta;
    private JLabel fondo;
    private ImageIcon imagenFondo;
    private JLabel titulo;
    public VistaMenuDificultad() {
        configurarBotonoes();
        configurarVentana();
    }

    private void configurarVentana() {
        this.setSize(720, 905);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        imagenFondo = new ImageIcon(this.getClass().getResource("/assets/portadaLazarillo.jpg"));
        fondo = new JLabel();
        fondo.setIcon(imagenFondo);
        fondo.setBounds(0, -30, 700, 910);
        this.add(fondo);
    }

    private void configurarBotonoes() {
        int alto = 60;
        int ancho = 250;
        int x = 220;
        Font f = new Font("Cambria", Font.ITALIC, 45);
        
        //Crear titulo
        titulo = new JLabel ("Level");
        titulo.setBounds(x, 100, ancho, alto);
        titulo.setFont(f);
        this.add(titulo);
        //BOTON RANKING
        difBaja = new JButton("Low");
        difBaja.setBounds(x, 300, ancho, alto);
        difBaja.setFont(f);
        this.add(difBaja);
        //BOTON DE COMENZAR A JUGAR
        difMedia = new JButton("Medium");
        difMedia.setBounds(x, 400, ancho, alto);
        difMedia.setFont(f);
        this.add(difMedia);

        //BONTON DE PARTIDAS GUARDADAS
        difAlta = new JButton("High");
        difAlta.setBounds(x, 500, ancho, alto);
        difAlta.setFont(f);
        this.add(difAlta);

    }
}
