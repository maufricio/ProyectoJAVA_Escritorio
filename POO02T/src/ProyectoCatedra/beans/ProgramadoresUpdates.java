package ProyectoCatedra.beans;

public class ProgramadoresUpdates {
    private int Id_usuario;
    private int Id_departamento;
    private int categoriaUsuario;
    private String username;
    private String password;

    public ProgramadoresUpdates(int Id_usuario, int Id_departamento, int categoriaUsuario, String username, String password){
        this.Id_usuario = Id_usuario;
        this.Id_departamento = Id_departamento;
        this.categoriaUsuario = categoriaUsuario;
        this.username = username;
        this.password = password;
    }

    public int getId_usuario() {
        return Id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        Id_usuario = id_usuario;
    }

    public int getId_departamento() {
        return Id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        Id_departamento = id_departamento;
    }

    public int getCategoriaUsuario() {
        return categoriaUsuario;
    }

    public void setCategoriaUsuario(int categoriaUsuario) {
        this.categoriaUsuario = categoriaUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
