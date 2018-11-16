/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorion.david.eva;

import java.awt.GridLayout;
import java.util.Arrays;
import java.util.Collections;
import javax.swing.JPanel;

/**
 *
 * @author dvdsa
 */
public class Partida extends JPanel {

    private String dificultad, nombrePartida;
    private int numeroCartasAncho, numeroCartasLargo, numeroDePartida, numeroDeCartasUsadas[];

    private static int n = 0;
    private Logica logica;
    public Partida(String dificultad, Logica logica) {
        n++;
        numeroDePartida = n;
        this.logica= logica;
        this.dificultad = dificultad;
        this.nombrePartida = "Partida " + numeroDePartida;

        this.setBounds(500, 100, 600, 800);
        calcularDistribucion();
        this.setLayout(new GridLayout(this.numeroCartasAncho, this.numeroCartasLargo, 10, 10));
        configurarPanel();

    }

    private void calcularDistribucion() {

        if (this.dificultad.equals("Low")) {
            this.numeroCartasAncho = 3;
            this.numeroCartasLargo = 2;
            numeroDeCartasUsadas = new int[]{0, 1, 2, 0, 1, 2};
            
        } else if (this.dificultad.equals("Medium")) {
            this.numeroCartasAncho = 2;
            this.numeroCartasLargo = 5;
            numeroDeCartasUsadas = new int[]{0, 1, 2, 3, 4, 0, 1, 2, 3, 4};
        } else {
            this.numeroCartasAncho = 4;
            this.numeroCartasLargo = 4;
            numeroDeCartasUsadas = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5, 6, 7};
        }
    }

    private void configurarPanel() {
        Collections.shuffle(Arrays.asList(numeroDeCartasUsadas));
        for (int i = 0; i < (numeroCartasAncho * numeroCartasLargo); i++) {
            this.add(logica.getArrayListCartas().get(numeroDeCartasUsadas[i]));//Aqui añado la cartas con el reverso    
        }
    }

}
