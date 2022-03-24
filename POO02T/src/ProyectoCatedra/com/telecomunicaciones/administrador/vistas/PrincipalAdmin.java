package ProyectoCatedra.com.telecomunicaciones.administrador.vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class PrincipalAdmin extends JFrame {

    private JButton btnGestionarDepartamentos;
    private JPanel panel1;
    private JButton btnGestionarJefes;
    private JButton btnGestionarProgramadores;
    private JButton btnGestUsuarios;
    private JButton btnGestCasos;

    public PrincipalAdmin(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel1);
        this.setMinimumSize(new Dimension(800,700));
        this.setLocationRelativeTo(getParent());
        btnGestionarDepartamentos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JFrame frame = new GestionDepartamentos("Gestionar Departamentos");
                frame.setVisible(true);
                PrincipalAdmin.super.dispose();
            }
        });
        btnGestionarProgramadores.addKeyListener(new KeyAdapter() {
        });
        btnGestionarProgramadores.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Frame frame = null;
                try {
                    frame = new GestionProgramadores("Gestionamiento Programadores");

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                frame.setVisible(true);
                PrincipalAdmin.super.dispose();
            }
        });
        btnGestCasos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JFrame frame = new GestionCasos("Gestionar Casos");
                frame.setVisible(true);
                PrincipalAdmin.super.dispose();
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public static void main(String[] args) {
        JFrame frame = new PrincipalAdmin("Vista Principal Administrador");
        frame.setVisible(true);
    }
}
