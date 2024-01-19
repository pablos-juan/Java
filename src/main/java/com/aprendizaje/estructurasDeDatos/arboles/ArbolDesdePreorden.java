package main.java.com.aprendizaje.estructurasDeDatos.arboles;

public class ArbolDesdePreorden {
    private class Nodo {
        public int valor;
        public Nodo right, left;

        public Nodo(int valor) {
            this.valor = valor;
        }
    }

    private Nodo raiz;

    public void recorrerArreglo(int[] arreglo, int index) {
        if ((index + 1) > arreglo.length) return;

        if (arreglo[index] != 0) {
            System.out.println(arreglo[index]);
        }

        recorrerArreglo(arreglo, index + 1);
    }

    public void add(int valor) {
        raiz = addValue(raiz, valor);
    }

    private Nodo addValue(Nodo nodo, int valor) {
        if (nodo == null) {
            return new Nodo(valor);
        }

        if (valor < nodo.valor) {
            nodo.left = addValue(nodo.left, valor);
        } else if (valor > nodo.valor) {
            nodo.right = addValue(nodo.right, valor);
        }

        return nodo;
    }

    public void newTree(int[] inOrden, int[] preOrden) {
        raiz = buildTree(preOrden, raiz, 0);
    }

    private Nodo buildTree(int[] preOrden, Nodo nodo, int index) {
        if (index < preOrden.length) {
            if (nodo == null) {
                new Nodo(preOrden[index]);
            }

            if (preOrden[index] < preOrden[0]) {
                
            }
        }
        return nodo;
    }
}
