/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.pooproyecto.Clases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Properties;
import java.util.Scanner;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author 
 */
public class Sistema {
    private Vendedor vendedor;
    private Comprador comprador;
    private ArrayList<Oferta> ofertas;
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Oferta> vehiculosOfertados;
    private ArrayList<Vehiculo> vehiculosFiltrados;
     private ArrayList<Vendedor> vendedores;


    public Sistema() {
        this.vendedores = new ArrayList<>();
        this.vendedor = new Vendedor();
        this.comprador = new Comprador();
//        this.ofertas = (ArrayList<Oferta>) readFile("ofertas.txt","oferta");
//        this.vehiculos = (ArrayList<Moto>) readFile("vehiculo.txt","vehiculo");
        this.vehiculosFiltrados= new ArrayList<>();
        this.vehiculosOfertados= new ArrayList<>();
    }
    
    public void menuOpciones(){
        Scanner sc = new Scanner(System.in);
        mostrarOpciones();
        System.out.println("Escoge una opción: ");
        int opcion = sc.nextInt();
        switch(opcion){
            case 1 -> menuVendedor();
            //Menu vendedor
            case 2 -> menuComprador();
            //Menu Comprador
            case 3 -> System.out.println("Hasta luego");
        }
    }
    
    public void menuVendedor(){
        mostrarVendedor();
        Scanner sc = new Scanner(System.in);
        System.out.println("Escoge una opción: ");
        int opcion = sc.nextInt();
        switch(opcion){
            case 1 -> vendedor.registrarVendedor();
            case 2 -> vendedor.nuevoVehiculoV();
            case 3 -> vendedor.aceptarOferta();
            case 4 -> menuOpciones();
        }
    }
    
    public void menuComprador(){
        mostrarComprador();
        Scanner sc = new Scanner(System.in);
        System.out.println("Escoge una opción: ");
        int opcion = sc.nextInt();
        switch(opcion){
            case 1 -> comprador.registrarComprador();
            case 2 -> comprador.ofertarVehiculo();
            case 3 -> menuOpciones();
        }
        //registrar un nuevo comprador
        //ofertar por un vehiculo
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


}