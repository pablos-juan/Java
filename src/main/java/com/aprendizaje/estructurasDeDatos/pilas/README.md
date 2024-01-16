# Pilas en Java
#java #estructuras_de_datos 
Una pila o *stack* es una colección ordenada de elementos de cualquier tipo en la cual los datos se agregan o retiran por el mismo extremo llamado "cima", "tope" o la parte superior de la pila.
- **Características:**
	- **Last In, First Out (LIFO):** El último elemento añadido a la pila será el primero en salir.
	- **Restricciones de acceso:** En una pila solo puede acceder al elemento más reciente (el tope de la pila). Otros elementos más antiguos están "ocultos" y no puede acceder a ellos hasta que se retiren los elementos más recientes.
	- **Eficiencia de tiempo:** Las operaciones `push` y `pop` en una pila suelen ser de tiempo constante, ya que solo afectan al elemento más reciente.
## Apilar
Introduce un elemento en la pila. Es similar al método `insertarPrincipio` de una [[listas enlazadas]]. Los elementos se introducen por el extremo superior de la pila.
1. Cree un nodo nuevo que contenga el elemento que debe agregar al pila.
2. Apunte el nodo nuevo al nodo `cima`, de tal forma que ahora el siguiente del nuevo nodo sea el primer elemento de la pila.
3. Dado que ahora el primer elemento es el nuevo nodo, asigne al nodo `cima` el nuevo nodo.
	```Java
	public void push(T elemento) {
        Nodo<T> nuevoNodo = new Nodo<>(elemento);
        nuevoNodo.setSiguiente(cima);
        cima = nuevoNodo;
        longitud++;
    }
	```
## Pop
Elimina el último elemento introducido en la pila. Es similar al método `eliminarPrimero` de una [[listas enlazadas]]. Los elementos serán eliminados por el mismo extremo en que fueron introducidos. Este método retorna el primer valor de la pila y luego lo elimina.
1. Comprueba si la pila está vacía. Si lo está, retorne el valor `null`.
2. Si no está vacía, cree un nodo temporal que contenga el nodo `cima`.
3. Mueva el nodo `cima` hacia el siguiente elemento.
4. Elimine el apuntador de nodo temporal asignándole el valor `null`. 
	```Java
	public void pop() {
        if (cima == null) {
            return;
        }

        Nodo temporal = cima;
        cima = cima.siguiente;
        temporal.siguiente = null;
        longitud--;
    }
	```