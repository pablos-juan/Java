package main.java.com.aprendizaje.estructurasDeDatos.listasEnlazadas;

public class Listas {

    private Nodo cabeza;

    private class Nodo {
        public Libro libro;
        public Nodo siguiente = null;

        public Nodo(Libro libro) {
            this.libro = libro;
        }
    }

    public void insertarPrincipio(Libro libro) {
        Nodo nodo = new Nodo(libro);
        nodo.siguiente = cabeza;
        cabeza = nodo;
    }

    public void insertarFinal(Libro libro) {
        Nodo nodoNuevo = new Nodo(libro);
        Nodo puntero = cabeza;

        if (cabeza == null) cabeza = nodoNuevo;
        while (puntero.siguiente != null) {
            puntero = puntero.siguiente;
        }
        puntero.siguiente = nodoNuevo;
    }

    public void insertarDespues(int n, Libro libro) {
        Nodo nuevoNodo = new Nodo(libro);

        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo puntero = cabeza;
            int contador = 0;
            while (puntero.siguiente != null || contador < n) {
                puntero = puntero.siguiente;
                contador++;
            }
            nuevoNodo.siguiente = puntero.siguiente;
            puntero.siguiente = nuevoNodo;
        }

    }
}
