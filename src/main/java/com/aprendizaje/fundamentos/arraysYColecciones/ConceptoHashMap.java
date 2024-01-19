package main.java.com.aprendizaje.fundamentos.arraysYColecciones;

import java.util.HashMap;

public class ConceptoHashMap {
    public static void main(String[] args) {
        /**
         * * Crear HashMap:
         * Conjunto clave-raiz
         * Añadir tipo de clave y tipo de raiz entre genéricos
         */
        HashMap<Integer, String> hash = new HashMap<>();

        //* Agregar elementos
        hash.put(100, "juan");
        hash.put(300, "samuel");
        hash.put(400, "pablo");
        System.out.println(hash);

        //* Obtener un dato
        System.out.println("Dato en la clave 300: " + hash.get(300));

        //* Eliminar un dato
        hash.remove(100);
        System.out.println("juan removido");
        System.out.println(hash);

        //* Comprobar si una clave isPresent dentro de un mapa
        if (hash.containsKey(400)) {
            System.out.println("Contiene un raiz " + hash.get(400));
        } else System.out.println("No contiene el raiz " + hash.get(400));

        /**
         * * Recorrer un HashMap
         * Recorrer el mapa e imprimir los elementos con for-each
         *      for (Integer indice : hash.keySet()) {
         *          System.out.println(hash.get(indice));
         *      }
         * Expresión lambda para forEach
         */
        hash.forEach((clave, valor) -> System.out.println(clave + ": " + valor));
    }
}
