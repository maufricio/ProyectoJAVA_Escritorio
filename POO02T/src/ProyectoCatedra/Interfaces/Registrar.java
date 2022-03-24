package ProyectoCatedra.Interfaces;

import javax.swing.*;
import java.awt.*;

public class Registrar extends JFrame{
    private JTextField txtNombres;
    private JTextField txtApellidos;
    private JButton btnLogin;
    private JButton btnRegistrar;
    private JPasswordField passContrasena;
    private JPasswordField passContrasena2;
    private JTextField txtTelefono;
    private JTextField txtFechaNa;
    private JComboBox cbxEmpleado;
    private JPanel PanelPrincipal;

    public Registrar(String registrar_usuarios) {
        super(registrar_usuarios);
        this.setContentPane(PanelPrincipal);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(600, 500);
        this.setVisible(true);
    }
}


