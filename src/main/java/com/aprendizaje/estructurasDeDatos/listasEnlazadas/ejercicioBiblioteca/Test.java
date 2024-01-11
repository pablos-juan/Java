package main.java.com.aprendizaje.estructurasDeDatos.listasEnlazadas.ejercicioBiblioteca;

public class Test {
    public static void main(String[] args) {
        Biblioteca miBiblioteca = new Biblioteca();

        miBiblioteca.add(new Libro("El capital", "Karl Marx", 1));
        miBiblioteca.add(new Libro("El resplandor", "Stephen King", 2));
        miBiblioteca.addAfter(new Libro("La biblia", "Dios", 3), 4);
        miBiblioteca.addEnd(new Libro("Memorias de una gallina", "Concha Lopez", 4));
        miBiblioteca.add(new Libro("El alquimista", "Pablo Coelho", 5));
        
        System.out.println("\nLIBROS EN LA BIBLIOTECA: " + miBiblioteca.length());
        miBiblioteca.printList();
        separador();

        Libro miLibro = miBiblioteca.getLibro(3);
        System.out.println("LIBRO EN LA POSICIÓN 3: " + miLibro);
        separador();

        System.out.println("ELIMINAR EL PRIMER LIBRO:");
        miBiblioteca.delete();
        separador();

        System.out.println("ELIMINAR EL ÚLTIMO LIBRO:");
        miBiblioteca.deleteEnd();
        separador();

        System.out.println("ELIMINAR LIBRO EN LA POSICIÓN 2:");
        miBiblioteca.deleteIn(2);

        miBiblioteca.printList();
        separador();

        System.out.println("OBTENER LIBRO CON ISBN:");
        Libro mm = miBiblioteca.getWithIsbn(3);
        System.out.println(mm);
    }

    public static void separador() {
        System.out.println(
            "----------------------------------------------------"
        );
    }
}
