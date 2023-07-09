/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyecto.poo.clases;

/**
 *
 * @author mariu
 */
public class Oferta{
    private Vehiculo vehiculo;
    private Comprador comprador;
    private double precio;

    public Oferta(Vehiculo vehiculo, Comprador comprador, double precio) {
        this.vehiculo = vehiculo;
        this.comprador = comprador;
        this.precio = precio;
    }
    
}
