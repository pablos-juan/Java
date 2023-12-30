package main.java.com.aprendizaje.expresionesLambda;

import java.util.*;

public class ExpresionesLambda {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>(List.of(2, 4, 6, 1, 3, 5, 9, 7, 8));

        /**
         * * Expresión lambda para imprimir una lista:
         * El método asList infiere el tipo de dato
         * El método forEach define una variable, infiere
         * su tipo y opera con ella
         */
        System.out.println("IMPRIMIR NÚMEROS CON LAMBDA:");
        numeros.forEach(numero -> System.out.println(numero + " "));

        // Lambda junto a método referencial para println
        System.out.println("REFERENCIA A MÉTODOS:");
        Arrays.asList(1, 2, 3, 4, 5, 6).forEach(System.out::println);

        /**
         * * Filtrado:
         * Filtrar números mayores que 5 -> filter
         * Lista como un flujo de elementos -> stream
         * Añadir los números filtrados a una lista -> Collectors.toList
         */
        ArrayList<Integer> mayoresQue = new ArrayList<>(numeros
                .stream()
                .filter(n -> n > 5)
                .toList());

        System.out.println("FILTRADOS: MAYORES QUE 5");
        mayoresQue.forEach(System.out::println);

        /**
         * * Mapeo:
         * Encontrar el cuadrado perfecto de cada elemento -> map
         * Filtrar los datos mayores que 5 y menores que 30 -> filter
         * Mostrar todos los datos filtrados -> forEach
         */
        System.out.println("MAPEO: CUADRADOS PERFECTOS");
        numeros.stream()
                .map(x -> x * x)
                .filter(x -> x > 5 && x <= 30)
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);

        /**
         * * Ordenación:
         * Ordenar los números de la lista de mayor a menor -> sorted
         * Usar Interfaz comparator para definir el criterio -> Comparator
         * Mostrar los datos
         * Comparator<Integer> ordenDescendente = Comparator.reverseOrder();
         */

        System.out.println("SORT: ORDENACIÓN DE MAYOR A MENOR");
        numeros.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        System.out.println("ORDENAR CADENAS SEGÚN SU LONGITUD");
        ArrayList<String> nombres = new ArrayList<>(List.of(
                "Samuel", "Juan", "Pablo", "Camila", "Spotify"
        ));
        nombres.stream()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .forEach(System.out::println);
    }
}
