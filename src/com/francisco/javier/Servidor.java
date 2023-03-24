package com.francisco.javier;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void lanzarServer(){
        DataInputStream entrada;
        DataOutputStream salida;
        try{
            System.out.println("Sevidor iniciado");
            /*
                Esta clase implementa sockets de servidor.
                Un socket de servidor espera que lleguen solicitudes a través de la red.
                Realiza alguna operación basada en esa solicitud y devuelve un
                resultado al solicitante.
             */
            ServerSocket servidor = new ServerSocket(8089);
            while(true){
                Socket cliente = servidor.accept();
                entrada = new DataInputStream(cliente.getInputStream());
                salida = new DataOutputStream(cliente.getOutputStream());
                //Leemos datos del cliente
                String mensajeCliente = entrada.readUTF();
                CodRot13.setMensaje(mensajeCliente);
                //Enviamos el mensaje al cliente codificado
                salida.writeUTF(String.valueOf(CodRot13.getMensaje()));
                //cerramos conexión
                cliente.close();
                System.out.println("Información recibida: " + mensajeCliente);
            }
            //sudo apt install telnetd -y
            //sudo systemctl status inetd
        }
        catch (IOException ex){
            System.out.println("Ha ocurrido una excepción: " + ex.getMessage());
        }
    }

}
