package main.java.com.aprendizaje.expresionesLambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ExpresionesLambda {
    public static void main(String[] args) {
        /**
         * * Expresión lambda para imprimir una lista:
         * El método asList infiere el tipo de dato
         * El método forEach define una variable, infiere
         * su tipo y opera con ella
         */
        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9).forEach(
            numero -> System.out.println(numero + " ")
        );

        // Lambda junto a método referencial para println
        Arrays.asList(1, 2, 3, 4, 5, 6).forEach(System.out::println);

        /**
         * * Filtrado:
         * Filtrar números mayores que 5 -> filter
         * Lista como un flujo de elementos -> stream
         * Añadir los números filtrados a una lista -> Collectors.toList
         */
        ArrayList<Integer> mayoresQue = (ArrayList<Integer>) Arrays
                .asList(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .stream()
                .filter(n -> n > 5)
                .collect(Collectors.toList());

        mayoresQue.forEach(System.out::println);
    }
}
