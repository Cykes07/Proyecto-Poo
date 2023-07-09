/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.pooproyecto.Clases;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
    
       public static String generarHash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
    
    public void registrarNuevoVendedor(Scanner sc){
        
        
    }

}
