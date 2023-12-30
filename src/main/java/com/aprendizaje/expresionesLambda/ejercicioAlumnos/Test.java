package main.java.com.aprendizaje.expresionesLambda.ejercicioAlumnos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Alumno> alumnos = new ArrayList<>();
        alumnos.add(new Alumno(
            20221, "Juan", "Castaño", "Lenguaje", 18));
        alumnos.add(new Alumno(
            30322, "María", "Gómez", "Matemáticas", 20));
        alumnos.add(new Alumno(
            40423, "Pedro", "López", "Historia", 19));
        alumnos.add(new Alumno(
            50524, "Ana", "Martínez", "Ciencias", 21));
        alumnos.add(new Alumno(
            60625, "Luis", "Sánchez", "Inglés", 22));
        alumnos.add(new Alumno(
            70726, "Laura", "Pérez", "Física", 20));
        alumnos.add(new Alumno(
            80827, "Sara", "Rodríguez", "Sociales", 23));
        alumnos.add(new Alumno(
            90928, "Javier", "Fernández", "Arte", 18));
        alumnos.add(new Alumno(
            10129, "Carmen", "Díaz", "Química", 24));
        alumnos.add(new Alumno(
            11230, "Leandro", "Ruiz", "Biología", 19));

        System.out.println("ALUMNOS EN LISTA:");
        alumnos.forEach(System.out::println);

        System.out.println("NOMBRES EMPEZADOS EN 'S' O 'L'");
        alumnos.stream()
                .filter(alumno -> alumno.getNombre().startsWith("S")
                        || alumno.getNombre().startsWith("L"))
                .forEach(System.out::println);

        System.out.println("NUMERO DE ALUMNOS: " + alumnos.size());

        System.out.println("ALUMNO CON MENOR EDAD: " +
                alumnos.stream()
                        .min(Comparator.comparingInt(Alumno::getEdad))
                        .map(Alumno::getNombre)
                        .orElse("sin alumnos"));

        System.out.println("ALUMNO CON MAYOR EDAD: " +
                alumnos.stream()
                        .max(Comparator.comparingInt(Alumno::getEdad))
                        .map(Alumno::getNombre)
                        .orElse("sin alumnos"));

        System.out.println("ALUMNOS CON CURSOS TERMINADOS EN 'a':");
        alumnos.stream()
                .filter(alumno -> alumno.getCurso().endsWith("a"))
                .map(alumno -> alumno.getNombre() + " " + alumno.getApellido())
                .forEach(System.out::println);

        System.out.println("ALUMNOS EN CURSOS CON NOMBRES QUE CONTIENEN LA LETRA 'e':");
        alumnos.stream()
                .filter(alumno -> alumno.getCurso().toLowerCase().contains("e"))
                .map(alumno -> alumno.getNombre() + " " + alumno.getApellido())
                .forEach(System.out::println);

        System.out.println("ALUMNOS CON MAS DE 5 LETRAS EN SU NOMBRE:");
        alumnos.stream()
                .filter(alumno -> alumno.getNombre().length() > 5)
                .forEach(alumno -> System.out.println(alumno.getNombre()));
    }
}
