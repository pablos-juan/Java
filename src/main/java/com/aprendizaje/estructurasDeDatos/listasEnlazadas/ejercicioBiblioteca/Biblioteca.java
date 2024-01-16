package main.java.com.aprendizaje.estructurasDeDatos.listasEnlazadas.ejercicioBiblioteca;

public class Biblioteca<T> {
    private Nodo<T> cabeza;
    private int longitud = 0;
    private final static String NO_DELETED_BOOK = "Error. Operación cancelada";
    private final static String DELETED_BOOK = "Libro eliminado";

    public void deleteIn(int position) {
        if (cabeza == null || longitud < position) {
            System.out.println(NO_DELETED_BOOK);
        }
        if (position == 0) {
            delete();
            return;
        }

        Nodo<T> actual = cabeza;
        int index = 1;
        while (actual.getSiguiente() != null && index < position-1) {
            actual = actual.getSiguiente();
            position++;
        }
        Nodo<T> temporal = actual.getSiguiente();
        actual.setSiguiente(temporal.getSiguiente());
        temporal.setSiguiente(null);
        longitud--;
        System.out.println(DELETED_BOOK);
    }

    public void deleteEnd() {
        if (cabeza == null) {
            System.out.println(NO_DELETED_BOOK);
            return;
        }
        if (cabeza.getSiguiente() == null) {
            cabeza = null;
            System.out.println(DELETED_BOOK);
        }

        Nodo<T> actual = cabeza;
        while (actual.getSiguiente().getSiguiente() != null) {
            actual = actual.getSiguiente();
        }
        actual.setSiguiente(null);
        longitud--;
        System.out.println(DELETED_BOOK);
    }

    public void delete() {
        if (cabeza == null) {
            System.out.println(NO_DELETED_BOOK);
            return;
        }

        Nodo<T> temporal = cabeza;
        cabeza = cabeza.getSiguiente();
        temporal.setSiguiente(null);
        longitud--;
        System.out.println(DELETED_BOOK);

    }

    public void addEnd(T elemento) {
        if (cabeza == null) {
            add(elemento);
            return;
        }

        Nodo<T> nuevoNuevo = new Nodo<>(elemento);
        Nodo<T> actual = cabeza;
        while (actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }
        actual.setSiguiente(nuevoNuevo);
        longitud++;
    }

    public void addAfter(T elemento, int position) {
        if (cabeza == null) {
            add(elemento);
            return;
        }

        Nodo<T> nuevoNodo = new Nodo<>(elemento);
        Nodo<T> actual = cabeza;
        int index = 1;

        while (actual.getSiguiente() != null && index < position) {
            actual = actual.getSiguiente();
            index++;
        }

        nuevoNodo.setSiguiente(actual.getSiguiente());
        actual.setSiguiente(nuevoNodo);
        longitud++;
    }

    public void add(T elemento) {
        Nodo<T> nodoNuevo = new Nodo<>(elemento);
        nodoNuevo.setSiguiente(cabeza);
        cabeza = nodoNuevo;
        longitud++;
    }

    @Override
    public String toString() {
        Nodo<T> actual = cabeza;
        StringBuilder retorno = new StringBuilder("{");

        while (actual != null) {
            retorno.append(actual.getElemento());

            if (actual.getSiguiente() == null) {
                retorno.append("}");
            } else {
                retorno.append("\n");
            }
            actual = actual.getSiguiente();
        }

        return retorno.toString();
    }

    public T getElemento(int position) {
        if (cabeza == null || longitud < position) {
            return null;
        }

        Nodo<T> actual = cabeza;
        int index = 1;
        while (actual.getSiguiente() != null && index < position){
            actual = actual.getSiguiente();
            index++;
        }

        return index != position ? null : actual.getElemento();
    }

    public int length() {
        return longitud;
    }
}
