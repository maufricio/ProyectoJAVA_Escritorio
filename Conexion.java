package ProyectoCatedra;
import java.sql.*;
public class Conexion
{
    private Connection conexion=null;
    private Statement s=null;
    private ResultSet rs=null;

    public Conexion()throws SQLException
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/telecomunicacion_es","root", "");
            s=conexion.createStatement();
        }
        catch (ClassNotFoundException e1)
        {
            System.out.println("ERROR: NO ENCUENTRO EL DRIVER DE LA BDD: "+e1.getMessage());
        }
    }
    public ResultSet getRs()
    {
        return rs;
    }

    public void setRs(String consulta)
    {
        try
        {
            this.rs=s.executeQuery(consulta);
        }
        catch (SQLException e2)
        {
            System.out.println("ERROR: FALLO EN SQL: "+e2.getMessage());
        }
    }

    public void setQuery(String query) throws SQLException
    {
        this.s.executeUpdate(query);
    }

    public void cerrarConexion()throws SQLException
    {
        conexion.close();
    }
}