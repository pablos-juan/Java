package main.java.com.aprendizaje.estructurasDeDatos.pilas.ejercicioPilaGenerica;

public class Nodo<T> {
    private T elemento;
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

    @Override
    public String toString() {
        return "{elemento=" + elemento + '}';
    }
}
