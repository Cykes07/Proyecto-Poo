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
public class Auto extends Vehiculo{
    private String vidrio;
    private String transmision;

    public Auto(String vidrio, String transmision, String placa, String marca, String modelo, String tipoMotor, int anio, int recorrido, String color, String tipoCombustible, double precio, Vendedor vendedor, ArrayList<Oferta> ofertas) {
        super(placa, marca, modelo, tipoMotor, anio, recorrido, color, tipoCombustible, precio, vendedor, ofertas);
        this.vidrio = vidrio;
        this.transmision = transmision;
    }
}
