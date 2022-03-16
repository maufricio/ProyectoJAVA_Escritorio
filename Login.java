package ProyectoCatedra.Interfaces;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame{
    private JPanel pnlLogin;
    private JTextField txtUsuario;
    private JPasswordField passContrasena;
    private JButton btnIngresar;
    private JButton btnRegistrar;

    public Login(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlLogin);
        this.setMinimumSize(new Dimension(600, 500));
        this.setLocationRelativeTo(getParent());
    }

    public static void main(String[] args) {
        JFrame frame;
        frame = new Login("Ingreso de Datos");
        frame.setVisible(true);
    }
}
