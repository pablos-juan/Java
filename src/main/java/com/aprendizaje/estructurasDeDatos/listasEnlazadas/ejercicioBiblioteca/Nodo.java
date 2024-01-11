package main.java.com.aprendizaje.estructurasDeDatos.listasEnlazadas.ejercicioBiblioteca;

public class Nodo {
    private final Libro libro;
    private Nodo siguiente = null;

    public Nodo(Libro libro) {
        this.libro = libro;
    }

    public Libro getLibro() {
        return libro;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
