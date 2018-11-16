/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorion.david.eva;

import java.awt.GridLayout;
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
    private JLabel JLpartida;
    private ControladorPartidasGuardadas controladorPartidasGuardadas;
    private ImageIcon IMGimagenFondo;
    private JLabel JLfondo;

    public VistaPartidasGuardadas(Logica logica) {
        this.logica = logica;
        configurarVentana();
        this.columnas = 0;

    }

    private void configurarVentana() {
        controladorPartidasGuardadas = new ControladorPartidasGuardadas(logica);
        this.setSize(720, 905);

        IMGimagenFondo = new ImageIcon(this.getClass().getResource("/assets/portadaLazarillo.jpg"));
        JLfondo = new JLabel();
        JLfondo.setIcon(IMGimagenFondo);
        JLfondo.setBounds(0, -30, 700, 900);
        this.add(JLfondo);
        mostrarPartidas();

    }

    public void mostrarPartidas() {
        if (!logica.getArrayPartidasGuardadas().isEmpty()) {
            this.filas = logica.getArrayPartidasGuardadas().size();
            this.setLayout(new GridLayout(filas, columnas));
            for (Partida it : logica.getArrayPartidasGuardadas()) {
               JLabel JLpartida = new JLabel(it.getNombrePartida());
                JLpartida.addMouseListener(controladorPartidasGuardadas);
                this.add(JLpartida);
            }

        }
    }
}
