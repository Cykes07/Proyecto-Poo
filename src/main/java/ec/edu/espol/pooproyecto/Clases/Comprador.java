/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.pooproyecto.Clases;

import java.util.ArrayList;

/**
 *
 * @author arife
 */
public class Comprador extends Usuario{
    private static ArrayList<String> correoComprador;

    public Comprador(String nommbre, String apellido, String organizacion, String correo, String clave) {
        super(nommbre, apellido, organizacion, correo, clave);
    }

}
