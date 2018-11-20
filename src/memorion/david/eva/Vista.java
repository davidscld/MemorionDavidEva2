/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorion.david.eva;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author dvdsa
 */
public class Vista extends JFrame {

    private MenuSuperior menuSuperior;
    private JPanel panel;
    private Logica logica;
    
    public Vista(JPanel panel1,Logica logica) {
        this.setSize(700, 925);
        this.panel=panel1;
        this.add(panel);
        this.logica=logica;
        
        configuracionMenuSuperior();
        configurarCierreAplicacion();
    }
    public void crearPanel(JPanel panel1){
        this.remove(panel);
        this.panel=panel1;
        this.add(panel);
        this.repaint();
    }


    private void configuracionMenuSuperior() {
        menuSuperior = new MenuSuperior(this.logica);
    
        this.setJMenuBar(menuSuperior);
    }

    private void configurarCierreAplicacion() {
             this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
          
            public void windowClosing(WindowEvent evt) {
                opcion();
            }
        });

    }
    private void opcion(){
       if (JOptionPane.showConfirmDialog(rootPane, "¿Desea salir?",
                "Salir del sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            System.exit(0);
    }


}
