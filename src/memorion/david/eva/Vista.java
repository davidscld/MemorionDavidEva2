/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorion.david.eva;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author dvdsa
 */
public class Vista extends JFrame {

    private MenuSuperior menuSuperior;
    private JPanel panel;
    private VistaMenuPrincipal vistaMenuPrincipal;
    private Logica logica;
    private Logica logica2;
    public Vista() {
        logica = new Logica (this);
        vistaMenuPrincipal = new VistaMenuPrincipal(logica);
        //panel=vistaMenuPrincipal;
        //this.add(panel);
        this.add(vistaMenuPrincipal);
        configuracionMenuSuperior();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        logica2 = new Logica(this);
        logica2.crearArrayListDeCartas();

    }

    private void configuracionMenuSuperior() {
        menuSuperior = new MenuSuperior();
        this.setJMenuBar(menuSuperior);
    }

    /*public void crearPanel(JPanel panel){
        System.out.println("aaaa");
        this.panel=panel;
        this.remove(this.panel);
        this.repaint();
        this.add(panel);
        
    }*/
}
