package main.java.com.aprendizaje.estructurasDeDatos.arboles;

public class ArbolRecursivo {
    public ArbolRecursivo left, right, padre;
    public int raiz;
    public int longitud = 0;

    public void add(int dato) {
        altInsert(dato, null);
    }

    private void altInsert(int dato, ArbolRecursivo padre) {
        if (isEmpty()) {
            this.raiz = dato;
            this.padre = padre;
            return;
        }

        int comparacion = Integer.compare(dato, raiz);

        if (comparacion < 0) {
            if (left == null) left = new ArbolRecursivo();
            left.altInsert(dato, this);
        } else if (comparacion > 0) {
            if (right == null) right = new ArbolRecursivo();
            right.altInsert(dato, this);
        } else {
            throw new RuntimeException("Elemento duplicado");
        }
    }

    public ArbolRecursivo minimo() {
        return left != null && !left.isEmpty() ? left.minimo() : this;
    }

    private void deleteID(int id) {
        if (left != null && right != null) {
            /**
             * Eliminar con dos hijos
             * Buscar el mínimo del subárbol derecho
             * o el máximo del subárbol izquierdo
             */
            ArbolRecursivo minimo = right.minimo();
            this.raiz = minimo.raiz;
            right.delete(minimo.raiz);
        } else if (left != null || right != null) {
            // Eliminar con un hijo. Para encontrar el hijo defina el árbol vacío
            ArbolRecursivo sustituto = left != null ? left : right;
            this.raiz = sustituto.raiz;
            this.left = sustituto.left;
            this.right = sustituto.right;
        } else {
            if (padre != null) {
                if (this == padre.left) padre.left = null;
                if (this == padre.right) padre.right = null;
                padre = null;
            }
            raiz = 0;
        }
    }

    public void delete(int id) {
        if (!isEmpty()) {
            if (id == raiz) {
                deleteID(id);
            } else if (left != null && id < raiz) {
                left.delete(id);
            } else if (right != null && id > raiz) {
                right.delete(id);
            }
        }
    }

    public boolean isPresent(int dato) {
        if (isEmpty()) return false;
        if (dato == raiz) return true;

        if (dato < raiz && left != null) {
            return left.isPresent(dato);
        }

        if (dato > raiz && right != null) {
            return right.isPresent(dato);
        }

        return false;
    }

    public int obtener(int dato) {
        if (isEmpty()) {
            return 0;
        }

        if (dato == raiz) {
            return raiz;
        } else if (dato < raiz && left != null) {
            return left.obtener(dato);
        } else if (right != null) {
            return right.obtener(dato);
        }

        return 0;
    }

    public void preOrden() {
        printPreOrden("");
    }

    public void inOrden() {
        printInOrden("");
    }

    public void postOrden() {
        printPostOrden("");
    }

    private void printPreOrden(String n) {
        if (!isEmpty()) {
            System.out.println(n + raiz);
            if (left != null) left.printPreOrden("   " + n);
            if (right != null) right.printPreOrden("   " + n);
        }
    }

    private void printInOrden(String n) {
        if (!isEmpty()) {
            if (left != null) left.printInOrden("   " + n);
            System.out.println(n + raiz);
            if (right != null) right.printInOrden("   " + n);
        }
    }

    private void printPostOrden(String n) {
        if (!isEmpty()) {
            if (left != null) left.printPostOrden("   " + n);
            if (right != null) right.printPostOrden("   " + n);
            System.out.println(n + raiz);
        }
    }

    public boolean isEmpty() {
        return raiz == 0;
    }
}