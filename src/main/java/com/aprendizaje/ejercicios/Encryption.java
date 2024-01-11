package main.java.com.aprendizaje.ejercicios;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Encryption {
    public static final String CLAVE_MESSAGE = "Ingrese la clave: ";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //scanner.useDelimiter("\n");
        int opcion = 0;

        while (opcion != 3) {
            System.out.print("""
                    --- ENCRIPTADOR ---
                    1. Encriptar un texto
                    2. Desencriptar un texto
                    3. Salir
                    OPCIÓN: 
                    """);
            opcion = getNum(scanner);
            separador();

            switch (opcion) {
                case 1:
                    scanner.nextLine();
                    System.out.println("INGRESE EL TEXTO QUE SERÁ ENCRIPTADO:");
                    String texto = scanner.nextLine();
                
                    System.out.println(CLAVE_MESSAGE);
                    String clave = scanner.nextLine();

                    String newTexto = encriptar(texto, clave);
                    System.out.println("TEXTO ENCRIPTADO: " + newTexto);
                    separador();
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.println("INGRESE EL TEXTO ENCRIPTADO:");
                    String textoEncriptado = scanner.nextLine();

                    System.out.println(CLAVE_MESSAGE);
                    String thisClave = scanner.nextLine();

                    String textoDesencriptado = desencriptar(textoEncriptado, thisClave);
                    System.out.println("TEXTO DESENCRIPTADO: " + textoDesencriptado);
                    separador();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    separador();
                    break;
                default:
                    System.out.println("Error. Ingrese una opción válida");
                    separador();
                    break;
            }
        }
    }

    public static String desencriptar(String textoEncriptado, String clave) {
        StringBuilder textoDesencriptado = new StringBuilder();

        for (int i = 0; i < textoEncriptado.length(); i++) {
            char caracterActual = textoEncriptado.charAt(i);
            char caracterEnClave = clave.charAt(i % clave.length());
            char caracterDesencriptado = (char) (caracterActual / caracterEnClave);
            textoDesencriptado.append(caracterDesencriptado);
        }

        return textoDesencriptado.toString();
    }

    public static String encriptar(String texto, String clave) {
        StringBuilder textoEncriptada = new StringBuilder();

        for (int i = 0; i < texto.length(); i++) {
            char caracterActual = texto.charAt(i);
            char caracterEnClave = clave.charAt(i % clave.length());
            char caracterEncriptado = (char) (caracterActual * caracterEnClave);
            textoEncriptada.append(caracterEncriptado);
        }

        return textoEncriptada.toString();
    }

    public static int getNum(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error de sintaxis: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }

    public static void separador() {
        System.out.println(
            "------------------------------------------------"
        );
    }
}
