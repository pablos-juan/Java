package main.java.com.aprendizaje.estructurasDeDatos.colas.ejercicioCine;

public class ColaCine<T> {

    private class Nodo<T> {
        public T elemento;
        public Nodo<T> siguiente = null;

        public Nodo(T elemento) {
            this.elemento = elemento;
        }
    }

    private Nodo<T> cabeza;
    private Nodo<T> ultimo;
    private int longitud;

    public void encolar(T elemento) {
        Nodo<T> nuevoNodo = new Nodo<>(elemento);

        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            ultimo.siguiente = nuevoNodo;
        }

        ultimo = nuevoNodo;
        longitud++;
    }

    private void eliminar() {
        if (cabeza == null) return;

        Nodo<T> temporal = cabeza;
        cabeza = cabeza.siguiente;
        temporal.siguiente = null;

        if (longitud == 0) {
            ultimo = null;
        }

        longitud--;
    }

    public T getPersona() {
        if (cabeza == null) {
            return null;
        }
        Nodo<T> temporal = cabeza;
        eliminar();
        return temporal.elemento;
    }

    public void print() {
        if (cabeza == null) {
            System.out.println("ERROR. COLA VACÍA");
            return;
        }

        Nodo<T> actual = cabeza;
        while (actual.siguiente == null) {
            System.out.println(cabeza.elemento);
            actual = actual.siguiente;
        }
    }

    @Override
    public String toString() {
        Nodo<T> actual = cabeza;
        StringBuilder retorno = new StringBuilder("{");

        while (actual != null) {
            retorno.append(actual.elemento);
            retorno.append(
                actual.siguiente == null ? '}' : ", "
            );
            actual = actual.siguiente;
        }

        return retorno.toString();
    }

    public boolean isEmpty() {
        return cabeza == null;
    }

    public int size() {
        return longitud;
    }
}
