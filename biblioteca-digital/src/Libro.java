package src;

import java.util.Objects;


public class Libro {
    private String titulo;
    private String autor;
    
  

   
    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Libro libro = (Libro) obj;
        return Objects.equals(titulo, libro.titulo) &&
               Objects.equals(autor, libro.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, autor);
    }

   
    @Override
    public String toString() {
        return "Libro{titulo='" + titulo + "', autor='" + autor + "'}";
    }
}