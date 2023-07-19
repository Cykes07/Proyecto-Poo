/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.pooproyecto.Clases;

import java.util.ArrayList;
import java.util.Scanner;

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
        this.vehiculosFiltrados= new ArrayList<>();
        this.vehiculosOfertados= new ArrayList<>();
    }
    
    public void menuOpciones() {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            mostrarOpciones();
            System.out.println("Escoge una opción: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    menuVendedor();
                    break;
                case 2:
                    menuComprador();
                    break;
                case 3:
                    System.out.println("Hasta luego");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 3);
    }
    
   public void menuVendedor() {
        mostrarVendedor();
        Scanner sc = new Scanner(System.in);
        System.out.println("Escoge una opción: ");
        int opc = sc.nextInt();
        switch (opc) {
            case 1:
                vendedor.registrarVendedor();
                break;
            case 2:
                vendedor.nuevoVehiculoV();
                break;
            case 3:
                vendedor.aceptarOferta();
                break;
            case 4:
                
                break;
            default:
                System.out.println("Opción inválida");
        }
    }

    public void menuComprador() {
        mostrarComprador();
        Scanner sc = new Scanner(System.in);
        System.out.println("Escoge una opción: ");
        int op = sc.nextInt();
        switch (op) {
            case 1:
                comprador.registrarComprador();
                break;
            case 2:
                comprador.ofertarVehiculo();
                break;
            case 3:
           
                break;
            default:
                System.out.println("Opción inválida");
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


}