/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.pooproyecto.Clases;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author arife
 */
public class Comprador extends Usuario{

    public Comprador(String nommbre, String apellido, String organizacion, String correo, String clave) {
        super(nommbre, apellido, organizacion, correo, clave);
    }

    public Comprador(){        
    }

    @Override
    public ArrayList<Comprador> readFile(String nomfile) {
        ArrayList<Comprador> buyers = new ArrayList<>();
        try (Scanner compradorScanner = new Scanner(new File(nomfile))) {
            while (compradorScanner.hasNextLine()) {
                String linea = compradorScanner.nextLine();
                String[] dato = linea.split("-");
                Comprador c = new Comprador(dato[0], dato[1], dato[2], dato[3], dato[4]);
                buyers.add(c);
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return buyers;
    }
    @Override
    public boolean validarCorreo(String correo){
        ArrayList<Comprador> compradores = readFile("compradores.txt");
        for (Comprador comprador : compradores) {
            if (comprador.getCorreo().equals(correo)) {
                return true; // El correo ya está registrado
            }
        }
        return false; // El correo no está registrado
    }
    @Override
    public boolean validarClave(String correo, String clave) {
        if (validarCorreo(correo)) {
            ArrayList<Comprador> compradores = readFile("compradores.txt");
            for (Comprador comprador : compradores) {
                if (comprador.getClave().equals(clave)) {
                    return true;
                }
            }
        }
        return false;
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
        
              
        if(validarCorreo(corU)){
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
   
    public void ofertarVehiculo (){  
        Scanner sc =new Scanner(System.in);
        sc.useDelimiter("\n"); 
        System.out.println("Ingresar correo electronico:  ");
        String correoU= sc.nextLine();
        
        if (validarCorreo(correoU)){
            System.out.println("Ingresar clave:  ");
            String claveU= sc.nextLine();
            String hashu= Usuario.generarHash(claveU);
            
            if(validarClave(correoU, hashu)){
                ArrayList<Vehiculo> vehiculosFiltrados = filtarVehiculo();
                if (vehiculosFiltrados.isEmpty()) { //Verificamos la lista si esta vacia
                    System.out.println("No se encontraron vehículos con los criterios de búsqueda ingresados.");
                    return;
                }
                int opcion;
                int indice = 0;

                do{
                    mostrarVehiculo(vehiculosFiltrados, indice);
                    System.out.println("\nEscoga una  opcion:");
                    System.out.println("1. Siguiente Vehículo");
                    System.out.println("2. Anterior Vehículo");
                    System.out.println("3. Ofertar");
                    System.out.println("4. Regresar");
                    opcion = sc.nextInt();
                    switch(opcion){
                        case 1 -> {
                            if(indice < vehiculosFiltrados.size()-1){
                                indice ++;
                                System.out.println("\n");
                                mostrarVehiculo(vehiculosFiltrados, indice);    
                            }else{
                                System.out.println("No hay más vehículos que mostrar");
                            }
                        }
                        case 2 -> {
                            if(indice > 0){
                                indice--;
                                System.out.println("\n");
                                mostrarVehiculo(vehiculosFiltrados, indice);    
                            }else{
                                System.out.println("\n");
                                System.out.println("No hay vehículos anteriores");
                                mostrarVehiculo(vehiculosFiltrados, indice); // Como es 0 vuelve a mostrar lo mismo
                            }
                        }
                        case 3 -> {
                            Vehiculo v = vehiculosFiltrados.get(indice);
                            System.out.println("Insertar precio a oferta:");
                            int precioOfertado= sc.nextInt();

                            String rutaArchivo = "ofertas.txt";

                            try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(rutaArchivo), true))){
                                pw.println(v.getPlaca()+"-"+v.getMarca()+"-"+v.getModelo()+"-"+v.getPrecio()+"-"+correoU+"-"+precioOfertado);
                            }catch(Exception e){
                                System.out.println(e.getMessage());
                                }


                           System.out.println("\n Gracias por ofertar!! ");
                           opcion = 4;

                        }
                        case 4 -> {
                            System.out.println("Hasta luego");
                            opcion = 4;
                        }
                        default -> {
                            System.out.println("\n");
                            System.out.println("Escoga una opcion valida");
                        }

                    }

                }while(opcion!=4);
            }else{
                System.out.println("Contraseña Incorrecta");
            }
        }
    }
    public ArrayList<Vehiculo> filtarVehiculo(){
       Scanner sc = new Scanner(System.in);
       sc.useDelimiter("\n"); 
       sc.useLocale(Locale.US);
       ArrayList<Vehiculo> vehiculosFiltrados = new ArrayList<>();
       System.out.println("Ingresar tipo de vehiculo:  ");
       String tipoVEH= sc.nextLine();
       System.out.println("Ingresar recorrido desde:  ");
       String rmin = sc.nextLine();
       int recorridoMin = rmin.isEmpty() ?  Integer.MIN_VALUE : Integer.parseInt(rmin);
       System.out.println(", hasta:  ");
       String rmax = sc.nextLine();
       int recorridoMax = rmax.isEmpty() ?  Integer.MAX_VALUE : Integer.parseInt(rmax);
       System.out.println("Ingresar año desde:  ");
       String amin = sc.nextLine();
       int anioMin = amin.isEmpty() ?  Integer.MIN_VALUE : Integer.parseInt(amin); //MAX VALUE es el mayor valor de double
       System.out.println(", hasta:  ");
       String amax = sc.nextLine();
       int anioMax= amax.isEmpty() ?  Integer.MAX_VALUE : Integer.parseInt(amax); // MIN VALUE es el menor valor de double
       System.out.println("Ingresar precio desde:  ");
       String pmin = sc.nextLine();
       double precioMin = pmin.isEmpty() ?  Double.MIN_VALUE : Double.parseDouble(pmin); // condicion ? valor si es true : valor si es false. 
       System.out.println(", hasta:  ");
       String pmax = sc.nextLine();
       double precioMax = pmax.isEmpty() ?  Double.MAX_VALUE : Double.parseDouble(pmax); // condicion ? valor si es true : valor si es false.
       Vehiculo vehiculo = new Vehiculo();
       ArrayList<Vehiculo> vehiculos = vehiculo.readFile("vehiculo.txt");
       for (Vehiculo v: vehiculos){ //getSimpleName escribe el nombre de la clase y ignorecase hace equals sin importar mayus o minus
           if(v.getClass().getSimpleName().equalsIgnoreCase(tipoVEH)&&  //Cada linea son el min y max 
                   Integer.parseInt(v.getRecorrido()) >= recorridoMin && Integer.parseInt(v.getRecorrido()) <= recorridoMax 
                   && Integer.parseInt(v.getAnio()) >= anioMin && Integer.parseInt(v.getAnio()) <= anioMax
                   && Integer.parseInt(v.getPrecio()) >= precioMin && Integer.parseInt(v.getPrecio()) <= precioMax){
                    vehiculosFiltrados.add(v);
            }   
       }
       return vehiculosFiltrados;
   }
    
    public void mostrarVehiculo(ArrayList<Vehiculo> vehiculo, int indice){
        Vehiculo v = vehiculo.get(indice);
        System.out.println("Tipo: " + v.getClass().getSimpleName());
        System.out.println("Marca: " + v.getMarca());
        System.out.println("Modelo: " + v.getModelo());
        System.out.println("Placa: " + v.getPlaca());
        System.out.println("Precio: " + v.getPrecio());
        System.out.println("Recorrido: " + v.getRecorrido());
        System.out.println("Año: " + v.getAnio());
    }
}
