package main.java.com.aprendizaje.fundamentos.genericos;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Envoltorio<Integer> miEnvoltorio = new Envoltorio<>(23);

        //* Uso de genéricos en una clase
        System.out.println("GENÉRICO: " + miEnvoltorio.get());
        miEnvoltorio.mostrar();

        //* Uso de genéricos en una función
        Integer[] numeros = {1, 2, 3, 4, 5};
        
        System.out.println("Array original: " + Arrays.toString(numeros));
        intercambiarElementos(numeros, 1, 3);
        System.out.println(
            "Array después del intercambio: " + Arrays.toString(numeros)
        );
        
        String[] palabras = {"uno", "dos", "tres", "cuatro", "cinco"};

        System.out.println("Array original: " + Arrays.toString(palabras));
        intercambiarElementos(palabras, 0, 4);
        System.out.println(
            "Array después del intercambio: " + Arrays.toString(palabras)
        );
    }

    public static <T> void intercambiarElementos(T[] array, int indice1, int indice2) {
        if (indice1 >= 0 && indice1 < array.length
            && indice2 >= 0 && indice2 < array.length) {
            T temp = array[indice1];
            array[indice1] = array[indice2];
            array[indice2] = temp;
        }
    }
}