package ProyectoCatedra.com.telecomunicaciones.administrador.vistas;

import ProyectoCatedra.beans.ProgramadoresUpdates;
import ProyectoCatedra.com.telecomunicaciones.administrador.Administrador;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class GestionProgramadores extends JFrame{
    private JPanel panel1;
    private JButton btnRegresarPrincipal;
    private JTable tblProgramadores;
    private JTextField txtIdProgramador;
    private JTextField txtCategoriaUsuario;
    private JTextField txtUsername;
    private JButton btnLimpiar;
    private JButton btnEditar;
    private JTextField txtIdDep;
    private JPasswordField pswProgramador;

    DefaultTableModel modelo = null;
    Administrador administrador = new Administrador();
    ProgramadoresUpdates programadoresUpdates;

    public GestionProgramadores(String title) throws SQLException {
        super.setTitle(title);
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(800,700));
        this.setVisible(true);
        this.setLocationRelativeTo(getParent());
        btnRegresarPrincipal.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JFrame frame = new PrincipalAdmin("Vista Principal Administrador");
                frame.setVisible(true);
                GestionProgramadores.super.dispose();
            }
        });
        modelo = administrador.selectUsuarioProgramadores();
        tblProgramadores.setModel(modelo);

        tblProgramadores.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                tblObtenerDatosJefesFunc(e);
            }
        });
        btnEditar.addKeyListener(new KeyAdapter() {
        });
        btnEditar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    updateProgramadoresData();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnLimpiar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                limpiarCampos();
            }
        });
    }

    public void tblObtenerDatosJefesFunc(MouseEvent e){
        int fila = tblProgramadores.rowAtPoint(e.getPoint());
        int columna = tblProgramadores.columnAtPoint(e.getPoint());
        if((fila > -1) && (columna > -1)){
            txtIdProgramador.setText(modelo.getValueAt(fila, 0).toString());
            txtIdDep.setText(modelo.getValueAt(fila, 1).toString());
            txtCategoriaUsuario.setText(modelo.getValueAt(fila, 2).toString());
            txtUsername.setText(modelo.getValueAt(fila, 3).toString());
            pswProgramador.setText(modelo.getValueAt(fila, 4).toString());
        }
    }
    public void updateProgramadoresData() throws SQLException {
        int id_usuario;
        int id_departamento;
        int tipoUsuario;
        String username;
        String password;

        id_usuario = Integer.parseInt(txtIdProgramador.getText());
        id_departamento = Integer.parseInt(txtIdDep.getText());
        tipoUsuario = Integer.parseInt(txtCategoriaUsuario.getText());
        username = txtUsername.getText();
        password = pswProgramador.getPassword().toString();

        programadoresUpdates = new ProgramadoresUpdates(id_usuario, id_departamento, tipoUsuario, username, password);
        administrador.updateUsuarios(programadoresUpdates);
        JOptionPane.showMessageDialog(null, "Programador actualizado");

        modelo = administrador.selectUsuarioProgramadores();
        tblProgramadores.setModel(modelo);

        limpiarCampos();
    }

    public void limpiarCampos(){
        txtIdProgramador.setText("");
        txtIdDep.setText("");
        txtCategoriaUsuario.setText("");
        txtUsername.setText("");
        pswProgramador.setText("");
    }
}