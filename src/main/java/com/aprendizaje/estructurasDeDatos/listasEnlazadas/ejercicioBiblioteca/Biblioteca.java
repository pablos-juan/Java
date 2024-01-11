package main.java.com.aprendizaje.estructurasDeDatos.listasEnlazadas.ejercicioBiblioteca;

public class Biblioteca {
    private Nodo cabeza;
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

        Nodo actual = cabeza;
        int index = 1;
        while (actual.getSiguiente() != null && index < position-1) {
            actual = actual.getSiguiente();
            position++;
        }
        Nodo temporal = actual.getSiguiente();
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

        Nodo actual = cabeza;
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

        Nodo temporal = cabeza;
        cabeza = cabeza.getSiguiente();
        temporal.setSiguiente(null);
        longitud--;
        System.out.println(DELETED_BOOK);

    }

    public void addEnd(Libro libro) {
        if (cabeza == null) {
            add(libro);
            return;
        }

        Nodo nuevoNuevo = new Nodo(libro);
        Nodo actual = cabeza;
        while (actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }
        actual.setSiguiente(nuevoNuevo);
        longitud++;
    }

    public void addAfter(Libro libro, int position) {
        if (cabeza == null) {
            add(libro);
            return;
        }

        Nodo nuevoNodo = new Nodo(libro);
        Nodo actual = cabeza;
        int index = 1;
        while (actual.getSiguiente() != null && index < position) {
            actual = actual.getSiguiente();
            index++;
        }
        nuevoNodo.setSiguiente(actual.getSiguiente());
        actual.setSiguiente(nuevoNodo);
        longitud++;
    }

    public void add(Libro libro) {
        Nodo nodoNuevo = new Nodo(libro);
        nodoNuevo.setSiguiente(cabeza);
        cabeza = nodoNuevo;
        longitud++;
    }

    public void printList() {
        if (cabeza == null) return;

        Nodo actual = cabeza;
        while (actual != null) {
            System.out.println(actual.getLibro());
            actual = actual.getSiguiente();
        }
    }

    public Libro getWithIsbn(int isbn) {
        if (cabeza == null) {
            return null;
        }

        Nodo actual = cabeza;
        while (actual.getSiguiente() != null && !comprobarLibro(actual, isbn)) {
            actual = actual.getSiguiente();
        }
        return comprobarLibro(actual, isbn) ? actual.getLibro() : null;
    }

    private boolean comprobarLibro(Nodo nodo, int isbn) {
        return nodo.getLibro().getIsbn() == isbn;
    }

    public Libro getLibro(int position) {
        if (cabeza == null || longitud < position) {
            return null;
        }

        Nodo actual = cabeza;
        int index = 1;
        while (actual.getSiguiente() != null && index < position){
            actual = actual.getSiguiente();
            index++;
        }

        return index != position ? null : actual.getLibro();
    }

    public int length() {
        return longitud;
    }
}
