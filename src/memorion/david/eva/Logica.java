/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorion.david.eva;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author dvdsa
 */
public class Logica {

    private ArrayList<Carta> ArrayListCartas = new ArrayList<>();
    private ArrayList<Jugador> ArrayListJugador = new ArrayList<>();
    
    public void abrirVistaMenuDificultad() {
        VistaMenuDificultad vistaMenuDificultad = new VistaMenuDificultad();
        vistaMenuDificultad.setVisible(true);
    }

    public void abrirFrameRankingJugadores() {
        VistaRankingJugadores vistaRankingJugadores = new VistaRankingJugadores();
        vistaRankingJugadores.setVisible(true);
    }
    
    public void abrirPartida(){
        
    }

    public ArrayList<Carta> getArrayListCartas() {
        return ArrayListCartas;
    }
    
    public ArrayList<Jugador> getArrayListJugador() {
        return ArrayListJugador;
    }
    

    public void crearArrayListDeCartas() {
       Carta carta1 = new Carta(this.getClass().getResource("/assets/Cartas/lazarillo1.jpg"));
        Carta carta2 = new Carta(this.getClass().getResource("/assets/Cartas/lazarillo2.jpg"));
        Carta carta3 = new Carta(this.getClass().getResource("/assets/Cartas/lazarillo3.jpg"));
        Carta carta4 = new Carta(this.getClass().getResource("/assets/Cartas/lazarillo4.jpg"));
        Carta carta5 = new Carta(this.getClass().getResource("/assets/Cartas/lazarillo5.jpg"));
        Carta carta6 = new Carta(this.getClass().getResource("/assets/Cartas/lazarillo6.jpg"));
        Carta carta7 = new Carta(this.getClass().getResource("/assets/Cartas/lazarillo7.jpg"));
        Carta carta8 = new Carta(this.getClass().getResource("/assets/Cartas/lazarillo8.jpg"));
        Carta carta9 = new Carta(this.getClass().getResource("/assets/Cartas/lazarillo9.jpg"));
        Carta carta10 = new Carta(this.getClass().getResource("/assets/Cartas/lazarillo10.jpg"));
        Carta carta11 = new Carta(this.getClass().getResource("/assets/Cartas/lazarillo11.jpg"));
        Carta carta12 = new Carta(this.getClass().getResource("/assets/Cartas/lazarillo12.jpg"));
        Carta reverso = new Carta(this.getClass().getResource("/assets/Cartas/reverso.jpg"));
        ArrayListCartas.add(carta1);
        ArrayListCartas.add(carta2);
        ArrayListCartas.add(carta3);
        ArrayListCartas.add(carta4);
        ArrayListCartas.add(carta5);
        ArrayListCartas.add(carta6);
        ArrayListCartas.add(carta7);
        ArrayListCartas.add(carta8);
        ArrayListCartas.add(carta9);
        ArrayListCartas.add(carta10);
        ArrayListCartas.add(carta11);
        ArrayListCartas.add(carta12);
        ArrayListCartas.add(reverso);
    }

}
