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
    private MenuSuperior menuSuperior;
    private JButton JBdifBaja, JBdifMedia, JBdifAlta;
    private JLabel JLfondo;
    private Label LBtitulo;
    private ImageIcon IMGimagenFondo;
    private ControladorBotonesVistas controladorBotonesVistas;
    public VistaMenuDificultad() {
       // configurarTitulo();
        configurarBotonoes();
        configurarVentana();
         configuracionMenuSuperior();
    }

    private void configurarVentana() {
        this.setSize(720, 905);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        IMGimagenFondo = new ImageIcon(this.getClass().getResource("/assets/Fondo/portadaLazarillo.jpg"));
        JLfondo = new JLabel();
        JLfondo.setIcon(IMGimagenFondo);
        JLfondo.setBounds(0, -30, 700, 910);
        this.add(JLfondo);
    }

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

    private void configurarTitulo() {
        //Crear titulo
        LBtitulo = new Label("Level", Label.CENTER);
        LBtitulo.setFont(new Font("Cambria", Font.ITALIC, 45));
        LBtitulo.setBounds(240, 150, 200, 100);
        LBtitulo.setBackground(null);
        this.add(LBtitulo);
    }

    private void crearActionJButton() {
        controladorBotonesVistas = new ControladorBotonesVistas();
        JBdifAlta.addActionListener(controladorBotonesVistas);
        JBdifMedia.addActionListener(controladorBotonesVistas);
        JBdifBaja.addActionListener(controladorBotonesVistas);
    }
        private void configuracionMenuSuperior(){
        menuSuperior=new MenuSuperior();
        this.setJMenuBar(menuSuperior);
    }
}
