package ProyectoCatedra.Interfaces;
import javax.swing.*;
import java.awt.*;

public class BienvenidaProgramador extends JFrame{
    private JTextArea txtBienvenido;
    private JButton btnSolicitudes;
    private JButton btnSolicitudesObservacion;
    private JButton btnSolicitudFinalizada;
    private JButton btnVerCasos;
    private JButton btnRegresar;
    private JPanel pnlProgramador;

    public BienvenidaProgramador(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlProgramador);
        this.setMinimumSize(new Dimension(600, 500));
        this.setLocationRelativeTo(getParent());
    }


    public static void main (String [] args) {
        JFrame frame = new BienvenidaProgramador("Programador");
        frame.setVisible(true);
    }
}
