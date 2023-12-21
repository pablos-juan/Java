package main.java.com.aprendizaje.fundamentos.arraysYColecciones;

import java.util.HashMap;

public class ConceptoHashMap {
    public static void main(String[] args) {
        //conjunto clave-valor
        HashMap<Integer, String> hash = new HashMap<>();
        hash.put(100, "Juan");
        hash.put(300, "Samuel");
        hash.put(400, "pablo");
        System.out.println(hash);

        //obtener un dato
        System.out.println(hash.get(300));

        //remover un dato
        hash.remove(100);
        System.out.println(hash);

        //contiene una clave
        if (hash.containsKey(400)) {
            System.out.println("Contiene un índice " + hash.get(400));
        } else System.out.println("No contiene el valor " + hash.get(400));

        //recorrer un hash
        for (Integer indice : hash.keySet()) {
            System.out.println(hash.get(indice));
        }
    }
}
