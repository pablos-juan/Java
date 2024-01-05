package main.java.com.aprendizaje.expresionesLambda.ejercicioCine;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie ("E.T.", "Steven Spielberg", 1982));
        movies.add(new Movie("Avatar", "James Cameron", 2009));
        movies.add(new Movie("Salvar al soldado Ryan", "Steven Spielberg", 1998));
        movies.add(new Movie("Origen", "Christopher Nolan", 2010));
        movies.add(new Movie ("L.A. Confidential", "Curtis Hanson", 1997));

        System.out.println("ESTRENOS A PARTIR DEL 2000:");
        List<Movie> estrenos = movies.stream()
                .filter(movie -> movie.getEstreno() >= 2000)
                .toList();
        estrenos.forEach(System.out::println);
        separador();

        System.out.println("PELÍCULAS DE STEVEN SPIELBERG:");
        String stevenMovies = movies.stream()
                .filter(m -> m.getDirector().equals("Steven Spielberg"))
                .map(Movie::getTitulo)
                .collect(Collectors.joining(", "));
        System.out.println(stevenMovies);
        separador();

        System.out.println("PELÍCULAS ORDENADAS ALFABÉTICAMENTE:");
        List<String> orderedList = movies.stream()
                .map(Movie::getTitulo)
                .sorted()
                .toList();
        orderedList.forEach(System.out::println);
        separador();

        System.out.println("ESTRENO MÁS RECIENTE:");
        Movie estreno = movies.stream()
                .max(Comparator.comparingInt(Movie::getEstreno))
                .orElse(null);
        System.out.println(estreno);
    }

    public static void separador() {
        System.out.println(
                "------------------------------------------------------------------------"
        );
    }
}
