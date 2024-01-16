package main.java.com.aprendizaje.estructurasDeDatos.listasEnlazadas.ejercicioBiblioteca;

public class Libro {
    private final String titulo;
    private final String autor;
    private final int isbn;

    public Libro(String titulo, String autor, int isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return String.format("{%s, %s, %d}", titulo, autor, isbn);
    }
}
