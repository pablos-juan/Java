# `Arrays` en Java
#java #fundamentos 
## `Array` unidimensional
Un array en Java es una estructura de datos que almacena un conjunto fijo de elementos del mismo tipo. Se trata de un objeto que proporciona un espacio contiguo en memoria para almacenar datos de manera eficiente.
- **Características:**
	- **Tipo de Elementos:** Todos los elementos dentro de un array deben ser del mismo tipo, ya sea primitivo o un objeto.
	- **Tamaño Fijo:** El tamaño de un array es fijo y se establece en el momento de su creación. No puede cambiarse dinámicamente.
	- **Índices:** Los elementos del array se acceden mediante índices. El índice comienza en 0 y va hasta el tamaño del array menos uno.
- **Usos Comunes:**
	- **Almacenamiento de Datos Homogéneos:** Los arrays son útiles para almacenar conjuntos de datos homogéneos, como una lista de calificaciones, identificadores, etc.
	- **Manipulación de Datos en Lote:** Se utilizan para realizar operaciones en lotes sobre conjuntos de datos, como realizar operaciones matemáticas en cada elemento de un array.
	- **Algoritmos de Búsqueda y Ordenación:** Los arrays son fundamentales en algoritmos de búsqueda y ordenación, ya que proporcionan acceso eficiente a elementos mediante índices.
	- **Representación de Grillas o Matrices:** En el caso de arrays multidimensionales, como matrices, se utilizan para representar grillas de datos, como tablas bidimensionales.
### Operaciones
- **Declaración e Inicialización:** Declaración e inicialización de un array de enteros con tamaño 5.
   ```java
   int[] miArray = new int[5]; 
   ```
- **Acceso a Elementos:** Asigna el valor 10 al primer elemento, luego recupera el valor del segundo elemento.
   ```java
   miArray[0] = 10; 
   int valor = miArray[1]; 
   ```
- **Iteración:** Recorrido de un `Array` mediante un índice.
   ```java
   for (int i = 0; i < miArray.length; i++) {
       System.out.println(miArray[i]);
   }
   ```
- **Longitud del Array:** Obtiene el tamaño del array.
   ```java
   int longitud = miArray.length;
   ```
En resumen, los arrays en Java son fundamentales para la manipulación eficiente de conjuntos de datos homogéneos y se utilizan ampliamente en programación para una variedad de propósitos.
## `Array` bidimensional
Es una estructura de datos que almacena elementos en filas y columnas. A diferencia de un array unidimensional, que es una lista lineal, un array bidimensional se asemeja a una cuadrícula o tabla. Puedes pensar en ello como un conjunto de arrays unidimensionales organizados de manera que forman filas y columnas.
- **Características:**
	- **Tipo de Elementos:** Al igual que en un array unidimensional, todos los elementos en un array bidimensional deben ser del mismo tipo.
	- **Tamaño Fijo:** El tamaño en ambas dimensiones se establece al crear el array bidimensional y no puede modificarse dinámicamente.
	- **Índices:** Se utilizan dos índices para acceder a un elemento en un array bidimensional: uno para la fila y otro para la columna.
- **Usos Comunes:**
	- **Representación de Datos Tabulares:** Los arrays bidimensionales se utilizan comúnmente para representar datos tabulares, como una matriz de calificaciones de estudiantes.
	- **Imágenes y Gráficos:** En el procesamiento de imágenes, un array bidimensional puede representar píxeles en una imagen.
	- **Tableros de Juegos:** Se utilizan para representar tableros de juegos como ajedrez, damas, etc.
## Operaciones
- **Declaración e Inicialización:** Declaración e inicialización de un array bidimensional de 3 filas y 4 columnas.
   ```java
   int[][] miArrayBidimensional = new int[3][4];
   ```
- **Acceso a Elementos:** Asigna el valor 10 al elemento en la primera fila, segunda columna. Depués recupera el valor del elemento en la tercera fila, cuarta columna.
   ```java
   miArrayBidimensional[0][1] = 10;
   int valor = miArrayBidimensional[2][3];
   ```
- **Iteración:**
   ```java
   for (int i = 0; i < miArrayBidimensional.length; i++) {
       for (int j = 0; j < miArrayBidimensional[i].length; j++) {
           System.out.print(miArrayBidimensional[i][j] + " ");
       }
       System.out.println(); // Salto de línea al final de cada fila
   }
   ```
- **Longitud del Array en Cada Dimensión:** Obtiene el número de filas. Luego obtiene el número de columnas (asumiendo que todas las filas tienen la misma longitud).
   ```java
   int filas = miArrayBidimensional.length;
   int columnas = miArrayBidimensional[0].length;
   ```
En resumen, los arrays bidimensionales en Java son útiles para organizar datos en una estructura de cuadrícula y se aplican en situaciones donde los datos están naturalmente dispuestos en filas y columnas.