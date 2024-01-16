package main.java.com.aprendizaje.estructurasDeDatos.listasEnlazadas.ejercicioBiblioteca;

public class Nodo<T> {
    private final T elemento;
    private Nodo<T> siguiente = null;

    public Nodo(T elemento) {
        this.elemento = elemento;
    }

    public T getElemento() {
        return elemento;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }
}
