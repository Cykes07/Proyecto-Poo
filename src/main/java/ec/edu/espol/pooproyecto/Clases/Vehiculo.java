/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.pooproyecto.Clases;
import java.util.ArrayList;

/**
 *
 * @author arife
 */
public class Vehiculo {
    private String placa;
    private String marca;
    private String modelo;
    private String tipoMotor;
    private int anio;
    private int recorrido;
    private String color;
    private String tipoCombustible;
    private double precio;
    private Vendedor vendedor;
    private ArrayList<Oferta> ofertas;

    public Vehiculo(String placa, String marca, String modelo, String tipoMotor, int anio, int recorrido, String color, String tipoCombustible, double precio, Vendedor vendedor, ArrayList<Oferta> ofertas) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.tipoMotor = tipoMotor;
        this.anio = anio;
        this.recorrido = recorrido;
        this.color = color;
        this.tipoCombustible = tipoCombustible;
        this.precio = precio;
        this.vendedor = vendedor;
        this.ofertas = ofertas;
    }
    
    
}
