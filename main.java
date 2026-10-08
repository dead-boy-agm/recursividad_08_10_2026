package src;

    public static void main(String[] args) {
        // Catalogo de libros
        Catalogo<Libro> libros = new CatalogoArreglo<>(3);
        libros.agregar(new Libro("Don Quijote", "Cervantes"));
        libros.agregar(new Libro("Dune", "Herbert"));
        libros.agregar(new Libro("Rayuela", "Cortazar"));

        System.out.println("Tamanio inicial: " + libros.tamanio());
        System.out.println("Posicion de Dune: " + libros.buscar(new Libro("Dune", "Herbert")));
        System.out.println("Posicion de libro inexistente: "
            + libros.buscar(new Libro("Dune", "Otro")));

        System.out.println("Eliminado: " + libros.eliminar(0));
        System.out.println("Estado final de libros:");
        for (int i = 0; i < libros.tamanio(); i++) {
            System.out.println("  [" + i + "] " + libros.obtener(i));
        }

        Catalogo<String> textos = new CatalogoArreglo<>(3);
        textos.agregar("A");
        textos.agregar("B");
        textos.agregar("C");
        System.out.println("buscar(\"C\"): " + textos.buscar("C"));
        System.out.println("buscar(\"Z\"): " + textos.buscar("Z"));
        textos.eliminar(0);
        System.out.println("obtener(0) tras eliminar(0): " + textos.obtener(0));

        try {
            textos.obtener(10);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error esperado: " + e.getMessage());
        }
        try {
            textos.agregar("D");
            textos.agregar("E");
        } catch (IllegalStateException e) {
            System.out.println("Error esperado: " + e.getMessage());
        }
    }
}
