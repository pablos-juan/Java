package main.java.com.aprendizaje.estructurasDeDatos.arboles;

public class Test {
    public static void main(String[] args) {
        /* ArbolBinarioBusqueda miArbol = new ArbolBinarioBusqueda();

        miArbol.add('c');
        miArbol.add('m');
        miArbol.add('d');
        miArbol.add('w');
        miArbol.add('a');
        miArbol.add('k');
        miArbol.add('b');

        miArbol.delete('a');
        miArbol.inOrden(); */
        ArbolDesdePreorden miArbolDesdePreorden = new ArbolDesdePreorden();
        int[] arreglo = {1, 3, 6, 4, 0, 8, 9};
        miArbolDesdePreorden.recorrerArreglo(arreglo, 0);
    }
}
