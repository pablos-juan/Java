## Excepciones en Java

En Java, una excepción es un evento imprevisto o no deseado que ocurre durante la ejecución de un programa y que interrumpe el flujo normal de ejecución. Las excepciones en Java se manejan mediante el sistema de manejo de excepciones integrado en el lenguaje.

### Tipos de Excepciones

#### Excepciones Verificadas

Las excepciones verificadas (checked exceptions) son aquellas que el compilador obliga a manejar, ya sea a través de la cláusula `throws` en la firma del método o mediante el manejo directo con un bloque `try-catch`. Algunos ejemplos de excepciones verificadas incluyen:

- `IOException`: Para manejar errores de entrada/salida.
- `SQLException`: Para manejar errores relacionados con bases de datos.
- `FileNotFoundException`: Para manejar errores cuando un archivo no puede ser encontrado.

```java
try {
    // Código que puede lanzar una excepción verificada
} catch (IOException e) {
    // Manejo de la excepción
}
