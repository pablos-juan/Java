package main.java.com.aprendizaje.estructurasDeDatos.listasEnlazadas;

public class Listas {

    private Nodo cabeza;
    private int longitud = 0;

    private class Nodo {
        public Libro libro;
        public Nodo siguiente = null;

        public Nodo(Libro libro) {
            this.libro = libro;
        }
    }

    public void insertarPrincipio(Libro libro) {
        //crear un nodo nuevo que conteanga un libro
        Nodo nuevoNodo = new Nodo(libro);
        //configurar el puntero para que apunte
        //al nodo que es cabeza de la lista
        nuevoNodo.siguiente = cabeza;
        //asignar el nuevo nodo como cabeza
        cabeza = nuevoNodo;
        longitud++;
    }

    public void insertarFinal(Libro libro) {
        //crear nueva lista
        Nodo nodoNuevo = new Nodo(libro);
        //verificar si la lista está vacía
        if (cabeza == null) {
            //si está vacía el nuevo nodo es ahora la cabeza
            cabeza = nodoNuevo;
            longitud++;
        } else {
            //nodo especial, inicializar en cabeza
            Nodo puntero = cabeza;
            //puntero avanza mientras el nodo siguiente no sea nulo
            while (puntero.siguiente != null) {
                puntero = puntero.siguiente;
            }
            //configurar puntero del último nodo para que ahora
            //apunte al nuevo nodo
            puntero.siguiente = nodoNuevo;
            longitud++;
        }
    }

    //insertar despues del libro en la posición n
    public void insertarDespues(int n, Libro libro) {
        Nodo nuevoNodo = new Nodo(libro);
        //comprobar si la lista está vacía
        if (cabeza == null) {
            cabeza = nuevoNodo;
            longitud++;
        } else {
            Nodo puntero = cabeza;
            //contador indica la posicion del libro al que señala
            //el puntero
            int contador = 0;
            while (puntero.siguiente != null && contador < n) {
                puntero = puntero.siguiente;
                contador++;
            }
            //conectar el nuevo nodo con el nodo de la derecha
            nuevoNodo.siguiente = puntero.siguiente;
            //connectar el nuevo nodo por la izquierda
            puntero.siguiente = nuevoNodo;
            longitud++;
        }
    }

    //obtener informacion
    public Libro obtenerLIbro(int n) {
        //comprobar si la lista está vacía
        if (cabeza == null) {
            return null;
        } else {
            Nodo puntero = cabeza;
            int contador = 0;
            //recorrer la lista
            while (contador < n && puntero.siguiente != null) {
                puntero = puntero.siguiente;
            }
            //retornar el libro en la posición del puntero
            return contador != n ? null : puntero.libro;
        }
    }

    public int getLongitud() {
        //mucho mas eficiente que recorrer la lista
        return longitud;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    //eliminar el primer elemento de la lista
    public void eliminarPrincipio() {
        if (cabeza != null) {
            //crear un nodo para eliminar el puntero
            //del primer nodo
            Nodo primerNodo = cabeza;
            //reasignar la cabeza de la lista
            cabeza = cabeza.siguiente;
            //reasignar el puntero siguiente de nodo a eliminar
            //para que apunte a null
            primerNodo.siguiente = null;
            longitud--;
        }
    }

    public void eliminarUltimo() {
        if (estaVacia()) return;
        //si la lista solo tiene un elemento
        if (cabeza.siguiente == null) {
            cabeza = null;
        } else {
            Nodo puntero = cabeza;
            //recorrer la lista hasta encontrar el penúltimo elemento
            //cuando siguiente del siguiente sea igual a null
            // puntero -> ° -> null
            while (puntero.siguiente.siguiente != null) {
                puntero = puntero.siguiente;
            }
            puntero.siguiente = null;
            longitud--;
        }
    }

    //eliminar un libro en la posición n
    public void eliminarLibro(int n) {
        if (cabeza == null || n >= longitud) return;
        if (n == 0) {
            //eliminarPrincipio();
            Nodo primerNodo = cabeza;
            cabeza = primerNodo.siguiente;
            primerNodo.siguiente = null;
            longitud--;
        } else {
            Nodo puntero = cabeza;
            int contador = 0;
            //avanzar hasta encontrar el elemento anterior al que
            //debe eliminarse
            while (puntero.siguiente != null && contador < (n - 1)) {
                puntero = puntero.siguiente;
                contador++;
            }
            //guarde el elemento a eliminar en un nodo temporal
            //en este caso es el siguiente del puntero
            Nodo temp = puntero.siguiente;
            //asgine el siguiente del puntero al siguiente del nodo temporal
            //puntero -> nodoEliminar -> nodo
            puntero.siguiente = temp.siguiente;
            //elimine el puntero del nodo temporal
            temp.siguiente = null;
            //puntero -> nodo
            longitud--;
        }
    }
}