package main.java.com.aprendizaje.expresionesLambda.ejercicioGarage;

public class Vehiculo {
    private String matricula;
    private Marca marca;
    private int km;

    public Vehiculo(String matricula, Marca marca, int km) {
        this.matricula = matricula;
        this.marca = marca;
        this.km = km;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    @Override
    public String toString() {
        return "{Matrícula: " + matricula
                + ", Marca: " + marca
                + ", Kilómetros: " + km
                + "}";
    }
}
