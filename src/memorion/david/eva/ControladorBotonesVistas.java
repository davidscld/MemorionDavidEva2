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
Logica logica;
    public ControladorBotonesVistas(Logica logica) {
        this.logica = logica;
    }

  

    @Override
    public void actionPerformed(ActionEvent ae) {
        String opcion = ((JButton) ae.getSource()).getText();
        switch (opcion) {
            //Casos de la VistaMenuPrincial
            case "Play":
                logica.abrirVistaMenuDificultad();
                break;
            case "Saved":
                //Primero hay que saber guardar
                break;
            case "Score":
                logica.abrirFrameRankingJugadores();
                break;
                
                //Casos de la VistaMenuDificultad
            case "Low":
            case "High":
            case "Medium":
                logica.Barajar();
                logica.abrirPartida(opcion);
                break;

        }
    }

}
