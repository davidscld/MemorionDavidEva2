/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorion.david.eva;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author dvdsa
 */
public class ControladorHuevoPascua extends MouseAdapter {

    private Logica logica;
    private static int contador = 0;
    /**
     * Consttructor que se ejecuta cuando se crea el controlador en la clase 
     * partida y se le encvia la logica.
     */
    public ControladorHuevoPascua(Logica logica) {
        this.logica = logica;
    }
    /**
     * void mouseClicked(MouseEvent me)
     * Cuando se hace clic 6 veces llama a al metodo huevodePascua que se 
     * encuentra en la logica
     */
    @Override
    public void mouseClicked(MouseEvent me) {

        contador++;
        if (contador == 6) {
            logica.huevoDePascua();
        }
    }
}
