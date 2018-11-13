/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorion.david.eva;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * a
 *
 * @author dvdsa
 */
public class VistaMenuPrincipal extends JFrame {

    private JButton ranking, jugar, pGuardadas;
    private JLabel fondo;
    private ImageIcon imagenFondo;

    public VistaMenuPrincipal() {
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
        int alto= 60;
        int ancho = 250;
        int x =220;
        Font f = new Font("Cambria",Font.ITALIC,45);
        //BOTON DE COMENZAR A JUGAR
        jugar = new JButton("Play");
        jugar.setBounds(x, 300, ancho, alto);  
        jugar.setFont(f);
        this.add(jugar);
        
        //BONTON DE PARTIDAS GUARDADAS
        pGuardadas = new JButton("Saved");
        pGuardadas.setBounds(x, 400, ancho, alto);
        pGuardadas.setFont(f);
        this.add(pGuardadas);
        //BOTON RANKING
        ranking = new JButton("Score");
        ranking.setBounds(x, 500, ancho, alto);
        ranking.setFont(f);
        this.add(ranking);

    }

}
