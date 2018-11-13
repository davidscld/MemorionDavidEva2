/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorion.david.eva;

import javax.swing.JPanel;

/**
 *
 * @author dvdsa
 */
public class Partida extends JPanel {
//TIENE QUE RECIBIR EL ARRAYLIST CON LAS CARTAS

    private String dificultad;
    private int numeroCartasAncho, numeroCartasLargo;
    public Partida(String dificultad) {
        this.dificultad = dificultad;
        this.setSize(1080, 720);
        calcularDistribucion();

    }

    private void calcularDistribucion() {
        if (this.dificultad.equals("facil")) {
            
        } else if (this.dificultad.equals("media")) {

        } else {

        }
    }

}
