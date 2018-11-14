/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorion.david.eva;

import java.awt.BorderLayout;
import javax.swing.JFrame;



/**
 *
 * @author dvdsa
 */
public class VistaJuegoCartas  extends JFrame{
    private Partida partida;

    public VistaJuegoCartas(Partida partida) {
        this.partida = partida;
        this.add(partida); 
        this.setLayout(new BorderLayout());
        
       this.setExtendedState(JFrame.MAXIMIZED_BOTH); //Expande la pantalla al maximo
    }
    
    
}
