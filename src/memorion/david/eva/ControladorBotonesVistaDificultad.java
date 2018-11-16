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
 * @author Eva
 */
public class ControladorBotonesVistaDificultad implements ActionListener{
    
    private Logica logica;
    
    ControladorBotonesVistaDificultad(Logica logica) {
        this.logica=logica;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String opcion = ((JButton) ae.getSource()).getText();
        System.out.println(opcion);
        switch (opcion) {
            case "Low":
                logica.barajar();
                logica.abrirPartidaNueva(opcion);
                break;
            case "High":
                logica.barajar();
                logica.abrirPartidaNueva(opcion);
                break;
            case "Medium": 
                logica.barajar();
                logica.abrirPartidaNueva(opcion);
                break;

        }    
    }
    
}
