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
 */
public class ControladorBotonesMenuSuperior implements ActionListener{
    Logica logica=new Logica();
    @Override
    public void actionPerformed(ActionEvent ae) {
        String opcion=((JMenuItem)ae.getSource()).getText();
        switch (opcion) {
            case "Play":
                logica.abrirFrameNiveles();
                break;
            case "Load game": //cargar partida
                break;
            case "Save game": //guardar partida
                break;
        }
    }
    
}
