/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorion.david.eva;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author dvdsa
 * 
 * Clase que extiende de Jpanel
 */
public class Partida extends JPanel {

    /*
    
    SIEMPRE QUE GUARDEMOS O ACABEMOS UNA PARTIDA ESTA TIENE QUE GUARDAR SU TIEMPO Y SU NUMERO DE PULSACIONES.
    
    
    
     */
    private String dificultad, nombrePartida;
    private ArrayList<Carta> cartasSeleccionadas = new ArrayList<>();
    private int numeroCartasAncho, numeroCartasLargo, numeroDePartida, numeroDeMovimientos;
    private JPanel panelDeCartas, panelDeContadores;
    private JLabel JLcontador = new JLabel("");
    private JLabel JLpulsaciones;
    private static int n = 0;
    private Logica logica;
    private int minutos = 0, segundos = 0, tiempoTotalUsado = 0;
    private Timer tiempo;
    private boolean partidaGuardada = false;
    private int cantidadCartas;
    private ControladorHuevoPascua controladorHuevoPascua;
    
    /**
     *  Partida(String dificultad, Logica logica)
     * Constructor que se ejecuta cuando se crea la partida en la clase logica 
     * y te envia Un string con la dificultad que ha ekegido y la logica.
     * La partida tiene un identificador llamado numeroDePartida que es autonumerico
     * guarda la logica que le hemos enviado, pone el fondo en opaco, guarga la 
     * dificultad que se le ha enviado. La partida tambien tiene un nombre que
     * ira tanbien con el numerodePartida. Ponemos el Layaout a null. 
     * El constructor llama a los metodos calcularDistribucion(), 
     * crearContadorTiempo(), crearPanelContadores(), crearPanelDeCartas(), 
     * configurarPanel() y configurarHuevoPascua().
     */
    public Partida(String dificultad, Logica logica) {
        n++;
        numeroDePartida = n;
        this.logica = logica;
        this.setOpaque(false);
        this.dificultad = dificultad;
        this.nombrePartida = "Partida " + numeroDePartida;
        this.setLayout(null);

        calcularDistribucion();
        crearContadorTiempo();
        crearPanelContadores();
        crearPanelDeCartas();
        configurarPanel();
        configurarHuevoPascua();
    }
    
    /**
     * pararTiempo()
     * Metodo que para el timer del tiempo y se llama cuando todas las cartas
     * estan emparejadas
     */
    public void pararTiempo() {
        tiempo.stop();
    }

    /**
     * crearPanelDeCartas()
     * Crea un panel para meter las cartas en el que se le dira el numero de 
     * cartasAnco y el numero de cartasLargo. Ponemos el panel opaco, le damos 
     * un tamaño a ese panel y se lo añadimos a la clase ya que esta es tambien un 
     * JPanel
     */
    private void crearPanelDeCartas() {
        panelDeCartas = new JPanel(new GridLayout(this.numeroCartasAncho, this.numeroCartasLargo, 5, 5));
        panelDeCartas.setOpaque(false);
        panelDeCartas.setBounds(70, 70, 850, 800);
        this.add(panelDeCartas);
    }
    
    /**
     * crearPanelContadores()
     * Lo primero de damos un formato para la letra de los JLabel.
     * Creamos un JPanel de contadores en el que le vamos a añarid el contador
     * de las pulsaciones que realiza sobre las cartas y el tiempo que lleva 
     * jugando.
     * Creamos un JPanel para el contador de las pulsaciones y otro para los 
     * minutos y segundos que lleva jugando. Estos JLabel se los añadimos al
     * JpanelDeContadores y este Jpanel a la clase que tambien es un JPanel.
     * A el JPanel de contadores le damos un tamalo  y una posicion.
     */
    private void crearPanelContadores() {
        Font f = new Font("Cambria", Font.ITALIC, 30);

        panelDeContadores = new JPanel(new GridLayout(0, 2));
        JLpulsaciones = new JLabel("Touches: " + numeroDeMovimientos);
        JLpulsaciones.setFont(f);
        JLpulsaciones.setForeground(Color.WHITE);
        JLcontador = new JLabel("Minutes: " + minutos + " Seconds: " + segundos);
        JLcontador.setFont(f);
        JLcontador.setForeground(Color.WHITE);
        panelDeContadores.setOpaque(false);
        panelDeContadores.add(JLpulsaciones);
        panelDeContadores.add(JLcontador);
        panelDeContadores.setBounds(70, 10, 600, 50);
        this.add(panelDeContadores);
    }

    public String getDificultad() {
        return dificultad;
    }

    public ArrayList<Carta> getCartasSeleccionadas() {
        return cartasSeleccionadas;
    }

    public boolean isPartidaGuardada() {
        return partidaGuardada;
    }

    public void setPartidaGuardada(boolean partidaGuardada) {
        this.partidaGuardada = partidaGuardada;
    }
    /**
     * calcularDistribucion()
     * La distribucion la calculamos segun la dificultad que se haya elegido
     * que la tenemos guardada en un String llamado dificultad que se ha pasado 
     * en el constructor por parametro.
     * Dependiendo de la dificultad el juego tendra un numero de cartas y 
     * un tamaño para que entren todas las cartas.
     * 
     */
    private void calcularDistribucion() {

        if (this.dificultad.equals("Low")) {
            this.numeroCartasAncho = 3;
            this.numeroCartasLargo = 2;
            cantidadCartas = 6;
            this.setBounds(450, 50, 900, 900);

        } else if (this.dificultad.equals("Medium")) {
            this.numeroCartasAncho = 2;
            this.numeroCartasLargo = 5;
            this.setBounds(450, 50, 900, 900);
            cantidadCartas = 10;
        } else {
            this.numeroCartasAncho = 4;
            this.numeroCartasLargo = 4;
            this.setBounds(450, 50, 1000, 1000);
            cantidadCartas = 16;
        }
    }

    public int getCantidadCartas() {
        return cantidadCartas;
    }
    /**
     * configurarPanel()
     * Tenemos un for que recorre el numero de veces que cartas queramos coger
     * y las va añadiendo a el ArrayList de CartasSeleccionadas.Cuando coge una 
     * carta del earray de cartasPar la guarda en una variable carta para luego 
     * buscarla con un for en el array de cartasImpar y tener asi su pareja.
     * cuando ya ha guardado todas las cartas en el arrayList lo desordena para 
     * que no salgan seguidas.
     * Despues recorre el arrayList de las cartas que se han selecionado y las 
     * va añadiendo al panelDeCartas.
     */
    private void configurarPanel() {

        for (int i = 0; i < ((numeroCartasAncho * numeroCartasLargo) / 2); i++) {

            cartasSeleccionadas.add(logica.getArrayListCartasPar().get(i));
            Carta carta = logica.getArrayListCartasPar().get(i);
            for (int j = 0; j < logica.getArrayListCartasImpar().size(); j++) {
                if (carta.getRutaAnverso().equals(logica.getArrayListCartasImpar().get(j).getRutaAnverso())) {
                    cartasSeleccionadas.add(logica.getArrayListCartasImpar().get(j));

                }
            }
        }

        Collections.shuffle(cartasSeleccionadas);
        for (Carta it : cartasSeleccionadas) {
            panelDeCartas.add(it);
        }

    }

    public String getNombrePartida() {
        return nombrePartida;
    }
    /**
     * JLabeltiempo()
     * Es un metodo que retorna un JLabel en el que se guardara el tiempo.
     * llame al metodo CrearContadorTiempo que tiene un timer, da tamaño al JLabel
     * y lo retorna.
     */
    public JLabel JLabeltiempo() {
        crearContadorTiempo();
        JLcontador.setBounds(700, 50, 40, 70);
        return JLcontador;
    }
    /**
     * crearContadorTiempo()
     * Metod que contiene un timer que se va ejecurtando cada segundo sumando un
     * segundo y si son 59 segundos suma un minuto y pone los segundos a 00.
     * cada verz que sume un segundo cambiamos el tento del JLcontador para 
     * que nos vaya cambiando el tiempo en el programa y para mostrarlo lo 
     * repintamos.
     */
    public void crearContadorTiempo() {
        this.tiempo = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (segundos == 59) {
                    minutos++;
                    segundos = 0;
                } else {
                    segundos++;
                }
                JLcontador.setText("Minutes: " + minutos + " Seconds: " + segundos);
                JLcontador.repaint();
            }

        });
        tiempo.start();
        tiempo.setRepeats(true);

    }

    public int getNumeroDeMovimientos() {
        return numeroDeMovimientos;
    }

    public void setNumeroDeMovimientos(int numeroDeMovimientos) {
        this.numeroDeMovimientos = numeroDeMovimientos;
        JLpulsaciones.setText("Touches: " + numeroDeMovimientos);
        JLpulsaciones.repaint();

    }

    public int getTiempoTotalUsado() {
        this.tiempoTotalUsado = this.minutos * 60 + this.segundos;
        return tiempoTotalUsado;
    }
    /**
     * configurarHuevoPascua()
     * Crea un controlador para el huvo de pascua y hace el acelerador para que
     * vala a ese controlador.
     */
    private void configurarHuevoPascua() {
        controladorHuevoPascua = new ControladorHuevoPascua(logica);
        JLpulsaciones.addMouseListener(controladorHuevoPascua);
    }

}
