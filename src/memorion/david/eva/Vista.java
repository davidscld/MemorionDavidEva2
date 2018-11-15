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
    //private VistaMenuPrincipal vistaMenuPrincipal;
    //private Logica logica;
    //private Logica logica2;
    public Vista(JPanel panel1) {
        //logica = new Logica (this);
        //vistaMenuPrincipal = new VistaMenuPrincipal(logica);
        //panel=vistaMenuPrincipal;
        //this.add(panel);
        //this.add(vistaMenuPrincipal);
        configuracionMenuSuperior();
        this.panel=panel1;
        this.add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //logica2 = new Logica(this);
        //logica2.crearArrayListDeCartas();

    }
    
    public void crearPanel(JPanel panel1){
        this.remove(panel);
        this.panel=panel1;
        this.add(panel);
        this.repaint();
    }

    private void configuracionMenuSuperior() {
        menuSuperior = new MenuSuperior();
        this.setJMenuBar(menuSuperior);
    }
}
