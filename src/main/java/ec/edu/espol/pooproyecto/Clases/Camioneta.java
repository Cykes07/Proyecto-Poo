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
public class Camioneta extends Vehiculo{
    private String vidrio;
    private String transmision;
    private String traccion;

    public Camioneta(String placa, String marca, String modelo, String tipoMotor, String anio, String recorrido, String color, String tipoCombustible, String precio, String vidrio, String transmision, String traccion,String correoVendedor) {
        super(placa, marca, modelo, tipoMotor, anio, recorrido, color, tipoCombustible, precio, correoVendedor);
        this.vidrio = vidrio;
        this.transmision = transmision;
        this.traccion = traccion;
    }

    

}



