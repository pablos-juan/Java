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

        separador();
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
                .toList()
        );

        separador();
        System.out.println("FILTER: mayores que 5");
        mayoresQue.forEach(System.out::println);

        /**
         * * Mapeo: map
         * Encontrar el cuadrado perfecto de cada elemento -> map
         * Filtrar los datos mayores que 5 y menores que 30 -> filter
         * Mostrar todos los datos filtrados -> forEach
         */
        separador();
        System.out.println("MAP: cuadrados perfectos");
        numeros.stream()
                .map(x -> x * x)
                .filter(x -> x > 5 && x <= 30)
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);

        /**
         * * Ordenación: sorted
         * Ordenar los números de la lista de mayor a menor -> sorted
         * Usar Interfaz comparator para definir el criterio -> Comparator
         * Mostrar los datos
         * Comparator<Integer> ordenDescendente = Comparator.reverseOrder();
         */
        separador("SORT");
        System.out.println("SORT: ordenar de mayor a menor");
        numeros.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println
        );

        separador();
        System.out.println("SORT: ordenar cadenas según su longitud");
        ArrayList<String> nombres = new ArrayList<>(List.of(
                "Samuel", "Juan", "Pablo", "Camila", "Spotify"
        ));
        nombres.stream()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .forEach(System.out::println);

        /**
         * * Coincidencia: anyMatch
         * Si al menos uno de los elementos cumple con una condición
         * retorna true, de lo contrario retorna false
         */
        boolean contieneJ = nombres.stream()
                .anyMatch(nombre -> nombre.toLowerCase().contains("i"));
        separador("MATCH");
        System.out.println(
                        "ANY. Algún nombre contiene 'J': " + contieneJ
        );

        /**
         * * Coincidencia: allMatch
         * Si todos lo elementos de la lista cumplen con una condición
         * retorna true, de lo contrario retorna false
         */
        boolean iniciaConP = nombres.stream()
                .allMatch(nombre -> nombre.toLowerCase().startsWith("p"));
        separador();
        System.out.println(
                        "ALL. Todos los nombres inician en 'P': " + iniciaConP
        );

        /**
         * * Coincidencia: noneMatch
         * Si ninguno de los elementos cumple con una condición
         * retorna true, de lo contrario retorna false
         */
        boolean noTerminaEnE = nombres.stream()
                .noneMatch(nombre -> nombre.toLowerCase().endsWith("e"));
        separador();
        System.out.println(
                        "NONE. Ningún nombre termina en 'E': " + noTerminaEnE
        );
    }

    public static void separador() {
        System.out.println(
                "--------------------------------------------------"
        );
    }

    public static void separador(String extra) {
        System.out.println(
                "-------------------------------------------------- " + extra 
        );
    }
}