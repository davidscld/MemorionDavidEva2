/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorion.david.eva;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author dvdsa
 */
public class VistaJugadorGanado extends JFrame {
    private ControladorBotonesVistas controladorBotonesVistas;
    private ImageIcon IMGimagenFondo;
    private JLabel JLfondo;
    private JButton JBenviar;
    private JTextField JTnombre;

    public VistaJugadorGanado() {
        configurarVentana();
        crearElementos();

    }

    private void configurarVentana() {
        this.setSize(720, 905);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        IMGimagenFondo = new ImageIcon(this.getClass().getResource("/assets/Fondo/portadaLazarillo.jpg"));
        JLfondo = new JLabel();
        JLfondo.setIcon(IMGimagenFondo);
        JLfondo.setBounds(0, -30, 700, 910);
        this.add(JLfondo);
    }

    private void crearElementos() {
        JTnombre = new JTextField();
        JTnombre.setBounds(150, 300, 400, 40);
        this.add(JTnombre);
        JBenviar = new JButton("Submit");
        JBenviar.setBounds(250, 400, 200, 50);
        controladorBotonesVistas = new ControladorBotonesVistas();
        JBenviar.addActionListener(controladorBotonesVistas);
        this.add(JBenviar);
        //Cuando pulse necesito recoger de la partida el numero de pulsaciones y el tiempo, juntarlo con el nombre que recojo y crear objeto de la clase jugador
    }
}
