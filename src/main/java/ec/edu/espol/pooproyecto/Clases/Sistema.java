/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.pooproyecto.Clases;

import static ec.edu.espol.pooproyecto.Clases.Comprador.generarHash;
import static ec.edu.espol.pooproyecto.Clases.Vehiculo.generarHash;
import static ec.edu.espol.pooproyecto.Clases.Vendedor.generarHash;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mariu
 */
public class Sistema {
    private ArrayList<Vendedor> vendedores;
    private ArrayList<String> correoVendedores;
    private  ArrayList<String> correoComprador;
    private ArrayList<Comprador> compradores;
    private ArrayList<Oferta> ofertas;
    
    public boolean validarCorreo(String correo){
        for(String c: correoVendedores){
           if(c.equals(correo))
               return true;
        }
        
        return false;
    }
    
     public void ingresarVehiculo(Scanner sc){
        
        System.out.println("Ingresar correo electronico:  ");
        String correoU= sc.nextLine();
        boolean validacion= validarCorreo(correoU);
        if (validacion){
            System.out.println("Ingresar clave:  ");
            String claveU= sc.nextLine();
            String Hashu= Vehiculo.generarHash(claveU);
        }
        
        System.out.println("Ingresar placa:  ");
        String placaU= sc.nextLine();
        System.out.println("Ingresar marca:  ");
        String marcaU= sc.nextLine();
        System.out.println("Ingresar modelo:  ");
        String modeloU= sc.nextLine();
        System.out.println("Ingresar tipo de motor:  ");
        String motorU= sc.nextLine();
        System.out.println("Ingresar año:  ");
        int anioU= sc.nextInt();
        System.out.println("Ingresar recorrido:  ");
        int recorridoU= sc.nextInt();
        System.out.println("Ingresar color:  ");
        String colorU= sc.nextLine();
        System.out.println("Ingresar tipo de combustible:  ");
        String combustibleU= sc.nextLine();
        System.out.println("Ingresar precio:  ");
        double precioU= sc.nextDouble();
        
    }
    
    
    public void registrarNuevoVendedor(Scanner sc){
        System.out.println("Ingresar nombre:  ");
        String nomb= sc.nextLine();
        System.out.println("Ingresar Apellido:  ");
        String ape= sc.nextLine();
        System.out.println("Ingresar organizacion:  ");
        String org= sc.nextLine();
        
        System.out.println("Ingresar correo electronico:  ");
        String corr= sc.nextLine();
        boolean resp= validarCorreo(corr);
        if (resp==true){
            System.out.println("Correo ya existe");
            return;
        }
        correoVendedores.add(corr);
        
        System.out.println("Ingresar contrasena:  ");
        String contr= sc.nextLine();
        String hashU= Vendedor.generarHash(contr);
        
        vendedores.add( new Vendedor(nomb,ape,org,corr,hashU));
    }
    
    public void registrarNuevoComprador(Scanner sc){
        System.out.println("Ingresar nombre:  ");
        String nombreU= sc.nextLine();
        System.out.println("Ingresar Apellido:  ");
        String apellidoU= sc.nextLine();
        System.out.println("Ingresar organizacion:  ");
        String organizacionU= sc.nextLine();
        
        System.out.println("Ingresar correo electronico:  ");
        String correoU= sc.nextLine();
        boolean resp= validarCorreo(correoU);
        if (resp==true){
            System.out.println("Correo ya existe");
            return;
        }
        correoComprador.add(correoU);
        
        System.out.println("Ingresar contrasena:  ");
        String contrasenaU= sc.nextLine();
        String hashU= Comprador.generarHash(contrasenaU);
        
        compradores.add( new Comprador(nombreU,apellidoU,organizacionU,correoU,hashU));
    }
    
//    public void ofertarVehiculo(Scanner sc){
//       System.out.println("Ingresar tipo de vehiculo:  ");
//       String tipoOFER= sc.nextLine();
//       System.out.println("Ingresar recorrido desde:  ");
//       String recorridoDESDE= sc.nextLine();
//       System.out.println(", hasta:  ");
//       String recorridoHASTA= sc.nextLine();
//       System.out.println("Ingresar año desde:  ");
//       String anioDESDE= sc.nextLine();
//       System.out.println(", hasta:  ");
//       String anioHASTA= sc.nextLine();
//       System.out.println("Ingresar precio desde:  ");
//       String precioDESDE= sc.nextLine();
//       System.out.println(", hasta:  ");
//       String precioHASTA= sc.nextLine();
//       :(
//   }
    
    
}
