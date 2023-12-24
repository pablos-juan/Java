package main.java.com.aprendizaje.fundamentos.arraysYColecciones;

import java.util.HashMap;

public class ConceptoHashMap {
    public static void main(String[] args) {
        //conjunto clave-valor
        HashMap<Integer, String> hash = new HashMap<>();
        hash.put(100, "juan");
        hash.put(300, "samuel");
        hash.put(400, "pablo");
        System.out.println(hash);

        //obtener un dato
        System.out.println("dato en la clave 300: " + hash.get(300));

        //remover un dato
        hash.remove(100);
        System.out.println("juan removido");
        System.out.println(hash);

        //contiene una clave
        if (hash.containsKey(400)) {
            System.out.println("Contiene un valor " + hash.get(400));
        } else System.out.println("No contiene el valor " + hash.get(400));

        //recorrer un hash
        for (Integer indice : hash.keySet()) {
            System.out.println(hash.get(indice));
        }

        //for-each en una expresión lambda
        hash.forEach((clave, valor) -> System.out.println(clave + ": " + valor));
    }
}
