/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.pooproyecto.Clases;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author arife
 */
public class Vendedor extends Usuario {
    private static ArrayList<String> correoVendedores;
    private ArrayList<Vehiculo> vehiculos;

    public Vendedor(String nombre, String apellido, String organizacion, String correo, String clave) {
        super(nombre, apellido, organizacion, correo, clave);
        this.vehiculos = new ArrayList<>();
    }
    
    public boolean validarCorreo(String correo){
        for(String c: correoVendedores){
           if(c.equals(correo))
               return true;
        }
        
        return false;
    }
    
    public void registrarNuevoVendedor(Scanner sc){
        
        
    }

}
