package main.java.com.aprendizaje.ejerciciosPruebasTecnicas;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PruebaTeatro {
    public static final char ASIENTO_OCUPADO = 'X', ASIENTO_LIBRE = 'L';
    public static final int LONGITUD = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] teatro = new char[LONGITUD][LONGITUD];
        int opcion;
        cargarMatriz(teatro);

        do {
            System.out.print("""
                    --> BIENVENIDO AL TEATRO <--
                    1. RESERVAR UN ASIENTO
                    2. MOSTRAR TODOS LOS ASIENTOS
                    3. SALIR
                    """);
            System.out.print("Opción: ");
            opcion = validarNumero(scanner);
            separador();

            switch (opcion) {
                case 1:
                    System.out.println("RESERVAR UN ASIENTO:");
                    asignarAsiento(teatro, scanner);
                    separador();
                    break;
                case 2:
                    System.out.println("ASIENTOS DEL TEATRO:");
                    mostrarAsientos(teatro);
                    separador();
                    break;
                case 3:
                    System.out.println("SALIENDO...");
                    break;
                default:
                    System.out.println("Error. Ingrese una opción válida");
                    separador();
                    break;
            }
        } while(opcion != 3);
    }

    public static void mostrarAsientos(char[][] matriz) {
        System.out.println("""
                Los asientos ocupados están marcados con una X,
                Los asientos libres están marcados con una L.
                """);
        for (char[] chars : matriz) {
            for (int j=0; j<matriz.length; j++) {
                System.out.print(chars[j] + " ");
            }
            System.out.println();
        }
    }

    public static void asignarAsiento(char[][] matriz, Scanner scanner) {
        System.out.println("""
                Para reservar un asiento, seleccione una de las 10 filas.
                Cada fila tiene 10 asientos, seleccione uno.
                """);
        while (true) {
            System.out.print("FILA: ");
            int fila = validarPosicion(scanner);
            System.out.print("COLUMNA: ");
            int columna = validarPosicion(scanner);

            if (asientoValido(matriz, fila, columna)) {
                matriz[fila][columna] = ASIENTO_OCUPADO;
                System.out.println("Asiento asignado!");
                break;
            }
        }
    }

    public static boolean asientoValido(char[][] matriz, int fila, int columna) {
        if (matriz[fila][columna] == ASIENTO_OCUPADO) {
            System.out.println("Error. Posición ocupada, elija otra");
            return false;
        }
        return true;
    }

    public static int validarPosicion(Scanner scanner) {
        while (true) {
            int place = validarNumero(scanner) - 1;
            if (place > 0 && place < 10) return place;
            System.out.println("Error. Ingrese una posición válida");
        }
    }

    public static int validarNumero(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error. Ingrese un número");
                scanner.nextLine();
            }
        }
    }
    
    public static void cargarMatriz(char[][] matriz) {
        for(int i=0; i<matriz.length; i++) {
            for(int j=0; j<matriz.length; j++) {
                matriz[i][j] = ASIENTO_LIBRE;
            }
        }
    }

    public static void separador() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}
