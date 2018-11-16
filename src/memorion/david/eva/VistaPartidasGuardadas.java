/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorion.david.eva;

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
    
    
    public VistaPartidasGuardadas(Logica logica) {
        this.logica=logica;
        configurarVentana();
        
        
        
    }
    
    private void configurarVentana() {
        this.setSize(720, 905);
      
        this.setLayout(null);
        
    }
    
}
