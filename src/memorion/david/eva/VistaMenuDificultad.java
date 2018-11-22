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
import javax.swing.JPanel;

/**
 *
 * @author dvdsa
 * 
 * Clase que extiende de JPanel
 */
public class VistaMenuDificultad extends JPanel {
    private MenuSuperior menuSuperior;
    private JButton JBdifBaja, JBdifMedia, JBdifAlta;
    private JLabel JLfondo;
    private Label LBtitulo;
    private ImageIcon IMGimagenFondo;
    private ControladorBotonesVistas controladorBotonesVistas;
    private Logica logica;
    
    /**
     *VistaMenuDificultad(Logica logica)
     * Constructor que se crea en el metodo correspondiente de la logica y que 
     * envia la logica .
     * Este constructor guarda la logica que se le ha enviado y llama a los metodos
     * configurarBotonoes() y  configurarVentana().
     */
    
    public VistaMenuDificultad(Logica logica) {

        this.logica = logica;
        configurarBotonoes();
        configurarVentana();
        
    }
    /**
     * configurarVentana()
     * Es la configuracion de la clase en si que es un JPanel dandole una imagen
     * un tamaño.
     */
    
    private void configurarVentana() {
        this.setSize(720, 925);
        
        this.setLayout(null);
        IMGimagenFondo = new ImageIcon(this.getClass().getResource("/assets/portadaLazarillo.jpg"));
        JLfondo = new JLabel();
        JLfondo.setIcon(IMGimagenFondo);
        JLfondo.setBounds(0, -30, 700, 900);
        this.add(JLfondo);
    }
    
    /**
     * configurarBotonoes()
     * Metodo que configura los botones que tiene esta clase con un tamaño
     * una clase de letra, su texto y lo añade al Jpanel de esta clase.
     */

    private void configurarBotonoes() {
        int alto = 60;
        int ancho = 250;
        int x = 220;
        Font f = new Font("Cambria", Font.ITALIC, 45);

        //BOTON RANKING
        JBdifBaja = new JButton("Low");
        JBdifBaja.setBounds(x, 300, ancho, alto);
        JBdifBaja.setFont(f);
        this.add(JBdifBaja);
        //BOTON DE COMENZAR A JUGAR
        JBdifMedia = new JButton("Medium");
        JBdifMedia.setBounds(x, 400, ancho, alto);
        JBdifMedia.setFont(f);
        this.add(JBdifMedia);

        //BONTON DE PARTIDAS GUARDADAS
        JBdifAlta = new JButton("High");
        JBdifAlta.setBounds(x, 500, ancho, alto);
        JBdifAlta.setFont(f);
        this.add(JBdifAlta);
        //Metodo que asigna los action
        crearActionJButton();
    }
    /**
     * NO SE UTILIZA
     */
    private void configurarTitulo() {
        //Crear titulo
        LBtitulo = new Label("Level", Label.CENTER);
        LBtitulo.setFont(new Font("Cambria", Font.ITALIC, 45));
        LBtitulo.setBounds(240, 150, 200, 100);
        LBtitulo.setBackground(null);
        this.add(LBtitulo);
    }
    
    /**
     * crearActionJButton()
     * creamos el controladorBotonesVista y le enviamos la logica
     * y añadimos el actionListener a cada boton para que cuando pulsemos
     * uno sepa cual es.
     */
    private void crearActionJButton() {
        controladorBotonesVistas = new ControladorBotonesVistas(logica);
        JBdifAlta.addActionListener(controladorBotonesVistas);
        JBdifMedia.addActionListener(controladorBotonesVistas);
        JBdifBaja.addActionListener(controladorBotonesVistas);
    }

}
