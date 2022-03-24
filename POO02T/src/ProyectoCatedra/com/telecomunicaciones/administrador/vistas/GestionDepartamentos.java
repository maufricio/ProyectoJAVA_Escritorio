package ProyectoCatedra.com.telecomunicaciones.administrador.vistas;

import ProyectoCatedra.beans.*;
import ProyectoCatedra.com.telecomunicaciones.administrador.Administrador;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class GestionDepartamentos extends JFrame {

    private JPanel panelPrincipal;
    private JButton btnRegresarAdmin;
    private JTextField txtnombredep;
    private JTextField txtTelContact;
    private JTextField txtJefeFunc;
    private JTextField txtJefeDesa;
    private JTextField txtIdDepartamento;
    private JTable table1;
    private JButton btnInsertarDep;
    private JButton btnLimpiar;
    private JButton btnDelete;
    private JTable jefesDepFunc;
    private JTable jefesDepDesa;

    DefaultTableModel modelo = null;
    DefaultTableModel modelo1 = null;
    DefaultTableModel modelo2 = null;
    Administrador administrador = new Administrador();
    Departamentos departamentos = null;
    DepartamentosUpdate departamentosUpdate = null;

    public GestionDepartamentos(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelPrincipal);
        this.setMinimumSize(new Dimension(800,700));
        this.setLocationRelativeTo(getParent());

        modelo = administrador.selectDepartamentos();
        table1.setModel(modelo);

        modelo1 = administrador.selectJefesFuncionales();
        jefesDepFunc.setModel(modelo1);

        modelo2 = administrador.selectJefesDesarrollo();
        jefesDepDesa.setModel(modelo2);


        btnRegresarAdmin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JFrame frame = new PrincipalAdmin("Gestionar Departamentos");
                frame.setVisible(true);
                GestionDepartamentos.super.dispose();
            }
        });
        btnInsertarDep.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    guardarDatos();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnLimpiar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                btnLimpiar();
            }
        });
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                tblObtenerDatos(e);
            }
        });
        btnDelete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    eliminarDatos();
                }catch (SQLException ex){
                    ex.printStackTrace();
                }

            }
        });
        jefesDepFunc.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                tblObtenerDatosJefesFunc(e);
            }
        });
        jefesDepDesa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                tblObtenerDatosJefesDesa(e);
            }
        });
    }

    public void guardarDatos() throws SQLException {
        int id;
        String nombre;
        String telDepContacto;
        String usuarioJefeFunc;
        String usuarioJefeDesa;

        nombre = txtnombredep.getText();
        telDepContacto = txtTelContact.getText();
        usuarioJefeFunc = txtJefeFunc.getText();
        usuarioJefeDesa = txtJefeDesa.getText();

        departamentos = new Departamentos(nombre, telDepContacto, usuarioJefeFunc, usuarioJefeDesa);

        if(btnInsertarDep.getText().equals("Insertar Departamento")){
            administrador.insertDepartamentos(departamentos);
            JOptionPane.showMessageDialog(null, "Departamento Agregado");
        } else if(btnInsertarDep.getText().equals("Editar Departamento")){
            id = Integer.parseInt(txtIdDepartamento.getText());
            departamentosUpdate = new DepartamentosUpdate(id, nombre, telDepContacto, usuarioJefeFunc, usuarioJefeDesa);
            administrador.updateDepartamentos(departamentosUpdate);
            JOptionPane.showMessageDialog(null, "Departamento editado");
        }

        modelo = administrador.selectDepartamentos();
        table1.setModel(modelo);
    }

    public void eliminarDatos() throws SQLException {
        try{
            int id;
            id = Integer.parseInt(txtIdDepartamento.getText());
            departamentosUpdate = new DepartamentosUpdate(id);
            administrador.deleteDepartamentos(departamentosUpdate);

            modelo = administrador.selectDepartamentos();
            table1.setModel(modelo);
            btnDelete.setEnabled(false);
        }catch(SQLException throwables){
            System.out.println("ERROR: " + throwables.getMessage());
        }

    }


    public void tblObtenerDatos(MouseEvent e){
        int fila = table1.rowAtPoint(e.getPoint());
        int columna = table1.columnAtPoint(e.getPoint());
        if((fila > -1) && (columna > -1)){
            txtIdDepartamento.setText(modelo.getValueAt(fila, 0).toString());
            txtnombredep.setText(modelo.getValueAt(fila, 1).toString());
            txtTelContact.setText(modelo.getValueAt(fila, 2).toString());
            txtJefeFunc.setText(modelo.getValueAt(fila, 3).toString());
            txtJefeDesa.setText(modelo.getValueAt(fila, 4).toString());
            txtJefeFunc.setEnabled(false);
            txtJefeDesa.setEnabled(false);
            btnInsertarDep.setText("Editar Departamento");
            btnDelete.setEnabled(true);
        }
    }

    public void tblObtenerDatosJefesFunc(MouseEvent e){
        int fila = jefesDepFunc.rowAtPoint(e.getPoint());
        int columna = jefesDepFunc.columnAtPoint(e.getPoint());
        if((fila > -1) && (columna > -1)){
            txtJefeFunc.setText(modelo1.getValueAt(fila, 1).toString());
        }
    }

    public void tblObtenerDatosJefesDesa(MouseEvent e){
        int fila = jefesDepDesa.rowAtPoint(e.getPoint());
        int columna = jefesDepDesa.columnAtPoint(e.getPoint());
        if((fila > -1) && (columna > -1)){
            txtJefeDesa.setText(modelo2.getValueAt(fila, 1).toString());
        }
    }

    public void btnLimpiar(){
        txtIdDepartamento.setText("");
        txtnombredep.setText("");
        txtTelContact.setText("");
        txtJefeDesa.setText("");
        txtJefeFunc.setText("");
        txtJefeFunc.setEnabled(true);
        txtJefeDesa.setEnabled(true);
        btnInsertarDep.setText("Insertar Departamento");
        btnDelete.setEnabled(false);

    }
}
