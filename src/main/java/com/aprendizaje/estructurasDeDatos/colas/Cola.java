package main.java.com.aprendizaje.estructurasDeDatos.colas;

public class Cola {

    private class Nodo {
        public String dato;
        public Nodo siguiente;

        public Nodo(String dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    Nodo cabeza, ultimo;
    int longitud = 0;

    /**
     * Introduce un elemento dentro de un nodo y lo agrega
     * al final de la cola
     * @param dato Elemento que será agregado
     */
    public void encolar(String dato) {
        Nodo nuevoNodo = new Nodo(dato);
        /**
         * Comprobar si la cola está vacía
         * Si lo está, apuntar la cabeza hacia el nodo nuevo
         * Si no está vacía, agregar el elemento nuevo
         * después del último nodo
         */
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            ultimo.siguiente = nuevoNodo;
        }
        // Asignar el nuevo elemento como el final de la cola
        ultimo = nuevoNodo;
        longitud++;
    }

    /**
     * Elimina el primer elemento de la cola
     */
    public void eliminar() {
        /**
         * Comprobar si la cola no está vacía
         * Si no lo está, usar un nodo temporal que señale el primer
         * elemento de la cola (cabeza) y eliminar su apuntador
         * Mueva la cabeza hacia el siguiente elemento de la cola
         */
        if (cabeza == null) return;
        Nodo temporal = cabeza;
        temporal.siguiente = null;
        cabeza = cabeza.siguiente;

        if (longitud == 0) {
            // Si la cola está vacía, el último nodo debe está vacío también
            ultimo = null;
        }
        longitud--;
    }

    /**
     * @return Primer elemento de la cola
     */
    public String obtener() {
        if (cabeza == null) {
            return null;
        }
        return cabeza.dato;
    }
}
