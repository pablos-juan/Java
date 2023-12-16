# Listas enlazadas

Una lista enlazada es una estructura de datos lineal que consiste en una secuencia de nodos, donde cada nodo contiene un valor y una referencia (o enlace) al siguiente nodo en la secuencia. A diferencia de los arrays o listas estáticas, las listas enlazadas no tienen un tamaño fijo, y los elementos pueden ser fácilmente insertados o eliminados en cualquier posición.

## Lista simplemente enlazada (Singly Linked List)

- Cada nodo tiene un enlace que apunta al siguiente nodo en la secuencia.
- El último nodo apunta a `null`.

## Lista doblemente enlazada (Doubly Linked List)

- Cada nodo tiene dos enlaces: uno que apunta al siguiente nodo y otro que apunta al nodo anterior.
- El primer nodo y el último nodo apuntan a `null` en sus enlaces respectivos.

## Lista circular simplemente enlazada

- Similar a la lista simplemente enlazada, pero el enlace del último nodo apunta al primer nodo, creando un ciclo.

## Lista circular doblemente enlazada

- Similar a la lista doblemente enlazada, pero el enlace del último nodo apunta al primer nodo y el enlace del primer nodo apunta al último nodo.

**Ventajas:**
- Permiten una inserción y eliminación eficientes en cualquier posición.
- No requieren un tamaño fijo y pueden crecer o decrecer dinámicamente.
- Son más flexibles que los arrays para ciertos tipos de operaciones.

**Desventajas:**
- Requieren más espacio de almacenamiento debido a los enlaces.
- El acceso aleatorio a los elementos es menos eficiente.

## Estructura

En Java, la estructura básica de un nodo para una lista simplemente enlazada podría verse así:

~~~java
public class Nodo {
    public int dato; // O cualquier tipo de dato que desees almacenar
    public Nodo siguiente; // Enlace al siguiente nodo

    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null; // Inicialmente, no hay nodo siguiente
    }
}
~~~

Puede resultar útil implementar una estructura llamada Lista. Este tipo de estructura puede guardar la cabeza o la longitud de la lista. Por ejemplo:

~~~java
public class Lista {
    Nodo cabeza = null;
    int longitud = 0;

    public class Nodo {
        public int dato; // O cualquier tipo de dato que desees almacenar
        public Nodo siguiente; // Enlace al siguiente nodo

        public Nodo(int dato) {
            this.dato = dato;
            this.siguiente = null; // Inicialmente, no hay nodo siguiente
        }
    }
}
~~~

Agregar algo como esto puede ayudar a obtener rapidamente la longitud de una lista sin, la necesidad de recorrer la lista cada vez que se solicite una consulta de este tipo. 

## Agregar elementos 

La adición de elementos a una lista enlazada implica la creación de un nuevo nodo y la actualización de los enlaces apropiados. A continuación, se muestra un ejemplo de cómo agregar un nuevo nodo al final de una lista simplemente enlazada:

### Agregar al inicio

1. Crear un nuevo nodo con el dato que desea insertar. 
2. Establecer el puntero del nuevo nodo para que apunte al nodo que actualmente es la cabeza de la lista.
3. Si la cabeza está vacía tiene un valor `null`. Apuntar la cabeza hacia el nuevo nodo para establecerlo como el inicio de la lista.

~~~Java
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
~~~

Dentro de la estructura nodo suele añadirse otro nodo con valor nulo, este nodo indica el fin de la lista. 

### Agregar al final

Para realizar una inserción al final, se requiere recorrer la lista. Además de crear un nuevo nodo que contendrá el objeto añadido a la lista, es necesario introducir un nodo especial conocido como puntero. Este puntero, que refleja el elemento actual, inicialmente apuntará hacia la cabeza de la lista.

1. Inicialmente, el puntero señalará la cabeza. La cabeza siempre es el primer elemento de una LinkedList.
2. Mediante un bucle el puntero seguirá moviéndose hasta que el nodo siguiente al que está apuntado tenga un valor nulo, esto refleja el final de la lista.
3. Cuando el bucle encuentre el final de la lista, inserte el nuevo nodo. Para esto, configure el apuntador del último nodo para que apunte hacia el nuevo nodo.

~~~Java
public void insertarFinal(Libro libro) { //recorrer la lista
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
~~~

### Agregar después de un elemento

El mecanismo para insertar un objeto dentro de una lista enlazada podría resumirse en recorrer la lista, encontrar la posición y reorganizar los punteros.

1. Después de recorrer la lista el puntero se detendrá en la posición anterior al nodo donde se desea realizar la inserción, en este caso, el nodo 2.
2. Encontrada la posición, el puntero del nodo nuevo debe apuntar hacia el nodo 2.
Esto se logra asignando la posición siguiente del puntero a la posición siguiente del puntero. 
3. Una vez esté conectado el nuevo nodo por la derecha, deben configurarse los punteros del nodo anterior (en este caso el nodo 1) para que apunten hacia el nodo nuevo: el puntero siguiente del nodo 1 será el nuevo nodo.

~~~Java
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
~~~

Además de crear un nuevo nodo es necesario comprobar dos casos extremos, si la lista está vacía o si el elemento será insertado en la posición 0.
- En el primer caso, el nuevo nodo será asignado a la cabeza directamente.
- En el otro caso debe insertarse el elemento siguiendo las instrucciones que se usan para insertar al inicio. Incluso, de tener el método en la misma clase puede usarse dentro de la función para realizar la inserción.

## Eliminar elementos

La eliminación de elementos en una lista enlazada implica modificar los enlaces entre los nodos. A continuación, se muestra un ejemplo de cómo eliminar un nodo específico de una lista simplemente enlazada:

### Eliminar primer elemento

Para eliminar el primer elemento de una lista enlazada debe reemplazarse el primer elemento de la lista por su siguiente. Basicamente debe crearse un nodo nuevo y asignarlo como `cabeza`, hecho esto se actualiza la `cabeza` para que apunte al segundo nodo.  

~~~Java
//eliminar el primer elemento de la lista
public void eliminarPrincipio() {
    if (cabeza != null) {
        Nodo primerNodo = cabeza;
        //reasignar la cabeza de la lista
        cabeza = cabeza.siguiente;
        //reasignar el puntero siguiente de nodo a eliminar
        //para que apunte a null
        primerNodo.siguiente = null;
        longitud--;
    }
}
~~~

### Eliminar último elemento

Para eliminar el último elemento de una lista enlazada, se debe recorrer la lista hasta llegar al penúltimo elemento y eliminar el enlace que apunta hacia el último nodo.

~~~Java
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
~~~

Claro, aquí tienes una versión mejorada del texto:

"Además, es necesario verificar si la lista está vacía o si contiene únicamente un elemento. Si la lista está vacía o solo tiene un elemento, se procede a asignar `null` a la cabeza. En el caso de que la lista contenga solo un elemento, se realiza esta asignación para vaciar la lista; en caso contrario, el método se detiene si la lista está vacía."

### Eliminar un elemento en una posicion `n`

Primeramente, debe asegurarse que la lista no esté vacía o que la posición del libro a eliminar esté dentro de la lista, si alguna de éstas dos condiciones es verdadera no es posible eliminar el elemento. 

~~~Java
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
~~~

Si la posición `n` es 0, significa que deseas eliminar el primer elemento de la lista. En este caso, simplemente actualiza la cabeza para que apunte al siguiente nodo.


## Cuando debería utilizar una Linked List?

Aquí hay algunas situaciones en las que podría considerar el uso de una lista enlazada en lugar de otras estructuras de datos en Java, como matrices o ArrayLists:

- **Inserción y eliminación frecuente en medio de la lista:**
Las listas enlazadas son eficientes para la inserción y eliminación de elementos en cualquier posición de la lista, ya que solo se requiere cambiar las referencias de los nodos cercanos, en lugar de desplazar elementos como en una matriz.

- **Tamaño dinámico:**
Las listas enlazadas no tienen un tamaño fijo como las matrices, lo que significa que pueden crecer o reducirse dinámicamente según sea necesario sin necesidad de copiar elementos.

- **Uso eficiente de memoria:**
Las listas enlazadas pueden ser más eficientes en términos de memoria en comparación con las matrices, especialmente cuando el tamaño de la lista es desconocido de antemano y puede cambiar.

- **Acceso secuencial:**
Si va a acceder a los elementos de la lista de manera secuencial, una lista enlazada puede ser una buena elección, ya que permite un acceso rápido a los elementos siguientes.

- **Estructuras de datos anidadas:**
Puede ser útil cuando se necesitan estructuras de datos anidadas o cuando se construyen estructuras de datos más complejas.

Sin embargo, hay algunas consideraciones importantes a tener en cuenta:

- **Acceso aleatorio más lento:**
Las listas enlazadas no ofrecen un acceso aleatorio eficiente como lo hace una matriz. Si necesita acceder a elementos de manera aleatoria con frecuencia, una lista enlazada puede no ser la mejor opción.

- **Uso de memoria adicional:**
Las listas enlazadas pueden consumir más memoria debido a las referencias adicionales que se almacenan junto con los datos.

Las listas enlazadas son estructuras de datos flexibles y dinámicas que pueden ser útiles en situaciones donde se necesitan operaciones frecuentes de inserción o eliminación de elementos en medio de la secuencia.
