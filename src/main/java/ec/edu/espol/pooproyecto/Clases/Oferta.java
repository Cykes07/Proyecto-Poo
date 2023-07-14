/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.pooproyecto.Clases;

/**
 *
 * @author arife
 */
public class Oferta{
    private Moto vehiculo;
    private Comprador comprador;
    private double precio;

    public Oferta(Moto vehiculo, Comprador comprador, double precio) {
        this.vehiculo = vehiculo;
        this.comprador = comprador;
        this.precio = precio;
    }
    
    @Override
    public String toString(){
        return "Correo: "+comprador.getCorreo()+"\n Precio ofertado: "+this.precio;  
    }
    
}
