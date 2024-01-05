# Genéricos
Los `Generics` fueron añadidos en Java 5. Permiten que una clase o un método sea definido con un parámetro de tipo `<T>`, que puede representar diferentes tipos de datos.
- **Características:**
	- **Fomento de la reutilización de código:** Un método o una función pueden aprovechar un parámetro genérico, permitiendo la aplicación de diversas operaciones sin depender del tipo de dato.
	- **Prevención de errores de tipo en tiempo de compilación:** Dado que los genéricos no están vinculados a un tipo específico, posibilitan la operación con cualquier tipo de dato, evitando errores de tipo durante la compilación.
## Declaración e inicialización
- **Genéricos en una clase:** Para declarar una clase de tipo genérico, declare su tipo dentro de `wildcards`. Cuando declare clase, tendrá que definir su tipo dependiendo de sus necesidades.
	```Java
	public class MiClaseGenerica<T> {
		private T dato;
	
		public void setDato(T nuevoDato) {
			this.dato = nuevoDato;
		}
	
		public T getDato() {
			return dato;
		}
	}
	```
	Los genéricos usan diferentes convenciones, `<T>` es una de ellas. Estas convenciones sugieren el tipo de dato que espera recibir la clase. Las convenciones más comunes para parámetros de tipo son:
	- **`E`:** Element (comúnmente usado en colecciones, como en `ArrayList<E>`).
	- **`K`:** Key (usado para mapas, como en `HashMap<K, V>`).
	- **`V`:** Value (también utilizando en mapas).
	- **`N`:** Number (utilizado en clases que operan con números, como en `List<Number>`).
	- **`S`, `U`, `V`, etc.:** Segundo, tercero, cuarto, etc. (cuando hay múltiples parámetros de tipo).
- **Genéricos en una función:** Para una función, agregue un genérico (como `<T>`) después de tipo de retorno. Además, agregue el tipo genérico dentro de los parámetros.
	```Java
	public static <T> void cambio(T[] array, int indice1, int indice2) {
        if (indice1 >= 0 && indice1 < array.length
		        && indice2 >= 0 && indice2 < array.length) {
            T temp = array[indice1];
            array[indice1] = array[indice2];
            array[indice2] = temp;
        }
    }
	```