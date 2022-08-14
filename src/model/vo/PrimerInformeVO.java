package model.vo;

/**
 *
 * @author JancarlosCh
 */
public class PrimerInformeVO {

    // Este reporte es ordenado por la “Ciudad_Residencia”
    private int idLider;
    private String nombre;
    private String primerApellido;
    private String ciudad;

    public PrimerInformeVO(int idLider, String nombre, String primerApellido, String ciudad) {
        this.idLider = idLider;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.ciudad = ciudad;
    }

    public int getIdLider() {
        return idLider;
    }

    public void setIdLider(int idLider) {
        this.idLider = idLider;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getNombreCompleto() {
        return nombre + " " + primerApellido;
    }
}
