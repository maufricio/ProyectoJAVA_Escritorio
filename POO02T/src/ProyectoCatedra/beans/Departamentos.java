package ProyectoCatedra.beans;

public class Departamentos{
    private String nombreDepartamento;
    private String telDepContacto;
    private String usuarioJefeFunc;
    private String usuarioJefeDesa;
    public Departamentos(String nombreDepartamento, String telDepContacto, String usuarioJefeFunc, String usuarioJefeDesa){
        this.nombreDepartamento = nombreDepartamento;
        this.telDepContacto = telDepContacto;
        this.usuarioJefeFunc = usuarioJefeFunc;
        this.usuarioJefeDesa = usuarioJefeDesa;
    }

    public Departamentos() {

    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public String getTelDepContacto() {
        return telDepContacto;
    }

    public void setTelDepContacto(String telDepContacto) {
        this.telDepContacto = telDepContacto;
    }

    public String getUsuarioJefeFunc() {
        return usuarioJefeFunc;
    }

    public void setUsuarioJefeFunc(String usuarioJefeFunc) {
        this.usuarioJefeFunc = usuarioJefeFunc;
    }

    public String getUsuarioJefeDesa() {
        return usuarioJefeDesa;
    }

    public void setUsuarioJefeDesa(String usuarioJefeDesa) {
        this.usuarioJefeDesa = usuarioJefeDesa;
    }
}
