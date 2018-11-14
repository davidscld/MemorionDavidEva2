/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorion.david.eva;

import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author dvdsa
 */
public class Partida extends JPanel {
//TIENE QUE RECIBIR EL ARRAYLIST CON LAS CARTAS

    private String dificultad, nombrePartida;
    private int numeroCartasAncho, numeroCartasLargo, numeroDePartida;
    private Logica logica;
    private static int n =0;
    public Partida(String dificultad) {
        n++;
        numeroDePartida=n;
        logica = new Logica();
        this.dificultad = dificultad;
        this.nombrePartida = "Partida "+numeroDePartida;
        
        
        this.setBounds(400, 200, 200, 300);
        calcularDistribucion();
        this.setLayout(new GridLayout(this.numeroCartasAncho, this.numeroCartasLargo, 10, 10));
        configurarPanel();
    
    }

    private void calcularDistribucion() {
        System.out.println(dificultad);
        if (this.dificultad.equals("low")) {
            this.numeroCartasAncho = 2;
            this.numeroCartasLargo = 3;

        } else if (this.dificultad.equals("medium")) {
            this.numeroCartasAncho = 5;
            this.numeroCartasLargo = 2;
        } else {
            this.numeroCartasAncho = 4;
            this.numeroCartasLargo = 4;
        }
    }

    private void configurarPanel() {
        this.setSize(1080, 720);
        for (int i = 0; i < 6; i++) {
            this.add(logica.getArrayListCartas().get(i));
        }
    }

}


