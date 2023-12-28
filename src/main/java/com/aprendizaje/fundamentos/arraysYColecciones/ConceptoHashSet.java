package main.java.com.aprendizaje.fundamentos.arraysYColecciones;

import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.LinkedHashSet;

public class ConceptoHashSet {
    public static void main(String[] args) {
        //* Definir tipo en genéricos
        Set<String> conjuntoHash = new HashSet<>();;

        /**
         * * Agregar elementos:
         * HashSet no permite valores duplicados,
         * en caso de haber alguno será ignorado
         */
        conjuntoHash.add("juan");
        conjuntoHash.add("pablo");
        conjuntoHash.add("samuel");
        System.out.println(conjuntoHash);

        System.out.println("""
                \n
                HashSet:
                ---------""");

        //* Recorrer conjunto con forEach en lambda
        conjuntoHash.forEach(x -> System.out.println(x));

        //* Conjunto TreeSet
        Set<String> conjuntoTree = new TreeSet<>();
        /**
         * * Orden de los elementos:
         * TreeSet ordena los elementos alfabéticamente
         * Los números están ordenados de menor a mayor
         */
        conjuntoTree.add("sara");
        conjuntoTree.add("camila");
        conjuntoTree.add("pedro");
    
        System.out.println("""
                \n
                TreeSet:
                ---------""");
        
        conjuntoTree.forEach(x -> System.out.println(x));

        //* Conjunto LinkedHashSet
        Set<Character> conjuntoLinked = new LinkedHashSet<>();
        //* Los valores será insertados según la inserción
        conjuntoLinked.add('v');
        conjuntoLinked.add('r');
        conjuntoLinked.add('b');
    
        System.out.println("""
                \n
                LinkedHashSet:
                ----------------""");

        conjuntoLinked.forEach(x -> System.out.println(x));

        //* Operaciones con HashSet
        // Eliminar elementos
        conjuntoHash.remove("pablo");
        System.out.println("pablo fué removido del conjunto");

        // Verificar existencia de un elemento
        if (conjuntoHash.contains("pablo")) {
            System.out.println("pablo está en el conjunto");
        } else System.out.println("pablo no está en el conjunto");

        // Eliminar todos los elementos
        conjuntoHash.clear();
        System.out.println("Todos los elementos fueron eliminados");

        // Comprobar si el conjunto está vacío
        if (conjuntoHash.isEmpty()) System.out.println("El conjunto está vacío");
    }
}
