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

    private String dificultad;
    private int numeroCartasAncho, numeroCartasLargo;
    private Logica logica;

    public Partida(String dificultad) {
        logica = new Logica();
        this.dificultad = dificultad;
        
        
        this.setSize(1080, 720);
        calcularDistribucion();
        this.setLayout(new GridLayout(this.numeroCartasAncho, this.numeroCartasLargo, 10, 10));
    
    }

    private void calcularDistribucion() {
        if (this.dificultad.equals("facil")) {
            this.numeroCartasAncho = 2;
            this.numeroCartasLargo = 3;

        } else if (this.dificultad.equals("media")) {
            this.numeroCartasAncho = 5;
            this.numeroCartasLargo = 2;
        } else {
            this.numeroCartasAncho = 4;
            this.numeroCartasLargo = 4;
        }
    }

    private void configurarPanel() {
        this.setSize(1080, 720);
        calcularDistribucion();
        this.setLayout(new GridLayout(this.numeroCartasAncho, this.numeroCartasLargo, 10, 10));
        for (int i = 0; i < logica.getArrayListCartas().size(); i++) {
            this.add(logica.getArrayListCartas().get(i));
        }
    }

}


