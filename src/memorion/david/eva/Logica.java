/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorion.david.eva;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author dvdsa
 */
public class Logica {

    private Vista vista;
    private VistaMenuPrincipal vistaMenuPrincipal;
    private VistaMenuDificultad vistaMenuDificultad;

    private static ArrayList<Carta> ArrayListCartasPar = new ArrayList<>();

    private static ArrayList<Carta> ArrayListCartasImpar = new ArrayList<>();

    private static ArrayList<Jugador> ArrayListJugador = new ArrayList<>();
    private ArrayList<Partida> ArrayPartidasGuardadas = new ArrayList<>();

    private ImageIcon imagenCartaAnverso;

    public Logica() {
        crearArrayListDeCartasPar();
        crearArrayListDeCartasImpar();
        vistaMenuPrincipal = new VistaMenuPrincipal(this);
        vista = new Vista(vistaMenuPrincipal, this);
        vista.setVisible(true);
        vista.setSize(700, 925);

    }
//////////////////////////////////////ABRIR VENTANAS/////////////////////////////////

    public void abrirVistaPrincipal() {
        vista.crearPanel(vistaMenuPrincipal);
        vista.setSize(700, 925);
    }

    public void abrirVistaMenuDificultad() {
        vistaMenuDificultad = new VistaMenuDificultad(this);
        vista.crearPanel(vistaMenuDificultad);
        vista.setSize(700, 925);
    }

    public void abrirVistaRankingJugadores() {
        VistaRankingJugadores vistaRankingJugadores = new VistaRankingJugadores(this);
        vista.crearPanel(vistaRankingJugadores);
        vista.setSize(700, 925);
    }

    public void abrirPartidaNueva(String dificultad) {

        Partida partida = new Partida(dificultad, this);
        VistaJuegoCartas vistaJuegoCartas = new VistaJuegoCartas(partida);
        vista.crearPanel(vistaJuegoCartas);
        vista.setExtendedState(JFrame.MAXIMIZED_BOTH); //Maximiza la pantalla 
    }

    public void abrirPartidaEmpezada(VistaJuegoCartas vistaJuegoCartas) {
        vista.crearPanel(vistaJuegoCartas);
        vista.setExtendedState(JFrame.MAXIMIZED_BOTH); //Maximiza la pantalla 
    }

    public void abrirVistaPartidasGuardadas() {
        VistaPartidasGuardadas vistaPartidasGuardadas = new VistaPartidasGuardadas(this);
        vista.crearPanel(vistaPartidasGuardadas);
        vista.setSize(700, 925);
    }
//////////////////////////////////////CARGAR ARRAYLIST////////////////////////////////////////////////////////

    public ArrayList<Carta> getArrayListCartasPar() {
        return ArrayListCartasPar;
    }

    public ArrayList<Jugador> getArrayListJugador() {
        return ArrayListJugador;
    }

    public ArrayList<Carta> getArrayListCartasImpar() {
        return ArrayListCartasImpar;
    }

    public void crearArrayListDeCartasImpar() {

        Carta carta1 = new Carta(this.getClass().getResource("/assets/lazarillo1.jpg"), this);
        Carta carta2 = new Carta(this.getClass().getResource("/assets/lazarillo2.jpg"), this);
        Carta carta3 = new Carta(this.getClass().getResource("/assets/lazarillo3.jpg"), this);
        Carta carta4 = new Carta(this.getClass().getResource("/assets/lazarillo4.jpg"), this);
        Carta carta5 = new Carta(this.getClass().getResource("/assets/lazarillo5.jpg"), this);
        Carta carta6 = new Carta(this.getClass().getResource("/assets/lazarillo6.jpg"), this);
        Carta carta7 = new Carta(this.getClass().getResource("/assets/lazarillo7.jpg"), this);
        Carta carta8 = new Carta(this.getClass().getResource("/assets/lazarillo8.jpg"), this);
        Carta carta9 = new Carta(this.getClass().getResource("/assets/lazarillo9.jpg"), this);
        Carta carta10 = new Carta(this.getClass().getResource("/assets/lazarillo10.jpg"), this);
        Carta carta11 = new Carta(this.getClass().getResource("/assets/lazarillo11.jpg"), this);
        Carta carta12 = new Carta(this.getClass().getResource("/assets/lazarillo12.jpg"), this);
        Carta carta13 = new Carta(this.getClass().getResource("/assets/lazarillo13.jpg"), this);
        Carta carta14 = new Carta(this.getClass().getResource("/assets/lazarillo14.jpg"), this);
        Carta carta15 = new Carta(this.getClass().getResource("/assets/lazarillo15.jpg"), this);
        Carta carta16 = new Carta(this.getClass().getResource("/assets/lazarillo16.jpg"), this);
        ArrayListCartasImpar.add(carta1);
        ArrayListCartasImpar.add(carta2);
        ArrayListCartasImpar.add(carta3);
        ArrayListCartasImpar.add(carta4);
        ArrayListCartasImpar.add(carta5);
        ArrayListCartasImpar.add(carta6);
        ArrayListCartasImpar.add(carta7);
        ArrayListCartasImpar.add(carta8);
        ArrayListCartasImpar.add(carta9);
        ArrayListCartasImpar.add(carta10);
        ArrayListCartasImpar.add(carta11);
        ArrayListCartasImpar.add(carta12);
        ArrayListCartasImpar.add(carta13);
        ArrayListCartasImpar.add(carta14);
        ArrayListCartasImpar.add(carta15);
        ArrayListCartasImpar.add(carta16);

    }

    public void crearArrayListDeCartasPar() {

        Carta carta1 = new Carta(this.getClass().getResource("/assets/lazarillo1.jpg"), this);
        Carta carta2 = new Carta(this.getClass().getResource("/assets/lazarillo2.jpg"), this);
        Carta carta3 = new Carta(this.getClass().getResource("/assets/lazarillo3.jpg"), this);
        Carta carta4 = new Carta(this.getClass().getResource("/assets/lazarillo4.jpg"), this);
        Carta carta5 = new Carta(this.getClass().getResource("/assets/lazarillo5.jpg"), this);
        Carta carta6 = new Carta(this.getClass().getResource("/assets/lazarillo6.jpg"), this);
        Carta carta7 = new Carta(this.getClass().getResource("/assets/lazarillo7.jpg"), this);
        Carta carta8 = new Carta(this.getClass().getResource("/assets/lazarillo8.jpg"), this);
        Carta carta9 = new Carta(this.getClass().getResource("/assets/lazarillo9.jpg"), this);
        Carta carta10 = new Carta(this.getClass().getResource("/assets/lazarillo10.jpg"), this);
        Carta carta11 = new Carta(this.getClass().getResource("/assets/lazarillo11.jpg"), this);
        Carta carta12 = new Carta(this.getClass().getResource("/assets/lazarillo12.jpg"), this);
        Carta carta13 = new Carta(this.getClass().getResource("/assets/lazarillo13.jpg"), this);
        Carta carta14 = new Carta(this.getClass().getResource("/assets/lazarillo14.jpg"), this);
        Carta carta15 = new Carta(this.getClass().getResource("/assets/lazarillo15.jpg"), this);
        Carta carta16 = new Carta(this.getClass().getResource("/assets/lazarillo16.jpg"), this);
        ArrayListCartasPar.add(carta1);
        ArrayListCartasPar.add(carta2);
        ArrayListCartasPar.add(carta3);
        ArrayListCartasPar.add(carta4);
        ArrayListCartasPar.add(carta5);
        ArrayListCartasPar.add(carta6);
        ArrayListCartasPar.add(carta7);
        ArrayListCartasPar.add(carta8);
        ArrayListCartasPar.add(carta9);
        ArrayListCartasPar.add(carta10);
        ArrayListCartasPar.add(carta11);
        ArrayListCartasPar.add(carta12);
        ArrayListCartasPar.add(carta13);
        ArrayListCartasPar.add(carta14);
        ArrayListCartasPar.add(carta15);
        ArrayListCartasPar.add(carta16);

    }
//////////////////////////METODOS CARTAS////////////////////////////////////7

    public void voltearCarta(Carta carta) {
        imagenCartaAnverso = new ImageIcon(carta.getRutaAnverso());
        carta.setIcon(imagenCartaAnverso);
    }

    public void barajar() {
        Collections.shuffle(ArrayListCartasPar);
        for (Carta it : ArrayListCartasPar) {
            it.ponerRerverso();
        }
        for (Carta it : ArrayListCartasImpar) {
            it.ponerRerverso();
        }

    }

    ///////////////////
    public void guardarPartida(Partida partida) {
        ArrayPartidasGuardadas.add(partida);
    }

    public void cargarPartidaGuardada() {
        
        //abrirPartidaEmpezada(vistaJuegoCartas);
    }
}
