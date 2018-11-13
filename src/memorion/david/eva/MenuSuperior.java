/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorion.david.eva;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author dvdsa
 */
public class MenuSuperior extends JMenuBar{
    
    private ControladorBotonesMenuSuperior controladorMenuSuperior;

    
    public MenuSuperior() {
        crearMenu();
    }
    
    public void crearMenu(){
        controladorMenuSuperior=new ControladorBotonesMenuSuperior();
        //Definimos las opciones del menu
        JMenuItem nuevaPartida=new JMenuItem("Play");
        JMenuItem cargarPartida=new JMenuItem("Load game");
        JMenuItem guardarPartida=new JMenuItem("Save game");

        // se define una barra de menú
        JMenuBar menuBar=new JMenuBar();
        
        //Añadimos escuchadores a los MEnuItem
        nuevaPartida.addActionListener(controladorMenuSuperior);
        cargarPartida.addActionListener(controladorMenuSuperior);
        guardarPartida.addActionListener(controladorMenuSuperior);
        
        //añadimos los menus a el menuBar
        this.add(nuevaPartida);
        this.add(cargarPartida);
        this.add(guardarPartida);   
    }
}
