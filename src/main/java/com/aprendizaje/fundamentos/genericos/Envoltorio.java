package main.java.com.aprendizaje.fundamentos.genericos;

public class Envoltorio<T> {
    private final T tipoObjeto;

    public Envoltorio(T tipoObjeto) {
        this.tipoObjeto = tipoObjeto;
    }

    public T get() {
        return tipoObjeto;
    }

    public void mostrar() {
        System.out.println("Caja[" + tipoObjeto + ']');
    }

    @Override
    public String toString() {
        return "Caja[" + tipoObjeto.toString() + ']';
    }
}
