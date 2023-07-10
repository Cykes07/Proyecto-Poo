/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.pooproyecto.Clases;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mariu
 */
public class Sistema {
    private ArrayList<Vendedor> vendedores;
    private ArrayList<Comprador> compradores;
    private ArrayList<Oferta> ofertas;
    private ArrayList<Vehiculo> vehiculos;
    
    public void menuOpciones(){
        Scanner sc = new Scanner(System.in);
        mostrarOpciones();
        System.out.println("Escoge una opción: ");
        int opcion = sc.nextInt();
        switch(opcion){
            case 1:
                menuVendedor();             
                //Menu vendedor
            case 2: 
                mostrarComprador();
                //Menu Comprador
            case 3:
                break;
        }
    }
    
    public void menuVendedor(){
        mostrarVendedor();
        Scanner sc = new Scanner(System.in);
        System.out.println("Escoge una opción: ");
        int opcion = sc.nextInt();
        switch(opcion){
            case 1:
                registrarNuevoVendedor();
            case 2:
                ingresarVehiculo();
            case 3:
                //aceptar oferta
            case 4:
                menuOpciones();
        }
    }
    
    public void menuComprador(){
        mostrarComprador();
        Scanner sc = new Scanner(System.in);
        System.out.println("Escoge una opción: ");
        int opcion = sc.nextInt();
        switch(opcion){
            case 1:
                //registrar un nuevo comprador
            case 2:
                //ofertar por un vehiculo
            case 3:
                menuOpciones();
        }
    }
    
    public void mostrarOpciones(){
        System.out.println("Menú Opciones: ");
        System.out.println("1. Vendendor");
        System.out.println("2. Comprador");
        System.out.println("3. Salir");
    }
    
    public void mostrarVendedor(){
        System.out.println("1. Registrar un nuevo vendendor");
        System.out.println("2. Registrar un nuevo vehículo");
        System.out.println("3. Aceptar oferta");
        System.out.println("4. Regresar");
    }
    
    public void mostrarComprador(){
        System.out.println("1. Registrar un nuevo comprador");
        System.out.println("2. Ofertar por un vehículo");
        System.out.println("3. Regresar");
    }
    
    public boolean validarCorreo(String correo){
        for(Vendedor vendedor: vendedores){
           if(vendedor.correo.equals(correo))
               return true;
        }
        return false;
    }
    
     public void ingresarVehiculo(){
        Scanner sc = new Scanner(System.in);
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
        for (Vehiculo vehiculo: vehiculos){
            if (vehiculo.placa.equals(placaU)){
                System.out.println("Esta placa ya existe");
                return;  
            }
        }
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
    
    public void registrarNuevoVendedor(){
        Scanner sc = new Scanner(System.in);
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
        System.out.println("Ingresar contrasena:  ");
        String contr= sc.nextLine();
        String hashU= Usuario.generarHash(contr);
        
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
        
        System.out.println("Ingresar contrasena:  ");
        String contrasenaU= sc.nextLine();
        String hashU= Usuario.generarHash(contrasenaU);
        
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
