/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.pooproyecto.Clases;
import java.io.File;
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
    private String correoVendedor;

    
    public Vehiculo(String placa, String marca, String modelo, String tipoMotor, String anio, String recorrido, String color, String tipoCombustible, String precio, String correoVendedor) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.tipoMotor = tipoMotor;
        this.anio = anio;
        this.recorrido = recorrido;
        this.color = color;
        this.tipoCombustible = tipoCombustible;
        this.precio = precio;
        this.correoVendedor=correoVendedor;
    }
    public Vehiculo(){  
        this.placa = "";
        this.marca = "";
        this.modelo = "";
        this.tipoMotor = "";
        this.anio = "";
        this.recorrido = "";
        this.color = "";
        this.tipoCombustible = "";
        this.precio = "";
    }
    
    public  String generarHash(String input) {
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
    public ArrayList<Vehiculo> readFile(String nomfile){
        ArrayList<Vehiculo> vehicles= new ArrayList<>();
        try(Scanner sc= new Scanner(new File (nomfile))){
            while(sc.hasNextLine()){
                String linea = sc.nextLine();
                String[] d=linea.split("-");
                String type = d[0]; //Sacamos en el archivo tipo de vehiculo
                Vehiculo v; //Inicializamos aqui para acortar lineas
                switch (type) {
                    case "AUTO" -> v = new Auto(d[1],d[2],d[3],d[4],d[5],d[6],d[7],d[8],d[9],d[10],d[11],d[12]);
                    case "CAMIONETA" -> v = new Camioneta(d[1],d[2],d[3],d[4],d[5],d[6],d[7],d[8],d[9],d[10],d[11],d[12],d[13]);
                    case "MOTO" -> v = new Moto(d[1],d[2],d[3],d[4],d[5],d[6],d[7],d[8],d[9],d[10]); //Este es moto
                    default -> {
                        continue; //Ignoramos lineas de tipos desconocidos
                    }
                }
                vehicles.add(v);
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }return vehicles;
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
