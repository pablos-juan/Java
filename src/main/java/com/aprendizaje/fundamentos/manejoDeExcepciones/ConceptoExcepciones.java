package main.java.com.aprendizaje.fundamentos.manejoDeExcepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConceptoExcepciones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Ingresar el numerador: ");
            int numerador = scanner.nextInt();

            System.out.print("Ingrese el denominador: ");
            int denominador = scanner.nextInt();

            int resultado = dividir(numerador, denominador);
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Error. No es posible dividir por cero");
        } catch (InputMismatchException n) {
            System.out.println("Error. Ingrese un número");
        } finally {
            scanner.close();
        }
    }

    /**
     * @return entero, resultado de dividir numerador entre denominador
     * @throws ArithmeticException en caso de división entre cero
     */
    private static int dividir(int numerador, int denominador) throws ArithmeticException {
        if (denominador == 0) {
            throw new ArithmeticException("Error. Intenta dividir por cero");
        }
        return numerador / denominador;
    }
}