# Fundamentos
## Variables
En Java, una variable es un espacio de almacenamiento con un nombre que se utiliza para almacenar datos que pueden cambiar durante la ejecución del programa. Las variables deben declararse con un tipo de datos específico. 
```Java
// Declaración de una variable entera
int edad;

// Declaración e inicialización de una variable
int numero = 42;
```
- **Tipos de variables:**
	- **Primitivos:** Representan valores simples. Ejemplos: `int`, `double`, `char`, `boolean`.
	- **Referencia:** Almacenan referencias a objetos. Ejemplos: `String`, `Object`, tipos definidos por el usuario.
## Tipos de datos
Java es un lenguaje de programación de tipado estático, lo que significa que los tipos de datos de las variables deben ser declarados explícitamente. Algunos tipos de datos comunes en Java son:
- **Tipos primitivos**
	- `int`: Entero.
	- `double`: Punto flotante.
	- `char`: Carácter.
	- `boolean`: Valor Boolean (`true` o `false`).
- **Tipos de referencia**
	- `String`: Secuencia de caracteres.
	- `Object`: Clase base para todos los objetos en Java.
	- Tipos definidos por el usuario (clases, interfaces, etc.).
## Operadores
Los operadores en Java son símbolos especiales que realizan operaciones en variables y valores. Algunos operadores comunes son:
- **Operadores aritméticos:**
	```Java
	int a = 10, b = 20;
	int suma = a + b;
	int resta = a - b;
	int multiplicacion = a * b;
	int division = a / b;
	int modulo = a % b;
	```
- **Operadores de asignación:**
	```Java
	int x = 5;
	x += 3; // Equivalente a x = x + 3
	x += 3;
	```
- **Operadores de comparación:**
	```Java
	int num1 = 10, num2 = 20;
	boolean igual = (num1 == num2);
	boolean noIgual = (num1 != num2);
	```
- **Operadores lógicos:**
	```Java
	boolean condicion1 = true, condicion2 = false;
	boolean resultadoAnd = condicion1 && condicion2;
	boolean resultadoOr = condicion1 || condicion2;
	boolean resultadoNot = !condicion1;
	```
- **Operadores de incremento y decremento:**
	```Java
	int contador = 5;
	contador++;  // Incremento
	contador--;  // Decremento
	```