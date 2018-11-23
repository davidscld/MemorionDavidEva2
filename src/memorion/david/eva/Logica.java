/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorion.david.eva;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author dvdsa
 */
public class Logica {

    private Vista vista;
    private VistaMenuPrincipal vistaMenuPrincipal;
    private VistaMenuDificultad vistaMenuDificultad;
    private VistaJuegoCartas vistaJuegoCartas;
    private VistaRankingJugadores vistaRankingJugadores;
    private Partida partida, partidaGuardada;
    private ArrayList<Carta> ArrayListCartasPar = new ArrayList<>();
    private ArrayList<Carta> ArrayListCartasImpar = new ArrayList<>();
    private static ArrayList<Jugador> ArrayListJugador = new ArrayList<>();
    private static ArrayList<Partida> ArrayPartidasGuardadas = new ArrayList<>();
    private ImageIcon imagenCartaAnverso;
    private ImageIcon imagenCartaCarga;
    private boolean existe = false;
    private int posicion = 0, pulsaciones = 0, contador = 0, tiempoUsado;
    private String nombreGanador = "****";
    private Timer volteo, tiempo;

    /**
     * Logica() Cuando creamos la logica en el main se ejecuta directamente el
     * constructor. El constructor lo primero que va a hacer es llamar a los
     * metodos de creacion de cartas. Luego va a crear la clase
     * VistaMenuPrincipal y la clase vista en la que vamos a pasarle como
     * parametro siempre una vista y la logica.
     */
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

    /**
     * Los metodos de abris alguna vista van a tener lineas del codigo muy
     * parecidas en las que llamamos a un metodo de la vista llamado crearPanel
     * y le vamos a mandar la vista que acabemnos de crear;
     */
    /**
     * abrirVistaPrincipal() Envia a la vista la VistaMenuPrincipal que ya fue
     * creada en el constructor de la logica(Clase en la que nos encontramos
     * actualmente).
     */
    public void abrirVistaPrincipal() {
        this.partida = null;
        vista.crearPanel(vistaMenuPrincipal);
        vista.setSize(700, 925);
    }

    /**
     * abrirVistaMenuDificultad() creamos la vistaMenuDificuldad y se la
     * enviamos a el metodo crearPanel() que se encuentra en la vista y le damos
     * un tamaño a la vista.
     */
    public void abrirVistaMenuDificultad() {
        this.partida = null;
        vistaMenuDificultad = new VistaMenuDificultad(this);
        vista.crearPanel(vistaMenuDificultad);
        vista.setSize(700, 925);
    }

    /**
     * abrirVistaRankingJugadores() creamos la vistaRankingJugadores y se la
     * enviamos a el metodo crearPanel() que se encuentra en la vista y le damos
     * un tamaño a la vista.
     */
    public void abrirVistaRankingJugadores() {
        this.partida = null;
        vistaRankingJugadores = new VistaRankingJugadores(this);
        vista.crearPanel(vistaRankingJugadores);
        vista.setSize(700, 925);
    }

    /**
     * abrirPartidaNueva() creamos una partida nueva y se la enviamos a
     * vistaJuegoCartas al crearla.Creamos la vistaJuegoCartas enviandole una
     * partida y se la enviamos a el metodo crearPanel() que se encuentra en la
     * vista y le damos un tamaño a la vista que sera que se maximice toda la
     * pantalla.
     */
    public void abrirPartidaNueva(String dificultad) {
        this.partida = null;
        this.pulsaciones = 0;
        this.partida = new Partida(dificultad, this);
        vistaJuegoCartas = new VistaJuegoCartas(partida);
        vista.crearPanel(vistaJuegoCartas);
        vista.setExtendedState(JFrame.MAXIMIZED_BOTH); //Maximiza la pantalla 
    }

    /**
     * abrirPartidaEmpezada(Partida partida) cuando llamamos a este metodo le
     * enviamos ya una partida para saber cual es la que partida guardada que
     * queremos abrir y creamos la vistaJuegoCartas enviandole la
     * partidaGuardada para que la muetre y podamos seguir jugandoe esa partida
     */
    private void abrirPartidaEmpezada(Partida partida) {
        this.partida = null;
        this.partidaGuardada = null;
        this.partidaGuardada = partida;
        vistaJuegoCartas = new VistaJuegoCartas(this.partidaGuardada);
        System.out.println("Numero de cartas " + this.partidaGuardada.getCantidadCartas());
        vista.crearPanel(vistaJuegoCartas);
        vista.setExtendedState(JFrame.MAXIMIZED_BOTH); //Maximiza la pantalla 

    }

    /**
     * abrirVistaPartidasGuardadas() creamos la VistaPartidasGuardadas y se la
     * enviamos a el metodo crearPanel() que se encuentra en la vista y le damos
     * un tamaño a la vista.
     */
    public void abrirVistaPartidasGuardadas() {
        this.partida = null;
        VistaPartidasGuardadas vistaPartidasGuardadas = new VistaPartidasGuardadas(this);
        vista.crearPanel(vistaPartidasGuardadas);
        vista.setSize(700, 925);

    }

    /**
     * abrirAcerdaDe() Metodo que nos abre una ventana intermitente en la que
     * indica las personas de creacion de programa
     */
    public void abrirAcerdaDe() {
        JOptionPane.showMessageDialog(null, "Creado por David Sanchez y Eva Chico");
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

    /**
     * crearArrayListDeCartasImpar() Metodo al que llamamos desde el constructor
     * de logica y nos crea la primera tanda de cartas y las guarda en un
     * arrayList. Porque el juego empareza dos cartas iguales tenemos que tener
     * dos cartas de cada tipo.
     */
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

    /**
     * crearArrayListDeCartasImpar() Metodo al que llamamos desde el constructor
     * de logica y nos crea la segunda tanda de cartas y las guarda en un
     * arrayList.
     */
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
//////////////////////////METODOS CARTAS////////////////////////////////////

    public void voltearCarta(Carta carta) {
        contador = 0;
        tiempoUsado = 500;
        tiempo = new Timer(tiempoUsado, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (contador == 0) {
                    imagenCartaCarga = new ImageIcon(this.getClass().getResource("/assets/carga.gif"));
                    carta.setIcon(imagenCartaCarga);
                    contador++;
                } else {
                    
                    carta.setLevantada(true);
                    imagenCartaAnverso = new ImageIcon(carta.getRutaAnverso());
                    carta.setIcon(imagenCartaAnverso);
                    
                    tiempo.stop();
                }
            }
        });
        tiempo.start();
        tiempo.setRepeats(true);
    }

    /**
     * comprobarParejas(Carta primeraPulsada, Carta segundaPulsada) Metodo que
     * se llama desde el controladosJuegoCartas y se le envian dos cartas para
     * ver si estas son pareja o no. Si son pareja Cambia el estado de
     * emparejadas a true, las deja del derecho y llama al metodo que comprueba
     * si estan todas emparejadas y termina el juego Si no estan emparejadas
     * Cambia el estado de si la carta esta levantada a falso y llama al metodo
     * volverAlReverso enviandole las dos cartas para que las de la vuelta.
     */
    public boolean comprobarParejas(Carta primeraPulsada, Carta segundaPulsada) {

        if (primeraPulsada.getRutaAnverso().equals(segundaPulsada.getRutaAnverso())) { //Si son pareja
            System.out.println("PAREJA EMPAREJADA");
            primeraPulsada.setEmparejada(true);
            segundaPulsada.setEmparejada(true);
            comprobarSiTodasEmparejadas();
            return true;
        } else {//Si no son pareja
            primeraPulsada.setLevantada(false);
            segundaPulsada.setLevantada(false);
            voltearAlReves(primeraPulsada, segundaPulsada);
            return false;
        }
    }

    /**
     * comprobarSiTodasEmparejadas() Lo primero que hace es comprobar si es una
     * partida nueva o una partida que ya teniamos guardada. Si todas estan
     * emparejadas llama al metodo guardarGanador.
     */
    public void comprobarSiTodasEmparejadas() {

        boolean todasEmparejadas = true;

        if (this.partida != null) {//En el caso de que este acabando una partida que acabe de empezar
            for (Carta it : this.partida.getCartasSeleccionadas()) {
                if (!it.isEmparejada()) {
                    todasEmparejadas = false;
                }
            }
            if (todasEmparejadas) {
                guardarGanador();
            }
        } else {//En el caso de que este acabando una partida que haya cargado que estuviera guardada
            for (Carta it : this.partidaGuardada.getCartasSeleccionadas()) {
                if (!it.isEmparejada()) {
                    todasEmparejadas = false;
                }
            }
            if (todasEmparejadas) {
                guardarGanador();
            }
        }

    }

    /**
     * barajar() Desordena el array de cartas pares, rocorre los arrays de
     * cartas y llama al metodo ponerReverso para que ponga a todas las cartas
     * el reverso.
     */
    public void barajar() {
        Collections.shuffle(ArrayListCartasPar);
        for (Carta it : ArrayListCartasPar) {
            it.ponerRerverso();
        }
        for (Carta it : ArrayListCartasImpar) {
            it.ponerRerverso();
        }

    }

    /**
     * voltearAlReves(Carta primeraPulsada, Carta segundaPulsada) Metodo que se
     * llama desde comprobarParejas cuando se ha comprobado que las dos cartas
     * que se han levantado no son pareja. Es un timer que dura 2 segundos y lo
     * que hace es llamar al metodo ponerReverso para que vuelva a dar la vuelta
     * a las dos cartas que se nos ha enviado desde donde se le ha llamado.
     */
    private void voltearAlReves(Carta primeraPulsada, Carta segundaPulsada) {

        this.volteo = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                primeraPulsada.ponerRerverso();
                segundaPulsada.ponerRerverso();
                volteo.stop();

            }

        });
        volteo.start();
        volteo.setRepeats(true);
    }

///////////////////METODOS RELACIONADOS A LAS PARTIDAS///////////////////////////////////
    /**
     * contadorPulsaciones() Es un contador que se le llama desde la clase
     * ContadosJuegoCartas() cuando vamos pulsando las cartas. El sontados suma
     * 1 y comprueba si es una partida nueva o una partida guardada y se lo
     * manda a el setNumero de movimientos que esta en la clase partida
     */
    public void contadorPulsaciones() {//NECESITAMOS RESETEARLAS Y TAMBIEN GUARDARLAS EN LA CLASE PARTIDA
        this.pulsaciones++;
        if (partida == null) {
            partidaGuardada.setNumeroDeMovimientos(pulsaciones);
        } else {
            partida.setNumeroDeMovimientos(pulsaciones);
        }

    }

    /**
     * guardarPartida() Tenemos que comprobar si la partida que gusardamos es
     * una nueva o una partida que ya estaba guardada. Si es una partida nueva
     * tengo que comprobar si la habia guardado antes o no para saber si tengo
     * que borrar alguna partida del arrylist de partidas guardada y cual es la
     * posicion del array que tengo que borrar. Si es una partida guardadas
     * tambien tengo que comprobar donde se encuentra la partida para borrarla y
     * luego añadir la que guardo actualmente
     */
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
                this.partida.setPartidaGuardada(true);
                ArrayPartidasGuardadas.add(this.partida);

            } else {
                ArrayPartidasGuardadas.remove(posicion);
                ArrayPartidasGuardadas.add(this.partida);
            }
        } else {
            for (int i = 0; i < ArrayPartidasGuardadas.size(); i++) {
                if (ArrayPartidasGuardadas.get(i).equals(this.partida)) {
                    posicion = i;

                }
            }
            ArrayPartidasGuardadas.remove(posicion);
            ArrayPartidasGuardadas.add(this.partidaGuardada);

        }

    }

    /**
     * cargarPartidaGuardada(String nombrePartida) Se le llama desde el
     * ControladorPartidasGuardadas y le mando un String con el nombre de la
     * partida que quiro seguir jugando. Recorro el array de partidasGuardadas
     * hasta que la encuentro y llamo al metodo abrirPartidaEmpezada enviandole
     * la partida que quiero abrir.
     */
    public void cargarPartidaGuardada(String nombrePartida) {
        Partida partidaEscogida = null;
        for (Partida it : ArrayPartidasGuardadas) {
            System.out.println(it.getNombrePartida() + " : " + nombrePartida);
            if (it.getNombrePartida().equals(nombrePartida)) {
                partidaEscogida = it;
            }
        }
        System.out.println(partidaEscogida.getNombrePartida());

        abrirPartidaEmpezada(partidaEscogida);
    }

    public void guardarGanador() {
        this.nombreGanador = JOptionPane.showInputDialog("Escribe tu nombre");//Recojo el nombre del ganador con un JOptioPanel

        if (this.partidaGuardada != null) {//En el caso de que haya acabado un partida que anteriormente hubiera guardado
            Jugador jugador = new Jugador(this.nombreGanador, this.partidaGuardada.getNumeroDeMovimientos(), this.partidaGuardada.getTiempoTotalUsado());
            ArrayListJugador.add(jugador);

        } else {//En el caso de que haya acabado una partida que acabe de empezar
            Jugador jugador = new Jugador(this.nombreGanador, this.partida.getNumeroDeMovimientos(), this.partida.getTiempoTotalUsado());
            ArrayListJugador.add(jugador);

        }
        abrirVistaRankingJugadores();

    }

    public void ordenarArrayListGanadores() {

    }

    /**
     * resetearEstadisticas() Metodo que resetea el juego entero.
     */
    public void resetearEstadisticas() {

        ArrayPartidasGuardadas.clear();
        ArrayListJugador.clear();
    }
//////////////////////////////METODOS NO AGRUPABLES///////////////

    public void huevoDePascua() {

    }

}
