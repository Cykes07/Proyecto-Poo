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
public class Auto extends Moto{
    private String vidrio;
    private String transmision;

    public Auto(String placa, String marca, String modelo, String tipoMotor, String anio, String recorrido, String color, String tipoCombustible, String precio, String vidrio, String transmision) {
        super(placa, marca, modelo, tipoMotor, anio, recorrido, color, tipoCombustible, precio);
        this.vidrio = vidrio;
        this.transmision = transmision;
    }
}
