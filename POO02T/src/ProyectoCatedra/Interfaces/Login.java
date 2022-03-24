package ProyectoCatedra.Interfaces;
import ProyectoCatedra.Conexion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame{
    private static final String title = "Login";
    private JPanel pnlLogin;
    private JTextField txtUsuario;
    private JPasswordField passContrasena;
    private JButton btnIngresar;
    private JButton btnRegistrar;


    public Login(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlLogin);
        this.setMinimumSize(new Dimension(600, 500));
        this.setLocationRelativeTo(getParent());
        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    setBtnIngresar();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
        });
    }

    public void setBtnIngresar() throws SQLException {
        String username;
        char [] password;

        username = txtUsuario.getText();
        password = passContrasena.getPassword();
        try
        {
            Conexion con=new Conexion();
            con.setRs("select count(username) from usuarios" + " where username='"+username+"'");
            ResultSet rs=con.getRs();
            rs.next();
            if(rs.getInt(1)==1)
            {
                String tipo="select tipoUsuario from usuarios" + " where username='"+username+"'";
                con.setRs(tipo);
                ResultSet rs1 = con.getRs();
                rs1.next();
                String Tipo= rs1.getString(1);
                System.out.println(Tipo);
                if (Integer.parseInt(Tipo)==1){
                    JFrame frame = new BienvenidoJefatura("Jefatura");
                    frame.setVisible(true);
                    System.out.println("entre");
                }else if(Integer.parseInt(Tipo)==2){
                    JFrame frame = new BienvenidoJefeDesarrollo("Jefe de Desarrollo");
                    frame.setVisible(true);
                    System.out.println("entre");
                }else if(Integer.parseInt(Tipo)==3) {
                    JFrame frame = new BienvenidaProgramador("Programador");
                    frame.setVisible(true);
                    System.out.println("entre");
                }else if(Integer.parseInt(Tipo)==4){
                    JFrame frame = new BienvenidaProbador("Probador");
                    frame.setVisible(true);
                    System.out.println("entre");
                }

            }
            else
            {
                JOptionPane.showMessageDialog(null, "No existe la cuenta");
            }
            rs.close();
            con.cerrarConexion();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }


    }

    public static void main (String [] args) {
        JFrame frame = new Login("Ingreso de Datos");
        frame.setVisible(true);
    }
}
