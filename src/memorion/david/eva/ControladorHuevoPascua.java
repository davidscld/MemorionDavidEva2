/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorion.david.eva;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author dvdsa
 */
public class ControladorHuevoPascua extends KeyAdapter {

    private Logica logica;
    private static int contador = 0;

    public ControladorHuevoPascua(Logica logica) {
        this.logica = logica;
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (KeyEvent.VK_6 == ke.getKeyCode()) {
            contador++;
            if (contador == 6) {

            }
        } else {

        }
    }

}
