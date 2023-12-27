# Listas enlazadas
Una lista enlazada es una estructura de datos lineal conformada por nodos, donde cada nodo contiene un valor y una referencia al siguiente nodo en la secuencia. A diferencia de las listas estáticas, como los arrays, las listas enlazadas no tienen un tamaño fijo, permitiendo la inserción y eliminación fácil de elementos en cualquier posición.
- **Características:**
	- Eficiencia en inserciones y eliminaciones en cualquier posición.
	- Dinámicas y pueden crecer o decrecer sin necesidad de re dimensionamiento.
	- Flexibles para ciertas operaciones en comparación con arrays.
	- Mayor consumo de espacio debido a las referencias entre nodos.
	- Acceso aleatorio menos eficiente.
- **Uso común:**
	- Inserciones y eliminaciones frecuentes en posiciones arbitrarias.
	- Necesidad de un tamaño dinámico que pueda crecer o decrecer.
	- Uso eficiente de memoria en situaciones con tamaño desconocido de antemano.
	- Acceso secuencial a los elementos.
- **Variantes:**
	- **Lista simple:** Cada nodo tiene un enlace al siguiente nodo.
	- **Lista doble:** Cada nodo tiene enlaces tanto al siguiente como al anterior nodo.
	- **Lista circular:** El último nodo está vinculado al primer nodo, creando un bucle.
## Estructura de Lista en Java
```java
public class Lista {
	/**
	 * Cabeza apunta hacia el primer nodo de la lista
	 * Longitud almacena el tamaño de la lista
	 */
    Nodo cabeza = null;
    int longitud = 0;
    
    public class Nodo {
        public String dato;
        public Nodo siguiente;
        
        public Nodo(String dato) {
            this.dato = dato;
            this.siguiente = null; 
        }
    }
}
```
El nodo `cabeza` se utiliza comúnmente para referirse al primer nodo de la lista y sirve como punto de partida para acceder a los demás nodos. Algunas razones para agregar un nodo `cabeza` podrían ser: 
- **Simplifica la manipulación de la lista:** al tener un nodo `cabeza`, siempre hay un punto de entrada constante para la lista. No es necesario tratar con casos especiales si se tiene un nodo cabeza. 
- **Manejo de listas vacías:** cuando una lista está vacía, el nodo `cabeza` tiene el valor `null`. Esto facilita el reconocimiento y operación de una lista vacía.
- **Acceso constante al primer elemento:** el nodo `cabeza` permite un acceso rápido y constante al primer elemento de la lista.
## Estructura de Nodo en Java
```java
public class Nodo {
	/**
	 * Indicar el tipo de dato que contiene el nodo
	 * Los datos pueden ser de cualquier tipo
	 * Siguiente es el enlace al nodo contiguo
	 * Inicialmente, siguiente está vacío
	 */
    public String dato;
    public Nodo siguiente = null;
    
    public Nodo(String dato) {
        this.dato = dato;
    }
}
```
## Agregar Elementos
- **Agregar al inicio:**
	1. Cree un nuevo nodo con el dato que debe insertarse.
	2. Dirija el apuntador del nodo nuevo, hacia el nodo que actualmente es `cabeza` de la lista.
	3. Si el nodo `cabeza` está vacío (tiene el valor `null`), el apuntador debe dirigirse hacia el nuevo nodo para establecerlo como `cabeza`.
	```java
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
	```
- **Agregar al final:**
	1. Cree un nuevo nodo con el dato que debe insertarse.
	2. Verifique si la lista está vacía. Si está vacía, asigne el nuevo nodo como `cabeza` de la lista.
	3. Si no está vacía, recorra la lista con un bucle `while` hasta encontrar el último nodo. El último nodo tiene el valor `null` en el nodo `siguiente`.
	4. Configure el apuntador del último nodo para que señale al nuevo nodo como su `siguiente`. De esta manera, el nuevo nodo será el nodo final.
	```java
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
	```
- **Agregar después de un elemento:**
	1. Cree un nuevo nodo con el dato que debe insertarse.
	2. Compruebe si la lista está vacía. Si está vacía, asigne el nuevo nodo como `cabeza` de la lista.
	3. Si no está vacía, avance hasta el nodo en la posición donde debe insertarse mediante un bucle `while`. Además, es necesario definir un `contador`, para conocer la posición del `puntero`. El bucle se detendrá cuando el `contador` y la posición sean iguales.
	4. Dirija el apuntador del nuevo nodo hacia el nodo `siguiente` del `puntero`, así estará conectado por la derecha.
	5. Para conectar el nuevo nodo por su izquierda, dirija el apuntador del `puntero` hacia el nodo `siguiente` del mismo. De esta manera, el nodo `siguiente` del `puntero` será el nuevo nodo.
	```java
	public void insertarDespues(int posicion, String dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (cabeza == null) { // Comprobar si la lista está vacía
            cabeza = nuevoNodo;
            longitud++;
        } else {
            Nodo puntero = cabeza;
            int contador = 0; // Indica la posición del puntero
            while (puntero.siguiente != null 
			        && contador < posicion) {
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
	```
## Eliminar Elementos
- **Eliminar el primer elemento:**
	1. Verifique si la lista está vacía, si no lo está continúe con los pasos.
	2. Cree un nodo temporal (`primerNodo`), que apunte a `cabeza`.
	3. Actualice la posición del primer elemento (`cabeza`) moviendo el apuntador de `cabeza` al `siguiente` nodo.
	4. Elimine el apuntador del nodo temporal (`primerNodo`) asignando a su `siguiente` el valor `null`.
	```java
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
	```
- **Eliminar al Final:**
	1. Verificar si la lista está vacía o si solo tiene un elemento. Si está vacía termine el método. Si solo tiene un elemento asigne a `cabeza` el valor `null`, así la lista quedará vacía.
	2. Recorra la lista con un bucle `while` hasta encontrar el penúltimo nodo. Reconocerá el penúltimo elemento cuando el nodo `siguiente` del `siguiente` del `puntero` tenga el valor `null` (está vacío). De esta manera, el `puntero` señalará al penúltimo nodo.
	3. Remueva el `siguiente` nodo del `puntero` asignando el valor `null` a su apuntador. De esta manera, el penúltimo nodo (`apuntador`) será ahora el último elemento.
	```java
	public void eliminarUltimo() {
        if (estaVacia()) return;
        // En caso de tener solo un elemento
        if (cabeza.siguiente == null) {
            cabeza = null;
        } else {
            Nodo puntero = cabeza;
            /**
             * *Encontrar el penúltimo elemento
             * Cuando el siguiente del siguiente 
             * del puntero esté vacío
             */
            while (puntero.siguiente.siguiente != null) {
                puntero = puntero.siguiente;
            }
            puntero.siguiente = null;
            longitud--;
        }
    }
	```
- **Eliminar en una posición:**
	1. Si la lista no está vacía y la posición no es mayor que la `longitud` continúe con los pasos. 
	2. Si debe eliminar el primer elemento (posición 0), siga los pasos de *eliminar principio*, o llame al método directamente.
	3. Si el dato a eliminar no está en la primera posición, recorra la lista con un bucle `while` hasta que el `contador` y la posición menos uno sean iguales. Así, el `siguiente` del `puntero` será el elemento a eliminar.
	4. Cree un nodo temporal que señale el elemento que debe eliminar (el `siguiente` del `puntero`).
	5. Enlace el `siguiente` del `puntero` con el nodo `siguiente` del nodo `temporal`. De esta manera, el `puntero` señalará al nodo inmediatamente después del nodo eliminado.
	6. Elimine el apuntador del nodo temporal asignando el valor `null` a su propiedad `siguiente`.
	7. Asignar null al puntero siguiente del nodo temporal.
	8. Decrementar la longitud de la lista.
	```java
	public void eliminarLibro(int posicion) {
        if (cabeza == null || posicion >= longitud) return;
        if (posicion == 0) { // Para eliminar el primer elemento
            Nodo primerNodo = cabeza;
            cabeza = primerNodo.siguiente;
            primerNodo.siguiente = null;
            longitud--;
        } else {
            Nodo puntero = cabeza;
            int contador = 0;
            while (puntero.siguiente != null 
		            && contador < (posicion - 1)) {
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
	```
## Obtener un elemento
1. Asegúrese de que la lista no esté vacía. La lista está vacía cuando el nodo `cabeza` tiene el valor `null`. Además, compruebe que la posición del elemento no es mayor a la longitud de la lista. 
2. Use un nodo `puntero` para recorrer la lista y un `contador`. El `contador` compara la posición del `puntero` con la posición del elemento que necesita. Recorra la lista con un bucle `while`, este avanzará hasta que el `contador` y la posición sean iguales.
3. Si después de recorrer la lista el `contador` no es igual a la posición retorne el valor `null`. En caso contrario retorne el `dato` el nodo al que señala el `puntero`.  
```Java
public String obtenerElemento(int posicion) {
		/**
         * Comprobar si la lista está vacía
         * Comprobar si la posición es válida
         */
        if (cabeza == null) {
            return null;
        } else {
            Nodo puntero = cabeza;
            int contador = 0;
            while (contador < posicion 
		            && puntero.siguiente != null) {
                puntero = puntero.siguiente;
            }
            return contador != posicion ? null : puntero.dato;
        }
    }
```
## Imprimir lista
1. Compruebe que la lista no esté vacía. La lista está vacía cuando el nodo `cabeza` tiene el valor `null`.
2. Si la lista no está vacía, use un bucle `while` para recorrer e imprimir los elementos.
```Java
public void imprimirLista() {
        if (cabeza != null) {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                System.out.println(actual.dato);
                actual = actual.siguiente;
            }
        }
    }
```