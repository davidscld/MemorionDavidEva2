/*
Esta clase ha de recibir el ArrayList que se encuentre en la clase logica del tipo Jugador.
Se crearan siempre dos columnas y habra tantas filas como tamaño tenga el ArrayList.
Recorreremos nuestro ArrayList y a medida , iremos introduciendo el JLabel el nombre y numero de movimientos
Cada JLabel se añadira al Panel que haya dentro de esta clase
 */
package memorion.david.eva;

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
 */
public class VistaRankingJugadores extends JPanel {

    private Logica logica;

    private JPanel panelCentral;
    private JLabel nombre, numeroDeMovimientos;
    private URL url = getClass().getResource("/assets/fondoPartidasJugadas.jpg");
    private Image imagenFondo = new ImageIcon(url).getImage();
    public VistaRankingJugadores(Logica logica) {
        this.logica = logica;
        configurarVentana();
        crearListado();
        
    }

    private void configurarVentana() {
        this.setSize(720, 905);

        this.setLayout(null);
        crearPanelCentral();

    }
        public void paint(Graphics g) {
        g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
        this.setOpaque(false);
        super.paint(g);
    }

    private void crearListado() {

        if (logica.getArrayListJugador().isEmpty()) {
            System.out.println("VACIO");
        } else {
            
            //RECOJO Y ASIGNO LA CANTIDAD DE FILAS QUE HABRA, SABIENDO EL NUMERO DE JUGADORES QUE HAN GANADO
            int numeroDeFilas = logica.getArrayListJugador().size();
            panelCentral.setLayout(new GridLayout(numeroDeFilas, 1));

            //RECORRO EL ARRAYLIST Y A MEDIDA VOY SACANDO NOMBRE Y N.MOVIMIENTOS DEL JUGADOR Y LOS MUESTRO.
            for (Jugador it : logica.getArrayListJugador()) {
                nombre = new JLabel(it.getNombre());
                panelCentral.add(nombre);
                numeroDeMovimientos = new JLabel("" + it.getNumeroMovimientos());
                panelCentral.add(numeroDeMovimientos);
            }
        }

    }

    private void crearPanelCentral() {
        panelCentral = new JPanel();//Hay que asignarle su gridLayout
        panelCentral.setBounds(50, 5, 500, 700);
        panelCentral.setOpaque(false);
        this.add(panelCentral);
    }
}
