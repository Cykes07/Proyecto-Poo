/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.pooproyecto.Clases;

import static ec.edu.espol.pooproyecto.Clases.Vendedor.generarHash;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author arife
 */
public class Comprador extends Usuario{
    private static ArrayList<String> correoComprador;
    public ArrayList<Comprador> compradores;

    public Comprador(String nommbre, String apellido, String organizacion, String correo, String clave) {
        super(nommbre, apellido, organizacion, correo, clave);
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
   public boolean validarCorreo(String correo){
        for(String c: correoComprador){
           if(c.equals(correo))
               return true;
        }
        
        return false;
    }
   
   
   
}
