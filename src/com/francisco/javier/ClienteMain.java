package com.francisco.javier;

import java.util.Scanner;
public class ClienteMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String msj = scanner.nextLine();
        Cliente.ejecutarCliente(msj);
    }

}
