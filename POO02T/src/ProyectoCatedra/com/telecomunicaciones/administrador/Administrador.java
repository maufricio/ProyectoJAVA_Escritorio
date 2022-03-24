package ProyectoCatedra.com.telecomunicaciones.administrador;

import ProyectoCatedra.Interfaces.Login;
import ProyectoCatedra.Interfaces.Registrar;
import ProyectoCatedra.beans.Departamentos;
import ProyectoCatedra.beans.DepartamentosUpdate;
import ProyectoCatedra.beans.ProgramadoresUpdates;
import ProyectoCatedra.beans.Usuarios;
import ProyectoCatedra.com.telecomunicaciones.administrador.conexion.*;
import ProyectoCatedra.com.telecomunicaciones.empleados.Empleados;
import com.mysql.cj.x.protobuf.MysqlxPrepare;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class Administrador extends Empleados {

    SqlQueries sqlQueries = new SqlQueries();
    public Administrador(){
        super.setRolEmpleado("Administrador");
    }

    public void insertDepartamentos(Departamentos departamentos) throws SQLException {
        Connection con = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            con = Conexion.getConnection();
            stmt = con.prepareStatement(sqlQueries.getSQL_INSERT_DEPARTAMENTOS());
            int index = 1;
            stmt.setString(index++, departamentos.getNombreDepartamento());
            stmt.setString(index++, departamentos.getTelDepContacto());
            stmt.setString(index++, departamentos.getUsuarioJefeFunc());
            stmt.setString(index++, departamentos.getUsuarioJefeDesa());
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados " + rows);
        }catch(SQLException throwables){
            System.out.println(throwables.getMessage());
        }
    }

    public DefaultTableModel selectDepartamentos(){
        DefaultTableModel dtm = new DefaultTableModel();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sqlQueries.getSQL_SELECT_DEPARTAMENTOS());
            rs = stmt.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();
            int numberOfColumns = meta.getColumnCount();
            for (int i = 1; i <= numberOfColumns; i++) {
                dtm.addColumn(meta.getColumnLabel(i));
            }
            while (rs.next()) {
                Object[] fila = new Object[numberOfColumns];
                for(int i = 0; i < numberOfColumns; i++){
                    fila[i] = rs.getObject(i+1);
                }
                dtm.addRow(fila);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return dtm;
    }

    public DefaultTableModel selectJefesFuncionales(){
        DefaultTableModel dtm = new DefaultTableModel();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sqlQueries.getSQL_SELECT_JEFE_FUNCIONAL());
            rs = stmt.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();
            int numberOfColumns = meta.getColumnCount();
            for (int i = 1; i <= numberOfColumns; i++) {
                dtm.addColumn(meta.getColumnLabel(i));
            }
            while (rs.next()) {
                Object[] fila = new Object[numberOfColumns];
                for(int i = 0; i < numberOfColumns; i++){
                    fila[i] = rs.getObject(i+1);
                }
                dtm.addRow(fila);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return dtm;
    }

    public DefaultTableModel selectJefesDesarrollo() {
        DefaultTableModel dtm = new DefaultTableModel();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sqlQueries.getSQL_SELECT_JEFE_DESARROLLO());
            rs = stmt.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();
            int numberOfColumns = meta.getColumnCount();
            for (int i = 1; i <= numberOfColumns; i++) {
                dtm.addColumn(meta.getColumnLabel(i));
            }
            while (rs.next()) {
                Object[] fila = new Object[numberOfColumns];
                for(int i = 0; i < numberOfColumns; i++){
                    fila[i] = rs.getObject(i+1);
                }
                dtm.addRow(fila);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return dtm;
    }


    public void updateDepartamentos(DepartamentosUpdate departamentosupdate) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sqlQueries.getSQL_UPDATE_DEPARTAMENTOS());
            int index = 1;
            stmt.setString(index++, departamentosupdate.getNombreDepartamento());
            stmt.setString(index++, departamentosupdate.getTelDepContacto());
            stmt.setString(index++, departamentosupdate.getUsuarioJefeFunc());
            stmt.setString(index++, departamentosupdate.getUsuarioJefeDesa());
            stmt.setInt(index++, departamentosupdate.getId());
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizados: " + rows);
        }catch(SQLException throwables){
            System.out.println(throwables.getMessage());
        }
    }

    public void deleteDepartamentos(DepartamentosUpdate departamentosUpdate) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sqlQueries.getSQL_DELETE_DEPARTAMENTOS());
            int index = 1;
            stmt.setInt(index++, departamentosUpdate.getId());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados: " + rows);
        }catch(SQLException throwables){
            System.out.println(throwables.getMessage());
        }
    }

    public void updateUsuarios(ProgramadoresUpdates programadoresUpdates) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sqlQueries.getSQL_UPDATE_PROGRAMADOR());
            int index = 1;
            stmt.setInt(index++, programadoresUpdates.getId_departamento());
            stmt.setInt(index++, programadoresUpdates.getCategoriaUsuario());
            stmt.setString(index++, programadoresUpdates.getUsername());
            stmt.setString(index++, programadoresUpdates.getPassword());
            stmt.setInt(index++, programadoresUpdates.getId_usuario());
            rows = stmt.executeUpdate();
            System.out.println("REGISTRO ACTUALIZADO: " + rows);
        }catch(SQLException throwables){
            System.out.println("ERROR: " + throwables.getMessage());
        }
    }

    public DefaultTableModel selectUsuarioProgramadores(){
        DefaultTableModel dtm = new DefaultTableModel();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sqlQueries.getSQL_SELECT_PROGRAMADOR());
            rs = stmt.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();
            int numberOfColumns = meta.getColumnCount();
            for (int i = 1; i <= numberOfColumns; i++) {
                dtm.addColumn(meta.getColumnLabel(i));
            }
            while (rs.next()) {
                Object[] fila = new Object[numberOfColumns];
                for(int i = 0; i < numberOfColumns; i++){
                    fila[i] = rs.getObject(i+1);
                }
                dtm.addRow(fila);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return dtm;
    }

    public DefaultTableModel selectCasos(){
        DefaultTableModel dtm = new DefaultTableModel();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sqlQueries.getSQL_SELECT_CASO());
            rs = stmt.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();
            int numberOfColumns = meta.getColumnCount();
            for (int i = 1; i <= numberOfColumns; i++) {
                dtm.addColumn(meta.getColumnLabel(i));
            }
            while (rs.next()) {
                Object[] fila = new Object[numberOfColumns];
                for(int i = 0; i < numberOfColumns; i++){
                    fila[i] = rs.getObject(i+1);
                }
                dtm.addRow(fila);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return dtm;
    }
    public void insertUsuarios(Usuarios usuarios) throws SQLException {
        JFrame jFrame = new Registrar("Registrar usuarios");
        jFrame.setVisible(true);
    }
}