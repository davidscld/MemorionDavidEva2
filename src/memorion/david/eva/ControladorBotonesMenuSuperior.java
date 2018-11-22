/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorion.david.eva;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JMenuItem;

/**
 *
 * @author dvdsa
 * 
 * Implementa ActionListener para que paodamos pulsar a las opciones.
 */
public class ControladorBotonesMenuSuperior implements ActionListener {

    private Logica logica;
  
    /**
     * ControladorBotonesMenuSuperior(Logica logica)
     * El controlador se crea en el menuSuperios y este envia la logica.
     */
    public ControladorBotonesMenuSuperior(Logica logica) {
        this.logica = logica;
    }

    /**
     * public void actionPerformed(ActionEvent ae)
     * te envia la opcion del menu que has pulsado 
     * SE guarda el texto en un String y se crea un switch-casa para saber 
     * cual es la opcion que se ha pulsado y llamar a el metodo correspondiente
     * de la calse logica.
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        String opcion = ((JMenuItem) ae.getSource()).getText();
        switch (opcion) {
            case "Home":
                logica.abrirVistaPrincipal();
                break;
            case "Play":
                logica.abrirVistaMenuDificultad();
                break;
            case "Load game": //cargar partida
                logica.abrirVistaPartidasGuardadas();
                break;
            case "Save game": //guardar partida
                logica.guardarPartida();
                break;
            case "About":
                logica.abrirAcerdaDe();
                break;
                
        }
    }

}
