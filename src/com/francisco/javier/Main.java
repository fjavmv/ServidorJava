package com.francisco.javier;

import java.awt.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        String dato = scanner.nextLine();
        Servidor.lanzarServer(dato);

    }
}
