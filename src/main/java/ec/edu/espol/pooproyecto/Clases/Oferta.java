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
}