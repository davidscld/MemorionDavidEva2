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
import javax.swing.JPanel;

/**
 * a
 *
 * @author dvdsa
 */
public class VistaMenuPrincipal extends JPanel {

    private JButton JBranking, JBjugar, JBpGuardadas, JBresetear;
    private JLabel JLfondo;
    private ImageIcon IMGimagenFondo;
    private ControladorBotonesVistas controladorBotonesVistas;
    private Logica logica;
    public VistaMenuPrincipal(Logica logica) {
        this.logica = logica;
        configurarBotonoes();
        configurarVentana();  
        crearActionJButton();
       
    }

    private void configurarVentana() {
        this.setSize(720, 905);
        this.setLayout(null);
        IMGimagenFondo = new ImageIcon(this.getClass().getResource("/assets/portadaLazarillo.jpg"));
        JLfondo = new JLabel();
        JLfondo.setIcon(IMGimagenFondo);
        JLfondo.setBounds(0, -30, 700, 910);
        this.add(JLfondo);
    }

    private void configurarBotonoes() {
        
        int alto= 60;
        int ancho = 250;
        int x =220;
        Font f = new Font("Cambria",Font.ITALIC,45);
        //BOTON DE COMENZAR A JUGAR
        JBjugar = new JButton("Play");
        JBjugar.setBounds(x, 300, ancho, alto);  
        JBjugar.setFont(f);
        this.add(JBjugar);
        
        //BONTON DE PARTIDAS GUARDADAS
        JBpGuardadas = new JButton("Saved");
        JBpGuardadas.setBounds(x, 400, ancho, alto);
        JBpGuardadas.setFont(f);
        this.add(JBpGuardadas);
        //BOTON RANKING
        JBranking = new JButton("Score");
        JBranking.setBounds(x, 500, ancho, alto);
        JBranking.setFont(f);
        this.add(JBranking);
        //BOTON RESETEAR
        JBresetear = new JButton("Reset");
        JBresetear.setBounds(x, 600, ancho, alto);
        JBresetear.setFont(f);
        this.add(JBresetear);
        

    }
    

    
    private void crearActionJButton(){
        controladorBotonesVistas=new ControladorBotonesVistas(logica);
        JBjugar.addActionListener(controladorBotonesVistas);
        JBpGuardadas.addActionListener(controladorBotonesVistas);
        JBranking.addActionListener(controladorBotonesVistas);
        JBresetear.addActionListener(controladorBotonesVistas);
    }

}
