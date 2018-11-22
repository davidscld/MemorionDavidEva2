/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorion.david.eva;

import java.awt.event.KeyEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

/**
 *
 * @author dvdsa
 */
public class MenuSuperior extends JMenuBar {

    private ControladorBotonesMenuSuperior controladorMenuSuperior;
    private Logica logica;
    /**
     * MenuSuperior(Logica logica)
     * Constructor que se ejecuta cuando se crea la clase MenuSuperior en la 
     * clase vista. Lo que hace es añadir un menu superior con unas opciones.
     */
    public MenuSuperior(Logica logica) {
        this.logica = logica;
        crearMenu();
    }
    /**
     * crearMenu()
     * Lo primero creamos el controladorBotonesMenuSuperior
     * Se definen los JMenuItem del menu que seran las opciones qeu se mostraran
     * Luego añadimos los escuchadores a los JMenuItem
     * Despues le asignamos aceleraciones a las opciones de menu que deseemos
     * Finalmente añadimos las opciones al JMenuBar que es la barra superior. Se 
     * lo añadimos directamente a la clase porque esta extiende de un JMenuBsr
     */
    public void crearMenu() {
        controladorMenuSuperior = new ControladorBotonesMenuSuperior(this.logica);
        //Definimos las opciones del menu
        JMenuItem inicio = new JMenuItem("Home");
        JMenuItem nuevaPartida = new JMenuItem("Play");
        JMenuItem cargarPartida = new JMenuItem("Load game");
        JMenuItem guardarPartida = new JMenuItem("Save game");
        JMenuItem acercaDe = new JMenuItem ("About");
        inicio.setHorizontalTextPosition(SwingConstants.CENTER);
        inicio.invalidate();

        //Añadimos escuchadores a los MEnuItem
        inicio.addActionListener(controladorMenuSuperior);
        nuevaPartida.addActionListener(controladorMenuSuperior);
        cargarPartida.addActionListener(controladorMenuSuperior);
        guardarPartida.addActionListener(controladorMenuSuperior);
        acercaDe.addActionListener(controladorMenuSuperior);
        
        //Asignamos aceleradores de teclado
        KeyStroke atajoInicio = KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK);
        inicio.setAccelerator(atajoInicio);
        KeyStroke atajoNuevaPartida = KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_DOWN_MASK);
        nuevaPartida.setAccelerator(atajoNuevaPartida);
        KeyStroke atajoAcercaDe = KeyStroke.getKeyStroke(KeyEvent.VK_H, KeyEvent.CTRL_DOWN_MASK);
        acercaDe.setAccelerator(atajoAcercaDe);
        //añadimos los menus a el menuBar
        this.add(inicio);
        this.add(nuevaPartida);
        this.add(cargarPartida);
        this.add(guardarPartida);
        this.add(acercaDe);
    }
}
