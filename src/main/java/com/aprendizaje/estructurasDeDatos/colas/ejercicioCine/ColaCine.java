package main.java.com.aprendizaje.estructurasDeDatos.colas.ejercicioCine;

public class ColaCine {

    private class Nodo {
        public Persona persona;
        public Nodo siguiente = null;

        public Nodo(Persona persona) {
            this.persona = persona;
        }
    }

    private Nodo cabeza;
    private Nodo ultimo;
    private int longitud;

    public void encolar(Persona persona) {
        Nodo nuevoNodo = new Nodo(persona);

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

        Nodo temporal = cabeza;
        cabeza = cabeza.siguiente;
        temporal.siguiente = null;

        if (longitud == 0) {
            ultimo = null;
        }

        longitud--;
    }

    public Persona getPersona() {
        if (cabeza == null) {
            return null;
        }
        Nodo temporal = cabeza;
        eliminar();
        return temporal.persona;
    }

    public void print() {
        if (cabeza == null) {
            System.out.println("ERROR. COLA VACÍA");
            return;
        }

        Nodo actual = cabeza;
        while (actual.siguiente == null) {
            System.out.println(cabeza.persona);
            actual = actual.siguiente;
        }
    }

    public boolean isEmpty() {
        return cabeza == null;
    }

    public int size() {
        return longitud;
    }
}
