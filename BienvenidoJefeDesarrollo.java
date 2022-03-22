package ProyectoCatedra.Interfaces;
import javax.swing.*;
import java.awt.*;

public class BienvenidoJefeDesarrollo  extends JFrame{
    private JButton btnSolicitudesPendientes;
    private JButton btnSolicitudes;
    private JButton btnVerCasos;
    private JButton btnRegresar;
    private JTextArea txtBienvenido;
    private JPanel pnlDesarrollo;
    private static final String title = "Jefatura";

    public BienvenidoJefeDesarrollo(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlDesarrollo);
        this.setMinimumSize(new Dimension(600, 500));
        this.setLocationRelativeTo(getParent());
    }


    public static void main (String [] args) {
        JFrame frame = new BienvenidoJefeDesarrollo("Jefatura");
        frame.setVisible(true);
    }
}
