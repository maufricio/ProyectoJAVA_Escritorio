package ProyectoCatedra.beans;

public class DepartamentosUpdate extends Departamentos{
        private int id;
        public DepartamentosUpdate(int id, String nombreDepartamento, String telDepContacto, String usuarioJefeFunc, String usuarioJefeDesa) {
            super();
            setId(id);
            super.setNombreDepartamento(nombreDepartamento);
            super.setTelDepContacto(telDepContacto);
            super.setUsuarioJefeFunc(usuarioJefeFunc);
            super.setUsuarioJefeDesa(usuarioJefeDesa);
        }

    public DepartamentosUpdate() {

    }

    public DepartamentosUpdate(int id){
            this.id = id;
    }

        public void setId(int id){
            this.id = id;
        }

        public int getId(){
            return this.id;
        }
}
