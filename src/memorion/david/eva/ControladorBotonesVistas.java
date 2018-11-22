/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorion.david.eva;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author dvdsa
 */
public class ControladorBotonesVistas implements ActionListener {
    private Logica logica;

    /**
     * ControladorBotonesVistas(Logica logica)
     * El controlador se crea en la vistaMEnuPrincipal y esta envia la logica.
     */
    
    public ControladorBotonesVistas(Logica logica) {
        this.logica = logica;
    }

  
    /**
     * public void actionPerformed(ActionEvent ae)
     * te envia la opcion del menu que has pulsado 
     * SE guarda el texto en un String y se crea un switch-casa para saber 
     * cual es la opcion que se ha pulsado y llamar a el metodo correspondiente
     * de la calse logica.
     * Este metodo tiene casos de la VistaMenuPrincipal y de la VistaMenuDificultad.
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        String opcion = ((JButton) ae.getSource()).getText();
        
        switch (opcion) {
            //Casos de la VistaMenuPrincial
            case "Play":
                logica.abrirVistaMenuDificultad();
                break;
            case "Saved":
                logica.abrirVistaPartidasGuardadas();
                break;
            case "Score":
                logica.abrirVistaRankingJugadores();
                break;
                
                //Casos de la VistaMenuDificultad
            case "Low":
            case "High":
            case "Medium": 
                logica.barajar();
                logica.abrirPartidaNueva(opcion);
                break;
            case "Reset":
                logica.resetearEstadisticas();
                break;
            

        }
    }

}
