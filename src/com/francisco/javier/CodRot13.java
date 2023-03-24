package com.francisco.javier;
/**
    Encriptación básica utilizando ROT13
   @author FJMV
 */
public class CodRot13 {
    protected static char [] mensajeDesdeConsola;
    //Constante para el desplzamiento de la letra
    private final static int VALOR_DESPLAZAMIENTO = 13;
    //Valores de referencia ASCII no se considera la Ñ
    private final static  int SIZE_ALFABETO = 26;
    private final static int MAYUSCULAS_ASCII = 65;
    private final static int MINUSCULAS_ASCII = 97;

    //Convertimos cadena de entrada en arreglo
    public static void setMensaje(String mensaje){
        mensajeDesdeConsola = mensaje.toCharArray();
    }

    //Recuperamos mensaje codificado
    public static char[] getMensaje() {
        return Rot13.deplazarLetra();
    }

    //clase interna provee del servicio a la clase principal
    private static class Rot13{
        /*
        Será necesario considerar la tabla de valores del codigo ASCII
        Para letras minúsculas los valores inician en el 97
        Para letras mayúsculas los valores inician en el 65
        Cada letra debe desplazarse n posiciones en este caso 13
        */
        private static char[] deplazarLetra() {
            // Mensaje codificado
            char[] msjCodificado = new char[mensajeDesdeConsola.length];

            //Recorremos el arreglo de caracteres
            for (int i = 0; i < mensajeDesdeConsola.length; i++) {
                //Almacenamos el elemento actual de acuerdo a la posición en el array de char
                char elementoActual = mensajeDesdeConsola[i];
                //Este método verifica si el arreglo esta compuesto solo de letras o
                //Sí hay otros elementos distintos los agrega al array sin desplazar
                if (!Character.isLetter(elementoActual)) {
                    msjCodificado[i] = elementoActual;
                    continue;
                }
                boolean letraMayuscula = Character.isUpperCase(elementoActual);
                int newPosition = (((int) elementoActual - (letraMayuscula ? MAYUSCULAS_ASCII : MINUSCULAS_ASCII)) + VALOR_DESPLAZAMIENTO) % SIZE_ALFABETO;
                if (newPosition < 0){
                    newPosition += SIZE_ALFABETO;
                }
                int valAsicii = (letraMayuscula ? MAYUSCULAS_ASCII : MINUSCULAS_ASCII) + newPosition;
                msjCodificado [i] = (char) valAsicii;
            }
            return msjCodificado;
        }

    }

}
