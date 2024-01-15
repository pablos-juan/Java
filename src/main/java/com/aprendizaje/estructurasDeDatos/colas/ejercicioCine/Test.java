package main.java.com.aprendizaje.estructurasDeDatos.colas.ejercicioCine;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        ColaCine cola = new ColaCine();
        int dineroRecaudado = 0;

        System.out.println("----CINE----");
        separador();
        llenarCola(cola);

        Persona persona;
        while (!cola.isEmpty()) {
            persona = cola.getPersona();
            int pago = cobrar(persona);
            dineroRecaudado += pago;

            System.out.println(persona.getNombre() + " pagó: $" + pago);
        }

        separador();
        System.out.println("RECAUDO TOTAL: " + dineroRecaudado);
    }

    /**
     * Define la tarifa según la edad de una persona
     * @param persona De aquí obtendrá la edad
     * @return Valor de la entrada según la edad
     */
    public static int cobrar(Persona persona) {
        final int TARIFA_5_10_ANIOS = 1, TARIFA_11_17_ANIOS = 3,
                TARIFA_18_MAS_ANIOS = 5;
        int edad = persona.getEdad();

        if (edad >= 18) {
            return TARIFA_18_MAS_ANIOS;
        }
        if (edad >= 11) {
            return TARIFA_11_17_ANIOS;
        }
        return TARIFA_5_10_ANIOS;
    }

    /**
     * Agrega personas a la cola
     * @param cola Aquí se añadirán las personas
     */
    public static void llenarCola(ColaCine cola) {
        Random random = new Random();
        final int TOTAL_PERSONAS = random.nextInt(50);

        Persona persona;
        for (int i = 0; i < TOTAL_PERSONAS; i++) {
            int edad = random.nextInt(5, 45);
            String nombre = getRandomNombre();
            persona = new Persona(edad, nombre);

            cola.encolar(persona);
        }
    }

    /**
     * Genera un nombre aleatorio
     * @return Nombre con una longitud entre 4 y 8 caracteres
     */
    public static String getRandomNombre() {
        Random random = new Random();
        char[] chars = new char[random.nextInt(4, 8)];

        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) random.nextInt(65, 91);
        }

        return new String(chars);
    }

    public static void separador() {
        System.out.println("--------------------------------------");
    }
}
