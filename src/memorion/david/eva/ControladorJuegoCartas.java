/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorion.david.eva;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author dvdsa
 */
public class ControladorJuegoCartas extends MouseAdapter {

    private Logica logica;

    public ControladorJuegoCartas() {
  
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        logica.voltearCarta((Carta)me.getSource());
    }

}
