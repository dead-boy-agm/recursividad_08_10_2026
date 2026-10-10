package src; 
	

public class Main {

 
   public static void main(String[] args) {
        
        Catalogo<Libro> libros = new CatalogoArreglo<>(3);
        libros.agregar(new Libro("Don Quijote", "Cervantes"));
        libros.agregar(new Libro("Dune", "Herbert"));
        libros.agregar(new Libro("Rayuela", "Cortázar"));
 
        System.out.println("Posición de Dune: " + libros.buscar(new Libro("Dune", "Herbert")));
        System.out.println("Posición de libro inexistente: " + libros.buscar(new Libro("X", "Y")));
 
        libros.eliminar(0);
        System.out.println("\nLibros tras eliminar el primero (" + libros.tamanio() + "):");
        for (int i = 0; i < libros.tamanio(); i++) {
            System.out.println("  " + i + ": " + libros.obtener(i));
        }
 
        // Catálogo de Strings
        Catalogo<String> textos = new CatalogoArreglo<>(3);
        textos.agregar("A");
        textos.agregar("B");
        textos.agregar("C");
        System.out.println("\nbuscar(\"C\") = " + textos.buscar("C"));
        System.out.println("buscar(\"Z\") = " + textos.buscar("Z"));
 
        // Manejo de errores
        try {
            textos.agregar("D");
        } catch (IllegalStateException e) {
            System.out.println("Error esperado: " + e.getMessage());
        }
        try {
            textos.obtener(10);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error esperado: " + e.getMessage());
        }
 
        textos.eliminar(0);
        System.out.println("\nEstado final de textos (" + textos.tamanio() + "): "
                + textos.obtener(0) + ", " + textos.obtener(1));
    }
}