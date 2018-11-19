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
 */
public class VistaRankingJugadores extends JPanel {

    private Logica logica;

    private JPanel panelCentral;
    private JLabel JLnombre, JLnumeroDeMovimientos;
    private URL url = getClass().getResource("/assets/fondoPartidasJugadas.jpg");
    private Image imagenFondo = new ImageIcon(url).getImage();
    private Font f = new Font("Cambria", Font.ITALIC, 30);

    public VistaRankingJugadores(Logica logica) {
        this.logica = logica;
        configurarVentana();
        crearListado();

    }

    private void configurarVentana() {
        this.setSize(720, 905);
        this.setLayout(null);

    }

    public void paint(Graphics g) {
        g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
        this.setOpaque(false);
        super.paint(g);
    }

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

    private void crearPanelCentral(int numeroDeFilas) {
        panelCentral = new JPanel(new GridLayout(numeroDeFilas, 0, 5, 5));//Hay que asignarle su gridLayout
        panelCentral.setBounds(250, 10, 250, 50);
        panelCentral.setOpaque(false);
        this.add(panelCentral);

    }
}
