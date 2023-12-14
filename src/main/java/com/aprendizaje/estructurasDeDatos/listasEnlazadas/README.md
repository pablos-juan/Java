## Listas Enlazadas

Una lista enlazada es una estructura de datos lineal que consiste en una secuencia de nodos, donde cada nodo contiene un valor y una referencia (o enlace) al siguiente nodo en la secuencia. A diferencia de los arrays o listas estáticas, las listas enlazadas no tienen un tamaño fijo, y los elementos pueden ser fácilmente insertados o eliminados en cualquier posición.

### Lista Simplemente Enlazada (Singly Linked List)

- Cada nodo tiene un enlace que apunta al siguiente nodo en la secuencia.
- El último nodo apunta a `null`.

### Lista Doblemente Enlazada (Doubly Linked List)

- Cada nodo tiene dos enlaces: uno que apunta al siguiente nodo y otro que apunta al nodo anterior.
- El primer nodo y el último nodo apuntan a `null` en sus enlaces respectivos.

### Lista Circular Simplemente Enlazada

- Similar a la lista simplemente enlazada, pero el enlace del último nodo apunta al primer nodo, creando un ciclo.

### Lista Circular Doblemente Enlazada

- Similar a la lista doblemente enlazada, pero el enlace del último nodo apunta al primer nodo y el enlace del primer nodo apunta al último nodo.

**Ventajas:**
- Permiten una inserción y eliminación eficientes en cualquier posición.
- No requieren un tamaño fijo y pueden crecer o decrecer dinámicamente.
- Son más flexibles que los arrays para ciertos tipos de operaciones.

**Desventajas:**
- Requieren más espacio de almacenamiento debido a los enlaces.
- El acceso aleatorio a los elementos es menos eficiente.

En resumen, las listas enlazadas son estructuras de datos flexibles y dinámicas que pueden ser útiles en situaciones donde se necesitan operaciones frecuentes de inserción o eliminación de elementos en medio de la secuencia.

