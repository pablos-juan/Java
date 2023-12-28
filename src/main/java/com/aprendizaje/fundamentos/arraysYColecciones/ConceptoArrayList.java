package main.java.com.aprendizaje.fundamentos.arraysYColecciones;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class ConceptoArrayList {
    public static void main(String[] args) {
        //* Indique el tipo de datos entre genéricos
        List<String> numberList = new ArrayList<>();
        
        //* Agregar elementos
        numberList.add("pablo");
        numberList.add("juan");
        numberList.add("samuel");
        numberList.add("camilo");

        /**
         * * Recorrer una lista:
         * Recorrer la lista e imprimir los elemento con for-each
         *      for (Integer numero : numberList) {
         *          System.out.println(numero)
         *      }
         * Expresión lambda para forEach
         */
        numberList.forEach(x -> System.out.println(x));

        //* Eliminar un elemento, indicar posición
        numberList.remove(2);
        System.out.println("Elemento en la posición 2 removido");

        //* Obtener tamaño de la lista
        System.out.println("Tamaño: " + numberList.size());
        
        //* Obtener un elemento según su posición
        System.out.println("Elemento en índice 1: " 
                            + numberList.get(1));
        
        //* Obtener la posición de un elemento
        System.out.println("Posición del elemento pablo: " 
                        // En caso de no encontrar el objeto, retornará -1
                            + numberList.indexOf("pablo"));
        
        //* Obtener elemento máximo y mínimo
        System.out.println("Máximo: " + Collections.max(numberList));
        System.out.println("Mínimo: " + Collections.min(numberList));
    }
}
