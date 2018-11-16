/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorion.david.eva;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author dvdsa
 */
public class Partida extends JPanel {

    private String dificultad, nombrePartida;
    private ArrayList<Carta> cartasSeleccionadas = new ArrayList<>();
    private int numeroCartasAncho, numeroCartasLargo, numeroDePartida;
    //private ArrayList <JLabel> cartasSeleccionadas = new ArrayList<>();
    private static int n = 0;
    private Logica logica;
    private int tiempoUsado=0;

    public Partida(String dificultad, Logica logica) {
        n++;
        numeroDePartida = n;
        this.logica = logica;
        this.dificultad = dificultad;
        this.nombrePartida = "Partida " + numeroDePartida;
        this.setBackground(Color.yellow);
        this.setBounds(200, 100, 800, 600);
        calcularDistribucion();
        this.setLayout(new GridLayout(this.numeroCartasAncho, this.numeroCartasLargo, 10, 10));
        configurarPanel();

    }

    private void calcularDistribucion() {

        if (this.dificultad.equals("Low")) {
            this.numeroCartasAncho = 3;
            this.numeroCartasLargo = 2;

        } else if (this.dificultad.equals("Medium")) {
            this.numeroCartasAncho = 2;
            this.numeroCartasLargo = 5;
        } else {
            this.numeroCartasAncho = 4;
            this.numeroCartasLargo = 4;

        }
    }

    private void configurarPanel() {

        for (int i = 0; i < ((numeroCartasAncho * numeroCartasLargo) / 2); i++) {

            cartasSeleccionadas.add(logica.getArrayListCartasPar().get(i));
            Carta carta = logica.getArrayListCartasPar().get(i);
            for (int j = 0; j < logica.getArrayListCartasImpar().size(); j++) {
                if (carta.getRutaAnverso().equals(logica.getArrayListCartasImpar().get(j).getRutaAnverso())) {
                    cartasSeleccionadas.add(logica.getArrayListCartasImpar().get(j));

                }
            }
        }
       
        Collections.shuffle(cartasSeleccionadas);
        for (Carta it : cartasSeleccionadas) {
            this.add(it);
        }

    }

}
