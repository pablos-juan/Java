package main.java.com.aprendizaje.fundamentos.estructurasDeControl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int day = getNumero(scanner);

        //expresiones switch (desde Java 12)
        String dayType = switch (day) {
            case 1, 2, 3, 4, 5 -> "Laborable";
            case 6, 7 -> "Fin de semana";
            default -> throw new IllegalArgumentException("Día no válido: " + day);
        };

        //bloques de código y 'yield' en switch expressions
        int mes = getNumero(scanner);
        int dias = switch (mes) {
            //cuántos días tiene cada mes
            case 4, 6, 9, 11 -> 30;
            case 2 -> {
                int year = getNumero(scanner);
                //comprobar si es bisiesto
                boolean esBisiesto = (year % 4 == 0 && year % 100 != 0) 
                                    || year % 400 == 0;
                //expresión ternaria
                //si es bisiesto el mes tiene 29 días, sino tiene 28
                yield esBisiesto ? 29 : 28;
            }
            default -> 31;
        };

        //uso de 'enum' para switch expressions
        enum DayOfWeek { //enum para valores fijos
            LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO
        }

        DayOfWeek dia = DayOfWeek.MARTES;

        switch (dia) {
            case LUNES -> System.out.println("Lunes, haz lo mínimo");
            case MARTES -> System.out.println("Martes, tómalo con calma");
            case MIERCOLES -> System.out.println("Miércoles, mejor no matarse");
            case JUEVES -> System.out.println("Jueves para la joda");
            case VIERNES -> System.out.println("Día de salud mental");
            case SABADO, DOMINGO -> System.out.println("Fin de semana");
        }

        //devolver un valor o una cadena de texto directamente
        System.out.println(
                switch (dia) {
                    case LUNES, MARTES, MIERCOLES -> "Inicio de semana";
                    case JUEVES, VIERNES -> "Casi fin de semana";
                    case SABADO, DOMINGO -> "Fin de semana";
                }
        );

        System.out.println("Tipo de día: " + dayType);
        System.out.println("El mes tiene " + dias + " días");
        System.out.println("Estación: " + getEstacion(day));
    }

    //switch expressions en una función
    public static String getEstacion(int mes) {
        //estaciones según el mes
        return switch (mes) {
            case 12, 1, 2 -> "Invierno";
            case 3, 4, 5 -> "Primavera";
            case 6, 7, 8 -> "Verano";
            case 9, 10, 11 -> "Otoño";
            default -> "mes no válido";
        };
    }

    public static int getNumero(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Ingrese un número: ");
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error. Ingrese un número");
                scanner.nextLine();
            }
        }
    }
}
