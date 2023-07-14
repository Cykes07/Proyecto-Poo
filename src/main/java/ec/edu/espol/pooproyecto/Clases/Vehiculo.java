/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.pooproyecto.Clases;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author arife
 */
public class Vehiculo {
    protected String placa;
    private String marca;
    private String modelo;
    private String tipoMotor;
    private String anio;
    private String recorrido;
    private String color;
    private String tipoCombustible;
    private String precio;
    private Vendedor vendedor;

    public Vehiculo(String placa) {
        this.placa = placa;
    }
    
    public Vehiculo(String placa, String marca, String modelo, String tipoMotor, String anio, String recorrido, String color, String tipoCombustible, String precio) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.tipoMotor = tipoMotor;
        this.anio = anio;
        this.recorrido = recorrido;
        this.color = color;
        this.tipoCombustible = tipoCombustible;
        this.precio = precio;
    }
    
     public static String generarHash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
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

    public String getTipoMotor() {
        return tipoMotor;
    }

    public String getAnio() {
        return anio;
    }

    public String getRecorrido() {
        return recorrido;
    }

    public String getColor() {
        return color;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public String getPrecio() {
        return precio;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }
     
}
