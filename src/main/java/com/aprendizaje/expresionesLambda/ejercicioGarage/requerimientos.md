# Ejercicio Garage
Construir una lista de vehículos. Cada vehículo debe tener los siguientes atributos:
- matrícula
- marca
- kilómetros
## Operaciones
- Listar los vehículos por marca y placa -> forEach
- Listar convertir los kilómetros a millas y mostrarlos según la placa -> forEach
- Listar todos los vehículos marca AUDI -> filter
- Ordenar los vehículos por cantidad de kilómetros -> sorted
- Listar todos las marcas sin que se repitan -> distinct
- Listar todos lo vehículos con mas de 20000 kilómetros -> filter
- Agrupar los vehículos por modelo -> Collectors.groupingBy
- Sumar los kilómetros de los vehículos -> reduce
- Listar 2 vehículos con kilómetros menores o iguales a 10000 -> limit