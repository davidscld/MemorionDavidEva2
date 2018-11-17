/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorion.david.eva;

import java.awt.Color;
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
    private Partida partida, partidaGuardada;
    private ArrayList<Carta> ArrayListCartasPar = new ArrayList<>();
    private ArrayList<Carta> ArrayListCartasImpar = new ArrayList<>();
    private static ArrayList<Jugador> ArrayListJugador = new ArrayList<>();
    private static ArrayList<Partida> ArrayPartidasGuardadas = new ArrayList<>();
    private ImageIcon imagenCartaAnverso;
    private boolean existe = false;
    private int posicion = 0, pulsaciones = 0;

    public Logica() {
        crearArrayListDeCartasImpar();
        crearArrayListDeCartasPar();
        vistaMenuPrincipal = new VistaMenuPrincipal(this);
        vista = new Vista(vistaMenuPrincipal, this);
        vista.setVisible(true);
        vista.setSize(700, 925);
        this.partida = null;

    }
//////////////////////////////////////ABRIR VENTANAS/////////////////////////////////

    public void abrirVistaPrincipal() {
        this.partida = null;
        vista.crearPanel(vistaMenuPrincipal);
        vista.setSize(700, 925);
    }

    public void abrirVistaMenuDificultad() {
        this.partida = null;
        vistaMenuDificultad = new VistaMenuDificultad(this);
        vista.crearPanel(vistaMenuDificultad);
        vista.setSize(700, 925);
    }

    public void abrirVistaRankingJugadores() {
        this.partida = null;
        VistaRankingJugadores vistaRankingJugadores = new VistaRankingJugadores(this);
        vista.crearPanel(vistaRankingJugadores);
        vista.setSize(700, 925);
    }

    public void abrirPartidaNueva(String dificultad) {
        this.partida = null;
        this.pulsaciones = 0;
        this.partida = new Partida(dificultad, this);
        VistaJuegoCartas vistaJuegoCartas = new VistaJuegoCartas(partida);
        vista.crearPanel(vistaJuegoCartas);
        vista.setExtendedState(JFrame.MAXIMIZED_BOTH); //Maximiza la pantalla 
    }

    private void abrirPartidaEmpezada(Partida partida) {
        this.partida = null;
        this.partidaGuardada = partida;
        VistaJuegoCartas vistaJuegoCartas = new VistaJuegoCartas(partida);
        System.out.println("Numero de cartas " + partida.getCantidadCartas());
        partida.setBackground(Color.yellow);
        vista.crearPanel(vistaJuegoCartas);
        vista.setExtendedState(JFrame.MAXIMIZED_BOTH); //Maximiza la pantalla 
        this.partidaGuardada = null;
    }

    public void abrirVistaPartidasGuardadas() {
        this.partida = null;
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

    private void crearArrayListDeCartasImpar() {

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

    private void crearArrayListDeCartasPar() {

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

    public ArrayList<Partida> getArrayPartidasGuardadas() {
        return ArrayPartidasGuardadas;
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

    ///////////////////METODOS RELACIONADOS A LAS PARTIDAS///////////////////////////////////7
    public Partida getPartida() {
        return partida;
    }

    public void contadorPulsaciones() {
        this.pulsaciones++;
    }

    public void guardarPartida() {
        existe = false;
        if (!(this.partida == null)) {

            if (!ArrayPartidasGuardadas.isEmpty()) {
                for (int i = 0; i < ArrayPartidasGuardadas.size(); i++) {
                    if (ArrayPartidasGuardadas.get(i).equals(this.partida)) {
                        posicion = i;
                        existe = true;
                    }
                }
            }            //NO SOBREESCRIBE LAS PARTIDAS SI LAS GUARDAMOS VARIAS VECES

            if (!existe) {
                this.partida.setNumeroDeMovimientos(this.pulsaciones);
                ArrayPartidasGuardadas.add(this.partida);

            }
        }

    }

    public void cargarPartidaGuardada(String nombrePartida) {
        Partida partidaEscogida = null;
        for (Partida it : ArrayPartidasGuardadas) {
            if (it.getNombrePartida().equals(nombrePartida)) {
                partidaEscogida = it;
            }
        }

        abrirPartidaEmpezada(partidaEscogida);
    }

    public void eliminarPartidaGuardada() {
        existe = false;
        if (!ArrayPartidasGuardadas.isEmpty()) {
            for (int i = 0; i < ArrayPartidasGuardadas.size(); i++) {
                if (ArrayPartidasGuardadas.get(i).equals(this.partida)) {
                    posicion = i;
                    existe = true;
                }
            }
        }
        if (existe) {
            ArrayPartidasGuardadas.remove(posicion);
        }
    }

    public void guardarGanador() {
        if (this.partidaGuardada != null) {//En el caso de que haya acabado un partida que anteriormente hubiera guardado
            Jugador jugador = new Jugador("nombre", this.partidaGuardada.getNumeroDeMovimientos(), this.partidaGuardada.getTiempoTotalUsado());
            ArrayListJugador.add(jugador);
        } else {//En el caso de que haya acabado una partida que acabe de empezar
            Jugador jugador = new Jugador("nombre", this.partida.getNumeroDeMovimientos(), this.partida.getTiempoTotalUsado());
            ArrayListJugador.add(jugador);

        }

    }
}
