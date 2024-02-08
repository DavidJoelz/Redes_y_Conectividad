package entidades;

import java.time.LocalDate;
import java.time.LocalTime;

public class Permiso {
    private int ID;
    private String DNIUsuario;
    private String TipoPermiso;
    private String AreaOrigen;
    private String DependenciaOrigen;
    private String AreaDestino;
    private String DependenciaDestino;
    private String Asunto;
    private String Observaciones;
    private LocalDate Fecha;
    private LocalTime HoraSalida;
    private LocalTime HoraRetorno;

    public Permiso() {
    }

    public Permiso(String DNIUsuario, String TipoPermiso, String AreaOrigen,
                   String DependenciaOrigen, String AreaDestino, String DependenciaDestino,
                   String Asunto, String Observaciones, LocalDate Fecha, LocalTime HoraSalida,
                   LocalTime HoraRetorno) {
        this.DNIUsuario = DNIUsuario;
        this.TipoPermiso = TipoPermiso;
        this.AreaOrigen = AreaOrigen;
        this.DependenciaOrigen = DependenciaOrigen;
        this.AreaDestino = AreaDestino;
        this.DependenciaDestino = DependenciaDestino;
        this.Asunto = Asunto;
        this.Observaciones = Observaciones;
        this.Fecha = Fecha;
        this.HoraSalida = HoraSalida;
        this.HoraRetorno = HoraRetorno;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDNIUsuario() {
        return DNIUsuario;
    }

    public void setDNIUsuario(String DNIUsuario) {
        this.DNIUsuario = DNIUsuario;
    }

    public String getTipoPermiso() {
        return TipoPermiso;
    }

    public void setTipoPermiso(String TipoPermiso) {
        this.TipoPermiso = TipoPermiso;
    }

    public String getAreaOrigen() {
        return AreaOrigen;
    }

    public void setAreaOrigen(String AreaOrigen) {
        this.AreaOrigen = AreaOrigen;
    }

    public String getDependenciaOrigen() {
        return DependenciaOrigen;
    }

    public void setDependenciaOrigen(String DependenciaOrigen) {
        this.DependenciaOrigen = DependenciaOrigen;
    }

    public String getAreaDestino() {
        return AreaDestino;
    }

    public void setAreaDestino(String AreaDestino) {
        this.AreaDestino = AreaDestino;
    }

    public String getDependenciaDestino() {
        return DependenciaDestino;
    }

    public void setDependenciaDestino(String DependenciaDestino) {
        this.DependenciaDestino = DependenciaDestino;
    }

    public String getAsunto() {
        return Asunto;
    }

    public void setAsunto(String Asunto) {
        this.Asunto = Asunto;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }

    public LocalDate getFecha() {
        return Fecha;
    }

    public void setFecha(LocalDate Fecha) {
        this.Fecha = Fecha;
    }

    public LocalTime getHoraSalida() {
        return HoraSalida;
    }

    public void setHoraSalida(LocalTime HoraSalida) {
        this.HoraSalida = HoraSalida;
    }

    public LocalTime getHoraRetorno() {
        return HoraRetorno;
    }

    public void setHoraRetorno(LocalTime HoraRetorno) {
        this.HoraRetorno = HoraRetorno;
    }

    @Override
    public String toString() {
        return "Permiso{" +
                "ID=" + ID +
                ", DNIUsuario='" + DNIUsuario + '\'' +
                ", TipoPermiso='" + TipoPermiso + '\'' +
                ", AreaOrigen='" + AreaOrigen + '\'' +
                ", DependenciaOrigen='" + DependenciaOrigen + '\'' +
                ", AreaDestino='" + AreaDestino + '\'' +
                ", DependenciaDestino='" + DependenciaDestino + '\'' +
                ", Asunto='" + Asunto + '\'' +
                ", Observaciones='" + Observaciones + '\'' +
                ", Fecha=" + Fecha +
                ", HoraSalida=" + HoraSalida +
                ", HoraRetorno=" + HoraRetorno +
                '}';
    }
}