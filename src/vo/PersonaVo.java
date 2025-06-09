package vo;

public class PersonaVo {
    private String documento;
    private String nombre;
    private String direccion;
    private String telefono;

    public PersonaVo(String documento, String nombre, String direccion, String telefono) {
        this.nombre ="";
        this.documento="";
        this.telefono="";
        this.direccion="";
    }
    public PersonaVo() {
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
