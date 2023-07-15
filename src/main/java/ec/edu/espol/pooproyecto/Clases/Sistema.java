/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.pooproyecto.Clases;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author mariu
 */
public class Sistema {
    private ArrayList<Vendedor> vendedores;
    private ArrayList<Comprador> compradores;
    private ArrayList<Oferta> ofertas;
    private ArrayList<Moto> vehiculos;
    private ArrayList<Moto> vehiculos2;
    

    public Sistema() {
        this.vendedores = (ArrayList<Vendedor>) readFile("vendedores.txt","vendedor");
        this.compradores = (ArrayList<Comprador>) readFile("compradores.txt","comprador");
        this.ofertas = new ArrayList<>();
        this.vehiculos = (ArrayList<Moto>) readFile("vehiculo.txt","vehiculo");
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
    
    public boolean validarCorreo(String correo, String tipo) {
        if (tipo.equals("vendedor")) {
            for (Vendedor v : vendedores) {
                if (v.getCorreo().equals(correo)) {
                    return true;
                }
            }
        } else if (tipo.equals("comprador")) {
            for (Comprador c : compradores) {
                if (c.getCorreo().equals(correo)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean validarClave(String correo, String clave, String tipo) {
        if (tipo.equals("vendedor")) {
            for (Vendedor v : vendedores) {
                if (v.getCorreo().equals(correo)) {
                    return v.getClave().equals(clave);
                }
            }
        } else if (tipo.equals("comprador")) {
            for (Comprador c : compradores) {
                if (c.getCorreo().equals(correo)) {
                    return c.getClave().equals(clave);
                }
            }
        }
        return false;
    }
     
    private ArrayList<?> readFile(String nomfile,String tipo){ //Dependiendo del tipo sale la lista que desea
        ArrayList<?> lista = null;
        try{
        switch (tipo) {
            case "vendedor" -> {
                ArrayList<Vendedor> Sellers = new ArrayList<>();
                try (Scanner vendedorScanner = new Scanner(new File(nomfile))) {
                    while (vendedorScanner.hasNextLine()) {
                        String linea = vendedorScanner.nextLine();
                        String[] dato = linea.split("-");
                        Vendedor v = new Vendedor(dato[0], dato[1], dato[2], dato[3], dato[4]);
                        Sellers.add(v);
                    }
                }   lista = Sellers;
                }
            case "comprador" -> {
                ArrayList<Comprador> buyers = new ArrayList<>();
                try (Scanner compradorScanner = new Scanner(new File(nomfile))) {
                    while (compradorScanner.hasNextLine()) {
                        String linea = compradorScanner.nextLine();
                        String[] dato = linea.split("-");
                        Comprador c = new Comprador(dato[0], dato[1], dato[2], dato[3], dato[4]);
                        buyers.add(c);
                    }
                }   lista = buyers;
                }
            case "vehiculo" -> {
                ArrayList<Moto> vehicles= new ArrayList<>();
                try(Scanner sc= new Scanner(new File (nomfile))){
                    while(sc.hasNextLine()){
                        String linea = sc.nextLine();
                        String[] d=linea.split("-");
                        String type = d[0]; //Sacamos en el archivo tipo de vehiculo
                        Moto v; //Inicializamos aqui para acortar lineas
                        switch (type) {
                            case "AUTO" -> v = new Auto(d[1],d[2],d[3],d[4],d[5],d[6],d[7],d[8],d[9],d[10],d[11]);
                            case "CAMIONETA" -> v = new Camioneta(d[1],d[2],d[3],d[4],d[5],d[6],d[7],d[8],d[9],d[10],d[11],d[12]);
                            case "MOTO" -> v = new Moto(d[1],d[2],d[3],d[4],d[5],d[6],d[7],d[8],d[9]); //Este es moto
                            default -> {
                                continue; //Ignoramos lineas de tipos desconocidos
                            }
                        }
                        vehicles.add(v);
                    }
                } lista = vehicles;
            }
            default -> System.out.println("Tipo inválido");
        }
    } catch (Exception e) {
        System.out.println("Error al leer el archivo: " + e.getMessage());
        lista = new ArrayList<>(); 
    }
    return lista;
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
        
       
        boolean validacion= validarCorreo(corU,"vendedor");
        if(validacion){
            System.out.println("Correo ya registrado. Ingresar un correo nuevo.");
        }
        else{
            System.out.println("Ingresar contrasena:  ");
            contU= sc.nextLine();
            hashU= Usuario.generarHash(contU);
        
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
        boolean validacion= validarCorreo(correoU,"vendendor");
        if (validacion){
            System.out.println("Ingresar clave:  ");
            String claveU= sc.nextLine();
            String hashu= Moto.generarHash(claveU);
            
            if(validarClave(correoU, hashu,"vendendor")){
                System.out.println("Sesión activa");
                System.out.println("Que tipo de vehiculo va a ingresar? a.AUTO, b.CAMIONETA, c.MOTO ");
                String tipo= sc.nextLine();

                System.out.println("Ingresar placa:  ");
                String placaU= sc.nextLine();
                for (Moto vehiculo: vehiculos){
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
                String anioU= sc.nextLine();
                System.out.println("Ingresar recorrido:  ");
                String recorridoU= sc.nextLine();
                System.out.println("Ingresar color:  ");
                String colorU= sc.nextLine();
                System.out.println("Ingresar tipo de combustible:  ");
                String combustibleU= sc.nextLine();
                System.out.println("Ingresar precio:  ");
                String precioU= sc.nextLine();     
                String rutaArchivo = "vehiculo.txt";
                
                if(tipo.equals("a") || tipo.equals("b")){
                    System.out.println("El vehiculo tiene vidrio? SI / NO:");
                    String vidU= sc.nextLine();
                    System.out.println("Escriba la transmisión:");
                    String tranU= sc.nextLine();
                    
                    if (tipo.equals("a")){                    
                    
                        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(rutaArchivo), true))){
                            pw.println("AUTO-"+placaU+"-"+marcaU+"-"+modeloU+"-"+motorU+"-"+anioU+"-"+recorridoU+"-"+colorU+"-"+combustibleU+"-"+precioU+"-"+vidU+"-"+tranU);
                        }catch(Exception e){
                            System.out.println(e.getMessage());
                        }
                    }    

                    else if(tipo.equals("b")){
                        System.out.println("Ingrese la traccion:");
                        String traccU= sc.nextLine();

                        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(rutaArchivo), true))){
                            pw.println("CAMIONETA-"+placaU+"-"+marcaU+"-"+modeloU+"-"+motorU+"-"+anioU+"-"+recorridoU+"-"+colorU+"-"+combustibleU+"-"+precioU+"-"+vidU+"-"+tranU+"-"+traccU);

                        }catch(Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                }else{
            
                    try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(rutaArchivo), true))){
                    pw.println("MOTO-"+placaU+"-"+marcaU+"-"+modeloU+"-"+motorU+"-"+anioU+"-"+recorridoU+"-"+colorU+"-"+combustibleU+"-"+precioU);

                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }    
            }
            
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
 
    public ArrayList<Moto> filtarVehiculo(){
       Scanner sc = new Scanner(System.in);
       sc.useDelimiter("\n"); 
       sc.useLocale(Locale.US);
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
       ArrayList<Moto> vehiculosFiltrados = new ArrayList<>();
       
       for (Moto v: vehiculos){ //getSimpleName escribe el nombre de la clase y ignorecase hace equals sin importar mayus o minus
           if(v.getClass().getSimpleName().equalsIgnoreCase(tipoVEH)&&  //Cada linea son el min y max 
                   Integer.parseInt(v.getRecorrido()) >= recorridoMin && Integer.parseInt(v.getRecorrido()) <= recorridoMax 
                   && Integer.parseInt(v.getAnio()) >= anioMin && Integer.parseInt(v.getAnio()) <= anioMax
                   && Integer.parseInt(v.getPrecio()) >= precioMin && Integer.parseInt(v.getPrecio()) <= precioMax){
                    vehiculosFiltrados.add(v);
            }   
       }
       return vehiculosFiltrados;
   }

    public void mostrarVehiculo(ArrayList<Moto> vehiculo, int indice){
        Moto v = vehiculo.get(indice);
        System.out.println("Tipo: " + v.getClass().getSimpleName());
        System.out.println("Marca: " + v.getMarca());
        System.out.println("Modelo: " + v.getModelo());
        System.out.println("Placa: " + v.getPlaca());
        System.out.println("Precio: " + v.getPrecio());
        System.out.println("Recorrido: " + v.getRecorrido());
        System.out.println("Año: " + v.getAnio());
    }
   
    public void ofertarVehiculo (){  //La idea es que vaya mostrando en pantalla con indices los vehiculos, ya que que este debe volver
        Scanner sc =new Scanner(System.in);
        sc.useDelimiter("\n"); 
        System.out.println("Ingresar correo electronico:  ");
        String correoU= sc.nextLine();
        boolean validacion= validarCorreo(correoU,"Comprador");
        
        if (validacion){
            System.out.println("Ingresar clave:  ");
            String claveU= sc.nextLine();
            String hashu= Moto.generarHash(claveU);
            
            if(validarClave(correoU, hashu,"comprador")){
                ArrayList <Moto> vehiculosFiltrados = filtarVehiculo();
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
                            Moto v = vehiculosFiltrados.get(indice);
                            System.out.println("Insertar precio a oferta:");
                            int precioOfertado= sc.nextInt();

                            String rutaArchivo = "ofertas.txt";

                            try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(rutaArchivo), true))){
                                pw.println(v.getPlaca()+"-"+v.getMarca()+"-"+v.getModelo()+"-"+v.getPrecio()+"-"+correoU+"-"+precioOfertado);
                            }catch(Exception e){
                                System.out.println(e.getMessage());
                                }


                           System.out.println("\n Gracias por ofertar!! ");

                        }
                        case 4 -> System.out.println("Hasta luego");
                        default -> {
                            System.out.println("\n");
                            System.out.println("Escoga una opcion valida");
                        }

                    }

                }while(opcion!=4);
            }
        }
    }
    
    
    
    public void aceptarOferta(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresar correo electronico:  ");
        String correoU= sc.nextLine();
        boolean validacion= validarCorreo(correoU,"vendendor");
        if (validacion){
            System.out.println("Ingresar clave:  ");
            String claveU= sc.nextLine();
            String hashu= Moto.generarHash(claveU);
            
            if(validarClave(correoU, hashu, "comprador")){
                System.out.println("Sesión activa");
                System.out.println("Ingrese la placa del vehículo: ");

            }    
        }    
    }
}