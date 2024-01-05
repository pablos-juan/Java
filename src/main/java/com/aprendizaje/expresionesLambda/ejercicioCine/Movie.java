package main.java.com.aprendizaje.expresionesLambda.ejercicioCine;

public class Movie {
    private String titulo, director;
    private int estreno;
    private boolean disponible;

    public Movie(String titulo, String director, int estreno) {
        this.titulo = titulo;
        this.director = director;
        this.estreno = estreno;
    }

    public Movie(String titulo, String director, int estreno, boolean disponible) {
        this.titulo = titulo;
        this.director = director;
        this.estreno = estreno;
        this.disponible = disponible;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getEstreno() {
        return estreno;
    }

    public void setEstreno(int estreno) {
        this.estreno = estreno;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return  '{' + titulo +
                ", director: " + director +
                ", estreno: " + estreno +
                ", disponible: " + disponible +
                '}';
    }
}
