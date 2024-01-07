# Prueba teatro
#trainee #todoCode
Suponer un sistema de reserva de asientos para un anfiteatro. El teatro cuenta con 10 filas de 10 asientos cada una. Se necesita desarrollar un sistema (sin uso de bases de datos, únicamente manejo de datos de forma lógica) que permita llevar a cabo lo siguiente:
1. Cargar la **matriz de las filas y asientos.** Indicando con una `X` los asientos ocupados y con `L` los asientos libres. Al iniciar el programa, todos los asientos debe estar libres.
2. Manejar la **reserva de asientos contemplando** que un asiento solo puede ser reservado si se encuentra en estado `L`. En caso de que su estado sea `X`, debe permitir al comprador elegir otro asiento. Si se encuentra en estado `L`, deberá pasar automáticamente al estado `X`.
3. Para finalizar el programa deberá ingresar un valor en particular. Contemplar que no existe una cantidad exacta de veces que el programa se pueda ejecutar.
5. En caso de que un cliente solicita visualizar cuáles son los asientos libres, el sistema debe mostrar por consola los asientos.