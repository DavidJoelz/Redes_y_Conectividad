package entidades;

public class Usuario {
    private int ID;
    private String DNI;
    private String Email;
    private String Pass;
    private String Nombre;
    private String Apellidos;
    private String Rol;

    // Constructor vacío (puede ser necesario para ciertos frameworks)
    public Usuario() {
    }

    // Constructor con parámetros
    public Usuario(String DNI, String Email, String Pass, String Nombre, String Apellidos, String Rol) {
        this.DNI = DNI;
        this.Email = Email;
        this.Pass = Pass;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Rol = Rol;
    }

    // Getters y setters (puedes generarlos automáticamente en tu IDE)
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String Rol) {
        this.Rol = Rol;
    }
}