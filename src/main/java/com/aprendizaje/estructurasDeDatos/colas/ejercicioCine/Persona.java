package main.java.com.aprendizaje.estructurasDeDatos.colas.ejercicioCine;

public class Persona {
    private final int edad;
    private final String nombre;

    public Persona(int edad, String nombre) {
        this.edad = edad;
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return '{' +
                "edad=" + edad +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
