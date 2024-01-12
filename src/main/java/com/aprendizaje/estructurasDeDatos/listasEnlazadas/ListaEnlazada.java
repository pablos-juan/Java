package main.java.com.aprendizaje.estructurasDeDatos.listasEnlazadas;

public class ListaEnlazada {
    private Nodo cabeza;
    private int longitud = 0;

    private class Nodo {
        public String dato;
        public Nodo siguiente = null;

        public Nodo(String dato) {
            this.dato = dato;
        }
    }

    public int getLongitud() {
        return longitud;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    //* Insertar elementos
    public void insertarPrincipio(String dato) {
        /**
         * * Crear y agregar un nodo nuevo:
         * Crear un nodo nuevo y asignarle el dato
         * El apuntador del nodo nuevo debe señalar la cabeza
         * Además, el nodo nuevo debe asignarse como cabeza
         */
        Nodo nuevoNodo = new Nodo(dato);
        nuevoNodo.siguiente = cabeza;
        cabeza = nuevoNodo;
        longitud++;
    }

    public void insertarFinal(String dato) {
        Nodo nodoNuevo = new Nodo(dato);
        if (cabeza == null) { // Comprobar si la lista está vacía
            cabeza = nodoNuevo;
            longitud++;
        } else {
            /**
             * * Puntero es un nodo especial,
             * señala el nodo actual
             * Debe inicializarse en el nodo que encabeza la lista
             */
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nodoNuevo;
            longitud++;
        }
    }

    public void insertarDespues(int posicion, String dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (cabeza == null) { // Comprobar si la lista está vacía
            cabeza = nuevoNodo;
            longitud++;
        } else {
            Nodo actual = cabeza;
            int index = 0; // Indica la posición del actual
            while (actual.siguiente != null && index < posicion) {
                actual = actual.siguiente;
                index++;
            }
            /**
             * * Reordenar los punteros del nuevo nodo:
             * El apuntador del nuevo nodo debe señalar el
             * nodo siguiente al nodo del actual
             * El apuntador del nodo actual (actual) debe
             * dirigirse hacia el nuevo 
             */
            nuevoNodo.siguiente = actual.siguiente;
            actual.siguiente = nuevoNodo;
            longitud++;
        }
    }

    public String obtenerElemento(int posicion) {
        /**
         * Comprobar si la lista está vacía
         * Comprobar si la posición es válida
         */
        if (cabeza == null || posicion > longitud) {
            return null;
        }
        Nodo actual = cabeza;
        int index = 0;
        while (actual.siguiente != null && index < posicion) {
            actual = actual.siguiente;
        }
        return index != posicion ? null : actual.dato;
    }

    //* Eliminar elementos
    public void eliminarPrincipio() {
        if (cabeza != null) {
            /**
             * * Reasignar la cabeza de la lista:
             * Crear un nodo temporal que contenga el primer nodo
             * La cabeza debe apuntar al nodo siguiente
             * Remover el apuntador del primer nodo
             */
            Nodo primerNodo = cabeza;
            cabeza = cabeza.siguiente;
            primerNodo.siguiente = null;
            longitud--;
        }
    }

    public void eliminarUltimo() {
        if (estaVacia()) return;
        // En caso de tener solo un elemento
        if (cabeza.siguiente == null) {
            cabeza = null;
        } else {
            Nodo actual = cabeza;
            /**
             * *Recorrer la lista hasta encontrar el penúltimo elemento
             * Cuando el siguiente del siguiente del actual esté vacío
             */
            while (actual.siguiente.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = null;
            longitud--;
        }
    }

    public void eliminarElemento(int posicion) {
        if (cabeza == null || posicion > longitud) return;
        if (posicion == 0) { // Para eliminar el primer elemento
            Nodo primerNodo = cabeza;
            cabeza = primerNodo.siguiente;
            primerNodo.siguiente = null;
            longitud--;
        } else {
            Nodo actual = cabeza;
            int index = 1;
            while (actual.siguiente != null && index < posicion) {
                actual = actual.siguiente;
                index++;
            }
            /**
             * * Reasignar punteros:
             * Poner el elemento a eliminar en un nodo temporal
             * El siguiente del puntero, será redirigido
             * hacia la propiedad siguiente del nodo temporal
             * Eliminar el apuntador del nodo temporal
             */
            Nodo temporal = actual.siguiente;
            actual.siguiente = temporal.siguiente;
            temporal.siguiente = null;
            longitud--;
        }
    }

    public void imprimirLista() {
        if (cabeza == null) return;

        Nodo actual = cabeza;
        while (actual != null) {
            System.out.println(actual.dato);
            actual = actual.siguiente;
        }
    }
}