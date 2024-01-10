package main.java.com.aprendizaje.ejercicios;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class EjerciciosJunior {
    public static final String CADENA_PRUEBA = "Espeluznante";
    public static final int NUM_PRUEBA = 2002;
    public static void main(String[] args) {
        System.out.println("INVERTIR CADENA: " + CADENA_PRUEBA);
        invertirString(CADENA_PRUEBA);
        separador();

        System.out.println("NÚMERO ES CAPICÚA: " + NUM_PRUEBA);
        esCapicua(252);
        separador();

        System.out.println("CONTADOR DE CARACTERES: " + CADENA_PRUEBA);
        contadorCaracteres(CADENA_PRUEBA);
        separador();

        System.out.println("CARACTERES REPETIDOS: " + CADENA_PRUEBA);
        caracteresRepetidos(CADENA_PRUEBA);
        separador();

        System.out.println("ES MÚLTIPLO DE 2: " + NUM_PRUEBA);
        esMultiploDe2(NUM_PRUEBA);
        separador();

        System.out.println("ES UN AÑO BISIESTO: " + NUM_PRUEBA);
        isLeapYear(NUM_PRUEBA);
        separador();

        System.out.println("ORDEN ALEATORIO DE UNA PALABRA: " + CADENA_PRUEBA);
        randomOrder(CADENA_PRUEBA);
        separador();

        System.out.println("REMUEVE DUPLICADOS DE LA LISTA:");
        listaSinDuplicados(Arrays.asList(1, 2, 3, 1, 2, 5, 6, 4, 3, 9, 6));
        separador();

        System.out.println("COMPROBAR SI UNA CADENA TIENE VOCALES: " + CADENA_PRUEBA);
        hayVocales(CADENA_PRUEBA);
        separador();

        System.out.println("COMPROBAR SI UNA CADENA ES PALÍNDROMO: " + CADENA_PRUEBA);
        esPalindromo(CADENA_PRUEBA);
        separador();
    }

    public static void esPalindromo(String cadena) {
        String reversed = new StringBuilder(cadena).reverse().toString();
        boolean esPalindromo = reversed.equals(cadena);
        System.out.println(esPalindromo ? cadena + " es un palíndromo"
                                        : cadena + " no es un palíndromo");
    }

    public static void hayVocales(String cadena) {
        boolean hayVocales = cadena.toLowerCase().matches(".*[aeiou].*");
        System.out.println(hayVocales);

        /* final String VOCALES = "aeiouAEIOU";

        for (char c : cadena.toCharArray()) {
            if (VOCALES.contains(String.valueOf(c))) {
                return true;
            }
        }
        return false; */
    }

    public static void listaSinDuplicados(List<Integer> lista) {
        Set<Integer> newLista = new HashSet<>(lista);
        newLista.forEach(System.out::println);
    }

    public static void randomOrder(String cadena) {
        /* String[] array = cadena.split("");
        List<String> list = Arrays.asList(array);
        Collections.shuffle(list);

        list.forEach(System.out::println); */
        final int LONGITUD = cadena.length();

        Set<Integer> numbers = new HashSet<>();
        char[] newCadena = cadena.toCharArray();
        char[] solution = new char[LONGITUD];

        Random random = new Random();

        for (int i = 0; i < LONGITUD; i++) {
            int num;
            do {
                num = random.nextInt(LONGITUD);
            } while (!numbers.add(num));
            solution[i] = newCadena[num];
        }
        //return new String(solution);
        System.out.println(solution);
    }

    public static void isLeapYear(int year) {
        System.out.println(
                LocalDate.of(year, 1, 1).isLeapYear()
                        ? year + " es un año bisiesto"
                        : year + " no es un año bisiesto"
        );
    }

    public static void esMultiploDe2(int number) {
        System.out.println(
                number % 2 == 0
                        ? "Es múltiplo de 2"
                        : "No es múltiplo de 2"
        );
    }

    public static void caracteresRepetidos(String cadena) {
        Map<Character, Integer> conteo = new HashMap<>();
        for (char c : cadena.toCharArray()) {
            conteo.put(c, conteo.getOrDefault(c, 0) + 1);
        }
        conteo.forEach((caracter, frecuencia) -> {
            if (frecuencia > 1) {
                System.out.println(caracter + ": " + frecuencia);
            }
        });
    }

    public static void contadorCaracteres(String cadena) {
        Map<Character, Integer> conteo = new HashMap<>();
        for (char c : cadena.toCharArray()) {
            conteo.put(c, conteo.getOrDefault(c, 0) + 1);
        }
        conteo.forEach((caracter, frecuencia) -> System.out.println(
                caracter + ": " + frecuencia)
        );
    }

    public static void esCapicua(int num) {
        String castNum = String.valueOf(num);
        String reverse = new StringBuilder(castNum).reverse().toString();
        System.out.println(
                castNum.equals(reverse) ? "Es capicúa " : "No es capicúa"
        );
    }

    public static void invertirString(String cadena) {
        /* String solution = "";
        for (int i = cadena.length()-1; i>=0; i--) {
            solution += cadena.charAt(i);
        }
        return solution; */
        System.out.println(new StringBuilder(cadena).reverse());
    }

    public static void separador() {
        System.out.println(
                "-------------------------------------------------------------"
        );
    }
}