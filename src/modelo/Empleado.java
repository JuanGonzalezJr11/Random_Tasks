package modelo;

public class Empleado {
    private int idEmpleado;
    private String nombre;
    private String descripcion;

    public Empleado() {
    }
    
    public Empleado(int idEmpleado, String nombre, String descripcion) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    public Empleado(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String conSinDescripcion(String d){
        if(descripcion == null || descripcion.isEmpty()){
            d = " ";
        }
        else{
            d = " - " + descripcion;
        }
        return d;
    }

    @Override
    public String toString() {
        return this.nombre + conSinDescripcion(descripcion);
    }
}
