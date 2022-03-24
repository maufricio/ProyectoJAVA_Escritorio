package ProyectoCatedra.com.telecomunicaciones.administrador.vistas;

import ProyectoCatedra.com.telecomunicaciones.administrador.Administrador;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GestionCasos extends JFrame {
    private JTable tblCasos;
    private JButton regresarButton;
    private JPanel mainPanel;

    Administrador administrador = new Administrador();
    DefaultTableModel modelo = null;

    public GestionCasos(String title){
        super(title);
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800, 700);
        this.setLocationRelativeTo(getParent());
        this.setVisible(true);

        modelo = administrador.selectCasos();
        tblCasos.setModel(modelo);
        regresarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Regresar();
            }
        });
    }

    public void Regresar(){
        JFrame jFrame = new PrincipalAdmin("Vista Principal Administrador");
        jFrame.setVisible(true);
        GestionCasos.super.dispose();
    }
}
