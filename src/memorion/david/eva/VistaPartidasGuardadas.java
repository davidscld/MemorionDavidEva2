/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorion.david.eva;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author dvdsa
 */
public class VistaPartidasGuardadas extends JPanel {

    private Logica logica;
    private int filas, columnas;
    private ControladorPartidasGuardadas controladorPartidasGuardadas;
    private JPanel panelCentral;
    private URL url = getClass().getResource("/assets/fondoPartidasJugadas.jpg");
    private Image imagenFondo = new ImageIcon(url).getImage();
    Font f = new Font("Cambria", Font.BOLD, 30);

    public VistaPartidasGuardadas(Logica logica) {
        this.logica = logica;
        configurarVentana();
        this.columnas = 1;
        this.filas = 12;

    }

    private void configurarVentana() {
        controladorPartidasGuardadas = new ControladorPartidasGuardadas(logica);
        this.setSize(720, 905);
        this.setLayout(null);
        configurarPanelCentral();
        mostrarPartidas();

    }

    public void paint(Graphics g) {
        g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
        this.setOpaque(false);
        super.paint(g);
    }

    public void mostrarPartidas() {
        if (!logica.getArrayPartidasGuardadas().isEmpty()) {
           
            for (Partida it : logica.getArrayPartidasGuardadas()) {
                JLabel JLpartida = new JLabel(it.getNombrePartida());
                JLpartida.setFont(f);
                JLpartida.addMouseListener(controladorPartidasGuardadas);
                panelCentral.repaint();
                panelCentral.add(JLpartida);
                
            }

        }
    }

    private void configurarPanelCentral() {
        panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout(12, 0, 10, 10));
        panelCentral.setBounds(240, 20, 300, 600);
        panelCentral.setOpaque(false);
        this.add(panelCentral);
    }
}
