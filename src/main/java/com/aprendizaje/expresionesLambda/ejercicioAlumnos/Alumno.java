package main.java.com.aprendizaje.expresionesLambda.ejercicioAlumnos;

public class Alumno {
    private int DNI, edad;
    private String nombre, apellido, curso;

    public Alumno() {}

    public Alumno(
        int DNI, String nombre, String apellido, String curso, int edad) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.curso = curso;
        this.edad = edad;
    }

    public int getDNI() {
        return DNI;
    }
    public void setDNI(int dNI) {
        DNI = dNI;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre
                + "\nApellido: " + apellido
                + "\nDNI: " + DNI
                + "\nCurso: " + curso
                + "\nEdad: " + edad
                + "\n------------------------";
    }
}
