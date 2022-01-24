package modelo;

public class Tarea {
    private int idTarea;
    private String tarea;
    private String descripcion;

    public Tarea(int idTarea, String tarea, String descripcion) {
        this.idTarea = idTarea;
        this.tarea = tarea;
        this.descripcion = descripcion;
    }

    public Tarea(String tarea, String descripcion) {
        this.tarea = tarea;
        this.descripcion = descripcion;
    }
    
    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return this.tarea;
    }
}
