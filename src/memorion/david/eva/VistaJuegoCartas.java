/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorion.david.eva;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author dvdsa
 */
public class VistaJuegoCartas extends JPanel {

    private Partida partida;
    private MenuSuperior menuSuperior;
    private URL url = getClass().getResource("/assets/fondo.jpg");
    private Image imgCarretera = new ImageIcon(url).getImage();

    public VistaJuegoCartas(Partida partida) {

        this.partida = partida;
        this.add(partida);
        this.setLayout(null);
        this.setSize(700, 925);
        /*Da error el timer no sigue con la ejecucion del programa*/
        //this.partida.JLabeltiempo();

    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(imgCarretera, 0, 0, getWidth(), getHeight(), this);
        this.setOpaque(false);
        super.paint(g);
    }

}
