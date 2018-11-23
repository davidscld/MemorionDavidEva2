/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorion.david.eva;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Timer;

/**
 *
 * @author dvdsa
 */
public class ControladorJuegoCartas extends MouseAdapter {

    private Logica logica;
    private static int contador = 0;
    private static Carta primerCartaPulsada, segundaCartaPulsada;
    private boolean cartasEmparejadas = true;
    private Timer timer, tiempo;
    /**
     * ControladorJuegoCartas(Logica logica)
     * El controlador se crea en la vistaMEnuPrincipal y esta envia la logica.
     */
    public ControladorJuegoCartas(Logica logica) {
        this.logica = logica;
    }

    /**
     * public void mouseClicked(MouseEvent me)
     * Te envia la opcion del JLanbel que has pulsado 
     * Cada vez que entra cuenta 1 para saber si hemos pulsado la primera o 
     * la segunda carta.
     * Si es la primera carta que se pulsa llamamos al metodo de contrar 
     * pulsaciones que esta en la logica, tambien llamamos a VoltearCarta
     * enviandole la carta que se ha`pulsado para que la de la vuelta y
     * guardamos la primera carta que hemos pulsado.
     * Si es la segunda carta que hemos pulsado llamamos al metodo de contrar 
     * pulsaciones que esta en la logica, tambien llamamos a VoltearCarta
     * enviandole la carta que se ha`pulsado para que la de la vuelta y
     * guardamos la segunda carta que hemos pulsado. Luego guardamos en 
     * cartasEmparejadas un booleand que lo recibimos llamando al metodo
     * comprobarpareja(PrimeraCarta,SegundaCarta) que le enviamos las dos cartas 
     * .Ponemos las cartas a null y comprobamos si el cartasEmparejadas es 
     * true o false. Si es true poonermos el contador a 0. Si es false llamamos al 
     * metodo resetearContador()
     */
    @Override
    public void mouseClicked(MouseEvent me) {

        contador++;

        if (contador == 1) {
           
            logica.contadorPulsaciones();//Necesitamos pasarle las pulsaciones a la clase partida y que estas vuelvan a 0 al cargar una nueva partida
            logica.voltearCarta((Carta) me.getSource());
            primerCartaPulsada = (Carta) me.getSource();

        }
        if (contador == 2) {//En el caso de que haya pulsado dos cartas
           
            logica.contadorPulsaciones();//Necesitamos pasarle las pulsaciones a la clase partida y que estas vuelvan a 0 al cargar una nueva partida
            logica.voltearCarta((Carta) me.getSource());
            segundaCartaPulsada = (Carta) me.getSource();
            cartasEmparejadas = logica.comprobarParejas(primerCartaPulsada, segundaCartaPulsada);
            primerCartaPulsada = null;
            segundaCartaPulsada = null;
            if (cartasEmparejadas) {
                contador = 0;
            } else {
                resetearContador();
            }

        }
    }
    
    /**
     * resetearContador()
     * Lo que hace es resetea el contador y no se pueden pulsar mas de dos carta
     * a la vez
     */
    private void resetearContador() {
        timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                contador = 0;
                timer.stop();
            }
        });
        timer.start();
        timer.setRepeats(true);
    }


}
