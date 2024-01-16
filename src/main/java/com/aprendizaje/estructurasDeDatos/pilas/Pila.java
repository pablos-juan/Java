package main.java.com.aprendizaje.estructurasDeDatos.pilas;

public class Pila {
    public class Nodo {
        public String dato;
        public Nodo siguiente = null;

        public Nodo(String dato) {
            this.dato = dato;
        }
    }

    Nodo cima;
    int longitud = 0;

    public void apilar(String dato) {
        Nodo nuevoNodo = new Nodo(dato);
        nuevoNodo.siguiente = cima;
        cima = nuevoNodo;
        longitud++;
    }

    public void pop() {
        if (cima == null) {
            return;
        }

        Nodo temporal = cima;
        cima = cima.siguiente;
        temporal.siguiente = null;
        longitud--;
    }

    public String getDato() {
        if (cima == null) {
            return null;
        }
        return cima.dato;
    }
}