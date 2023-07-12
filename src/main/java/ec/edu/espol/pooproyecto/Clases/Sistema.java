/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.pooproyecto.Clases;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
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

    public Sistema() {
        this.vendedores = readFile("vendedores.txt");
        this.compradores = readFile2("compradores.txt");
        this.ofertas = new ArrayList<Oferta>();
        this.vehiculos = new ArrayList<Vehiculo>();
    }
    
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
                registrarVendedor();
            case 2:
                nuevoVehiculoV();
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
     
    public ArrayList<Vendedor> readFile(String nomfile){
        ArrayList<Vendedor> vendedores= new ArrayList<>();
        try(Scanner sc= new Scanner(new File (nomfile))){
            while(sc.hasNextLine()){
                String linea = sc.nextLine();
                String[] dato=linea.split("-");
                Vendedor v= new Vendedor(dato[0],dato[1],dato[2],dato[3],dato[4]);
                vendedores.add(v);
            }
        } 
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return vendedores;
    }
    
    public ArrayList<Comprador> readFile2(String nomfile){
    ArrayList<Comprador> compradores= new ArrayList<>();
    try(Scanner sc= new Scanner(new File (nomfile))){
        while(sc.hasNextLine()){
            String linea = sc.nextLine();
            String[] dato=linea.split("-");
            Comprador c= new Comprador(dato[0],dato[1],dato[2],dato[3],dato[4]);
            compradores.add(c);
        }
    } 
    catch(Exception e){
        System.out.println(e.getMessage());
    }
    return compradores;
    }
    
    
    public void registrarVendedor(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Ingrese Nombre:");
        String nomU= sc.nextLine();
        System.out.println("Ingrese Apellido:");
        String apeU= sc.nextLine();
        System.out.println("Ingrese organizacion:");
        String orgU= sc.nextLine();
        System.out.println("Ingrese correo:");
        String corU= sc.nextLine();
        String contU="";
        String hashU="";
        
       
        boolean validacion= false;
        for (Vendedor v: vendedores){   
            if(v.getCorreo().equals(corU)){
                validacion=true;
            }
        }      
        if(validacion){
            System.out.println("Correo ya registrado. Ingresar un correo nuevo.");
        }
        else{
            System.out.println("Ingresar contrasena:  ");
            contU= sc.nextLine();
            hashU= Usuario.generarHash(contU);
            //correosVendedores.add(corU);
            //Vendedor ven= new Vendedor(nomU,apeU,orgU,corU,hashU);
            //vendedores.add(ven); 
        
            String rutaArchivo = "vendedores.txt";

            try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(rutaArchivo), true))){
            pw.println(nomU+"-"+apeU+"-"+orgU+"-"+corU+"-"+hashU);
            
            }catch(Exception e){
            System.out.println(e.getMessage());
            }
        
            System.out.println(nomU+"-"+apeU+"-"+orgU+"-"+corU+"-"+hashU);
        }
        
    }
    
    public void nuevoVehiculoV(){
        
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresar correo electronico:  ");
        String correoU= sc.nextLine();
        boolean validacion= validarCorreo(correoU);
        if (validacion){
            System.out.println("Ingresar clave:  ");
            String claveU= sc.nextLine();
            String Hashu= Vehiculo.generarHash(claveU);
        }     
        
        System.out.println("Que tipo de vehiculo va a ingresar? a.AUTO, b.CAMIONETA, c.MOTO ");
        String tipo= sc.nextLine();
        
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
        
        if(tipo.equals("a") || tipo.equals("b")){
            System.out.println("El carro tiene vidrio? SI / NO:");
            String vidU= sc.nextLine();
            System.out.println("Ingrese la transmision:");
            String tranU= sc.nextLine();
            
            String rutaArchivo = "vehiculo.txt";

            try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(rutaArchivo), true))){
            pw.println("AUTO-"+marcaU+"-"+modeloU+"-"+motorU+"-"+anioU+"-"+recorridoU+"-"+colorU+"-"+combustibleU+"-"+precioU+"-"+vidU+"-"+tranU);

            }catch(Exception e){
            System.out.println(e.getMessage());
            }    
            
            if(tipo.equals("b")){
                System.out.println("Ingrese la traccion:");
                String traccU= sc.nextLine();
   

                try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(rutaArchivo), true))){
                pw.println("CAMIONETA-"+marcaU+"-"+modeloU+"-"+motorU+"-"+anioU+"-"+recorridoU+"-"+colorU+"-"+combustibleU+"-"+precioU+"-"+vidU+"-"+tranU+"-"+traccU);

                }catch(Exception e){
                System.out.println(e.getMessage());
        }
            }
        
            
        }
 
        String rutaArchivo = "vehiculo.txt";

        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(rutaArchivo), true))){
        pw.println("MOTO-"+marcaU+"-"+modeloU+"-"+motorU+"-"+anioU+"-"+recorridoU+"-"+colorU+"-"+combustibleU+"-"+precioU);

        }catch(Exception e){
        System.out.println(e.getMessage());
        }
    }
    
    
    
    
    public void registrarComprador(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Ingrese Nombre:");
        String nomU= sc.nextLine();
        System.out.println("Ingrese Apellido:");
        String apeU= sc.nextLine();
        System.out.println("Ingrese organizacion:");
        String orgU= sc.nextLine();
        System.out.println("Ingrese correo:");
        String corU= sc.nextLine();
        String contU="";
        String hashU="";
        
       
        boolean validacion= false;
        for (Comprador c: compradores){   
            if(c.getCorreo().equals(corU)){
                validacion=true;
            }
        }      
        if(validacion){
            System.out.println("Correo ya registrado. Ingresar un correo nuevo.");
        }
        else{
            System.out.println("Ingresar contrasena:  ");
            contU= sc.nextLine();
            hashU= Usuario.generarHash(contU);
        
            String rutaArchivo = "compradores.txt";

            try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(rutaArchivo), true))){
            pw.println(nomU+"-"+apeU+"-"+orgU+"-"+corU+"-"+hashU);
            
            }catch(Exception e){
            System.out.println(e.getMessage());
            }
        }
        
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
