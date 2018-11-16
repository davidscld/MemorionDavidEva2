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
    private VistaMenuPrincipal vistaMenuPrincipal;
    private VistaMenuDificultad vistaMenuDificultad;

    private static ArrayList<Carta> ArrayListCartas = new ArrayList<>();
    private static ArrayList<Jugador> ArrayListJugador = new ArrayList<>();
    private ImageIcon imagenCartaAnverso;

    public Logica() {
        crearArrayListDeCartas();
        vistaMenuPrincipal=new VistaMenuPrincipal(this);
        vista=new Vista(vistaMenuPrincipal);
        vista.setVisible(true);
        
    }
    
    public void abrirVistaPrincipal(){
        vista.crearPanel(vistaMenuPrincipal);
    }

    public void abrirVistaMenuDificultad() {
        vistaMenuDificultad = new VistaMenuDificultad(this);
        vista.crearPanel(vistaMenuDificultad);
    }

    public void abrirFrameRankingJugadores() {
        VistaRankingJugadores vistaRankingJugadores = new VistaRankingJugadores(this);
        vista.crearPanel(vistaRankingJugadores);
    }

    public void abrirPartida(String dificultad) {

        Partida partida = new Partida(dificultad, this);
        VistaJuegoCartas vistaJuegoCartas = new VistaJuegoCartas(partida);
        vista.crearPanel(vistaJuegoCartas);
    }

    public ArrayList<Carta> getArrayListCartas() {
        return ArrayListCartas;
    }

    public ArrayList<Jugador> getArrayListJugador() {
        return ArrayListJugador;
    }

    public void crearArrayListDeCartas() {
        System.out.println("rrr");
        Carta carta1 = new Carta(this.getClass().getResource("/assets/lazarillo1.jpg"),this);
        Carta carta2 = new Carta(this.getClass().getResource("/assets/lazarillo2.jpg"),this);
        Carta carta3 = new Carta(this.getClass().getResource("/assets/lazarillo3.jpg"),this);
        Carta carta4 = new Carta(this.getClass().getResource("/assets/lazarillo4.jpg"),this);
        Carta carta5 = new Carta(this.getClass().getResource("/assets/lazarillo5.jpg"),this);
        Carta carta6 = new Carta(this.getClass().getResource("/assets/lazarillo6.jpg"),this);
        Carta carta7 = new Carta(this.getClass().getResource("/assets/lazarillo7.jpg"),this);
        Carta carta8 = new Carta(this.getClass().getResource("/assets/lazarillo8.jpg"),this);
        Carta carta9 = new Carta(this.getClass().getResource("/assets/lazarillo9.jpg"),this);
        Carta carta10 = new Carta(this.getClass().getResource("/assets/lazarillo10.jpg"),this);
        Carta carta11 = new Carta(this.getClass().getResource("/assets/lazarillo11.jpg"),this);
        Carta carta12 = new Carta(this.getClass().getResource("/assets/lazarillo12.jpg"),this);
        Carta carta13 = new Carta(this.getClass().getResource("/assets/lazarillo13.jpg"),this);
        Carta carta14 = new Carta(this.getClass().getResource("/assets/lazarillo14.jpg"),this);
        Carta carta15 = new Carta(this.getClass().getResource("/assets/lazarillo15.jpg"),this);
        Carta carta16 = new Carta(this.getClass().getResource("/assets/lazarillo16.jpg"),this);
        System.out.println("sss");
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

    public void barajar() {
        System.out.println("aaa");
        Collections.shuffle(ArrayListCartas);
        System.out.println("bbb");
        for (Carta it : ArrayListCartas) {
            it.ponerRerverso();
        }
    }
}
