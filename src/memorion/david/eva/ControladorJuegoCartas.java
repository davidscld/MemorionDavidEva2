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

    public ControladorJuegoCartas(Logica logica) {
        this.logica = logica;
    }
//Aqui da error

    @Override
    public void mouseClicked(MouseEvent me) {

        contador++;

        if (contador == 1) {
           
           // logica.cargarAnimacion((Carta) me.getSource());
            logica.contadorPulsaciones();//Necesitamos pasarle las pulsaciones a la clase partida y que estas vuelvan a 0 al cargar una nueva partida
            logica.voltearCarta((Carta) me.getSource());
            primerCartaPulsada = (Carta) me.getSource();

        }
        if (contador == 2) {//En el caso de que haya pulsado dos cartas
           //    logica.cargarAnimacion((Carta) me.getSource());
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

    private void resetearContador() {
        timer = new Timer(3000, new ActionListener() {
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
