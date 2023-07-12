/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espol.pooproyecto;

import ec.edu.espol.pooproyecto.Clases.Sistema;

/**
 *
 * @author arife
 */
public class PooProyecto {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("holaaaaa");
        
        Sistema s1= new Sistema();
        //s1.readFile("vendedores.txt");
        //s1.registrarVendedor();
        s1.readFile2("compradores.txt");
        s1.registrarComprador();
    }
}
