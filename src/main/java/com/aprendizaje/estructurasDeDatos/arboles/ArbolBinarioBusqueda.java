package main.java.com.aprendizaje.estructurasDeDatos.arboles;

public class ArbolBinarioBusqueda {
    private Nodo raiz;

    public void add(Character valor) {
        raiz = addValue(raiz, valor);
    }

    private Nodo addValue(Nodo nodo, Character valor) {
        if (nodo == null) {
            return new Nodo(valor);
        }
        /**
         * Si el valor a insertar es menor que el valor del nodo actual,
         * inserte el valor en el subárbol izquierdo
         * Si el valor es mayor, inserte el valor en el subárbol derecho
         */
        if (valor < nodo.getValue()) {
            nodo.setLeft(addValue(nodo.getLeft(), valor));
        } else if (valor > nodo.getValue()) {
            nodo.setRight(addValue(nodo.getRight(), valor));
        } else {
            // Si el valor ya está dentro del árbol lanza una excepción
            throw new IllegalArgumentException("Valor duplicado: " + valor);
        }
        return nodo;
    }

    public void delete(Character valor) {
        raiz = deleteValue(raiz, valor);
    }

    private Nodo deleteValue(Nodo nodo, Character valor) {
        if (nodo == null) {
            return nodo;
        }

        if (valor < nodo.getValue()) {
            nodo.setLeft(deleteValue(nodo.getLeft(), valor));
        } else if (valor > nodo.getValue()) {
            nodo.setRight(deleteValue(nodo.getRight(), valor));
        } else {
            /**
             * * Si el valor es igual al valor del nodo actual ese debe eliminarse
             * Caso 1: El nodo tiene al menos un hijo nulo (o es una hoja)
             * Si el subárbol izquierdo es nulo, retornar el subárbol derecho
             * Si el subárbol derecho es nulo, retornar el subárbol izquierdo
             */
            if (nodo.getLeft() == null) {
                return nodo.getRight();
            }
            
            if (nodo.getRight() == null) {
                return nodo.getLeft();
            }

            /**
             * Caso 2, nodo con dos hijos: Obtener el sucesor inOrden
             * Nodo más pequeño en el subárbol derecho 
             */
            nodo.setValue(findMinValue(nodo.getRight()));
            nodo.setRight(deleteValue(nodo.getRight(), nodo.getValue()));
        }
        return nodo;
    }

    private Character findMinValue(Nodo nodo) {
        return nodo.getLeft() != null ? findMinValue(nodo.getLeft())
                : nodo.getValue();
        /* Character minValue = nodo.getValue();
        while (nodo.getLeft() != null) {
            minValue = nodo.getLeft().getValue();
            nodo = nodo.getLeft();
        }
        return minValue; */
    }

    public void getValue(Character valor) {
        System.out.println(search(raiz, valor));
    }

    private Character search(Nodo nodo, Character valor) {
        if (nodo == null) {
            return null;
        }

        if (valor.equals(nodo.getValue())) {
            return nodo.getValue();
        }

        return valor < nodo.getValue() ? search(nodo.getLeft(), valor)
                : search(nodo.getRight(), valor);
    }

    public void inOrden() {
        printInOrden(raiz, "");
    }

    private void printInOrden(Nodo nodo, String n) {
        if (nodo != null) {
            if (nodo.getLeft() != null) printInOrden(nodo.getLeft(), n + "  ");
            System.out.println(n + nodo.getValue());
            if (nodo.getRight() != null) printInOrden(nodo.getRight(), n + "  ");
        }
    }

    public void preOrden() {
        printPreOrden(raiz, "");
    }

    private void printPreOrden(Nodo nodo, String n) {
        if (nodo != null) {
            System.out.println(n + nodo.getValue());
            if (nodo.getLeft() != null) printPreOrden(nodo.getLeft(), n + "  ");
            if (nodo.getRight() != null) printPreOrden(nodo.getRight(), n + "  ");
        }
    }

    public void postOrden() {
        printPostOrden(raiz, "");
    }

    private void printPostOrden(Nodo nodo, String n) {
        if (nodo != null) {
            if (nodo.getLeft() != null) printPreOrden(nodo.getLeft(), n + "  ");
            if (nodo.getRight() != null) printPostOrden(nodo.getRight(), n + "  ");
            System.out.println(n + nodo.getValue());
        }
    }

    public boolean isEmpty() {
        return raiz == null;
    }
}