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

    public Partida(String dificultad, Logica logica) {
        n++;
        numeroDePartida = n;
        this.logica = logica;
        this.setOpaque(false);
        this.dificultad = dificultad;
        this.nombrePartida = "Partida " + numeroDePartida;
        this.setLayout(null);
        
        
        calcularDistribucion();
        crearPanelContadores();
        crearPanelDeCartas();
        configurarPanel();
        crearContadorTiempo();

    }

    private void crearPanelDeCartas() {
      panelDeCartas = new JPanel(new GridLayout(this.numeroCartasAncho, this.numeroCartasLargo,5,5));
      panelDeCartas.setOpaque(false);
      panelDeCartas.setBounds(70, 70, 850, 800);
      this.add(panelDeCartas);
    }
    private void crearPanelContadores(){
        Font f = new Font("Cambria",Font.ITALIC,30);

        panelDeContadores = new JPanel(new GridLayout(0,2));
        JLpulsaciones = new JLabel("Touches: "+numeroDeMovimientos);
        JLpulsaciones.setFont(f);
        JLpulsaciones.setForeground(Color.WHITE);
        JLcontador = new JLabel("Minutes: "+minutos+ " Seconds: "+segundos);
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
    

    public JLabel JLabeltiempo() {
        crearContadorTiempo();
        JLcontador.setBounds(700, 50, 40, 70);
        return JLcontador;
    }

    public void crearContadorTiempo() {
        System.out.println("Enta en el metodo crear contador tiempo");
        this.tiempo = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (segundos == 59) {
                    minutos++;
                    segundos = 0;
                } else {
                    segundos++;
                }
                JLcontador.setText("Minutes: "+minutos+ " Seconds: "+segundos);
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
        JLpulsaciones.setText("Touches: "+numeroDeMovimientos);
        JLpulsaciones.repaint();
        
    }

    public int getTiempoTotalUsado() {
        this.tiempoTotalUsado = this.minutos * 60 + this.segundos;
        return tiempoTotalUsado;
    }

}
