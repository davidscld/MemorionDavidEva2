/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorion.david.eva;

import java.util.Comparator;

/**
 *
 * @author dvdsa
 */
public class Jugador {

    private String nombre;
    private int numeroMovimientos, tiempoUsado;
    /**
     * Jugador(String nombre, int numeroMovimientos, int tiempoUsado)
     * Constructor de  jugador que lo llama desde la logica cuando ha acabado
     * una partida. Nos mandan el string del nombre el numero de movimientos 
     * y el tiempo usado
     */
    public Jugador(String nombre, int numeroMovimientos, int tiempoUsado) {
        this.nombre = nombre;
        this.numeroMovimientos = numeroMovimientos;
        this.tiempoUsado = tiempoUsado;

    }

    public String getNombre() {
        return nombre;
    }

    public int getNumeroMovimientos() {
        return numeroMovimientos;
    }

    public int getTiempoUsado() {
        return tiempoUsado;
    }



}
