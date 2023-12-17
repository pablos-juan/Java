package main.java.com.aprendizaje.fundamentos.estructurasDeControl;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Function;

public class Condicionales {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int edad = getNumero(scanner);

        //condicional simple
        String tipoPersona = validarEdad(edad);

        //operadores ternarios
        //TipoDeDato = condición ? valor_si_verdadero : valor_si_falso
        String mensaje = (edad % 2 == 0) ? "Es par" : "Es impar";

        //operadores ternarios junto a expresiones lambda
        Function<Integer, String> clasificarNumero = n -> (n % 2 == 0) ? "Par" : "Impar";

        System.out.println(edad + ": " +mensaje);
        System.out.println("Es par: " + clasificarNumero);
        System.out.println("Tipo de persona: " + tipoPersona);
    }

    //condicionales en una función
    public static String validarEdad(int edad) {
        //ciclo if clásico
        if (edad < 18) {
            return "Eres menor de edad";
        } else if (edad < 65) {
            return "Eres adulto";
        } else return "Eres un adulto mayor";
    }

    public static int getNumero(Scanner scanner) {
        System.out.print("Escriba un número: ");
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error. Ingrese un número");
                scanner.nextLine();
            }
        }
    }
}
