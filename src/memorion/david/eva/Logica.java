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

    private static ArrayList<Carta> ArrayListCartas = new ArrayList<>();
    private static ArrayList<Jugador> ArrayListJugador = new ArrayList<>();
    
    public void abrirVistaMenuDificultad() {
        VistaMenuDificultad vistaMenuDificultad = new VistaMenuDificultad();
        vistaMenuDificultad.setVisible(true);
    }

    public void abrirFrameRankingJugadores() {
        VistaRankingJugadores vistaRankingJugadores = new VistaRankingJugadores();
        vistaRankingJugadores.setVisible(true);
    }
    
    public void abrirPartida(String dificultad){
        System.out.println("entre jaja");
        Partida partida = new Partida(dificultad);
        VistaJuegoCartas vistaJuegoCartas = new VistaJuegoCartas(partida);
        vistaJuegoCartas.setVisible(true);
    }

    public ArrayList<Carta> getArrayListCartas() {
        return ArrayListCartas;
    }
    
    public ArrayList<Jugador> getArrayListJugador() {
        return ArrayListJugador;
    }
    

    public void crearArrayListDeCartas() {
        Carta carta1 = new Carta(this.getClass().getResource("/assets/lazarillo1.jpg"));
        Carta carta2 = new Carta(this.getClass().getResource("/assets/lazarillo2.jpg"));
        Carta carta3 = new Carta(this.getClass().getResource("/assets/lazarillo3.jpg"));
        Carta carta4 = new Carta(this.getClass().getResource("/assets/lazarillo4.jpg"));
        Carta carta5 = new Carta(this.getClass().getResource("/assets/lazarillo5.jpg"));
        Carta carta6 = new Carta(this.getClass().getResource("/assets/lazarillo6.jpg"));
        Carta carta7 = new Carta(this.getClass().getResource("/assets/lazarillo7.jpg"));
        Carta carta8 = new Carta(this.getClass().getResource("/assets/lazarillo8.jpg"));
        Carta carta9 = new Carta(this.getClass().getResource("/assets/lazarillo9.jpg"));
        Carta carta10 = new Carta(this.getClass().getResource("/assets/lazarillo10.jpg"));
        Carta carta11 = new Carta(this.getClass().getResource("/assets/lazarillo11.jpg"));
        Carta carta12 = new Carta(this.getClass().getResource("/assets/lazarillo12.jpg"));
        Carta reverso = new Carta(this.getClass().getResource("/assets/reverso.png"));
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
