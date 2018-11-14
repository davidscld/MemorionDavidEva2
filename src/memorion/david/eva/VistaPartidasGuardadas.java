/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorion.david.eva;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author dvdsa
 */
public class VistaPartidasGuardadas extends JFrame {
    
    private MenuSuperior menuSuperior;
    
    public VistaPartidasGuardadas() {
        configurarVentana();
        configuracionMenuSuperior();
        
        
    }
    
    private void configurarVentana() {
        this.setSize(720, 905);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        
    }
    
    private void configuracionMenuSuperior(){
        menuSuperior=new MenuSuperior();
        this.setJMenuBar(menuSuperior);
    }
}
