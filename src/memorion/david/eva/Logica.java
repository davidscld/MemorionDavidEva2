/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorion.david.eva;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ImageIcon;

/**
 *
 * @author dvdsa
 */
public class Logica {

    private Vista vista;

    private static ArrayList<Carta> ArrayListCartas = new ArrayList<>();
    private static ArrayList<Jugador> ArrayListJugador = new ArrayList<>();
    private ImageIcon imagenCartaAnverso;

    public Logica(Vista vista) {
        this.vista = vista;
    }

    public void abrirVistaMenuDificultad() {

        vista.removeAll();
        VistaMenuDificultad vistaMenuDificultad = new VistaMenuDificultad(this);
        vista.add(vistaMenuDificultad);
    

        //vista.crearPanel(vistaMenuDificultad);
    }

    public void abrirFrameRankingJugadores() {
        VistaRankingJugadores vistaRankingJugadores = new VistaRankingJugadores(this);
        vistaRankingJugadores.setVisible(true);
    }

    public void abrirPartida(String dificultad) {

        Partida partida = new Partida(dificultad, this);
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
        Carta carta13 = new Carta(this.getClass().getResource("/assets/lazarillo13.jpg"));
        Carta carta14 = new Carta(this.getClass().getResource("/assets/lazarillo14.jpg"));
        Carta carta15 = new Carta(this.getClass().getResource("/assets/lazarillo15.jpg"));
        Carta carta16 = new Carta(this.getClass().getResource("/assets/lazarillo16.jpg"));

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
        ArrayListCartas.add(carta13);
        ArrayListCartas.add(carta14);
        ArrayListCartas.add(carta15);
        ArrayListCartas.add(carta16);

    }

    public void voltearCarta(Carta carta) {
        imagenCartaAnverso = new ImageIcon(carta.getRutaAnverso());
        carta.setIcon(imagenCartaAnverso);
    }

    public void Barajar() {
        Collections.shuffle(ArrayListCartas);
        for (Carta it : ArrayListCartas) {
            it.ponerRerverso();
        }
    }
}
