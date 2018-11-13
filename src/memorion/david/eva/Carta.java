/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorion.david.eva;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author dvdsa
 */
public class Carta extends JLabel {

    private String ruta;
    private ImageIcon imagenCarta;
    private int largo, ancho, n = 0;
    private static int id;
    private boolean emparejada;

    public Carta(String ruta) {
        this.ruta = ruta;
        this.largo = 80;
        this.ancho = 60;
        this.emparejada = false;
        crearCarta();

    }

    public void setEmparejada(boolean emparejada) {
        this.emparejada = emparejada;
    }

    public boolean isEmparejada() {
        return emparejada;
    }

    public static int getId() {
        return id;
    }

    private void crearCarta() {
        this.setSize(largo, ancho);
        imagenCarta = new ImageIcon(this.getClass().getResource(this.ruta));
        this.setIcon(imagenCarta);
    }

}
