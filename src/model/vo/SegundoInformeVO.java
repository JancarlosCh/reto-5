package model.vo;

/**
 *
 * @author JancarlosCh
 */
public class SegundoInformeVO {
//Cuya clasificación sea “Casa Campestre” y que estén ubicados en las ciudades de “Santa Marta”, 
// “Cartagena” y “Barranquilla”.
    private int idProyecto;
    private String constructora;
    private int numeroHabitantes;
    private String ciudad;

    public SegundoInformeVO(int idProyecto, String constructora, int numeroHabitantes, String ciudad) {
        this.idProyecto = idProyecto;
        this.constructora = constructora;
        this.numeroHabitantes = numeroHabitantes;
        this.ciudad = ciudad;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getConstructora() {
        return constructora;
    }

    public void setConstructora(String constructora) {
        this.constructora = constructora;
    }

    public int getNumeroHabitantes() {
        return numeroHabitantes;
    }

    public void setNumeroHabitantes(int numeroHabitantes) {
        this.numeroHabitantes = numeroHabitantes;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
