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
## Lambda para `stream`
Las expresiones lambda son frecuentemente utilizadas en `stream` para operaciones de `filtrado`, `mapeo` y `reducción`. `stream` convierte una lista en un flujo de datos al que se aplican las operaciones.
```Java
ArrayList<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

// Filtrar números pares
ArrayList<Integer> pares = numeros.stream()
		.filter(n -> n % 2 == 0)
		.collect(Collectors.toList());
```
### Métodos en `stream` 
- **`filter()`:** #filter
	- El método `filter` acepta `predicate`como parámetro, una interfaz que evalúa una condición y devuelve un valor `boolean`. Por lo mismo, el resultado de la operación dentro de `filter` es de tipo `boolean`.
	- La estructura de `filter` está compuesta por un parámetro (de tipo inferido, por lo general), una flecha `->` y una condición. Agregue brackets `{}` luego de la flecha en caso de necesitar un bloque de código, para definir el retorno de la operación use `return`.
		```Java
		ArrayList<Integer> mayoresQue = new ArrayList<>(numeros
                .stream()
                .filter(n -> n > 5)
                .toList());
                
        System.out.println("FILTRADOS: MAYORES QUE 5");
        mayoresQue.forEach(System.out::println);
		```
- **`min()` y `max()`:** #min #max
	- Ambos son métodos usan un `comparator` como parámetro para encontrar el elemento mínimo y máximo respectivamente. El resultado de ambas operaciones es un `Optional`, lo que significa que puede contener o no un valor.
	- Dado que el este tipo de métodos producen un `Optional` es necesario agregar métodos como `orElse` (en caso de no encontrar ningún valor) o `ifElse` (en caso de que el valor sí esté presente).
		```Java
		System.out.println("ALUMNO CON MENOR EDAD: " +  
	        alumnos.stream()  
	                .min(Comparator.comparingInt(Alumno::getEdad))  
	                .map(Alumno::getNombre)  
	                .orElse("sin alumnos"));
		```
- **`map()`:** #map 
	- El método `map` transforma los elementos de `stream` según la operación definida. Esta operación puede ser definida previamente usando la interfaz `Function`.
	- Dado un parámetro, `map` puede realizar operaciones como transformar valores, concatenar variables con `String`, lógicas matemáticas o incluso recuperar propiedades de un objeto. De esta manera el método `map` retorna un valor o un parámetro.
		```Java
		numeros.stream()
                .map(x -> x * x)
                .filter(x -> x > 5 && x <= 30)
                .forEach(System.out::println);
		```
- **`sorted()`:** #sorted
	- Este método ordena los elementos de un `stream` o una colección. `sorted` admite como parámetro un `comparator` personalizado o puede usarse el orden natural de los elementos, de ser posible.
	- Dado que `sorted` es una operación intermedia, debe concatenarse otro elemento para terminar el flujo de datos.
		```Java
		List<String> palabras = Arrays.asList(
				"perro", "gato", "elefante", "abeja"); 
				
		// Orden léxico gráfico (orden natural de las cadenas)
		List<String> palabrasOrdenadas = palabras
				.stream()
				.sorted(Comparator.naturalOrder())
				.toList();
		```
		Los métodos de ordenamiento más comunes para la interfaz `comparator` son:
		- **`naturalOrder`:** ordena las cadenas y los caracteres en orden alfabético. Los números de menor a mayor. Si usa el método `sorted` sin parámetros, los elementos seguirán el orden natural. Su opuesto directo es `reverseOrder`.
		- **`comparingInt`:** compara valores de tipo `int`. Es realmente útil cuando debe ordenar, por ejemplo, según la longitud de una cadena (obteniendo la longitud cada cadena). Para revertir el orden use el método `reversed`.
- **`anyMatch()`:** #anyMatch
	- Este método verifica si al menos un elemento en el `stream` cumple con cierta condición. `anyMatch` retorna un `boolean`, si al menos un elemento cumple con la condición retorna `true`, de lo contrario es `false`. Esta operación es de corto circuito, tan pronto encuentre una coincidencia, la evaluación se detendrá y retornará `true`.
	- Dado que usa `predicate` como parámetro, asegúrese de encontrar una condición válida para la evaluación.
		```Java
		boolean contieneJ = nombres.stream()
	                .anyMatch(nombre ->
				                nombre.toLowerCase().contains("i")
				                );
	        System.out.println(
			        "HAY UN NOMBRE QUE CONTIENE LA LETRA J: " 
					+ contieneJ);
		```
- **`allMatch()`:** #allMatch
	- Verifica si todos los elementos en el `stream` cumplen con cierta condición. Si la condición se cumple, retorna `true`, de lo contrario retorna `false`. Por lo mismo, su retorno es de tipo `boolean`.
	- Esta operación también es de corto circuito, en cuanto uno de los elementos incumpla la condición, la evaluación se detiene y retorna `false`.
		```Java
		boolean iniciaConP = nombres.stream()
	                .allMatch(nombre -> 
		                nombre.toLowerCase().startsWith("p"));
		separador();
	    System.out.println(
					"ALL. Todos los nombres inician en 'P': "
					+ iniciaConP
	    );
		```
- **`noneMatch()`:** #noneMatch
	- El método `noneMatch` es una operación de los `stream` que verifica si ninguno de los elementos cumple una condición. Si ninguno de los elementos cumple con la condición retorna `true`, de lo contrario retornará `false`.
		```Java
		boolean noTerminaEnE = nombres.stream()
                .noneMatch(nombre -> 
	                nombre.toLowerCase().endsWith("e"));
		separador();
		System.out.println(
                        "NONE. Ningún nombre termina en 'E': "
                        + noTerminaEnE
		);
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