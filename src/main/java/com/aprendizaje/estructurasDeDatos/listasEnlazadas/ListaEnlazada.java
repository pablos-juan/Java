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
            Nodo puntero = cabeza;
            while (puntero.siguiente != null) {
                puntero = puntero.siguiente;
            }
            puntero.siguiente = nodoNuevo;
            longitud++;
        }
    }

    public void insertarDespues(int posicion, String dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (cabeza == null) { // Comprobar si la lista está vacía
            cabeza = nuevoNodo;
            longitud++;
        } else {
            Nodo puntero = cabeza;
            int contador = 0; // Indica la posición del puntero
            while (puntero.siguiente != null && contador < posicion) {
                puntero = puntero.siguiente;
                contador++;
            }
            /**
             * * Reordenar los punteros del nuevo nodo:
             * El apuntador del nuevo nodo debe señalar el
             * nodo siguiente al nodo del puntero
             * El apuntador del nodo actual (puntero) debe 
             * dirigirse hacia el nuevo 
             */
            nuevoNodo.siguiente = puntero.siguiente;
            puntero.siguiente = nuevoNodo;
            longitud++;
        }
    }

    public String obtenerElemento(int posicion) {
        /**
         * Comprobar si la lista está vacía
         * Comprobar si la posición es válida
         */
        if (cabeza == null && posicion > longitud) {
            return null;
        } else {
            Nodo puntero = cabeza;
            int contador = 0;
            while (contador < posicion && puntero.siguiente != null) {
                puntero = puntero.siguiente;
            }
            return contador != posicion ? null : puntero.dato;
        }
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
            Nodo puntero = cabeza;
            /**
             * *Recorrer la lista hasta encontrar el penúltimo elemento
             * Cuando el siguiente del siguiente del puntero esté vacío
             */
            while (puntero.siguiente.siguiente != null) {
                puntero = puntero.siguiente;
            }
            puntero.siguiente = null;
            longitud--;
        }
    }

    public void eliminarElemento(int posicion) {
        if (cabeza == null || posicion >= longitud) return;
        if (posicion == 0) { // Para eliminar el primer elemento
            Nodo primerNodo = cabeza;
            cabeza = primerNodo.siguiente;
            primerNodo.siguiente = null;
            longitud--;
        } else {
            Nodo puntero = cabeza;
            int contador = 0;
            while (puntero.siguiente != null && contador < (posicion - 1)) {
                puntero = puntero.siguiente;
                contador++;
            }
            /**
             * * Reasignar punteros:
             * Poner el elemento a eliminar en un nodo temporal
             * El siguiente del puntero, será redirigido
             * hacia la propiedad siguiente del nodo temporal
             * Eliminar el apuntador del nodo temporal
             */
            Nodo temp = puntero.siguiente;
            puntero.siguiente = temp.siguiente;
            temp.siguiente = null;
            longitud--;
        }
    }

    public void imprimirLista() {
        if (cabeza != null) {
            Nodo actual = cabeza;
            while (actual != null) {
                System.out.println(actual.dato);
                actual = actual.siguiente;
            }
        }
    }
}