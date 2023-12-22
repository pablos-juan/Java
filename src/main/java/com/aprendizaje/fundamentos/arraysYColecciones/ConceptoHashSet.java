package main.java.com.aprendizaje.fundamentos.arraysYColecciones;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

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
                HashSet:
                ---------
                """);

        //recorrer conjunto hash
        for (String valor : conjuntoHash) {
            System.out.println(valor);
        }

        Set<String> conjutnoTree = new TreeSet<>();
        conjutnoTree.add("sara");
        conjutnoTree.add("camila");
        conjutnoTree.add("pedro");
    
        System.out.println("""
                TreeSet:
                ---------
                """);
        
        //TreeSet imprimirá los valores en orden alfabético
        for (String valor : conjutnoTree) {
            System.out.println(valor);
        }
    }
}
