package ProyectoCatedra.com.telecomunicaciones.administrador;

public class SqlQueries {
    //Queries departamentos
    private final String SQL_INSERT_DEPARTAMENTOS = "INSERT INTO departamentos(nombreDepartamento, telDepContacto, usuarioJefeFunc, usuarioJefeDesa) VALUES(?, ?, ?, ?)";
    private final String SQL_UPDATE_DEPARTAMENTOS = "UPDATE departamentos SET nombreDepartamento = ?, telDepContacto = ?, usuarioJefeFunc = ?, usuarioJefeDesa = ? WHERE Id_departamento = ?";
    private final String SQL_DELETE_DEPARTAMENTOS = "DELETE FROM departamentos WHERE id_Departamento = ?";
    private final String SQL_SELECT_DEPARTAMENTOS = "SELECT * FROM departamentos";

    //Queries programador
    private final String SQL_INSERT_PROGRAMADOR = "INSERT INTO usuarios (Id_departamento, tipoUsuario, nombresUsuario, apellidosUsuario, passwordUsuario, username) VALUES(?, 3, ?, ?, ?, ?)";
    private final String SQL_UPDATE_PROGRAMADOR = "UPDATE usuarios SET Id_departamento = ?, tipoUsuario = ?,  username = ?, passwordUsuario = ? WHERE Id_usuario = ?";
    private final String SQL_DELETE_PROGRAMADOR = "DELETE FROM usuarios WHERE Id_usuario = ?";
    private final String SQL_SELECT_PROGRAMADOR = "SELECT Id_usuario, Id_departamento, tipoUsuario, username, passwordUsuario FROM usuarios WHERE tipoUsuario = 3";


    //Queries usuarios
    private final String SQL_INSERT_USUARIOS = "INSERT INTO usuarios (Id_departamento, tipoUsuario, nombresUsuario, apellidosUsuario, passwordUsuario, username) VALUES(?, ?, ?, ?, ?, ?)";
    private final String SQL_UPDATE_USUARIOS = "UPDATE usuarios SET Id_departamento = ?, tipoUsuario = ?, nombresUsuario = ?, apellidosUsuario = ?, passwordUsuario = ?, username = ? WHERE Id_usuario = ?";
    private final String SQL_DELETE_USUARIOS = "DELETE FROM usuarios WHERE Id_usuario = ?";
    private final String SQL_SELECT_USUARIOS = "SELECT * FROM usuarios";


    //Queries jefes
    private final String SQL_SELECT_JEFE_FUNCIONAL = "SELECT Id_usuario, tipoUsuario, username FROM usuarios WHERE tipoUsuario = 1";
    private final String SQL_SELECT_JEFE_DESARROLLO = "SELECT Id_usuario, tipoUsuario, username FROM usuarios WHERE tipoUsuario = 2";
    private final String SQL_UPDATE_JEFE_FUNCIONAL = "UPDATE departamentos SET usuarioJefeFunc = ? WHERE Id_departamento = ?";
    private final String SQL_UPDATE_JEFE_DESARROLLO = "UPDATE departametos SET usuarioJefeDesa = ? WHERE Id_departamento = ?";
    private final String SQL_DELETE_JEFE_DESARROLLO = "DELETE FROM usuarios WHERE Id_usuario = ?";
    private final String SQL_DELETE_JEFE_FUNCIONAL = "DELETE FROM usuarios WHERE Id_usuario = ?";

    //Queries casos

    private final String SQL_SELECT_CASO = "SELECT * FROM casos";


    public String getSQL_UPDATE_USUARIOS() {
        return SQL_UPDATE_USUARIOS;
    }

    public String getSQL_DELETE_USUARIOS() {
        return SQL_DELETE_USUARIOS;
    }

    public String getSQL_SELECT_USUARIOS() {
        return SQL_SELECT_USUARIOS;
    }

    public String getSQL_SELECT_JEFE_FUNCIONAL() {
        return SQL_SELECT_JEFE_FUNCIONAL;
    }

    public String getSQL_SELECT_JEFE_DESARROLLO() {
        return SQL_SELECT_JEFE_DESARROLLO;
    }

    public String getSQL_DELETE_JEFE_DESARROLLO() {
        return SQL_DELETE_JEFE_DESARROLLO;
    }

    public String getSQL_DELETE_JEFE_FUNCIONAL() {
        return SQL_DELETE_JEFE_FUNCIONAL;
    }

    public String getSQL_SELECT_CASO() {
        return SQL_SELECT_CASO;
    }

    public String getSQL_INSERT_DEPARTAMENTOS() {
        return SQL_INSERT_DEPARTAMENTOS;
    }

    public String getSQL_UPDATE_DEPARTAMENTOS() {
        return SQL_UPDATE_DEPARTAMENTOS;
    }

    public String getSQL_DELETE_DEPARTAMENTOS() {
        return SQL_DELETE_DEPARTAMENTOS;
    }

    public String getSQL_SELECT_DEPARTAMENTOS() {
        return SQL_SELECT_DEPARTAMENTOS;
    }

    public String getSQL_INSERT_PROGRAMADOR() {
        return SQL_INSERT_PROGRAMADOR;
    }

    public String getSQL_UPDATE_PROGRAMADOR() {
        return SQL_UPDATE_PROGRAMADOR;
    }

    public String getSQL_DELETE_PROGRAMADOR() {
        return SQL_DELETE_PROGRAMADOR;
    }

    public String getSQL_SELECT_PROGRAMADOR() {
        return SQL_SELECT_PROGRAMADOR;
    }

    public String getSQL_UPDATE_JEFE_FUNCIONAL() {
        return SQL_UPDATE_JEFE_FUNCIONAL;
    }

    public String getSQL_UPDATE_JEFE_DESARROLLO() {
        return SQL_UPDATE_JEFE_DESARROLLO;
    }
}
