# Colecciones
#java #fundamentos #colecciones 
Las colecciones en Java son objetos que pueden contener múltiples elementos. A diferencia de los arrays, las colecciones son dinámicas y pueden cambiar de tamaño durante la ejecución del programa. Algunas de las interfaces y clases principales en el marco de colecciones de Java son:
## ArrayList
- **Características:**
	- Implementa la interfaz `List`.
	- Dinámico y redimensionable.
	- Permite agregar, eliminar y acceder a elementos eficientemente.
- **Uso común:**
	- Necesitas acceso rápido a elementos mediante índices.
	- Realizas operaciones frecuentes de lectura y recorrido secuencial.
	- El tamaño de la lista no cambia con frecuencia, y la mayoría de las operaciones son de lectura.
- **Evitar cuando:**
	- Necesitas realizar operaciones frecuentes de inserción o eliminación en posiciones intermedias de la lista.
	- La lista puede cambiar con frecuencia y prefieres una estructura de datos dinámica.
```Java
ArrayList<String> listaNombres = new ArrayList<>();
listaNombres.add("Juan");
listaNombres.add("María");
```
## Listas enlazadas
- **Características:**
	- Implementa la interfaz `List`.
	- Eficiente para la inserción y eliminación en el medio de la lista.
	- Proporciona acceso secuencial.
- **Uso común:**
	- Realizas operaciones frecuentes de inserción y eliminación en posiciones intermedias de la lista.
	- El redimensionamiento de las operaciones de inserción y eliminación es más crítico que el acceso por índice.
- **Evitar cuando:**
	- Necesitas acceso rápido a elementos mediante índices.
	- Realizas principalmente operaciones de lectura y recorrido secuencial.
```Java
LinkedList<Integer> listaNumeros = new LinkedList<>();
listaNumeros.add(1);
listaNumeros.add(2);
```
## HashSet
- **Características:**
	- Implementa la interfaz `Set`.
	- No permite elementos duplicados.
	- Eficiente para la búsqueda y adición.
- **Uso común:**
	- Necesitas almacenar elementos únicos.
	- Realizas operaciones frecuentes de búsqueda, inserción y eliminación de elementos únicos.
	- No necesitas una asociación clave-valor.
- **Evitar cuando:**
	- Necesitas mantener un orden específico en los elementos.
	- Quieres asociar valores específicos con los elementos almacenados.
```Java
LinkedList<Integer> listaNumeros = new LinkedList<>();
listaNumeros.add(1);
listaNumeros.add(2);
```
## HashMap
- **Características:**
	- Implementa la interfaz `Map`.
	- Almacena pares clave-valor.
	- Permite la búsqueda eficiente por clave.
- **Uso común:**
	- Necesitas asociar claves únicas con valores.
	- Realizas operaciones frecuentes de búsqueda, inserción y eliminación basadas en claves.
	- La relación entre claves y valor es esencial.
- **Evitar cuando:**
	- Es prescindible asociar clave-valor.
	- Estás trabajando con tipos primitivos y no se requieren objetos clave.
```Java
HashMap<String, Integer> mapaEdades = new HashMap<>();
mapaEdades.put("Juan", 25);
mapaEdades.put("María", 30);
```
## Iteración a través de Colecciones
```Java
//iteración a través de una lista
for (String nombre : listaNombres) {
    System.out.println(nombre);
}

//iteración a través de un conjunto
for (String nombre : conjuntoNombres) {
    System.out.println(nombre);
}

//iteración a través de un mapa
for (Map.Entry<String, Integer> entry : mapaEdades.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}
```