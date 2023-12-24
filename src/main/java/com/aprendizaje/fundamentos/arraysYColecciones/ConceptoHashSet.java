package main.java.com.aprendizaje.fundamentos.arraysYColecciones;

import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.LinkedHashSet;

public class ConceptoHashSet {
    public static void main(String[] args) {
        //conjunto HashSet
        Set<String> conjuntoHash = new HashSet<>();;

        //agregar elementos
        conjuntoHash.add("juan");
        conjuntoHash.add("pablo");
        conjuntoHash.add("samuel");
        System.out.println(conjuntoHash);

        System.out.println("""
                \n
                HashSet:
                ---------""");

        //recorrer conjunto hash con for-each en una expresión lambda
        conjuntoHash.forEach(x -> System.out.println(x));

        //conjunto TreeHashSet
        Set<String> conjuntoTree = new TreeSet<>();
        conjuntoTree.add("sara");
        conjuntoTree.add("camila");
        conjuntoTree.add("pedro");
    
        System.out.println("""
                \n
                TreeSet:
                ---------""");
        
        //TreeSet imprimirá los valores en orden alfabético
        conjuntoTree.forEach(x -> System.out.println(x));

        //conjunto LinkedHashSet
        Set<Character> conjuntoLinked = new LinkedHashSet<>();
        conjuntoLinked.add('v');
        conjuntoLinked.add('r');
        conjuntoLinked.add('b');
    
        System.out.println("""
                \n
                LinkedHashSet:
                ----------------""");

        //LinkedHasSet imprimirá los valores según el orden de inserción
        //no hay valores duplicados
        conjuntoLinked.forEach(x -> System.out.println(x));

        //OPERACIONES CON HASH SET
        //eliminar elementos
        conjuntoHash.remove("pablo");
        System.out.println("pablo fué removido del conjunto");

        //verificar existencia de un elemento
        if (conjuntoHash.contains("pablo")) {
            System.out.println("pablo está en el conjunto");
        } else System.out.println("pablo no está en el conjunto");

        //eliminar todos los elementos
        conjuntoHash.clear();
        System.out.println("Todos los elementos fueron eliminados");

        //comprobar si el conjunto está vacío
        if (conjuntoHash.isEmpty()) System.out.println("El conjunto está vacío");
    }
}
