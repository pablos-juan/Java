package main.java.com.aprendizaje.estructurasDeDatos.pilas.ejercicioPilaGenerica;

public class PilaDinamica<T> {
    private Nodo<T> cima;
    private int longitud = 0;

    public void push(T elemento) {
        Nodo<T> nuevoNodo = new Nodo<>(elemento);
        nuevoNodo.setSiguiente(cima);
        cima = nuevoNodo;
        longitud++;
    }

    public T pop() {
        if (isEmpty()) return null;

        Nodo<T> temporal = cima;
        cima = cima.getSiguiente();
        temporal.setSiguiente(null);
        longitud--;

        return temporal.getElemento();
    }

    public T top() {
        if (isEmpty()) return null;

        return cima.getElemento();
    }

    @Override
    public String toString() {
        StringBuilder retorno = new StringBuilder("{");
        Nodo<T> actual = cima;

        while (actual != null) {
            retorno.append(actual.getElemento());
            retorno.append(
                actual.getSiguiente() == null ? '}' : ", "
            );
            actual = actual.getSiguiente();
        }

        return retorno.toString();
    }

    public boolean isEmpty() {
        return cima == null;
    }

    public int size() {
        return longitud;
    }
}
