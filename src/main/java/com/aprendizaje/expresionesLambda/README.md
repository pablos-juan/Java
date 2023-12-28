# Expresiones lambda
Las expresiones lambda fueron introducidas en Java 8 y son una característica importante del lenguaje que da solución a la sintaxis en las clases anónimas de un solo método. Las expresiones lambda permiten escribir de manera más concisa y expresiva ciertos tipos de funciones.
- **Características:**
	- Las expresiones lambda proporcionan una sintaxis concisa para definir funciones en línea.
	- Pueden ser cero o más parámetros.
	- Si hay un solo parámetro y su tipo puede ser inferido, los paréntesis pueden ser omitidos.
- **Usos comunes:**
	- Las expresiones lambda son comúnmente utilizadas en combinación con Java Streams para realizar operaciones de filtrado, mapeo y reducción de datos.
## Uso de expresiones lambda
- **Sintaxis básica:** la sintaxis básica de una expresión lambda se compone de parámetros, una flecha `->` y el cuerpo de la expresión: `(parámetros -> expresión)`.
	```Java
	(int a, int b) -> a + b;
	```
- **Tipos de parámetros:**
	- En muchas situaciones, el tipo de parámetro puede ser omitido y el compilador de Java lo inferirá. 
	- Si hay un solo parámetro sin tipo, los paréntesis también pueden ser omitidos.
	```Java
	// Expresión lambda con tipos de parámetros inferidos
	(a, b) -> a + b;
	```
- **Bloques de código en expresiones lambda:** el cuerpo de una expresión lambda puede ser una expresión simple o un bloque de código.
	```Java
	(a, b) -> {
	    int resultado = a + b;
	    return resultado;
	};
	```
- **Métodos de referencia:** Java también proporciona métodos de referencia como una forma más concisa de expresar ciertos tipos de expresiones lambda.
	```Java
	// Imprime cada elemento de la lista
	mayoresQue.forEach(System.out::println);
	```
## Lambda para Streams
- Las expresiones lambda son frecuentemente utilizadas en Java Streams para operaciones de `filtrado`, `mapeo` y `reducción`. 
- Facilitan la programación funcional y mejoran la legibilidad del código.
```Java
ArrayList<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

// Filtrar números pares
ArrayList<Integer> pares = numeros.stream()
		.filter(n -> n % 2 == 0)
		.collect(Collectors.toList());
```
## Interfaces funcionales
- Las expresiones lambda son más utilizadas con interfaces funcionales.
- Una interfaz funcional es una interfaz que tiene un solo método abstracto. 
- Pueden contener múltiples métodos predeterminados o estáticos, pero solo con un método básico.
```Java
// Ejemplo de interfaz funcional
@FunctionalInterface
interface Operacion {
    int calcular(int a, int b);
}

// Uso de una expresión lambda con la interfaz funcional
Operacion suma = (a, b) -> a + b;
```