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
    /**
     * ControladorPartidasGuardadas(Logica logica)
     * El controlador se crea en la vistaMEnuPrincipal y esta envia la logica.
     */
    public ControladorPartidasGuardadas(Logica logica) {
        this.logica = logica;
    }
    /**
     * public void actionPerformed(ActionEvent ae)
     * te envia la opcion del menu que has pulsado 
     * Llama a un metodo de la logica que se llama
     * cargarPartidaGaurdada enviandole el nombre de la partida que quiero 
     * cargar.
     */
    @Override
    public void mouseClicked(MouseEvent me) {

        logica.cargarPartidaGuardada(((JLabel) me.getSource()).getText());
    }

}
