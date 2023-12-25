package main.java.com.aprendizaje.fundamentos.arraysYColecciones;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class ConceptoArrayList {
    public static void main(String[] args) {
        //indicar tipo entre genéricos
        List<String> numberList = new ArrayList<>();
        
        //agregar elementos
        numberList.add("pablo");
        numberList.add("juan");
        numberList.add("samuel");
        numberList.add("camilo");

        //recorrer lista con for-each e imprimir los elementos
            /*
                for (Integer numero : numberList) {
                    System.out.println(numero)
                }
            */
        //for-each en una expresión lambda
        numberList.forEach(x -> System.out.println(x));

        //eliminar un elemento
        numberList.remove(2); //2 es la posición
        System.out.println("Elemento en la posición 2 removido");

        //tamaño de la lista
        System.out.println("Tamaño: " + numberList.size());
        
        //obtener un elemento según un índice
        System.out.println("Elemento en índice 1: " 
                            + numberList.get(1));
        
        //obtener la posición de un elemento
        System.out.println("Posición del elemento pablo: " 
                        //en caso de no encontrar el elemento retorna -1
                            + numberList.indexOf("pablo"));
        
        //elemento máximo y mínimo
        System.out.println("Máximo: " + Collections.max(numberList));
        System.out.println("Mínimo: " + Collections.min(numberList));
    }
}
