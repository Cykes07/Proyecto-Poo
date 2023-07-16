/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.pooproyecto.Clases;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author arife
 */
public class Oferta{
    String placa;
    String marca;
    String modelo;
    String precio;
    String correo;
    String precioOfertado;

    public Oferta(String placa, String marca, String modelo, String precio, String correo, String precioOfertado) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.correo = correo;
        this.precioOfertado = precioOfertado;
    }
    public Oferta() {
        this.placa = "";
        this.marca = "";
        this.modelo = "";
        this.precio = "";
        this.correo = "";
        this.precioOfertado = "";
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPrecio() {
        return precio;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPrecioOfertado() {
        return precioOfertado;
    }
    
    
    public ArrayList<Oferta> readFile(String nomfile) {
        ArrayList<Oferta> oferss= new ArrayList<>();
        try(Scanner sc= new Scanner(new File (nomfile))){
            while(sc.hasNextLine()){
                String linea = sc.nextLine();
                String[] d=linea.split("-");
                Oferta f = new Oferta(d[0],d[1],d[2],d[3],d[4],d[5]);                       
                oferss.add(f);
            }
        }catch (Exception e) {
        System.out.println("Error al leer el archivo: " + e.getMessage());
        }return oferss;
    } 

}