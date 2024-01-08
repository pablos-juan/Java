package main.java.com.aprendizaje.expresionesLambda;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
        separador();

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

        System.out.println("FILTER: mayores que 5");
        mayoresQue.forEach(System.out::println);
        separador();

        /**
         * * Mapeo: map
         * Encontrar el cuadrado perfecto de cada elemento -> map
         * Filtrar los datos mayores que 5 y menores que 30 -> filter
         * Mostrar todos los datos filtrados -> forEach
         */
        System.out.println("MAP: cuadrados perfectos");
        numeros.stream()
                .map(x -> x * x)
                .filter(x -> x > 5 && x <= 30)
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);
        separador();

        /**
         * * Ordenación: sorted
         * Ordenar los números de la lista de mayor a menor -> sorted
         * Usar Interfaz comparator para definir el criterio -> Comparator
         * Mostrar los datos
         * Comparator<Integer> ordenDescendente = Comparator.reverseOrder();
         */
        System.out.println("SORT: ordenar de mayor a menor");
        numeros.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println
        );
        separador();

        System.out.println("SORT: ordenar cadenas según su longitud");
        ArrayList<String> nombres = new ArrayList<>(List.of(
                "Samuel", "Juan", "Pablo", "Camila", "Adriana"
        ));
        nombres.stream()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .forEach(System.out::println);
        separador();

        /**
         * * Coincidencia: anyMatch
         * Si al menos uno de los elementos cumple con una condición
         * retorna true, de lo contrario retorna false
         */
        boolean contieneJ = nombres.stream()
                .anyMatch(nombre -> nombre.toLowerCase().contains("i"));
        System.out.println(
                        "ANY. Algún nombre contiene 'J': " + contieneJ
        );
        separador();

        /**
         * * Coincidencia: allMatch
         * Si todos lo elementos de la lista cumplen con una condición
         * retorna true, de lo contrario retorna false
         */
        boolean iniciaConP = nombres.stream()
                .allMatch(nombre -> nombre.toLowerCase().startsWith("p"));
        System.out.println(
                        "ALL. Todos los nombres inician en 'P': " + iniciaConP
        );
        separador();

        /**
         * * Coincidencia: noneMatch
         * Si ninguno de los elementos cumple con una condición
         * retorna true, de lo contrario retorna false
         */
        boolean noTerminaEnE = nombres.stream()
                .noneMatch(nombre -> nombre.toLowerCase().endsWith("e"));
        System.out.println(
                        "NONE. Ningún nombre termina en 'E': " + noTerminaEnE
        );
        separador();

        /**
         * * Omitir elementos: skip
         * Omite los primeros n elementos
         * siendo n de tipo longs
         */
        int n = 2;
        List<String> elementosOmitidos = nombres.stream()
                .skip(n)
                .toList();
        System.out.println("SKIP: omitir los 2 primeros elementos");
        elementosOmitidos.forEach(System.out::println);
        separador();

        /**
         * * Limitar elementos: limit
         * Limita el flujo hasta un máximo de n elementos
         * siendo n de tipo long
         */
        int limite = 3;
        List<String> listaLimitada = nombres.stream()
                .limit(limite)
                .toList();
        System.out.println("LIMIT: limita el flujo a 3 elementos");
        listaLimitada.forEach(System.out::println);
        separador();

        /**
         * * Ejemplo paginación con limit y skip:
         * pageNumber define el elemento que iniciará la página
         * pageSize será el máximo de elementos en una página
         * Cada página tendrá dos elementos
         */
        System.out.println("PAGINACIÓN: limit y skip");
        int pageNumber = 0;
        int pageSize = 2;
        /**
         * El producto de pageNumber * pageSize resulta en el número
         * de elementos que ya fueron incluidos en un página
         * El ciclo se detendrá cuando todos lo elementos estén dentro
         * Los elementos serán agregados cuando el producto de
         * pageNumber * pageSize sea mayor o igual al tamaño de la lista
         */
        while (pageNumber * pageSize < nombres.size()) {
                nombres.stream()
                        .skip(pageNumber * pageSize)
                        .limit(pageSize)
                        .forEach(System.out::println);
                pageNumber++;
                System.out.println("------------- p:" + pageNumber);
        }
        separador();

        /**
         * * Collectors: groupingBy
         * Agrupa los elementos según el criterio impuesto
         * Retorna un mapa, su clave es el parámetro por el que se agrupa
         * su valor es una lista, que contienen los elementos que cumplen
         * con ese criterio de agrupación
         */
        Map<Integer, List<String>> mapaLongitud = nombres.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println("COLLECTORS, groupingBy: agrupar los nombres según su longitud");
        mapaLongitud.forEach((clave, valor) -> System.out.println(
                "Longitud: " + clave + ", Coincidencia: " + valor
        ));
        separador();

        /**
         * * Collectors: counting
         * Defina un criterio para la recolección por ejemplo,
         * las palabras terminadas en en la letra "a"
         * Dado que solo hay dos casos posibles (true o false)
         * el mapa mostrará las coincidencias para cada una
         * Collectors.counting determina el número de coincidencias
         */
        Map<Object, Long> countingMap = nombres.stream()
                .collect(Collectors.groupingBy(
                        m -> m.endsWith("a"), Collectors.counting()
                ));
        System.out.println("COLLECTORS, counting: nombres que terminan en 'a'");
        countingMap.forEach((clave, valor) -> System.out.println(
                clave + ": " + valor
        ));
        separador();

        /**
         * * Collectors: summing
         * Agrupar palabras por su longitud
         * Sumar las longitudes de las palabras en los grupos
         */
        Map<Integer, Integer> summingMap = nombres.stream()
                .collect(Collectors.groupingBy(
                        String::length,
                        Collectors.summingInt(String::length)
                ));
        System.out.println("COLLECTORS, summing: palabras agrupadas por longitud");
        summingMap.forEach((clave, valor) -> System.out.println(
                "Longitud: " + clave + ", longitud total: " + valor
        ));
        separador();

        /**
         * * Reduce:
         * Combina los elementos de un flujo en un solo resultado
         * Reduce devuelve un optional
         */
        System.out.println("REDUCE: suma de longitudes" + "\nTotal: " +
                nombres.stream()
                .map(String::length)
                .reduce(Integer::sum)
                .orElse(0)
        );
        separador();

        /**
         * * Reduce para concatenar cadenas:
         * Declarar identidad inicial, un valor con el que inicia la reducción
         * Usar una función lambda con dos parámetros, a y b, por ejemplo
         * a, es el acumulador y b es el siguiente elemento en el stream
         * En cada iteración, se suma el acumulador con el siguiente elemento
         */
        String concatenacion = nombres.stream()
                .map(m -> m.concat(" "))
                .reduce("REDUCE: nombres concatenados: ", (a, b) -> a + b);
        System.out.println(concatenacion);
        separador();

        /**
         * * Buscar un elemento: findFirst
         * Usa predicate, devuelve un optional
         * FindFirst devuelve el primer elemento que coincida con
         * la condición impuesta en forma de predicate
         * Predicate puede ser agregado directamente el método
         * filter o declarado previamente
         */
        Predicate<String> longitudMax = nombre -> nombre.length()<7;
        Predicate<String> longitudMin = nombre -> nombre.length()>3;
        Predicate<String> contieneA = nombre -> nombre.contains("a");
        Predicate<String> esValido = longitudMax.and(longitudMin).and(contieneA);

        String findFirst = nombres.stream()
                .map(String::toLowerCase)
                .filter(esValido)
                .findFirst()
                .orElse(null);
        System.out.println("findFISRT: primera coincidencia: " + findFirst);
    }

    public static void separador() {
        System.out.println(
                "--------------------------------------------------"
        );
    }
}