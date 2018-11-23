/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorion.david.eva;

import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author dvdsa
 */
public class Carta extends JLabel {

    private URL rutaAnverso, rutaReverso;
    private ImageIcon imagenCarta;
    private int id;
    private static int n = 0;
    private boolean emparejada, levantada;
    private ControladorJuegoCartas controladorJuegoCartas;
    private Logica logica;
    /**
     * Constructor carta que se crea en la logica cuando creamos el arrayList
     * de cartas y nos envia una ruta y la logica.
     * Tiene un id autonumerico para saber que carta es. Y ponemos emparejadas 
     * y levantada a false porque cuando creamos las cartas todas estan dada la
     * vuelta. Luego guardamos la logica y llamamos a l metodo asignarControlador
     */
    public Carta(URL rutaAnverso,Logica logica) {
        n++;
        id = n;
        this.rutaAnverso = rutaAnverso;
        this.emparejada = false;
        this.levantada = false;
        this.logica=logica;
        asignarControlador();
    }

    public void setEmparejada(boolean emparejada) {
        this.emparejada = emparejada;
    }

    public boolean isEmparejada() {
        return emparejada;
    }

    public int getId() {
        return id;
    }

    public boolean isLevantada() {
        return levantada;
    }

    public void setLevantada(boolean levantada) {
        this.levantada = levantada;
    }

    public URL getRutaAnverso() {
        return rutaAnverso;
    }
    /**
     * asignarControlador()
     * Creamos el controladosJuegoCartas y le envio la logica que hemos guardado
     * en el constructor y le ponemos el escuchador.
     */
    private void asignarControlador() {
        controladorJuegoCartas = new ControladorJuegoCartas(logica);
        this.addMouseListener(controladorJuegoCartas);

    }
    /**
     * ponerRerverso(
     * Meto que pone el reverso a todas las cartas 
     */
    public void ponerRerverso() {
        this.rutaReverso = getClass().getResource("/assets/reverso.jpg");
        imagenCarta = new ImageIcon(rutaReverso);
        this.setIcon(imagenCarta);
    }

}
