package main.java.com.aprendizaje.estructurasDeDatos.arboles;

public class Nodo {
    private Character valor;
    private Nodo left, right;
        
    public Nodo(Character valor) {
        this.valor = valor;
    }

    public Character getValue() {
        return valor;
    }

    public void setValue(Character valor) {
        this.valor = valor;
    }

    public Nodo getLeft() {
        return left;
    }

    public void setLeft(Nodo left) {
        this.left = left;
    }

    public Nodo getRight() {
        return right;
    }

    public void setRight(Nodo right) {
        this.right = right;
    }
}
