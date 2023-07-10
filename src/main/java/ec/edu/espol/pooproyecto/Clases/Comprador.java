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

   public boolean validarCorreo(String correo){
        for(String c: correoComprador){
           if(c.equals(correo))
               return true;
        }
        
        return false;
    }
   
   
   
}
