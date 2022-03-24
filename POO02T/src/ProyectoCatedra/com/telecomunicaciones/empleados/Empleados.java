package ProyectoCatedra.com.telecomunicaciones.empleados;

public abstract class Empleados {
    private int IdEmpleado;
    private String nombreEmpleado;
    private String apellidoEmpleado;
    private String rolEmpleado;
    private String passwordEmpleado;
    private String usernameEmpleado;
    private String departamentoEmpleado;

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getApellidoEmpleado() {
        return apellidoEmpleado;
    }

    public void setApellidoEmpleado(String apellidoEmpleado) {
        this.apellidoEmpleado = apellidoEmpleado;
    }

    public String getPasswordEmpleado() {
        return passwordEmpleado;
    }

    public void setPasswordEmpleado(String passwordEmpleado) {
        this.passwordEmpleado = passwordEmpleado;
    }

    public String getUsernameEmpleado() {
        return usernameEmpleado;
    }

    public void setUsernameEmpleado(String usernameEmpleado) {
        this.usernameEmpleado = usernameEmpleado;
    }

    public String getDepartamentoEmpleado() {
        return departamentoEmpleado;
    }

    public void setDepartamentoEmpleado(String departamentoEmpleado) {
        this.departamentoEmpleado = departamentoEmpleado;
    }

    public String getRolEmpleado() {
        return rolEmpleado;
    }

    public void setRolEmpleado(String rolEmpleado) {
        this.rolEmpleado = rolEmpleado;
    }
}
