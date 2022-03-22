package ProyectoCatedra.Interfaces;
import javax.swing.*;
import java.awt.*;

public class BienvenidaProbador extends JFrame{
    private JTextArea txtBienvenido;
    private JButton btnSolicitudesaProbar;
    private JButton btnSolicitudesFinalizadas;
    private JButton btnVerCasos;
    private JButton btnRegresar;
    private JPanel pnlProbador;


    public BienvenidaProbador(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlProbador);
        this.setMinimumSize(new Dimension(600, 500));
        this.setLocationRelativeTo(getParent());
    }


    public static void main (String [] args) {
        JFrame frame = new BienvenidaProbador("Probador");
        frame.setVisible(true);
    }

}
