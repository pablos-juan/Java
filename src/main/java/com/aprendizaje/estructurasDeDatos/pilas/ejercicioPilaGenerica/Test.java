package main.java.com.aprendizaje.estructurasDeDatos.pilas.ejercicioPilaGenerica;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        PilaDinamica<String> nombres = new PilaDinamica<>();
        agregarNombres(nombres, 7);


        System.out.println("----PILA:----");
        System.out.println(nombres);
        separador();

        System.out.println("TAMAÑO DE LA PILA: " + nombres.size());
        separador();

        System.out.println("PRIMER ELEMENTO DE LA PILA: " + nombres.top());
        separador();

        System.out.println("SACAR NOMBRES DE LA PILA:");
        vaciarPila(nombres);
        separador();
    }

    public static <T> void vaciarPila(PilaDinamica<T> miPila) {
        while (!miPila.isEmpty()) {
            T elemento = miPila.pop();
            System.out.println(elemento + " eliminado.");
        }
    }

    public static void agregarNombres(PilaDinamica<String> miPila, int elementos) {
        for (int i = 1; i <= elementos; i++) {
            miPila.push(nombreAleatorio());
        }
    }

    public static String nombreAleatorio() {
        final String[] NOMBRES = {"Juan", "María", "Luis", "Ana", "Pedro", "Laura", "Carlos"};
        final String[] APELLIDOS = {"Gómez", "Rodríguez", "Fernández", "Martínez", "López", "Pérez", "Sánchez"};
        int LONGITUD = NOMBRES.length;

        Random random = new Random();
        String nombre = NOMBRES[random.nextInt(LONGITUD)];
        String apellido = APELLIDOS[random.nextInt(LONGITUD)];

        return  nombre + " " + apellido;
    }

    public static void separador() {
        System.out.println("--------------------------------------------");
    }
}
