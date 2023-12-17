# Listas Enlazadas

## Concepto

Una lista enlazada es una estructura de datos lineal conformada por nodos, donde cada nodo contiene un valor y una referencia al siguiente nodo en la secuencia. A diferencia de las listas estáticas, como los arrays, las listas enlazadas no tienen un tamaño fijo, permitiendo la inserción y eliminación fácil de elementos en cualquier posición.

## Ventajas y Desventajas

**Ventajas:**
- Eficiencia en inserciones y eliminaciones en cualquier posición.
- Dinámicas y pueden crecer o decrecer sin necesidad de redimensionamiento.
- Flexibles para ciertas operaciones en comparación con arrays.

**Desventajas:**
- Mayor consumo de espacio debido a las referencias entre nodos.
- Acceso aleatorio menos eficiente.

## Operaciones

### Estructura de Nodo en Java

```java
public class Nodo {
    public int dato; // O cualquier tipo de dato que desees almacenar
    public Nodo siguiente; // Enlace al siguiente nodo

    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null; // Inicialmente, no hay nodo siguiente
    }
}
```

### Estructura de Lista en Java

```java
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
```

### Agregar Elementos

#### Agregar al Inicio

- Crear un nuevo nodo con el dato que desea insertar.
- Establecer el puntero del nuevo nodo para que apunte al nodo que actualmente es la cabeza de la lista.
- Si la cabeza está vacía (tiene un valor null), apuntar la cabeza hacia el nuevo nodo para establecerlo como el inicio de la lista.


```java
public void insertarPrincipio(Libro libro) {
    Nodo nuevoNodo = new Nodo(libro);
    nuevoNodo.siguiente = cabeza;
    cabeza = nuevoNodo;
    longitud++;
}
```

#### Agregar al Final

- Crear un nuevo nodo con el dato que desea insertar.
- Verificar si la lista está vacía.
- Si está vacía, asignar el nuevo nodo como la cabeza.
- Si no está vacía, avanzar hasta el último nodo de la lista.
- Configurar el puntero del último nodo para que apunte al nuevo nodo.


```java
public void insertarFinal(Libro libro) {
    Nodo nodoNuevo = new Nodo(libro);
    if (cabeza == null) {
        cabeza = nodoNuevo;
        longitud++;
    } else {
        Nodo puntero = cabeza;
        while (puntero.siguiente != null) {
            puntero = puntero.siguiente;
        }
        puntero.siguiente = nodoNuevo;
        longitud++;
    }
}
```

#### Agregar Después de un Elemento

- Crear un nuevo nodo con el dato que desea insertar.
- Comprobar si la lista está vacía.
- Si está vacía, asignar el nuevo nodo como la cabeza.
- Si no está vacía, avanzar hasta el nodo en la posición deseada.
- Conectar el nuevo nodo con el nodo de la derecha.
- Conectar el nuevo nodo por la izquierda.


```java
public void insertarDespues(int n, Libro libro) {
    Nodo nuevoNodo = new Nodo(libro);
    if (cabeza == null) {
        cabeza = nuevoNodo;
        longitud++;
    } else {
        Nodo puntero = cabeza;
        int contador = 0;
        while (puntero.siguiente != null && contador < n) {
            puntero = puntero.siguiente;
            contador++;
        }
        nuevoNodo.siguiente = puntero.siguiente;
        puntero.siguiente = nuevoNodo;
        longitud++;
    }
}
```

### Eliminar Elementos

#### Eliminar al Principio

- Verificar si la lista no está vacía.
Crear un nodo temporal apuntando al primer nodo.
- Actualizar la cabeza para que apunte al siguiente nodo.
- Asignar null al puntero siguiente del nodo temporal.
- Decrementar la longitud de la lista.


```java
public void eliminarPrincipio() {
    if (cabeza != null) {
        Nodo primerNodo = cabeza;
        cabeza = cabeza.siguiente;
        primerNodo.siguiente = null;
        longitud--;
    }
}
```

#### Eliminar al Final

- Verificar si la lista no está vacía.
- Si la lista tiene un solo elemento, asignar null a la cabeza.
- Si la lista tiene más de un elemento, avanzar hasta el penúltimo nodo.
- Asignar null al puntero siguiente del penúltimo nodo.
- Decrementar la longitud de la lista.


```java
public void eliminarUltimo() {
    if (estaVacia()) return;
    if (cabeza.siguiente == null) {
        cabeza = null;
    } else {
        Nodo puntero = cabeza;
        while (puntero.siguiente.siguiente != null) {
            puntero = puntero.siguiente;
        }
        puntero.siguiente = null;
        longitud--;
    }
}
```

#### Eliminar en una Posición Específica

- Verificar si la lista no está vacía y si la posición es válida.
- Si la posición es 0, realizar los pasos de "Eliminar al Principio".
- Avanzar hasta el nodo anterior al que se desea eliminar.
- Crear un nodo temporal apuntando al nodo que se va a eliminar.
- Conectar el nodo anterior con el siguiente del nodo temporal.
- Asignar null al puntero siguiente del nodo temporal.
- Decrementar la longitud de la lista.


```java
public void eliminarLibro(int n) {
    if (cabeza == null || n >= longitud) return;
    if (n == 0) {
        Nodo primerNodo = cabeza;
        cabeza = primerNodo.siguiente;
        primerNodo.siguiente = null;
        longitud--;
    } else {
        Nodo puntero = cabeza;
        int contador = 0;
        while (puntero.siguiente != null && contador < (n - 1)) {
            puntero = puntero.siguiente;
            contador++;
        }
        Nodo temp = puntero.siguiente;
        puntero.siguiente = temp.siguiente;
        temp.siguiente = null;
        longitud--;
    }
}
```

## Cuándo Utilizar una Lista Enlazada

- Inserciones y eliminaciones frecuentes en posiciones arbitrarias.
- Necesidad de un tamaño dinámico que pueda crecer o decrecer.
- Uso eficiente de memoria en situaciones con tamaño desconocido de antemano.
- Acceso secuencial a los elementos.

**Consideraciones:**
- Acceso aleatorio menos eficiente.
- Mayor consumo de espacio debido a las referencias entre nodos.

Las listas enlazadas son ideales en situaciones donde se requieren operaciones frecuentes de inserción o eliminación en cualquier posición de la secuencia.
