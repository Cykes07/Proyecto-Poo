/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.pooproyecto.Clases;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 *
 * @author arife
 */
public class Vendedor extends Usuario {

    public Vendedor(String nombre, String apellido, String organizacion, String correo, String clave) {
        super(nombre, apellido, organizacion, correo, clave);
    }

    public Vendedor(){        
    }
    
    @Override
    public ArrayList<Vendedor> readFile(String nomfile) {
        ArrayList<Vendedor> sellers = new ArrayList<>();
        try (Scanner vendedorScanner = new Scanner(new File(nomfile))) {
            while (vendedorScanner.hasNextLine()) {
                String linea = vendedorScanner.nextLine();
                String[] dato = linea.split("-");
                Vendedor v = new Vendedor(dato[0], dato[1], dato[2], dato[3], dato[4]);
                sellers.add(v);
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return sellers;
    }
    @Override
    public boolean validarCorreo(String correo) {
        ArrayList<Vendedor> vendedores = readFile("vendedores.txt");
        for (Vendedor vendedor : vendedores) {
            if (vendedor.getCorreo().equals(correo)) {
                return true; // El correo ya está registrado
            }
        }
        return false; // El correo no está registrado
    }

    @Override
    public boolean validarClave(String correo, String clave) {
        if (validarCorreo(correo)) {
            ArrayList<Vendedor> vendedores = readFile("vendedores.txt");
            for (Vendedor vendedor : vendedores) {
                if (vendedor.getClave().equals(clave)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void registrarVendedor(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Ingrese Nombre:");
        String nomU= sc.nextLine();
        System.out.println("Ingrese Apellido:");
        String apeU= sc.nextLine();
        System.out.println("Ingrese organizacion:");
        String orgU= sc.nextLine();
        System.out.println("Ingrese correo:");
        String corU= sc.nextLine();
        String contU="";
        String hashU="";
        
  
        if(validarCorreo(corU)){
            System.out.println("Correo ya registrado. Ingresar un correo nuevo.");
        }
        else{
            System.out.println("Ingresar contrasena:  ");
            contU= sc.nextLine();
            hashU= Usuario.generarHash(contU);
        
            String rutaArchivo = "vendedores.txt";

            try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(rutaArchivo), true))){
            pw.println(nomU+"-"+apeU+"-"+orgU+"-"+corU+"-"+hashU);
            
            }catch(Exception e){
            System.out.println(e.getMessage());
            }
        
            System.out.println(nomU+"-"+apeU+"-"+orgU+"-"+corU+"-"+hashU);
        }
        
    }
    
    public void nuevoVehiculoV(){
            
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresar correo electronico:  ");
        String correoU= sc.nextLine();

        if (validarCorreo(correoU)){
            System.out.println("Ingresar clave:  ");
            String claveU= sc.nextLine();
            String hashu= Usuario.generarHash(claveU);
            
            if(validarClave(correoU, hashu)){
                System.out.println("Sesión activa");
                System.out.println("Que tipo de vehiculo va a ingresar? a.AUTO, b.CAMIONETA, c.MOTO ");
                String tipo= sc.nextLine();

                System.out.println("Ingresar placa:  ");
                String placaU= sc.nextLine();
                Vehiculo vehiculo = new Vehiculo();
                ArrayList<Vehiculo> vehiculos = vehiculo.readFile("vehiculo.txt");
                for (Vehiculo v: vehiculos){
                    if (v.placa.equals(placaU)){
                        System.out.println("Esta placa ya existe");
                        return;  
                    }
                }
                System.out.println("Ingresar marca:  ");
                String marcaU= sc.nextLine();
                System.out.println("Ingresar modelo:  ");
                String modeloU= sc.nextLine();
                System.out.println("Ingresar tipo de motor:  ");
                String motorU= sc.nextLine();
                System.out.println("Ingresar año:  ");
                String anioU= sc.nextLine();
                System.out.println("Ingresar recorrido:  ");
                String recorridoU= sc.nextLine();
                System.out.println("Ingresar color:  ");
                String colorU= sc.nextLine();
                System.out.println("Ingresar tipo de combustible:  ");
                String combustibleU= sc.nextLine();
                System.out.println("Ingresar precio:  ");
                String precioU= sc.nextLine();     
                String rutaArchivo = "vehiculo.txt";
                
                if(tipo.equals("a") || tipo.equals("b")){
                    System.out.println("El vehiculo tiene vidrio? SI / NO:");
                    String vidU= sc.nextLine();
                    System.out.println("Escriba la transmisión:");
                    String tranU= sc.nextLine();
                    
                    if (tipo.equals("a")){                    
                    
                        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(rutaArchivo), true))){
                            pw.println("AUTO-"+placaU+"-"+marcaU+"-"+modeloU+"-"+motorU+"-"+anioU+"-"+recorridoU+"-"+colorU+"-"+combustibleU+"-"+precioU+"-"+vidU+"-"+tranU+"-"+correoU);
                        }catch(Exception e){
                            System.out.println(e.getMessage());
                        }
                    }    

                    else if(tipo.equals("b")){
                        System.out.println("Ingrese la traccion:");
                        String traccU= sc.nextLine();

                        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(rutaArchivo), true))){
                            pw.println("CAMIONETA-"+placaU+"-"+marcaU+"-"+modeloU+"-"+motorU+"-"+anioU+"-"+recorridoU+"-"+colorU+"-"+combustibleU+"-"+precioU+"-"+vidU+"-"+tranU+"-"+traccU+"-"+correoU);

                        }catch(Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                }else{
            
                    try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(rutaArchivo), true))){
                    pw.println("MOTO-"+placaU+"-"+marcaU+"-"+modeloU+"-"+motorU+"-"+anioU+"-"+recorridoU+"-"+colorU+"-"+combustibleU+"-"+precioU+"-"+correoU);

                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }    
            }
            
        }  
        
        
    }
    
    public void aceptarOferta(){
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n"); 
        System.out.println("Ingresar correo electronico:  ");
        String correoU= sc.nextLine();
        if (validarCorreo(correoU)){
            System.out.println("Ingresar clave:  ");
            String claveU= sc.nextLine();
            Vehiculo v = new Vehiculo();
            String hashu= v.generarHash(claveU);
            
            if(validarClave(correoU, hashu)){
                System.out.println("Sesión activa");
                System.out.println("Ingrese la placa del vehículo: ");
                String placaBus= sc.nextLine();
                Oferta oferta = new Oferta();
                ArrayList<Oferta> ofertas = oferta.readFile("ofertas.txt");
                ArrayList<Oferta> vehiculosofertados = new ArrayList<>();
                for (Oferta o: ofertas){
                    if(o.getPlaca().equals(placaBus)){
                        vehiculosofertados.add(o);
                    }
                }
                if (vehiculosofertados.isEmpty()) {
                    System.out.println("No se encontraron ofertas con la placa ingresada.");
                    return;
                }
                int posicionActu= 0;
                int numeral=1;
                int opc;
                
                System.out.println("\nSe han realizado "+ vehiculosofertados.size() +" ofertas");
                
                do {
                    Oferta o = vehiculosofertados.get(posicionActu);

                    System.out.println("\nOferta #" + numeral + " de " + vehiculosofertados.size() + "\n");
                    System.out.println(o.marca + "  " + o.modelo + "  Precio:" + o.precio + "\nCorreo: " + correoU + ", Precio Ofertado: " + o.precioOfertado + "\n");

                    if (posicionActu == 0) {
                        System.out.println("1. Siguiente oferta \n2. Aceptar oferta  \nSeleccionar opcion (solo numero):");
                        opc = sc.nextInt();
                        if (opc == 2)
                            opc = 3;
                    } else if (posicionActu == vehiculosofertados.size() - 1) {
                        System.out.println("1. Anterior oferta   \n2. Aceptar oferta  \nSeleccionar opcion (solo numero):");
                        opc = sc.nextInt();
                        if (opc == 1) {
                            opc = 2;
                        } else if (opc == 2) {
                            opc = 3;
                        }
                    } else {
                        System.out.println("1. Siguiente oferta  \n2. Anterior oferta   \n3. Aceptar oferta  \nSeleccionar opcion (solo numero):");
                        opc = sc.nextInt();
                    }

                    switch (opc) {
                        case 1 -> {
                            if (posicionActu < vehiculosofertados.size() - 1) {
                                posicionActu++;
                                numeral++;
                            } else {
                                System.out.println("-- Estas en el ultimo vehiculo --");
                            }
                        }
                        case 2 -> {
                            if (posicionActu > 0) {
                                posicionActu--;
                                numeral--;
                            } else {
                                System.out.println("-- Estas en el primer vehiculo --");
                            }
                        }
                        case 3 -> {
                            String destinatario = o.correo; // A quien le quieres escribir.
                            String asunto = "Oferta aceptada!";
                            String cuerpo = "La oferta del carro con la placa " + o.placa + " fue aceptada";
                            enviarConGMail(destinatario, asunto, cuerpo);

                            eliminarLineas("ofertas.txt", o.placa);
                            eliminarLineas("vehiculo.txt", o.placa);
                            System.out.println("Oferta aceptada!!");
                        }
                        default -> System.out.println("opcion incorrecta");
                    }
                } while (opc != 3);
            }else{
                System.out.println("Clave incorrecta");
            }    
        }else{
            System.out.println("Correo no registrado");
        }    
    }
    
    private static void enviarConGMail(String destinatario, String asunto, String cuerpo) {
        //La dirección de correo de envío
            String remitente = "chicotabletpoo@gmail.com";
        //La clave de aplicación obtenida según se explica en este artículo:
        String claveemail = "chrjuiqzxztvionz";

        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
        props.put("mail.smtp.user", remitente);
        props.put("mail.smtp.clave", claveemail);    //La clave de la cuenta
        props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
        props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
        props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(remitente));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));   //Se podrían añadir varios de la misma manera
            message.setSubject(asunto);
            message.setText(cuerpo);
                try (Transport transport = session.getTransport("smtp")) {
                    transport.connect("smtp.gmail.com", remitente, claveemail);
                    transport.sendMessage(message, message.getAllRecipients());
                }
        }
        catch (MessagingException me) {
            me.printStackTrace();   //Si se produce un error
        }
    }
        
    public static void eliminarLineas(String nombreArchivo, String textoEliminar) {
        File archivo = new File(nombreArchivo);
        File archivoTemporal = new File("temp.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(archivo));
             BufferedWriter bw = new BufferedWriter(new FileWriter(archivoTemporal))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.contains(textoEliminar)) {
                    bw.write(linea);
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Elimina el archivo original
        archivo.delete();

        // Renombra el archivo temporal al nombre original
        archivoTemporal.renameTo(archivo);
    }
   
}
