package com.francisco.javier;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        DataInputStream entrada;
        DataOutputStream salida;
        try{
            System.out.println("Sevidor iniciado");
            ServerSocket servidor = new ServerSocket(23);
            while(true){
                Socket cliente = servidor.accept();
                entrada = new DataInputStream(cliente.getInputStream());
                salida = new DataOutputStream(cliente.getOutputStream());
                String msjcliente = entrada.readUTF();
                String datos = scanner.next();//entrada.readLine();
                //imprimer dato recibido del lado del cliente
                salida.writeUTF(datos);
                //cerramos conexión
                cliente.close();
                System.out.println("Información recibida del cliente: " + msjcliente);
            }
            //sudo apt install telnetd -y
            //sudo systemctl status inetd
        }
        catch (IOException ex){
            System.out.println(ex);
        }
    }
}
