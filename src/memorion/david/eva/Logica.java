/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorion.david.eva;

import java.util.ArrayList;

/**
 *
 * @author dvdsa
 */
public class Logica {
    private ArrayList<Carta> ArrayListCartas = new ArrayList<>();
    
    public void abrirFrameNiveles(){
        VistaMenuDificultad vistaMenuDificultad=new VistaMenuDificultad();
        vistaMenuDificultad.setVisible(true);
    }
    
    public void abrirFrameRankingJugadores(){
        VistaRankingJugadores vistaRankingJugadores=new VistaRankingJugadores();
        vistaRankingJugadores.setVisible(true);
    }

    public ArrayList<Carta> getArrayListCartas() {
        return ArrayListCartas;
    }
    
    
}
