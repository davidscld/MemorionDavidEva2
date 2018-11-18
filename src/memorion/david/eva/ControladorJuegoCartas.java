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
    private static int contador = 0;
    private static Carta primerCartaPulsada, segundaCartaPulsada;

    public ControladorJuegoCartas(Logica logica) {
        this.logica = logica;
    }
//Aqui da error

    @Override
    public void mouseClicked(MouseEvent me) {

        logica.contadorPulsaciones();//Necesitamos pasarle las pulsaciones a la clase partida y que estas vuelvan a 0 al cargar una nueva partida
        logica.voltearCarta((Carta) me.getSource());
        contador++;
        
        if (contador == 1) {
            primerCartaPulsada=(Carta) me.getSource();
        }
        if(contador == 2){//En el caso de que haya pulsado dos cartas
            segundaCartaPulsada=(Carta) me.getSource();
            logica.comprobarParejas(primerCartaPulsada, segundaCartaPulsada);
            primerCartaPulsada=null;
            segundaCartaPulsada=null;
            contador=0;
        }
    }

}
