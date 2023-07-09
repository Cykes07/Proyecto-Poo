/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.pooproyecto.Clases;

/**
 *
 * @author arife
 */
public class Usuario {
    private String nombre;
    private String apellido;
    private String organizacion;
    private String correo;
    private String clave;

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    
    
    
    
    
    public Usuario(String nombre, String apellido, String organizacion, String correo, String clave) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.organizacion = organizacion;
        this.correo = correo;
        this.clave = clave;
    }

}
