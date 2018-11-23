/*
Esta clase ha de recibir el ArrayList que se encuentre en la clase logica del tipo Jugador.
Se crearan siempre dos columnas y habra tantas filas como tamaño tenga el ArrayList.
Recorreremos nuestro ArrayList y a medida , iremos introduciendo el JLabel el nombre y numero de movimientos
Cada JLabel se añadira al Panel que haya dentro de esta clase
 */
package memorion.david.eva;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author dvdsa
 * 
 * clase que extiende de JPanel
 */
public class VistaRankingJugadores extends JPanel {

    private Logica logica;

    private JPanel panelCentral;
    private JLabel JLnombre, JLnumeroDeMovimientos;
    private URL url = getClass().getResource("/assets/fondoPartidasJugadas.jpg");
    private Image imagenFondo = new ImageIcon(url).getImage();
    private Font f = new Font("Cambria", Font.ITALIC, 30);
    /**
     * VistaRankingJugadores(Logica logica)
     * Constructor que se ejecuta en la logica cuando creamos la clase 
     * VistaRankingJugador y nos envia la logica.
     * Este constructor llama a los metodos configurarVentana() y crearListado()
     */
    public VistaRankingJugadores(Logica logica) {
        this.logica = logica;
        configurarVentana();
        crearListado();

    }
    /**
     * configurarVentana()
     * Metodo que da un tamaño al Jpanel de la clase y pone el layout a null
     */
    private void configurarVentana() {
        this.setSize(720, 905);
        this.setLayout(null);

    }
    /**
     * paint(Graphics g)
     * Metodo que se utiliza para poner la imagen de fondo dandole un tamaño
     */
    public void paint(Graphics g) {
        g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
        this.setOpaque(false);
        super.paint(g);
    }
    
    /**
     * crearListado()
     * Compruebo si no esta vacio el array de jugador. Si no esta vacio
     * recojo y asigno la cantidad de filas que habra, sabiendo el numero de 
     * jugadores que han jugado.
     * Luego se recorre el araryList y a medida se va sacando el nombre y numero
     * de movimientos del juegador y los voy mostrnado.
     */
    private void crearListado() {

        if (!logica.getArrayListJugador().isEmpty()) {
            //RECOJO Y ASIGNO LA CANTIDAD DE FILAS QUE HABRA, SABIENDO EL NUMERO DE JUGADORES QUE HAN GANADO
            int numeroDeFilas = logica.getArrayListJugador().size();
            crearPanelCentral(numeroDeFilas);
           
           
            
            //RECORRO EL ARRAYLIST Y A MEDIDA VOY SACANDO NOMBRE Y N.MOVIMIENTOS DEL JUGADOR Y LOS MUESTRO.
            for (Jugador it : logica.getArrayListJugador()) {
                JLnombre = new JLabel(it.getNombre());
                JLnombre.setFont(f);
                panelCentral.add(JLnombre);
                JLnumeroDeMovimientos = new JLabel("" + it.getNumeroMovimientos());
                JLnumeroDeMovimientos.setFont(f);
                panelCentral.add(JLnumeroDeMovimientos);
            }
        }

    }
    /**
     * crearPanelCentral(int numeroDeFilas)
     * Metodo que añade un Jpanel central en el que le doy un tamaño y las 
     * coordenadas donde debe ir situado este panel que es el que va a llevar
     * los JLabel de los jugadores que hay y se le añado a la clase ya que
     * es un JPanel.
     */
    private void crearPanelCentral(int numeroDeFilas) {
        panelCentral = new JPanel(new GridLayout(numeroDeFilas, 0, 5, 5));//Hay que asignarle su gridLayout
        panelCentral.setBounds(250, 10, 250, 50);
        panelCentral.setOpaque(false);
        this.add(panelCentral);

    }
}
