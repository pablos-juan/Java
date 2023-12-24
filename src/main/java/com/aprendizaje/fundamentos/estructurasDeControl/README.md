# Estructuras de control
#java #fundamentos 
En Java, las estructuras de control son mecanismos que permiten modificar el flujo de ejecución de un programa. Estas estructuras son fundamentales para tomar decisiones, repetir acciones y controlar el flujo general de un programa. Las estructuras de control en Java incluyen:

## Estructuras de decisión (condicionales)
- **if:** Permite ejecutar un bloque de código si una condición es verdadera. 
	- **`if`:** Es la palabra clave que inicia la estructura de control. Indica que se va a evaluar una condición y, si es verdadera, se ejecutará el bloque de código asociado.
	- **`condición`:** Es una expresión `Boolean` que se evalúa como verdadera o falsa. Si la condición es verdadera, el bloque de código dentro del `if` se ejecutará. Si es falsa, el bloque de código se omitirá.
	- **`{}` (bloque de código):** Encierra el conjunto de instrucciones que se ejecutarán si la condición es verdadera. Puede contener una o más declaraciones.
- **else-if:** Permite evaluar múltiples condiciones en secuencia.
	- **`else if`:** Esta es una extensión del `if` que se utiliza para evaluar una condición si todas las condiciones anteriores (precedentes) han sido falsas.
	- **Bloques de código:** Cada bloque de código asociado a un `if` o `else if` se ejecutará si su condición correspondiente es verdadera.
- **switch:** Permite seleccionar entre múltiples opciones. En java 12 fueron introducidos cambios en su sintaxis con la adición de las [[Switch expressions]].
	- **`switch`:** Esta es la palabra clave que inicia la estructura de control. Se coloca seguida de la expresión que se evaluará.
	- **`case`:** Cada `case` proporciona una opción específica que se comparará con el valor de la expresión. Si hay coincidencia, se ejecuta el bloque de código asociado al `case`. Si no hay coincidencia, se pasa al siguiente `case`.
	- **`break`:** Es importante incluir `break` después de cada bloque de código asociado a un `case` para evitar que la ejecución continúe hacia los `case` siguientes. Si se omite el `break`, la ejecución continuará en los `case` siguientes aunque no haya coincidencia.
	- **`default`:** Si ninguno de los `case` coincide con el valor de la expresión, se ejecuta el bloque de código asociado a `default`. No es obligatorio incluir `default`, pero es útil para manejar casos no previstos.
## Estructuras de repetición (bucles) 
- **for:** Permite ejecutar un bloque de código un número específico de veces mediante un índice. 
	- **`for`:** La palabra clave que inicia la estructura de control. Se utiliza seguida de paréntesis que contienen tres partes: la inicialización, la condición de continuación y la expresión de actualización.
	- **Inicialización (`int i = 1`):** Se ejecuta una vez al principio y se utiliza para declarar e inicializar la variable de iteración (`i` en este caso).
	- **Condición de continuación (`i <= 5`):** Se evalúa antes de cada iteración. Si es verdadera, se ejecuta el bloque de código dentro del `for`; de lo contrario, se sale del bucle.
	- **Expresión de actualización (`i++`):** Se ejecuta al final de cada iteración y generalmente se utiliza para incrementar o decrementar la variable de iteración (`i` en este caso).
	- **Bloque de código (`{}`):** Contiene las instrucciones que se ejecutan en cada iteración del bucle.
- **while:** Ejecuta un bloque de código mientras una condición sea verdadera.
	- **`while`:** La palabra clave que inicia la estructura de control. Se utiliza seguida de una condición en paréntesis.
	- **Condición (`i <= 5`):** Se evalúa antes de cada iteración. Si es verdadera, se ejecuta el bloque de código dentro del `while`; de lo contrario, se sale del bucle.
	- **Bloque de código (`{}`):** Contiene las instrucciones que se ejecutan en cada iteración del bucle.
- **do-while:** Similar a `while`, pero garantiza que el código se ejecutará al menos una vez antes de verificar la condición.
	- **`do`:** La palabra clave que inicia la estructura de control `do-while`.
	- **Bloque de código (`{}`):** Contiene las instrucciones que se ejecutan en cada iteración del bucle.
	- **`while`:** La palabra clave que indica la condición que se evaluará después de ejecutar el bloque de código.
	- **Condición (`i <= 5`):** Se evalúa después de cada iteración. Si es verdadera, el bucle se repetirá; de lo contrario, se sale del bucle.