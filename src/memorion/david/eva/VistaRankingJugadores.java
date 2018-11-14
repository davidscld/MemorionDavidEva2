/*
Esta clase ha de recibir el ArrayList que se encuentre en la clase logica del tipo Jugador.
Se crearan siempre dos columnas y habra tantas filas como tamaño tenga el ArrayList.
Recorreremos nuestro ArrayList y a medida , iremos introduciendo el JLabel el nombre y numero de movimientos
Cada JLabel se añadira al Panel que haya dentro de esta clase
 */
package memorion.david.eva;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author dvdsa
 */
public class VistaRankingJugadores extends JFrame {

    private MenuSuperior menuSuperior;
    private Logica logica;
    private JPanel panelCentral;
    private JLabel nombre, numeroDeMovimientos;

    public VistaRankingJugadores() {
        configurarVentana();
        crearListado();
        configuracionMenuSuperior();
        crearListado();
    }

    private void configurarVentana() {
        this.setSize(720, 905);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        crearPanelCentral();

    }

    private void configuracionMenuSuperior() {
        menuSuperior = new MenuSuperior();
        this.setJMenuBar(menuSuperior);
    }

    private void crearListado() {
        logica = new Logica();
        //RECOJO Y ASIGNO LA CANTIDAD DE FILAS QUE HABRA, SABIENDO EL NUMERO DE JUGADORES QUE HAN GANADO
        int numeroDeFilas = logica.getArrayListJugador().size();
        panelCentral.setLayout(new GridLayout(numeroDeFilas, 1));
        
        //RECORRO EL ARRAYLIST Y A MEDIDA VOY SACANDO NOMBRE Y N.MOVIMIENTOS DEL JUGADOR Y LOS MUESTRO.
        for (Jugador it : logica.getArrayListJugador()) {
            nombre = new JLabel(it.getNombre());
            this.add(nombre);
            numeroDeMovimientos = new JLabel("" + it.getNumeroMovimientos());
            this.add(numeroDeMovimientos);
        }

    }

    private void crearPanelCentral() {
        panelCentral = new JPanel();//Hay que asignarle su gridLayout
        panelCentral.setBounds(50, 50, 500, 700);
        this.add(panelCentral);
    }
}
