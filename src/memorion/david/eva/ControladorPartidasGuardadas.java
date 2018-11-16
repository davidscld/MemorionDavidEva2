/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorion.david.eva;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

/**
 *
 * @author dvdsa
 */
public class ControladorPartidasGuardadas extends MouseAdapter {

    Logica logica;

    public ControladorPartidasGuardadas(Logica logica) {
        this.logica = logica;
    }

    @Override
    public void mouseClicked(MouseEvent me) {

        logica.cargarPartidaGuardada(((JLabel) me.getSource()).getText());
    }

}
