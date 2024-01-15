# Colas en Java
- **Características:**
	- **Relación con las Linked List:** Una cola se puede construir a partir de una lista enlazada. Los nodos están unidos desde el principio hasta el final por medio de punteros.
	- **Operaciones simples:** Solo existen tres tipos de operaciones: `Encolar` para introducir algo en la cola, `consultar` para obtener el siguiente elemento de la cola, y `eliminar` para remover el primer elemento de la cola.
## Estructura de una cola
```Java
class Cola {
    private Nodo cabeza;
    private Nodo fin;
	int longitud = 0;
    private class Nodo {
        public String dato;
        public Nodo siguiente;

        public Nodo(String dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }
}
```
En Java, las colas presentan una estructura análoga a la de una lista enlazada. Una cola utiliza un nodo para indicar el inicio de la lista (`cabeza`) y otro nodo para representar el último elemento de la misma (`fin`).
- **Cola vacía:** En caso de que la cola esté vacía, ambos nodos (`cabeza` y `fin`) tienen el valor `null`.
- **Cola con un único elemento:** Cuando la cola solo tiene un elemento, los nodos `cabeza` y `fin` apuntarán a ese único elemento.
- **Nodos:** Las colas, al igual que las [[listas enlazadas]], emplean nodos para añadir objetos. Estos nodos comparten la misma estructura que tendrían en una lista enlazada.
## Encolar
Agrega un elemento al final de la cola. Es similar al método de `agregarFinal` que se utiliza en una lista enlazada, con la diferencia de que el nodo `fin` recibe un tratamiento especial.
1. Cree un nuevo nodo que contenga el elemento que debe agregar.
2. Compruebe si la cola está vacía. Una cola está vacía cuando el primer elemento (`cabeza`) tiene el valor `null`. Si la cola está vacía, dirija el apuntador de `cabeza` hacia el nuevo nodo. 
3. Si la cola no está vacía, agregue el elemento nuevo después del último nodo (nodo `fin`).
4. Por último, dirija el apuntador de `fin` hacia el nuevo nodo y se actualizará el último elemento de la lista.
```Java
public void encolar(String dato) {
	Nodo nuevoNodo = new Nodo(dato);
	
	if (cabeza == null) {
		cabeza = nuevoNodo;
	} else {
		ultimo.siguiente = nuevoNodo;
	}
	
	ultimo = nuevoNodo;
	longitud++;
}
```
## Eliminar 
Elimina el primer elemento de la cola. Comparte la estructura de `eliminarPrimero`, uno de los métodos de las listas enlazadas.
1. Compruebe si la cola está vacía. Una cola está vacía cuando el nodo `cabeza` tiene el valor `null`.
2. Si la cola no está vacía, cree un nodo (`temporal`) que contenga el primer elemento de la cola (`cabeza`).
3. Asigne el valor `null` al nodo `temporal`, así eliminará su apuntador.
4. Reasigne el valor del nodo `cabeza` hacia su siguiente elemento.
5. Si luego de eliminar el primer elemento la lista está vacía, asigne el valor `null` al nodo `fin`. De esta forma la lista estará vacía.
```Java
public void eliminar() {
	if (cabeza == null) return;
	
	Nodo temporal = cabeza;
	temporal.siguiente = null;
	cabeza = cabeza.siguiente;

	if (longitud == 0) {
		ultimo = null;
	}
	
	longitud--;
}
```
## Obtener un elemento
1. Compruebe si la cola está vacía. Una cola está vacía cuando el primer elemento (nodo `cabeza`) esta vacío.
2. Si la cola no está vacía, retorne el dato que se encuentra dentro del nodo. En una cola, se obtiene el primer elemento (dado el order FIFO).
```Java
public String obtener() {
	if (cabeza == null) {
		return null;
	}
	return cabeza.dato;
}
```