package ProyectoCatedra.Interfaces;
import ProyectoCatedra.Conexion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BienvenidoJefatura extends JFrame{
    private JButton btnverCasos;
    private JButton btnAgregarCaso;
    private JTextArea txtBienvenido;
    private JButton btnSalir;
    private JPanel pnlJefatura;
    private static final String title = "Jefatura";


    public BienvenidoJefatura(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlJefatura);
        this.setMinimumSize(new Dimension(600, 500));
        this.setLocationRelativeTo(getParent());
    }

    public static void main (String [] args) {
        JFrame frame = new BienvenidoJefatura("Jefatura");
        frame.setVisible(true);
    }
}