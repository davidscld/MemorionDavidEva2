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
 * 
 * Clase que extiende de un Jpanel
 */
public class VistaPartidasGuardadas extends JPanel {

    private Logica logica;
    private int filas, columnas;
    private ControladorPartidasGuardadas controladorPartidasGuardadas;
    private JPanel panelCentral;
    private URL url = getClass().getResource("/assets/fondoPartidasJugadas.jpg");
    private Image imagenFondo = new ImageIcon(url).getImage();
    Font f = new Font("Cambria", Font.BOLD, 30);

    /**
     * VistaPartidasGuardadas(Logica logica)
     * Constructor que se ejecuta en la logica cuando creamos la clase 
     * VistaPartidasGuardadas y nos envia la logica.
     * Luego llama al metodo configurarVentana() y pone las comunas a 1 y 
     * las filas a 12.
     */
    
    public VistaPartidasGuardadas(Logica logica) {
        this.logica = logica;
        configurarVentana();
        this.columnas = 1;
        this.filas = 12;
        

    }

    /**
     * configurarVentana()
     * Crea la clase del controladosPartidas guardadas y le envia la logica
     * da un tamaño a la clase que es un JPanel, pone el layaout a null para que
     * nosotros le posicionemos todos los elementos.
     * Luego llama a configurarPanelCentral(), mostrarPartidas(); y 
     * repinta el jPanel
     */
    
    private void configurarVentana() {
        controladorPartidasGuardadas = new ControladorPartidasGuardadas(logica);
        this.setSize(720, 905);
        this.setLayout(null);
        configurarPanelCentral();
        mostrarPartidas();
        this.repaint();

    }
    /**
     * paint(Graphics g)
     * Metodo que se utiliza para poner la imagen de fondo dandole un tamaño
     */
    public void paint(Graphics g) {
        g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
        this.setOpaque(false);
        super.paint(g);
    }
    /**
     * mostrarPartidas()
     * comprobamos si el arraylist de partidasguardadas esta vacio o no y si no 
     * esta vacio recorremos el arraylist de Partidas guardadas y vamos pintando
     * en Jlabel las partidas que tenemos guardadas.
     */
    public void mostrarPartidas() {
        if (!logica.getArrayPartidasGuardadas().isEmpty()) {
           
            for (Partida it : logica.getArrayPartidasGuardadas()) {
                JLabel JLpartida = new JLabel(it.getNombrePartida());
                JLpartida.setFont(f);
                JLpartida.addMouseListener(controladorPartidasGuardadas);
                panelCentral.add(JLpartida);
                panelCentral.repaint();
                
            }

        }
    }
    /**
     * configurarPanelCentral()
     * Metodo que añade un Jpanel central en el que le doy un tamaño y las 
     * coordenadas donde debe ir situado este panel que es el que va a llevar
     * los JLabel de las partidas guardada que hay y se le añado a la clase ya que
     * es un JPanel.
     */
    private void configurarPanelCentral() {
        panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout(12, 0, 10, 10));
        panelCentral.setBounds(240, 20, 300, 600);
        panelCentral.setOpaque(false);
        this.add(panelCentral);
    }
}
