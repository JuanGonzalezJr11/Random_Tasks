package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.*;

public class GestorBaseDatos {
    private Connection con;
    private final String CONN = "jdbc:sqlserver://DESKTOP-8CM8F2H:1433;databaseName=RandomTasks;";
    private final String USER = "Furtgolito";
    private final String PASS = "1234";
    private void abrirConexion(){
        try {
            con = DriverManager.getConnection(CONN, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void cerrarConexion(){
        try {
            if(con != null && !con.isClosed()){
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX Personal:
    public void agregarEmpleado(Empleado em){
        try {
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("INSERT INTO Empleados VALUES (?, ?)");
            ps.setString(1, em.getNombre());
            ps.setString(2, em.getDescripcion());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
    }
    public ArrayList<Empleado> listadoEmpleados(){
        ArrayList<Empleado> lista = new ArrayList<>();
        try {
            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Empleados");
            while(rs.next()){
                int idEmpleado = rs.getInt("idEmpleado");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                lista.add(new Empleado(idEmpleado, nombre, descripcion));
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        return lista;
    }
    public boolean modificarEmpleado(Empleado em){
        boolean resultado = false;
        try {
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("UPDATE Empleados SET nombre = ?, descripcion = ? WHERE idEmpleado = ?");
            ps.setString(1, em.getNombre());
            ps.setString(2, em.getDescripcion());
            ps.setInt(3, em.getIdEmpleado());
            ps.executeUpdate();
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        return resultado;
    }
    public void borrarEmpleado(int idEmpleado){
        try {
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("DELETE FROM Empleados WHERE idEmpleado = ?");
            ps.setInt(1, idEmpleado);
            ps.executeUpdate();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
    }
    // XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXZZZZZZ Tareas:
    public void agregarTarea(Tarea t){
        try {
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("INSERT INTO Tareas VALUES (?, ?)");
            ps.setString(1, t.getTarea());
            ps.setString(2, t.getDescripcion());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
    }
}

