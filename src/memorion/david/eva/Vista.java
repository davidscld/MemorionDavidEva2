/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorion.david.eva;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author dvdsa
 * 
 * Esta clase extiende de un Jframe
 */
public class Vista extends JFrame {

    private MenuSuperior menuSuperior;
    private JPanel panel;
    private Logica logica;
    
    /**
     * Constructor que se ejecuta en el constructor de la logica cuando se crea
     * la clase vista y se le envia un Jpanel y una logica.
     * Guardamos el panel y la logica y llamamos a los metodos  de 
     * configuracionMenuSuperios y ConfiguracionCierreAplicacion.
     */
    
    public Vista(JPanel panel1,Logica logica) {
        this.setSize(700, 925);
        this.panel=panel1;
        this.add(panel);
        this.logica=logica;
        
        configuracionMenuSuperior();
        configurarCierreAplicacion();
    }
    
    /**
     * crearPanel(JPanel panel1)
     * Este metodo se llama en la logica cuando se crea alguna vista y nos 
     * manda la vista  a este metodo que son Jpanel.
     * Elimino el panel que tenia guardado anteriormente y le asigno el nuevo
     * panel que me han enviado se lo añado al jFrame y lo repinto para que me 
     * lo muestre.
     */
    public void crearPanel(JPanel panel1){
        this.remove(panel);
        this.panel=panel1;
        this.add(panel);
        this.repaint();
    }

    /**
     * Creo la clase menuSuperior, le envio la logica y añado ese menu que he 
     * creado al jFrame;
     */
    private void configuracionMenuSuperior() {
        menuSuperior = new MenuSuperior(this.logica);
    
        this.setJMenuBar(menuSuperior);
    }
    /**
     * configurarCierreAplicacion()
     * Metodo que cierra la aplicacion y llama a el metodo opcion.
     */
    private void configurarCierreAplicacion() {
             this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
          
            public void windowClosing(WindowEvent evt) {
                opcion();
            }
        });

    }
    
    /**
     * opcion()
     * Cuando damos a cerrar la aplicacion nos saldra un cuadro de dialogo
     * para confirmar el cierre de esa aplicacion.
     */
    private void opcion(){
       if (JOptionPane.showConfirmDialog(rootPane, "¿Desea salir?",
                "Salir del sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            System.exit(0);
    }


}
